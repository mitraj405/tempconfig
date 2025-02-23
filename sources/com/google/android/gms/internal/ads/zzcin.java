package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcin implements zzezl {
    private final zzcif zza;
    private Context zzb;
    private String zzc;

    public /* synthetic */ zzcin(zzcif zzcif, zzcim zzcim) {
        this.zza = zzcif;
    }

    public final /* synthetic */ zzezl zza(String str) {
        str.getClass();
        this.zzc = str;
        return this;
    }

    public final /* synthetic */ zzezl zzb(Context context) {
        context.getClass();
        this.zzb = context;
        return this;
    }

    public final zzezm zzc() {
        zzhfk.zzc(this.zzb, Context.class);
        zzhfk.zzc(this.zzc, String.class);
        return new zzcip(this.zza, this.zzb, this.zzc, (zzcio) null);
    }
}
