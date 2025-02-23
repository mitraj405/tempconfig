package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdci {
    /* access modifiers changed from: private */
    public final Set zza = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzb = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzc = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzd = new HashSet();
    /* access modifiers changed from: private */
    public final Set zze = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzf = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzg = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzh = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzi = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzj = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzk = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzl = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzm = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzn = new HashSet();
    /* access modifiers changed from: private */
    public zzfbz zzo;

    public final zzdci zza(zza zza2, Executor executor) {
        this.zzc.add(new zzdei(zza2, executor));
        return this;
    }

    public final zzdci zzb(zzcwt zzcwt, Executor executor) {
        this.zzi.add(new zzdei(zzcwt, executor));
        return this;
    }

    public final zzdci zzc(zzcxg zzcxg, Executor executor) {
        this.zzl.add(new zzdei(zzcxg, executor));
        return this;
    }

    public final zzdci zzd(zzcxk zzcxk, Executor executor) {
        this.zzf.add(new zzdei(zzcxk, executor));
        return this;
    }

    public final zzdci zze(zzcwq zzcwq, Executor executor) {
        this.zze.add(new zzdei(zzcwq, executor));
        return this;
    }

    public final zzdci zzf(zzcye zzcye, Executor executor) {
        this.zzh.add(new zzdei(zzcye, executor));
        return this;
    }

    public final zzdci zzg(zzcyp zzcyp, Executor executor) {
        this.zzg.add(new zzdei(zzcyp, executor));
        return this;
    }

    public final zzdci zzh(zzp zzp, Executor executor) {
        this.zzn.add(new zzdei(zzp, executor));
        return this;
    }

    public final zzdci zzi(zzczb zzczb, Executor executor) {
        this.zzm.add(new zzdei(zzczb, executor));
        return this;
    }

    public final zzdci zzj(zzczo zzczo, Executor executor) {
        this.zzb.add(new zzdei(zzczo, executor));
        return this;
    }

    public final zzdci zzk(AppEventListener appEventListener, Executor executor) {
        this.zzk.add(new zzdei(appEventListener, executor));
        return this;
    }

    public final zzdci zzl(zzdeq zzdeq, Executor executor) {
        this.zzd.add(new zzdei(zzdeq, executor));
        return this;
    }

    public final zzdci zzm(zzfbz zzfbz) {
        this.zzo = zzfbz;
        return this;
    }

    public final zzdck zzn() {
        return new zzdck(this, (zzdcj) null);
    }
}
