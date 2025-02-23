package com.google.android.gms.internal.ads;

import com.google.common.primitives.UnsignedBytes;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzamr implements zzamf {
    private final zzek zza;
    private final zzadc zzb;
    private final String zzc;
    private final int zzd;
    private zzadp zze;
    private String zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private int zzl;
    private long zzm;

    public zzamr() {
        throw null;
    }

    public final void zza(zzek zzek) {
        boolean z;
        boolean z2;
        zzdi.zzb(this.zze);
        while (zzek.zzb() > 0) {
            int i = this.zzg;
            boolean z3 = true;
            if (i == 0) {
                byte[] zzM = zzek.zzM();
                int zzd2 = zzek.zzd();
                int zze2 = zzek.zze();
                while (true) {
                    if (zzd2 >= zze2) {
                        zzek.zzK(zze2);
                        break;
                    }
                    int i2 = zzd2 + 1;
                    byte b = zzM[zzd2];
                    if ((b & UnsignedBytes.MAX_VALUE) == 255) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!this.zzj || (b & 224) != 224) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    this.zzj = z;
                    if (z2) {
                        zzek.zzK(i2);
                        this.zzj = false;
                        this.zza.zzM()[1] = zzM[zzd2];
                        this.zzh = 2;
                        this.zzg = 1;
                        break;
                    }
                    zzd2 = i2;
                }
            } else if (i != 1) {
                int min = Math.min(zzek.zzb(), this.zzl - this.zzh);
                this.zze.zzq(zzek, min);
                int i3 = this.zzh + min;
                this.zzh = i3;
                if (i3 >= this.zzl) {
                    if (this.zzm == -9223372036854775807L) {
                        z3 = false;
                    }
                    zzdi.zzf(z3);
                    this.zze.zzs(this.zzm, 1, this.zzl, 0, (zzado) null);
                    this.zzm += this.zzk;
                    this.zzh = 0;
                    this.zzg = 0;
                }
            } else {
                int min2 = Math.min(zzek.zzb(), 4 - this.zzh);
                zzek.zzG(this.zza.zzM(), this.zzh, min2);
                int i4 = this.zzh + min2;
                this.zzh = i4;
                if (i4 >= 4) {
                    this.zza.zzK(0);
                    if (!this.zzb.zza(this.zza.zzg())) {
                        this.zzh = 0;
                        this.zzg = 1;
                    } else {
                        zzadc zzadc = this.zzb;
                        this.zzl = zzadc.zzc;
                        if (!this.zzi) {
                            this.zzk = (((long) zzadc.zzg) * 1000000) / ((long) zzadc.zzd);
                            zzad zzad = new zzad();
                            zzad.zzK(this.zzf);
                            zzad.zzX(this.zzb.zzb);
                            zzad.zzP(4096);
                            zzad.zzy(this.zzb.zze);
                            zzad.zzY(this.zzb.zzd);
                            zzad.zzO(this.zzc);
                            zzad.zzV(this.zzd);
                            this.zze.zzl(zzad.zzad());
                            this.zzi = true;
                        }
                        this.zza.zzK(0);
                        this.zze.zzq(this.zza, 4);
                        this.zzg = 2;
                    }
                }
            }
        }
    }

    public final void zzb(zzacn zzacn, zzans zzans) {
        zzans.zzc();
        this.zzf = zzans.zzb();
        this.zze = zzacn.zzw(zzans.zza(), 1);
    }

    public final void zzd(long j, int i) {
        this.zzm = j;
    }

    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzj = false;
        this.zzm = -9223372036854775807L;
    }

    public zzamr(String str, int i) {
        this.zzg = 0;
        zzek zzek = new zzek(4);
        this.zza = zzek;
        zzek.zzM()[0] = -1;
        this.zzb = new zzadc();
        this.zzm = -9223372036854775807L;
        this.zzc = str;
        this.zzd = i;
    }

    public final void zzc(boolean z) {
    }
}
