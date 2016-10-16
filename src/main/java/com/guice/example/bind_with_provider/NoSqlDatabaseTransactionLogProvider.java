package com.guice.example.bind_with_provider;

import com.google.inject.Provider;
import com.guice.example.helpers.log.NoSqlDatabaseTransactionLog;

/**
 * Created by gnavin on 6/1/16.
 */

//lazy value provision, create many new objects
public class NoSqlDatabaseTransactionLogProvider implements Provider<NoSqlDatabaseTransactionLog> {

    public NoSqlDatabaseTransactionLog get() {
        /**
         * if object creation can cause exception, then refer below link
         * https://github.com/google/guice/wiki/ProvidesMethods#throwing-exceptions
         */
        NoSqlDatabaseTransactionLog transactionLog = new NoSqlDatabaseTransactionLog();
        transactionLog.setJdbcUrl("jdbc:mysql://localhost/test");
        transactionLog.setThreadPoolSize(10);
        return transactionLog;
    }
}
