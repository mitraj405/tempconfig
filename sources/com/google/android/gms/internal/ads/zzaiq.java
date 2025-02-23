package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaiq implements zzack, zzadi {
    private zzagr zzA;
    private final zzajy zza;
    private final int zzb;
    private final zzek zzc;
    private final zzek zzd;
    private final zzek zze;
    private final zzek zzf;
    private final ArrayDeque zzg;
    private final zzaiu zzh;
    private final List zzi;
    private zzfxr zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private int zzn;
    private zzek zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private zzacn zzu;
    private zzaip[] zzv;
    private long[][] zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    @Deprecated
    public zzaiq() {
        this(zzajy.zza, 16);
    }

    private static int zzk(int i) {
        if (i == 1751476579) {
            return 2;
        }
        if (i != 1903435808) {
            return 0;
        }
        return 1;
    }

    private static int zzl(zzaiz zzaiz, long j) {
        int zza2 = zzaiz.zza(j);
        if (zza2 == -1) {
            return zzaiz.zzb(j);
        }
        return zza2;
    }

    private static long zzm(zzaiz zzaiz, long j, long j2) {
        int zzl2 = zzl(zzaiz, j);
        if (zzl2 == -1) {
            return j2;
        }
        return Math.min(zzaiz.zzc[zzl2], j2);
    }

    private final void zzn() {
        this.zzk = 0;
        this.zzn = 0;
    }

    private final void zzo(long j) throws zzbo {
        zzbk zzbk;
        zzbk zzbk2;
        boolean z;
        boolean z2;
        long j2;
        List list;
        int i;
        zzbk zzbk3;
        int i2;
        int i3;
        int i4;
        while (!this.zzg.isEmpty() && ((zzahv) this.zzg.peek()).zza == j) {
            zzahv zzahv = (zzahv) this.zzg.pop();
            if (zzahv.zzd == 1836019574) {
                ArrayList arrayList = new ArrayList();
                int i5 = this.zzz;
                zzacy zzacy = new zzacy();
                zzahw zzb2 = zzahv.zzb(1969517665);
                if (zzb2 != null) {
                    zzbk zzb3 = zzaif.zzb(zzb2);
                    zzacy.zzb(zzb3);
                    zzbk = zzb3;
                } else {
                    zzbk = null;
                }
                zzahv zza2 = zzahv.zza(1835365473);
                if (zza2 != null) {
                    zzbk2 = zzaif.zza(zza2);
                } else {
                    zzbk2 = null;
                }
                zzbj[] zzbjArr = new zzbj[1];
                zzahw zzb4 = zzahv.zzb(1836476516);
                zzb4.getClass();
                if (i5 == 1) {
                    z = true;
                } else {
                    z = false;
                }
                zzbjArr[0] = zzaif.zzc(zzb4.zza);
                zzbk zzbk4 = new zzbk(-9223372036854775807L, zzbjArr);
                if (1 != (this.zzb & 1)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                zzbk zzbk5 = zzbk;
                long j3 = -9223372036854775807L;
                List zzd2 = zzaif.zzd(zzahv, zzacy, -9223372036854775807L, (zzy) null, z2, z, new zzaio());
                long j4 = -9223372036854775807L;
                int i6 = 0;
                int i7 = -1;
                int i8 = 0;
                while (true) {
                    j2 = 0;
                    if (i8 >= zzd2.size()) {
                        break;
                    }
                    zzaiz zzaiz = (zzaiz) zzd2.get(i8);
                    if (zzaiz.zzb == 0) {
                        list = zzd2;
                    } else {
                        zzaiw zzaiw = zzaiz.zza;
                        list = zzd2;
                        long j5 = zzaiw.zze;
                        if (j5 == j3) {
                            j5 = zzaiz.zzh;
                        }
                        int i9 = i6 + 1;
                        long max = Math.max(j4, j5);
                        zzaip zzaip = new zzaip(zzaiw, zzaiz, this.zzu.zzw(i6, zzaiw.zzb));
                        if ("audio/true-hd".equals(zzaiw.zzf.zzm)) {
                            i = zzaiz.zze * 16;
                        } else {
                            i = zzaiz.zze + 30;
                        }
                        zzad zzb5 = zzaiw.zzf.zzb();
                        zzb5.zzP(i);
                        if (zzaiw.zzb == 2) {
                            if ((this.zzb & 8) != 0) {
                                zzaf zzaf = zzaiw.zzf;
                                if (i7 == -1) {
                                    i4 = 1;
                                } else {
                                    i4 = 2;
                                }
                                zzb5.zzV(zzaf.zzf | i4);
                            }
                            if (j5 > 0 && (i3 = zzaiz.zzb) > 0) {
                                zzb5.zzH(((float) i3) / (((float) j5) / 1000000.0f));
                            }
                        }
                        if (zzaiw.zzb == 1 && zzacy.zza()) {
                            zzb5.zzF(zzacy.zza);
                            zzb5.zzG(zzacy.zzb);
                        }
                        int i10 = zzaiw.zzb;
                        zzbk[] zzbkArr = new zzbk[3];
                        if (this.zzi.isEmpty()) {
                            i2 = 0;
                            zzbk3 = null;
                        } else {
                            zzbk3 = new zzbk(this.zzi);
                            i2 = 0;
                        }
                        zzbkArr[i2] = zzbk3;
                        zzbkArr[1] = zzbk5;
                        zzbkArr[2] = zzbk4;
                        int i11 = i7;
                        zzbk zzbk6 = new zzbk(-9223372036854775807L, new zzbj[i2]);
                        if (zzbk2 != null) {
                            for (int i12 = 0; i12 < zzbk2.zza(); i12++) {
                                zzbj zzb6 = zzbk2.zzb(i12);
                                if (zzb6 instanceof zzex) {
                                    zzex zzex = (zzex) zzb6;
                                    if (!zzex.zza.equals("com.android.capture.fps")) {
                                        zzbk6 = zzbk6.zzc(zzex);
                                    } else if (i10 == 2) {
                                        zzbk6 = zzbk6.zzc(zzex);
                                    }
                                }
                            }
                        }
                        for (int i13 = 0; i13 < 3; i13++) {
                            zzbk6 = zzbk6.zzd(zzbkArr[i13]);
                        }
                        if (zzbk6.zza() > 0) {
                            zzb5.zzQ(zzbk6);
                        }
                        zzaip.zzc.zzl(zzb5.zzad());
                        int i14 = zzaiw.zzb;
                        int i15 = i11;
                        if (i14 == 2) {
                            if (i15 == -1) {
                                i7 = arrayList.size();
                                arrayList.add(zzaip);
                                i6 = i9;
                                j4 = max;
                            }
                        }
                        i7 = i15;
                        arrayList.add(zzaip);
                        i6 = i9;
                        j4 = max;
                    }
                    i8++;
                    zzd2 = list;
                    j3 = -9223372036854775807L;
                }
                this.zzx = i7;
                this.zzy = j4;
                zzaip[] zzaipArr = (zzaip[]) arrayList.toArray(new zzaip[0]);
                this.zzv = zzaipArr;
                int length = zzaipArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i16 = 0; i16 < zzaipArr.length; i16++) {
                    jArr[i16] = new long[zzaipArr[i16].zzb.zzb];
                    jArr2[i16] = zzaipArr[i16].zzb.zzf[0];
                }
                int i17 = 0;
                while (i17 < zzaipArr.length) {
                    int i18 = -1;
                    long j6 = Long.MAX_VALUE;
                    for (int i19 = 0; i19 < zzaipArr.length; i19++) {
                        if (!zArr[i19]) {
                            long j7 = jArr2[i19];
                            if (j7 <= j6) {
                                i18 = i19;
                                j6 = j7;
                            }
                        }
                    }
                    int i20 = iArr[i18];
                    long[] jArr3 = jArr[i18];
                    jArr3[i20] = j2;
                    zzaiz zzaiz2 = zzaipArr[i18].zzb;
                    j2 += (long) zzaiz2.zzd[i20];
                    int i21 = i20 + 1;
                    iArr[i18] = i21;
                    if (i21 < jArr3.length) {
                        jArr2[i18] = zzaiz2.zzf[i21];
                    } else {
                        zArr[i18] = true;
                        i17++;
                    }
                }
                this.zzw = jArr;
                this.zzu.zzD();
                this.zzu.zzO(this);
                this.zzg.clear();
                this.zzk = 2;
            } else if (!this.zzg.isEmpty()) {
                ((zzahv) this.zzg.peek()).zzc(zzahv);
            }
        }
        if (this.zzk != 2) {
            zzn();
        }
    }

    public final long zza() {
        return this.zzy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:229:0x0095 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r33, com.google.android.gms.internal.ads.zzadf r34) throws java.io.IOException {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            r2 = r34
        L_0x0006:
            int r3 = r0.zzk
            r4 = 1718909296(0x66747970, float:2.8862439E23)
            r7 = 0
            r9 = 2
            r10 = -1
            r11 = 8
            r12 = 1
            if (r3 == 0) goto L_0x0273
            r14 = 262144(0x40000, double:1.295163E-318)
            if (r3 == r12) goto L_0x01e2
            if (r3 == r9) goto L_0x002c
            com.google.android.gms.internal.ads.zzaiu r3 = r0.zzh
            java.util.List r4 = r0.zzi
            r3.zza(r1, r2, r4)
            long r1 = r2.zza
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 != 0) goto L_0x002b
            r32.zzn()
        L_0x002b:
            return r12
        L_0x002c:
            long r3 = r33.zzf()
            int r11 = r0.zzp
            if (r11 != r10) goto L_0x00b3
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r25 = r10
            r26 = r25
            r20 = r12
            r27 = r20
            r18 = r16
            r21 = r18
            r23 = r21
            r11 = 0
        L_0x0048:
            com.google.android.gms.internal.ads.zzaip[] r5 = r0.zzv
            int r6 = r5.length
            if (r11 >= r6) goto L_0x0099
            r5 = r5[r11]
            int r6 = r5.zze
            com.google.android.gms.internal.ads.zzaiz r5 = r5.zzb
            int r9 = r5.zzb
            if (r6 != r9) goto L_0x0058
            goto L_0x0095
        L_0x0058:
            long[] r5 = r5.zzc
            r28 = r5[r6]
            long[][] r5 = r0.zzw
            int r9 = com.google.android.gms.internal.ads.zzet.zza
            r5 = r5[r11]
            r30 = r5[r6]
            long r28 = r28 - r3
            int r5 = (r28 > r7 ? 1 : (r28 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x0071
            int r5 = (r28 > r14 ? 1 : (r28 == r14 ? 0 : -1))
            if (r5 < 0) goto L_0x006f
            goto L_0x0071
        L_0x006f:
            r5 = 0
            goto L_0x0072
        L_0x0071:
            r5 = r12
        L_0x0072:
            if (r5 != 0) goto L_0x0078
            if (r27 != 0) goto L_0x0080
            r6 = 0
            goto L_0x007a
        L_0x0078:
            r6 = r27
        L_0x007a:
            if (r5 != r6) goto L_0x0089
            int r9 = (r28 > r23 ? 1 : (r28 == r23 ? 0 : -1))
            if (r9 >= 0) goto L_0x0089
        L_0x0080:
            r27 = r5
            r26 = r11
            r23 = r28
            r21 = r30
            goto L_0x008b
        L_0x0089:
            r27 = r6
        L_0x008b:
            int r6 = (r30 > r18 ? 1 : (r30 == r18 ? 0 : -1))
            if (r6 >= 0) goto L_0x0095
            r20 = r5
            r25 = r11
            r18 = r30
        L_0x0095:
            int r11 = r11 + 1
            r9 = 2
            goto L_0x0048
        L_0x0099:
            int r5 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r5 == 0) goto L_0x00ab
            if (r20 == 0) goto L_0x00ab
            r5 = 10485760(0xa00000, double:5.180654E-317)
            long r18 = r18 + r5
            int r5 = (r21 > r18 ? 1 : (r21 == r18 ? 0 : -1))
            if (r5 < 0) goto L_0x00ab
            r11 = r25
            goto L_0x00ad
        L_0x00ab:
            r11 = r26
        L_0x00ad:
            r0.zzp = r11
            if (r11 != r10) goto L_0x00b3
            goto L_0x01e1
        L_0x00b3:
            com.google.android.gms.internal.ads.zzaip[] r5 = r0.zzv
            r5 = r5[r11]
            com.google.android.gms.internal.ads.zzadp r6 = r5.zzc
            int r9 = r5.zze
            com.google.android.gms.internal.ads.zzaiz r11 = r5.zzb
            long[] r10 = r11.zzc
            r12 = r10[r9]
            int[] r10 = r11.zzd
            r10 = r10[r9]
            com.google.android.gms.internal.ads.zzadq r11 = r5.zzd
            long r3 = r12 - r3
            int r14 = r0.zzq
            long r14 = (long) r14
            long r3 = r3 + r14
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x01de
            r7 = 262144(0x40000, double:1.295163E-318)
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x00da
            goto L_0x01de
        L_0x00da:
            com.google.android.gms.internal.ads.zzaiw r2 = r5.zza
            int r2 = r2.zzg
            r7 = 1
            if (r2 != r7) goto L_0x00e6
            r7 = 8
            long r3 = r3 + r7
            int r10 = r10 + -8
        L_0x00e6:
            int r2 = (int) r3
            r1.zzk(r2)
            com.google.android.gms.internal.ads.zzaiw r2 = r5.zza
            int r3 = r2.zzj
            if (r3 == 0) goto L_0x0150
            com.google.android.gms.internal.ads.zzek r2 = r0.zzd
            byte[] r2 = r2.zzM()
            r4 = 0
            r2[r4] = r4
            r7 = 1
            r2[r7] = r4
            r7 = 2
            r2[r7] = r4
            int r4 = 4 - r3
        L_0x0101:
            int r7 = r0.zzr
            if (r7 >= r10) goto L_0x0193
            int r7 = r0.zzs
            if (r7 != 0) goto L_0x013b
            r1.zzi(r2, r4, r3)
            int r7 = r0.zzq
            int r7 = r7 + r3
            r0.zzq = r7
            com.google.android.gms.internal.ads.zzek r7 = r0.zzd
            r8 = 0
            r7.zzK(r8)
            com.google.android.gms.internal.ads.zzek r7 = r0.zzd
            int r7 = r7.zzg()
            if (r7 < 0) goto L_0x0133
            r0.zzs = r7
            com.google.android.gms.internal.ads.zzek r7 = r0.zzc
            r7.zzK(r8)
            com.google.android.gms.internal.ads.zzek r7 = r0.zzc
            r12 = 4
            r6.zzq(r7, r12)
            int r7 = r0.zzr
            int r7 = r7 + r12
            r0.zzr = r7
            int r10 = r10 + r4
            goto L_0x0101
        L_0x0133:
            java.lang.String r1 = "Invalid NAL length"
            r2 = 0
            com.google.android.gms.internal.ads.zzbo r1 = com.google.android.gms.internal.ads.zzbo.zza(r1, r2)
            throw r1
        L_0x013b:
            r8 = 0
            int r7 = r6.zzf(r1, r7, r8)
            int r8 = r0.zzq
            int r8 = r8 + r7
            r0.zzq = r8
            int r8 = r0.zzr
            int r8 = r8 + r7
            r0.zzr = r8
            int r8 = r0.zzs
            int r8 = r8 - r7
            r0.zzs = r8
            goto L_0x0101
        L_0x0150:
            com.google.android.gms.internal.ads.zzaf r2 = r2.zzf
            java.lang.String r3 = "audio/ac4"
            java.lang.String r2 = r2.zzm
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0173
            int r2 = r0.zzr
            if (r2 != 0) goto L_0x0170
            com.google.android.gms.internal.ads.zzek r2 = r0.zze
            com.google.android.gms.internal.ads.zzabm.zzb(r10, r2)
            com.google.android.gms.internal.ads.zzek r2 = r0.zze
            r3 = 7
            r6.zzq(r2, r3)
            int r2 = r0.zzr
            int r2 = r2 + r3
            r0.zzr = r2
        L_0x0170:
            int r10 = r10 + 7
            goto L_0x0178
        L_0x0173:
            if (r11 == 0) goto L_0x0178
            r11.zzd(r1)
        L_0x0178:
            int r2 = r0.zzr
            if (r2 >= r10) goto L_0x0193
            int r2 = r10 - r2
            r3 = 0
            int r2 = r6.zzf(r1, r2, r3)
            int r3 = r0.zzq
            int r3 = r3 + r2
            r0.zzq = r3
            int r3 = r0.zzr
            int r3 = r3 + r2
            r0.zzr = r3
            int r3 = r0.zzs
            int r3 = r3 - r2
            r0.zzs = r3
            goto L_0x0178
        L_0x0193:
            com.google.android.gms.internal.ads.zzaiz r1 = r5.zzb
            long[] r2 = r1.zzf
            r3 = r2[r9]
            int[] r1 = r1.zzg
            r1 = r1[r9]
            if (r11 == 0) goto L_0x01bd
            r22 = 0
            r23 = 0
            r16 = r11
            r17 = r6
            r18 = r3
            r20 = r1
            r21 = r10
            r16.zzc(r17, r18, r20, r21, r22, r23)
            r1 = 1
            int r9 = r9 + r1
            com.google.android.gms.internal.ads.zzaiz r1 = r5.zzb
            int r1 = r1.zzb
            if (r9 != r1) goto L_0x01cc
            r1 = 0
            r11.zza(r6, r1)
            goto L_0x01cc
        L_0x01bd:
            r21 = 0
            r22 = 0
            r16 = r6
            r17 = r3
            r19 = r1
            r20 = r10
            r16.zzs(r17, r19, r20, r21, r22)
        L_0x01cc:
            int r1 = r5.zze
            r2 = 1
            int r1 = r1 + r2
            r5.zze = r1
            r1 = -1
            r0.zzp = r1
            r1 = 0
            r0.zzq = r1
            r0.zzr = r1
            r0.zzs = r1
            r10 = 0
            goto L_0x01e1
        L_0x01de:
            r2.zza = r12
            r10 = 1
        L_0x01e1:
            return r10
        L_0x01e2:
            long r5 = r0.zzm
            int r3 = r0.zzn
            long r7 = (long) r3
            long r5 = r5 - r7
            long r7 = r33.zzf()
            long r7 = r7 + r5
            com.google.android.gms.internal.ads.zzek r3 = r0.zzo
            if (r3 == 0) goto L_0x0244
            byte[] r9 = r3.zzM()
            int r10 = r0.zzn
            int r5 = (int) r5
            r1.zzi(r9, r10, r5)
            int r5 = r0.zzl
            if (r5 != r4) goto L_0x0229
            r4 = 1
            r0.zzt = r4
            r3.zzK(r11)
            int r4 = r3.zzg()
            int r4 = zzk(r4)
            if (r4 == 0) goto L_0x0210
            goto L_0x0226
        L_0x0210:
            r4 = 4
            r3.zzL(r4)
        L_0x0214:
            int r4 = r3.zzb()
            if (r4 <= 0) goto L_0x0225
            int r4 = r3.zzg()
            int r4 = zzk(r4)
            if (r4 == 0) goto L_0x0214
            goto L_0x0226
        L_0x0225:
            r4 = 0
        L_0x0226:
            r0.zzz = r4
            goto L_0x025d
        L_0x0229:
            java.util.ArrayDeque r4 = r0.zzg
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x025d
            java.util.ArrayDeque r4 = r0.zzg
            java.lang.Object r4 = r4.peek()
            com.google.android.gms.internal.ads.zzahv r4 = (com.google.android.gms.internal.ads.zzahv) r4
            com.google.android.gms.internal.ads.zzahw r5 = new com.google.android.gms.internal.ads.zzahw
            int r6 = r0.zzl
            r5.<init>(r6, r3)
            r4.zzd(r5)
            goto L_0x025d
        L_0x0244:
            boolean r3 = r0.zzt
            if (r3 != 0) goto L_0x0252
            int r3 = r0.zzl
            r4 = 1835295092(0x6d646174, float:4.4175247E27)
            if (r3 != r4) goto L_0x0252
            r3 = 1
            r0.zzz = r3
        L_0x0252:
            r3 = 262144(0x40000, double:1.295163E-318)
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x025f
            int r3 = (int) r5
            r1.zzk(r3)
        L_0x025d:
            r13 = 0
            goto L_0x0267
        L_0x025f:
            long r3 = r33.zzf()
            long r3 = r3 + r5
            r2.zza = r3
            r13 = 1
        L_0x0267:
            r0.zzo(r7)
            if (r13 == 0) goto L_0x0006
            int r3 = r0.zzk
            r5 = 2
            if (r3 == r5) goto L_0x0006
            r3 = 1
            return r3
        L_0x0273:
            r5 = r9
            r3 = r12
            int r6 = r0.zzn
            if (r6 != 0) goto L_0x02e3
            com.google.android.gms.internal.ads.zzek r6 = r0.zzf
            byte[] r6 = r6.zzM()
            r9 = 0
            boolean r6 = r1.zzn(r6, r9, r11, r3)
            if (r6 != 0) goto L_0x02cb
            int r1 = r0.zzz
            if (r1 != r5) goto L_0x02c9
            int r1 = r0.zzb
            r1 = r1 & r5
            if (r1 == 0) goto L_0x02c9
            com.google.android.gms.internal.ads.zzacn r1 = r0.zzu
            r2 = 4
            com.google.android.gms.internal.ads.zzadp r1 = r1.zzw(r9, r2)
            com.google.android.gms.internal.ads.zzagr r2 = r0.zzA
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 != 0) goto L_0x02a1
            r5 = 0
            goto L_0x02ab
        L_0x02a1:
            com.google.android.gms.internal.ads.zzbk r5 = new com.google.android.gms.internal.ads.zzbk
            r6 = 1
            com.google.android.gms.internal.ads.zzbj[] r6 = new com.google.android.gms.internal.ads.zzbj[r6]
            r6[r9] = r2
            r5.<init>(r3, r6)
        L_0x02ab:
            com.google.android.gms.internal.ads.zzad r2 = new com.google.android.gms.internal.ads.zzad
            r2.<init>()
            r2.zzQ(r5)
            com.google.android.gms.internal.ads.zzaf r2 = r2.zzad()
            r1.zzl(r2)
            com.google.android.gms.internal.ads.zzacn r1 = r0.zzu
            r1.zzD()
            com.google.android.gms.internal.ads.zzacn r1 = r0.zzu
            com.google.android.gms.internal.ads.zzadh r2 = new com.google.android.gms.internal.ads.zzadh
            r2.<init>(r3, r7)
            r1.zzO(r2)
        L_0x02c9:
            r1 = -1
            return r1
        L_0x02cb:
            r0.zzn = r11
            com.google.android.gms.internal.ads.zzek r3 = r0.zzf
            r5 = 0
            r3.zzK(r5)
            com.google.android.gms.internal.ads.zzek r3 = r0.zzf
            long r5 = r3.zzu()
            r0.zzm = r5
            com.google.android.gms.internal.ads.zzek r3 = r0.zzf
            int r3 = r3.zzg()
            r0.zzl = r3
        L_0x02e3:
            long r5 = r0.zzm
            r9 = 1
            int r3 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0302
            com.google.android.gms.internal.ads.zzek r3 = r0.zzf
            byte[] r3 = r3.zzM()
            r1.zzi(r3, r11, r11)
            int r3 = r0.zzn
            int r3 = r3 + r11
            r0.zzn = r3
            com.google.android.gms.internal.ads.zzek r3 = r0.zzf
            long r5 = r3.zzv()
            r0.zzm = r5
            goto L_0x032d
        L_0x0302:
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x032d
            long r5 = r33.zzd()
            r7 = -1
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x031e
            java.util.ArrayDeque r3 = r0.zzg
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzahv r3 = (com.google.android.gms.internal.ads.zzahv) r3
            if (r3 == 0) goto L_0x031d
            long r5 = r3.zza
            goto L_0x031e
        L_0x031d:
            r5 = r7
        L_0x031e:
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x032d
            long r7 = r33.zzf()
            long r5 = r5 - r7
            int r3 = r0.zzn
            long r7 = (long) r3
            long r5 = r5 + r7
            r0.zzm = r5
        L_0x032d:
            long r5 = r0.zzm
            int r3 = r0.zzn
            long r7 = (long) r3
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x046a
            int r5 = r0.zzl
            r6 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r5 == r6) goto L_0x0418
            r6 = 1953653099(0x7472616b, float:7.681346E31)
            if (r5 == r6) goto L_0x0418
            r6 = 1835297121(0x6d646961, float:4.4181236E27)
            if (r5 == r6) goto L_0x0418
            r6 = 1835626086(0x6d696e66, float:4.515217E27)
            if (r5 == r6) goto L_0x0418
            r6 = 1937007212(0x7374626c, float:1.9362132E31)
            if (r5 == r6) goto L_0x0418
            r6 = 1701082227(0x65647473, float:6.742798E22)
            if (r5 == r6) goto L_0x0418
            if (r5 != r7) goto L_0x035d
            goto L_0x0418
        L_0x035d:
            r6 = 1835296868(0x6d646864, float:4.418049E27)
            if (r5 == r6) goto L_0x03e4
            r6 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r5 == r6) goto L_0x03e4
            r6 = 1751411826(0x68646c72, float:4.3148E24)
            if (r5 == r6) goto L_0x03e4
            r6 = 1937011556(0x73747364, float:1.9367383E31)
            if (r5 == r6) goto L_0x03e4
            r6 = 1937011827(0x73747473, float:1.9367711E31)
            if (r5 == r6) goto L_0x03e4
            r6 = 1937011571(0x73747373, float:1.9367401E31)
            if (r5 == r6) goto L_0x03e4
            r6 = 1668576371(0x63747473, float:4.5093966E21)
            if (r5 == r6) goto L_0x03e4
            r6 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r5 == r6) goto L_0x03e4
            r6 = 1937011555(0x73747363, float:1.9367382E31)
            if (r5 == r6) goto L_0x03e4
            r6 = 1937011578(0x7374737a, float:1.936741E31)
            if (r5 == r6) goto L_0x03e4
            r6 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r5 == r6) goto L_0x03e4
            r6 = 1937007471(0x7374636f, float:1.9362445E31)
            if (r5 == r6) goto L_0x03e4
            r6 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r5 == r6) goto L_0x03e4
            r6 = 1953196132(0x746b6864, float:7.46037E31)
            if (r5 == r6) goto L_0x03e4
            if (r5 == r4) goto L_0x03e4
            r4 = 1969517665(0x75647461, float:2.8960062E32)
            if (r5 == r4) goto L_0x03e4
            r4 = 1801812339(0x6b657973, float:2.7741754E26)
            if (r5 == r4) goto L_0x03e4
            r4 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r5 != r4) goto L_0x03b5
            goto L_0x03e4
        L_0x03b5:
            long r3 = r33.zzf()
            int r5 = r0.zzn
            long r5 = (long) r5
            long r10 = r3 - r5
            int r3 = r0.zzl
            r4 = 1836086884(0x6d707664, float:4.6512205E27)
            if (r3 != r4) goto L_0x03dc
            long r14 = r10 + r5
            com.google.android.gms.internal.ads.zzagr r3 = new com.google.android.gms.internal.ads.zzagr
            r8 = 0
            long r12 = r0.zzm
            long r4 = r12 - r5
            r7 = r3
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r16 = r4
            r7.<init>(r8, r10, r12, r14, r16)
            r0.zzA = r3
        L_0x03dc:
            r3 = 0
            r0.zzo = r3
            r3 = 1
            r0.zzk = r3
            goto L_0x0006
        L_0x03e4:
            if (r3 != r11) goto L_0x03e8
            r3 = 1
            goto L_0x03e9
        L_0x03e8:
            r3 = 0
        L_0x03e9:
            com.google.android.gms.internal.ads.zzdi.zzf(r3)
            long r3 = r0.zzm
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x03f7
            r3 = 1
            goto L_0x03f8
        L_0x03f7:
            r3 = 0
        L_0x03f8:
            com.google.android.gms.internal.ads.zzdi.zzf(r3)
            com.google.android.gms.internal.ads.zzek r3 = new com.google.android.gms.internal.ads.zzek
            long r4 = r0.zzm
            int r4 = (int) r4
            r3.<init>((int) r4)
            com.google.android.gms.internal.ads.zzek r4 = r0.zzf
            byte[] r4 = r4.zzM()
            byte[] r5 = r3.zzM()
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r5, r6, r11)
            r0.zzo = r3
            r3 = 1
            r0.zzk = r3
            goto L_0x0006
        L_0x0418:
            long r3 = r33.zzf()
            long r5 = r0.zzm
            long r3 = r3 + r5
            int r8 = r0.zzn
            long r8 = (long) r8
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x044a
            int r5 = r0.zzl
            if (r5 != r7) goto L_0x044a
            com.google.android.gms.internal.ads.zzek r5 = r0.zze
            r5.zzH(r11)
            com.google.android.gms.internal.ads.zzek r5 = r0.zze
            byte[] r5 = r5.zzM()
            r6 = 0
            r1.zzh(r5, r6, r11)
            com.google.android.gms.internal.ads.zzek r5 = r0.zze
            com.google.android.gms.internal.ads.zzaif.zze(r5)
            com.google.android.gms.internal.ads.zzek r5 = r0.zze
            int r5 = r5.zzd()
            r1.zzk(r5)
            r33.zzj()
        L_0x044a:
            long r3 = r3 - r8
            java.util.ArrayDeque r5 = r0.zzg
            com.google.android.gms.internal.ads.zzahv r6 = new com.google.android.gms.internal.ads.zzahv
            int r7 = r0.zzl
            r6.<init>(r7, r3)
            r5.push(r6)
            long r5 = r0.zzm
            int r7 = r0.zzn
            long r7 = (long) r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x0465
            r0.zzo(r3)
            goto L_0x0006
        L_0x0465:
            r32.zzn()
            goto L_0x0006
        L_0x046a:
            java.lang.String r1 = "Atom size less than header length (unsupported)."
            com.google.android.gms.internal.ads.zzbo r1 = com.google.android.gms.internal.ads.zzbo.zzc(r1)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiq.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    public final /* synthetic */ List zzd() {
        return this.zzj;
    }

    public final void zze(zzacn zzacn) {
        if ((this.zzb & 16) == 0) {
            zzacn = new zzakc(zzacn, this.zza);
        }
        this.zzu = zzacn;
    }

    public final zzadg zzg(long j) {
        long j2;
        long j3;
        int zzb2;
        zzaip[] zzaipArr = this.zzv;
        if (zzaipArr.length == 0) {
            zzadj zzadj = zzadj.zza;
            return new zzadg(zzadj, zzadj);
        }
        int i = this.zzx;
        long j4 = -1;
        if (i != -1) {
            zzaiz zzaiz = zzaipArr[i].zzb;
            int zzl2 = zzl(zzaiz, j);
            if (zzl2 == -1) {
                zzadj zzadj2 = zzadj.zza;
                return new zzadg(zzadj2, zzadj2);
            }
            long j5 = zzaiz.zzf[zzl2];
            j2 = zzaiz.zzc[zzl2];
            if (j5 >= j || zzl2 >= zzaiz.zzb - 1 || (zzb2 = zzaiz.zzb(j)) == -1 || zzb2 == zzl2) {
                j3 = -9223372036854775807L;
            } else {
                j3 = zzaiz.zzf[zzb2];
                j4 = zzaiz.zzc[zzb2];
            }
            j = j5;
        } else {
            j2 = Long.MAX_VALUE;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            zzaip[] zzaipArr2 = this.zzv;
            if (i2 >= zzaipArr2.length) {
                break;
            }
            if (i2 != this.zzx) {
                zzaiz zzaiz2 = zzaipArr2[i2].zzb;
                long zzm2 = zzm(zzaiz2, j, j2);
                if (j3 != -9223372036854775807L) {
                    j4 = zzm(zzaiz2, j3, j4);
                }
                j2 = zzm2;
            }
            i2++;
        }
        zzadj zzadj3 = new zzadj(j, j2);
        if (j3 == -9223372036854775807L) {
            return new zzadg(zzadj3, zzadj3);
        }
        return new zzadg(zzadj3, new zzadj(j3, j4));
    }

    public final boolean zzh() {
        return true;
    }

    public final void zzi(long j, long j2) {
        this.zzg.clear();
        this.zzn = 0;
        this.zzp = -1;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        if (j != 0) {
            for (zzaip zzaip : this.zzv) {
                zzaiz zzaiz = zzaip.zzb;
                int zza2 = zzaiz.zza(j2);
                if (zza2 == -1) {
                    zza2 = zzaiz.zzb(j2);
                }
                zzaip.zze = zza2;
                zzadq zzadq = zzaip.zzd;
                if (zzadq != null) {
                    zzadq.zzb();
                }
            }
        } else if (this.zzk != 3) {
            zzn();
        } else {
            this.zzh.zzb();
            this.zzi.clear();
        }
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        boolean z;
        zzfxr zzfxr;
        if ((this.zzb & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        zzadm zzb2 = zzaiv.zzb(zzacl, z);
        if (zzb2 != null) {
            zzfxr = zzfxr.zzn(zzb2);
        } else {
            zzfxr = zzfxr.zzm();
        }
        this.zzj = zzfxr;
        if (zzb2 == null) {
            return true;
        }
        return false;
    }

    public zzaiq(zzajy zzajy, int i) {
        this.zza = zzajy;
        this.zzb = i;
        this.zzj = zzfxr.zzm();
        this.zzk = (i & 4) != 0 ? 3 : 0;
        this.zzh = new zzaiu();
        this.zzi = new ArrayList();
        this.zzf = new zzek(16);
        this.zzg = new ArrayDeque();
        this.zzc = new zzek(zzfh.zza);
        this.zzd = new zzek(4);
        this.zze = new zzek();
        this.zzp = -1;
        this.zzu = zzacn.zza;
        this.zzv = new zzaip[0];
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
