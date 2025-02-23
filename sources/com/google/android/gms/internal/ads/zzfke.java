package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfke {
    public static void zza(ListenableFuture listenableFuture, zzfkf zzfkf, zzfju zzfju) {
        zzg(listenableFuture, zzfkf, zzfju, false);
    }

    public static void zzb(ListenableFuture listenableFuture, zzfkf zzfkf, zzfju zzfju) {
        zzg(listenableFuture, zzfkf, zzfju, true);
    }

    public static void zzc(ListenableFuture listenableFuture, zzfkf zzfkf, zzfju zzfju) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzgcj.zzr(zzgca.zzu(listenableFuture), new zzfkd(zzfkf, zzfju), zzbzo.zzf);
        }
    }

    public static void zzd(ListenableFuture listenableFuture, zzfju zzfju) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzgcj.zzr(zzgca.zzu(listenableFuture), new zzfkb(zzfju), zzbzo.zzf);
        }
    }

    public static boolean zze(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.matches((String) zzba.zzc().zza(zzbbw.zzhU), str);
    }

    public static int zzf(zzffg zzffg) {
        int zzf = zzq.zzf(zzffg) - 1;
        if (zzf == 0 || zzf == 1) {
            return 7;
        }
        return 23;
    }

    private static void zzg(ListenableFuture listenableFuture, zzfkf zzfkf, zzfju zzfju, boolean z) {
        if (((Boolean) zzbdl.zzc.zze()).booleanValue()) {
            zzgcj.zzr(zzgca.zzu(listenableFuture), new zzfkc(zzfkf, zzfju, z), zzbzo.zzf);
        }
    }
}
