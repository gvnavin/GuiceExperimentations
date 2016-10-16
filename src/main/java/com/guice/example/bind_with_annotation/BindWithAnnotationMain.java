package com.guice.example.bind_with_annotation;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.guice.example.bind_with_instance.BindWithInstanceDemo;
import com.guice.example.helpers.cardprocessor.CheckoutCreditCardProcessor;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.log.ITransactionLog;
import com.guice.example.helpers.log.MySqlDatabaseTransactionLog;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindWithAnnotationMain {
    public static void main(String[] args) {
        
        /**
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        final Injector injector = Guice.createInjector(new BindWithAnnotationGuiceModule());
        
        /**
         * Now that we've got the injector, we can build objects.
         */
        final BindWithAnnotationInjectionDemo bindWithAnnotationInjectionDemo = injector
            .getInstance(BindWithAnnotationInjectionDemo.class);
        bindWithAnnotationInjectionDemo.print();
    
        System.out.println("------------------------------------------------------------------------");
        
        final ICreditCardProcessor creditCardProcessorAnnotation = injector
            .getInstance(Key.get(ICreditCardProcessor.class, PayPal.class));
        System.out.println("creditCardProcessor = " + creditCardProcessorAnnotation);
        System.out.println("creditCardProcessorAnnotation.charge(null, 100) = " + creditCardProcessorAnnotation.charge(null, 100));
    
        System.out.println("------------------------------------------------------------------------");
        
        final ICreditCardProcessor creditCardProcessorNamed = injector
            .getInstance(Key.get(ICreditCardProcessor.class, Names.named("Checkout")));
        System.out.println("creditCardProcessorNamed = " + creditCardProcessorNamed);
        System.out.println("creditCardProcessorNamed.charge(null, 100) = " + creditCardProcessorNamed.charge(null, 100));
    
        System.out.println("------------------------------------------------------------------------");
    
        final ITransactionLog transactionLog = injector
            .getInstance(Key.get(ITransactionLog.class, SqlDatabaseTransactionLog.class));
    
        System.out.println("transactionLog = " + transactionLog);
        System.out.println("transactionLog.print()");
        transactionLog.print();
    
    }
    
}
