package com.guice.example.bind_nothing_explicit;

import com.google.inject.Inject;
import com.guice.example.bind_with_annotation.SqlDatabaseTransactionLog;
import com.guice.example.helpers.card.CreditCard;
import com.guice.example.helpers.factorymodulebuilder.Payment;
import com.guice.example.helpers.factorymodulebuilder.PaymentFactory;
import com.guice.example.helpers.log.ITransactionLog;
import com.guice.example.helpers.log.MySqlDatabaseTransactionLog;
import com.guice.example.helpers.log.NoSqlDatabaseTransactionLog;
import com.guice.example.helpers.misc.PizzaOrder;
import com.guice.example.helpers.service.AnnotatedBillingService;
import com.guice.example.helpers.service.BillingServiceNoInterfaceConstructorParams;
import com.guice.example.helpers.service.IBillingService;
import com.guice.example.helpers.service.NamedBillingService;
import com.guice.example.helpers.service.RealBillingService;
import lombok.RequiredArgsConstructor;

/**
 * Created by gnavin on 6/1/16.
 */

@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class BindNothingExplicitInjectionDemo {

    final PizzaOrder order = new PizzaOrder(100);
    final CreditCard creditCard = new CreditCard("1234", 11, 2010);
    
    //injecting concrete class directly, doesn't binding inside Module.Configure()
    //BillingServiceNoInterfaceConstructorParams not taking any interface params
    private final BillingServiceNoInterfaceConstructorParams billingService;
    
    public void print() {
        System.out.println("BindInterfaceWithImplDemo.print");
    
        System.out.println("billingService = " + billingService);
        billingService.chargeOrder(order, creditCard);
        System.out.println();
    }

}
