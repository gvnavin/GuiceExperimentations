package com.guice.example.assisted_injection;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    
    public static void main(String[] args) {
        final Injector injector = Guice.createInjector(new TestFactoryModule());
        final TestFactory instance = injector.getInstance(TestFactory.class);
        final TestModel name = instance.create("name", 3);
        System.out.println("name = " + name);
    }
}
