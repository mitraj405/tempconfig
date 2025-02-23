package defpackage;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import cris.org.in.ima.IrctcImaApplication;

/* renamed from: tg  reason: default package and case insensitive filesystem */
/* compiled from: IrctcImaApplication */
public final class C1405tg implements Runnable {
    public final void run() {
        String str;
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(IrctcImaApplication.a);
            if (advertisingIdInfo != null) {
                str = advertisingIdInfo.getId();
            } else {
                str = null;
            }
            C0535I5.j = str;
        } catch (Exception e) {
            FirebaseAnalytics firebaseAnalytics = IrctcImaApplication.f4146a;
            e.getMessage();
        }
    }
}
