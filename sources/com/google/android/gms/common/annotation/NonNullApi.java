package com.google.android.gms.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE, ElementType.PACKAGE})
@KeepForSdk
@Retention(RetentionPolicy.CLASS)
/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public @interface NonNullApi {
}
