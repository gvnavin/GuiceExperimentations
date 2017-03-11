package com.guice.example.avoid_multiple_initializers_in_single_class.example_impl;

import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IBook;

public class Book implements IBook {
    @Override
    public void setBookNumber() {
        System.out.println("Book.setBookNumber");
    }
}
