package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzanb implements zzabt {
    private final zzer zza;
    private final zzek zzb = new zzek();

    public /* synthetic */ zzanb(zzer zzer, zzana zzana) {
        this.zza = zzer;
    }

    public final zzabs zza(zzacl zzacl, long j) throws IOException {
        int zzh;
        long j2;
        long zzf = zzacl.zzf();
        int min = (int) Math.min(20000, zzacl.zzd() - zzf);
        this.zzb.zzH(min);
        ((zzaby) zzacl).zzm(this.zzb.zzM(), 0, min, false);
        int i = -1;
        long j3 = -9223372036854775807L;
        int i2 = -1;
        while (true) {
            zzek zzek = this.zzb;
            if (zzek.zzb() >= 4) {
                if (zzanc.zzh(zzek.zzM(), zzek.zzd()) != 442) {
                    zzek.zzL(1);
                } else {
                    zzek.zzL(4);
                    long zzc = zzand.zzc(zzek);
                    if (zzc != -9223372036854775807L) {
                        long zzb2 = this.zza.zzb(zzc);
                        if (zzb2 > j) {
                            if (j3 == -9223372036854775807L) {
                                return zzabs.zzd(zzb2, zzf);
                            }
                            j2 = (long) i2;
                        } else if (100000 + zzb2 > j) {
                            j2 = (long) zzek.zzd();
                            break;
                        } else {
                            i2 = zzek.zzd();
                            j3 = zzb2;
                        }
                    }
                    int zze = zzek.zze();
                    if (zzek.zzb() >= 10) {
                        zzek.zzL(9);
                        int zzm = zzek.zzm() & 7;
                        if (zzek.zzb() >= zzm) {
                            zzek.zzL(zzm);
                            if (zzek.zzb() >= 4) {
                                if (zzanc.zzh(zzek.zzM(), zzek.zzd()) == 443) {
                                    zzek.zzL(4);
                                    int zzq = zzek.zzq();
                                    if (zzek.zzb() < zzq) {
                                        zzek.zzK(zze);
                                    } else {
                                        zzek.zzL(zzq);
                                    }
                                }
                                while (true) {
                                    if (zzek.zzb() < 4 || (zzh = zzanc.zzh(zzek.zzM(), zzek.zzd())) == 442 || zzh == 441 || (zzh >>> 8) != 1) {
                                        break;
                                    }
                                    zzek.zzL(4);
                                    if (zzek.zzb() < 2) {
                                        zzek.zzK(zze);
                                        break;
                                    }
                                    zzek.zzK(Math.min(zzek.zze(), zzek.zzd() + zzek.zzq()));
                                }
                            } else {
                                zzek.zzK(zze);
                            }
                        } else {
                            zzek.zzK(zze);
                        }
                    } else {
                        zzek.zzK(zze);
                    }
                    i = zzek.zzd();
                }
            } else if (j3 != -9223372036854775807L) {
                return zzabs.zzf(j3, zzf + ((long) i));
            } else {
                return zzabs.zza;
            }
        }
        return zzabs.zze(zzf + j2);
    }

    public final void zzb() {
        byte[] bArr = zzet.zzf;
        int length = bArr.length;
        this.zzb.zzI(bArr, 0);
    }
}
