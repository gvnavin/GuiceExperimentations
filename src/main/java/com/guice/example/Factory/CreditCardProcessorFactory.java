package com.guice.example.Factory;

import com.guice.example.cardprocessor.ICreditCardProcessor;
import com.guice.example.cardprocessor.SquareCreditCardProcessor;

/**
 * Created by gnavin on 5/31/16.
 */
public class CreditCardProcessorFactory {
    private static ICreditCardProcessor instance;

    public static void setInstance(ICreditCardProcessor processor) {
        instance = processor;
    }

    public static ICreditCardProcessor getInstance() {
        if (instance == null) {
            return new SquareCreditCardProcessor();
        }

        return instance;
    }
}
