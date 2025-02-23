package com.momagic;

import com.momagic.B;
import com.momagic.C0828a;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: RestClient */
public final class z implements Runnable {
    public final /* synthetic */ B.b a;
    public final /* synthetic */ int c;

    /* renamed from: c  reason: collision with other field name */
    public final /* synthetic */ String f4066c;

    public z(int i, C0828a.b bVar, String str) {
        this.c = i;
        this.f4066c = str;
        this.a = bVar;
    }

    public final void run() {
        int i = this.c;
        if (i == 0) {
            B.b(this.f4066c, (String) null, (Map<String, String>) null, (JSONObject) null, this.a, 60000);
        } else {
            B.b(this.f4066c, (String) null, (Map<String, String>) null, (JSONObject) null, this.a, i);
        }
    }
}
