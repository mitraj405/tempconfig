package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzamm implements zzamf {
    private final zzani zza;
    private final zzamx zzb = new zzamx(7, 128);
    private final zzamx zzc = new zzamx(8, 128);
    private final zzamx zzd = new zzamx(6, 128);
    private long zze;
    private final boolean[] zzf = new boolean[3];
    private String zzg;
    private zzadp zzh;
    private zzaml zzi;
    private boolean zzj;
    private long zzk = -9223372036854775807L;
    private boolean zzl;
    private final zzek zzm = new zzek();

    public zzamm(zzani zzani, boolean z, boolean z2) {
        this.zza = zzani;
    }

    private final void zzf(byte[] bArr, int i, int i2) {
        if (!this.zzj) {
            this.zzb.zza(bArr, i, i2);
            this.zzc.zza(bArr, i, i2);
        }
        this.zzd.zza(bArr, i, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01a5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzek r19) {
        /*
            r18 = this;
            r0 = r18
            com.google.android.gms.internal.ads.zzadp r1 = r0.zzh
            com.google.android.gms.internal.ads.zzdi.zzb(r1)
            int r1 = com.google.android.gms.internal.ads.zzet.zza
            int r1 = r19.zzd()
            int r2 = r19.zze()
            byte[] r3 = r19.zzM()
            long r4 = r0.zze
            int r6 = r19.zzb()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zze = r4
            com.google.android.gms.internal.ads.zzadp r4 = r0.zzh
            int r5 = r19.zzb()
            r6 = r19
            r4.zzq(r6, r5)
        L_0x002a:
            boolean[] r4 = r0.zzf
            int r4 = com.google.android.gms.internal.ads.zzfh.zza(r3, r1, r2, r4)
            if (r4 == r2) goto L_0x01b7
            int r5 = r4 + 3
            byte r6 = r3[r5]
            r10 = r6 & 31
            int r6 = r4 - r1
            if (r6 <= 0) goto L_0x003f
            r0.zzf(r3, r1, r4)
        L_0x003f:
            int r1 = r2 - r4
            long r7 = r0.zze
            long r11 = (long) r1
            long r8 = r7 - r11
            if (r6 >= 0) goto L_0x004a
            int r6 = -r6
            goto L_0x004b
        L_0x004a:
            r6 = 0
        L_0x004b:
            long r11 = r0.zzk
            boolean r7 = r0.zzj
            r13 = 4
            if (r7 == 0) goto L_0x0058
        L_0x0052:
            r17 = r2
            r16 = r5
            goto L_0x0160
        L_0x0058:
            com.google.android.gms.internal.ads.zzamx r7 = r0.zzb
            r7.zzd(r6)
            com.google.android.gms.internal.ads.zzamx r7 = r0.zzc
            r7.zzd(r6)
            boolean r7 = r0.zzj
            if (r7 != 0) goto L_0x0125
            com.google.android.gms.internal.ads.zzamx r7 = r0.zzb
            boolean r7 = r7.zze()
            if (r7 == 0) goto L_0x0052
            com.google.android.gms.internal.ads.zzamx r7 = r0.zzc
            boolean r7 = r7.zze()
            if (r7 == 0) goto L_0x0052
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.google.android.gms.internal.ads.zzamx r14 = r0.zzb
            byte[] r15 = r14.zza
            int r14 = r14.zzb
            byte[] r14 = java.util.Arrays.copyOf(r15, r14)
            r7.add(r14)
            com.google.android.gms.internal.ads.zzamx r14 = r0.zzc
            byte[] r15 = r14.zza
            int r14 = r14.zzb
            byte[] r14 = java.util.Arrays.copyOf(r15, r14)
            r7.add(r14)
            com.google.android.gms.internal.ads.zzamx r14 = r0.zzb
            byte[] r15 = r14.zza
            int r14 = r14.zzb
            com.google.android.gms.internal.ads.zzfg r14 = com.google.android.gms.internal.ads.zzfh.zze(r15, r13, r14)
            com.google.android.gms.internal.ads.zzamx r15 = r0.zzc
            byte[] r4 = r15.zza
            int r15 = r15.zzb
            com.google.android.gms.internal.ads.zzff r4 = com.google.android.gms.internal.ads.zzfh.zzd(r4, r13, r15)
            int r15 = r14.zza
            int r13 = r14.zzb
            r16 = r5
            int r5 = r14.zzc
            java.lang.String r5 = com.google.android.gms.internal.ads.zzdk.zza(r15, r13, r5)
            com.google.android.gms.internal.ads.zzadp r13 = r0.zzh
            com.google.android.gms.internal.ads.zzad r15 = new com.google.android.gms.internal.ads.zzad
            r15.<init>()
            r17 = r2
            java.lang.String r2 = r0.zzg
            r15.zzK(r2)
            java.lang.String r2 = "video/avc"
            r15.zzX(r2)
            r15.zzz(r5)
            int r2 = r14.zze
            r15.zzac(r2)
            int r2 = r14.zzf
            r15.zzI(r2)
            com.google.android.gms.internal.ads.zzm r2 = new com.google.android.gms.internal.ads.zzm
            r2.<init>()
            int r5 = r14.zzj
            r2.zzc(r5)
            int r5 = r14.zzk
            r2.zzb(r5)
            int r5 = r14.zzl
            r2.zzd(r5)
            int r5 = r14.zzh
            int r5 = r5 + 8
            r2.zzf(r5)
            int r5 = r14.zzi
            int r5 = r5 + 8
            r2.zza(r5)
            com.google.android.gms.internal.ads.zzo r2 = r2.zzg()
            r15.zzA(r2)
            float r2 = r14.zzg
            r15.zzT(r2)
            r15.zzL(r7)
            com.google.android.gms.internal.ads.zzaf r2 = r15.zzad()
            r13.zzl(r2)
            r2 = 1
            r0.zzj = r2
            com.google.android.gms.internal.ads.zzaml r2 = r0.zzi
            r2.zzc(r14)
            com.google.android.gms.internal.ads.zzaml r2 = r0.zzi
            r2.zzb(r4)
            com.google.android.gms.internal.ads.zzamx r2 = r0.zzb
            r2.zzb()
            com.google.android.gms.internal.ads.zzamx r2 = r0.zzc
            r2.zzb()
            goto L_0x0160
        L_0x0125:
            r17 = r2
            r16 = r5
            com.google.android.gms.internal.ads.zzamx r2 = r0.zzb
            boolean r4 = r2.zze()
            if (r4 == 0) goto L_0x0145
            byte[] r4 = r2.zza
            int r2 = r2.zzb
            r5 = 4
            com.google.android.gms.internal.ads.zzfg r2 = com.google.android.gms.internal.ads.zzfh.zze(r4, r5, r2)
            com.google.android.gms.internal.ads.zzaml r4 = r0.zzi
            r4.zzc(r2)
            com.google.android.gms.internal.ads.zzamx r2 = r0.zzb
            r2.zzb()
            goto L_0x0160
        L_0x0145:
            r5 = 4
            com.google.android.gms.internal.ads.zzamx r2 = r0.zzc
            boolean r4 = r2.zze()
            if (r4 == 0) goto L_0x0160
            byte[] r4 = r2.zza
            int r2 = r2.zzb
            com.google.android.gms.internal.ads.zzff r2 = com.google.android.gms.internal.ads.zzfh.zzd(r4, r5, r2)
            com.google.android.gms.internal.ads.zzaml r4 = r0.zzi
            r4.zzb(r2)
            com.google.android.gms.internal.ads.zzamx r2 = r0.zzc
            r2.zzb()
        L_0x0160:
            com.google.android.gms.internal.ads.zzamx r2 = r0.zzd
            boolean r2 = r2.zzd(r6)
            if (r2 == 0) goto L_0x0188
            com.google.android.gms.internal.ads.zzamx r2 = r0.zzd
            byte[] r4 = r2.zza
            int r2 = r2.zzb
            int r2 = com.google.android.gms.internal.ads.zzfh.zzb(r4, r2)
            com.google.android.gms.internal.ads.zzek r4 = r0.zzm
            com.google.android.gms.internal.ads.zzamx r5 = r0.zzd
            byte[] r5 = r5.zza
            r4.zzI(r5, r2)
            com.google.android.gms.internal.ads.zzek r2 = r0.zzm
            r4 = 4
            r2.zzK(r4)
            com.google.android.gms.internal.ads.zzani r2 = r0.zza
            com.google.android.gms.internal.ads.zzek r4 = r0.zzm
            r2.zza(r11, r4)
        L_0x0188:
            com.google.android.gms.internal.ads.zzaml r2 = r0.zzi
            boolean r4 = r0.zzj
            boolean r1 = r2.zzf(r8, r1, r4)
            if (r1 == 0) goto L_0x0195
            r1 = 0
            r0.zzl = r1
        L_0x0195:
            long r11 = r0.zzk
            boolean r1 = r0.zzj
            if (r1 != 0) goto L_0x01a5
            com.google.android.gms.internal.ads.zzamx r1 = r0.zzb
            r1.zzc(r10)
            com.google.android.gms.internal.ads.zzamx r1 = r0.zzc
            r1.zzc(r10)
        L_0x01a5:
            com.google.android.gms.internal.ads.zzamx r1 = r0.zzd
            r1.zzc(r10)
            com.google.android.gms.internal.ads.zzaml r7 = r0.zzi
            boolean r13 = r0.zzl
            r7.zze(r8, r10, r11, r13)
            r1 = r16
            r2 = r17
            goto L_0x002a
        L_0x01b7:
            r0.zzf(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamm.zza(com.google.android.gms.internal.ads.zzek):void");
    }

    public final void zzb(zzacn zzacn, zzans zzans) {
        zzans.zzc();
        this.zzg = zzans.zzb();
        zzadp zzw = zzacn.zzw(zzans.zza(), 2);
        this.zzh = zzw;
        this.zzi = new zzaml(zzw, false, false);
        this.zza.zzb(zzacn, zzans);
    }

    public final void zzc(boolean z) {
        zzdi.zzb(this.zzh);
        int i = zzet.zza;
        if (z) {
            this.zzi.zza(this.zze);
        }
    }

    public final void zzd(long j, int i) {
        boolean z;
        this.zzk = j;
        int i2 = i & 2;
        boolean z2 = this.zzl;
        if (i2 != 0) {
            z = true;
        } else {
            z = false;
        }
        this.zzl = z | z2;
    }

    public final void zze() {
        this.zze = 0;
        this.zzl = false;
        this.zzk = -9223372036854775807L;
        zzfh.zzf(this.zzf);
        this.zzb.zzb();
        this.zzc.zzb();
        this.zzd.zzb();
        zzaml zzaml = this.zzi;
        if (zzaml != null) {
            zzaml.zzd();
        }
    }
}
