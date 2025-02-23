package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzeun implements zzful {
    public final /* synthetic */ String zza;

    public /* synthetic */ zzeun(String str) {
        this.zza = str;
    }

    public final Object apply(Object obj) {
        String str = this.zza;
        zzm.zzg("Error calling adapter: ".concat(String.valueOf(str)));
        String concat = "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str));
        zzu.zzo().zzw((Throwable) obj, concat);
        return null;
    }
}
