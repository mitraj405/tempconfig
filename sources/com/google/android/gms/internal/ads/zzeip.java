package com.google.android.gms.internal.ads;

import in.juspay.hyper.constants.LogCategory;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzeip {
    private final zzffy zza;
    private final zzdpy zzb;
    private final zzdsk zzc;

    public zzeip(zzffy zzffy, zzdpy zzdpy, zzdsk zzdsk) {
        this.zza = zzffy;
        this.zzb = zzdpy;
        this.zzc = zzdsk;
    }

    public final void zza(zzfeo zzfeo, zzfel zzfel, int i, zzeex zzeex, long j) {
        zzdpx zzdpx;
        zzdsj zza2 = this.zzc.zza();
        zza2.zzd(zzfeo);
        zza2.zzc(zzfel);
        zza2.zzb(LogCategory.ACTION, "adapter_status");
        zza2.zzb("adapter_l", String.valueOf(j));
        zza2.zzb("sc", Integer.toString(i));
        if (zzeex != null) {
            zza2.zzb("arec", Integer.toString(zzeex.zzb().zza));
            String zza3 = this.zza.zza(zzeex.getMessage());
            if (zza3 != null) {
                zza2.zzb("areec", zza3);
            }
        }
        zzdpy zzdpy = this.zzb;
        Iterator it = zzfel.zzt.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzdpx = null;
                break;
            }
            zzdpx = zzdpy.zza((String) it.next());
            if (zzdpx != null) {
                break;
            }
        }
        if (zzdpx != null) {
            zza2.zzb("ancn", zzdpx.zza);
            zzbra zzbra = zzdpx.zzb;
            if (zzbra != null) {
                zza2.zzb("adapter_v", zzbra.toString());
            }
            zzbra zzbra2 = zzdpx.zzc;
            if (zzbra2 != null) {
                zza2.zzb("adapter_sv", zzbra2.toString());
            }
        }
        zza2.zzf();
    }
}
