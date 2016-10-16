package com.guice.example.helpers.service;

import com.google.inject.Inject;
import com.guice.example.helpers.card.CreditCard;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.log.ITransactionLog;
import com.guice.example.helpers.misc.PizzaOrder;
import com.guice.example.helpers.misc.Receipt;

/**
 * Created by gnavin on 5/31/16.
 */
public class SampleBillingService implements IBillingService {

    private final ICreditCardProcessor processor;
    private final ITransactionLog transactionLog;
    
    @Inject
    public SampleBillingService(final ICreditCardProcessor processor) {
        this.processor = processor;
        this.transactionLog = null;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        System.out.println("SampleBillingService.chargeOrder");
        return charge(processor, creditCard, order, transactionLog);
    }
}
