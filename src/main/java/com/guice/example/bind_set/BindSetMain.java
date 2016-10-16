package com.guice.example.bind_set;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class BindSetMain {
    
    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new BindSetModule());
    
        /**
         * Now that we've got the injector, we can build objects.
         */
        final BindSetInjectionDemo bindSetInjectionDemo = injector.getInstance(BindSetInjectionDemo.class);
        bindSetInjectionDemo.print();
    }
}
