package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import in.juspay.hyper.constants.LogSubCategory;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzewb implements zzevn {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final boolean zze;
    public final int zzf;

    public zzewb(String str, int i, int i2, int i3, boolean z, int i4) {
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = z;
        this.zzf = i4;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        boolean z = true;
        zzffu.zzf(bundle, "carrier", this.zza, !TextUtils.isEmpty(this.zza));
        int i = this.zzb;
        if (i == -2) {
            z = false;
        }
        zzffu.zze(bundle, "cnt", i, z);
        bundle.putInt("gnt", this.zzc);
        bundle.putInt("pt", this.zzd);
        Bundle zza2 = zzffu.zza(bundle, LogSubCategory.Context.DEVICE);
        bundle.putBundle(LogSubCategory.Context.DEVICE, zza2);
        Bundle zza3 = zzffu.zza(zza2, LogSubCategory.ApiCall.NETWORK);
        zza2.putBundle(LogSubCategory.ApiCall.NETWORK, zza3);
        zza3.putInt("active_network_state", this.zzf);
        zza3.putBoolean("active_network_metered", this.zze);
    }
}
