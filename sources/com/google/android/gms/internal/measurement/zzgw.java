package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public final class zzgw {
    private static final ArrayMap<String, Uri> zza = new ArrayMap<>();

    public static synchronized Uri zza(String str) {
        Uri orDefault;
        synchronized (zzgw.class) {
            ArrayMap<String, Uri> arrayMap = zza;
            orDefault = arrayMap.getOrDefault(str, null);
            if (orDefault == null) {
                String encode = Uri.encode(str);
                orDefault = Uri.parse("content://com.google.android.gms.phenotype/" + encode);
                arrayMap.put(str, orDefault);
            }
        }
        return orDefault;
    }

    public static String zza(Context context, String str) {
        if (!str.contains("#")) {
            return xx.D(str, "#", context.getPackageName());
        }
        throw new IllegalArgumentException("The passed in package cannot already have a subpackage: ".concat(str));
    }

    public static boolean zza(String str, String str2) {
        if (str.equals("eng") || str.equals("userdebug")) {
            return str2.contains("dev-keys") || str2.contains("test-keys");
        }
        return false;
    }
}
