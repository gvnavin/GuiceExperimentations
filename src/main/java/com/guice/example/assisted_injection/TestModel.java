package com.guice.example.assisted_injection;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

public class TestModel {
    
    @Inject
    public TestModel(
        DummyClass dummy,
        @Assisted String name,
        @Assisted int amount) {
        System.out.println("dummy = " + dummy);
        System.out.println("name = " + name);
        System.out.println("amount = " + amount);
    }
}