package com.guice.example.scope_singleton;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;
import com.guice.example.bind_with_annotation.PayPal;
import com.guice.example.bind_with_annotation.SqlDatabaseTransactionLog;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.cardprocessor.SquareCreditCardProcessor;
import com.guice.example.helpers.log.DatabaseTransactionLog;
import com.guice.example.helpers.log.MySqlDatabaseTransactionLog;
import com.guice.example.helpers.singleton_helper.SingletonExample;

/**
 * Created by gnavin on 5/31/16.
 */
public class ScopeSingletonMain {
    public static void main(String[] args) {

        final Injector injector = Guice.createInjector(new ScopeSingletonGuiceModule());
    
        final SquareCreditCardProcessor squareCreditCardProcessor1 = injector.getInstance(SquareCreditCardProcessor.class);
        System.out.println("squareCreditCardProcessor1 = " + squareCreditCardProcessor1);
    
        final SquareCreditCardProcessor squareCreditCardProcessor2 = injector.getInstance(SquareCreditCardProcessor.class);
        System.out.println("squareCreditCardProcessor2 = " + squareCreditCardProcessor2);
    
        System.out.println("------------------------------------------------------------------------");
        
        final ICreditCardProcessor fakeCreditCardProcessor1 = injector.getInstance(ICreditCardProcessor.class);
        System.out.println("fakeCreditCardProcessor1 = " + fakeCreditCardProcessor1);
        
        final ICreditCardProcessor fakeCreditCardProcessor2 = injector.getInstance(ICreditCardProcessor.class);
        System.out.println("fakeCreditCardProcessor2 = " + fakeCreditCardProcessor2);
    
        System.out.println("------------------------------------------------------------------------");
        
        final ICreditCardProcessor payPalCreditCardProcessor1 = injector.getInstance(Key.get(ICreditCardProcessor.class, PayPal.class));
        System.out.println("payPalCreditCardProcessor1 = " + payPalCreditCardProcessor1);
        
        final ICreditCardProcessor payPalCreditCardProcessor2 = injector.getInstance(Key.get(ICreditCardProcessor.class, PayPal.class));
        System.out.println("payPalCreditCardProcessor2 = " + payPalCreditCardProcessor2);
    
        System.out.println("------------------------------------------------------------------------");
        
        final ICreditCardProcessor checkoutCreditCardProcessor1 = injector.getInstance(Key.get(ICreditCardProcessor.class, Names.named("Checkout")));
        System.out.println("checkoutCreditCardProcessor1 = " + checkoutCreditCardProcessor1);
        
        final ICreditCardProcessor checkoutCreditCardProcessor2 = injector.getInstance(Key.get(ICreditCardProcessor.class, Names.named("Checkout")));
        System.out.println("checkoutCreditCardProcessor2 = " + checkoutCreditCardProcessor2);
    
        System.out.println("------------------------------------------------------------------------");
    
        final DatabaseTransactionLog databaseTransactionLog1 = injector.getInstance(DatabaseTransactionLog.class);
        System.out.println("databaseTransactionLog1 = " + databaseTransactionLog1);
        
        final DatabaseTransactionLog databaseTransactionLog2 = injector.getInstance(DatabaseTransactionLog.class);
        System.out.println("databaseTransactionLog2 = " + databaseTransactionLog2);
    
        System.out.println("------------------------------------------------------------------------");
    
        final MySqlDatabaseTransactionLog mySqlDatabaseTransactionLog1 = injector.getInstance(MySqlDatabaseTransactionLog.class);
        System.out.println("mySqlDatabaseTransactionLog1 = " + mySqlDatabaseTransactionLog1);
        
        final MySqlDatabaseTransactionLog mySqlDatabaseTransactionLog2 = injector.getInstance(MySqlDatabaseTransactionLog.class);
        System.out.println("mySqlDatabaseTransactionLog2 = " + mySqlDatabaseTransactionLog2);
    
        System.out.println("------------------------------------------------------------------------");
    
        final MySqlDatabaseTransactionLog namedmySqlDatabaseTransactionLog1 = injector.getInstance(Key.get(MySqlDatabaseTransactionLog.class, SqlDatabaseTransactionLog.class));
        System.out.println("namedmySqlDatabaseTransactionLog1 = " + namedmySqlDatabaseTransactionLog1);
    
        final MySqlDatabaseTransactionLog namedmySqlDatabaseTransactionLog2 = injector.getInstance(Key.get(MySqlDatabaseTransactionLog.class, SqlDatabaseTransactionLog.class));
        System.out.println("namedmySqlDatabaseTransactionLog2 = " + namedmySqlDatabaseTransactionLog2);
    
        System.out.println("------------------------------------------------------------------------");
    
        final SingletonExample singletonExample1 = injector.getInstance(SingletonExample.class);
        System.out.println("singletonExample1 = " + singletonExample1);
        
        final SingletonExample singletonExample2 = injector.getInstance(SingletonExample.class);
        System.out.println("singletonExample2 = " + singletonExample2);
    
        System.out.println("------------------------------------------------------------------------");
        
    }

}
