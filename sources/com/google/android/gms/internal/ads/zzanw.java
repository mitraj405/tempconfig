package com.google.android.gms.internal.ads;

import java.math.RoundingMode;
import okhttp3.internal.http.StatusLine;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzanw implements zzanx {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, StatusLine.HTTP_TEMP_REDIRECT, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzacn zzc;
    private final zzadp zzd;
    private final zzaoa zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzek zzh;
    private final int zzi;
    private final zzaf zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzanw(zzacn zzacn, zzadp zzadp, zzaoa zzaoa) throws zzbo {
        this.zzc = zzacn;
        this.zzd = zzadp;
        this.zze = zzaoa;
        int max = Math.max(1, zzaoa.zzc / 10);
        this.zzi = max;
        zzek zzek = new zzek(zzaoa.zzf);
        zzek.zzk();
        int zzk2 = zzek.zzk();
        this.zzf = zzk2;
        int i = zzaoa.zzb;
        int i2 = zzaoa.zzd;
        int L = C1058d.L(i2 - (i * 4), 8, zzaoa.zze * i, 1);
        if (zzk2 == L) {
            int i3 = zzet.zza;
            int i4 = ((max + zzk2) - 1) / zzk2;
            this.zzg = new byte[(i2 * i4)];
            this.zzh = new zzek((zzk2 + zzk2) * i * i4);
            int i5 = ((zzaoa.zzc * zzaoa.zzd) * 8) / zzk2;
            zzad zzad = new zzad();
            zzad.zzX("audio/raw");
            zzad.zzx(i5);
            zzad.zzS(i5);
            zzad.zzP((max + max) * i);
            zzad.zzy(zzaoa.zzb);
            zzad.zzY(zzaoa.zzc);
            zzad.zzR(2);
            this.zzj = zzad.zzad();
            return;
        }
        throw zzbo.zza("Expected frames per block: " + L + "; got: " + zzk2, (Throwable) null);
    }

    private final int zzd(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zze(int i) {
        return (i + i) * this.zze.zzb;
    }

    private final void zzf(int i) {
        long zzt = this.zzl + zzet.zzt(this.zzn, 1000000, (long) this.zze.zzc, RoundingMode.FLOOR);
        int zze2 = zze(i);
        this.zzd.zzs(zzt, 1, zze2, this.zzm - zze2, (zzado) null);
        this.zzn += (long) i;
        this.zzm -= zze2;
    }

    public final void zza(int i, long j) {
        this.zzc.zzO(new zzaod(this.zze, this.zzf, (long) i, j));
        this.zzd.zzl(this.zzj);
    }

    public final void zzb(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0044 A[EDGE_INSN: B:38:0x0044->B:10:0x0044 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0025  */
    public final boolean zzc(com.google.android.gms.internal.ads.zzacl r21, long r22) throws java.io.IOException {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            int r3 = r0.zzm
            int r3 = r0.zzd(r3)
            int r4 = r0.zzi
            int r4 = r4 - r3
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            int r3 = r0.zzf
            int r4 = r4 + r3
            r5 = -1
            int r4 = r4 + r5
            int r4 = r4 / r3
            com.google.android.gms.internal.ads.zzaoa r3 = r0.zze
            int r3 = r3.zzd
            int r4 = r4 * r3
            r6 = 0
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0022
        L_0x0020:
            r3 = 1
            goto L_0x0023
        L_0x0022:
            r3 = 0
        L_0x0023:
            if (r3 != 0) goto L_0x0044
            int r8 = r0.zzk
            if (r8 >= r4) goto L_0x0044
            int r8 = r4 - r8
            long r8 = (long) r8
            long r8 = java.lang.Math.min(r8, r1)
            int r8 = (int) r8
            byte[] r9 = r0.zzg
            int r10 = r0.zzk
            r11 = r21
            int r8 = r11.zza(r9, r10, r8)
            if (r8 != r5) goto L_0x003e
            goto L_0x0020
        L_0x003e:
            int r9 = r0.zzk
            int r9 = r9 + r8
            r0.zzk = r9
            goto L_0x0023
        L_0x0044:
            int r1 = r0.zzk
            com.google.android.gms.internal.ads.zzaoa r2 = r0.zze
            int r2 = r2.zzd
            int r1 = r1 / r2
            if (r1 <= 0) goto L_0x014b
            byte[] r2 = r0.zzg
            com.google.android.gms.internal.ads.zzek r4 = r0.zzh
            r5 = 0
        L_0x0052:
            if (r5 >= r1) goto L_0x0118
            r8 = 0
        L_0x0055:
            com.google.android.gms.internal.ads.zzaoa r9 = r0.zze
            int r10 = r9.zzb
            if (r8 >= r10) goto L_0x0110
            byte[] r11 = r4.zzM()
            int r9 = r9.zzd
            int r12 = r5 * r9
            int r9 = r9 / r10
            int r9 = r9 + -4
            int r13 = r8 * 4
            int r13 = r13 + r12
            int r12 = r13 + 1
            byte r12 = r2[r12]
            r12 = r12 & 255(0xff, float:3.57E-43)
            byte r14 = r2[r13]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r15 = r13 + 2
            byte r15 = r2[r15]
            r15 = r15 & 255(0xff, float:3.57E-43)
            r6 = 88
            int r15 = java.lang.Math.min(r15, r6)
            int[] r16 = zzb
            r16 = r16[r15]
            int r6 = r0.zzf
            int r6 = r6 * r5
            int r6 = r6 * r10
            int r6 = r6 + r8
            int r12 = r12 << 8
            r12 = r12 | r14
            short r12 = (short) r12
            r14 = r12 & 255(0xff, float:3.57E-43)
            int r6 = r6 + r6
            byte r14 = (byte) r14
            r11[r6] = r14
            int r14 = r6 + 1
            int r7 = r12 >> 8
            byte r7 = (byte) r7
            r11[r14] = r7
            r7 = 0
        L_0x009a:
            int r14 = r9 + r9
            if (r7 >= r14) goto L_0x0108
            int r14 = r10 * 4
            int r14 = r14 + r13
            int r18 = r7 / 8
            int r19 = r7 / 2
            int r19 = r19 % 4
            int r18 = r18 * r10
            int r18 = r18 * 4
            int r18 = r18 + r14
            int r18 = r18 + r19
            byte r14 = r2[r18]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r18 = r7 % 2
            if (r18 != 0) goto L_0x00ba
            r14 = r14 & 15
            goto L_0x00bc
        L_0x00ba:
            int r14 = r14 >> 4
        L_0x00bc:
            r18 = r14 & 7
            int r18 = r18 + r18
            r17 = 1
            int r18 = r18 + 1
            int r18 = r18 * r16
            r16 = r14 & 8
            r19 = r2
            int r2 = r18 >> 3
            if (r16 == 0) goto L_0x00cf
            int r2 = -r2
        L_0x00cf:
            int r12 = r12 + r2
            r2 = 32767(0x7fff, float:4.5916E-41)
            int r2 = java.lang.Math.min(r12, r2)
            r12 = -32768(0xffffffffffff8000, float:NaN)
            int r12 = java.lang.Math.max(r12, r2)
            int r2 = r10 + r10
            int r6 = r6 + r2
            r2 = r12 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r11[r6] = r2
            int r2 = r6 + 1
            r22 = r6
            int r6 = r12 >> 8
            byte r6 = (byte) r6
            r11[r2] = r6
            int[] r2 = zza
            r2 = r2[r14]
            int r15 = r15 + r2
            r2 = 88
            int r6 = java.lang.Math.min(r15, r2)
            r14 = 0
            int r15 = java.lang.Math.max(r14, r6)
            int[] r6 = zzb
            r16 = r6[r15]
            int r7 = r7 + 1
            r6 = r22
            r2 = r19
            goto L_0x009a
        L_0x0108:
            r19 = r2
            r17 = 1
            int r8 = r8 + 1
            goto L_0x0055
        L_0x0110:
            r19 = r2
            r17 = 1
            int r5 = r5 + 1
            goto L_0x0052
        L_0x0118:
            int r2 = r0.zzf
            int r2 = r2 * r1
            int r2 = r0.zze(r2)
            r5 = 0
            r4.zzK(r5)
            r4.zzJ(r2)
            int r2 = r0.zzk
            com.google.android.gms.internal.ads.zzaoa r4 = r0.zze
            int r4 = r4.zzd
            int r1 = r1 * r4
            int r2 = r2 - r1
            r0.zzk = r2
            com.google.android.gms.internal.ads.zzek r1 = r0.zzh
            com.google.android.gms.internal.ads.zzadp r2 = r0.zzd
            int r4 = r1.zze()
            r2.zzq(r1, r4)
            int r1 = r0.zzm
            int r1 = r1 + r4
            r0.zzm = r1
            int r1 = r0.zzd(r1)
            int r2 = r0.zzi
            if (r1 < r2) goto L_0x014b
            r0.zzf(r2)
        L_0x014b:
            if (r3 == 0) goto L_0x0158
            int r1 = r0.zzm
            int r1 = r0.zzd(r1)
            if (r1 <= 0) goto L_0x0158
            r0.zzf(r1)
        L_0x0158:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanw.zzc(com.google.android.gms.internal.ads.zzacl, long):boolean");
    }
}
