package defpackage;

import android.icu.util.ULocale;
import java.util.Locale;

/* renamed from: gf  reason: default package */
/* compiled from: ICUCompat */
public final class gf {
    public static ULocale a(Object obj) {
        return ULocale.addLikelySubtags((ULocale) obj);
    }

    public static ULocale b(Locale locale) {
        return ULocale.forLocale(locale);
    }

    public static String c(Object obj) {
        return ((ULocale) obj).getScript();
    }
}
