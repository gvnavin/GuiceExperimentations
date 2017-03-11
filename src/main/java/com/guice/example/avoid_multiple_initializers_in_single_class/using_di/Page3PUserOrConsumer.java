package com.guice.example.avoid_multiple_initializers_in_single_class.using_di;

import com.google.inject.Inject;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IPage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor=@__(@Inject))
public class Page3PUserOrConsumer {

    private final IPage page;
    
    public void doSomethingRelated() {
        page.setPageNumber();
    }
}
