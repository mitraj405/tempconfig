package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public abstract class zzbyb {
    static zzbyb zza;

    public static synchronized zzbyb zzd(Context context) {
        synchronized (zzbyb.class) {
            zzbyb zzbyb = zza;
            if (zzbyb != null) {
                return zzbyb;
            }
            Context applicationContext = context.getApplicationContext();
            zzbbw.zza(applicationContext);
            zzg zzi = zzu.zzo().zzi();
            zzi.zzs(applicationContext);
            zzbxt zzbxt = new zzbxt((zzbxs) null);
            zzbxt.zzb(applicationContext);
            zzbxt.zzc(zzu.zzB());
            zzbxt.zza(zzi);
            zzbxt.zzd(zzu.zzn());
            zzbyb zze = zzbxt.zze();
            zza = zze;
            zze.zza().zza();
            zzbyf zzc = zza.zzc();
            if (((Boolean) zzba.zzc().zza(zzbbw.zzal)).booleanValue()) {
                zzu.zzp();
                Map zzv = zzt.zzv((String) zzba.zzc().zza(zzbbw.zzam));
                for (String zzc2 : zzv.keySet()) {
                    zzc.zzc(zzc2);
                }
                zzc.zzd(new zzbyd(zzc, zzv));
            }
            zzbyb zzbyb2 = zza;
            return zzbyb2;
        }
    }

    public abstract zzbxm zza();

    public abstract zzbxq zzb();

    public abstract zzbyf zzc();
}
