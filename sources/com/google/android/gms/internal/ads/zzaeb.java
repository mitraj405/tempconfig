package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaeb implements zzack {
    private final zzek zza;
    private final zzaea zzb;
    private final boolean zzc;
    private final zzajy zzd;
    private int zze;
    private zzacn zzf;
    private zzaec zzg;
    private long zzh;
    /* access modifiers changed from: private */
    public zzaee[] zzi;
    private long zzj;
    private zzaee zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;

    @Deprecated
    public zzaeb() {
        this(1, zzajy.zza);
    }

    private final zzaee zzg(int i) {
        for (zzaee zzaee : this.zzi) {
            if (zzaee.zzg(i)) {
                return zzaee;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0033 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r28, com.google.android.gms.internal.ads.zzadf r29) throws java.io.IOException {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            long r2 = r0.zzj
            r4 = -1
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L_0x002e
            long r9 = r28.zzf()
            int r6 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r6 < 0) goto L_0x0028
            r11 = 262144(0x40000, double:1.295163E-318)
            long r11 = r11 + r9
            int r6 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r6 <= 0) goto L_0x001f
            goto L_0x0028
        L_0x001f:
            long r2 = r2 - r9
            r6 = r1
            com.google.android.gms.internal.ads.zzaby r6 = (com.google.android.gms.internal.ads.zzaby) r6
            int r2 = (int) r2
            r6.zzo(r2, r8)
            goto L_0x002e
        L_0x0028:
            r6 = r29
            r6.zza = r2
            r2 = r7
            goto L_0x002f
        L_0x002e:
            r2 = r8
        L_0x002f:
            r0.zzj = r4
            if (r2 == 0) goto L_0x0034
            return r7
        L_0x0034:
            int r2 = r0.zze
            r3 = 12
            r6 = 0
            if (r2 == 0) goto L_0x03a8
            r9 = 1819436136(0x6c726468, float:1.1721368E27)
            r10 = 1414744396(0x5453494c, float:3.62987127E12)
            r11 = 2
            if (r2 == r7) goto L_0x034f
            r12 = 3
            if (r2 == r11) goto L_0x022b
            r9 = 6
            r11 = 1769369453(0x69766f6d, float:1.8620122E25)
            r13 = 4
            r16 = 8
            r14 = 16
            if (r2 == r12) goto L_0x0196
            r4 = 5
            r5 = 8
            if (r2 == r13) goto L_0x0168
            if (r2 == r4) goto L_0x00e6
            long r12 = r28.zzf()
            long r14 = r0.zzn
            int r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r2 < 0) goto L_0x0066
            r8 = -1
            goto L_0x00e5
        L_0x0066:
            com.google.android.gms.internal.ads.zzaee r2 = r0.zzk
            if (r2 == 0) goto L_0x0075
            boolean r1 = r2.zzh(r1)
            if (r1 != 0) goto L_0x0072
            goto L_0x00e5
        L_0x0072:
            r0.zzk = r6
            return r8
        L_0x0075:
            long r12 = r28.zzf()
            r14 = 1
            long r12 = r12 & r14
            int r2 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x0086
            r2 = r1
            com.google.android.gms.internal.ads.zzaby r2 = (com.google.android.gms.internal.ads.zzaby) r2
            r2.zzo(r7, r8)
        L_0x0086:
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            r4 = r1
            com.google.android.gms.internal.ads.zzaby r4 = (com.google.android.gms.internal.ads.zzaby) r4
            r4.zzm(r2, r8, r3, r8)
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            r2.zzK(r8)
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            int r2 = r2.zzi()
            if (r2 != r10) goto L_0x00b5
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            r2.zzK(r5)
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            int r2 = r2.zzi()
            if (r2 != r11) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r3 = r5
        L_0x00ae:
            r4.zzo(r3, r8)
            r28.zzj()
            goto L_0x00e5
        L_0x00b5:
            com.google.android.gms.internal.ads.zzek r3 = r0.zza
            int r3 = r3.zzi()
            r6 = 1263424842(0x4b4e554a, float:1.352225E7)
            if (r2 != r6) goto L_0x00cb
            long r2 = (long) r3
            long r4 = r28.zzf()
            long r4 = r4 + r2
            long r4 = r4 + r16
            r0.zzj = r4
            goto L_0x00e5
        L_0x00cb:
            r4.zzo(r5, r8)
            r28.zzj()
            com.google.android.gms.internal.ads.zzaee r2 = r0.zzg(r2)
            if (r2 != 0) goto L_0x00e0
            long r2 = (long) r3
            long r4 = r28.zzf()
            long r4 = r4 + r2
            r0.zzj = r4
            goto L_0x00e5
        L_0x00e0:
            r2.zze(r3)
            r0.zzk = r2
        L_0x00e5:
            return r8
        L_0x00e6:
            com.google.android.gms.internal.ads.zzek r2 = new com.google.android.gms.internal.ads.zzek
            int r3 = r0.zzo
            r2.<init>((int) r3)
            byte[] r3 = r2.zzM()
            int r4 = r0.zzo
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r1.zzn(r3, r8, r4, r8)
            int r1 = r2.zzb()
            if (r1 >= r14) goto L_0x0101
            r18 = 0
            goto L_0x011d
        L_0x0101:
            int r1 = r2.zzd()
            r2.zzL(r5)
            int r3 = r2.zzi()
            long r3 = (long) r3
            long r5 = r0.zzm
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0116
            r18 = 0
            goto L_0x011a
        L_0x0116:
            long r5 = r5 + r16
            r18 = r5
        L_0x011a:
            r2.zzK(r1)
        L_0x011d:
            int r1 = r2.zzb()
            if (r1 < r14) goto L_0x0145
            int r1 = r2.zzi()
            int r3 = r2.zzi()
            int r4 = r2.zzi()
            long r4 = (long) r4
            long r4 = r4 + r18
            r2.zzi()
            com.google.android.gms.internal.ads.zzaee r1 = r0.zzg(r1)
            if (r1 == 0) goto L_0x011d
            r3 = r3 & r14
            if (r3 != r14) goto L_0x0141
            r1.zzb(r4)
        L_0x0141:
            r1.zzd()
            goto L_0x011d
        L_0x0145:
            com.google.android.gms.internal.ads.zzaee[] r1 = r0.zzi
            int r2 = r1.length
            r3 = r8
        L_0x0149:
            if (r3 >= r2) goto L_0x0153
            r4 = r1[r3]
            r4.zzc()
            int r3 = r3 + 1
            goto L_0x0149
        L_0x0153:
            r0.zzp = r7
            com.google.android.gms.internal.ads.zzacn r1 = r0.zzf
            com.google.android.gms.internal.ads.zzady r2 = new com.google.android.gms.internal.ads.zzady
            long r3 = r0.zzh
            r2.<init>(r0, r3)
            r1.zzO(r2)
            r0.zze = r9
            long r1 = r0.zzm
            r0.zzj = r1
            return r8
        L_0x0168:
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            r3 = r1
            com.google.android.gms.internal.ads.zzaby r3 = (com.google.android.gms.internal.ads.zzaby) r3
            r3.zzn(r2, r8, r5, r8)
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            r2.zzK(r8)
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            int r3 = r2.zzi()
            int r2 = r2.zzi()
            r5 = 829973609(0x31786469, float:3.6145826E-9)
            if (r3 != r5) goto L_0x018d
            r0.zze = r4
            r0.zzo = r2
            goto L_0x0195
        L_0x018d:
            long r3 = r28.zzf()
            long r1 = (long) r2
            long r3 = r3 + r1
            r0.zzj = r3
        L_0x0195:
            return r8
        L_0x0196:
            long r13 = r0.zzm
            int r4 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x01a8
            long r4 = r28.zzf()
            int r4 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r4 != 0) goto L_0x01a5
            goto L_0x01a8
        L_0x01a5:
            r0.zzj = r13
            return r8
        L_0x01a8:
            com.google.android.gms.internal.ads.zzek r4 = r0.zza
            byte[] r4 = r4.zzM()
            r5 = r1
            com.google.android.gms.internal.ads.zzaby r5 = (com.google.android.gms.internal.ads.zzaby) r5
            r5.zzm(r4, r8, r3, r8)
            r28.zzj()
            com.google.android.gms.internal.ads.zzek r4 = r0.zza
            r4.zzK(r8)
            com.google.android.gms.internal.ads.zzaea r4 = r0.zzb
            com.google.android.gms.internal.ads.zzek r5 = r0.zza
            r4.zza(r5)
            com.google.android.gms.internal.ads.zzek r4 = r0.zza
            com.google.android.gms.internal.ads.zzaea r5 = r0.zzb
            int r4 = r4.zzi()
            int r6 = r5.zza
            r12 = 1179011410(0x46464952, float:12690.33)
            if (r6 != r12) goto L_0x01d8
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r1.zzo(r3, r8)
            return r8
        L_0x01d8:
            if (r6 != r10) goto L_0x021e
            if (r4 == r11) goto L_0x01dd
            goto L_0x021e
        L_0x01dd:
            long r3 = r28.zzf()
            r0.zzm = r3
            int r5 = r5.zzb
            long r5 = (long) r5
            long r3 = r3 + r5
            long r3 = r3 + r16
            r0.zzn = r3
            boolean r5 = r0.zzp
            if (r5 != 0) goto L_0x0212
            com.google.android.gms.internal.ads.zzaec r5 = r0.zzg
            r5.getClass()
            int r5 = r5.zzb
            r2 = 16
            r5 = r5 & r2
            if (r5 == r2) goto L_0x020c
            com.google.android.gms.internal.ads.zzacn r2 = r0.zzf
            com.google.android.gms.internal.ads.zzadh r3 = new com.google.android.gms.internal.ads.zzadh
            long r4 = r0.zzh
            r10 = 0
            r3.<init>(r4, r10)
            r2.zzO(r3)
            r0.zzp = r7
            goto L_0x0212
        L_0x020c:
            r2 = 4
            r0.zze = r2
            r0.zzj = r3
            return r8
        L_0x0212:
            long r1 = r28.zzf()
            r3 = 12
            long r1 = r1 + r3
            r0.zzj = r1
            r0.zze = r9
            return r8
        L_0x021e:
            long r1 = r28.zzf()
            int r3 = r5.zzb
            long r3 = (long) r3
            long r1 = r1 + r3
            long r1 = r1 + r16
            r0.zzj = r1
            return r8
        L_0x022b:
            int r2 = r0.zzl
            int r2 = r2 + -4
            com.google.android.gms.internal.ads.zzek r3 = new com.google.android.gms.internal.ads.zzek
            r3.<init>((int) r2)
            byte[] r4 = r3.zzM()
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r1.zzn(r4, r8, r2, r8)
            com.google.android.gms.internal.ads.zzaef r1 = com.google.android.gms.internal.ads.zzaef.zzc(r9, r3)
            int r2 = r1.zza()
            if (r2 != r9) goto L_0x0337
            java.lang.Class<com.google.android.gms.internal.ads.zzaec> r2 = com.google.android.gms.internal.ads.zzaec.class
            com.google.android.gms.internal.ads.zzadx r2 = r1.zzb(r2)
            com.google.android.gms.internal.ads.zzaec r2 = (com.google.android.gms.internal.ads.zzaec) r2
            if (r2 == 0) goto L_0x032f
            r0.zzg = r2
            int r3 = r2.zza
            int r2 = r2.zzc
            long r4 = (long) r2
            long r2 = (long) r3
            long r4 = r4 * r2
            r0.zzh = r4
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            com.google.android.gms.internal.ads.zzfxr r1 = r1.zza
            int r3 = r1.size()
            r4 = r8
            r14 = r4
        L_0x0269:
            if (r4 >= r3) goto L_0x031b
            java.lang.Object r5 = r1.get(r4)
            com.google.android.gms.internal.ads.zzadx r5 = (com.google.android.gms.internal.ads.zzadx) r5
            int r9 = r5.zza()
            r10 = 1819440243(0x6c727473, float:1.17243986E27)
            if (r9 != r10) goto L_0x0312
            com.google.android.gms.internal.ads.zzaef r5 = (com.google.android.gms.internal.ads.zzaef) r5
            int r9 = r14 + 1
            java.lang.Class<com.google.android.gms.internal.ads.zzaed> r10 = com.google.android.gms.internal.ads.zzaed.class
            com.google.android.gms.internal.ads.zzadx r10 = r5.zzb(r10)
            com.google.android.gms.internal.ads.zzaed r10 = (com.google.android.gms.internal.ads.zzaed) r10
            java.lang.Class<com.google.android.gms.internal.ads.zzaeg> r13 = com.google.android.gms.internal.ads.zzaeg.class
            com.google.android.gms.internal.ads.zzadx r13 = r5.zzb(r13)
            com.google.android.gms.internal.ads.zzaeg r13 = (com.google.android.gms.internal.ads.zzaeg) r13
            java.lang.String r15 = "AviExtractor"
            if (r10 != 0) goto L_0x029c
            java.lang.String r5 = "Missing Stream Header"
            com.google.android.gms.internal.ads.zzea.zzf(r15, r5)
        L_0x0297:
            r10 = r6
            r28 = r9
            goto L_0x030b
        L_0x029c:
            if (r13 != 0) goto L_0x02a4
            java.lang.String r5 = "Missing Stream Format"
            com.google.android.gms.internal.ads.zzea.zzf(r15, r5)
            goto L_0x0297
        L_0x02a4:
            int r15 = r10.zzd
            int r6 = r10.zzb
            int r12 = r10.zzc
            r28 = r9
            long r8 = (long) r6
            long r11 = (long) r12
            java.math.RoundingMode r26 = java.math.RoundingMode.FLOOR
            long r6 = (long) r15
            r17 = 1000000(0xf4240, double:4.940656E-318)
            long r22 = r8 * r17
            r20 = r6
            r24 = r11
            long r7 = com.google.android.gms.internal.ads.zzet.zzt(r20, r22, r24, r26)
            com.google.android.gms.internal.ads.zzaf r6 = r13.zza
            com.google.android.gms.internal.ads.zzad r9 = r6.zzb()
            r9.zzJ(r14)
            int r11 = r10.zze
            if (r11 == 0) goto L_0x02ce
            r9.zzP(r11)
        L_0x02ce:
            java.lang.Class<com.google.android.gms.internal.ads.zzaeh> r11 = com.google.android.gms.internal.ads.zzaeh.class
            com.google.android.gms.internal.ads.zzadx r5 = r5.zzb(r11)
            com.google.android.gms.internal.ads.zzaeh r5 = (com.google.android.gms.internal.ads.zzaeh) r5
            if (r5 == 0) goto L_0x02dd
            java.lang.String r5 = r5.zza
            r9.zzM(r5)
        L_0x02dd:
            java.lang.String r5 = r6.zzm
            int r5 = com.google.android.gms.internal.ads.zzbn.zzb(r5)
            r6 = 1
            if (r5 == r6) goto L_0x02ed
            r6 = 2
            if (r5 != r6) goto L_0x02eb
            r15 = 2
            goto L_0x02ee
        L_0x02eb:
            r10 = 0
            goto L_0x030b
        L_0x02ed:
            r15 = r5
        L_0x02ee:
            com.google.android.gms.internal.ads.zzacn r5 = r0.zzf
            com.google.android.gms.internal.ads.zzadp r5 = r5.zzw(r14, r15)
            com.google.android.gms.internal.ads.zzaf r9 = r9.zzad()
            r5.zzl(r9)
            int r9 = r10.zzd
            com.google.android.gms.internal.ads.zzaee r10 = new com.google.android.gms.internal.ads.zzaee
            r13 = r10
            r16 = r7
            r18 = r9
            r19 = r5
            r13.<init>(r14, r15, r16, r18, r19)
            r0.zzh = r7
        L_0x030b:
            if (r10 == 0) goto L_0x0310
            r2.add(r10)
        L_0x0310:
            r14 = r28
        L_0x0312:
            int r4 = r4 + 1
            r6 = 0
            r7 = 1
            r8 = 0
            r11 = 2
            r12 = 3
            goto L_0x0269
        L_0x031b:
            r4 = r8
            com.google.android.gms.internal.ads.zzaee[] r1 = new com.google.android.gms.internal.ads.zzaee[r4]
            java.lang.Object[] r1 = r2.toArray(r1)
            com.google.android.gms.internal.ads.zzaee[] r1 = (com.google.android.gms.internal.ads.zzaee[]) r1
            r0.zzi = r1
            com.google.android.gms.internal.ads.zzacn r1 = r0.zzf
            r1.zzD()
            r1 = 3
            r0.zze = r1
            return r4
        L_0x032f:
            java.lang.String r1 = "AviHeader not found"
            r2 = 0
            com.google.android.gms.internal.ads.zzbo r1 = com.google.android.gms.internal.ads.zzbo.zza(r1, r2)
            throw r1
        L_0x0337:
            r2 = r6
            int r1 = r1.zza()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Unexpected header list type "
            r3.<init>(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.google.android.gms.internal.ads.zzbo r1 = com.google.android.gms.internal.ads.zzbo.zza(r1, r2)
            throw r1
        L_0x034f:
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r4 = 0
            r1.zzn(r2, r4, r3, r4)
            com.google.android.gms.internal.ads.zzek r1 = r0.zza
            r1.zzK(r4)
            com.google.android.gms.internal.ads.zzaea r1 = r0.zzb
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            r1.zza(r2)
            int r3 = r1.zza
            if (r3 != r10) goto L_0x0394
            int r2 = r2.zzi()
            r1.zzc = r2
            com.google.android.gms.internal.ads.zzaea r1 = r0.zzb
            int r2 = r1.zzc
            if (r2 != r9) goto L_0x0380
            int r1 = r1.zzb
            r0.zzl = r1
            r1 = 2
            r0.zze = r1
            r1 = 0
            return r1
        L_0x0380:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "hdrl expected, found: "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbo r1 = com.google.android.gms.internal.ads.zzbo.zza(r1, r2)
            throw r1
        L_0x0394:
            r2 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r4 = "LIST expected, found: "
            r1.<init>(r4)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.internal.ads.zzbo r1 = com.google.android.gms.internal.ads.zzbo.zza(r1, r2)
            throw r1
        L_0x03a8:
            r2 = r6
            boolean r4 = r27.zzj(r28)
            if (r4 == 0) goto L_0x03b9
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r2 = 0
            r1.zzo(r3, r2)
            r1 = 1
            r0.zze = r1
            return r2
        L_0x03b9:
            java.lang.String r1 = "AVI Header List not found"
            com.google.android.gms.internal.ads.zzbo r1 = com.google.android.gms.internal.ads.zzbo.zza(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaeb.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zze = 0;
        if (this.zzc) {
            zzacn = new zzakc(zzacn, this.zzd);
        }
        this.zzf = zzacn;
        this.zzj = -1;
    }

    public final void zzi(long j, long j2) {
        this.zzj = -1;
        this.zzk = null;
        int i = 0;
        for (zzaee zzf2 : this.zzi) {
            zzf2.zzf(j);
        }
        if (j == 0) {
            if (this.zzi.length != 0) {
                i = 3;
            }
            this.zze = i;
            return;
        }
        this.zze = 6;
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        ((zzaby) zzacl).zzm(this.zza.zzM(), 0, 12, false);
        this.zza.zzK(0);
        if (this.zza.zzi() != 1179011410) {
            return false;
        }
        this.zza.zzL(4);
        if (this.zza.zzi() == 541677121) {
            return true;
        }
        return false;
    }

    public zzaeb(int i, zzajy zzajy) {
        this.zzd = zzajy;
        this.zzc = 1 != (i ^ 1) ? false : true;
        this.zza = new zzek(12);
        this.zzb = new zzaea((zzadz) null);
        this.zzf = new zzaci();
        this.zzi = new zzaee[0];
        this.zzm = -1;
        this.zzn = -1;
        this.zzl = -1;
        this.zzh = -9223372036854775807L;
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
