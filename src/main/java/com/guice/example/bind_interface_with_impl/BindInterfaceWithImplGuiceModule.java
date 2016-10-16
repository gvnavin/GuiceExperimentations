package com.guice.example.bind_interface_with_impl;

import com.google.inject.AbstractModule;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.cardprocessor.PayPalCreditCardProcessor;
import com.guice.example.helpers.service.IBillingService;
import com.guice.example.helpers.service.RealBillingService;
import com.guice.example.helpers.service.SampleBillingService;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindInterfaceWithImplGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bindInterfaceWithImpl();
    }

    private void bindInterfaceWithImpl() {
        /**
         * Similarly, this binding tells Guice that when ICreditCardProcessor is used in
         * a dependency, that should be satisfied with a PayPalCreditCardProcessor.
         */
        bind(ICreditCardProcessor.class).to(PayPalCreditCardProcessor.class);
        bind(IBillingService.class).to(SampleBillingService.class);
    }

}

