package com.momagic;

import com.google.firebase.perf.FirebasePerformance;
import com.momagic.B;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: RestClient */
public final class A implements Runnable {
    public final /* synthetic */ B.b a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Map f3998a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ JSONObject f3999a;
    public final /* synthetic */ String c;

    public A(String str, HashMap hashMap, JSONObject jSONObject, B.b bVar) {
        this.c = str;
        this.f3998a = hashMap;
        this.f3999a = jSONObject;
        this.a = bVar;
    }

    public final void run() {
        B.b(this.c, FirebasePerformance.HttpMethod.POST, this.f3998a, this.f3999a, this.a, 60000);
    }
}
