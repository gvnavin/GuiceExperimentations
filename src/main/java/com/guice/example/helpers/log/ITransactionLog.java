package com.guice.example.helpers.log;

import com.guice.example.helpers.misc.ChargeResult;

/**
 * Created by gnavin on 5/31/16.
 */
public interface ITransactionLog {
    void logChargeResult(ChargeResult result);

    void logConnectException(Exception e);

    void print();
}
