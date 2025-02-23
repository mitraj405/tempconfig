package com.momagic;

import com.momagic.B;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: DATB */
public final class i extends B.b {
    public final /* synthetic */ C1139gq a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f4055a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ HashMap f4056a;

    public i(C1139gq gqVar, HashMap hashMap, String str) {
        this.a = gqVar;
        this.f4056a = hashMap;
        this.f4055a = str;
    }

    public final void a(int i, String str) {
        JSONObject jSONObject = new JSONObject(this.f4056a);
        C1139gq gqVar = this.a;
        gqVar.h("eventLocalDataEN", this.f4055a);
        gqVar.h("eventLocalDataEV", jSONObject.toString());
    }

    public final void b(String str) {
        C1139gq gqVar = this.a;
        gqVar.h("eventLocalDataEN", (String) null);
        gqVar.h("eventLocalDataEV", (String) null);
    }
}
