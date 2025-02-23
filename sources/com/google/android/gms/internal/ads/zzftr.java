package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzftr implements IBinder.DeathRecipient {
    public final /* synthetic */ zzftz zza;

    public /* synthetic */ zzftr(zzftz zzftz) {
        this.zza = zzftz;
    }

    public final void binderDied() {
        this.zza.zzk();
    }
}
