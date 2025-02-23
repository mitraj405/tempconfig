package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfnc implements Runnable {
    final /* synthetic */ zzfnd zza;
    private final WebView zzb;

    public zzfnc(zzfnd zzfnd) {
        this.zza = zzfnd;
        this.zzb = zzfnd.zza;
    }

    public final void run() {
        this.zzb.destroy();
    }
}
