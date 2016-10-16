package com.guice.example.bind_with_provider;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guice.example.bind_with_instance.BindWithInstanceDemo;
import com.guice.example.helpers.log.NoSqlDatabaseTransactionLog;
import com.guice.example.helpers.service.IBillingService;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindWithProviderMain {
    public static void main(String[] args) {

        /**
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        final Injector injector = Guice.createInjector(new BindWithProviderGuiceModule());

        /**
         * Now that we've got the injector, we can build objects.
         */
        final BindWithProviderInjectionDemo bindWithProviderInjectionDemo = injector.getInstance(BindWithProviderInjectionDemo.class);
        bindWithProviderInjectionDemo.print();
    
        System.out.println("------------------------------------------------------------------------");
    
        final NoSqlDatabaseTransactionLog noSqlDatabaseTransactionLog = injector.getInstance(NoSqlDatabaseTransactionLog.class);
        System.out.println("noSqlDatabaseTransactionLog = " + noSqlDatabaseTransactionLog);
        System.out.println("noSqlDatabaseTransactionLog.print()");
        noSqlDatabaseTransactionLog.print();
    
        System.out.println("------------------------------------------------------------------------");
    }

}
