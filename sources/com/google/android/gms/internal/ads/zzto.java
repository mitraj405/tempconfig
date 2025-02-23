package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzto implements zzus, zzre {
    final /* synthetic */ zztq zza;
    private final Object zzb;
    private zzur zzc;
    private zzrd zzd;

    public zzto(zztq zztq, Object obj) {
        this.zza = zztq;
        this.zzc = zztq.zze((zzui) null);
        this.zzd = zztq.zzc((zzui) null);
        this.zzb = obj;
    }

    private final zzue zzf(zzue zzue, zzui zzui) {
        zztq zztq = this.zza;
        Object obj = this.zzb;
        long j = zzue.zzc;
        zztq.zzx(obj, j, zzui);
        zztq zztq2 = this.zza;
        Object obj2 = this.zzb;
        long j2 = zzue.zzd;
        zztq2.zzx(obj2, j2, zzui);
        if (j == zzue.zzc && j2 == zzue.zzd) {
            return zzue;
        }
        return new zzue(1, zzue.zza, zzue.zzb, 0, (Object) null, j, j2);
    }

    private final boolean zzg(int i, zzui zzui) {
        zzui zzui2;
        if (zzui != null) {
            zzui2 = this.zza.zzy(this.zzb, zzui);
            if (zzui2 == null) {
                return false;
            }
        } else {
            zzui2 = null;
        }
        this.zza.zzw(this.zzb, 0);
        zzur zzur = this.zzc;
        int i2 = zzur.zza;
        if (!zzet.zzG(zzur.zzb, zzui2)) {
            this.zzc = this.zza.zzf(0, zzui2);
        }
        zzrd zzrd = this.zzd;
        int i3 = zzrd.zza;
        if (zzet.zzG(zzrd.zzb, zzui2)) {
            return true;
        }
        this.zzd = this.zza.zzd(0, zzui2);
        return true;
    }

    public final void zzae(int i, zzui zzui, zzue zzue) {
        if (zzg(0, zzui)) {
            this.zzc.zzc(zzf(zzue, zzui));
        }
    }

    public final void zzaf(int i, zzui zzui, zztz zztz, zzue zzue) {
        if (zzg(0, zzui)) {
            this.zzc.zzd(zztz, zzf(zzue, zzui));
        }
    }

    public final void zzag(int i, zzui zzui, zztz zztz, zzue zzue) {
        if (zzg(0, zzui)) {
            this.zzc.zze(zztz, zzf(zzue, zzui));
        }
    }

    public final void zzah(int i, zzui zzui, zztz zztz, zzue zzue, IOException iOException, boolean z) {
        if (zzg(0, zzui)) {
            this.zzc.zzf(zztz, zzf(zzue, zzui), iOException, z);
        }
    }

    public final void zzai(int i, zzui zzui, zztz zztz, zzue zzue) {
        if (zzg(0, zzui)) {
            this.zzc.zzg(zztz, zzf(zzue, zzui));
        }
    }
}
