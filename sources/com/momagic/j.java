package com.momagic;

import android.content.Context;
import com.momagic.B;

/* compiled from: DATB */
public final class j extends B.b {
    public final /* synthetic */ Context a;

    public j(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00be, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r0 = r5.a;
        r6 = r6.toString();
        r1 = com.momagic.C0835h.f4046a;
        com.momagic.H.r(r0, r6, "DATB", "init");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r6) {
        /*
            r5 = this;
            boolean r0 = r6.isEmpty()     // Catch:{ Exception -> 0x00cf }
            if (r0 != 0) goto L_0x00dd
            int r0 = r6.length()     // Catch:{ Exception -> 0x00cf }
            r1 = 20
            if (r0 <= r1) goto L_0x00dd
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x00be }
            gq r0 = defpackage.C1139gq.c(r0)     // Catch:{ Exception -> 0x00be }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00be }
            java.lang.String r6 = com.momagic.H.d(r6)     // Catch:{ Exception -> 0x00be }
            java.util.Objects.requireNonNull(r6)     // Catch:{ Exception -> 0x00be }
            r1.<init>(r6)     // Catch:{ Exception -> 0x00be }
            java.lang.String r6 = "senderId"
            boolean r6 = r1.has(r6)     // Catch:{ Exception -> 0x00be }
            if (r6 == 0) goto L_0x0031
            java.lang.String r6 = "senderId"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ Exception -> 0x00be }
            com.momagic.C0835h.f4048a = r6     // Catch:{ Exception -> 0x00be }
            goto L_0x005a
        L_0x0031:
            java.lang.String r6 = "getSenderId()"
            java.lang.String r2 = "FCMTokenGenerator"
            android.content.Context r3 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x004c }
            com.google.firebase.FirebaseOptions r3 = com.google.firebase.FirebaseOptions.fromResource(r3)     // Catch:{ Exception -> 0x004c }
            if (r3 == 0) goto L_0x0044
            java.lang.String r6 = r3.getGcmSenderId()     // Catch:{ Exception -> 0x004c }
            if (r6 == 0) goto L_0x0056
            goto L_0x0058
        L_0x0044:
            android.content.Context r3 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x004c }
            java.lang.String r4 = "Firebase options is null"
            com.momagic.H.r(r3, r4, r2, r6)     // Catch:{ Exception -> 0x004c }
            goto L_0x0056
        L_0x004c:
            r3 = move-exception
            android.content.Context r4 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x00be }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x00be }
            com.momagic.H.r(r4, r3, r2, r6)     // Catch:{ Exception -> 0x00be }
        L_0x0056:
            java.lang.String r6 = ""
        L_0x0058:
            com.momagic.C0835h.f4048a = r6     // Catch:{ Exception -> 0x00be }
        L_0x005a:
            java.lang.String r6 = "pid"
            java.lang.String r6 = r1.optString(r6)     // Catch:{ Exception -> 0x00be }
            com.momagic.C0835h.b = r6     // Catch:{ Exception -> 0x00be }
            java.lang.String r6 = "isPrompt"
            boolean r6 = r1.optBoolean(r6)     // Catch:{ Exception -> 0x00be }
            java.lang.String r1 = "isPrompt"
            r0.f(r1, r6)     // Catch:{ Exception -> 0x00be }
            java.lang.String r6 = "pid"
            java.lang.String r1 = com.momagic.C0835h.b     // Catch:{ Exception -> 0x00be }
            android.content.SharedPreferences r2 = r0.f5471a     // Catch:{ Exception -> 0x00be }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ Exception -> 0x00be }
            r2.putString(r6, r1)     // Catch:{ Exception -> 0x00be }
            r2.apply()     // Catch:{ Exception -> 0x00be }
            android.content.Context r6 = r5.a     // Catch:{ Exception -> 0x00be }
            android.app.Notification r1 = new android.app.Notification     // Catch:{ Exception -> 0x00be }
            r1.<init>()     // Catch:{ Exception -> 0x00be }
            java.lang.String r1 = r1.getChannelId()     // Catch:{ Exception -> 0x00be }
            java.lang.String r2 = com.momagic.C0835h.f4048a     // Catch:{ Exception -> 0x00be }
            com.momagic.C0835h.d(r6, r1, r2)     // Catch:{ Exception -> 0x00be }
            android.content.Context r6 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x00be }
            gq r6 = defpackage.C1139gq.c(r6)     // Catch:{ Exception -> 0x00be }
            android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x00be }
            com.momagic.l r2 = new com.momagic.l     // Catch:{ Exception -> 0x00be }
            r2.<init>(r6)     // Catch:{ Exception -> 0x00be }
            int r6 = com.momagic.C0834g.a     // Catch:{ Exception -> 0x00be }
            java.lang.Class<com.momagic.g> r6 = com.momagic.C0834g.class
            monitor-enter(r6)     // Catch:{ Exception -> 0x00be }
            com.momagic.g r3 = new com.momagic.g     // Catch:{ all -> 0x00bb }
            r3.<init>()     // Catch:{ all -> 0x00bb }
            r3.b(r1, r2)     // Catch:{ all -> 0x00bb }
            monitor-exit(r6)     // Catch:{ Exception -> 0x00be }
            java.lang.String r6 = com.momagic.C0835h.b     // Catch:{ Exception -> 0x00be }
            if (r6 == 0) goto L_0x00dd
            java.lang.String r6 = "iz_isConsentStored"
            boolean r6 = r0.a(r6)     // Catch:{ Exception -> 0x00be }
            if (r6 == 0) goto L_0x00dd
            java.lang.String r6 = "iz_cantStoredQueue"
            r1 = 1
            r0.g(r1, r6)     // Catch:{ Exception -> 0x00be }
            goto L_0x00dd
        L_0x00bb:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ Exception -> 0x00be }
            throw r0     // Catch:{ Exception -> 0x00be }
        L_0x00be:
            r6 = move-exception
            android.content.Context r0 = r5.a     // Catch:{ Exception -> 0x00cf }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00cf }
            android.content.Context r1 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x00cf }
            java.lang.String r1 = "DATB"
            java.lang.String r2 = "init"
            com.momagic.H.r(r0, r6, r1, r2)     // Catch:{ Exception -> 0x00cf }
            goto L_0x00dd
        L_0x00cf:
            r6 = move-exception
            android.content.Context r0 = com.momagic.C0835h.f4046a
            java.lang.String r6 = r6.toString()
            java.lang.String r1 = "DATB"
            java.lang.String r2 = "init_onSuccess"
            com.momagic.H.r(r0, r6, r1, r2)
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.momagic.j.b(java.lang.String):void");
    }

    public final void a(int i, String str) {
    }
}
