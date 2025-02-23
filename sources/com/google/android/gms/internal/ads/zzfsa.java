package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfsa {
    private static zzfsa zza;
    private final String zzb;
    private final SharedPreferences zzc;

    private zzfsa(Context context) {
        this.zzb = context.getPackageName();
        this.zzc = context.getSharedPreferences("paid_storage_sp", 0);
    }

    public static zzfsa zzb(Context context) {
        if (zza == null) {
            zza = new zzfsa(context);
        }
        return zza;
    }

    public final long zza(String str, long j) {
        return this.zzc.getLong(str, -1);
    }

    public final String zzc(String str, String str2) {
        return this.zzc.getString(str, (String) null);
    }

    public final void zzd(String str, Object obj) throws IOException {
        boolean z;
        if (obj instanceof String) {
            z = this.zzc.edit().putString(str, (String) obj).commit();
        } else if (obj instanceof Long) {
            z = this.zzc.edit().putLong(str, ((Long) obj).longValue()).commit();
        } else if (obj instanceof Boolean) {
            z = this.zzc.edit().putBoolean(str, ((Boolean) obj).booleanValue()).commit();
        } else {
            String.valueOf(obj.getClass());
            String str2 = this.zzb;
            throw new IOException("Failed to store " + str + " for app " + str2);
        }
        if (z) {
            return;
        }
        String str22 = this.zzb;
        throw new IOException("Failed to store " + str + " for app " + str22);
    }

    public final void zze(String str) throws IOException {
        if (!this.zzc.edit().remove(str).commit()) {
            String str2 = this.zzb;
            throw new IOException("Failed to remove " + str + " for app " + str2);
        }
    }

    public final boolean zzf(String str, boolean z) {
        return this.zzc.getBoolean(str, true);
    }

    public final boolean zzg(String str) {
        return this.zzc.contains(str);
    }
}
