package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbiz implements zzbix {
    private final zzbja zza;

    public zzbiz(zzbja zzbja) {
        this.zza = zzbja;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcej = (zzcej) obj;
        boolean equals = C0515Ga.AVLBLTY_ONLY.equals(map.get("transparentBackground"));
        boolean equals2 = C0515Ga.AVLBLTY_ONLY.equals(map.get("blur"));
        float f = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat((String) map.get("blurRadius"));
            }
        } catch (NumberFormatException e) {
            zzm.zzh("Fail to parse float", e);
        }
        this.zza.zzc(equals);
        this.zza.zzb(equals2, f);
        zzcej.zzay(equals);
    }
}
