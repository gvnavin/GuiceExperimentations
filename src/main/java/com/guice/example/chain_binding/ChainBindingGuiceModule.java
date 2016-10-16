package com.guice.example.chain_binding;

import com.google.inject.AbstractModule;
import com.guice.example.helpers.log.DatabaseTransactionLog;
import com.guice.example.helpers.log.ITransactionLog;
import com.guice.example.helpers.log.MySqlDatabaseTransactionLog;

/**
 * Created by gnavin on 5/31/16.
 */
public class ChainBindingGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        chainBinding();
    }

    private void chainBinding() {
        /**
         * https://github.com/google/guice/wiki/LinkedBindings
         * You can even link the concrete DatabaseTransactionLog class to a subclass:
         *
         * Linked bindings can also be chained:
         * ITransactionLog --> DatabaseTransactionLog --> MySqlDatabaseTransactionLog
         */
        bind(ITransactionLog.class).to(DatabaseTransactionLog.class);
        bind(DatabaseTransactionLog.class).to(MySqlDatabaseTransactionLog.class);
    }
}

