package com.google.android.gms.internal.ads;

import java.io.Closeable;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
public abstract class zzfrd implements Closeable {
    public static zzfrp zza() {
        return new zzfrp();
    }

    public static zzfrp zzb(int i, zzfro zzfro) {
        return new zzfrp(new zzfrb(i), new zzfrc(), zzfro);
    }

    public static zzfrp zzc(zzfvk<Integer> zzfvk, zzfvk<Integer> zzfvk2, zzfro zzfro) {
        return new zzfrp(zzfvk, zzfvk2, zzfro);
    }

    public static /* synthetic */ Integer zze() {
        return -1;
    }
}
