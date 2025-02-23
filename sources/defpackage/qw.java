package defpackage;

import java.util.Arrays;
import java.util.List;

/* renamed from: qw  reason: default package */
/* compiled from: ShapeGroup */
public final class qw implements Z6 {
    public final String a;

    /* renamed from: a  reason: collision with other field name */
    public final List<Z6> f3205a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3206a;

    public qw(List list, String str, boolean z) {
        this.a = str;
        this.f3205a = list;
        this.f3206a = z;
    }

    public final V6 a(Ej ej, C0359v2 v2Var) {
        return new Y6(ej, v2Var, this);
    }

    public final String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.f3205a.toArray()) + '}';
    }
}
