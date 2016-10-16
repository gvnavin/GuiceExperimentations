package com.guice.example.helpers.cardprocessor;

import com.guice.example.helpers.card.CreditCard;
import com.guice.example.helpers.misc.ChargeResult;

/**
 * Created by gnavin on 6/1/16.
 */
public class CheckoutCreditCardProcessor implements ICreditCardProcessor {
    public ChargeResult charge(final CreditCard creditCard, final int amount) {
        System.out.println("CheckoutCreditCardProcessor.charge  this : " + this);
        return new ChargeResult();
    }
}
