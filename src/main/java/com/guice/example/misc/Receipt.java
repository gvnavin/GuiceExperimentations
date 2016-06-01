package com.guice.example.misc;

/**
 * Created by gnavin on 5/31/16.
 */
public class Receipt {
    private int amountOfCharge;

    public static Receipt forSuccessfulCharge(final Object amount) {
        return new Receipt();
    }

    public static Receipt forDeclinedCharge(final Object declineMessage) {
        return new Receipt();
    }

    public static Receipt forSystemFailure(final String message) {
        return new Receipt();
    }

    public boolean hasSuccessfulCharge() {
        return true;
    }

    public int getAmountOfCharge() {
        return amountOfCharge;
    }
}
