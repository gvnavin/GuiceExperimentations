package com.guice.example.instancebinding;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Created by gnavin on 6/1/16.
 */
public class InstanceBindingDemo {

    @Inject
    @Named("JDBC.URL")
    private String jdbcUrl;

    @Inject
    @Named("login.timeout.seconds")
    private int timeOut;

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public int getTimeOut() {
        return timeOut;
    }
}
