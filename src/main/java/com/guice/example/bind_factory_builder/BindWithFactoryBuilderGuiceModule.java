package com.guice.example.bind_factory_builder;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.guice.example.factorymodulebuilder.Payment;
import com.guice.example.factorymodulebuilder.PaymentFactory;
import com.guice.example.factorymodulebuilder.RealPayment;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindWithFactoryBuilderGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bindFactoryModule();
    }
    
    private void bindFactoryModule() {
        install(new FactoryModuleBuilder()
            .implement(Payment.class, RealPayment.class)
            .build(PaymentFactory.class));
    }
}
