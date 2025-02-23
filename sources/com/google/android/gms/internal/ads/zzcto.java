package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzbbc;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcto implements zzcye, zza, zzczo, zzcxk, zzcwq, zzdca {
    private final Clock zza;
    private final zzbyx zzb;

    public zzcto(Clock clock, zzbyx zzbyx) {
        this.zza = clock;
        this.zzb = zzbyx;
    }

    public final void onAdClicked() {
        this.zzb.zzd();
    }

    public final void zza() {
        this.zzb.zze();
    }

    public final void zzdo(zzfex zzfex) {
        this.zzb.zzk(this.zza.elapsedRealtime());
    }

    public final String zzg() {
        return this.zzb.zzc();
    }

    public final void zzi(zzbbc.zzb zzb2) {
        this.zzb.zzi();
    }

    public final void zzk(zzl zzl) {
        this.zzb.zzj(zzl);
    }

    public final void zzm(zzbbc.zzb zzb2) {
        this.zzb.zzg();
    }

    public final void zzr() {
        this.zzb.zzf();
    }

    public final void zzs() {
        this.zzb.zzh(true);
    }

    public final void zzb() {
    }

    public final void zzc() {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    public final void zzh() {
    }

    public final void zzdn(zzbvb zzbvb) {
    }

    public final void zzj(zzbbc.zzb zzb2) {
    }

    public final void zzl(boolean z) {
    }

    public final void zzn(boolean z) {
    }

    public final void zzds(zzbvn zzbvn, String str, String str2) {
    }
}
