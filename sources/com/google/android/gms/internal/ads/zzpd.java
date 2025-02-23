package com.google.android.gms.internal.ads;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzpd {
    private final Handler zza;
    private final zzpe zzb;

    public zzpd(Handler handler, zzpe zzpe) {
        this.zza = zzpe == null ? null : handler;
        this.zzb = zzpe;
    }

    public final void zza(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzox(this, exc));
        }
    }

    public final void zzb(Exception exc) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzoy(this, exc));
        }
    }

    public final void zzc(zzpf zzpf) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzov(this, zzpf));
        }
    }

    public final void zzd(zzpf zzpf) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzow(this, zzpf));
        }
    }

    public final void zze(String str, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpb(this, str, j, j2));
        }
    }

    public final void zzf(String str) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpc(this, str));
        }
    }

    public final void zzg(zzhn zzhn) {
        zzhn.zza();
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzos(this, zzhn));
        }
    }

    public final void zzh(zzhn zzhn) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzor(this, zzhn));
        }
    }

    public final void zzi(zzaf zzaf, zzho zzho) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzoz(this, zzaf, zzho));
        }
    }

    public final /* synthetic */ void zzj(Exception exc) {
        int i = zzet.zza;
        this.zzb.zza(exc);
    }

    public final /* synthetic */ void zzk(Exception exc) {
        int i = zzet.zza;
        this.zzb.zzh(exc);
    }

    public final /* synthetic */ void zzl(zzpf zzpf) {
        int i = zzet.zza;
        this.zzb.zzi(zzpf);
    }

    public final /* synthetic */ void zzm(zzpf zzpf) {
        int i = zzet.zza;
        this.zzb.zzj(zzpf);
    }

    public final /* synthetic */ void zzn(String str, long j, long j2) {
        int i = zzet.zza;
        this.zzb.zzb(str, j, j2);
    }

    public final /* synthetic */ void zzo(String str) {
        int i = zzet.zza;
        this.zzb.zzc(str);
    }

    public final /* synthetic */ void zzp(zzhn zzhn) {
        zzhn.zza();
        int i = zzet.zza;
        this.zzb.zzd(zzhn);
    }

    public final /* synthetic */ void zzq(zzhn zzhn) {
        int i = zzet.zza;
        this.zzb.zze(zzhn);
    }

    public final /* synthetic */ void zzr(zzaf zzaf, zzho zzho) {
        int i = zzet.zza;
        this.zzb.zzf(zzaf, zzho);
    }

    public final /* synthetic */ void zzs(long j) {
        int i = zzet.zza;
        this.zzb.zzg(j);
    }

    public final /* synthetic */ void zzt(boolean z) {
        int i = zzet.zza;
        this.zzb.zzn(z);
    }

    public final /* synthetic */ void zzu(int i, long j, long j2) {
        int i2 = zzet.zza;
        this.zzb.zzk(i, j, j2);
    }

    public final void zzv(long j) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzot(this, j));
        }
    }

    public final void zzw(boolean z) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzpa(this, z));
        }
    }

    public final void zzx(int i, long j, long j2) {
        Handler handler = this.zza;
        if (handler != null) {
            handler.post(new zzou(this, i, j, j2));
        }
    }
}
