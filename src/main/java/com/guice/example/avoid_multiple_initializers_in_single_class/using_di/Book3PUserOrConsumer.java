package com.guice.example.avoid_multiple_initializers_in_single_class.using_di;

import com.google.inject.Inject;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IBook;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(onConstructor=@__(@Inject))
public class Book3PUserOrConsumer {
   
   private final IBook book;
   
   public void doSomethingRelated() {
       book.setBookNumber();
   }
}
