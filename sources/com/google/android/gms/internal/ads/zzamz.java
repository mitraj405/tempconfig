package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzamz implements zzant {
    private final zzamf zza;
    private final zzej zzb = new zzej(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzer zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzamz(zzamf zzamf) {
        this.zza = zzamf;
    }

    private final void zze(int i) {
        this.zzc = i;
        this.zzd = 0;
    }

    private final boolean zzf(zzek zzek, byte[] bArr, int i) {
        int min = Math.min(zzek.zzb(), i - this.zzd);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            zzek.zzL(min);
        } else {
            zzek.zzG(bArr, this.zzd, min);
        }
        int i2 = this.zzd + min;
        this.zzd = i2;
        if (i2 == i) {
            return true;
        }
        return false;
    }

    public final void zza(zzek zzek, int i) throws zzbo {
        int i2;
        zzek zzek2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        long j;
        int i7;
        int i8;
        boolean z2;
        zzek zzek3 = zzek;
        zzdi.zzb(this.zze);
        int i9 = -1;
        int i10 = 2;
        boolean z3 = false;
        int i11 = 1;
        if ((i & 1) != 0) {
            int i12 = this.zzc;
            if (!(i12 == 0 || i12 == 1)) {
                if (i12 != 2) {
                    int i13 = this.zzj;
                    if (i13 != -1) {
                        zzea.zzf("PesReader", "Unexpected start indicator: expected " + i13 + " more bytes");
                    }
                    if (zzek.zze() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    this.zza.zzc(z2);
                } else {
                    zzea.zzf("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zze(1);
        }
        int i14 = i;
        while (zzek.zzb() > 0) {
            int i15 = this.zzc;
            if (i15 == 0) {
                zzek2 = zzek3;
                i2 = i14;
                zzek2.zzL(zzek.zzb());
            } else if (i15 != i11) {
                if (i15 != i10) {
                    int zzb2 = zzek.zzb();
                    int i16 = this.zzj;
                    if (i16 == i9) {
                        i8 = z3;
                    } else {
                        i8 = zzb2 - i16;
                    }
                    if (i8 > 0) {
                        zzb2 -= i8;
                        zzek3.zzJ(zzek.zzd() + zzb2);
                    }
                    this.zza.zza(zzek3);
                    int i17 = this.zzj;
                    if (i17 != i9) {
                        int i18 = i17 - zzb2;
                        this.zzj = i18;
                        if (i18 == 0) {
                            this.zza.zzc(z3);
                            zze(i11);
                        }
                    }
                } else {
                    if (zzf(zzek3, this.zzb.zza, Math.min(10, this.zzi)) && zzf(zzek3, (byte[]) null, this.zzi)) {
                        this.zzb.zzl(z3 ? 1 : 0);
                        if (this.zzf) {
                            this.zzb.zzn(4);
                            long zzd2 = (long) this.zzb.zzd(3);
                            this.zzb.zzn(i11);
                            int zzd3 = this.zzb.zzd(15) << 15;
                            this.zzb.zzn(i11);
                            long zzd4 = (long) this.zzb.zzd(15);
                            this.zzb.zzn(i11);
                            if (this.zzh || !this.zzg) {
                                i6 = i14;
                            } else {
                                this.zzb.zzn(4);
                                this.zzb.zzn(i11);
                                this.zzb.zzn(i11);
                                long zzd5 = (long) this.zzb.zzd(15);
                                this.zzb.zzn(i11);
                                i6 = i14;
                                this.zze.zzb(((long) (this.zzb.zzd(15) << 15)) | (((long) this.zzb.zzd(3)) << 30) | zzd5);
                                this.zzh = true;
                            }
                            j = this.zze.zzb((zzd2 << 30) | ((long) zzd3) | zzd4);
                        } else {
                            i6 = i14;
                            j = -9223372036854775807L;
                        }
                        if (true != this.zzk) {
                            i7 = 0;
                        } else {
                            i7 = 4;
                        }
                        int i19 = i7 | i6;
                        this.zza.zzd(j, i19);
                        zze(3);
                        i10 = 2;
                        z3 = false;
                        i11 = 1;
                        i14 = i19;
                        i9 = -1;
                        zzek3 = zzek;
                    }
                }
                i2 = i14;
                zzek2 = zzek;
            } else {
                i2 = i14;
                zzek2 = zzek;
                if (zzf(zzek2, this.zzb.zza, 9)) {
                    z = false;
                    this.zzb.zzl(0);
                    int zzd6 = this.zzb.zzd(24);
                    i3 = 1;
                    if (zzd6 != 1) {
                        C0709Uj.t("Unexpected start code prefix: ", zzd6, "PesReader");
                        i4 = -1;
                        this.zzj = -1;
                        i10 = 2;
                        i5 = 0;
                    } else {
                        this.zzb.zzn(8);
                        zzej zzej = this.zzb;
                        int zzd7 = zzej.zzd(16);
                        zzej.zzn(5);
                        this.zzk = this.zzb.zzp();
                        i5 = 2;
                        this.zzb.zzn(2);
                        this.zzf = this.zzb.zzp();
                        this.zzg = this.zzb.zzp();
                        this.zzb.zzn(6);
                        int zzd8 = this.zzb.zzd(8);
                        this.zzi = zzd8;
                        if (zzd7 == 0) {
                            i4 = -1;
                            this.zzj = -1;
                        } else {
                            int i20 = (zzd7 - 3) - zzd8;
                            this.zzj = i20;
                            if (i20 < 0) {
                                C0709Uj.t("Found negative packet payload size: ", i20, "PesReader");
                                i4 = -1;
                                this.zzj = -1;
                            } else {
                                i4 = -1;
                            }
                        }
                        i10 = 2;
                    }
                    zze(i5);
                } else {
                    i4 = -1;
                    z = false;
                    i3 = 1;
                    i10 = 2;
                }
                z3 = z;
                i11 = i3;
                i9 = i4;
            }
            zzek3 = zzek2;
            i14 = i2;
        }
    }

    public final void zzb(zzer zzer, zzacn zzacn, zzans zzans) {
        this.zze = zzer;
        this.zza.zzb(zzacn, zzans);
    }

    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }

    public final boolean zzd(boolean z) {
        if (this.zzc == 3 && this.zzj == -1) {
            return true;
        }
        return false;
    }
}
