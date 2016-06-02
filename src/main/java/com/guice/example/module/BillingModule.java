package com.guice.example.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.guice.example.bindingannotation.PayPal;
import com.guice.example.cardprocessor.CheckoutCreditCardProcessor;
import com.guice.example.cardprocessor.CreditCardProcessor;
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

        /**
         * This tells Guice that whenever it sees a dependency on a ITransactionLog,
         * it should satisfy the dependency using a DatabaseTransactionLog.
         */
        bind(ITransactionLog.class).to(DatabaseTransactionLog.class);

        /**
         * https://github.com/google/guice/wiki/LinkedBindings
         * You can even link the concrete DatabaseTransactionLog class to a subclass:
         *
         * Linked bindings can also be chained:
         * ITransactionLog --> DatabaseTransactionLog --> MySqlDatabaseTransactionLog
         */
        bind(DatabaseTransactionLog.class).to(MySqlDatabaseTransactionLog.class);

        /**
         * Similarly, this binding tells Guice that when CreditCardProcessor is used in
         * a dependency, that should be satisfied with a PayPalCreditCardProcessor.
         */
        bind(CreditCardProcessor.class).to(PayPalCreditCardProcessor.class);

        //bind(IBillingService.class).to(RealBillingService.class);
        //bind(IBillingService.class).to(AnnotatedBillingService.class);
        bind(IBillingService.class).to(NamedBillingService.class);

        bind(CreditCardProcessor.class).annotatedWith(PayPal.class).to(PayPalCreditCardProcessor.class);

        bind(CreditCardProcessor.class).annotatedWith(Names.named("Checkout")).to(CheckoutCreditCardProcessor.class);
    }
}

