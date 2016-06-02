package com.guice.example.log;

import com.guice.example.misc.ChargeResult;

/**
 * Created by gnavin on 5/31/16.
 */
public class DatabaseTransactionLog implements ITransactionLog {
    private String jdbcUrl;
    private int threadPoolSize;

    public void logChargeResult(final ChargeResult result) {
        System.out.println("DatabaseTransactionLog.logChargeResult");
    }

    public void logConnectException(final Exception e) {
        System.out.println("DatabaseTransactionLog.logConnectException");
    }

    public void setJdbcUrl(final String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void setThreadPoolSize(final int threadPoolSize) {
        this.threadPoolSize = threadPoolSize;
    }

    @Override
    public void print() {
        printClassName();
        System.out.println("jdbcUrl = " + jdbcUrl);
        System.out.println("threadPoolSize = " + threadPoolSize);
    }

    protected void printClassName() {
        System.out.println("DatabaseTransactionLog.print this : " + this);
    }
}
