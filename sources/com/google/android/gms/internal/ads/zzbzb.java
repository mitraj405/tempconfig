package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbzb extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzbze zza;

    public zzbzb(zzbze zzbze) {
        this.zza = zzbze;
    }

    public final void onAvailable(Network network) {
        this.zza.zzo.set(true);
    }

    public final void onLost(Network network) {
        this.zza.zzo.set(false);
    }
}
