package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhfp {
    private final List zza;
    private final List zzb;

    public /* synthetic */ zzhfp(int i, int i2, zzhfo zzhfo) {
        this.zza = zzhez.zzc(i);
        this.zzb = zzhez.zzc(i2);
    }

    public final zzhfp zza(zzhfl zzhfl) {
        this.zzb.add(zzhfl);
        return this;
    }

    public final zzhfp zzb(zzhfl zzhfl) {
        this.zza.add(zzhfl);
        return this;
    }

    public final zzhfq zzc() {
        return new zzhfq(this.zza, this.zzb, (zzhfo) null);
    }
}
