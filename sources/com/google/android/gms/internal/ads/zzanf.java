package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzanf implements zzack {
    private final zzer zza = new zzer(0);
    private final SparseArray zzb = new SparseArray();
    private final zzek zzc = new zzek(4096);
    private final zzand zzd = new zzand();
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private long zzh;
    private zzanc zzi;
    private zzacn zzj;
    private boolean zzk;

    /* JADX WARNING: Removed duplicated region for block: B:59:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r17, com.google.android.gms.internal.ads.zzadf r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            com.google.android.gms.internal.ads.zzacn r3 = r0.zzj
            com.google.android.gms.internal.ads.zzdi.zzb(r3)
            long r10 = r17.zzd()
            r12 = -1
            int r3 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzand r4 = r0.zzd
            boolean r5 = r4.zze()
            if (r5 == 0) goto L_0x001e
            goto L_0x0023
        L_0x001e:
            int r1 = r4.zza(r1, r2)
            return r1
        L_0x0023:
            boolean r4 = r0.zzk
            r14 = 1
            if (r4 != 0) goto L_0x0064
            r0.zzk = r14
            com.google.android.gms.internal.ads.zzand r4 = r0.zzd
            long r5 = r4.zzb()
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 == 0) goto L_0x0054
            com.google.android.gms.internal.ads.zzanc r15 = new com.google.android.gms.internal.ads.zzanc
            com.google.android.gms.internal.ads.zzer r5 = r4.zzd()
            long r6 = r4.zzb()
            r4 = r15
            r8 = r10
            r4.<init>(r5, r6, r8)
            r0.zzi = r15
            com.google.android.gms.internal.ads.zzacn r4 = r0.zzj
            com.google.android.gms.internal.ads.zzadi r5 = r15.zzb()
            r4.zzO(r5)
            goto L_0x0064
        L_0x0054:
            com.google.android.gms.internal.ads.zzacn r5 = r0.zzj
            com.google.android.gms.internal.ads.zzadh r6 = new com.google.android.gms.internal.ads.zzadh
            long r7 = r4.zzb()
            r14 = 0
            r6.<init>(r7, r14)
            r5.zzO(r6)
        L_0x0064:
            com.google.android.gms.internal.ads.zzanc r5 = r0.zzi
            if (r5 == 0) goto L_0x0074
            boolean r6 = r5.zze()
            if (r6 != 0) goto L_0x006f
            goto L_0x0074
        L_0x006f:
            int r1 = r5.zza(r1, r2)
            return r1
        L_0x0074:
            r17.zzj()
            if (r3 == 0) goto L_0x007f
            long r2 = r17.zze()
            long r10 = r10 - r2
            goto L_0x0080
        L_0x007f:
            r10 = r12
        L_0x0080:
            int r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            r3 = -1
            if (r2 == 0) goto L_0x008d
            r5 = 4
            int r2 = (r10 > r5 ? 1 : (r10 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            return r3
        L_0x008d:
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            byte[] r2 = r2.zzM()
            r5 = 4
            r6 = 0
            r4 = 1
            boolean r2 = r1.zzm(r2, r6, r5, r4)
            if (r2 != 0) goto L_0x009d
            return r3
        L_0x009d:
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            r2.zzK(r6)
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            int r2 = r2.zzg()
            r5 = 441(0x1b9, float:6.18E-43)
            if (r2 != r5) goto L_0x00ad
            return r3
        L_0x00ad:
            r3 = 442(0x1ba, float:6.2E-43)
            if (r2 != r3) goto L_0x00d3
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r3 = 10
            r1.zzm(r2, r6, r3, r6)
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            r3 = 9
            r2.zzK(r3)
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            int r2 = r2.zzm()
            r2 = r2 & 7
            int r2 = r2 + 14
            r1.zzo(r2, r6)
            return r6
        L_0x00d3:
            r3 = 443(0x1bb, float:6.21E-43)
            r5 = 2
            r7 = 6
            if (r2 != r3) goto L_0x00f4
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r1.zzm(r2, r6, r5, r6)
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            r2.zzK(r6)
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            int r2 = r2.zzq()
            int r2 = r2 + r7
            r1.zzo(r2, r6)
            return r6
        L_0x00f4:
            int r3 = r2 >> 8
            r4 = 1
            if (r3 == r4) goto L_0x00ff
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r1.zzo(r4, r6)
            return r6
        L_0x00ff:
            r2 = r2 & 255(0xff, float:3.57E-43)
            android.util.SparseArray r3 = r0.zzb
            java.lang.Object r3 = r3.get(r2)
            com.google.android.gms.internal.ads.zzane r3 = (com.google.android.gms.internal.ads.zzane) r3
            boolean r8 = r0.zze
            if (r8 != 0) goto L_0x018a
            if (r3 != 0) goto L_0x016a
            r8 = 189(0xbd, float:2.65E-43)
            r9 = 0
            if (r2 != r8) goto L_0x0124
            com.google.android.gms.internal.ads.zzalx r8 = new com.google.android.gms.internal.ads.zzalx
            r8.<init>(r9, r6)
            r4 = 1
            r0.zzf = r4
            long r9 = r17.zzf()
            r0.zzh = r9
        L_0x0122:
            r9 = r8
            goto L_0x014d
        L_0x0124:
            r4 = 1
            r8 = r2 & 224(0xe0, float:3.14E-43)
            r10 = 192(0xc0, float:2.69E-43)
            if (r8 != r10) goto L_0x0139
            com.google.android.gms.internal.ads.zzamr r8 = new com.google.android.gms.internal.ads.zzamr
            r8.<init>(r9, r6)
            r0.zzf = r4
            long r9 = r17.zzf()
            r0.zzh = r9
            goto L_0x0122
        L_0x0139:
            r8 = r2 & 240(0xf0, float:3.36E-43)
            r10 = 224(0xe0, float:3.14E-43)
            if (r8 != r10) goto L_0x014d
            com.google.android.gms.internal.ads.zzamh r8 = new com.google.android.gms.internal.ads.zzamh
            r8.<init>(r9)
            r0.zzg = r4
            long r9 = r17.zzf()
            r0.zzh = r9
            goto L_0x0122
        L_0x014d:
            if (r9 == 0) goto L_0x016a
            com.google.android.gms.internal.ads.zzans r3 = new com.google.android.gms.internal.ads.zzans
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r10 = 256(0x100, float:3.59E-43)
            r3.<init>(r8, r2, r10)
            com.google.android.gms.internal.ads.zzacn r8 = r0.zzj
            r9.zzb(r8, r3)
            com.google.android.gms.internal.ads.zzer r3 = r0.zza
            com.google.android.gms.internal.ads.zzane r8 = new com.google.android.gms.internal.ads.zzane
            r8.<init>(r9, r3)
            android.util.SparseArray r3 = r0.zzb
            r3.put(r2, r8)
            r3 = r8
        L_0x016a:
            boolean r2 = r0.zzf
            r8 = 1048576(0x100000, double:5.180654E-318)
            if (r2 == 0) goto L_0x017a
            boolean r2 = r0.zzg
            if (r2 == 0) goto L_0x017a
            long r8 = r0.zzh
            r10 = 8192(0x2000, double:4.0474E-320)
            long r8 = r8 + r10
        L_0x017a:
            long r10 = r17.zzf()
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 <= 0) goto L_0x018a
            r2 = 1
            r0.zze = r2
            com.google.android.gms.internal.ads.zzacn r2 = r0.zzj
            r2.zzD()
        L_0x018a:
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r1.zzm(r2, r6, r5, r6)
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            r2.zzK(r6)
            com.google.android.gms.internal.ads.zzek r2 = r0.zzc
            int r2 = r2.zzq()
            int r2 = r2 + r7
            if (r3 != 0) goto L_0x01a7
            r1.zzo(r2, r6)
            goto L_0x01c8
        L_0x01a7:
            com.google.android.gms.internal.ads.zzek r4 = r0.zzc
            r4.zzH(r2)
            com.google.android.gms.internal.ads.zzek r4 = r0.zzc
            byte[] r4 = r4.zzM()
            r1.zzn(r4, r6, r2, r6)
            com.google.android.gms.internal.ads.zzek r1 = r0.zzc
            r1.zzK(r7)
            com.google.android.gms.internal.ads.zzek r1 = r0.zzc
            r3.zza(r1)
            com.google.android.gms.internal.ads.zzek r1 = r0.zzc
            int r2 = r1.zzc()
            r1.zzJ(r2)
        L_0x01c8:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanf.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zzj = zzacn;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
        if (r0 != r7) goto L_0x0021;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034 A[LOOP:0: B:12:0x002c->B:14:0x0034, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(long r5, long r7) {
        /*
            r4 = this;
            com.google.android.gms.internal.ads.zzer r5 = r4.zza
            long r0 = r5.zzf()
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0021
            long r0 = r5.zzd()
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
            int r6 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0024
        L_0x0021:
            r5.zzi(r7)
        L_0x0024:
            com.google.android.gms.internal.ads.zzanc r5 = r4.zzi
            r6 = 0
            if (r5 == 0) goto L_0x002c
            r5.zzd(r7)
        L_0x002c:
            android.util.SparseArray r5 = r4.zzb
            int r5 = r5.size()
            if (r6 >= r5) goto L_0x0042
            android.util.SparseArray r5 = r4.zzb
            java.lang.Object r5 = r5.valueAt(r6)
            com.google.android.gms.internal.ads.zzane r5 = (com.google.android.gms.internal.ads.zzane) r5
            r5.zzb()
            int r6 = r6 + 1
            goto L_0x002c
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzanf.zzi(long, long):void");
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        byte[] bArr = new byte[14];
        zzaby zzaby = (zzaby) zzacl;
        zzaby.zzm(bArr, 0, 14, false);
        byte b = bArr[0] & UnsignedBytes.MAX_VALUE;
        byte b2 = bArr[1] & UnsignedBytes.MAX_VALUE;
        byte b3 = bArr[2] & UnsignedBytes.MAX_VALUE;
        if (((b << Ascii.CAN) | (b2 << Ascii.DLE) | (b3 << 8) | (bArr[3] & UnsignedBytes.MAX_VALUE)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzaby.zzl(bArr[13] & 7, false);
        zzaby.zzm(bArr, 0, 3, false);
        if ((((bArr[0] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[1] & UnsignedBytes.MAX_VALUE) << 8) | (bArr[2] & UnsignedBytes.MAX_VALUE)) == 1) {
            return true;
        }
        return false;
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
