package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzs;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
public final class zzfel {
    public final zzbxi zzA;
    public final String zzB;
    public final JSONObject zzC;
    public final JSONObject zzD;
    public final String zzE;
    public final String zzF;
    public final String zzG;
    public final String zzH;
    public final String zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final boolean zzM;
    public final boolean zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final int zzQ;
    public final int zzR;
    public final boolean zzS;
    public final boolean zzT;
    public final String zzU;
    public final zzffj zzV;
    public final boolean zzW;
    public final boolean zzX;
    public final int zzY;
    public final String zzZ;
    public final List zza;
    public final int zzaa;
    public final String zzab;
    public final boolean zzac;
    public final zzbst zzad;
    public final zzs zzae;
    public final String zzaf;
    public final boolean zzag;
    public final JSONObject zzah;
    public final boolean zzai;
    public final JSONObject zzaj;
    public final boolean zzak;
    public final String zzal;
    public final boolean zzam;
    public final String zzan;
    public final String zzao;
    public final String zzap;
    public final boolean zzaq;
    public final boolean zzar;
    public final int zzas;
    public final String zzat;
    public final List zzau;
    public final boolean zzav;
    public final Map zzaw;
    public final int zzb;
    public final List zzc;
    public final List zzd;
    public final int zze;
    public final List zzf;
    public final List zzg;
    public final List zzh;
    public final List zzi;
    public final String zzj;
    public final String zzk;
    public final zzbvz zzl;
    public final List zzm;
    public final List zzn;
    public final List zzo;
    public final List zzp;
    public final int zzq;
    public final List zzr;
    public final zzfeq zzs;
    public final List zzt;
    public final List zzu;
    public final JSONObject zzv;
    public final String zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:337:0x08e2, code lost:
        r10 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:338:0x08e4, code lost:
        r9 = r81;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzfel(android.util.JsonReader r83) throws java.lang.IllegalStateException, java.io.IOException, org.json.JSONException, java.lang.NumberFormatException {
        /*
            r82 = this;
            r0 = r82
            r82.<init>()
            java.util.List r1 = java.util.Collections.emptyList()
            java.util.List r2 = java.util.Collections.emptyList()
            java.util.List r3 = java.util.Collections.emptyList()
            java.util.List r4 = java.util.Collections.emptyList()
            java.util.List r5 = java.util.Collections.emptyList()
            java.util.List r6 = java.util.Collections.emptyList()
            java.util.List r7 = java.util.Collections.emptyList()
            java.util.List r8 = java.util.Collections.emptyList()
            java.util.List r9 = java.util.Collections.emptyList()
            java.util.List r10 = java.util.Collections.emptyList()
            java.util.List r11 = java.util.Collections.emptyList()
            java.util.List r12 = java.util.Collections.emptyList()
            java.util.List r13 = java.util.Collections.emptyList()
            java.util.List r14 = java.util.Collections.emptyList()
            org.json.JSONObject r15 = new org.json.JSONObject
            r15.<init>()
            org.json.JSONObject r16 = new org.json.JSONObject
            r16.<init>()
            org.json.JSONObject r17 = new org.json.JSONObject
            r17.<init>()
            org.json.JSONObject r18 = new org.json.JSONObject
            r18.<init>()
            org.json.JSONObject r19 = new org.json.JSONObject
            r19.<init>()
            org.json.JSONObject r20 = new org.json.JSONObject
            r20.<init>()
            com.google.android.gms.internal.ads.zzfxr.zzm()
            com.google.android.gms.internal.ads.zzfxr r21 = com.google.android.gms.internal.ads.zzfxr.zzm()
            java.util.HashMap r22 = new java.util.HashMap
            r22.<init>()
            r83.beginObject()
            r23 = 0
            java.lang.String r24 = ""
            r25 = 0
            r26 = -1
            r27 = r16
            r28 = r17
            r29 = r18
            r30 = r19
            r31 = r20
            r32 = r21
            r33 = r22
            r38 = r23
            r44 = r38
            r45 = r44
            r46 = r45
            r47 = r46
            r48 = r47
            r49 = r48
            r50 = r49
            r52 = r50
            r53 = r52
            r55 = r53
            r56 = r55
            r57 = r56
            r61 = r57
            r63 = r61
            r69 = r63
            r70 = r69
            r71 = r70
            r72 = r71
            r76 = r72
            r77 = r76
            r78 = r77
            r80 = r78
            r39 = r24
            r40 = r39
            r41 = r40
            r42 = r41
            r43 = r42
            r54 = r43
            r58 = r54
            r60 = r58
            r62 = r60
            r64 = r62
            r65 = r64
            r66 = r65
            r67 = r66
            r68 = r67
            r73 = r68
            r74 = r73
            r75 = r74
            r79 = r75
            r19 = r25
            r34 = r19
            r35 = r34
            r36 = r35
            r37 = r36
            r51 = r26
            r59 = r51
            r21 = r11
            r20 = r12
            r18 = r13
            r17 = r14
            r16 = r15
            r13 = r80
            r14 = r13
            r11 = r79
            r12 = r11
            r15 = r37
        L_0x00f2:
            boolean r22 = r83.hasNext()
            if (r22 == 0) goto L_0x08e8
            java.lang.String r22 = r83.nextName()
            if (r22 != 0) goto L_0x0101
            r25 = r24
            goto L_0x0103
        L_0x0101:
            r25 = r22
        L_0x0103:
            int r22 = r25.hashCode()
            switch(r22) {
                case -2138196627: goto L_0x065c;
                case -1980587809: goto L_0x064b;
                case -1965512151: goto L_0x063a;
                case -1871425831: goto L_0x0629;
                case -1843156475: goto L_0x0618;
                case -1812055556: goto L_0x0607;
                case -1785028569: goto L_0x05f5;
                case -1776946669: goto L_0x05e3;
                case -1662989631: goto L_0x05d1;
                case -1620470467: goto L_0x05bf;
                case -1550155393: goto L_0x05ad;
                case -1440104884: goto L_0x059b;
                case -1439500848: goto L_0x0589;
                case -1428969291: goto L_0x0577;
                case -1406227629: goto L_0x0565;
                case -1403779768: goto L_0x0553;
                case -1375413093: goto L_0x0541;
                case -1360811658: goto L_0x052f;
                case -1306015996: goto L_0x051d;
                case -1303332046: goto L_0x050b;
                case -1289032093: goto L_0x04f9;
                case -1240082064: goto L_0x04e7;
                case -1234181075: goto L_0x04d5;
                case -1168140544: goto L_0x04c3;
                case -1152230954: goto L_0x04b2;
                case -1146534047: goto L_0x04a0;
                case -1115838944: goto L_0x048e;
                case -1081936678: goto L_0x047c;
                case -1078050970: goto L_0x046a;
                case -1051269058: goto L_0x0458;
                case -982608540: goto L_0x0446;
                case -972056451: goto L_0x0434;
                case -776859333: goto L_0x0423;
                case -570101180: goto L_0x0411;
                case -544216775: goto L_0x03ff;
                case -437057161: goto L_0x03ee;
                case -404433734: goto L_0x03dc;
                case -404326515: goto L_0x03ca;
                case -397704715: goto L_0x03b8;
                case -388807511: goto L_0x03a6;
                case -369773488: goto L_0x0394;
                case -213449460: goto L_0x0382;
                case -213424028: goto L_0x0370;
                case -180214626: goto L_0x035e;
                case -154616268: goto L_0x034c;
                case -29338502: goto L_0x033a;
                case 3107: goto L_0x0328;
                case 3355: goto L_0x0316;
                case 3076010: goto L_0x0304;
                case 37109963: goto L_0x02f2;
                case 63195984: goto L_0x02e0;
                case 107433883: goto L_0x02ce;
                case 230323073: goto L_0x02bd;
                case 418392395: goto L_0x02ab;
                case 542250332: goto L_0x0299;
                case 549176928: goto L_0x0287;
                case 597473788: goto L_0x0275;
                case 754887508: goto L_0x0263;
                case 791122864: goto L_0x0252;
                case 805095541: goto L_0x0240;
                case 1010584092: goto L_0x022e;
                case 1100650276: goto L_0x021c;
                case 1141602460: goto L_0x020a;
                case 1186014765: goto L_0x01f8;
                case 1321720943: goto L_0x01e6;
                case 1422388341: goto L_0x01d4;
                case 1437255331: goto L_0x01c2;
                case 1637553475: goto L_0x01b0;
                case 1638957285: goto L_0x019f;
                case 1686319423: goto L_0x018d;
                case 1688341040: goto L_0x017c;
                case 1799285870: goto L_0x016a;
                case 1839650832: goto L_0x0158;
                case 1875425491: goto L_0x0146;
                case 2068142375: goto L_0x0134;
                case 2072888499: goto L_0x0122;
                case 2075506442: goto L_0x0110;
                default: goto L_0x010a;
            }
        L_0x010a:
            r81 = r9
            r22 = r10
            goto L_0x066d
        L_0x0110:
            r22 = r10
            java.lang.String r10 = "render_serially"
            r81 = r9
            r9 = r25
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 75
            goto L_0x066f
        L_0x0122:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "manual_tracking_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 15
            goto L_0x066f
        L_0x0134:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "rule_line_external_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 52
            goto L_0x066f
        L_0x0146:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_analytics_logging_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 42
            goto L_0x066f
        L_0x0158:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "renderers"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = r23
            goto L_0x066f
        L_0x016a:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "use_third_party_container_height"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 48
            goto L_0x066f
        L_0x017c:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "video_reward_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 7
            goto L_0x066f
        L_0x018d:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_network_class_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 55
            goto L_0x066f
        L_0x019f:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "video_start_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 6
            goto L_0x066f
        L_0x01b0:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "bid_response"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 40
            goto L_0x066f
        L_0x01c2:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_source_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 58
            goto L_0x066f
        L_0x01d4:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_collapsible"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 70
            goto L_0x066f
        L_0x01e6:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "allow_pub_owned_ad_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 31
            goto L_0x066f
        L_0x01f8:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "cache_hit_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 66
            goto L_0x066f
        L_0x020a:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "adapter_response_info_key"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 56
            goto L_0x066f
        L_0x021c:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "rewards"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 11
            goto L_0x066f
        L_0x022e:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "transaction_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 9
            goto L_0x066f
        L_0x0240:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "analytics_event_name_to_parameters_map"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 76
            goto L_0x066f
        L_0x0252:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 5
            goto L_0x066f
        L_0x0263:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "container_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 17
            goto L_0x066f
        L_0x0275:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "debug_dialog_string"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 27
            goto L_0x066f
        L_0x0287:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "presentation_error_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 16
            goto L_0x066f
        L_0x0299:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "consent_form_action_identifier"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 72
            goto L_0x066f
        L_0x02ab:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_closable_area_disabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 36
            goto L_0x066f
        L_0x02bd:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_load_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 4
            goto L_0x066f
        L_0x02ce:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "qdata"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 24
            goto L_0x066f
        L_0x02e0:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "render_test_label"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 33
            goto L_0x066f
        L_0x02f2:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "request_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 68
            goto L_0x066f
        L_0x0304:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "data"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 22
            goto L_0x066f
        L_0x0316:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 23
            goto L_0x066f
        L_0x0328:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 18
            goto L_0x066f
        L_0x033a:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "allow_custom_click_gesture"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 32
            goto L_0x066f
        L_0x034c:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_offline_ad"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 61
            goto L_0x066f
        L_0x035e:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "native_required_asset_viewability"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 63
            goto L_0x066f
        L_0x0370:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "watermark"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 46
            goto L_0x066f
        L_0x0382:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "force_disable_hardware_acceleration"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 65
            goto L_0x066f
        L_0x0394:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_close_button_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 50
            goto L_0x066f
        L_0x03a6:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "content_url"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 64
            goto L_0x066f
        L_0x03b8:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_close_time_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 45
            goto L_0x066f
        L_0x03ca:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "render_timeout_ms"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 38
            goto L_0x066f
        L_0x03dc:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "rtb_native_required_assets"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 62
            goto L_0x066f
        L_0x03ee:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "imp_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 3
            goto L_0x066f
        L_0x03ff:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "safe_browsing"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 26
            goto L_0x066f
        L_0x0411:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "late_load_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 74
            goto L_0x066f
        L_0x0423:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "click_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 2
            goto L_0x066f
        L_0x0434:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_source_instance_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 60
            goto L_0x066f
        L_0x0446:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "valid_from_timestamp"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 10
            goto L_0x066f
        L_0x0458:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "active_view"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 25
            goto L_0x066f
        L_0x046a:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "video_complete_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 8
            goto L_0x066f
        L_0x047c:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "allocation_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 21
            goto L_0x066f
        L_0x048e:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "fill_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 12
            goto L_0x066f
        L_0x04a0:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_scroll_aware"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 43
            goto L_0x066f
        L_0x04b2:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 1
            goto L_0x066f
        L_0x04c3:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "presentation_error_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 14
            goto L_0x066f
        L_0x04d5:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "allow_pub_rendered_attribution"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 30
            goto L_0x066f
        L_0x04e7:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_event_value"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 51
            goto L_0x066f
        L_0x04f9:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "extras"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 29
            goto L_0x066f
        L_0x050b:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "test_mode_enabled"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 34
            goto L_0x066f
        L_0x051d:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "adapters"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 20
            goto L_0x066f
        L_0x052f:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_sizes"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 19
            goto L_0x066f
        L_0x0541:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_cover"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 54
            goto L_0x066f
        L_0x0553:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "showable_impression_type"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 44
            goto L_0x066f
        L_0x0565:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "buffer_click_url_as_ready_to_ping"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 67
            goto L_0x066f
        L_0x0577:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "enable_omid"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 39
            goto L_0x066f
        L_0x0589:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "orientation"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 37
            goto L_0x066f
        L_0x059b:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_custom_close_blocked"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 35
            goto L_0x066f
        L_0x05ad:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "nofill_urls"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 13
            goto L_0x066f
        L_0x05bf:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "backend_query_id"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 47
            goto L_0x066f
        L_0x05d1:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_interscroller"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 53
            goto L_0x066f
        L_0x05e3:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_source_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 57
            goto L_0x066f
        L_0x05f5:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "parallel_key"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 73
            goto L_0x066f
        L_0x0607:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "play_prewarm_options"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 49
            goto L_0x066f
        L_0x0618:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "is_consent"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 71
            goto L_0x066f
        L_0x0629:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "recursive_server_response_data"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 69
            goto L_0x066f
        L_0x063a:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "omid_settings"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 41
            goto L_0x066f
        L_0x064b:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "debug_signals"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 28
            goto L_0x066f
        L_0x065c:
            r81 = r9
            r22 = r10
            r9 = r25
            java.lang.String r10 = "ad_source_instance_name"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x066d
            r9 = 59
            goto L_0x066f
        L_0x066d:
            r9 = r26
        L_0x066f:
            switch(r9) {
                case 0: goto L_0x08dc;
                case 1: goto L_0x08d1;
                case 2: goto L_0x08ca;
                case 3: goto L_0x08c3;
                case 4: goto L_0x08bc;
                case 5: goto L_0x08b1;
                case 6: goto L_0x08aa;
                case 7: goto L_0x08a3;
                case 8: goto L_0x089c;
                case 9: goto L_0x0895;
                case 10: goto L_0x088e;
                case 11: goto L_0x0883;
                case 12: goto L_0x087b;
                case 13: goto L_0x0871;
                case 14: goto L_0x0868;
                case 15: goto L_0x0860;
                case 16: goto L_0x0858;
                case 17: goto L_0x0850;
                case 18: goto L_0x0845;
                case 19: goto L_0x083f;
                case 20: goto L_0x0839;
                case 21: goto L_0x0833;
                case 22: goto L_0x082d;
                case 23: goto L_0x0827;
                case 24: goto L_0x0821;
                case 25: goto L_0x0817;
                case 26: goto L_0x080d;
                case 27: goto L_0x0807;
                case 28: goto L_0x0801;
                case 29: goto L_0x07fb;
                case 30: goto L_0x07f5;
                case 31: goto L_0x07ef;
                case 32: goto L_0x07e9;
                case 33: goto L_0x07e3;
                case 34: goto L_0x07dd;
                case 35: goto L_0x07d7;
                case 36: goto L_0x07d1;
                case 37: goto L_0x07c7;
                case 38: goto L_0x07c1;
                case 39: goto L_0x07bb;
                case 40: goto L_0x07b5;
                case 41: goto L_0x07af;
                case 42: goto L_0x07a9;
                case 43: goto L_0x07a3;
                case 44: goto L_0x079d;
                case 45: goto L_0x0797;
                case 46: goto L_0x0791;
                case 47: goto L_0x078b;
                case 48: goto L_0x0785;
                case 49: goto L_0x077b;
                case 50: goto L_0x0774;
                case 51: goto L_0x076a;
                case 52: goto L_0x0764;
                case 53: goto L_0x075e;
                case 54: goto L_0x0758;
                case 55: goto L_0x0752;
                case 56: goto L_0x074c;
                case 57: goto L_0x0734;
                case 58: goto L_0x071c;
                case 59: goto L_0x0704;
                case 60: goto L_0x06eb;
                case 61: goto L_0x06e5;
                case 62: goto L_0x06df;
                case 63: goto L_0x06d9;
                case 64: goto L_0x06d3;
                case 65: goto L_0x06cd;
                case 66: goto L_0x06c8;
                case 67: goto L_0x06c2;
                case 68: goto L_0x06bc;
                case 69: goto L_0x06b6;
                case 70: goto L_0x06b0;
                case 71: goto L_0x06aa;
                case 72: goto L_0x06a4;
                case 73: goto L_0x069e;
                case 74: goto L_0x0698;
                case 75: goto L_0x0692;
                case 76: goto L_0x0679;
                default: goto L_0x0672;
            }
        L_0x0672:
            r10 = r83
            r83.skipValue()
            goto L_0x08e2
        L_0x0679:
            com.google.android.gms.internal.ads.zzbbn r9 = com.google.android.gms.internal.ads.zzbbw.zzT
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x068d
            java.util.Map r33 = com.google.android.gms.ads.internal.util.zzbs.zze(r83)
            goto L_0x08e2
        L_0x068d:
            r83.skipValue()
            goto L_0x0777
        L_0x0692:
            boolean r80 = r83.nextBoolean()
            goto L_0x08e2
        L_0x0698:
            java.util.List r32 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            goto L_0x08e2
        L_0x069e:
            java.lang.String r79 = r83.nextString()
            goto L_0x08e2
        L_0x06a4:
            int r78 = r83.nextInt()
            goto L_0x08e2
        L_0x06aa:
            boolean r77 = r83.nextBoolean()
            goto L_0x08e2
        L_0x06b0:
            boolean r76 = r83.nextBoolean()
            goto L_0x08e2
        L_0x06b6:
            java.lang.String r74 = r83.nextString()
            goto L_0x08e2
        L_0x06bc:
            java.lang.String r73 = r83.nextString()
            goto L_0x08e2
        L_0x06c2:
            boolean r72 = r83.nextBoolean()
            goto L_0x08e2
        L_0x06c8:
            com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            goto L_0x0777
        L_0x06cd:
            boolean r71 = r83.nextBoolean()
            goto L_0x08e2
        L_0x06d3:
            java.lang.String r37 = r83.nextString()
            goto L_0x08e2
        L_0x06d9:
            boolean r70 = r83.nextBoolean()
            goto L_0x08e2
        L_0x06df:
            org.json.JSONObject r31 = com.google.android.gms.ads.internal.util.zzbs.zzi(r83)
            goto L_0x08e2
        L_0x06e5:
            boolean r69 = r83.nextBoolean()
            goto L_0x08e2
        L_0x06eb:
            com.google.android.gms.internal.ads.zzbbn r9 = com.google.android.gms.internal.ads.zzbbw.zzgd
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x06ff
            java.lang.String r68 = r83.nextString()
            goto L_0x08e2
        L_0x06ff:
            r83.skipValue()
            goto L_0x0777
        L_0x0704:
            com.google.android.gms.internal.ads.zzbbn r9 = com.google.android.gms.internal.ads.zzbbw.zzgd
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0718
            java.lang.String r67 = r83.nextString()
            goto L_0x08e2
        L_0x0718:
            r83.skipValue()
            goto L_0x0777
        L_0x071c:
            com.google.android.gms.internal.ads.zzbbn r9 = com.google.android.gms.internal.ads.zzbbw.zzgd
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0730
            java.lang.String r66 = r83.nextString()
            goto L_0x08e2
        L_0x0730:
            r83.skipValue()
            goto L_0x0777
        L_0x0734:
            com.google.android.gms.internal.ads.zzbbn r9 = com.google.android.gms.internal.ads.zzbbw.zzgd
            java.lang.Object r9 = r9.zzl()
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x0748
            java.lang.String r65 = r83.nextString()
            goto L_0x08e2
        L_0x0748:
            r83.skipValue()
            goto L_0x0777
        L_0x074c:
            java.lang.String r75 = r83.nextString()
            goto L_0x08e2
        L_0x0752:
            java.lang.String r64 = r83.nextString()
            goto L_0x08e2
        L_0x0758:
            org.json.JSONObject r30 = com.google.android.gms.ads.internal.util.zzbs.zzi(r83)
            goto L_0x08e2
        L_0x075e:
            boolean r63 = r83.nextBoolean()
            goto L_0x08e2
        L_0x0764:
            java.lang.String r62 = r83.nextString()
            goto L_0x08e2
        L_0x076a:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbs.zzi(r83)
            com.google.android.gms.ads.internal.client.zzs r36 = com.google.android.gms.ads.internal.client.zzs.zza(r9)
            goto L_0x08e2
        L_0x0774:
            r83.nextBoolean()
        L_0x0777:
            r10 = r83
            goto L_0x08e2
        L_0x077b:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbs.zzi(r83)
            com.google.android.gms.internal.ads.zzbst r35 = com.google.android.gms.internal.ads.zzbst.zza(r9)
            goto L_0x08e2
        L_0x0785:
            boolean r61 = r83.nextBoolean()
            goto L_0x08e2
        L_0x078b:
            java.lang.String r60 = r83.nextString()
            goto L_0x08e2
        L_0x0791:
            java.lang.String r58 = r83.nextString()
            goto L_0x08e2
        L_0x0797:
            int r59 = r83.nextInt()
            goto L_0x08e2
        L_0x079d:
            int r57 = r83.nextInt()
            goto L_0x08e2
        L_0x07a3:
            boolean r56 = r83.nextBoolean()
            goto L_0x08e2
        L_0x07a9:
            boolean r55 = r83.nextBoolean()
            goto L_0x08e2
        L_0x07af:
            org.json.JSONObject r29 = com.google.android.gms.ads.internal.util.zzbs.zzi(r83)
            goto L_0x08e2
        L_0x07b5:
            java.lang.String r54 = r83.nextString()
            goto L_0x08e2
        L_0x07bb:
            boolean r53 = r83.nextBoolean()
            goto L_0x08e2
        L_0x07c1:
            int r52 = r83.nextInt()
            goto L_0x08e2
        L_0x07c7:
            java.lang.String r9 = r83.nextString()
            int r51 = zzd(r9)
            goto L_0x08e2
        L_0x07d1:
            boolean r50 = r83.nextBoolean()
            goto L_0x08e2
        L_0x07d7:
            boolean r49 = r83.nextBoolean()
            goto L_0x08e2
        L_0x07dd:
            boolean r48 = r83.nextBoolean()
            goto L_0x08e2
        L_0x07e3:
            boolean r47 = r83.nextBoolean()
            goto L_0x08e2
        L_0x07e9:
            boolean r46 = r83.nextBoolean()
            goto L_0x08e2
        L_0x07ef:
            boolean r45 = r83.nextBoolean()
            goto L_0x08e2
        L_0x07f5:
            boolean r44 = r83.nextBoolean()
            goto L_0x08e2
        L_0x07fb:
            org.json.JSONObject r28 = com.google.android.gms.ads.internal.util.zzbs.zzi(r83)
            goto L_0x08e2
        L_0x0801:
            org.json.JSONObject r27 = com.google.android.gms.ads.internal.util.zzbs.zzi(r83)
            goto L_0x08e2
        L_0x0807:
            java.lang.String r43 = r83.nextString()
            goto L_0x08e2
        L_0x080d:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbs.zzi(r83)
            com.google.android.gms.internal.ads.zzbxi r34 = com.google.android.gms.internal.ads.zzbxi.zza(r9)
            goto L_0x08e2
        L_0x0817:
            org.json.JSONObject r9 = com.google.android.gms.ads.internal.util.zzbs.zzi(r83)
            java.lang.String r42 = r9.toString()
            goto L_0x08e2
        L_0x0821:
            java.lang.String r41 = r83.nextString()
            goto L_0x08e2
        L_0x0827:
            java.lang.String r40 = r83.nextString()
            goto L_0x08e2
        L_0x082d:
            org.json.JSONObject r16 = com.google.android.gms.ads.internal.util.zzbs.zzi(r83)
            goto L_0x08e2
        L_0x0833:
            java.lang.String r39 = r83.nextString()
            goto L_0x08e2
        L_0x0839:
            java.util.List r18 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            goto L_0x08e2
        L_0x083f:
            java.util.List r17 = com.google.android.gms.internal.ads.zzfem.zza(r83)
            goto L_0x08e2
        L_0x0845:
            com.google.android.gms.internal.ads.zzfeq r9 = new com.google.android.gms.internal.ads.zzfeq
            r10 = r83
            r9.<init>(r10)
            r19 = r9
            goto L_0x08e2
        L_0x0850:
            r10 = r83
            java.util.List r20 = com.google.android.gms.internal.ads.zzfem.zza(r83)
            goto L_0x08e2
        L_0x0858:
            r10 = r83
            int r38 = r83.nextInt()
            goto L_0x08e2
        L_0x0860:
            r10 = r83
            java.util.List r21 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            goto L_0x08e2
        L_0x0868:
            r10 = r83
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            r10 = r9
            goto L_0x08e4
        L_0x0871:
            r10 = r83
            java.util.List r9 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            r10 = r22
            goto L_0x00f2
        L_0x087b:
            r10 = r83
            java.util.List r8 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            goto L_0x08e2
        L_0x0883:
            r10 = r83
            org.json.JSONArray r9 = com.google.android.gms.ads.internal.util.zzbs.zzf(r83)
            com.google.android.gms.internal.ads.zzbvz r15 = com.google.android.gms.internal.ads.zzbvz.zza(r9)
            goto L_0x08e2
        L_0x088e:
            r10 = r83
            java.lang.String r11 = r83.nextString()
            goto L_0x08e2
        L_0x0895:
            r10 = r83
            java.lang.String r12 = r83.nextString()
            goto L_0x08e2
        L_0x089c:
            r10 = r83
            java.util.List r7 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            goto L_0x08e2
        L_0x08a3:
            r10 = r83
            java.util.List r6 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            goto L_0x08e2
        L_0x08aa:
            r10 = r83
            java.util.List r5 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            goto L_0x08e2
        L_0x08b1:
            r10 = r83
            int r9 = r83.nextInt()
            int r14 = zzc(r9)
            goto L_0x08e2
        L_0x08bc:
            r10 = r83
            java.util.List r4 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            goto L_0x08e2
        L_0x08c3:
            r10 = r83
            java.util.List r3 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            goto L_0x08e2
        L_0x08ca:
            r10 = r83
            java.util.List r2 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
            goto L_0x08e2
        L_0x08d1:
            r10 = r83
            java.lang.String r9 = r83.nextString()
            int r13 = zzb(r9)
            goto L_0x08e2
        L_0x08dc:
            r10 = r83
            java.util.List r1 = com.google.android.gms.ads.internal.util.zzbs.zzd(r83)
        L_0x08e2:
            r10 = r22
        L_0x08e4:
            r9 = r81
            goto L_0x00f2
        L_0x08e8:
            r81 = r9
            r22 = r10
            r10 = r83
            r83.endObject()
            r0.zza = r1
            r0.zzb = r13
            r0.zzc = r2
            r0.zzd = r3
            r0.zzf = r4
            r0.zze = r14
            r0.zzg = r5
            r0.zzh = r6
            r0.zzi = r7
            r0.zzj = r12
            r0.zzk = r11
            r0.zzl = r15
            r0.zzm = r8
            r0.zzn = r9
            r9 = r22
            r0.zzo = r9
            r11 = r21
            r0.zzp = r11
            r1 = r38
            r0.zzq = r1
            r12 = r20
            r0.zzr = r12
            r9 = r19
            r0.zzs = r9
            r13 = r18
            r0.zzt = r13
            r14 = r17
            r0.zzu = r14
            r1 = r39
            r0.zzw = r1
            r15 = r16
            r0.zzv = r15
            r1 = r40
            r0.zzx = r1
            r1 = r41
            r0.zzy = r1
            r1 = r42
            r0.zzz = r1
            r1 = r34
            r0.zzA = r1
            r1 = r43
            r0.zzB = r1
            r1 = r27
            r0.zzC = r1
            r1 = r28
            r0.zzD = r1
            r1 = r44
            r0.zzJ = r1
            r1 = r45
            r0.zzK = r1
            r1 = r46
            r0.zzL = r1
            r1 = r47
            r0.zzM = r1
            r1 = r48
            r0.zzN = r1
            r1 = r49
            r0.zzO = r1
            r1 = r50
            r0.zzP = r1
            r1 = r51
            r0.zzQ = r1
            r1 = r52
            r0.zzR = r1
            r1 = r53
            r0.zzT = r1
            r1 = r54
            r0.zzU = r1
            com.google.android.gms.internal.ads.zzffj r1 = new com.google.android.gms.internal.ads.zzffj
            r2 = r29
            r1.<init>(r2)
            r0.zzV = r1
            r1 = r55
            r0.zzW = r1
            r1 = r56
            r0.zzX = r1
            r1 = r57
            r0.zzY = r1
            r1 = r58
            r0.zzZ = r1
            r1 = r59
            r0.zzaa = r1
            r1 = r60
            r0.zzab = r1
            r1 = r61
            r0.zzac = r1
            r1 = r35
            r0.zzad = r1
            r1 = r36
            r0.zzae = r1
            r1 = r62
            r0.zzaf = r1
            r1 = r63
            r0.zzag = r1
            r1 = r30
            r0.zzah = r1
            r1 = r64
            r0.zzE = r1
            r1 = r65
            r0.zzF = r1
            r1 = r66
            r0.zzG = r1
            r1 = r67
            r0.zzH = r1
            r1 = r68
            r0.zzI = r1
            r1 = r69
            r0.zzai = r1
            r1 = r31
            r0.zzaj = r1
            r1 = r70
            r0.zzak = r1
            r1 = r37
            r0.zzal = r1
            r1 = r71
            r0.zzam = r1
            r1 = r72
            r0.zzS = r1
            r1 = r73
            r0.zzan = r1
            r1 = r74
            r0.zzao = r1
            r1 = r75
            r0.zzap = r1
            r1 = r76
            r0.zzaq = r1
            r1 = r77
            r0.zzar = r1
            r1 = r78
            r0.zzas = r1
            r1 = r32
            r0.zzau = r1
            r1 = r79
            r0.zzat = r1
            r1 = r80
            r0.zzav = r1
            r1 = r33
            r0.zzaw = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfel.<init>(android.util.JsonReader):void");
    }

    public static String zza(int i) {
        switch (i) {
            case 1:
                return "BANNER";
            case 2:
                return "INTERSTITIAL";
            case 3:
                return "NATIVE_EXPRESS";
            case 4:
                return "NATIVE";
            case 5:
                return "REWARDED";
            case 6:
                return "APP_OPEN_AD";
            case 7:
                return "REWARDED_INTERSTITIAL";
            default:
                return "UNKNOWN";
        }
    }

    private static int zzb(String str) {
        if ("banner".equals(str)) {
            return 1;
        }
        if ("interstitial".equals(str)) {
            return 2;
        }
        if ("native_express".equals(str)) {
            return 3;
        }
        if ("native".equals(str)) {
            return 4;
        }
        if ("rewarded".equals(str)) {
            return 5;
        }
        if ("app_open_ad".equals(str)) {
            return 6;
        }
        if ("rewarded_interstitial".equals(str)) {
            return 7;
        }
        return 0;
    }

    private static int zzc(int i) {
        if (i == 0 || i == 1 || i == 3) {
            return i;
        }
        return 0;
    }

    private static final int zzd(String str) {
        if ("landscape".equalsIgnoreCase(str)) {
            return 6;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            return 7;
        }
        return -1;
    }
}
