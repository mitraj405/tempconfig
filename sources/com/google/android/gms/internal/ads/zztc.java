package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zztc {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap zzc = new HashMap();

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:457:?, code lost:
        return r1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair zza(com.google.android.gms.internal.ads.zzaf r19) {
        /*
            r0 = r19
            java.lang.String r1 = r0.zzj
            if (r1 != 0) goto L_0x0008
            goto L_0x0748
        L_0x0008:
            java.lang.String r2 = "\\."
            java.lang.String[] r1 = r1.split(r2)
            java.lang.String r2 = r0.zzm
            java.lang.String r3 = "video/dolby-vision"
            boolean r2 = r3.equals(r2)
            r3 = 1024(0x400, float:1.435E-42)
            r4 = 512(0x200, float:7.175E-43)
            r5 = 256(0x100, float:3.59E-43)
            r6 = 128(0x80, float:1.794E-43)
            r7 = 64
            r8 = 32
            r9 = 8
            r10 = 3
            r11 = 16
            r12 = 4
            r13 = 2
            java.lang.String r14 = "MediaCodecUtil"
            r15 = 1
            if (r2 == 0) goto L_0x01d5
            java.lang.String r0 = r0.zzj
            int r2 = r1.length
            if (r2 >= r10) goto L_0x003a
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            defpackage.lf.w(r0, r1, r14)
            goto L_0x0748
        L_0x003a:
            java.util.regex.Pattern r2 = zzb
            r10 = r1[r15]
            java.util.regex.Matcher r2 = r2.matcher(r10)
            boolean r10 = r2.matches()
            if (r10 != 0) goto L_0x004f
            java.lang.String r1 = "Ignoring malformed Dolby Vision codec string: "
            defpackage.lf.w(r0, r1, r14)
            goto L_0x0748
        L_0x004f:
            java.lang.String r0 = r2.group(r15)
            if (r0 != 0) goto L_0x0057
            goto L_0x00f6
        L_0x0057:
            int r2 = r0.hashCode()
            r10 = 1567(0x61f, float:2.196E-42)
            if (r2 == r10) goto L_0x00e9
            switch(r2) {
                case 1536: goto L_0x00dc;
                case 1537: goto L_0x00cf;
                case 1538: goto L_0x00c2;
                case 1539: goto L_0x00b5;
                case 1540: goto L_0x00a8;
                case 1541: goto L_0x009b;
                case 1542: goto L_0x008e;
                case 1543: goto L_0x0080;
                case 1544: goto L_0x0072;
                case 1545: goto L_0x0064;
                default: goto L_0x0062;
            }
        L_0x0062:
            goto L_0x00f6
        L_0x0064:
            java.lang.String r2 = "09"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            goto L_0x00f7
        L_0x0072:
            java.lang.String r2 = "08"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            goto L_0x00f7
        L_0x0080:
            java.lang.String r2 = "07"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            goto L_0x00f7
        L_0x008e:
            java.lang.String r2 = "06"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x00f7
        L_0x009b:
            java.lang.String r2 = "05"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x00f7
        L_0x00a8:
            java.lang.String r2 = "04"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            goto L_0x00f7
        L_0x00b5:
            java.lang.String r2 = "03"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            goto L_0x00f7
        L_0x00c2:
            java.lang.String r2 = "02"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            goto L_0x00f7
        L_0x00cf:
            java.lang.String r2 = "01"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            goto L_0x00f7
        L_0x00dc:
            java.lang.String r2 = "00"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
            goto L_0x00f7
        L_0x00e9:
            java.lang.String r2 = "10"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00f6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            goto L_0x00f7
        L_0x00f6:
            r2 = 0
        L_0x00f7:
            if (r2 != 0) goto L_0x0100
            java.lang.String r1 = "Unknown Dolby Vision profile string: "
            defpackage.lf.w(r0, r1, r14)
            goto L_0x0748
        L_0x0100:
            r0 = r1[r13]
            if (r0 != 0) goto L_0x0106
            goto L_0x01c4
        L_0x0106:
            int r1 = r0.hashCode()
            switch(r1) {
                case 1537: goto L_0x017f;
                case 1538: goto L_0x0172;
                case 1539: goto L_0x0165;
                case 1540: goto L_0x0158;
                case 1541: goto L_0x014a;
                case 1542: goto L_0x013c;
                case 1543: goto L_0x012e;
                case 1544: goto L_0x0120;
                case 1545: goto L_0x0112;
                default: goto L_0x010d;
            }
        L_0x010d:
            switch(r1) {
                case 1567: goto L_0x01b7;
                case 1568: goto L_0x01aa;
                case 1569: goto L_0x019b;
                case 1570: goto L_0x018c;
                default: goto L_0x0110;
            }
        L_0x0110:
            goto L_0x01c4
        L_0x0112:
            java.lang.String r1 = "09"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x01c5
        L_0x0120:
            java.lang.String r1 = "08"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            goto L_0x01c5
        L_0x012e:
            java.lang.String r1 = "07"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            goto L_0x01c5
        L_0x013c:
            java.lang.String r1 = "06"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            goto L_0x01c5
        L_0x014a:
            java.lang.String r1 = "05"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x01c5
        L_0x0158:
            java.lang.String r1 = "04"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            goto L_0x01c5
        L_0x0165:
            java.lang.String r1 = "03"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            goto L_0x01c5
        L_0x0172:
            java.lang.String r1 = "02"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            goto L_0x01c5
        L_0x017f:
            java.lang.String r1 = "01"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r15)
            goto L_0x01c5
        L_0x018c:
            java.lang.String r1 = "13"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            r1 = 4096(0x1000, float:5.74E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x01c5
        L_0x019b:
            java.lang.String r1 = "12"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            r1 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x01c5
        L_0x01aa:
            java.lang.String r1 = "11"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            goto L_0x01c5
        L_0x01b7:
            java.lang.String r1 = "10"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01c4
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)
            goto L_0x01c5
        L_0x01c4:
            r1 = 0
        L_0x01c5:
            if (r1 != 0) goto L_0x01ce
            java.lang.String r1 = "Unknown Dolby Vision level string: "
            defpackage.lf.w(r0, r1, r14)
            goto L_0x0748
        L_0x01ce:
            android.util.Pair r0 = new android.util.Pair
            r0.<init>(r2, r1)
            goto L_0x0749
        L_0x01d5:
            r2 = 0
            r3 = r1[r2]
            int r5 = r3.hashCode()
            r6 = 6
            r7 = -1
            switch(r5) {
                case 3004662: goto L_0x021e;
                case 3006243: goto L_0x0214;
                case 3006244: goto L_0x020a;
                case 3199032: goto L_0x0200;
                case 3214780: goto L_0x01f6;
                case 3356560: goto L_0x01ec;
                case 3624515: goto L_0x01e2;
                default: goto L_0x01e1;
            }
        L_0x01e1:
            goto L_0x0228
        L_0x01e2:
            java.lang.String r5 = "vp09"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0228
            r3 = r13
            goto L_0x0229
        L_0x01ec:
            java.lang.String r5 = "mp4a"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0228
            r3 = r6
            goto L_0x0229
        L_0x01f6:
            java.lang.String r5 = "hvc1"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0228
            r3 = r12
            goto L_0x0229
        L_0x0200:
            java.lang.String r5 = "hev1"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0228
            r3 = r10
            goto L_0x0229
        L_0x020a:
            java.lang.String r5 = "avc2"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0228
            r3 = r15
            goto L_0x0229
        L_0x0214:
            java.lang.String r5 = "avc1"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0228
            r3 = r2
            goto L_0x0229
        L_0x021e:
            java.lang.String r5 = "av01"
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0228
            r3 = 5
            goto L_0x0229
        L_0x0228:
            r3 = r7
        L_0x0229:
            r5 = 8192(0x2000, float:1.14794E-41)
            r8 = 20
            switch(r3) {
                case 0: goto L_0x0674;
                case 1: goto L_0x0674;
                case 2: goto L_0x05d3;
                case 3: goto L_0x0355;
                case 4: goto L_0x0355;
                case 5: goto L_0x02a3;
                case 6: goto L_0x0232;
                default: goto L_0x0230;
            }
        L_0x0230:
            goto L_0x0748
        L_0x0232:
            java.lang.String r0 = r0.zzj
            int r3 = r1.length
            if (r3 == r10) goto L_0x023e
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            defpackage.lf.w(r0, r1, r14)
            goto L_0x0748
        L_0x023e:
            r3 = r1[r15]     // Catch:{ NumberFormatException -> 0x029c }
            int r3 = java.lang.Integer.parseInt(r3, r11)     // Catch:{ NumberFormatException -> 0x029c }
            java.lang.String r3 = com.google.android.gms.internal.ads.zzbn.zzd(r3)     // Catch:{ NumberFormatException -> 0x029c }
            java.lang.String r4 = "audio/mp4a-latm"
            boolean r3 = r4.equals(r3)     // Catch:{ NumberFormatException -> 0x029c }
            if (r3 == 0) goto L_0x0748
            r1 = r1[r13]     // Catch:{ NumberFormatException -> 0x029c }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x029c }
            r3 = 17
            if (r1 == r3) goto L_0x0289
            if (r1 == r8) goto L_0x0287
            r3 = 23
            if (r1 == r3) goto L_0x0284
            r3 = 29
            if (r1 == r3) goto L_0x0281
            r3 = 39
            if (r1 == r3) goto L_0x027e
            r3 = 42
            if (r1 == r3) goto L_0x027b
            switch(r1) {
                case 1: goto L_0x0279;
                case 2: goto L_0x0277;
                case 3: goto L_0x028b;
                case 4: goto L_0x0275;
                case 5: goto L_0x0273;
                case 6: goto L_0x0271;
                default: goto L_0x026f;
            }     // Catch:{ NumberFormatException -> 0x029c }
        L_0x026f:
            r10 = r7
            goto L_0x028b
        L_0x0271:
            r10 = r6
            goto L_0x028b
        L_0x0273:
            r10 = 5
            goto L_0x028b
        L_0x0275:
            r10 = r12
            goto L_0x028b
        L_0x0277:
            r10 = r13
            goto L_0x028b
        L_0x0279:
            r10 = r15
            goto L_0x028b
        L_0x027b:
            r10 = 42
            goto L_0x028b
        L_0x027e:
            r10 = 39
            goto L_0x028b
        L_0x0281:
            r10 = 29
            goto L_0x028b
        L_0x0284:
            r10 = 23
            goto L_0x028b
        L_0x0287:
            r10 = r8
            goto L_0x028b
        L_0x0289:
            r10 = 17
        L_0x028b:
            if (r10 == r7) goto L_0x0748
            android.util.Pair r1 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x029c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)     // Catch:{ NumberFormatException -> 0x029c }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ NumberFormatException -> 0x029c }
            r1.<init>(r3, r2)     // Catch:{ NumberFormatException -> 0x029c }
            goto L_0x034b
        L_0x029c:
            java.lang.String r1 = "Ignoring malformed MP4A codec string: "
            defpackage.lf.w(r0, r1, r14)
            goto L_0x0748
        L_0x02a3:
            java.lang.String r3 = r0.zzj
            com.google.android.gms.internal.ads.zzo r0 = r0.zzy
            int r8 = r1.length
            if (r8 >= r12) goto L_0x02b1
            java.lang.String r0 = "Ignoring malformed AV1 codec string: "
            defpackage.lf.w(r3, r0, r14)
            goto L_0x0748
        L_0x02b1:
            r8 = r1[r15]     // Catch:{ NumberFormatException -> 0x034e }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x034e }
            r11 = r1[r13]     // Catch:{ NumberFormatException -> 0x034e }
            java.lang.String r2 = r11.substring(r2, r13)     // Catch:{ NumberFormatException -> 0x034e }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x034e }
            r1 = r1[r10]     // Catch:{ NumberFormatException -> 0x034e }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x034e }
            if (r8 == 0) goto L_0x02d0
            java.lang.String r0 = "Unknown AV1 profile: "
            defpackage.C0709Uj.t(r0, r8, r14)
            goto L_0x0748
        L_0x02d0:
            if (r1 == r9) goto L_0x02ef
            r3 = 10
            if (r1 == r3) goto L_0x02dd
            java.lang.String r0 = "Unknown AV1 bit depth: "
            defpackage.C0709Uj.t(r0, r1, r14)
            goto L_0x0748
        L_0x02dd:
            if (r0 == 0) goto L_0x02ed
            byte[] r1 = r0.zze
            if (r1 != 0) goto L_0x02ea
            int r0 = r0.zzd
            r1 = 7
            if (r0 == r1) goto L_0x02ea
            if (r0 != r6) goto L_0x02ed
        L_0x02ea:
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x02f0
        L_0x02ed:
            r0 = r13
            goto L_0x02f0
        L_0x02ef:
            r0 = r15
        L_0x02f0:
            switch(r2) {
                case 0: goto L_0x0334;
                case 1: goto L_0x0332;
                case 2: goto L_0x0330;
                case 3: goto L_0x032e;
                case 4: goto L_0x032b;
                case 5: goto L_0x0328;
                case 6: goto L_0x0325;
                case 7: goto L_0x0322;
                case 8: goto L_0x031f;
                case 9: goto L_0x0335;
                case 10: goto L_0x031c;
                case 11: goto L_0x0319;
                case 12: goto L_0x0316;
                case 13: goto L_0x0314;
                case 14: goto L_0x0311;
                case 15: goto L_0x030d;
                case 16: goto L_0x030a;
                case 17: goto L_0x0307;
                case 18: goto L_0x0304;
                case 19: goto L_0x0301;
                case 20: goto L_0x02fe;
                case 21: goto L_0x02fb;
                case 22: goto L_0x02f8;
                case 23: goto L_0x02f5;
                default: goto L_0x02f3;
            }
        L_0x02f3:
            r4 = r7
            goto L_0x0335
        L_0x02f5:
            r4 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0335
        L_0x02f8:
            r4 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x0335
        L_0x02fb:
            r4 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x0335
        L_0x02fe:
            r4 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0335
        L_0x0301:
            r4 = 524288(0x80000, float:7.34684E-40)
            goto L_0x0335
        L_0x0304:
            r4 = 262144(0x40000, float:3.67342E-40)
            goto L_0x0335
        L_0x0307:
            r4 = 131072(0x20000, float:1.83671E-40)
            goto L_0x0335
        L_0x030a:
            r4 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0335
        L_0x030d:
            r4 = 32768(0x8000, float:4.5918E-41)
            goto L_0x0335
        L_0x0311:
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0335
        L_0x0314:
            r4 = r5
            goto L_0x0335
        L_0x0316:
            r4 = 4096(0x1000, float:5.74E-42)
            goto L_0x0335
        L_0x0319:
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0335
        L_0x031c:
            r4 = 1024(0x400, float:1.435E-42)
            goto L_0x0335
        L_0x031f:
            r4 = 256(0x100, float:3.59E-43)
            goto L_0x0335
        L_0x0322:
            r4 = 128(0x80, float:1.794E-43)
            goto L_0x0335
        L_0x0325:
            r4 = 64
            goto L_0x0335
        L_0x0328:
            r4 = 32
            goto L_0x0335
        L_0x032b:
            r4 = 16
            goto L_0x0335
        L_0x032e:
            r4 = r9
            goto L_0x0335
        L_0x0330:
            r4 = r12
            goto L_0x0335
        L_0x0332:
            r4 = r13
            goto L_0x0335
        L_0x0334:
            r4 = r15
        L_0x0335:
            if (r4 != r7) goto L_0x033e
            java.lang.String r0 = "Unknown AV1 level: "
            defpackage.C0709Uj.t(r0, r2, r14)
            goto L_0x0748
        L_0x033e:
            android.util.Pair r1 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r1.<init>(r0, r2)
        L_0x034b:
            r0 = r1
            goto L_0x0749
        L_0x034e:
            java.lang.String r0 = "Ignoring malformed AV1 codec string: "
            defpackage.lf.w(r3, r0, r14)
            goto L_0x0748
        L_0x0355:
            java.lang.String r2 = r0.zzj
            com.google.android.gms.internal.ads.zzo r0 = r0.zzy
            int r3 = r1.length
            if (r3 >= r12) goto L_0x0363
            java.lang.String r0 = "Ignoring malformed HEVC codec string: "
            defpackage.lf.w(r2, r0, r14)
            goto L_0x0748
        L_0x0363:
            java.util.regex.Pattern r3 = zzb
            r7 = r1[r15]
            java.util.regex.Matcher r3 = r3.matcher(r7)
            boolean r7 = r3.matches()
            if (r7 != 0) goto L_0x0378
            java.lang.String r0 = "Ignoring malformed HEVC codec string: "
            defpackage.lf.w(r2, r0, r14)
            goto L_0x0748
        L_0x0378:
            java.lang.String r2 = r3.group(r15)
            java.lang.String r3 = "1"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x0386
            r0 = r15
            goto L_0x0398
        L_0x0386:
            java.lang.String r3 = "2"
            boolean r3 = r3.equals(r2)
            if (r3 == 0) goto L_0x05cc
            if (r0 == 0) goto L_0x0397
            int r0 = r0.zzd
            if (r0 != r6) goto L_0x0397
            r0 = 4096(0x1000, float:5.74E-42)
            goto L_0x0398
        L_0x0397:
            r0 = r13
        L_0x0398:
            r1 = r1[r10]
            if (r1 != 0) goto L_0x039e
            goto L_0x0501
        L_0x039e:
            r1.hashCode()
            r2 = -1
            int r3 = r1.hashCode()
            switch(r3) {
                case 70821: goto L_0x04f4;
                case 70914: goto L_0x04e9;
                case 70917: goto L_0x04de;
                case 71007: goto L_0x04d3;
                case 71010: goto L_0x04c8;
                case 74665: goto L_0x04bd;
                case 74758: goto L_0x04b2;
                case 74761: goto L_0x04a7;
                case 74851: goto L_0x0499;
                case 74854: goto L_0x048b;
                case 2193639: goto L_0x047d;
                case 2193642: goto L_0x046f;
                case 2193732: goto L_0x0461;
                case 2193735: goto L_0x0453;
                case 2193738: goto L_0x0445;
                case 2193825: goto L_0x0437;
                case 2193828: goto L_0x0429;
                case 2193831: goto L_0x041b;
                case 2312803: goto L_0x040d;
                case 2312806: goto L_0x03ff;
                case 2312896: goto L_0x03f1;
                case 2312899: goto L_0x03e3;
                case 2312902: goto L_0x03d5;
                case 2312989: goto L_0x03c7;
                case 2312992: goto L_0x03b9;
                case 2312995: goto L_0x03ab;
                default: goto L_0x03a9;
            }
        L_0x03a9:
            goto L_0x04fe
        L_0x03ab:
            java.lang.String r3 = "L186"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x03b5
            goto L_0x04fe
        L_0x03b5:
            r2 = 25
            goto L_0x04fe
        L_0x03b9:
            java.lang.String r3 = "L183"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x03c3
            goto L_0x04fe
        L_0x03c3:
            r2 = 24
            goto L_0x04fe
        L_0x03c7:
            java.lang.String r3 = "L180"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x03d1
            goto L_0x04fe
        L_0x03d1:
            r2 = 23
            goto L_0x04fe
        L_0x03d5:
            java.lang.String r3 = "L156"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x03df
            goto L_0x04fe
        L_0x03df:
            r2 = 22
            goto L_0x04fe
        L_0x03e3:
            java.lang.String r3 = "L153"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x03ed
            goto L_0x04fe
        L_0x03ed:
            r2 = 21
            goto L_0x04fe
        L_0x03f1:
            java.lang.String r3 = "L150"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x03fb
            goto L_0x04fe
        L_0x03fb:
            r2 = 20
            goto L_0x04fe
        L_0x03ff:
            java.lang.String r3 = "L123"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0409
            goto L_0x04fe
        L_0x0409:
            r2 = 19
            goto L_0x04fe
        L_0x040d:
            java.lang.String r3 = "L120"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0417
            goto L_0x04fe
        L_0x0417:
            r2 = 18
            goto L_0x04fe
        L_0x041b:
            java.lang.String r3 = "H186"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0425
            goto L_0x04fe
        L_0x0425:
            r2 = 17
            goto L_0x04fe
        L_0x0429:
            java.lang.String r3 = "H183"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0433
            goto L_0x04fe
        L_0x0433:
            r2 = 16
            goto L_0x04fe
        L_0x0437:
            java.lang.String r3 = "H180"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0441
            goto L_0x04fe
        L_0x0441:
            r2 = 15
            goto L_0x04fe
        L_0x0445:
            java.lang.String r3 = "H156"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x044f
            goto L_0x04fe
        L_0x044f:
            r2 = 14
            goto L_0x04fe
        L_0x0453:
            java.lang.String r3 = "H153"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x045d
            goto L_0x04fe
        L_0x045d:
            r2 = 13
            goto L_0x04fe
        L_0x0461:
            java.lang.String r3 = "H150"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x046b
            goto L_0x04fe
        L_0x046b:
            r2 = 12
            goto L_0x04fe
        L_0x046f:
            java.lang.String r3 = "H123"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0479
            goto L_0x04fe
        L_0x0479:
            r2 = 11
            goto L_0x04fe
        L_0x047d:
            java.lang.String r3 = "H120"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0487
            goto L_0x04fe
        L_0x0487:
            r2 = 10
            goto L_0x04fe
        L_0x048b:
            java.lang.String r3 = "L93"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0495
            goto L_0x04fe
        L_0x0495:
            r2 = 9
            goto L_0x04fe
        L_0x0499:
            java.lang.String r3 = "L90"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x04a3
            goto L_0x04fe
        L_0x04a3:
            r2 = 8
            goto L_0x04fe
        L_0x04a7:
            java.lang.String r3 = "L63"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x04b0
            goto L_0x04fe
        L_0x04b0:
            r2 = 7
            goto L_0x04fe
        L_0x04b2:
            java.lang.String r3 = "L60"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x04bb
            goto L_0x04fe
        L_0x04bb:
            r2 = 6
            goto L_0x04fe
        L_0x04bd:
            java.lang.String r3 = "L30"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x04c6
            goto L_0x04fe
        L_0x04c6:
            r2 = 5
            goto L_0x04fe
        L_0x04c8:
            java.lang.String r3 = "H93"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x04d1
            goto L_0x04fe
        L_0x04d1:
            r2 = 4
            goto L_0x04fe
        L_0x04d3:
            java.lang.String r3 = "H90"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x04dc
            goto L_0x04fe
        L_0x04dc:
            r2 = 3
            goto L_0x04fe
        L_0x04de:
            java.lang.String r3 = "H63"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x04e7
            goto L_0x04fe
        L_0x04e7:
            r2 = 2
            goto L_0x04fe
        L_0x04e9:
            java.lang.String r3 = "H60"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x04f2
            goto L_0x04fe
        L_0x04f2:
            r2 = 1
            goto L_0x04fe
        L_0x04f4:
            java.lang.String r3 = "H30"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x04fd
            goto L_0x04fe
        L_0x04fd:
            r2 = 0
        L_0x04fe:
            switch(r2) {
                case 0: goto L_0x05b4;
                case 1: goto L_0x05af;
                case 2: goto L_0x05a8;
                case 3: goto L_0x05a1;
                case 4: goto L_0x059c;
                case 5: goto L_0x0597;
                case 6: goto L_0x0592;
                case 7: goto L_0x058b;
                case 8: goto L_0x0584;
                case 9: goto L_0x057d;
                case 10: goto L_0x0576;
                case 11: goto L_0x0571;
                case 12: goto L_0x0569;
                case 13: goto L_0x0562;
                case 14: goto L_0x055b;
                case 15: goto L_0x0554;
                case 16: goto L_0x054c;
                case 17: goto L_0x0544;
                case 18: goto L_0x053c;
                case 19: goto L_0x0534;
                case 20: goto L_0x052c;
                case 21: goto L_0x0524;
                case 22: goto L_0x051c;
                case 23: goto L_0x0514;
                case 24: goto L_0x050c;
                case 25: goto L_0x0504;
                default: goto L_0x0501;
            }
        L_0x0501:
            r2 = 0
            goto L_0x05b8
        L_0x0504:
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x050c:
            r2 = 4194304(0x400000, float:5.877472E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x0514:
            r2 = 1048576(0x100000, float:1.469368E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x051c:
            r2 = 262144(0x40000, float:3.67342E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x0524:
            r2 = 65536(0x10000, float:9.18355E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x052c:
            r2 = 16384(0x4000, float:2.2959E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x0534:
            r2 = 4096(0x1000, float:5.74E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x053c:
            r2 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x0544:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x054c:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x0554:
            r2 = 2097152(0x200000, float:2.938736E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x055b:
            r2 = 524288(0x80000, float:7.34684E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x0562:
            r2 = 131072(0x20000, float:1.83671E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x0569:
            r2 = 32768(0x8000, float:4.5918E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x0571:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            goto L_0x05b8
        L_0x0576:
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x057d:
            r2 = 256(0x100, float:3.59E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x0584:
            r2 = 64
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x058b:
            r2 = 16
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x0592:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            goto L_0x05b8
        L_0x0597:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
            goto L_0x05b8
        L_0x059c:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            goto L_0x05b8
        L_0x05a1:
            r2 = 128(0x80, float:1.794E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x05a8:
            r2 = 32
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x05b8
        L_0x05af:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            goto L_0x05b8
        L_0x05b4:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
        L_0x05b8:
            if (r2 != 0) goto L_0x05c1
            java.lang.String r0 = "Unknown HEVC level string: "
            defpackage.lf.w(r1, r0, r14)
            goto L_0x0748
        L_0x05c1:
            android.util.Pair r1 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.<init>(r0, r2)
            goto L_0x034b
        L_0x05cc:
            java.lang.String r0 = "Unknown HEVC profile string: "
            defpackage.lf.w(r2, r0, r14)
            goto L_0x0748
        L_0x05d3:
            r3 = 128(0x80, float:1.794E-43)
            r6 = 32
            r11 = 4096(0x1000, float:5.74E-42)
            r16 = 256(0x100, float:3.59E-43)
            r17 = 64
            java.lang.String r0 = r0.zzj
            int r2 = r1.length
            if (r2 >= r10) goto L_0x05e9
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            defpackage.lf.w(r0, r1, r14)
            goto L_0x0748
        L_0x05e9:
            r2 = r1[r15]     // Catch:{ NumberFormatException -> 0x066d }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x066d }
            r1 = r1[r13]     // Catch:{ NumberFormatException -> 0x066d }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x066d }
            if (r2 == 0) goto L_0x0605
            if (r2 == r15) goto L_0x0603
            if (r2 == r13) goto L_0x0601
            if (r2 == r10) goto L_0x05ff
            r1 = r7
            goto L_0x0606
        L_0x05ff:
            r1 = r9
            goto L_0x0606
        L_0x0601:
            r1 = r12
            goto L_0x0606
        L_0x0603:
            r1 = r13
            goto L_0x0606
        L_0x0605:
            r1 = r15
        L_0x0606:
            if (r1 != r7) goto L_0x060f
            java.lang.String r0 = "Unknown VP9 profile: "
            defpackage.C0709Uj.t(r0, r2, r14)
            goto L_0x0748
        L_0x060f:
            r2 = 10
            if (r0 == r2) goto L_0x0654
            r2 = 11
            if (r0 == r2) goto L_0x0652
            if (r0 == r8) goto L_0x0650
            r2 = 21
            if (r0 == r2) goto L_0x064e
            r2 = 30
            if (r0 == r2) goto L_0x064b
            r2 = 31
            if (r0 == r2) goto L_0x0649
            r2 = 40
            if (r0 == r2) goto L_0x0646
            r2 = 41
            if (r0 == r2) goto L_0x0644
            r2 = 50
            if (r0 == r2) goto L_0x0641
            r2 = 51
            if (r0 == r2) goto L_0x0655
            switch(r0) {
                case 60: goto L_0x063e;
                case 61: goto L_0x063c;
                case 62: goto L_0x063a;
                default: goto L_0x0638;
            }
        L_0x0638:
            r4 = r7
            goto L_0x0655
        L_0x063a:
            r4 = r5
            goto L_0x0655
        L_0x063c:
            r4 = r11
            goto L_0x0655
        L_0x063e:
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x0655
        L_0x0641:
            r4 = r16
            goto L_0x0655
        L_0x0644:
            r4 = r3
            goto L_0x0655
        L_0x0646:
            r4 = r17
            goto L_0x0655
        L_0x0649:
            r4 = r6
            goto L_0x0655
        L_0x064b:
            r4 = 16
            goto L_0x0655
        L_0x064e:
            r4 = r9
            goto L_0x0655
        L_0x0650:
            r4 = r12
            goto L_0x0655
        L_0x0652:
            r4 = r13
            goto L_0x0655
        L_0x0654:
            r4 = r15
        L_0x0655:
            if (r4 != r7) goto L_0x065e
            java.lang.String r1 = "Unknown VP9 level: "
            defpackage.C0709Uj.t(r1, r0, r14)
            goto L_0x0748
        L_0x065e:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r0.<init>(r1, r2)
            goto L_0x0749
        L_0x066d:
            java.lang.String r1 = "Ignoring malformed VP9 codec string: "
            defpackage.lf.w(r0, r1, r14)
            goto L_0x0748
        L_0x0674:
            r8 = 256(0x100, float:3.59E-43)
            r11 = 64
            java.lang.String r0 = r0.zzj
            int r2 = r1.length
            java.lang.String r3 = "Ignoring malformed AVC codec string: "
            if (r2 >= r13) goto L_0x0684
            defpackage.lf.w(r0, r3, r14)
            goto L_0x0748
        L_0x0684:
            r18 = r1[r15]     // Catch:{ NumberFormatException -> 0x0745 }
            int r4 = r18.length()     // Catch:{ NumberFormatException -> 0x0745 }
            if (r4 != r6) goto L_0x06a4
            r2 = r1[r15]     // Catch:{ NumberFormatException -> 0x0745 }
            r4 = 0
            java.lang.String r2 = r2.substring(r4, r13)     // Catch:{ NumberFormatException -> 0x0745 }
            r4 = 16
            int r2 = java.lang.Integer.parseInt(r2, r4)     // Catch:{ NumberFormatException -> 0x0745 }
            r1 = r1[r15]     // Catch:{ NumberFormatException -> 0x0745 }
            java.lang.String r1 = r1.substring(r12)     // Catch:{ NumberFormatException -> 0x0745 }
            int r0 = java.lang.Integer.parseInt(r1, r4)     // Catch:{ NumberFormatException -> 0x0745 }
            goto L_0x06b4
        L_0x06a4:
            r4 = 16
            if (r2 < r10) goto L_0x0735
            r2 = r1[r15]     // Catch:{ NumberFormatException -> 0x0745 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0745 }
            r1 = r1[r13]     // Catch:{ NumberFormatException -> 0x0745 }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0745 }
        L_0x06b4:
            r1 = 66
            if (r2 == r1) goto L_0x06dd
            r1 = 77
            if (r2 == r1) goto L_0x06de
            r1 = 88
            if (r2 == r1) goto L_0x06db
            r1 = 100
            if (r2 == r1) goto L_0x06d9
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 == r1) goto L_0x06d7
            r1 = 122(0x7a, float:1.71E-43)
            if (r2 == r1) goto L_0x06d4
            r1 = 244(0xf4, float:3.42E-43)
            if (r2 == r1) goto L_0x06d2
            r13 = r7
            goto L_0x06de
        L_0x06d2:
            r13 = r11
            goto L_0x06de
        L_0x06d4:
            r13 = 32
            goto L_0x06de
        L_0x06d7:
            r13 = r4
            goto L_0x06de
        L_0x06d9:
            r13 = r9
            goto L_0x06de
        L_0x06db:
            r13 = r12
            goto L_0x06de
        L_0x06dd:
            r13 = r15
        L_0x06de:
            if (r13 != r7) goto L_0x06e7
            java.lang.String r0 = "Unknown AVC profile: "
            defpackage.C0709Uj.t(r0, r2, r14)
            goto L_0x0748
        L_0x06e7:
            switch(r0) {
                case 10: goto L_0x06fc;
                case 11: goto L_0x06fa;
                case 12: goto L_0x071f;
                case 13: goto L_0x06f8;
                default: goto L_0x06ea;
            }
        L_0x06ea:
            switch(r0) {
                case 20: goto L_0x0703;
                case 21: goto L_0x0701;
                case 22: goto L_0x06fe;
                default: goto L_0x06ed;
            }
        L_0x06ed:
            switch(r0) {
                case 30: goto L_0x070c;
                case 31: goto L_0x0709;
                case 32: goto L_0x0706;
                default: goto L_0x06f0;
            }
        L_0x06f0:
            switch(r0) {
                case 40: goto L_0x0713;
                case 41: goto L_0x0710;
                case 42: goto L_0x070e;
                default: goto L_0x06f3;
            }
        L_0x06f3:
            switch(r0) {
                case 50: goto L_0x071d;
                case 51: goto L_0x0719;
                case 52: goto L_0x0716;
                default: goto L_0x06f6;
            }
        L_0x06f6:
            r9 = r7
            goto L_0x071f
        L_0x06f8:
            r9 = r4
            goto L_0x071f
        L_0x06fa:
            r9 = r12
            goto L_0x071f
        L_0x06fc:
            r9 = r15
            goto L_0x071f
        L_0x06fe:
            r9 = 128(0x80, float:1.794E-43)
            goto L_0x071f
        L_0x0701:
            r9 = r11
            goto L_0x071f
        L_0x0703:
            r9 = 32
            goto L_0x071f
        L_0x0706:
            r9 = 1024(0x400, float:1.435E-42)
            goto L_0x071f
        L_0x0709:
            r9 = 512(0x200, float:7.175E-43)
            goto L_0x071f
        L_0x070c:
            r9 = r8
            goto L_0x071f
        L_0x070e:
            r9 = r5
            goto L_0x071f
        L_0x0710:
            r9 = 4096(0x1000, float:5.74E-42)
            goto L_0x071f
        L_0x0713:
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x071f
        L_0x0716:
            r9 = 65536(0x10000, float:9.18355E-41)
            goto L_0x071f
        L_0x0719:
            r9 = 32768(0x8000, float:4.5918E-41)
            goto L_0x071f
        L_0x071d:
            r9 = 16384(0x4000, float:2.2959E-41)
        L_0x071f:
            if (r9 != r7) goto L_0x0727
            java.lang.String r1 = "Unknown AVC level: "
            defpackage.C0709Uj.t(r1, r0, r14)
            goto L_0x0748
        L_0x0727:
            android.util.Pair r0 = new android.util.Pair
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            r0.<init>(r1, r2)
            goto L_0x0749
        L_0x0735:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x0745 }
            r1.<init>(r3)     // Catch:{ NumberFormatException -> 0x0745 }
            r1.append(r0)     // Catch:{ NumberFormatException -> 0x0745 }
            java.lang.String r1 = r1.toString()     // Catch:{ NumberFormatException -> 0x0745 }
            com.google.android.gms.internal.ads.zzea.zzf(r14, r1)     // Catch:{ NumberFormatException -> 0x0745 }
            goto L_0x0748
        L_0x0745:
            defpackage.lf.w(r0, r3, r14)
        L_0x0748:
            r0 = 0
        L_0x0749:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztc.zza(com.google.android.gms.internal.ads.zzaf):android.util.Pair");
    }

    public static zzsf zzb() throws zzsw {
        List zze = zze("audio/raw", false, false);
        if (zze.isEmpty()) {
            return null;
        }
        return (zzsf) zze.get(0);
    }

    public static String zzc(zzaf zzaf) {
        Pair zza2;
        if ("audio/eac3-joc".equals(zzaf.zzm)) {
            return "audio/eac3";
        }
        if (!"video/dolby-vision".equals(zzaf.zzm) || (zza2 = zza(zzaf)) == null) {
            return null;
        }
        int intValue = ((Integer) zza2.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return "video/hevc";
        }
        if (intValue == 512) {
            return "video/avc";
        }
        if (intValue == 1024) {
            return "video/av01";
        }
        return null;
    }

    public static List zzd(zzsq zzsq, zzaf zzaf, boolean z, boolean z2) throws zzsw {
        String zzc2 = zzc(zzaf);
        if (zzc2 == null) {
            return zzfxr.zzm();
        }
        return zze(zzc2, z, z2);
    }

    public static synchronized List zze(String str, boolean z, boolean z2) throws zzsw {
        String str2 = str;
        boolean z3 = z;
        boolean z4 = z2;
        synchronized (zztc.class) {
            zzsu zzsu = new zzsu(str2, z3, z4);
            HashMap hashMap = zzc;
            List list = (List) hashMap.get(zzsu);
            if (list != null) {
                return list;
            }
            int i = zzet.zza;
            ArrayList zzh = zzh(zzsu, new zzta(z3, z4));
            if (z3 && zzh.isEmpty() && zzet.zza <= 23) {
                zzh = zzh(zzsu, new zzsz((zzsy) null));
                if (!zzh.isEmpty()) {
                    String str3 = ((zzsf) zzh.get(0)).zza;
                    zzea.zzf("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str2 + ". Assuming: " + str3);
                }
            }
            if ("audio/raw".equals(str2)) {
                if (zzet.zza < 26 && zzet.zzb.equals("R9") && zzh.size() == 1 && ((zzsf) zzh.get(0)).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    zzh.add(zzsf.zzc("OMX.google.raw.decoder", "audio/raw", "audio/raw", (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
                }
                zzi(zzh, new zzss());
            }
            if (zzet.zza < 32 && zzh.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((zzsf) zzh.get(0)).zza)) {
                zzh.add((zzsf) zzh.remove(0));
            }
            zzfxr zzk = zzfxr.zzk(zzh);
            hashMap.put(zzsu, zzk);
            return zzk;
        }
    }

    public static List zzf(zzsq zzsq, zzaf zzaf, boolean z, boolean z2) throws zzsw {
        List zze = zze(zzaf.zzm, z, z2);
        List zzd = zzd(zzsq, zzaf, z, z2);
        zzfxo zzfxo = new zzfxo();
        zzfxo.zzh(zze);
        zzfxo.zzh(zzd);
        return zzfxo.zzi();
    }

    public static List zzg(List list, zzaf zzaf) {
        ArrayList arrayList = new ArrayList(list);
        zzi(arrayList, new zzst(zzaf));
        return arrayList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v23, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v26, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v27, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v30, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v28 */
    /* JADX WARNING: type inference failed for: r2v31 */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01ab, code lost:
        if (r2 != r7) goto L_0x01ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01b1, code lost:
        if (r1.zzb == false) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01b3, code lost:
        r22 = r12;
        r18 = r13;
        r20 = r14;
        r2 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        r6.add(com.google.android.gms.internal.ads.zzsf.zzc(r12, r15, r5, r10, r11, r21, r0, false, false));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01cf, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01d0, code lost:
        r1 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (r12.endsWith(".secure") == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        if ("SCV31".equals(r10) == false) goto L_0x00a8;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x021e A[SYNTHETIC, Splitter:B:143:0x021e] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x023e A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList zzh(com.google.android.gms.internal.ads.zzsu r23, com.google.android.gms.internal.ads.zzsx r24) throws com.google.android.gms.internal.ads.zzsw {
        /*
            r1 = r23
            r2 = r24
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x026c }
            r6.<init>()     // Catch:{ Exception -> 0x026c }
            java.lang.String r15 = r1.zza     // Catch:{ Exception -> 0x026c }
            int r14 = r24.zza()     // Catch:{ Exception -> 0x026c }
            boolean r16 = r24.zze()     // Catch:{ Exception -> 0x026c }
            r17 = 0
            r13 = r17
        L_0x001b:
            if (r13 >= r14) goto L_0x026b
            android.media.MediaCodecInfo r0 = r2.zzb(r13)     // Catch:{ Exception -> 0x026c }
            int r7 = com.google.android.gms.internal.ads.zzet.zza     // Catch:{ Exception -> 0x026c }
            r8 = 29
            if (r7 < r8) goto L_0x0034
            boolean r9 = r0.isAlias()     // Catch:{ Exception -> 0x026c }
            if (r9 == 0) goto L_0x0034
        L_0x002d:
            r18 = r13
            r20 = r14
            r2 = r15
            goto L_0x0260
        L_0x0034:
            java.lang.String r12 = r0.getName()     // Catch:{ Exception -> 0x026c }
            boolean r9 = r0.isEncoder()     // Catch:{ Exception -> 0x026c }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = ".secure"
            if (r16 != 0) goto L_0x0048
            boolean r10 = r12.endsWith(r9)     // Catch:{ Exception -> 0x026c }
            if (r10 != 0) goto L_0x002d
        L_0x0048:
            r10 = 24
            if (r7 >= r10) goto L_0x00a8
            java.lang.String r10 = "OMX.SEC.aac.dec"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x026c }
            if (r10 != 0) goto L_0x005c
            java.lang.String r10 = "OMX.Exynos.AAC.Decoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x026c }
            if (r10 == 0) goto L_0x00a8
        L_0x005c:
            java.lang.String r10 = "samsung"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzet.zzc     // Catch:{ Exception -> 0x026c }
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x026c }
            if (r10 == 0) goto L_0x00a8
            java.lang.String r10 = com.google.android.gms.internal.ads.zzet.zzb     // Catch:{ Exception -> 0x026c }
            java.lang.String r11 = "zeroflte"
            boolean r11 = r10.startsWith(r11)     // Catch:{ Exception -> 0x026c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "zerolte"
            boolean r11 = r10.startsWith(r11)     // Catch:{ Exception -> 0x026c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "zenlte"
            boolean r11 = r10.startsWith(r11)     // Catch:{ Exception -> 0x026c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "SC-05G"
            boolean r11 = r11.equals(r10)     // Catch:{ Exception -> 0x026c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "marinelteatt"
            boolean r11 = r11.equals(r10)     // Catch:{ Exception -> 0x026c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "404SC"
            boolean r11 = r11.equals(r10)     // Catch:{ Exception -> 0x026c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "SC-04G"
            boolean r11 = r11.equals(r10)     // Catch:{ Exception -> 0x026c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "SCV31"
            boolean r10 = r11.equals(r10)     // Catch:{ Exception -> 0x026c }
            if (r10 != 0) goto L_0x002d
        L_0x00a8:
            r11 = 23
            if (r7 > r11) goto L_0x00bc
            java.lang.String r7 = "audio/eac3-joc"
            boolean r7 = r7.equals(r15)     // Catch:{ Exception -> 0x026c }
            if (r7 == 0) goto L_0x00bc
            java.lang.String r7 = "OMX.MTK.AUDIO.DECODER.DSPAC3"
            boolean r7 = r7.equals(r12)     // Catch:{ Exception -> 0x026c }
            if (r7 != 0) goto L_0x002d
        L_0x00bc:
            java.lang.String[] r7 = r0.getSupportedTypes()     // Catch:{ Exception -> 0x026c }
            int r10 = r7.length     // Catch:{ Exception -> 0x026c }
            r11 = r17
        L_0x00c3:
            if (r11 >= r10) goto L_0x00d1
            r5 = r7[r11]     // Catch:{ Exception -> 0x026c }
            boolean r19 = r5.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x026c }
            if (r19 == 0) goto L_0x00ce
            goto L_0x0131
        L_0x00ce:
            int r11 = r11 + 1
            goto L_0x00c3
        L_0x00d1:
            java.lang.String r5 = "video/dolby-vision"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x026c }
            if (r5 == 0) goto L_0x00f7
            java.lang.String r5 = "OMX.MS.HEVCDV.Decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x026c }
            if (r5 == 0) goto L_0x00e4
            java.lang.String r5 = "video/hevcdv"
            goto L_0x0131
        L_0x00e4:
            java.lang.String r5 = "OMX.RTK.video.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x026c }
            if (r5 != 0) goto L_0x00f4
            java.lang.String r5 = "OMX.realtek.video.decoder.tunneled"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x026c }
            if (r5 == 0) goto L_0x0130
        L_0x00f4:
            java.lang.String r5 = "video/dv_hevc"
            goto L_0x0131
        L_0x00f7:
            java.lang.String r5 = "audio/alac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x026c }
            if (r5 == 0) goto L_0x010a
            java.lang.String r5 = "OMX.lge.alac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x026c }
            if (r5 == 0) goto L_0x010a
            java.lang.String r5 = "audio/x-lg-alac"
            goto L_0x0131
        L_0x010a:
            java.lang.String r5 = "audio/flac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x026c }
            if (r5 == 0) goto L_0x011d
            java.lang.String r5 = "OMX.lge.flac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x026c }
            if (r5 == 0) goto L_0x011d
            java.lang.String r5 = "audio/x-lg-flac"
            goto L_0x0131
        L_0x011d:
            java.lang.String r5 = "audio/ac3"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x026c }
            if (r5 == 0) goto L_0x0130
            java.lang.String r5 = "OMX.lge.ac3.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x026c }
            if (r5 == 0) goto L_0x0130
            java.lang.String r5 = "audio/lg-ac3"
            goto L_0x0131
        L_0x0130:
            r5 = 0
        L_0x0131:
            if (r5 == 0) goto L_0x002d
            android.media.MediaCodecInfo$CodecCapabilities r10 = r0.getCapabilitiesForType(r5)     // Catch:{ Exception -> 0x020f }
            boolean r7 = r2.zzd(r4, r5, r10)     // Catch:{ Exception -> 0x020f }
            boolean r11 = r2.zzc(r4, r5, r10)     // Catch:{ Exception -> 0x020f }
            boolean r8 = r1.zzc     // Catch:{ Exception -> 0x020f }
            if (r8 != 0) goto L_0x0146
            if (r11 != 0) goto L_0x002d
            goto L_0x014a
        L_0x0146:
            if (r7 != 0) goto L_0x014a
            goto L_0x002d
        L_0x014a:
            boolean r7 = r2.zzd(r3, r5, r10)     // Catch:{ Exception -> 0x020f }
            boolean r8 = r2.zzc(r3, r5, r10)     // Catch:{ Exception -> 0x020f }
            boolean r11 = r1.zzb     // Catch:{ Exception -> 0x020f }
            r20 = 1
            if (r11 != 0) goto L_0x015b
            if (r8 != 0) goto L_0x002d
            goto L_0x015f
        L_0x015b:
            if (r7 == 0) goto L_0x002d
            r7 = r20
        L_0x015f:
            int r8 = com.google.android.gms.internal.ads.zzet.zza     // Catch:{ Exception -> 0x020f }
            r11 = 29
            if (r8 < r11) goto L_0x016a
            boolean r11 = r0.isHardwareAccelerated()     // Catch:{ Exception -> 0x020f }
            goto L_0x0175
        L_0x016a:
            boolean r11 = zzj(r0, r15)     // Catch:{ Exception -> 0x020f }
            if (r11 != 0) goto L_0x0173
            r11 = r20
            goto L_0x0175
        L_0x0173:
            r11 = r17
        L_0x0175:
            boolean r21 = zzj(r0, r15)     // Catch:{ Exception -> 0x020f }
            r2 = 29
            if (r8 < r2) goto L_0x0182
            boolean r0 = r0.isVendor()     // Catch:{ Exception -> 0x020f }
            goto L_0x01a7
        L_0x0182:
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x020f }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfuf.zza(r0)     // Catch:{ Exception -> 0x020f }
            java.lang.String r2 = "omx.google."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x020f }
            if (r2 != 0) goto L_0x01a5
            java.lang.String r2 = "c2.android."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x020f }
            if (r2 != 0) goto L_0x01a5
            java.lang.String r2 = "c2.google."
            boolean r0 = r0.startsWith(r2)     // Catch:{ Exception -> 0x020f }
            if (r0 != 0) goto L_0x01a5
            r0 = r20
            goto L_0x01a7
        L_0x01a5:
            r0 = r17
        L_0x01a7:
            if (r16 == 0) goto L_0x01ad
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x020f }
            if (r2 == r7) goto L_0x01b3
        L_0x01ad:
            if (r16 != 0) goto L_0x01db
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x01d3 }
            if (r2 != 0) goto L_0x01db
        L_0x01b3:
            r2 = 0
            r19 = 0
            r7 = r12
            r8 = r15
            r9 = r5
            r22 = r12
            r12 = r21
            r18 = r13
            r13 = r0
            r20 = r14
            r14 = r2
            r2 = r15
            r15 = r19
            com.google.android.gms.internal.ads.zzsf r0 = com.google.android.gms.internal.ads.zzsf.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x01cf }
            r6.add(r0)     // Catch:{ Exception -> 0x01cf }
            goto L_0x0260
        L_0x01cf:
            r0 = move-exception
            r1 = r22
            goto L_0x0216
        L_0x01d3:
            r0 = move-exception
            r18 = r13
            r20 = r14
            r2 = r15
            r1 = r12
            goto L_0x0216
        L_0x01db:
            r22 = r12
            r18 = r13
            r20 = r14
            r2 = r15
            if (r16 != 0) goto L_0x0260
            if (r7 == 0) goto L_0x0260
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01cf }
            r7.<init>()     // Catch:{ Exception -> 0x01cf }
            r15 = r22
            r7.append(r15)     // Catch:{ Exception -> 0x020c }
            r7.append(r9)     // Catch:{ Exception -> 0x020c }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x020c }
            r14 = 0
            r19 = 1
            r8 = r2
            r9 = r5
            r12 = r21
            r13 = r0
            r1 = r15
            r15 = r19
            com.google.android.gms.internal.ads.zzsf r0 = com.google.android.gms.internal.ads.zzsf.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x020a }
            r6.add(r0)     // Catch:{ Exception -> 0x020a }
            goto L_0x026b
        L_0x020a:
            r0 = move-exception
            goto L_0x0216
        L_0x020c:
            r0 = move-exception
            r1 = r15
            goto L_0x0216
        L_0x020f:
            r0 = move-exception
            r1 = r12
            r18 = r13
            r20 = r14
            r2 = r15
        L_0x0216:
            int r7 = com.google.android.gms.internal.ads.zzet.zza     // Catch:{ Exception -> 0x026c }
            java.lang.String r8 = "MediaCodecUtil"
            r9 = 23
            if (r7 > r9) goto L_0x023e
            boolean r7 = r6.isEmpty()     // Catch:{ Exception -> 0x026c }
            if (r7 != 0) goto L_0x023e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026c }
            r0.<init>()     // Catch:{ Exception -> 0x026c }
            java.lang.String r5 = "Skipping codec "
            r0.append(r5)     // Catch:{ Exception -> 0x026c }
            r0.append(r1)     // Catch:{ Exception -> 0x026c }
            java.lang.String r1 = " (failed to query capabilities)"
            r0.append(r1)     // Catch:{ Exception -> 0x026c }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x026c }
            com.google.android.gms.internal.ads.zzea.zzc(r8, r0)     // Catch:{ Exception -> 0x026c }
            goto L_0x0260
        L_0x023e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x026c }
            r2.<init>()     // Catch:{ Exception -> 0x026c }
            java.lang.String r3 = "Failed to query codec "
            r2.append(r3)     // Catch:{ Exception -> 0x026c }
            r2.append(r1)     // Catch:{ Exception -> 0x026c }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x026c }
            r2.append(r5)     // Catch:{ Exception -> 0x026c }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x026c }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x026c }
            com.google.android.gms.internal.ads.zzea.zzc(r8, r1)     // Catch:{ Exception -> 0x026c }
            throw r0     // Catch:{ Exception -> 0x026c }
        L_0x0260:
            int r13 = r18 + 1
            r1 = r23
            r15 = r2
            r14 = r20
            r2 = r24
            goto L_0x001b
        L_0x026b:
            return r6
        L_0x026c:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzsw r1 = new com.google.android.gms.internal.ads.zzsw
            r2 = 0
            r1.<init>(r0, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zztc.zzh(com.google.android.gms.internal.ads.zzsu, com.google.android.gms.internal.ads.zzsx):java.util.ArrayList");
    }

    private static void zzi(List list, zztb zztb) {
        Collections.sort(list, new zzsr(zztb));
    }

    private static boolean zzj(MediaCodecInfo mediaCodecInfo, String str) {
        if (zzet.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        if (zzbn.zzg(str)) {
            return true;
        }
        String zza2 = zzfuf.zza(mediaCodecInfo.getName());
        if (zza2.startsWith("arc.")) {
            return false;
        }
        if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google.")) {
            return true;
        }
        if (zza2.startsWith("omx.")) {
            return false;
        }
        if (!zza2.startsWith("c2.")) {
            return true;
        }
        return false;
    }
}
