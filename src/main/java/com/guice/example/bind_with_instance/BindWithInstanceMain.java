package com.guice.example.bind_with_instance;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.name.Names;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindWithInstanceMain {
    public static void main(String[] args) {

        /**
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        final Injector injector = Guice.createInjector(new BindWithInstanceGuiceModule());

        /**
         * Now that we've got the injector, we can build objects.
         */
        final BindWithInstanceDemo bindWithInstanceDemo = injector.getInstance(BindWithInstanceDemo.class);
    
        System.out.println("bindWithInstanceDemo.getJdbcUrl() : " + bindWithInstanceDemo.getJdbcUrl());
        System.out.println("bindWithInstanceDemo.getTimeOut() : " + bindWithInstanceDemo.getTimeOut());
        
        System.out.println("------------------------------------------------------------------------");
        
        final String jdbcUrl = injector.getInstance(Key.get(String.class, Names.named("JDBC.URL")));
        System.out.println("jdbcUrl = " + jdbcUrl);
    
        System.out.println("------------------------------------------------------------------------");
        
        final Integer loginTimeOut = injector.getInstance(Key.get(Integer.class, Names.named("login.timeout.seconds")));
        System.out.println("loginTimeOut = " + loginTimeOut);
    
        System.out.println("------------------------------------------------------------------------");
    }

}
