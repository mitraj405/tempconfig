package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzbb implements Callable {
    public final /* synthetic */ TaggingLibraryJsInterface zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzbb(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.zza = taggingLibraryJsInterface;
        this.zzb = str;
    }

    public final Object call() {
        return this.zza.getClickSignals(this.zzb);
    }
}
