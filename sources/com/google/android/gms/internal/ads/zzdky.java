package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzdky implements Runnable {
    public final /* synthetic */ zzcej zza;

    public /* synthetic */ zzdky(zzcej zzcej) {
        this.zza = zzcej;
    }

    public final void run() {
        this.zza.zzd("onSdkImpression", new ArrayMap());
    }
}
