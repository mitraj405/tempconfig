package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaax {
    private final Handler zza;
    private final zzaay zzb;

    public zzaax(Handler handler, zzaay zzaay) {
        this.zza = zzaay == null ? null : handler;
        this.zzb = zzaay;
    }

    public final void zza(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaan(this, str, j, j2));
        }
    }

    public final void zzb(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaaw(this, str));
        }
    }

    public final void zzc(zzhn zzhn) {
        zzhn.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaav(this, zzhn));
        }
    }

    public final void zzd(int i, long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaap(this, i, j));
        }
    }

    public final void zze(zzhn zzhn) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaat(this, zzhn));
        }
    }

    public final void zzf(zzaf zzaf, zzho zzho) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaau(this, zzaf, zzho));
        }
    }

    public final /* synthetic */ void zzg(String str, long j, long j2) {
        int i = zzet.zza;
        this.zzb.zzp(str, j, j2);
    }

    public final /* synthetic */ void zzh(String str) {
        int i = zzet.zza;
        this.zzb.zzq(str);
    }

    public final /* synthetic */ void zzi(zzhn zzhn) {
        zzhn.zza();
        int i = zzet.zza;
        this.zzb.zzr(zzhn);
    }

    public final /* synthetic */ void zzj(int i, long j) {
        int i2 = zzet.zza;
        this.zzb.zzl(i, j);
    }

    public final /* synthetic */ void zzk(zzhn zzhn) {
        int i = zzet.zza;
        this.zzb.zzs(zzhn);
    }

    public final /* synthetic */ void zzl(zzaf zzaf, zzho zzho) {
        int i = zzet.zza;
        this.zzb.zzu(zzaf, zzho);
    }

    public final /* synthetic */ void zzm(Object obj, long j) {
        int i = zzet.zza;
        this.zzb.zzm(obj, j);
    }

    public final /* synthetic */ void zzn(long j, int i) {
        int i2 = zzet.zza;
        this.zzb.zzt(j, i);
    }

    public final /* synthetic */ void zzo(Exception exc) {
        int i = zzet.zza;
        this.zzb.zzo(exc);
    }

    public final /* synthetic */ void zzp(zzcp zzcp) {
        int i = zzet.zza;
        this.zzb.zzv(zzcp);
    }

    public final void zzq(Object obj) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaaq(this, obj, SystemClock.elapsedRealtime()));
        }
    }

    public final void zzr(long j, int i) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaar(this, j, i));
        }
    }

    public final void zzs(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaas(this, exc));
        }
    }

    public final void zzt(zzcp zzcp) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzaao(this, zzcp));
        }
    }
}
