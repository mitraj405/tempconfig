package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hypersdk.core.PaymentConstants;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbjp implements zzbix {
    private final zzbjo zza;

    public zzbjp(zzbjo zzbjo) {
        this.zza = zzbjo;
    }

    public static void zzb(zzcej zzcej, zzbjo zzbjo) {
        zzcej.zzag("/reward", new zzbjp(zzbjo));
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get(LogCategory.ACTION);
        if ("grant".equals(str)) {
            zzbvz zzbvz = null;
            try {
                int parseInt = Integer.parseInt((String) map.get(PaymentConstants.AMOUNT));
                String str2 = (String) map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzbvz = new zzbvz(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzm.zzk("Unable to parse reward amount.", e);
            }
            this.zza.zza(zzbvz);
        } else if ("video_start".equals(str)) {
            this.zza.zzc();
        } else if ("video_complete".equals(str)) {
            this.zza.zzb();
        }
    }
}
