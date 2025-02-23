package com.mobsandgeeks.saripaar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@ValidateUsing(C0632P1.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Max {
    String message() default "Should be less than max value";

    int messageResId() default -1;

    int sequence() default -1;

    int value();
}
