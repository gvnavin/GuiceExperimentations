package com.guice.example.service;

import com.google.inject.Inject;
import com.guice.example.misc.PizzaOrder;
import com.guice.example.misc.Receipt;
import com.guice.example.card.CreditCard;
import com.guice.example.cardprocessor.ICreditCardProcessor;
import com.guice.example.log.ITransactionLog;

/**
 * Created by gnavin on 5/31/16.
 */
public class RealBillingService implements IBillingService {

    private final ICreditCardProcessor processor;
    private final ITransactionLog transactionLog;

    @Inject
    public RealBillingService(final ICreditCardProcessor processor, final ITransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        System.out.println("RealBillingService.chargeOrder");
        return charge(processor, creditCard, order, transactionLog);
    }
}
