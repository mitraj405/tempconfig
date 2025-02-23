package defpackage;

import android.os.Bundle;
import android.util.Base64;
import cris.org.in.ima.IrctcImaApplication;
import java.security.KeyFactory;
import java.security.interfaces.ECPublicKey;
import java.security.spec.X509EncodedKeySpec;
import rx.Subscriber;

/* renamed from: ke  reason: default package and case insensitive filesystem */
/* compiled from: GenrateECKey */
public final class C1217ke extends Subscriber<String> {
    public final /* synthetic */ C1239le a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Subscriber f5545a;

    public C1217ke(C1239le leVar, Subscriber subscriber) {
        this.a = leVar;
        this.f5545a = subscriber;
    }

    public final void onCompleted() {
        C1239le.a = this.a;
    }

    public final void onError(Throwable th) {
        C1239le.a = null;
        new Zu("errorgeneckey").c(C1181iv.a()).a(E0.a()).b(this.f5545a);
    }

    public final void onNext(Object obj) {
        String str = (String) obj;
        int i = C1507z0.a;
        Bundle bundle = new Bundle();
        bundle.putString("login_method", "final");
        IrctcImaApplication.f4146a.logEvent("logins", bundle);
        this.a.getClass();
        try {
            C1131ga gaVar = new C1131ga((ECPublicKey) KeyFactory.getInstance("EC", "SC").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2))));
            gaVar.d = "serveryek";
            C1228kw.a().b = gaVar;
        } catch (Exception unused) {
        }
        new Zu("verifyuser").c(C1181iv.a()).a(E0.a()).b(this.f5545a);
    }
}
