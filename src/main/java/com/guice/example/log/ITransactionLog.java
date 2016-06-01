package com.guice.example.log;

import com.guice.example.misc.ChargeResult;

/**
 * Created by gnavin on 5/31/16.
 */
public interface ITransactionLog {
    public void logChargeResult(ChargeResult result);

    public void logConnectException(Exception e);
}
