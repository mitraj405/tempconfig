package defpackage;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/* renamed from: Eg  reason: default package */
/* compiled from: JSONObject */
public final class Eg extends HashMap implements Map, Dg, C0520Gg {
    private static final long serialVersionUID = -503443796854799292L;

    public static void c(Map map, StringWriter stringWriter) throws IOException {
        if (map == null) {
            stringWriter.write("null");
            return;
        }
        stringWriter.write(123);
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                stringWriter.write(44);
            }
            stringWriter.write(34);
            stringWriter.write(C1354qp.I(String.valueOf(entry.getKey())));
            stringWriter.write(34);
            stringWriter.write(58);
            C1354qp.O0(entry.getValue(), stringWriter);
        }
        stringWriter.write(125);
    }
}
