package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaic implements zzaia {
    private final int zza;
    private final int zzb;
    private final zzek zzc;

    public zzaic(zzahw zzahw, zzaf zzaf) {
        zzek zzek = zzahw.zza;
        this.zzc = zzek;
        zzek.zzK(12);
        int zzp = zzek.zzp();
        if ("audio/raw".equals(zzaf.zzm)) {
            int zzm = zzet.zzm(zzaf.zzB, zzaf.zzz);
            if (zzp == 0 || zzp % zzm != 0) {
                zzea.zzf("AtomParsers", "Audio sample size mismatch. stsd sample size: " + zzm + ", stsz sample size: " + zzp);
                zzp = zzm;
            }
        }
        this.zza = zzp == 0 ? -1 : zzp;
        this.zzb = zzek.zzp();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i = this.zza;
        if (i == -1) {
            return this.zzc.zzp();
        }
        return i;
    }
}
