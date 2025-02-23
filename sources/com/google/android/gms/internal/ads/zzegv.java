package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzegv implements zzdgx {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ListenableFuture zzc;
    private final zzfel zzd;
    private final zzcej zze;
    private final zzffg zzf;
    private final zzbja zzg;
    private final boolean zzh;
    private final zzeds zzi;

    public zzegv(Context context, VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfel zzfel, zzcej zzcej, zzffg zzffg, boolean z, zzbja zzbja, zzeds zzeds) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = listenableFuture;
        this.zzd = zzfel;
        this.zze = zzcej;
        this.zzf = zzffg;
        this.zzg = zzbja;
        this.zzh = z;
        this.zzi = zzeds;
    }

    public final void zza(boolean z, Context context, zzcxd zzcxd) {
        boolean z2;
        boolean z3;
        float f;
        zzeds zzeds;
        zzdfp zzdfp = (zzdfp) zzgcj.zzq(this.zzc);
        this.zze.zzaq(true);
        if (this.zzh) {
            z2 = this.zzg.zze(false);
        } else {
            z2 = false;
        }
        zzu.zzp();
        Context context2 = this.zza;
        boolean z4 = this.zzh;
        boolean zzI = zzt.zzI(context2);
        if (z4) {
            z3 = this.zzg.zzd();
        } else {
            z3 = false;
        }
        if (this.zzh) {
            f = this.zzg.zza();
        } else {
            f = 0.0f;
        }
        zzk zzk = new zzk(z2, zzI, z3, f, -1, z, this.zzd.zzO, false);
        if (zzcxd != null) {
            zzcxd.zzf();
        }
        zzu.zzi();
        zzdgm zzh2 = zzdfp.zzh();
        zzcej zzcej = this.zze;
        zzfel zzfel = this.zzd;
        VersionInfoParcel versionInfoParcel = this.zzb;
        int i = zzfel.zzQ;
        String str = zzfel.zzB;
        zzfeq zzfeq = zzfel.zzs;
        String str2 = zzfeq.zzb;
        String str3 = zzfeq.zza;
        zzffg zzffg = this.zzf;
        if (zzfel.zzai) {
            zzeds = this.zzi;
        } else {
            zzeds = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zza) null, (zzp) zzh2, (zzaa) null, zzcej, i, versionInfoParcel, str, zzk, str2, str3, zzffg.zzf, zzcxd, (zzbsg) zzeds);
        zzn.zza(context, adOverlayInfoParcel, true);
    }
}
