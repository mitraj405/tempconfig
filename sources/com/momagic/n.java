package com.momagic;

import android.content.SharedPreferences;
import com.momagic.B;
import com.momagic.C0835h;
import org.json.JSONObject;

/* compiled from: DATB */
public final class n extends B.b {
    public final /* synthetic */ C1139gq a;

    public n(C1139gq gqVar) {
        this.a = gqVar;
    }

    public final void b(String str) {
        C0835h.g(C0835h.f4046a);
        C0835h.j jVar = C0835h.f4047a;
        if (jVar != null) {
            jVar.getClass();
        }
        C1139gq gqVar = this.a;
        gqVar.f("isTokenUpdated", true);
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = gqVar.f5471a.edit();
        edit.putLong("deviceRegistrationTimeStamp", currentTimeMillis);
        edit.apply();
        C0835h.c(C0835h.f4046a);
        try {
            gqVar.f("iz_isConsentStored", true);
            gqVar.g(1, "iz_cantStoredQueue");
            if (!gqVar.e("iz_userLocalData").isEmpty()) {
                C0835h.b(H.y(new JSONObject(gqVar.e("iz_userLocalData"))));
            }
            if (!gqVar.e("eventLocalDataEN").isEmpty() && !gqVar.e("eventLocalDataEV").isEmpty()) {
                JSONObject jSONObject = new JSONObject(gqVar.e("eventLocalDataEV"));
                C0835h.a(H.y(jSONObject), gqVar.e("eventLocalDataEN"));
            }
            if (gqVar.a("isSetSubscriptionMethod")) {
                C0835h.l(Boolean.valueOf(gqVar.a("setSubscriptionLocalData")));
            }
            if (!gqVar.e("iz_SUBSCRIBER_ID_DATA").isEmpty()) {
                C0835h.k(gqVar.e("iz_SUBSCRIBER_ID_DATA"));
            }
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "DATB", "registerToken");
        }
    }

    public final void a(int i, String str) {
    }
}
