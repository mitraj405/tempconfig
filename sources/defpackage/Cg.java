package defpackage;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;

/* renamed from: Cg  reason: default package */
/* compiled from: JSONArray */
public final class Cg extends ArrayList implements Dg, C0520Gg {
    public static final /* synthetic */ int c = 0;
    private static final long serialVersionUID = 3957988303675231981L;

    public static void c(Collection collection, StringWriter stringWriter) throws IOException {
        if (collection == null) {
            stringWriter.write("null");
            return;
        }
        stringWriter.write(91);
        boolean z = true;
        for (Object next : collection) {
            if (z) {
                z = false;
            } else {
                stringWriter.write(44);
            }
            if (next == null) {
                stringWriter.write("null");
            } else {
                C1354qp.O0(next, stringWriter);
            }
        }
        stringWriter.write(93);
    }
}
