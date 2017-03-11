package com.guice.example.avoid_multiple_initializers_in_single_class.normal_init;

public class Page3PUserOrConsumer {
    // This is having ManagerOrControllerOrSDK, indirectly it has access to all the other object which are not needed
    
    private final ManagerOrControllerOrSDK managerOrControllerOrSDK;
    
    public Page3PUserOrConsumer(final ManagerOrControllerOrSDK managerOrControllerOrSDK) {
        this.managerOrControllerOrSDK = managerOrControllerOrSDK;
    }
    
    public void doSomethingRelated() {
        managerOrControllerOrSDK.getPage().setPageNumber();
        
        //but it can have the access to other object so that it can corrupt
        managerOrControllerOrSDK.getBook().setBookNumber();
        managerOrControllerOrSDK.getContext().setUIContext();
        
    }
}
