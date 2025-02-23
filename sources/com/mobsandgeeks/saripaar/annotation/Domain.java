package com.mobsandgeeks.saripaar.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@ValidateUsing(C0616O1.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Domain {
    boolean allowLocal() default false;

    String message() default "Invalid domain name";

    int messageResId() default -1;

    int sequence() default -1;
}
