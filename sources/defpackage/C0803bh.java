package defpackage;

import java.io.IOException;
import java.io.StringWriter;
import java.security.Key;
import java.util.Collections;
import java.util.LinkedHashMap;

/* renamed from: bh  reason: default package and case insensitive filesystem */
/* compiled from: JsonWebStructure */
public abstract class C0803bh {
    public static final Nq b = new Nq();
    public final Nq a;

    /* renamed from: a  reason: collision with other field name */
    public final C0638Pe f3914a = new C0638Pe();

    /* renamed from: a  reason: collision with other field name */
    public Key f3915a;

    /* renamed from: a  reason: collision with other field name */
    public final nh f3916a = new nh(3);

    /* renamed from: a  reason: collision with other field name */
    public C1315p0 f3917a = C1315p0.a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3918a = true;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f3919a;

    public C0803bh() {
        Collections.emptySet();
        this.a = b;
    }

    public final String a() {
        C0638Pe pe = this.f3914a;
        if (pe.b == null) {
            if (pe.a == null) {
                LinkedHashMap linkedHashMap = pe.f3754a;
                StringWriter stringWriter = new StringWriter();
                try {
                    C1354qp.O0(linkedHashMap, stringWriter);
                    pe.a = stringWriter.toString();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            String str = pe.a;
            nh nhVar = pe.f3755a;
            nhVar.getClass();
            pe.b = nhVar.e(r1.u(str, "UTF-8"));
        }
        return pe.b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        C0638Pe pe = this.f3914a;
        if (pe.a == null) {
            LinkedHashMap linkedHashMap = pe.f3754a;
            StringWriter stringWriter = new StringWriter();
            try {
                C1354qp.O0(linkedHashMap, stringWriter);
                pe.a = stringWriter.toString();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        sb.append(pe.a);
        return sb.toString();
    }
}
