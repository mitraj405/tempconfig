package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
public class HashAccumulator {
    @VisibleForTesting
    static int zaa = 31;
    private int zab = 1;

    @KeepForSdk
    public HashAccumulator addObject(Object obj) {
        int i;
        int i2 = zaa * this.zab;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        this.zab = i2 + i;
        return this;
    }

    @KeepForSdk
    public int hash() {
        return this.zab;
    }

    public final HashAccumulator zaa(boolean z) {
        this.zab = (zaa * this.zab) + (z ? 1 : 0);
        return this;
    }
}
