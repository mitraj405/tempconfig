package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaeo implements zzack {
    private final byte[] zza;
    private final zzek zzb;
    private final zzacq zzc;
    private zzacn zzd;
    private zzadp zze;
    private int zzf;
    private zzbk zzg;
    private zzacv zzh;
    private int zzi;
    private int zzj;
    private zzaen zzk;
    private int zzl;
    private long zzm;

    public zzaeo() {
        throw null;
    }

    private final long zza(zzek zzek, boolean z) {
        boolean z2;
        this.zzh.getClass();
        int zzd2 = zzek.zzd();
        while (zzd2 <= zzek.zze() - 16) {
            zzek.zzK(zzd2);
            if (zzacr.zzc(zzek, this.zzh, this.zzj, this.zzc)) {
                zzek.zzK(zzd2);
                return this.zzc.zza;
            }
            zzd2++;
        }
        if (z) {
            while (zzd2 <= zzek.zze() - this.zzi) {
                zzek.zzK(zzd2);
                try {
                    z2 = zzacr.zzc(zzek, this.zzh, this.zzj, this.zzc);
                } catch (IndexOutOfBoundsException unused) {
                    z2 = false;
                }
                if (zzek.zzd() <= zzek.zze() && z2) {
                    zzek.zzK(zzd2);
                    return this.zzc.zza;
                }
                zzd2++;
            }
            zzek.zzK(zzek.zze());
            return -1;
        }
        zzek.zzK(zzd2);
        return -1;
    }

    private final void zzg() {
        zzacv zzacv = this.zzh;
        int i = zzet.zza;
        this.zze.zzs((this.zzm * 1000000) / ((long) zzacv.zze), 1, this.zzl, 0, (zzado) null);
    }

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        boolean zzp;
        zzadi zzadi;
        zzacl zzacl2 = zzacl;
        int i = this.zzf;
        boolean z = true;
        if (i == 0) {
            zzacl.zzj();
            long zze2 = zzacl.zze();
            zzbk zza2 = zzacs.zza(zzacl2, true);
            ((zzaby) zzacl2).zzo((int) (zzacl.zze() - zze2), false);
            this.zzg = zza2;
            this.zzf = 1;
            return 0;
        } else if (i == 1) {
            ((zzaby) zzacl2).zzm(this.zza, 0, 42, false);
            zzacl.zzj();
            this.zzf = 2;
            return 0;
        } else if (i == 2) {
            zzek zzek = new zzek(4);
            ((zzaby) zzacl2).zzn(zzek.zzM(), 0, 4, false);
            if (zzek.zzu() == 1716281667) {
                this.zzf = 3;
                return 0;
            }
            throw zzbo.zza("Failed to read FLAC stream marker.", (Throwable) null);
        } else if (i == 3) {
            zzacv zzacv = this.zzh;
            do {
                zzacl.zzj();
                zzej zzej = new zzej(new byte[4], 4);
                zzaby zzaby = (zzaby) zzacl2;
                zzaby.zzm(zzej.zza, 0, 4, false);
                zzp = zzej.zzp();
                int zzd2 = zzej.zzd(7);
                int zzd3 = zzej.zzd(24) + 4;
                if (zzd2 == 0) {
                    byte[] bArr = new byte[38];
                    zzaby.zzn(bArr, 0, 38, false);
                    zzacv = new zzacv(bArr, 4);
                } else if (zzacv == null) {
                    throw new IllegalArgumentException();
                } else if (zzd2 == 3) {
                    zzek zzek2 = new zzek(zzd3);
                    zzaby.zzn(zzek2.zzM(), 0, zzd3, false);
                    zzacv = zzacv.zzf(zzacs.zzb(zzek2));
                } else if (zzd2 == 4) {
                    zzek zzek3 = new zzek(zzd3);
                    zzaby.zzn(zzek3.zzM(), 0, zzd3, false);
                    zzek3.zzL(4);
                    zzacv = zzacv.zzg(Arrays.asList(zzadv.zzc(zzek3, false, false).zza));
                } else if (zzd2 == 6) {
                    zzek zzek4 = new zzek(zzd3);
                    zzaby.zzn(zzek4.zzM(), 0, zzd3, false);
                    zzek4.zzL(4);
                    zzacv = zzacv.zze(zzfxr.zzn(zzafj.zzb(zzek4)));
                } else {
                    zzaby.zzo(zzd3, false);
                }
                int i2 = zzet.zza;
                this.zzh = zzacv;
            } while (!zzp);
            zzacv.getClass();
            this.zzi = Math.max(zzacv.zzc, 6);
            this.zze.zzl(this.zzh.zzc(this.zza, this.zzg));
            this.zzf = 4;
            return 0;
        } else if (i != 4) {
            this.zze.getClass();
            zzacv zzacv2 = this.zzh;
            zzacv2.getClass();
            zzaen zzaen = this.zzk;
            if (zzaen != null && zzaen.zze()) {
                return zzaen.zza(zzacl2, zzadf);
            }
            if (this.zzm == -1) {
                this.zzm = zzacr.zzb(zzacl2, zzacv2);
                return 0;
            }
            zzek zzek5 = this.zzb;
            int zze3 = zzek5.zze();
            if (zze3 < 32768) {
                int zza3 = zzacl2.zza(zzek5.zzM(), zze3, 32768 - zze3);
                if (zza3 != -1) {
                    z = false;
                }
                if (!z) {
                    this.zzb.zzJ(zze3 + zza3);
                } else if (this.zzb.zzb() == 0) {
                    zzg();
                    return -1;
                }
            } else {
                z = false;
            }
            zzek zzek6 = this.zzb;
            int zzd4 = zzek6.zzd();
            int i3 = this.zzl;
            int i4 = this.zzi;
            if (i3 < i4) {
                zzek6.zzL(Math.min(i4 - i3, zzek6.zzb()));
            }
            long zza4 = zza(this.zzb, z);
            zzek zzek7 = this.zzb;
            int zzd5 = zzek7.zzd() - zzd4;
            zzek7.zzK(zzd4);
            this.zze.zzq(this.zzb, zzd5);
            this.zzl += zzd5;
            if (zza4 != -1) {
                zzg();
                this.zzl = 0;
                this.zzm = zza4;
            }
            zzek zzek8 = this.zzb;
            if (zzek8.zzb() >= 16) {
                return 0;
            }
            int zzb2 = zzek8.zzb();
            System.arraycopy(zzek8.zzM(), zzek8.zzd(), zzek8.zzM(), 0, zzb2);
            this.zzb.zzK(0);
            this.zzb.zzJ(zzb2);
            return 0;
        } else {
            zzacl.zzj();
            zzek zzek9 = new zzek(2);
            ((zzaby) zzacl2).zzm(zzek9.zzM(), 0, 2, false);
            int zzq = zzek9.zzq();
            if ((zzq >> 2) == 16382) {
                zzacl.zzj();
                this.zzj = zzq;
                zzacn zzacn = this.zzd;
                int i5 = zzet.zza;
                long zzf2 = zzacl.zzf();
                long zzd6 = zzacl.zzd();
                zzacv zzacv3 = this.zzh;
                zzacv3.getClass();
                if (zzacv3.zzk != null) {
                    zzadi = new zzact(zzacv3, zzf2);
                } else if (zzd6 == -1 || zzacv3.zzj <= 0) {
                    zzadi = new zzadh(zzacv3.zza(), 0);
                } else {
                    zzaen zzaen2 = new zzaen(zzacv3, this.zzj, zzf2, zzd6);
                    this.zzk = zzaen2;
                    zzadi = zzaen2.zzb();
                }
                zzacn.zzO(zzadi);
                this.zzf = 5;
                return 0;
            }
            zzacl.zzj();
            throw zzbo.zza("First frame does not start with sync code.", (Throwable) null);
        }
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zzd = zzacn;
        this.zze = zzacn.zzw(0, 1);
        zzacn.zzD();
    }

    public final void zzi(long j, long j2) {
        long j3 = 0;
        if (j == 0) {
            this.zzf = 0;
        } else {
            zzaen zzaen = this.zzk;
            if (zzaen != null) {
                zzaen.zzd(j2);
            }
        }
        if (j2 != 0) {
            j3 = -1;
        }
        this.zzm = j3;
        this.zzl = 0;
        this.zzb.zzH(0);
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        zzacs.zza(zzacl, false);
        zzek zzek = new zzek(4);
        ((zzaby) zzacl).zzm(zzek.zzM(), 0, 4, false);
        if (zzek.zzu() == 1716281667) {
            return true;
        }
        return false;
    }

    public zzaeo(int i) {
        this.zza = new byte[42];
        this.zzb = new zzek(new byte[32768], 0);
        this.zzc = new zzacq();
        this.zzf = 0;
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
