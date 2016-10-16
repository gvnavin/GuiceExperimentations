package com.guice.example.chain_binding;

import com.google.inject.Inject;
import com.guice.example.helpers.log.ITransactionLog;
import lombok.RequiredArgsConstructor;

/**
 * Created by gnavin on 6/1/16.
 */
@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class ChainBindingInjectionDemo {
    
    private final ITransactionLog transactionLog;

    public void print() {
        System.out.println();
        
        System.out.println("BindInterfaceWithImplDemo.print");

        System.out.println("transactionLog = " + transactionLog);
        transactionLog.print();
        System.out.println();

    }

}
