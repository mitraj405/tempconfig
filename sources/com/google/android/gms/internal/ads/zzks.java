package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzks implements zzus, zzre {
    final /* synthetic */ zzkw zza;
    private final zzku zzb;

    public zzks(zzkw zzkw, zzku zzku) {
        this.zza = zzkw;
        this.zzb = zzku;
    }

    private final Pair zzf(int i, zzui zzui) {
        zzui zzui2;
        zzui zzui3 = null;
        if (zzui != null) {
            zzku zzku = this.zzb;
            int i2 = 0;
            while (true) {
                if (i2 >= zzku.zzc.size()) {
                    zzui2 = null;
                    break;
                } else if (((zzui) zzku.zzc.get(i2)).zzd == zzui.zzd) {
                    zzui2 = zzui.zza(Pair.create(zzku.zzb, zzui.zza));
                    break;
                } else {
                    i2++;
                }
            }
            if (zzui2 == null) {
                return null;
            }
            zzui3 = zzui2;
        }
        return Pair.create(Integer.valueOf(this.zzb.zzd), zzui3);
    }

    public final void zzae(int i, zzui zzui, zzue zzue) {
        Pair zzf = zzf(0, zzui);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzkq(this, zzf, zzue));
        }
    }

    public final void zzaf(int i, zzui zzui, zztz zztz, zzue zzue) {
        Pair zzf = zzf(0, zzui);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzko(this, zzf, zztz, zzue));
        }
    }

    public final void zzag(int i, zzui zzui, zztz zztz, zzue zzue) {
        Pair zzf = zzf(0, zzui);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzkr(this, zzf, zztz, zzue));
        }
    }

    public final void zzah(int i, zzui zzui, zztz zztz, zzue zzue, IOException iOException, boolean z) {
        Pair zzf = zzf(0, zzui);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzkn(this, zzf, zztz, zzue, iOException, z));
        }
    }

    public final void zzai(int i, zzui zzui, zztz zztz, zzue zzue) {
        Pair zzf = zzf(0, zzui);
        if (zzf != null) {
            this.zza.zzi.zzh(new zzkp(this, zzf, zztz, zzue));
        }
    }
}
