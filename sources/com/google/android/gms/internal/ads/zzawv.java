package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzawv extends zzaxd {
    private final StackTraceElement[] zzh;

    public zzawv(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzavp, "9douHjmTTjq3N4YYUdzzHaKyxIqsB5K92p8t26vKQB1HahpVak+32YHan4LmgLPE", "q6oLc2ULDKRAR1VDdX5lO9/kb0NHjx7PMACMr/7cZL8=", zzaro, i, 45);
        this.zzh = stackTraceElementArr;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        Object obj = this.zzh;
        if (obj != null) {
            int i = 1;
            zzavg zzavg = new zzavg((String) this.zze.invoke((Object) null, new Object[]{obj}));
            synchronized (this.zzd) {
                this.zzd.zzF(zzavg.zza.longValue());
                if (zzavg.zzb.booleanValue()) {
                    zzaro zzaro = this.zzd;
                    if (true != zzavg.zzc.booleanValue()) {
                        i = 2;
                    }
                    zzaro.zzac(i);
                } else {
                    this.zzd.zzac(3);
                }
            }
        }
    }
}
