package com.mobsandgeeks.saripaar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@ValidateUsing(C0632P1.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Digits {
    int fraction() default 2;

    int integer();

    String message() default "Should be a digit";

    int messageResId() default -1;

    int sequence() default -1;
}
