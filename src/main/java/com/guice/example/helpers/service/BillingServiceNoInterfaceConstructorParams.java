package com.guice.example.helpers.service;

import com.google.inject.Inject;
import com.guice.example.helpers.card.CreditCard;
import com.guice.example.helpers.cardprocessor.ICreditCardProcessor;
import com.guice.example.helpers.cardprocessor.PayPalCreditCardProcessor;
import com.guice.example.helpers.log.ITransactionLog;
import com.guice.example.helpers.log.InMemoryTransactionLog;
import com.guice.example.helpers.misc.PizzaOrder;
import com.guice.example.helpers.misc.Receipt;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class BillingServiceNoInterfaceConstructorParams implements IBillingService {
    
    private final PayPalCreditCardProcessor processor;
    private final InMemoryTransactionLog transactionLog;
    
    /**
     * Attempts to charge the order to the credit card. Both successful and
     * failed transactions will be recorded.
     *
     * @param order
     * @param creditCard
     * @return a receipt of the transaction. If the charge was successful, the
     * receipt will be successful. Otherwise, the receipt will contain a
     * decline note describing why the charge failed.
     */
    @Override
    public Receipt chargeOrder(final PizzaOrder order, final CreditCard creditCard) {
        System.out.println("BillingServiceNoInterfaceConstructorParams.chargeOrder");
        return new Receipt();
    }
    
    @Override
    public Receipt charge(final ICreditCardProcessor processor, final CreditCard creditCard, final PizzaOrder order,
        final ITransactionLog transactionLog) {
        System.out.println("BillingServiceNoInterfaceConstructorParams.charge");
        return new Receipt();
    }
}
