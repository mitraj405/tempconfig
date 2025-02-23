package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzanl {
    private final zzer zza = new zzer(0);
    private final zzek zzb = new zzek();
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private long zzh = -9223372036854775807L;

    public zzanl(int i) {
    }

    private final int zze(zzacl zzacl) {
        byte[] bArr = zzet.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
        this.zzc = true;
        zzacl.zzj();
        return 0;
    }

    public final int zza(zzacl zzacl, zzadf zzadf, int i) throws IOException {
        if (i <= 0) {
            zze(zzacl);
            return 0;
        }
        long j = -9223372036854775807L;
        if (!this.zze) {
            long zzd2 = zzacl.zzd();
            int min = (int) Math.min(112800, zzd2);
            long j2 = zzd2 - ((long) min);
            if (zzacl.zzf() != j2) {
                zzadf.zza = j2;
            } else {
                this.zzb.zzH(min);
                zzacl.zzj();
                ((zzaby) zzacl).zzm(this.zzb.zzM(), 0, min, false);
                zzek zzek = this.zzb;
                int zzd3 = zzek.zzd();
                int zze2 = zzek.zze();
                int i2 = zze2 - 188;
                while (true) {
                    if (i2 < zzd3) {
                        break;
                    }
                    byte[] zzM = zzek.zzM();
                    int i3 = -4;
                    int i4 = 0;
                    while (true) {
                        if (i3 > 4) {
                            break;
                        }
                        int i5 = (i3 * 188) + i2;
                        if (i5 < zzd3 || i5 >= zze2 || zzM[i5] != 71) {
                            i4 = 0;
                        } else {
                            i4++;
                            if (i4 == 5) {
                                long zzb2 = zzanu.zzb(zzek, i2, i);
                                if (zzb2 != -9223372036854775807L) {
                                    j = zzb2;
                                    break;
                                }
                            }
                        }
                        i3++;
                    }
                    i2--;
                }
                this.zzg = j;
                this.zze = true;
                return 0;
            }
        } else if (this.zzg == -9223372036854775807L) {
            zze(zzacl);
            return 0;
        } else if (!this.zzd) {
            int min2 = (int) Math.min(112800, zzacl.zzd());
            if (zzacl.zzf() != 0) {
                zzadf.zza = 0;
            } else {
                this.zzb.zzH(min2);
                zzacl.zzj();
                ((zzaby) zzacl).zzm(this.zzb.zzM(), 0, min2, false);
                zzek zzek2 = this.zzb;
                int zzd4 = zzek2.zzd();
                int zze3 = zzek2.zze();
                while (true) {
                    if (zzd4 >= zze3) {
                        break;
                    }
                    if (zzek2.zzM()[zzd4] == 71) {
                        long zzb3 = zzanu.zzb(zzek2, zzd4, i);
                        if (zzb3 != -9223372036854775807L) {
                            j = zzb3;
                            break;
                        }
                    }
                    zzd4++;
                }
                this.zzf = j;
                this.zzd = true;
                return 0;
            }
        } else {
            long j3 = this.zzf;
            if (j3 == -9223372036854775807L) {
                zze(zzacl);
                return 0;
            }
            zzer zzer = this.zza;
            this.zzh = zzer.zzc(this.zzg) - zzer.zzb(j3);
            zze(zzacl);
            return 0;
        }
        return 1;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final zzer zzc() {
        return this.zza;
    }

    public final boolean zzd() {
        return this.zzc;
    }
}
