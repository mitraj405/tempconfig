package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzail implements zzack {
    private static final byte[] zza = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzaf zzb;
    private zzaik zzA;
    private int zzB;
    private int zzC;
    private int zzD;
    private boolean zzE;
    private zzacn zzF;
    private zzadp[] zzG;
    private zzadp[] zzH;
    private boolean zzI;
    private final zzajy zzc;
    private final int zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzek zzg;
    private final zzek zzh;
    private final zzek zzi;
    private final byte[] zzj;
    private final zzek zzk;
    private final zzafh zzl;
    private final zzek zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private zzfxr zzp;
    private int zzq;
    private int zzr;
    private long zzs;
    private int zzt;
    private zzek zzu;
    private long zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        zzad zzad = new zzad();
        zzad.zzX("application/x-emsg");
        zzb = zzad.zzad();
    }

    @Deprecated
    public zzail() {
        this(zzajy.zza, 32, (zzer) null, (zzaiw) null, zzfxr.zzm(), (zzadp) null);
    }

    private static int zza(int i) throws zzbo {
        if (i >= 0) {
            return i;
        }
        throw zzbo.zza("Unexpected negative value: " + i, (Throwable) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzy zzg(java.util.List r17) {
        /*
            int r0 = r17.size()
            r1 = 0
            r2 = 0
            r3 = r1
        L_0x0007:
            if (r3 >= r0) goto L_0x0108
            r4 = r17
            java.lang.Object r5 = r4.get(r3)
            com.google.android.gms.internal.ads.zzahw r5 = (com.google.android.gms.internal.ads.zzahw) r5
            int r6 = r5.zzd
            r7 = 1886614376(0x70737368, float:3.013775E29)
            if (r6 != r7) goto L_0x0102
            if (r2 != 0) goto L_0x001f
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x001f:
            com.google.android.gms.internal.ads.zzek r5 = r5.zza
            byte[] r5 = r5.zzM()
            com.google.android.gms.internal.ads.zzek r6 = new com.google.android.gms.internal.ads.zzek
            r6.<init>((byte[]) r5)
            int r8 = r6.zze()
            r9 = 32
            if (r8 >= r9) goto L_0x0033
            goto L_0x0078
        L_0x0033:
            r6.zzK(r1)
            int r8 = r6.zzb()
            int r9 = r6.zzg()
            java.lang.String r10 = "PsshAtomUtil"
            if (r9 == r8) goto L_0x005c
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Advertised atom size ("
            r6.<init>(r7)
            r6.append(r9)
            java.lang.String r7 = ") does not match buffer size: "
            r6.append(r7)
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            com.google.android.gms.internal.ads.zzea.zzf(r10, r6)
            goto L_0x0078
        L_0x005c:
            int r8 = r6.zzg()
            if (r8 == r7) goto L_0x0068
            java.lang.String r6 = "Atom type is not pssh: "
            defpackage.C0709Uj.t(r6, r8, r10)
            goto L_0x0078
        L_0x0068:
            int r7 = r6.zzg()
            int r7 = com.google.android.gms.internal.ads.zzahx.zze(r7)
            r8 = 1
            if (r7 <= r8) goto L_0x007b
            java.lang.String r6 = "Unsupported pssh version: "
            defpackage.C0709Uj.t(r6, r7, r10)
        L_0x0078:
            r16 = r2
            goto L_0x00d3
        L_0x007b:
            java.util.UUID r9 = new java.util.UUID
            long r11 = r6.zzt()
            long r13 = r6.zzt()
            r9.<init>(r11, r13)
            if (r7 != r8) goto L_0x00ad
            int r8 = r6.zzp()
            java.util.UUID[] r11 = new java.util.UUID[r8]
            r12 = r1
        L_0x0091:
            if (r12 >= r8) goto L_0x00aa
            java.util.UUID r13 = new java.util.UUID
            long r14 = r6.zzt()
            r16 = r2
            long r1 = r6.zzt()
            r13.<init>(r14, r1)
            r11[r12] = r13
            int r12 = r12 + 1
            r2 = r16
            r1 = 0
            goto L_0x0091
        L_0x00aa:
            r16 = r2
            goto L_0x00b0
        L_0x00ad:
            r16 = r2
            r11 = 0
        L_0x00b0:
            int r1 = r6.zzp()
            int r2 = r6.zzb()
            if (r1 == r2) goto L_0x00d6
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Atom data size ("
            r6.<init>(r7)
            r6.append(r1)
            java.lang.String r1 = ") does not match the bytes left: "
            r6.append(r1)
            r6.append(r2)
            java.lang.String r1 = r6.toString()
            com.google.android.gms.internal.ads.zzea.zzf(r10, r1)
        L_0x00d3:
            r1 = 0
            r8 = 0
            goto L_0x00e1
        L_0x00d6:
            byte[] r2 = new byte[r1]
            r8 = 0
            r6.zzG(r2, r8, r1)
            com.google.android.gms.internal.ads.zzais r1 = new com.google.android.gms.internal.ads.zzais
            r1.<init>(r9, r7, r2, r11)
        L_0x00e1:
            if (r1 != 0) goto L_0x00e5
            r1 = 0
            goto L_0x00e7
        L_0x00e5:
            java.util.UUID r1 = r1.zza
        L_0x00e7:
            if (r1 != 0) goto L_0x00f3
            java.lang.String r1 = "FragmentedMp4Extractor"
            java.lang.String r2 = "Skipped pssh atom (failed to extract uuid)"
            com.google.android.gms.internal.ads.zzea.zzf(r1, r2)
            r2 = r16
            goto L_0x0103
        L_0x00f3:
            com.google.android.gms.internal.ads.zzx r2 = new com.google.android.gms.internal.ads.zzx
            java.lang.String r6 = "video/mp4"
            r7 = 0
            r2.<init>(r1, r7, r6, r5)
            r1 = r16
            r1.add(r2)
            r2 = r1
            goto L_0x0103
        L_0x0102:
            r8 = r1
        L_0x0103:
            int r3 = r3 + 1
            r1 = r8
            goto L_0x0007
        L_0x0108:
            r0 = 0
            if (r2 != 0) goto L_0x010c
            return r0
        L_0x010c:
            com.google.android.gms.internal.ads.zzy r0 = new com.google.android.gms.internal.ads.zzy
            r0.<init>((java.util.List) r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzail.zzg(java.util.List):com.google.android.gms.internal.ads.zzy");
    }

    private final void zzh() {
        this.zzq = 0;
        this.zzt = 0;
    }

    private static void zzk(zzek zzek, int i, zzaiy zzaiy) throws zzbo {
        boolean z;
        zzek.zzK(i + 8);
        int zzg2 = zzek.zzg() & 16777215;
        if ((zzg2 & 1) == 0) {
            if ((zzg2 & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            int zzp2 = zzek.zzp();
            if (zzp2 == 0) {
                Arrays.fill(zzaiy.zzl, 0, zzaiy.zze, false);
                return;
            }
            int i2 = zzaiy.zze;
            if (zzp2 == i2) {
                Arrays.fill(zzaiy.zzl, 0, zzp2, z);
                zzaiy.zza(zzek.zzb());
                zzek zzek2 = zzaiy.zzn;
                zzek.zzG(zzek2.zzM(), 0, zzek2.zze());
                zzaiy.zzn.zzK(0);
                zzaiy.zzo = false;
                return;
            }
            throw zzbo.zza("Senc sample count " + zzp2 + " is different from fragment sample count" + i2, (Throwable) null);
        }
        throw zzbo.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x032b, code lost:
        if (com.google.android.gms.internal.ads.zzet.zzt(r34 + r1[0], 1000000, r5.zzd, java.math.RoundingMode.FLOOR) < r5.zze) goto L_0x033f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzl(long r51) throws com.google.android.gms.internal.ads.zzbo {
        /*
            r50 = this;
            r0 = r50
        L_0x0002:
            java.util.ArrayDeque r1 = r0.zzn
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0723
            java.util.ArrayDeque r1 = r0.zzn
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzahv r1 = (com.google.android.gms.internal.ads.zzahv) r1
            long r1 = r1.zza
            int r1 = (r1 > r51 ? 1 : (r1 == r51 ? 0 : -1))
            if (r1 != 0) goto L_0x0723
            java.util.ArrayDeque r1 = r0.zzn
            java.lang.Object r1 = r1.pop()
            r2 = r1
            com.google.android.gms.internal.ads.zzahv r2 = (com.google.android.gms.internal.ads.zzahv) r2
            int r1 = r2.zzd
            r3 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r6 = 12
            r8 = 8
            if (r1 != r3) goto L_0x0146
            java.util.List r1 = r2.zzb
            com.google.android.gms.internal.ads.zzy r1 = zzg(r1)
            r3 = 1836475768(0x6d766578, float:4.7659988E27)
            com.google.android.gms.internal.ads.zzahv r3 = r2.zza(r3)
            r3.getClass()
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            java.util.List r9 = r3.zzb
            int r9 = r9.size()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r13 = 0
        L_0x004d:
            if (r13 >= r9) goto L_0x00b8
            java.util.List r14 = r3.zzb
            java.lang.Object r14 = r14.get(r13)
            com.google.android.gms.internal.ads.zzahw r14 = (com.google.android.gms.internal.ads.zzahw) r14
            int r15 = r14.zzd
            r11 = 1953654136(0x74726578, float:7.6818474E31)
            if (r15 != r11) goto L_0x0096
            com.google.android.gms.internal.ads.zzek r11 = r14.zza
            r11.zzK(r6)
            int r14 = r11.zzg()
            int r15 = r11.zzg()
            int r15 = r15 + -1
            int r6 = r11.zzg()
            int r10 = r11.zzg()
            int r11 = r11.zzg()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            com.google.android.gms.internal.ads.zzaih r7 = new com.google.android.gms.internal.ads.zzaih
            r7.<init>(r15, r6, r10, r11)
            android.util.Pair r6 = android.util.Pair.create(r14, r7)
            java.lang.Object r7 = r6.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r6 = r6.second
            com.google.android.gms.internal.ads.zzaih r6 = (com.google.android.gms.internal.ads.zzaih) r6
            r12.put(r7, r6)
            goto L_0x00b3
        L_0x0096:
            r6 = 1835362404(0x6d656864, float:4.4373917E27)
            if (r15 != r6) goto L_0x00b3
            com.google.android.gms.internal.ads.zzek r4 = r14.zza
            r4.zzK(r8)
            int r5 = r4.zzg()
            int r5 = com.google.android.gms.internal.ads.zzahx.zze(r5)
            if (r5 != 0) goto L_0x00af
            long r4 = r4.zzu()
            goto L_0x00b3
        L_0x00af:
            long r4 = r4.zzv()
        L_0x00b3:
            int r13 = r13 + 1
            r6 = 12
            goto L_0x004d
        L_0x00b8:
            com.google.android.gms.internal.ads.zzacy r3 = new com.google.android.gms.internal.ads.zzacy
            r3.<init>()
            int r6 = r0.zzd
            r7 = 16
            r6 = r6 & r7
            if (r6 == 0) goto L_0x00c6
            r7 = 1
            goto L_0x00c7
        L_0x00c6:
            r7 = 0
        L_0x00c7:
            r8 = 0
            com.google.android.gms.internal.ads.zzaii r9 = new com.google.android.gms.internal.ads.zzaii
            r9.<init>(r0)
            r6 = r1
            java.util.List r1 = com.google.android.gms.internal.ads.zzaif.zzd(r2, r3, r4, r6, r7, r8, r9)
            int r2 = r1.size()
            android.util.SparseArray r3 = r0.zzf
            int r3 = r3.size()
            if (r3 != 0) goto L_0x0117
            r11 = 0
        L_0x00df:
            if (r11 >= r2) goto L_0x0110
            java.lang.Object r3 = r1.get(r11)
            com.google.android.gms.internal.ads.zzaiz r3 = (com.google.android.gms.internal.ads.zzaiz) r3
            com.google.android.gms.internal.ads.zzaiw r4 = r3.zza
            com.google.android.gms.internal.ads.zzaik r5 = new com.google.android.gms.internal.ads.zzaik
            com.google.android.gms.internal.ads.zzacn r6 = r0.zzF
            int r7 = r4.zzb
            com.google.android.gms.internal.ads.zzadp r6 = r6.zzw(r11, r7)
            int r7 = r4.zza
            com.google.android.gms.internal.ads.zzaih r7 = zzm(r12, r7)
            r5.<init>(r6, r3, r7)
            android.util.SparseArray r3 = r0.zzf
            int r6 = r4.zza
            r3.put(r6, r5)
            long r5 = r0.zzy
            long r3 = r4.zze
            long r3 = java.lang.Math.max(r5, r3)
            r0.zzy = r3
            int r11 = r11 + 1
            goto L_0x00df
        L_0x0110:
            com.google.android.gms.internal.ads.zzacn r1 = r0.zzF
            r1.zzD()
            goto L_0x0002
        L_0x0117:
            android.util.SparseArray r3 = r0.zzf
            int r3 = r3.size()
            if (r3 != r2) goto L_0x0121
            r10 = 1
            goto L_0x0122
        L_0x0121:
            r10 = 0
        L_0x0122:
            com.google.android.gms.internal.ads.zzdi.zzf(r10)
            r11 = 0
        L_0x0126:
            if (r11 >= r2) goto L_0x0002
            java.lang.Object r3 = r1.get(r11)
            com.google.android.gms.internal.ads.zzaiz r3 = (com.google.android.gms.internal.ads.zzaiz) r3
            com.google.android.gms.internal.ads.zzaiw r4 = r3.zza
            android.util.SparseArray r5 = r0.zzf
            int r6 = r4.zza
            java.lang.Object r5 = r5.get(r6)
            com.google.android.gms.internal.ads.zzaik r5 = (com.google.android.gms.internal.ads.zzaik) r5
            int r4 = r4.zza
            com.google.android.gms.internal.ads.zzaih r4 = zzm(r12, r4)
            r5.zzh(r3, r4)
            int r11 = r11 + 1
            goto L_0x0126
        L_0x0146:
            r3 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r1 != r3) goto L_0x070b
            android.util.SparseArray r1 = r0.zzf
            int r3 = r0.zzd
            byte[] r6 = r0.zzj
            java.util.List r7 = r2.zzc
            int r7 = r7.size()
            r9 = 0
        L_0x0158:
            if (r9 >= r7) goto L_0x0676
            java.util.List r11 = r2.zzc
            java.lang.Object r11 = r11.get(r9)
            com.google.android.gms.internal.ads.zzahv r11 = (com.google.android.gms.internal.ads.zzahv) r11
            int r12 = r11.zzd
            r13 = 1953653094(0x74726166, float:7.6813435E31)
            if (r12 != r13) goto L_0x0654
            r12 = 1952868452(0x74666864, float:7.301914E31)
            com.google.android.gms.internal.ads.zzahw r12 = r11.zzb(r12)
            r12.getClass()
            com.google.android.gms.internal.ads.zzek r12 = r12.zza
            r12.zzK(r8)
            int r13 = r12.zzg()
            r14 = 16777215(0xffffff, float:2.3509886E-38)
            r13 = r13 & r14
            int r15 = r12.zzg()
            java.lang.Object r15 = r1.get(r15)
            com.google.android.gms.internal.ads.zzaik r15 = (com.google.android.gms.internal.ads.zzaik) r15
            if (r15 != 0) goto L_0x018e
            r15 = 0
            goto L_0x01d7
        L_0x018e:
            r17 = r13 & 1
            if (r17 == 0) goto L_0x019c
            long r4 = r12.zzv()
            com.google.android.gms.internal.ads.zzaiy r10 = r15.zzb
            r10.zzb = r4
            r10.zzc = r4
        L_0x019c:
            com.google.android.gms.internal.ads.zzaih r4 = r15.zze
            r5 = r13 & 2
            if (r5 == 0) goto L_0x01a9
            int r5 = r12.zzg()
            int r5 = r5 + -1
            goto L_0x01ab
        L_0x01a9:
            int r5 = r4.zza
        L_0x01ab:
            r10 = r13 & 8
            if (r10 == 0) goto L_0x01b4
            int r10 = r12.zzg()
            goto L_0x01b6
        L_0x01b4:
            int r10 = r4.zzb
        L_0x01b6:
            r18 = r13 & 16
            if (r18 == 0) goto L_0x01c1
            int r18 = r12.zzg()
            r14 = r18
            goto L_0x01c3
        L_0x01c1:
            int r14 = r4.zzc
        L_0x01c3:
            r13 = r13 & 32
            if (r13 == 0) goto L_0x01cc
            int r4 = r12.zzg()
            goto L_0x01ce
        L_0x01cc:
            int r4 = r4.zzd
        L_0x01ce:
            com.google.android.gms.internal.ads.zzaiy r12 = r15.zzb
            com.google.android.gms.internal.ads.zzaih r13 = new com.google.android.gms.internal.ads.zzaih
            r13.<init>(r5, r10, r14, r4)
            r12.zza = r13
        L_0x01d7:
            if (r15 != 0) goto L_0x01db
            goto L_0x0654
        L_0x01db:
            com.google.android.gms.internal.ads.zzaiy r4 = r15.zzb
            long r12 = r4.zzp
            boolean r5 = r4.zzq
            r15.zzi()
            r10 = 1
            r15.zzl = true
            r14 = 1952867444(0x74666474, float:7.3014264E31)
            com.google.android.gms.internal.ads.zzahw r14 = r11.zzb(r14)
            if (r14 == 0) goto L_0x0212
            r16 = r3 & 2
            if (r16 != 0) goto L_0x0212
            com.google.android.gms.internal.ads.zzek r5 = r14.zza
            r5.zzK(r8)
            int r12 = r5.zzg()
            int r12 = com.google.android.gms.internal.ads.zzahx.zze(r12)
            if (r12 != r10) goto L_0x0209
            long r12 = r5.zzv()
            goto L_0x020d
        L_0x0209:
            long r12 = r5.zzu()
        L_0x020d:
            r4.zzp = r12
            r4.zzq = r10
            goto L_0x0216
        L_0x0212:
            r4.zzp = r12
            r4.zzq = r5
        L_0x0216:
            java.util.List r5 = r11.zzb
            int r10 = r5.size()
            r12 = 0
            r13 = 0
            r14 = 0
        L_0x021f:
            r8 = 1953658222(0x7472756e, float:7.683823E31)
            if (r12 >= r10) goto L_0x024b
            java.lang.Object r19 = r5.get(r12)
            r20 = r1
            r1 = r19
            com.google.android.gms.internal.ads.zzahw r1 = (com.google.android.gms.internal.ads.zzahw) r1
            r19 = r7
            int r7 = r1.zzd
            if (r7 != r8) goto L_0x0244
            com.google.android.gms.internal.ads.zzek r1 = r1.zza
            r7 = 12
            r1.zzK(r7)
            int r1 = r1.zzp()
            if (r1 <= 0) goto L_0x0244
            int r14 = r14 + r1
            int r13 = r13 + 1
        L_0x0244:
            int r12 = r12 + 1
            r7 = r19
            r1 = r20
            goto L_0x021f
        L_0x024b:
            r20 = r1
            r19 = r7
            r1 = 0
            r15.zzh = r1
            r15.zzg = r1
            r15.zzf = r1
            com.google.android.gms.internal.ads.zzaiy r1 = r15.zzb
            r1.zzd = r13
            r1.zze = r14
            int[] r7 = r1.zzg
            int r7 = r7.length
            if (r7 >= r13) goto L_0x0269
            long[] r7 = new long[r13]
            r1.zzf = r7
            int[] r7 = new int[r13]
            r1.zzg = r7
        L_0x0269:
            int[] r7 = r1.zzh
            int r7 = r7.length
            if (r7 >= r14) goto L_0x0282
            int r14 = r14 * 125
            int r14 = r14 / 100
            int[] r7 = new int[r14]
            r1.zzh = r7
            long[] r7 = new long[r14]
            r1.zzi = r7
            boolean[] r7 = new boolean[r14]
            r1.zzj = r7
            boolean[] r7 = new boolean[r14]
            r1.zzl = r7
        L_0x0282:
            r1 = 0
            r7 = 0
            r12 = 0
        L_0x0285:
            r21 = 0
            if (r1 >= r10) goto L_0x0433
            java.lang.Object r14 = r5.get(r1)
            com.google.android.gms.internal.ads.zzahw r14 = (com.google.android.gms.internal.ads.zzahw) r14
            int r13 = r14.zzd
            if (r13 != r8) goto L_0x0403
            int r13 = r7 + 1
            com.google.android.gms.internal.ads.zzek r14 = r14.zza
            r8 = 8
            r14.zzK(r8)
            int r8 = r14.zzg()
            r18 = 16777215(0xffffff, float:2.3509886E-38)
            r8 = r8 & r18
            r24 = r5
            com.google.android.gms.internal.ads.zzaiz r5 = r15.zzd
            com.google.android.gms.internal.ads.zzaiw r5 = r5.zza
            r25 = r10
            com.google.android.gms.internal.ads.zzaiy r10 = r15.zzb
            r26 = r13
            com.google.android.gms.internal.ads.zzaih r13 = r10.zza
            int r27 = com.google.android.gms.internal.ads.zzet.zza
            int[] r0 = r10.zzg
            int r27 = r14.zzp()
            r0[r7] = r27
            long[] r0 = r10.zzf
            r28 = r1
            r27 = r2
            long r1 = r10.zzb
            r0[r7] = r1
            r29 = r8 & 1
            if (r29 == 0) goto L_0x02da
            r29 = r9
            int r9 = r14.zzg()
            r30 = r11
            r31 = r12
            long r11 = (long) r9
            long r1 = r1 + r11
            r0[r7] = r1
            goto L_0x02e0
        L_0x02da:
            r29 = r9
            r30 = r11
            r31 = r12
        L_0x02e0:
            r0 = r8 & 4
            if (r0 == 0) goto L_0x02e6
            r0 = 1
            goto L_0x02e7
        L_0x02e6:
            r0 = 0
        L_0x02e7:
            int r1 = r13.zzd
            if (r0 == 0) goto L_0x02ef
            int r1 = r14.zzg()
        L_0x02ef:
            r2 = r8 & 256(0x100, float:3.59E-43)
            r9 = r8 & 512(0x200, float:7.175E-43)
            r11 = r8 & 1024(0x400, float:1.435E-42)
            r8 = r8 & 2048(0x800, float:2.87E-42)
            long[] r12 = r5.zzh
            if (r12 == 0) goto L_0x0338
            r32 = r1
            int r1 = r12.length
            r33 = r6
            r6 = 1
            if (r1 != r6) goto L_0x0334
            long[] r1 = r5.zzi
            if (r1 != 0) goto L_0x0308
            goto L_0x0334
        L_0x0308:
            r6 = 0
            r34 = r12[r6]
            int r12 = (r34 > r21 ? 1 : (r34 == r21 ? 0 : -1))
            if (r12 != 0) goto L_0x0313
            r6 = r0
            r34 = r11
            goto L_0x032e
        L_0x0313:
            r36 = r1[r6]
            long r38 = r34 + r36
            r40 = 1000000(0xf4240, double:4.940656E-318)
            r6 = r0
            long r0 = r5.zzd
            java.math.RoundingMode r44 = java.math.RoundingMode.FLOOR
            r42 = r0
            long r0 = com.google.android.gms.internal.ads.zzet.zzt(r38, r40, r42, r44)
            r34 = r11
            long r11 = r5.zze
            int r0 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r0 >= 0) goto L_0x032e
            goto L_0x033f
        L_0x032e:
            long[] r0 = r5.zzi
            r1 = 0
            r21 = r0[r1]
            goto L_0x033f
        L_0x0334:
            r6 = r0
            r34 = r11
            goto L_0x033f
        L_0x0338:
            r32 = r1
            r33 = r6
            r34 = r11
            r6 = r0
        L_0x033f:
            int[] r0 = r10.zzh
            long[] r1 = r10.zzi
            boolean[] r11 = r10.zzj
            int r12 = r5.zzb
            r35 = r4
            r4 = 2
            if (r12 != r4) goto L_0x0352
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0352
            r4 = 1
            goto L_0x0353
        L_0x0352:
            r4 = 0
        L_0x0353:
            int[] r12 = r10.zzg
            r7 = r12[r7]
            int r12 = r31 + r7
            r43 = r3
            r23 = r4
            long r3 = r5.zzc
            r5 = r0
            r44 = r1
            long r0 = r10.zzp
            r7 = r31
        L_0x0366:
            if (r7 >= r12) goto L_0x03fc
            if (r2 == 0) goto L_0x0373
            int r31 = r14.zzg()
            r45 = r2
            r2 = r31
            goto L_0x0377
        L_0x0373:
            r45 = r2
            int r2 = r13.zzb
        L_0x0377:
            zza(r2)
            if (r9 == 0) goto L_0x0383
            int r31 = r14.zzg()
            r46 = r9
            goto L_0x0389
        L_0x0383:
            r46 = r9
            int r9 = r13.zzc
            r31 = r9
        L_0x0389:
            zza(r31)
            if (r34 == 0) goto L_0x0393
            int r9 = r14.zzg()
            goto L_0x039e
        L_0x0393:
            if (r7 != 0) goto L_0x039c
            if (r6 == 0) goto L_0x039b
            r9 = r32
            r7 = 0
            goto L_0x039e
        L_0x039b:
            r7 = 0
        L_0x039c:
            int r9 = r13.zzd
        L_0x039e:
            if (r8 == 0) goto L_0x03ad
            int r36 = r14.zzg()
            r47 = r6
            r49 = r12
            r48 = r13
            r6 = r36
            goto L_0x03b4
        L_0x03ad:
            r47 = r6
            r49 = r12
            r48 = r13
            r6 = 0
        L_0x03b4:
            long r12 = (long) r6
            long r12 = r12 + r0
            long r36 = r12 - r21
            r38 = 1000000(0xf4240, double:4.940656E-318)
            java.math.RoundingMode r42 = java.math.RoundingMode.FLOOR
            r40 = r3
            long r12 = com.google.android.gms.internal.ads.zzet.zzt(r36, r38, r40, r42)
            r44[r7] = r12
            boolean r6 = r10.zzq
            if (r6 != 0) goto L_0x03d3
            com.google.android.gms.internal.ads.zzaiz r6 = r15.zzd
            r36 = r3
            long r3 = r6.zzh
            long r12 = r12 + r3
            r44[r7] = r12
            goto L_0x03d5
        L_0x03d3:
            r36 = r3
        L_0x03d5:
            r5[r7] = r31
            r3 = 16
            int r4 = r9 >> 16
            r3 = 1
            r4 = r4 & r3
            if (r4 != 0) goto L_0x03e8
            if (r23 == 0) goto L_0x03e6
            if (r7 != 0) goto L_0x03e8
            r4 = r3
            r7 = 0
            goto L_0x03e9
        L_0x03e6:
            r4 = r3
            goto L_0x03e9
        L_0x03e8:
            r4 = 0
        L_0x03e9:
            r11[r7] = r4
            long r12 = (long) r2
            long r0 = r0 + r12
            int r7 = r7 + r3
            r3 = r36
            r2 = r45
            r9 = r46
            r6 = r47
            r13 = r48
            r12 = r49
            goto L_0x0366
        L_0x03fc:
            r49 = r12
            r10.zzp = r0
            r7 = r26
            goto L_0x041a
        L_0x0403:
            r28 = r1
            r27 = r2
            r43 = r3
            r35 = r4
            r24 = r5
            r33 = r6
            r29 = r9
            r25 = r10
            r30 = r11
            r31 = r12
            r18 = 16777215(0xffffff, float:2.3509886E-38)
        L_0x041a:
            int r1 = r28 + 1
            r0 = r50
            r5 = r24
            r10 = r25
            r2 = r27
            r9 = r29
            r11 = r30
            r6 = r33
            r4 = r35
            r3 = r43
            r8 = 1953658222(0x7472756e, float:7.683823E31)
            goto L_0x0285
        L_0x0433:
            r27 = r2
            r43 = r3
            r35 = r4
            r33 = r6
            r29 = r9
            r30 = r11
            com.google.android.gms.internal.ads.zzaiz r0 = r15.zzd
            com.google.android.gms.internal.ads.zzaiw r0 = r0.zza
            r1 = r35
            com.google.android.gms.internal.ads.zzaih r2 = r1.zza
            r2.getClass()
            int r2 = r2.zza
            com.google.android.gms.internal.ads.zzaix r0 = r0.zza(r2)
            r2 = 1935763834(0x7361697a, float:1.785898E31)
            r11 = r30
            com.google.android.gms.internal.ads.zzahw r2 = r11.zzb(r2)
            if (r2 == 0) goto L_0x04cd
            r0.getClass()
            com.google.android.gms.internal.ads.zzek r2 = r2.zza
            r3 = 8
            r2.zzK(r3)
            int r4 = r2.zzg()
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0470
            r2.zzL(r3)
        L_0x0470:
            int r3 = r2.zzm()
            int r4 = r2.zzp()
            int r5 = r1.zze
            if (r4 > r5) goto L_0x04b1
            int r5 = r0.zzd
            if (r3 != 0) goto L_0x0497
            boolean[] r3 = r1.zzl
            r6 = 0
            r7 = 0
        L_0x0484:
            if (r6 >= r4) goto L_0x0495
            int r8 = r2.zzm()
            int r7 = r7 + r8
            if (r8 <= r5) goto L_0x048f
            r8 = 1
            goto L_0x0490
        L_0x048f:
            r8 = 0
        L_0x0490:
            r3[r6] = r8
            int r6 = r6 + 1
            goto L_0x0484
        L_0x0495:
            r5 = 0
            goto L_0x04a4
        L_0x0497:
            if (r3 <= r5) goto L_0x049b
            r2 = 1
            goto L_0x049c
        L_0x049b:
            r2 = 0
        L_0x049c:
            int r7 = r3 * r4
            boolean[] r3 = r1.zzl
            r5 = 0
            java.util.Arrays.fill(r3, r5, r4, r2)
        L_0x04a4:
            boolean[] r2 = r1.zzl
            int r3 = r1.zze
            java.util.Arrays.fill(r2, r4, r3, r5)
            if (r7 <= 0) goto L_0x04cd
            r1.zza(r7)
            goto L_0x04cd
        L_0x04b1:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Saiz sample count "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r1 = " is greater than fragment sample count"
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r1)
            throw r0
        L_0x04cd:
            r2 = 1935763823(0x7361696f, float:1.7858967E31)
            com.google.android.gms.internal.ads.zzahw r2 = r11.zzb(r2)
            if (r2 == 0) goto L_0x0518
            com.google.android.gms.internal.ads.zzek r2 = r2.zza
            r3 = 8
            r2.zzK(r3)
            int r4 = r2.zzg()
            r5 = r4 & 1
            r6 = 1
            if (r5 != r6) goto L_0x04e9
            r2.zzL(r3)
        L_0x04e9:
            int r3 = r2.zzp()
            if (r3 != r6) goto L_0x0504
            int r3 = com.google.android.gms.internal.ads.zzahx.zze(r4)
            long r4 = r1.zzc
            if (r3 != 0) goto L_0x04fc
            long r2 = r2.zzu()
            goto L_0x0500
        L_0x04fc:
            long r2 = r2.zzv()
        L_0x0500:
            long r4 = r4 + r2
            r1.zzc = r4
            goto L_0x0518
        L_0x0504:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unexpected saio entry count: "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r2)
            throw r0
        L_0x0518:
            r2 = 0
            r3 = 1936027235(0x73656e63, float:1.8177412E31)
            com.google.android.gms.internal.ads.zzahw r3 = r11.zzb(r3)
            if (r3 == 0) goto L_0x0528
            com.google.android.gms.internal.ads.zzek r3 = r3.zza
            r4 = 0
            zzk(r3, r4, r1)
        L_0x0528:
            if (r0 == 0) goto L_0x052e
            java.lang.String r0 = r0.zzb
            r5 = r0
            goto L_0x052f
        L_0x052e:
            r5 = r2
        L_0x052f:
            r0 = r2
            r3 = r0
            r4 = 0
        L_0x0532:
            java.util.List r6 = r11.zzb
            int r6 = r6.size()
            if (r4 >= r6) goto L_0x056f
            java.util.List r6 = r11.zzb
            java.lang.Object r6 = r6.get(r4)
            com.google.android.gms.internal.ads.zzahw r6 = (com.google.android.gms.internal.ads.zzahw) r6
            com.google.android.gms.internal.ads.zzek r7 = r6.zza
            int r6 = r6.zzd
            r8 = 1935828848(0x73626770, float:1.7937577E31)
            r9 = 1936025959(0x73656967, float:1.817587E31)
            if (r6 != r8) goto L_0x055b
            r12 = 12
            r7.zzK(r12)
            int r6 = r7.zzg()
            if (r6 != r9) goto L_0x056c
            r0 = r7
            goto L_0x056c
        L_0x055b:
            r12 = 12
            r8 = 1936158820(0x73677064, float:1.8336489E31)
            if (r6 != r8) goto L_0x056c
            r7.zzK(r12)
            int r6 = r7.zzg()
            if (r6 != r9) goto L_0x056c
            r3 = r7
        L_0x056c:
            int r4 = r4 + 1
            goto L_0x0532
        L_0x056f:
            r12 = 12
            if (r0 == 0) goto L_0x060c
            if (r3 != 0) goto L_0x0577
            goto L_0x060c
        L_0x0577:
            r4 = 8
            r0.zzK(r4)
            int r6 = r0.zzg()
            int r6 = com.google.android.gms.internal.ads.zzahx.zze(r6)
            r7 = 4
            r0.zzL(r7)
            r8 = 1
            if (r6 != r8) goto L_0x058e
            r0.zzL(r7)
        L_0x058e:
            int r0 = r0.zzg()
            if (r0 != r8) goto L_0x0605
            r3.zzK(r4)
            int r0 = r3.zzg()
            int r0 = com.google.android.gms.internal.ads.zzahx.zze(r0)
            r3.zzL(r7)
            if (r0 != r8) goto L_0x05b4
            long r8 = r3.zzu()
            int r0 = (r8 > r21 ? 1 : (r8 == r21 ? 0 : -1))
            if (r0 == 0) goto L_0x05ad
            goto L_0x05ba
        L_0x05ad:
            java.lang.String r0 = "Variable length description in sgpd found (unsupported)"
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zzc(r0)
            throw r0
        L_0x05b4:
            r4 = 2
            if (r0 < r4) goto L_0x05ba
            r3.zzL(r7)
        L_0x05ba:
            long r8 = r3.zzu()
            r13 = 1
            int r0 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x05fe
            r0 = 1
            r3.zzL(r0)
            int r4 = r3.zzm()
            r6 = r4 & 240(0xf0, float:3.36E-43)
            int r8 = r6 >> 4
            r9 = r4 & 15
            int r4 = r3.zzm()
            if (r4 != r0) goto L_0x060d
            int r6 = r3.zzm()
            r4 = 16
            byte[] r7 = new byte[r4]
            r10 = 0
            r3.zzG(r7, r10, r4)
            if (r6 != 0) goto L_0x05f1
            int r2 = r3.zzm()
            byte[] r4 = new byte[r2]
            r3.zzG(r4, r10, r2)
            r10 = r4
            goto L_0x05f2
        L_0x05f1:
            r10 = r2
        L_0x05f2:
            r1.zzk = r0
            com.google.android.gms.internal.ads.zzaix r2 = new com.google.android.gms.internal.ads.zzaix
            r4 = 1
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r1.zzm = r2
            goto L_0x060d
        L_0x05fe:
            java.lang.String r0 = "Entry count in sgpd != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zzc(r0)
            throw r0
        L_0x0605:
            java.lang.String r0 = "Entry count in sbgp != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zzc(r0)
            throw r0
        L_0x060c:
            r0 = 1
        L_0x060d:
            java.util.List r2 = r11.zzb
            int r2 = r2.size()
            r3 = 0
        L_0x0614:
            if (r3 >= r2) goto L_0x064c
            java.util.List r4 = r11.zzb
            java.lang.Object r4 = r4.get(r3)
            com.google.android.gms.internal.ads.zzahw r4 = (com.google.android.gms.internal.ads.zzahw) r4
            int r5 = r4.zzd
            r6 = 1970628964(0x75756964, float:3.1109627E32)
            if (r5 != r6) goto L_0x0640
            com.google.android.gms.internal.ads.zzek r4 = r4.zza
            r5 = 8
            r4.zzK(r5)
            r7 = r33
            r6 = 0
            r8 = 16
            r4.zzG(r7, r6, r8)
            byte[] r9 = zza
            boolean r9 = java.util.Arrays.equals(r7, r9)
            if (r9 == 0) goto L_0x0647
            zzk(r4, r8, r1)
            goto L_0x0647
        L_0x0640:
            r7 = r33
            r5 = 8
            r6 = 0
            r8 = 16
        L_0x0647:
            int r3 = r3 + 1
            r33 = r7
            goto L_0x0614
        L_0x064c:
            r7 = r33
            r5 = 8
            r6 = 0
            r8 = 16
            goto L_0x0666
        L_0x0654:
            r20 = r1
            r27 = r2
            r43 = r3
            r19 = r7
            r5 = r8
            r29 = r9
            r0 = 1
            r8 = 16
            r12 = 12
            r7 = r6
            r6 = 0
        L_0x0666:
            int r9 = r29 + 1
            r0 = r50
            r8 = r5
            r6 = r7
            r7 = r19
            r1 = r20
            r2 = r27
            r3 = r43
            goto L_0x0158
        L_0x0676:
            r1 = r2
            r2 = 0
            r6 = 0
            java.util.List r0 = r1.zzb
            com.google.android.gms.internal.ads.zzy r0 = zzg(r0)
            r3 = r50
            if (r0 == 0) goto L_0x06c7
            android.util.SparseArray r1 = r3.zzf
            int r1 = r1.size()
            r4 = r6
        L_0x068a:
            if (r4 >= r1) goto L_0x06c7
            android.util.SparseArray r5 = r3.zzf
            java.lang.Object r5 = r5.valueAt(r4)
            com.google.android.gms.internal.ads.zzaik r5 = (com.google.android.gms.internal.ads.zzaik) r5
            com.google.android.gms.internal.ads.zzaiz r7 = r5.zzd
            com.google.android.gms.internal.ads.zzaiw r7 = r7.zza
            com.google.android.gms.internal.ads.zzaiy r8 = r5.zzb
            com.google.android.gms.internal.ads.zzaih r8 = r8.zza
            int r9 = com.google.android.gms.internal.ads.zzet.zza
            int r8 = r8.zza
            com.google.android.gms.internal.ads.zzaix r7 = r7.zza(r8)
            if (r7 == 0) goto L_0x06a9
            java.lang.String r7 = r7.zzb
            goto L_0x06aa
        L_0x06a9:
            r7 = r2
        L_0x06aa:
            com.google.android.gms.internal.ads.zzy r7 = r0.zzb(r7)
            com.google.android.gms.internal.ads.zzaiz r8 = r5.zzd
            com.google.android.gms.internal.ads.zzaiw r8 = r8.zza
            com.google.android.gms.internal.ads.zzaf r8 = r8.zzf
            com.google.android.gms.internal.ads.zzad r8 = r8.zzb()
            r8.zzE(r7)
            com.google.android.gms.internal.ads.zzaf r7 = r8.zzad()
            com.google.android.gms.internal.ads.zzadp r5 = r5.zza
            r5.zzl(r7)
            int r4 = r4 + 1
            goto L_0x068a
        L_0x06c7:
            long r0 = r3.zzx
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x0720
            android.util.SparseArray r0 = r3.zzf
            int r0 = r0.size()
            r11 = r6
        L_0x06d9:
            if (r11 >= r0) goto L_0x0703
            android.util.SparseArray r1 = r3.zzf
            java.lang.Object r1 = r1.valueAt(r11)
            com.google.android.gms.internal.ads.zzaik r1 = (com.google.android.gms.internal.ads.zzaik) r1
            long r4 = r3.zzx
            int r2 = r1.zzf
        L_0x06e7:
            com.google.android.gms.internal.ads.zzaiy r6 = r1.zzb
            int r7 = r6.zze
            if (r2 >= r7) goto L_0x0700
            long[] r7 = r6.zzi
            r8 = r7[r2]
            int r7 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r7 > 0) goto L_0x0700
            boolean[] r6 = r6.zzj
            boolean r6 = r6[r2]
            if (r6 == 0) goto L_0x06fd
            r1.zzi = r2
        L_0x06fd:
            int r2 = r2 + 1
            goto L_0x06e7
        L_0x0700:
            int r11 = r11 + 1
            goto L_0x06d9
        L_0x0703:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3.zzx = r1
            goto L_0x0720
        L_0x070b:
            r3 = r0
            r1 = r2
            java.util.ArrayDeque r0 = r3.zzn
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0720
            java.util.ArrayDeque r0 = r3.zzn
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzahv r0 = (com.google.android.gms.internal.ads.zzahv) r0
            r0.zzc(r1)
        L_0x0720:
            r0 = r3
            goto L_0x0002
        L_0x0723:
            r3 = r0
            r50.zzh()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzail.zzl(long):void");
    }

    private static final zzaih zzm(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzaih) sparseArray.valueAt(0);
        }
        zzaih zzaih = (zzaih) sparseArray.get(i);
        zzaih.getClass();
        return zzaih;
    }

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        boolean z;
        boolean z2;
        long j;
        long j2;
        String str;
        String str2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        int i;
        zzaik zzaik;
        zzado zzado;
        int i2;
        boolean z3;
        int i3;
        zzacl zzacl2 = zzacl;
        while (true) {
            int i4 = this.zzq;
            z = true;
            z2 = false;
            if (i4 == 0) {
                if (this.zzt == 0) {
                    if (!zzacl2.zzn(this.zzm.zzM(), 0, 8, true)) {
                        return -1;
                    }
                    this.zzt = 8;
                    this.zzm.zzK(0);
                    this.zzs = this.zzm.zzu();
                    this.zzr = this.zzm.zzg();
                }
                long j8 = this.zzs;
                if (j8 == 1) {
                    ((zzaby) zzacl2).zzn(this.zzm.zzM(), 8, 8, false);
                    this.zzt += 8;
                    this.zzs = this.zzm.zzv();
                } else if (j8 == 0) {
                    long zzd2 = zzacl.zzd();
                    if (zzd2 == -1) {
                        if (!this.zzn.isEmpty()) {
                            zzd2 = ((zzahv) this.zzn.peek()).zza;
                        } else {
                            zzd2 = -1;
                        }
                    }
                    if (zzd2 != -1) {
                        this.zzs = (zzd2 - zzacl.zzf()) + ((long) this.zzt);
                    }
                }
                long j9 = this.zzs;
                long j10 = (long) this.zzt;
                if (j9 >= j10) {
                    long zzf2 = zzacl.zzf() - j10;
                    int i5 = this.zzr;
                    if ((i5 == 1836019558 || i5 == 1835295092) && !this.zzI) {
                        this.zzF.zzO(new zzadh(this.zzy, zzf2));
                        this.zzI = true;
                    }
                    if (this.zzr == 1836019558) {
                        int size = this.zzf.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            zzaiy zzaiy = ((zzaik) this.zzf.valueAt(i6)).zzb;
                            zzaiy.zzc = zzf2;
                            zzaiy.zzb = zzf2;
                        }
                    }
                    int i7 = this.zzr;
                    if (i7 == 1835295092) {
                        this.zzA = null;
                        this.zzv = zzf2 + this.zzs;
                        this.zzq = 2;
                    } else if (i7 == 1836019574 || i7 == 1953653099 || i7 == 1835297121 || i7 == 1835626086 || i7 == 1937007212 || i7 == 1836019558 || i7 == 1953653094 || i7 == 1836475768 || i7 == 1701082227) {
                        long zzf3 = (zzacl.zzf() + this.zzs) - 8;
                        this.zzn.push(new zzahv(i7, zzf3));
                        if (this.zzs == ((long) this.zzt)) {
                            zzl(zzf3);
                        } else {
                            zzh();
                        }
                    } else if (i7 == 1751411826 || i7 == 1835296868 || i7 == 1836476516 || i7 == 1936286840 || i7 == 1937011556 || i7 == 1937011827 || i7 == 1668576371 || i7 == 1937011555 || i7 == 1937011578 || i7 == 1937013298 || i7 == 1937007471 || i7 == 1668232756 || i7 == 1937011571 || i7 == 1952867444 || i7 == 1952868452 || i7 == 1953196132 || i7 == 1953654136 || i7 == 1953658222 || i7 == 1886614376 || i7 == 1935763834 || i7 == 1935763823 || i7 == 1936027235 || i7 == 1970628964 || i7 == 1935828848 || i7 == 1936158820 || i7 == 1701606260 || i7 == 1835362404 || i7 == 1701671783) {
                        if (this.zzt != 8) {
                            throw zzbo.zzc("Leaf atom defines extended atom size (unsupported).");
                        } else if (this.zzs <= 2147483647L) {
                            zzek zzek = new zzek((int) this.zzs);
                            System.arraycopy(this.zzm.zzM(), 0, zzek.zzM(), 0, 8);
                            this.zzu = zzek;
                            this.zzq = 1;
                        } else {
                            throw zzbo.zzc("Leaf atom with length > 2147483647 (unsupported).");
                        }
                    } else if (this.zzs <= 2147483647L) {
                        this.zzu = null;
                        this.zzq = 1;
                    } else {
                        throw zzbo.zzc("Skipping atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw zzbo.zzc("Atom size less than header length (unsupported).");
                }
            } else if (i4 != 1) {
                i = 3;
                if (i4 != 2) {
                    zzaik = this.zzA;
                    if (zzaik != null) {
                        break;
                    }
                    SparseArray sparseArray = this.zzf;
                    int size2 = sparseArray.size();
                    long j11 = Long.MAX_VALUE;
                    zzaik zzaik2 = null;
                    for (int i8 = 0; i8 < size2; i8++) {
                        zzaik zzaik3 = (zzaik) sparseArray.valueAt(i8);
                        if ((zzaik3.zzl || zzaik3.zzf != zzaik3.zzd.zzb) && (!zzaik3.zzl || zzaik3.zzh != zzaik3.zzb.zzd)) {
                            long zzd3 = zzaik3.zzd();
                            if (zzd3 < j11) {
                                zzaik2 = zzaik3;
                                j11 = zzd3;
                            }
                        }
                    }
                    if (zzaik2 == null) {
                        int zzf4 = (int) (this.zzv - zzacl.zzf());
                        if (zzf4 >= 0) {
                            ((zzaby) zzacl2).zzo(zzf4, false);
                            zzh();
                        } else {
                            throw zzbo.zza("Offset to end of mdat was negative.", (Throwable) null);
                        }
                    } else {
                        int zzd4 = (int) (zzaik2.zzd() - zzacl.zzf());
                        if (zzd4 < 0) {
                            zzea.zzf("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            zzd4 = 0;
                        }
                        ((zzaby) zzacl2).zzo(zzd4, false);
                        this.zzA = zzaik2;
                        zzaik = zzaik2;
                    }
                } else {
                    int size3 = this.zzf.size();
                    long j12 = Long.MAX_VALUE;
                    zzaik zzaik4 = null;
                    for (int i9 = 0; i9 < size3; i9++) {
                        zzaiy zzaiy2 = ((zzaik) this.zzf.valueAt(i9)).zzb;
                        if (zzaiy2.zzo) {
                            long j13 = zzaiy2.zzc;
                            if (j13 < j12) {
                                zzaik4 = (zzaik) this.zzf.valueAt(i9);
                                j12 = j13;
                            }
                        }
                    }
                    if (zzaik4 == null) {
                        this.zzq = 3;
                    } else {
                        int zzf5 = (int) (j12 - zzacl.zzf());
                        if (zzf5 >= 0) {
                            zzaby zzaby = (zzaby) zzacl2;
                            zzaby.zzo(zzf5, false);
                            zzaiy zzaiy3 = zzaik4.zzb;
                            zzek zzek2 = zzaiy3.zzn;
                            zzaby.zzn(zzek2.zzM(), 0, zzek2.zze(), false);
                            zzaiy3.zzn.zzK(0);
                            zzaiy3.zzo = false;
                        } else {
                            throw zzbo.zza("Offset to encryption data was negative.", (Throwable) null);
                        }
                    }
                }
            } else {
                int i10 = ((int) this.zzs) - this.zzt;
                zzek zzek3 = this.zzu;
                if (zzek3 != null) {
                    ((zzaby) zzacl2).zzn(zzek3.zzM(), 8, i10, false);
                    zzahw zzahw = new zzahw(this.zzr, zzek3);
                    long zzf6 = zzacl.zzf();
                    if (!this.zzn.isEmpty()) {
                        ((zzahv) this.zzn.peek()).zzd(zzahw);
                    } else {
                        int i11 = zzahw.zzd;
                        if (i11 == 1936286840) {
                            zzek zzek4 = zzahw.zza;
                            zzek4.zzK(8);
                            int zze2 = zzahx.zze(zzek4.zzg());
                            zzek4.zzL(4);
                            long zzu2 = zzek4.zzu();
                            if (zze2 == 0) {
                                j7 = zzek4.zzu();
                                j6 = zzek4.zzu();
                            } else {
                                j7 = zzek4.zzv();
                                j6 = zzek4.zzv();
                            }
                            long j14 = zzf6 + j6;
                            long zzt2 = zzet.zzt(j7, 1000000, zzu2, RoundingMode.FLOOR);
                            zzek4.zzL(2);
                            int zzq2 = zzek4.zzq();
                            int[] iArr = new int[zzq2];
                            long[] jArr = new long[zzq2];
                            long[] jArr2 = new long[zzq2];
                            long[] jArr3 = new long[zzq2];
                            int i12 = 0;
                            long j15 = zzt2;
                            while (i12 < zzq2) {
                                int zzg2 = zzek4.zzg();
                                if ((zzg2 & Integer.MIN_VALUE) == 0) {
                                    long zzu3 = zzek4.zzu();
                                    iArr[i12] = zzg2 & Integer.MAX_VALUE;
                                    jArr[i12] = j14;
                                    jArr3[i12] = j15;
                                    long j16 = j7 + zzu3;
                                    int i13 = i12;
                                    long j17 = j16;
                                    long j18 = j16;
                                    long[] jArr4 = jArr2;
                                    long[] jArr5 = jArr3;
                                    long zzt3 = zzet.zzt(j17, 1000000, zzu2, RoundingMode.FLOOR);
                                    jArr4[i13] = zzt3 - jArr5[i13];
                                    zzek4.zzL(4);
                                    int[] iArr2 = iArr;
                                    j14 += (long) iArr2[i13];
                                    iArr = iArr2;
                                    zzq2 = zzq2;
                                    jArr = jArr;
                                    jArr2 = jArr4;
                                    j15 = zzt3;
                                    i12 = i13 + 1;
                                    jArr3 = jArr5;
                                    j7 = j18;
                                } else {
                                    throw zzbo.zza("Unhandled indirect reference", (Throwable) null);
                                }
                            }
                            Pair create = Pair.create(Long.valueOf(zzt2), new zzabw(iArr, jArr, jArr2, jArr3));
                            this.zzz = ((Long) create.first).longValue();
                            this.zzF.zzO((zzadi) create.second);
                            this.zzI = true;
                        } else if (i11 == 1701671783) {
                            zzek zzek5 = zzahw.zza;
                            if (this.zzG.length != 0) {
                                zzek5.zzK(8);
                                int zze3 = zzahx.zze(zzek5.zzg());
                                if (zze3 == 0) {
                                    String zzx2 = zzek5.zzx(0);
                                    zzx2.getClass();
                                    String zzx3 = zzek5.zzx(0);
                                    zzx3.getClass();
                                    long zzu4 = zzek5.zzu();
                                    j4 = zzet.zzt(zzek5.zzu(), 1000000, zzu4, RoundingMode.FLOOR);
                                    long j19 = this.zzz;
                                    if (j19 != -9223372036854775807L) {
                                        j5 = j19 + j4;
                                    } else {
                                        j5 = -9223372036854775807L;
                                    }
                                    str = zzx3;
                                    j2 = zzet.zzt(zzek5.zzu(), 1000, zzu4, RoundingMode.FLOOR);
                                    str2 = zzx2;
                                    j = zzek5.zzu();
                                    j3 = j5;
                                } else if (zze3 != 1) {
                                    C0709Uj.t("Skipping unsupported emsg version: ", zze3, "FragmentedMp4Extractor");
                                } else {
                                    long zzu5 = zzek5.zzu();
                                    long zzt4 = zzet.zzt(zzek5.zzv(), 1000000, zzu5, RoundingMode.FLOOR);
                                    long zzt5 = zzet.zzt(zzek5.zzu(), 1000, zzu5, RoundingMode.FLOOR);
                                    long zzu6 = zzek5.zzu();
                                    String zzx4 = zzek5.zzx(0);
                                    zzx4.getClass();
                                    String zzx5 = zzek5.zzx(0);
                                    zzx5.getClass();
                                    str = zzx5;
                                    j2 = zzt5;
                                    j3 = zzt4;
                                    j = zzu6;
                                    str2 = zzx4;
                                    j4 = -9223372036854775807L;
                                }
                                byte[] bArr = new byte[zzek5.zzb()];
                                zzek5.zzG(bArr, 0, zzek5.zzb());
                                zzek zzek6 = new zzek(this.zzl.zza(new zzafg(str2, str, j2, j, bArr)));
                                int zzb2 = zzek6.zzb();
                                for (zzadp zzq3 : this.zzG) {
                                    zzek6.zzK(0);
                                    zzq3.zzq(zzek6, zzb2);
                                }
                                if (j3 == -9223372036854775807L) {
                                    this.zzo.addLast(new zzaij(j4, true, zzb2));
                                    this.zzw += zzb2;
                                } else if (!this.zzo.isEmpty()) {
                                    this.zzo.addLast(new zzaij(j3, false, zzb2));
                                    this.zzw += zzb2;
                                } else {
                                    for (zzadp zzs2 : this.zzG) {
                                        zzs2.zzs(j3, 1, zzb2, 0, (zzado) null);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    ((zzaby) zzacl2).zzo(i10, false);
                }
                zzl(zzacl.zzf());
            }
        }
        byte b = 6;
        if (this.zzq == 3) {
            int zzb3 = zzaik.zzb();
            this.zzB = zzb3;
            if (zzaik.zzf < zzaik.zzi) {
                ((zzaby) zzacl2).zzo(zzb3, false);
                zzaix zzf7 = zzaik.zzf();
                if (zzf7 != null) {
                    zzek zzek7 = zzaik.zzb.zzn;
                    int i14 = zzf7.zzd;
                    if (i14 != 0) {
                        zzek7.zzL(i14);
                    }
                    if (zzaik.zzb.zzb(zzaik.zzf)) {
                        zzek7.zzL(zzek7.zzq() * 6);
                    }
                }
                if (!zzaik.zzk()) {
                    this.zzA = null;
                }
                this.zzq = i;
                return 0;
            }
            if (zzaik.zzd.zza.zzg == 1) {
                this.zzB = zzb3 - 8;
                ((zzaby) zzacl2).zzo(8, false);
            }
            if ("audio/ac4".equals(zzaik.zzd.zza.zzf.zzm)) {
                this.zzC = zzaik.zzc(this.zzB, 7);
                zzabm.zzb(this.zzB, this.zzk);
                zzaik.zza.zzq(this.zzk, 7);
                i3 = this.zzC + 7;
                this.zzC = i3;
            } else {
                i3 = zzaik.zzc(this.zzB, 0);
                this.zzC = i3;
            }
            this.zzB += i3;
            this.zzq = 4;
            this.zzD = 0;
        }
        zzaiw zzaiw = zzaik.zzd.zza;
        zzadp zzadp = zzaik.zza;
        long zze4 = zzaik.zze();
        int i15 = zzaiw.zzj;
        if (i15 == 0) {
            while (true) {
                int i16 = this.zzC;
                int i17 = this.zzB;
                if (i16 >= i17) {
                    break;
                }
                this.zzC += zzadp.zzf(zzacl2, i17 - i16, false);
            }
        } else {
            byte[] zzM = this.zzh.zzM();
            zzM[0] = 0;
            zzM[1] = 0;
            zzM[2] = 0;
            int i18 = i15 + 1;
            int i19 = 4 - i15;
            while (this.zzC < this.zzB) {
                int i20 = this.zzD;
                if (i20 == 0) {
                    ((zzaby) zzacl2).zzn(zzM, i19, i18, z2);
                    this.zzh.zzK(z2 ? 1 : 0);
                    int zzg3 = this.zzh.zzg();
                    if (zzg3 > 0) {
                        this.zzD = zzg3 - 1;
                        this.zzg.zzK(z2);
                        zzadp.zzq(this.zzg, 4);
                        zzadp.zzq(this.zzh, z ? 1 : 0);
                        if (this.zzH.length > 0) {
                            String str3 = zzaiw.zzf.zzm;
                            byte b2 = zzM[4];
                            byte[] bArr2 = zzfh.zza;
                            if (("video/avc".equals(str3) && (b2 & Ascii.US) == b) || ("video/hevc".equals(str3) && ((b2 & true ? 1 : 0) >> z) == 39)) {
                                z3 = z;
                                this.zzE = z3;
                                this.zzC += 5;
                                this.zzB += i19;
                            }
                        }
                        z3 = false;
                        this.zzE = z3;
                        this.zzC += 5;
                        this.zzB += i19;
                    } else {
                        throw zzbo.zza("Invalid NAL length", (Throwable) null);
                    }
                } else {
                    if (this.zzE) {
                        this.zzi.zzH(i20);
                        ((zzaby) zzacl2).zzn(this.zzi.zzM(), 0, this.zzD, false);
                        zzadp.zzq(this.zzi, this.zzD);
                        i2 = this.zzD;
                        zzek zzek8 = this.zzi;
                        int zzb4 = zzfh.zzb(zzek8.zzM(), zzek8.zze());
                        this.zzi.zzK("video/hevc".equals(zzaiw.zzf.zzm) ? 1 : 0);
                        this.zzi.zzJ(zzb4);
                        zzabv.zza(zze4, this.zzi, this.zzH);
                    } else {
                        i2 = zzadp.zzf(zzacl2, i20, false);
                    }
                    this.zzC += i2;
                    this.zzD -= i2;
                    b = 6;
                    z = true;
                }
                z2 = false;
            }
        }
        int zza2 = zzaik.zza();
        zzaix zzf8 = zzaik.zzf();
        if (zzf8 != null) {
            zzado = zzf8.zzc;
        } else {
            zzado = null;
        }
        long j20 = zze4;
        zzadp.zzs(zze4, zza2, this.zzB, 0, zzado);
        while (!this.zzo.isEmpty()) {
            zzaij zzaij = (zzaij) this.zzo.removeFirst();
            this.zzw -= zzaij.zzc;
            long j21 = zzaij.zza;
            if (zzaij.zzb) {
                j21 += j20;
            }
            for (zzadp zzs3 : this.zzG) {
                zzs3.zzs(j21, 1, zzaij.zzc, this.zzw, (zzado) null);
            }
        }
        if (!zzaik.zzk()) {
            this.zzA = null;
        }
        i = 3;
        this.zzq = i;
        return 0;
    }

    public final /* synthetic */ List zzd() {
        return this.zzp;
    }

    public final void zze(zzacn zzacn) {
        int i;
        if ((this.zzd & 32) == 0) {
            zzacn = new zzakc(zzacn, this.zzc);
        }
        this.zzF = zzacn;
        zzh();
        zzadp[] zzadpArr = new zzadp[2];
        this.zzG = zzadpArr;
        int i2 = 100;
        int i3 = 0;
        if ((this.zzd & 4) != 0) {
            zzadpArr[0] = this.zzF.zzw(100, 5);
            i = 1;
            i2 = 101;
        } else {
            i = 0;
        }
        zzadp[] zzadpArr2 = (zzadp[]) zzet.zzP(this.zzG, i);
        this.zzG = zzadpArr2;
        for (zzadp zzl2 : zzadpArr2) {
            zzl2.zzl(zzb);
        }
        this.zzH = new zzadp[this.zze.size()];
        while (i3 < this.zzH.length) {
            zzadp zzw2 = this.zzF.zzw(i2, 3);
            zzw2.zzl((zzaf) this.zze.get(i3));
            this.zzH[i3] = zzw2;
            i3++;
            i2++;
        }
    }

    public final void zzi(long j, long j2) {
        int size = this.zzf.size();
        for (int i = 0; i < size; i++) {
            ((zzaik) this.zzf.valueAt(i)).zzi();
        }
        this.zzo.clear();
        this.zzw = 0;
        this.zzx = j2;
        this.zzn.clear();
        zzh();
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        zzfxr zzfxr;
        zzadm zza2 = zzaiv.zza(zzacl);
        if (zza2 != null) {
            zzfxr = zzfxr.zzn(zza2);
        } else {
            zzfxr = zzfxr.zzm();
        }
        this.zzp = zzfxr;
        if (zza2 == null) {
            return true;
        }
        return false;
    }

    public zzail(zzajy zzajy, int i, zzer zzer, zzaiw zzaiw, List list, zzadp zzadp) {
        this.zzc = zzajy;
        this.zzd = i;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzafh();
        this.zzm = new zzek(16);
        this.zzg = new zzek(zzfh.zza);
        this.zzh = new zzek(5);
        this.zzi = new zzek();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzek(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzp = zzfxr.zzm();
        this.zzy = -9223372036854775807L;
        this.zzx = -9223372036854775807L;
        this.zzz = -9223372036854775807L;
        this.zzF = zzacn.zza;
        this.zzG = new zzadp[0];
        this.zzH = new zzadp[0];
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
