package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfss extends zzftl {
    private int zza;
    private String zzb;
    private byte zzc;

    public final zzftl zza(String str) {
        this.zzb = str;
        return this;
    }

    public final zzftl zzb(int i) {
        this.zza = i;
        this.zzc = 1;
        return this;
    }

    public final zzftm zzc() {
        if (this.zzc == 1) {
            return new zzfsu(this.zza, this.zzb, (zzfst) null);
        }
        throw new IllegalStateException("Missing required properties: statusCode");
    }
}
