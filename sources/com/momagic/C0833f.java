package com.momagic;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.momagic.C0834g;

/* renamed from: com.momagic.f  reason: case insensitive filesystem */
/* compiled from: AdvertisingIdClient */
public final class C0833f implements Runnable {
    public final /* synthetic */ C0834g.b a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C0834g f4042a;

    public C0833f(C0834g gVar, C0834g.b bVar) {
        this.f4042a = gVar;
        this.a = bVar;
    }

    public final void run() {
        C0834g.e eVar = this.f4042a.f4044a;
        if (eVar != null) {
            String str = this.a.a;
            C1139gq gqVar = ((l) eVar).a;
            gqVar.h("add", str);
            String e = gqVar.e("encryptedPid");
            Handler handler = new Handler(Looper.getMainLooper());
            Context context = C0835h.f4046a;
            handler.post(new C0618O7(str, e));
        }
    }
}
