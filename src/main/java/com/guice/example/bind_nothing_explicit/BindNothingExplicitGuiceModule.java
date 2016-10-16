package com.guice.example.bind_nothing_explicit;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.guice.example.bind_with_annotation.PayPal;
import com.guice.example.bind_with_annotation.SqlDatabaseTransactionLog;
import com.guice.example.helpers.cardprocessor.CheckoutCreditCardProcessor;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.cardprocessor.PayPalCreditCardProcessor;
import com.guice.example.helpers.factorymodulebuilder.Payment;
import com.guice.example.helpers.factorymodulebuilder.PaymentFactory;
import com.guice.example.helpers.factorymodulebuilder.RealPayment;
import com.guice.example.helpers.log.DatabaseTransactionLog;
import com.guice.example.helpers.log.ITransactionLog;
import com.guice.example.helpers.log.MySqlDatabaseTransactionLog;
import com.guice.example.helpers.log.NoSqlDatabaseTransactionLog;
import com.guice.example.helpers.service.IBillingService;
import com.guice.example.helpers.service.RealBillingService;
import com.guice.example.module.NoSqlDatabaseTransactionLogProvider;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindNothingExplicitGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
    }
}

