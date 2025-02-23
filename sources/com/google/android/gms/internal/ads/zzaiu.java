package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzaiu {
    private static final zzfvh zza = zzfvh.zzb(zzfui.zzc(':'));
    private static final zzfvh zzb = zzfvh.zzb(zzfui.zzc('*'));
    private final List zzc = new ArrayList();
    private int zzd = 0;
    private int zze;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzacl r31, com.google.android.gms.internal.ads.zzadf r32, java.util.List r33) throws java.io.IOException {
        /*
            r30 = this;
            r1 = r30
            r0 = r31
            r2 = r32
            int r3 = r1.zzd
            r6 = 1
            if (r3 == 0) goto L_0x01ff
            r7 = 8
            r8 = 2
            r9 = 0
            if (r3 == r6) goto L_0x01cc
            r12 = 2817(0xb01, float:3.947E-42)
            r13 = 2816(0xb00, float:3.946E-42)
            r14 = 2192(0x890, float:3.072E-42)
            r15 = 3
            if (r3 == r8) goto L_0x0152
            long r16 = r31.zzf()
            long r18 = r31.zzd()
            long r20 = r31.zzf()
            long r18 = r18 - r20
            int r3 = r1.zze
            long r4 = (long) r3
            com.google.android.gms.internal.ads.zzek r3 = new com.google.android.gms.internal.ads.zzek
            long r4 = r18 - r4
            int r4 = (int) r4
            r3.<init>((int) r4)
            byte[] r5 = r3.zzM()
            r0.zzi(r5, r9, r4)
            r0 = r9
        L_0x003b:
            java.util.List r4 = r1.zzc
            int r4 = r4.size()
            if (r0 >= r4) goto L_0x014b
            java.util.List r4 = r1.zzc
            java.lang.Object r4 = r4.get(r0)
            com.google.android.gms.internal.ads.zzait r4 = (com.google.android.gms.internal.ads.zzait) r4
            long r9 = r4.zza
            long r9 = r9 - r16
            int r7 = (int) r9
            r3.zzK(r7)
            r7 = 4
            r3.zzL(r7)
            int r9 = r3.zzi()
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzfuj.zzc
            java.lang.String r5 = r3.zzA(r9, r10)
            int r19 = r5.hashCode()
            r22 = -1
            switch(r19) {
                case -1711564334: goto L_0x0093;
                case -1332107749: goto L_0x0089;
                case -1251387154: goto L_0x007f;
                case -830665521: goto L_0x0075;
                case 1760745220: goto L_0x006b;
                default: goto L_0x006a;
            }
        L_0x006a:
            goto L_0x009d
        L_0x006b:
            java.lang.String r11 = "Super_SlowMotion_BGM"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x009d
            r5 = r8
            goto L_0x009f
        L_0x0075:
            java.lang.String r11 = "Super_SlowMotion_Deflickering_On"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x009d
            r5 = r7
            goto L_0x009f
        L_0x007f:
            java.lang.String r11 = "Super_SlowMotion_Data"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x009d
            r5 = r6
            goto L_0x009f
        L_0x0089:
            java.lang.String r11 = "Super_SlowMotion_Edit_Data"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x009d
            r5 = r15
            goto L_0x009f
        L_0x0093:
            java.lang.String r11 = "SlowMotion_Data"
            boolean r5 = r5.equals(r11)
            if (r5 == 0) goto L_0x009d
            r5 = 0
            goto L_0x009f
        L_0x009d:
            r5 = r22
        L_0x009f:
            r11 = 0
            if (r5 == 0) goto L_0x00bb
            if (r5 == r6) goto L_0x00b9
            if (r5 == r8) goto L_0x00b7
            if (r5 == r15) goto L_0x00b4
            if (r5 != r7) goto L_0x00ad
            r5 = 2820(0xb04, float:3.952E-42)
            goto L_0x00bc
        L_0x00ad:
            java.lang.String r0 = "Invalid SEF name"
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r0, r11)
            throw r0
        L_0x00b4:
            r5 = 2819(0xb03, float:3.95E-42)
            goto L_0x00bc
        L_0x00b7:
            r5 = r12
            goto L_0x00bc
        L_0x00b9:
            r5 = r13
            goto L_0x00bc
        L_0x00bb:
            r5 = r14
        L_0x00bc:
            int r4 = r4.zzb
            int r9 = r9 + 8
            int r4 = r4 - r9
            if (r5 == r14) goto L_0x00d9
            if (r5 == r13) goto L_0x00d6
            if (r5 == r12) goto L_0x00d6
            r4 = 2819(0xb03, float:3.95E-42)
            if (r5 == r4) goto L_0x00d6
            r4 = 2820(0xb04, float:3.952E-42)
            if (r5 != r4) goto L_0x00d0
            goto L_0x00d6
        L_0x00d0:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x00d6:
            r7 = r33
            goto L_0x0146
        L_0x00d9:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            java.lang.String r4 = r3.zzA(r4, r10)
            com.google.android.gms.internal.ads.zzfvh r5 = zzb
            java.util.List r4 = r5.zze(r4)
            r9 = 0
        L_0x00e9:
            int r5 = r4.size()
            if (r9 >= r5) goto L_0x013c
            com.google.android.gms.internal.ads.zzfvh r5 = zza
            java.lang.Object r10 = r4.get(r9)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            java.util.List r10 = r5.zze(r10)
            int r5 = r10.size()
            if (r5 != r15) goto L_0x0137
            r5 = 0
            java.lang.Object r23 = r10.get(r5)     // Catch:{ NumberFormatException -> 0x0131 }
            java.lang.String r23 = (java.lang.String) r23     // Catch:{ NumberFormatException -> 0x0131 }
            long r25 = java.lang.Long.parseLong(r23)     // Catch:{ NumberFormatException -> 0x0131 }
            java.lang.Object r23 = r10.get(r6)     // Catch:{ NumberFormatException -> 0x0131 }
            java.lang.String r23 = (java.lang.String) r23     // Catch:{ NumberFormatException -> 0x0131 }
            long r27 = java.lang.Long.parseLong(r23)     // Catch:{ NumberFormatException -> 0x0131 }
            java.lang.Object r10 = r10.get(r8)     // Catch:{ NumberFormatException -> 0x0131 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ NumberFormatException -> 0x0131 }
            int r10 = java.lang.Integer.parseInt(r10)     // Catch:{ NumberFormatException -> 0x0131 }
            int r10 = r10 + -1
            int r29 = r6 << r10
            com.google.android.gms.internal.ads.zzagu r10 = new com.google.android.gms.internal.ads.zzagu     // Catch:{ NumberFormatException -> 0x0131 }
            r24 = r10
            r24.<init>(r25, r27, r29)     // Catch:{ NumberFormatException -> 0x0131 }
            r7.add(r10)     // Catch:{ NumberFormatException -> 0x0131 }
            int r9 = r9 + 1
            goto L_0x00e9
        L_0x0131:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r11, r0)
            throw r0
        L_0x0137:
            com.google.android.gms.internal.ads.zzbo r0 = com.google.android.gms.internal.ads.zzbo.zza(r11, r11)
            throw r0
        L_0x013c:
            com.google.android.gms.internal.ads.zzagv r4 = new com.google.android.gms.internal.ads.zzagv
            r4.<init>(r7)
            r7 = r33
            r7.add(r4)
        L_0x0146:
            int r0 = r0 + 1
            r9 = 0
            goto L_0x003b
        L_0x014b:
            r9 = 0
            r2.zza = r9
            r0 = r6
            goto L_0x021d
        L_0x0152:
            long r3 = r31.zzd()
            int r9 = r1.zze
            int r9 = r9 + -20
            com.google.android.gms.internal.ads.zzek r10 = new com.google.android.gms.internal.ads.zzek
            r10.<init>((int) r9)
            byte[] r11 = r10.zzM()
            r5 = 0
            r0.zzi(r11, r5, r9)
            r0 = 0
        L_0x0168:
            int r11 = r9 / 12
            if (r0 >= r11) goto L_0x01af
            r10.zzL(r8)
            short r11 = r10.zzC()
            if (r11 == r14) goto L_0x0187
            if (r11 == r13) goto L_0x0187
            if (r11 == r12) goto L_0x0187
            r5 = 2819(0xb03, float:3.95E-42)
            if (r11 == r5) goto L_0x0187
            r5 = 2820(0xb04, float:3.952E-42)
            if (r11 == r5) goto L_0x0187
            r10.zzL(r7)
            r33 = r9
            goto L_0x01a2
        L_0x0187:
            int r5 = r1.zze
            long r12 = (long) r5
            long r12 = r3 - r12
            int r5 = r10.zzi()
            r33 = r9
            long r8 = (long) r5
            int r5 = r10.zzi()
            java.util.List r14 = r1.zzc
            com.google.android.gms.internal.ads.zzait r6 = new com.google.android.gms.internal.ads.zzait
            long r12 = r12 - r8
            r6.<init>(r11, r12, r5)
            r14.add(r6)
        L_0x01a2:
            int r0 = r0 + 1
            r9 = r33
            r6 = 1
            r8 = 2
            r12 = 2817(0xb01, float:3.947E-42)
            r13 = 2816(0xb00, float:3.946E-42)
            r14 = 2192(0x890, float:3.072E-42)
            goto L_0x0168
        L_0x01af:
            java.util.List r0 = r1.zzc
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x01bc
            r3 = 0
            r2.zza = r3
            goto L_0x01fd
        L_0x01bc:
            r1.zzd = r15
            java.util.List r0 = r1.zzc
            r3 = 0
            java.lang.Object r0 = r0.get(r3)
            com.google.android.gms.internal.ads.zzait r0 = (com.google.android.gms.internal.ads.zzait) r0
            long r3 = r0.zza
            r2.zza = r3
            goto L_0x01fd
        L_0x01cc:
            r3 = r9
            com.google.android.gms.internal.ads.zzek r4 = new com.google.android.gms.internal.ads.zzek
            r4.<init>((int) r7)
            byte[] r5 = r4.zzM()
            r0.zzi(r5, r3, r7)
            int r3 = r4.zzi()
            int r3 = r3 + r7
            r1.zze = r3
            int r3 = r4.zzg()
            r4 = 1397048916(0x53454654, float:8.4728847E11)
            if (r3 == r4) goto L_0x01ee
            r3 = 0
            r2.zza = r3
            goto L_0x01fd
        L_0x01ee:
            long r3 = r31.zzf()
            int r0 = r1.zze
            int r0 = r0 + -12
            long r5 = (long) r0
            long r3 = r3 - r5
            r2.zza = r3
            r0 = 2
            r1.zzd = r0
        L_0x01fd:
            r0 = 1
            goto L_0x021d
        L_0x01ff:
            r3 = 0
            long r5 = r31.zzd()
            r7 = -1
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto L_0x0217
            r7 = 8
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0212
            goto L_0x0217
        L_0x0212:
            r3 = -8
            long r4 = r5 + r3
            goto L_0x0218
        L_0x0217:
            r4 = r3
        L_0x0218:
            r2.zza = r4
            r0 = 1
            r1.zzd = r0
        L_0x021d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiu.zza(com.google.android.gms.internal.ads.zzacl, com.google.android.gms.internal.ads.zzadf, java.util.List):int");
    }

    public final void zzb() {
        this.zzc.clear();
        this.zzd = 0;
    }
}
