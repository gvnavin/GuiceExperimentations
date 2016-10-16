package com.guice.example.helpers.singleton_helper;

import com.google.inject.Provider;
import com.guice.example.helpers.log.DatabaseTransactionLog;

/**
 * Created by gnavin on 6/1/16.
 */
public class DatabaseTransactionLogProvider implements Provider<DatabaseTransactionLog> {
    private String jdbcUrl;
    private int threadPoolSize;
    
    public DatabaseTransactionLog get() {
        /**
         * if object creation can cause exception, then refer below link
         * https://github.com/google/guice/wiki/ProvidesMethods#throwing-exceptions
         */
        DatabaseTransactionLog transactionLog = new DatabaseTransactionLog();
        transactionLog.setJdbcUrl(jdbcUrl);
        transactionLog.setThreadPoolSize(threadPoolSize);
        return transactionLog;
    }
}
