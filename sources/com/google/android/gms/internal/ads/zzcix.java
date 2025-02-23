package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcix implements zzfaz {
    private final zzcif zza;
    private Context zzb;
    private String zzc;
    private zzq zzd;

    public /* synthetic */ zzcix(zzcif zzcif, zzciw zzciw) {
        this.zza = zzcif;
    }

    public final /* synthetic */ zzfaz zza(zzq zzq) {
        zzq.getClass();
        this.zzd = zzq;
        return this;
    }

    public final /* synthetic */ zzfaz zzb(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzfaz zzc(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzfba zzd() {
        zzhfk.zzc(this.zzb, Context.class);
        zzhfk.zzc(this.zzc, String.class);
        zzhfk.zzc(this.zzd, zzq.class);
        return new zzciz(this.zza, this.zzb, this.zzc, this.zzd, (zzciy) null);
    }
}
