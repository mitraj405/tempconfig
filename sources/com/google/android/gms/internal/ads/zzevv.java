package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzevv implements zzevn {
    private final int zza;
    private final int zzb;

    public zzevv(int i, int i2) {
        this.zza = i;
        this.zzb = i2;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("sessions_without_flags", this.zza);
        bundle.putInt("crashes_without_flags", this.zzb);
        int i = zzay.zza;
        if (zzba.zzc().zze()) {
            bundle.putBoolean("did_reset", true);
        }
    }
}
