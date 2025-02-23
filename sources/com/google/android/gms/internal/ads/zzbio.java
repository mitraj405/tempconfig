package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzbio implements zzbix {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcej = (zzcej) obj;
        if (zzcej.zzJ() != null) {
            zzcej.zzJ().zza();
        }
        zzm zzL = zzcej.zzL();
        if (zzL != null) {
            zzL.zzb();
            return;
        }
        zzm zzM = zzcej.zzM();
        if (zzM != null) {
            zzM.zzb();
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
