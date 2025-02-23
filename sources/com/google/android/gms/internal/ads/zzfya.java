package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzfya extends zzfzx {
    private final Object zza;
    private boolean zzb;

    public zzfya(Object obj) {
        this.zza = obj;
    }

    public final boolean hasNext() {
        if (!this.zzb) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (!this.zzb) {
            this.zzb = true;
            return this.zza;
        }
        throw new NoSuchElementException();
    }
}
