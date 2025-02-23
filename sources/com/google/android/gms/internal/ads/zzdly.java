package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdly implements zzcfz {
    public final /* synthetic */ zzbzs zza;

    public /* synthetic */ zzdly(zzbzs zzbzs) {
        this.zza = zzbzs;
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzbzs zzbzs = this.zza;
        if (z) {
            zzbzs.zzb();
            return;
        }
        zzbzs.zzd(new zzeir(1, "Image Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
