package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcmw implements zzcly {
    private final zzdvi zza;

    public zzcmw(zzdvi zzdvi) {
        this.zza = zzdvi;
    }

    public final void zza(Map map) {
        String str = (String) map.get("test_mode_enabled");
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzo(str.equals("true"));
        }
    }
}
