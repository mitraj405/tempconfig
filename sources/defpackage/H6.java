package defpackage;

import android.content.res.Configuration;
import android.os.LocaleList;

/* renamed from: H6  reason: default package */
/* compiled from: ConfigurationCompat */
public final class H6 {
    public static LocaleList a(Configuration configuration) {
        return configuration.getLocales();
    }

    public static void b(Configuration configuration, ki kiVar) {
        configuration.setLocales((LocaleList) kiVar.f3053a.a());
    }
}
