package com.guice.example.inject_without_explicit_bind;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.guice.example.bind_nothing_explicit.BindNothingExplicitGuiceModule;
import com.guice.example.bind_nothing_explicit.BindNothingExplicitInjectionDemo;

/**
 * Created by gnavin on 5/31/16.
 */
public class InjectWithoutBindMain {
    public static void main(String[] args) {

        /**
         * Guice.createInjector() takes your Modules, and returns a new Injector
         * instance. Most applications will call this method exactly once, in their
         * main() method.
         */
        final Injector injector = Guice.createInjector(new InjectWithoutBindModule());

        /**
         * Now that we've got the injector, we can build objects.
         */
        final ClassA classA = injector.getInstance(ClassA.class);

        System.out.println("classA = " + classA);
        final ClassB classB = classA.getClassB();
        System.out.println("classB = " + classB);
        final ClassC classC = classB.getClassC();
        final ClassD classD = classB.getClassD();
        System.out.println("classC = " + classC);
        System.out.println("classD = " + classD);
        final ClassE classE = classD.getClassE();
        System.out.println("classE = " + classE);

    }

}
