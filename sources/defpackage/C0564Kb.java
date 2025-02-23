package defpackage;

import android.content.Context;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.momagic.C0835h;
import com.momagic.H;

/* renamed from: Kb  reason: default package and case insensitive filesystem */
/* compiled from: FCMTokenGenerator */
public final class C0564Kb implements Runnable {
    public final /* synthetic */ C0577Lb a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f3684a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1063dA f3685a;
    public final /* synthetic */ String c;

    /* renamed from: Kb$a */
    /* compiled from: FCMTokenGenerator */
    public class a implements OnCompleteListener<String> {
        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
            if (r2.e("iz_app_version").equalsIgnoreCase(com.momagic.H.h(r4)) != false) goto L_0x0059;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onComplete(com.google.android.gms.tasks.Task<java.lang.String> r10) {
            /*
                r9 = this;
                java.lang.String r0 = "deviceToken"
                Kb r1 = defpackage.C0564Kb.this
                boolean r2 = r10.isSuccessful()     // Catch:{ Exception -> 0x006c }
                if (r2 != 0) goto L_0x000b
                return
            L_0x000b:
                java.lang.Object r10 = r10.getResult()     // Catch:{ Exception -> 0x006c }
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x006c }
                if (r10 == 0) goto L_0x0066
                boolean r2 = r10.isEmpty()     // Catch:{ Exception -> 0x006c }
                if (r2 != 0) goto L_0x0066
                android.content.Context r2 = r1.f3684a     // Catch:{ Exception -> 0x006c }
                gq r2 = defpackage.C1139gq.c(r2)     // Catch:{ Exception -> 0x006c }
                java.lang.String r3 = r2.e(r0)     // Catch:{ Exception -> 0x006c }
                boolean r3 = r10.equals(r3)     // Catch:{ Exception -> 0x006c }
                android.content.Context r4 = r1.f3684a
                java.lang.String r5 = "iz_app_version"
                java.lang.String r6 = "IZ_SDK_UPDATE"
                java.lang.String r7 = "2.4.0"
                if (r3 == 0) goto L_0x0049
                java.lang.String r3 = r2.e(r6)     // Catch:{ Exception -> 0x006c }
                boolean r3 = r7.equals(r3)     // Catch:{ Exception -> 0x006c }
                if (r3 == 0) goto L_0x0049
                java.lang.String r3 = r2.e(r5)     // Catch:{ Exception -> 0x006c }
                java.lang.String r8 = com.momagic.H.h(r4)     // Catch:{ Exception -> 0x006c }
                boolean r3 = r3.equalsIgnoreCase(r8)     // Catch:{ Exception -> 0x006c }
                if (r3 != 0) goto L_0x0059
            L_0x0049:
                java.lang.String r3 = "isTokenUpdated"
                r8 = 0
                r2.f(r3, r8)     // Catch:{ Exception -> 0x006c }
                java.lang.String r3 = com.momagic.H.h(r4)     // Catch:{ Exception -> 0x006c }
                r2.h(r5, r3)     // Catch:{ Exception -> 0x006c }
                r2.h(r6, r7)     // Catch:{ Exception -> 0x006c }
            L_0x0059:
                r2.h(r0, r10)     // Catch:{ Exception -> 0x006c }
                dA r10 = r1.f3685a     // Catch:{ Exception -> 0x006c }
                if (r10 == 0) goto L_0x0081
                com.momagic.h$i r10 = (com.momagic.C0835h.i) r10     // Catch:{ Exception -> 0x006c }
                r10.a()     // Catch:{ Exception -> 0x006c }
                goto L_0x0081
            L_0x0066:
                dA r10 = r1.f3685a     // Catch:{ Exception -> 0x006c }
                r10.getClass()     // Catch:{ Exception -> 0x006c }
                goto L_0x0081
            L_0x006c:
                r10 = move-exception
                android.content.Context r0 = r1.f3684a
                java.lang.String r2 = r10.toString()
                java.lang.String r3 = "FCMTokenGenerator"
                java.lang.String r4 = "getToken"
                com.momagic.H.r(r0, r2, r3, r4)
                dA r0 = r1.f3685a
                if (r0 == 0) goto L_0x0081
                r10.getMessage()
            L_0x0081:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C0564Kb.a.onComplete(com.google.android.gms.tasks.Task):void");
        }
    }

    public C0564Kb(C0577Lb lb, String str, Context context, C0835h.i iVar) {
        this.a = lb;
        this.c = str;
        this.f3684a = context;
        this.f3685a = iVar;
    }

    public final void run() {
        try {
            C0577Lb lb = this.a;
            String str = this.c;
            lb.getClass();
            C0577Lb.c(str);
            ((FirebaseMessaging) C0577Lb.a.get(FirebaseMessaging.class)).getToken().addOnCompleteListener(new a());
        } catch (Exception e) {
            H.r(this.f3684a, e.toString(), "FCMTokenGenerator", "getToken");
            if (this.f3685a != null) {
                e.getMessage();
            }
        }
    }
}
