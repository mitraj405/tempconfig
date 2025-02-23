package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbnf {
    private final Object zza = new Object();
    private final Object zzb = new Object();
    private zzbno zzc;
    private zzbno zzd;

    private static final Context zzc(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            return context;
        }
        return applicationContext;
    }

    public final zzbno zza(Context context, VersionInfoParcel versionInfoParcel, zzfki zzfki) {
        zzbno zzbno;
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = new zzbno(zzc(context), versionInfoParcel, (String) zzba.zzc().zza(zzbbw.zza), zzfki);
            }
            zzbno = this.zzc;
        }
        return zzbno;
    }

    public final zzbno zzb(Context context, VersionInfoParcel versionInfoParcel, zzfki zzfki) {
        zzbno zzbno;
        synchronized (this.zzb) {
            if (this.zzd == null) {
                this.zzd = new zzbno(zzc(context), versionInfoParcel, (String) zzbec.zza.zze(), zzfki);
            }
            zzbno = this.zzd;
        }
        return zzbno;
    }
}
