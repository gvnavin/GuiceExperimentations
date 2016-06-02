package com.guice.example.cardprocessor;

import com.guice.example.card.CreditCard;
import com.guice.example.misc.ChargeResult;

/**
 * Created by gnavin on 6/1/16.
 */
public class CheckoutCreditCardProcessor implements ICreditCardProcessor {
    public ChargeResult charge(final CreditCard creditCard, final int amount) {
        System.out.println("CheckoutCreditCardProcessor.charge");
        return new ChargeResult();
    }
}
