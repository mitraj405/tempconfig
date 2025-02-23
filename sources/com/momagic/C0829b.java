package com.momagic;

import com.momagic.B;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* renamed from: com.momagic.b  reason: case insensitive filesystem */
/* compiled from: AdMediation */
public final class C0829b extends B.b {
    public final /* synthetic */ long a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C1203jp f4039a;

    public C0829b(C1203jp jpVar, long j) {
        this.f4039a = jpVar;
        this.a = j;
    }

    public final void a(int i, String str) {
        C1203jp jpVar = this.f4039a;
        C0828a.e(jpVar, C0828a.f(jpVar));
    }

    public final void b(String str) {
        long j = this.a;
        C1203jp jpVar = this.f4039a;
        if (str != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                Object nextValue = new JSONTokener(str).nextValue();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("b", Double.parseDouble(jpVar.x));
                jSONObject.put("rb", Double.parseDouble(jpVar.D));
                jSONObject.put("a", jpVar.F);
                long j2 = currentTimeMillis - j;
                jSONObject.put("t", j2);
                C0828a.f.add(jSONObject);
                if (nextValue instanceof JSONObject) {
                    JSONObject jSONObject2 = new JSONObject(str);
                    jpVar.f5523a = j2;
                    C0828a.n(jpVar, jSONObject2);
                } else if (nextValue instanceof JSONArray) {
                    JSONArray jSONArray = new JSONArray(str);
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("", jSONArray);
                    jpVar.f5523a = j2;
                    C0828a.n(jpVar, jSONObject3);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
