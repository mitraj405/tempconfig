package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzawq extends zzaxd {
    private static volatile String zzh;
    private static final Object zzi = new Object();

    public zzawq(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2) {
        super(zzavp, "+pOuZc4XP/KXmz3ZcR0Th/zrptiqFMKeADXdr6ffDtBODTAlpCvFIUU/DK0sXoAh", "l4qa5EABhdRHJHltXD4U8dy0wNZl4oyoZ9TbFONnMI4=", zzaro, i, 1);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzB("E");
        if (zzh == null) {
            synchronized (zzi) {
                if (zzh == null) {
                    zzh = (String) this.zze.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzd) {
            this.zzd.zzB(zzh);
        }
    }
}
