package com.guice.example.cardprocessor;

import com.guice.example.misc.ChargeResult;
import com.guice.example.card.CreditCard;

/**
 * Created by gnavin on 5/31/16.
 */
public interface CreditCardProcessor {
    public ChargeResult charge(CreditCard creditCard, int amount);
}
