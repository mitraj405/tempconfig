package com.momagic;

import android.content.Context;
import com.momagic.B;
import org.json.JSONArray;

/* compiled from: TargetActivity */
public final class E extends B.b {
    public final /* synthetic */ int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Context f4014a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1139gq f4015a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f4016a;
    public final /* synthetic */ String b;

    public E(Context context, C1139gq gqVar, String str, String str2) {
        this.f4015a = gqVar;
        this.f4016a = str;
        this.f4014a = context;
        this.b = str2;
    }

    public final void a(int i, String str) {
        C1139gq gqVar = this.f4015a;
        try {
            if (gqVar.e("iZ_Notification_Last_Click_Offline").isEmpty()) {
                H.z(this.f4014a, this.b, "iZ_Notification_Last_Click_Offline", this.f4016a, "0", 0);
            } else if (!H.v(new JSONArray(gqVar.e("iZ_Notification_Last_Click_Offline")), this.f4016a)) {
                H.z(this.f4014a, this.b, "iZ_Notification_Last_Click_Offline", this.f4016a, "0", 0);
            }
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "TargetActivity", "lastClickAPI");
        }
    }

    public final void b(String str) {
        int i;
        C1139gq gqVar = this.f4015a;
        try {
            if (!gqVar.e("iZ_Notification_Last_Click_Offline").isEmpty() && (i = this.a) >= 0) {
                new JSONArray(gqVar.e("iZ_Notification_Last_Click_Offline")).remove(i);
                gqVar.h("iZ_Notification_Last_Click_Offline", (String) null);
            }
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "TargetActivity", "lastClickAPI");
        }
    }
}
