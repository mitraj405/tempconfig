package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcvb implements zzczo, zzdfc {
    private final Context zza;
    private final zzffg zzb;
    private final VersionInfoParcel zzc;
    private final zzg zzd;
    private final zzdun zze;
    private final zzfki zzf;

    public zzcvb(Context context, zzffg zzffg, VersionInfoParcel versionInfoParcel, zzg zzg, zzdun zzdun, zzfki zzfki) {
        this.zza = context;
        this.zzb = zzffg;
        this.zzc = versionInfoParcel;
        this.zzd = zzg;
        this.zze = zzdun;
        this.zzf = zzfki;
    }

    private final void zzc() {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdC)).booleanValue()) {
            zzg zzg = this.zzd;
            Context context = this.zza;
            VersionInfoParcel versionInfoParcel = this.zzc;
            zzffg zzffg = this.zzb;
            zzfki zzfki = this.zzf;
            zzu.zza().zzc(context, versionInfoParcel, zzffg.zzf, zzg.zzh(), zzfki);
        }
        this.zze.zzr();
    }

    public final void zzdn(zzbvb zzbvb) {
        zzc();
    }

    public final void zze(zzay zzay) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzdD)).booleanValue()) {
            zzc();
        }
    }

    public final void zzdo(zzfex zzfex) {
    }

    public final void zzf(String str) {
    }
}
