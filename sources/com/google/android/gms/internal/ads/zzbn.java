package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzbn {
    public static final /* synthetic */ int zza = 0;
    private static final ArrayList zzb = new ArrayList();
    private static final Pattern zzc = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zza(java.lang.String r7, java.lang.String r8) {
        /*
            int r0 = r7.hashCode()
            r1 = 7
            r2 = 9
            r3 = 5
            r4 = 6
            r5 = 8
            r6 = 0
            switch(r0) {
                case -2123537834: goto L_0x0084;
                case -1365340241: goto L_0x007a;
                case -1095064472: goto L_0x0070;
                case -53558318: goto L_0x0066;
                case 187078296: goto L_0x005c;
                case 187078297: goto L_0x0052;
                case 550520934: goto L_0x0048;
                case 1504578661: goto L_0x003e;
                case 1504831518: goto L_0x0034;
                case 1504891608: goto L_0x0028;
                case 1505942594: goto L_0x001d;
                case 1556697186: goto L_0x0011;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x008e
        L_0x0011:
            java.lang.String r0 = "audio/true-hd"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = 10
            goto L_0x008f
        L_0x001d:
            java.lang.String r0 = "audio/vnd.dts.hd"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = r1
            goto L_0x008f
        L_0x0028:
            java.lang.String r0 = "audio/opus"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = 11
            goto L_0x008f
        L_0x0034:
            java.lang.String r0 = "audio/mpeg"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = r6
            goto L_0x008f
        L_0x003e:
            java.lang.String r0 = "audio/eac3"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = 3
            goto L_0x008f
        L_0x0048:
            java.lang.String r0 = "audio/vnd.dts.uhd;profile=p2"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = r2
            goto L_0x008f
        L_0x0052:
            java.lang.String r0 = "audio/ac4"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = r3
            goto L_0x008f
        L_0x005c:
            java.lang.String r0 = "audio/ac3"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = 2
            goto L_0x008f
        L_0x0066:
            java.lang.String r0 = "audio/mp4a-latm"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = 1
            goto L_0x008f
        L_0x0070:
            java.lang.String r0 = "audio/vnd.dts"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = r4
            goto L_0x008f
        L_0x007a:
            java.lang.String r0 = "audio/vnd.dts.hd;profile=lbr"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = r5
            goto L_0x008f
        L_0x0084:
            java.lang.String r0 = "audio/eac3-joc"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x008e
            r7 = 4
            goto L_0x008f
        L_0x008e:
            r7 = -1
        L_0x008f:
            switch(r7) {
                case 0: goto L_0x00b5;
                case 1: goto L_0x00a6;
                case 2: goto L_0x00a5;
                case 3: goto L_0x00a4;
                case 4: goto L_0x00a1;
                case 5: goto L_0x009e;
                case 6: goto L_0x009d;
                case 7: goto L_0x009c;
                case 8: goto L_0x009c;
                case 9: goto L_0x0099;
                case 10: goto L_0x0096;
                case 11: goto L_0x0093;
                default: goto L_0x0092;
            }
        L_0x0092:
            return r6
        L_0x0093:
            r7 = 20
            return r7
        L_0x0096:
            r7 = 14
            return r7
        L_0x0099:
            r7 = 30
            return r7
        L_0x009c:
            return r5
        L_0x009d:
            return r1
        L_0x009e:
            r7 = 17
            return r7
        L_0x00a1:
            r7 = 18
            return r7
        L_0x00a4:
            return r4
        L_0x00a5:
            return r3
        L_0x00a6:
            if (r8 != 0) goto L_0x00a9
            return r6
        L_0x00a9:
            com.google.android.gms.internal.ads.zzbm r7 = zzc(r8)
            if (r7 != 0) goto L_0x00b0
            return r6
        L_0x00b0:
            int r7 = r7.zza()
            return r7
        L_0x00b5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbn.zza(java.lang.String, java.lang.String):int");
    }

    public static int zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (zzg(str)) {
            return 1;
        }
        if (zzi(str)) {
            return 2;
        }
        if ("text".equals(zzj(str)) || "application/x-media3-cues".equals(str) || "application/cea-608".equals(str) || "application/cea-708".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/x-subrip".equals(str) || "application/ttml+xml".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-rawcc".equals(str) || "application/vobsub".equals(str) || "application/pgs".equals(str) || "application/dvbsubs".equals(str)) {
            return 3;
        }
        if (zzh(str)) {
            return 4;
        }
        if ("application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str)) {
            return 5;
        }
        if ("application/x-camera-motion".equals(str)) {
            return 6;
        }
        int size = zzb.size();
        for (int i = 0; i < size; i++) {
            String str2 = ((zzbl) zzb.get(i)).zza;
            if (str.equals((Object) null)) {
                return 0;
            }
        }
        return -1;
    }

    public static zzbm zzc(String str) {
        int i;
        Matcher matcher = zzc.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        group.getClass();
        String group2 = matcher.group(2);
        try {
            int parseInt = Integer.parseInt(group, 16);
            if (group2 != null) {
                i = Integer.parseInt(group2);
            } else {
                i = 0;
            }
            return new zzbm(parseInt, i);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static String zzd(int i) {
        if (i == 32) {
            return "video/mp4v-es";
        }
        if (i == 33) {
            return "video/avc";
        }
        if (i == 35) {
            return "video/hevc";
        }
        if (i == 64) {
            return "audio/mp4a-latm";
        }
        if (i == 163) {
            return "video/wvc1";
        }
        if (i == 177) {
            return "video/x-vnd.on2.vp9";
        }
        if (i == 221) {
            return "audio/vorbis";
        }
        if (i == 165) {
            return "audio/ac3";
        }
        if (i == 166) {
            return "audio/eac3";
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return "video/mpeg2";
            case 102:
            case 103:
            case 104:
                return "audio/mp4a-latm";
            case 105:
            case 107:
                return "audio/mpeg";
            case 106:
                return "video/mpeg";
            case 108:
                return "image/jpeg";
            default:
                switch (i) {
                    case 169:
                    case 172:
                        return "audio/vnd.dts";
                    case 170:
                    case 171:
                        return "audio/vnd.dts.hd";
                    case 173:
                        return "audio/opus";
                    case 174:
                        return "audio/ac4";
                    default:
                        return null;
                }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zze(java.lang.String r6) {
        /*
            if (r6 != 0) goto L_0x0004
            r6 = 0
            return r6
        L_0x0004:
            java.lang.String r6 = com.google.android.gms.internal.ads.zzfuf.zza(r6)
            int r0 = r6.hashCode()
            r1 = 5
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1007807498: goto L_0x0047;
                case -979095690: goto L_0x003d;
                case -586683234: goto L_0x0033;
                case -432836268: goto L_0x0029;
                case -432836267: goto L_0x001f;
                case 187090231: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0051
        L_0x0015:
            java.lang.String r0 = "audio/mp3"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = r5
            goto L_0x0052
        L_0x001f:
            java.lang.String r0 = "audio/mpeg-l2"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = r1
            goto L_0x0052
        L_0x0029:
            java.lang.String r0 = "audio/mpeg-l1"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = r2
            goto L_0x0052
        L_0x0033:
            java.lang.String r0 = "audio/x-wav"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = r4
            goto L_0x0052
        L_0x003d:
            java.lang.String r0 = "application/x-mpegurl"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = r3
            goto L_0x0052
        L_0x0047:
            java.lang.String r0 = "audio/x-flac"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x0051
            r0 = 0
            goto L_0x0052
        L_0x0051:
            r0 = -1
        L_0x0052:
            if (r0 == 0) goto L_0x006e
            if (r0 == r5) goto L_0x006b
            if (r0 == r4) goto L_0x0068
            if (r0 == r3) goto L_0x0065
            if (r0 == r2) goto L_0x0062
            if (r0 == r1) goto L_0x005f
            return r6
        L_0x005f:
            java.lang.String r6 = "audio/mpeg-L2"
            return r6
        L_0x0062:
            java.lang.String r6 = "audio/mpeg-L1"
            return r6
        L_0x0065:
            java.lang.String r6 = "application/x-mpegURL"
            return r6
        L_0x0068:
            java.lang.String r6 = "audio/wav"
            return r6
        L_0x006b:
            java.lang.String r6 = "audio/mpeg"
            return r6
        L_0x006e:
            java.lang.String r6 = "audio/flac"
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbn.zze(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzf(java.lang.String r3, java.lang.String r4) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r3.hashCode()
            r2 = 1
            switch(r1) {
                case -2123537834: goto L_0x0076;
                case -432837260: goto L_0x006c;
                case -432837259: goto L_0x0062;
                case -53558318: goto L_0x0057;
                case 187078296: goto L_0x004d;
                case 187094639: goto L_0x0043;
                case 1504578661: goto L_0x0038;
                case 1504619009: goto L_0x002e;
                case 1504831518: goto L_0x0024;
                case 1903231877: goto L_0x0019;
                case 1903589369: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0081
        L_0x000e:
            java.lang.String r1 = "audio/g711-mlaw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 5
            goto L_0x0082
        L_0x0019:
            java.lang.String r1 = "audio/g711-alaw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 4
            goto L_0x0082
        L_0x0024:
            java.lang.String r1 = "audio/mpeg"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = r0
            goto L_0x0082
        L_0x002e:
            java.lang.String r1 = "audio/flac"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 6
            goto L_0x0082
        L_0x0038:
            java.lang.String r1 = "audio/eac3"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 8
            goto L_0x0082
        L_0x0043:
            java.lang.String r1 = "audio/raw"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 3
            goto L_0x0082
        L_0x004d:
            java.lang.String r1 = "audio/ac3"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 7
            goto L_0x0082
        L_0x0057:
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 10
            goto L_0x0082
        L_0x0062:
            java.lang.String r1 = "audio/mpeg-L2"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 2
            goto L_0x0082
        L_0x006c:
            java.lang.String r1 = "audio/mpeg-L1"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = r2
            goto L_0x0082
        L_0x0076:
            java.lang.String r1 = "audio/eac3-joc"
            boolean r3 = r3.equals(r1)
            if (r3 == 0) goto L_0x0081
            r3 = 9
            goto L_0x0082
        L_0x0081:
            r3 = -1
        L_0x0082:
            switch(r3) {
                case 0: goto L_0x009c;
                case 1: goto L_0x009c;
                case 2: goto L_0x009c;
                case 3: goto L_0x009c;
                case 4: goto L_0x009c;
                case 5: goto L_0x009c;
                case 6: goto L_0x009c;
                case 7: goto L_0x009c;
                case 8: goto L_0x009c;
                case 9: goto L_0x009c;
                case 10: goto L_0x0086;
                default: goto L_0x0085;
            }
        L_0x0085:
            return r0
        L_0x0086:
            if (r4 != 0) goto L_0x0089
            return r0
        L_0x0089:
            com.google.android.gms.internal.ads.zzbm r3 = zzc(r4)
            if (r3 != 0) goto L_0x0090
            return r0
        L_0x0090:
            int r3 = r3.zza()
            if (r3 == 0) goto L_0x009b
            r4 = 16
            if (r3 == r4) goto L_0x009b
            return r2
        L_0x009b:
            return r0
        L_0x009c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbn.zzf(java.lang.String, java.lang.String):boolean");
    }

    public static boolean zzg(String str) {
        return "audio".equals(zzj(str));
    }

    public static boolean zzh(String str) {
        if ("image".equals(zzj(str)) || "application/x-image-uri".equals(str)) {
            return true;
        }
        return false;
    }

    public static boolean zzi(String str) {
        return "video".equals(zzj(str));
    }

    private static String zzj(String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }
}
