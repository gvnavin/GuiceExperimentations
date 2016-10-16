package com.guice.example.bind_with_instance;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Created by gnavin on 6/1/16.
 */
public class BindWithInstanceDemo {

    private final String jdbcUrl;

    private final int timeOut;
    
    @Inject
    public BindWithInstanceDemo(
        @Named("JDBC.URL") final String jdbcUrl,
        @Named("login.timeout.seconds") final int timeOut) {
        
        this.jdbcUrl = jdbcUrl;
        this.timeOut = timeOut;
    }
    
    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public int getTimeOut() {
        return timeOut;
    }
}
