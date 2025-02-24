package com.google.errorprone.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
@IncompatibleModifiers(modifier = {Modifier.FINAL})
@Retention(RetentionPolicy.RUNTIME)
public @interface Var {
}
