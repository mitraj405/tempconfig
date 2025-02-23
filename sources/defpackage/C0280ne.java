package defpackage;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/* renamed from: ne  reason: default package and case insensitive filesystem */
/* compiled from: GetTopicsResponse.kt */
public final class C0280ne {
    public final List<C0254lA> a;

    public C0280ne(List<C0254lA> list) {
        C1177ig.f(list, "topics");
        this.a = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0280ne)) {
            return false;
        }
        List<C0254lA> list = this.a;
        C0280ne neVar = (C0280ne) obj;
        if (list.size() != neVar.a.size()) {
            return false;
        }
        return C1177ig.a(new HashSet(list), new HashSet(neVar.a));
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{this.a});
    }

    public final String toString() {
        return "Topics=" + this.a;
    }
}
