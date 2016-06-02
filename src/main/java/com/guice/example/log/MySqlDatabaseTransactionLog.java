package com.guice.example.log;

import com.guice.example.misc.ChargeResult;

/**
 * Created by gnavin on 6/1/16.
 */
public class MySqlDatabaseTransactionLog extends DatabaseTransactionLog {
    public void logChargeResult(final ChargeResult result) {
        System.out.println("MySqlDatabaseTransactionLog.logChargeResult");
    }

    public void logConnectException(final Exception e) {
        System.out.println("MySqlDatabaseTransactionLog.logConnectException");
    }

    protected void printClassName() {
        System.out.println("MySqlDatabaseTransactionLog.print this : " + this);
    }
}
