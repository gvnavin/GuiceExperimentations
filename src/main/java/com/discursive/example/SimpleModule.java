package com.discursive.example;

import com.discursive.example.student.Registrar;
import com.discursive.example.student.StudentStore;
import com.discursive.example.student.register.LenientRegistrar;
import com.discursive.example.student.store.DummyStudentStore;
import com.google.inject.AbstractModule;

/**
 * Created by gnavin on 5/31/16.
 */
public class SimpleModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StudentStore.class).to(DummyStudentStore.class);
        bind(Registrar.class).to(LenientRegistrar.class);
    }

}
