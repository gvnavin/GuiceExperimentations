package com.guice.example.bind_factory_builder;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guice.example.bind_with_instance.BindWithInstanceDemo;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindWithFactoryBuilderMain {
    public static void main(String[] args) {

        /**
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        final Injector injector = Guice.createInjector(new BindWithFactoryBuilderGuiceModule());

        /**
         * Now that we've got the injector, we can build objects.
         */
        final BindWithFactoryBuilderInjectionDemo bindWithFactoryBuilderInjectionDemo = injector.getInstance(BindWithFactoryBuilderInjectionDemo.class);
        bindWithFactoryBuilderInjectionDemo.print();

    }
    
}
