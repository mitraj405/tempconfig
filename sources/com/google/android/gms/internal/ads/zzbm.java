package com.google.android.gms.internal.ads;

import com.google.common.primitives.Ints;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbm {
    public final int zza;

    public zzbm(int i, int i2) {
        this.zza = i2;
    }

    public final int zza() {
        int i = this.zza;
        if (i == 2) {
            return 10;
        }
        if (i == 5) {
            return 11;
        }
        if (i == 29) {
            return 12;
        }
        if (i == 42) {
            return 16;
        }
        if (i == 22) {
            return Ints.MAX_POWER_OF_TWO;
        }
        if (i != 23) {
            return 0;
        }
        return 15;
    }
}
