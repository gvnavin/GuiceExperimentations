package com.guice.example.bind_interface_with_impl;

import com.google.inject.Inject;
import com.guice.example.helpers.card.CreditCard;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.misc.PizzaOrder;
import com.guice.example.helpers.service.IBillingService;
import lombok.RequiredArgsConstructor;

/**
 * Created by gnavin on 6/1/16.
 */
@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class BindInterfaceWithImplDemo {
    
    final PizzaOrder order = new PizzaOrder(100);
    final CreditCard creditCard = new CreditCard("1234", 11, 2010);
    
    /**
     *
     */
    private final ICreditCardProcessor creditCardProcessor;
    
    /**
     * injecting field examples
     */
    private final IBillingService billingService;
    
    public void print() {
        System.out.println("BindInterfaceWithImplDemo.print");
        
        System.out.println("creditCardProcessor = " + creditCardProcessor);
        creditCardProcessor.charge(creditCard, 100);
        System.out.println();
    
        System.out.println("------------------------------------------------------------------------");
        
        System.out.println("billingService = " + billingService);
        billingService.chargeOrder(order, creditCard);
        System.out.println();
        
    }
    
}
