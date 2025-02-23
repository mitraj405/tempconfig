package com.google.firebase.sessions.settings;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

@C1128g8(c = "com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1", f = "RemoteSettings.kt", l = {125, 128, 131, 133, 134, 136}, m = "invokeSuspend")
/* compiled from: RemoteSettings.kt */
public final class RemoteSettings$updateSettings$2$1 extends Py implements Function2<JSONObject, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ RemoteSettings this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RemoteSettings$updateSettings$2$1(RemoteSettings remoteSettings, Continuation<? super RemoteSettings$updateSettings$2$1> continuation) {
        super(2, continuation);
        this.this$0 = remoteSettings;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RemoteSettings$updateSettings$2$1 remoteSettings$updateSettings$2$1 = new RemoteSettings$updateSettings$2$1(this.this$0, continuation);
        remoteSettings$updateSettings$2$1.L$0 = obj;
        return remoteSettings$updateSettings$2$1;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d7, code lost:
        r12 = (java.lang.Integer) r7.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00db, code lost:
        if (r12 == null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00dd, code lost:
        r2 = r11.this$0;
        r12.intValue();
        r11.L$0 = r1;
        r11.L$1 = r0;
        r11.L$2 = null;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f7, code lost:
        if (r2.getSettingsCache().updateSessionRestartTimeout((java.lang.Integer) r7.a, r11) != r4) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f9, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00fa, code lost:
        r12 = (java.lang.Double) r1.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fe, code lost:
        if (r12 == null) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0100, code lost:
        r2 = r11.this$0;
        r12.doubleValue();
        r11.L$0 = r0;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x011a, code lost:
        if (r2.getSettingsCache().updateSamplingRate((java.lang.Double) r1.a, r11) != r4) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x011c, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x011d, code lost:
        r12 = (java.lang.Integer) r0.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0121, code lost:
        if (r12 == null) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0123, code lost:
        r1 = r11.this$0;
        r12.intValue();
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x013d, code lost:
        if (r1.getSettingsCache().updateSessionCacheDuration((java.lang.Integer) r0.a, r11) != r4) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013f, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0140, code lost:
        r12 = kotlin.Unit.a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0143, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0144, code lost:
        if (r12 != null) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0146, code lost:
        r12 = r11.this$0.getSettingsCache();
        r0 = new java.lang.Integer(86400);
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0161, code lost:
        if (r12.updateSessionCacheDuration(r0, r11) != r4) goto L_0x0164;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0163, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0164, code lost:
        r12 = r11.this$0.getSettingsCache();
        r2 = new java.lang.Long(java.lang.System.currentTimeMillis());
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0180, code lost:
        if (r12.updateSessionCacheUpdatedTime(r2, r11) != r4) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0182, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0185, code lost:
        return kotlin.Unit.a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.String r0 = "cache_duration"
            java.lang.String r1 = "session_timeout_seconds"
            java.lang.String r2 = "sampling_rate"
            java.lang.String r3 = "sessions_enabled"
            v7 r4 = defpackage.C1438v7.COROUTINE_SUSPENDED
            int r5 = r11.label
            r6 = 0
            switch(r5) {
                case 0: goto L_0x004e;
                case 1: goto L_0x003d;
                case 2: goto L_0x0030;
                case 3: goto L_0x0027;
                case 4: goto L_0x0022;
                case 5: goto L_0x001d;
                case 6: goto L_0x0018;
                default: goto L_0x0010;
            }
        L_0x0010:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0018:
            defpackage.r1.R(r12)
            goto L_0x0183
        L_0x001d:
            defpackage.r1.R(r12)
            goto L_0x0164
        L_0x0022:
            defpackage.r1.R(r12)
            goto L_0x0140
        L_0x0027:
            java.lang.Object r0 = r11.L$0
            Ks r0 = (defpackage.C0571Ks) r0
            defpackage.r1.R(r12)
            goto L_0x011d
        L_0x0030:
            java.lang.Object r0 = r11.L$1
            Ks r0 = (defpackage.C0571Ks) r0
            java.lang.Object r1 = r11.L$0
            Ks r1 = (defpackage.C0571Ks) r1
            defpackage.r1.R(r12)
            goto L_0x00fa
        L_0x003d:
            java.lang.Object r0 = r11.L$2
            Ks r0 = (defpackage.C0571Ks) r0
            java.lang.Object r1 = r11.L$1
            Ks r1 = (defpackage.C0571Ks) r1
            java.lang.Object r2 = r11.L$0
            Ks r2 = (defpackage.C0571Ks) r2
            defpackage.r1.R(r12)
            goto L_0x00d2
        L_0x004e:
            defpackage.r1.R(r12)
            java.lang.Object r12 = r11.L$0
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            java.util.Objects.toString(r12)
            Ks r5 = new Ks
            r5.<init>()
            Ks r7 = new Ks
            r7.<init>()
            Ks r8 = new Ks
            r8.<init>()
            java.lang.String r9 = "app_quality"
            boolean r10 = r12.has(r9)
            if (r10 == 0) goto L_0x00b3
            java.lang.Object r12 = r12.get(r9)
            java.lang.String r9 = "null cannot be cast to non-null type org.json.JSONObject"
            defpackage.C1177ig.d(r12, r9)
            org.json.JSONObject r12 = (org.json.JSONObject) r12
            boolean r9 = r12.has(r3)     // Catch:{ JSONException -> 0x00b3 }
            if (r9 == 0) goto L_0x0087
            java.lang.Object r3 = r12.get(r3)     // Catch:{ JSONException -> 0x00b3 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ JSONException -> 0x00b3 }
            goto L_0x0088
        L_0x0087:
            r3 = r6
        L_0x0088:
            boolean r9 = r12.has(r2)     // Catch:{ JSONException -> 0x00b4 }
            if (r9 == 0) goto L_0x0096
            java.lang.Object r2 = r12.get(r2)     // Catch:{ JSONException -> 0x00b4 }
            java.lang.Double r2 = (java.lang.Double) r2     // Catch:{ JSONException -> 0x00b4 }
            r5.a = r2     // Catch:{ JSONException -> 0x00b4 }
        L_0x0096:
            boolean r2 = r12.has(r1)     // Catch:{ JSONException -> 0x00b4 }
            if (r2 == 0) goto L_0x00a4
            java.lang.Object r1 = r12.get(r1)     // Catch:{ JSONException -> 0x00b4 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ JSONException -> 0x00b4 }
            r7.a = r1     // Catch:{ JSONException -> 0x00b4 }
        L_0x00a4:
            boolean r1 = r12.has(r0)     // Catch:{ JSONException -> 0x00b4 }
            if (r1 == 0) goto L_0x00b4
            java.lang.Object r12 = r12.get(r0)     // Catch:{ JSONException -> 0x00b4 }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ JSONException -> 0x00b4 }
            r8.a = r12     // Catch:{ JSONException -> 0x00b4 }
            goto L_0x00b4
        L_0x00b3:
            r3 = r6
        L_0x00b4:
            if (r3 == 0) goto L_0x00d5
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            r3.booleanValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.getSettingsCache()
            r11.L$0 = r5
            r11.L$1 = r7
            r11.L$2 = r8
            r0 = 1
            r11.label = r0
            java.lang.Object r12 = r12.updateSettingsEnabled(r3, r11)
            if (r12 != r4) goto L_0x00cf
            return r4
        L_0x00cf:
            r2 = r5
            r1 = r7
            r0 = r8
        L_0x00d2:
            r7 = r1
            r1 = r2
            goto L_0x00d7
        L_0x00d5:
            r1 = r5
            r0 = r8
        L_0x00d7:
            T r12 = r7.a
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L_0x00fa
            com.google.firebase.sessions.settings.RemoteSettings r2 = r11.this$0
            r12.intValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r2.getSettingsCache()
            T r2 = r7.a
            java.lang.Integer r2 = (java.lang.Integer) r2
            r11.L$0 = r1
            r11.L$1 = r0
            r11.L$2 = r6
            r3 = 2
            r11.label = r3
            java.lang.Object r12 = r12.updateSessionRestartTimeout(r2, r11)
            if (r12 != r4) goto L_0x00fa
            return r4
        L_0x00fa:
            T r12 = r1.a
            java.lang.Double r12 = (java.lang.Double) r12
            if (r12 == 0) goto L_0x011d
            com.google.firebase.sessions.settings.RemoteSettings r2 = r11.this$0
            r12.doubleValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r2.getSettingsCache()
            T r1 = r1.a
            java.lang.Double r1 = (java.lang.Double) r1
            r11.L$0 = r0
            r11.L$1 = r6
            r11.L$2 = r6
            r2 = 3
            r11.label = r2
            java.lang.Object r12 = r12.updateSamplingRate(r1, r11)
            if (r12 != r4) goto L_0x011d
            return r4
        L_0x011d:
            T r12 = r0.a
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto L_0x0143
            com.google.firebase.sessions.settings.RemoteSettings r1 = r11.this$0
            r12.intValue()
            com.google.firebase.sessions.settings.SettingsCache r12 = r1.getSettingsCache()
            T r0 = r0.a
            java.lang.Integer r0 = (java.lang.Integer) r0
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 4
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheDuration(r0, r11)
            if (r12 != r4) goto L_0x0140
            return r4
        L_0x0140:
            kotlin.Unit r12 = kotlin.Unit.a
            goto L_0x0144
        L_0x0143:
            r12 = r6
        L_0x0144:
            if (r12 != 0) goto L_0x0164
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.getSettingsCache()
            java.lang.Integer r0 = new java.lang.Integer
            r1 = 86400(0x15180, float:1.21072E-40)
            r0.<init>(r1)
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r1 = 5
            r11.label = r1
            java.lang.Object r12 = r12.updateSessionCacheDuration(r0, r11)
            if (r12 != r4) goto L_0x0164
            return r4
        L_0x0164:
            com.google.firebase.sessions.settings.RemoteSettings r12 = r11.this$0
            com.google.firebase.sessions.settings.SettingsCache r12 = r12.getSettingsCache()
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Long r2 = new java.lang.Long
            r2.<init>(r0)
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r0 = 6
            r11.label = r0
            java.lang.Object r12 = r12.updateSessionCacheUpdatedTime(r2, r11)
            if (r12 != r4) goto L_0x0183
            return r4
        L_0x0183:
            kotlin.Unit r12 = kotlin.Unit.a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        return ((RemoteSettings$updateSettings$2$1) create(jSONObject, continuation)).invokeSuspend(Unit.a);
    }
}
