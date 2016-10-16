package com.guice.example.bind_with_provider;

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
import com.guice.example.helpers.service.IBillingService;
import com.guice.example.helpers.service.NamedBillingService;
import com.guice.example.helpers.service.RealBillingService;
import lombok.RequiredArgsConstructor;

/**
 * Created by gnavin on 6/1/16.
 */
@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class BindWithProviderInjectionDemo {

    private final NoSqlDatabaseTransactionLog noSqlDatabaseTransactionLog;

    public void print() {
        System.out.println("BindWithProviderInjectionDemo.print");

        System.out.println("noSqlDatabaseTransactionLog = " + noSqlDatabaseTransactionLog);
        noSqlDatabaseTransactionLog.print();
        System.out.println();
    }

}
