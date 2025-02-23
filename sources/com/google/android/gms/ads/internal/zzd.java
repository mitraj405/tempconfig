package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzdsk;
import com.google.android.gms.internal.ads.zzfju;
import com.google.android.gms.internal.ads.zzfki;
import com.google.android.gms.internal.ads.zzgbq;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzd implements zzgbq {
    public final /* synthetic */ Long zza;
    public final /* synthetic */ zzdsk zzb;
    public final /* synthetic */ zzfki zzc;
    public final /* synthetic */ zzfju zzd;

    public /* synthetic */ zzd(zzf zzf, Long l, zzdsk zzdsk, zzfki zzfki, zzfju zzfju) {
        this.zza = l;
        this.zzb = zzdsk;
        this.zzc = zzfki;
        this.zzd = zzfju;
    }

    public final ListenableFuture zza(Object obj) {
        return zzf.zzd(this.zza, this.zzb, this.zzc, this.zzd, (JSONObject) obj);
    }
}
