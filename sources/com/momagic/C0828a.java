package com.momagic;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.messaging.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.momagic.B;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.momagic.a  reason: case insensitive filesystem */
/* compiled from: AdMediation */
public final class C0828a {
    public static int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public static final ArrayList f4032a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public static C1203jp f4033a;
    public static final ArrayList b = new ArrayList();
    public static final ArrayList c = new ArrayList();
    public static final ArrayList d = new ArrayList();
    public static final ArrayList e = new ArrayList();
    public static final ArrayList f = new ArrayList();
    public static final ArrayList g = new ArrayList();

    /* renamed from: com.momagic.a$a  reason: collision with other inner class name */
    /* compiled from: AdMediation */
    public class C0052a extends B.b {
        public final /* synthetic */ C1139gq a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ String f4034a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1203jp f4035a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ JSONObject f4036a;

        public C0052a(C1203jp jpVar, JSONObject jSONObject, String str, C1139gq gqVar) {
            this.f4035a = jpVar;
            this.f4036a = jSONObject;
            this.f4034a = str;
            this.a = gqVar;
        }

        public final void a(int i, String str) {
            C1203jp jpVar = this.f4035a;
            C0828a.e(jpVar, C0828a.f(jpVar));
        }

        public final void b(String str) {
            String str2 = str;
            String str3 = "globalPayload";
            try {
                String str4 = str3;
                try {
                    JSONObject jSONObject = new JSONObject(str2.replace("\n", ""));
                    boolean has = jSONObject.has("an");
                    JSONObject jSONObject2 = this.f4036a;
                    String str5 = "iz_gplPayload";
                    C1203jp jpVar = this.f4035a;
                    if (has) {
                        C0828a.i(C0835h.f4046a, jSONObject, jpVar.K, jSONObject2.toString());
                        return;
                    }
                    if (jSONObject2.has("ct")) {
                        jpVar.J = jSONObject2.optString("ct");
                    } else {
                        jpVar.J = jSONObject.optString("ct");
                    }
                    if (jSONObject2.has("k")) {
                        jpVar.f5528b = jSONObject2.optString("k");
                    } else {
                        jpVar.f5528b = jSONObject.optString("k");
                    }
                    if (jSONObject2.has(FacebookMediationAdapter.KEY_ID)) {
                        jpVar.f5529c = jSONObject2.optString(FacebookMediationAdapter.KEY_ID);
                    } else {
                        jpVar.f5529c = jSONObject.optString(FacebookMediationAdapter.KEY_ID);
                    }
                    if (jSONObject2.has("r")) {
                        jpVar.f5530d = jSONObject2.optString("r");
                    } else {
                        jpVar.f5530d = jSONObject.optString("r");
                    }
                    jpVar.f5525a = jSONObject.optString("fu");
                    jpVar.f5531e = jSONObject.optString("ln");
                    jpVar.f5532f = jSONObject.optString("t");
                    jpVar.f5534h = jSONObject.optString("m");
                    jpVar.f5535i = jSONObject.optString("i");
                    if (jSONObject2.has("ri")) {
                        jSONObject2.optInt("ri");
                        jpVar.getClass();
                    } else {
                        jSONObject.optInt("ri");
                        jpVar.getClass();
                    }
                    if (jSONObject2.has("tg")) {
                        jpVar.f5537k = jSONObject2.optString("tg");
                    } else {
                        jpVar.f5537k = jSONObject.optString("tg");
                    }
                    if (jSONObject2.has("b1")) {
                        jpVar.m = jSONObject2.optString("b1");
                    } else {
                        jpVar.m = jSONObject.optString("b1");
                    }
                    if (jSONObject2.has("l1")) {
                        jpVar.n = jSONObject2.optString("l1");
                    } else {
                        jpVar.n = jSONObject.optString("l1");
                    }
                    jpVar.f5538l = jSONObject.optString("bi");
                    jpVar.b = jSONObject.optInt("b");
                    jSONObject.optString("bic");
                    jpVar.getClass();
                    jpVar.f5536j = jSONObject.optString("bc");
                    jpVar.f5533g = jSONObject.optString("st");
                    jpVar.a = jSONObject.optInt("gp");
                    jpVar.f = jSONObject.optInt("bct");
                    jSONObject.optString("ib1");
                    jpVar.getClass();
                    jpVar.u = jSONObject.optString("d1");
                    jpVar.o = jSONObject.optString("b2");
                    jpVar.p = jSONObject.optString("l2");
                    jSONObject.optString("ib2");
                    jpVar.getClass();
                    jpVar.v = jSONObject.optString("d2");
                    jpVar.c = jSONObject.optInt("ia");
                    jSONObject.optString("ti");
                    jpVar.getClass();
                    jSONObject.optString("ic");
                    jpVar.getClass();
                    jpVar.q = jSONObject.optString("s");
                    jpVar.r = jSONObject.optString("lc");
                    jpVar.d = jSONObject.optInt("v");
                    jpVar.s = jSONObject.optString("gk");
                    jpVar.t = jSONObject.optString("gm");
                    jSONObject.optString("pn");
                    jpVar.getClass();
                    jSONObject.optString("ci");
                    jpVar.getClass();
                    jpVar.e = jSONObject.optInt("p");
                    jSONObject.optString(Constants.MessagePayloadKeys.RAW_DATA);
                    jpVar.getClass();
                    jpVar.w = jSONObject.optString("ap");
                    if (jSONObject2.has("cfg")) {
                        jpVar.l = jSONObject2.optInt("cfg");
                    } else {
                        jpVar.l = jSONObject.optInt("cfg");
                    }
                    jpVar.K = "fcm";
                    jpVar.getClass();
                    jpVar.q = jSONObject.optString("s");
                    jpVar.i = jSONObject.optInt("mn");
                    jpVar.H = jSONObject.optString("fbd");
                    jpVar.G = jSONObject.optString("fsd");
                    jpVar.I = jSONObject.optString("fbu");
                    C1104f8.b(C0835h.f4046a, str2, "gpl_payload");
                    String str6 = jpVar.f5532f;
                    if (str6 == null || str6.isEmpty()) {
                        C0828a.e(jpVar, C0828a.f(jpVar));
                        C1139gq c = C1139gq.c(C0835h.f4046a);
                        String str7 = str5;
                        if (!c.e(str7).equalsIgnoreCase(H.p())) {
                            c.h(str7, H.p());
                            str3 = str4;
                            x.j("Payload title is empty", jpVar.toString(), "NotificationEventManager", str3);
                            return;
                        }
                        return;
                    }
                    C0835h.j(C0835h.f4046a, jpVar);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("GPLURL", this.f4034a);
                    jSONObject3.put("PayloadData", jSONObject.toString());
                    this.a.h("iz_payload_data", jSONObject3.toString());
                } catch (Exception e) {
                    e = e;
                    str3 = str4;
                    C1104f8.b(C0835h.f4046a, e.toString(), "[Log.e]->globalPayload");
                    H.r(C0835h.f4046a, e.toString(), str3, "AdMediation");
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    /* renamed from: com.momagic.a$b */
    /* compiled from: AdMediation */
    public class b extends B.b {
        public final /* synthetic */ int a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ long f4037a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ C1203jp f4038a;

        public b(C1203jp jpVar, long j, int i, int i2) {
            this.f4038a = jpVar;
            this.f4037a = j;
            this.a = i2;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
            if (r9.g == 0) goto L_0x0023;
         */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0054 A[SYNTHETIC, Splitter:B:19:0x0054] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0084 A[Catch:{ Exception -> 0x008c }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r8, java.lang.String r9) {
            /*
                r7 = this;
                jp r9 = r7.f4038a
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x008c }
                r0.<init>()     // Catch:{ Exception -> 0x008c }
                java.lang.String r1 = "b"
                java.lang.String r2 = "-1"
                r0.put(r1, r2)     // Catch:{ Exception -> 0x008c }
                java.lang.String r1 = "a"
                java.lang.String r2 = r9.F     // Catch:{ Exception -> 0x008c }
                r0.put(r1, r2)     // Catch:{ Exception -> 0x008c }
                java.lang.String r1 = "rb"
                r2 = -1
                r0.put(r1, r2)     // Catch:{ Exception -> 0x008c }
                java.lang.String r1 = "t"
                if (r8 != r2) goto L_0x0023
                int r8 = r9.g     // Catch:{ Exception -> 0x008c }
                if (r8 != 0) goto L_0x0027
            L_0x0023:
                int r8 = r9.h     // Catch:{ Exception -> 0x008c }
                if (r8 == 0) goto L_0x002c
            L_0x0027:
                r8 = -2
                r0.put(r1, r8)     // Catch:{ Exception -> 0x008c }
                goto L_0x002f
            L_0x002c:
                r0.put(r1, r2)     // Catch:{ Exception -> 0x008c }
            L_0x002f:
                java.util.ArrayList r8 = com.momagic.C0828a.d     // Catch:{ Exception -> 0x008c }
                r8.add(r0)     // Catch:{ Exception -> 0x008c }
                int r0 = r8.size()     // Catch:{ Exception -> 0x008c }
                java.util.ArrayList r1 = com.momagic.C0828a.f4032a     // Catch:{ Exception -> 0x008c }
                int r2 = r1.size()     // Catch:{ Exception -> 0x008c }
                if (r0 != r2) goto L_0x004f
                java.util.ArrayList r0 = com.momagic.C0828a.f     // Catch:{ Exception -> 0x008c }
                int r0 = r0.size()     // Catch:{ Exception -> 0x008c }
                if (r0 != 0) goto L_0x004f
                java.lang.String r0 = com.momagic.C0828a.f(r9)     // Catch:{ Exception -> 0x008c }
                com.momagic.C0828a.e(r9, r0)     // Catch:{ Exception -> 0x008c }
            L_0x004f:
                r0 = 6
                int r2 = r7.a
                if (r2 != r0) goto L_0x0081
                java.util.ArrayList r0 = com.momagic.C0828a.f     // Catch:{ Exception -> 0x008c }
                int r3 = r0.size()     // Catch:{ Exception -> 0x008c }
                int r4 = r1.size()     // Catch:{ Exception -> 0x008c }
                r5 = 1
                int r4 = r4 - r5
                r6 = 0
                if (r3 != r4) goto L_0x006d
                int r3 = r8.size()     // Catch:{ Exception -> 0x008c }
                if (r3 != r5) goto L_0x006d
                com.momagic.C0828a.c(r9, r6, r2)     // Catch:{ Exception -> 0x008c }
                goto L_0x0081
            L_0x006d:
                int r8 = r8.size()     // Catch:{ Exception -> 0x008c }
                int r1 = r1.size()     // Catch:{ Exception -> 0x008c }
                int r1 = r1 - r5
                if (r8 != r1) goto L_0x0081
                int r8 = r0.size()     // Catch:{ Exception -> 0x008c }
                if (r8 != r5) goto L_0x0081
                com.momagic.C0828a.c(r9, r6, r2)     // Catch:{ Exception -> 0x008c }
            L_0x0081:
                r8 = 4
                if (r2 != r8) goto L_0x0098
                java.lang.String r8 = com.momagic.C0828a.f(r9)     // Catch:{ Exception -> 0x008c }
                com.momagic.C0828a.e(r9, r8)     // Catch:{ Exception -> 0x008c }
                goto L_0x0098
            L_0x008c:
                r8 = move-exception
                android.content.Context r9 = com.momagic.C0835h.f4046a
                java.lang.String r8 = r8.toString()
                java.lang.String r0 = "[Log.e]->Parse JSON"
                defpackage.C1104f8.b(r9, r8, r0)
            L_0x0098:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.momagic.C0828a.b.a(int, java.lang.String):void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:15|16|(1:18)|19|(2:21|(2:23|34)(2:24|36))(1:33)) */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            r0 = new org.json.JSONObject();
            r0.put("b", "-1");
            r0.put("a", r10.F);
            r0.put("t", r11 - r8);
            r0.put("rb", -1);
            r2 = com.momagic.C0828a.d;
            r2.add(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0099, code lost:
            if (r7 == 4) goto L_0x009b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x009b, code lost:
            com.momagic.C0828a.e(r10, com.momagic.C0828a.f(r10));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00af, code lost:
            if ((r2.size() - 1) == (com.momagic.C0828a.f4032a.size() - 1)) goto L_0x00b1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b7, code lost:
            if (com.momagic.C0828a.f.size() > 0) goto L_0x00b9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ba, code lost:
            com.momagic.C0828a.e(r10, com.momagic.C0828a.f(r10));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c2, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c3, code lost:
            defpackage.C1104f8.b(com.momagic.C0835h.f4046a, r0.toString(), "[Log.e]->Parse JSON");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x007e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void b(java.lang.String r17) {
            /*
                r16 = this;
                r1 = r16
                r0 = r17
                java.lang.String r2 = "rb"
                java.lang.String r3 = "t"
                java.lang.String r4 = "a"
                java.lang.String r5 = "-1"
                java.lang.String r6 = "b"
                int r7 = r1.a
                long r8 = r1.f4037a
                jp r10 = r1.f4038a
                if (r0 == 0) goto L_0x00ce
                long r11 = java.lang.System.currentTimeMillis()
                java.util.ArrayList r15 = com.momagic.C0828a.g     // Catch:{ JSONException -> 0x007e }
                r15.add(r0)     // Catch:{ JSONException -> 0x007e }
                org.json.JSONTokener r15 = new org.json.JSONTokener     // Catch:{ JSONException -> 0x007e }
                r15.<init>(r0)     // Catch:{ JSONException -> 0x007e }
                java.lang.Object r15 = r15.nextValue()     // Catch:{ JSONException -> 0x007e }
                if (r15 == 0) goto L_0x00ce
                boolean r13 = r15 instanceof org.json.JSONObject     // Catch:{ JSONException -> 0x007e }
                if (r13 == 0) goto L_0x003c
                org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007e }
                r13.<init>(r0)     // Catch:{ JSONException -> 0x007e }
                long r14 = r11 - r8
                r10.f5523a = r14     // Catch:{ JSONException -> 0x007e }
                com.momagic.C0828a.c(r10, r13, r7)     // Catch:{ JSONException -> 0x007e }
                goto L_0x00ce
            L_0x003c:
                boolean r13 = r15 instanceof org.json.JSONArray     // Catch:{ JSONException -> 0x007e }
                if (r13 == 0) goto L_0x0058
                org.json.JSONArray r13 = new org.json.JSONArray     // Catch:{ JSONException -> 0x007e }
                r13.<init>(r0)     // Catch:{ JSONException -> 0x007e }
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007e }
                r0.<init>()     // Catch:{ JSONException -> 0x007e }
                java.lang.String r14 = ""
                r0.put(r14, r13)     // Catch:{ JSONException -> 0x007e }
                long r13 = r11 - r8
                r10.f5523a = r13     // Catch:{ JSONException -> 0x007e }
                com.momagic.C0828a.c(r10, r0, r7)     // Catch:{ JSONException -> 0x007e }
                goto L_0x00ce
            L_0x0058:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007e }
                r0.<init>()     // Catch:{ JSONException -> 0x007e }
                r0.put(r6, r5)     // Catch:{ JSONException -> 0x007e }
                java.lang.String r13 = r10.F     // Catch:{ JSONException -> 0x007e }
                r0.put(r4, r13)     // Catch:{ JSONException -> 0x007e }
                long r13 = r11 - r8
                r0.put(r3, r13)     // Catch:{ JSONException -> 0x007e }
                r13 = -1
                r0.put(r2, r13)     // Catch:{ JSONException -> 0x007e }
                java.util.ArrayList r13 = com.momagic.C0828a.d     // Catch:{ JSONException -> 0x007e }
                r13.add(r0)     // Catch:{ JSONException -> 0x007e }
                r0 = 4
                if (r7 != r0) goto L_0x00ce
                java.lang.String r0 = com.momagic.C0828a.f(r10)     // Catch:{ JSONException -> 0x007e }
                com.momagic.C0828a.e(r10, r0)     // Catch:{ JSONException -> 0x007e }
                goto L_0x00ce
            L_0x007e:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00c2 }
                r0.<init>()     // Catch:{ Exception -> 0x00c2 }
                r0.put(r6, r5)     // Catch:{ Exception -> 0x00c2 }
                java.lang.String r5 = r10.F     // Catch:{ Exception -> 0x00c2 }
                r0.put(r4, r5)     // Catch:{ Exception -> 0x00c2 }
                long r11 = r11 - r8
                r0.put(r3, r11)     // Catch:{ Exception -> 0x00c2 }
                r3 = -1
                r0.put(r2, r3)     // Catch:{ Exception -> 0x00c2 }
                java.util.ArrayList r2 = com.momagic.C0828a.d     // Catch:{ Exception -> 0x00c2 }
                r2.add(r0)     // Catch:{ Exception -> 0x00c2 }
                r0 = 4
                if (r7 != r0) goto L_0x00a2
                java.lang.String r0 = com.momagic.C0828a.f(r10)     // Catch:{ Exception -> 0x00c2 }
                com.momagic.C0828a.e(r10, r0)     // Catch:{ Exception -> 0x00c2 }
            L_0x00a2:
                int r0 = r2.size()     // Catch:{ Exception -> 0x00c2 }
                r2 = -1
                int r0 = r0 + r2
                java.util.ArrayList r3 = com.momagic.C0828a.f4032a     // Catch:{ Exception -> 0x00c2 }
                int r3 = r3.size()     // Catch:{ Exception -> 0x00c2 }
                int r3 = r3 + r2
                if (r0 != r3) goto L_0x00ce
                java.util.ArrayList r0 = com.momagic.C0828a.f     // Catch:{ Exception -> 0x00c2 }
                int r0 = r0.size()     // Catch:{ Exception -> 0x00c2 }
                if (r0 <= 0) goto L_0x00ba
                goto L_0x00ce
            L_0x00ba:
                java.lang.String r0 = com.momagic.C0828a.f(r10)     // Catch:{ Exception -> 0x00c2 }
                com.momagic.C0828a.e(r10, r0)     // Catch:{ Exception -> 0x00c2 }
                goto L_0x00ce
            L_0x00c2:
                r0 = move-exception
                android.content.Context r2 = com.momagic.C0835h.f4046a
                java.lang.String r0 = r0.toString()
                java.lang.String r3 = "[Log.e]->Parse JSON"
                defpackage.C1104f8.b(r2, r0, r3)
            L_0x00ce:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.momagic.C0828a.b.b(java.lang.String):void");
        }
    }

    /* renamed from: com.momagic.a$c */
    /* compiled from: AdMediation */
    public class c extends B.b {
        public final /* synthetic */ C1203jp a;

        public c(C1203jp jpVar) {
            this.a = jpVar;
        }

        public final void a(int i, String str) {
            C1203jp jpVar = this.a;
            C0828a.e(jpVar, C0828a.f(jpVar));
        }

        public final void b(String str) {
            if (str != null) {
                try {
                    Object nextValue = new JSONTokener(str).nextValue();
                    if (nextValue != null) {
                        boolean z = nextValue instanceof JSONObject;
                        C1203jp jpVar = this.a;
                        if (z) {
                            C0828a.b(jpVar, new JSONObject(str));
                        } else if (nextValue instanceof JSONArray) {
                            JSONArray jSONArray = new JSONArray(str);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("", jSONArray);
                            C0828a.b(jpVar, jSONObject);
                        }
                    }
                } catch (JSONException e) {
                    C1139gq c = C1139gq.c(C0835h.f4046a);
                    if (!c.e("iz_AdMediation_EXCEPTION_AdType_11").equalsIgnoreCase(H.p())) {
                        c.h("iz_AdMediation_EXCEPTION_AdType_11", H.p());
                        H.w(C0835h.f4046a, e.toString(), "AdMediation", "finalAd_payload");
                    }
                }
            }
        }
    }

    public static void a(C1203jp jpVar) {
        if (C0835h.f4046a != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pid", C1139gq.c(C0835h.f4046a).b());
                jSONObject.put("rid", jpVar.f5530d);
                jSONObject.put("type", jpVar.E);
                jSONObject.put("ta", currentTimeMillis - jpVar.f5526b);
                jSONObject.put("av", "2.4.0");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("a", 0);
                jSONObject2.put("b", 0);
                jSONObject2.put("ln", jpVar.f5531e);
                jSONObject2.put("ti", jpVar.f5532f);
                long j = jpVar.f5523a;
                if (j == 0) {
                    jSONObject2.put("t", -1);
                } else {
                    jSONObject2.put("t", j);
                }
                jSONObject.put("served", jSONObject2);
                ArrayList arrayList = f;
                arrayList.addAll(d);
                jSONObject.put("bids", new JSONArray(arrayList));
                String replaceAll = jSONObject.toString().replaceAll("\\\\", " ");
                m(0, replaceAll);
                C1139gq c2 = C1139gq.c(C0835h.f4046a);
                if (Build.VERSION.SDK_INT >= 31) {
                    TargetActivity.r = replaceAll;
                    c2.h("MEDIATIONCLICKDATA", replaceAll);
                    return;
                }
                c2.h("MEDIATIONCLICKDATA", replaceAll);
                String str = NotificationActionReceiver.o;
            } catch (Exception e2) {
                C1104f8.b(C0835h.f4046a, e2.toString(), "[Log.e]->");
            }
        }
    }

    public static void b(C1203jp jpVar, JSONObject jSONObject) {
        String str;
        try {
            String str2 = jpVar.y;
            if (str2 != null) {
                if (!str2.isEmpty()) {
                    if (jpVar.y.startsWith("[")) {
                        JSONArray jSONArray = new JSONArray(jpVar.y);
                        for (int i = 0; i <= jSONArray.length() - 1; i++) {
                            String i2 = x.i(jSONArray.getString(i), jSONObject);
                            jpVar.y = i2;
                            g(i2);
                        }
                    } else {
                        String i3 = x.i(jpVar.y, jSONObject);
                        jpVar.y = i3;
                        g(i3);
                    }
                }
            }
            String str3 = jpVar.z;
            if (str3 != null && !str3.isEmpty()) {
                boolean startsWith = jpVar.z.startsWith("[");
                ArrayList arrayList = e;
                if (startsWith) {
                    JSONArray jSONArray2 = new JSONArray(jpVar.z);
                    for (int i4 = 0; i4 <= jSONArray2.length() - 1; i4++) {
                        String h = x.h(jSONArray2.getString(i4), jSONObject);
                        jpVar.z = h;
                        arrayList.add(h);
                    }
                } else {
                    String h2 = x.h(jpVar.z, jSONObject);
                    jpVar.z = h2;
                    arrayList.add(h2);
                }
            }
            String str4 = jpVar.f5532f;
            if (str4 == null || str4.equalsIgnoreCase("")) {
                e(jpVar, f(jpVar));
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("pid", C1139gq.c(C0835h.f4046a).b());
            jSONObject2.put("rid", jpVar.f5530d);
            jSONObject2.put("type", jpVar.E);
            jSONObject2.put("ta", currentTimeMillis - jpVar.f5526b);
            jSONObject2.put("av", "2.4.0");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("a", jpVar.F);
            jSONObject3.put("b", Double.parseDouble(jpVar.x));
            jSONObject3.put("t", jpVar.f5523a);
            jSONObject3.put("ln", jpVar.f5531e);
            jSONObject3.put("ti", jpVar.f5532f);
            String str5 = jpVar.D;
            if (!(str5 == null || str5.isEmpty() || (str = jpVar.D) == "")) {
                jSONObject3.put("rb", Double.parseDouble(str));
            }
            jSONObject2.put("served", jSONObject3);
            ArrayList arrayList2 = d;
            arrayList2.addAll(f);
            jSONObject2.put("bids", new JSONArray(arrayList2));
            String replaceAll = jSONObject2.toString().replaceAll("\\\\", " ");
            m(0, replaceAll);
            x.o(C0835h.f4046a, jpVar);
            C1139gq c2 = C1139gq.c(C0835h.f4046a);
            if (Build.VERSION.SDK_INT >= 31) {
                TargetActivity.r = replaceAll;
                c2.h("MEDIATIONCLICKDATA", replaceAll);
                return;
            }
            c2.h("MEDIATIONCLICKDATA", replaceAll);
            String str6 = NotificationActionReceiver.o;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void c(C1203jp jpVar, JSONObject jSONObject, int i) {
        Context context = C0835h.f4046a;
        if (context != null) {
            ArrayList arrayList = f4032a;
            if (jSONObject != null) {
                C1139gq c2 = C1139gq.c(context);
                String str = jpVar.f5532f;
                if (str != null && !str.isEmpty()) {
                    jpVar.f5532f = k(jpVar.f5532f, jSONObject);
                }
                if (jpVar.D.equalsIgnoreCase("-1")) {
                    jpVar.D = jpVar.D;
                } else {
                    jpVar.D = k(jpVar.D, jSONObject);
                }
                if (jpVar.f5532f == "") {
                    jpVar.x = "-1";
                    jpVar.D = "-1";
                } else {
                    jpVar.x = k(jpVar.x, jSONObject);
                    String str2 = jpVar.C;
                    if (str2 != "") {
                        jpVar.C = k(str2, jSONObject);
                        String k = k(jpVar.B, jSONObject);
                        jpVar.B = k;
                        if (!(k == "" || jpVar.C == "")) {
                            jpVar.x = String.valueOf(Float.valueOf(Float.valueOf(Float.parseFloat(k)).floatValue() / Float.valueOf(Float.valueOf(Float.parseFloat(jpVar.C)).floatValue() * 10.0f).floatValue()));
                        }
                    }
                }
                String str3 = jpVar.f5531e;
                if (str3 != null && !str3.isEmpty()) {
                    jpVar.f5531e = k(jpVar.f5531e, jSONObject);
                }
                if (!jpVar.f5531e.startsWith("http://")) {
                    if (!jpVar.f5531e.startsWith("https://")) {
                        String str4 = jpVar.f5531e;
                        jpVar.f5531e = "https://" + str4;
                    }
                }
                String str5 = jpVar.f5538l;
                if (str5 != null && !str5.isEmpty()) {
                    jpVar.f5538l = k(jpVar.f5538l, jSONObject);
                }
                String str6 = jpVar.f5534h;
                if (str6 != null && !str6.isEmpty()) {
                    jpVar.f5534h = k(jpVar.f5534h, jSONObject);
                }
                String str7 = jpVar.f5535i;
                if (str7 != null && !str7.isEmpty()) {
                    jpVar.f5535i = k(jpVar.f5535i, jSONObject);
                }
                String k2 = k(jpVar.n, jSONObject);
                jpVar.n = k2;
                if (jpVar.b == 1) {
                    if (k2 != null) {
                        jpVar.m = jpVar.m.replace("~", "");
                    }
                    if (!jpVar.n.startsWith("http://") && !jpVar.n.startsWith("https://")) {
                        String str8 = jpVar.n;
                        jpVar.n = "https://" + str8;
                    }
                    String str9 = jpVar.o;
                    if (str9 != null && !str9.isEmpty()) {
                        jpVar.o = jpVar.o.replace("~", "");
                    }
                    String replace = k(jpVar.p, jSONObject).replace("~", "");
                    jpVar.p = replace;
                    if (!replace.startsWith("http://") && !jpVar.p.startsWith("https://")) {
                        String str10 = jpVar.p;
                        jpVar.p = "https://" + str10;
                    }
                }
                String str11 = jpVar.f5535i;
                if (str11 != null && str11 != "" && !str11.startsWith("http://") && !jpVar.f5535i.startsWith("https://")) {
                    String str12 = jpVar.f5535i;
                    jpVar.f5535i = "https://" + str12;
                }
                String str13 = jpVar.f5538l;
                if (str13 != null && str13 != "" && !str13.startsWith("http://") && !jpVar.f5538l.startsWith("https://")) {
                    String str14 = jpVar.f5538l;
                    jpVar.f5538l = "https://" + str14;
                }
                if (jpVar.x == "" && jpVar.D == "") {
                    jpVar.x = "-1";
                    jpVar.D = "-1";
                }
                jpVar.w = "";
                jpVar.c = 0;
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("b", Double.parseDouble(jpVar.x));
                jSONObject2.put("a", jpVar.F);
                long j = jpVar.f5523a;
                if (j == 0) {
                    jSONObject2.put("t", -1);
                } else {
                    jSONObject2.put("t", j);
                }
                String str15 = jpVar.D;
                if (str15 != null && !str15.isEmpty()) {
                    jSONObject2.put("rb", Double.parseDouble(jpVar.D));
                }
                f.add(jSONObject2);
                if (i == 4) {
                    h(jpVar);
                }
                if (i == 5 && c2.a("Send")) {
                    String str16 = jpVar.f5532f;
                    if (str16 != null && !str16.equalsIgnoreCase("")) {
                        c2.f("Send", false);
                        h(jpVar);
                    } else if (d.size() > 0) {
                        e(jpVar, f(jpVar));
                    }
                }
                if (i == 6) {
                    b.add(jpVar);
                    if (a == arrayList.size()) {
                        p();
                    }
                }
            } else if (i == 6) {
                try {
                    if (a == arrayList.size()) {
                        p();
                    }
                } catch (Exception e2) {
                    C1139gq c3 = C1139gq.c(C0835h.f4046a);
                    if (!c3.e("iz_AdMediation_EXCEPTION_AdType_9").equalsIgnoreCase(H.p())) {
                        c3.h("iz_AdMediation_EXCEPTION_AdType_9", H.p());
                        H.w(C0835h.f4046a, e2.toString(), "AdMediation", "getAdNotificationData");
                    }
                }
            }
        }
    }

    public static void d(C1203jp jpVar) {
        Context context = C0835h.f4046a;
        if (context != null) {
            try {
                C1139gq c2 = C1139gq.c(context);
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pid", c2.b());
                jSONObject.put("rid", jpVar.f5530d);
                jSONObject.put("type", jpVar.E);
                jSONObject.put("ta", currentTimeMillis - jpVar.f5526b);
                jSONObject.put("av", "2.4.0");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("a", 0);
                jSONObject2.put("b", 0);
                jSONObject2.put("ln", jpVar.f5531e);
                jSONObject2.put("ti", jpVar.f5532f);
                long j = jpVar.f5523a;
                if (j == 0) {
                    jSONObject2.put("t", -1);
                } else {
                    jSONObject2.put("t", j);
                }
                jSONObject.put("served", jSONObject2);
                ArrayList arrayList = f;
                arrayList.addAll(d);
                jSONObject.put("bids", new JSONArray(arrayList));
                String replaceAll = jSONObject.toString().replaceAll("\\\\", " ");
                m(0, replaceAll);
                String str = NotificationActionReceiver.o;
                TargetActivity.r = replaceAll;
            } catch (Exception e2) {
                C1139gq c3 = C1139gq.c(C0835h.f4046a);
                if (!c3.e("iz_AdMediation_EXCEPTION_AdType_14").equalsIgnoreCase(H.p())) {
                    c3.h("iz_AdMediation_EXCEPTION_AdType_14", H.p());
                    Context context2 = C0835h.f4046a;
                    H.r(context2, "PayloadError" + e2 + jpVar.f5530d, "AdMediation", "ShowClickAndImpressionData");
                }
            }
        }
    }

    public static void e(C1203jp jpVar, String str) {
        B.a(new C0830c(jpVar), str);
    }

    public static String f(C1203jp jpVar) {
        String str;
        try {
            if (jpVar.G != "") {
                str = jpVar.G + ".izooto.com";
            } else {
                str = jpVar.H;
                if (str == "") {
                    str = "flbk.izooto.com";
                }
            }
            String str2 = "default.json";
            String str3 = jpVar.I;
            if (str3 != "") {
                str2 = str3;
            }
            return "https://" + str + RemoteSettings.FORWARD_SLASH_STRING + str2;
        } catch (Exception e2) {
            H.w(C0835h.f4046a, e2.toString(), "Fallback", "callFallbackAPI");
            return "";
        }
    }

    public static void g(String str) {
        if (!str.isEmpty()) {
            B.a(new d(), str);
        }
    }

    public static void h(C1203jp jpVar) {
        if (C0835h.f4046a != null) {
            B.a(new c(jpVar), x.c(jpVar.f5525a));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x03e8, code lost:
        r1 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x03fa, code lost:
        if (defpackage.C1139gq.c(r27).e(r1).equalsIgnoreCase(com.momagic.H.p()) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x03fc, code lost:
        r19.h(r1, com.momagic.H.p());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x041c, code lost:
        r3 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        com.momagic.x.j("Payload Error" + r15.optString("t"), (java.lang.String) null, r3, "getAdJsonData()");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x049f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void i(android.content.Context r27, org.json.JSONObject r28, java.lang.String r29, java.lang.String r30) {
        /*
            r1 = r27
            r0 = r28
            r2 = r30
            java.lang.String r3 = "currentDateViewDaily"
            java.lang.String r4 = "to"
            java.lang.String r5 = "ri"
            java.lang.String r6 = "Send"
            java.lang.String r7 = "ct"
            java.lang.String r8 = "AdMediation"
            java.lang.String r9 = "b"
            java.lang.String r10 = "id"
            java.lang.String r11 = "']"
            java.lang.String r12 = "['"
            java.lang.String r13 = ""
            if (r1 == 0) goto L_0x04c3
            r14 = 0
            a = r14     // Catch:{ Exception -> 0x04a1 }
            gq r15 = defpackage.C1139gq.c(r27)     // Catch:{ Exception -> 0x04a1 }
            java.util.ArrayList r14 = f4032a
            r14.clear()     // Catch:{ Exception -> 0x04a1 }
            java.util.ArrayList r1 = c
            r1.clear()     // Catch:{ Exception -> 0x04a1 }
            java.util.ArrayList r16 = b     // Catch:{ Exception -> 0x04a1 }
            r16.clear()     // Catch:{ Exception -> 0x04a1 }
            java.util.ArrayList r16 = e     // Catch:{ Exception -> 0x04a1 }
            r16.clear()     // Catch:{ Exception -> 0x04a1 }
            java.util.ArrayList r16 = f     // Catch:{ Exception -> 0x04a1 }
            r16.clear()     // Catch:{ Exception -> 0x04a1 }
            java.util.ArrayList r16 = d     // Catch:{ Exception -> 0x04a1 }
            r16.clear()     // Catch:{ Exception -> 0x04a1 }
            java.util.ArrayList r16 = g     // Catch:{ Exception -> 0x04a1 }
            r16.clear()     // Catch:{ Exception -> 0x04a1 }
            if (r2 == 0) goto L_0x0058
            boolean r16 = r30.isEmpty()     // Catch:{ Exception -> 0x04a1 }
            if (r16 != 0) goto L_0x0058
            r16 = r6
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x04a1 }
            r6.<init>(r2)     // Catch:{ Exception -> 0x04a1 }
            goto L_0x0060
        L_0x0058:
            r16 = r6
            java.lang.String r2 = "g"
            org.json.JSONObject r6 = r0.getJSONObject(r2)     // Catch:{ Exception -> 0x04a1 }
        L_0x0060:
            java.lang.String r2 = "an"
            org.json.JSONArray r0 = r0.getJSONArray(r2)     // Catch:{ Exception -> 0x04a1 }
            r17 = r3
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x04a1 }
            int r18 = r0.length()     // Catch:{ Exception -> 0x04a1 }
            if (r18 <= 0) goto L_0x04c3
            r18 = r8
            r19 = r15
            r8 = 0
        L_0x0077:
            int r15 = r0.length()     // Catch:{ Exception -> 0x0423 }
            r20 = r14
            java.lang.String r14 = "6"
            r21 = r1
            java.lang.String r1 = "tp"
            if (r8 >= r15) goto L_0x0428
            org.json.JSONObject r15 = r0.getJSONObject(r8)     // Catch:{ Exception -> 0x0423 }
            long r22 = r6.optLong(r7)     // Catch:{ Exception -> 0x0423 }
            r28 = r0
            gq r0 = defpackage.C1139gq.c(r27)     // Catch:{ Exception -> 0x0423 }
            android.content.SharedPreferences r0 = r0.f5471a     // Catch:{ Exception -> 0x0423 }
            r30 = r8
            java.lang.String r8 = "deviceRegistrationTimeStamp"
            boolean r24 = r0.contains(r8)     // Catch:{ Exception -> 0x0423 }
            r25 = r4
            r26 = r5
            r4 = 0
            if (r24 == 0) goto L_0x00a9
            long r4 = r0.getLong(r8, r4)     // Catch:{ Exception -> 0x0423 }
        L_0x00a9:
            int r0 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            java.lang.String r4 = "t"
            if (r0 <= 0) goto L_0x03e8
            jp r0 = new jp     // Catch:{ Exception -> 0x0423 }
            r0.<init>()     // Catch:{ Exception -> 0x0423 }
            f4033a = r0     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r6.optString(r1)     // Catch:{ Exception -> 0x0423 }
            r0.E = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r15.optString(r10)     // Catch:{ Exception -> 0x0423 }
            r0.F = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "rb"
            java.lang.String r5 = r15.optString(r5)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.D = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "fu"
            java.lang.String r5 = r15.optString(r5)     // Catch:{ Exception -> 0x0423 }
            r0.f5525a = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "k"
            java.lang.String r5 = r6.optString(r5)     // Catch:{ Exception -> 0x0423 }
            r0.f5528b = r5     // Catch:{ Exception -> 0x0423 }
            boolean r0 = r6.has(r10)     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x0101
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r6.optString(r10)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.f5529c = r5     // Catch:{ Exception -> 0x0423 }
            goto L_0x0111
        L_0x0101:
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r15.optString(r10)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.f5529c = r5     // Catch:{ Exception -> 0x0423 }
        L_0x0111:
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            r0.f5526b = r2     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "r"
            java.lang.String r5 = r6.optString(r5)     // Catch:{ Exception -> 0x0423 }
            r0.f5530d = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "ln"
            java.lang.String r5 = r15.optString(r5)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.f5531e = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r4 = r15.optString(r4)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r4 = r4.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r4 = r4.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.f5532f = r4     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r4 = "m"
            java.lang.String r4 = r15.optString(r4)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r4 = r4.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r4 = r4.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.f5534h = r4     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r4 = "i"
            java.lang.String r4 = r15.optString(r4)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r4 = r4.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r4 = r4.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.f5535i = r4     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            r4 = r26
            r15.optInt(r4)     // Catch:{ Exception -> 0x0423 }
            r0.getClass()     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "tg"
            java.lang.String r5 = r15.optString(r5)     // Catch:{ Exception -> 0x0423 }
            r0.f5537k = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "bi"
            java.lang.String r5 = r15.optString(r5)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.f5538l = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "bic"
            java.lang.String r5 = r15.optString(r5)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            r5.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.getClass()     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "bc"
            java.lang.String r5 = r15.optString(r5)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.f5536j = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "st"
            java.lang.String r5 = r15.optString(r5)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r5.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.f5533g = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "gp"
            int r5 = r15.optInt(r5)     // Catch:{ Exception -> 0x0423 }
            r0.a = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "bct"
            int r5 = r15.optInt(r5)     // Catch:{ Exception -> 0x0423 }
            r0.f = r5     // Catch:{ Exception -> 0x0423 }
            boolean r0 = r6.has(r9)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "b2"
            java.lang.String r8 = "b1"
            if (r0 == 0) goto L_0x0208
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            r22 = r2
            int r2 = r6.optInt(r9)     // Catch:{ Exception -> 0x0423 }
            r0.b = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r6.optString(r8)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.m = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r6.optString(r5)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.o = r2     // Catch:{ Exception -> 0x0423 }
            goto L_0x0232
        L_0x0208:
            r22 = r2
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            int r2 = r6.optInt(r9)     // Catch:{ Exception -> 0x0423 }
            r0.b = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r15.optString(r8)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.m = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r15.optString(r5)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.o = r2     // Catch:{ Exception -> 0x0423 }
        L_0x0232:
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "l1"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.n = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "ib1"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            r2.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.getClass()     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "d1"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.u = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "l2"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.p = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "ib2"
            r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.getClass()     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "d2"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.v = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "ia"
            int r2 = r15.optInt(r2)     // Catch:{ Exception -> 0x0423 }
            r0.c = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "ti"
            r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.getClass()     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "ic"
            r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.getClass()     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "s"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.q = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "lc"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.r = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "v"
            int r2 = r15.optInt(r2)     // Catch:{ Exception -> 0x0423 }
            r0.d = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "gk"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.s = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "gm"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.t = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "pn"
            r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.getClass()     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "ci"
            r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.getClass()     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "p"
            int r2 = r15.optInt(r2)     // Catch:{ Exception -> 0x0423 }
            r0.e = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "rawData"
            r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.getClass()     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "ap"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.w = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "cfg"
            int r2 = r6.optInt(r2)     // Catch:{ Exception -> 0x0423 }
            r0.l = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "cpc"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.x = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "rc"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.z = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "rv"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.y = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "pf"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.A = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "cpm"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.B = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "ctr"
            java.lang.String r2 = r15.optString(r2)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r12, r13)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = r2.replace(r11, r13)     // Catch:{ Exception -> 0x0423 }
            r0.C = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "fbd"
            java.lang.String r2 = r6.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.H = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "fsd"
            java.lang.String r2 = r6.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.G = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = "fbu"
            java.lang.String r2 = r6.optString(r2)     // Catch:{ Exception -> 0x0423 }
            r0.I = r2     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            r2 = r25
            int r3 = r6.optInt(r2)     // Catch:{ Exception -> 0x0423 }
            r0.g = r3     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            int r3 = r15.optInt(r2)     // Catch:{ Exception -> 0x0423 }
            r0.h = r3     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r3 = r6.optString(r7)     // Catch:{ Exception -> 0x0423 }
            r0.J = r3     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            r3 = r29
            r0.K = r3     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "nt"
            int r5 = r6.optInt(r5)     // Catch:{ Exception -> 0x0423 }
            r0.j = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = r6.optString(r4)     // Catch:{ Exception -> 0x0423 }
            r0.M = r5     // Catch:{ Exception -> 0x0423 }
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            java.lang.String r0 = r0.A     // Catch:{ Exception -> 0x0423 }
            java.lang.String r5 = "1"
            boolean r0 = r0.equalsIgnoreCase(r5)     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x03d4
            java.lang.String r0 = r6.optString(r1)     // Catch:{ Exception -> 0x0423 }
            boolean r0 = r0.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x0423 }
            if (r0 == 0) goto L_0x03d4
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            r1 = r21
            r1.add(r0)     // Catch:{ Exception -> 0x0423 }
            r5 = r20
            goto L_0x03dd
        L_0x03d4:
            r1 = r21
            jp r0 = f4033a     // Catch:{ Exception -> 0x0423 }
            r5 = r20
            r5.add(r0)     // Catch:{ Exception -> 0x0423 }
        L_0x03dd:
            int r8 = r30 + 1
            r0 = r28
            r14 = r5
            r5 = r4
            r4 = r2
            r2 = r22
            goto L_0x0077
        L_0x03e8:
            gq r0 = defpackage.C1139gq.c(r27)     // Catch:{ Exception -> 0x0423 }
            r1 = r17
            java.lang.String r0 = r0.e(r1)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r2 = com.momagic.H.p()     // Catch:{ Exception -> 0x0423 }
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ Exception -> 0x0423 }
            if (r0 != 0) goto L_0x0422
            java.lang.String r0 = com.momagic.H.p()     // Catch:{ Exception -> 0x0423 }
            r2 = r19
            r2.h(r1, r0)     // Catch:{ Exception -> 0x0423 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0423 }
            r0.<init>()     // Catch:{ Exception -> 0x0423 }
            java.lang.String r1 = "Payload Error"
            r0.append(r1)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r1 = r15.optString(r4)     // Catch:{ Exception -> 0x0423 }
            r0.append(r1)     // Catch:{ Exception -> 0x0423 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0423 }
            java.lang.String r1 = "getAdJsonData()"
            r2 = 0
            r3 = r18
            com.momagic.x.j(r0, r2, r3, r1)     // Catch:{ Exception -> 0x049f }
        L_0x0422:
            return
        L_0x0423:
            r0 = move-exception
            r3 = r18
            goto L_0x04a3
        L_0x0428:
            r3 = r18
            r2 = r19
            r5 = r20
            int r0 = r5.size()     // Catch:{ Exception -> 0x049f }
            if (r0 <= 0) goto L_0x04c3
            java.lang.String r0 = r6.optString(r1)     // Catch:{ Exception -> 0x049f }
            java.lang.String r4 = "4"
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x049f }
            if (r0 == 0) goto L_0x044c
            r0 = 0
            java.lang.Object r4 = r5.get(r0)     // Catch:{ Exception -> 0x049f }
            jp r4 = (defpackage.C1203jp) r4     // Catch:{ Exception -> 0x049f }
            r7 = 4
            o(r4, r7, r0)     // Catch:{ Exception -> 0x049f }
            goto L_0x044d
        L_0x044c:
            r0 = 0
        L_0x044d:
            java.lang.String r4 = r6.optString(r1)     // Catch:{ Exception -> 0x049f }
            java.lang.String r7 = "5"
            boolean r4 = r4.equalsIgnoreCase(r7)     // Catch:{ Exception -> 0x049f }
            r7 = 2000(0x7d0, double:9.88E-321)
            if (r4 == 0) goto L_0x047e
            r4 = 1
            r9 = r16
            r2.f(r9, r4)     // Catch:{ Exception -> 0x049f }
            r4 = r0
        L_0x0462:
            int r10 = r5.size()     // Catch:{ Exception -> 0x049f }
            if (r4 >= r10) goto L_0x047e
            boolean r10 = r2.a(r9)     // Catch:{ Exception -> 0x049f }
            if (r10 == 0) goto L_0x047b
            java.lang.Object r10 = r5.get(r4)     // Catch:{ Exception -> 0x049f }
            jp r10 = (defpackage.C1203jp) r10     // Catch:{ Exception -> 0x049f }
            r11 = 5
            o(r10, r11, r4)     // Catch:{ Exception -> 0x049f }
            java.lang.Thread.sleep(r7)     // Catch:{ Exception -> 0x049f }
        L_0x047b:
            int r4 = r4 + 1
            goto L_0x0462
        L_0x047e:
            java.lang.String r1 = r6.optString(r1)     // Catch:{ Exception -> 0x049f }
            boolean r1 = r1.equalsIgnoreCase(r14)     // Catch:{ Exception -> 0x049f }
            if (r1 == 0) goto L_0x04c3
            r14 = r0
        L_0x0489:
            java.lang.Object r0 = r5.get(r14)     // Catch:{ Exception -> 0x049f }
            jp r0 = (defpackage.C1203jp) r0     // Catch:{ Exception -> 0x049f }
            r1 = 6
            o(r0, r1, r14)     // Catch:{ Exception -> 0x049f }
            java.lang.Thread.sleep(r7)     // Catch:{ Exception -> 0x049f }
            int r14 = r14 + 1
            int r0 = r5.size()     // Catch:{ Exception -> 0x049f }
            if (r14 < r0) goto L_0x0489
            goto L_0x04c3
        L_0x049f:
            r0 = move-exception
            goto L_0x04a3
        L_0x04a1:
            r0 = move-exception
            r3 = r8
        L_0x04a3:
            android.content.Context r1 = com.momagic.C0835h.f4046a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "JSONException"
            r2.<init>(r4)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "[Log.e]->AdMediation"
            defpackage.C1104f8.b(r1, r2, r4)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "getJSONData"
            r2 = r27
            com.momagic.H.r(r2, r0, r3, r1)
        L_0x04c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.momagic.C0828a.i(android.content.Context, org.json.JSONObject, java.lang.String, java.lang.String):void");
    }

    public static void j(Context context, JSONObject jSONObject, String str) {
        if (context != null) {
            try {
                if (!str.isEmpty()) {
                    long optLong = jSONObject.optLong("ct");
                    SharedPreferences sharedPreferences = C1139gq.c(context).f5471a;
                    long j = 0;
                    if (sharedPreferences.contains("deviceRegistrationTimeStamp")) {
                        j = sharedPreferences.getLong("deviceRegistrationTimeStamp", 0);
                    }
                    if (optLong > j) {
                        C1203jp jpVar = new C1203jp();
                        f4033a = jpVar;
                        l(str, jpVar, jSONObject);
                    } else if (!C1139gq.c(context).e("currentDateViewDaily").equalsIgnoreCase(H.p())) {
                        C1139gq.c(context).h("currentDateViewDaily", H.p());
                        x.j("Payload Error" + jSONObject.optString("t"), (String) null, "AdMediation", "GPL()");
                    }
                } else {
                    C1139gq c2 = C1139gq.c(context);
                    if (!c2.e("iz_GPL_FIRST_TIME").equalsIgnoreCase(H.p())) {
                        c2.h("iz_GPL_FIRST_TIME", H.p());
                        x.j("Payload Error" + jSONObject.optString("t"), (String) null, "AdMediation", "GPL()");
                    }
                }
            } catch (Exception e2) {
                C1139gq c3 = C1139gq.c(context);
                if (!c3.e("iz_GPL_EXCEPTION").equalsIgnoreCase(H.p())) {
                    c3.h("iz_GPL_EXCEPTION", H.p());
                    H.w(context, e2.toString(), "AdMediation", "getMediationGPL");
                }
            }
        }
    }

    public static String k(String str, JSONObject jSONObject) {
        try {
            if (str.matches("[0-9]{1,13}(\\.[0-9]*)?")) {
                return str;
            }
            if (str.startsWith("~")) {
                return str.replace("~", "");
            }
            if (!str.contains(".")) {
                return jSONObject.optString(str);
            }
            String[] split = str.split("\\.");
            if (split.length != 2) {
                if (split.length != 3) {
                    if (split.length == 4) {
                        if (split[2].contains("[")) {
                            String[] split2 = split[2].split("\\[");
                            return jSONObject.getJSONObject(split[0]).getJSONObject(split[1]).getJSONArray(split2[0]).getJSONObject(Integer.parseInt(split2[1].replace("]", ""))).optString(split[3]);
                        }
                    } else if (split.length != 5) {
                        jSONObject.optString(str);
                    } else if (split[2].contains("[")) {
                        String[] split3 = split[2].split("\\[");
                        return jSONObject.getJSONObject(split[0]).getJSONObject(split[1]).getJSONArray(split3[0]).getJSONObject(Integer.parseInt(split3[1].replace("]", ""))).getJSONObject(split[3]).optString(split[4]);
                    }
                    return "";
                }
            }
            JSONObject jSONObject2 = null;
            int i = 0;
            while (i < split.length) {
                if (split[i].contains("[")) {
                    String[] split4 = split[i].split("\\[");
                    if (jSONObject2 == null) {
                        jSONObject2 = jSONObject.getJSONArray(split4[0]).getJSONObject(Integer.parseInt(split4[1].replace("]", "")));
                    } else {
                        jSONObject2 = jSONObject2.getJSONArray(split4[0]).getJSONObject(Integer.parseInt(split4[1].replace("]", "")));
                    }
                    i++;
                } else {
                    Objects.requireNonNull(jSONObject2);
                    return jSONObject2.optString(split[i]);
                }
            }
            return "";
        } catch (Exception e2) {
            C1104f8.b(C0835h.f4046a, "getParsedValue" + e2, "[Log.e]->AdMediation");
        }
    }

    public static void l(String str, C1203jp jpVar, JSONObject jSONObject) {
        String str2;
        String str3;
        String str4 = str;
        C1203jp jpVar2 = jpVar;
        JSONObject jSONObject2 = jSONObject;
        Context context = C0835h.f4046a;
        if (context != null) {
            C1139gq c2 = C1139gq.c(context);
            String str5 = "cfg";
            if (c2.e("iz_payload_data") != null) {
                str2 = "s";
                try {
                    str3 = new JSONObject(c2.e("iz_payload_data")).optString("GPLURL");
                } catch (Exception unused) {
                    str3 = "";
                }
                if (!str4.equalsIgnoreCase(str3)) {
                    B.a(new C0052a(jpVar2, jSONObject2, str4, c2), str4);
                    return;
                }
            } else {
                str2 = "s";
            }
            String e2 = c2.e("iz_payload_data");
            try {
                if (!e2.isEmpty()) {
                    JSONObject jSONObject3 = new JSONObject(new JSONObject(e2).optString("PayloadData").replace("\n", ""));
                    jpVar2.J = jSONObject2.optString("ct");
                    if (jSONObject2.has("ct")) {
                        jpVar2.J = jSONObject2.optString("ct");
                    } else {
                        jpVar2.J = jSONObject3.optString("ct");
                    }
                    if (jSONObject2.has("k")) {
                        jpVar2.f5528b = jSONObject2.optString("k");
                    } else {
                        jpVar2.f5528b = jSONObject3.optString("k");
                    }
                    if (jSONObject2.has(FacebookMediationAdapter.KEY_ID)) {
                        jpVar2.f5529c = jSONObject2.optString(FacebookMediationAdapter.KEY_ID);
                    } else {
                        jpVar2.f5529c = jSONObject3.optString(FacebookMediationAdapter.KEY_ID);
                    }
                    if (jSONObject2.has("r")) {
                        jpVar2.f5530d = jSONObject2.optString("r");
                    } else {
                        jpVar2.f5530d = jSONObject3.optString("r");
                    }
                    jpVar2.f5525a = jSONObject3.optString("fu");
                    jpVar2.f5531e = jSONObject3.optString("ln");
                    jpVar2.f5532f = jSONObject3.optString("t");
                    jpVar2.f5534h = jSONObject3.optString("m");
                    jpVar2.f5535i = jSONObject3.optString("i");
                    if (jSONObject2.has("ri")) {
                        jSONObject2.optInt("ri");
                    } else {
                        jSONObject3.optInt("ri");
                    }
                    if (jSONObject2.has("tg")) {
                        jpVar2.f5537k = jSONObject2.optString("tg");
                    } else {
                        jpVar2.f5537k = jSONObject3.optString("tg");
                    }
                    if (jSONObject2.has("b1")) {
                        jpVar2.m = jSONObject2.optString("b1");
                    } else {
                        jpVar2.m = jSONObject3.optString("b1");
                    }
                    if (jSONObject2.has("l1")) {
                        jpVar2.n = jSONObject2.optString("l1");
                    } else {
                        jpVar2.n = jSONObject3.optString("l1");
                    }
                    jpVar2.f5538l = jSONObject3.optString("bi");
                    jpVar2.b = jSONObject3.optInt("b");
                    jSONObject3.optString("bic");
                    jpVar2.f5536j = jSONObject3.optString("bc");
                    jpVar2.f5533g = jSONObject3.optString("st");
                    jpVar2.a = jSONObject3.optInt("gp");
                    jpVar2.f = jSONObject3.optInt("bct");
                    jSONObject3.optString("ib1");
                    jpVar2.u = jSONObject3.optString("d1");
                    jpVar2.o = jSONObject3.optString("b2");
                    jpVar2.p = jSONObject3.optString("l2");
                    jSONObject3.optString("ib2");
                    jpVar2.v = jSONObject3.optString("d2");
                    jpVar2.c = jSONObject3.optInt("ia");
                    jSONObject3.optString("ti");
                    jSONObject3.optString("ic");
                    String str6 = str2;
                    jpVar2.q = jSONObject3.optString(str6);
                    jpVar2.r = jSONObject3.optString("lc");
                    jpVar2.d = jSONObject3.optInt("v");
                    jpVar2.s = jSONObject3.optString("gk");
                    jpVar2.t = jSONObject3.optString("gm");
                    jSONObject3.optString("pn");
                    jSONObject3.optString("ci");
                    jpVar2.e = jSONObject3.optInt("p");
                    jSONObject3.optString(Constants.MessagePayloadKeys.RAW_DATA);
                    jpVar2.w = jSONObject3.optString("ap");
                    String str7 = str5;
                    if (jSONObject2.has(str7)) {
                        jpVar2.l = jSONObject2.optInt(str7);
                    } else {
                        jpVar2.l = jSONObject3.optInt(str7);
                    }
                    jpVar2.K = "fcm";
                    jpVar2.q = jSONObject3.optString(str6);
                    jpVar2.i = jSONObject3.optInt("mn");
                    jpVar2.H = jSONObject3.optString("fbd");
                    jpVar2.G = jSONObject3.optString("fsd");
                    jpVar2.I = jSONObject3.optString("fbu");
                    String str8 = jpVar2.f5532f;
                    if (str8 == null || str8.isEmpty()) {
                        e(jpVar2, f(jpVar));
                    } else {
                        C0835h.j(C0835h.f4046a, jpVar2);
                    }
                }
            } catch (Exception unused2) {
                e(jpVar2, f(jpVar));
            }
        }
    }

    public static void m(int i, String str) {
        if (C0835h.f4046a != null) {
            try {
                if (f.size() > 0) {
                    C1104f8.b(C0835h.f4046a, g.toString(), "successResponseMediation");
                }
                C1104f8.b(C0835h.f4046a, str, "mediation_impression");
                JSONObject jSONObject = new JSONObject(str);
                B.c("https://med.dtblt.com/medi", (HashMap) null, jSONObject, new C0831d(i, jSONObject));
            } catch (Exception e2) {
                C1139gq c2 = C1139gq.c(C0835h.f4046a);
                if (!c2.e("iz_AdMediation_EXCEPTION_AdType_15").equalsIgnoreCase(H.p())) {
                    c2.h("iz_AdMediation_EXCEPTION_AdType_15", H.p());
                    Context context = C0835h.f4046a;
                    H.w(context, e2 + str, "AdMediation", "mediationImpression");
                }
            }
        }
    }

    public static void n(C1203jp jpVar, JSONObject jSONObject) {
        String str;
        if (C0835h.f4046a != null) {
            try {
                String str2 = jpVar.f5532f;
                if (str2 != null && !str2.isEmpty()) {
                    jpVar.f5532f = k(jpVar.f5532f, jSONObject);
                }
                String str3 = jpVar.f5534h;
                if (str3 != null && !str3.isEmpty()) {
                    jpVar.f5534h = k(jpVar.f5534h, jSONObject);
                }
                jpVar.f5531e = k(jpVar.f5531e, jSONObject);
                jpVar.x = k(jpVar.x, jSONObject);
                jpVar.D = k(jpVar.D, jSONObject);
                if (!jpVar.f5531e.startsWith("http://")) {
                    if (!jpVar.f5531e.startsWith("https://")) {
                        jpVar.f5531e = "https://" + jpVar.f5531e;
                    }
                }
                String str4 = jpVar.f5538l;
                if (str4 != null && !str4.isEmpty()) {
                    jpVar.f5538l = k(jpVar.f5538l, jSONObject);
                }
                String str5 = jpVar.f5535i;
                if (str5 != null && !str5.isEmpty()) {
                    jpVar.f5535i = k(jpVar.f5535i, jSONObject);
                }
                jpVar.n = k(jpVar.n, jSONObject);
                jpVar.C = k(jpVar.C, jSONObject);
                jpVar.B = k(jpVar.B, jSONObject);
                jpVar.D = k(jpVar.D, jSONObject);
                if (jpVar.b == 1) {
                    if (jpVar.n != null) {
                        jpVar.m = jpVar.m.replace("~", "");
                    }
                    if (!jpVar.n.startsWith("http://") && !jpVar.n.startsWith("https://")) {
                        jpVar.n = "https://" + jpVar.n;
                    }
                    String str6 = jpVar.o;
                    if (str6 != null && !str6.isEmpty()) {
                        jpVar.o = jpVar.o.replace("~", "");
                    }
                    String replace = k(jpVar.p, jSONObject).replace("~", "");
                    jpVar.p = replace;
                    if (!replace.startsWith("http://") && !jpVar.p.startsWith("https://")) {
                        jpVar.p = "https://" + jpVar.p;
                    }
                }
                String str7 = jpVar.f5535i;
                if (str7 != null && str7 != "" && !str7.startsWith("http://") && !jpVar.f5535i.startsWith("https://")) {
                    jpVar.f5535i = "https://" + jpVar.f5535i;
                }
                String str8 = jpVar.f5538l;
                if (str8 != null && str8 != "" && !str8.startsWith("http://") && !jpVar.f5538l.startsWith("https://")) {
                    jpVar.f5538l = "https://" + jpVar.f5538l;
                }
                String str9 = jpVar.y;
                if (str9 != null) {
                    if (!str9.isEmpty()) {
                        if (jpVar.y.startsWith("[")) {
                            JSONArray jSONArray = new JSONArray(jpVar.y);
                            for (int i = 0; i <= jSONArray.length() - 1; i++) {
                                String i2 = x.i(jSONArray.getString(i), jSONObject);
                                jpVar.y = i2;
                                g(i2);
                            }
                        } else {
                            String i3 = x.i(jpVar.y, jSONObject);
                            jpVar.y = i3;
                            g(i3);
                        }
                    }
                }
                String str10 = jpVar.z;
                if (str10 != null && !str10.isEmpty()) {
                    boolean startsWith = jpVar.z.startsWith("[");
                    ArrayList arrayList = e;
                    if (startsWith) {
                        JSONArray jSONArray2 = new JSONArray(jpVar.z);
                        for (int i4 = 0; i4 <= jSONArray2.length() - 1; i4++) {
                            String h = x.h(jSONArray2.getString(i4), jSONObject);
                            jpVar.z = h;
                            arrayList.add(h);
                        }
                    } else {
                        String h2 = x.h(jpVar.z, jSONObject);
                        jpVar.z = h2;
                        arrayList.add(h2);
                    }
                }
                ArrayList arrayList2 = f;
                if (arrayList2.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("pid", C1139gq.c(C0835h.f4046a).b());
                    jSONObject2.put("rid", jpVar.f5530d);
                    jSONObject2.put("type", jpVar.E);
                    jSONObject2.put("ta", currentTimeMillis - jpVar.f5526b);
                    jSONObject2.put("av", "2.4.0");
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("a", jpVar.F);
                    jSONObject3.put("b", Double.parseDouble(jpVar.x));
                    jSONObject3.put("t", jpVar.f5523a);
                    jSONObject3.put("ln", jpVar.f5531e);
                    jSONObject3.put("ti", jpVar.f5532f);
                    String str11 = jpVar.D;
                    if (!(str11 == null || str11.isEmpty() || (str = jpVar.D) == "")) {
                        jSONObject3.put("rb", Double.parseDouble(str));
                    }
                    jSONObject2.put("served", jSONObject3);
                    arrayList2.addAll(d);
                    jSONObject2.put("bids", new JSONArray(arrayList2));
                    String replaceAll = jSONObject2.toString().replaceAll("\\\\", " ");
                    m(0, replaceAll);
                    C1139gq c2 = C1139gq.c(C0835h.f4046a);
                    if (Build.VERSION.SDK_INT >= 31) {
                        TargetActivity.r = replaceAll;
                        c2.h("MEDIATIONCLICKDATA", replaceAll);
                    } else {
                        c2.h("MEDIATIONCLICKDATA", replaceAll);
                        String str12 = NotificationActionReceiver.o;
                    }
                    String str13 = jpVar.f5532f;
                    if (str13 == null || str13.isEmpty()) {
                        e(f4033a, f(f4033a));
                        return;
                    }
                    x.o(C0835h.f4046a, jpVar);
                    return;
                }
                e(f4033a, f(f4033a));
            } catch (Exception e2) {
                C1139gq c3 = C1139gq.c(C0835h.f4046a);
                if (!c3.e("iz_AdMediation_EXCEPTION_AdType_13").equalsIgnoreCase(H.p())) {
                    c3.h("iz_AdMediation_EXCEPTION_AdType_13", H.p());
                    H.w(C0835h.f4046a, "PayloadError" + e2.toString(), "AdMediation", "parseAgainJson");
                }
                C1104f8.b(C0835h.f4046a, e2.toString(), "[Log.e]->AdMediation 868");
            }
        }
    }

    public static void o(C1203jp jpVar, int i, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = jpVar.h;
        if (i3 == 0) {
            i3 = jpVar.g;
        }
        a++;
        new Thread(new z(i3 * 1000, new b(jpVar, currentTimeMillis, i2, i), x.c(jpVar.f5525a))).start();
    }

    public static void p() {
        ArrayList arrayList = b;
        if (arrayList.size() > 0) {
            try {
                double parseFloat = (double) Float.parseFloat(((C1203jp) arrayList.get(0)).x);
                int i = 0;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (((C1203jp) arrayList.get(i2)).x != null && !((C1203jp) arrayList.get(i2)).x.isEmpty() && ((double) Float.parseFloat(((C1203jp) arrayList.get(i2)).x)) > parseFloat) {
                        parseFloat = (double) Float.parseFloat(((C1203jp) arrayList.get(i2)).x);
                        i = i2;
                    }
                }
                ArrayList arrayList2 = c;
                if (arrayList2.size() > 0) {
                    double d2 = 0.0d;
                    int i3 = 0;
                    for (int i4 = 0; i4 < arrayList2.size(); i4++) {
                        if (Float.parseFloat(((C1203jp) arrayList2.get(i4)).x) >= Float.parseFloat(((C1203jp) arrayList2.get(0)).x)) {
                            d2 = (double) Float.parseFloat(((C1203jp) arrayList2.get(i4)).x);
                            i3 = i4;
                        }
                    }
                    if (d2 > parseFloat) {
                        C1203jp jpVar = (C1203jp) arrayList2.get(i3);
                        B.a(new C0829b(jpVar, System.currentTimeMillis()), jpVar.f5525a);
                    } else if (((C1203jp) arrayList.get(i)).f5532f != null && !((C1203jp) arrayList.get(i)).f5532f.equalsIgnoreCase("")) {
                        h((C1203jp) arrayList.get(i));
                        if (arrayList2.size() > 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("b", -1);
                            jSONObject.put("rb", Double.parseDouble(((C1203jp) arrayList2.get(i3)).D));
                            jSONObject.put("a", ((C1203jp) arrayList2.get(i3)).F);
                            jSONObject.put("t", -1);
                            f.add(jSONObject);
                            arrayList2.clear();
                        }
                    }
                } else {
                    h((C1203jp) arrayList.get(i));
                }
            } catch (Exception e2) {
                e2.toString();
            }
        }
    }

    /* renamed from: com.momagic.a$d */
    /* compiled from: AdMediation */
    public class d extends B.b {
        public final void b(String str) {
        }

        public final void a(int i, String str) {
        }
    }
}
