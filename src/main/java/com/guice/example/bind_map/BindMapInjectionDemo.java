package com.guice.example.bind_map;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.guice.example.helpers.multibinder.Snack;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor(onConstructor = @_(@Inject))
public class BindMapInjectionDemo {
    
    private final Map<String, Snack> snacks;
    
    //Provider lazy value provision
    private final Map<String, Provider<Snack>> snackProviders;
    
    public void print() {
    
        for (Map.Entry<String, Snack> stringSnackEntry : snacks.entrySet()) {
            System.out.println("stringSnackEntry.getKey() = " + stringSnackEntry.getKey());
            System.out.println("stringSnackEntry.getValue() = " + stringSnackEntry.getValue());
            System.out.println("stringSnackEntry.getValue() = " + stringSnackEntry.getValue());
        }
        
        System.out.println("------------------------------------------------------------------------");
        
        for (Map.Entry<String, Provider<Snack>> stringProviderEntry : snackProviders.entrySet()) {
            System.out.println("stringProviderEntry.getKey() = " + stringProviderEntry.getKey());
            System.out.println("stringProviderEntry.getValue().get() = " + stringProviderEntry.getValue().get());
            System.out.println("stringProviderEntry.getValue().get() = " + stringProviderEntry.getValue().get());
        }
        
    }
}
