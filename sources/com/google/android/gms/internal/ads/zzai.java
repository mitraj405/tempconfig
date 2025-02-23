package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzai {
    public /* synthetic */ zzai(zzo zzo, int i, int i2, float f, long j, zzah zzah) {
        boolean z;
        String h = lf.h("width must be positive, but is: ", i);
        boolean z2 = true;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        zzdi.zze(z, h);
        zzdi.zze(i2 <= 0 ? false : z2, "height must be positive, but is: " + i2);
    }
}
