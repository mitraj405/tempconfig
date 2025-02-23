package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.view.Surface;
import com.facebook.ads.AdError;
import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzaaa extends zzso implements zzaag {
    private static final int[] zzb = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private zzcp zzA = zzcp.zza;
    private zzcp zzB = null;
    private boolean zzC;
    private int zzD = -1000;
    private int zzE = 0;
    private zzaae zzF;
    private final Context zze;
    private final zzabc zzf;
    private final zzaax zzg;
    private final boolean zzh = "NVIDIA".equals(zzet.zzc);
    private final zzaah zzi;
    private final zzaaf zzj = new zzaaf();
    private boolean zzk;
    private boolean zzl;
    private zzzz zzm;
    private boolean zzn;
    private boolean zzo;
    /* access modifiers changed from: private */
    public Surface zzp;
    private zzaad zzq;
    private boolean zzr;
    private int zzs = 1;
    private long zzt;
    private int zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private int zzy;
    private long zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaaa(Context context, zzsa zzsa, zzsq zzsq, long j, boolean z, Handler handler, zzaay zzaay, int i, float f) {
        super(2, zzsa, zzsq, false, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        Handler handler2 = handler;
        zzaay zzaay2 = zzaay;
        this.zzg = new zzaax(handler, zzaay);
        zzzt zzc2 = new zzzg(applicationContext, new zzaah(applicationContext, this, 0)).zzc();
        this.zzf = zzc2.zzi();
        zzaah zzh2 = zzc2.zzh();
        zzdi.zzb(zzh2);
        this.zzi = zzh2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:321:0x04bf, code lost:
        if (r0.equals("deb") != false) goto L_0x0787;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:511:0x079d, code lost:
        if (r10 != 0) goto L_0x079f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zzaS(java.lang.String r17) {
        /*
            java.lang.String r0 = "OMX.google"
            r1 = r17
            boolean r0 = r1.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            java.lang.Class<com.google.android.gms.internal.ads.zzaaa> r2 = com.google.android.gms.internal.ads.zzaaa.class
            monitor-enter(r2)
            boolean r0 = zzc     // Catch:{ all -> 0x07a7 }
            if (r0 != 0) goto L_0x07a3
            int r0 = com.google.android.gms.internal.ads.zzet.zza     // Catch:{ all -> 0x07a7 }
            r3 = 28
            r4 = 5
            r5 = 6
            r6 = 4
            r7 = 7
            r8 = 2
            r9 = 3
            r10 = -1
            r11 = 1
            if (r0 > r3) goto L_0x0083
            java.lang.String r12 = com.google.android.gms.internal.ads.zzet.zzb     // Catch:{ all -> 0x07a7 }
            int r13 = r12.hashCode()     // Catch:{ all -> 0x07a7 }
            switch(r13) {
                case -1339091551: goto L_0x0071;
                case -1220081023: goto L_0x0067;
                case -1220066608: goto L_0x005d;
                case -1012436106: goto L_0x0053;
                case -760312546: goto L_0x0049;
                case -64886864: goto L_0x003f;
                case 3415681: goto L_0x0035;
                case 825323514: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x007b
        L_0x002b:
            java.lang.String r13 = "machuca"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = r4
            goto L_0x007c
        L_0x0035:
            java.lang.String r13 = "once"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = r5
            goto L_0x007c
        L_0x003f:
            java.lang.String r13 = "magnolia"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = r6
            goto L_0x007c
        L_0x0049:
            java.lang.String r13 = "aquaman"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = r1
            goto L_0x007c
        L_0x0053:
            java.lang.String r13 = "oneday"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = r7
            goto L_0x007c
        L_0x005d:
            java.lang.String r13 = "dangalUHD"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = r8
            goto L_0x007c
        L_0x0067:
            java.lang.String r13 = "dangalFHD"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = r9
            goto L_0x007c
        L_0x0071:
            java.lang.String r13 = "dangal"
            boolean r12 = r12.equals(r13)
            if (r12 == 0) goto L_0x007b
            r12 = r11
            goto L_0x007c
        L_0x007b:
            r12 = r10
        L_0x007c:
            switch(r12) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                default: goto L_0x007f;
            }
        L_0x007f:
            goto L_0x0083
        L_0x0080:
            r1 = r11
            goto L_0x079f
        L_0x0083:
            r12 = 27
            if (r0 > r12) goto L_0x0092
            java.lang.String r13 = "HWEML"
            java.lang.String r14 = com.google.android.gms.internal.ads.zzet.zzb     // Catch:{ all -> 0x07a7 }
            boolean r13 = r13.equals(r14)     // Catch:{ all -> 0x07a7 }
            if (r13 == 0) goto L_0x0092
            goto L_0x0080
        L_0x0092:
            java.lang.String r13 = com.google.android.gms.internal.ads.zzet.zzd     // Catch:{ all -> 0x07a7 }
            int r14 = r13.hashCode()     // Catch:{ all -> 0x07a7 }
            r15 = 8
            switch(r14) {
                case -349662828: goto L_0x00ef;
                case -321033677: goto L_0x00e5;
                case 2006354: goto L_0x00db;
                case 2006367: goto L_0x00d1;
                case 2006371: goto L_0x00c7;
                case 1785421873: goto L_0x00bd;
                case 1785421876: goto L_0x00b3;
                case 1798172390: goto L_0x00a9;
                case 2119412532: goto L_0x009f;
                default: goto L_0x009d;
            }
        L_0x009d:
            goto L_0x00f9
        L_0x009f:
            java.lang.String r14 = "AFTEUFF014"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = r4
            goto L_0x00fa
        L_0x00a9:
            java.lang.String r14 = "AFTSO001"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = r15
            goto L_0x00fa
        L_0x00b3:
            java.lang.String r14 = "AFTEU014"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = r6
            goto L_0x00fa
        L_0x00bd:
            java.lang.String r14 = "AFTEU011"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = r9
            goto L_0x00fa
        L_0x00c7:
            java.lang.String r14 = "AFTR"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = r8
            goto L_0x00fa
        L_0x00d1:
            java.lang.String r14 = "AFTN"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = r11
            goto L_0x00fa
        L_0x00db:
            java.lang.String r14 = "AFTA"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = r1
            goto L_0x00fa
        L_0x00e5:
            java.lang.String r14 = "AFTKMST12"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = r7
            goto L_0x00fa
        L_0x00ef:
            java.lang.String r14 = "AFTJMST12"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00f9
            r14 = r5
            goto L_0x00fa
        L_0x00f9:
            r14 = r10
        L_0x00fa:
            switch(r14) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                case 8: goto L_0x0080;
                default: goto L_0x00fd;
            }
        L_0x00fd:
            r14 = 26
            if (r0 > r14) goto L_0x079f
            java.lang.String r0 = com.google.android.gms.internal.ads.zzet.zzb     // Catch:{ all -> 0x07a7 }
            int r16 = r0.hashCode()     // Catch:{ all -> 0x07a7 }
            switch(r16) {
                case -2144781245: goto L_0x077b;
                case -2144781185: goto L_0x0770;
                case -2144781160: goto L_0x0765;
                case -2097309513: goto L_0x075a;
                case -2022874474: goto L_0x074f;
                case -1978993182: goto L_0x0744;
                case -1978990237: goto L_0x0739;
                case -1936688988: goto L_0x072e;
                case -1936688066: goto L_0x0723;
                case -1936688065: goto L_0x0717;
                case -1931988508: goto L_0x070b;
                case -1885099851: goto L_0x06ff;
                case -1696512866: goto L_0x06f3;
                case -1680025915: goto L_0x06e7;
                case -1615810839: goto L_0x06db;
                case -1600724499: goto L_0x06cf;
                case -1554255044: goto L_0x06c3;
                case -1481772737: goto L_0x06b7;
                case -1481772730: goto L_0x06ab;
                case -1481772729: goto L_0x069f;
                case -1320080169: goto L_0x0693;
                case -1217592143: goto L_0x0687;
                case -1180384755: goto L_0x067b;
                case -1139198265: goto L_0x066f;
                case -1052835013: goto L_0x0663;
                case -993250464: goto L_0x0658;
                case -993250458: goto L_0x064d;
                case -965403638: goto L_0x0641;
                case -958336948: goto L_0x0635;
                case -879245230: goto L_0x0629;
                case -842500323: goto L_0x061d;
                case -821392978: goto L_0x0611;
                case -797483286: goto L_0x0605;
                case -794946968: goto L_0x05f9;
                case -788334647: goto L_0x05ed;
                case -782144577: goto L_0x05e1;
                case -575125681: goto L_0x05d5;
                case -521118391: goto L_0x05c9;
                case -430914369: goto L_0x05bd;
                case -290434366: goto L_0x05b1;
                case -282781963: goto L_0x05a5;
                case -277133239: goto L_0x0599;
                case -173639913: goto L_0x058d;
                case -56598463: goto L_0x0581;
                case 2126: goto L_0x0575;
                case 2564: goto L_0x0569;
                case 2715: goto L_0x055d;
                case 2719: goto L_0x0551;
                case 3091: goto L_0x0545;
                case 3483: goto L_0x0539;
                case 73405: goto L_0x052d;
                case 75537: goto L_0x0521;
                case 75739: goto L_0x0515;
                case 76779: goto L_0x0509;
                case 78669: goto L_0x04fd;
                case 79305: goto L_0x04f1;
                case 80618: goto L_0x04e5;
                case 88274: goto L_0x04d9;
                case 98846: goto L_0x04ce;
                case 98848: goto L_0x04c3;
                case 99329: goto L_0x04b9;
                case 101481: goto L_0x04ad;
                case 1513190: goto L_0x04a2;
                case 1514184: goto L_0x0497;
                case 1514185: goto L_0x048c;
                case 2133089: goto L_0x0480;
                case 2133091: goto L_0x0474;
                case 2133120: goto L_0x0468;
                case 2133151: goto L_0x045c;
                case 2133182: goto L_0x0450;
                case 2133184: goto L_0x0444;
                case 2436959: goto L_0x0438;
                case 2463773: goto L_0x042c;
                case 2464648: goto L_0x0420;
                case 2689555: goto L_0x0414;
                case 3154429: goto L_0x0408;
                case 3284551: goto L_0x03fc;
                case 3351335: goto L_0x03f0;
                case 3386211: goto L_0x03e4;
                case 41325051: goto L_0x03d8;
                case 51349633: goto L_0x03cd;
                case 51350594: goto L_0x03c2;
                case 55178625: goto L_0x03b6;
                case 61542055: goto L_0x03ab;
                case 65355429: goto L_0x039f;
                case 66214468: goto L_0x0393;
                case 66214470: goto L_0x0387;
                case 66214473: goto L_0x037b;
                case 66215429: goto L_0x036f;
                case 66215431: goto L_0x0363;
                case 66215433: goto L_0x0357;
                case 66216390: goto L_0x034b;
                case 76402249: goto L_0x033f;
                case 76404105: goto L_0x0333;
                case 76404911: goto L_0x0327;
                case 80963634: goto L_0x031b;
                case 82882791: goto L_0x030f;
                case 98715550: goto L_0x0303;
                case 101370885: goto L_0x02f7;
                case 102844228: goto L_0x02eb;
                case 165221241: goto L_0x02e0;
                case 182191441: goto L_0x02d4;
                case 245388979: goto L_0x02c8;
                case 287431619: goto L_0x02bc;
                case 307593612: goto L_0x02b0;
                case 308517133: goto L_0x02a4;
                case 316215098: goto L_0x0298;
                case 316215116: goto L_0x028c;
                case 316246811: goto L_0x0280;
                case 316246818: goto L_0x0274;
                case 407160593: goto L_0x0268;
                case 507412548: goto L_0x025c;
                case 793982701: goto L_0x0250;
                case 794038622: goto L_0x0244;
                case 794040393: goto L_0x0238;
                case 835649806: goto L_0x022c;
                case 917340916: goto L_0x0220;
                case 958008161: goto L_0x0214;
                case 1060579533: goto L_0x0208;
                case 1150207623: goto L_0x01fc;
                case 1176899427: goto L_0x01f0;
                case 1280332038: goto L_0x01e4;
                case 1306947716: goto L_0x01d8;
                case 1349174697: goto L_0x01cc;
                case 1522194893: goto L_0x01c0;
                case 1691543273: goto L_0x01b4;
                case 1691544261: goto L_0x01a8;
                case 1709443163: goto L_0x019c;
                case 1865889110: goto L_0x0190;
                case 1906253259: goto L_0x0184;
                case 1977196784: goto L_0x0178;
                case 2006372676: goto L_0x016c;
                case 2019281702: goto L_0x0160;
                case 2029784656: goto L_0x0154;
                case 2030379515: goto L_0x0148;
                case 2033393791: goto L_0x013c;
                case 2047190025: goto L_0x0130;
                case 2047252157: goto L_0x0124;
                case 2048319463: goto L_0x0118;
                case 2048855701: goto L_0x010c;
                default: goto L_0x010a;
            }
        L_0x010a:
            goto L_0x0786
        L_0x010c:
            java.lang.String r3 = "HWWAS-H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 66
            goto L_0x0787
        L_0x0118:
            java.lang.String r3 = "HWVNS-H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 65
            goto L_0x0787
        L_0x0124:
            java.lang.String r3 = "ELUGA_Prim"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 33
            goto L_0x0787
        L_0x0130:
            java.lang.String r3 = "ELUGA_Note"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 32
            goto L_0x0787
        L_0x013c:
            java.lang.String r3 = "ASUS_X00AD_2"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 14
            goto L_0x0787
        L_0x0148:
            java.lang.String r3 = "HWCAM-H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 64
            goto L_0x0787
        L_0x0154:
            java.lang.String r3 = "HWBLN-H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 63
            goto L_0x0787
        L_0x0160:
            java.lang.String r3 = "DM-01K"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 29
            goto L_0x0787
        L_0x016c:
            java.lang.String r3 = "BRAVIA_ATV3_4K"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 19
            goto L_0x0787
        L_0x0178:
            java.lang.String r3 = "Infinix-X572"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 69
            goto L_0x0787
        L_0x0184:
            java.lang.String r3 = "PB2-670M"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 100
            goto L_0x0787
        L_0x0190:
            java.lang.String r3 = "santoni"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 117(0x75, float:1.64E-43)
            goto L_0x0787
        L_0x019c:
            java.lang.String r3 = "iball8735_9806"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 68
            goto L_0x0787
        L_0x01a8:
            java.lang.String r3 = "CPH1715"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 24
            goto L_0x0787
        L_0x01b4:
            java.lang.String r3 = "CPH1609"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 23
            goto L_0x0787
        L_0x01c0:
            java.lang.String r3 = "woods_f"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 133(0x85, float:1.86E-43)
            goto L_0x0787
        L_0x01cc:
            java.lang.String r3 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 61
            goto L_0x0787
        L_0x01d8:
            java.lang.String r3 = "EverStar_S"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 35
            goto L_0x0787
        L_0x01e4:
            java.lang.String r3 = "hwALE-H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 62
            goto L_0x0787
        L_0x01f0:
            java.lang.String r3 = "itel_S41"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 71
            goto L_0x0787
        L_0x01fc:
            java.lang.String r3 = "LS-5017"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 78
            goto L_0x0787
        L_0x0208:
            java.lang.String r3 = "panell_d"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 96
            goto L_0x0787
        L_0x0214:
            java.lang.String r3 = "j2xlteins"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 72
            goto L_0x0787
        L_0x0220:
            java.lang.String r3 = "A7000plus"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 10
            goto L_0x0787
        L_0x022c:
            java.lang.String r3 = "manning"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 81
            goto L_0x0787
        L_0x0238:
            java.lang.String r3 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 59
            goto L_0x0787
        L_0x0244:
            java.lang.String r3 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 58
            goto L_0x0787
        L_0x0250:
            java.lang.String r3 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 57
            goto L_0x0787
        L_0x025c:
            java.lang.String r3 = "QM16XE_U"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 114(0x72, float:1.6E-43)
            goto L_0x0787
        L_0x0268:
            java.lang.String r3 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 106(0x6a, float:1.49E-43)
            goto L_0x0787
        L_0x0274:
            java.lang.String r3 = "TB3-850M"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 125(0x7d, float:1.75E-43)
            goto L_0x0787
        L_0x0280:
            java.lang.String r3 = "TB3-850F"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 124(0x7c, float:1.74E-43)
            goto L_0x0787
        L_0x028c:
            java.lang.String r3 = "TB3-730X"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 123(0x7b, float:1.72E-43)
            goto L_0x0787
        L_0x0298:
            java.lang.String r3 = "TB3-730F"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 122(0x7a, float:1.71E-43)
            goto L_0x0787
        L_0x02a4:
            java.lang.String r3 = "A7020a48"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 12
            goto L_0x0787
        L_0x02b0:
            java.lang.String r3 = "A7010a48"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 11
            goto L_0x0787
        L_0x02bc:
            java.lang.String r3 = "griffin"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 60
            goto L_0x0787
        L_0x02c8:
            java.lang.String r3 = "marino_f"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 82
            goto L_0x0787
        L_0x02d4:
            java.lang.String r3 = "CPY83_I00"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 25
            goto L_0x0787
        L_0x02e0:
            java.lang.String r3 = "A2016a40"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = r15
            goto L_0x0787
        L_0x02eb:
            java.lang.String r3 = "le_x6"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 77
            goto L_0x0787
        L_0x02f7:
            java.lang.String r3 = "l5460"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 76
            goto L_0x0787
        L_0x0303:
            java.lang.String r3 = "i9031"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 67
            goto L_0x0787
        L_0x030f:
            java.lang.String r3 = "X3_HK"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 135(0x87, float:1.89E-43)
            goto L_0x0787
        L_0x031b:
            java.lang.String r3 = "V23GB"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x0787
        L_0x0327:
            java.lang.String r3 = "Q4310"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 112(0x70, float:1.57E-43)
            goto L_0x0787
        L_0x0333:
            java.lang.String r3 = "Q4260"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 110(0x6e, float:1.54E-43)
            goto L_0x0787
        L_0x033f:
            java.lang.String r3 = "PRO7S"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 108(0x6c, float:1.51E-43)
            goto L_0x0787
        L_0x034b:
            java.lang.String r3 = "F3311"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 48
            goto L_0x0787
        L_0x0357:
            java.lang.String r3 = "F3215"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 47
            goto L_0x0787
        L_0x0363:
            java.lang.String r3 = "F3213"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 46
            goto L_0x0787
        L_0x036f:
            java.lang.String r3 = "F3211"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 45
            goto L_0x0787
        L_0x037b:
            java.lang.String r3 = "F3116"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 44
            goto L_0x0787
        L_0x0387:
            java.lang.String r3 = "F3113"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 43
            goto L_0x0787
        L_0x0393:
            java.lang.String r3 = "F3111"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 42
            goto L_0x0787
        L_0x039f:
            java.lang.String r3 = "E5643"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 30
            goto L_0x0787
        L_0x03ab:
            java.lang.String r3 = "A1601"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = r7
            goto L_0x0787
        L_0x03b6:
            java.lang.String r3 = "Aura_Note_2"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 15
            goto L_0x0787
        L_0x03c2:
            java.lang.String r3 = "602LV"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = r6
            goto L_0x0787
        L_0x03cd:
            java.lang.String r3 = "601LV"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = r9
            goto L_0x0787
        L_0x03d8:
            java.lang.String r3 = "MEIZU_M5"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 83
            goto L_0x0787
        L_0x03e4:
            java.lang.String r3 = "p212"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 92
            goto L_0x0787
        L_0x03f0:
            java.lang.String r3 = "mido"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 85
            goto L_0x0787
        L_0x03fc:
            java.lang.String r3 = "kate"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 75
            goto L_0x0787
        L_0x0408:
            java.lang.String r3 = "fugu"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 50
            goto L_0x0787
        L_0x0414:
            java.lang.String r3 = "XE2X"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 136(0x88, float:1.9E-43)
            goto L_0x0787
        L_0x0420:
            java.lang.String r3 = "Q427"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 111(0x6f, float:1.56E-43)
            goto L_0x0787
        L_0x042c:
            java.lang.String r3 = "Q350"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 109(0x6d, float:1.53E-43)
            goto L_0x0787
        L_0x0438:
            java.lang.String r3 = "P681"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 93
            goto L_0x0787
        L_0x0444:
            java.lang.String r3 = "F04J"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 41
            goto L_0x0787
        L_0x0450:
            java.lang.String r3 = "F04H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 40
            goto L_0x0787
        L_0x045c:
            java.lang.String r3 = "F03H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 39
            goto L_0x0787
        L_0x0468:
            java.lang.String r3 = "F02H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 38
            goto L_0x0787
        L_0x0474:
            java.lang.String r3 = "F01J"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 37
            goto L_0x0787
        L_0x0480:
            java.lang.String r3 = "F01H"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 36
            goto L_0x0787
        L_0x048c:
            java.lang.String r3 = "1714"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = r8
            goto L_0x0787
        L_0x0497:
            java.lang.String r3 = "1713"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = r11
            goto L_0x0787
        L_0x04a2:
            java.lang.String r3 = "1601"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = r1
            goto L_0x0787
        L_0x04ad:
            java.lang.String r3 = "flo"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 49
            goto L_0x0787
        L_0x04b9:
            java.lang.String r4 = "deb"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x0786
            goto L_0x0787
        L_0x04c3:
            java.lang.String r3 = "cv3"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = r12
            goto L_0x0787
        L_0x04ce:
            java.lang.String r3 = "cv1"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = r14
            goto L_0x0787
        L_0x04d9:
            java.lang.String r3 = "Z80"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 139(0x8b, float:1.95E-43)
            goto L_0x0787
        L_0x04e5:
            java.lang.String r3 = "QX1"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 115(0x73, float:1.61E-43)
            goto L_0x0787
        L_0x04f1:
            java.lang.String r3 = "PLE"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 107(0x6b, float:1.5E-43)
            goto L_0x0787
        L_0x04fd:
            java.lang.String r3 = "P85"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 94
            goto L_0x0787
        L_0x0509:
            java.lang.String r3 = "MX6"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 86
            goto L_0x0787
        L_0x0515:
            java.lang.String r3 = "M5c"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 80
            goto L_0x0787
        L_0x0521:
            java.lang.String r3 = "M04"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 79
            goto L_0x0787
        L_0x052d:
            java.lang.String r3 = "JGZ"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 73
            goto L_0x0787
        L_0x0539:
            java.lang.String r3 = "mh"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 84
            goto L_0x0787
        L_0x0545:
            java.lang.String r3 = "b5"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 16
            goto L_0x0787
        L_0x0551:
            java.lang.String r3 = "V5"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 129(0x81, float:1.81E-43)
            goto L_0x0787
        L_0x055d:
            java.lang.String r3 = "V1"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 127(0x7f, float:1.78E-43)
            goto L_0x0787
        L_0x0569:
            java.lang.String r3 = "Q5"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 113(0x71, float:1.58E-43)
            goto L_0x0787
        L_0x0575:
            java.lang.String r3 = "C1"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 20
            goto L_0x0787
        L_0x0581:
            java.lang.String r3 = "woods_fn"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 134(0x86, float:1.88E-43)
            goto L_0x0787
        L_0x058d:
            java.lang.String r3 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 31
            goto L_0x0787
        L_0x0599:
            java.lang.String r3 = "Z12_PRO"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 138(0x8a, float:1.93E-43)
            goto L_0x0787
        L_0x05a5:
            java.lang.String r3 = "BLACK-1X"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 17
            goto L_0x0787
        L_0x05b1:
            java.lang.String r3 = "taido_row"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 121(0x79, float:1.7E-43)
            goto L_0x0787
        L_0x05bd:
            java.lang.String r3 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 105(0x69, float:1.47E-43)
            goto L_0x0787
        L_0x05c9:
            java.lang.String r3 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 53
            goto L_0x0787
        L_0x05d5:
            java.lang.String r3 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 51
            goto L_0x0787
        L_0x05e1:
            java.lang.String r3 = "OnePlus5T"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 91
            goto L_0x0787
        L_0x05ed:
            java.lang.String r3 = "whyred"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 132(0x84, float:1.85E-43)
            goto L_0x0787
        L_0x05f9:
            java.lang.String r3 = "watson"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 131(0x83, float:1.84E-43)
            goto L_0x0787
        L_0x0605:
            java.lang.String r3 = "SVP-DTV15"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 119(0x77, float:1.67E-43)
            goto L_0x0787
        L_0x0611:
            java.lang.String r3 = "A7000-a"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 9
            goto L_0x0787
        L_0x061d:
            java.lang.String r3 = "nicklaus_f"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 88
            goto L_0x0787
        L_0x0629:
            java.lang.String r3 = "tcl_eu"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 126(0x7e, float:1.77E-43)
            goto L_0x0787
        L_0x0635:
            java.lang.String r3 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 34
            goto L_0x0787
        L_0x0641:
            java.lang.String r3 = "s905x018"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 120(0x78, float:1.68E-43)
            goto L_0x0787
        L_0x064d:
            java.lang.String r3 = "A10-70L"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = r5
            goto L_0x0787
        L_0x0658:
            java.lang.String r3 = "A10-70F"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = r4
            goto L_0x0787
        L_0x0663:
            java.lang.String r3 = "namath"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 87
            goto L_0x0787
        L_0x066f:
            java.lang.String r3 = "Slate_Pro"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 118(0x76, float:1.65E-43)
            goto L_0x0787
        L_0x067b:
            java.lang.String r3 = "iris60"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 70
            goto L_0x0787
        L_0x0687:
            java.lang.String r3 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 18
            goto L_0x0787
        L_0x0693:
            java.lang.String r3 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 52
            goto L_0x0787
        L_0x069f:
            java.lang.String r3 = "panell_dt"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 99
            goto L_0x0787
        L_0x06ab:
            java.lang.String r3 = "panell_ds"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 98
            goto L_0x0787
        L_0x06b7:
            java.lang.String r3 = "panell_dl"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 97
            goto L_0x0787
        L_0x06c3:
            java.lang.String r3 = "vernee_M5"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 130(0x82, float:1.82E-43)
            goto L_0x0787
        L_0x06cf:
            java.lang.String r3 = "pacificrim"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 95
            goto L_0x0787
        L_0x06db:
            java.lang.String r3 = "Phantom6"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 104(0x68, float:1.46E-43)
            goto L_0x0787
        L_0x06e7:
            java.lang.String r3 = "ComioS1"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 21
            goto L_0x0787
        L_0x06f3:
            java.lang.String r3 = "XT1663"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 137(0x89, float:1.92E-43)
            goto L_0x0787
        L_0x06ff:
            java.lang.String r3 = "RAIJIN"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 116(0x74, float:1.63E-43)
            goto L_0x0787
        L_0x070b:
            java.lang.String r3 = "AquaPowerM"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 13
            goto L_0x0787
        L_0x0717:
            java.lang.String r3 = "PGN611"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 103(0x67, float:1.44E-43)
            goto L_0x0787
        L_0x0723:
            java.lang.String r3 = "PGN610"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 102(0x66, float:1.43E-43)
            goto L_0x0787
        L_0x072e:
            java.lang.String r3 = "PGN528"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 101(0x65, float:1.42E-43)
            goto L_0x0787
        L_0x0739:
            java.lang.String r3 = "NX573J"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 90
            goto L_0x0787
        L_0x0744:
            java.lang.String r3 = "NX541J"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 89
            goto L_0x0787
        L_0x074f:
            java.lang.String r3 = "CP8676_I02"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 22
            goto L_0x0787
        L_0x075a:
            java.lang.String r3 = "K50a40"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 74
            goto L_0x0787
        L_0x0765:
            java.lang.String r3 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 56
            goto L_0x0787
        L_0x0770:
            java.lang.String r3 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 55
            goto L_0x0787
        L_0x077b:
            java.lang.String r3 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0786
            r3 = 54
            goto L_0x0787
        L_0x0786:
            r3 = r10
        L_0x0787:
            switch(r3) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0080;
                case 2: goto L_0x0080;
                case 3: goto L_0x0080;
                case 4: goto L_0x0080;
                case 5: goto L_0x0080;
                case 6: goto L_0x0080;
                case 7: goto L_0x0080;
                case 8: goto L_0x0080;
                case 9: goto L_0x0080;
                case 10: goto L_0x0080;
                case 11: goto L_0x0080;
                case 12: goto L_0x0080;
                case 13: goto L_0x0080;
                case 14: goto L_0x0080;
                case 15: goto L_0x0080;
                case 16: goto L_0x0080;
                case 17: goto L_0x0080;
                case 18: goto L_0x0080;
                case 19: goto L_0x0080;
                case 20: goto L_0x0080;
                case 21: goto L_0x0080;
                case 22: goto L_0x0080;
                case 23: goto L_0x0080;
                case 24: goto L_0x0080;
                case 25: goto L_0x0080;
                case 26: goto L_0x0080;
                case 27: goto L_0x0080;
                case 28: goto L_0x0080;
                case 29: goto L_0x0080;
                case 30: goto L_0x0080;
                case 31: goto L_0x0080;
                case 32: goto L_0x0080;
                case 33: goto L_0x0080;
                case 34: goto L_0x0080;
                case 35: goto L_0x0080;
                case 36: goto L_0x0080;
                case 37: goto L_0x0080;
                case 38: goto L_0x0080;
                case 39: goto L_0x0080;
                case 40: goto L_0x0080;
                case 41: goto L_0x0080;
                case 42: goto L_0x0080;
                case 43: goto L_0x0080;
                case 44: goto L_0x0080;
                case 45: goto L_0x0080;
                case 46: goto L_0x0080;
                case 47: goto L_0x0080;
                case 48: goto L_0x0080;
                case 49: goto L_0x0080;
                case 50: goto L_0x0080;
                case 51: goto L_0x0080;
                case 52: goto L_0x0080;
                case 53: goto L_0x0080;
                case 54: goto L_0x0080;
                case 55: goto L_0x0080;
                case 56: goto L_0x0080;
                case 57: goto L_0x0080;
                case 58: goto L_0x0080;
                case 59: goto L_0x0080;
                case 60: goto L_0x0080;
                case 61: goto L_0x0080;
                case 62: goto L_0x0080;
                case 63: goto L_0x0080;
                case 64: goto L_0x0080;
                case 65: goto L_0x0080;
                case 66: goto L_0x0080;
                case 67: goto L_0x0080;
                case 68: goto L_0x0080;
                case 69: goto L_0x0080;
                case 70: goto L_0x0080;
                case 71: goto L_0x0080;
                case 72: goto L_0x0080;
                case 73: goto L_0x0080;
                case 74: goto L_0x0080;
                case 75: goto L_0x0080;
                case 76: goto L_0x0080;
                case 77: goto L_0x0080;
                case 78: goto L_0x0080;
                case 79: goto L_0x0080;
                case 80: goto L_0x0080;
                case 81: goto L_0x0080;
                case 82: goto L_0x0080;
                case 83: goto L_0x0080;
                case 84: goto L_0x0080;
                case 85: goto L_0x0080;
                case 86: goto L_0x0080;
                case 87: goto L_0x0080;
                case 88: goto L_0x0080;
                case 89: goto L_0x0080;
                case 90: goto L_0x0080;
                case 91: goto L_0x0080;
                case 92: goto L_0x0080;
                case 93: goto L_0x0080;
                case 94: goto L_0x0080;
                case 95: goto L_0x0080;
                case 96: goto L_0x0080;
                case 97: goto L_0x0080;
                case 98: goto L_0x0080;
                case 99: goto L_0x0080;
                case 100: goto L_0x0080;
                case 101: goto L_0x0080;
                case 102: goto L_0x0080;
                case 103: goto L_0x0080;
                case 104: goto L_0x0080;
                case 105: goto L_0x0080;
                case 106: goto L_0x0080;
                case 107: goto L_0x0080;
                case 108: goto L_0x0080;
                case 109: goto L_0x0080;
                case 110: goto L_0x0080;
                case 111: goto L_0x0080;
                case 112: goto L_0x0080;
                case 113: goto L_0x0080;
                case 114: goto L_0x0080;
                case 115: goto L_0x0080;
                case 116: goto L_0x0080;
                case 117: goto L_0x0080;
                case 118: goto L_0x0080;
                case 119: goto L_0x0080;
                case 120: goto L_0x0080;
                case 121: goto L_0x0080;
                case 122: goto L_0x0080;
                case 123: goto L_0x0080;
                case 124: goto L_0x0080;
                case 125: goto L_0x0080;
                case 126: goto L_0x0080;
                case 127: goto L_0x0080;
                case 128: goto L_0x0080;
                case 129: goto L_0x0080;
                case 130: goto L_0x0080;
                case 131: goto L_0x0080;
                case 132: goto L_0x0080;
                case 133: goto L_0x0080;
                case 134: goto L_0x0080;
                case 135: goto L_0x0080;
                case 136: goto L_0x0080;
                case 137: goto L_0x0080;
                case 138: goto L_0x0080;
                case 139: goto L_0x0080;
                default: goto L_0x078a;
            }
        L_0x078a:
            int r0 = r13.hashCode()     // Catch:{ all -> 0x07a7 }
            r3 = -594534941(0xffffffffdc901de3, float:-3.2452206E17)
            if (r0 == r3) goto L_0x0794
            goto L_0x079d
        L_0x0794:
            java.lang.String r0 = "JSN-L21"
            boolean r0 = r13.equals(r0)
            if (r0 == 0) goto L_0x079d
            r10 = r1
        L_0x079d:
            if (r10 == 0) goto L_0x0080
        L_0x079f:
            zzd = r1     // Catch:{ all -> 0x07a7 }
            zzc = r11     // Catch:{ all -> 0x07a7 }
        L_0x07a3:
            monitor-exit(r2)     // Catch:{ all -> 0x07a7 }
            boolean r0 = zzd
            return r0
        L_0x07a7:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x07a7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaa.zzaS(java.lang.String):boolean");
    }

    private static List zzaT(Context context, zzsq zzsq, zzaf zzaf, boolean z, boolean z2) throws zzsw {
        String str = zzaf.zzm;
        if (str == null) {
            return zzfxr.zzm();
        }
        if (zzet.zza >= 26 && "video/dolby-vision".equals(str) && !zzzy.zza(context)) {
            List zzd2 = zztc.zzd(zzsq, zzaf, z, z2);
            if (!zzd2.isEmpty()) {
                return zzd2;
            }
        }
        return zztc.zzf(zzsq, zzaf, z, z2);
    }

    private final void zzaU() {
        zzcp zzcp = this.zzB;
        if (zzcp != null) {
            this.zzg.zzt(zzcp);
        }
    }

    /* access modifiers changed from: private */
    public final void zzaV() {
        this.zzg.zzq(this.zzp);
        this.zzr = true;
    }

    private final void zzaW() {
        Surface surface = this.zzp;
        zzaad zzaad = this.zzq;
        if (surface == zzaad) {
            this.zzp = null;
        }
        if (zzaad != null) {
            zzaad.release();
            this.zzq = null;
        }
    }

    private final boolean zzaX(zzsf zzsf) {
        if (zzet.zza < 23 || zzaS(zzsf.zza)) {
            return false;
        }
        if (!zzsf.zzf) {
            return true;
        }
        if (!zzaad.zzb(this.zze)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0075, code lost:
        if (r3.equals("video/av01") != false) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00cc, code lost:
        return ((r0 * r1) * 3) / r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int zzad(com.google.android.gms.internal.ads.zzsf r10, com.google.android.gms.internal.ads.zzaf r11) {
        /*
            int r0 = r11.zzr
            int r1 = r11.zzs
            r2 = -1
            if (r0 == r2) goto L_0x00cd
            if (r1 != r2) goto L_0x000b
            goto L_0x00cd
        L_0x000b:
            java.lang.String r3 = r11.zzm
            r3.getClass()
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            r5 = 2
            r6 = 1
            java.lang.String r7 = "video/avc"
            java.lang.String r8 = "video/hevc"
            if (r4 == 0) goto L_0x0037
            android.util.Pair r11 = com.google.android.gms.internal.ads.zztc.zza(r11)
            if (r11 == 0) goto L_0x0036
            java.lang.Object r11 = r11.first
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r11 == r3) goto L_0x0034
            if (r11 == r6) goto L_0x0034
            if (r11 != r5) goto L_0x0036
        L_0x0034:
            r3 = r7
            goto L_0x0037
        L_0x0036:
            r3 = r8
        L_0x0037:
            int r11 = r3.hashCode()
            r4 = 3
            r9 = 4
            switch(r11) {
                case -1664118616: goto L_0x0078;
                case -1662735862: goto L_0x006f;
                case -1662541442: goto L_0x0067;
                case 1187890754: goto L_0x005d;
                case 1331836730: goto L_0x0055;
                case 1599127256: goto L_0x004b;
                case 1599127257: goto L_0x0041;
                default: goto L_0x0040;
            }
        L_0x0040:
            goto L_0x0082
        L_0x0041:
            java.lang.String r11 = "video/x-vnd.on2.vp9"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0082
            r5 = 6
            goto L_0x0083
        L_0x004b:
            java.lang.String r11 = "video/x-vnd.on2.vp8"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0082
            r5 = r4
            goto L_0x0083
        L_0x0055:
            boolean r11 = r3.equals(r7)
            if (r11 == 0) goto L_0x0082
            r5 = 5
            goto L_0x0083
        L_0x005d:
            java.lang.String r11 = "video/mp4v-es"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0082
            r5 = r6
            goto L_0x0083
        L_0x0067:
            boolean r11 = r3.equals(r8)
            if (r11 == 0) goto L_0x0082
            r5 = r9
            goto L_0x0083
        L_0x006f:
            java.lang.String r11 = "video/av01"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0082
            goto L_0x0083
        L_0x0078:
            java.lang.String r11 = "video/3gpp"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x0082
            r5 = 0
            goto L_0x0083
        L_0x0082:
            r5 = r2
        L_0x0083:
            switch(r5) {
                case 0: goto L_0x00c9;
                case 1: goto L_0x00c9;
                case 2: goto L_0x00c9;
                case 3: goto L_0x00c9;
                case 4: goto L_0x00bf;
                case 5: goto L_0x008a;
                case 6: goto L_0x0087;
                default: goto L_0x0086;
            }
        L_0x0086:
            goto L_0x00cd
        L_0x0087:
            r9 = 8
            goto L_0x00c9
        L_0x008a:
            java.lang.String r11 = com.google.android.gms.internal.ads.zzet.zzd
            java.lang.String r3 = "BRAVIA 4K 2015"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto L_0x00cd
            java.lang.String r3 = "Amazon"
            java.lang.String r4 = com.google.android.gms.internal.ads.zzet.zzc
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00b2
            java.lang.String r3 = "KFSOWI"
            boolean r3 = r3.equals(r11)
            if (r3 != 0) goto L_0x00cd
            java.lang.String r3 = "AFTS"
            boolean r11 = r3.equals(r11)
            if (r11 == 0) goto L_0x00b2
            boolean r10 = r10.zzf
            if (r10 != 0) goto L_0x00cd
        L_0x00b2:
            int r0 = r0 + 15
            int r1 = r1 + 15
            int r0 = r0 / 16
            int r1 = r1 / 16
            int r1 = r1 * r0
            int r1 = r1 * 768
            int r1 = r1 / r9
            return r1
        L_0x00bf:
            int r0 = r0 * r1
            int r0 = r0 * r4
            int r0 = r0 / r9
            r10 = 2097152(0x200000, float:2.938736E-39)
            int r10 = java.lang.Math.max(r10, r0)
            return r10
        L_0x00c9:
            int r0 = r0 * r1
            int r0 = r0 * r4
            int r0 = r0 / r9
            return r0
        L_0x00cd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaa.zzad(com.google.android.gms.internal.ads.zzsf, com.google.android.gms.internal.ads.zzaf):int");
    }

    public static int zzae(zzsf zzsf, zzaf zzaf) {
        if (zzaf.zzn == -1) {
            return zzad(zzsf, zzaf);
        }
        int size = zzaf.zzo.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += ((byte[]) zzaf.zzo.get(i2)).length;
        }
        return zzaf.zzn + i;
    }

    public final void zzA() {
        ((zzzr) this.zzf).zza.zzs();
    }

    public final void zzC() {
        try {
            super.zzC();
            this.zzl = false;
            if (this.zzq != null) {
                zzaW();
            }
        } catch (Throwable th) {
            this.zzl = false;
            if (this.zzq != null) {
                zzaW();
            }
            throw th;
        }
    }

    public final void zzD() {
        this.zzu = 0;
        zzh();
        this.zzt = SystemClock.elapsedRealtime();
        this.zzx = 0;
        this.zzy = 0;
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zzg();
        } else {
            this.zzi.zzg();
        }
    }

    public final void zzE() {
        if (this.zzu > 0) {
            zzh();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzg.zzd(this.zzu, elapsedRealtime - this.zzt);
            this.zzu = 0;
            this.zzt = elapsedRealtime;
        }
        int i = this.zzy;
        if (i != 0) {
            this.zzg.zzr(this.zzx, i);
            this.zzx = 0;
            this.zzy = 0;
        }
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zzh();
        } else {
            this.zzi.zzh();
        }
    }

    public final void zzM(float f, float f2) throws zzhw {
        super.zzM(f, f2);
        this.zzi.zzm(f);
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zze.zzd(f);
        }
    }

    public final String zzU() {
        return "MediaCodecVideoRenderer";
    }

    public final void zzV(long j, long j2) throws zzhw {
        super.zzV(j, j2);
        if (this.zzk) {
            try {
                this.zzf.zzg(j, j2);
            } catch (zzabb e) {
                throw zzi(e, e.zza, false, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
            }
        }
    }

    public final boolean zzW() {
        if (!super.zzW() || this.zzk) {
            return false;
        }
        return true;
    }

    public final boolean zzX() {
        zzaad zzaad;
        boolean z = false;
        if (super.zzX() && !this.zzk) {
            z = true;
        }
        if (!z || (((zzaad = this.zzq) == null || this.zzp != zzaad) && zzay() != null)) {
            return this.zzi.zzn(z);
        }
        return true;
    }

    public final float zzZ(float f, zzaf zzaf, zzaf[] zzafArr) {
        float f2 = -1.0f;
        for (zzaf zzaf2 : zzafArr) {
            float f3 = zzaf2.zzt;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    public final void zzaC(long j) {
        super.zzaC(j);
        this.zzw--;
    }

    public final void zzaD(zzhd zzhd) throws zzhw {
        this.zzw++;
        int i = zzet.zza;
    }

    public final void zzaE(zzaf zzaf) throws zzhw {
        if (this.zzk) {
            try {
                zzabc zzabc = this.zzf;
                zzzt.zzd(((zzzr) zzabc).zza, zzaf, zzh());
                this.zzf.zzh(new zzzx(this), zzgda.zzb());
            } catch (zzabb e) {
                throw zzi(e, zzaf, false, 7000);
            }
        }
    }

    public final void zzaG() {
        super.zzaG();
        this.zzw = 0;
    }

    public final boolean zzaM(zzsf zzsf) {
        if (this.zzp != null || zzaX(zzsf)) {
            return true;
        }
        return false;
    }

    public final void zzaO(zzsc zzsc, int i, long j) {
        Trace.beginSection("skipVideoBuffer");
        zzsc.zzn(i, false);
        Trace.endSection();
        this.zza.zzf++;
    }

    public final void zzaP(int i, int i2) {
        zzhn zzhn = this.zza;
        zzhn.zzh += i;
        int i3 = i + i2;
        zzhn.zzg += i3;
        this.zzu += i3;
        int i4 = this.zzv + i3;
        this.zzv = i4;
        zzhn.zzi = Math.max(i4, zzhn.zzi);
    }

    public final void zzaQ(long j) {
        zzhn zzhn = this.zza;
        zzhn.zzk += j;
        zzhn.zzl++;
        this.zzx += j;
        this.zzy++;
    }

    public final boolean zzaR(long j, boolean z) throws zzhw {
        int zzd2 = zzd(j);
        if (zzd2 == 0) {
            return false;
        }
        if (z) {
            zzhn zzhn = this.zza;
            zzhn.zzd += zzd2;
            zzhn.zzf += this.zzw;
        } else {
            this.zza.zzj++;
            zzaP(zzd2, this.zzw);
        }
        zzaI();
        if (this.zzk) {
            this.zzf.zze();
        }
        return true;
    }

    public final int zzaa(zzsq zzsq, zzaf zzaf) throws zzsw {
        boolean z;
        boolean z2;
        int i;
        int i2;
        int i3;
        int i4 = 128;
        if (!zzbn.zzi(zzaf.zzm)) {
            return 128;
        }
        int i5 = 1;
        int i6 = 0;
        if (zzaf.zzp != null) {
            z = true;
        } else {
            z = false;
        }
        List zzaT = zzaT(this.zze, zzsq, zzaf, z, false);
        if (z && zzaT.isEmpty()) {
            zzaT = zzaT(this.zze, zzsq, zzaf, false, false);
        }
        if (!zzaT.isEmpty()) {
            if (!zzso.zzaN(zzaf)) {
                i5 = 2;
            } else {
                zzsf zzsf = (zzsf) zzaT.get(0);
                boolean zze2 = zzsf.zze(zzaf);
                if (!zze2) {
                    int i7 = 1;
                    while (true) {
                        if (i7 >= zzaT.size()) {
                            break;
                        }
                        zzsf zzsf2 = (zzsf) zzaT.get(i7);
                        if (zzsf2.zze(zzaf)) {
                            zze2 = true;
                            z2 = false;
                            zzsf = zzsf2;
                            break;
                        }
                        i7++;
                    }
                }
                z2 = true;
                if (true != zze2) {
                    i = 3;
                } else {
                    i = 4;
                }
                if (true != zzsf.zzf(zzaf)) {
                    i2 = 8;
                } else {
                    i2 = 16;
                }
                if (true != zzsf.zzg) {
                    i3 = 0;
                } else {
                    i3 = 64;
                }
                if (true != z2) {
                    i4 = 0;
                }
                if (zzet.zza >= 26 && "video/dolby-vision".equals(zzaf.zzm) && !zzzy.zza(this.zze)) {
                    i4 = 256;
                }
                if (zze2) {
                    List zzaT2 = zzaT(this.zze, zzsq, zzaf, z, true);
                    if (!zzaT2.isEmpty()) {
                        zzsf zzsf3 = (zzsf) zztc.zzg(zzaT2, zzaf).get(0);
                        if (zzsf3.zze(zzaf) && zzsf3.zzf(zzaf)) {
                            i6 = 32;
                        }
                    }
                }
                return i | i2 | i6 | i3 | i4;
            }
        }
        return i5 | 128;
    }

    public final zzho zzab(zzsf zzsf, zzaf zzaf, zzaf zzaf2) {
        int i;
        int i2;
        zzho zzb2 = zzsf.zzb(zzaf, zzaf2);
        int i3 = zzb2.zze;
        zzzz zzzz = this.zzm;
        zzzz.getClass();
        if (zzaf2.zzr > zzzz.zza || zzaf2.zzs > zzzz.zzb) {
            i3 |= 256;
        }
        if (zzae(zzsf, zzaf2) > zzzz.zzc) {
            i3 |= 64;
        }
        String str = zzsf.zza;
        if (i3 != 0) {
            i = i3;
            i2 = 0;
        } else {
            i2 = zzb2.zzd;
            i = 0;
        }
        return new zzho(str, zzaf, zzaf2, i2, i);
    }

    public final zzho zzac(zzjz zzjz) throws zzhw {
        zzho zzac = super.zzac(zzjz);
        zzaf zzaf = zzjz.zza;
        zzaf.getClass();
        this.zzg.zzf(zzaf, zzac);
        return zzac;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0232  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x023e  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0246  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01e5  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01f2  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0207  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzrz zzaf(com.google.android.gms.internal.ads.zzsf r20, com.google.android.gms.internal.ads.zzaf r21, android.media.MediaCrypto r22, float r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r23
            com.google.android.gms.internal.ads.zzaad r4 = r0.zzq
            if (r4 == 0) goto L_0x0015
            boolean r5 = r1.zzf
            boolean r4 = r4.zza
            if (r4 == r5) goto L_0x0015
            r19.zzaW()
        L_0x0015:
            java.lang.String r4 = r1.zzc
            com.google.android.gms.internal.ads.zzaf[] r5 = r19.zzT()
            int r6 = r2.zzr
            int r7 = r2.zzs
            int r8 = zzae(r20, r21)
            int r9 = r5.length
            r10 = -1
            r13 = 1
            if (r9 != r13) goto L_0x003d
            if (r8 == r10) goto L_0x0039
            int r5 = zzad(r20, r21)
            if (r5 == r10) goto L_0x0039
            float r8 = (float) r8
            r9 = 1069547520(0x3fc00000, float:1.5)
            float r8 = r8 * r9
            int r8 = (int) r8
            int r8 = java.lang.Math.min(r8, r5)
        L_0x0039:
            r16 = r4
            goto L_0x0138
        L_0x003d:
            r14 = 0
            r15 = 0
        L_0x003f:
            if (r14 >= r9) goto L_0x0083
            r11 = r5[r14]
            com.google.android.gms.internal.ads.zzo r12 = r2.zzy
            if (r12 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzo r12 = r11.zzy
            if (r12 != 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzad r11 = r11.zzb()
            com.google.android.gms.internal.ads.zzo r12 = r2.zzy
            r11.zzA(r12)
            com.google.android.gms.internal.ads.zzaf r11 = r11.zzad()
        L_0x0058:
            com.google.android.gms.internal.ads.zzho r12 = r1.zzb(r2, r11)
            int r12 = r12.zzd
            if (r12 == 0) goto L_0x007f
            int r12 = r11.zzr
            if (r12 == r10) goto L_0x006b
            int r13 = r11.zzs
            if (r13 != r10) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r13 = 0
            goto L_0x006c
        L_0x006b:
            r13 = 1
        L_0x006c:
            r15 = r15 | r13
            int r6 = java.lang.Math.max(r6, r12)
            int r12 = r11.zzs
            int r7 = java.lang.Math.max(r7, r12)
            int r11 = zzae(r1, r11)
            int r8 = java.lang.Math.max(r8, r11)
        L_0x007f:
            int r14 = r14 + 1
            r13 = 1
            goto L_0x003f
        L_0x0083:
            if (r15 == 0) goto L_0x0039
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r9 = "Resolutions unknown. Codec max resolution: "
            r5.<init>(r9)
            r5.append(r6)
            java.lang.String r9 = "x"
            r5.append(r9)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.String r10 = "MediaCodecVideoRenderer"
            com.google.android.gms.internal.ads.zzea.zzf(r10, r5)
            int r5 = r2.zzs
            int r11 = r2.zzr
            if (r5 <= r11) goto L_0x00a8
            r12 = 1
            goto L_0x00a9
        L_0x00a8:
            r12 = 0
        L_0x00a9:
            if (r12 == 0) goto L_0x00ad
            r13 = r5
            goto L_0x00ae
        L_0x00ad:
            r13 = r11
        L_0x00ae:
            r14 = 1
            if (r14 != r12) goto L_0x00b2
            r5 = r11
        L_0x00b2:
            int[] r11 = zzb
            r14 = 0
        L_0x00b5:
            r15 = 9
            if (r14 >= r15) goto L_0x00fa
            float r15 = (float) r5
            float r3 = (float) r13
            r16 = r4
            r4 = r11[r14]
            r17 = r11
            float r11 = (float) r4
            if (r4 <= r13) goto L_0x00fc
            float r15 = r15 / r3
            float r15 = r15 * r11
            int r3 = (int) r15
            if (r3 > r5) goto L_0x00ca
            goto L_0x00fc
        L_0x00ca:
            int r11 = com.google.android.gms.internal.ads.zzet.zza
            r11 = 1
            if (r11 == r12) goto L_0x00d1
            r15 = r4
            goto L_0x00d2
        L_0x00d1:
            r15 = r3
        L_0x00d2:
            if (r11 != r12) goto L_0x00d5
            goto L_0x00d6
        L_0x00d5:
            r4 = r3
        L_0x00d6:
            android.graphics.Point r3 = r1.zza(r15, r4)
            float r4 = r2.zzt
            if (r3 == 0) goto L_0x00ed
            r11 = r5
            double r4 = (double) r4
            int r15 = r3.x
            r18 = r11
            int r11 = r3.y
            boolean r4 = r1.zzg(r15, r11, r4)
            if (r4 == 0) goto L_0x00ef
            goto L_0x00fd
        L_0x00ed:
            r18 = r5
        L_0x00ef:
            int r14 = r14 + 1
            r3 = r23
            r4 = r16
            r11 = r17
            r5 = r18
            goto L_0x00b5
        L_0x00fa:
            r16 = r4
        L_0x00fc:
            r3 = 0
        L_0x00fd:
            if (r3 == 0) goto L_0x0138
            int r4 = r3.x
            int r6 = java.lang.Math.max(r6, r4)
            int r3 = r3.y
            int r7 = java.lang.Math.max(r7, r3)
            com.google.android.gms.internal.ads.zzad r3 = r21.zzb()
            r3.zzac(r6)
            r3.zzI(r7)
            com.google.android.gms.internal.ads.zzaf r3 = r3.zzad()
            int r3 = zzad(r1, r3)
            int r8 = java.lang.Math.max(r8, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Codec max resolution adjusted to: "
            r3.<init>(r4)
            r3.append(r6)
            r3.append(r9)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            com.google.android.gms.internal.ads.zzea.zzf(r10, r3)
        L_0x0138:
            com.google.android.gms.internal.ads.zzzz r3 = new com.google.android.gms.internal.ads.zzzz
            r3.<init>(r6, r7, r8)
            r0.zzm = r3
            boolean r4 = r0.zzh
            android.media.MediaFormat r5 = new android.media.MediaFormat
            r5.<init>()
            java.lang.String r6 = "mime"
            r7 = r16
            r5.setString(r6, r7)
            int r6 = r2.zzr
            java.lang.String r7 = "width"
            r5.setInteger(r7, r6)
            int r6 = r2.zzs
            java.lang.String r7 = "height"
            r5.setInteger(r7, r6)
            java.util.List r6 = r2.zzo
            com.google.android.gms.internal.ads.zzed.zzb(r5, r6)
            float r6 = r2.zzt
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x016d
            java.lang.String r8 = "frame-rate"
            r5.setFloat(r8, r6)
        L_0x016d:
            int r6 = r2.zzu
            java.lang.String r8 = "rotation-degrees"
            com.google.android.gms.internal.ads.zzed.zza(r5, r8, r6)
            com.google.android.gms.internal.ads.zzo r6 = r2.zzy
            if (r6 == 0) goto L_0x019a
            java.lang.String r8 = "color-transfer"
            int r9 = r6.zzd
            com.google.android.gms.internal.ads.zzed.zza(r5, r8, r9)
            java.lang.String r8 = "color-standard"
            int r9 = r6.zzb
            com.google.android.gms.internal.ads.zzed.zza(r5, r8, r9)
            java.lang.String r8 = "color-range"
            int r9 = r6.zzc
            com.google.android.gms.internal.ads.zzed.zza(r5, r8, r9)
            byte[] r6 = r6.zze
            if (r6 == 0) goto L_0x019a
            java.lang.String r8 = "hdr-static-info"
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r6)
            r5.setByteBuffer(r8, r6)
        L_0x019a:
            java.lang.String r6 = r2.zzm
            java.lang.String r8 = "video/dolby-vision"
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x01b7
            android.util.Pair r6 = com.google.android.gms.internal.ads.zztc.zza(r21)
            if (r6 == 0) goto L_0x01b7
            java.lang.Object r6 = r6.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.String r8 = "profile"
            com.google.android.gms.internal.ads.zzed.zza(r5, r8, r6)
        L_0x01b7:
            int r6 = r3.zza
            java.lang.String r8 = "max-width"
            r5.setInteger(r8, r6)
            int r6 = r3.zzb
            java.lang.String r8 = "max-height"
            r5.setInteger(r8, r6)
            int r3 = r3.zzc
            java.lang.String r6 = "max-input-size"
            com.google.android.gms.internal.ads.zzed.zza(r5, r6, r3)
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            r6 = 23
            if (r3 < r6) goto L_0x01e3
            java.lang.String r6 = "priority"
            r8 = 0
            r5.setInteger(r6, r8)
            r6 = r23
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x01e3
            java.lang.String r7 = "operating-rate"
            r5.setFloat(r7, r6)
        L_0x01e3:
            if (r4 == 0) goto L_0x01f2
            java.lang.String r4 = "no-post-process"
            r6 = 1
            r5.setInteger(r4, r6)
            java.lang.String r4 = "auto-frc"
            r6 = 0
            r5.setInteger(r4, r6)
            goto L_0x01f3
        L_0x01f2:
            r6 = 0
        L_0x01f3:
            r4 = 35
            if (r3 < r4) goto L_0x0203
            int r3 = r0.zzD
            int r3 = -r3
            int r3 = java.lang.Math.max(r6, r3)
            java.lang.String r4 = "importance"
            r5.setInteger(r4, r3)
        L_0x0203:
            android.view.Surface r3 = r0.zzp
            if (r3 != 0) goto L_0x0226
            boolean r3 = r19.zzaX(r20)
            if (r3 == 0) goto L_0x0220
            com.google.android.gms.internal.ads.zzaad r3 = r0.zzq
            if (r3 != 0) goto L_0x021b
            android.content.Context r3 = r0.zze
            boolean r4 = r1.zzf
            com.google.android.gms.internal.ads.zzaad r3 = com.google.android.gms.internal.ads.zzaad.zza(r3, r4)
            r0.zzq = r3
        L_0x021b:
            com.google.android.gms.internal.ads.zzaad r3 = r0.zzq
            r0.zzp = r3
            goto L_0x0226
        L_0x0220:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0226:
            boolean r3 = r0.zzk
            if (r3 == 0) goto L_0x0239
            com.google.android.gms.internal.ads.zzabc r3 = r0.zzf
            boolean r3 = r3.zzk()
            if (r3 != 0) goto L_0x0239
            java.lang.String r3 = "allow-frame-drop"
            r4 = 0
            r5.setInteger(r3, r4)
            goto L_0x023a
        L_0x0239:
            r4 = 0
        L_0x023a:
            boolean r3 = r0.zzk
            if (r3 != 0) goto L_0x0246
            android.view.Surface r3 = r0.zzp
            r6 = 0
            com.google.android.gms.internal.ads.zzrz r1 = com.google.android.gms.internal.ads.zzrz.zzb(r1, r5, r2, r3, r6)
            return r1
        L_0x0246:
            r6 = 0
            com.google.android.gms.internal.ads.zzdi.zzf(r4)
            com.google.android.gms.internal.ads.zzdi.zzb(r6)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaa.zzaf(com.google.android.gms.internal.ads.zzsf, com.google.android.gms.internal.ads.zzaf, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzrz");
    }

    public final List zzag(zzsq zzsq, zzaf zzaf, boolean z) throws zzsw {
        return zztc.zzg(zzaT(this.zze, zzsq, zzaf, false, false), zzaf);
    }

    @TargetApi(29)
    public final void zzaj(zzhd zzhd) throws zzhw {
        if (this.zzo) {
            ByteBuffer byteBuffer = zzhd.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b != -75 || s != 60 || s2 != 1 || b2 != 4) {
                    return;
                }
                if (b3 == 0 || b3 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    zzsc zzay = zzay();
                    zzay.getClass();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    zzay.zzp(bundle);
                }
            }
        }
    }

    public final void zzak(Exception exc) {
        zzea.zzd("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    public final void zzal(String str, zzrz zzrz, long j, long j2) {
        this.zzg.zza(str, j, j2);
        this.zzn = zzaS(str);
        zzsf zzaA = zzaA();
        zzaA.getClass();
        boolean z = false;
        if (zzet.zza >= 29 && "video/x-vnd.on2.vp9".equals(zzaA.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] zzh2 = zzaA.zzh();
            int length = zzh2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (zzh2[i].profile == 16384) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
        }
        this.zzo = z;
    }

    public final void zzam(String str) {
        this.zzg.zzb(str);
    }

    public final void zzan(zzaf zzaf, MediaFormat mediaFormat) {
        boolean z;
        int i;
        int i2;
        zzsc zzay = zzay();
        if (zzay != null) {
            zzay.zzq(this.zzs);
        }
        mediaFormat.getClass();
        if (!mediaFormat.containsKey("crop-right") || !mediaFormat.containsKey("crop-left") || !mediaFormat.containsKey("crop-bottom") || !mediaFormat.containsKey("crop-top")) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            i = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i = mediaFormat.getInteger("width");
        }
        if (z) {
            i2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i2 = mediaFormat.getInteger("height");
        }
        float f = zzaf.zzv;
        int i3 = zzet.zza;
        int i4 = zzaf.zzu;
        if (i4 == 90 || i4 == 270) {
            f = 1.0f / f;
            int i5 = i2;
            i2 = i;
            i = i5;
        }
        this.zzA = new zzcp(i, i2, 0, f);
        if (this.zzk) {
            zzabc zzabc = this.zzf;
            zzad zzb2 = zzaf.zzb();
            zzb2.zzac(i);
            zzb2.zzI(i2);
            zzb2.zzW(0);
            zzb2.zzT(f);
            zzabc.zzf(1, zzb2.zzad());
            return;
        }
        this.zzi.zzk(zzaf.zzt);
    }

    public final void zzao(zzsc zzsc, int i, long j, long j2) {
        Trace.beginSection("releaseOutputBuffer");
        zzsc.zzm(i, j2);
        Trace.endSection();
        this.zza.zze++;
        this.zzv = 0;
        if (!this.zzk) {
            zzcp zzcp = this.zzA;
            if (!zzcp.equals(zzcp.zza) && !zzcp.equals(this.zzB)) {
                this.zzB = zzcp;
                this.zzg.zzt(zzcp);
            }
            if (this.zzi.zzo() && this.zzp != null) {
                zzaV();
            }
        }
    }

    public final void zzap() {
        if (this.zzk) {
            this.zzf.zzi(zzau());
        } else {
            this.zzi.zzf();
        }
    }

    public final boolean zzar(long j, long j2, zzsc zzsc, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzaf zzaf) throws zzhw {
        zzsc zzsc2 = zzsc;
        int i4 = i;
        boolean z3 = z2;
        zzsc.getClass();
        long zzau = j3 - zzau();
        int zza = this.zzi.zza(j3, j, j2, zzav(), z2, this.zzj);
        if (zza != 4) {
            if (!z || z3) {
                long j4 = zzau;
                if (this.zzp != this.zzq || this.zzk) {
                    if (this.zzk) {
                        try {
                            this.zzf.zzg(j, j2);
                            long zzd2 = this.zzf.zzd(j4, z3);
                            if (zzd2 != -9223372036854775807L) {
                                int i5 = zzet.zza;
                                zzao(zzsc, i, j4, zzd2);
                                return true;
                            }
                        } catch (zzabb e) {
                            throw zzi(e, e.zza, false, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR_CODE);
                        }
                    } else if (zza == 0) {
                        zzh();
                        long nanoTime = System.nanoTime();
                        int i6 = zzet.zza;
                        zzao(zzsc, i, j4, nanoTime);
                        zzaQ(this.zzj.zzc());
                        return true;
                    } else if (zza == 1) {
                        zzaaf zzaaf = this.zzj;
                        long zzd3 = zzaaf.zzd();
                        long zzc2 = zzaaf.zzc();
                        int i7 = zzet.zza;
                        if (zzd3 == this.zzz) {
                            zzaO(zzsc2, i4, j4);
                        } else {
                            zzao(zzsc, i, j4, zzd3);
                        }
                        zzaQ(zzc2);
                        this.zzz = zzd3;
                        return true;
                    } else if (zza == 2) {
                        Trace.beginSection("dropVideoBuffer");
                        zzsc2.zzn(i4, false);
                        Trace.endSection();
                        zzaP(0, 1);
                        zzaQ(this.zzj.zzc());
                        return true;
                    } else if (zza == 3) {
                        zzaO(zzsc2, i4, j4);
                        zzaQ(this.zzj.zzc());
                        return true;
                    } else if (zza != 5) {
                        throw new IllegalStateException(String.valueOf(zza));
                    }
                } else if (this.zzj.zzc() < 30000) {
                    zzaO(zzsc2, i4, j4);
                    zzaQ(this.zzj.zzc());
                    return true;
                }
            } else {
                zzaO(zzsc2, i4, zzau);
                return true;
            }
        }
        return false;
    }

    public final int zzat(zzhd zzhd) {
        int i = zzet.zza;
        return 0;
    }

    public final zzse zzaz(Throwable th, zzsf zzsf) {
        return new zzzw(th, zzsf, this.zzp);
    }

    public final void zzs() {
        this.zzi.zzb();
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzt(int r6, java.lang.Object r7) throws com.google.android.gms.internal.ads.zzhw {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            if (r6 == r1) goto L_0x00bf
            r2 = 7
            if (r6 == r2) goto L_0x00ae
            r2 = 10
            if (r6 == r2) goto L_0x009e
            r2 = 16
            if (r6 == r2) goto L_0x0072
            r0 = 4
            if (r6 == r0) goto L_0x005d
            r0 = 5
            if (r6 == r0) goto L_0x004e
            r0 = 13
            if (r6 == r0) goto L_0x0041
            r0 = 14
            if (r6 == r0) goto L_0x0021
            super.zzt(r6, r7)
            return
        L_0x0021:
            r7.getClass()
            com.google.android.gms.internal.ads.zzel r7 = (com.google.android.gms.internal.ads.zzel) r7
            int r6 = r7.zzb()
            if (r6 == 0) goto L_0x0154
            int r6 = r7.zza()
            if (r6 == 0) goto L_0x0154
            com.google.android.gms.internal.ads.zzabc r6 = r5.zzf
            android.view.Surface r0 = r5.zzp
            com.google.android.gms.internal.ads.zzdi.zzb(r0)
            com.google.android.gms.internal.ads.zzzr r6 = (com.google.android.gms.internal.ads.zzzr) r6
            com.google.android.gms.internal.ads.zzzt r6 = r6.zza
            r6.zzu(r0, r7)
            return
        L_0x0041:
            r7.getClass()
            com.google.android.gms.internal.ads.zzabc r6 = r5.zzf
            java.util.List r7 = (java.util.List) r7
            r6.zzj(r7)
            r5.zzC = r1
            return
        L_0x004e:
            com.google.android.gms.internal.ads.zzaah r6 = r5.zzi
            r7.getClass()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r6.zzj(r7)
            return
        L_0x005d:
            r7.getClass()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r6 = r7.intValue()
            r5.zzs = r6
            com.google.android.gms.internal.ads.zzsc r7 = r5.zzay()
            if (r7 == 0) goto L_0x0154
            r7.zzq(r6)
            return
        L_0x0072:
            r7.getClass()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r6 = r7.intValue()
            r5.zzD = r6
            com.google.android.gms.internal.ads.zzsc r6 = r5.zzay()
            if (r6 == 0) goto L_0x0154
            int r7 = com.google.android.gms.internal.ads.zzet.zza
            r1 = 35
            if (r7 < r1) goto L_0x0154
            android.os.Bundle r7 = new android.os.Bundle
            r7.<init>()
            int r1 = r5.zzD
            int r1 = -r1
            int r0 = java.lang.Math.max(r0, r1)
            java.lang.String r1 = "importance"
            r7.putInt(r1, r0)
            r6.zzp(r7)
            return
        L_0x009e:
            r7.getClass()
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r6 = r7.intValue()
            int r7 = r5.zzE
            if (r7 == r6) goto L_0x0154
            r5.zzE = r6
            return
        L_0x00ae:
            r7.getClass()
            com.google.android.gms.internal.ads.zzaae r7 = (com.google.android.gms.internal.ads.zzaae) r7
            r5.zzF = r7
            com.google.android.gms.internal.ads.zzabc r6 = r5.zzf
            com.google.android.gms.internal.ads.zzzr r6 = (com.google.android.gms.internal.ads.zzzr) r6
            com.google.android.gms.internal.ads.zzzt r6 = r6.zza
            r6.zzj = r7
            return
        L_0x00bf:
            boolean r6 = r7 instanceof android.view.Surface
            r2 = 0
            if (r6 == 0) goto L_0x00c7
            android.view.Surface r7 = (android.view.Surface) r7
            goto L_0x00c8
        L_0x00c7:
            r7 = r2
        L_0x00c8:
            if (r7 != 0) goto L_0x00e6
            com.google.android.gms.internal.ads.zzaad r6 = r5.zzq
            if (r6 == 0) goto L_0x00d0
            r7 = r6
            goto L_0x00e6
        L_0x00d0:
            com.google.android.gms.internal.ads.zzsf r6 = r5.zzaA()
            if (r6 == 0) goto L_0x00e6
            boolean r3 = r5.zzaX(r6)
            if (r3 == 0) goto L_0x00e6
            android.content.Context r7 = r5.zze
            boolean r6 = r6.zzf
            com.google.android.gms.internal.ads.zzaad r7 = com.google.android.gms.internal.ads.zzaad.zza(r7, r6)
            r5.zzq = r7
        L_0x00e6:
            android.view.Surface r6 = r5.zzp
            if (r6 == r7) goto L_0x013e
            r5.zzp = r7
            boolean r6 = r5.zzk
            if (r6 != 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzaah r6 = r5.zzi
            r6.zzl(r7)
        L_0x00f5:
            r5.zzr = r0
            int r6 = r5.zzcV()
            com.google.android.gms.internal.ads.zzsc r0 = r5.zzay()
            if (r0 == 0) goto L_0x011c
            boolean r3 = r5.zzk
            if (r3 != 0) goto L_0x011c
            int r3 = com.google.android.gms.internal.ads.zzet.zza
            r4 = 23
            if (r3 < r4) goto L_0x0116
            if (r7 == 0) goto L_0x0115
            boolean r3 = r5.zzn
            if (r3 != 0) goto L_0x0116
            r0.zzo(r7)
            goto L_0x011c
        L_0x0115:
            r7 = r2
        L_0x0116:
            r5.zzaF()
            r5.zzaB()
        L_0x011c:
            if (r7 == 0) goto L_0x012e
            com.google.android.gms.internal.ads.zzaad r0 = r5.zzq
            if (r7 == r0) goto L_0x012e
            r5.zzaU()
            r7 = 2
            if (r6 != r7) goto L_0x0154
            com.google.android.gms.internal.ads.zzaah r6 = r5.zzi
            r6.zzc(r1)
            return
        L_0x012e:
            r5.zzB = r2
            boolean r6 = r5.zzk
            if (r6 == 0) goto L_0x0154
            com.google.android.gms.internal.ads.zzabc r6 = r5.zzf
            com.google.android.gms.internal.ads.zzzr r6 = (com.google.android.gms.internal.ads.zzzr) r6
            com.google.android.gms.internal.ads.zzzt r6 = r6.zza
            r6.zzr()
            return
        L_0x013e:
            if (r7 == 0) goto L_0x0154
            com.google.android.gms.internal.ads.zzaad r6 = r5.zzq
            if (r7 == r6) goto L_0x0154
            r5.zzaU()
            android.view.Surface r6 = r5.zzp
            if (r6 == 0) goto L_0x0154
            boolean r7 = r5.zzr
            if (r7 == 0) goto L_0x0154
            com.google.android.gms.internal.ads.zzaax r7 = r5.zzg
            r7.zzq(r6)
        L_0x0154:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaa.zzt(int, java.lang.Object):void");
    }

    public final void zzw() {
        this.zzB = null;
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zzd();
        } else {
            this.zzi.zzd();
        }
        this.zzr = false;
        try {
            super.zzw();
        } finally {
            this.zzg.zzc(this.zza);
            this.zzg.zzt(zzcp.zza);
        }
    }

    public final void zzx(boolean z, boolean z2) throws zzhw {
        super.zzx(z, z2);
        zzm();
        this.zzg.zze(this.zza);
        if (!this.zzl) {
            this.zzk = this.zzC;
            this.zzl = true;
        }
        if (this.zzk) {
            ((zzzr) this.zzf).zza.zzd.zze(z2);
        } else {
            this.zzi.zze(z2);
        }
    }

    public final void zzy() {
        zzh();
    }

    public final void zzz(long j, boolean z) throws zzhw {
        this.zzf.zze();
        this.zzf.zzi(zzau());
        super.zzz(j, z);
        this.zzi.zzi();
        if (z) {
            this.zzi.zzc(false);
        }
        this.zzv = 0;
    }
}
