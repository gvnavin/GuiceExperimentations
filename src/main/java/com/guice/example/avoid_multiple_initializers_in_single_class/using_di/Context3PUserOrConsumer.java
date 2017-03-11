package com.guice.example.avoid_multiple_initializers_in_single_class.using_di;

import com.google.inject.Inject;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor=@__(@Inject))
public class Context3PUserOrConsumer {
    
    private final IContext context;
    
    public void doSomethingRelated() {
        context.setUIContext();
    }
}
