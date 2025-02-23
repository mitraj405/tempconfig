package com.momagic;

import com.momagic.B;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: NotificationEventManager */
public final class s extends B.b {
    public final /* synthetic */ C1203jp a;

    public s(C1203jp jpVar) {
        this.a = jpVar;
    }

    public final void a(int i, String str) {
        C1104f8.b(C0835h.f4046a, str, "fetcherPayloadResponse");
        C1203jp jpVar = this.a;
        C0828a.e(jpVar, C0828a.f(jpVar));
    }

    public final void b(String str) {
        C1203jp jpVar = this.a;
        if (str != null) {
            try {
                C1104f8.b(C0835h.f4046a, str, "fetcherPayloadResponse");
                Object nextValue = new JSONTokener(str).nextValue();
                if (nextValue instanceof JSONObject) {
                    x.p(jpVar, new JSONObject(str));
                } else if (nextValue instanceof JSONArray) {
                    JSONArray jSONArray = new JSONArray(str);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("", jSONArray);
                    x.p(jpVar, jSONObject);
                }
            } catch (JSONException e) {
                H.r(C0835h.f4046a, e.toString(), "NotificationEventManager", "processPayload");
                C0828a.e(jpVar, C0828a.f(jpVar));
            }
        }
    }
}
