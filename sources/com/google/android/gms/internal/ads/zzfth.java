package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfth extends zzfsk {
    final /* synthetic */ zzfti zza;
    private final zzftn zzb;

    public zzfth(zzfti zzfti, zzftn zzftn) {
        this.zza = zzfti;
        this.zzb = zzftn;
    }

    public final void zzb(Bundle bundle) {
        int i = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        zzftl zzc = zzftm.zzc();
        zzc.zzb(i);
        if (string != null) {
            zzc.zza(string);
        }
        this.zzb.zza(zzc.zzc());
        if (i == 8157) {
            this.zza.zza();
        }
    }
}
