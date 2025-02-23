package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbbc;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzecg implements zzfio {
    public final /* synthetic */ zzech zza;
    public final /* synthetic */ long zzb;

    public /* synthetic */ zzecg(zzech zzech, long j) {
        this.zza = zzech;
        this.zzb = j;
    }

    public final Object zza(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (this.zza.zzf()) {
            return null;
        }
        long j = this.zzb;
        zzbbc.zzaf.zza.C0036zza zzn = zzbbc.zzaf.zza.zzn();
        zzn.zzP(j);
        byte[] zzaV = ((zzbbc.zzaf.zza) zzn.zzbr()).zzaV();
        zzeco.zzf(sQLiteDatabase, false, false);
        zzeco.zzc(sQLiteDatabase, j, zzaV);
        return null;
    }
}
