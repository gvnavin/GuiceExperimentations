package com.guice.example;

import com.google.inject.Inject;
import com.guice.example.bindingannotation.RemoteServerLog;
import com.guice.example.card.CreditCard;
import com.guice.example.factorymodulebuilder.Payment;
import com.guice.example.factorymodulebuilder.PaymentFactory;
import com.guice.example.log.ITransactionLog;
import com.guice.example.log.MySqlDatabaseTransactionLog;
import com.guice.example.log.NoSqlDatabaseTransactionLog;
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

    /**
     * injecting field examples
     */
    @Inject
    private IBillingService billingService;

    //injecting concrete class directly, doesn't binding inside Module.Configure()
    @Inject
    private RealBillingService realBillingService;

    @Inject
    private AnnotatedBillingService annotatedBillingService;

    @Inject
    private NamedBillingService namedBillingService;

    @Inject
    private ITransactionLog transactionLog;

    //Inject using annotation
    @Inject
    @RemoteServerLog
    private MySqlDatabaseTransactionLog remoteTransactionLog;

    @Inject
    private NoSqlDatabaseTransactionLog noSqlDatabaseTransactionLog;

    @Inject
    private PaymentFactory paymentFactory;

    public void print() {
        System.out.println("InjectionDemo.print");

        System.out.println("billingService = " + billingService);
        billingService.chargeOrder(order, creditCard);
        System.out.println();

        System.out.println("realBillingService = " + realBillingService);
        realBillingService.chargeOrder(order, creditCard);
        System.out.println();

        System.out.println("annotatedBillingService = " + annotatedBillingService);
        annotatedBillingService.chargeOrder(order, creditCard);
        System.out.println();

        System.out.println("namedBillingService = " + namedBillingService);
        namedBillingService.chargeOrder(order, creditCard);
        System.out.println();

        System.out.println("transactionLog = " + transactionLog);
        transactionLog.print();
        System.out.println();

        System.out.println("remoteTransactionLog = " + remoteTransactionLog);
        remoteTransactionLog.print();
        System.out.println();

        System.out.println("noSqlDatabaseTransactionLog = " + noSqlDatabaseTransactionLog);
        noSqlDatabaseTransactionLog.print();
        System.out.println();

        for (int i = 0; i < 5; i++) {
            final Payment payment = paymentFactory.create(i, i*300);
            System.out.println("payment = " + payment);
        }
    }

}
