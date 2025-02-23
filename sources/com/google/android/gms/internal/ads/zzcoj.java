package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzu;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcoj implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;
    private final zzhfu zzc;

    public zzcoj(zzhfu zzhfu, zzhfu zzhfu2, zzhfu zzhfu3) {
        this.zza = zzhfu;
        this.zzb = zzhfu2;
        this.zzc = zzhfu3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        String str = (String) this.zzc.zzb();
        boolean equals = "native".equals(str);
        zzu.zzp();
        return new zzaxs(UUID.randomUUID().toString(), ((zzchc) this.zza).zza(), str, (JSONObject) this.zzb.zzb(), false, equals);
    }
}
