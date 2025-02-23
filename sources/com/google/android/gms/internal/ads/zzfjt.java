package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.nonagon.signalgeneration.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final /* synthetic */ class zzfjt {
    public static zzfju zza(Context context, int i) {
        boolean z;
        if (zzfki.zza()) {
            int i2 = i - 2;
            if (i2 != 20 && i2 != 21) {
                switch (i2) {
                    case 2:
                    case 3:
                    case 6:
                    case 7:
                    case 8:
                        z = ((Boolean) zzbdl.zzc.zze()).booleanValue();
                        break;
                    case 4:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        z = ((Boolean) zzbdl.zzd.zze()).booleanValue();
                        break;
                    case 5:
                        z = ((Boolean) zzbdl.zzb.zze()).booleanValue();
                        break;
                }
            } else {
                z = ((Boolean) zzbdl.zze.zze()).booleanValue();
            }
            if (z) {
                return new zzfjw(context, i);
            }
        }
        return new zzfky();
    }

    public static zzfju zzb(Context context, int i, int i2, zzl zzl) {
        zzfju zza = zza(context, i);
        if (zza instanceof zzfjw) {
            zza.zzi();
            zza.zzn(i2);
            zza.zzf(zzq.zza(zzl.zzm));
            if (zzfke.zze(zzl.zzp)) {
                zza.zze(zzl.zzp);
            }
        }
        return zza;
    }
}
