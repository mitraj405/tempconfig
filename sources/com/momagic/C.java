package com.momagic;

import android.content.Context;
import com.momagic.B;
import org.json.JSONArray;

/* compiled from: TargetActivity */
public final class C extends B.b {
    public final /* synthetic */ int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f4003a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1139gq f4004a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f4005a;
    public final /* synthetic */ int b;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ String f4006b;
    public final /* synthetic */ String c;

    public C(int i, Context context, C1139gq gqVar, String str, String str2, String str3) {
        this.f4004a = gqVar;
        this.f4005a = str;
        this.f4003a = context;
        this.f4006b = str2;
        this.c = str3;
        this.b = i;
    }

    public final void a(int i, String str) {
        C1139gq gqVar = this.f4004a;
        try {
            if (gqVar.e("iZ_Notification_Click_Offline").isEmpty()) {
                H.z(this.f4003a, this.f4006b, "iZ_Notification_Click_Offline", this.f4005a, this.c, this.b);
            } else if (!H.v(new JSONArray(gqVar.e("iZ_Notification_Click_Offline")), this.f4005a)) {
                H.z(this.f4003a, this.f4006b, "iZ_Notification_Click_Offline", this.f4005a, this.c, this.b);
            }
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "NotificationActionReceiver", "notificationClickAPI->onFailure");
        }
    }

    public final void b(String str) {
        int i;
        C1139gq gqVar = this.f4004a;
        try {
            if (!gqVar.e("iZ_Notification_Click_Offline").isEmpty() && (i = this.a) >= 0) {
                new JSONArray(gqVar.e("iZ_Notification_Click_Offline")).remove(i);
                gqVar.h("iZ_Notification_Click_Offline", (String) null);
            }
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "TargetActivity", "notificationClickAPI");
        }
    }
}
