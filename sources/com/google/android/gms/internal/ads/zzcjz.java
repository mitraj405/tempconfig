package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcjz implements zzfee {
    private final zzcif zza;
    private Context zzb;
    private String zzc;

    public /* synthetic */ zzcjz(zzcif zzcif, zzcjy zzcjy) {
        this.zza = zzcif;
    }

    public final /* synthetic */ zzfee zza(String str) {
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzfee zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzfef zzc() {
        zzhfk.zzc(this.zzb, Context.class);
        return new zzckb(this.zza, this.zzb, this.zzc, (zzcka) null);
    }
}
