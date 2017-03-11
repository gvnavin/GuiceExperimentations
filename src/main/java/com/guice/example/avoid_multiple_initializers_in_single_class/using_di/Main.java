package com.guice.example.avoid_multiple_initializers_in_single_class.using_di;

import com.google.inject.Guice;
import com.google.inject.Injector;

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
        final Injector injector = Guice.createInjector(new BindModule());

        /**
         * Now that we've got the injector, we can build objects.
         */
        final Book3PUserOrConsumer book3PUserOrConsumer = injector.getInstance(Book3PUserOrConsumer.class);
        book3PUserOrConsumer.doSomethingRelated();
    
        final Context3PUserOrConsumer context3PUserOrConsumer = injector.getInstance(Context3PUserOrConsumer.class);
        context3PUserOrConsumer.doSomethingRelated();
        
        final Page3PUserOrConsumer page3PUserOrConsumer = injector.getInstance(Page3PUserOrConsumer.class);
        page3PUserOrConsumer.doSomethingRelated();
    
    }

}
