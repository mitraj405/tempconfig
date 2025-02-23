package com.momagic;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.core.app.NotificationCompat$Builder;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressLint({"MissingFirebaseInstanceTokenRefresh"})
public class DATBMessagingService extends FirebaseMessagingService {
    public final ExecutorService a = Executors.newSingleThreadExecutor();

    /* renamed from: a  reason: collision with other field name */
    public C1203jp f4011a = null;

    public class a implements Runnable {
        public final /* synthetic */ RemoteMessage a;

        public a(RemoteMessage remoteMessage) {
            this.a = remoteMessage;
        }

        public final void run() {
            try {
                DATBMessagingService.c(DATBMessagingService.this, this.a);
                Thread.sleep(2000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void c(DATBMessagingService dATBMessagingService, RemoteMessage remoteMessage) {
        dATBMessagingService.getClass();
        try {
            if (remoteMessage.getData().size() > 0 && C1139gq.c(dATBMessagingService).f5471a.getBoolean("isEnable", true)) {
                dATBMessagingService.d(remoteMessage.getData());
            }
            if (remoteMessage.getNotification() != null) {
                dATBMessagingService.e(remoteMessage);
            }
        } catch (Exception e) {
            H.r(dATBMessagingService, remoteMessage + e.toString(), "DATBMessagingService", "executeBackgroundTask");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:100|101|116) */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        defpackage.C1104f8.b(r1, r23.toString(), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:100:0x043d */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x02bd A[Catch:{ Exception -> 0x0343 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(java.util.Map<java.lang.String, java.lang.String> r23) {
        /*
            r22 = this;
            r1 = r22
            r2 = r23
            java.lang.String r0 = "currentDateViewDaily"
            java.lang.String r3 = "contentPush"
            java.lang.String r4 = "ri"
            java.lang.String r5 = "handleNow"
            java.lang.String r6 = "ct"
            java.lang.String r7 = "IsException"
            java.lang.String r8 = "[Log.v]->"
            gq r9 = defpackage.C1139gq.c(r22)
            java.lang.String r10 = "an"
            java.lang.Object r10 = r2.get(r10)     // Catch:{ Exception -> 0x0448 }
            java.lang.String r13 = "DATBMessagingService"
            java.lang.String r14 = "cfg"
            java.lang.String r15 = "r"
            java.lang.String r12 = "id"
            java.lang.String r11 = "Mediation"
            r16 = r8
            java.lang.String r8 = "g"
            r17 = r7
            java.lang.String r7 = "gpl"
            r18 = r5
            java.lang.String r5 = "fcm"
            r19 = r0
            java.lang.String r0 = "Payload Error"
            if (r10 != 0) goto L_0x0347
            java.lang.Object r10 = r2.get(r8)     // Catch:{ Exception -> 0x0343 }
            if (r10 != 0) goto L_0x0347
            java.lang.Object r10 = r2.get(r7)     // Catch:{ Exception -> 0x0343 }
            if (r10 == 0) goto L_0x0046
            goto L_0x0347
        L_0x0046:
            r10 = 0
            r9.f(r11, r10)     // Catch:{ Exception -> 0x0343 }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x0343 }
            r7.<init>(r2)     // Catch:{ Exception -> 0x0343 }
            long r10 = r7.optLong(r6)     // Catch:{ Exception -> 0x0343 }
            gq r8 = defpackage.C1139gq.c(r22)     // Catch:{ Exception -> 0x0343 }
            android.content.SharedPreferences r8 = r8.f5471a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "deviceRegistrationTimeStamp"
            boolean r17 = r8.contains(r2)     // Catch:{ Exception -> 0x0343 }
            r20 = r13
            r21 = r14
            r13 = 0
            if (r17 == 0) goto L_0x006b
            long r13 = r8.getLong(r2, r13)     // Catch:{ Exception -> 0x0343 }
        L_0x006b:
            int r2 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            java.lang.String r8 = "t"
            if (r2 <= 0) goto L_0x030b
            jp r0 = new jp     // Catch:{ Exception -> 0x0343 }
            r0.<init>()     // Catch:{ Exception -> 0x0343 }
            r1.f4011a = r0     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = r7.optString(r6)     // Catch:{ Exception -> 0x0343 }
            r0.J = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "fu"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.f5525a = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "k"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.f5528b = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = r7.optString(r12)     // Catch:{ Exception -> 0x0343 }
            r0.f5529c = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = r7.optString(r15)     // Catch:{ Exception -> 0x0343 }
            r0.f5530d = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "ln"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.f5531e = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = r7.optString(r8)     // Catch:{ Exception -> 0x0343 }
            r0.f5532f = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "m"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.f5534h = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "i"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.f5535i = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            r7.optInt(r4)     // Catch:{ Exception -> 0x0343 }
            r0.getClass()     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "tg"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.f5537k = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "bi"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.f5538l = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "b"
            int r2 = r7.optInt(r2)     // Catch:{ Exception -> 0x0343 }
            r0.b = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "bic"
            r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.getClass()     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "bc"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.f5536j = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "st"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.f5533g = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "gp"
            int r2 = r7.optInt(r2)     // Catch:{ Exception -> 0x0343 }
            r0.a = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "bct"
            int r2 = r7.optInt(r2)     // Catch:{ Exception -> 0x0343 }
            r0.f = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "b1"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.m = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "l1"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.n = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "ib1"
            r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.getClass()     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "d1"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.u = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "b2"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.o = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "l2"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.p = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "ib2"
            r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.getClass()     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "d2"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.v = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "ia"
            int r2 = r7.optInt(r2)     // Catch:{ Exception -> 0x0343 }
            r0.c = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "ti"
            r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.getClass()     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "ic"
            r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.getClass()     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "gk"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.s = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "gm"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.t = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "pn"
            r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.getClass()     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "ci"
            r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.getClass()     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "rawData"
            r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.getClass()     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "ap"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.w = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            r2 = r21
            int r2 = r7.optInt(r2)     // Catch:{ Exception -> 0x0343 }
            r0.l = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            r0.K = r5     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "mn"
            int r2 = r7.optInt(r2)     // Catch:{ Exception -> 0x0343 }
            r0.i = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "fbd"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.H = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "fsd"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.G = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "fbu"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.I = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "nt"
            int r2 = r7.optInt(r2)     // Catch:{ Exception -> 0x0343 }
            r0.j = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "nbc"
            r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.getClass()     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "et"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.L = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = r7.optString(r4)     // Catch:{ Exception -> 0x0343 }
            r0.M = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "v"
            int r2 = r7.optInt(r2)     // Catch:{ Exception -> 0x0343 }
            r0.d = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "lc"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.r = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "c"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.O = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "vb"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.P = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "bdg"
            int r2 = r7.optInt(r2)     // Catch:{ Exception -> 0x0343 }
            r0.k = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "oth_chnl"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.N = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "s"
            java.lang.String r2 = r7.optString(r2)     // Catch:{ Exception -> 0x0343 }
            r0.q = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = "p"
            int r2 = r7.optInt(r2)     // Catch:{ Exception -> 0x0343 }
            r0.e = r2     // Catch:{ Exception -> 0x0343 }
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x02af }
            java.lang.String r0 = r0.f5530d     // Catch:{ Exception -> 0x02af }
            if (r0 == 0) goto L_0x02a5
            boolean r0 = r0.isEmpty()     // Catch:{ Exception -> 0x02af }
            if (r0 != 0) goto L_0x02a5
            java.lang.String r2 = "o"
            jp r0 = r1.f4011a     // Catch:{ Exception -> 0x02af }
            java.lang.String r0 = r0.f5530d     // Catch:{ Exception -> 0x0292 }
            java.lang.String r0 = r0.trim()     // Catch:{ Exception -> 0x0292 }
            r4 = 0
            char r0 = r0.charAt(r4)     // Catch:{ Exception -> 0x0292 }
            int r11 = r0 + -48
            goto L_0x02a1
        L_0x0292:
            r0 = move-exception
            android.content.Context r4 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x02af }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = "Util"
            java.lang.String r6 = "getValidIdForCampaigns"
            com.momagic.H.r(r4, r0, r5, r6)     // Catch:{ Exception -> 0x02af }
            r11 = 0
        L_0x02a1:
            r9.g(r11, r2)     // Catch:{ Exception -> 0x02af }
            goto L_0x02b9
        L_0x02a5:
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r23.toString()     // Catch:{ Exception -> 0x02af }
            defpackage.C1104f8.b(r0, r3, r2)     // Catch:{ Exception -> 0x02af }
            goto L_0x02b9
        L_0x02af:
            r0 = move-exception
            android.content.Context r2 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0343 }
            defpackage.C1104f8.b(r2, r3, r0)     // Catch:{ Exception -> 0x0343 }
        L_0x02b9:
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x0343 }
            if (r0 != 0) goto L_0x02bf
            com.momagic.C0835h.f4046a = r1     // Catch:{ Exception -> 0x0343 }
        L_0x02bf:
            android.os.Handler r0 = new android.os.Handler     // Catch:{ Exception -> 0x0343 }
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x0343 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0343 }
            gA r2 = new gA     // Catch:{ Exception -> 0x0343 }
            r3 = 11
            r2.<init>(r1, r3)     // Catch:{ Exception -> 0x0343 }
            jp r3 = r1.f4011a     // Catch:{ Exception -> 0x02f0 }
            y1 r4 = defpackage.C1492y1.a()     // Catch:{ Exception -> 0x02e1 }
            java.util.concurrent.ExecutorService r4 = r4.f7069a     // Catch:{ Exception -> 0x02e1 }
            E6 r5 = new E6     // Catch:{ Exception -> 0x02e1 }
            r6 = 1
            r5.<init>(r3, r6, r0, r2)     // Catch:{ Exception -> 0x02e1 }
            r4.execute(r5)     // Catch:{ Exception -> 0x02e1 }
            goto L_0x02fe
        L_0x02e1:
            r0 = move-exception
            android.content.Context r2 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x02f0 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02f0 }
            java.lang.String r3 = "NotificationExecutorService"
            java.lang.String r4 = "executeNotification"
            com.momagic.H.r(r2, r0, r3, r4)     // Catch:{ Exception -> 0x02f0 }
            goto L_0x02fe
        L_0x02f0:
            r0 = move-exception
            android.content.Context r2 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0343 }
            java.lang.String r3 = "handleNownotificationExecutorService"
            r4 = r20
            com.momagic.H.r(r2, r0, r4, r3)     // Catch:{ Exception -> 0x0343 }
        L_0x02fe:
            android.content.Context r0 = com.momagic.C0835h.f4046a     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = r23.toString()     // Catch:{ Exception -> 0x0343 }
            java.lang.String r3 = " Log-> "
            defpackage.C1104f8.b(r0, r2, r3)     // Catch:{ Exception -> 0x0343 }
            goto L_0x0453
        L_0x030b:
            gq r2 = defpackage.C1139gq.c(r22)     // Catch:{ Exception -> 0x0343 }
            r3 = r19
            java.lang.String r2 = r2.e(r3)     // Catch:{ Exception -> 0x0343 }
            java.lang.String r4 = com.momagic.H.p()     // Catch:{ Exception -> 0x0343 }
            boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ Exception -> 0x0343 }
            if (r2 != 0) goto L_0x0453
            java.lang.String r2 = com.momagic.H.p()     // Catch:{ Exception -> 0x0343 }
            r9.h(r3, r2)     // Catch:{ Exception -> 0x0343 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0343 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0343 }
            java.lang.String r0 = r7.optString(r8)     // Catch:{ Exception -> 0x0343 }
            r2.append(r0)     // Catch:{ Exception -> 0x0343 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0343 }
            java.lang.String r2 = r7.toString()     // Catch:{ Exception -> 0x0343 }
            java.lang.String r3 = "DATBMESSAGINSERVEICES"
            java.lang.String r4 = "handleNow()"
            com.momagic.x.j(r0, r2, r3, r4)     // Catch:{ Exception -> 0x0343 }
            goto L_0x0453
        L_0x0343:
            r3 = r23
            goto L_0x0445
        L_0x0347:
            r4 = r13
            r2 = r14
            r3 = r23
            java.lang.Object r6 = r3.get(r7)     // Catch:{ Exception -> 0x0445 }
            java.lang.String r10 = "https://impr.izooto.com/imp"
            java.lang.String r13 = "1"
            if (r6 == 0) goto L_0x03ee
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ Exception -> 0x03be }
            java.lang.Object r6 = r3.get(r8)     // Catch:{ Exception -> 0x03be }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x03be }
            java.util.Objects.requireNonNull(r6)     // Catch:{ Exception -> 0x03be }
            r5.<init>(r6)     // Catch:{ Exception -> 0x03be }
            java.lang.Object r6 = r3.get(r7)     // Catch:{ Exception -> 0x03be }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x03be }
            java.lang.String r7 = r5.toString()     // Catch:{ Exception -> 0x03be }
            if (r7 == 0) goto L_0x03af
            if (r6 == 0) goto L_0x03af
            boolean r7 = r6.isEmpty()     // Catch:{ Exception -> 0x03be }
            if (r7 != 0) goto L_0x03af
            java.lang.String r0 = r5.optString(r12)     // Catch:{ Exception -> 0x03be }
            java.lang.String r7 = r5.optString(r15)     // Catch:{ Exception -> 0x03be }
            int r2 = r5.optInt(r2)     // Catch:{ Exception -> 0x03be }
            java.lang.String r2 = com.momagic.H.l(r2)     // Catch:{ Exception -> 0x03be }
            if (r2 == 0) goto L_0x03a6
            boolean r8 = r2.isEmpty()     // Catch:{ Exception -> 0x03be }
            if (r8 != 0) goto L_0x03a6
            int r8 = r2.length()     // Catch:{ Exception -> 0x03be }
            r12 = 1
            int r8 = r8 - r12
            char r2 = r2.charAt(r8)     // Catch:{ Exception -> 0x03be }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x03be }
            boolean r2 = r2.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x03be }
            if (r2 == 0) goto L_0x03a6
            com.momagic.x.k(r10, r0, r7)     // Catch:{ Exception -> 0x03be }
        L_0x03a6:
            com.momagic.C0828a.j(r1, r5, r6)     // Catch:{ Exception -> 0x03be }
            r2 = 0
            r9.f(r11, r2)     // Catch:{ Exception -> 0x03be }
            goto L_0x0453
        L_0x03af:
            java.lang.String r2 = r23.toString()     // Catch:{ Exception -> 0x03be }
            java.lang.String r5 = "MessagingServices"
            r6 = r18
            com.momagic.x.j(r0, r2, r5, r6)     // Catch:{ Exception -> 0x03bc }
            goto L_0x0453
        L_0x03bc:
            r0 = move-exception
            goto L_0x03c1
        L_0x03be:
            r0 = move-exception
            r6 = r18
        L_0x03c1:
            r2 = r17
            boolean r5 = r9.a(r2)     // Catch:{ Exception -> 0x0445 }
            if (r5 != 0) goto L_0x03e4
            r5 = 1
            r9.f(r2, r5)     // Catch:{ Exception -> 0x0445 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0445 }
            r2.<init>()     // Catch:{ Exception -> 0x0445 }
            r2.append(r0)     // Catch:{ Exception -> 0x0445 }
            java.lang.String r0 = "PayloadError"
            r2.append(r0)     // Catch:{ Exception -> 0x0445 }
            r2.append(r3)     // Catch:{ Exception -> 0x0445 }
            java.lang.String r0 = r2.toString()     // Catch:{ Exception -> 0x0445 }
            com.momagic.H.r(r1, r0, r4, r6)     // Catch:{ Exception -> 0x0445 }
        L_0x03e4:
            java.lang.String r0 = r23.toString()     // Catch:{ Exception -> 0x0445 }
            r4 = r16
            defpackage.C1104f8.b(r1, r0, r4)     // Catch:{ Exception -> 0x044a }
            goto L_0x0453
        L_0x03ee:
            r4 = r16
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x043d }
            java.lang.Object r6 = r3.get(r8)     // Catch:{ Exception -> 0x043d }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x043d }
            r0.<init>(r6)     // Catch:{ Exception -> 0x043d }
            java.lang.String r6 = r0.optString(r12)     // Catch:{ Exception -> 0x043d }
            java.lang.String r7 = r0.optString(r15)     // Catch:{ Exception -> 0x043d }
            int r0 = r0.optInt(r2)     // Catch:{ Exception -> 0x043d }
            java.lang.String r0 = com.momagic.H.l(r0)     // Catch:{ Exception -> 0x043d }
            if (r0 == 0) goto L_0x042a
            boolean r2 = r0.isEmpty()     // Catch:{ Exception -> 0x043d }
            if (r2 != 0) goto L_0x042a
            int r2 = r0.length()     // Catch:{ Exception -> 0x043d }
            r8 = 1
            int r2 = r2 - r8
            char r0 = r0.charAt(r2)     // Catch:{ Exception -> 0x043d }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x043d }
            boolean r0 = r0.equalsIgnoreCase(r13)     // Catch:{ Exception -> 0x043d }
            if (r0 == 0) goto L_0x042a
            com.momagic.x.k(r10, r6, r7)     // Catch:{ Exception -> 0x043d }
        L_0x042a:
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x043d }
            java.lang.String r2 = r23.toString()     // Catch:{ Exception -> 0x043d }
            r0.<init>(r2)     // Catch:{ Exception -> 0x043d }
            java.lang.String r2 = ""
            com.momagic.C0828a.i(r1, r0, r5, r2)     // Catch:{ Exception -> 0x043d }
            r2 = 1
            r9.f(r11, r2)     // Catch:{ Exception -> 0x043d }
            goto L_0x0453
        L_0x043d:
            java.lang.String r0 = r23.toString()     // Catch:{ Exception -> 0x044a }
            defpackage.C1104f8.b(r1, r0, r4)     // Catch:{ Exception -> 0x044a }
            goto L_0x0453
        L_0x0445:
            r4 = r16
            goto L_0x044a
        L_0x0448:
            r3 = r2
            r4 = r8
        L_0x044a:
            android.content.Context r0 = com.momagic.C0835h.f4046a
            java.lang.String r2 = r23.toString()
            defpackage.C1104f8.b(r0, r2, r4)
        L_0x0453:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.momagic.DATBMessagingService.d(java.util.Map):void");
    }

    public final void e(RemoteMessage remoteMessage) {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 1140850688);
        String string = getString(C0772Zr.default_notification_channel_id);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        NotificationCompat$Builder notificationCompat$Builder = new NotificationCompat$Builder(this, string);
        Notification notification = notificationCompat$Builder.f1735a;
        notification.icon = 17301598;
        notificationCompat$Builder.g(remoteMessage.getNotification().getTitle());
        notificationCompat$Builder.f(remoteMessage.getNotification().getBody());
        notificationCompat$Builder.j(16, true);
        notificationCompat$Builder.j(16, true);
        notification.sound = defaultUri;
        notification.audioStreamType = -1;
        notification.audioAttributes = NotificationCompat$Builder.a.a(NotificationCompat$Builder.a.e(NotificationCompat$Builder.a.c(NotificationCompat$Builder.a.b(), 4), 5));
        notificationCompat$Builder.f1736a = activity;
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        notificationManager.createNotificationChannel(new NotificationChannel(string, "Updates and Notifications", 3));
        notificationManager.notify(0, notificationCompat$Builder.b());
    }

    public final void onMessageReceived(RemoteMessage remoteMessage) {
        try {
            this.a.execute(new a(remoteMessage));
        } catch (Exception e) {
            H.r(this, remoteMessage + e.toString(), "DATBMessagingService", "onMessageReceived");
        }
    }
}
