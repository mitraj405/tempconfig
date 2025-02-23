package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbnx {
    private final zzbna zza;
    private ListenableFuture zzb;

    public zzbnx(zzbna zzbna) {
        this.zza = zzbna;
    }

    private final void zzd() {
        if (this.zzb == null) {
            zzbzt zzbzt = new zzbzt();
            this.zzb = zzbzt;
            this.zza.zzb((zzauo) null).zzj(new zzbnu(zzbzt), new zzbnv(zzbzt));
        }
    }

    public final zzboa zza(String str, zzbnh zzbnh, zzbng zzbng) {
        zzd();
        return new zzboa(this.zzb, "google.afma.activeView.handleUpdate", zzbnh, zzbng);
    }

    public final void zzb(String str, zzbix zzbix) {
        zzd();
        this.zzb = zzgcj.zzn(this.zzb, new zzbnw(str, zzbix), zzbzo.zzf);
    }

    public final void zzc(String str, zzbix zzbix) {
        this.zzb = zzgcj.zzm(this.zzb, new zzbnt(str, zzbix), zzbzo.zzf);
    }
}
