package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzald {
    public static zzale zza(zzale zzale, String[] strArr, Map map) {
        int length;
        int i = 0;
        if (zzale == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzale) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzale zzale2 = new zzale();
                while (i < length2) {
                    zzale2.zzl((zzale) map.get(strArr[i]));
                    i++;
                }
                return zzale2;
            }
        } else if (strArr != null && strArr.length == 1) {
            zzale.zzl((zzale) map.get(strArr[0]));
            return zzale;
        } else if (strArr != null && (length = strArr.length) > 1) {
            while (i < length) {
                zzale.zzl((zzale) map.get(strArr[i]));
                i++;
            }
        }
        return zzale;
    }
}
