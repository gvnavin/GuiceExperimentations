package com.guice.example.bind_nothing_explicit;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindNothingExplicitMain {
    public static void main(String[] args) {

        /**
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        final Injector injector = Guice.createInjector(new BindNothingExplicitGuiceModule());

        /**
         * Now that we've got the injector, we can build objects.
         */
        final BindNothingExplicitInjectionDemo bindNothingExplicitInjectionDemo = injector.getInstance(BindNothingExplicitInjectionDemo.class);
        System.out.println();
        bindNothingExplicitInjectionDemo.print();
    
        // Real Billing service takes interface as constructor params,
        // guice needs binding of concrete class for the interface
        //final RealBillingService realBillingService = injector.getInstance(RealBillingService.class);
        //System.out.println("realBillingService = " + realBillingService);
    
    }

}
