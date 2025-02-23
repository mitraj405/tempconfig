package com.google.android.gms.ads.internal.util;

import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.internal.ads.zzapd;
import com.google.android.gms.internal.ads.zzaph;
import com.google.android.gms.internal.ads.zzapn;
import com.google.android.gms.internal.ads.zzaqe;
import com.google.android.gms.internal.ads.zzbzt;
import com.google.firebase.perf.FirebasePerformance;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbn extends zzaph {
    private final zzbzt zza;
    private final zzl zzb;

    public zzbn(String str, Map map, zzbzt zzbzt) {
        super(0, str, new zzbm(zzbzt));
        this.zza = zzbzt;
        zzl zzl = new zzl((String) null);
        this.zzb = zzl;
        zzl.zzd(str, FirebasePerformance.HttpMethod.GET, (Map) null, (byte[]) null);
    }

    public final zzapn zzh(zzapd zzapd) {
        return zzapn.zzb(zzapd, zzaqe.zzb(zzapd));
    }

    public final /* bridge */ /* synthetic */ void zzo(Object obj) {
        zzapd zzapd = (zzapd) obj;
        this.zzb.zzf(zzapd.zzc, zzapd.zza);
        byte[] bArr = zzapd.zzb;
        if (zzl.zzk() && bArr != null) {
            this.zzb.zzh(bArr);
        }
        this.zza.zzc(zzapd);
    }
}
