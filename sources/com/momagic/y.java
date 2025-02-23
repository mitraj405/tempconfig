package com.momagic;

import com.momagic.B;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: RestClient */
public final class y implements Runnable {
    public final /* synthetic */ B.b a;
    public final /* synthetic */ String c;

    public y(B.b bVar, String str) {
        this.c = str;
        this.a = bVar;
    }

    public final void run() {
        B.b(this.c, (String) null, (Map<String, String>) null, (JSONObject) null, this.a, 60000);
    }
}
