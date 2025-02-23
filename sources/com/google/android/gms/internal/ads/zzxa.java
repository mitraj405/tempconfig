package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzxa implements zzxo {
    public final /* synthetic */ zzxi zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzxa(zzxi zzxi, String str) {
        this.zza = zzxi;
        this.zzb = str;
    }

    public final List zza(int i, zzcd zzcd, int[] iArr) {
        zzfxo zzfxo = new zzfxo();
        for (int i2 = 0; i2 < zzcd.zza; i2++) {
            int i3 = i;
            zzcd zzcd2 = zzcd;
            int i4 = i2;
            zzfxo.zzf(new zzxn(i3, zzcd2, i4, this.zza, iArr[i2], this.zzb));
        }
        return zzfxo.zzi();
    }
}
