package com.momagic;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.momagic.B;
import in.juspay.hyper.constants.LogCategory;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.momagic.h  reason: case insensitive filesystem */
/* compiled from: DATB */
public final class C0835h {
    @SuppressLint({"StaticFieldLeak"})
    public static Activity a;

    /* renamed from: a  reason: collision with other field name */
    public static Context f4046a;

    /* renamed from: a  reason: collision with other field name */
    public static j f4047a;

    /* renamed from: a  reason: collision with other field name */
    public static String f4048a;

    /* renamed from: a  reason: collision with other field name */
    public static C1348qc f4049a;

    /* renamed from: a  reason: collision with other field name */
    public static final C1352qn f4050a = new C1352qn();
    public static String b;

    /* renamed from: com.momagic.h$a */
    /* compiled from: DATB */
    public class a implements Runnable {
        public final /* synthetic */ String c;

        public a(String str) {
            this.c = str;
        }

        public final void run() {
            C0835h.k(this.c);
        }
    }

    /* renamed from: com.momagic.h$b */
    /* compiled from: DATB */
    public class b extends B.b {
        public final /* synthetic */ C1139gq a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ String f4051a;

        public b(C1139gq gqVar, String str) {
            this.a = gqVar;
            this.f4051a = str;
        }

        public final void a(int i, String str) {
            this.a.h("iz_SUBSCRIBER_ID_DATA", this.f4051a);
        }

        public final void b(String str) {
            this.a.h("iz_SUBSCRIBER_ID_DATA", "");
        }
    }

    /* renamed from: com.momagic.h$c */
    /* compiled from: DATB */
    public class c extends B.b {
        public final /* synthetic */ C1139gq a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ String f4052a;

        public c(C1139gq gqVar, String str) {
            this.a = gqVar;
            this.f4052a = str;
        }

        public final void a(int i, String str) {
            this.a.h("iz_SUBSCRIBER_ID_DATA", this.f4052a);
        }

        public final void b(String str) {
            this.a.h("iz_SUBSCRIBER_ID_DATA", "");
        }
    }

    /* renamed from: com.momagic.h$d */
    /* compiled from: DATB */
    public class d implements Runnable {
        public final /* synthetic */ HashMap a;

        public d(HashMap hashMap) {
            this.a = hashMap;
        }

        public final void run() {
            C1104f8.b(C0835h.f4046a, "addUserProperty(): operation from pending task queue.", "[Log.d]->addUserProperty->");
            C0835h.b(this.a);
        }
    }

    /* renamed from: com.momagic.h$e */
    /* compiled from: DATB */
    public class e extends B.b {
        public final /* synthetic */ C1139gq a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ HashMap f4053a;

        public e(C1139gq gqVar, HashMap hashMap) {
            this.a = gqVar;
            this.f4053a = hashMap;
        }

        public final void a(int i, String str) {
            this.a.h("iz_userLocalData", new JSONObject(this.f4053a).toString());
        }

        public final void b(String str) {
            this.a.h("iz_userLocalData", (String) null);
        }
    }

    /* renamed from: com.momagic.h$f */
    /* compiled from: DATB */
    public class f implements Runnable {
        public final /* synthetic */ Boolean a;

        public f(Boolean bool) {
            this.a = bool;
        }

        public final void run() {
            C0835h.l(this.a);
        }
    }

    /* renamed from: com.momagic.h$g */
    /* compiled from: DATB */
    public class g extends B.b {
        public final /* synthetic */ C1139gq a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Boolean f4054a;

        public g(C1139gq gqVar, Boolean bool) {
            this.a = gqVar;
            this.f4054a = bool;
        }

        public final void a(int i, String str) {
            C1139gq gqVar = this.a;
            gqVar.f("isSetSubscriptionMethod", true);
            gqVar.f("setSubscriptionLocalData", this.f4054a.booleanValue());
        }

        public final void b(String str) {
            this.a.f("isSetSubscriptionMethod", false);
        }
    }

    /* renamed from: com.momagic.h$i */
    /* compiled from: DATB */
    public class i implements C1063dA {
        public final /* synthetic */ Context a;

        public i(Context context) {
            this.a = context;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0241 A[Catch:{ Exception -> 0x03d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x025a A[Catch:{ Exception -> 0x03d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x026d A[Catch:{ Exception -> 0x03d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x028b A[Catch:{ Exception -> 0x03d1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x02a5 A[SYNTHETIC, Splitter:B:38:0x02a5] */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x03f6  */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x0408  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0415  */
        /* JADX WARNING: Removed duplicated region for block: B:74:0x041e  */
        /* JADX WARNING: Removed duplicated region for block: B:77:0x0431  */
        /* JADX WARNING: Removed duplicated region for block: B:82:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r43 = this;
                java.lang.String r0 = "iz_remove_topic_offline"
                java.lang.String r1 = "iz_add_topic_offline"
                java.lang.String r2 = "iz_SUBSCRIBER_ID_DATA"
                java.lang.String r3 = "eventLocalDataEV"
                java.lang.String r4 = "eventLocalDataEN"
                java.lang.String r5 = "iz_userLocalData"
                android.content.Context r6 = com.momagic.C0835h.f4046a
                if (r6 == 0) goto L_0x03ed
                gq r6 = defpackage.C1139gq.c(r6)
                java.lang.String r8 = r6.b()
                java.lang.String r9 = "DATB"
                if (r8 == 0) goto L_0x03e1
                java.lang.String r8 = r6.b()
                boolean r8 = r8.isEmpty()
                if (r8 != 0) goto L_0x03e1
                java.lang.String r8 = "isTokenUpdated"
                boolean r8 = r6.a(r8)
                java.lang.String r10 = "pid"
                java.lang.String r11 = "deviceName"
                java.lang.String r12 = "osVersion"
                java.lang.String r13 = "momagic-sdk"
                java.lang.String r14 = "sn"
                java.lang.String r15 = "mpn"
                java.lang.String r7 = "add"
                r16 = r0
                java.lang.String r0 = "adid"
                r17 = r1
                java.lang.String r1 = "deviceToken"
                r18 = r2
                java.lang.String r2 = "at"
                r19 = r3
                java.lang.String r3 = "av"
                r20 = r4
                java.lang.String r4 = "ln"
                r21 = r5
                java.lang.String r5 = "check"
                r22 = r9
                java.lang.String r9 = "bKey"
                r23 = r11
                java.lang.String r11 = "1"
                r24 = r12
                java.lang.String r12 = "allowed"
                r25 = r13
                java.lang.String r13 = "4"
                r26 = r14
                java.lang.String r14 = "os"
                r27 = r15
                java.lang.String r15 = "bver"
                r28 = r0
                java.lang.String r0 = "tz"
                r29 = r7
                java.lang.String r7 = "3"
                r30 = r2
                java.lang.String r2 = "dtype"
                r31 = r1
                java.lang.String r1 = "9"
                r32 = r3
                java.lang.String r3 = "btype"
                r33 = r4
                java.lang.String r4 = "2"
                r34 = r5
                java.lang.String r5 = "s"
                r35 = r9
                java.lang.String r9 = "2.4.0"
                r36 = r9
                java.lang.String r9 = "registerToken"
                r37 = r9
                java.lang.String r9 = ""
                if (r8 != 0) goto L_0x01cf
                java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x01bf }
                r8.<init>()     // Catch:{ Exception -> 0x01bf }
                r8.put(r5, r4)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r4 = r6.b()     // Catch:{ Exception -> 0x01bf }
                r8.put(r10, r4)     // Catch:{ Exception -> 0x01bf }
                r8.put(r3, r1)     // Catch:{ Exception -> 0x01bf }
                r8.put(r2, r7)     // Catch:{ Exception -> 0x01bf }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
                r1.<init>(r9)     // Catch:{ Exception -> 0x01bf }
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x01bf }
                r1.append(r2)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x01bf }
                r8.put(r0, r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
                r0.<init>(r9)     // Catch:{ Exception -> 0x01bf }
                android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x01bf }
                java.lang.String r1 = com.momagic.H.h(r1)     // Catch:{ Exception -> 0x01bf }
                r0.append(r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bf }
                r8.put(r15, r0)     // Catch:{ Exception -> 0x01bf }
                r8.put(r14, r13)     // Catch:{ Exception -> 0x01bf }
                r8.put(r12, r11)     // Catch:{ Exception -> 0x01bf }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
                r0.<init>(r9)     // Catch:{ Exception -> 0x01bf }
                android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x01bf }
                java.lang.String r1 = com.momagic.H.g(r1)     // Catch:{ Exception -> 0x01bf }
                r0.append(r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bf }
                r1 = r35
                r8.put(r1, r0)     // Catch:{ Exception -> 0x01bf }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
                r0.<init>(r9)     // Catch:{ Exception -> 0x01bf }
                android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x01bf }
                java.lang.String r1 = com.momagic.H.h(r1)     // Catch:{ Exception -> 0x01bf }
                r0.append(r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bf }
                r1 = r34
                r8.put(r1, r0)     // Catch:{ Exception -> 0x01bf }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
                r0.<init>(r9)     // Catch:{ Exception -> 0x01bf }
                android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x01bf }
                android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x01bf }
                android.content.res.Configuration r1 = r1.getConfiguration()     // Catch:{ Exception -> 0x01bf }
                android.os.LocaleList r1 = r1.getLocales()     // Catch:{ Exception -> 0x01bf }
                r2 = 0
                java.util.Locale r1 = r1.get(r2)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r1 = r1.getDisplayLanguage()     // Catch:{ Exception -> 0x01bf }
                r0.append(r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bf }
                r1 = r33
                r8.put(r1, r0)     // Catch:{ Exception -> 0x01bf }
                r0 = r32
                r1 = r36
                r8.put(r0, r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
                r0.<init>(r9)     // Catch:{ Exception -> 0x01bf }
                r1 = r31
                java.lang.String r1 = r6.e(r1)     // Catch:{ Exception -> 0x01bf }
                r0.append(r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bf }
                r1 = r30
                r8.put(r1, r0)     // Catch:{ Exception -> 0x01bf }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
                r0.<init>(r9)     // Catch:{ Exception -> 0x01bf }
                r1 = r29
                java.lang.String r1 = r6.e(r1)     // Catch:{ Exception -> 0x01bf }
                r0.append(r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bf }
                r1 = r28
                r8.put(r1, r0)     // Catch:{ Exception -> 0x01bf }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
                r0.<init>(r9)     // Catch:{ Exception -> 0x01bf }
                android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x01bf }
                java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x01bf }
                r0.append(r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bf }
                r1 = r27
                r8.put(r1, r0)     // Catch:{ Exception -> 0x01bf }
                r0 = r25
                r1 = r26
                r8.put(r1, r0)     // Catch:{ Exception -> 0x01bf }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
                r0.<init>(r9)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r1 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x01bf }
                r0.append(r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bf }
                r1 = r24
                r8.put(r1, r0)     // Catch:{ Exception -> 0x01bf }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01bf }
                r0.<init>(r9)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r1 = com.momagic.H.k()     // Catch:{ Exception -> 0x01bf }
                r0.append(r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x01bf }
                r1 = r23
                r8.put(r1, r0)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r0 = "https://irctc.truenotify.in/momagicflow/appenp"
                com.momagic.m r1 = new com.momagic.m     // Catch:{ Exception -> 0x01bf }
                r1.<init>()     // Catch:{ Exception -> 0x01bf }
                r2 = 0
                com.momagic.B.c(r0, r8, r2, r1)     // Catch:{ Exception -> 0x01bf }
                java.lang.String r0 = "https://aevents.izooto.com/app"
                com.momagic.n r1 = new com.momagic.n     // Catch:{ Exception -> 0x01bf }
                r1.<init>(r6)     // Catch:{ Exception -> 0x01bf }
                com.momagic.B.c(r0, r8, r2, r1)     // Catch:{ Exception -> 0x01bf }
                goto L_0x03ed
            L_0x01bf:
                r0 = move-exception
                android.content.Context r1 = com.momagic.C0835h.f4046a
                java.lang.String r0 = r0.toString()
                r8 = r22
                r2 = r37
                com.momagic.H.r(r1, r0, r8, r2)
                goto L_0x03ed
            L_0x01cf:
                r38 = r26
                r39 = r28
                r40 = r30
                r8 = r35
                r41 = r36
                r42 = r37
                android.content.Context r26 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03d1 }
                com.momagic.C0835h.g(r26)     // Catch:{ Exception -> 0x03d1 }
                android.content.Context r26 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03d1 }
                com.momagic.C0835h.c(r26)     // Catch:{ Exception -> 0x03d1 }
                r35 = r8
                r8 = r21
                java.lang.String r21 = r6.e(r8)     // Catch:{ Exception -> 0x03d1 }
                boolean r21 = r21.isEmpty()     // Catch:{ Exception -> 0x03d1 }
                if (r21 != 0) goto L_0x0206
                r21 = r11
                org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ Exception -> 0x03d1 }
                java.lang.String r8 = r6.e(r8)     // Catch:{ Exception -> 0x03d1 }
                r11.<init>(r8)     // Catch:{ Exception -> 0x03d1 }
                java.util.HashMap r8 = com.momagic.H.y(r11)     // Catch:{ Exception -> 0x03d1 }
                com.momagic.C0835h.b(r8)     // Catch:{ Exception -> 0x03d1 }
                goto L_0x0208
            L_0x0206:
                r21 = r11
            L_0x0208:
                r8 = r20
                java.lang.String r11 = r6.e(r8)     // Catch:{ Exception -> 0x03d1 }
                boolean r11 = r11.isEmpty()     // Catch:{ Exception -> 0x03d1 }
                if (r11 != 0) goto L_0x0237
                r11 = r19
                java.lang.String r19 = r6.e(r11)     // Catch:{ Exception -> 0x03d1 }
                boolean r19 = r19.isEmpty()     // Catch:{ Exception -> 0x03d1 }
                if (r19 != 0) goto L_0x0237
                r19 = r12
                org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ Exception -> 0x03d1 }
                java.lang.String r11 = r6.e(r11)     // Catch:{ Exception -> 0x03d1 }
                r12.<init>(r11)     // Catch:{ Exception -> 0x03d1 }
                java.lang.String r8 = r6.e(r8)     // Catch:{ Exception -> 0x03d1 }
                java.util.HashMap r11 = com.momagic.H.y(r12)     // Catch:{ Exception -> 0x03d1 }
                com.momagic.C0835h.a(r11, r8)     // Catch:{ Exception -> 0x03d1 }
                goto L_0x0239
            L_0x0237:
                r19 = r12
            L_0x0239:
                java.lang.String r8 = "isSetSubscriptionMethod"
                boolean r8 = r6.a(r8)     // Catch:{ Exception -> 0x03d1 }
                if (r8 == 0) goto L_0x024e
                java.lang.String r8 = "setSubscriptionLocalData"
                boolean r8 = r6.a(r8)     // Catch:{ Exception -> 0x03d1 }
                java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ Exception -> 0x03d1 }
                com.momagic.C0835h.l(r8)     // Catch:{ Exception -> 0x03d1 }
            L_0x024e:
                r8 = r18
                java.lang.String r11 = r6.e(r8)     // Catch:{ Exception -> 0x03d1 }
                boolean r11 = r11.isEmpty()     // Catch:{ Exception -> 0x03d1 }
                if (r11 != 0) goto L_0x0261
                java.lang.String r8 = r6.e(r8)     // Catch:{ Exception -> 0x03d1 }
                com.momagic.C0835h.k(r8)     // Catch:{ Exception -> 0x03d1 }
            L_0x0261:
                r8 = r17
                java.lang.String r11 = r6.e(r8)     // Catch:{ Exception -> 0x03d1 }
                boolean r11 = r11.isEmpty()     // Catch:{ Exception -> 0x03d1 }
                if (r11 != 0) goto L_0x027f
                org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ Exception -> 0x03d1 }
                java.lang.String r8 = r6.e(r8)     // Catch:{ Exception -> 0x03d1 }
                r11.<init>(r8)     // Catch:{ Exception -> 0x03d1 }
                java.lang.String r8 = "add_topic"
                java.util.ArrayList r11 = com.momagic.H.x(r11)     // Catch:{ Exception -> 0x03d1 }
                com.momagic.C0835h.m(r8, r11)     // Catch:{ Exception -> 0x03d1 }
            L_0x027f:
                r8 = r16
                java.lang.String r11 = r6.e(r8)     // Catch:{ Exception -> 0x03d1 }
                boolean r11 = r11.isEmpty()     // Catch:{ Exception -> 0x03d1 }
                if (r11 != 0) goto L_0x029d
                org.json.JSONArray r11 = new org.json.JSONArray     // Catch:{ Exception -> 0x03d1 }
                java.lang.String r8 = r6.e(r8)     // Catch:{ Exception -> 0x03d1 }
                r11.<init>(r8)     // Catch:{ Exception -> 0x03d1 }
                java.lang.String r8 = "remove_topic"
                java.util.ArrayList r11 = com.momagic.H.x(r11)     // Catch:{ Exception -> 0x03d1 }
                com.momagic.C0835h.m(r8, r11)     // Catch:{ Exception -> 0x03d1 }
            L_0x029d:
                java.lang.String r8 = "iz_fileExits"
                boolean r8 = r6.a(r8)     // Catch:{ Exception -> 0x03d1 }
                if (r8 != 0) goto L_0x03ed
                java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x03b9 }
                r8.<init>()     // Catch:{ Exception -> 0x03b9 }
                r8.put(r5, r4)     // Catch:{ Exception -> 0x03b9 }
                java.lang.String r4 = r6.b()     // Catch:{ Exception -> 0x03b9 }
                r8.put(r10, r4)     // Catch:{ Exception -> 0x03b9 }
                r8.put(r3, r1)     // Catch:{ Exception -> 0x03b9 }
                r8.put(r2, r7)     // Catch:{ Exception -> 0x03b9 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b9 }
                r1.<init>(r9)     // Catch:{ Exception -> 0x03b9 }
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x03b9 }
                r1.append(r2)     // Catch:{ Exception -> 0x03b9 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x03b9 }
                r8.put(r0, r1)     // Catch:{ Exception -> 0x03b9 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b9 }
                r0.<init>(r9)     // Catch:{ Exception -> 0x03b9 }
                android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03b9 }
                java.lang.String r1 = com.momagic.H.h(r1)     // Catch:{ Exception -> 0x03b9 }
                r0.append(r1)     // Catch:{ Exception -> 0x03b9 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03b9 }
                r8.put(r15, r0)     // Catch:{ Exception -> 0x03b9 }
                r8.put(r14, r13)     // Catch:{ Exception -> 0x03b9 }
                r1 = r19
                r0 = r21
                r8.put(r1, r0)     // Catch:{ Exception -> 0x03b9 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b9 }
                r0.<init>(r9)     // Catch:{ Exception -> 0x03b9 }
                android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03b9 }
                java.lang.String r1 = com.momagic.H.g(r1)     // Catch:{ Exception -> 0x03b9 }
                r0.append(r1)     // Catch:{ Exception -> 0x03b9 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03b9 }
                r1 = r35
                r8.put(r1, r0)     // Catch:{ Exception -> 0x03b9 }
                r0 = r34
                r1 = r41
                r8.put(r0, r1)     // Catch:{ Exception -> 0x03b9 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b9 }
                r0.<init>(r9)     // Catch:{ Exception -> 0x03b9 }
                android.content.Context r2 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03b9 }
                android.content.res.Resources r2 = r2.getResources()     // Catch:{ Exception -> 0x03b9 }
                android.content.res.Configuration r2 = r2.getConfiguration()     // Catch:{ Exception -> 0x03b9 }
                android.os.LocaleList r2 = r2.getLocales()     // Catch:{ Exception -> 0x03b9 }
                r3 = 0
                java.util.Locale r2 = r2.get(r3)     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r2 = r2.getDisplayLanguage()     // Catch:{ Exception -> 0x03b7 }
                r0.append(r2)     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03b7 }
                r2 = r33
                r8.put(r2, r0)     // Catch:{ Exception -> 0x03b7 }
                r0 = r32
                r8.put(r0, r1)     // Catch:{ Exception -> 0x03b7 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b7 }
                r0.<init>(r9)     // Catch:{ Exception -> 0x03b7 }
                r1 = r31
                java.lang.String r1 = r6.e(r1)     // Catch:{ Exception -> 0x03b7 }
                r0.append(r1)     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03b7 }
                r1 = r40
                r8.put(r1, r0)     // Catch:{ Exception -> 0x03b7 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b7 }
                r0.<init>(r9)     // Catch:{ Exception -> 0x03b7 }
                r1 = r29
                java.lang.String r1 = r6.e(r1)     // Catch:{ Exception -> 0x03b7 }
                r0.append(r1)     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03b7 }
                r1 = r39
                r8.put(r1, r0)     // Catch:{ Exception -> 0x03b7 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b7 }
                r0.<init>(r9)     // Catch:{ Exception -> 0x03b7 }
                android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r1 = r1.getPackageName()     // Catch:{ Exception -> 0x03b7 }
                r0.append(r1)     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03b7 }
                r1 = r27
                r8.put(r1, r0)     // Catch:{ Exception -> 0x03b7 }
                r0 = r25
                r1 = r38
                r8.put(r1, r0)     // Catch:{ Exception -> 0x03b7 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b7 }
                r0.<init>(r9)     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r1 = android.os.Build.VERSION.RELEASE     // Catch:{ Exception -> 0x03b7 }
                r0.append(r1)     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03b7 }
                r1 = r24
                r8.put(r1, r0)     // Catch:{ Exception -> 0x03b7 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x03b7 }
                r0.<init>(r9)     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r1 = com.momagic.H.k()     // Catch:{ Exception -> 0x03b7 }
                r0.append(r1)     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03b7 }
                r1 = r23
                r8.put(r1, r0)     // Catch:{ Exception -> 0x03b7 }
                android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r1 = r8.toString()     // Catch:{ Exception -> 0x03b7 }
                java.lang.String r2 = "RegisterToken"
                defpackage.C1104f8.b(r0, r1, r2)     // Catch:{ Exception -> 0x03b7 }
                goto L_0x03ee
            L_0x03b7:
                r0 = move-exception
                goto L_0x03bb
            L_0x03b9:
                r0 = move-exception
                r3 = 0
            L_0x03bb:
                android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x03cb }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x03cb }
                r2 = r22
                r4 = r42
                com.momagic.H.r(r1, r0, r2, r4)     // Catch:{ Exception -> 0x03c9 }
                goto L_0x03ee
            L_0x03c9:
                r0 = move-exception
                goto L_0x03d7
            L_0x03cb:
                r0 = move-exception
                r2 = r22
                r4 = r42
                goto L_0x03d7
            L_0x03d1:
                r0 = move-exception
                r2 = r22
                r4 = r42
                r3 = 0
            L_0x03d7:
                android.content.Context r1 = com.momagic.C0835h.f4046a
                java.lang.String r0 = r0.toString()
                com.momagic.H.r(r1, r0, r2, r4)
                goto L_0x03ee
            L_0x03e1:
                r2 = r9
                r3 = 0
                android.content.Context r0 = com.momagic.C0835h.f4046a
                java.lang.String r1 = "Missing pid"
                java.lang.String r4 = "Register Token"
                com.momagic.H.r(r0, r1, r2, r4)
                goto L_0x03ee
            L_0x03ed:
                r3 = 0
            L_0x03ee:
                android.content.Context r0 = com.momagic.C0835h.f4046a
                android.app.Application r0 = (android.app.Application) r0
                M r1 = defpackage.M.a
                if (r1 != 0) goto L_0x0400
                M r1 = new M
                r1.<init>()
                defpackage.M.a = r1
                r0.registerActivityLifecycleCallbacks(r1)
            L_0x0400:
                r1 = r43
                android.content.Context r0 = r1.a
                boolean r2 = r0 instanceof android.app.Activity
                if (r2 == 0) goto L_0x040c
                android.app.Activity r0 = (android.app.Activity) r0
                com.momagic.C0835h.a = r0
            L_0x040c:
                android.content.Context r0 = com.momagic.C0835h.f4046a
                com.momagic.C0835h.c(r0)
                android.content.Context r0 = com.momagic.C0835h.f4046a
                if (r0 == 0) goto L_0x041b
                java.lang.Class<com.google.firebase.analytics.FirebaseAnalytics> r0 = com.google.firebase.analytics.FirebaseAnalytics.class
                defpackage.C1348qc.a = r0     // Catch:{ Exception -> 0x041b }
                r7 = 1
                goto L_0x041c
            L_0x041b:
                r7 = r3
            L_0x041c:
                if (r7 == 0) goto L_0x0427
                qc r0 = new qc
                android.content.Context r2 = com.momagic.C0835h.f4046a
                r0.<init>(r2)
                com.momagic.C0835h.f4049a = r0
            L_0x0427:
                qn r0 = com.momagic.C0835h.f4050a
                java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r2 = r0.f6905a
                boolean r3 = r2.isEmpty()
                if (r3 != 0) goto L_0x044e
                pn r3 = new pn
                r3.<init>()
                java.util.concurrent.ExecutorService r3 = java.util.concurrent.Executors.newSingleThreadExecutor(r3)
                r0.f6906a = r3
            L_0x043c:
                boolean r3 = r2.isEmpty()
                if (r3 != 0) goto L_0x044e
                java.util.concurrent.ExecutorService r3 = r0.f6906a
                java.lang.Object r4 = r2.poll()
                java.lang.Runnable r4 = (java.lang.Runnable) r4
                r3.submit(r4)
                goto L_0x043c
            L_0x044e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.momagic.C0835h.i.a():void");
        }
    }

    /* renamed from: com.momagic.h$j */
    /* compiled from: DATB */
    public static class j {
        public Context a;

        public j(Context context) {
            this.a = context;
        }

        public final void a() {
            Context context = this.a;
            Context applicationContext = context.getApplicationContext();
            C0835h.f4046a = applicationContext;
            C0835h.f4047a = this;
            this.a = null;
            C1139gq c = C1139gq.c(applicationContext);
            try {
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle != null) {
                    if (bundle.containsKey("momagic_app_id")) {
                        String string = bundle.getString("momagic_app_id");
                        C0835h.b = string;
                        c.h("encryptedPid", string);
                    }
                    if (C0835h.b != "") {
                        B.a(new j(context), "https://cdn.izooto.com/app/app_" + C0835h.b + ".dat");
                        return;
                    }
                    return;
                }
                H.r(C0835h.f4046a, "It seems you forgot to configure momagic_app id or momagic_sender_id property in your app level build.gradle", "DATB", "init_onSuccess");
            } catch (Throwable th) {
                H.r(C0835h.f4046a, th.toString(), "DATB", "initBuilder");
            }
        }
    }

    public static void a(HashMap hashMap, String str) {
        C1352qn qnVar = f4050a;
        qnVar.getClass();
        if (C1352qn.b("addEvent()") && f4046a == null) {
            qnVar.a(new C0604N7(hashMap, str));
        } else if (hashMap == null || str == null || str.length() <= 0 || hashMap.size() <= 0) {
            H.r(f4046a, "Event Name or Event Data are not available", "DATB", "addEvent");
        } else {
            String replace = str.substring(0, Math.min(str.length(), 32)).replace(" ", "_");
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry : hashMap.entrySet()) {
                if (entry.getKey() != null && !((String) entry.getKey()).isEmpty()) {
                    hashMap2.put(((String) entry.getKey()).toLowerCase(), entry.getValue());
                }
            }
            if (hashMap2.size() > 0) {
                Context context = f4046a;
                if (context != null) {
                    C1139gq c2 = C1139gq.c(context);
                    HashMap hashMap3 = new HashMap();
                    int i2 = 1;
                    for (Map.Entry entry2 : hashMap2.entrySet()) {
                        if (i2 <= 16) {
                            String substring = ((String) entry2.getKey()).substring(0, Math.min(((String) entry2.getKey()).length(), 32));
                            if (entry2.getValue() instanceof String) {
                                if (entry2.getValue().toString().length() > 0) {
                                    hashMap3.put(substring, entry2.getValue().toString().substring(0, Math.min(entry2.getValue().toString().length(), 64)));
                                }
                            } else if (!(entry2.getValue() instanceof String) && entry2.getValue() != null) {
                                hashMap3.put(substring, entry2.getValue());
                            }
                            i2++;
                        }
                    }
                    if (hashMap3.size() > 0) {
                        try {
                            JSONObject jSONObject = new JSONObject(hashMap3);
                            if (!c2.b().isEmpty()) {
                                if (c2.d("iz_cantStoredQueue") > 0) {
                                    if (!c2.e("deviceToken").isEmpty()) {
                                        HashMap hashMap4 = new HashMap();
                                        hashMap4.put("pid", c2.b());
                                        hashMap4.put("act", replace);
                                        hashMap4.put("et", "evt");
                                        hashMap4.put("bKey", "" + H.g(f4046a));
                                        hashMap4.put("val", "" + jSONObject.toString());
                                        Context context2 = f4046a;
                                        C1104f8.b(context2, replace + "EventData->" + hashMap4.toString(), "[Log.v]->");
                                        B.c("https://et.izooto.com/evt", hashMap4, (JSONObject) null, new i(c2, hashMap2, replace));
                                        return;
                                    }
                                    JSONObject jSONObject2 = new JSONObject(hashMap2);
                                    c2.h("eventLocalDataEN", replace);
                                    c2.h("eventLocalDataEV", jSONObject2.toString());
                                    return;
                                }
                            }
                            JSONObject jSONObject3 = new JSONObject(hashMap2);
                            c2.h("eventLocalDataEN", replace);
                            c2.h("eventLocalDataEV", jSONObject3.toString());
                        } catch (Exception e2) {
                            H.r(f4046a, e2.toString(), "DATB", "addEventAPI");
                        }
                    } else {
                        H.r(f4046a, "Event length more than 32", "DATB", "AdEvent");
                    }
                }
            } else {
                H.r(f4046a, "Event Name or Event Data are not available", "DATB", "addEvent");
            }
        }
    }

    public static void b(HashMap<String, Object> hashMap) {
        C1352qn qnVar = f4050a;
        qnVar.getClass();
        if (C1352qn.b("addUserProperty()") && f4046a == null) {
            qnVar.a(new d(hashMap));
        } else if (hashMap == null || hashMap.size() <= 0) {
            H.r(f4046a, "Blank user properties", "DATB", "addUserProperty");
        } else {
            try {
                C1139gq c2 = C1139gq.c(f4046a);
                HashMap hashMap2 = new HashMap();
                for (Map.Entry next : hashMap.entrySet()) {
                    if (next.getKey() != null && !((String) next.getKey()).isEmpty()) {
                        hashMap2.put(((String) next.getKey()).toLowerCase(), next.getValue());
                    }
                }
                if (hashMap2.size() > 0) {
                    HashMap e2 = e(hashMap2);
                    if (e2.size() > 0) {
                        JSONObject jSONObject = new JSONObject(e2);
                        if (!c2.b().isEmpty()) {
                            if (c2.d("iz_cantStoredQueue") > 0) {
                                if (!c2.e("deviceToken").isEmpty()) {
                                    HashMap hashMap3 = new HashMap();
                                    hashMap3.put("pid", c2.b());
                                    hashMap3.put("act", "add");
                                    hashMap3.put("et", "userp");
                                    hashMap3.put("bKey", "" + H.g(f4046a));
                                    hashMap3.put("val", "" + jSONObject.toString());
                                    B.c("https://prp.izooto.com/prp", hashMap3, (JSONObject) null, new e(c2, hashMap));
                                    return;
                                }
                                c2.h("iz_userLocalData", new JSONObject(hashMap).toString());
                                return;
                            }
                        }
                        c2.h("iz_userLocalData", new JSONObject(hashMap).toString());
                        return;
                    }
                    H.r(f4046a, "Blank user properties", "DATB", "addUserProperty");
                    return;
                }
                H.r(f4046a, "Blank user properties", "DATB", "addUserProperty");
            } catch (Exception e3) {
                H.r(f4046a, e3.toString(), "DATB", "addUserProperty");
            }
        }
    }

    public static void c(Context context) {
        if (context != null) {
            C1139gq c2 = C1139gq.c(context);
            if (c2.d("enable") == 0) {
                boolean z = true;
                c2.g(1, "enable");
                c2.g(0, "disable");
                C1139gq c3 = C1139gq.c(context);
                try {
                    if (!c3.b().isEmpty()) {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                        if (connectivityManager != null) {
                            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                            if (allNetworkInfo != null) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= allNetworkInfo.length) {
                                        break;
                                    } else if (allNetworkInfo[i2].getState() == NetworkInfo.State.CONNECTED) {
                                        break;
                                    } else {
                                        i2++;
                                    }
                                }
                            }
                        }
                        z = false;
                        if (z && !c3.e("deviceToken").isEmpty()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pid", c3.b());
                            hashMap.put("bKey", "" + H.g(context));
                            hashMap.put("btype", "9");
                            hashMap.put("dtype", C0515Ga.FARE_AVLBLTY);
                            hashMap.put("bver", "2.4.0");
                            hashMap.put("pte", C0515Ga.FARE_ONLY);
                            hashMap.put("os", "4");
                            hashMap.put("pt", "0");
                            hashMap.put("ge", C0515Ga.AVLBLTY_ONLY);
                            hashMap.put(LogCategory.ACTION, "" + 0);
                            B.c("https://usub.izooto.com/sunsub", hashMap, (JSONObject) null, new o());
                        }
                    }
                } catch (Exception e2) {
                    H.r(context, e2.toString(), "DATB", "getNotificationAPI");
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0030, code lost:
        if (r6.getImportance() == 0) goto L_0x0033;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044 A[Catch:{ Exception -> 0x00d3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e A[ADDED_TO_REGION, Catch:{ Exception -> 0x00d3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(android.content.Context r5, java.lang.String r6, java.lang.String r7) {
        /*
            java.lang.String r0 = "checkNotificationPermission"
            java.lang.String r1 = "DATB"
            gq r2 = defpackage.C1139gq.c(r5)
            java.lang.String r3 = "notification"
            en r4 = new en     // Catch:{ all -> 0x0035 }
            r4.<init>(r5)     // Catch:{ all -> 0x0035 }
            boolean r4 = r4.a()     // Catch:{ all -> 0x0035 }
            if (r4 != 0) goto L_0x0016
            goto L_0x0033
        L_0x0016:
            if (r6 == 0) goto L_0x0041
            java.lang.Object r4 = r5.getSystemService(r3)     // Catch:{ all -> 0x0035 }
            android.app.NotificationManager r4 = (android.app.NotificationManager) r4     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x0041
            java.lang.Object r3 = r5.getSystemService(r3)     // Catch:{ all -> 0x0035 }
            android.app.NotificationManager r3 = (android.app.NotificationManager) r3     // Catch:{ all -> 0x0035 }
            android.app.NotificationChannel r6 = r3.getNotificationChannel(r6)     // Catch:{ all -> 0x0035 }
            if (r6 == 0) goto L_0x0041
            int r6 = r6.getImportance()     // Catch:{ all -> 0x0035 }
            if (r6 == 0) goto L_0x0033
            goto L_0x0041
        L_0x0033:
            r6 = 0
            goto L_0x0042
        L_0x0035:
            r6 = move-exception
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r3 = "Util"
            java.lang.String r4 = "areNotificationsEnabled"
            com.momagic.H.r(r5, r6, r3, r4)     // Catch:{ Exception -> 0x00d3 }
        L_0x0041:
            r6 = 1
        L_0x0042:
            if (r6 == 0) goto L_0x005e
            if (r7 == 0) goto L_0x0051
            boolean r6 = r7.isEmpty()     // Catch:{ Exception -> 0x00d3 }
            if (r6 != 0) goto L_0x0051
            f(r5, r7)     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00db
        L_0x0051:
            android.content.Context r6 = f4046a     // Catch:{ Exception -> 0x00d3 }
            int r7 = defpackage.C0772Zr.something_wrong_fcm_sender_id     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r6 = r6.getString(r7)     // Catch:{ Exception -> 0x00d3 }
            com.momagic.H.r(r5, r6, r1, r0)     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00db
        L_0x005e:
            if (r7 == 0) goto L_0x009c
            boolean r6 = r7.isEmpty()     // Catch:{ Exception -> 0x00d3 }
            if (r6 != 0) goto L_0x009c
            java.lang.String r6 = "deviceToken"
            java.lang.String r6 = r2.e(r6)     // Catch:{ Exception -> 0x00d3 }
            boolean r6 = r6.isEmpty()     // Catch:{ Exception -> 0x00d3 }
            if (r6 != 0) goto L_0x009c
            defpackage.C0577Lb.c(r7)     // Catch:{ Exception -> 0x0090 }
            gq r6 = defpackage.C1139gq.c(r5)     // Catch:{ Exception -> 0x0090 }
            com.google.firebase.FirebaseApp r7 = defpackage.C0577Lb.a     // Catch:{ Exception -> 0x0090 }
            java.lang.Class<com.google.firebase.messaging.FirebaseMessaging> r2 = com.google.firebase.messaging.FirebaseMessaging.class
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x0090 }
            com.google.firebase.messaging.FirebaseMessaging r7 = (com.google.firebase.messaging.FirebaseMessaging) r7     // Catch:{ Exception -> 0x0090 }
            com.google.android.gms.tasks.Task r7 = r7.deleteToken()     // Catch:{ Exception -> 0x0090 }
            Jb r2 = new Jb     // Catch:{ Exception -> 0x0090 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0090 }
            r7.addOnCompleteListener(r2)     // Catch:{ Exception -> 0x0090 }
            goto L_0x009c
        L_0x0090:
            r6 = move-exception
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r7 = "FCMTokenGenerator"
            java.lang.String r2 = "removeDeviceAddress"
            com.momagic.H.r(r5, r6, r7, r2)     // Catch:{ Exception -> 0x00d3 }
        L_0x009c:
            gq r6 = defpackage.C1139gq.c(r5)     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r7 = "isPrompt"
            boolean r6 = r6.a(r7)     // Catch:{ Exception -> 0x00d3 }
            if (r6 == 0) goto L_0x00db
            android.content.Context r6 = f4046a     // Catch:{ Exception -> 0x00d3 }
            if (r6 == 0) goto L_0x00db
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00d3 }
            r7 = 33
            if (r6 < r7) goto L_0x00db
            android.content.Intent r6 = new android.content.Intent     // Catch:{ Exception -> 0x00c6 }
            android.content.Context r7 = f4046a     // Catch:{ Exception -> 0x00c6 }
            java.lang.Class<com.momagic.NotificationPermission> r2 = com.momagic.NotificationPermission.class
            r6.<init>(r7, r2)     // Catch:{ Exception -> 0x00c6 }
            r7 = 268435456(0x10000000, float:2.5243549E-29)
            r6.addFlags(r7)     // Catch:{ Exception -> 0x00c6 }
            android.content.Context r7 = f4046a     // Catch:{ Exception -> 0x00c6 }
            r7.startActivity(r6)     // Catch:{ Exception -> 0x00c6 }
            goto L_0x00db
        L_0x00c6:
            r6 = move-exception
            android.content.Context r7 = f4046a     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00d3 }
            java.lang.String r2 = "promptForPushNotifications"
            com.momagic.H.r(r7, r6, r1, r2)     // Catch:{ Exception -> 0x00d3 }
            goto L_0x00db
        L_0x00d3:
            r6 = move-exception
            java.lang.String r6 = r6.toString()
            com.momagic.H.r(r5, r6, r1, r0)
        L_0x00db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.momagic.C0835h.d(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static HashMap e(HashMap hashMap) {
        HashMap hashMap2 = new HashMap();
        int i2 = 1;
        int i3 = 1;
        for (Map.Entry entry : hashMap.entrySet()) {
            if (i2 <= 64) {
                String substring = ((String) entry.getKey()).substring(0, Math.min(((String) entry.getKey()).length(), 32));
                if (entry.getValue() instanceof String) {
                    if (entry.getValue().toString().length() > 0) {
                        hashMap2.put(substring, entry.getValue().toString().substring(0, Math.min(entry.getValue().toString().length(), 64)));
                    }
                } else if (entry.getValue() instanceof List) {
                    ArrayList arrayList = new ArrayList();
                    for (Object next : (List) entry.getValue()) {
                        if (i3 <= 64) {
                            boolean z = next instanceof String;
                            if (z) {
                                String obj = next.toString();
                                if (i3 <= 64 && obj.length() > 0) {
                                    arrayList.add(obj.substring(0, Math.min(obj.length(), 64)));
                                }
                            } else if (!z && next != null) {
                                arrayList.add(next);
                            }
                            i3++;
                        }
                    }
                    hashMap2.put(substring, arrayList);
                } else if (!(entry.getValue() instanceof String) && !(entry.getValue() instanceof List) && entry.getValue() != null) {
                    hashMap2.put(substring, entry.getValue());
                }
                i2++;
            }
        }
        return hashMap2;
    }

    public static void f(Context context, String str) {
        if (context != null) {
            try {
                C0577Lb lb = new C0577Lb();
                i iVar = new i(context);
                C1139gq c2 = C1139gq.c(context);
                if (c2.a("iz_canGenerateFcmToken")) {
                    c2.e("deviceToken");
                    iVar.a();
                    return;
                }
                new Thread(new C0564Kb(lb, str, context, iVar)).start();
            } catch (Exception e2) {
                H.r(f4046a, e2.toString(), "DATB", "init");
            }
        }
    }

    public static void g(Context context) {
        String str;
        if (context != null) {
            C1139gq c2 = C1139gq.c(context);
            if (!c2.e("currentDate").equalsIgnoreCase(new SimpleDateFormat("yyyy.MM.dd").format(new Date()))) {
                c2.h("currentDate", new SimpleDateFormat("yyyy.MM.dd").format(new Date()));
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("last_website_visit", Boolean.TRUE);
                    Context context2 = f4046a;
                    if (context2 != null) {
                        context2.getResources().getConfiguration().getLocales().get(0);
                        str = Locale.getDefault().getDisplayLanguage();
                    } else {
                        str = "iz_ln";
                    }
                    hashMap.put("lang", str);
                    JSONObject jSONObject = new JSONObject(hashMap);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("pid", c2.b());
                    hashMap2.put("bKey", "" + H.g(f4046a));
                    hashMap2.put("val", "" + jSONObject.toString());
                    hashMap2.put("act", "add");
                    hashMap2.put("isid", C0515Ga.AVLBLTY_ONLY);
                    hashMap2.put("et", "userp");
                    Context context3 = f4046a;
                    C1104f8.b(context3, "Last Visit" + hashMap2.toString(), "[Log.e]->LastVisit->");
                    B.c("https://lvi.izooto.com/lvi", hashMap2, (JSONObject) null, new C0053h());
                } catch (Exception e2) {
                    H.r(context, e2.toString(), "DATB", "lastVisitAPI");
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
        r2 = f4049a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void h() {
        /*
            java.lang.String r0 = "datbcount"
            android.content.Context r1 = f4046a
            if (r1 == 0) goto L_0x0090
            gq r1 = defpackage.C1139gq.c(r1)
            qc r2 = f4049a
            r3 = 1
            if (r2 == 0) goto L_0x0070
            java.lang.String r2 = "isCheck"
            boolean r2 = r1.a(r2)
            if (r2 == 0) goto L_0x0070
            qc r2 = f4049a
            android.content.Context r4 = r2.f6898a
            if (r4 == 0) goto L_0x0070
            java.util.concurrent.atomic.AtomicLong r5 = defpackage.C1348qc.b
            if (r5 != 0) goto L_0x0028
            java.util.concurrent.atomic.AtomicLong r5 = new java.util.concurrent.atomic.AtomicLong
            r5.<init>()
            defpackage.C1348qc.b = r5
        L_0x0028:
            java.util.concurrent.atomic.AtomicLong r5 = defpackage.C1348qc.b
            long r6 = java.lang.System.currentTimeMillis()
            r5.set(r6)
            java.lang.Object r2 = r2.c(r4)     // Catch:{ Exception -> 0x0064 }
            java.lang.Class<?> r5 = defpackage.C1348qc.a     // Catch:{ Exception -> 0x0064 }
            java.lang.reflect.Method r5 = defpackage.C1348qc.e(r5)     // Catch:{ Exception -> 0x0064 }
            jp r6 = defpackage.C1348qc.f6897a     // Catch:{ Exception -> 0x0064 }
            android.os.Bundle r6 = defpackage.C1348qc.b(r6)     // Catch:{ Exception -> 0x0064 }
            if (r6 == 0) goto L_0x0070
            jp r6 = defpackage.C1348qc.f6897a     // Catch:{ Exception -> 0x0064 }
            android.os.Bundle r6 = defpackage.C1348qc.b(r6)     // Catch:{ Exception -> 0x0064 }
            if (r6 == 0) goto L_0x0054
            java.lang.String r7 = "time_of_click"
            java.lang.String r8 = defpackage.C1348qc.d()     // Catch:{ Exception -> 0x0064 }
            r6.putString(r7, r8)     // Catch:{ Exception -> 0x0064 }
        L_0x0054:
            if (r5 == 0) goto L_0x0070
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x0064 }
            java.lang.String r8 = "push_notification_opened"
            r9 = 0
            r7[r9] = r8     // Catch:{ Exception -> 0x0064 }
            r7[r3] = r6     // Catch:{ Exception -> 0x0064 }
            r5.invoke(r2, r7)     // Catch:{ Exception -> 0x0064 }
            goto L_0x0070
        L_0x0064:
            r2 = move-exception
            java.lang.String r2 = r2.toString()
            java.lang.String r5 = "FirebaseAnalyticsClass"
            java.lang.String r6 = "openTrackEvent"
            com.momagic.H.r(r4, r2, r5, r6)
        L_0x0070:
            int r2 = r1.d(r0)     // Catch:{ Exception -> 0x0082 }
            int r2 = r2 - r3
            r1.g(r2, r0)     // Catch:{ Exception -> 0x0082 }
            android.content.Context r2 = f4046a     // Catch:{ Exception -> 0x0082 }
            int r0 = r1.d(r0)     // Catch:{ Exception -> 0x0082 }
            defpackage.Dw.a(r2, r0)     // Catch:{ Exception -> 0x0082 }
            goto L_0x0090
        L_0x0082:
            r0 = move-exception
            android.content.Context r1 = f4046a
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "DATB"
            java.lang.String r3 = "notificationActionHandler"
            com.momagic.H.r(r1, r0, r2, r3)
        L_0x0090:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.momagic.C0835h.h():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        r1 = f4049a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void i(defpackage.C1203jp r8) {
        /*
            android.content.Context r0 = f4046a
            gq r0 = defpackage.C1139gq.c(r0)
            if (r8 == 0) goto L_0x0083
            qc r1 = f4049a
            r2 = 0
            if (r1 == 0) goto L_0x0061
            java.lang.String r1 = "isCheck"
            boolean r1 = r0.a(r1)
            if (r1 == 0) goto L_0x0061
            qc r1 = f4049a
            android.content.Context r3 = r1.f6898a
            if (r3 == 0) goto L_0x0061
            java.lang.Object r1 = r1.c(r3)     // Catch:{ Exception -> 0x0055 }
            java.lang.Class<?> r4 = defpackage.C1348qc.a     // Catch:{ Exception -> 0x0055 }
            java.lang.reflect.Method r4 = defpackage.C1348qc.e(r4)     // Catch:{ Exception -> 0x0055 }
            android.os.Bundle r5 = defpackage.C1348qc.b(r8)     // Catch:{ Exception -> 0x0055 }
            if (r5 == 0) goto L_0x0061
            android.os.Bundle r5 = defpackage.C1348qc.b(r8)     // Catch:{ Exception -> 0x0055 }
            if (r4 == 0) goto L_0x003e
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0055 }
            java.lang.String r7 = "push_notification_received"
            r6[r2] = r7     // Catch:{ Exception -> 0x0055 }
            r7 = 1
            r6[r7] = r5     // Catch:{ Exception -> 0x0055 }
            r4.invoke(r1, r6)     // Catch:{ Exception -> 0x0055 }
        L_0x003e:
            java.util.concurrent.atomic.AtomicLong r1 = defpackage.C1348qc.f6896a     // Catch:{ Exception -> 0x0055 }
            if (r1 != 0) goto L_0x0049
            java.util.concurrent.atomic.AtomicLong r1 = new java.util.concurrent.atomic.AtomicLong     // Catch:{ Exception -> 0x0055 }
            r1.<init>()     // Catch:{ Exception -> 0x0055 }
            defpackage.C1348qc.f6896a = r1     // Catch:{ Exception -> 0x0055 }
        L_0x0049:
            java.util.concurrent.atomic.AtomicLong r1 = defpackage.C1348qc.f6896a     // Catch:{ Exception -> 0x0055 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0055 }
            r1.set(r4)     // Catch:{ Exception -> 0x0055 }
            defpackage.C1348qc.f6897a = r8     // Catch:{ Exception -> 0x0055 }
            goto L_0x0061
        L_0x0055:
            r1 = move-exception
            java.lang.String r1 = r1.toString()
            java.lang.String r4 = "FirebaseAnalyticsClass"
            java.lang.String r5 = "receiveEvent"
            com.momagic.H.r(r3, r1, r4, r5)
        L_0x0061:
            java.lang.String r1 = r8.f5529c
            if (r1 == 0) goto L_0x0083
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0083
            java.lang.String r1 = r8.f5529c
            java.lang.String r3 = "notificationId"
            java.lang.String r4 = r0.e(r3)
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x007e
            java.lang.String r1 = "notificationIdUpdated"
            r0.f(r1, r2)
        L_0x007e:
            java.lang.String r8 = r8.f5529c
            r0.h(r3, r8)
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.momagic.C0835h.i(jp):void");
    }

    public static void j(Context context, C1203jp jpVar) {
        Context context2 = context;
        C1203jp jpVar2 = jpVar;
        if (jpVar2 != null) {
            String str = jpVar2.f5525a;
            if (str == null || str.isEmpty()) {
                Context context3 = f4046a;
                if (!(context3 == null || context3 == null)) {
                    try {
                        x.o(context3, jpVar2);
                    } catch (Exception e2) {
                        H.r(f4046a, e2.toString(), "NotificationEventManager", "allCloudPush");
                    }
                }
            } else {
                Context context4 = f4046a;
                if (context4 != null) {
                    try {
                        if (C1139gq.c(context4).a("Mediation")) {
                            Context context5 = f4046a;
                            if (context5 != null) {
                                x.o(context5, jpVar2);
                            }
                        } else {
                            B.a(new s(jpVar2), x.c(jpVar2.f5525a));
                        }
                    } catch (Exception e3) {
                        H.r(f4046a, e3.toString(), "NotificationEventManager", "adPush");
                    }
                }
            }
        }
        if (context2 != null) {
            String str2 = "iz_api_name";
            C1139gq c2 = C1139gq.c(context);
            try {
                String str3 = "apiURL";
                if (!c2.e("iZ_Notification_Click_Offline").isEmpty()) {
                    JSONArray jSONArray = new JSONArray(c2.e("iZ_Notification_Click_Offline"));
                    int i2 = 0;
                    while (i2 < jSONArray.length()) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        int i3 = i2;
                        NotificationActionReceiver.e(context, jSONObject.optString(str3), jSONObject.optString("cid"), jSONObject.optString("rid"), jSONObject.optInt("click"), i3, "fcm");
                        i2 = i3 + 1;
                        str3 = str3;
                        jSONArray = jSONArray;
                        str2 = str2;
                    }
                }
                String str4 = str2;
                String str5 = str3;
                if (!c2.e("iZ_Notification_Last_Click_Offline").isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray(c2.e("iZ_Notification_Last_Click_Offline"));
                    for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                        NotificationActionReceiver.c(i4, context2, jSONObject2.optString(str5), jSONObject2.optString("rid"));
                    }
                }
                if (!c2.e("iZ_Notification_View_Offline").isEmpty()) {
                    JSONArray jSONArray3 = new JSONArray(c2.e("iZ_Notification_View_Offline"));
                    for (int i5 = 0; i5 < jSONArray3.length(); i5++) {
                        JSONObject jSONObject3 = jSONArray3.getJSONObject(i5);
                        x.k(jSONObject3.optString(str5), jSONObject3.optString("cid"), jSONObject3.optString("rid"));
                    }
                }
                if (!c2.e("iZ_Notification_Last_View_Offline").isEmpty()) {
                    JSONArray jSONArray4 = new JSONArray(c2.e("iZ_Notification_Last_View_Offline"));
                    for (int i6 = 0; i6 < jSONArray4.length(); i6++) {
                        JSONObject jSONObject4 = jSONArray4.getJSONObject(i6);
                        x.l(i6, jSONObject4.optString(str5), jSONObject4.optString("rid"), jSONObject4.optString("cid"));
                    }
                }
                if (!c2.e("iz_mediation_records").isEmpty()) {
                    JSONArray jSONArray5 = new JSONArray(c2.e("iz_mediation_records"));
                    int i7 = 0;
                    while (i7 < jSONArray5.length()) {
                        JSONObject jSONObject5 = jSONArray5.getJSONObject(i7);
                        String str6 = str4;
                        if (jSONObject5.getString(str6).equals("iz_impression")) {
                            C0828a.m(i7, jSONObject5.getString("iz_mediationData"));
                        }
                        if (jSONObject5.getString(str6).equals("iz_mClick")) {
                            NotificationActionReceiver.a(i7, jSONObject5.getString("iz_mediationData"));
                        }
                        i7++;
                        str4 = str6;
                    }
                }
            } catch (Exception e4) {
                H.r(f4046a, e4.toString(), "DATB", "initialize");
            }
        }
    }

    public static void k(String str) {
        C1352qn qnVar = f4050a;
        qnVar.getClass();
        if (!C1352qn.b("setSubscriberID()") || f4046a != null) {
            Context context = f4046a;
            if (context != null) {
                C1139gq c2 = C1139gq.c(context);
                if (!c2.e("DATB_SUBID").equalsIgnoreCase(str)) {
                    c2.h("DATB_SUBID", str);
                    if (str == null || str.isEmpty()) {
                        H.r(f4046a, "Subscriber ID is not here", "DATB", "SetSubscriberID");
                    } else if (c2.b().isEmpty() || c2.d("iz_cantStoredQueue") <= 0) {
                        c2.h("iz_SUBSCRIBER_ID_DATA", str);
                    } else if (!c2.e("deviceToken").isEmpty()) {
                        try {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pid", c2.b());
                            hashMap.put("operation", "add_property");
                            hashMap.put("btype", "9");
                            hashMap.put("pt", C0515Ga.AVLBLTY_ONLY);
                            hashMap.put("bKey", H.g(f4046a));
                            hashMap.put(AppMeasurementSdk.ConditionalUserProperty.NAME, "subscriber_id");
                            hashMap.put("at", c2.e("deviceToken"));
                            hashMap.put("value", str);
                            B.c("https://irctc.truenotify.in/momagicflow/appup", hashMap, (JSONObject) null, new b(c2, str));
                            B.c("https://pp.izooto.com/idsyn", hashMap, (JSONObject) null, new c(c2, str));
                        } catch (Exception e2) {
                            H.r(f4046a, e2.toString(), "DATB", "setSubscriptionID");
                        }
                    } else {
                        c2.h("iz_SUBSCRIBER_ID_DATA", str);
                    }
                } else {
                    Context context2 = f4046a;
                    C1104f8.b(context2, "Repeated Subscriber ID " + str, "[Log.e]->");
                }
            }
        } else {
            qnVar.a(new a(str));
        }
    }

    public static void l(Boolean bool) {
        int i2;
        C1352qn qnVar = f4050a;
        qnVar.getClass();
        if (!C1352qn.b("setSubscription()") || f4046a != null) {
            C1139gq c2 = C1139gq.c(f4046a);
            c2.f("isEnable", bool.booleanValue());
            try {
                if (bool.booleanValue()) {
                    i2 = 0;
                } else {
                    i2 = 2;
                }
                if (!c2.b().isEmpty()) {
                    if (c2.d("iz_cantStoredQueue") > 0) {
                        if (!c2.e("deviceToken").isEmpty()) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pid", c2.b());
                            hashMap.put("bKey", "" + H.g(f4046a));
                            hashMap.put("btype", "9");
                            hashMap.put("dtype", C0515Ga.FARE_AVLBLTY);
                            hashMap.put("bver", "2.4.0");
                            hashMap.put("pte", C0515Ga.FARE_ONLY);
                            hashMap.put("os", "4");
                            hashMap.put("pt", "0");
                            hashMap.put("ge", C0515Ga.AVLBLTY_ONLY);
                            hashMap.put(LogCategory.ACTION, "" + i2);
                            Context context = f4046a;
                            C1104f8.b(context, "setSubscription" + hashMap.toString(), "[Log.d]->setSubscription->");
                            B.c("https://usub.izooto.com/sunsub", hashMap, (JSONObject) null, new g(c2, bool));
                            return;
                        }
                        c2.f("isSetSubscriptionMethod", true);
                        c2.f("setSubscriptionLocalData", bool.booleanValue());
                        return;
                    }
                }
                c2.f("isSetSubscriptionMethod", true);
                c2.f("setSubscriptionLocalData", bool.booleanValue());
            } catch (Exception e2) {
                H.r(f4046a, e2.toString(), "DATB", "setSubscription");
            }
        } else {
            qnVar.a(new f(bool));
        }
    }

    public static void m(String str, ArrayList arrayList) {
        if (f4046a != null) {
            try {
                if (arrayList.size() > 0) {
                    C1139gq c2 = C1139gq.c(f4046a);
                    if (!c2.b().isEmpty()) {
                        if (c2.d("iz_cantStoredQueue") > 0) {
                            if (!c2.e("deviceToken").isEmpty()) {
                                HashMap hashMap = new HashMap();
                                hashMap.put("topic", arrayList);
                                JSONObject jSONObject = new JSONObject(hashMap);
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("pid", c2.b());
                                hashMap2.put("act", str);
                                hashMap2.put("et", "userp");
                                hashMap2.put("bKey", "" + H.g(f4046a));
                                hashMap2.put("val", "" + jSONObject.toString());
                                hashMap2.put("at", "" + c2.e("deviceToken"));
                                hashMap2.put("btype", "9");
                                B.c("https://prp.izooto.com/prp", hashMap2, (JSONObject) null, new k(str, c2, arrayList));
                                return;
                            }
                            JSONArray jSONArray = new JSONArray(arrayList);
                            if (str.equalsIgnoreCase("add_topic")) {
                                c2.h("iz_add_topic_offline", jSONArray.toString());
                                return;
                            } else if (str.equalsIgnoreCase("remove_topic")) {
                                c2.h("iz_remove_topic_offline", jSONArray.toString());
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    JSONArray jSONArray2 = new JSONArray(arrayList);
                    if (str.equalsIgnoreCase("add_topic")) {
                        c2.h("iz_add_topic_offline", jSONArray2.toString());
                    } else if (str.equalsIgnoreCase("remove_topic")) {
                        c2.h("iz_remove_topic_offline", jSONArray2.toString());
                    }
                }
            } catch (Exception e2) {
                H.r(f4046a, e2.toString(), "DATB", "topicApi");
            }
        }
    }

    /* renamed from: com.momagic.h$h  reason: collision with other inner class name */
    /* compiled from: DATB */
    public class C0053h extends B.b {
        public final void b(String str) {
        }

        public final void a(int i, String str) {
        }
    }
}
