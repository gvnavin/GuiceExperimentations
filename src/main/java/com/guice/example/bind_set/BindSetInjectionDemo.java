package com.guice.example.bind_set;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.guice.example.helpers.multibinder.Snack;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class BindSetInjectionDemo {
    
    private final Set<Snack> snacks;
    
    //Provider lazy value provision
    private final Collection<Provider<Snack>> snackProviders;
    
    public void print() {
    
        System.out.println("snacks = " + snacks);
        for (Snack snack : snacks) {
            System.out.println("snack = " + snack);
            System.out.println("snack = " + snack);
        }
        
        System.out.println("------------------------------------------------------------------------");
    
        System.out.println("snackProviders = " + snackProviders);
        for (Provider<Snack> snackProvider : snackProviders) {
            System.out.println("snackProvider.get() = " + snackProvider.get());
            System.out.println("snackProvider.get() = " + snackProvider.get());
        }
    }
}
