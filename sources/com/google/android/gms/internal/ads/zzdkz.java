package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzdkz implements zzgcf {
    final /* synthetic */ zzdla zza;

    public zzdkz(zzdla zzdla) {
        this.zza = zzdla;
    }

    public final void zza(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbbw.zzeI)).booleanValue()) {
            zzu.zzo().zzw(th, "omid native display exp");
        }
    }

    /* renamed from: zzc */
    public final void zzb(List list) {
        try {
            zzcej zzcej = (zzcej) list.get(0);
            if (zzcej != null) {
                this.zza.zzb(zzcej);
            }
        } catch (ClassCastException | IndexOutOfBoundsException e) {
            if (((Boolean) zzba.zzc().zza(zzbbw.zzeI)).booleanValue()) {
                zzu.zzo().zzw(e, "omid native display exp");
            }
        }
    }
}
