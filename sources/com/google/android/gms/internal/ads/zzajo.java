package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
abstract class zzajo {
    private final zzajh zza = new zzajh();
    private zzadp zzb;
    private zzacn zzc;
    private zzajj zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private zzajl zzj = new zzajl();
    private long zzk;
    private boolean zzl;
    private boolean zzm;

    public abstract long zza(zzek zzek);

    public void zzb(boolean z) {
        int i;
        if (z) {
            this.zzj = new zzajl();
            this.zzf = 0;
            i = 0;
        } else {
            i = 1;
        }
        this.zzh = i;
        this.zze = -1;
        this.zzg = 0;
    }

    public abstract boolean zzc(zzek zzek, long j, zzajl zzajl) throws IOException;

    public final int zze(zzacl zzacl, zzadf zzadf) throws IOException {
        boolean z;
        zzacl zzacl2 = zzacl;
        zzdi.zzb(this.zzb);
        int i = zzet.zza;
        int i2 = this.zzh;
        if (i2 == 0) {
            while (this.zza.zze(zzacl2)) {
                long zzf2 = zzacl.zzf();
                long j = this.zzf;
                this.zzk = zzf2 - j;
                if (zzc(this.zza.zza(), j, this.zzj)) {
                    this.zzf = zzacl.zzf();
                } else {
                    zzaf zzaf = this.zzj.zza;
                    this.zzi = zzaf.zzA;
                    if (!this.zzm) {
                        this.zzb.zzl(zzaf);
                        this.zzm = true;
                    }
                    zzajj zzajj = this.zzj.zzb;
                    if (zzajj != null) {
                        this.zzd = zzajj;
                    } else if (zzacl.zzd() == -1) {
                        this.zzd = new zzajn((zzajm) null);
                    } else {
                        zzaji zzb2 = this.zza.zzb();
                        if ((zzb2.zza & 4) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.zzd = new zzajd(this, this.zzf, zzacl.zzd(), (long) (zzb2.zzd + zzb2.zze), zzb2.zzb, z);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                }
            }
            this.zzh = 3;
            return -1;
        } else if (i2 == 1) {
            ((zzaby) zzacl2).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        } else if (i2 != 2) {
            return -1;
        } else {
            long zzd2 = this.zzd.zzd(zzacl2);
            if (zzd2 >= 0) {
                zzadf.zza = zzd2;
                return 1;
            }
            if (zzd2 < -1) {
                zzi(-(zzd2 + 2));
            }
            if (!this.zzl) {
                zzadi zze2 = this.zzd.zze();
                zzdi.zzb(zze2);
                this.zzc.zzO(zze2);
                this.zzl = true;
            }
            if (this.zzk > 0 || this.zza.zze(zzacl2)) {
                this.zzk = 0;
                zzek zza2 = this.zza.zza();
                long zza3 = zza(zza2);
                if (zza3 >= 0) {
                    long j2 = this.zzg;
                    if (j2 + zza3 >= this.zze) {
                        long zzf3 = zzf(j2);
                        this.zzb.zzq(zza2, zza2.zze());
                        this.zzb.zzs(zzf3, 1, zza2.zze(), 0, (zzado) null);
                        this.zze = -1;
                    }
                }
                this.zzg += zza3;
            } else {
                this.zzh = 3;
                return -1;
            }
        }
        return 0;
    }

    public final long zzf(long j) {
        return (j * 1000000) / ((long) this.zzi);
    }

    public final long zzg(long j) {
        return (((long) this.zzi) * j) / 1000000;
    }

    public final void zzh(zzacn zzacn, zzadp zzadp) {
        this.zzc = zzacn;
        this.zzb = zzadp;
        zzb(true);
    }

    public void zzi(long j) {
        this.zzg = j;
    }

    public final void zzj(long j, long j2) {
        this.zza.zzc();
        if (j == 0) {
            zzb(!this.zzl);
        } else if (this.zzh != 0) {
            long zzg2 = zzg(j2);
            this.zze = zzg2;
            zzajj zzajj = this.zzd;
            int i = zzet.zza;
            zzajj.zzg(zzg2);
            this.zzh = 2;
        }
    }
}
