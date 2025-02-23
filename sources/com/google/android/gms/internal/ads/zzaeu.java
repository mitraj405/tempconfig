package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaeu extends zzaet {
    private final zzek zzb = new zzek(zzfh.zza);
    private final zzek zzc = new zzek(4);
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzaeu(zzadp zzadp) {
        super(zzadp);
    }

    public final boolean zza(zzek zzek) throws zzaes {
        int zzm = zzek.zzm();
        int i = zzm >> 4;
        int i2 = zzm & 15;
        if (i2 == 7) {
            this.zzg = i;
            if (i != 5) {
                return true;
            }
            return false;
        }
        throw new zzaes(lf.h("Video format not supported: ", i2));
    }

    public final boolean zzb(zzek zzek, long j) throws zzbo {
        int i;
        int i2;
        zzek zzek2 = zzek;
        int zzm = zzek.zzm();
        long zzh = (long) zzek.zzh();
        if (zzm == 0) {
            if (!this.zze) {
                zzek zzek3 = new zzek(new byte[zzek.zzb()]);
                zzek2.zzG(zzek3.zzM(), 0, zzek.zzb());
                zzabn zza = zzabn.zza(zzek3);
                this.zzd = zza.zzb;
                zzad zzad = new zzad();
                zzad.zzX("video/avc");
                zzad.zzz(zza.zzk);
                zzad.zzac(zza.zzc);
                zzad.zzI(zza.zzd);
                zzad.zzT(zza.zzj);
                zzad.zzL(zza.zza);
                this.zza.zzl(zzad.zzad());
                this.zze = true;
                return false;
            }
        } else if (zzm == 1 && this.zze) {
            if (this.zzg == 1) {
                i = 1;
            } else {
                i = 0;
            }
            if (this.zzf) {
                i2 = i;
            } else if (i != 0) {
                i2 = 1;
            }
            byte[] zzM = this.zzc.zzM();
            zzM[0] = 0;
            zzM[1] = 0;
            zzM[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzek.zzb() > 0) {
                zzek2.zzG(this.zzc.zzM(), i3, this.zzd);
                this.zzc.zzK(0);
                zzek zzek4 = this.zzc;
                zzek zzek5 = this.zzb;
                int zzp = zzek4.zzp();
                zzek5.zzK(0);
                this.zza.zzq(this.zzb, 4);
                this.zza.zzq(zzek2, zzp);
                i4 = i4 + 4 + zzp;
            }
            this.zza.zzs((zzh * 1000) + j, i2, i4, 0, (zzado) null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
