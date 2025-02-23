package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzwu implements zzxo {
    public final /* synthetic */ zzxi zza;

    public /* synthetic */ zzwu(zzxi zzxi) {
        this.zza = zzxi;
    }

    public final List zza(int i, zzcd zzcd, int[] iArr) {
        zzfxo zzfxo = new zzfxo();
        for (int i2 = 0; i2 < zzcd.zza; i2++) {
            zzfxo.zzf(new zzxd(i, zzcd, i2, this.zza, iArr[i2]));
        }
        return zzfxo.zzi();
    }
}
