package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzzr implements zzabc, zzzj {
    final /* synthetic */ zzzt zza;
    private final Context zzb;
    private final int zzc;
    private final ArrayList zzd;
    private zzaf zze;
    private long zzf;
    private boolean zzg;
    private long zzh;
    private boolean zzi;
    private long zzj;
    private zzaba zzk;
    private Executor zzl;

    public zzzr(zzzt zzzt, Context context) {
        this.zza = zzzt;
        this.zzb = context;
        this.zzc = true != zzet.zzL(context) ? 5 : 1;
        this.zzd = new ArrayList();
        this.zzh = -9223372036854775807L;
        this.zzk = zzaba.zzb;
        this.zzl = zzzt.zza;
    }

    private final void zzl() {
        if (this.zze != null) {
            new ArrayList().addAll(this.zzd);
            zzaf zzaf = this.zze;
            zzaf.getClass();
            zzdi.zzb((Object) null);
            int i = zzaf.zzs;
            zzag zzag = new zzag(zzzt.zzw(zzaf.zzy), zzaf.zzr, i);
            zzag.zza(zzaf.zzv);
            zzag.zzb();
            throw null;
        }
    }

    public final void zza(zzzt zzzt) {
        this.zzl.execute(new zzzq(this, this.zzk));
    }

    public final void zzb(zzzt zzzt) {
        this.zzl.execute(new zzzp(this, this.zzk));
    }

    public final void zzc(zzzt zzzt, zzcp zzcp) {
        this.zzl.execute(new zzzo(this, this.zzk, zzcp));
    }

    public final long zzd(long j, boolean z) {
        zzdi.zzf(false);
        long j2 = this.zzj;
        if (j2 != -9223372036854775807L) {
            if (!zzzt.zzv(this.zza, j2)) {
                return -9223372036854775807L;
            }
            zzl();
            this.zzj = -9223372036854775807L;
        }
        zzdi.zzb((Object) null);
        throw null;
    }

    public final void zze() {
        this.zzi = false;
        this.zzh = -9223372036854775807L;
        zzzt.zzn(this.zza);
    }

    public final void zzf(int i, zzaf zzaf) {
        boolean z = false;
        zzdi.zzf(false);
        this.zza.zzd.zzk(zzaf.zzt);
        int i2 = zzet.zza;
        this.zze = zzaf;
        if (!this.zzi) {
            zzl();
            this.zzi = true;
            this.zzj = -9223372036854775807L;
            return;
        }
        if (this.zzh != -9223372036854775807L) {
            z = true;
        }
        zzdi.zzf(z);
        this.zzj = this.zzh;
    }

    public final void zzg(long j, long j2) throws zzabb {
        try {
            this.zza.zzt(j, j2);
        } catch (zzhw e) {
            zzaf zzaf = this.zze;
            if (zzaf == null) {
                zzaf = new zzad().zzad();
            }
            throw new zzabb(e, zzaf);
        }
    }

    public final void zzh(zzaba zzaba, Executor executor) {
        this.zzk = zzaba;
        this.zzl = executor;
    }

    public final void zzi(long j) {
        boolean z;
        if (this.zzf != j) {
            z = true;
        } else {
            z = false;
        }
        this.zzg = z;
        this.zzf = j;
    }

    public final void zzj(List list) {
        this.zzd.clear();
        this.zzd.addAll(list);
        zzl();
    }

    public final boolean zzk() {
        return zzet.zzL(this.zzb);
    }
}
