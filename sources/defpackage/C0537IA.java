package defpackage;

import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* renamed from: IA  reason: default package and case insensitive filesystem */
/* compiled from: Sequences.kt */
public final class C0537IA<T, R> implements C0810bw<R> {
    public final C0810bw<T> a;

    /* renamed from: a  reason: collision with other field name */
    public final Function1<T, R> f3661a;

    /* renamed from: IA$a */
    /* compiled from: Sequences.kt */
    public static final class a implements Iterator<R> {
        public final /* synthetic */ C0537IA<T, R> a;

        /* renamed from: a  reason: collision with other field name */
        public final Iterator<T> f3662a;

        public a(C0537IA<T, R> ia) {
            this.a = ia;
            this.f3662a = ia.a.iterator();
        }

        public final boolean hasNext() {
            return this.f3662a.hasNext();
        }

        public final R next() {
            return this.a.f3661a.invoke(this.f3662a.next());
        }

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C0537IA(H8 h8, C1312oy oyVar) {
        this.a = h8;
        this.f3661a = oyVar;
    }

    public final Iterator<R> iterator() {
        return new a(this);
    }
}
