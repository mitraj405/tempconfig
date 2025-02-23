package defpackage;

import java.nio.charset.Charset;

/* renamed from: Y4  reason: default package */
/* compiled from: Charsets.kt */
public final class Y4 {
    public static final Charset a;

    static {
        Charset forName = Charset.forName("UTF-8");
        C1177ig.e(forName, "forName(\"UTF-8\")");
        a = forName;
        C1177ig.e(Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        C1177ig.e(Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        C1177ig.e(Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        C1177ig.e(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        C1177ig.e(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }
}
