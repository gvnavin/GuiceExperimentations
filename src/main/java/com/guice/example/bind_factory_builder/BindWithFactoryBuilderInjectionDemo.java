package com.guice.example.bind_factory_builder;

import com.google.inject.Inject;
import com.guice.example.factorymodulebuilder.Payment;
import com.guice.example.factorymodulebuilder.PaymentFactory;
import lombok.RequiredArgsConstructor;

/**
 * Created by gnavin on 6/1/16.
 */
@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class BindWithFactoryBuilderInjectionDemo {

    private final PaymentFactory paymentFactory;

    public void print() {
        System.out.println("BindInterfaceWithImplDemo.print");

        for (int i = 0; i < 5; i++) {
            final Payment payment = paymentFactory.create(i, i*300);
            System.out.println("payment = " + payment);
        }
    }

}
