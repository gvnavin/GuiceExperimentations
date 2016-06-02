package com.guice.example.service;

import com.google.inject.Inject;
import com.guice.example.bindingannotation.PayPal;
import com.guice.example.card.CreditCard;
import com.guice.example.cardprocessor.ICreditCardProcessor;
import com.guice.example.log.ITransactionLog;
import com.guice.example.misc.PizzaOrder;
import com.guice.example.misc.Receipt;

/**
 * Created by gnavin on 6/1/16.
 */
public class AnnotatedBillingService implements IBillingService {
    private final ICreditCardProcessor processor;
    private final ITransactionLog transactionLog;

    //annotated ICreditCardProcessor with @PayPal
    @Inject
    public AnnotatedBillingService(@PayPal final ICreditCardProcessor processor, final ITransactionLog transactionLog) {
        this.processor = processor;
        this.transactionLog = transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        System.out.println("RealBillingService.chargeOrder");
        return charge(processor, creditCard, order, transactionLog);
    }
}
