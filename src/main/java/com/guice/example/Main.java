package com.guice.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guice.example.instancebinding.InstanceBindingDemo;
import com.guice.example.module.GuiceModule;

/**
 * Created by gnavin on 5/31/16.
 */
public class Main {
    public static void main(String[] args) {

        /**
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        final Injector injector = Guice.createInjector(new GuiceModule());

        /**
         * Now that we've got the injector, we can build objects.
         */
        final InjectionDemo injectionDemo = injector.getInstance(InjectionDemo.class);
        injectionDemo.print();

        testInstanceBinding(injector);
    }

    public static void testInstanceBinding(final Injector injector) {
        final InstanceBindingDemo instanceBindingDemo = injector.getInstance(InstanceBindingDemo.class);
        System.out.println("instanceBindingDemo.getJdbcUrl() : " + instanceBindingDemo.getJdbcUrl());
        System.out.println("instanceBindingDemo.getTimeOut() : " + instanceBindingDemo.getTimeOut());
    }
}
