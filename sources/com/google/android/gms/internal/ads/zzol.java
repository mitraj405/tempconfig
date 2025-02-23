package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzol extends BroadcastReceiver {
    final /* synthetic */ zzom zza;

    public /* synthetic */ zzol(zzom zzom, zzok zzok) {
        this.zza = zzom;
    }

    public final void onReceive(Context context, Intent intent) {
        if (!isInitialStickyBroadcast()) {
            zzom zzom = this.zza;
            zzom.zzj(zzof.zzd(context, intent, zzom.zzh, zzom.zzg));
        }
    }
}
