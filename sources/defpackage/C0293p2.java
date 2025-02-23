package defpackage;

import java.util.Arrays;
import java.util.List;

/* renamed from: p2  reason: default package and case insensitive filesystem */
/* compiled from: BaseAnimatableValue */
public abstract class C0293p2<V, O> implements R0<V, O> {
    public final List<Bh<V>> a;

    public C0293p2(List<Bh<V>> list) {
        this.a = list;
    }

    public final boolean a() {
        List<Bh<V>> list = this.a;
        if (list.isEmpty()) {
            return true;
        }
        if (list.size() != 1 || !list.get(0).c()) {
            return false;
        }
        return true;
    }

    public final List<Bh<V>> c() {
        return this.a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        List<Bh<V>> list = this.a;
        if (!list.isEmpty()) {
            sb.append("values=");
            sb.append(Arrays.toString(list.toArray()));
        }
        return sb.toString();
    }
}
