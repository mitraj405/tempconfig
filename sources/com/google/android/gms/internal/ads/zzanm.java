package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzanm implements zzang {
    final /* synthetic */ zzano zza;
    private final zzej zzb = new zzej(new byte[4], 4);

    public zzanm(zzano zzano) {
        this.zza = zzano;
    }

    public final void zza(zzek zzek) {
        if (zzek.zzm() == 0 && (zzek.zzm() & 128) != 0) {
            zzek.zzL(6);
            int zzb2 = zzek.zzb() / 4;
            for (int i = 0; i < zzb2; i++) {
                zzek.zzF(this.zzb, 4);
                zzej zzej = this.zzb;
                int zzd = zzej.zzd(16);
                zzej.zzn(3);
                if (zzd == 0) {
                    this.zzb.zzn(13);
                } else {
                    int zzd2 = this.zzb.zzd(13);
                    if (this.zza.zzg.get(zzd2) == null) {
                        zzano zzano = this.zza;
                        zzano.zzg.put(zzd2, new zzanh(new zzann(zzano, zzd2)));
                        zzano zzano2 = this.zza;
                        zzano2.zzm = zzano2.zzm + 1;
                    }
                }
            }
            this.zza.zzg.remove(0);
        }
    }

    public final void zzb(zzer zzer, zzacn zzacn, zzans zzans) {
    }
}
