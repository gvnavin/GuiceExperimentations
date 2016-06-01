package com.guice.example.service;

import com.guice.example.cardprocessor.CreditCardProcessor;
import com.guice.example.log.ITransactionLog;
import com.guice.example.misc.ChargeResult;
import com.guice.example.misc.PizzaOrder;
import com.guice.example.misc.Receipt;
import com.guice.example.card.CreditCard;

/**
 * Created by gnavin on 5/31/16.
 */
public interface IBillingService {
    /**
     * Attempts to charge the order to the credit card. Both successful and
     * failed transactions will be recorded.
     *
     * @return a receipt of the transaction. If the charge was successful, the
     *      receipt will be successful. Otherwise, the receipt will contain a
     *      decline note describing why the charge failed.
     */
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);

    default Receipt charge(CreditCardProcessor processor, CreditCard creditCard, PizzaOrder order, ITransactionLog transactionLog) {
        try {
            ChargeResult result = processor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);

            return result.wasSuccessful()
                    ? Receipt.forSuccessfulCharge(order.getAmount())
                    : Receipt.forDeclinedCharge(result.getDeclineMessage());
        } catch (Exception e) {
            transactionLog.logConnectException(e);
            return Receipt.forSystemFailure(e.getMessage());
        }
    }
}
