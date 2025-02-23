package com.mobsandgeeks.saripaar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@ValidateUsing(J6.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfirmPassword {
    String message() default "Passwords don't match";

    int messageResId() default -1;

    int sequence() default -1;
}
