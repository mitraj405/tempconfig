package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzecu {
    private final zzbav zza;
    private final Context zzb;
    private final zzebz zzc;
    private final VersionInfoParcel zzd;

    public zzecu(Context context, VersionInfoParcel versionInfoParcel, zzbav zzbav, zzebz zzebz) {
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zza = zzbav;
        this.zzc = zzebz;
    }

    public final /* synthetic */ Void zza(boolean z, SQLiteDatabase sQLiteDatabase) throws Exception {
        int i;
        SQLiteDatabase sQLiteDatabase2 = sQLiteDatabase;
        if (z) {
            this.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            ArrayList arrayList = new ArrayList();
            Cursor query = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            while (query.moveToNext()) {
                try {
                    arrayList.add(zzbbc.zzaf.zza.zzx(query.getBlob(query.getColumnIndexOrThrow("serialized_proto_data"))));
                } catch (zzgyn e) {
                    zzm.zzg("Unable to deserialize proto from offline signals database:");
                    zzm.zzg(e.getMessage());
                }
            }
            query.close();
            Context context = this.zzb;
            zzbbc.zzaf.zzc zzi = zzbbc.zzaf.zzi();
            zzi.zzv(context.getPackageName());
            zzi.zzy(Build.MODEL);
            zzi.zzA(zzeco.zza(sQLiteDatabase2, 0));
            zzi.zzh(arrayList);
            zzi.zzE(zzeco.zza(sQLiteDatabase2, 1));
            zzi.zzx(zzeco.zza(sQLiteDatabase2, 3));
            zzi.zzF(zzu.zzB().currentTimeMillis());
            zzi.zzB(zzeco.zzb(sQLiteDatabase2, 2));
            zzbbc.zzaf zzaf = (zzbbc.zzaf) zzi.zzbr();
            int size = arrayList.size();
            long j = 0;
            for (int i2 = 0; i2 < size; i2++) {
                zzbbc.zzaf.zza zza2 = (zzbbc.zzaf.zza) arrayList.get(i2);
                if (zza2.zzk() == zzbbc.zzq.ENUM_TRUE && zza2.zze() > j) {
                    j = zza2.zze();
                }
            }
            if (j != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", Long.valueOf(j));
                sQLiteDatabase2.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", (String[]) null);
            }
            this.zza.zzb(new zzecs(zzaf));
            VersionInfoParcel versionInfoParcel = this.zzd;
            zzbbc.zzar.zza zzd2 = zzbbc.zzar.zzd();
            zzd2.zzg(versionInfoParcel.buddyApkVersion);
            zzd2.zzi(this.zzd.clientJarVersion);
            if (true != this.zzd.isClientJar) {
                i = 2;
            } else {
                i = 0;
            }
            zzd2.zzh(i);
            this.zza.zzb(new zzect((zzbbc.zzar) zzd2.zzbr()));
            this.zza.zzc(10004);
            zzeco.zze(sQLiteDatabase);
        }
        return null;
    }

    public final void zzb(boolean z) {
        try {
            this.zzc.zza(new zzecr(this, z));
        } catch (Exception e) {
            zzm.zzg("Error in offline signals database startup: ".concat(String.valueOf(e.getMessage())));
        }
    }
}
