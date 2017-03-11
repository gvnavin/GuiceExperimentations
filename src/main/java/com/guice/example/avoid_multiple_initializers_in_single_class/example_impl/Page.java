package com.guice.example.avoid_multiple_initializers_in_single_class.example_impl;

import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IPage;

public class Page implements IPage {
    @Override
    public void setPageNumber() {
        System.out.println("Page.setPageNumber");
    }
}
