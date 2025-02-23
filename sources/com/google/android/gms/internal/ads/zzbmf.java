package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbmf implements Runnable {
    public final /* synthetic */ zzbna zza;
    public final /* synthetic */ zzbmz zzb;
    public final /* synthetic */ zzblv zzc;
    public final /* synthetic */ ArrayList zzd;
    public final /* synthetic */ long zze;

    public /* synthetic */ zzbmf(zzbna zzbna, zzbmz zzbmz, zzblv zzblv, ArrayList arrayList, long j) {
        this.zza = zzbna;
        this.zzb = zzbmz;
        this.zzc = zzblv;
        this.zzd = arrayList;
        this.zze = j;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
