package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzdih implements zzhfc {
    private final zzhfu zza;

    public zzdih(zzhfu zzhfu, zzhfu zzhfu2) {
        this.zza = zzhfu;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        VersionInfoParcel zza2 = ((zzchc) this.zza).zza();
        zzu.zzp();
        return new zzaxs(UUID.randomUUID().toString(), zza2, "native", new JSONObject(), false, true);
    }
}
