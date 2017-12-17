package com.guice.example.bind_with_provider;

import com.google.inject.Inject;
import com.guice.example.helpers.log.NoSqlDatabaseTransactionLog;
import lombok.RequiredArgsConstructor;

/**
 * Created by gnavin on 6/1/16.
 */
@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class BindWithProviderInjectionDemo {

    private final NoSqlDatabaseTransactionLog noSqlDatabaseTransactionLog;

    public void print() {
        System.out.println("BindWithProviderInjectionDemo.print");

        System.out.println("noSqlDatabaseTransactionLog = " + noSqlDatabaseTransactionLog);
        noSqlDatabaseTransactionLog.print();
        System.out.println();
    }

}
