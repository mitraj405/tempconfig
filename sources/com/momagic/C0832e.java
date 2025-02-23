package com.momagic;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.momagic.C0834g;

/* renamed from: com.momagic.e  reason: case insensitive filesystem */
/* compiled from: AdvertisingIdClient */
public final class C0832e implements Runnable {
    public final /* synthetic */ Context a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C0834g f4041a;

    public C0832e(C0834g gVar, Context context) {
        this.f4041a = gVar;
        this.a = context;
    }

    public final void run() {
        C0834g.c cVar;
        Context context = this.a;
        C0834g gVar = this.f4041a;
        gVar.getClass();
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            cVar = new C0834g.c();
            try {
                if (context.bindService(intent, cVar, 1)) {
                    C0834g.d dVar = new C0834g.d(cVar.a());
                    String b = dVar.b();
                    if (TextUtils.isEmpty(b)) {
                        gVar.a(new Exception("Advertising ID extraction Error: ID Not available"));
                    } else {
                        dVar.c();
                        gVar.f4043a.post(new C0833f(gVar, new C0834g.b(b)));
                    }
                }
            } catch (Exception e) {
                e.toString();
                gVar.a(e);
            }
            context.unbindService(cVar);
        } catch (Exception e2) {
            e2.toString();
            gVar.a(e2);
        } catch (Throwable th) {
            context.unbindService(cVar);
            throw th;
        }
    }
}
