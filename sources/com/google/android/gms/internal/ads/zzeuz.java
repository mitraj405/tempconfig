package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeuz implements zzevo {
    private final zzbya zza;
    private final zzgcu zzb;
    private final Context zzc;

    public zzeuz(zzbya zzbya, zzgcu zzgcu, Context context) {
        this.zza = zzbya;
        this.zzb = zzgcu;
        this.zzc = context;
    }

    public final int zza() {
        return 34;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzeuy(this));
    }

    public final /* synthetic */ zzeva zzc() throws Exception {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        if (!this.zza.zzp(this.zzc)) {
            return new zzeva((String) null, (String) null, (String) null, (String) null, (Long) null);
        }
        String zzd = this.zza.zzd(this.zzc);
        if (zzd == null) {
            str = "";
        } else {
            str = zzd;
        }
        String zzb2 = this.zza.zzb(this.zzc);
        if (zzb2 == null) {
            str2 = "";
        } else {
            str2 = zzb2;
        }
        String zza2 = this.zza.zza(this.zzc);
        if (zza2 == null) {
            str3 = "";
        } else {
            str3 = zza2;
        }
        Long l = null;
        if (true != this.zza.zzp(this.zzc)) {
            str4 = null;
        } else {
            str4 = "fa";
        }
        if ("TIME_OUT".equals(str2)) {
            l = (Long) zzba.zzc().zza(zzbbw.zzaa);
        }
        Long l2 = l;
        if (str4 == null) {
            str5 = "";
        } else {
            str5 = str4;
        }
        return new zzeva(str, str2, str3, str5, l2);
    }
}
