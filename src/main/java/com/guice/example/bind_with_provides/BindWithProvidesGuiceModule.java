package com.guice.example.bind_with_provides;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.guice.example.bind_with_annotation.SqlDatabaseTransactionLog;
import com.guice.example.helpers.log.MySqlDatabaseTransactionLog;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindWithProvidesGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bindInstance();
    }
    
    private void bindInstance() {
        bind(String.class).annotatedWith(Names.named("JDBC.Server.URL")).toInstance("jdbc:mysql://localhost/test");
        bind(Integer.class).annotatedWith(Names.named("threadpool.size")).toInstance(10);
    }
    
    /**
     * simple provides method
     * When you need code to create an object, use an @Provides method.
     *
     * @return
     */
    @Provides
    MySqlDatabaseTransactionLog provideTransactionLog() {
        /**
         * if object creation can cause exception, then refer below link
         * https://github.com/google/guice/wiki/ProvidesMethods#throwing-exceptions
         */
        MySqlDatabaseTransactionLog transactionLog = new MySqlDatabaseTransactionLog();
        return transactionLog;
    }
    
    /**
     * provides method with annotation "@SqlDatabaseTransactionLog"
     * injected method parameters using named annotations
     *
     * @param jdbcUrl
     * @param threadPoolSize
     * @return
     */
    @Provides
    @SqlDatabaseTransactionLog
    MySqlDatabaseTransactionLog provideNamedTransactionLog(
        @Named("JDBC.Server.URL") final String jdbcUrl,
        @Named("threadpool.size") final int threadPoolSize) {
        /**
         * if object creation can cause exception, then refer below link
         * https://github.com/google/guice/wiki/ProvidesMethods#throwing-exceptions
         */
        MySqlDatabaseTransactionLog transactionLog = new MySqlDatabaseTransactionLog();
        transactionLog.setJdbcUrl(jdbcUrl);
        transactionLog.setThreadPoolSize(threadPoolSize);
        return transactionLog;
    }
}

