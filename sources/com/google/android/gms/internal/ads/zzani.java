package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzani {
    private final List zza;
    private final zzadp[] zzb;

    public zzani(List list) {
        this.zza = list;
        this.zzb = new zzadp[list.size()];
    }

    public final void zza(long j, zzek zzek) {
        zzabv.zza(j, zzek, this.zzb);
    }

    public final void zzb(zzacn zzacn, zzans zzans) {
        for (int i = 0; i < this.zzb.length; i++) {
            zzans.zzc();
            zzadp zzw = zzacn.zzw(zzans.zza(), 3);
            zzaf zzaf = (zzaf) this.zza.get(i);
            String str = zzaf.zzm;
            boolean z = true;
            if (!"application/cea-608".equals(str) && !"application/cea-708".equals(str)) {
                z = false;
            }
            zzdi.zze(z, "Invalid closed caption MIME type provided: ".concat(String.valueOf(str)));
            String str2 = zzaf.zza;
            if (str2 == null) {
                str2 = zzans.zzb();
            }
            zzad zzad = new zzad();
            zzad.zzK(str2);
            zzad.zzX(str);
            zzad.zzZ(zzaf.zze);
            zzad.zzO(zzaf.zzd);
            zzad.zzw(zzaf.zzE);
            zzad.zzL(zzaf.zzo);
            zzw.zzl(zzad.zzad());
            this.zzb[i] = zzw;
        }
    }
}
