package defpackage;

import defpackage.C1156hg;
import java.util.List;

/* renamed from: b  reason: default package and case insensitive filesystem */
/* compiled from: -InterceptorChain.kt */
public final class C0791b implements C1156hg.a {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final Ef f3907a;

    /* renamed from: a  reason: collision with other field name */
    public final List<C1156hg> f3908a;

    public C0791b(List<? extends C1156hg> list, int i, Ef ef) {
        C1177ig.g(list, "interceptors");
        C1177ig.g(ef, "request");
        this.f3908a = list;
        this.a = i;
        this.f3907a = ef;
    }

    public final Ff a(Ef ef) {
        C1177ig.g(ef, "request");
        List<C1156hg> list = this.f3908a;
        int size = list.size();
        int i = this.a;
        if (i < size) {
            return list.get(i).intercept(new C0791b(list, i + 1, ef));
        }
        throw new AssertionError("no interceptors added to the chain");
    }

    public final Ef b() {
        return this.f3907a;
    }
}
