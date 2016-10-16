package com.guice.example.helpers.log;

import com.guice.example.helpers.misc.ChargeResult;

/**
 * Created by gnavin on 6/1/16.
 */
public class NoSqlDatabaseTransactionLog extends DatabaseTransactionLog {
    private String serverUrl;
    private int threadPoolSize;

    public void logChargeResult(final ChargeResult result) {
        System.out.println("NoSqlDatabaseTransactionLog.logChargeResult");
    }

    public void logConnectException(final Exception e) {
        System.out.println("NoSqlDatabaseTransactionLog.logConnectException");
    }

    protected void printClassName() {
        System.out.println("NoSqlDatabaseTransactionLog.print this : " + this);
    }
}
