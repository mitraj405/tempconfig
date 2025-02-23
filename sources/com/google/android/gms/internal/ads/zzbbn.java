package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class zzbbn {
    private final int zza;
    private final String zzb;
    private final Object zzc;
    private final Object zzd;

    public /* synthetic */ zzbbn(int i, String str, Object obj, Object obj2, zzbbm zzbbm) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        zzba.zza().zzd(this);
    }

    public static zzbbn zzf(int i, String str, float f, float f2) {
        return new zzbbk(1, str, Float.valueOf(f), Float.valueOf(f2));
    }

    public static zzbbn zzg(int i, String str, int i2, int i3) {
        return new zzbbi(1, str, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static zzbbn zzh(int i, String str, long j, long j2) {
        return new zzbbj(1, str, Long.valueOf(j), Long.valueOf(j2));
    }

    public static zzbbn zzi(int i, String str, Boolean bool, Boolean bool2) {
        return new zzbbh(i, str, bool, bool2);
    }

    public static zzbbn zzj(int i, String str, String str2, String str3) {
        return new zzbbl(1, str, str2, str3);
    }

    public static zzbbn zzk(int i, String str) {
        zzbbn zzj = zzj(1, "gads:sdk_core_constants:experiment_id", (String) null, (String) null);
        zzba.zza().zzc(zzj);
        return zzj;
    }

    public abstract Object zza(JSONObject jSONObject);

    public abstract Object zzb(Bundle bundle);

    public abstract Object zzc(SharedPreferences sharedPreferences);

    public abstract void zzd(SharedPreferences.Editor editor, Object obj);

    public final int zze() {
        return this.zza;
    }

    public final Object zzl() {
        return zzba.zzc().zza(this);
    }

    public final Object zzm() {
        if (zzba.zzc().zzf()) {
            return this.zzd;
        }
        return this.zzc;
    }

    public final String zzn() {
        return this.zzb;
    }
}
