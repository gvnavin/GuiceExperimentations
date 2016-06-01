package com.guice.example.log;

import com.guice.example.misc.ChargeResult;

/**
 * Created by gnavin on 5/31/16.
 */
public class InMemoryTransactionLog implements ITransactionLog {
    public void logChargeResult(final ChargeResult result) {
        System.out.println("InMemoryTransactionLog.logChargeResult");
    }

    public void logConnectException(final Exception e) {
        System.out.println("InMemoryTransactionLog.logConnectException");
    }

    public boolean wasSuccessLogged() {
        System.out.println("InMemoryTransactionLog.wasSuccessLogged");
        return true;
    }
}
