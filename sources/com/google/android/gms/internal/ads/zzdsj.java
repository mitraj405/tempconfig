package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdsj {
    final /* synthetic */ zzdsk zza;
    private final Map zzb = new ConcurrentHashMap();

    public zzdsj(zzdsk zzdsk) {
        this.zza = zzdsk;
    }

    public final zzdsj zzb(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.zzb.put(str, str2);
        }
        return this;
    }

    public final zzdsj zzc(zzfel zzfel) {
        zzb("aai", zzfel.zzw);
        zzb("request_id", zzfel.zzan);
        zzb(FirebaseAnalytics.Param.AD_FORMAT, zzfel.zza(zzfel.zzb));
        return this;
    }

    public final zzdsj zzd(zzfeo zzfeo) {
        zzb("gqi", zzfeo.zzb);
        return this;
    }

    public final String zze() {
        return this.zza.zza.zzb(this.zzb);
    }

    public final void zzf() {
        this.zza.zzb.execute(new zzdsh(this));
    }

    public final void zzg() {
        this.zza.zzb.execute(new zzdsi(this));
    }

    public final /* synthetic */ void zzh() {
        this.zza.zza.zzf(this.zzb);
    }

    public final /* synthetic */ void zzi() {
        this.zza.zza.zze(this.zzb);
    }
}
