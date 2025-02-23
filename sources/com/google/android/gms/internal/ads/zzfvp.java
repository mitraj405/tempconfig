package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzfvp {
    private static final Object zza;

    static {
        Object zza2 = zza();
        zza = zza2;
        if (zza2 != null) {
            zzb("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        if (zza2 != null) {
            zzc(zza2);
        }
    }

    private static Object zza() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, (ClassLoader) null).getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method zzb(String str, Class... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e) {
            throw e;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method zzc(Object obj) {
        try {
            Method zzb = zzb("getStackTraceDepth", Throwable.class);
            if (zzb == null) {
                return null;
            }
            zzb.invoke(obj, new Object[]{new Throwable()});
            return zzb;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }
}
