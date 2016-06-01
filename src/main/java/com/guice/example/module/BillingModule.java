package com.guice.example.module;

import com.google.inject.AbstractModule;
import com.guice.example.service.BillingService;
import com.guice.example.cardprocessor.CreditCardProcessor;
import com.guice.example.cardprocessor.PaypalCreditCardProcessor;
import com.guice.example.log.DatabaseTransactionLog;
import com.guice.example.log.TransactionLog;
import com.guice.example.service.RealBillingService;

/**
 * Created by gnavin on 5/31/16.
 */
public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {

        /**
         * This tells Guice that whenever it sees a dependency on a TransactionLog,
         * it should satisfy the dependency using a DatabaseTransactionLog.
         */
        bind(TransactionLog.class).to(DatabaseTransactionLog.class);

        /**
         * Similarly, this binding tells Guice that when CreditCardProcessor is used in
         * a dependency, that should be satisfied with a PaypalCreditCardProcessor.
         */
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);

        bind(BillingService.class).to(RealBillingService.class);
    }
}

