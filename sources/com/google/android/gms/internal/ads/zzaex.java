package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaex implements zzack {
    private final zzek zza = new zzek(6);
    private zzacn zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private long zzf = -1;
    private zzagr zzg;
    private zzacl zzh;
    private zzafa zzi;
    private zzaiq zzj;

    private final int zza(zzacl zzacl) throws IOException {
        this.zza.zzH(2);
        ((zzaby) zzacl).zzm(this.zza.zzM(), 0, 2, false);
        return this.zza.zzq();
    }

    private final void zzg() {
        zzacn zzacn = this.zzb;
        zzacn.getClass();
        zzacn.zzD();
        this.zzb.zzO(new zzadh(-9223372036854775807L, 0));
        this.zzc = 6;
    }

    /* JADX WARNING: Removed duplicated region for block: B:79:0x0186  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(com.google.android.gms.internal.ads.zzacl r24, com.google.android.gms.internal.ads.zzadf r25) throws java.io.IOException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            int r3 = r0.zzc
            r4 = 4
            r5 = -1
            r7 = 2
            r8 = 1
            r9 = 0
            if (r3 == 0) goto L_0x01b7
            if (r3 == r8) goto L_0x0199
            r10 = -1
            if (r3 == r7) goto L_0x00d6
            r5 = 5
            if (r3 == r4) goto L_0x004c
            if (r3 == r5) goto L_0x0024
            r1 = 6
            if (r3 != r1) goto L_0x001e
            return r10
        L_0x001e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0024:
            com.google.android.gms.internal.ads.zzafa r3 = r0.zzi
            if (r3 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzacl r3 = r0.zzh
            if (r1 == r3) goto L_0x0037
        L_0x002c:
            r0.zzh = r1
            com.google.android.gms.internal.ads.zzafa r3 = new com.google.android.gms.internal.ads.zzafa
            long r4 = r0.zzf
            r3.<init>(r1, r4)
            r0.zzi = r3
        L_0x0037:
            com.google.android.gms.internal.ads.zzaiq r1 = r0.zzj
            r1.getClass()
            com.google.android.gms.internal.ads.zzafa r3 = r0.zzi
            int r1 = r1.zzb(r3, r2)
            if (r1 != r8) goto L_0x004b
            long r3 = r2.zza
            long r5 = r0.zzf
            long r3 = r3 + r5
            r2.zza = r3
        L_0x004b:
            return r1
        L_0x004c:
            long r6 = r24.zzf()
            long r10 = r0.zzf
            int r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r3 != 0) goto L_0x00d3
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            boolean r2 = r1.zzm(r2, r9, r8, r8)
            if (r2 != 0) goto L_0x0066
            r23.zzg()
            goto L_0x00d2
        L_0x0066:
            r24.zzj()
            com.google.android.gms.internal.ads.zzaiq r2 = r0.zzj
            if (r2 != 0) goto L_0x0078
            com.google.android.gms.internal.ads.zzaiq r2 = new com.google.android.gms.internal.ads.zzaiq
            com.google.android.gms.internal.ads.zzajy r3 = com.google.android.gms.internal.ads.zzajy.zza
            r6 = 8
            r2.<init>(r3, r6)
            r0.zzj = r2
        L_0x0078:
            com.google.android.gms.internal.ads.zzafa r2 = new com.google.android.gms.internal.ads.zzafa
            long r6 = r0.zzf
            r2.<init>(r1, r6)
            r0.zzi = r2
            com.google.android.gms.internal.ads.zzaiq r1 = r0.zzj
            boolean r1 = r1.zzj(r2)
            if (r1 == 0) goto L_0x00cf
            com.google.android.gms.internal.ads.zzaiq r1 = r0.zzj
            com.google.android.gms.internal.ads.zzafc r2 = new com.google.android.gms.internal.ads.zzafc
            long r6 = r0.zzf
            com.google.android.gms.internal.ads.zzacn r3 = r0.zzb
            r3.getClass()
            r2.<init>(r6, r3)
            r1.zze(r2)
            com.google.android.gms.internal.ads.zzagr r1 = r0.zzg
            r1.getClass()
            com.google.android.gms.internal.ads.zzacn r2 = r0.zzb
            r2.getClass()
            r3 = 1024(0x400, float:1.435E-42)
            com.google.android.gms.internal.ads.zzadp r2 = r2.zzw(r3, r4)
            com.google.android.gms.internal.ads.zzad r3 = new com.google.android.gms.internal.ads.zzad
            r3.<init>()
            java.lang.String r4 = "image/jpeg"
            r3.zzB(r4)
            com.google.android.gms.internal.ads.zzbk r4 = new com.google.android.gms.internal.ads.zzbk
            com.google.android.gms.internal.ads.zzbj[] r6 = new com.google.android.gms.internal.ads.zzbj[r8]
            r6[r9] = r1
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4.<init>(r7, r6)
            r3.zzQ(r4)
            com.google.android.gms.internal.ads.zzaf r1 = r3.zzad()
            r2.zzl(r1)
            r0.zzc = r5
            goto L_0x00d2
        L_0x00cf:
            r23.zzg()
        L_0x00d2:
            return r9
        L_0x00d3:
            r2.zza = r10
            return r8
        L_0x00d6:
            int r2 = r0.zzd
            r3 = 65505(0xffe1, float:9.1792E-41)
            if (r2 != r3) goto L_0x018e
            com.google.android.gms.internal.ads.zzek r2 = new com.google.android.gms.internal.ads.zzek
            int r3 = r0.zze
            r2.<init>((int) r3)
            byte[] r3 = r2.zzM()
            int r4 = r0.zze
            r8 = r1
            com.google.android.gms.internal.ads.zzaby r8 = (com.google.android.gms.internal.ads.zzaby) r8
            r8.zzn(r3, r9, r4, r9)
            com.google.android.gms.internal.ads.zzagr r3 = r0.zzg
            if (r3 != 0) goto L_0x018c
            java.lang.String r3 = r2.zzx(r9)
            java.lang.String r4 = "http://ns.adobe.com/xap/1.0/"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x018c
            java.lang.String r2 = r2.zzx(r9)
            if (r2 == 0) goto L_0x018c
            long r3 = r24.zzd()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0111
        L_0x010e:
            r8 = 0
            goto L_0x0182
        L_0x0111:
            com.google.android.gms.internal.ads.zzaez r1 = com.google.android.gms.internal.ads.zzafd.zza(r2)
            if (r1 != 0) goto L_0x0118
            goto L_0x010e
        L_0x0118:
            java.util.List r2 = r1.zzb
            int r2 = r2.size()
            if (r2 >= r7) goto L_0x0121
            goto L_0x010e
        L_0x0121:
            java.util.List r2 = r1.zzb
            int r2 = r2.size()
            int r2 = r2 + r10
            r11 = r5
            r13 = r11
            r17 = r13
            r19 = r17
            r7 = r9
        L_0x012f:
            if (r2 < 0) goto L_0x0168
            java.util.List r10 = r1.zzb
            java.lang.Object r10 = r10.get(r2)
            com.google.android.gms.internal.ads.zzaey r10 = (com.google.android.gms.internal.ads.zzaey) r10
            java.lang.String r15 = r10.zza
            java.lang.String r8 = "video/mp4"
            boolean r8 = r8.equals(r15)
            r7 = r7 | r8
            if (r2 != 0) goto L_0x014a
            long r9 = r10.zzc
            long r3 = r3 - r9
            r8 = 0
            goto L_0x014e
        L_0x014a:
            long r8 = r10.zzb
            long r8 = r3 - r8
        L_0x014e:
            r21 = r3
            r3 = r8
            r8 = r21
            if (r7 == 0) goto L_0x015e
            int r10 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x015e
            long r19 = r8 - r3
            r17 = r3
            r7 = 0
        L_0x015e:
            if (r2 != 0) goto L_0x0161
            r13 = r8
        L_0x0161:
            if (r2 != 0) goto L_0x0164
            r11 = r3
        L_0x0164:
            int r2 = r2 + -1
            r9 = 0
            goto L_0x012f
        L_0x0168:
            int r2 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x010e
            int r2 = (r19 > r5 ? 1 : (r19 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x010e
            int r2 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x010e
            int r2 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x0179
            goto L_0x010e
        L_0x0179:
            long r1 = r1.zza
            com.google.android.gms.internal.ads.zzagr r8 = new com.google.android.gms.internal.ads.zzagr
            r10 = r8
            r15 = r1
            r10.<init>(r11, r13, r15, r17, r19)
        L_0x0182:
            r0.zzg = r8
            if (r8 == 0) goto L_0x018a
            long r1 = r8.zzd
            r0.zzf = r1
        L_0x018a:
            r3 = 0
            goto L_0x0196
        L_0x018c:
            r3 = r9
            goto L_0x0196
        L_0x018e:
            int r2 = r0.zze
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r3 = 0
            r1.zzo(r2, r3)
        L_0x0196:
            r0.zzc = r3
            return r3
        L_0x0199:
            r3 = r9
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            r2.zzH(r7)
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r1.zzn(r2, r3, r7, r3)
            com.google.android.gms.internal.ads.zzek r1 = r0.zza
            int r1 = r1.zzq()
            int r1 = r1 + -2
            r0.zze = r1
            r0.zzc = r7
            return r3
        L_0x01b7:
            r3 = r9
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            r2.zzH(r7)
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzaby r1 = (com.google.android.gms.internal.ads.zzaby) r1
            r1.zzn(r2, r3, r7, r3)
            com.google.android.gms.internal.ads.zzek r1 = r0.zza
            int r1 = r1.zzq()
            r0.zzd = r1
            r2 = 65498(0xffda, float:9.1782E-41)
            if (r1 != r2) goto L_0x01e2
            long r1 = r0.zzf
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x01de
            r0.zzc = r4
            goto L_0x01f3
        L_0x01de:
            r23.zzg()
            goto L_0x01f3
        L_0x01e2:
            r2 = 65488(0xffd0, float:9.1768E-41)
            if (r1 < r2) goto L_0x01ec
            r2 = 65497(0xffd9, float:9.1781E-41)
            if (r1 <= r2) goto L_0x01f3
        L_0x01ec:
            r2 = 65281(0xff01, float:9.1478E-41)
            if (r1 == r2) goto L_0x01f3
            r0.zzc = r8
        L_0x01f3:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaex.zzb(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf):int");
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zzb = zzacn;
    }

    public final void zzi(long j, long j2) {
        if (j == 0) {
            this.zzc = 0;
            this.zzj = null;
        } else if (this.zzc == 5) {
            zzaiq zzaiq = this.zzj;
            zzaiq.getClass();
            zzaiq.zzi(j, j2);
        }
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        if (zza(zzacl) != 65496) {
            return false;
        }
        int zza2 = zza(zzacl);
        this.zzd = zza2;
        if (zza2 == 65504) {
            this.zza.zzH(2);
            zzaby zzaby = (zzaby) zzacl;
            zzaby.zzm(this.zza.zzM(), 0, 2, false);
            zzaby.zzl(this.zza.zzq() - 2, false);
            zza2 = zza(zzacl);
            this.zzd = zza2;
        }
        if (zza2 == 65505) {
            zzaby zzaby2 = (zzaby) zzacl;
            zzaby2.zzl(2, false);
            this.zza.zzH(6);
            zzaby2.zzm(this.zza.zzM(), 0, 6, false);
            if (this.zza.zzu() == 1165519206 && this.zza.zzq() == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
