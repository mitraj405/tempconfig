package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzeul implements Runnable {
    public final /* synthetic */ zzeup zza;
    public final /* synthetic */ zzbql zzb;
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ List zzd;
    public final /* synthetic */ zzelj zze;
    public final /* synthetic */ zzbzt zzf;

    public /* synthetic */ zzeul(zzeup zzeup, zzbql zzbql, Bundle bundle, List list, zzelj zzelj, zzbzt zzbzt) {
        this.zza = zzeup;
        this.zzb = zzbql;
        this.zzc = bundle;
        this.zzd = list;
        this.zze = zzelj;
        this.zzf = zzbzt;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
