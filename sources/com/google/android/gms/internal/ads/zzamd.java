package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzamd implements zzamf {
    private final zzek zza;
    private final AtomicInteger zzb = new AtomicInteger();
    private final String zzc;
    private final int zzd;
    private String zze;
    private zzadp zzf;
    private int zzg = 0;
    private int zzh;
    private int zzi;
    private long zzj;
    private zzaf zzk;
    private int zzl;
    private int zzm;
    private int zzn = -1;
    private int zzo = -1;
    private long zzp = -9223372036854775807L;

    public zzamd(String str, int i, int i2) {
        this.zza = new zzek(new byte[i2]);
        this.zzc = str;
        this.zzd = i;
    }

    private final void zzf(zzacg zzacg) {
        int i;
        zzad zzad;
        int i2 = zzacg.zzb;
        if (i2 != -2147483647 && (i = zzacg.zzc) != -1) {
            zzaf zzaf = this.zzk;
            if (zzaf == null || i != zzaf.zzz || i2 != zzaf.zzA || !zzet.zzG(zzacg.zza, zzaf.zzm)) {
                zzaf zzaf2 = this.zzk;
                if (zzaf2 == null) {
                    zzad = new zzad();
                } else {
                    zzad = zzaf2.zzb();
                }
                zzad.zzK(this.zze);
                zzad.zzX(zzacg.zza);
                zzad.zzy(zzacg.zzc);
                zzad.zzY(zzacg.zzb);
                zzad.zzO(this.zzc);
                zzad.zzV(this.zzd);
                zzaf zzad2 = zzad.zzad();
                this.zzk = zzad2;
                this.zzf.zzl(zzad2);
            }
        }
    }

    private final boolean zzg(zzek zzek, byte[] bArr, int i) {
        int min = Math.min(zzek.zzb(), i - this.zzh);
        zzek.zzG(bArr, this.zzh, min);
        int i2 = this.zzh + min;
        this.zzh = i2;
        if (i2 == i) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01be  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzek r17) throws com.google.android.gms.internal.ads.zzbo {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.gms.internal.ads.zzadp r2 = r0.zzf
            com.google.android.gms.internal.ads.zzdi.zzb(r2)
        L_0x0009:
            int r2 = r17.zzb()
            if (r2 <= 0) goto L_0x0299
            int r2 = r0.zzg
            r3 = 8
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 4
            r8 = 1
            if (r2 == 0) goto L_0x0209
            r9 = 5
            r10 = 7
            r11 = 6
            if (r2 == r8) goto L_0x0136
            if (r2 == r5) goto L_0x011a
            r12 = 0
            r14 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == r4) goto L_0x00df
            if (r2 == r7) goto L_0x00b2
            if (r2 == r9) goto L_0x0071
            int r2 = r17.zzb()
            int r3 = r0.zzl
            int r4 = r0.zzh
            int r3 = r3 - r4
            int r2 = java.lang.Math.min(r2, r3)
            com.google.android.gms.internal.ads.zzadp r3 = r0.zzf
            r3.zzq(r1, r2)
            int r3 = r0.zzh
            int r3 = r3 + r2
            r0.zzh = r3
            int r2 = r0.zzl
            if (r3 != r2) goto L_0x0009
            long r2 = r0.zzp
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 == 0) goto L_0x0051
            r2 = r8
            goto L_0x0052
        L_0x0051:
            r2 = r6
        L_0x0052:
            com.google.android.gms.internal.ads.zzdi.zzf(r2)
            com.google.android.gms.internal.ads.zzadp r9 = r0.zzf
            long r10 = r0.zzp
            int r2 = r0.zzm
            if (r2 != r7) goto L_0x005f
            r12 = r6
            goto L_0x0060
        L_0x005f:
            r12 = r8
        L_0x0060:
            int r13 = r0.zzl
            r14 = 0
            r15 = 0
            r9.zzs(r10, r12, r13, r14, r15)
            long r2 = r0.zzp
            long r4 = r0.zzj
            long r2 = r2 + r4
            r0.zzp = r2
            r0.zzg = r6
            goto L_0x0009
        L_0x0071:
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            int r3 = r0.zzo
            boolean r2 = r0.zzg(r1, r2, r3)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            java.util.concurrent.atomic.AtomicInteger r3 = r0.zzb
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzacg r2 = com.google.android.gms.internal.ads.zzach.zze(r2, r3)
            int r3 = r0.zzm
            if (r3 != r4) goto L_0x0092
            r0.zzf(r2)
        L_0x0092:
            int r3 = r2.zzd
            r0.zzl = r3
            long r2 = r2.zze
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 != 0) goto L_0x009d
            goto L_0x009e
        L_0x009d:
            r12 = r2
        L_0x009e:
            r0.zzj = r12
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            r2.zzK(r6)
            com.google.android.gms.internal.ads.zzadp r2 = r0.zzf
            com.google.android.gms.internal.ads.zzek r3 = r0.zza
            int r4 = r0.zzo
            r2.zzq(r3, r4)
            r0.zzg = r11
            goto L_0x0009
        L_0x00b2:
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            boolean r2 = r0.zzg(r1, r2, r11)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            int r2 = com.google.android.gms.internal.ads.zzach.zzb(r2)
            r0.zzo = r2
            int r3 = r0.zzh
            if (r3 <= r2) goto L_0x00db
            int r2 = r3 - r2
            int r3 = r3 - r2
            r0.zzh = r3
            int r3 = r17.zzd()
            int r3 = r3 - r2
            r1.zzK(r3)
        L_0x00db:
            r0.zzg = r9
            goto L_0x0009
        L_0x00df:
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            int r3 = r0.zzn
            boolean r2 = r0.zzg(r1, r2, r3)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzacg r2 = com.google.android.gms.internal.ads.zzach.zzd(r2)
            r0.zzf(r2)
            int r3 = r2.zzd
            r0.zzl = r3
            long r2 = r2.zze
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 != 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r12 = r2
        L_0x0106:
            r0.zzj = r12
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            r2.zzK(r6)
            com.google.android.gms.internal.ads.zzadp r2 = r0.zzf
            com.google.android.gms.internal.ads.zzek r3 = r0.zza
            int r4 = r0.zzn
            r2.zzq(r3, r4)
            r0.zzg = r11
            goto L_0x0009
        L_0x011a:
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            boolean r2 = r0.zzg(r1, r2, r10)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            int r2 = com.google.android.gms.internal.ads.zzach.zza(r2)
            r0.zzn = r2
            r0.zzg = r4
            goto L_0x0009
        L_0x0136:
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            r12 = 18
            boolean r2 = r0.zzg(r1, r2, r12)
            if (r2 == 0) goto L_0x0009
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            byte[] r2 = r2.zzM()
            com.google.android.gms.internal.ads.zzaf r13 = r0.zzk
            if (r13 != 0) goto L_0x0160
            java.lang.String r13 = r0.zze
            java.lang.String r14 = r0.zzc
            int r15 = r0.zzd
            r12 = 0
            com.google.android.gms.internal.ads.zzaf r12 = com.google.android.gms.internal.ads.zzach.zzc(r2, r13, r14, r15, r12)
            r0.zzk = r12
            com.google.android.gms.internal.ads.zzadp r13 = r0.zzf
            r13.zzl(r12)
        L_0x0160:
            byte r12 = r2[r6]
            r13 = 31
            r14 = -1
            r15 = -2
            if (r12 == r15) goto L_0x01a1
            if (r12 == r14) goto L_0x018b
            if (r12 == r13) goto L_0x0179
            byte r3 = r2[r9]
            r3 = r3 & r4
            int r3 = r3 << 12
            byte r4 = r2[r11]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r7
            byte r6 = r2[r10]
            goto L_0x01ad
        L_0x0179:
            byte r6 = r2[r11]
            r4 = r4 & r6
            int r4 = r4 << 12
            byte r6 = r2[r10]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r6 = r6 << r7
            byte r3 = r2[r3]
            r3 = r3 & 60
            int r3 = r3 >> r5
            r4 = r4 | r6
            r3 = r3 | r4
            goto L_0x019e
        L_0x018b:
            byte r3 = r2[r10]
            r3 = r3 & r4
            int r3 = r3 << 12
            byte r4 = r2[r11]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r7
            r6 = 9
            byte r6 = r2[r6]
            r6 = r6 & 60
            int r6 = r6 >> r5
            r3 = r3 | r4
            r3 = r3 | r6
        L_0x019e:
            int r3 = r3 + r8
            r4 = r8
            goto L_0x01b4
        L_0x01a1:
            byte r3 = r2[r7]
            r3 = r3 & r4
            int r3 = r3 << 12
            byte r4 = r2[r10]
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << r7
            byte r6 = r2[r11]
        L_0x01ad:
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r7
            r3 = r3 | r4
            r3 = r3 | r6
            int r3 = r3 + r8
            r4 = 0
        L_0x01b4:
            if (r4 == 0) goto L_0x01ba
            int r3 = r3 * 16
            int r3 = r3 / 14
        L_0x01ba:
            r0.zzl = r3
            if (r12 == r15) goto L_0x01d9
            if (r12 == r14) goto L_0x01d0
            if (r12 == r13) goto L_0x01c9
            byte r3 = r2[r7]
            r3 = r3 & r8
            int r3 = r3 << r11
            byte r2 = r2[r9]
            goto L_0x01df
        L_0x01c9:
            byte r3 = r2[r9]
            r3 = r3 & r10
            int r3 = r3 << r7
            byte r2 = r2[r11]
            goto L_0x01d6
        L_0x01d0:
            byte r3 = r2[r7]
            r3 = r3 & r10
            int r3 = r3 << r7
            byte r2 = r2[r10]
        L_0x01d6:
            r2 = r2 & 60
            goto L_0x01e1
        L_0x01d9:
            byte r3 = r2[r9]
            r3 = r3 & r8
            int r3 = r3 << r11
            byte r2 = r2[r7]
        L_0x01df:
            r2 = r2 & 252(0xfc, float:3.53E-43)
        L_0x01e1:
            int r2 = r2 >> r5
            r2 = r2 | r3
            int r2 = r2 + r8
            com.google.android.gms.internal.ads.zzaf r3 = r0.zzk
            int r3 = r3.zzA
            int r2 = r2 * 32
            long r4 = (long) r2
            long r2 = com.google.android.gms.internal.ads.zzet.zzs(r4, r3)
            int r2 = com.google.android.gms.internal.ads.zzgap.zzb(r2)
            long r2 = (long) r2
            r0.zzj = r2
            com.google.android.gms.internal.ads.zzek r2 = r0.zza
            r3 = 0
            r2.zzK(r3)
            com.google.android.gms.internal.ads.zzadp r2 = r0.zzf
            com.google.android.gms.internal.ads.zzek r3 = r0.zza
            r4 = 18
            r2.zzq(r3, r4)
            r0.zzg = r11
            goto L_0x0009
        L_0x0209:
            int r2 = r17.zzb()
            if (r2 <= 0) goto L_0x0009
            int r2 = r0.zzi
            int r2 = r2 << r3
            r0.zzi = r2
            int r6 = r17.zzm()
            r2 = r2 | r6
            r0.zzi = r2
            r6 = 2147385345(0x7ffe8001, float:NaN)
            if (r2 == r6) goto L_0x0259
            r6 = -25230976(0xfffffffffe7f0180, float:-8.474023E37)
            if (r2 == r6) goto L_0x0259
            r6 = 536864768(0x1fffe800, float:1.0838051E-19)
            if (r2 == r6) goto L_0x0259
            r6 = -14745368(0xffffffffff1f00e8, float:-2.1135196E38)
            if (r2 != r6) goto L_0x0230
            goto L_0x0259
        L_0x0230:
            r6 = 1683496997(0x64582025, float:1.5947252E22)
            if (r2 == r6) goto L_0x0257
            r6 = 622876772(0x25205864, float:1.3907736E-16)
            if (r2 != r6) goto L_0x023b
            goto L_0x0257
        L_0x023b:
            r6 = 1078008818(0x40411bf2, float:3.0173306)
            if (r2 == r6) goto L_0x0255
            r6 = -233094848(0xfffffffff21b4140, float:-3.0751398E30)
            if (r2 != r6) goto L_0x0246
            goto L_0x0255
        L_0x0246:
            r6 = 1908687592(0x71c442e8, float:1.9436783E30)
            if (r2 == r6) goto L_0x0253
            r6 = -398277519(0xffffffffe842c471, float:-3.6790512E24)
            if (r2 != r6) goto L_0x0251
            goto L_0x0253
        L_0x0251:
            r2 = 0
            goto L_0x025a
        L_0x0253:
            r2 = r7
            goto L_0x025a
        L_0x0255:
            r2 = r4
            goto L_0x025a
        L_0x0257:
            r2 = r5
            goto L_0x025a
        L_0x0259:
            r2 = r8
        L_0x025a:
            r0.zzm = r2
            if (r2 == 0) goto L_0x0209
            com.google.android.gms.internal.ads.zzek r3 = r0.zza
            byte[] r3 = r3.zzM()
            int r6 = r0.zzi
            int r9 = r6 >> 24
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r10 = 0
            r3[r10] = r9
            int r9 = r6 >> 16
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r3[r8] = r9
            int r9 = r6 >> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r3[r5] = r9
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = (byte) r6
            r3[r4] = r6
            r0.zzh = r7
            r6 = 0
            r0.zzi = r6
            if (r2 == r4) goto L_0x0295
            if (r2 != r7) goto L_0x028b
            goto L_0x0295
        L_0x028b:
            if (r2 != r8) goto L_0x0291
            r0.zzg = r8
            goto L_0x0009
        L_0x0291:
            r0.zzg = r5
            goto L_0x0009
        L_0x0295:
            r0.zzg = r7
            goto L_0x0009
        L_0x0299:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamd.zza(com.google.android.gms.internal.ads.zzek):void");
    }

    public final void zzb(zzacn zzacn, zzans zzans) {
        zzans.zzc();
        this.zze = zzans.zzb();
        this.zzf = zzacn.zzw(zzans.zza(), 1);
    }

    public final void zzd(long j, int i) {
        this.zzp = j;
    }

    public final void zze() {
        this.zzg = 0;
        this.zzh = 0;
        this.zzi = 0;
        this.zzp = -9223372036854775807L;
        this.zzb.set(0);
    }

    public final void zzc(boolean z) {
    }
}
