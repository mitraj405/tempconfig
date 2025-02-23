package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaur extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzaus zza;

    public zzaur(zzaus zzaus) {
        this.zza = zzaus;
    }

    public final void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        synchronized (zzaus.class) {
            this.zza.zza = networkCapabilities;
        }
    }

    public final void onLost(Network network) {
        synchronized (zzaus.class) {
            this.zza.zza = null;
        }
    }
}
