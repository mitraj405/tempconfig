package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfnq implements Runnable {
    public final void run() {
        if (zzfnt.zzc != null) {
            zzfnt.zzc.post(zzfnt.zzd);
            zzfnt.zzc.postDelayed(zzfnt.zze, 200);
        }
    }
}
