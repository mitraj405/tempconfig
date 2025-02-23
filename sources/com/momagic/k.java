package com.momagic;

import com.momagic.B;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* compiled from: DATB */
public final class k extends B.b {
    public final /* synthetic */ C1139gq a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f4057a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ List f4058a;

    public k(String str, C1139gq gqVar, ArrayList arrayList) {
        this.f4057a = str;
        this.a = gqVar;
        this.f4058a = arrayList;
    }

    public final void a(int i, String str) {
        JSONArray jSONArray = new JSONArray(this.f4058a);
        String str2 = this.f4057a;
        boolean equalsIgnoreCase = str2.equalsIgnoreCase("add_topic");
        C1139gq gqVar = this.a;
        if (equalsIgnoreCase) {
            gqVar.h("iz_add_topic_offline", jSONArray.toString());
        } else if (str2.equalsIgnoreCase("remove_topic")) {
            gqVar.h("iz_remove_topic_offline", jSONArray.toString());
        }
    }

    public final void b(String str) {
        String str2 = this.f4057a;
        boolean equalsIgnoreCase = str2.equalsIgnoreCase("add_topic");
        C1139gq gqVar = this.a;
        if (equalsIgnoreCase) {
            gqVar.h("iz_add_topic_offline", (String) null);
        } else if (str2.equalsIgnoreCase("remove_topic")) {
            gqVar.h("iz_remove_topic_offline", (String) null);
        }
    }
}
