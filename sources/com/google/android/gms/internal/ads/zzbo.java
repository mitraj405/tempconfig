package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzbo extends IOException {
    public final boolean zza;
    public final int zzb;

    public zzbo(String str, Throwable th, boolean z, int i) {
        super(str, th);
        this.zza = z;
        this.zzb = i;
    }

    public static zzbo zza(String str, Throwable th) {
        return new zzbo(str, th, true, 1);
    }

    public static zzbo zzb(String str, Throwable th) {
        return new zzbo(str, th, true, 0);
    }

    public static zzbo zzc(String str) {
        return new zzbo(str, (Throwable) null, false, 1);
    }

    public final String getMessage() {
        StringBuilder n = lf.n(super.getMessage(), "{contentIsMalformed=");
        n.append(this.zza);
        n.append(", dataType=");
        return lf.k(n, this.zzb, "}");
    }
}
