package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzcj;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzezh implements Callable {
    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzba.zzc().zza(zzbbw.zzD);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzba.zzc().zza(zzbbw.zzE)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzcj.zza(str2));
                }
            }
        }
        return new zzezj(hashMap);
    }
}
