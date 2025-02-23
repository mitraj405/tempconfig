package com.momagic;

import android.annotation.SuppressLint;
import com.momagic.B;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.momagic.d  reason: case insensitive filesystem */
/* compiled from: AdMediation */
public final class C0831d extends B.b {
    public final /* synthetic */ int a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ JSONObject f4040a;

    public C0831d(int i, JSONObject jSONObject) {
        this.a = i;
        this.f4040a = jSONObject;
    }

    public final void a(int i, String str) {
        H.A(C0835h.f4046a, "iz_impression", this.f4040a.toString());
    }

    @SuppressLint({"NewApi"})
    public final void b(String str) {
        int i;
        C1139gq c = C1139gq.c(C0835h.f4046a);
        if (!c.e("iz_mediation_records").isEmpty() && (i = this.a) >= 0) {
            try {
                new JSONArray(c.e("iz_mediation_records")).remove(i);
                c.h("iz_mediation_records", (String) null);
            } catch (Exception e) {
                C1104f8.b(C0835h.f4046a, e.toString(), "[Log.e]-> ");
            }
        }
    }
}
