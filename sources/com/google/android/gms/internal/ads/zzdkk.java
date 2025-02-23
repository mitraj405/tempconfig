package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdkk implements zzbix {
    public final /* synthetic */ zzdkn zza;

    public /* synthetic */ zzdkk(zzdkn zzdkn) {
        this.zza = zzdkn;
    }

    public final void zza(Object obj, Map map) {
        zzcej zzcej = (zzcej) obj;
        zzcej.zzN().zzB(new zzdkh(this.zza, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzcej.loadData(str, "text/html", "UTF-8");
        } else {
            zzcej.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        }
    }
}
