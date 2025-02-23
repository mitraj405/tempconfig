package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeou implements zzevn {
    private final String zza;
    private final boolean zzb;

    public zzeou(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zza != null) {
            Bundle zza2 = zzffu.zza(bundle, "pii");
            zza2.putString("afai", this.zza);
            zza2.putBoolean("is_afai_lat", this.zzb);
        }
    }
}
