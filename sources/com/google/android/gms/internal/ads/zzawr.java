package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzawr extends zzaxd {
    public zzawr(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2) {
        super(zzavp, "WfvM4SeNDVyFarUKUVpVTE2MRQkjnaN4GpgwC5lMrmyQkCennlTSSkgCAZvzOVXK", "Kq6mcF8LH4HqXGyg5/DR3VvLtDExNTPXoCRIPhkdOGM=", zzaro, i, 3);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbbw.zzcu)).booleanValue();
        zzauv zzauv = new zzauv((String) this.zze.invoke((Object) null, new Object[]{this.zza.zzb(), Boolean.valueOf(booleanValue)}));
        synchronized (this.zzd) {
            this.zzd.zzj(zzauv.zza);
            this.zzd.zzC(zzauv.zzb);
        }
    }
}
