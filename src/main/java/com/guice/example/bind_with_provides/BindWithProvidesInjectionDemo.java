package com.guice.example.bind_with_provides;

import com.google.inject.Inject;
import com.guice.example.bind_with_annotation.SqlDatabaseTransactionLog;
import com.guice.example.helpers.log.MySqlDatabaseTransactionLog;

/**
 * Created by gnavin on 6/1/16.
 */
public class BindWithProvidesInjectionDemo {
    
    private final MySqlDatabaseTransactionLog transactionLog;
    
    private final MySqlDatabaseTransactionLog namedTransactionLog;
    
    @Inject
    public BindWithProvidesInjectionDemo(
        final MySqlDatabaseTransactionLog transactionLog,
        @SqlDatabaseTransactionLog final MySqlDatabaseTransactionLog namedTransactionLog) {
        
        this.transactionLog = transactionLog;
        this.namedTransactionLog = namedTransactionLog;
    }
    
    public void print() {
        System.out.println("BindWithProvidesInjectionDemo.print");

        System.out.println("transactionLog = " + transactionLog);
        transactionLog.print();
        System.out.println();
    
        System.out.println("------------------------------------------------------------------------");
        
        System.out.println("namedTransactionLog = " + namedTransactionLog);
        namedTransactionLog.print();
        System.out.println();
        
    }

}
