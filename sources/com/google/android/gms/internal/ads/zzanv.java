package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzanv {
    private final List zza;
    private final zzadp[] zzb;

    public zzanv(List list) {
        this.zza = list;
        this.zzb = new zzadp[list.size()];
    }

    public final void zza(long j, zzek zzek) {
        if (zzek.zzb() >= 9) {
            int zzg = zzek.zzg();
            int zzg2 = zzek.zzg();
            int zzm = zzek.zzm();
            if (zzg == 434 && zzg2 == 1195456820 && zzm == 3) {
                zzabv.zzb(j, zzek, this.zzb);
            }
        }
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
            zzad zzad = new zzad();
            zzad.zzK(zzans.zzb());
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
