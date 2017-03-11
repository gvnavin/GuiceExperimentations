package com.guice.example.avoid_multiple_initializers_in_single_class.using_di;

import com.google.inject.AbstractModule;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_impl.Book;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_impl.Context;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_impl.Page;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IBook;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IContext;
import com.guice.example.avoid_multiple_initializers_in_single_class.example_interfaces.IPage;

/**
 * Created by gnavin on 3/2/17.
 */
public class BindModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IBook.class).to(Book.class);
        bind(IPage.class).to(Page.class);
        bind(IContext.class).to(Context.class);
    }
}
