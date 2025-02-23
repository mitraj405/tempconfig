package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcml implements zzcly {
    public final void zza(Map map) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzjz)).booleanValue() && !map.isEmpty()) {
            String str = (String) map.get("is_topics_ad_personalization_allowed");
            if (!TextUtils.isEmpty(str)) {
                zzu.zzo().zzi().zzJ(Boolean.parseBoolean(str));
            }
        }
    }
}
