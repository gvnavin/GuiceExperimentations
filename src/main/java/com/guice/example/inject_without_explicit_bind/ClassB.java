package com.guice.example.inject_without_explicit_bind;

import com.google.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by gnavin on 3/2/17.
 */
@AllArgsConstructor(onConstructor = @_(@Inject))
@Getter
public class ClassB {
    private ClassC classC;
    private ClassD classD;
}
