package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzavz extends zzaxd {
    private final Activity zzh;
    private final View zzi;

    public zzavz(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2, View view, Activity activity) {
        super(zzavp, "GC4CZUnPsyUcm5NrWw7C8gSktjb/gtBCDrSKBLlqImuOnQy7zHyo6XlIzkH3EMVH", "Kx8fghNUQq+sA+EfmK6qh0KjuKvw753ECuaCFV8szVM=", zzaro, i, 62);
        this.zzi = view;
        this.zzh = activity;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbbw.zzcp)).booleanValue();
            Object[] objArr = (Object[]) this.zze.invoke((Object) null, new Object[]{this.zzi, this.zzh, Boolean.valueOf(booleanValue)});
            synchronized (this.zzd) {
                this.zzd.zzc(((Long) objArr[0]).longValue());
                this.zzd.zze(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zzd.zzd((String) objArr[2]);
                }
            }
        }
    }
}
