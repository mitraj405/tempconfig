package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzadw implements zzack {
    private static final int[] zza = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzb;
    private static final byte[] zzc;
    private static final byte[] zzd;
    private static final int zze;
    private final byte[] zzf;
    private boolean zzg;
    private long zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private zzacn zzo;
    private zzadp zzp;
    private zzadi zzq;
    private boolean zzr;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        zzb = iArr;
        int i = zzet.zza;
        Charset charset = zzfuj.zzc;
        zzc = "#!AMR\n".getBytes(charset);
        zzd = "#!AMR-WB\n".getBytes(charset);
        zze = iArr[8];
    }

    public zzadw() {
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e A[Catch:{ EOFException -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0043 A[Catch:{ EOFException -> 0x00b0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(com.google.android.gms.internal.ads.zzacl r14) throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = "Illegal AMR "
            java.lang.String r1 = "Invalid padding bits for frame header "
            int r2 = r13.zzj
            r3 = -1
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x000c
            goto L_0x005a
        L_0x000c:
            r14.zzj()     // Catch:{ EOFException -> 0x00b0 }
            byte[] r2 = r13.zzf     // Catch:{ EOFException -> 0x00b0 }
            r6 = r14
            com.google.android.gms.internal.ads.zzaby r6 = (com.google.android.gms.internal.ads.zzaby) r6     // Catch:{ EOFException -> 0x00b0 }
            r6.zzm(r2, r5, r4, r5)     // Catch:{ EOFException -> 0x00b0 }
            byte[] r2 = r13.zzf     // Catch:{ EOFException -> 0x00b0 }
            byte r2 = r2[r5]     // Catch:{ EOFException -> 0x00b0 }
            r6 = r2 & 131(0x83, float:1.84E-43)
            r7 = 0
            if (r6 > 0) goto L_0x009f
            int r1 = r2 >> 3
            boolean r2 = r13.zzg     // Catch:{ EOFException -> 0x00b0 }
            r1 = r1 & 15
            if (r2 == 0) goto L_0x0031
            r6 = 10
            if (r1 < r6) goto L_0x003c
            r6 = 13
            if (r1 <= r6) goto L_0x0031
            goto L_0x003c
        L_0x0031:
            if (r2 != 0) goto L_0x007f
            r6 = 12
            if (r1 < r6) goto L_0x003c
            r6 = 14
            if (r1 > r6) goto L_0x003c
            goto L_0x007f
        L_0x003c:
            if (r2 == 0) goto L_0x0043
            int[] r0 = zzb     // Catch:{ EOFException -> 0x00b0 }
            r0 = r0[r1]     // Catch:{ EOFException -> 0x00b0 }
            goto L_0x0047
        L_0x0043:
            int[] r0 = zza     // Catch:{ EOFException -> 0x00b0 }
            r0 = r0[r1]     // Catch:{ EOFException -> 0x00b0 }
        L_0x0047:
            r2 = r0
            r13.zzi = r2     // Catch:{ EOFException -> 0x00b0 }
            r13.zzj = r2
            int r0 = r13.zzl
            if (r0 != r3) goto L_0x0053
            r13.zzl = r2
            r0 = r2
        L_0x0053:
            if (r0 != r2) goto L_0x005a
            int r0 = r13.zzm
            int r0 = r0 + r4
            r13.zzm = r0
        L_0x005a:
            com.google.android.gms.internal.ads.zzadp r0 = r13.zzp
            int r14 = r0.zzf(r14, r2, r4)
            if (r14 != r3) goto L_0x0063
            return r3
        L_0x0063:
            int r0 = r13.zzj
            int r0 = r0 - r14
            r13.zzj = r0
            if (r0 <= 0) goto L_0x006b
            return r5
        L_0x006b:
            com.google.android.gms.internal.ads.zzadp r6 = r13.zzp
            long r7 = r13.zzh
            r9 = 1
            int r10 = r13.zzi
            r11 = 0
            r12 = 0
            r6.zzs(r7, r9, r10, r11, r12)
            long r0 = r13.zzh
            r2 = 20000(0x4e20, double:9.8813E-320)
            long r0 = r0 + r2
            r13.zzh = r0
            return r5
        L_0x007f:
            java.lang.String r14 = "WB"
            java.lang.String r5 = "NB"
            if (r4 == r2) goto L_0x0086
            r14 = r5
        L_0x0086:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x00b0 }
            r2.<init>(r0)     // Catch:{ EOFException -> 0x00b0 }
            r2.append(r14)     // Catch:{ EOFException -> 0x00b0 }
            java.lang.String r14 = " frame type "
            r2.append(r14)     // Catch:{ EOFException -> 0x00b0 }
            r2.append(r1)     // Catch:{ EOFException -> 0x00b0 }
            java.lang.String r14 = r2.toString()     // Catch:{ EOFException -> 0x00b0 }
            com.google.android.gms.internal.ads.zzbo r14 = com.google.android.gms.internal.ads.zzbo.zza(r14, r7)     // Catch:{ EOFException -> 0x00b0 }
            throw r14     // Catch:{ EOFException -> 0x00b0 }
        L_0x009f:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x00b0 }
            r14.<init>(r1)     // Catch:{ EOFException -> 0x00b0 }
            r14.append(r2)     // Catch:{ EOFException -> 0x00b0 }
            java.lang.String r14 = r14.toString()     // Catch:{ EOFException -> 0x00b0 }
            com.google.android.gms.internal.ads.zzbo r14 = com.google.android.gms.internal.ads.zzbo.zza(r14, r7)     // Catch:{ EOFException -> 0x00b0 }
            throw r14     // Catch:{ EOFException -> 0x00b0 }
        L_0x00b0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadw.zza(com.google.android.gms.internal.ads.zzacl):int");
    }

    private static boolean zzg(zzacl zzacl, byte[] bArr) throws IOException {
        zzacl.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        ((zzaby) zzacl).zzm(bArr2, 0, length, false);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzh(zzacl zzacl) throws IOException {
        byte[] bArr = zzc;
        if (zzg(zzacl, bArr)) {
            this.zzg = false;
            ((zzaby) zzacl).zzo(bArr.length, false);
            return true;
        }
        byte[] bArr2 = zzd;
        if (!zzg(zzacl, bArr2)) {
            return false;
        }
        this.zzg = true;
        ((zzaby) zzacl).zzo(bArr2.length, false);
        return true;
    }

    public final int zzb(zzacl zzacl, zzadf zzadf) throws IOException {
        String str;
        int i;
        zzdi.zzb(this.zzp);
        int i2 = zzet.zza;
        if (zzacl.zzf() != 0 || zzh(zzacl)) {
            if (!this.zzr) {
                this.zzr = true;
                boolean z = this.zzg;
                if (true != z) {
                    str = "audio/3gpp";
                } else {
                    str = "audio/amr-wb";
                }
                if (true != z) {
                    i = 8000;
                } else {
                    i = 16000;
                }
                zzadp zzadp = this.zzp;
                zzad zzad = new zzad();
                zzad.zzX(str);
                zzad.zzP(zze);
                zzad.zzy(1);
                zzad.zzY(i);
                zzadp.zzl(zzad.zzad());
            }
            int zza2 = zza(zzacl);
            if (this.zzk) {
                return zza2;
            }
            zzadh zzadh = new zzadh(-9223372036854775807L, 0);
            this.zzq = zzadh;
            this.zzo.zzO(zzadh);
            this.zzk = true;
            return zza2;
        }
        throw zzbo.zza("Could not find AMR header.", (Throwable) null);
    }

    public final /* synthetic */ List zzd() {
        return zzfxr.zzm();
    }

    public final void zze(zzacn zzacn) {
        this.zzo = zzacn;
        this.zzp = zzacn.zzw(0, 1);
        zzacn.zzD();
    }

    public final void zzi(long j, long j2) {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = 0;
        this.zzn = 0;
    }

    public final boolean zzj(zzacl zzacl) throws IOException {
        return zzh(zzacl);
    }

    public zzadw(int i) {
        this.zzf = new byte[1];
        this.zzl = -1;
    }

    public final /* synthetic */ zzack zzc() {
        return this;
    }

    public final void zzf() {
    }
}
