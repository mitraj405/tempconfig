package com.momagic;

import com.momagic.B;
import org.json.JSONObject;

/* renamed from: com.momagic.c  reason: case insensitive filesystem */
/* compiled from: AdMediation */
public final class C0830c extends B.b {
    public final /* synthetic */ C1203jp a;

    public C0830c(C1203jp jpVar) {
        this.a = jpVar;
    }

    public final void b(String str) {
        C1203jp jpVar = this.a;
        try {
            JSONObject jSONObject = new JSONObject(str);
            jpVar.f5532f = jSONObject.optString("t");
            jpVar.f5534h = jSONObject.optString("m");
            jpVar.f5531e = jSONObject.optString("ln");
            jpVar.f5535i = jSONObject.optString("i");
            jpVar.f5538l = jSONObject.optString("bi");
            jpVar.n = jSONObject.optString("l1");
            jpVar.f5530d = jpVar.f5530d;
            x.o(C0835h.f4046a, jpVar);
            C0828a.a(jpVar);
        } catch (Exception e) {
            H.w(C0835h.f4046a, e.toString(), "AdMediation", "ShowFallBackResponse");
        }
    }

    public final void a(int i, String str) {
    }
}
