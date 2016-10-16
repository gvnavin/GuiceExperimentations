package com.guice.example.helpers.module;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import com.guice.example.helpers.log.NoSqlDatabaseTransactionLog;

/**
 * Created by gnavin on 6/1/16.
 */
public class NoSqlDatabaseTransactionLogProvider implements Provider<NoSqlDatabaseTransactionLog> {
    private String jdbcUrl;
    private int threadPoolSize;

    @Inject
    public NoSqlDatabaseTransactionLogProvider(@Named("Server.URL") final String jdbcUrl,
                                               @Named("threadpool.size") final int threadPoolSize) {
        this.jdbcUrl = jdbcUrl;
        this.threadPoolSize = threadPoolSize;
    }

    public NoSqlDatabaseTransactionLog get() {
        /**
         * if object creation can cause exception, then refer below link
         * https://github.com/google/guice/wiki/ProvidesMethods#throwing-exceptions
         */
        NoSqlDatabaseTransactionLog transactionLog = new NoSqlDatabaseTransactionLog();
        transactionLog.setJdbcUrl(jdbcUrl);
        transactionLog.setThreadPoolSize(threadPoolSize);
        return transactionLog;
    }
}
