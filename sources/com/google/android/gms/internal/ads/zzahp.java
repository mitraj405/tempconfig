package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzahp implements zzack {
    private final zzek zza;
    private final zzadc zzb;
    private final zzacy zzc;
    private final zzada zzd;
    private final zzadp zze;
    private zzacn zzf;
    private zzadp zzg;
    private zzadp zzh;
    private int zzi;
    private zzbk zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private int zzn;
    private zzahr zzo;
    private boolean zzp;

    public zzahp() {
        throw null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: com.google.android.gms.internal.ads.zzahm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: com.google.android.gms.internal.ads.zzahm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v39, resolved type: com.google.android.gms.internal.ads.zzahq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v47, resolved type: com.google.android.gms.internal.ads.zzahm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v50, resolved type: com.google.android.gms.internal.ads.zzahm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v61, resolved type: com.google.android.gms.internal.ads.zzahm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: com.google.android.gms.internal.ads.zzahm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v62, resolved type: com.google.android.gms.internal.ads.zzahm} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v63, resolved type: com.google.android.gms.internal.ads.zzahu} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v64, resolved type: com.google.android.gms.internal.ads.zzahs} */
    /* JADX WARNING: type inference failed for: r3v16 */
    /* JADX WARNING: type inference failed for: r3v40 */
    /* JADX WARNING: type inference failed for: r3v41, types: [com.google.android.gms.internal.ads.zzaho] */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01c2, code lost:
        if (r2 != null) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c4, code lost:
        r2 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0241  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzg(com.google.android.gms.internal.ads.zzacl r35) throws java.io.IOException {
        /*
            r34 = this;
            r0 = r34
            r1 = r35
            int r2 = r0.zzi
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L_0x000f
            r0.zzm(r1, r4)     // Catch:{ EOFException -> 0x000e }
            goto L_0x000f
        L_0x000e:
            return r3
        L_0x000f:
            com.google.android.gms.internal.ads.zzahr r2 = r0.zzo
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = 1
            if (r2 != 0) goto L_0x025a
            com.google.android.gms.internal.ads.zzadc r2 = r0.zzb
            com.google.android.gms.internal.ads.zzek r14 = new com.google.android.gms.internal.ads.zzek
            int r2 = r2.zzc
            r14.<init>((int) r2)
            byte[] r2 = r14.zzM()
            com.google.android.gms.internal.ads.zzadc r9 = r0.zzb
            int r9 = r9.zzc
            r10 = r1
            com.google.android.gms.internal.ads.zzaby r10 = (com.google.android.gms.internal.ads.zzaby) r10
            r10.zzm(r2, r4, r9, r4)
            com.google.android.gms.internal.ads.zzadc r2 = r0.zzb
            int r9 = r2.zza
            r9 = r9 & r8
            r10 = 36
            r11 = 21
            if (r9 == 0) goto L_0x0041
            int r2 = r2.zze
            if (r2 == r8) goto L_0x0048
            r11 = r10
            goto L_0x0048
        L_0x0041:
            int r2 = r2.zze
            if (r2 == r8) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r11 = 13
        L_0x0048:
            int r2 = r14.zze()
            int r9 = r11 + 4
            r12 = 1231971951(0x496e666f, float:976486.94)
            r13 = 1447187017(0x56425249, float:5.3414667E13)
            r15 = 1483304551(0x58696e67, float:1.02664153E15)
            if (r2 < r9) goto L_0x0066
            r14.zzK(r11)
            int r2 = r14.zzg()
            if (r2 == r15) goto L_0x007a
            if (r2 != r12) goto L_0x0066
            r2 = r12
            goto L_0x007a
        L_0x0066:
            int r2 = r14.zze()
            r9 = 40
            if (r2 < r9) goto L_0x0079
            r14.zzK(r10)
            int r2 = r14.zzg()
            if (r2 != r13) goto L_0x0079
            r2 = r13
            goto L_0x007a
        L_0x0079:
            r2 = r4
        L_0x007a:
            if (r2 == r12) goto L_0x00a0
            if (r2 == r13) goto L_0x0086
            if (r2 == r15) goto L_0x00a0
            r35.zzj()
        L_0x0083:
            r2 = 0
            goto L_0x0162
        L_0x0086:
            long r9 = r35.zzd()
            long r11 = r35.zzf()
            com.google.android.gms.internal.ads.zzadc r13 = r0.zzb
            com.google.android.gms.internal.ads.zzahs r2 = com.google.android.gms.internal.ads.zzahs.zzb(r9, r11, r13, r14)
            com.google.android.gms.internal.ads.zzadc r9 = r0.zzb
            int r9 = r9.zzc
            r10 = r1
            com.google.android.gms.internal.ads.zzaby r10 = (com.google.android.gms.internal.ads.zzaby) r10
            r10.zzo(r9, r4)
            goto L_0x0162
        L_0x00a0:
            com.google.android.gms.internal.ads.zzadc r9 = r0.zzb
            com.google.android.gms.internal.ads.zzaht r9 = com.google.android.gms.internal.ads.zzaht.zzb(r9, r14)
            com.google.android.gms.internal.ads.zzacy r10 = r0.zzc
            boolean r11 = r10.zza()
            if (r11 != 0) goto L_0x00ba
            int r11 = r9.zzd
            if (r11 == r3) goto L_0x00ba
            int r12 = r9.zze
            if (r12 == r3) goto L_0x00ba
            r10.zza = r11
            r10.zzb = r12
        L_0x00ba:
            long r10 = r35.zzf()
            long r12 = r35.zzd()
            r16 = -1
            int r12 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r12 == 0) goto L_0x00fb
            long r12 = r9.zzc
            int r14 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r14 == 0) goto L_0x00fb
            long r18 = r35.zzd()
            long r12 = r12 + r10
            int r14 = (r18 > r12 ? 1 : (r18 == r12 ? 0 : -1))
            if (r14 == 0) goto L_0x00fb
            long r7 = r35.zzd()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r3 = "Data size mismatch between stream ("
            r14.<init>(r3)
            r14.append(r7)
            java.lang.String r3 = ") and Xing frame ("
            r14.append(r3)
            r14.append(r12)
            java.lang.String r3 = "), using Xing value."
            r14.append(r3)
            java.lang.String r3 = r14.toString()
            java.lang.String r7 = "Mp3Extractor"
            com.google.android.gms.internal.ads.zzea.zze(r7, r3)
        L_0x00fb:
            com.google.android.gms.internal.ads.zzadc r3 = r0.zzb
            int r3 = r3.zzc
            r7 = r1
            com.google.android.gms.internal.ads.zzaby r7 = (com.google.android.gms.internal.ads.zzaby) r7
            r7.zzo(r3, r4)
            if (r2 != r15) goto L_0x010c
            com.google.android.gms.internal.ads.zzahu r2 = com.google.android.gms.internal.ads.zzahu.zzb(r9, r10)
            goto L_0x0162
        L_0x010c:
            long r2 = r35.zzd()
            long r24 = r9.zza()
            int r7 = (r24 > r5 ? 1 : (r24 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x011a
            goto L_0x0083
        L_0x011a:
            long r7 = r9.zzc
            int r12 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r12 == 0) goto L_0x012b
            long r2 = r10 + r7
            com.google.android.gms.internal.ads.zzadc r12 = r9.zza
            int r12 = r12.zzc
        L_0x0126:
            long r12 = (long) r12
            long r7 = r7 - r12
            r27 = r2
            goto L_0x0136
        L_0x012b:
            int r7 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r7 == 0) goto L_0x0083
            long r7 = r2 - r10
            com.google.android.gms.internal.ads.zzadc r12 = r9.zza
            int r12 = r12.zzc
            goto L_0x0126
        L_0x0136:
            r22 = 8000000(0x7a1200, double:3.952525E-317)
            java.math.RoundingMode r26 = java.math.RoundingMode.HALF_UP
            r20 = r7
            long r2 = com.google.android.gms.internal.ads.zzet.zzt(r20, r22, r24, r26)
            int r31 = com.google.android.gms.internal.ads.zzgap.zzb(r2)
            long r2 = r9.zzb
            java.math.RoundingMode r12 = java.math.RoundingMode.HALF_UP
            long r2 = com.google.android.gms.internal.ads.zzgaj.zzb(r7, r2, r12)
            int r32 = com.google.android.gms.internal.ads.zzgap.zzb(r2)
            com.google.android.gms.internal.ads.zzadc r2 = r9.zza
            com.google.android.gms.internal.ads.zzahm r3 = new com.google.android.gms.internal.ads.zzahm
            int r2 = r2.zzc
            long r7 = (long) r2
            long r29 = r10 + r7
            r33 = 0
            r26 = r3
            r26.<init>(r27, r29, r31, r32, r33)
            r2 = r3
        L_0x0162:
            com.google.android.gms.internal.ads.zzbk r3 = r0.zzj
            long r7 = r35.zzf()
            if (r3 == 0) goto L_0x01b3
            int r9 = r3.zza()
            r10 = r4
        L_0x016f:
            if (r10 >= r9) goto L_0x01b3
            com.google.android.gms.internal.ads.zzbj r11 = r3.zzb(r10)
            boolean r12 = r11 instanceof com.google.android.gms.internal.ads.zzagi
            if (r12 == 0) goto L_0x01b0
            com.google.android.gms.internal.ads.zzagi r11 = (com.google.android.gms.internal.ads.zzagi) r11
            int r9 = r3.zza()
            r10 = r4
        L_0x0180:
            if (r10 >= r9) goto L_0x01aa
            com.google.android.gms.internal.ads.zzbj r12 = r3.zzb(r10)
            boolean r13 = r12 instanceof com.google.android.gms.internal.ads.zzagm
            if (r13 == 0) goto L_0x01a7
            com.google.android.gms.internal.ads.zzagm r12 = (com.google.android.gms.internal.ads.zzagm) r12
            java.lang.String r13 = r12.zzf
            java.lang.String r14 = "TLEN"
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x01a7
            com.google.android.gms.internal.ads.zzfxr r3 = r12.zzb
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            long r9 = java.lang.Long.parseLong(r3)
            long r9 = com.google.android.gms.internal.ads.zzet.zzr(r9)
            goto L_0x01ab
        L_0x01a7:
            int r10 = r10 + 1
            goto L_0x0180
        L_0x01aa:
            r9 = r5
        L_0x01ab:
            com.google.android.gms.internal.ads.zzaho r3 = com.google.android.gms.internal.ads.zzaho.zzb(r7, r11, r9)
            goto L_0x01b4
        L_0x01b0:
            int r10 = r10 + 1
            goto L_0x016f
        L_0x01b3:
            r3 = 0
        L_0x01b4:
            boolean r7 = r0.zzp
            if (r7 == 0) goto L_0x01be
            com.google.android.gms.internal.ads.zzahq r2 = new com.google.android.gms.internal.ads.zzahq
            r2.<init>()
            goto L_0x01fd
        L_0x01be:
            if (r3 == 0) goto L_0x01c2
            r2 = r3
            goto L_0x01c5
        L_0x01c2:
            if (r2 != 0) goto L_0x01c5
            r2 = 0
        L_0x01c5:
            if (r2 == 0) goto L_0x01cb
            r2.zzh()
            goto L_0x01fd
        L_0x01cb:
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            r3 = r1
            com.google.android.gms.internal.ads.zzaby r3 = (com.google.android.gms.internal.ads.zzaby) r3
            r7 = 4
            r3.zzm(r2, r4, r7, r4)
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            r2.zzK(r4)
            com.google.android.gms.internal.ads.zzadc r2 = r0.zzb
            com.google.android.gms.internal.ads.zzek r3 = r0.zza
            int r3 = r3.zzg()
            r2.zza(r3)
            com.google.android.gms.internal.ads.zzahm r2 = new com.google.android.gms.internal.ads.zzahm
            long r8 = r35.zzd()
            long r10 = r35.zzf()
            com.google.android.gms.internal.ads.zzadc r3 = r0.zzb
            int r12 = r3.zzf
            int r13 = r3.zzc
            r14 = 0
            r7 = r2
            r7.<init>(r8, r10, r12, r13, r14)
        L_0x01fd:
            r0.zzo = r2
            com.google.android.gms.internal.ads.zzacn r3 = r0.zzf
            r3.zzO(r2)
            com.google.android.gms.internal.ads.zzad r2 = new com.google.android.gms.internal.ads.zzad
            r2.<init>()
            com.google.android.gms.internal.ads.zzadc r3 = r0.zzb
            java.lang.String r3 = r3.zzb
            r2.zzX(r3)
            r3 = 4096(0x1000, float:5.74E-42)
            r2.zzP(r3)
            com.google.android.gms.internal.ads.zzadc r3 = r0.zzb
            int r3 = r3.zze
            r2.zzy(r3)
            com.google.android.gms.internal.ads.zzadc r3 = r0.zzb
            int r3 = r3.zzd
            r2.zzY(r3)
            com.google.android.gms.internal.ads.zzacy r3 = r0.zzc
            int r3 = r3.zza
            r2.zzF(r3)
            com.google.android.gms.internal.ads.zzacy r3 = r0.zzc
            int r3 = r3.zzb
            r2.zzG(r3)
            com.google.android.gms.internal.ads.zzbk r3 = r0.zzj
            r2.zzQ(r3)
            com.google.android.gms.internal.ads.zzahr r3 = r0.zzo
            int r3 = r3.zzc()
            r7 = -2147483647(0xffffffff80000001, float:-1.4E-45)
            if (r3 == r7) goto L_0x024a
            com.google.android.gms.internal.ads.zzahr r3 = r0.zzo
            int r3 = r3.zzc()
            r2.zzx(r3)
        L_0x024a:
            com.google.android.gms.internal.ads.zzadp r3 = r0.zzh
            com.google.android.gms.internal.ads.zzaf r2 = r2.zzad()
            r3.zzl(r2)
            long r2 = r35.zzf()
            r0.zzm = r2
            goto L_0x0272
        L_0x025a:
            long r2 = r0.zzm
            r7 = 0
            int r7 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0272
            long r7 = r35.zzf()
            int r9 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r9 >= 0) goto L_0x0272
            long r2 = r2 - r7
            r7 = r1
            com.google.android.gms.internal.ads.zzaby r7 = (com.google.android.gms.internal.ads.zzaby) r7
            int r2 = (int) r2
            r7.zzo(r2, r4)
        L_0x0272:
            int r2 = r0.zzn
            if (r2 != 0) goto L_0x02d9
            r35.zzj()
            boolean r2 = r34.zzl(r35)
            if (r2 == 0) goto L_0x0282
            r3 = -1
            goto L_0x02ed
        L_0x0282:
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            r2.zzK(r4)
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            int r2 = r2.zzg()
            int r3 = r0.zzi
            long r7 = (long) r3
            boolean r3 = zzk(r2, r7)
            if (r3 == 0) goto L_0x02d0
            int r3 = com.google.android.gms.internal.ads.zzadd.zzb(r2)
            r7 = -1
            if (r3 != r7) goto L_0x029e
            goto L_0x02d0
        L_0x029e:
            com.google.android.gms.internal.ads.zzadc r3 = r0.zzb
            r3.zza(r2)
            long r2 = r0.zzk
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x02b5
            com.google.android.gms.internal.ads.zzahr r2 = r0.zzo
            long r5 = r35.zzf()
            long r2 = r2.zze(r5)
            r0.zzk = r2
        L_0x02b5:
            com.google.android.gms.internal.ads.zzadc r2 = r0.zzb
            int r3 = r2.zzc
            r0.zzn = r3
            com.google.android.gms.internal.ads.zzahr r5 = r0.zzo
            boolean r6 = r5 instanceof com.google.android.gms.internal.ads.zzahn
            if (r6 != 0) goto L_0x02c3
            r2 = r3
            goto L_0x02d9
        L_0x02c3:
            com.google.android.gms.internal.ads.zzahn r5 = (com.google.android.gms.internal.ads.zzahn) r5
            long r3 = r0.zzl
            int r1 = r2.zzg
            long r1 = (long) r1
            long r3 = r3 + r1
            r0.zzh(r3)
            r1 = 0
            throw r1
        L_0x02d0:
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r3 = 1
            r1.zzo(r3, r4)
            r0.zzi = r4
            goto L_0x02ec
        L_0x02d9:
            r3 = 1
            com.google.android.gms.internal.ads.zzadp r5 = r0.zzh
            int r1 = r5.zzf(r1, r2, r3)
            r2 = -1
            if (r1 != r2) goto L_0x02e5
            r3 = r2
            goto L_0x02ed
        L_0x02e5:
            int r2 = r0.zzn
            int r2 = r2 - r1
            r0.zzn = r2
            if (r2 <= 0) goto L_0x02ee
        L_0x02ec:
            r3 = r4
        L_0x02ed:
            return r3
        L_0x02ee:
            com.google.android.gms.internal.ads.zzadp r5 = r0.zzh
            long r1 = r0.zzl
            long r6 = r0.zzh(r1)
            r8 = 1
            com.google.android.gms.internal.ads.zzadc r1 = r0.zzb
            int r9 = r1.zzc
            r10 = 0
            r11 = 0
            r5.zzs(r6, r8, r9, r10, r11)
            long r1 = r0.zzl
            com.google.android.gms.internal.ads.zzadc r3 = r0.zzb
            int r3 = r3.zzg
            long r5 = (long) r3
            long r1 = r1 + r5
            r0.zzl = r1
            r0.zzn = r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahp.zzg(com.google.android.gms.internal.ads.zzacl):int");
    }

    private final long zzh(long j) {
        zzadc zzadc = this.zzb;
        return ((j * 1000000) / ((long) zzadc.zzd)) + this.zzk;
    }

    private static boolean zzk(int i, long j) {
        if (((long) (i & -128000)) == (j & -128000)) {
            return true;
        }
        return false;
    }

    private final boolean zzl(zzacl zzacl) throws IOException {
        zzahr zzahr = this.zzo;
        if (zzahr != null) {
            long zzd2 = zzahr.zzd();
            if (zzd2 != -1 && zzacl.zze() > zzd2 - 4) {
                return true;
            }
        }
        try {
            if (!zzacl.zzm(this.zza.zzM(), 0, 4, true)) {
                return true;
            }
            return false;
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzm(zzacl zzacl, boolean z) throws IOException {
        int i;
        int i2;
        int i3;
        int zzb2;
        zzacl.zzj();
        if (zzacl.zzf() == 0) {
            zzbk zza2 = this.zzd.zza(zzacl, (zzaga) null);
            this.zzj = zza2;
            if (zza2 != null) {
                this.zzc.zzb(zza2);
            }
            i2 = (int) zzacl.zze();
            if (!z) {
                ((zzaby) zzacl).zzo(i2, false);
            }
            i = 0;
        } else {
            i2 = 0;
            i = 0;
        }
        int i4 = i;
        int i5 = i4;
        while (true) {
            if (!zzl(zzacl)) {
                this.zza.zzK(0);
                int zzg2 = this.zza.zzg();
                if ((i == 0 || zzk(zzg2, (long) i)) && (zzb2 = zzadd.zzb(zzg2)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.zzb.zza(zzg2);
                        i = zzg2;
                    }
                    ((zzaby) zzacl).zzl(zzb2 - 4, false);
                } else {
                    if (true != z) {
                        i3 = 131072;
                    } else {
                        i3 = 32768;
                    }
                    int i6 = i5 + 1;
                    if (i5 != i3) {
                        if (z) {
                            zzacl.zzj();
                            ((zzaby) zzacl).zzl(i2 + i6, false);
                        } else {
                            ((zzaby) zzacl).zzo(1, false);
                        }
                        i = 0;
                        i5 = i6;
                        i4 = 0;
                    } else if (z) {
                        return false;
                    } else {
                        throw zzbo.zza("Searched too many bytes.", (Throwable) null);
                    }
                }
            } else if (i4 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            ((zzaby) zzacl).zzo(i2 + i5, false);
        } else {
            zzacl.zzj();
        }
        this.zzi = i;
        return true;
    }

    public final void zza() {
        this.zzp = true;
    }

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        zzdi.zzb(this.zzg);
        int i = zzet.zza;
        int zzg2 = zzg(zzacl);
        if (zzg2 == -1 && (this.zzo instanceof zzahn)) {
            if (this.zzo.zza() != zzh(this.zzl)) {
                zzahn zzahn = (zzahn) this.zzo;
                throw null;
            }
        }
        return zzg2;
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zzf = zzacn;
        zzadp zzw = zzacn.zzw(0, 1);
        this.zzg = zzw;
        this.zzh = zzw;
        this.zzf.zzD();
    }

    public final void zzi(long j, long j2) {
        this.zzi = 0;
        this.zzk = -9223372036854775807L;
        this.zzl = 0;
        this.zzn = 0;
        zzahr zzahr = this.zzo;
        if (zzahr instanceof zzahn) {
            zzahn zzahn = (zzahn) zzahr;
            throw null;
        }
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        return zzm(zzacl, true);
    }

    public zzahp(int i) {
        this.zza = new zzek(10);
        this.zzb = new zzadc();
        this.zzc = new zzacy();
        this.zzk = -9223372036854775807L;
        this.zzd = new zzada();
        zzacj zzacj = new zzacj();
        this.zze = zzacj;
        this.zzh = zzacj;
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
