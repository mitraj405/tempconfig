package defpackage;

import java.io.Serializable;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* renamed from: B5  reason: default package */
/* compiled from: CoroutineContextImpl.kt */
public final class B5 implements CoroutineContext, Serializable {
    public final CoroutineContext.b a;

    /* renamed from: a  reason: collision with other field name */
    public final CoroutineContext f3527a;

    /* renamed from: B5$a */
    /* compiled from: CoroutineContextImpl.kt */
    public static final class a implements Serializable {
        private static final long serialVersionUID = 0;
        public final CoroutineContext[] a;

        public a(CoroutineContext[] coroutineContextArr) {
            this.a = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext coroutineContext = C1440va.a;
            for (CoroutineContext j : this.a) {
                coroutineContext = coroutineContext.j(j);
            }
            return coroutineContext;
        }
    }

    /* renamed from: B5$b */
    /* compiled from: CoroutineContextImpl.kt */
    public static final class b extends C0595Mh implements Function2<String, CoroutineContext.b, String> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        public final Object invoke(Object obj, Object obj2) {
            boolean z;
            String str = (String) obj;
            CoroutineContext.b bVar = (CoroutineContext.b) obj2;
            C1177ig.f(str, "acc");
            C1177ig.f(bVar, "element");
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    /* renamed from: B5$c */
    /* compiled from: CoroutineContextImpl.kt */
    public static final class c extends C0595Mh implements Function2<Unit, CoroutineContext.b, Unit> {
        public final /* synthetic */ C0558Js a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ CoroutineContext[] f3528a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(CoroutineContext[] coroutineContextArr, C0558Js js) {
            super(2);
            this.f3528a = coroutineContextArr;
            this.a = js;
        }

        public final Object invoke(Object obj, Object obj2) {
            CoroutineContext.b bVar = (CoroutineContext.b) obj2;
            C1177ig.f((Unit) obj, "<anonymous parameter 0>");
            C1177ig.f(bVar, "element");
            C0558Js js = this.a;
            int i = js.c;
            js.c = i + 1;
            this.f3528a[i] = bVar;
            return Unit.a;
        }
    }

    public B5(CoroutineContext.b bVar, CoroutineContext coroutineContext) {
        C1177ig.f(coroutineContext, "left");
        C1177ig.f(bVar, "element");
        this.f3527a = coroutineContext;
        this.a = bVar;
    }

    private final Object writeReplace() {
        boolean z;
        int d = d();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[d];
        C0558Js js = new C0558Js();
        C(Unit.a, new c(coroutineContextArr, js));
        if (js.c == d) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return new a(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final <R> R C(R r, Function2<? super R, ? super CoroutineContext.b, ? extends R> function2) {
        C1177ig.f(function2, "operation");
        return function2.invoke(this.f3527a.C(r, function2), this.a);
    }

    public final <E extends CoroutineContext.b> E b(CoroutineContext.c<E> cVar) {
        C1177ig.f(cVar, "key");
        B5 b5 = this;
        while (true) {
            E b2 = b5.a.b(cVar);
            if (b2 != null) {
                return b2;
            }
            CoroutineContext coroutineContext = b5.f3527a;
            if (!(coroutineContext instanceof B5)) {
                return coroutineContext.b(cVar);
            }
            b5 = (B5) coroutineContext;
        }
    }

    public final int d() {
        int i = 2;
        B5 b5 = this;
        while (true) {
            CoroutineContext coroutineContext = b5.f3527a;
            if (coroutineContext instanceof B5) {
                b5 = (B5) coroutineContext;
            } else {
                b5 = null;
            }
            if (b5 == null) {
                return i;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            if (!(obj instanceof B5)) {
                return false;
            }
            B5 b5 = (B5) obj;
            if (b5.d() != d()) {
                return false;
            }
            B5 b52 = this;
            while (true) {
                CoroutineContext.b bVar = b52.a;
                if (C1177ig.a(b5.b(bVar.Z()), bVar)) {
                    CoroutineContext coroutineContext = b52.f3527a;
                    if (!(coroutineContext instanceof B5)) {
                        C1177ig.d(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        CoroutineContext.b bVar2 = (CoroutineContext.b) coroutineContext;
                        z = C1177ig.a(b5.b(bVar2.Z()), bVar2);
                        break;
                    }
                    b52 = (B5) coroutineContext;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                return true;
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.a.hashCode() + this.f3527a.hashCode();
    }

    public final CoroutineContext j(CoroutineContext coroutineContext) {
        return CoroutineContext.a.a(this, coroutineContext);
    }

    public final CoroutineContext l(CoroutineContext.c<?> cVar) {
        C1177ig.f(cVar, "key");
        CoroutineContext.b bVar = this.a;
        CoroutineContext.b b2 = bVar.b(cVar);
        CoroutineContext coroutineContext = this.f3527a;
        if (b2 != null) {
            return coroutineContext;
        }
        CoroutineContext l = coroutineContext.l(cVar);
        if (l == coroutineContext) {
            return this;
        }
        if (l == C1440va.a) {
            return bVar;
        }
        return new B5(bVar, l);
    }

    public final String toString() {
        return "[" + ((String) C("", b.a)) + ']';
    }
}
