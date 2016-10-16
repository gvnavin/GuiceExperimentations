package com.guice.example.helpers.misc;

/**
 * Created by gnavin on 5/31/16.
 */
public class PizzaOrder {
    private int amount;

    public PizzaOrder(final int i) {
        amount = i;
    }

    public int getAmount() {
        return amount;
    }
}
