package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfdo implements OnAdMetadataChangedListener, zzcye, zzcwt, zzcwq, zzcxg, zzczb, zzfbz, zzdeq {
    private final zzfgq zza;
    private final AtomicReference zzb = new AtomicReference();
    private final AtomicReference zzc = new AtomicReference();
    private final AtomicReference zzd = new AtomicReference();
    private final AtomicReference zze = new AtomicReference();
    private final AtomicReference zzf = new AtomicReference();
    private final AtomicReference zzg = new AtomicReference();
    private final AtomicReference zzh = new AtomicReference();

    public zzfdo(zzfgq zzfgq) {
        this.zza = zzfgq;
    }

    public final void onAdMetadataChanged() {
        zzfbq.zza(this.zzb, new zzfdc());
    }

    public final void zza() {
        this.zza.zza();
        zzfbq.zza(this.zzd, new zzfdk());
        zzfbq.zza(this.zze, new zzfdl());
    }

    public final void zzb() {
        zzfbq.zza(this.zze, new zzfdm());
    }

    public final void zzc() {
        zzfbq.zza(this.zzd, new zzfcw());
        zzfbq.zza(this.zze, new zzfcx());
        zzfbq.zza(this.zzd, new zzfcy());
    }

    public final void zzdB(zze zze2) {
        int i = zze2.zza;
        zzfbq.zza(this.zzc, new zzfdh(zze2));
        zzfbq.zza(this.zzc, new zzfdi(i));
        zzfbq.zza(this.zze, new zzfdj(i));
    }

    public final void zzdG() {
        zzfbq.zza(this.zzd, new zzfdd());
    }

    public final void zzds(zzbvn zzbvn, String str, String str2) {
        zzfbq.zza(this.zzd, new zzfdn(zzbvn));
        zzfbq.zza(this.zzf, new zzfct(zzbvn, str, str2));
        zzfbq.zza(this.zze, new zzfcu(zzbvn));
        zzfbq.zza(this.zzg, new zzfcv(zzbvn, str, str2));
    }

    public final void zze() {
        zzfbq.zza(this.zze, new zzfdg());
    }

    public final void zzf() {
        zzfbq.zza(this.zze, new zzfcs());
    }

    public final void zzg(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzb.set(onAdMetadataChangedListener);
    }

    public final void zzh(zzs zzs) {
        zzfbq.zza(this.zzh, new zzfcz(zzs));
    }

    public final void zzi(zzdg zzdg) {
        this.zzh.set(zzdg);
    }

    public final void zzj(zzbwj zzbwj) {
        this.zzd.set(zzbwj);
    }

    public final void zzk(zzbwn zzbwn) {
        this.zzc.set(zzbwn);
    }

    public final void zzl(zzfbz zzfbz) {
        throw null;
    }

    @Deprecated
    public final void zzm(zzbvt zzbvt) {
        this.zze.set(zzbvt);
    }

    @Deprecated
    public final void zzn(zzbvo zzbvo) {
        this.zzg.set(zzbvo);
    }

    public final void zzo(zzbwo zzbwo) {
        this.zzf.set(zzbwo);
    }

    public final void zzq(zze zze2) {
        zzfbq.zza(this.zzd, new zzfde(zze2));
        zzfbq.zza(this.zzd, new zzfdf(zze2));
    }

    public final void zzs() {
        zzfbq.zza(this.zzc, new zzfda());
        zzfbq.zza(this.zze, new zzfdb());
    }

    public final void zzdf() {
    }
}
