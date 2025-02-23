package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public final class zzfup {
    private final String zza;
    private final zzfun zzb;
    private zzfun zzc;

    public /* synthetic */ zzfup(String str, zzfuo zzfuo) {
        zzfun zzfun = new zzfun();
        this.zzb = zzfun;
        this.zzc = zzfun;
        str.getClass();
        this.zza = str;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.zza);
        sb.append('{');
        zzfun zzfun = this.zzb.zzb;
        String str = "";
        while (zzfun != null) {
            Object obj = zzfun.zza;
            sb.append(str);
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append(deepToString, 1, deepToString.length() - 1);
            }
            zzfun = zzfun.zzb;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }

    public final zzfup zza(Object obj) {
        zzfun zzfun = new zzfun();
        this.zzc.zzb = zzfun;
        this.zzc = zzfun;
        zzfun.zza = obj;
        return this;
    }
}
