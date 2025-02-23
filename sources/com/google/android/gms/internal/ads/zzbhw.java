package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbhw implements zzbix {
    public final void zza(Object obj, Map map) {
        boolean z;
        zzcfq zzcfq = (zzcfq) obj;
        zzbix zzbix = zzbiw.zza;
        if (!((Boolean) zzba.zzc().zza(zzbbw.zzht)).booleanValue()) {
            zzm.zzj("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get("package_name");
        if (TextUtils.isEmpty(str)) {
            zzm.zzj("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        if (zzcfq.getContext().getPackageManager().getLaunchIntentForPackage(str) != null) {
            z = true;
        } else {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        hashMap.put(str, valueOf);
        zze.zza("/canOpenApp;" + str + ";" + valueOf);
        ((zzbls) zzcfq).zzd("openableApp", hashMap);
    }
}
