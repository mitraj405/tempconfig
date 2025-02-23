package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbw;

@TargetApi(30)
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzz extends zzy {
    public final int zzm(Context context) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzhL)).booleanValue()) {
            return 0;
        }
        return super.zzm(context);
    }
}
