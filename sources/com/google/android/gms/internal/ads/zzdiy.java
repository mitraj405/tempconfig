package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdiy {
    private zzbfa zza;

    public zzdiy(zzdik zzdik) {
        this.zza = zzdik;
    }

    public final synchronized zzbfa zza() {
        return this.zza;
    }

    public final synchronized void zzb(zzbfa zzbfa) {
        this.zza = zzbfa;
    }
}
