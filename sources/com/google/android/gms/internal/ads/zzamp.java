package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzamp implements zzamf {
    private final zzek zza = new zzek(10);
    private zzadp zzb;
    private boolean zzc;
    private long zzd = -9223372036854775807L;
    private int zze;
    private int zzf;

    public final void zza(zzek zzek) {
        zzdi.zzb(this.zzb);
        if (this.zzc) {
            int zzb2 = zzek.zzb();
            int i = this.zzf;
            if (i < 10) {
                int min = Math.min(zzb2, 10 - i);
                System.arraycopy(zzek.zzM(), zzek.zzd(), this.zza.zzM(), this.zzf, min);
                if (this.zzf + min == 10) {
                    this.zza.zzK(0);
                    if (this.zza.zzm() == 73 && this.zza.zzm() == 68 && this.zza.zzm() == 51) {
                        this.zza.zzL(3);
                        this.zze = this.zza.zzl() + 10;
                    } else {
                        zzea.zzf("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzc = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(zzb2, this.zze - this.zzf);
            this.zzb.zzq(zzek, min2);
            this.zzf += min2;
        }
    }

    public final void zzb(zzacn zzacn, zzans zzans) {
        zzans.zzc();
        zzadp zzw = zzacn.zzw(zzans.zza(), 5);
        this.zzb = zzw;
        zzad zzad = new zzad();
        zzad.zzK(zzans.zzb());
        zzad.zzX("application/id3");
        zzw.zzl(zzad.zzad());
    }

    public final void zzc(boolean z) {
        int i;
        boolean z2;
        zzdi.zzb(this.zzb);
        if (this.zzc && (i = this.zze) != 0 && this.zzf == i) {
            if (this.zzd != -9223372036854775807L) {
                z2 = true;
            } else {
                z2 = false;
            }
            zzdi.zzf(z2);
            this.zzb.zzs(this.zzd, 1, this.zze, 0, (zzado) null);
            this.zzc = false;
        }
    }

    public final void zzd(long j, int i) {
        if ((i & 4) != 0) {
            this.zzc = true;
            this.zzd = j;
            this.zze = 0;
            this.zzf = 0;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzd = -9223372036854775807L;
    }
}
