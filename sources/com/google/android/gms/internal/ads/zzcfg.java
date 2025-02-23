package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzcfg implements zzbix {
    final /* synthetic */ zzcfi zza;

    public zzcfg(zzcfi zzcfi) {
        this.zza = zzcfi;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcej = (zzcej) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zza) {
                        zzcfi zzcfi = this.zza;
                        if (zzcfi.zzI != parseInt) {
                            zzcfi.zzI = parseInt;
                            this.zza.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzm.zzk("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
