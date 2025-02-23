package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzxu {
    public final zzcd zza;
    public final int[] zzb;

    public zzxu(zzcd zzcd, int[] iArr, int i) {
        if (iArr.length == 0) {
            zzea.zzd("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
        }
        this.zza = zzcd;
        this.zzb = iArr;
    }
}
