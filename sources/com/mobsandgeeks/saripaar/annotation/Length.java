package com.mobsandgeeks.saripaar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@ValidateUsing(C0632P1.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Length {
    int max() default Integer.MAX_VALUE;

    String message() default "Invalid length";

    int messageResId() default -1;

    int min() default Integer.MIN_VALUE;

    int sequence() default -1;

    boolean trim() default false;
}
