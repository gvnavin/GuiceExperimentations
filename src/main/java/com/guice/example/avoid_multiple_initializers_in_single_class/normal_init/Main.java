package com.guice.example.avoid_multiple_initializers_in_single_class.normal_init;

public class Main {
    public static void main(String[] args) {
        final ManagerOrControllerOrSDK managerOrControllerOrSDK = new ManagerOrControllerOrSDK();
        
        final Book3PUserOrConsumer book3PUserOrConsumer = new Book3PUserOrConsumer(managerOrControllerOrSDK);
        book3PUserOrConsumer.doSomethingRelated();
        System.out.println("-------------------------------------------------");
        
        final Context3PUserOrConsumer context3PUserOrConsumer = new Context3PUserOrConsumer(managerOrControllerOrSDK);
        context3PUserOrConsumer.doSomethingRelated();
        System.out.println("-------------------------------------------------");
        
        final Page3PUserOrConsumer page3PUserOrConsumer = new Page3PUserOrConsumer(managerOrControllerOrSDK);
        page3PUserOrConsumer.doSomethingRelated();
        System.out.println("-------------------------------------------------");
    }
}
