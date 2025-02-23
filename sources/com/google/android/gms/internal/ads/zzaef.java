package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaef implements zzadx {
    public final zzfxr zza;
    private final int zzb;

    private zzaef(int i, zzfxr zzfxr) {
        this.zzb = i;
        this.zza = zzfxr;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzaef zzc(int r16, com.google.android.gms.internal.ads.zzek r17) {
        /*
            r0 = r17
            com.google.android.gms.internal.ads.zzfxo r1 = new com.google.android.gms.internal.ads.zzfxo
            r1.<init>()
            int r2 = r17.zze()
            r3 = -2
        L_0x000c:
            int r4 = r17.zzb()
            r5 = 8
            if (r4 <= r5) goto L_0x016d
            int r4 = r17.zzi()
            int r5 = r17.zzi()
            int r6 = r17.zzd()
            int r6 = r6 + r5
            r0.zzJ(r6)
            r5 = 1414744396(0x5453494c, float:3.62987127E12)
            r7 = 2
            r8 = 1
            if (r4 != r5) goto L_0x0035
            int r4 = r17.zzi()
            com.google.android.gms.internal.ads.zzaef r4 = zzc(r4, r0)
            goto L_0x0129
        L_0x0035:
            r5 = 0
            switch(r4) {
                case 1718776947: goto L_0x004d;
                case 1751742049: goto L_0x0047;
                case 1752331379: goto L_0x0041;
                case 1852994675: goto L_0x003b;
                default: goto L_0x0039;
            }
        L_0x0039:
            goto L_0x0128
        L_0x003b:
            com.google.android.gms.internal.ads.zzaeh r4 = com.google.android.gms.internal.ads.zzaeh.zzb(r17)
            goto L_0x0129
        L_0x0041:
            com.google.android.gms.internal.ads.zzaed r4 = com.google.android.gms.internal.ads.zzaed.zzb(r17)
            goto L_0x0129
        L_0x0047:
            com.google.android.gms.internal.ads.zzaec r4 = com.google.android.gms.internal.ads.zzaec.zzb(r17)
            goto L_0x0129
        L_0x004d:
            java.lang.String r4 = "StreamFormatChunk"
            if (r3 != r7) goto L_0x0099
            r9 = 4
            r0.zzL(r9)
            int r10 = r17.zzi()
            int r11 = r17.zzi()
            r0.zzL(r9)
            int r9 = r17.zzi()
            switch(r9) {
                case 808802372: goto L_0x0075;
                case 826496577: goto L_0x0072;
                case 828601953: goto L_0x0072;
                case 842289229: goto L_0x006f;
                case 859066445: goto L_0x006c;
                case 875967048: goto L_0x0072;
                case 877677894: goto L_0x0075;
                case 1145656883: goto L_0x0075;
                case 1145656920: goto L_0x0075;
                case 1196444237: goto L_0x0069;
                case 1482049860: goto L_0x0075;
                case 1684633208: goto L_0x0075;
                case 1735420525: goto L_0x0069;
                case 2021026148: goto L_0x0075;
                default: goto L_0x0067;
            }
        L_0x0067:
            r12 = r5
            goto L_0x0077
        L_0x0069:
            java.lang.String r12 = "video/mjpeg"
            goto L_0x0077
        L_0x006c:
            java.lang.String r12 = "video/mp43"
            goto L_0x0077
        L_0x006f:
            java.lang.String r12 = "video/mp42"
            goto L_0x0077
        L_0x0072:
            java.lang.String r12 = "video/avc"
            goto L_0x0077
        L_0x0075:
            java.lang.String r12 = "video/mp4v-es"
        L_0x0077:
            if (r12 != 0) goto L_0x0080
            java.lang.String r10 = "Ignoring track with unsupported compression "
            defpackage.C0709Uj.t(r10, r9, r4)
            goto L_0x0128
        L_0x0080:
            com.google.android.gms.internal.ads.zzad r4 = new com.google.android.gms.internal.ads.zzad
            r4.<init>()
            r4.zzac(r10)
            r4.zzI(r11)
            r4.zzX(r12)
            com.google.android.gms.internal.ads.zzaeg r5 = new com.google.android.gms.internal.ads.zzaeg
            com.google.android.gms.internal.ads.zzaf r4 = r4.zzad()
            r5.<init>(r4)
            goto L_0x0128
        L_0x0099:
            if (r3 != r8) goto L_0x011b
            int r9 = r17.zzk()
            java.lang.String r10 = "audio/mp4a-latm"
            java.lang.String r11 = "audio/raw"
            if (r9 == r8) goto L_0x00c2
            r12 = 85
            if (r9 == r12) goto L_0x00bf
            r12 = 255(0xff, float:3.57E-43)
            if (r9 == r12) goto L_0x00bd
            r12 = 8192(0x2000, float:1.14794E-41)
            if (r9 == r12) goto L_0x00ba
            r12 = 8193(0x2001, float:1.1481E-41)
            if (r9 == r12) goto L_0x00b7
            r12 = r5
            goto L_0x00c3
        L_0x00b7:
            java.lang.String r12 = "audio/vnd.dts"
            goto L_0x00c3
        L_0x00ba:
            java.lang.String r12 = "audio/ac3"
            goto L_0x00c3
        L_0x00bd:
            r12 = r10
            goto L_0x00c3
        L_0x00bf:
            java.lang.String r12 = "audio/mpeg"
            goto L_0x00c3
        L_0x00c2:
            r12 = r11
        L_0x00c3:
            if (r12 != 0) goto L_0x00cb
            java.lang.String r10 = "Ignoring track with unsupported format tag "
            defpackage.C0709Uj.t(r10, r9, r4)
            goto L_0x0128
        L_0x00cb:
            int r4 = r17.zzk()
            int r5 = r17.zzi()
            r9 = 6
            r0.zzL(r9)
            int r9 = r17.zzq()
            int r9 = com.google.android.gms.internal.ads.zzet.zzl(r9)
            int r13 = r17.zzk()
            byte[] r14 = new byte[r13]
            r15 = 0
            r0.zzG(r14, r15, r13)
            com.google.android.gms.internal.ads.zzad r15 = new com.google.android.gms.internal.ads.zzad
            r15.<init>()
            r15.zzX(r12)
            r15.zzy(r4)
            r15.zzY(r5)
            boolean r4 = r11.equals(r12)
            if (r4 == 0) goto L_0x0102
            if (r9 == 0) goto L_0x0102
            r15.zzR(r9)
        L_0x0102:
            boolean r4 = r10.equals(r12)
            if (r4 == 0) goto L_0x0111
            if (r13 <= 0) goto L_0x0111
            com.google.android.gms.internal.ads.zzfxr r4 = com.google.android.gms.internal.ads.zzfxr.zzn(r14)
            r15.zzL(r4)
        L_0x0111:
            com.google.android.gms.internal.ads.zzaeg r4 = new com.google.android.gms.internal.ads.zzaeg
            com.google.android.gms.internal.ads.zzaf r5 = r15.zzad()
            r4.<init>(r5)
            goto L_0x0129
        L_0x011b:
            java.lang.String r9 = "Ignoring strf box for unsupported track type: "
            java.lang.String r10 = com.google.android.gms.internal.ads.zzet.zzC(r3)
            java.lang.String r9 = r9.concat(r10)
            com.google.android.gms.internal.ads.zzea.zzf(r4, r9)
        L_0x0128:
            r4 = r5
        L_0x0129:
            if (r4 == 0) goto L_0x0165
            int r5 = r4.zza()
            r9 = 1752331379(0x68727473, float:4.5798432E24)
            if (r5 != r9) goto L_0x0162
            r3 = r4
            com.google.android.gms.internal.ads.zzaed r3 = (com.google.android.gms.internal.ads.zzaed) r3
            int r3 = r3.zza
            r5 = 1935960438(0x73646976, float:1.809666E31)
            if (r3 == r5) goto L_0x0161
            r5 = 1935963489(0x73647561, float:1.8100348E31)
            if (r3 == r5) goto L_0x015f
            r5 = 1937012852(0x73747874, float:1.936895E31)
            if (r3 == r5) goto L_0x015d
            java.lang.String r3 = java.lang.Integer.toHexString(r3)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r5 = "AviStreamHeaderChunk"
            java.lang.String r7 = "Found unsupported streamType fourCC: "
            java.lang.String r3 = r7.concat(r3)
            com.google.android.gms.internal.ads.zzea.zzf(r5, r3)
            r3 = -1
            goto L_0x0162
        L_0x015d:
            r3 = 3
            goto L_0x0162
        L_0x015f:
            r3 = r8
            goto L_0x0162
        L_0x0161:
            r3 = r7
        L_0x0162:
            r1.zzf(r4)
        L_0x0165:
            r0.zzK(r6)
            r0.zzJ(r2)
            goto L_0x000c
        L_0x016d:
            com.google.android.gms.internal.ads.zzaef r0 = new com.google.android.gms.internal.ads.zzaef
            com.google.android.gms.internal.ads.zzfxr r1 = r1.zzi()
            r2 = r16
            r0.<init>(r2, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaef.zzc(int, com.google.android.gms.internal.ads.zzek):com.google.android.gms.internal.ads.zzaef");
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzadx zzb(Class cls) {
        zzfxr zzfxr = this.zza;
        int size = zzfxr.size();
        int i = 0;
        while (i < size) {
            zzadx zzadx = (zzadx) zzfxr.get(i);
            i++;
            if (zzadx.getClass() == cls) {
                return zzadx;
            }
        }
        return null;
    }
}
