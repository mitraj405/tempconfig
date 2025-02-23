package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzacd implements zzacp {
    private static final int[] zza = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};
    private static final zzacc zzb = new zzacc(new zzabz());
    private static final zzacc zzc = new zzacc(new zzaca());
    private zzfxr zzd;
    private final zzajy zze = new zzajt();

    private final void zzb(int i, List list) {
        switch (i) {
            case 0:
                list.add(new zzalw());
                return;
            case 1:
                list.add(new zzaly());
                return;
            case 2:
                list.add(new zzama(0));
                return;
            case 3:
                list.add(new zzadw(0));
                return;
            case 4:
                zzack zza2 = zzb.zza(0);
                if (zza2 != null) {
                    list.add(zza2);
                    return;
                } else {
                    list.add(new zzaeo(0));
                    return;
                }
            case 5:
                list.add(new zzaeq());
                return;
            case 6:
                list.add(new zzahj(this.zze, 0));
                return;
            case 7:
                list.add(new zzahp(0));
                return;
            case 8:
                list.add(new zzail(this.zze, 0, (zzer) null, (zzaiw) null, zzfxr.zzm(), (zzadp) null));
                list.add(new zzaiq(this.zze, 0));
                return;
            case 9:
                list.add(new zzajg());
                return;
            case 10:
                list.add(new zzanf());
                return;
            case 11:
                if (this.zzd == null) {
                    this.zzd = zzfxr.zzm();
                }
                list.add(new zzano(1, 0, this.zze, new zzer(0), new zzamc(0, this.zzd), 112800));
                return;
            case 12:
                list.add(new zzanz());
                return;
            case 14:
                list.add(new zzaew(0));
                return;
            case 15:
                zzack zza3 = zzc.zza(new Object[0]);
                if (zza3 != null) {
                    list.add(zza3);
                    return;
                }
                return;
            case 16:
                list.add(new zzaeb(0, this.zze));
                return;
            case 17:
                list.add(new zzajr());
                return;
            case 18:
                list.add(new zzaoe());
                return;
            case 19:
                list.add(new zzaej());
                return;
            case 20:
                list.add(new zzaev());
                return;
            case 21:
                list.add(new zzaei());
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01c0, code lost:
        r3 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01c1, code lost:
        switch(r3) {
            case 0: goto L_0x01f8;
            case 1: goto L_0x01f8;
            case 2: goto L_0x01f8;
            case 3: goto L_0x01f5;
            case 4: goto L_0x01f3;
            case 5: goto L_0x01f3;
            case 6: goto L_0x01f3;
            case 7: goto L_0x01f1;
            case 8: goto L_0x01ef;
            case 9: goto L_0x01ec;
            case 10: goto L_0x01e9;
            case 11: goto L_0x01e9;
            case 12: goto L_0x01e9;
            case 13: goto L_0x01e9;
            case 14: goto L_0x01e9;
            case 15: goto L_0x01e7;
            case 16: goto L_0x01e4;
            case 17: goto L_0x01e4;
            case 18: goto L_0x01e4;
            case 19: goto L_0x01e1;
            case 20: goto L_0x01de;
            case 21: goto L_0x01db;
            case 22: goto L_0x01d9;
            case 23: goto L_0x01d7;
            case 24: goto L_0x01d5;
            case 25: goto L_0x01d2;
            case 26: goto L_0x01cf;
            case 27: goto L_0x01cc;
            case 28: goto L_0x01ca;
            case 29: goto L_0x01c8;
            case 30: goto L_0x01c8;
            case 31: goto L_0x01c6;
            default: goto L_0x01c4;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01c6, code lost:
        r3 = 21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01c8, code lost:
        r3 = 20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01ca, code lost:
        r3 = 19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x01cc, code lost:
        r3 = 18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01cf, code lost:
        r3 = 17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x01d2, code lost:
        r3 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01d5, code lost:
        r3 = 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01d7, code lost:
        r3 = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x01d9, code lost:
        r3 = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x01db, code lost:
        r3 = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01de, code lost:
        r3 = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01e1, code lost:
        r3 = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x01e4, code lost:
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x01e7, code lost:
        r3 = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01e9, code lost:
        r3 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01ec, code lost:
        r3 = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01ef, code lost:
        r3 = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x01f1, code lost:
        r3 = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01f3, code lost:
        r3 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01f5, code lost:
        r3 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x01f8, code lost:
        r3 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x03cb  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x03e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzack[] zza(android.net.Uri r25, java.util.Map r26) {
        /*
            r24 = this;
            r1 = r24
            monitor-enter(r24)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0421 }
            r2 = 21
            r0.<init>(r2)     // Catch:{ all -> 0x0421 }
            java.lang.String r3 = "Content-Type"
            r4 = r26
            java.lang.Object r3 = r4.get(r3)     // Catch:{ all -> 0x0421 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x0421 }
            r4 = 0
            if (r3 == 0) goto L_0x0025
            boolean r5 = r3.isEmpty()     // Catch:{ all -> 0x0421 }
            if (r5 == 0) goto L_0x001e
            goto L_0x0025
        L_0x001e:
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0421 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0421 }
            goto L_0x0026
        L_0x0025:
            r3 = 0
        L_0x0026:
            r7 = 7
            r8 = 5
            r9 = 4
            r10 = 3
            r11 = 20
            r12 = 19
            r13 = 14
            r14 = 13
            r15 = 12
            r16 = 11
            r17 = 9
            r18 = 6
            r19 = 15
            r20 = 1
            r21 = 10
            r22 = 8
            r4 = -1
            if (r3 != 0) goto L_0x0048
        L_0x0045:
            r3 = r4
            goto L_0x01f9
        L_0x0048:
            java.lang.String r3 = com.google.android.gms.internal.ads.zzbn.zze(r3)     // Catch:{ all -> 0x0421 }
            int r23 = r3.hashCode()     // Catch:{ all -> 0x0421 }
            switch(r23) {
                case -2123537834: goto L_0x01b6;
                case -1662384011: goto L_0x01ac;
                case -1662384007: goto L_0x01a2;
                case -1662095187: goto L_0x0198;
                case -1606874997: goto L_0x018d;
                case -1487656890: goto L_0x0182;
                case -1487464693: goto L_0x0177;
                case -1487464690: goto L_0x016c;
                case -1487394660: goto L_0x0161;
                case -1487018032: goto L_0x0155;
                case -1248337486: goto L_0x0149;
                case -1079884372: goto L_0x013d;
                case -1004728940: goto L_0x0131;
                case -879272239: goto L_0x0125;
                case -879258763: goto L_0x0119;
                case -387023398: goto L_0x010d;
                case -43467528: goto L_0x0102;
                case 13915911: goto L_0x00f6;
                case 187078296: goto L_0x00eb;
                case 187078297: goto L_0x00e0;
                case 187078669: goto L_0x00d5;
                case 187090232: goto L_0x00c9;
                case 187091926: goto L_0x00be;
                case 187099443: goto L_0x00b2;
                case 1331848029: goto L_0x00a6;
                case 1503095341: goto L_0x009b;
                case 1504578661: goto L_0x008f;
                case 1504619009: goto L_0x0084;
                case 1504824762: goto L_0x0078;
                case 1504831518: goto L_0x006c;
                case 1505118770: goto L_0x0061;
                case 2039520277: goto L_0x0055;
                default: goto L_0x0053;
            }     // Catch:{ all -> 0x0421 }
        L_0x0053:
            goto L_0x01c0
        L_0x0055:
            java.lang.String r5 = "video/x-matroska"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r21
            goto L_0x01c1
        L_0x0061:
            java.lang.String r5 = "audio/webm"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r14
            goto L_0x01c1
        L_0x006c:
            java.lang.String r5 = "audio/mpeg"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r19
            goto L_0x01c1
        L_0x0078:
            java.lang.String r5 = "audio/midi"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r17
            goto L_0x01c1
        L_0x0084:
            java.lang.String r5 = "audio/flac"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r7
            goto L_0x01c1
        L_0x008f:
            java.lang.String r5 = "audio/eac3"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r20
            goto L_0x01c1
        L_0x009b:
            java.lang.String r5 = "audio/3gpp"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r8
            goto L_0x01c1
        L_0x00a6:
            java.lang.String r5 = "video/mp4"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 16
            goto L_0x01c1
        L_0x00b2:
            java.lang.String r5 = "audio/wav"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 22
            goto L_0x01c1
        L_0x00be:
            java.lang.String r5 = "audio/ogg"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r12
            goto L_0x01c1
        L_0x00c9:
            java.lang.String r5 = "audio/mp4"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 17
            goto L_0x01c1
        L_0x00d5:
            java.lang.String r5 = "audio/amr"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r9
            goto L_0x01c1
        L_0x00e0:
            java.lang.String r5 = "audio/ac4"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r10
            goto L_0x01c1
        L_0x00eb:
            java.lang.String r5 = "audio/ac3"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 0
            goto L_0x01c1
        L_0x00f6:
            java.lang.String r5 = "video/x-flv"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r22
            goto L_0x01c1
        L_0x0102:
            java.lang.String r5 = "application/webm"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r13
            goto L_0x01c1
        L_0x010d:
            java.lang.String r5 = "audio/x-matroska"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r16
            goto L_0x01c1
        L_0x0119:
            java.lang.String r5 = "image/png"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 26
            goto L_0x01c1
        L_0x0125:
            java.lang.String r5 = "image/bmp"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 28
            goto L_0x01c1
        L_0x0131:
            java.lang.String r5 = "text/vtt"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 23
            goto L_0x01c1
        L_0x013d:
            java.lang.String r5 = "video/x-msvideo"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 25
            goto L_0x01c1
        L_0x0149:
            java.lang.String r5 = "application/mp4"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 18
            goto L_0x01c1
        L_0x0155:
            java.lang.String r5 = "image/webp"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 27
            goto L_0x01c1
        L_0x0161:
            java.lang.String r5 = "image/jpeg"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 24
            goto L_0x01c1
        L_0x016c:
            java.lang.String r5 = "image/heif"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 29
            goto L_0x01c1
        L_0x0177:
            java.lang.String r5 = "image/heic"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 30
            goto L_0x01c1
        L_0x0182:
            java.lang.String r5 = "image/avif"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 31
            goto L_0x01c1
        L_0x018d:
            java.lang.String r5 = "audio/amr-wb"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r18
            goto L_0x01c1
        L_0x0198:
            java.lang.String r5 = "video/webm"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r15
            goto L_0x01c1
        L_0x01a2:
            java.lang.String r5 = "video/mp2t"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r2
            goto L_0x01c1
        L_0x01ac:
            java.lang.String r5 = "video/mp2p"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = r11
            goto L_0x01c1
        L_0x01b6:
            java.lang.String r5 = "audio/eac3-joc"
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0421 }
            if (r3 == 0) goto L_0x01c0
            r3 = 2
            goto L_0x01c1
        L_0x01c0:
            r3 = r4
        L_0x01c1:
            switch(r3) {
                case 0: goto L_0x01f8;
                case 1: goto L_0x01f8;
                case 2: goto L_0x01f8;
                case 3: goto L_0x01f5;
                case 4: goto L_0x01f3;
                case 5: goto L_0x01f3;
                case 6: goto L_0x01f3;
                case 7: goto L_0x01f1;
                case 8: goto L_0x01ef;
                case 9: goto L_0x01ec;
                case 10: goto L_0x01e9;
                case 11: goto L_0x01e9;
                case 12: goto L_0x01e9;
                case 13: goto L_0x01e9;
                case 14: goto L_0x01e9;
                case 15: goto L_0x01e7;
                case 16: goto L_0x01e4;
                case 17: goto L_0x01e4;
                case 18: goto L_0x01e4;
                case 19: goto L_0x01e1;
                case 20: goto L_0x01de;
                case 21: goto L_0x01db;
                case 22: goto L_0x01d9;
                case 23: goto L_0x01d7;
                case 24: goto L_0x01d5;
                case 25: goto L_0x01d2;
                case 26: goto L_0x01cf;
                case 27: goto L_0x01cc;
                case 28: goto L_0x01ca;
                case 29: goto L_0x01c8;
                case 30: goto L_0x01c8;
                case 31: goto L_0x01c6;
                default: goto L_0x01c4;
            }     // Catch:{ all -> 0x0421 }
        L_0x01c4:
            goto L_0x0045
        L_0x01c6:
            r3 = r2
            goto L_0x01f9
        L_0x01c8:
            r3 = r11
            goto L_0x01f9
        L_0x01ca:
            r3 = r12
            goto L_0x01f9
        L_0x01cc:
            r3 = 18
            goto L_0x01f9
        L_0x01cf:
            r3 = 17
            goto L_0x01f9
        L_0x01d2:
            r3 = 16
            goto L_0x01f9
        L_0x01d5:
            r3 = r13
            goto L_0x01f9
        L_0x01d7:
            r3 = r14
            goto L_0x01f9
        L_0x01d9:
            r3 = r15
            goto L_0x01f9
        L_0x01db:
            r3 = r16
            goto L_0x01f9
        L_0x01de:
            r3 = r21
            goto L_0x01f9
        L_0x01e1:
            r3 = r17
            goto L_0x01f9
        L_0x01e4:
            r3 = r22
            goto L_0x01f9
        L_0x01e7:
            r3 = r7
            goto L_0x01f9
        L_0x01e9:
            r3 = r18
            goto L_0x01f9
        L_0x01ec:
            r3 = r19
            goto L_0x01f9
        L_0x01ef:
            r3 = r8
            goto L_0x01f9
        L_0x01f1:
            r3 = r9
            goto L_0x01f9
        L_0x01f3:
            r3 = r10
            goto L_0x01f9
        L_0x01f5:
            r3 = r20
            goto L_0x01f9
        L_0x01f8:
            r3 = 0
        L_0x01f9:
            if (r3 == r4) goto L_0x01fe
            r1.zzb(r3, r0)     // Catch:{ all -> 0x0421 }
        L_0x01fe:
            java.lang.String r5 = r25.getLastPathSegment()     // Catch:{ all -> 0x0421 }
            if (r5 != 0) goto L_0x0207
        L_0x0204:
            r5 = r4
            goto L_0x03bf
        L_0x0207:
            java.lang.String r6 = ".ac3"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03be
            java.lang.String r6 = ".ec3"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0219
            goto L_0x03be
        L_0x0219:
            java.lang.String r6 = ".ac4"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0225
            r5 = r20
            goto L_0x03bf
        L_0x0225:
            java.lang.String r6 = ".adts"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03bc
            java.lang.String r6 = ".aac"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0237
            goto L_0x03bc
        L_0x0237:
            java.lang.String r6 = ".amr"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0242
            r5 = r10
            goto L_0x03bf
        L_0x0242:
            java.lang.String r6 = ".flac"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x024d
            r5 = r9
            goto L_0x03bf
        L_0x024d:
            java.lang.String r6 = ".flv"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0258
            r5 = r8
            goto L_0x03bf
        L_0x0258:
            java.lang.String r6 = ".mid"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03b9
            java.lang.String r6 = ".midi"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03b9
            java.lang.String r6 = ".smf"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0272
            goto L_0x03b9
        L_0x0272:
            int r6 = r5.length()     // Catch:{ all -> 0x0421 }
            java.lang.String r8 = ".mk"
            int r6 = r6 + -4
            boolean r6 = r5.startsWith(r8, r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03b6
            java.lang.String r6 = ".webm"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x028a
            goto L_0x03b6
        L_0x028a:
            java.lang.String r6 = ".mp3"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0295
            r5 = r7
            goto L_0x03bf
        L_0x0295:
            java.lang.String r6 = ".mp4"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03b3
            int r6 = r5.length()     // Catch:{ all -> 0x0421 }
            int r6 = r6 + -4
            java.lang.String r7 = ".m4"
            boolean r6 = r5.startsWith(r7, r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03b3
            int r6 = r5.length()     // Catch:{ all -> 0x0421 }
            java.lang.String r7 = ".mp4"
            int r6 = r6 + -5
            boolean r6 = r5.startsWith(r7, r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03b3
            int r6 = r5.length()     // Catch:{ all -> 0x0421 }
            int r6 = r6 + -5
            java.lang.String r7 = ".cmf"
            boolean r6 = r5.startsWith(r7, r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x02c9
            goto L_0x03b3
        L_0x02c9:
            int r6 = r5.length()     // Catch:{ all -> 0x0421 }
            int r6 = r6 + -4
            java.lang.String r7 = ".og"
            boolean r6 = r5.startsWith(r7, r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03b0
            java.lang.String r6 = ".opus"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x02e1
            goto L_0x03b0
        L_0x02e1:
            java.lang.String r6 = ".ps"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03ad
            java.lang.String r6 = ".mpeg"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03ad
            java.lang.String r6 = ".mpg"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03ad
            java.lang.String r6 = ".m2p"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0303
            goto L_0x03ad
        L_0x0303:
            java.lang.String r6 = ".ts"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03aa
            int r6 = r5.length()     // Catch:{ all -> 0x0421 }
            int r6 = r6 + -4
            java.lang.String r7 = ".ts"
            boolean r6 = r5.startsWith(r7, r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x031b
            goto L_0x03aa
        L_0x031b:
            java.lang.String r6 = ".wav"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03a8
            java.lang.String r6 = ".wave"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x032d
            goto L_0x03a8
        L_0x032d:
            java.lang.String r6 = ".vtt"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03a6
            java.lang.String r6 = ".webvtt"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x033f
            goto L_0x03a6
        L_0x033f:
            java.lang.String r6 = ".jpg"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03a4
            java.lang.String r6 = ".jpeg"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0350
            goto L_0x03a4
        L_0x0350:
            java.lang.String r6 = ".avi"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x035c
            r5 = 16
            goto L_0x03bf
        L_0x035c:
            java.lang.String r6 = ".png"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0368
            r5 = 17
            goto L_0x03bf
        L_0x0368:
            java.lang.String r6 = ".webp"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0374
            r5 = 18
            goto L_0x03bf
        L_0x0374:
            java.lang.String r6 = ".bmp"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03a2
            java.lang.String r6 = ".dib"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0385
            goto L_0x03a2
        L_0x0385:
            java.lang.String r6 = ".heic"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 != 0) goto L_0x03a0
            java.lang.String r6 = ".heif"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r6 == 0) goto L_0x0396
            goto L_0x03a0
        L_0x0396:
            java.lang.String r6 = ".avif"
            boolean r5 = r5.endsWith(r6)     // Catch:{ all -> 0x0421 }
            if (r5 == 0) goto L_0x0204
            r5 = r2
            goto L_0x03bf
        L_0x03a0:
            r5 = r11
            goto L_0x03bf
        L_0x03a2:
            r5 = r12
            goto L_0x03bf
        L_0x03a4:
            r5 = r13
            goto L_0x03bf
        L_0x03a6:
            r5 = r14
            goto L_0x03bf
        L_0x03a8:
            r5 = r15
            goto L_0x03bf
        L_0x03aa:
            r5 = r16
            goto L_0x03bf
        L_0x03ad:
            r5 = r21
            goto L_0x03bf
        L_0x03b0:
            r5 = r17
            goto L_0x03bf
        L_0x03b3:
            r5 = r22
            goto L_0x03bf
        L_0x03b6:
            r5 = r18
            goto L_0x03bf
        L_0x03b9:
            r5 = r19
            goto L_0x03bf
        L_0x03bc:
            r5 = 2
            goto L_0x03bf
        L_0x03be:
            r5 = 0
        L_0x03bf:
            if (r5 == r4) goto L_0x03c6
            if (r5 == r3) goto L_0x03c6
            r1.zzb(r5, r0)     // Catch:{ all -> 0x0421 }
        L_0x03c6:
            int[] r4 = zza     // Catch:{ all -> 0x0421 }
            r6 = 0
        L_0x03c9:
            if (r6 >= r2) goto L_0x03d7
            r7 = r4[r6]     // Catch:{ all -> 0x0421 }
            if (r7 == r3) goto L_0x03d4
            if (r7 == r5) goto L_0x03d4
            r1.zzb(r7, r0)     // Catch:{ all -> 0x0421 }
        L_0x03d4:
            int r6 = r6 + 1
            goto L_0x03c9
        L_0x03d7:
            int r2 = r0.size()     // Catch:{ all -> 0x0421 }
            com.google.android.gms.internal.ads.zzack[] r2 = new com.google.android.gms.internal.ads.zzack[r2]     // Catch:{ all -> 0x0421 }
            r4 = 0
        L_0x03de:
            int r3 = r0.size()     // Catch:{ all -> 0x0421 }
            if (r4 >= r3) goto L_0x041f
            java.lang.Object r3 = r0.get(r4)     // Catch:{ all -> 0x0421 }
            com.google.android.gms.internal.ads.zzack r3 = (com.google.android.gms.internal.ads.zzack) r3     // Catch:{ all -> 0x0421 }
            com.google.android.gms.internal.ads.zzack r5 = r3.zzc()     // Catch:{ all -> 0x0421 }
            boolean r5 = r5 instanceof com.google.android.gms.internal.ads.zzail     // Catch:{ all -> 0x0421 }
            if (r5 != 0) goto L_0x041a
            com.google.android.gms.internal.ads.zzack r5 = r3.zzc()     // Catch:{ all -> 0x0421 }
            boolean r5 = r5 instanceof com.google.android.gms.internal.ads.zzaiq     // Catch:{ all -> 0x0421 }
            if (r5 != 0) goto L_0x041a
            com.google.android.gms.internal.ads.zzack r5 = r3.zzc()     // Catch:{ all -> 0x0421 }
            boolean r5 = r5 instanceof com.google.android.gms.internal.ads.zzano     // Catch:{ all -> 0x0421 }
            if (r5 != 0) goto L_0x041a
            com.google.android.gms.internal.ads.zzack r5 = r3.zzc()     // Catch:{ all -> 0x0421 }
            boolean r5 = r5 instanceof com.google.android.gms.internal.ads.zzaeb     // Catch:{ all -> 0x0421 }
            if (r5 != 0) goto L_0x041a
            com.google.android.gms.internal.ads.zzack r5 = r3.zzc()     // Catch:{ all -> 0x0421 }
            boolean r5 = r5 instanceof com.google.android.gms.internal.ads.zzahj     // Catch:{ all -> 0x0421 }
            if (r5 != 0) goto L_0x041a
            com.google.android.gms.internal.ads.zzajy r5 = r1.zze     // Catch:{ all -> 0x0421 }
            com.google.android.gms.internal.ads.zzakb r6 = new com.google.android.gms.internal.ads.zzakb     // Catch:{ all -> 0x0421 }
            r6.<init>(r3, r5)     // Catch:{ all -> 0x0421 }
            r3 = r6
        L_0x041a:
            r2[r4] = r3     // Catch:{ all -> 0x0421 }
            int r4 = r4 + 1
            goto L_0x03de
        L_0x041f:
            monitor-exit(r24)
            return r2
        L_0x0421:
            r0 = move-exception
            monitor-exit(r24)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacd.zza(android.net.Uri, java.util.Map):com.google.android.gms.internal.ads.zzack[]");
    }
}
