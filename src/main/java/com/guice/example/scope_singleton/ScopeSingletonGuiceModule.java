package com.guice.example.scope_singleton;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.guice.example.bind_with_annotation.PayPal;
import com.guice.example.bind_with_annotation.SqlDatabaseTransactionLog;
import com.guice.example.helpers.cardprocessor.CheckoutCreditCardProcessor;
import com.guice.example.helpers.cardprocessor.FakeCreditCardProcessor;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.cardprocessor.PayPalCreditCardProcessor;
import com.guice.example.helpers.cardprocessor.SquareCreditCardProcessor;
import com.guice.example.helpers.log.DatabaseTransactionLog;
import com.guice.example.helpers.log.MySqlDatabaseTransactionLog;
import com.guice.example.helpers.singleton_helper.DatabaseTransactionLogProvider;

/**
 * Created by gnavin on 5/31/16.
 */
//https://github.com/google/guice/wiki/Scopes
public class ScopeSingletonGuiceModule extends AbstractModule {
    
    @Override
    protected void configure() {
    
        //make a class singleton
        bind(SquareCreditCardProcessor.class).in(Singleton.class);
        
        //bind a implementation to interface with singletion object
        bind(ICreditCardProcessor.class).to(FakeCreditCardProcessor.class).asEagerSingleton();
        bind(ICreditCardProcessor.class).annotatedWith(PayPal.class).to(PayPalCreditCardProcessor.class).in(Scopes.SINGLETON);
        bind(ICreditCardProcessor.class).annotatedWith(Names.named("Checkout")).to(CheckoutCreditCardProcessor.class).in(Singleton.class);
        bind(DatabaseTransactionLog.class).toProvider(DatabaseTransactionLogProvider.class).in(Singleton.class);
        
    }

    /**
     * simple provides method
     * When you need code to create an object, use an @Provides method.
     * @return
     */
    @Provides
    @Singleton
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
     * @return
     */
    @Provides
    @Singleton
    @SqlDatabaseTransactionLog
    MySqlDatabaseTransactionLog provideNamedTransactionLog() {
        /**
         * if object creation can cause exception, then refer below link
         * https://github.com/google/guice/wiki/ProvidesMethods#throwing-exceptions
         */
        MySqlDatabaseTransactionLog transactionLog = new MySqlDatabaseTransactionLog();
        transactionLog.setJdbcUrl("jdbc:mysql://localhost/test");
        transactionLog.setThreadPoolSize(30);
        return transactionLog;
    }
}

