package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.util.client.zzr;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzedc implements zzfio {
    public final /* synthetic */ zzedh zza;
    public final /* synthetic */ zzr zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzedc(zzedh zzedh, zzr zzr, String str) {
        this.zza = zzedh;
        this.zzb = zzr;
        this.zzc = str;
    }

    public final Object zza(Object obj) {
        this.zza.zzg((SQLiteDatabase) obj, this.zzb, this.zzc);
        return null;
    }
}
