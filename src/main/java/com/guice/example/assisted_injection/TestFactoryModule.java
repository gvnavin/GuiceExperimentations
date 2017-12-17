package com.guice.example.assisted_injection;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

public class TestFactoryModule extends AbstractModule {
    /**
     * Configures a {@link Binder} via the exposed methods.
     */
    @Override
    protected void configure() {
        install(new FactoryModuleBuilder()
            .build(TestFactory.class));
    
    }
}
