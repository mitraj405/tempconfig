package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaad extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzaab zzd;
    private boolean zze;

    public /* synthetic */ zzaad(zzaab zzaab, SurfaceTexture surfaceTexture, boolean z, zzaac zzaac) {
        super(surfaceTexture);
        this.zzd = zzaab;
        this.zza = z;
    }

    public static zzaad zza(Context context, boolean z) {
        int i = 0;
        boolean z2 = true;
        if (z && !zzb(context)) {
            z2 = false;
        }
        zzdi.zzf(z2);
        zzaab zzaab = new zzaab();
        if (z) {
            i = zzb;
        }
        return zzaab.zza(i);
    }

    public static synchronized boolean zzb(Context context) {
        int i;
        int i2;
        synchronized (zzaad.class) {
            if (!zzc) {
                if (!zzdr.zzb(context)) {
                    i2 = 0;
                } else if (zzdr.zzc()) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                zzb = i2;
                zzc = true;
            }
            i = zzb;
        }
        if (i != 0) {
            return true;
        }
        return false;
    }

    public final void release() {
        super.release();
        synchronized (this.zzd) {
            if (!this.zze) {
                this.zzd.zzb();
                this.zze = true;
            }
        }
    }
}
