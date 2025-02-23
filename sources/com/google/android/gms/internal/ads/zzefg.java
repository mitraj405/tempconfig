package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzefg implements zzdgx {
    private final VersionInfoParcel zza;
    private final ListenableFuture zzb;
    private final zzfel zzc;
    private final zzcej zzd;
    private final zzffg zze;
    private final zzbja zzf;
    private final boolean zzg;
    private final zzeds zzh;

    public zzefg(VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfel zzfel, zzcej zzcej, zzffg zzffg, boolean z, zzbja zzbja, zzeds zzeds) {
        this.zza = versionInfoParcel;
        this.zzb = listenableFuture;
        this.zzc = zzfel;
        this.zzd = zzcej;
        this.zze = zzffg;
        this.zzg = z;
        this.zzf = zzbja;
        this.zzh = zzeds;
    }

    public final void zza(boolean z, Context context, zzcxd zzcxd) {
        boolean z2;
        boolean z3;
        float f;
        zzeds zzeds;
        zzcov zzcov = (zzcov) zzgcj.zzq(this.zzb);
        this.zzd.zzaq(true);
        if (this.zzg) {
            z2 = this.zzf.zze(true);
        } else {
            z2 = true;
        }
        boolean z4 = this.zzg;
        if (z4) {
            z3 = this.zzf.zzd();
        } else {
            z3 = false;
        }
        boolean z5 = z3;
        if (z4) {
            f = this.zzf.zza();
        } else {
            f = 0.0f;
        }
        zzk zzk = new zzk(z2, true, z5, f, -1, z, this.zzc.zzO, false);
        if (zzcxd != null) {
            zzcxd.zzf();
        }
        zzu.zzi();
        zzdgm zzg2 = zzcov.zzg();
        zzcej zzcej = this.zzd;
        int i = this.zzc.zzQ;
        if (i == -1) {
            zzw zzw = this.zze.zzj;
            if (zzw != null) {
                int i2 = zzw.zza;
                if (i2 == 1) {
                    i = 7;
                } else if (i2 == 2) {
                    i = 6;
                }
            }
            zzm.zze("Error setting app open orientation; no targeting orientation available.");
            i = this.zzc.zzQ;
        }
        int i3 = i;
        VersionInfoParcel versionInfoParcel = this.zza;
        zzfel zzfel = this.zzc;
        String str = zzfel.zzB;
        zzfeq zzfeq = zzfel.zzs;
        String str2 = zzfeq.zzb;
        String str3 = zzfeq.zza;
        zzffg zzffg = this.zze;
        if (zzfel.zzai) {
            zzeds = this.zzh;
        } else {
            zzeds = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zza) null, (zzp) zzg2, (zzaa) null, zzcej, i3, versionInfoParcel, str, zzk, str2, str3, zzffg.zzf, zzcxd, (zzbsg) zzeds);
        zzn.zza(context, adOverlayInfoParcel, true);
    }
}
