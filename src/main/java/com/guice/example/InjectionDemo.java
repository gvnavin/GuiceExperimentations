package com.guice.example;

import com.google.inject.Inject;
import com.guice.example.card.CreditCard;
import com.guice.example.misc.PizzaOrder;
import com.guice.example.service.AnnotatedBillingService;
import com.guice.example.service.IBillingService;
import com.guice.example.service.NamedBillingService;
import com.guice.example.service.RealBillingService;

/**
 * Created by gnavin on 6/1/16.
 */
public class InjectionDemo {

    final PizzaOrder order = new PizzaOrder(100);
    final CreditCard creditCard = new CreditCard("1234", 11, 2010);

    @Inject
    private IBillingService billingService;

    @Inject
    private RealBillingService realBillingService;

    @Inject
    private AnnotatedBillingService annotatedBillingService;

    @Inject
    private NamedBillingService namedBillingService;

    public void print() {
        System.out.println("InjectionDemo.print");

        System.out.println("billingService = " + billingService);
        billingService.chargeOrder(order, creditCard);

        System.out.println("realBillingService = " + realBillingService);
        realBillingService.chargeOrder(order, creditCard);

        System.out.println("annotatedBillingService = " + annotatedBillingService);
        annotatedBillingService.chargeOrder(order, creditCard);

        System.out.println("namedBillingService = " + namedBillingService);
        namedBillingService.chargeOrder(order, creditCard);
    }

}
