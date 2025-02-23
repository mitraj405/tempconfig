package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdui implements Runnable {
    public final /* synthetic */ zzdun zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbkz zzc;
    public final /* synthetic */ zzfge zzd;
    public final /* synthetic */ List zze;

    public /* synthetic */ zzdui(zzdun zzdun, String str, zzbkz zzbkz, zzfge zzfge, List list) {
        this.zza = zzdun;
        this.zzb = str;
        this.zzc = zzbkz;
        this.zzd = zzfge;
        this.zze = list;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
