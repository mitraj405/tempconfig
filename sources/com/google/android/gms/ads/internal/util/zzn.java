package com.google.android.gms.ads.internal.util;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.ads.zzfru;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzn implements Callable {
    public final /* synthetic */ Uri zza;

    public /* synthetic */ zzn(Uri uri) {
        this.zza = uri;
    }

    public final Object call() {
        zzfru zzfru = zzt.zza;
        zzu.zzp();
        return zzt.zzP(this.zza);
    }
}
