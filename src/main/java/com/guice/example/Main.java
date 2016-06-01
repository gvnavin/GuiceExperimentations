package com.guice.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guice.example.card.CreditCard;
import com.guice.example.misc.PizzaOrder;
import com.guice.example.module.BillingModule;
import com.guice.example.service.IBillingService;

/**
 * Created by gnavin on 5/31/16.
 */
public class Main {
    public static void main(String[] args) {

        final PizzaOrder order = new PizzaOrder(100);
        final CreditCard creditCard = new CreditCard("1234", 11, 2010);
        /**
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        Injector injector = Guice.createInjector(new BillingModule());

        /**
         * Now that we've got the injector, we can build objects.
         */
        IBillingService IBillingService = injector.getInstance(IBillingService.class);
        IBillingService.chargeOrder(order, creditCard);


    }
}
