package com.guice.example.bind_set;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.multibindings.Multibinder;
import com.guice.example.helpers.multibinder.Skittles;
import com.guice.example.helpers.multibinder.Snack;
import com.guice.example.helpers.multibinder.SnickersProvider;
import com.guice.example.helpers.multibinder.Twix;

public class BindSetModule extends AbstractModule {
    protected void configure() {
        Multibinder<Snack> mapbinder
            = Multibinder.newSetBinder(binder(), Snack.class);
        mapbinder.addBinding().toInstance(new Twix());
        mapbinder.addBinding().toProvider(SnickersProvider.class);
        mapbinder.addBinding().to(Skittles.class);
    }
}
