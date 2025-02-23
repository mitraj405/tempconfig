package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaif {
    private static final byte[] zza = "OpusHead".getBytes(zzfuj.zzc);

    static {
        int i = zzet.zza;
    }

    public static zzbk zza(zzahv zzahv) {
        zzex zzex;
        zzahw zzb = zzahv.zzb(1751411826);
        zzahw zzb2 = zzahv.zzb(1801812339);
        zzahw zzb3 = zzahv.zzb(1768715124);
        if (!(zzb == null || zzb2 == null || zzb3 == null || zzg(zzb.zza) != 1835299937)) {
            zzek zzek = zzb2.zza;
            zzek.zzK(12);
            int zzg = zzek.zzg();
            String[] strArr = new String[zzg];
            for (int i = 0; i < zzg; i++) {
                int zzg2 = zzek.zzg();
                zzek.zzL(4);
                strArr[i] = zzek.zzA(zzg2 - 8, zzfuj.zzc);
            }
            zzek zzek2 = zzb3.zza;
            zzek2.zzK(8);
            ArrayList arrayList = new ArrayList();
            while (zzek2.zzb() > 8) {
                int zzg3 = zzek2.zzg() + zzek2.zzd();
                int zzg4 = zzek2.zzg() - 1;
                if (zzg4 < 0 || zzg4 >= zzg) {
                    C0709Uj.t("Skipped metadata with unknown key index: ", zzg4, "AtomParsers");
                } else {
                    String str = strArr[zzg4];
                    while (true) {
                        int zzd = zzek2.zzd();
                        if (zzd >= zzg3) {
                            zzex = null;
                            break;
                        }
                        int zzg5 = zzek2.zzg();
                        if (zzek2.zzg() == 1684108385) {
                            int zzg6 = zzek2.zzg();
                            int zzg7 = zzek2.zzg();
                            int i2 = zzg5 - 16;
                            byte[] bArr = new byte[i2];
                            zzek2.zzG(bArr, 0, i2);
                            zzex = new zzex(str, bArr, zzg7, zzg6);
                            break;
                        }
                        zzek2.zzK(zzd + zzg5);
                    }
                    if (zzex != null) {
                        arrayList.add(zzex);
                    }
                }
                zzek2.zzK(zzg3);
            }
            if (!arrayList.isEmpty()) {
                return new zzbk((List) arrayList);
            }
        }
        return null;
    }

    public static zzbk zzb(zzahw zzahw) {
        int i;
        zzek zzek = zzahw.zza;
        zzek.zzK(8);
        zzbk zzbk = new zzbk(-9223372036854775807L, new zzbj[0]);
        while (zzek.zzb() >= 8) {
            int zzd = zzek.zzd();
            int zzg = zzek.zzg() + zzd;
            int zzg2 = zzek.zzg();
            zzbk zzbk2 = null;
            if (zzg2 == 1835365473) {
                zzek.zzK(zzd);
                zzek.zzL(8);
                zze(zzek);
                while (true) {
                    if (zzek.zzd() >= zzg) {
                        break;
                    }
                    int zzd2 = zzek.zzd();
                    int zzg3 = zzek.zzg() + zzd2;
                    if (zzek.zzg() == 1768715124) {
                        zzek.zzK(zzd2);
                        zzek.zzL(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzek.zzd() < zzg3) {
                            zzbj zza2 = zzain.zza(zzek);
                            if (zza2 != null) {
                                arrayList.add(zza2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzbk2 = new zzbk((List) arrayList);
                        }
                    } else {
                        zzek.zzK(zzg3);
                    }
                }
                zzbk = zzbk.zzd(zzbk2);
            } else if (zzg2 == 1936553057) {
                zzek.zzK(zzd);
                zzek.zzL(12);
                while (true) {
                    if (zzek.zzd() >= zzg) {
                        break;
                    }
                    int zzd3 = zzek.zzd();
                    int zzg4 = zzek.zzg();
                    if (zzek.zzg() != 1935766900) {
                        zzek.zzK(zzd3 + zzg4);
                    } else if (zzg4 >= 16) {
                        zzek.zzL(4);
                        int i2 = -1;
                        int i3 = 0;
                        for (int i4 = 0; i4 < 2; i4++) {
                            int zzm = zzek.zzm();
                            int zzm2 = zzek.zzm();
                            if (zzm == 0) {
                                i2 = zzm2;
                            } else if (zzm == 1) {
                                i3 = zzm2;
                            }
                        }
                        if (i2 == 12) {
                            i = 240;
                        } else if (i2 == 13) {
                            i = 120;
                        } else {
                            if (i2 == 21 && zzek.zzb() >= 8 && zzek.zzd() + 8 <= zzg) {
                                int zzg5 = zzek.zzg();
                                int zzg6 = zzek.zzg();
                                if (zzg5 >= 12 && zzg6 == 1936877170) {
                                    i = zzek.zzn();
                                }
                            }
                            i = -2147483647;
                        }
                        if (i != -2147483647) {
                            zzbk2 = new zzbk(-9223372036854775807L, new zzagy((float) i, i3));
                        }
                    }
                }
                zzbk = zzbk.zzd(zzbk2);
            } else if (zzg2 == -1451722374) {
                zzbk = zzbk.zzd(zzi(zzek));
            }
            zzek.zzK(zzg);
        }
        return zzbk;
    }

    public static zzfd zzc(zzek zzek) {
        long j;
        long j2;
        zzek.zzK(8);
        if (zzahx.zze(zzek.zzg()) == 0) {
            j2 = zzek.zzu();
            j = zzek.zzu();
        } else {
            j2 = zzek.zzt();
            j = zzek.zzt();
        }
        return new zzfd(j2, j, zzek.zzu());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:340:0x070f, code lost:
        if (r11.zzd(1) > 0) goto L_0x0711;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x0733, code lost:
        if (r13 == 1) goto L_0x0735;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00eb, code lost:
        r8 = -9223372036854775807L;
     */
    /* JADX WARNING: Removed duplicated region for block: B:306:0x063c  */
    /* JADX WARNING: Removed duplicated region for block: B:307:0x0653  */
    /* JADX WARNING: Removed duplicated region for block: B:359:0x0744  */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x0773  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x0775  */
    /* JADX WARNING: Removed duplicated region for block: B:454:0x0969  */
    /* JADX WARNING: Removed duplicated region for block: B:455:0x096b  */
    /* JADX WARNING: Removed duplicated region for block: B:506:0x0afb  */
    /* JADX WARNING: Removed duplicated region for block: B:507:0x0aff  */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x0b2e  */
    /* JADX WARNING: Removed duplicated region for block: B:511:0x0b58  */
    /* JADX WARNING: Removed duplicated region for block: B:518:0x0b65 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List zzd(com.google.android.gms.internal.ads.zzahv r55, com.google.android.gms.internal.ads.zzacy r56, long r57, com.google.android.gms.internal.ads.zzy r59, boolean r60, boolean r61, com.google.android.gms.internal.ads.zzful r62) throws com.google.android.gms.internal.ads.zzbo {
        /*
            r0 = r55
            r11 = r59
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r14 = 0
        L_0x000a:
            java.util.List r1 = r0.zzc
            int r1 = r1.size()
            if (r14 >= r1) goto L_0x0b6d
            java.util.List r1 = r0.zzc
            java.lang.Object r1 = r1.get(r14)
            r15 = r1
            com.google.android.gms.internal.ads.zzahv r15 = (com.google.android.gms.internal.ads.zzahv) r15
            int r1 = r15.zzd
            r2 = 1953653099(0x7472616b, float:7.681346E31)
            if (r1 == r2) goto L_0x002b
            r3 = r56
            r0 = r62
            r2 = r12
            r31 = r14
            goto L_0x0b5c
        L_0x002b:
            r1 = 1836476516(0x6d766864, float:4.7662196E27)
            com.google.android.gms.internal.ads.zzahw r1 = r0.zzb(r1)
            r1.getClass()
            r2 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzahv r2 = r15.zza(r2)
            r2.getClass()
            r3 = 1751411826(0x68646c72, float:4.3148E24)
            com.google.android.gms.internal.ads.zzahw r3 = r2.zzb(r3)
            r3.getClass()
            com.google.android.gms.internal.ads.zzek r3 = r3.zza
            int r3 = zzg(r3)
            r4 = 1936684398(0x736f756e, float:1.8971874E31)
            r8 = -1
            if (r3 != r4) goto L_0x0057
            r5 = 1
            goto L_0x007d
        L_0x0057:
            r4 = 1986618469(0x76696465, float:1.1834389E33)
            if (r3 != r4) goto L_0x005e
            r5 = 2
            goto L_0x007d
        L_0x005e:
            r4 = 1952807028(0x74657874, float:7.272211E31)
            if (r3 == r4) goto L_0x007c
            r4 = 1935832172(0x7362746c, float:1.7941596E31)
            if (r3 == r4) goto L_0x007c
            r4 = 1937072756(0x73756274, float:1.944137E31)
            if (r3 == r4) goto L_0x007c
            r4 = 1668047728(0x636c6370, float:4.3605968E21)
            if (r3 != r4) goto L_0x0073
            goto L_0x007c
        L_0x0073:
            r4 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r3 != r4) goto L_0x007a
            r5 = 5
            goto L_0x007d
        L_0x007a:
            r5 = r8
            goto L_0x007d
        L_0x007c:
            r5 = 3
        L_0x007d:
            if (r5 != r8) goto L_0x0089
            r0 = r62
            r32 = r12
            r31 = r14
            r1 = r15
        L_0x0086:
            r4 = 0
            goto L_0x0b26
        L_0x0089:
            r3 = 1953196132(0x746b6864, float:7.46037E31)
            com.google.android.gms.internal.ads.zzahw r3 = r15.zzb(r3)
            r3.getClass()
            com.google.android.gms.internal.ads.zzek r3 = r3.zza
            r6 = 8
            r3.zzK(r6)
            int r17 = r3.zzg()
            int r17 = com.google.android.gms.internal.ads.zzahx.zze(r17)
            r13 = 16
            if (r17 != 0) goto L_0x00a8
            r4 = r6
            goto L_0x00a9
        L_0x00a8:
            r4 = r13
        L_0x00a9:
            r3.zzL(r4)
            int r4 = r3.zzg()
            r6 = 4
            r3.zzL(r6)
            int r20 = r3.zzd()
            r7 = 0
        L_0x00b9:
            if (r17 != 0) goto L_0x00bd
            r9 = r6
            goto L_0x00bf
        L_0x00bd:
            r9 = 8
        L_0x00bf:
            r23 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r7 >= r9) goto L_0x00e8
            byte[] r9 = r3.zzM()
            int r25 = r20 + r7
            byte r9 = r9[r25]
            if (r9 == r8) goto L_0x00e5
            if (r17 != 0) goto L_0x00d7
            long r25 = r3.zzu()
            goto L_0x00db
        L_0x00d7:
            long r25 = r3.zzv()
        L_0x00db:
            r27 = 0
            int r7 = (r25 > r27 ? 1 : (r25 == r27 ? 0 : -1))
            if (r7 != 0) goto L_0x00e2
            goto L_0x00eb
        L_0x00e2:
            r8 = r25
            goto L_0x00ed
        L_0x00e5:
            int r7 = r7 + 1
            goto L_0x00b9
        L_0x00e8:
            r3.zzL(r9)
        L_0x00eb:
            r8 = r23
        L_0x00ed:
            r3.zzL(r13)
            int r7 = r3.zzg()
            int r10 = r3.zzg()
            r3.zzL(r6)
            int r6 = r3.zzg()
            int r3 = r3.zzg()
            r13 = 65536(0x10000, float:9.18355E-41)
            r0 = -65536(0xffffffffffff0000, float:NaN)
            if (r7 != 0) goto L_0x0115
            if (r10 != r13) goto L_0x0114
            if (r6 != r0) goto L_0x0113
            if (r3 != 0) goto L_0x0112
            r0 = 90
            goto L_0x0133
        L_0x0112:
            r6 = r0
        L_0x0113:
            r10 = r13
        L_0x0114:
            r7 = 0
        L_0x0115:
            if (r7 != 0) goto L_0x0126
            if (r10 != r0) goto L_0x0123
            if (r6 != r13) goto L_0x0122
            if (r3 != 0) goto L_0x0120
            r0 = 270(0x10e, float:3.78E-43)
            goto L_0x0133
        L_0x0120:
            r10 = r0
            goto L_0x0124
        L_0x0122:
            r10 = r0
        L_0x0123:
            r13 = r6
        L_0x0124:
            r7 = 0
            goto L_0x0127
        L_0x0126:
            r13 = r6
        L_0x0127:
            if (r7 != r0) goto L_0x0132
            if (r10 != 0) goto L_0x0132
            if (r13 != 0) goto L_0x0132
            if (r3 != r0) goto L_0x0132
            r0 = 180(0xb4, float:2.52E-43)
            goto L_0x0133
        L_0x0132:
            r0 = 0
        L_0x0133:
            com.google.android.gms.internal.ads.zzaie r13 = new com.google.android.gms.internal.ads.zzaie
            r13.<init>(r4, r8, r0)
            int r0 = (r57 > r23 ? 1 : (r57 == r23 ? 0 : -1))
            if (r0 != 0) goto L_0x0143
            long r3 = r13.zzb
            r31 = r3
            goto L_0x0145
        L_0x0143:
            r31 = r57
        L_0x0145:
            com.google.android.gms.internal.ads.zzek r0 = r1.zza
            com.google.android.gms.internal.ads.zzfd r0 = zzc(r0)
            long r9 = r0.zzc
            int r0 = (r31 > r23 ? 1 : (r31 == r23 ? 0 : -1))
            if (r0 != 0) goto L_0x0152
            goto L_0x015f
        L_0x0152:
            r33 = 1000000(0xf4240, double:4.940656E-318)
            java.math.RoundingMode r37 = java.math.RoundingMode.FLOOR
            r35 = r9
            long r0 = com.google.android.gms.internal.ads.zzet.zzt(r31, r33, r35, r37)
            r23 = r0
        L_0x015f:
            r0 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzahv r0 = r2.zza(r0)
            r0.getClass()
            r1 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzahv r0 = r0.zza(r1)
            r0.getClass()
            r1 = 1835296868(0x6d646864, float:4.418049E27)
            com.google.android.gms.internal.ads.zzahw r1 = r2.zzb(r1)
            r1.getClass()
            com.google.android.gms.internal.ads.zzek r1 = r1.zza
            r6 = 8
            r1.zzK(r6)
            int r2 = r1.zzg()
            int r2 = com.google.android.gms.internal.ads.zzahx.zze(r2)
            if (r2 != 0) goto L_0x0190
            r3 = r6
            goto L_0x0192
        L_0x0190:
            r3 = 16
        L_0x0192:
            r1.zzL(r3)
            if (r2 != 0) goto L_0x0199
            r2 = 4
            goto L_0x019a
        L_0x0199:
            r2 = r6
        L_0x019a:
            long r3 = r1.zzu()
            r1.zzL(r2)
            int r1 = r1.zzq()
            int r2 = r1 >> 10
            int r7 = r1 >> 5
            r1 = r1 & 31
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r2 = r2 & 31
            int r2 = r2 + 96
            char r2 = (char) r2
            r8.append(r2)
            r2 = r7 & 31
            int r2 = r2 + 96
            char r2 = (char) r2
            r8.append(r2)
            int r1 = r1 + 96
            char r1 = (char) r1
            r8.append(r1)
            java.lang.String r1 = r8.toString()
            java.lang.Long r2 = java.lang.Long.valueOf(r3)
            android.util.Pair r8 = android.util.Pair.create(r2, r1)
            r1 = 1937011556(0x73747364, float:1.9367383E31)
            com.google.android.gms.internal.ads.zzahw r0 = r0.zzb(r1)
            if (r0 == 0) goto L_0x0b65
            int r7 = r13.zza
            int r4 = r13.zzc
            java.lang.Object r1 = r8.second
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.internal.ads.zzek r0 = r0.zza
            r2 = 12
            r0.zzK(r2)
            int r1 = r0.zzg()
            r31 = r14
            com.google.android.gms.internal.ads.zzaib r14 = new com.google.android.gms.internal.ads.zzaib
            r14.<init>(r1)
            r32 = r12
            r12 = 0
        L_0x01fd:
            if (r12 >= r1) goto L_0x0a70
            r19 = r13
            int r13 = r0.zzd()
            r33 = r15
            int r15 = r0.zzg()
            if (r15 <= 0) goto L_0x020f
            r2 = 1
            goto L_0x0210
        L_0x020f:
            r2 = 0
        L_0x0210:
            java.lang.String r6 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzaco.zzb(r2, r6)
            int r2 = r0.zzg()
            r6 = 1635148593(0x61766331, float:2.840654E20)
            r29 = r1
            r1 = 1701733238(0x656e6376, float:7.035987E22)
            if (r2 == r6) goto L_0x0405
            r6 = 1635148595(0x61766333, float:2.8406544E20)
            if (r2 == r6) goto L_0x0405
            if (r2 == r1) goto L_0x0405
            r6 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r2 == r6) goto L_0x0405
            r6 = 1836070006(0x6d703476, float:4.646239E27)
            if (r2 == r6) goto L_0x0405
            r6 = 1752589105(0x68766331, float:4.6541277E24)
            if (r2 == r6) goto L_0x0405
            r6 = 1751479857(0x68657631, float:4.3344087E24)
            if (r2 == r6) goto L_0x0405
            r6 = 1932670515(0x73323633, float:1.4119387E31)
            if (r2 == r6) goto L_0x0405
            r6 = 1211250227(0x48323633, float:182488.8)
            if (r2 == r6) goto L_0x0405
            r6 = 1987063864(0x76703038, float:1.21789965E33)
            if (r2 == r6) goto L_0x0405
            r6 = 1987063865(0x76703039, float:1.2178997E33)
            if (r2 == r6) goto L_0x0405
            r6 = 1635135537(0x61763031, float:2.8383572E20)
            if (r2 == r6) goto L_0x0405
            r6 = 1685479798(0x64766176, float:1.8179687E22)
            if (r2 == r6) goto L_0x0405
            r6 = 1685479729(0x64766131, float:1.817961E22)
            if (r2 == r6) goto L_0x0405
            r6 = 1685481573(0x64766865, float:1.8181686E22)
            if (r2 == r6) goto L_0x0405
            r6 = 1685481521(0x64766831, float:1.8181627E22)
            if (r2 != r6) goto L_0x026d
            goto L_0x0405
        L_0x026d:
            r1 = 1836069985(0x6d703461, float:4.6462328E27)
            if (r2 == r1) goto L_0x03d2
            r1 = 1701733217(0x656e6361, float:7.0359778E22)
            if (r2 == r1) goto L_0x03d2
            r1 = 1633889587(0x61632d33, float:2.6191674E20)
            if (r2 == r1) goto L_0x03d2
            r1 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r2 == r1) goto L_0x03d2
            r1 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r2 == r1) goto L_0x03d2
            r1 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r2 == r1) goto L_0x03d2
            r1 = 1685353315(0x64747363, float:1.803728E22)
            if (r2 == r1) goto L_0x03d2
            r1 = 1685353317(0x64747365, float:1.8037282E22)
            if (r2 == r1) goto L_0x03d2
            r1 = 1685353320(0x64747368, float:1.8037286E22)
            if (r2 == r1) goto L_0x03d2
            r1 = 1685353324(0x6474736c, float:1.803729E22)
            if (r2 == r1) goto L_0x03d2
            r1 = 1685353336(0x64747378, float:1.8037304E22)
            if (r2 == r1) goto L_0x03d2
            r1 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r2 == r1) goto L_0x03d2
            r1 = 1935767394(0x73617762, float:1.7863284E31)
            if (r2 == r1) goto L_0x03d2
            r1 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r2 == r1) goto L_0x03d2
            r1 = 1936684916(0x736f7774, float:1.89725E31)
            if (r2 == r1) goto L_0x03d2
            r1 = 1953984371(0x74776f73, float:7.841539E31)
            if (r2 == r1) goto L_0x03d2
            r1 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r2 == r1) goto L_0x03d2
            r1 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r2 == r1) goto L_0x03d2
            r1 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r2 == r1) goto L_0x03d2
            r1 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r2 == r1) goto L_0x03d2
            r1 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r2 == r1) goto L_0x03d2
            r1 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r2 == r1) goto L_0x03d2
            r1 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r2 == r1) goto L_0x03d2
            r1 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r2 == r1) goto L_0x03d2
            r1 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r2 != r1) goto L_0x02ec
            goto L_0x03d2
        L_0x02ec:
            r1 = 1414810956(0x54544d4c, float:3.64731957E12)
            if (r2 == r1) goto L_0x0357
            r1 = 1954034535(0x74783367, float:7.865797E31)
            if (r2 == r1) goto L_0x0357
            r1 = 2004251764(0x77767474, float:4.998699E33)
            if (r2 == r1) goto L_0x0357
            r1 = 1937010800(0x73747070, float:1.9366469E31)
            if (r2 == r1) goto L_0x0357
            r1 = 1664495672(0x63363038, float:3.360782E21)
            if (r2 != r1) goto L_0x0306
            goto L_0x0357
        L_0x0306:
            r1 = 1835365492(0x6d657474, float:4.4383032E27)
            if (r2 != r1) goto L_0x032c
            int r1 = r13 + 16
            r0.zzK(r1)
            r1 = 0
            r0.zzx(r1)
            java.lang.String r2 = r0.zzx(r1)
            if (r2 == 0) goto L_0x0344
            com.google.android.gms.internal.ads.zzad r1 = new com.google.android.gms.internal.ads.zzad
            r1.<init>()
            r1.zzJ(r7)
            r1.zzX(r2)
            com.google.android.gms.internal.ads.zzaf r1 = r1.zzad()
            r14.zzb = r1
            goto L_0x0344
        L_0x032c:
            r1 = 1667329389(0x63616d6d, float:4.1584024E21)
            if (r2 != r1) goto L_0x0344
            com.google.android.gms.internal.ads.zzad r1 = new com.google.android.gms.internal.ads.zzad
            r1.<init>()
            r1.zzJ(r7)
            java.lang.String r2 = "application/x-camera-motion"
            r1.zzX(r2)
            com.google.android.gms.internal.ads.zzaf r1 = r1.zzad()
            r14.zzb = r1
        L_0x0344:
            r27 = r3
            r2 = r4
            r18 = r5
            r3 = r7
            r43 = r8
            r21 = r9
            r17 = r12
            r37 = r13
            r6 = r14
            r39 = r15
            goto L_0x03ff
        L_0x0357:
            int r1 = r13 + 16
            r0.zzK(r1)
            r1 = 1414810956(0x54544d4c, float:3.64731957E12)
            r34 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 != r1) goto L_0x036c
            java.lang.String r1 = "application/ttml+xml"
        L_0x0368:
            r38 = r34
            r2 = 0
            goto L_0x039f
        L_0x036c:
            r1 = 1954034535(0x74783367, float:7.865797E31)
            if (r2 != r1) goto L_0x0387
            int r1 = r15 + -16
            byte[] r2 = new byte[r1]
            r6 = 0
            r0.zzG(r2, r6, r1)
            com.google.android.gms.internal.ads.zzfxr r1 = com.google.android.gms.internal.ads.zzfxr.zzn(r2)
            java.lang.String r2 = "application/x-quicktime-tx3g"
            r38 = r34
            r54 = r2
            r2 = r1
            r1 = r54
            goto L_0x039f
        L_0x0387:
            r1 = 2004251764(0x77767474, float:4.998699E33)
            if (r2 != r1) goto L_0x038f
            java.lang.String r1 = "application/x-mp4-vtt"
            goto L_0x0368
        L_0x038f:
            r1 = 1937010800(0x73747070, float:1.9366469E31)
            if (r2 != r1) goto L_0x0399
            r34 = 0
            java.lang.String r1 = "application/ttml+xml"
            goto L_0x0368
        L_0x0399:
            r6 = 1
            r14.zzd = r6
            java.lang.String r1 = "application/x-mp4-cea-608"
            goto L_0x0368
        L_0x039f:
            com.google.android.gms.internal.ads.zzad r6 = new com.google.android.gms.internal.ads.zzad
            r6.<init>()
            r6.zzJ(r7)
            r6.zzX(r1)
            r6.zzO(r3)
            r35 = r3
            r34 = r4
            r3 = r38
            r6.zzab(r3)
            r6.zzL(r2)
            com.google.android.gms.internal.ads.zzaf r1 = r6.zzad()
            r14.zzb = r1
            r18 = r5
            r3 = r7
            r43 = r8
            r21 = r9
            r17 = r12
            r37 = r13
            r6 = r14
            r39 = r15
            r2 = r34
            r27 = r35
            goto L_0x03ff
        L_0x03d2:
            r35 = r3
            r34 = r4
            r1 = r0
            r6 = 12
            r27 = r35
            r3 = r13
            r40 = r34
            r4 = r15
            r18 = r5
            r5 = r7
            r6 = r27
            r42 = r7
            r7 = r61
            r43 = r8
            r8 = r59
            r21 = r9
            r10 = 3
            r9 = r14
            r10 = r12
            zzm(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r17 = r12
            r37 = r13
            r6 = r14
            r39 = r15
            r2 = r40
            r3 = r42
        L_0x03ff:
            r4 = 3
            r5 = -1
            r41 = 5
            goto L_0x0a50
        L_0x0405:
            r27 = r3
            r40 = r4
            r18 = r5
            r42 = r7
            r43 = r8
            r21 = r9
            int r3 = r13 + 16
            r0.zzK(r3)
            r3 = 16
            r0.zzL(r3)
            int r4 = r0.zzq()
            int r5 = r0.zzq()
            r6 = 50
            r0.zzL(r6)
            int r6 = r0.zzd()
            if (r2 != r1) goto L_0x045a
            android.util.Pair r2 = zzh(r0, r13, r15)
            if (r2 == 0) goto L_0x0454
            java.lang.Object r1 = r2.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r11 != 0) goto L_0x0440
            r7 = 0
            goto L_0x044a
        L_0x0440:
            java.lang.Object r7 = r2.second
            com.google.android.gms.internal.ads.zzaix r7 = (com.google.android.gms.internal.ads.zzaix) r7
            java.lang.String r7 = r7.zzb
            com.google.android.gms.internal.ads.zzy r7 = r11.zzb(r7)
        L_0x044a:
            com.google.android.gms.internal.ads.zzaix[] r8 = r14.zza
            java.lang.Object r2 = r2.second
            com.google.android.gms.internal.ads.zzaix r2 = (com.google.android.gms.internal.ads.zzaix) r2
            r8[r12] = r2
            r2 = r1
            goto L_0x0456
        L_0x0454:
            r2 = r1
            r7 = r11
        L_0x0456:
            r0.zzK(r6)
            goto L_0x045b
        L_0x045a:
            r7 = r11
        L_0x045b:
            r1 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r2 != r1) goto L_0x0468
            java.lang.String r1 = "video/mpeg"
            r54 = r2
            r2 = r1
            r1 = r54
            goto L_0x0472
        L_0x0468:
            r1 = 1211250227(0x48323633, float:182488.8)
            if (r2 != r1) goto L_0x0470
            java.lang.String r2 = "video/3gpp"
            goto L_0x0472
        L_0x0470:
            r1 = r2
            r2 = 0
        L_0x0472:
            r8 = 1065353216(0x3f800000, float:1.0)
            r3 = r6
            r34 = r7
            r7 = r8
            r17 = r12
            r6 = 0
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
            r16 = 0
            r20 = 0
            r25 = 8
            r28 = 8
            r30 = -1
            r35 = 0
            r36 = -1
        L_0x048d:
            int r8 = r3 - r13
            if (r8 >= r15) goto L_0x09ac
            r0.zzK(r3)
            int r8 = r0.zzd()
            int r37 = r0.zzg()
            if (r37 != 0) goto L_0x04b4
            int r37 = r0.zzd()
            r38 = r10
            int r10 = r37 - r13
            if (r10 != r15) goto L_0x04b2
            r48 = r4
            r47 = r5
            r46 = r7
            r53 = r9
            goto L_0x09b6
        L_0x04b2:
            r10 = 0
            goto L_0x04b8
        L_0x04b4:
            r38 = r10
            r10 = r37
        L_0x04b8:
            if (r10 <= 0) goto L_0x04c0
            r37 = r13
            r39 = r15
            r13 = 1
            goto L_0x04c5
        L_0x04c0:
            r37 = r13
            r39 = r15
            r13 = 0
        L_0x04c5:
            java.lang.String r15 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzaco.zzb(r13, r15)
            int r13 = r0.zzg()
            r15 = 1635148611(0x61766343, float:2.8406573E20)
            if (r13 != r15) goto L_0x0521
            int r8 = r8 + 8
            if (r2 != 0) goto L_0x04d9
            r2 = 1
            goto L_0x04da
        L_0x04d9:
            r2 = 0
        L_0x04da:
            r15 = 0
            com.google.android.gms.internal.ads.zzaco.zzb(r2, r15)
            r0.zzK(r8)
            com.google.android.gms.internal.ads.zzabn r2 = com.google.android.gms.internal.ads.zzabn.zza(r0)
            java.util.List r8 = r2.zza
            int r9 = r2.zzb
            r14.zzc = r9
            if (r20 != 0) goto L_0x04f2
            float r7 = r2.zzj
            r9 = r7
            r7 = 0
            goto L_0x04f4
        L_0x04f2:
            r9 = r7
            r7 = 1
        L_0x04f4:
            java.lang.String r11 = r2.zzk
            int r12 = r2.zzg
            int r13 = r2.zzh
            int r15 = r2.zzi
            r20 = r7
            int r7 = r2.zze
            int r2 = r2.zzf
            java.lang.String r25 = "video/avc"
        L_0x0504:
            r44 = r1
            r48 = r4
            r47 = r5
            r28 = r7
            r35 = r8
            r7 = r9
            r9 = r11
            r30 = r13
            r45 = r14
            r11 = r15
            r4 = 3
            r5 = -1
            r41 = 5
            r54 = r25
            r25 = r2
            r2 = r54
            goto L_0x099b
        L_0x0521:
            r15 = 1752589123(0x68766343, float:4.6541328E24)
            if (r13 != r15) goto L_0x0558
            int r8 = r8 + 8
            if (r2 != 0) goto L_0x052c
            r2 = 1
            goto L_0x052d
        L_0x052c:
            r2 = 0
        L_0x052d:
            r9 = 0
            com.google.android.gms.internal.ads.zzaco.zzb(r2, r9)
            r0.zzK(r8)
            com.google.android.gms.internal.ads.zzacz r2 = com.google.android.gms.internal.ads.zzacz.zza(r0)
            java.util.List r8 = r2.zza
            int r9 = r2.zzb
            r14.zzc = r9
            if (r20 != 0) goto L_0x0545
            float r7 = r2.zzh
            r9 = r7
            r7 = 0
            goto L_0x0547
        L_0x0545:
            r9 = r7
            r7 = 1
        L_0x0547:
            java.lang.String r11 = r2.zzi
            int r12 = r2.zze
            int r13 = r2.zzf
            int r15 = r2.zzg
            r20 = r7
            int r7 = r2.zzc
            int r2 = r2.zzd
            java.lang.String r25 = "video/hevc"
            goto L_0x0504
        L_0x0558:
            r15 = 1685480259(0x64766343, float:1.8180206E22)
            if (r13 == r15) goto L_0x0979
            r15 = 1685485123(0x64767643, float:1.8185683E22)
            if (r13 != r15) goto L_0x0564
            goto L_0x0979
        L_0x0564:
            r15 = 1987076931(0x76706343, float:1.21891066E33)
            if (r13 != r15) goto L_0x05b8
            if (r2 != 0) goto L_0x056d
            r2 = 1
            goto L_0x056e
        L_0x056d:
            r2 = 0
        L_0x056e:
            r11 = 0
            com.google.android.gms.internal.ads.zzaco.zzb(r2, r11)
            int r8 = r8 + 12
            r0.zzK(r8)
            r15 = 2
            r0.zzL(r15)
            int r2 = r0.zzm()
            int r8 = r2 >> 4
            r11 = 1
            r2 = r2 & r11
            int r12 = r0.zzm()
            int r13 = r0.zzm()
            int r12 = com.google.android.gms.internal.ads.zzo.zza(r12)
            if (r11 == r2) goto L_0x0593
            r2 = r15
            goto L_0x0594
        L_0x0593:
            r2 = r11
        L_0x0594:
            int r13 = com.google.android.gms.internal.ads.zzo.zzb(r13)
            r11 = 1987063864(0x76703038, float:1.21789965E33)
            if (r1 != r11) goto L_0x05a0
            java.lang.String r11 = "video/x-vnd.on2.vp8"
            goto L_0x05a2
        L_0x05a0:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
        L_0x05a2:
            r44 = r1
            r30 = r2
            r48 = r4
            r47 = r5
            r25 = r8
            r28 = r25
            r2 = r11
            r11 = r13
            r45 = r14
            r4 = 3
            r5 = -1
            r41 = 5
            goto L_0x099b
        L_0x05b8:
            r15 = 1635135811(0x61763143, float:2.8384055E20)
            r44 = r1
            java.lang.String r1 = "AtomParsers"
            if (r13 != r15) goto L_0x07a7
            int r8 = r8 + 8
            int r2 = r10 + -8
            byte[] r11 = new byte[r2]
            r15 = 0
            r0.zzG(r11, r15, r2)
            com.google.android.gms.internal.ads.zzfxr r2 = com.google.android.gms.internal.ads.zzfxr.zzn(r11)
            r0.zzK(r8)
            com.google.android.gms.internal.ads.zzm r8 = new com.google.android.gms.internal.ads.zzm
            r8.<init>()
            com.google.android.gms.internal.ads.zzej r11 = new com.google.android.gms.internal.ads.zzej
            byte[] r12 = r0.zzM()
            int r13 = r12.length
            r11.<init>(r12, r13)
            int r12 = r0.zzd()
            r13 = 8
            int r12 = r12 * r13
            r11.zzl(r12)
            r12 = 1
            r11.zzo(r12)
            r15 = 3
            int r13 = r11.zzd(r15)
            r15 = 6
            r11.zzn(r15)
            boolean r15 = r11.zzp()
            boolean r12 = r11.zzp()
            r25 = 10
            r28 = r2
            r2 = 2
            if (r13 != r2) goto L_0x061d
            if (r15 == 0) goto L_0x0619
            r13 = 1
            if (r13 == r12) goto L_0x060f
            r12 = r25
            goto L_0x0611
        L_0x060f:
            r12 = 12
        L_0x0611:
            r8.zzf(r12)
            r8.zza(r12)
            r12 = r13
            goto L_0x062d
        L_0x0619:
            r13 = r2
            r12 = 1
            r15 = 0
            goto L_0x061e
        L_0x061d:
            r12 = 1
        L_0x061e:
            if (r13 > r2) goto L_0x062d
            if (r12 == r15) goto L_0x0625
            r2 = 8
            goto L_0x0627
        L_0x0625:
            r2 = r25
        L_0x0627:
            r8.zzf(r2)
            r8.zza(r2)
        L_0x062d:
            r2 = 13
            r11.zzn(r2)
            r11.zzm()
            r15 = 4
            int r13 = r11.zzd(r15)
            if (r13 == r12) goto L_0x0653
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r11 = "Unsupported obu_type: "
            r2.<init>(r11)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.internal.ads.zzea.zze(r1, r2)
            com.google.android.gms.internal.ads.zzo r1 = r8.zzg()
            goto L_0x0784
        L_0x0653:
            boolean r12 = r11.zzp()
            if (r12 == 0) goto L_0x0664
            java.lang.String r2 = "Unsupported obu_extension_flag"
            com.google.android.gms.internal.ads.zzea.zze(r1, r2)
            com.google.android.gms.internal.ads.zzo r1 = r8.zzg()
            goto L_0x0784
        L_0x0664:
            boolean r12 = r11.zzp()
            r11.zzm()
            if (r12 == 0) goto L_0x0682
            r12 = 8
            int r13 = r11.zzd(r12)
            r12 = 127(0x7f, float:1.78E-43)
            if (r13 <= r12) goto L_0x0682
            java.lang.String r2 = "Excessive obu_size"
            com.google.android.gms.internal.ads.zzea.zze(r1, r2)
            com.google.android.gms.internal.ads.zzo r1 = r8.zzg()
            goto L_0x0784
        L_0x0682:
            r12 = 3
            int r13 = r11.zzd(r12)
            r11.zzm()
            boolean r12 = r11.zzp()
            if (r12 == 0) goto L_0x069b
            java.lang.String r2 = "Unsupported reduced_still_picture_header"
            com.google.android.gms.internal.ads.zzea.zze(r1, r2)
            com.google.android.gms.internal.ads.zzo r1 = r8.zzg()
            goto L_0x0784
        L_0x069b:
            boolean r12 = r11.zzp()
            if (r12 == 0) goto L_0x06ac
            java.lang.String r2 = "Unsupported timing_info_present_flag"
            com.google.android.gms.internal.ads.zzea.zze(r1, r2)
            com.google.android.gms.internal.ads.zzo r1 = r8.zzg()
            goto L_0x0784
        L_0x06ac:
            boolean r12 = r11.zzp()
            if (r12 == 0) goto L_0x06bd
            java.lang.String r2 = "Unsupported initial_display_delay_present_flag"
            com.google.android.gms.internal.ads.zzea.zze(r1, r2)
            com.google.android.gms.internal.ads.zzo r1 = r8.zzg()
            goto L_0x0784
        L_0x06bd:
            r1 = 5
            int r12 = r11.zzd(r1)
            r2 = 0
        L_0x06c3:
            if (r2 > r12) goto L_0x06d9
            r15 = 12
            r11.zzn(r15)
            int r15 = r11.zzd(r1)
            r1 = 7
            if (r15 <= r1) goto L_0x06d4
            r11.zzm()
        L_0x06d4:
            int r2 = r2 + 1
            r1 = 5
            r15 = 4
            goto L_0x06c3
        L_0x06d9:
            int r1 = r11.zzd(r15)
            int r2 = r11.zzd(r15)
            r12 = 1
            int r1 = r1 + r12
            r11.zzn(r1)
            int r2 = r2 + r12
            r11.zzn(r2)
            boolean r1 = r11.zzp()
            if (r1 == 0) goto L_0x06f4
            r1 = 7
            r11.zzn(r1)
        L_0x06f4:
            r1 = 7
            r11.zzn(r1)
            boolean r1 = r11.zzp()
            if (r1 == 0) goto L_0x0702
            r2 = 2
            r11.zzn(r2)
        L_0x0702:
            boolean r2 = r11.zzp()
            if (r2 == 0) goto L_0x070a
            r2 = 1
            goto L_0x0711
        L_0x070a:
            r2 = 1
            int r12 = r11.zzd(r2)
            if (r12 <= 0) goto L_0x071a
        L_0x0711:
            boolean r12 = r11.zzp()
            if (r12 != 0) goto L_0x071a
            r11.zzn(r2)
        L_0x071a:
            if (r1 == 0) goto L_0x0721
            r1 = 3
            r11.zzn(r1)
            goto L_0x0722
        L_0x0721:
            r1 = 3
        L_0x0722:
            r11.zzn(r1)
            boolean r1 = r11.zzp()
            r2 = 2
            if (r13 != r2) goto L_0x0732
            if (r1 == 0) goto L_0x0737
            r11.zzm()
            goto L_0x0737
        L_0x0732:
            r1 = 1
            if (r13 != r1) goto L_0x0737
        L_0x0735:
            r1 = 0
            goto L_0x073e
        L_0x0737:
            boolean r1 = r11.zzp()
            if (r1 == 0) goto L_0x0735
            r1 = 1
        L_0x073e:
            boolean r2 = r11.zzp()
            if (r2 == 0) goto L_0x0780
            r2 = 8
            int r12 = r11.zzd(r2)
            int r13 = r11.zzd(r2)
            int r30 = r11.zzd(r2)
            if (r1 != 0) goto L_0x0764
            r1 = 1
            if (r12 != r1) goto L_0x0765
            r2 = 13
            if (r13 != r2) goto L_0x0762
            if (r30 != 0) goto L_0x0760
            r11 = r1
            r12 = r11
            goto L_0x076a
        L_0x0760:
            r12 = r1
            goto L_0x0766
        L_0x0762:
            r12 = r1
            goto L_0x0765
        L_0x0764:
            r1 = 1
        L_0x0765:
            r2 = r13
        L_0x0766:
            int r11 = r11.zzd(r1)
        L_0x076a:
            int r12 = com.google.android.gms.internal.ads.zzo.zza(r12)
            r8.zzc(r12)
            if (r11 != r1) goto L_0x0775
            r1 = 1
            goto L_0x0776
        L_0x0775:
            r1 = 2
        L_0x0776:
            r8.zzb(r1)
            int r1 = com.google.android.gms.internal.ads.zzo.zzb(r2)
            r8.zzd(r1)
        L_0x0780:
            com.google.android.gms.internal.ads.zzo r1 = r8.zzg()
        L_0x0784:
            int r2 = r1.zzd
            int r8 = r1.zzc
            int r11 = r1.zzb
            int r12 = r1.zzg
            int r1 = r1.zzf
            java.lang.String r13 = "video/av01"
            r48 = r4
            r47 = r5
            r30 = r8
            r25 = r12
            r45 = r14
            r35 = r28
            r4 = 3
            r5 = -1
            r41 = 5
            r28 = r1
            r12 = r11
            r11 = r2
            r2 = r13
            goto L_0x099b
        L_0x07a7:
            r41 = 5
            r15 = 1668050025(0x636c6c69, float:4.3612434E21)
            if (r13 != r15) goto L_0x07d1
            if (r6 != 0) goto L_0x07b4
            java.nio.ByteBuffer r6 = zzl()
        L_0x07b4:
            r1 = 21
            r6.position(r1)
            short r1 = r0.zzD()
            r6.putShort(r1)
            short r1 = r0.zzD()
            r6.putShort(r1)
            r48 = r4
            r47 = r5
            r45 = r14
        L_0x07cd:
            r4 = 3
        L_0x07ce:
            r5 = -1
            goto L_0x099b
        L_0x07d1:
            r15 = 1835295606(0x6d646376, float:4.4176764E27)
            if (r13 != r15) goto L_0x0841
            if (r6 != 0) goto L_0x07dc
            java.nio.ByteBuffer r6 = zzl()
        L_0x07dc:
            short r1 = r0.zzD()
            short r8 = r0.zzD()
            short r13 = r0.zzD()
            short r15 = r0.zzD()
            r45 = r14
            short r14 = r0.zzD()
            r46 = r7
            short r7 = r0.zzD()
            r47 = r5
            short r5 = r0.zzD()
            r48 = r4
            short r4 = r0.zzD()
            long r49 = r0.zzu()
            long r51 = r0.zzu()
            r53 = r9
            r9 = 1
            r6.position(r9)
            r6.putShort(r14)
            r6.putShort(r7)
            r6.putShort(r1)
            r6.putShort(r8)
            r6.putShort(r13)
            r6.putShort(r15)
            r6.putShort(r5)
            r6.putShort(r4)
            r4 = 10000(0x2710, double:4.9407E-320)
            long r4 = r49 / r4
            int r1 = (int) r4
            short r1 = (short) r1
            r6.putShort(r1)
            r4 = 10000(0x2710, double:4.9407E-320)
            long r4 = r51 / r4
            int r1 = (int) r4
            short r1 = (short) r1
            r6.putShort(r1)
        L_0x083c:
            r7 = r46
            r9 = r53
            goto L_0x07cd
        L_0x0841:
            r48 = r4
            r47 = r5
            r46 = r7
            r53 = r9
            r45 = r14
            r4 = 1681012275(0x64323633, float:1.3149704E22)
            if (r13 != r4) goto L_0x085d
            if (r2 != 0) goto L_0x0854
            r1 = 1
            goto L_0x0855
        L_0x0854:
            r1 = 0
        L_0x0855:
            r4 = 0
            com.google.android.gms.internal.ads.zzaco.zzb(r1, r4)
            java.lang.String r1 = "video/3gpp"
            r2 = r1
            goto L_0x083c
        L_0x085d:
            r4 = 0
            r5 = 1702061171(0x65736473, float:7.183675E22)
            if (r13 != r5) goto L_0x0885
            if (r2 != 0) goto L_0x0867
            r1 = 1
            goto L_0x0868
        L_0x0867:
            r1 = 0
        L_0x0868:
            com.google.android.gms.internal.ads.zzaco.zzb(r1, r4)
            com.google.android.gms.internal.ads.zzahz r1 = zzj(r0, r8)
            java.lang.String r2 = r1.zza
            byte[] r4 = r1.zzb
            if (r4 == 0) goto L_0x0882
            com.google.android.gms.internal.ads.zzfxr r4 = com.google.android.gms.internal.ads.zzfxr.zzn(r4)
            r16 = r1
            r35 = r4
            goto L_0x083c
        L_0x0882:
            r16 = r1
            goto L_0x083c
        L_0x0885:
            r4 = 1885434736(0x70617370, float:2.7909473E29)
            if (r13 != r4) goto L_0x08a3
            int r8 = r8 + 8
            r0.zzK(r8)
            int r1 = r0.zzp()
            int r4 = r0.zzp()
            float r1 = (float) r1
            float r4 = (float) r4
            float r1 = r1 / r4
            r7 = r1
            r9 = r53
            r4 = 3
            r5 = -1
            r20 = 1
            goto L_0x099b
        L_0x08a3:
            r4 = 1937126244(0x73763364, float:1.9506033E31)
            if (r13 != r4) goto L_0x08d7
            int r1 = r8 + 8
        L_0x08aa:
            int r4 = r1 - r8
            if (r4 >= r10) goto L_0x08cd
            r0.zzK(r1)
            int r4 = r0.zzg()
            int r4 = r4 + r1
            int r5 = r0.zzg()
            r7 = 1886547818(0x70726f6a, float:3.0012025E29)
            if (r5 != r7) goto L_0x08cb
            byte[] r5 = r0.zzM()
            byte[] r1 = java.util.Arrays.copyOfRange(r5, r1, r4)
            r38 = r1
            goto L_0x083c
        L_0x08cb:
            r1 = r4
            goto L_0x08aa
        L_0x08cd:
            r7 = r46
            r9 = r53
            r4 = 3
            r5 = -1
            r38 = 0
            goto L_0x099b
        L_0x08d7:
            r4 = 1936995172(0x73743364, float:1.9347576E31)
            if (r13 != r4) goto L_0x0919
            int r1 = r0.zzm()
            r4 = 3
            r0.zzL(r4)
            if (r1 != 0) goto L_0x0977
            int r1 = r0.zzm()
            if (r1 == 0) goto L_0x0910
            r5 = 1
            if (r1 == r5) goto L_0x0907
            r5 = 2
            if (r1 == r5) goto L_0x08fe
            if (r1 == r4) goto L_0x08f6
            goto L_0x0977
        L_0x08f6:
            r36 = r4
            r7 = r46
            r9 = r53
            goto L_0x07ce
        L_0x08fe:
            r7 = r46
            r9 = r53
            r5 = -1
            r36 = 2
            goto L_0x099b
        L_0x0907:
            r7 = r46
            r9 = r53
            r5 = -1
            r36 = 1
            goto L_0x099b
        L_0x0910:
            r7 = r46
            r9 = r53
            r5 = -1
            r36 = 0
            goto L_0x099b
        L_0x0919:
            r4 = 3
            r5 = 1668246642(0x636f6c72, float:4.4165861E21)
            if (r13 != r5) goto L_0x0977
            r5 = -1
            if (r12 != r5) goto L_0x0997
            if (r11 != r5) goto L_0x0975
            int r7 = r0.zzg()
            r8 = 1852009592(0x6e636c78, float:1.7596057E28)
            if (r7 == r8) goto L_0x0943
            r8 = 1852009571(0x6e636c63, float:1.7596032E28)
            if (r7 != r8) goto L_0x0933
            goto L_0x0943
        L_0x0933:
            java.lang.String r8 = "Unsupported color type: "
            java.lang.String r7 = com.google.android.gms.internal.ads.zzahx.zzf(r7)
            java.lang.String r7 = r8.concat(r7)
            com.google.android.gms.internal.ads.zzea.zzf(r1, r7)
            r11 = r5
            r12 = r11
            goto L_0x0997
        L_0x0943:
            int r1 = r0.zzq()
            int r7 = r0.zzq()
            r8 = 2
            r0.zzL(r8)
            r8 = 19
            if (r10 != r8) goto L_0x0961
            int r8 = r0.zzm()
            r8 = r8 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x095f
            r10 = 19
            r8 = 1
            goto L_0x0962
        L_0x095f:
            r10 = 19
        L_0x0961:
            r8 = 0
        L_0x0962:
            int r1 = com.google.android.gms.internal.ads.zzo.zza(r1)
            r9 = 1
            if (r9 == r8) goto L_0x096b
            r8 = 2
            goto L_0x096c
        L_0x096b:
            r8 = 1
        L_0x096c:
            int r7 = com.google.android.gms.internal.ads.zzo.zzb(r7)
            r12 = r1
            r11 = r7
            r30 = r8
            goto L_0x0997
        L_0x0975:
            r12 = r5
            goto L_0x0997
        L_0x0977:
            r5 = -1
            goto L_0x0997
        L_0x0979:
            r44 = r1
            r48 = r4
            r47 = r5
            r46 = r7
            r53 = r9
            r45 = r14
            r4 = 3
            r5 = -1
            r41 = 5
            com.google.android.gms.internal.ads.zzace r1 = com.google.android.gms.internal.ads.zzace.zza(r0)
            if (r1 == 0) goto L_0x0997
            java.lang.String r1 = r1.zza
            java.lang.String r2 = "video/dolby-vision"
            r9 = r1
            r7 = r46
            goto L_0x099b
        L_0x0997:
            r7 = r46
            r9 = r53
        L_0x099b:
            int r3 = r3 + r10
            r13 = r37
            r10 = r38
            r15 = r39
            r1 = r44
            r14 = r45
            r5 = r47
            r4 = r48
            goto L_0x048d
        L_0x09ac:
            r48 = r4
            r47 = r5
            r46 = r7
            r53 = r9
            r38 = r10
        L_0x09b6:
            r37 = r13
            r45 = r14
            r39 = r15
            r4 = 3
            r5 = -1
            r41 = 5
            if (r2 != 0) goto L_0x09ca
            r2 = r40
            r3 = r42
            r6 = r45
            goto L_0x0a50
        L_0x09ca:
            com.google.android.gms.internal.ads.zzad r1 = new com.google.android.gms.internal.ads.zzad
            r1.<init>()
            r3 = r42
            r1.zzJ(r3)
            r1.zzX(r2)
            r9 = r53
            r1.zzz(r9)
            r2 = r48
            r1.zzac(r2)
            r2 = r47
            r1.zzI(r2)
            r8 = r46
            r1.zzT(r8)
            r2 = r40
            r1.zzW(r2)
            r7 = r38
            r1.zzU(r7)
            r7 = r36
            r1.zzaa(r7)
            r7 = r35
            r1.zzL(r7)
            r7 = r34
            r1.zzE(r7)
            com.google.android.gms.internal.ads.zzm r7 = new com.google.android.gms.internal.ads.zzm
            r7.<init>()
            r7.zzc(r12)
            r8 = r30
            r7.zzb(r8)
            r7.zzd(r11)
            if (r6 == 0) goto L_0x0a1b
            byte[] r6 = r6.array()
            goto L_0x0a1c
        L_0x0a1b:
            r6 = 0
        L_0x0a1c:
            r7.zze(r6)
            r6 = r28
            r7.zzf(r6)
            r6 = r25
            r7.zza(r6)
            com.google.android.gms.internal.ads.zzo r6 = r7.zzg()
            r1.zzA(r6)
            if (r16 == 0) goto L_0x0a48
            long r6 = r16.zzc
            int r6 = com.google.android.gms.internal.ads.zzgap.zze(r6)
            r1.zzx(r6)
            long r6 = r16.zzd
            int r6 = com.google.android.gms.internal.ads.zzgap.zze(r6)
            r1.zzS(r6)
        L_0x0a48:
            com.google.android.gms.internal.ads.zzaf r1 = r1.zzad()
            r6 = r45
            r6.zzb = r1
        L_0x0a50:
            int r13 = r37 + r39
            r0.zzK(r13)
            int r12 = r17 + 1
            r11 = r59
            r4 = r2
            r7 = r3
            r14 = r6
            r5 = r18
            r13 = r19
            r9 = r21
            r3 = r27
            r1 = r29
            r15 = r33
            r8 = r43
            r2 = 12
            r6 = 8
            goto L_0x01fd
        L_0x0a70:
            r18 = r5
            r43 = r8
            r21 = r9
            r19 = r13
            r6 = r14
            r33 = r15
            if (r60 != 0) goto L_0x0af1
            r0 = 1701082227(0x65647473, float:6.742798E22)
            r1 = r33
            com.google.android.gms.internal.ads.zzahv r0 = r1.zza(r0)
            if (r0 == 0) goto L_0x0af3
            r2 = 1701606260(0x656c7374, float:6.9788014E22)
            com.google.android.gms.internal.ads.zzahw r0 = r0.zzb(r2)
            if (r0 != 0) goto L_0x0a93
            r4 = 0
            goto L_0x0ae2
        L_0x0a93:
            com.google.android.gms.internal.ads.zzek r0 = r0.zza
            r2 = 8
            r0.zzK(r2)
            int r2 = r0.zzg()
            int r2 = com.google.android.gms.internal.ads.zzahx.zze(r2)
            int r3 = r0.zzp()
            long[] r4 = new long[r3]
            long[] r5 = new long[r3]
            r7 = 0
        L_0x0aab:
            if (r7 >= r3) goto L_0x0ade
            r8 = 1
            if (r2 != r8) goto L_0x0ab5
            long r9 = r0.zzv()
            goto L_0x0ab9
        L_0x0ab5:
            long r9 = r0.zzu()
        L_0x0ab9:
            r4[r7] = r9
            if (r2 != r8) goto L_0x0ac2
            long r9 = r0.zzt()
            goto L_0x0ac7
        L_0x0ac2:
            int r9 = r0.zzg()
            long r9 = (long) r9
        L_0x0ac7:
            r5[r7] = r9
            short r9 = r0.zzD()
            if (r9 != r8) goto L_0x0ad6
            r9 = 2
            r0.zzL(r9)
            int r7 = r7 + 1
            goto L_0x0aab
        L_0x0ad6:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x0ade:
            android.util.Pair r4 = android.util.Pair.create(r4, r5)
        L_0x0ae2:
            if (r4 == 0) goto L_0x0af3
            java.lang.Object r0 = r4.first
            long[] r0 = (long[]) r0
            java.lang.Object r2 = r4.second
            long[] r2 = (long[]) r2
            r29 = r0
            r30 = r2
            goto L_0x0af7
        L_0x0af1:
            r1 = r33
        L_0x0af3:
            r29 = 0
            r30 = 0
        L_0x0af7:
            com.google.android.gms.internal.ads.zzaf r0 = r6.zzb
            if (r0 != 0) goto L_0x0aff
            r0 = r62
            goto L_0x0086
        L_0x0aff:
            com.google.android.gms.internal.ads.zzaiw r4 = new com.google.android.gms.internal.ads.zzaiw
            int r17 = r19.zza
            r0 = r43
            java.lang.Object r0 = r0.first
            java.lang.Long r0 = (java.lang.Long) r0
            long r19 = r0.longValue()
            com.google.android.gms.internal.ads.zzaf r0 = r6.zzb
            int r2 = r6.zzd
            com.google.android.gms.internal.ads.zzaix[] r3 = r6.zza
            int r5 = r6.zzc
            r16 = r4
            r25 = r0
            r26 = r2
            r27 = r3
            r28 = r5
            r16.<init>(r17, r18, r19, r21, r23, r25, r26, r27, r28, r29, r30)
            r0 = r62
        L_0x0b26:
            java.lang.Object r2 = r0.apply(r4)
            com.google.android.gms.internal.ads.zzaiw r2 = (com.google.android.gms.internal.ads.zzaiw) r2
            if (r2 == 0) goto L_0x0b58
            r3 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzahv r1 = r1.zza(r3)
            r1.getClass()
            r3 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzahv r1 = r1.zza(r3)
            r1.getClass()
            r3 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzahv r1 = r1.zza(r3)
            r1.getClass()
            r3 = r56
            com.google.android.gms.internal.ads.zzaiz r1 = zzk(r2, r1, r3)
            r2 = r32
            r2.add(r1)
            goto L_0x0b5c
        L_0x0b58:
            r3 = r56
            r2 = r32
        L_0x0b5c:
            int r14 = r31 + 1
            r0 = r55
            r11 = r59
            r12 = r2
            goto L_0x000a
        L_0x0b65:
            java.lang.String r0 = "Malformed sample table (stbl) missing sample description (stsd)"
            r1 = 0
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r1)
            throw r0
        L_0x0b6d:
            r2 = r12
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.zzd(com.google.android.gms.internal.ads.zzahv, com.google.android.gms.internal.ads.zzacy, long, com.google.android.gms.internal.ads.zzy, boolean, boolean, com.google.android.gms.internal.ads.zzful):java.util.List");
    }

    public static void zze(zzek zzek) {
        int zzd = zzek.zzd();
        zzek.zzL(4);
        if (zzek.zzg() != 1751411826) {
            zzd += 4;
        }
        zzek.zzK(zzd);
    }

    private static int zzf(zzek zzek) {
        int zzm = zzek.zzm();
        int i = zzm & 127;
        while ((zzm & 128) == 128) {
            zzm = zzek.zzm();
            i = (i << 7) | (zzm & 127);
        }
        return i;
    }

    private static int zzg(zzek zzek) {
        zzek.zzK(16);
        return zzek.zzg();
    }

    private static Pair zzh(zzek zzek, int i, int i2) throws zzbo {
        boolean z;
        Pair pair;
        boolean z2;
        boolean z3;
        Integer num;
        zzaix zzaix;
        int i3;
        int i4;
        boolean z4;
        byte[] bArr;
        zzek zzek2 = zzek;
        int zzd = zzek.zzd();
        while (zzd - i < i2) {
            zzek2.zzK(zzd);
            int zzg = zzek.zzg();
            boolean z5 = true;
            if (zzg > 0) {
                z = true;
            } else {
                z = false;
            }
            zzaco.zzb(z, "childAtomSize must be positive");
            if (zzek.zzg() == 1936289382) {
                int i5 = zzd + 8;
                int i6 = 0;
                int i7 = -1;
                String str = null;
                Integer num2 = null;
                while (i5 - zzd < zzg) {
                    zzek2.zzK(i5);
                    int zzg2 = zzek.zzg();
                    int zzg3 = zzek.zzg();
                    if (zzg3 == 1718775137) {
                        num2 = Integer.valueOf(zzek.zzg());
                    } else if (zzg3 == 1935894637) {
                        zzek2.zzL(4);
                        str = zzek2.zzA(4, zzfuj.zzc);
                    } else if (zzg3 == 1935894633) {
                        i7 = i5;
                        i6 = zzg2;
                    }
                    i5 += zzg2;
                }
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    if (num2 != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    zzaco.zzb(z2, "frma atom is mandatory");
                    if (i7 != -1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    zzaco.zzb(z3, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            num = num2;
                            zzaix = null;
                            break;
                        }
                        zzek2.zzK(i8);
                        int zzg4 = zzek.zzg();
                        if (zzek.zzg() == 1952804451) {
                            int zze = zzahx.zze(zzek.zzg());
                            zzek2.zzL(1);
                            if (zze == 0) {
                                zzek2.zzL(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int zzm = zzek.zzm();
                                i4 = zzm & 15;
                                i3 = (zzm & 240) >> 4;
                            }
                            if (zzek.zzm() == 1) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            int zzm2 = zzek.zzm();
                            byte[] bArr2 = new byte[16];
                            zzek2.zzG(bArr2, 0, 16);
                            if (!z4 || zzm2 != 0) {
                                bArr = null;
                            } else {
                                int zzm3 = zzek.zzm();
                                byte[] bArr3 = new byte[zzm3];
                                zzek2.zzG(bArr3, 0, zzm3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzaix = new zzaix(z4, str, zzm2, bArr2, i3, i4, bArr);
                        } else {
                            Integer num3 = num2;
                            i8 += zzg4;
                        }
                    }
                    if (zzaix == null) {
                        z5 = false;
                    }
                    zzaco.zzb(z5, "tenc atom is mandatory");
                    int i9 = zzet.zza;
                    pair = Pair.create(num, zzaix);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    return pair;
                }
            }
            zzd += zzg;
        }
        return null;
    }

    private static zzbk zzi(zzek zzek) {
        short zzD = zzek.zzD();
        zzek.zzL(2);
        String zzA = zzek.zzA(zzD, zzfuj.zzc);
        int max = Math.max(zzA.lastIndexOf(43), zzA.lastIndexOf(45));
        try {
            return new zzbk(-9223372036854775807L, new zzfa(Float.parseFloat(zzA.substring(0, max)), Float.parseFloat(zzA.substring(max, zzA.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static zzahz zzj(zzek zzek, int i) {
        long j;
        long j2;
        zzek.zzK(i + 12);
        zzek.zzL(1);
        zzf(zzek);
        zzek.zzL(2);
        int zzm = zzek.zzm();
        if ((zzm & 128) != 0) {
            zzek.zzL(2);
        }
        if ((zzm & 64) != 0) {
            zzek.zzL(zzek.zzm());
        }
        if ((zzm & 32) != 0) {
            zzek.zzL(2);
        }
        zzek.zzL(1);
        zzf(zzek);
        String zzd = zzbn.zzd(zzek.zzm());
        if ("audio/mpeg".equals(zzd) || "audio/vnd.dts".equals(zzd) || "audio/vnd.dts.hd".equals(zzd)) {
            return new zzahz(zzd, (byte[]) null, -1, -1);
        }
        zzek.zzL(4);
        long zzu = zzek.zzu();
        long zzu2 = zzek.zzu();
        zzek.zzL(1);
        int zzf = zzf(zzek);
        byte[] bArr = new byte[zzf];
        zzek.zzG(bArr, 0, zzf);
        if (zzu2 <= 0) {
            j = -1;
        } else {
            j = zzu2;
        }
        if (zzu > 0) {
            j2 = zzu;
        } else {
            j2 = -1;
        }
        return new zzahz(zzd, bArr, j, j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x02a3  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x02e2  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0320  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x0323  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0353  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0365  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x027f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0290 A[LOOP:7: B:99:0x0290->B:103:0x029a, LOOP_START, PHI: r17 
      PHI: (r17v9 int) = (r17v5 int), (r17v10 int) binds: [B:98:0x028e, B:103:0x029a] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzaiz zzk(com.google.android.gms.internal.ads.zzaiw r39, com.google.android.gms.internal.ads.zzahv r40, com.google.android.gms.internal.ads.zzacy r41) throws com.google.android.gms.internal.ads.zzbo {
        /*
            r1 = r39
            r0 = r40
            r2 = r41
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.gms.internal.ads.zzahw r3 = r0.zzb(r3)
            r4 = 0
            if (r3 == 0) goto L_0x0018
            com.google.android.gms.internal.ads.zzaf r5 = r1.zzf
            com.google.android.gms.internal.ads.zzaic r6 = new com.google.android.gms.internal.ads.zzaic
            r6.<init>(r3, r5)
            goto L_0x0026
        L_0x0018:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.gms.internal.ads.zzahw r3 = r0.zzb(r3)
            if (r3 == 0) goto L_0x05d1
            com.google.android.gms.internal.ads.zzaid r6 = new com.google.android.gms.internal.ads.zzaid
            r6.<init>(r3)
        L_0x0026:
            int r3 = r6.zzb()
            r5 = 0
            if (r3 != 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzaiz r9 = new com.google.android.gms.internal.ads.zzaiz
            long[] r2 = new long[r5]
            int[] r3 = new int[r5]
            r4 = 0
            long[] r6 = new long[r5]
            int[] r7 = new int[r5]
            r10 = 0
            r0 = r9
            r1 = r39
            r5 = r6
            r6 = r7
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0044:
            r7 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.gms.internal.ads.zzahw r7 = r0.zzb(r7)
            if (r7 != 0) goto L_0x0059
            r7 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.gms.internal.ads.zzahw r7 = r0.zzb(r7)
            r7.getClass()
            r8 = 1
            goto L_0x005a
        L_0x0059:
            r8 = r5
        L_0x005a:
            r9 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.gms.internal.ads.zzahw r9 = r0.zzb(r9)
            r9.getClass()
            r10 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.gms.internal.ads.zzahw r10 = r0.zzb(r10)
            r10.getClass()
            r11 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.gms.internal.ads.zzahw r11 = r0.zzb(r11)
            if (r11 == 0) goto L_0x007a
            com.google.android.gms.internal.ads.zzek r11 = r11.zza
            goto L_0x007b
        L_0x007a:
            r11 = r4
        L_0x007b:
            r12 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.gms.internal.ads.zzahw r0 = r0.zzb(r12)
            if (r0 == 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzek r0 = r0.zza
            goto L_0x0088
        L_0x0087:
            r0 = r4
        L_0x0088:
            com.google.android.gms.internal.ads.zzek r10 = r10.zza
            com.google.android.gms.internal.ads.zzek r9 = r9.zza
            com.google.android.gms.internal.ads.zzek r7 = r7.zza
            com.google.android.gms.internal.ads.zzahy r12 = new com.google.android.gms.internal.ads.zzahy
            r12.<init>(r9, r7, r8)
            r7 = 12
            r10.zzK(r7)
            int r8 = r10.zzp()
            r9 = -1
            int r8 = r8 + r9
            int r13 = r10.zzp()
            int r14 = r10.zzp()
            if (r0 == 0) goto L_0x00b0
            r0.zzK(r7)
            int r15 = r0.zzp()
            goto L_0x00b1
        L_0x00b0:
            r15 = r5
        L_0x00b1:
            if (r11 == 0) goto L_0x00c2
            r11.zzK(r7)
            int r5 = r11.zzp()
            if (r5 <= 0) goto L_0x00c3
            int r4 = r11.zzp()
            int r4 = r4 + r9
            goto L_0x00c5
        L_0x00c2:
            r4 = r11
        L_0x00c3:
            r11 = r4
            r4 = r9
        L_0x00c5:
            int r7 = r6.zza()
            r40 = r4
            com.google.android.gms.internal.ads.zzaf r4 = r1.zzf
            java.lang.String r4 = r4.zzm
            if (r7 == r9) goto L_0x0187
            java.lang.String r9 = "audio/raw"
            boolean r9 = r9.equals(r4)
            if (r9 != 0) goto L_0x00e9
            java.lang.String r9 = "audio/g711-mlaw"
            boolean r9 = r9.equals(r4)
            if (r9 != 0) goto L_0x00e9
            java.lang.String r9 = "audio/g711-alaw"
            boolean r4 = r9.equals(r4)
            if (r4 == 0) goto L_0x0187
        L_0x00e9:
            if (r8 != 0) goto L_0x0187
            if (r15 != 0) goto L_0x0186
            if (r5 != 0) goto L_0x0186
            int r0 = r12.zza
            long[] r4 = new long[r0]
            int[] r5 = new int[r0]
        L_0x00f5:
            boolean r6 = r12.zza()
            if (r6 == 0) goto L_0x0106
            int r6 = r12.zzb
            long r8 = r12.zzd
            r4[r6] = r8
            int r8 = r12.zzc
            r5[r6] = r8
            goto L_0x00f5
        L_0x0106:
            long r8 = (long) r14
            r6 = 8192(0x2000, float:1.14794E-41)
            int r6 = r6 / r7
            r10 = 0
            r11 = 0
        L_0x010c:
            if (r10 >= r0) goto L_0x011a
            r12 = r5[r10]
            int r13 = com.google.android.gms.internal.ads.zzet.zza
            int r12 = r12 + r6
            r13 = -1
            int r12 = r12 + r13
            int r12 = r12 / r6
            int r11 = r11 + r12
            int r10 = r10 + 1
            goto L_0x010c
        L_0x011a:
            long[] r10 = new long[r11]
            int[] r12 = new int[r11]
            long[] r13 = new long[r11]
            int[] r11 = new int[r11]
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0128:
            if (r14 >= r0) goto L_0x0178
            r18 = r5[r14]
            r19 = r4[r14]
            r37 = r17
            r17 = r0
            r0 = r16
            r16 = r37
            r38 = r18
            r18 = r4
            r4 = r38
        L_0x013c:
            if (r4 <= 0) goto L_0x0167
            int r21 = java.lang.Math.min(r6, r4)
            r10[r16] = r19
            r40 = r5
            int r5 = r7 * r21
            r12[r16] = r5
            int r0 = java.lang.Math.max(r0, r5)
            r22 = r6
            long r5 = (long) r15
            long r5 = r5 * r8
            r13[r16] = r5
            r5 = 1
            r11[r16] = r5
            r5 = r12[r16]
            long r5 = (long) r5
            long r19 = r19 + r5
            int r15 = r15 + r21
            int r4 = r4 - r21
            int r16 = r16 + 1
            r5 = r40
            r6 = r22
            goto L_0x013c
        L_0x0167:
            r40 = r5
            r22 = r6
            int r14 = r14 + 1
            r4 = r18
            r37 = r16
            r16 = r0
            r0 = r17
            r17 = r37
            goto L_0x0128
        L_0x0178:
            long r4 = (long) r15
            long r8 = r8 * r4
            r15 = r1
            r0 = r3
            r2 = r10
            r6 = r11
            r3 = r12
            r5 = r13
            r4 = r16
            r16 = r8
            goto L_0x033b
        L_0x0186:
            r8 = 0
        L_0x0187:
            long[] r4 = new long[r3]
            int[] r7 = new int[r3]
            long[] r9 = new long[r3]
            r16 = r5
            int[] r5 = new int[r3]
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r2 = r17
            r1 = r21
            r21 = r10
            r17 = r15
            r15 = r14
            r14 = r13
            r13 = r8
            r8 = r40
        L_0x01ac:
            java.lang.String r10 = "AtomParsers"
            if (r2 >= r3) goto L_0x027f
            r26 = 1
        L_0x01b2:
            if (r18 != 0) goto L_0x01d7
            boolean r26 = r12.zza()
            if (r26 == 0) goto L_0x01cf
            r40 = r13
            r27 = r14
            long r13 = r12.zzd
            r28 = r3
            int r3 = r12.zzc
            r18 = r3
            r22 = r13
            r14 = r27
            r3 = r28
            r13 = r40
            goto L_0x01b2
        L_0x01cf:
            r28 = r3
            r40 = r13
            r27 = r14
            r3 = 0
            goto L_0x01df
        L_0x01d7:
            r28 = r3
            r40 = r13
            r27 = r14
            r3 = r18
        L_0x01df:
            if (r26 != 0) goto L_0x01f9
            java.lang.String r3 = "Unexpected end of chunk data"
            com.google.android.gms.internal.ads.zzea.zzf(r10, r3)
            long[] r4 = java.util.Arrays.copyOf(r4, r2)
            int[] r7 = java.util.Arrays.copyOf(r7, r2)
            long[] r9 = java.util.Arrays.copyOf(r9, r2)
            int[] r5 = java.util.Arrays.copyOf(r5, r2)
            r3 = r2
            goto L_0x0289
        L_0x01f9:
            if (r0 != 0) goto L_0x01fe
        L_0x01fb:
            r10 = r20
            goto L_0x0212
        L_0x01fe:
            if (r19 != 0) goto L_0x020f
            if (r17 <= 0) goto L_0x020d
            int r17 = r17 + -1
            int r19 = r0.zzp()
            int r20 = r0.zzg()
            goto L_0x01fe
        L_0x020d:
            r19 = 0
        L_0x020f:
            int r19 = r19 + -1
            goto L_0x01fb
        L_0x0212:
            r4[r2] = r22
            int r13 = r6.zzc()
            r7[r2] = r13
            if (r13 <= r1) goto L_0x021d
            r1 = r13
        L_0x021d:
            long r13 = (long) r10
            long r13 = r24 + r13
            r9[r2] = r13
            if (r11 != 0) goto L_0x0226
            r13 = 1
            goto L_0x0227
        L_0x0226:
            r13 = 0
        L_0x0227:
            r5[r2] = r13
            if (r2 != r8) goto L_0x023b
            r13 = 1
            r5[r2] = r13
            int r16 = r16 + -1
            if (r16 <= 0) goto L_0x023b
            r11.getClass()
            int r8 = r11.zzp()
            int r8 = r8 + -1
        L_0x023b:
            long r13 = (long) r15
            long r24 = r24 + r13
            int r14 = r27 + -1
            if (r14 != 0) goto L_0x025e
            if (r40 <= 0) goto L_0x0257
            int r13 = r21.zzp()
            int r14 = r21.zzg()
            int r15 = r40 + -1
            r18 = r1
            r37 = r14
            r14 = r13
            r13 = r15
            r15 = r37
            goto L_0x0262
        L_0x0257:
            r13 = 0
            r18 = r1
            r14 = r13
            r13 = r40
            goto L_0x0262
        L_0x025e:
            r13 = r40
            r18 = r1
        L_0x0262:
            r1 = r7[r2]
            r26 = r4
            r29 = r5
            long r4 = (long) r1
            long r22 = r22 + r4
            int r1 = r3 + -1
            int r2 = r2 + 1
            r20 = r10
            r4 = r26
            r3 = r28
            r5 = r29
            r37 = r18
            r18 = r1
            r1 = r37
            goto L_0x01ac
        L_0x027f:
            r28 = r3
            r26 = r4
            r29 = r5
            r40 = r13
            r27 = r14
        L_0x0289:
            r2 = r20
            long r11 = (long) r2
            long r11 = r24 + r11
            if (r0 == 0) goto L_0x02a0
        L_0x0290:
            if (r17 <= 0) goto L_0x02a0
            int r2 = r0.zzp()
            if (r2 == 0) goto L_0x029a
            r0 = 0
            goto L_0x02a1
        L_0x029a:
            r0.zzg()
            int r17 = r17 + -1
            goto L_0x0290
        L_0x02a0:
            r0 = 1
        L_0x02a1:
            if (r16 != 0) goto L_0x02e2
            if (r27 != 0) goto L_0x02d3
            if (r18 != 0) goto L_0x02ce
            if (r40 != 0) goto L_0x02ca
            if (r19 != 0) goto L_0x02c3
            if (r0 != 0) goto L_0x02b7
            r16 = 0
            r14 = 0
            r0 = 0
            r18 = 0
            r13 = 0
            r19 = 0
            goto L_0x02d9
        L_0x02b7:
            r15 = r39
            r16 = r1
            r40 = r3
            r17 = r4
            r18 = r5
            goto L_0x032f
        L_0x02c3:
            r2 = 0
            r6 = 0
            r13 = 0
            r14 = r2
            r18 = r6
            goto L_0x02d7
        L_0x02ca:
            r2 = 0
            r18 = 0
            goto L_0x02cf
        L_0x02ce:
            r2 = 0
        L_0x02cf:
            r13 = r40
            r14 = r2
            goto L_0x02d7
        L_0x02d3:
            r13 = r40
            r14 = r27
        L_0x02d7:
            r16 = 0
        L_0x02d9:
            r15 = r39
            r2 = r16
            r6 = r18
            r8 = r19
            goto L_0x02ee
        L_0x02e2:
            r15 = r39
            r13 = r40
            r2 = r16
            r6 = r18
            r8 = r19
            r14 = r27
        L_0x02ee:
            r16 = r1
            int r1 = r15.zza
            r40 = r3
            java.lang.String r3 = "Inconsistent stbl box for track "
            r17 = r4
            java.lang.String r4 = ": remainingSynchronizationSamples "
            r18 = r5
            java.lang.String r5 = ", remainingSamplesAtTimestampDelta "
            java.lang.StringBuilder r1 = defpackage.C1058d.C(r3, r1, r4, r2, r5)
            r1.append(r14)
            java.lang.String r2 = ", remainingSamplesInChunk "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = ", remainingTimestampDeltaChanges "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r2 = ", remainingSamplesAtTimestampOffset "
            r1.append(r2)
            r1.append(r8)
            r2 = 1
            if (r2 == r0) goto L_0x0323
            java.lang.String r0 = ", ctts invalid"
            goto L_0x0325
        L_0x0323:
            java.lang.String r0 = ""
        L_0x0325:
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            com.google.android.gms.internal.ads.zzea.zzf(r10, r0)
        L_0x032f:
            r0 = r40
            r3 = r7
            r5 = r9
            r4 = r16
            r2 = r17
            r6 = r18
            r16 = r11
        L_0x033b:
            r13 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r15.zzc
            java.math.RoundingMode r1 = java.math.RoundingMode.FLOOR
            r7 = r16
            r9 = r13
            r40 = r3
            r18 = r4
            r3 = r13
            r13 = r1
            long r7 = com.google.android.gms.internal.ads.zzet.zzt(r7, r9, r11, r13)
            long[] r1 = r15.zzh
            if (r1 != 0) goto L_0x0365
            long r0 = r15.zzc
            com.google.android.gms.internal.ads.zzet.zzF(r5, r3, r0)
            com.google.android.gms.internal.ads.zzaiz r9 = new com.google.android.gms.internal.ads.zzaiz
            r0 = r9
            r1 = r39
            r3 = r40
            r4 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0365:
            int r3 = r1.length
            r4 = 1
            if (r3 != r4) goto L_0x0420
            int r3 = r15.zzb
            if (r3 != r4) goto L_0x0420
            int r3 = r5.length
            r4 = 2
            if (r3 < r4) goto L_0x0420
            long[] r4 = r15.zzi
            r4.getClass()
            r7 = 0
            r8 = r4[r7]
            r19 = r1[r7]
            long r10 = r15.zzc
            long r12 = r15.zzd
            java.math.RoundingMode r25 = java.math.RoundingMode.FLOOR
            r21 = r10
            r23 = r12
            long r10 = com.google.android.gms.internal.ads.zzet.zzt(r19, r21, r23, r25)
            long r10 = r10 + r8
            int r1 = r3 + -1
            r4 = 4
            int r4 = java.lang.Math.min(r4, r1)
            int r4 = java.lang.Math.max(r7, r4)
            int r3 = r3 + -4
            int r1 = java.lang.Math.min(r3, r1)
            int r1 = java.lang.Math.max(r7, r1)
            r12 = r5[r7]
            int r3 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r3 > 0) goto L_0x0420
            r3 = r5[r4]
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0420
            r3 = r5[r1]
            int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r1 >= 0) goto L_0x0420
            int r1 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r1 > 0) goto L_0x0420
            long r19 = r8 - r12
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzf
            int r1 = r1.zzA
            long r3 = (long) r1
            long r7 = r15.zzc
            java.math.RoundingMode r25 = java.math.RoundingMode.FLOOR
            r21 = r3
            r23 = r7
            long r3 = com.google.android.gms.internal.ads.zzet.zzt(r19, r21, r23, r25)
            com.google.android.gms.internal.ads.zzaf r1 = r15.zzf
            int r1 = r1.zzA
            long r7 = (long) r1
            long r12 = r15.zzc
            long r19 = r16 - r10
            java.math.RoundingMode r25 = java.math.RoundingMode.FLOOR
            r21 = r7
            r23 = r12
            long r7 = com.google.android.gms.internal.ads.zzet.zzt(r19, r21, r23, r25)
            r9 = 0
            int r1 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x03e7
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L_0x0420
            r3 = 0
        L_0x03e7:
            r9 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r1 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r1 > 0) goto L_0x0420
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x03f3
            goto L_0x0420
        L_0x03f3:
            int r0 = (int) r3
            r1 = r41
            r1.zza = r0
            int r0 = (int) r7
            r1.zzb = r0
            long r0 = r15.zzc
            r3 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.gms.internal.ads.zzet.zzF(r5, r3, r0)
            long[] r0 = r15.zzh
            r1 = 0
            r7 = r0[r1]
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r15.zzd
            java.math.RoundingMode r13 = java.math.RoundingMode.FLOOR
            long r7 = com.google.android.gms.internal.ads.zzet.zzt(r7, r9, r11, r13)
            com.google.android.gms.internal.ads.zzaiz r9 = new com.google.android.gms.internal.ads.zzaiz
            r0 = r9
            r1 = r39
            r3 = r40
            r4 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0420:
            long[] r1 = r15.zzh
            int r3 = r1.length
            r4 = 1
            if (r3 != r4) goto L_0x046b
            r3 = 0
            r7 = r1[r3]
            r9 = 0
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x046a
            long[] r0 = r15.zzi
            r0.getClass()
            r3 = r0[r3]
            r0 = 0
        L_0x0437:
            int r1 = r5.length
            if (r0 >= r1) goto L_0x0450
            r7 = r5[r0]
            long r19 = r7 - r3
            r21 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r15.zzc
            java.math.RoundingMode r25 = java.math.RoundingMode.FLOOR
            r23 = r7
            long r7 = com.google.android.gms.internal.ads.zzet.zzt(r19, r21, r23, r25)
            r5[r0] = r7
            int r0 = r0 + 1
            goto L_0x0437
        L_0x0450:
            long r7 = r16 - r3
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r15.zzc
            java.math.RoundingMode r13 = java.math.RoundingMode.FLOOR
            long r7 = com.google.android.gms.internal.ads.zzet.zzt(r7, r9, r11, r13)
            com.google.android.gms.internal.ads.zzaiz r9 = new com.google.android.gms.internal.ads.zzaiz
            r0 = r9
            r1 = r39
            r3 = r40
            r4 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x046a:
            r3 = 1
        L_0x046b:
            int r1 = r15.zzb
            r4 = 1
            if (r1 != r4) goto L_0x0472
            r1 = 1
            goto L_0x0473
        L_0x0472:
            r1 = 0
        L_0x0473:
            long[] r4 = r15.zzi
            int[] r7 = new int[r3]
            int[] r3 = new int[r3]
            r4.getClass()
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0480:
            long[] r12 = r15.zzh
            int r13 = r12.length
            if (r10 >= r13) goto L_0x04da
            r13 = r4[r10]
            r16 = -1
            int r16 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r16 == 0) goto L_0x04d2
            r19 = r12[r10]
            r16 = r11
            long r11 = r15.zzc
            r41 = r8
            r17 = r9
            long r8 = r15.zzd
            java.math.RoundingMode r25 = java.math.RoundingMode.FLOOR
            r21 = r11
            r23 = r8
            long r8 = com.google.android.gms.internal.ads.zzet.zzt(r19, r21, r23, r25)
            r11 = 1
            int r12 = com.google.android.gms.internal.ads.zzet.zzc(r5, r13, r11, r11)
            r7[r10] = r12
            long r13 = r13 + r8
            r8 = 0
            int r9 = com.google.android.gms.internal.ads.zzet.zza(r5, r13, r1, r8)
            r3[r10] = r9
        L_0x04b2:
            r9 = r7[r10]
            r12 = r3[r10]
            if (r9 >= r12) goto L_0x04c3
            r13 = r6[r9]
            r11 = r11 & r13
            if (r11 != 0) goto L_0x04c3
            int r9 = r9 + 1
            r7[r10] = r9
            r11 = 1
            goto L_0x04b2
        L_0x04c3:
            int r11 = r12 - r9
            int r11 = r11 + r41
            r13 = r16
            if (r13 == r9) goto L_0x04cc
            r8 = 1
        L_0x04cc:
            r8 = r17 | r8
            r9 = r8
            r8 = r11
            r11 = r12
            goto L_0x04d7
        L_0x04d2:
            r41 = r8
            r17 = r9
            r13 = r11
        L_0x04d7:
            int r10 = r10 + 1
            goto L_0x0480
        L_0x04da:
            r41 = r8
            r17 = r9
            r1 = 0
            if (r8 == r0) goto L_0x04e3
            r0 = 1
            goto L_0x04e4
        L_0x04e3:
            r0 = r1
        L_0x04e4:
            r0 = r17 | r0
            if (r0 == 0) goto L_0x04eb
            long[] r4 = new long[r8]
            goto L_0x04ec
        L_0x04eb:
            r4 = r2
        L_0x04ec:
            if (r0 == 0) goto L_0x04f1
            int[] r9 = new int[r8]
            goto L_0x04f3
        L_0x04f1:
            r9 = r40
        L_0x04f3:
            r10 = 1
            if (r10 != r0) goto L_0x04f8
            r18 = r1
        L_0x04f8:
            if (r0 == 0) goto L_0x04fd
            int[] r10 = new int[r8]
            goto L_0x04fe
        L_0x04fd:
            r10 = r6
        L_0x04fe:
            long[] r8 = new long[r8]
            r11 = 0
            r12 = r11
            r11 = r1
        L_0x0504:
            long[] r14 = r15.zzh
            int r14 = r14.length
            if (r1 >= r14) goto L_0x05a8
            long[] r14 = r15.zzi
            r16 = r14[r1]
            r14 = r7[r1]
            r26 = r7
            r7 = r3[r1]
            if (r0 == 0) goto L_0x0527
            r27 = r3
            int r3 = r7 - r14
            java.lang.System.arraycopy(r2, r14, r4, r11, r3)
            r28 = r2
            r2 = r40
            java.lang.System.arraycopy(r2, r14, r9, r11, r3)
            java.lang.System.arraycopy(r6, r14, r10, r11, r3)
            goto L_0x052d
        L_0x0527:
            r28 = r2
            r27 = r3
            r2 = r40
        L_0x052d:
            r3 = r18
        L_0x052f:
            if (r14 >= r7) goto L_0x0584
            r21 = 1000000(0xf4240, double:4.940656E-318)
            r40 = r6
            r41 = r7
            long r6 = r15.zzd
            java.math.RoundingMode r25 = java.math.RoundingMode.FLOOR
            r19 = r12
            r23 = r6
            long r6 = com.google.android.gms.internal.ads.zzet.zzt(r19, r21, r23, r25)
            r18 = r5[r14]
            long r29 = r18 - r16
            r31 = 1000000(0xf4240, double:4.940656E-318)
            r36 = r4
            r19 = r5
            long r4 = r15.zzc
            java.math.RoundingMode r35 = java.math.RoundingMode.FLOOR
            r33 = r4
            long r4 = com.google.android.gms.internal.ads.zzet.zzt(r29, r31, r33, r35)
            r29 = r10
            int r10 = r15.zzb
            r20 = r12
            r12 = 1
            if (r10 == r12) goto L_0x0568
            r12 = 0
            long r4 = java.lang.Math.max(r12, r4)
        L_0x0568:
            long r6 = r6 + r4
            r8[r11] = r6
            if (r0 == 0) goto L_0x0573
            r4 = r9[r11]
            if (r4 <= r3) goto L_0x0573
            r3 = r2[r14]
        L_0x0573:
            int r11 = r11 + 1
            int r14 = r14 + 1
            r6 = r40
            r7 = r41
            r5 = r19
            r12 = r20
            r10 = r29
            r4 = r36
            goto L_0x052f
        L_0x0584:
            r36 = r4
            r19 = r5
            r40 = r6
            r29 = r10
            r20 = r12
            long[] r4 = r15.zzh
            r5 = r4[r1]
            long r12 = r20 + r5
            int r1 = r1 + 1
            r6 = r40
            r40 = r2
            r18 = r3
            r5 = r19
            r7 = r26
            r3 = r27
            r2 = r28
            r4 = r36
            goto L_0x0504
        L_0x05a8:
            r36 = r4
            r29 = r10
            r20 = r12
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r15.zzd
            java.math.RoundingMode r25 = java.math.RoundingMode.FLOOR
            r19 = r20
            r21 = r0
            r23 = r2
            long r10 = com.google.android.gms.internal.ads.zzet.zzt(r19, r21, r23, r25)
            com.google.android.gms.internal.ads.zzaiz r12 = new com.google.android.gms.internal.ads.zzaiz
            r0 = r12
            r1 = r39
            r2 = r36
            r3 = r9
            r4 = r18
            r5 = r8
            r6 = r29
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r12
        L_0x05d1:
            java.lang.String r0 = "Track has no sample table size information"
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.zzk(com.google.android.gms.internal.ads.zzaiw, com.google.android.gms.internal.ads.zzahv, com.google.android.gms.internal.ads.zzacy):com.google.android.gms.internal.ads.zzaiz");
    }

    private static ByteBuffer zzl() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* JADX WARNING: Removed duplicated region for block: B:122:0x01bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzm(com.google.android.gms.internal.ads.zzek r26, int r27, int r28, int r29, int r30, java.lang.String r31, boolean r32, com.google.android.gms.internal.ads.zzy r33, com.google.android.gms.internal.ads.zzaib r34, int r35) throws com.google.android.gms.internal.ads.zzbo {
        /*
            r0 = r26
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r5 = r33
            r6 = r34
            int r7 = r1 + 16
            r0.zzK(r7)
            r7 = 6
            r8 = 8
            if (r32 == 0) goto L_0x0020
            int r10 = r26.zzq()
            r0.zzL(r7)
            goto L_0x0024
        L_0x0020:
            r0.zzL(r8)
            r10 = 0
        L_0x0024:
            r14 = 4
            r11 = 2
            r12 = 1
            r9 = 16
            if (r10 == 0) goto L_0x0086
            if (r10 != r12) goto L_0x002e
            goto L_0x0086
        L_0x002e:
            if (r10 != r11) goto L_0x0548
            r0.zzL(r9)
            long r19 = r26.zzt()
            double r19 = java.lang.Double.longBitsToDouble(r19)
            long r12 = java.lang.Math.round(r19)
            int r7 = (int) r12
            int r10 = r26.zzp()
            r0.zzL(r14)
            int r12 = r26.zzp()
            int r13 = r26.zzp()
            r19 = r13 & 1
            r13 = r13 & r11
            if (r19 != 0) goto L_0x007a
            if (r12 != r8) goto L_0x0058
            r9 = 3
            goto L_0x0081
        L_0x0058:
            if (r12 != r9) goto L_0x0061
            if (r13 == 0) goto L_0x005f
            r9 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0081
        L_0x005f:
            r9 = r11
            goto L_0x0081
        L_0x0061:
            r9 = 24
            if (r12 != r9) goto L_0x006d
            if (r13 == 0) goto L_0x006a
            r9 = 1342177280(0x50000000, float:8.5899346E9)
            goto L_0x0081
        L_0x006a:
            r9 = 21
            goto L_0x0081
        L_0x006d:
            r9 = 32
            if (r12 != r9) goto L_0x0080
            if (r13 == 0) goto L_0x0076
            r12 = 1610612736(0x60000000, float:3.6893488E19)
            goto L_0x0078
        L_0x0076:
            r12 = 22
        L_0x0078:
            r9 = r12
            goto L_0x0081
        L_0x007a:
            r9 = 32
            if (r12 != r9) goto L_0x0080
            r9 = r14
            goto L_0x0081
        L_0x0080:
            r9 = -1
        L_0x0081:
            r0.zzL(r8)
            r12 = 0
            goto L_0x00a6
        L_0x0086:
            int r8 = r26.zzq()
            r0.zzL(r7)
            int r7 = r26.zzn()
            int r12 = r26.zzd()
            int r12 = r12 + -4
            r0.zzK(r12)
            int r12 = r26.zzg()
            r13 = 1
            if (r10 != r13) goto L_0x00a4
            r0.zzL(r9)
        L_0x00a4:
            r10 = r8
            r9 = -1
        L_0x00a6:
            int r8 = r26.zzd()
            r13 = 1701733217(0x656e6361, float:7.0359778E22)
            r11 = r27
            if (r11 != r13) goto L_0x00dd
            android.util.Pair r11 = zzh(r0, r1, r2)
            if (r11 == 0) goto L_0x00d7
            java.lang.Object r13 = r11.first
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            if (r5 != 0) goto L_0x00c3
            r14 = 0
            goto L_0x00ce
        L_0x00c3:
            java.lang.Object r14 = r11.second
            com.google.android.gms.internal.ads.zzaix r14 = (com.google.android.gms.internal.ads.zzaix) r14
            java.lang.String r14 = r14.zzb
            com.google.android.gms.internal.ads.zzy r5 = r5.zzb(r14)
            r14 = r5
        L_0x00ce:
            com.google.android.gms.internal.ads.zzaix[] r5 = r6.zza
            java.lang.Object r11 = r11.second
            com.google.android.gms.internal.ads.zzaix r11 = (com.google.android.gms.internal.ads.zzaix) r11
            r5[r35] = r11
            goto L_0x00d8
        L_0x00d7:
            r14 = r5
        L_0x00d8:
            r0.zzK(r8)
            r11 = r13
            goto L_0x00de
        L_0x00dd:
            r14 = r5
        L_0x00de:
            r5 = 1633889587(0x61632d33, float:2.6191674E20)
            java.lang.String r13 = "audio/mhm1"
            java.lang.String r15 = "audio/ac4"
            if (r11 != r5) goto L_0x00ec
            java.lang.String r5 = "audio/ac3"
        L_0x00e9:
            r11 = r9
            goto L_0x01b1
        L_0x00ec:
            r5 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r11 != r5) goto L_0x00f4
            java.lang.String r5 = "audio/eac3"
            goto L_0x00e9
        L_0x00f4:
            r5 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r11 != r5) goto L_0x00fd
            r11 = r9
            r5 = r15
            goto L_0x01b1
        L_0x00fd:
            r5 = 1685353315(0x64747363, float:1.803728E22)
            if (r11 != r5) goto L_0x0105
            java.lang.String r5 = "audio/vnd.dts"
            goto L_0x00e9
        L_0x0105:
            r5 = 1685353320(0x64747368, float:1.8037286E22)
            if (r11 == r5) goto L_0x01ad
            r5 = 1685353324(0x6474736c, float:1.803729E22)
            if (r11 != r5) goto L_0x0111
            goto L_0x01ad
        L_0x0111:
            r5 = 1685353317(0x64747365, float:1.8037282E22)
            if (r11 != r5) goto L_0x0119
            java.lang.String r5 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x00e9
        L_0x0119:
            r5 = 1685353336(0x64747378, float:1.8037304E22)
            if (r11 != r5) goto L_0x0121
            java.lang.String r5 = "audio/vnd.dts.uhd;profile=p2"
            goto L_0x00e9
        L_0x0121:
            r5 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r11 != r5) goto L_0x0129
            java.lang.String r5 = "audio/3gpp"
            goto L_0x00e9
        L_0x0129:
            r5 = 1935767394(0x73617762, float:1.7863284E31)
            if (r11 != r5) goto L_0x0131
            java.lang.String r5 = "audio/amr-wb"
            goto L_0x00e9
        L_0x0131:
            r5 = 1936684916(0x736f7774, float:1.89725E31)
            java.lang.String r22 = "audio/raw"
            if (r11 != r5) goto L_0x013d
        L_0x0138:
            r5 = r22
            r11 = 2
            goto L_0x01b1
        L_0x013d:
            r5 = 1953984371(0x74776f73, float:7.841539E31)
            if (r11 != r5) goto L_0x0148
            r5 = r22
            r11 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x01b1
        L_0x0148:
            r5 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r11 != r5) goto L_0x0155
            r5 = -1
            if (r9 != r5) goto L_0x0151
            goto L_0x0138
        L_0x0151:
            r11 = r9
            r5 = r22
            goto L_0x01b1
        L_0x0155:
            r5 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r11 == r5) goto L_0x01a9
            r5 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r11 != r5) goto L_0x0160
            goto L_0x01a9
        L_0x0160:
            r5 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r11 != r5) goto L_0x0168
            java.lang.String r5 = "audio/mha1"
            goto L_0x00e9
        L_0x0168:
            r5 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r11 != r5) goto L_0x0170
            r11 = r9
            r5 = r13
            goto L_0x01b1
        L_0x0170:
            r5 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r11 != r5) goto L_0x0179
            java.lang.String r5 = "audio/alac"
            goto L_0x00e9
        L_0x0179:
            r5 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r11 != r5) goto L_0x0182
            java.lang.String r5 = "audio/g711-alaw"
            goto L_0x00e9
        L_0x0182:
            r5 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r11 != r5) goto L_0x018b
            java.lang.String r5 = "audio/g711-mlaw"
            goto L_0x00e9
        L_0x018b:
            r5 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r11 != r5) goto L_0x0194
            java.lang.String r5 = "audio/opus"
            goto L_0x00e9
        L_0x0194:
            r5 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r11 != r5) goto L_0x019d
            java.lang.String r5 = "audio/flac"
            goto L_0x00e9
        L_0x019d:
            r5 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r11 != r5) goto L_0x01a6
            java.lang.String r5 = "audio/true-hd"
            goto L_0x00e9
        L_0x01a6:
            r11 = r9
            r5 = 0
            goto L_0x01b1
        L_0x01a9:
            java.lang.String r5 = "audio/mpeg"
            goto L_0x00e9
        L_0x01ad:
            java.lang.String r5 = "audio/vnd.dts.hd"
            goto L_0x00e9
        L_0x01b1:
            r16 = r11
            r33 = 0
            r11 = 0
            r22 = 0
        L_0x01b8:
            int r9 = r8 - r1
            if (r9 >= r2) goto L_0x04ff
            r0.zzK(r8)
            int r9 = r26.zzg()
            if (r9 <= 0) goto L_0x01c7
            r1 = 1
            goto L_0x01c8
        L_0x01c7:
            r1 = 0
        L_0x01c8:
            java.lang.String r2 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzaco.zzb(r1, r2)
            int r1 = r26.zzg()
            r35 = r7
            r7 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r1 != r7) goto L_0x0237
            int r1 = r8 + 8
            r0.zzK(r1)
            r1 = 1
            r0.zzL(r1)
            int r2 = r26.zzm()
            r0.zzL(r1)
            boolean r7 = java.util.Objects.equals(r5, r13)
            if (r7 == 0) goto L_0x0200
            java.lang.Object[] r7 = new java.lang.Object[r1]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r1 = 0
            r7[r1] = r2
            java.lang.String r2 = "mhm1.%02X"
            java.lang.String r2 = java.lang.String.format(r2, r7)
            r23 = r13
            goto L_0x0212
        L_0x0200:
            r7 = r1
            r23 = r13
            r1 = 0
            java.lang.Object[] r13 = new java.lang.Object[r7]
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r13[r1] = r2
            java.lang.String r2 = "mha1.%02X"
            java.lang.String r2 = java.lang.String.format(r2, r13)
        L_0x0212:
            int r7 = r26.zzq()
            byte[] r13 = new byte[r7]
            r0.zzG(r13, r1, r7)
            if (r11 != 0) goto L_0x022c
            com.google.android.gms.internal.ads.zzfxr r11 = com.google.android.gms.internal.ads.zzfxr.zzn(r13)
            r7 = r35
            r24 = r12
            r17 = 3
            r20 = 2
            r12 = r1
            goto L_0x04f0
        L_0x022c:
            java.lang.Object r7 = r11.get(r1)
            byte[] r7 = (byte[]) r7
            com.google.android.gms.internal.ads.zzfxr r11 = com.google.android.gms.internal.ads.zzfxr.zzo(r13, r7)
            goto L_0x026e
        L_0x0237:
            r23 = r13
            r7 = 1835557200(0x6d686150, float:4.4948854E27)
            if (r1 != r7) goto L_0x0284
            int r1 = r8 + 8
            r0.zzK(r1)
            int r1 = r26.zzm()
            if (r1 <= 0) goto L_0x0279
            byte[] r2 = new byte[r1]
            r7 = 0
            r0.zzG(r2, r7, r1)
            if (r11 != 0) goto L_0x0262
            com.google.android.gms.internal.ads.zzfxr r11 = com.google.android.gms.internal.ads.zzfxr.zzn(r2)
            r2 = r33
            r24 = r12
            r17 = 3
            r20 = 2
            r12 = r7
            r7 = r35
            goto L_0x04f0
        L_0x0262:
            java.lang.Object r1 = r11.get(r7)
            byte[] r1 = (byte[]) r1
            com.google.android.gms.internal.ads.zzfxr r11 = com.google.android.gms.internal.ads.zzfxr.zzo(r1, r2)
        L_0x026c:
            r2 = r33
        L_0x026e:
            r7 = r35
            r24 = r12
        L_0x0272:
            r12 = 0
            r17 = 3
            r20 = 2
            goto L_0x04f0
        L_0x0279:
            r2 = r35
            r24 = r12
            r12 = 0
            r17 = 3
            r20 = 2
            goto L_0x04ed
        L_0x0284:
            r7 = 1702061171(0x65736473, float:7.183675E22)
            if (r1 == r7) goto L_0x0445
            if (r32 == 0) goto L_0x02ce
            r13 = 2002876005(0x77617665, float:4.5729223E33)
            if (r1 != r13) goto L_0x02ce
            int r1 = r26.zzd()
            if (r1 < r8) goto L_0x0299
            r7 = 0
            r13 = 1
            goto L_0x029b
        L_0x0299:
            r7 = 0
            r13 = 0
        L_0x029b:
            com.google.android.gms.internal.ads.zzaco.zzb(r13, r7)
        L_0x029e:
            int r7 = r1 - r8
            if (r7 >= r9) goto L_0x02c3
            r0.zzK(r1)
            int r7 = r26.zzg()
            if (r7 <= 0) goto L_0x02ad
            r13 = 1
            goto L_0x02ae
        L_0x02ad:
            r13 = 0
        L_0x02ae:
            com.google.android.gms.internal.ads.zzaco.zzb(r13, r2)
            int r13 = r26.zzg()
            r25 = r2
            r2 = 1702061171(0x65736473, float:7.183675E22)
            if (r13 == r2) goto L_0x02c0
            int r1 = r1 + r7
            r2 = r25
            goto L_0x029e
        L_0x02c0:
            r2 = r35
            goto L_0x02c6
        L_0x02c3:
            r2 = r35
            r1 = -1
        L_0x02c6:
            r7 = -1
            r13 = 4
            r17 = 3
            r20 = 2
            goto L_0x044e
        L_0x02ce:
            r2 = 1684103987(0x64616333, float:1.6630662E22)
            if (r1 != r2) goto L_0x02e3
            int r1 = r8 + 8
            r0.zzK(r1)
            java.lang.String r1 = java.lang.Integer.toString(r30)
            com.google.android.gms.internal.ads.zzaf r1 = com.google.android.gms.internal.ads.zzabj.zzc(r0, r1, r4, r14)
            r6.zzb = r1
            goto L_0x0279
        L_0x02e3:
            r2 = 1684366131(0x64656333, float:1.692581E22)
            if (r1 != r2) goto L_0x02f8
            int r1 = r8 + 8
            r0.zzK(r1)
            java.lang.String r1 = java.lang.Integer.toString(r30)
            com.google.android.gms.internal.ads.zzaf r1 = com.google.android.gms.internal.ads.zzabj.zzd(r0, r1, r4, r14)
            r6.zzb = r1
            goto L_0x0279
        L_0x02f8:
            r2 = 1684103988(0x64616334, float:1.6630663E22)
            if (r1 != r2) goto L_0x033c
            int r1 = r8 + 8
            r0.zzK(r1)
            java.lang.String r1 = java.lang.Integer.toString(r30)
            r2 = 1
            r0.zzL(r2)
            int r7 = r26.zzm()
            r13 = 32
            r7 = r7 & r13
            com.google.android.gms.internal.ads.zzad r13 = new com.google.android.gms.internal.ads.zzad
            r13.<init>()
            r13.zzK(r1)
            r13.zzX(r15)
            r1 = 2
            r13.zzy(r1)
            int r1 = r7 >> 5
            if (r2 == r1) goto L_0x0328
            r1 = 44100(0xac44, float:6.1797E-41)
            goto L_0x032b
        L_0x0328:
            r1 = 48000(0xbb80, float:6.7262E-41)
        L_0x032b:
            r13.zzY(r1)
            r13.zzE(r14)
            r13.zzO(r4)
            com.google.android.gms.internal.ads.zzaf r1 = r13.zzad()
            r6.zzb = r1
            goto L_0x0279
        L_0x033c:
            r2 = 1684892784(0x646d6c70, float:1.7518768E22)
            if (r1 != r2) goto L_0x035f
            if (r12 <= 0) goto L_0x034b
            r2 = r33
            r7 = r12
            r24 = r7
            r10 = 2
            goto L_0x0272
        L_0x034b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Invalid sample rate for Dolby TrueHD MLP stream: "
            r0.<init>(r1)
            r0.append(r12)
            java.lang.String r0 = r0.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r2)
            throw r0
        L_0x035f:
            r2 = 0
            r7 = 1684305011(0x64647473, float:1.6856995E22)
            if (r1 == r7) goto L_0x041c
            r7 = 1969517683(0x75647473, float:2.8960097E32)
            if (r1 != r7) goto L_0x036c
            goto L_0x041c
        L_0x036c:
            r7 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r1 != r7) goto L_0x038a
            int r1 = r8 + 8
            int r7 = r9 + -8
            byte[] r11 = zza
            int r13 = r11.length
            int r13 = r13 + r7
            byte[] r13 = java.util.Arrays.copyOf(r11, r13)
            r0.zzK(r1)
            int r1 = r11.length
            r0.zzG(r13, r1, r7)
            java.util.List r11 = com.google.android.gms.internal.ads.zzade.zze(r13)
            goto L_0x026c
        L_0x038a:
            r7 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r1 != r7) goto L_0x03c3
            int r1 = r8 + 12
            int r7 = r9 + -12
            int r11 = r7 + 4
            byte[] r11 = new byte[r11]
            r13 = 102(0x66, float:1.43E-43)
            r18 = 0
            r11[r18] = r13
            r13 = 76
            r21 = 1
            r11[r21] = r13
            r13 = 97
            r20 = 2
            r11[r20] = r13
            r13 = 67
            r17 = 3
            r11[r17] = r13
            r0.zzK(r1)
            r13 = 4
            r0.zzG(r11, r13, r7)
            com.google.android.gms.internal.ads.zzfxr r11 = com.google.android.gms.internal.ads.zzfxr.zzn(r11)
            r2 = r33
            r7 = r35
            r24 = r12
            r12 = 0
            goto L_0x04f0
        L_0x03c3:
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            r13 = 4
            r17 = 3
            r20 = 2
            if (r1 != r7) goto L_0x0418
            int r1 = r8 + 12
            int r10 = r9 + -12
            byte[] r11 = new byte[r10]
            r0.zzK(r1)
            r1 = 0
            r0.zzG(r11, r1, r10)
            com.google.android.gms.internal.ads.zzek r1 = new com.google.android.gms.internal.ads.zzek
            r1.<init>((byte[]) r11)
            r10 = 9
            r1.zzK(r10)
            int r10 = r1.zzm()
            r2 = 20
            r1.zzK(r2)
            int r1 = r1.zzp()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            android.util.Pair r1 = android.util.Pair.create(r1, r2)
            java.lang.Object r2 = r1.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.google.android.gms.internal.ads.zzfxr r11 = com.google.android.gms.internal.ads.zzfxr.zzn(r11)
            r10 = r1
            r7 = r2
            r24 = r12
            r12 = 0
            goto L_0x04ee
        L_0x0418:
            r2 = r35
            goto L_0x04ea
        L_0x041c:
            r7 = 1634492771(0x616c6163, float:2.7252807E20)
            r13 = 4
            r17 = 3
            r20 = 2
            com.google.android.gms.internal.ads.zzad r1 = new com.google.android.gms.internal.ads.zzad
            r1.<init>()
            r1.zzJ(r3)
            r1.zzX(r5)
            r1.zzy(r10)
            r2 = r35
            r1.zzY(r2)
            r1.zzE(r14)
            r1.zzO(r4)
            com.google.android.gms.internal.ads.zzaf r1 = r1.zzad()
            r6.zzb = r1
            goto L_0x04ea
        L_0x0445:
            r2 = r35
            r13 = 4
            r17 = 3
            r20 = 2
            r1 = r8
            r7 = -1
        L_0x044e:
            if (r1 == r7) goto L_0x04ea
            com.google.android.gms.internal.ads.zzahz r22 = zzj(r0, r1)
            java.lang.String r1 = r22.zza
            byte[] r5 = r22.zzb
            if (r5 == 0) goto L_0x04e5
            java.lang.String r11 = "audio/vorbis"
            boolean r11 = r11.equals(r1)
            if (r11 == 0) goto L_0x04c5
            com.google.android.gms.internal.ads.zzek r11 = new com.google.android.gms.internal.ads.zzek
            r11.<init>((byte[]) r5)
            r7 = 1
            r11.zzL(r7)
            r13 = 0
        L_0x0470:
            int r21 = r11.zzb()
            r7 = 255(0xff, float:3.57E-43)
            if (r21 <= 0) goto L_0x0488
            int r0 = r11.zzf()
            if (r0 != r7) goto L_0x0488
            r0 = 1
            r11.zzL(r0)
            int r13 = r13 + 255
            r0 = r26
            r7 = 1
            goto L_0x0470
        L_0x0488:
            int r0 = r11.zzm()
            int r0 = r0 + r13
            r13 = 0
        L_0x048e:
            int r24 = r11.zzb()
            if (r24 <= 0) goto L_0x04a5
            r24 = r12
            int r12 = r11.zzf()
            if (r12 != r7) goto L_0x04a7
            r12 = 1
            r11.zzL(r12)
            int r13 = r13 + 255
            r12 = r24
            goto L_0x048e
        L_0x04a5:
            r24 = r12
        L_0x04a7:
            r12 = 1
            int r7 = r11.zzm()
            int r7 = r7 + r13
            byte[] r13 = new byte[r0]
            int r11 = r11.zzd()
            r12 = 0
            java.lang.System.arraycopy(r5, r11, r13, r12, r0)
            int r11 = r11 + r0
            int r0 = r5.length
            int r11 = r11 + r7
            int r0 = r0 - r11
            byte[] r7 = new byte[r0]
            java.lang.System.arraycopy(r5, r11, r7, r12, r0)
            com.google.android.gms.internal.ads.zzfxr r11 = com.google.android.gms.internal.ads.zzfxr.zzo(r13, r7)
            goto L_0x04e8
        L_0x04c5:
            r24 = r12
            r12 = 0
            java.lang.String r0 = "audio/mp4a-latm"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x04db
            com.google.android.gms.internal.ads.zzabf r0 = com.google.android.gms.internal.ads.zzabg.zza(r5)
            int r7 = r0.zza
            int r10 = r0.zzb
            java.lang.String r0 = r0.zzc
            goto L_0x04de
        L_0x04db:
            r0 = r33
            r7 = r2
        L_0x04de:
            com.google.android.gms.internal.ads.zzfxr r11 = com.google.android.gms.internal.ads.zzfxr.zzn(r5)
            r2 = r0
            r5 = r1
            goto L_0x04f0
        L_0x04e5:
            r24 = r12
            r12 = 0
        L_0x04e8:
            r5 = r1
            goto L_0x04ed
        L_0x04ea:
            r24 = r12
            r12 = 0
        L_0x04ed:
            r7 = r2
        L_0x04ee:
            r2 = r33
        L_0x04f0:
            int r8 = r8 + r9
            r0 = r26
            r1 = r28
            r33 = r2
            r13 = r23
            r12 = r24
            r2 = r29
            goto L_0x01b8
        L_0x04ff:
            r2 = r7
            com.google.android.gms.internal.ads.zzaf r0 = r6.zzb
            if (r0 != 0) goto L_0x0548
            if (r5 == 0) goto L_0x0548
            com.google.android.gms.internal.ads.zzad r0 = new com.google.android.gms.internal.ads.zzad
            r0.<init>()
            r0.zzJ(r3)
            r0.zzX(r5)
            r1 = r33
            r0.zzz(r1)
            r0.zzy(r10)
            r0.zzY(r2)
            r9 = r16
            r0.zzR(r9)
            r0.zzL(r11)
            r0.zzE(r14)
            r0.zzO(r4)
            if (r22 == 0) goto L_0x0542
            long r1 = r22.zzc
            int r1 = com.google.android.gms.internal.ads.zzgap.zze(r1)
            r0.zzx(r1)
            long r1 = r22.zzd
            int r1 = com.google.android.gms.internal.ads.zzgap.zze(r1)
            r0.zzS(r1)
        L_0x0542:
            com.google.android.gms.internal.ads.zzaf r0 = r0.zzad()
            r6.zzb = r0
        L_0x0548:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaif.zzm(com.google.android.gms.internal.ads.zzek, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzy, com.google.android.gms.internal.ads.zzaib, int):void");
    }
}
