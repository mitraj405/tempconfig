package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
final class zzakx {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzfxw zze = zzfxw.zzp("auto", "none");
    private static final zzfxw zzf = zzfxw.zzq("dot", "sesame", "circle");
    private static final zzfxw zzg = zzfxw.zzp("filled", "open");
    private static final zzfxw zzh = zzfxw.zzq("after", "before", "outside");
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzakx(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzakx zza(java.lang.String r8) {
        /*
            if (r8 != 0) goto L_0x0004
            goto L_0x0102
        L_0x0004:
            java.lang.String r8 = r8.trim()
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfuf.zza(r8)
            boolean r0 = r8.isEmpty()
            if (r0 != 0) goto L_0x0102
            java.util.regex.Pattern r0 = zzd
            java.lang.String[] r8 = android.text.TextUtils.split(r8, r0)
            com.google.android.gms.internal.ads.zzfxw r8 = com.google.android.gms.internal.ads.zzfxw.zzm(r8)
            com.google.android.gms.internal.ads.zzfxw r0 = zzh
            com.google.android.gms.internal.ads.zzfzs r0 = com.google.android.gms.internal.ads.zzfzt.zzb(r0, r8)
            java.lang.String r1 = "outside"
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzfxx.zza(r0, r1)
            java.lang.String r0 = (java.lang.String) r0
            int r2 = r0.hashCode()
            r3 = -1106037339(0xffffffffbe1335a5, float:-0.14375933)
            r4 = -1
            r5 = 1
            r6 = 0
            if (r2 == r3) goto L_0x0046
            r1 = 92734940(0x58705dc, float:1.2697491E-35)
            if (r2 == r1) goto L_0x003c
            goto L_0x004e
        L_0x003c:
            java.lang.String r1 = "after"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004e
            r0 = r6
            goto L_0x004f
        L_0x0046:
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x004e
            r0 = r5
            goto L_0x004f
        L_0x004e:
            r0 = r4
        L_0x004f:
            r1 = 2
            if (r0 == 0) goto L_0x0058
            if (r0 == r5) goto L_0x0056
            r0 = r5
            goto L_0x0059
        L_0x0056:
            r0 = -2
            goto L_0x0059
        L_0x0058:
            r0 = r1
        L_0x0059:
            com.google.android.gms.internal.ads.zzfxw r2 = zze
            com.google.android.gms.internal.ads.zzfzs r2 = com.google.android.gms.internal.ads.zzfzt.zzb(r2, r8)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x008b
            java.util.Iterator r8 = r2.iterator()
            java.lang.Object r8 = r8.next()
            java.lang.String r8 = (java.lang.String) r8
            int r1 = r8.hashCode()
            r2 = 3387192(0x33af38, float:4.746467E-39)
            if (r1 == r2) goto L_0x0079
            goto L_0x0083
        L_0x0079:
            java.lang.String r1 = "none"
            boolean r8 = r8.equals(r1)
            if (r8 == 0) goto L_0x0083
            r8 = r6
            goto L_0x0084
        L_0x0083:
            r8 = r4
        L_0x0084:
            if (r8 == 0) goto L_0x0088
            goto L_0x00fc
        L_0x0088:
            r4 = r6
            goto L_0x00fc
        L_0x008b:
            com.google.android.gms.internal.ads.zzfxw r2 = zzg
            com.google.android.gms.internal.ads.zzfzs r2 = com.google.android.gms.internal.ads.zzfzt.zzb(r2, r8)
            com.google.android.gms.internal.ads.zzfxw r3 = zzf
            com.google.android.gms.internal.ads.zzfzs r8 = com.google.android.gms.internal.ads.zzfzt.zzb(r3, r8)
            boolean r3 = r2.isEmpty()
            if (r3 == 0) goto L_0x00a5
            boolean r3 = r8.isEmpty()
            if (r3 == 0) goto L_0x00a5
            goto L_0x00fc
        L_0x00a5:
            java.lang.String r3 = "filled"
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzfxx.zza(r2, r3)
            java.lang.String r2 = (java.lang.String) r2
            int r3 = r2.hashCode()
            r7 = 3417674(0x34264a, float:4.789181E-39)
            if (r3 == r7) goto L_0x00b7
            goto L_0x00c1
        L_0x00b7:
            java.lang.String r3 = "open"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00c1
            r2 = r6
            goto L_0x00c2
        L_0x00c1:
            r2 = r4
        L_0x00c2:
            if (r2 == 0) goto L_0x00c6
            r2 = r5
            goto L_0x00c7
        L_0x00c6:
            r2 = r1
        L_0x00c7:
            java.lang.String r3 = "circle"
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzfxx.zza(r8, r3)
            java.lang.String r8 = (java.lang.String) r8
            int r3 = r8.hashCode()
            r7 = -905816648(0xffffffffca0255b8, float:-2135406.0)
            if (r3 == r7) goto L_0x00e8
            r7 = 99657(0x18549, float:1.39649E-40)
            if (r3 == r7) goto L_0x00de
            goto L_0x00f1
        L_0x00de:
            java.lang.String r3 = "dot"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x00f1
            r4 = r6
            goto L_0x00f1
        L_0x00e8:
            java.lang.String r3 = "sesame"
            boolean r8 = r8.equals(r3)
            if (r8 == 0) goto L_0x00f1
            r4 = r5
        L_0x00f1:
            if (r4 == 0) goto L_0x00fa
            if (r4 == r5) goto L_0x00f8
            r6 = r2
            r4 = r5
            goto L_0x00fc
        L_0x00f8:
            r4 = 3
            goto L_0x00fb
        L_0x00fa:
            r4 = r1
        L_0x00fb:
            r6 = r2
        L_0x00fc:
            com.google.android.gms.internal.ads.zzakx r8 = new com.google.android.gms.internal.ads.zzakx
            r8.<init>(r4, r6, r0)
            return r8
        L_0x0102:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakx.zza(java.lang.String):com.google.android.gms.internal.ads.zzakx");
    }
}
