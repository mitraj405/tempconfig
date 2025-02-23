package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzzt implements zzabd, zzco {
    /* access modifiers changed from: private */
    public static final Executor zza = new zzzd();
    private final Context zzb;
    private final zzzr zzc;
    /* access modifiers changed from: private */
    public final zzaah zzd;
    private final zzaam zze;
    private final zzbx zzf;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet zzg;
    /* access modifiers changed from: private */
    public zzdj zzh;
    /* access modifiers changed from: private */
    public zzaf zzi;
    /* access modifiers changed from: private */
    public zzaae zzj;
    private zzdt zzk;
    /* access modifiers changed from: private */
    public Pair zzl;
    private int zzm;
    private int zzn = 0;

    public /* synthetic */ zzzt(zzzg zzzg, zzzs zzzs) {
        Context zza2 = zzzg.zza;
        this.zzb = zza2;
        zzzr zzzr = new zzzr(this, zza2);
        this.zzc = zzzr;
        zzaah zzd2 = zzzg.zzb;
        this.zzd = zzd2;
        this.zze = new zzaam(new zzzi(this, (zzzh) null), zzd2);
        zzbx zzb2 = zzzg.zzd;
        zzdi.zzb(zzb2);
        this.zzf = zzb2;
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        this.zzg = copyOnWriteArraySet;
        copyOnWriteArraySet.add(zzzr);
    }

    public static /* bridge */ /* synthetic */ zzcn zzd(zzzt zzzt, zzaf zzaf, zzdj zzdj) {
        boolean z;
        if (zzzt.zzn == 0) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zzf(z);
        zzzt.zzh = zzdj;
        Looper myLooper = Looper.myLooper();
        zzdi.zzb(myLooper);
        zzzt.zzk = zzdj.zzb(myLooper, (Handler.Callback) null);
        zzo zzw = zzw(zzaf.zzy);
        if (zzw.zzd == 7 && zzet.zza < 34) {
            zzm zzc2 = zzw.zzc();
            zzc2.zzd(6);
            zzw = zzc2.zzg();
        }
        zzo zzo = zzw;
        try {
            zzbx zzbx = zzzt.zzf;
            Context context = zzzt.zzb;
            zzr zzr = zzr.zza;
            zzdt zzdt = zzzt.zzk;
            Objects.requireNonNull(zzdt);
            zzbx.zza(context, zzo, zzr, zzzt, new zzze(zzdt), zzfxr.zzm(), 0);
            Pair pair = zzzt.zzl;
            if (pair != null) {
                Surface surface = (Surface) pair.first;
                zzel zzel = (zzel) pair.second;
                zzel.zzb();
                zzel.zza();
            }
            throw null;
        } catch (zzcl e) {
            throw new zzabb(e, zzaf);
        }
    }

    public static /* synthetic */ void zzl(zzzt zzzt) {
        int i = zzzt.zzm - 1;
        zzzt.zzm = i;
        if (i <= 0) {
            if (i >= 0) {
                zzzt.zze.zza();
                return;
            }
            throw new IllegalStateException(String.valueOf(i));
        }
    }

    public static /* bridge */ /* synthetic */ void zzn(zzzt zzzt) {
        if (zzzt.zzn == 1) {
            zzzt.zzm++;
            zzzt.zze.zza();
            zzdt zzdt = zzzt.zzk;
            zzdi.zzb(zzdt);
            zzdt.zzh(new zzzf(zzzt));
        }
    }

    public static /* bridge */ /* synthetic */ boolean zzv(zzzt zzzt, long j) {
        if (zzzt.zzm != 0 || !zzzt.zze.zze(j)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static zzo zzw(zzo zzo) {
        if (zzo == null || !zzo.zzf()) {
            return zzo.zza;
        }
        return zzo;
    }

    public final zzaah zzh() {
        return this.zzd;
    }

    public final zzabc zzi() {
        return this.zzc;
    }

    public final void zzr() {
        zzel zzel = zzel.zza;
        zzel.zzb();
        zzel.zza();
        this.zzl = null;
    }

    public final void zzs() {
        if (this.zzn != 2) {
            zzdt zzdt = this.zzk;
            if (zzdt != null) {
                zzdt.zze((Object) null);
            }
            this.zzl = null;
            this.zzn = 2;
        }
    }

    public final void zzt(long j, long j2) throws zzhw {
        if (this.zzm == 0) {
            this.zze.zzc(j, j2);
        }
    }

    public final void zzu(Surface surface, zzel zzel) {
        Pair pair = this.zzl;
        if (pair == null || !((Surface) pair.first).equals(surface) || !((zzel) this.zzl.second).equals(zzel)) {
            this.zzl = Pair.create(surface, zzel);
        }
    }
}
