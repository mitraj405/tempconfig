package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzakr implements zzaka {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzakq zzc;
    private final zzek zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzakr() {
        this((List) null);
    }

    private static float zzc(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i == 1) {
            return 0.5f;
        }
        if (i != 2) {
            return -3.4028235E38f;
        }
        return 0.95f;
    }

    private static int zzd(long j, List list, List list2) {
        int i;
        ArrayList arrayList;
        int size = list.size();
        while (true) {
            size--;
            if (size >= 0) {
                if (((Long) list.get(size)).longValue() != j) {
                    if (((Long) list.get(size)).longValue() < j) {
                        i = size + 1;
                        break;
                    }
                } else {
                    return size;
                }
            } else {
                i = 0;
                break;
            }
        }
        list.add(i, Long.valueOf(j));
        if (i == 0) {
            arrayList = new ArrayList();
        } else {
            arrayList = new ArrayList((Collection) list2.get(i - 1));
        }
        list2.add(i, arrayList);
        return i;
    }

    private static long zze(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        String group = matcher.group(1);
        int i = zzet.zza;
        return (Long.parseLong(group) * 3600000000L) + (Long.parseLong(matcher.group(2)) * 60000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        if (r3.equals("playresx") != false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzf(com.google.android.gms.internal.ads.zzek r7, java.nio.charset.Charset r8) {
        /*
            r6 = this;
        L_0x0000:
            java.lang.String r0 = r7.zzy(r8)
            if (r0 == 0) goto L_0x00dd
            java.lang.String r1 = "[Script Info]"
            boolean r1 = r1.equalsIgnoreCase(r0)
            r2 = 91
            if (r1 == 0) goto L_0x0073
        L_0x0010:
            java.lang.String r0 = r7.zzy(r8)
            if (r0 == 0) goto L_0x0000
            int r1 = r7.zzb()
            if (r1 == 0) goto L_0x0022
            char r1 = r7.zza(r8)
            if (r1 == r2) goto L_0x0000
        L_0x0022:
            java.lang.String r1 = ":"
            java.lang.String[] r0 = r0.split(r1)
            int r1 = r0.length
            r3 = 2
            if (r1 != r3) goto L_0x0010
            r1 = 0
            r3 = r0[r1]
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfuf.zza(r3)
            int r4 = r3.hashCode()
            r5 = 1
            switch(r4) {
                case 1879649548: goto L_0x004a;
                case 1879649549: goto L_0x0040;
                default: goto L_0x003f;
            }
        L_0x003f:
            goto L_0x0053
        L_0x0040:
            java.lang.String r1 = "playresy"
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L_0x0053
            r1 = r5
            goto L_0x0054
        L_0x004a:
            java.lang.String r4 = "playresx"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r1 = -1
        L_0x0054:
            if (r1 == 0) goto L_0x0066
            if (r1 == r5) goto L_0x0059
            goto L_0x0010
        L_0x0059:
            r0 = r0[r5]     // Catch:{ NumberFormatException -> 0x0010 }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x0010 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x0010 }
            r6.zzg = r0     // Catch:{ NumberFormatException -> 0x0010 }
            goto L_0x0010
        L_0x0066:
            r0 = r0[r5]     // Catch:{ NumberFormatException -> 0x0010 }
            java.lang.String r0 = r0.trim()     // Catch:{ NumberFormatException -> 0x0010 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x0010 }
            r6.zzf = r0     // Catch:{ NumberFormatException -> 0x0010 }
            goto L_0x0010
        L_0x0073:
            java.lang.String r1 = "[V4+ Styles]"
            boolean r1 = r1.equalsIgnoreCase(r0)
            java.lang.String r3 = "SsaParser"
            if (r1 == 0) goto L_0x00c6
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r1 = 0
        L_0x0083:
            java.lang.String r4 = r7.zzy(r8)
            if (r4 == 0) goto L_0x00c2
            int r5 = r7.zzb()
            if (r5 == 0) goto L_0x0095
            char r5 = r7.zza(r8)
            if (r5 == r2) goto L_0x00c2
        L_0x0095:
            java.lang.String r5 = "Format:"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x00a2
            com.google.android.gms.internal.ads.zzaks r1 = com.google.android.gms.internal.ads.zzaks.zza(r4)
            goto L_0x0083
        L_0x00a2:
            java.lang.String r5 = "Style:"
            boolean r5 = r4.startsWith(r5)
            if (r5 == 0) goto L_0x0083
            if (r1 != 0) goto L_0x00b6
            java.lang.String r5 = "Skipping 'Style:' line before 'Format:' line: "
            java.lang.String r4 = r5.concat(r4)
            com.google.android.gms.internal.ads.zzea.zzf(r3, r4)
            goto L_0x0083
        L_0x00b6:
            com.google.android.gms.internal.ads.zzaku r4 = com.google.android.gms.internal.ads.zzaku.zzb(r4, r1)
            if (r4 == 0) goto L_0x0083
            java.lang.String r5 = r4.zza
            r0.put(r5, r4)
            goto L_0x0083
        L_0x00c2:
            r6.zze = r0
            goto L_0x0000
        L_0x00c6:
            java.lang.String r1 = "[V4 Styles]"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x00d5
            java.lang.String r0 = "[V4 Styles] are not supported"
            com.google.android.gms.internal.ads.zzea.zze(r3, r0)
            goto L_0x0000
        L_0x00d5:
            java.lang.String r1 = "[Events]"
            boolean r0 = r1.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x0000
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakr.zzf(com.google.android.gms.internal.ads.zzek, java.nio.charset.Charset):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0224, code lost:
        r12.zzh(zzc(r12.zzb()));
        r12.zze(zzc(r12.zza()), 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x023b, code lost:
        r0 = r12.zzp();
        r1 = zzd(r10, r3, r2);
        r4 = zzd(r17, r3, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0249, code lost:
        if (r1 >= r4) goto L_0x025d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x024b, code lost:
        ((java.util.List) r2.get(r1)).add(r0);
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01e2, code lost:
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01e3, code lost:
        r12.zzm(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e8, code lost:
        switch(r0) {
            case -1: goto L_0x01f5;
            case 0: goto L_0x01eb;
            case 1: goto L_0x01f3;
            case 2: goto L_0x01f1;
            case 3: goto L_0x01ef;
            case 4: goto L_0x01f3;
            case 5: goto L_0x01f1;
            case 6: goto L_0x01ef;
            case 7: goto L_0x01f3;
            case 8: goto L_0x01f1;
            case 9: goto L_0x01ef;
            default: goto L_0x01eb;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01eb, code lost:
        defpackage.C0709Uj.t("Unknown alignment: ", r0, "SsaParser");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01ef, code lost:
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01f1, code lost:
        r6 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01f3, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01f5, code lost:
        r6 = Integer.MIN_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01f6, code lost:
        r12.zzi(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01f9, code lost:
        switch(r0) {
            case -1: goto L_0x0204;
            case 0: goto L_0x01fc;
            case 1: goto L_0x0205;
            case 2: goto L_0x0205;
            case 3: goto L_0x0205;
            case 4: goto L_0x0202;
            case 5: goto L_0x0202;
            case 6: goto L_0x0202;
            case 7: goto L_0x0200;
            case 8: goto L_0x0200;
            case 9: goto L_0x0200;
            default: goto L_0x01fc;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01fc, code lost:
        defpackage.C0709Uj.t("Unknown alignment: ", r0, "SsaParser");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0200, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0202, code lost:
        r4 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0204, code lost:
        r4 = Integer.MIN_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0205, code lost:
        r12.zzf(r4);
        r0 = r13.zzb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x020a, code lost:
        if (r0 == null) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x020e, code lost:
        if (r15 == -3.4028235E38f) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0212, code lost:
        if (r14 == -3.4028235E38f) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0214, code lost:
        r12.zzh(r0.x / r14);
        r12.zze(r13.zzb.y / r15, 0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(byte[] r20, int r21, int r22, com.google.android.gms.internal.ads.zzajz r23, com.google.android.gms.internal.ads.zzdn r24) {
        /*
            r19 = this;
            r0 = r19
            r1 = r21
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r4 = r1 + r22
            com.google.android.gms.internal.ads.zzek r5 = r0.zzd
            r6 = r20
            r5.zzI(r6, r4)
            com.google.android.gms.internal.ads.zzek r4 = r0.zzd
            r4.zzK(r1)
            com.google.android.gms.internal.ads.zzek r1 = r0.zzd
            java.nio.charset.Charset r1 = r1.zzB()
            if (r1 != 0) goto L_0x0026
            java.nio.charset.Charset r1 = com.google.android.gms.internal.ads.zzfuj.zzc
        L_0x0026:
            boolean r4 = r0.zzb
            if (r4 != 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzek r4 = r0.zzd
            r0.zzf(r4, r1)
        L_0x002f:
            com.google.android.gms.internal.ads.zzek r4 = r0.zzd
            boolean r5 = r0.zzb
            if (r5 == 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzakq r5 = r0.zzc
            goto L_0x0039
        L_0x0038:
            r5 = 0
        L_0x0039:
            java.lang.String r6 = r4.zzy(r1)
            if (r6 == 0) goto L_0x0267
            java.lang.String r8 = "Format:"
            boolean r8 = r6.startsWith(r8)
            if (r8 == 0) goto L_0x004c
            com.google.android.gms.internal.ads.zzakq r5 = com.google.android.gms.internal.ads.zzakq.zza(r6)
            goto L_0x0039
        L_0x004c:
            java.lang.String r8 = "Dialogue:"
            boolean r9 = r6.startsWith(r8)
            if (r9 == 0) goto L_0x0257
            java.lang.String r9 = "SsaParser"
            if (r5 != 0) goto L_0x0063
            java.lang.String r7 = "Skipping dialogue line before complete format: "
            java.lang.String r6 = r7.concat(r6)
            com.google.android.gms.internal.ads.zzea.zzf(r9, r6)
            goto L_0x0257
        L_0x0063:
            boolean r8 = r6.startsWith(r8)
            com.google.android.gms.internal.ads.zzdi.zzd(r8)
            r8 = 9
            java.lang.String r8 = r6.substring(r8)
            java.lang.String r10 = ","
            int r11 = r5.zze
            java.lang.String[] r8 = r8.split(r10, r11)
            int r10 = r8.length
            int r11 = r5.zze
            if (r10 == r11) goto L_0x0088
            java.lang.String r7 = "Skipping dialogue line with fewer columns than format: "
            java.lang.String r6 = r7.concat(r6)
            com.google.android.gms.internal.ads.zzea.zzf(r9, r6)
            goto L_0x0257
        L_0x0088:
            int r10 = r5.zza
            r10 = r8[r10]
            long r10 = zze(r10)
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            java.lang.String r15 = "Skipping invalid timing: "
            if (r14 != 0) goto L_0x00a4
            java.lang.String r6 = r15.concat(r6)
            com.google.android.gms.internal.ads.zzea.zzf(r9, r6)
            goto L_0x0257
        L_0x00a4:
            int r14 = r5.zzb
            r14 = r8[r14]
            r21 = r8
            long r7 = zze(r14)
            int r12 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
            if (r12 != 0) goto L_0x00bb
            java.lang.String r6 = r15.concat(r6)
            com.google.android.gms.internal.ads.zzea.zzf(r9, r6)
            goto L_0x0257
        L_0x00bb:
            java.util.Map r6 = r0.zze
            if (r6 == 0) goto L_0x00d1
            int r12 = r5.zzc
            r13 = -1
            if (r12 == r13) goto L_0x00d1
            r12 = r21[r12]
            java.lang.String r12 = r12.trim()
            java.lang.Object r6 = r6.get(r12)
            com.google.android.gms.internal.ads.zzaku r6 = (com.google.android.gms.internal.ads.zzaku) r6
            goto L_0x00d2
        L_0x00d1:
            r6 = 0
        L_0x00d2:
            int r12 = r5.zzd
            r12 = r21[r12]
            com.google.android.gms.internal.ads.zzakt r13 = com.google.android.gms.internal.ads.zzakt.zza(r12)
            java.lang.String r12 = com.google.android.gms.internal.ads.zzakt.zzb(r12)
            java.lang.String r14 = "\\N"
            java.lang.String r15 = "\n"
            java.lang.String r12 = r12.replace(r14, r15)
            java.lang.String r14 = "\\n"
            java.lang.String r12 = r12.replace(r14, r15)
            java.lang.String r14 = "\\h"
            java.lang.String r15 = " "
            java.lang.String r12 = r12.replace(r14, r15)
            float r14 = r0.zzf
            float r15 = r0.zzg
            android.text.SpannableString r0 = new android.text.SpannableString
            r0.<init>(r12)
            com.google.android.gms.internal.ads.zzcz r12 = new com.google.android.gms.internal.ads.zzcz
            r12.<init>()
            r12.zzl(r0)
            r16 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            if (r6 == 0) goto L_0x01bb
            r20 = r1
            java.lang.Integer r1 = r6.zzc
            if (r1 == 0) goto L_0x012a
            r21 = r4
            android.text.style.ForegroundColorSpan r4 = new android.text.style.ForegroundColorSpan
            int r1 = r1.intValue()
            r4.<init>(r1)
            int r1 = r0.length()
            r22 = r5
            r5 = 33
            r17 = r7
            r7 = 0
            r0.setSpan(r4, r7, r1, r5)
            goto L_0x0130
        L_0x012a:
            r21 = r4
            r22 = r5
            r17 = r7
        L_0x0130:
            int r1 = r6.zzj
            r4 = 3
            if (r1 != r4) goto L_0x014c
            java.lang.Integer r1 = r6.zzd
            if (r1 == 0) goto L_0x014c
            android.text.style.BackgroundColorSpan r5 = new android.text.style.BackgroundColorSpan
            int r1 = r1.intValue()
            r5.<init>(r1)
            int r1 = r0.length()
            r7 = 33
            r8 = 0
            r0.setSpan(r5, r8, r1, r7)
        L_0x014c:
            float r1 = r6.zze
            int r5 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r5 == 0) goto L_0x015b
            int r5 = (r15 > r16 ? 1 : (r15 == r16 ? 0 : -1))
            if (r5 == 0) goto L_0x015b
            float r1 = r1 / r15
            r5 = 1
            r12.zzn(r1, r5)
        L_0x015b:
            boolean r1 = r6.zzf
            if (r1 == 0) goto L_0x0184
            boolean r1 = r6.zzg
            if (r1 == 0) goto L_0x0173
            android.text.style.StyleSpan r1 = new android.text.style.StyleSpan
            r1.<init>(r4)
            int r4 = r0.length()
            r5 = 33
            r7 = 0
            r0.setSpan(r1, r7, r4, r5)
            goto L_0x0199
        L_0x0173:
            r5 = 33
            r7 = 0
            android.text.style.StyleSpan r1 = new android.text.style.StyleSpan
            r4 = 1
            r1.<init>(r4)
            int r4 = r0.length()
            r0.setSpan(r1, r7, r4, r5)
            goto L_0x0199
        L_0x0184:
            r5 = 33
            r7 = 0
            boolean r1 = r6.zzg
            if (r1 == 0) goto L_0x0199
            android.text.style.StyleSpan r1 = new android.text.style.StyleSpan
            r4 = 2
            r1.<init>(r4)
            int r8 = r0.length()
            r0.setSpan(r1, r7, r8, r5)
            goto L_0x019a
        L_0x0199:
            r4 = 2
        L_0x019a:
            boolean r1 = r6.zzh
            if (r1 == 0) goto L_0x01aa
            android.text.style.UnderlineSpan r1 = new android.text.style.UnderlineSpan
            r1.<init>()
            int r8 = r0.length()
            r0.setSpan(r1, r7, r8, r5)
        L_0x01aa:
            boolean r1 = r6.zzi
            if (r1 == 0) goto L_0x01c4
            android.text.style.StrikethroughSpan r1 = new android.text.style.StrikethroughSpan
            r1.<init>()
            int r8 = r0.length()
            r0.setSpan(r1, r7, r8, r5)
            goto L_0x01c4
        L_0x01bb:
            r20 = r1
            r21 = r4
            r22 = r5
            r17 = r7
            r4 = 2
        L_0x01c4:
            int r0 = r13.zza
            r1 = -1
            if (r0 == r1) goto L_0x01ca
            goto L_0x01d0
        L_0x01ca:
            if (r6 == 0) goto L_0x01cf
            int r0 = r6.zzb
            goto L_0x01d0
        L_0x01cf:
            r0 = -1
        L_0x01d0:
            java.lang.String r1 = "Unknown alignment: "
            switch(r0) {
                case -1: goto L_0x01e2;
                case 0: goto L_0x01d5;
                case 1: goto L_0x01df;
                case 2: goto L_0x01dc;
                case 3: goto L_0x01d9;
                case 4: goto L_0x01df;
                case 5: goto L_0x01dc;
                case 6: goto L_0x01d9;
                case 7: goto L_0x01df;
                case 8: goto L_0x01dc;
                case 9: goto L_0x01d9;
                default: goto L_0x01d5;
            }
        L_0x01d5:
            defpackage.C0709Uj.t(r1, r0, r9)
            goto L_0x01e2
        L_0x01d9:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            goto L_0x01e3
        L_0x01dc:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_CENTER
            goto L_0x01e3
        L_0x01df:
            android.text.Layout$Alignment r5 = android.text.Layout.Alignment.ALIGN_NORMAL
            goto L_0x01e3
        L_0x01e2:
            r5 = 0
        L_0x01e3:
            r12.zzm(r5)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            switch(r0) {
                case -1: goto L_0x01f5;
                case 0: goto L_0x01eb;
                case 1: goto L_0x01f3;
                case 2: goto L_0x01f1;
                case 3: goto L_0x01ef;
                case 4: goto L_0x01f3;
                case 5: goto L_0x01f1;
                case 6: goto L_0x01ef;
                case 7: goto L_0x01f3;
                case 8: goto L_0x01f1;
                case 9: goto L_0x01ef;
                default: goto L_0x01eb;
            }
        L_0x01eb:
            defpackage.C0709Uj.t(r1, r0, r9)
            goto L_0x01f5
        L_0x01ef:
            r6 = r4
            goto L_0x01f6
        L_0x01f1:
            r6 = 1
            goto L_0x01f6
        L_0x01f3:
            r6 = 0
            goto L_0x01f6
        L_0x01f5:
            r6 = r5
        L_0x01f6:
            r12.zzi(r6)
            switch(r0) {
                case -1: goto L_0x0204;
                case 0: goto L_0x01fc;
                case 1: goto L_0x0205;
                case 2: goto L_0x0205;
                case 3: goto L_0x0205;
                case 4: goto L_0x0202;
                case 5: goto L_0x0202;
                case 6: goto L_0x0202;
                case 7: goto L_0x0200;
                case 8: goto L_0x0200;
                case 9: goto L_0x0200;
                default: goto L_0x01fc;
            }
        L_0x01fc:
            defpackage.C0709Uj.t(r1, r0, r9)
            goto L_0x0204
        L_0x0200:
            r4 = 0
            goto L_0x0205
        L_0x0202:
            r4 = 1
            goto L_0x0205
        L_0x0204:
            r4 = r5
        L_0x0205:
            r12.zzf(r4)
            android.graphics.PointF r0 = r13.zzb
            if (r0 == 0) goto L_0x0224
            int r1 = (r15 > r16 ? 1 : (r15 == r16 ? 0 : -1))
            if (r1 == 0) goto L_0x0224
            int r1 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r1 == 0) goto L_0x0224
            float r0 = r0.x
            float r0 = r0 / r14
            r12.zzh(r0)
            android.graphics.PointF r0 = r13.zzb
            float r0 = r0.y
            float r0 = r0 / r15
            r1 = 0
            r12.zze(r0, r1)
            goto L_0x023b
        L_0x0224:
            r0 = 0
            int r1 = r12.zzb()
            float r1 = zzc(r1)
            r12.zzh(r1)
            int r1 = r12.zza()
            float r1 = zzc(r1)
            r12.zze(r1, r0)
        L_0x023b:
            com.google.android.gms.internal.ads.zzdb r0 = r12.zzp()
            int r1 = zzd(r10, r3, r2)
            r4 = r17
            int r4 = zzd(r4, r3, r2)
        L_0x0249:
            if (r1 >= r4) goto L_0x025d
            java.lang.Object r5 = r2.get(r1)
            java.util.List r5 = (java.util.List) r5
            r5.add(r0)
            int r1 = r1 + 1
            goto L_0x0249
        L_0x0257:
            r20 = r1
            r21 = r4
            r22 = r5
        L_0x025d:
            r0 = r19
            r1 = r20
            r4 = r21
            r5 = r22
            goto L_0x0039
        L_0x0267:
            r0 = 0
            r1 = r0
        L_0x0269:
            int r4 = r2.size()
            if (r1 >= r4) goto L_0x02c1
            java.lang.Object r4 = r2.get(r1)
            r6 = r4
            java.util.List r6 = (java.util.List) r6
            boolean r4 = r6.isEmpty()
            if (r4 == 0) goto L_0x0283
            if (r1 == 0) goto L_0x0282
            r4 = 1
            r5 = r24
            goto L_0x02b9
        L_0x0282:
            r1 = r0
        L_0x0283:
            int r4 = r2.size()
            int r4 = r4 + -1
            if (r1 == r4) goto L_0x02bb
            java.lang.Object r4 = r3.get(r1)
            java.lang.Long r4 = (java.lang.Long) r4
            long r7 = r4.longValue()
            int r4 = r1 + 1
            java.lang.Object r4 = r3.get(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            java.lang.Object r9 = r3.get(r1)
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            long r9 = r4 - r9
            com.google.android.gms.internal.ads.zzajs r4 = new com.google.android.gms.internal.ads.zzajs
            r5 = r4
            r5.<init>(r6, r7, r9)
            r5 = r24
            r5.zza(r4)
            r4 = 1
        L_0x02b9:
            int r1 = r1 + r4
            goto L_0x0269
        L_0x02bb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x02c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzakr.zza(byte[], int, int, com.google.android.gms.internal.ads.zzajz, com.google.android.gms.internal.ads.zzdn):void");
    }

    public zzakr(List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzek();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String zzA = zzet.zzA((byte[]) list.get(0));
        zzdi.zzd(zzA.startsWith("Format:"));
        zzakq zza2 = zzakq.zza(zzA);
        zza2.getClass();
        this.zzc = zza2;
        zzf(new zzek((byte[]) list.get(1)), zzfuj.zzc);
    }

    public final /* synthetic */ void zzb() {
    }
}
