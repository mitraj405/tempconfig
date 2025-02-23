package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzecj implements zzfio {
    public final /* synthetic */ zzeck zza;
    public final /* synthetic */ boolean zzb;
    public final /* synthetic */ ArrayList zzc;
    public final /* synthetic */ zzbbc.zzab zzd;
    public final /* synthetic */ zzbbc.zzaf.zzd zze;

    public /* synthetic */ zzecj(zzeck zzeck, boolean z, ArrayList arrayList, zzbbc.zzab zzab, zzbbc.zzaf.zzd zzd2) {
        this.zza = zzeck;
        this.zzb = z;
        this.zzc = arrayList;
        this.zzd = zzab;
        this.zze = zzd2;
    }

    public final Object zza(Object obj) {
        zzeck zzeck = this.zza;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        if (zzeck.zzb.zzf()) {
            return null;
        }
        zzbbc.zzaf.zzd zzd2 = this.zze;
        zzbbc.zzab zzab = this.zzd;
        ArrayList arrayList = this.zzc;
        boolean z = this.zzb;
        byte[] zze2 = zzecl.zze(zzeck.zzb, z, arrayList, zzab, zzd2);
        zzeco.zzf(sQLiteDatabase, z, true);
        zzeco.zzc(sQLiteDatabase, zzeck.zzb.zzf.zzd(), zze2);
        return null;
    }
}
