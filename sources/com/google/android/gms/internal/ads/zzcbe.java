package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzcbe {
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) zzba.zzc().zza(zzbbw.zzx)).longValue());
    private long zzb;
    private boolean zzc = true;

    public final void zza(SurfaceTexture surfaceTexture, zzcap zzcap) {
        if (zzcap != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (!this.zzc) {
                if (Math.abs(timestamp - this.zzb) < this.zza) {
                    return;
                }
            }
            this.zzc = false;
            this.zzb = timestamp;
            zzt.zza.post(new zzcbd(zzcap));
        }
    }

    public final void zzb() {
        this.zzc = true;
    }
}
