package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzhfd implements zzhfc, zzhew {
    private static final zzhfd zza = new zzhfd((Object) null);
    private final Object zzb;

    private zzhfd(Object obj) {
        this.zzb = obj;
    }

    public static zzhfc zza(Object obj) {
        zzhfk.zza(obj, "instance cannot be null");
        return new zzhfd(obj);
    }

    public static zzhfc zzc(Object obj) {
        if (obj == null) {
            return zza;
        }
        return new zzhfd(obj);
    }

    public final Object zzb() {
        return this.zzb;
    }
}
