package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzams implements zzamf {
    private final zzek zza = new zzek(new byte[15], 2);
    private final zzej zzb = new zzej();
    private final zzek zzc = new zzek();
    private int zzd = 0;
    private String zze;
    private zzadp zzf;
    private double zzg = -9.223372036854776E18d;
    private double zzh = -9.223372036854776E18d;
    private boolean zzi;
    private boolean zzj = true;
    private int zzk;
    private int zzl;
    private boolean zzm = true;
    private int zzn;
    private int zzo;
    private final zzamt zzp = new zzamt();
    private int zzq = -2147483647;
    private int zzr = -1;
    private int zzs;
    private long zzt = -1;
    private boolean zzu;

    private static final void zzf(zzek zzek, zzek zzek2, boolean z) {
        int zzd2 = zzek.zzd();
        int min = Math.min(zzek.zzb(), zzek2.zzb());
        zzek.zzG(zzek2.zzM(), zzek2.zzd(), min);
        zzek2.zzL(min);
        if (z) {
            zzek.zzK(zzd2);
        }
    }

    public final void zza(zzek zzek) throws zzbo {
        int i;
        zzdi.zzb(this.zzf);
        while (zzek.zzb() > 0) {
            int i2 = this.zzd;
            int i3 = 0;
            if (i2 == 0) {
                int i4 = this.zzk;
                if ((i4 & 2) == 0) {
                    zzek.zzK(zzek.zze());
                } else {
                    if ((i4 & 4) == 0) {
                        while (true) {
                            if (zzek.zzb() <= 0) {
                                break;
                            }
                            int i5 = this.zzl << 8;
                            this.zzl = i5;
                            int zzm2 = i5 | zzek.zzm();
                            this.zzl = zzm2;
                            if ((zzm2 & 16777215) == 12583333) {
                                zzek.zzK(zzek.zzd() - 3);
                                this.zzl = 0;
                                break;
                            }
                        }
                    }
                    this.zzd = 1;
                }
            } else if (i2 != 1) {
                int i6 = this.zzp.zza;
                if (i6 == 1 || i6 == 17) {
                    zzf(zzek, this.zzc, true);
                }
                int min = Math.min(zzek.zzb(), this.zzp.zzc - this.zzn);
                this.zzf.zzq(zzek, min);
                int i7 = this.zzn + min;
                this.zzn = i7;
                zzamt zzamt = this.zzp;
                if (i7 == zzamt.zzc) {
                    int i8 = zzamt.zza;
                    if (i8 == 1) {
                        byte[] zzM = this.zzc.zzM();
                        zzamv zza2 = zzamw.zza(new zzej(zzM, zzM.length));
                        this.zzq = zza2.zzb;
                        this.zzr = zza2.zzc;
                        long j = this.zzt;
                        long j2 = this.zzp.zzb;
                        if (j != j2) {
                            this.zzt = j2;
                            int i9 = zza2.zza;
                            String str = "mhm1";
                            if (i9 != -1) {
                                str = str.concat(String.valueOf(String.format(".%02X", new Object[]{Integer.valueOf(i9)})));
                            }
                            byte[] bArr = zza2.zzd;
                            zzfxr zzfxr = null;
                            if (bArr != null && bArr.length > 0) {
                                zzfxr = zzfxr.zzo(zzet.zzf, bArr);
                            }
                            zzad zzad = new zzad();
                            zzad.zzK(this.zze);
                            zzad.zzX("audio/mhm1");
                            zzad.zzY(this.zzq);
                            zzad.zzz(str);
                            zzad.zzL(zzfxr);
                            this.zzf.zzl(zzad.zzad());
                        }
                        this.zzu = true;
                    } else if (i8 == 17) {
                        byte[] zzM2 = this.zzc.zzM();
                        zzej zzej = new zzej(zzM2, zzM2.length);
                        if (zzej.zzp()) {
                            zzej.zzn(2);
                            i3 = zzej.zzd(13);
                        }
                        this.zzs = i3;
                    } else if (i8 == 2) {
                        if (this.zzu) {
                            this.zzj = false;
                            i = 1;
                        } else {
                            i = 0;
                        }
                        int i10 = this.zzr - this.zzs;
                        double d = (double) this.zzq;
                        long round = Math.round(this.zzg);
                        if (this.zzi) {
                            this.zzi = false;
                            this.zzg = this.zzh;
                        } else {
                            this.zzg += (((double) i10) * 1000000.0d) / d;
                        }
                        this.zzf.zzs(round, i, this.zzo, 0, (zzado) null);
                        this.zzu = false;
                        this.zzs = 0;
                        this.zzo = 0;
                    }
                    this.zzd = 1;
                }
            } else {
                zzf(zzek, this.zza, false);
                zzek zzek2 = this.zza;
                if (zzek2.zzb() == 0) {
                    zzej zzej2 = this.zzb;
                    int zze2 = zzek2.zze();
                    zzej2.zzk(zzek2.zzM(), zze2);
                    if (zzamw.zzb(this.zzb, this.zzp)) {
                        this.zzn = 0;
                        this.zzo = this.zzp.zzc + zze2 + this.zzo;
                        this.zza.zzK(0);
                        zzadp zzadp = this.zzf;
                        zzek zzek3 = this.zza;
                        zzadp.zzq(zzek3, zzek3.zze());
                        this.zza.zzH(2);
                        this.zzc.zzH(this.zzp.zzc);
                        this.zzm = true;
                        this.zzd = 2;
                    } else {
                        zzek zzek4 = this.zza;
                        if (zzek4.zze() < 15) {
                            zzek4.zzJ(zzek4.zze() + 1);
                        }
                    }
                }
                this.zzm = false;
            }
        }
    }

    public final void zzb(zzacn zzacn, zzans zzans) {
        zzans.zzc();
        this.zze = zzans.zzb();
        this.zzf = zzacn.zzw(zzans.zza(), 1);
    }

    public final void zzd(long j, int i) {
        this.zzk = i;
        if (!this.zzj && (this.zzo != 0 || !this.zzm)) {
            this.zzi = true;
        }
        if (j != -9223372036854775807L) {
            double d = (double) j;
            if (this.zzi) {
                this.zzh = d;
            } else {
                this.zzg = d;
            }
        }
    }

    public final void zze() {
        this.zzd = 0;
        this.zzl = 0;
        this.zza.zzH(2);
        this.zzn = 0;
        this.zzo = 0;
        this.zzq = -2147483647;
        this.zzr = -1;
        this.zzs = 0;
        this.zzt = -1;
        this.zzu = false;
        this.zzi = false;
        this.zzm = true;
        this.zzj = true;
        this.zzg = -9.223372036854776E18d;
        this.zzh = -9.223372036854776E18d;
    }

    public final void zzc(boolean z) {
    }
}
