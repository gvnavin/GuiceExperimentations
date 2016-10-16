package com.guice.example.helpers.module;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guice.example.bind_with_instance.BindWithInstanceDemo;

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
        final BindWithInstanceDemo bindWithInstanceDemo = injector.getInstance(BindWithInstanceDemo.class);
        System.out.println("bindWithInstanceDemo.getJdbcUrl() : " + bindWithInstanceDemo.getJdbcUrl());
        System.out.println("bindWithInstanceDemo.getTimeOut() : " + bindWithInstanceDemo.getTimeOut());
    }
}
