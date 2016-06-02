package com.guice.example.cardprocessor;

import com.guice.example.misc.ChargeResult;
import com.guice.example.card.CreditCard;

/**
 * Created by gnavin on 5/31/16.
 */
public class PayPalCreditCardProcessor implements CreditCardProcessor {
    public ChargeResult charge(final CreditCard creditCard, final int amount) {
        System.out.println("PayPalCreditCardProcessor.charge");
        return new ChargeResult();
    }
}
