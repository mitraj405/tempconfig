package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaxa extends zzaxd {
    private final View zzh;

    public zzaxa(zzavp zzavp, String str, String str2, zzaro zzaro, int i, int i2, View view) {
        super(zzavp, "fHaUCxrr3fcbpdQPVJw6OSoHeHoizr6wmxmAsnLvDUhuNG2u8ebKX4VPxAoXSx4W", "K/sgHSTVeE1LLZ4HP+m5KF6ND+k7W4ID3M3VTul8bAI=", zzaro, i, 57);
        this.zzh = view;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzh != null) {
            Boolean bool = (Boolean) zzba.zzc().zza(zzbbw.zzda);
            Boolean bool2 = (Boolean) zzba.zzc().zza(zzbbw.zzjZ);
            DisplayMetrics displayMetrics = this.zza.zzb().getResources().getDisplayMetrics();
            zzavt zzavt = new zzavt((String) this.zze.invoke((Object) null, new Object[]{this.zzh, displayMetrics, bool, bool2}));
            zzash zza = zzasi.zza();
            zza.zzb(zzavt.zza.longValue());
            zza.zzd(zzavt.zzb.longValue());
            zza.zze(zzavt.zzc.longValue());
            if (bool2.booleanValue()) {
                zza.zzc(zzavt.zze.longValue());
            }
            if (bool.booleanValue()) {
                zza.zza(zzavt.zzd.longValue());
            }
            this.zzd.zzY((zzasi) zza.zzbr());
        }
    }
}
