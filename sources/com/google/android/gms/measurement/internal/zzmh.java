package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzcz;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@22.0.2 */
public final class zzmh extends zze {
    protected final zzmp zza = new zzmp(this);
    protected final zzmn zzb = new zzmn(this);
    /* access modifiers changed from: private */
    public Handler zzc;
    private boolean zzd = true;
    private final zzmm zze = new zzmm(this);

    public zzmh(zzhj zzhj) {
        super(zzhj);
    }

    /* access modifiers changed from: private */
    public final void zzab() {
        zzt();
        if (this.zzc == null) {
            this.zzc = new zzcz(Looper.getMainLooper());
        }
    }

    public final boolean zzaa() {
        zzt();
        return this.zzd;
    }

    public final /* bridge */ /* synthetic */ zzb zzc() {
        return super.zzc();
    }

    public final /* bridge */ /* synthetic */ zzab zzd() {
        return super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzag zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzax zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zzfq zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzfp zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzfr zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfw zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzgh zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzhc zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ zziv zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzks zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzmh zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zznp zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    public final boolean zzz() {
        return false;
    }

    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public static /* synthetic */ void zza(zzmh zzmh, long j) {
        zzmh.zzt();
        zzmh.zzab();
        zzmh.zzj().zzp().zza("Activity paused, time", Long.valueOf(j));
        zzmh.zze.zza(j);
        if (zzmh.zze().zzv()) {
            zzmh.zzb.zzb(j);
        }
    }

    public static /* synthetic */ void zzb(zzmh zzmh, long j) {
        zzmh.zzt();
        zzmh.zzab();
        zzmh.zzj().zzp().zza("Activity resumed, time", Long.valueOf(j));
        if (zzmh.zze().zza(zzbf.zzcg)) {
            if (zzmh.zze().zzv() || zzmh.zzd) {
                zzmh.zzb.zzc(j);
            }
        } else if (zzmh.zze().zzv() || zzmh.zzk().zzn.zza()) {
            zzmh.zzb.zzc(j);
        }
        zzmh.zze.zza();
        zzmp zzmp = zzmh.zza;
        zzmp.zza.zzt();
        if (zzmp.zza.zzu.zzac()) {
            zzmp.zza(zzmp.zza.zzb().currentTimeMillis(), false);
        }
    }

    public final void zza(boolean z) {
        zzt();
        this.zzd = z;
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        return this.zzb.zza(z, z2, j);
    }
}
