package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: Vg  reason: default package */
/* compiled from: JsonUtil */
public final class Vg {

    /* renamed from: Vg$a */
    /* compiled from: JsonUtil */
    public class a {
    }

    /* renamed from: Vg$b */
    /* compiled from: JsonUtil */
    public static class b extends LinkedHashMap<String, Object> {
        public final Object put(Object obj, Object obj2) {
            String str = (String) obj;
            if (!containsKey(str)) {
                return super.put(str, obj2);
            }
            throw new IllegalArgumentException(lf.j("An entry for '", str, "' already exists. Names must be unique."));
        }
    }

    static {
        new a();
    }

    public static Map<String, Object> a(String str) throws C0626Og {
        try {
            Object c = new Fg().c(str);
            if (c != null) {
                return (Map) c;
            }
            throw new C0626Og("Parsing returned null");
        } catch (Go | IllegalArgumentException e) {
            throw new C0626Og("Parsing error: " + e, e);
        } catch (ClassCastException e2) {
            throw new C0626Og("Expecting a JSON object at the root but " + e2, e2);
        }
    }
}
