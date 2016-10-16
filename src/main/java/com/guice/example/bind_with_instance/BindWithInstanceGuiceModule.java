package com.guice.example.bind_with_instance;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindWithInstanceGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bindInstance();
    }

    private void bindInstance() {
        bind(String.class).annotatedWith(Names.named("JDBC.URL")).toInstance("jdbc:mysql://localhost/pizza");
        bind(Integer.class).annotatedWith(Names.named("login.timeout.seconds")).toInstance(10);
    }
   
}

