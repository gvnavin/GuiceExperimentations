package com.guice.example.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.guice.example.bindingannotation.PayPal;
import com.guice.example.cardprocessor.CheckoutCreditCardProcessor;
import com.guice.example.cardprocessor.ICreditCardProcessor;
import com.guice.example.cardprocessor.PayPalCreditCardProcessor;
import com.guice.example.log.DatabaseTransactionLog;
import com.guice.example.log.ITransactionLog;
import com.guice.example.log.MySqlDatabaseTransactionLog;
import com.guice.example.service.IBillingService;
import com.guice.example.service.NamedBillingService;

/**
 * Created by gnavin on 5/31/16.
 */
public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {

        bindInterfaceWithImpl();
        chainBinding();
        bindWithAnnotation();
        bindInstance();

    }

    private void bindInterfaceWithImpl() {
        /**
         * Similarly, this binding tells Guice that when ICreditCardProcessor is used in
         * a dependency, that should be satisfied with a PayPalCreditCardProcessor.
         */
        bind(ICreditCardProcessor.class).to(PayPalCreditCardProcessor.class);

        //bind(IBillingService.class).to(RealBillingService.class);
        //bind(IBillingService.class).to(AnnotatedBillingService.class);
        bind(IBillingService.class).to(NamedBillingService.class);

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

        bind(ICreditCardProcessor.class).annotatedWith(PayPal.class).to(PayPalCreditCardProcessor.class);

        bind(ICreditCardProcessor.class).annotatedWith(Names.named("Checkout")).to(CheckoutCreditCardProcessor.class);
    }

    private void bindInstance() {
        bind(String.class)
                .annotatedWith(Names.named("JDBC.URL"))
                .toInstance("jdbc:mysql://localhost/pizza");
        bind(Integer.class)
                .annotatedWith(Names.named("login.timeout.seconds"))
                .toInstance(10);
    }
}

