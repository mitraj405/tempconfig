package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
final class zzbrx extends zzbgg {
    final /* synthetic */ zzbsa zza;

    public /* synthetic */ zzbrx(zzbsa zzbsa, zzbrw zzbrw) {
        this.zza = zzbsa;
    }

    public final void zze(zzbfx zzbfx, String str) {
        zzbsa zzbsa = this.zza;
        if (zzbsa.zzb != null) {
            zzbsa.zzb.onCustomClick(zzbsa.zzf(zzbfx), str);
        }
    }
}
