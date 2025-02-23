package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbcj {
    private final Map zza = new HashMap();
    private final zzbcl zzb;

    public zzbcj(zzbcl zzbcl) {
        this.zzb = zzbcl;
    }

    public final zzbcl zza() {
        return this.zzb;
    }

    public final void zzb(String str, zzbci zzbci) {
        this.zza.put(str, zzbci);
    }

    public final void zzc(String str, String str2, long j) {
        zzbci zzbci = (zzbci) this.zza.get(str2);
        String[] strArr = {str};
        if (zzbci != null) {
            this.zzb.zze(zzbci, j, strArr);
        }
        this.zza.put(str, new zzbci(j, (String) null, (zzbci) null));
    }
}
