package com.guice.example.bind_with_provider;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.guice.example.helpers.log.NoSqlDatabaseTransactionLog;

/**
 * Created by gnavin on 5/31/16.
 */
public class BindWithProviderGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bindProvider();
    }

    private void bindProvider() {
        bind(NoSqlDatabaseTransactionLog.class).toProvider(NoSqlDatabaseTransactionLogProvider.class);
    }
    
}

