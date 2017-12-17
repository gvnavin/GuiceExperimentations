package com.guice.example.factorymodulebuilder;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

/**
 * Created by gnavin on 6/2/16.
 */
public class RealPayment implements Payment {
    @Inject
    public RealPayment(
            CreditService creditService,
            AuthService authService,
            @Assisted("index") int index,
            @Assisted("amount") int amount) {
        System.out.println("RealPayment.RealPayment");
        System.out.println("creditService = [" + creditService + "], authService = [" + authService + "], index = [" + index + "], amount = [" + amount + "]");
    }
}
