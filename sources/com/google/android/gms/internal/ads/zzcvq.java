package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcvq implements zzcye, zzcxl {
    private final zzfel zza;

    public zzcvq(Context context, zzfel zzfel, zzbss zzbss) {
        this.zza = zzfel;
    }

    public final void zzs() {
        zzbst zzbst = this.zza.zzad;
        if (zzbst != null && zzbst.zza) {
            ArrayList arrayList = new ArrayList();
            if (!this.zza.zzad.zzb.isEmpty()) {
                arrayList.add(this.zza.zzad.zzb);
            }
        }
    }

    public final void zzdj(Context context) {
    }

    public final void zzdl(Context context) {
    }

    public final void zzdm(Context context) {
    }
}
