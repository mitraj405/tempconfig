package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzalx implements zzamf {
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

    public zzalx() {
        throw null;
    }

    public final void zza(zzek zzek) {
        boolean z;
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
                        if (zzek.zzm() == 11) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        this.zzi = z2;
                    } else {
                        int zzm2 = zzek.zzm();
                        if (zzm2 == 119) {
                            this.zzi = false;
                            this.zzg = 1;
                            zzek zzek2 = this.zzb;
                            zzek2.zzM()[0] = Ascii.VT;
                            zzek2.zzM()[1] = 119;
                            this.zzh = 2;
                            break;
                        }
                        if (zzm2 == 11) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.zzi = z;
                    }
                }
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
                int min2 = Math.min(zzek.zzb(), 128 - this.zzh);
                zzek.zzG(zzM, this.zzh, min2);
                int i3 = this.zzh + min2;
                this.zzh = i3;
                if (i3 == 128) {
                    this.zza.zzl(0);
                    zzabi zze2 = zzabj.zze(this.zza);
                    zzaf zzaf = this.zzk;
                    if (zzaf == null || zze2.zzc != zzaf.zzz || zze2.zzb != zzaf.zzA || !zzet.zzG(zze2.zza, zzaf.zzm)) {
                        zzad zzad = new zzad();
                        zzad.zzK(this.zze);
                        zzad.zzX(zze2.zza);
                        zzad.zzy(zze2.zzc);
                        zzad.zzY(zze2.zzb);
                        zzad.zzO(this.zzc);
                        zzad.zzV(this.zzd);
                        zzad.zzS(zze2.zzf);
                        if ("audio/ac3".equals(zze2.zza)) {
                            zzad.zzx(zze2.zzf);
                        }
                        zzaf zzad2 = zzad.zzad();
                        this.zzk = zzad2;
                        this.zzf.zzl(zzad2);
                    }
                    this.zzl = zze2.zzd;
                    this.zzj = (((long) zze2.zze) * 1000000) / ((long) this.zzk.zzA);
                    this.zzb.zzK(0);
                    this.zzf.zzq(this.zzb, 128);
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

    public zzalx(String str, int i) {
        zzej zzej = new zzej(new byte[128], 128);
        this.zza = zzej;
        this.zzb = new zzek(zzej.zza);
        this.zzg = 0;
        this.zzm = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
    }

    public final void zzc(boolean z) {
    }
}
