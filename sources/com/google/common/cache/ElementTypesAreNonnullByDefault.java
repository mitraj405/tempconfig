package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@GwtCompatible
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface ElementTypesAreNonnullByDefault {
}
