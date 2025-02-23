package defpackage;

import android.os.LocaleList;
import java.util.Locale;

/* renamed from: mi  reason: default package */
/* compiled from: LocaleListPlatformWrapper */
public final class mi implements li {
    public final LocaleList a;

    public mi(Object obj) {
        this.a = (LocaleList) obj;
    }

    public final Object a() {
        return this.a;
    }

    public final Locale b(int i) {
        return this.a.get(i);
    }

    public final String c() {
        return this.a.toLanguageTags();
    }

    public final boolean equals(Object obj) {
        return this.a.equals(((li) obj).a());
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    public final int size() {
        return this.a.size();
    }

    public final String toString() {
        return this.a.toString();
    }
}
