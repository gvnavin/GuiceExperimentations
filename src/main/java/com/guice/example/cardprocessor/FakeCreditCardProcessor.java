package com.guice.example.cardprocessor;

import com.guice.example.misc.ChargeResult;
import com.guice.example.card.CreditCard;

/**
 * Created by gnavin on 5/31/16.
 */
public class FakeCreditCardProcessor implements CreditCardProcessor {
    private CreditCard cardOfOnlyCharge;
    private int amountOfOnlyCharge;

    public ChargeResult charge(final CreditCard creditCard, final int amount) {
        return new ChargeResult();
    }

    public CreditCard getCardOfOnlyCharge() {
        return cardOfOnlyCharge;
    }

    public int getAmountOfOnlyCharge() {
        return amountOfOnlyCharge;
    }
}
