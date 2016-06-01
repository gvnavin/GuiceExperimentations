package com.guice.example.log;

import com.guice.example.misc.ChargeResult;

/**
 * Created by gnavin on 5/31/16.
 */
public class DatabaseTransactionLog implements ITransactionLog {
    public void logChargeResult(final ChargeResult result) {
        System.out.println("DatabaseTransactionLog.logChargeResult");
    }

    public void logConnectException(final Exception e) {
        System.out.println("DatabaseTransactionLog.logConnectException");
    }
}
