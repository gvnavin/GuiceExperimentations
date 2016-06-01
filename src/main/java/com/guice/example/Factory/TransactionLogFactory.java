package com.guice.example.Factory;

import com.guice.example.log.InMemoryTransactionLog;
import com.guice.example.log.TransactionLog;

/**
 * Created by gnavin on 5/31/16.
 */
public class TransactionLogFactory {
    private static TransactionLog instance;

    public static void setInstance(final TransactionLog instance) {
        TransactionLogFactory.instance = instance;
    }

    public static TransactionLog getInstance() {
        return instance;
    }
}
