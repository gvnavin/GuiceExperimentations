package com.guice.example.helpers.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.guice.example.bind_with_annotation.PayPal;
import com.guice.example.bind_with_annotation.SqlDatabaseTransactionLog;
import com.guice.example.helpers.cardprocessor.CheckoutCreditCardProcessor;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.cardprocessor.PayPalCreditCardProcessor;
import com.guice.example.helpers.factorymodulebuilder.Payment;
import com.guice.example.helpers.factorymodulebuilder.PaymentFactory;
import com.guice.example.helpers.factorymodulebuilder.RealPayment;
import com.guice.example.helpers.log.DatabaseTransactionLog;
import com.guice.example.helpers.log.ITransactionLog;
import com.guice.example.helpers.log.MySqlDatabaseTransactionLog;
import com.guice.example.helpers.log.NoSqlDatabaseTransactionLog;
import com.guice.example.helpers.service.IBillingService;
import com.guice.example.helpers.service.RealBillingService;

/**
 * Created by gnavin on 5/31/16.
 */
public class GuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bindInterfaceWithImpl();
        chainBinding();
        bindWithAnnotation();
        
        bindProvider();
        bindFactoryModule();
    }

    private void bindInterfaceWithImpl() {
        /**
         * Similarly, this binding tells Guice that when ICreditCardProcessor is used in
         * a dependency, that should be satisfied with a PayPalCreditCardProcessor.
         */
        bind(ICreditCardProcessor.class).to(PayPalCreditCardProcessor.class);
        bind(IBillingService.class).to(RealBillingService.class);
        //bind(IBillingService.class).to(AnnotatedBillingService.class);
        //bind(IBillingService.class).to(NamedBillingService.class);

    }

    private void chainBinding() {
        /**
         * https://github.com/google/guice/wiki/LinkedBindings
         * You can even link the concrete DatabaseTransactionLog class to a subclass:
         *
         * Linked bindings can also be chained:
         * ITransactionLog --> DatabaseTransactionLog --> MySqlDatabaseTransactionLog
         */
        bind(ITransactionLog.class).to(DatabaseTransactionLog.class);
        bind(DatabaseTransactionLog.class).to(MySqlDatabaseTransactionLog.class);
    }

    private void bindWithAnnotation() {
        /**
         * Avoid named annotation, prefer annotation class
         * http://javanuggets.blogspot.com/2012/04/named-annotations-are-evil.html
         **/
        bind(ICreditCardProcessor.class).annotatedWith(PayPal.class).to(PayPalCreditCardProcessor.class);
        bind(ICreditCardProcessor.class).annotatedWith(Names.named("Checkout")).to(CheckoutCreditCardProcessor.class);
    }

    private void bindProvider() {
        bind(NoSqlDatabaseTransactionLog.class).toProvider(NoSqlDatabaseTransactionLogProvider.class);
    }
    
    /**
     * creates factory implementation
     */
    private void bindFactoryModule() {
        install(new FactoryModuleBuilder()
                .implement(Payment.class, RealPayment.class)
                .build(PaymentFactory.class));
    }
    /**
     * simple provides method
     * When you need code to create an object, use an @Provides method.
     * @return
     */
    @Provides
    MySqlDatabaseTransactionLog provideTransactionLog() {
        /**
         * if object creation can cause exception, then refer below link
         * https://github.com/google/guice/wiki/ProvidesMethods#throwing-exceptions
         */
        MySqlDatabaseTransactionLog transactionLog = new MySqlDatabaseTransactionLog();
        transactionLog.setJdbcUrl("jdbc:mysql://localhost/test");
        transactionLog.setThreadPoolSize(30);
        return transactionLog;
    }

    /**
     * provides method with annotation "@SqlDatabaseTransactionLog"
     * injected method parameters using named annotations
     * @param jdbcUrl
     * @param threadPoolSize
     * @return
     */
    @Provides
    @SqlDatabaseTransactionLog
    MySqlDatabaseTransactionLog provideNamedTransactionLog(@Named("JDBC.Server.URL") final String jdbcUrl,
                                                           @Named("threadpool.size") final int threadPoolSize) {
        /**
         * if object creation can cause exception, then refer below link
         * https://github.com/google/guice/wiki/ProvidesMethods#throwing-exceptions
         */
        MySqlDatabaseTransactionLog transactionLog = new MySqlDatabaseTransactionLog();
        transactionLog.setJdbcUrl(jdbcUrl);
        transactionLog.setThreadPoolSize(threadPoolSize);
        return transactionLog;
    }
}

