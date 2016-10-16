package com.guice.example.bind_map;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import com.guice.example.helpers.multibinder.Skittles;
import com.guice.example.helpers.multibinder.Snack;
import com.guice.example.helpers.multibinder.SnickersProvider;
import com.guice.example.helpers.multibinder.Twix;

public class BindMapModule extends AbstractModule {
    protected void configure() {
        MapBinder<String, Snack> mapbinder
            = MapBinder.newMapBinder(binder(), String.class, Snack.class);
        mapbinder.addBinding("twix").toInstance(new Twix());
        mapbinder.addBinding("snickers").toProvider(SnickersProvider.class);
        mapbinder.addBinding("skittles").to(Skittles.class);
    }
}
