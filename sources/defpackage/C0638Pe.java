package defpackage;

import java.util.LinkedHashMap;

/* renamed from: Pe  reason: default package and case insensitive filesystem */
/* compiled from: Headers */
public final class C0638Pe {
    public String a;

    /* renamed from: a  reason: collision with other field name */
    public final LinkedHashMap f3754a = new LinkedHashMap();

    /* renamed from: a  reason: collision with other field name */
    public final nh f3755a = new nh(3);
    public String b;

    public final String a(String str) {
        return (String) this.f3754a.get(str);
    }

    public final void b(Object obj, String str) {
        this.f3754a.put(str, obj);
        this.a = null;
        this.b = null;
    }
}
