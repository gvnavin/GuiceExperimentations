package com.guice.example.helpers.service;

import com.google.inject.Inject;
import com.guice.example.helpers.misc.PizzaOrder;
import com.guice.example.helpers.misc.Receipt;
import com.guice.example.helpers.card.CreditCard;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.log.ITransactionLog;
import lombok.RequiredArgsConstructor;

/**
 * Created by gnavin on 5/31/16.
 */
@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class RealBillingService implements IBillingService {

    private final ICreditCardProcessor processor;
    private final ITransactionLog transactionLog;

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        System.out.println("RealBillingService.chargeOrder");
        return charge(processor, creditCard, order, transactionLog);
    }
}
