package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeoy implements zzevn {
    private final zzw zza;
    private final VersionInfoParcel zzb;
    private final boolean zzc;

    public zzeoy(zzw zzw, VersionInfoParcel versionInfoParcel, boolean z) {
        this.zza = zzw;
        this.zzb = versionInfoParcel;
        this.zzc = z;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzb.clientJarVersion >= ((Integer) zzba.zzc().zza(zzbbw.zzeK)).intValue()) {
            bundle.putString("app_open_version", C0515Ga.FARE_ONLY);
        }
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeL)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzc);
        }
        zzw zzw = this.zza;
        if (zzw != null) {
            int i = zzw.zza;
            if (i == 1) {
                bundle.putString("avo", "p");
            } else if (i == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
