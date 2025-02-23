package com.google.android.gms.internal.ads;

import android.os.Bundle;
import in.juspay.hyper.constants.LogSubCategory;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzetc implements zzevn {
    public final Bundle zza;

    public zzetc(Bundle bundle) {
        this.zza = bundle;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzffu.zza(bundle, LogSubCategory.Context.DEVICE);
        zza2.putBundle("android_mem_info", this.zza);
        bundle.putBundle(LogSubCategory.Context.DEVICE, zza2);
    }
}
