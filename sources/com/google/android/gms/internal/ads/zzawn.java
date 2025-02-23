package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzawn extends zzaxd {
    private final zzavh zzh;

    public zzawn(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2, zzavh zzavh) {
        super(zzavp, "QcEEfK1PwFv2Eb+NZQ+4kWKAUUVvycYqoBzmAjBexJV/sKEjaFlajeD5MAZYWXy5", "361aY1ErIwpwsXwpamiiDSCpkl/IcdBM93dd8sW9a/Y=", zzaro, i, 94);
        this.zzh = zzavh;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        int intValue = ((Integer) this.zze.invoke((Object) null, new Object[]{this.zzh.zza()})).intValue();
        synchronized (this.zzd) {
            this.zzd.zzae(zzasa.zza(intValue));
        }
    }
}
