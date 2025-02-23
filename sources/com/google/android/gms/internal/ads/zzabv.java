package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzabv {
    public static void zza(long j, zzek zzek, zzadp[] zzadpArr) {
        int i;
        boolean z;
        while (true) {
            boolean z2 = true;
            if (zzek.zzb() > 1) {
                int zzc = zzc(zzek);
                int zzc2 = zzc(zzek);
                int zzd = zzek.zzd() + zzc2;
                if (zzc2 == -1 || zzc2 > zzek.zzb()) {
                    zzea.zzf("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    zzd = zzek.zze();
                } else if (zzc == 4 && zzc2 >= 8) {
                    int zzm = zzek.zzm();
                    int zzq = zzek.zzq();
                    if (zzq == 49) {
                        i = zzek.zzg();
                        zzq = 49;
                    } else {
                        i = 0;
                    }
                    int zzm2 = zzek.zzm();
                    if (zzq == 47) {
                        zzek.zzL(1);
                        zzq = 47;
                    }
                    if (zzm == 181 && ((zzq == 49 || zzq == 47) && zzm2 == 3)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (zzq == 49) {
                        if (i != 1195456820) {
                            z2 = false;
                        }
                        z &= z2;
                    }
                    if (z) {
                        zzb(j, zzek, zzadpArr);
                    }
                }
                zzek.zzK(zzd);
            } else {
                return;
            }
        }
    }

    public static void zzb(long j, zzek zzek, zzadp[] zzadpArr) {
        boolean z;
        zzek zzek2 = zzek;
        zzadp[] zzadpArr2 = zzadpArr;
        int zzm = zzek.zzm();
        if ((zzm & 64) != 0) {
            int i = zzm & 31;
            zzek2.zzL(1);
            int zzd = zzek.zzd();
            for (zzadp zzadp : zzadpArr2) {
                int i2 = i * 3;
                zzek2.zzK(zzd);
                zzadp.zzq(zzek2, i2);
                if (j != -9223372036854775807L) {
                    z = true;
                } else {
                    z = false;
                }
                zzdi.zzf(z);
                zzadp.zzs(j, 1, i2, 0, (zzado) null);
            }
        }
    }

    private static int zzc(zzek zzek) {
        int i = 0;
        while (zzek.zzb() != 0) {
            int zzm = zzek.zzm();
            i += zzm;
            if (zzm != 255) {
                return i;
            }
        }
        return -1;
    }
}
