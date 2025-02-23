package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzamy implements zzang {
    private zzaf zza;
    private zzer zzb;
    private zzadp zzc;

    public zzamy(String str) {
        zzad zzad = new zzad();
        zzad.zzX(str);
        this.zza = zzad.zzad();
    }

    public final void zza(zzek zzek) {
        zzdi.zzb(this.zzb);
        int i = zzet.zza;
        long zze = this.zzb.zze();
        long zzf = this.zzb.zzf();
        if (zze != -9223372036854775807L && zzf != -9223372036854775807L) {
            zzaf zzaf = this.zza;
            if (zzf != zzaf.zzq) {
                zzad zzb2 = zzaf.zzb();
                zzb2.zzab(zzf);
                zzaf zzad = zzb2.zzad();
                this.zza = zzad;
                this.zzc.zzl(zzad);
            }
            int zzb3 = zzek.zzb();
            this.zzc.zzq(zzek, zzb3);
            this.zzc.zzs(zze, 1, zzb3, 0, (zzado) null);
        }
    }

    public final void zzb(zzer zzer, zzacn zzacn, zzans zzans) {
        this.zzb = zzer;
        zzans.zzc();
        zzadp zzw = zzacn.zzw(zzans.zza(), 5);
        this.zzc = zzw;
        zzw.zzl(this.zza);
    }
}
