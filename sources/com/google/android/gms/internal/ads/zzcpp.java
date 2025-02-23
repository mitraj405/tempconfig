package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzcpp implements zzcye {
    public final /* synthetic */ Context zza;
    public final /* synthetic */ VersionInfoParcel zzb;
    public final /* synthetic */ zzfel zzc;
    public final /* synthetic */ zzffg zzd;

    public /* synthetic */ zzcpp(Context context, VersionInfoParcel versionInfoParcel, zzfel zzfel, zzffg zzffg) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzfel;
        this.zzd = zzffg;
    }

    public final void zzs() {
        zzu.zzs().zzn(this.zza, this.zzb.afmaVersion, this.zzc.zzC.toString(), this.zzd.zzf);
    }
}
