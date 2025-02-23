package com.momagic;

import com.momagic.B;
import org.json.JSONArray;

/* compiled from: NotificationEventManager */
public final class w extends B.b {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1139gq f4063a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f4064a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public w(C1139gq gqVar, int i, String str, String str2, String str3) {
        this.f4063a = gqVar;
        this.a = i;
        this.f4064a = str;
        this.b = str2;
        this.c = str3;
    }

    public final void a(int i, String str) {
        C1139gq gqVar = this.f4063a;
        try {
            if (gqVar.e("iZ_Notification_Last_View_Offline").isEmpty()) {
                H.z(C0835h.f4046a, this.b, "iZ_Notification_Last_View_Offline", this.f4064a, this.c, 0);
            } else if (!H.v(new JSONArray(gqVar.e("iZ_Notification_Last_View_Offline")), this.f4064a)) {
                H.z(C0835h.f4046a, this.b, "iZ_Notification_Last_View_Offline", this.f4064a, this.c, 0);
            }
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "lastViewNotification");
        }
    }

    public final void b(String str) {
        int i;
        C1139gq gqVar = this.f4063a;
        try {
            if (!gqVar.e("iZ_Notification_Last_View_Offline").isEmpty() && (i = this.a) >= 0) {
                new JSONArray(gqVar.e("iZ_Notification_Last_View_Offline")).remove(i);
                gqVar.h("iZ_Notification_Last_View_Offline", (String) null);
            }
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "lastViewNotification");
        }
    }
}
