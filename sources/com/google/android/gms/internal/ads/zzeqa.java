package com.google.android.gms.internal.ads;

import android.os.Bundle;
import in.juspay.hyper.constants.LogSubCategory;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeqa implements zzevn {
    private final double zza;
    private final boolean zzb;

    public zzeqa(double d, boolean z) {
        this.zza = d;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzffu.zza(bundle, LogSubCategory.Context.DEVICE);
        bundle.putBundle(LogSubCategory.Context.DEVICE, zza2);
        Bundle zza3 = zzffu.zza(zza2, "battery");
        zza2.putBundle("battery", zza3);
        zza3.putBoolean("is_charging", this.zzb);
        zza3.putDouble("battery_level", this.zza);
    }
}
