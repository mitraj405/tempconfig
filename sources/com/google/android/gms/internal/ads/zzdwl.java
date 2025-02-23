package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzdwl extends Exception {
    private final int zza;

    public zzdwl(int i) {
        this.zza = i;
    }

    public final int zza() {
        return this.zza;
    }

    public zzdwl(int i, String str) {
        super(str);
        this.zza = i;
    }

    public zzdwl(int i, String str, Throwable th) {
        super(str, th);
        this.zza = 1;
    }
}
