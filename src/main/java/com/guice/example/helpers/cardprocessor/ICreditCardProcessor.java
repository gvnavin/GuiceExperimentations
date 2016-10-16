package com.guice.example.helpers.cardprocessor;

import com.guice.example.helpers.misc.ChargeResult;
import com.guice.example.helpers.card.CreditCard;

/**
 * Created by gnavin on 5/31/16.
 */
public interface ICreditCardProcessor {
    ChargeResult charge(CreditCard creditCard, int amount);
}
