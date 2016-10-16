package com.guice.example.bind_map;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class BindMapMain {
    
    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new BindMapModule());
    
        /**
         * Now that we've got the injector, we can build objects.
         */
        final BindMapInjectionDemo bindMapInjectionDemo = injector.getInstance(BindMapInjectionDemo.class);
        bindMapInjectionDemo.print();
    }
}
