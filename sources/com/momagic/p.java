package com.momagic;

import android.content.Context;
import com.momagic.B;
import org.json.JSONArray;

/* compiled from: NotificationActionReceiver */
public final class p extends B.b {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f4059a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1139gq f4060a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f4061a;
    public final /* synthetic */ String b;

    public p(int i, Context context, C1139gq gqVar, String str, String str2) {
        this.f4060a = gqVar;
        this.a = i;
        this.f4059a = context;
        this.f4061a = str;
        this.b = str2;
    }

    public final void a(int i, String str) {
        C1139gq gqVar = this.f4060a;
        try {
            if (gqVar.e("iZ_Notification_Last_Click_Offline").isEmpty()) {
                H.z(this.f4059a, this.b, "iZ_Notification_Last_Click_Offline", this.f4061a, "0", 0);
            } else if (!H.v(new JSONArray(gqVar.e("iZ_Notification_Last_Click_Offline")), this.f4061a)) {
                H.z(this.f4059a, this.b, "iZ_Notification_Last_Click_Offline", this.f4061a, "0", 0);
            }
        } catch (Exception e) {
            H.r(this.f4059a, e.toString(), "NotificationActionReceiver", "lastClickAPI");
        }
    }

    public final void b(String str) {
        int i;
        C1139gq gqVar = this.f4060a;
        try {
            if (!gqVar.e("iZ_Notification_Last_Click_Offline").isEmpty() && (i = this.a) >= 0) {
                new JSONArray(gqVar.e("iZ_Notification_Last_Click_Offline")).remove(i);
                gqVar.h("iZ_Notification_Last_Click_Offline", (String) null);
            }
        } catch (Exception e) {
            H.r(this.f4059a, e.toString(), "NotificationActionReceiver", "lastClickAPI");
        }
    }
}
