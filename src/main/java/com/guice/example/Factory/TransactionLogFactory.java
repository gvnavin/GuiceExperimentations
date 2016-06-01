package com.guice.example.Factory;

import com.guice.example.log.ITransactionLog;

/**
 * Created by gnavin on 5/31/16.
 */
public class TransactionLogFactory {
    private static ITransactionLog instance;

    public static void setInstance(final ITransactionLog instance) {
        TransactionLogFactory.instance = instance;
    }

    public static ITransactionLog getInstance() {
        return instance;
    }
}
