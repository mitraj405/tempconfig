package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdpb implements zzcfz {
    public final /* synthetic */ zzbzt zza;

    public /* synthetic */ zzdpb(zzbzt zzbzt) {
        this.zza = zzbzt;
    }

    public final void zza(boolean z, int i, String str, String str2) {
        zzbzt zzbzt = this.zza;
        if (z) {
            zzbzt.zzc((Object) null);
            return;
        }
        zzbzt.zzd(new Exception("Ad Web View failed to load. Error code: " + i + ", Description: " + str + ", Failing URL: " + str2));
    }
}
