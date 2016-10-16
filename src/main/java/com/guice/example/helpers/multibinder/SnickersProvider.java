package com.guice.example.helpers.multibinder;

import com.google.inject.Provider;

public class SnickersProvider implements Provider<Snack> {
    
    @Override
    public Snack get() {
        return new Cookie();
    }
    
}
