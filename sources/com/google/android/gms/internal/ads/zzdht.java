package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdht implements zzbix {
    private final WeakReference zza;

    public /* synthetic */ zzdht(zzdhy zzdhy, zzdhs zzdhs) {
        this.zza = new WeakReference(zzdhy);
    }

    public final void zza(Object obj, Map map) {
        zzdhy zzdhy = (zzdhy) this.zza.get();
        if (zzdhy != null && "_ac".equals((String) map.get("eventName"))) {
            zzdhy.zzh.onAdClicked();
            if (((Boolean) zzba.zzc().zza(zzbbw.zzjR)).booleanValue()) {
                zzdhy.zzi.zzdG();
                if (!TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                    zzdhy.zzi.zzdf();
                }
            }
        }
    }
}
