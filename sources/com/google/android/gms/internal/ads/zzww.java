package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzww implements zzxo {
    public final /* synthetic */ zzxt zza;
    public final /* synthetic */ zzxi zzb;
    public final /* synthetic */ boolean zzc;
    public final /* synthetic */ int[] zzd;

    public /* synthetic */ zzww(zzxt zzxt, zzxi zzxi, boolean z, int[] iArr) {
        this.zza = zzxt;
        this.zzb = zzxi;
        this.zzc = z;
        this.zzd = iArr;
    }

    public final List zza(int i, zzcd zzcd, int[] iArr) {
        zzwt zzwt = new zzwt(this.zza);
        int i2 = this.zzd[i];
        zzfxo zzfxo = new zzfxo();
        zzcd zzcd2 = zzcd;
        for (int i3 = 0; i3 < zzcd2.zza; i3++) {
            zzfxo.zzf(new zzxc(i, zzcd, i3, this.zzb, iArr[i3], this.zzc, zzwt, i2));
        }
        return zzfxo.zzi();
    }
}
