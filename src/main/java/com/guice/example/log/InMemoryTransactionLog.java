package com.guice.example.log;

import com.guice.example.misc.ChargeResult;

/**
 * Created by gnavin on 5/31/16.
 */
public class InMemoryTransactionLog implements TransactionLog {
    public void logChargeResult(final ChargeResult result) {

    }

    public void logConnectException(final Exception e) {

    }

    public boolean wasSuccessLogged() {
        return true;
    }
}
