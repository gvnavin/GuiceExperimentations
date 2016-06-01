package com.guice.example.Factory;

import com.guice.example.cardprocessor.CreditCardProcessor;
import com.guice.example.cardprocessor.SquareCreditCardProcessor;

/**
 * Created by gnavin on 5/31/16.
 */
public class CreditCardProcessorFactory {
    private static CreditCardProcessor instance;

    public static void setInstance(CreditCardProcessor processor) {
        instance = processor;
    }

    public static CreditCardProcessor getInstance() {
        if (instance == null) {
            return new SquareCreditCardProcessor();
        }

        return instance;
    }
}
