package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzand {
    private final zzer zza = new zzer(0);
    private final zzek zzb = new zzek();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;

    public static long zzc(zzek zzek) {
        zzek zzek2 = zzek;
        int zzd2 = zzek.zzd();
        if (zzek.zzb() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        zzek2.zzG(bArr, 0, 9);
        zzek2.zzK(zzd2);
        byte b = bArr[0];
        if ((b & 196) != 68) {
            return -9223372036854775807L;
        }
        byte b2 = bArr[2];
        if ((b2 & 4) != 4) {
            return -9223372036854775807L;
        }
        byte b3 = bArr[4];
        if ((b3 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return -9223372036854775807L;
        }
        long j = (long) b;
        long j2 = (long) bArr[1];
        long j3 = (long) b2;
        long j4 = (j2 & 255) << 20;
        long j5 = (j3 & 3) << 13;
        long j6 = j5 | j4 | ((j & 3) << 28) | (((j & 56) >> 3) << 30) | (((248 & j3) >> 3) << 15);
        return j6 | ((((long) bArr[3]) & 255) << 5) | ((((long) b3) & 248) >> 3);
    }

    private final int zzf(zzacl zzacl) {
        byte[] bArr = zzet.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzacl.zzj();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & UnsignedBytes.MAX_VALUE) | ((bArr[i] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8);
    }

    public final int zza(zzacl zzacl, zzadf zzadf) throws IOException {
        long j = -9223372036854775807L;
        if (!this.zze) {
            long zzd2 = zzacl.zzd();
            int min = (int) Math.min(20000, zzd2);
            long j2 = zzd2 - ((long) min);
            if (zzacl.zzf() != j2) {
                zzadf.zza = j2;
                return 1;
            }
            this.zzb.zzH(min);
            zzacl.zzj();
            ((zzaby) zzacl).zzm(this.zzb.zzM(), 0, min, false);
            zzek zzek = this.zzb;
            int zzd3 = zzek.zzd();
            int zze2 = zzek.zze() - 4;
            while (true) {
                if (zze2 < zzd3) {
                    break;
                }
                if (zzg(zzek.zzM(), zze2) == 442) {
                    zzek.zzK(zze2 + 4);
                    long zzc2 = zzc(zzek);
                    if (zzc2 != -9223372036854775807L) {
                        j = zzc2;
                        break;
                    }
                }
                zze2--;
            }
            this.zzg = j;
            this.zze = true;
        } else if (this.zzg == -9223372036854775807L) {
            zzf(zzacl);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(20000, zzacl.zzd());
            if (zzacl.zzf() != 0) {
                zzadf.zza = 0;
                return 1;
            }
            this.zzb.zzH(min2);
            zzacl.zzj();
            ((zzaby) zzacl).zzm(this.zzb.zzM(), 0, min2, false);
            zzek zzek2 = this.zzb;
            int zzd4 = zzek2.zzd();
            int zze3 = zzek2.zze();
            while (true) {
                if (zzd4 >= zze3 - 3) {
                    break;
                }
                if (zzg(zzek2.zzM(), zzd4) == 442) {
                    zzek2.zzK(zzd4 + 4);
                    long zzc3 = zzc(zzek2);
                    if (zzc3 != -9223372036854775807L) {
                        j = zzc3;
                        break;
                    }
                }
                zzd4++;
            }
            this.zzf = j;
            this.zzd = true;
        } else {
            long j3 = this.zzf;
            if (j3 == -9223372036854775807L) {
                zzf(zzacl);
                return 0;
            }
            zzer zzer = this.zza;
            this.zzh = zzer.zzc(this.zzg) - zzer.zzb(j3);
            zzf(zzacl);
            return 0;
        }
        return 0;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzer zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }
}
