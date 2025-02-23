package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaiv {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static zzadm zza(zzacl zzacl) throws IOException {
        return zzc(zzacl, true, false);
    }

    public static zzadm zzb(zzacl zzacl, boolean z) throws IOException {
        return zzc(zzacl, false, z);
    }

    private static zzadm zzc(zzacl zzacl, boolean z, boolean z2) throws IOException {
        zzek zzek;
        int i;
        boolean z3;
        boolean z4;
        zzek zzek2;
        int[] iArr;
        zzacl zzacl2 = zzacl;
        boolean z5 = z2;
        long zzd = zzacl.zzd();
        long j = -1;
        int i2 = (zzd > -1 ? 1 : (zzd == -1 ? 0 : -1));
        long j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (i2 != 0 && zzd <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j2 = zzd;
        }
        zzek zzek3 = new zzek(64);
        int i3 = (int) j2;
        boolean z6 = false;
        int i4 = 0;
        boolean z7 = false;
        while (true) {
            if (i4 >= i3) {
                boolean z8 = z6;
                break;
            }
            zzek3.zzH(8);
            boolean z9 = true;
            if (!zzacl2.zzm(zzek3.zzM(), z6 ? 1 : 0, 8, true)) {
                break;
            }
            long zzu = zzek3.zzu();
            int zzg = zzek3.zzg();
            if (zzu == 1) {
                zzacl2.zzh(zzek3.zzM(), 8, 8);
                i = 16;
                zzek3.zzJ(16);
                zzu = zzek3.zzt();
                zzek = zzek3;
            } else {
                if (zzu == 0) {
                    long zzd2 = zzacl.zzd();
                    if (zzd2 != j) {
                        zzu = (zzd2 - zzacl.zze()) + 8;
                    }
                }
                zzek = zzek3;
                i = 8;
            }
            long j3 = zzu;
            long j4 = (long) i;
            if (j3 < j4) {
                return new zzaig(zzg, j3, i);
            }
            i4 += i;
            if (zzg == 1836019574) {
                i3 += (int) j3;
                if (i2 != 0 && ((long) i3) > zzd) {
                    i3 = (int) zzd;
                }
                zzek3 = zzek;
                j = -1;
                z6 = false;
            } else if (zzg == 1836019558 || zzg == 1836475768) {
                z6 = true;
            } else {
                if (zzg == 1835295092) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                z7 |= !z3;
                int i5 = zzg;
                long j5 = zzd;
                if ((((long) i4) + j3) - j4 >= ((long) i3)) {
                    z6 = false;
                    break;
                }
                int i6 = (int) (j3 - j4);
                i4 += i6;
                if (i5 != 1718909296) {
                    zzek2 = zzek;
                    z4 = false;
                    if (i6 != 0) {
                        zzacl2.zzg(i6);
                    }
                } else if (i6 < 8) {
                    return new zzaig(1718909296, (long) i6, 8);
                } else {
                    zzek2 = zzek;
                    zzek2.zzH(i6);
                    z4 = false;
                    zzacl2.zzh(zzek2.zzM(), 0, i6);
                    int zzg2 = zzek2.zzg();
                    boolean zzd3 = zzd(zzg2, z5) | z7;
                    zzek2.zzL(4);
                    int zzb = zzek2.zzb() / 4;
                    if (!zzd3 && zzb > 0) {
                        iArr = new int[zzb];
                        int i7 = 0;
                        while (true) {
                            if (i7 >= zzb) {
                                z9 = zzd3;
                                break;
                            }
                            int zzg3 = zzek2.zzg();
                            iArr[i7] = zzg3;
                            if (zzd(zzg3, z5)) {
                                break;
                            }
                            i7++;
                        }
                    } else {
                        z9 = zzd3;
                        iArr = null;
                    }
                    if (!z9) {
                        return new zzaja(zzg2, iArr);
                    }
                    z7 = z9;
                }
                zzek3 = zzek2;
                z6 = z4;
                zzd = j5;
                j = -1;
            }
        }
        if (!z7) {
            return zzair.zza;
        }
        if (z == z6) {
            return null;
        }
        if (z6) {
            return zzaim.zza;
        }
        return zzaim.zzb;
    }

    private static boolean zzd(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579) {
            if (z) {
                return true;
            }
            i = 1751476579;
        }
        int[] iArr = zza;
        for (int i2 = 0; i2 < 29; i2++) {
            if (iArr[i2] == i) {
                return true;
            }
        }
        return false;
    }
}
