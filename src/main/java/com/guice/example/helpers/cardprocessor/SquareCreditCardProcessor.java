package com.guice.example.helpers.cardprocessor;

import com.guice.example.helpers.misc.ChargeResult;
import com.guice.example.helpers.card.CreditCard;

/**
 * Created by gnavin on 5/31/16.
 */
public class SquareCreditCardProcessor implements ICreditCardProcessor {
    public ChargeResult charge(final CreditCard creditCard, final int amount) {
        System.out.println("SquareCreditCardProcessor.charge this : " + this);
        return new ChargeResult();
    }
}
