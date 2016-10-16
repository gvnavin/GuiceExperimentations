package com.guice.example.bind_with_provides;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guice.example.bind_with_instance.BindWithInstanceDemo;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindWithProvidesMain {
    public static void main(String[] args) {

        /**
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        final Injector injector = Guice.createInjector(new BindWithProvidesGuiceModule());

        /**
         * Now that we've got the injector, we can build objects.
         */
        final BindWithProvidesInjectionDemo bindWithProvidesInjectionDemo = injector.getInstance(BindWithProvidesInjectionDemo.class);
        System.out.println();
        bindWithProvidesInjectionDemo.print();
        System.out.println("------------------------------------------------------------------------");
    }

}
