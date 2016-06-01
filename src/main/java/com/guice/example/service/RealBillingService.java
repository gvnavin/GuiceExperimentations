package com.guice.example.service;

import com.guice.example.Factory.CreditCardProcessorFactory;
import com.guice.example.Factory.TransactionLogFactory;
import com.guice.example.misc.ChargeResult;
import com.guice.example.misc.PizzaOrder;
import com.guice.example.misc.Receipt;
import com.guice.example.card.CreditCard;
import com.guice.example.cardprocessor.CreditCardProcessor;
import com.guice.example.cardprocessor.PaypalCreditCardProcessor;
import com.guice.example.log.DatabaseTransactionLog;
import com.guice.example.log.TransactionLog;

/**
 * Created by gnavin on 5/31/16.
 */
public class RealBillingService  implements BillingService {
    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
        CreditCardProcessor processor = CreditCardProcessorFactory.getInstance();
        TransactionLog transactionLog = TransactionLogFactory.getInstance();

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
