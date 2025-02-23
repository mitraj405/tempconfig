package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfwy extends zzfwl {
    final /* synthetic */ zzfxa zza;
    private final Object zzb;
    private int zzc;

    public zzfwy(zzfxa zzfxa, int i) {
        this.zza = zzfxa;
        this.zzb = zzfxa.zzg(zzfxa, i);
        this.zzc = i;
    }

    private final void zza() {
        int i = this.zzc;
        if (i == -1 || i >= this.zza.size() || !zzfur.zza(this.zzb, zzfxa.zzg(this.zza, this.zzc))) {
            this.zzc = this.zza.zzw(this.zzb);
        }
    }

    public final Object getKey() {
        return this.zzb;
    }

    public final Object getValue() {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.get(this.zzb);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            return null;
        }
        return zzfxa.zzj(this.zza, i);
    }

    public final Object setValue(Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.put(this.zzb, obj);
        }
        zza();
        int i = this.zzc;
        if (i == -1) {
            this.zza.put(this.zzb, obj);
            return null;
        }
        zzfxa zzfxa = this.zza;
        Object zzj = zzfxa.zzj(zzfxa, i);
        zzfxa.zzn(zzfxa, this.zzc, obj);
        return zzj;
    }
}
