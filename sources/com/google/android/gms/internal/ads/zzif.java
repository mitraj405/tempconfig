package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzif {
    final Context zza;
    zzdj zzb = zzdj.zza;
    zzfvk zzc;
    zzfvk zzd;
    zzfvk zze;
    zzfvk zzf;
    zzfvk zzg;
    zzful zzh;
    Looper zzi = zzet.zzy();
    int zzj = -1000;
    zzh zzk = zzh.zza;
    int zzl = 1;
    boolean zzm = true;
    zzlj zzn = zzlj.zzb;
    long zzo = 500;
    long zzp = 2000;
    boolean zzq = true;
    boolean zzr;
    String zzs = "";
    zzhq zzt = new zzhq(0.97f, 1.03f, 1000, 1.0E-7f, zzet.zzr(20), zzet.zzr(500), 0.999f, (zzhp) null);

    public zzif(Context context, zzcdt zzcdt) {
        Context context2 = context;
        zzhy zzhy = new zzhy(zzcdt);
        zzhz zzhz = new zzhz(context2);
        zzia zzia = new zzia(context2);
        zzib zzib = new zzib();
        zzic zzic = new zzic(context2);
        zzid zzid = new zzid();
        context.getClass();
        this.zza = context2;
        this.zzc = zzhy;
        this.zzd = zzhz;
        this.zze = zzia;
        this.zzf = zzib;
        this.zzg = zzic;
        this.zzh = zzid;
    }

    public static /* synthetic */ zzuh zza(Context context) {
        return new zztv(context, new zzacd());
    }
}
