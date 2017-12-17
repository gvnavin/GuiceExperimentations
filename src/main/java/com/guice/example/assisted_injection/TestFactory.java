package com.guice.example.assisted_injection;

import com.google.inject.assistedinject.Assisted;

public interface TestFactory {
    TestModel create(
        @Assisted String name,
        @Assisted int amount);
}