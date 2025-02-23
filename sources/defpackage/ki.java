package defpackage;

import android.os.LocaleList;
import java.util.Locale;

/* renamed from: ki  reason: default package */
/* compiled from: LocaleListCompat */
public final class ki {
    public static final ki a = new ki(new mi(b.a(new Locale[0])));

    /* renamed from: a  reason: collision with other field name */
    public final li f3053a;

    /* renamed from: ki$a */
    /* compiled from: LocaleListCompat */
    public static class a {
        public static final Locale[] a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean b(Locale locale, Locale locale2) {
            boolean z;
            boolean z2;
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage())) {
                return false;
            }
            Locale[] localeArr = a;
            int length = localeArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (localeArr[i].equals(locale)) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                int length2 = localeArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length2) {
                        z2 = false;
                        break;
                    } else if (localeArr[i2].equals(locale2)) {
                        z2 = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z2) {
                    String c = gf.c(gf.a(gf.b(locale)));
                    if (!c.isEmpty()) {
                        return c.equals(gf.c(gf.a(gf.b(locale2))));
                    }
                    String country = locale.getCountry();
                    if (country.isEmpty() || country.equals(locale2.getCountry())) {
                        return true;
                    }
                    return false;
                }
            }
            return false;
        }
    }

    /* renamed from: ki$b */
    /* compiled from: LocaleListCompat */
    public static class b {
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    public ki(mi miVar) {
        this.f3053a = miVar;
    }

    public static ki a(String str) {
        if (str == null || str.isEmpty()) {
            return a;
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            localeArr[i] = a.a(split[i]);
        }
        return new ki(new mi(b.a(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ki) {
            if (this.f3053a.equals(((ki) obj).f3053a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f3053a.hashCode();
    }

    public final String toString() {
        return this.f3053a.toString();
    }
}
