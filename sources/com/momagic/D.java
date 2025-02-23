package com.momagic;

import android.content.Context;
import com.momagic.B;
import org.json.JSONArray;

/* compiled from: TargetActivity */
public final class D extends B.b {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f4007a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1139gq f4008a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f4009a;
    public final /* synthetic */ int b = -1;

    /* renamed from: b  reason: collision with other field name */
    public final /* synthetic */ String f4010b;
    public final /* synthetic */ String c;

    public D(int i, Context context, C1139gq gqVar, String str, String str2, String str3) {
        this.f4008a = gqVar;
        this.f4009a = str;
        this.f4007a = context;
        this.f4010b = str2;
        this.c = str3;
        this.a = i;
    }

    public final void a(int i, String str) {
        C1139gq gqVar = this.f4008a;
        try {
            if (gqVar.e("iZ_Notification_Click_Offline").isEmpty()) {
                H.z(this.f4007a, this.f4010b, "iZ_Notification_Click_Offline", this.f4009a, this.c, this.a);
            } else if (!H.v(new JSONArray(gqVar.e("iZ_Notification_Click_Offline")), this.f4009a)) {
                H.z(this.f4007a, this.f4010b, "iZ_Notification_Click_Offline", this.f4009a, this.c, this.a);
            }
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "NotificationActionReceiver", "notificationClickAPI");
        }
    }

    public final void b(String str) {
        int i;
        C1139gq gqVar = this.f4008a;
        try {
            if (!gqVar.e("iZ_Notification_Click_Offline").isEmpty() && (i = this.b) >= 0) {
                JSONArray jSONArray = new JSONArray(gqVar.e("iZ_Notification_Click_Offline"));
                jSONArray.remove(i);
                gqVar.h("iZ_Notification_Click_Offline", jSONArray.toString());
            }
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "NotificationActionReceiver", "notificationClickAPI");
        }
    }
}
