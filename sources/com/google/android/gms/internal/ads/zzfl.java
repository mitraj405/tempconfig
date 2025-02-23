package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzfl implements zzfs {
    private final boolean zza;
    private final ArrayList zzb = new ArrayList(1);
    private int zzc;
    private zzfy zzd;

    public zzfl(boolean z) {
        this.zza = z;
    }

    public /* synthetic */ Map zze() {
        return Collections.emptyMap();
    }

    public final void zzf(zzgu zzgu) {
        zzgu.getClass();
        if (!this.zzb.contains(zzgu)) {
            this.zzb.add(zzgu);
            this.zzc++;
        }
    }

    public final void zzg(int i) {
        zzfy zzfy = this.zzd;
        int i2 = zzet.zza;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            ((zzgu) this.zzb.get(i3)).zza(this, zzfy, this.zza, i);
        }
    }

    public final void zzh() {
        zzfy zzfy = this.zzd;
        int i = zzet.zza;
        for (int i2 = 0; i2 < this.zzc; i2++) {
            ((zzgu) this.zzb.get(i2)).zzb(this, zzfy, this.zza);
        }
        this.zzd = null;
    }

    public final void zzi(zzfy zzfy) {
        for (int i = 0; i < this.zzc; i++) {
            ((zzgu) this.zzb.get(i)).zzc(this, zzfy, this.zza);
        }
    }

    public final void zzj(zzfy zzfy) {
        this.zzd = zzfy;
        for (int i = 0; i < this.zzc; i++) {
            ((zzgu) this.zzb.get(i)).zzd(this, zzfy, this.zza);
        }
    }
}
