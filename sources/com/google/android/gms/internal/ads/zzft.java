package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public class zzft extends IOException {
    public final int zza;

    public zzft(int i) {
        this.zza = i;
    }

    public zzft(String str, int i) {
        super(str);
        this.zza = i;
    }

    public zzft(String str, Throwable th, int i) {
        super(str, th);
        this.zza = i;
    }

    public zzft(Throwable th, int i) {
        super(th);
        this.zza = i;
    }
}
