package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzanz implements zzack {
    private zzacn zza;
    private zzadp zzb;
    private int zzc = 0;
    private long zzd = -1;
    private zzanx zze;
    private int zzf = -1;
    private long zzg = -1;

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e6, code lost:
        if (r1 != 65534) goto L_0x00e8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ed, code lost:
        if (r2 == 32) goto L_0x00f4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r19, com.google.android.gms.internal.ads.zzadf r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            com.google.android.gms.internal.ads.zzadp r2 = r0.zzb
            com.google.android.gms.internal.ads.zzdi.zzb(r2)
            int r2 = com.google.android.gms.internal.ads.zzet.zza
            int r2 = r0.zzc
            r3 = -1
            r4 = 4
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0151
            r7 = 2
            r8 = -1
            if (r2 == r5) goto L_0x011c
            r10 = 3
            if (r2 == r7) goto L_0x009f
            if (r2 == r10) goto L_0x003c
            long r10 = r0.zzg
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r5 = r6
        L_0x0025:
            com.google.android.gms.internal.ads.zzdi.zzf(r5)
            long r4 = r0.zzg
            long r7 = r19.zzf()
            long r4 = r4 - r7
            com.google.android.gms.internal.ads.zzanx r2 = r0.zze
            r2.getClass()
            boolean r1 = r2.zzc(r1, r4)
            if (r1 == 0) goto L_0x003b
            return r3
        L_0x003b:
            return r6
        L_0x003c:
            android.util.Pair r2 = com.google.android.gms.internal.ads.zzaoc.zza(r19)
            java.lang.Object r3 = r2.first
            java.lang.Long r3 = (java.lang.Long) r3
            int r3 = r3.intValue()
            r0.zzf = r3
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r2 = r2.longValue()
            long r10 = r0.zzd
            int r5 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0062
            r12 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r5 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r5 != 0) goto L_0x0062
            r2 = r10
        L_0x0062:
            int r5 = r0.zzf
            long r10 = (long) r5
            long r10 = r10 + r2
            r0.zzg = r10
            long r1 = r19.zzd()
            int r3 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x0092
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0092
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Data exceeds input length: "
            r3.<init>(r5)
            r3.append(r10)
            java.lang.String r5 = ", "
            r3.append(r5)
            r3.append(r1)
            java.lang.String r3 = r3.toString()
            java.lang.String r5 = "WavExtractor"
            com.google.android.gms.internal.ads.zzea.zzf(r5, r3)
            r0.zzg = r1
            r10 = r1
        L_0x0092:
            com.google.android.gms.internal.ads.zzanx r1 = r0.zze
            r1.getClass()
            int r2 = r0.zzf
            r1.zza(r2, r10)
            r0.zzc = r4
            return r6
        L_0x009f:
            com.google.android.gms.internal.ads.zzaoa r15 = com.google.android.gms.internal.ads.zzaoc.zzb(r19)
            int r1 = r15.zza
            r2 = 17
            if (r1 != r2) goto L_0x00b5
            com.google.android.gms.internal.ads.zzanw r1 = new com.google.android.gms.internal.ads.zzanw
            com.google.android.gms.internal.ads.zzacn r2 = r0.zza
            com.google.android.gms.internal.ads.zzadp r3 = r0.zzb
            r1.<init>(r2, r3, r15)
            r0.zze = r1
            goto L_0x0106
        L_0x00b5:
            r2 = 6
            if (r1 != r2) goto L_0x00c9
            com.google.android.gms.internal.ads.zzany r1 = new com.google.android.gms.internal.ads.zzany
            com.google.android.gms.internal.ads.zzacn r13 = r0.zza
            com.google.android.gms.internal.ads.zzadp r14 = r0.zzb
            java.lang.String r16 = "audio/g711-alaw"
            r17 = -1
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zze = r1
            goto L_0x0106
        L_0x00c9:
            r2 = 7
            if (r1 != r2) goto L_0x00dd
            com.google.android.gms.internal.ads.zzany r1 = new com.google.android.gms.internal.ads.zzany
            com.google.android.gms.internal.ads.zzacn r13 = r0.zza
            com.google.android.gms.internal.ads.zzadp r14 = r0.zzb
            java.lang.String r16 = "audio/g711-mlaw"
            r17 = -1
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zze = r1
            goto L_0x0106
        L_0x00dd:
            int r2 = r15.zze
            if (r1 == r5) goto L_0x00f0
            if (r1 == r10) goto L_0x00eb
            r3 = 65534(0xfffe, float:9.1833E-41)
            if (r1 == r3) goto L_0x00f0
        L_0x00e8:
            r17 = r6
            goto L_0x00f6
        L_0x00eb:
            r3 = 32
            if (r2 != r3) goto L_0x00e8
            goto L_0x00f4
        L_0x00f0:
            int r4 = com.google.android.gms.internal.ads.zzet.zzl(r2)
        L_0x00f4:
            r17 = r4
        L_0x00f6:
            if (r17 == 0) goto L_0x0109
            com.google.android.gms.internal.ads.zzany r1 = new com.google.android.gms.internal.ads.zzany
            com.google.android.gms.internal.ads.zzacn r13 = r0.zza
            com.google.android.gms.internal.ads.zzadp r14 = r0.zzb
            java.lang.String r16 = "audio/raw"
            r12 = r1
            r12.<init>(r13, r14, r15, r16, r17)
            r0.zze = r1
        L_0x0106:
            r0.zzc = r10
            return r6
        L_0x0109:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unsupported WAV format type: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.internal.ads.zzbo r1 = com.google.android.gms.internal.ads.zzbo.zzc(r1)
            throw r1
        L_0x011c:
            com.google.android.gms.internal.ads.zzek r2 = new com.google.android.gms.internal.ads.zzek
            r3 = 8
            r2.<init>((int) r3)
            com.google.android.gms.internal.ads.zzaob r4 = com.google.android.gms.internal.ads.zzaob.zza(r1, r2)
            int r5 = r4.zza
            r10 = 1685272116(0x64733634, float:1.7945858E22)
            if (r5 == r10) goto L_0x0132
            r19.zzj()
            goto L_0x014c
        L_0x0132:
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r1.zzl(r3, r6)
            r2.zzK(r6)
            byte[] r5 = r2.zzM()
            r1.zzm(r5, r6, r3, r6)
            long r8 = r2.zzr()
            long r4 = r4.zzb
            int r2 = (int) r4
            int r2 = r2 + r3
            r1.zzo(r2, r6)
        L_0x014c:
            r0.zzd = r8
            r0.zzc = r7
            return r6
        L_0x0151:
            long r7 = r19.zzf()
            r9 = 0
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 != 0) goto L_0x015d
            r2 = r5
            goto L_0x015e
        L_0x015d:
            r2 = r6
        L_0x015e:
            com.google.android.gms.internal.ads.zzdi.zzf(r2)
            int r2 = r0.zzf
            if (r2 == r3) goto L_0x016d
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r1.zzo(r2, r6)
            r0.zzc = r4
            goto L_0x0184
        L_0x016d:
            boolean r2 = com.google.android.gms.internal.ads.zzaoc.zzc(r19)
            if (r2 == 0) goto L_0x0185
            long r2 = r19.zze()
            long r7 = r19.zzf()
            long r2 = r2 - r7
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            int r2 = (int) r2
            r1.zzo(r2, r6)
            r0.zzc = r5
        L_0x0184:
            return r6
        L_0x0185:
            java.lang.String r1 = "Unsupported or unrecognized wav file type."
            r2 = 0
            com.google.android.gms.internal.ads.zzbo r1 = com.google.android.gms.internal.ads.zzbo.zza(r1, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanz.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zza = zzacn;
        this.zzb = zzacn.zzw(0, 1);
        zzacn.zzD();
    }

    public final void zzi(long j, long j2) {
        int i;
        if (j == 0) {
            i = 0;
        } else {
            i = 4;
        }
        this.zzc = i;
        zzanx zzanx = this.zze;
        if (zzanx != null) {
            zzanx.zzb(j2);
        }
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        return zzaoc.zzc(zzacl);
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
