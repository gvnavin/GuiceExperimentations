package com.guice.example.bind_with_annotation;

import com.google.inject.Inject;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.log.ITransactionLog;
import com.guice.example.helpers.log.MySqlDatabaseTransactionLog;

/**
 * Created by gnavin on 6/1/16.
 */
public class BindWithAnnotationInjectionDemo {
    
    private final ICreditCardProcessor processor;
    
    private final ITransactionLog transactionLog;
    
    @Inject
    public BindWithAnnotationInjectionDemo(
        @PayPal final ICreditCardProcessor processor,
        @SqlDatabaseTransactionLog final ITransactionLog transactionLog) {
        
        this.processor = processor;
        this.transactionLog = transactionLog;
    }
    
    public void print() {
        System.out.println("BindWithAnnotationInjectionDemo.print");
        
        System.out.println();
        
        System.out.println("processor = " + processor);
        System.out.println("processor.charge(null, 10) = " + processor.charge(null, 10));
        
        System.out.println();
        System.out.println("------------------------------------------------------------------------");
        
        System.out.println("transactionLog = " + transactionLog);
        transactionLog.print();
        System.out.println();
        
    }
    
}
