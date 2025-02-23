package com.mobsandgeeks.saripaar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@ValidateUsing(C0632P1.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Pattern {
    boolean caseSensitive() default true;

    String message() default "Input does not match pattern";

    int messageResId() default -1;

    String regex();

    int sequence() default -1;
}
