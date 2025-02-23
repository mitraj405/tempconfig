package com.google.android.gms.internal.ads;

import com.google.common.primitives.SignedBytes;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzalz implements zzamf {
    private final zzej zza;
    private final zzek zzb;
    private final String zzc;
    private final int zzd;
    private String zze;
    private zzadp zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private long zzj;
    private zzaf zzk;
    private int zzl;
    private long zzm;

    public zzalz() {
        throw null;
    }

    public final void zza(zzek zzek) {
        int zzm2;
        boolean z;
        byte b;
        boolean z2;
        zzdi.zzb(this.zzf);
        while (zzek.zzb() > 0) {
            int i = this.zzg;
            boolean z3 = true;
            if (i == 0) {
                while (true) {
                    if (zzek.zzb() <= 0) {
                        break;
                    } else if (!this.zzi) {
                        if (zzek.zzm() == 172) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.zzi = z2;
                    } else {
                        zzm2 = zzek.zzm();
                        if (zzm2 == 172) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.zzi = z;
                        b = SignedBytes.MAX_POWER_OF_TWO;
                        if (zzm2 == 64) {
                            break;
                        } else if (zzm2 == 65) {
                            zzm2 = 65;
                            break;
                        }
                    }
                }
                this.zzg = 1;
                zzek zzek2 = this.zzb;
                zzek2.zzM()[0] = -84;
                if (zzm2 == 65) {
                    b = 65;
                }
                zzek2.zzM()[1] = b;
                this.zzh = 2;
            } else if (i != 1) {
                int min = Math.min(zzek.zzb(), this.zzl - this.zzh);
                this.zzf.zzq(zzek, min);
                int i2 = this.zzh + min;
                this.zzh = i2;
                if (i2 == this.zzl) {
                    if (this.zzm == -9223372036854775807L) {
                        z3 = false;
                    }
                    zzdi.zzf(z3);
                    this.zzf.zzs(this.zzm, 1, this.zzl, 0, (zzado) null);
                    this.zzm += this.zzj;
                    this.zzg = 0;
                }
            } else {
                byte[] zzM = this.zzb.zzM();
                int min2 = Math.min(zzek.zzb(), 16 - this.zzh);
                zzek.zzG(zzM, this.zzh, min2);
                int i3 = this.zzh + min2;
                this.zzh = i3;
                if (i3 == 16) {
                    this.zza.zzl(0);
                    zzabl zza2 = zzabm.zza(this.zza);
                    zzaf zzaf = this.zzk;
                    if (zzaf == null || zzaf.zzz != 2 || zza2.zza != zzaf.zzA || !"audio/ac4".equals(zzaf.zzm)) {
                        zzad zzad = new zzad();
                        zzad.zzK(this.zze);
                        zzad.zzX("audio/ac4");
                        zzad.zzy(2);
                        zzad.zzY(zza2.zza);
                        zzad.zzO(this.zzc);
                        zzad.zzV(this.zzd);
                        zzaf zzad2 = zzad.zzad();
                        this.zzk = zzad2;
                        this.zzf.zzl(zzad2);
                    }
                    this.zzl = zza2.zzb;
                    this.zzj = (((long) zza2.zzc) * 1000000) / ((long) this.zzk.zzA);
                    this.zzb.zzK(0);
                    this.zzf.zzq(this.zzb, 16);
                    this.zzg = 2;
                }
            }
        }
    }

    public final void zzb(zzacn zzacn, zzans zzans) {
        zzans.zzc();
        this.zze = zzans.zzb();
        this.zzf = zzacn.zzw(zzans.zza(), 1);
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = false;
        this.zzm = -9223372036854775807L;
    }

    public zzalz(String str, int i) {
        zzej zzej = new zzej(new byte[16], 16);
        this.zza = zzej;
        this.zzb = new zzek(zzej.zza);
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = false;
        this.zzm = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
    }

    public final void zzc(boolean z) {
    }
}
