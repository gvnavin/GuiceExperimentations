package com.guice.example.avoid_multiple_initializers_in_single_class.example_impl;

import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IContext;

public class Context implements IContext{
    @Override
    public void setUIContext() {
        System.out.println("Context.setUIContext");
    }
}
