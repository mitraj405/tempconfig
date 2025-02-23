package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzawu extends zzaxd {
    private final boolean zzh;

    public zzawu(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2) {
        super(zzavp, "vvYcBqgI4aoC3GZZ7n1bdLp71k52s6EJLh0/nA6ME39LmvOZf3TBZ+H4xg1YfQXg", "6jGSPrUM0+2YrTO2vsTOKq3+XL/IfUFs5oxZaSEvsQg=", zzaro, i, 61);
        this.zzh = zzavp.zzs();
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zze.invoke((Object) null, new Object[]{this.zza.zzb(), Boolean.valueOf(this.zzh)})).longValue();
        synchronized (this.zzd) {
            this.zzd.zzE(longValue);
        }
    }
}
