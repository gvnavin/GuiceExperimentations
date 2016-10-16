package com.guice.example.chain_binding;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guice.example.bind_with_instance.BindWithInstanceDemo;
import com.guice.example.helpers.log.ITransactionLog;

/**
 * Created by gnavin on 5/31/16.
 */
public class ChainBindingMain {
    public static void main(String[] args) {

        /**
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        final Injector injector = Guice.createInjector(new ChainBindingGuiceModule());

        /**
         * Now that we've got the injector, we can build objects.
         */
        final ChainBindingInjectionDemo chainBindingInjectionDemo = injector.getInstance(ChainBindingInjectionDemo.class);
        chainBindingInjectionDemo.print();
    
        System.out.println("------------------------------------------------------------------------");
        
        final ITransactionLog transactionLog = injector.getInstance(ITransactionLog.class);
        System.out.println("transactionLog = " + transactionLog);
        transactionLog.print();
    
        System.out.println("------------------------------------------------------------------------");
    
    }

}
