package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbdu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zze extends zzm {
    public static void zza(String str) {
        if (zzc() && str != null && str.length() > 4000) {
            for (String str2 : zzm.zza.zzc(str)) {
            }
        }
    }

    public static void zzb(String str, Throwable th) {
        zzc();
    }

    public static boolean zzc() {
        if (!zzm.zzm(2) || !((Boolean) zzbdu.zza.zze()).booleanValue()) {
            return false;
        }
        return true;
    }
}
