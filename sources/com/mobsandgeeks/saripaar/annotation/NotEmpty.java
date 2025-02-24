package com.mobsandgeeks.saripaar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@ValidateUsing(C1089ee.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotEmpty {
    String emptyText() default "";

    int emptyTextResId() default -1;

    String message() default "This field is required";

    int messageResId() default -1;

    int sequence() default -1;

    boolean trim() default false;
}
