package com.guice.example.bind_interface_with_impl;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guice.example.bind_with_instance.BindWithInstanceDemo;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.service.IBillingService;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindInterfaceWithImplMain {
    public static void main(String[] args) {

        /**
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        final Injector injector = Guice.createInjector(new BindInterfaceWithImplGuiceModule());

        /**
         * Now that we've got the injector, we can build objects.
         */
        final BindInterfaceWithImplDemo bindInterfaceWithImplDemo = injector.getInstance(BindInterfaceWithImplDemo.class);
        bindInterfaceWithImplDemo.print();
    
        System.out.println("------------------------------------------------------------------------");
        
        final ICreditCardProcessor creditCardProcessor = injector.getInstance(ICreditCardProcessor.class);
        System.out.println("creditCardProcessor = " + creditCardProcessor);
        System.out.println("creditCardProcessor.charge() = " + creditCardProcessor.charge(null, 10));
        
        System.out.println("------------------------------------------------------------------------");
        
        final IBillingService billingService = injector.getInstance(IBillingService.class);
        System.out.println("billingService = " + billingService);
        System.out.println("billingService.chargeOrder() = " + billingService.chargeOrder(null, null));
    
        System.out.println("------------------------------------------------------------------------");
    }

   
}
