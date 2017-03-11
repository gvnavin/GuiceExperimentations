package com.guice.example.avoid_multiple_initializers_in_single_class.normal_init;

import com.guice.example.avoid_multiple_initializers_in_single_class.example_impl.Book;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_impl.Context;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_impl.Page;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IBook;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IContext;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IPage;
import lombok.Getter;

@Getter
public class ManagerOrControllerOrSDK {
    
    // This is not a very good practice to initialize all the interfaces in one initializer
    // As the number of interfaces keeps growing,
    // sharing this ManagerOrControllerOrSDK class will be exposed a lot
    
    private final IBook book;
    private final IContext context;
    private final IPage page;
    
    public ManagerOrControllerOrSDK() {
        book = new Book();
        context = new Context();
        page = new Page();
    }
    
    
}
