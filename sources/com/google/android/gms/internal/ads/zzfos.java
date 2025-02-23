package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfos {
    private final Context zza;
    private final Looper zzb;

    public zzfos(Context context, Looper looper) {
        this.zza = context;
        this.zzb = looper;
    }

    public final void zza(String str) {
        zzfpg zza2 = zzfpi.zza();
        zza2.zza(this.zza.getPackageName());
        zza2.zzc(2);
        zzfpd zza3 = zzfpe.zza();
        zza3.zza(str);
        zza3.zzb(2);
        zza2.zzb(zza3);
        new zzfot(this.zza, this.zzb, (zzfpi) zza2.zzbr()).zza();
    }
}
