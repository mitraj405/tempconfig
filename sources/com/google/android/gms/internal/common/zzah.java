package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.jspecify.nullness.NullMarked;

@NullMarked
/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
public final class zzah {
    @CanIgnoreReturnValue
    public static Object[] zza(Object[] objArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            if (objArr[i2] != null) {
                i2++;
            } else {
                throw new NullPointerException(lf.h("at index ", i2));
            }
        }
        return objArr;
    }
}
