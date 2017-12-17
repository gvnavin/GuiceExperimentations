package com.guice.example.factorymodulebuilder;

import com.google.inject.assistedinject.Assisted;

/**
 * Created by gnavin on 6/2/16.
 */
public interface PaymentFactory {
    Payment create(@Assisted("index") int index,
                   @Assisted("amount") int amount);
}
