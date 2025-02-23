package com.momagic;

import android.annotation.SuppressLint;
import com.momagic.B;
import org.json.JSONArray;

/* compiled from: TargetActivity */
public final class G extends B.b {
    public final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ String f4017a;

    public G(String str) {
        this.f4017a = str;
    }

    public final void a(int i, String str) {
        H.A(C0835h.f4046a, "iz_mClick", this.f4017a);
    }

    @SuppressLint({"NewApi"})
    public final void b(String str) {
        int i;
        C1139gq c = C1139gq.c(C0835h.f4046a);
        if (c.e("iz_mediation_records").isEmpty() || (i = this.a) < 0) {
            c.h("MEDIATIONCLICKDATA", "");
            TargetActivity.r = "";
            return;
        }
        try {
            new JSONArray(c.e("iz_mediation_records")).remove(i);
            c.h("iz_mediation_records", (String) null);
        } catch (Exception e) {
            H.r(C0835h.f4046a, e.toString(), "TargetActivity", "callMediationClicks");
        }
        c.h("MEDIATIONCLICKDATA", "");
    }
}
