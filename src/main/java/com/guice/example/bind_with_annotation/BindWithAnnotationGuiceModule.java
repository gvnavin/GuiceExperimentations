package com.guice.example.bind_with_annotation;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.guice.example.helpers.cardprocessor.CheckoutCreditCardProcessor;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.cardprocessor.PayPalCreditCardProcessor;
import com.guice.example.helpers.log.ITransactionLog;
import com.guice.example.helpers.log.MySqlDatabaseTransactionLog;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindWithAnnotationGuiceModule extends AbstractModule {
    
    @Override
    protected void configure() {
        bindWithAnnotation();
    }

    private void bindWithAnnotation() {
        /**
         * Avoid named annotation, prefer annotation class
         * http://javanuggets.blogspot.com/2012/04/named-annotations-are-evil.html
         **/
        bind(ICreditCardProcessor.class).annotatedWith(PayPal.class).to(PayPalCreditCardProcessor.class);
        bind(ICreditCardProcessor.class).annotatedWith(Names.named("Checkout")).to(CheckoutCreditCardProcessor.class);
    
        bind(ITransactionLog.class).annotatedWith(SqlDatabaseTransactionLog.class).to(MySqlDatabaseTransactionLog.class);
    }

}

