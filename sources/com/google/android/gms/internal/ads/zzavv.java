package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzavv extends BroadcastReceiver {
    final /* synthetic */ zzavw zza;

    public zzavv(zzavw zzavw) {
        this.zza = zzavw;
    }

    public final void onReceive(Context context, Intent intent) {
        this.zza.zzf();
    }
}
