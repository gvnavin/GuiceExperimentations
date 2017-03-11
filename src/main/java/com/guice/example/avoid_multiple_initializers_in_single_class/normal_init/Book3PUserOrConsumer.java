package com.guice.example.avoid_multiple_initializers_in_single_class.normal_init;

public class Book3PUserOrConsumer {
    // This is having ManagerOrControllerOrSDK, indirectly it has access to all the other object which are not needed
    
    private final ManagerOrControllerOrSDK managerOrControllerOrSDK;
    
    public Book3PUserOrConsumer(final ManagerOrControllerOrSDK managerOrControllerOrSDK) {
        this.managerOrControllerOrSDK = managerOrControllerOrSDK;
    }
    
   public void doSomethingRelated() {
       managerOrControllerOrSDK.getBook().setBookNumber();
       
       //but it can have the access to other object so that it can corrupt
       managerOrControllerOrSDK.getPage().setPageNumber();
       managerOrControllerOrSDK.getContext().setUIContext();
       
   }
}
