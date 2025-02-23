package kotlin.coroutines;

import defpackage.C1171i7;
import in.juspay.hyper.constants.LogCategory;
import kotlin.jvm.functions.Function2;

/* compiled from: CoroutineContext.kt */
public interface CoroutineContext {

    /* compiled from: CoroutineContext.kt */
    public static final class a {

        /* renamed from: kotlin.coroutines.CoroutineContext$a$a  reason: collision with other inner class name */
        /* compiled from: CoroutineContext.kt */
        public static final class C0073a extends C0595Mh implements Function2<CoroutineContext, b, CoroutineContext> {
            public static final C0073a a = new C0073a();

            public C0073a() {
                super(2);
            }

            public final Object invoke(Object obj, Object obj2) {
                B5 b5;
                CoroutineContext coroutineContext = (CoroutineContext) obj;
                b bVar = (b) obj2;
                C1177ig.f(coroutineContext, "acc");
                C1177ig.f(bVar, "element");
                CoroutineContext l = coroutineContext.l(bVar.Z());
                C1440va vaVar = C1440va.a;
                if (l == vaVar) {
                    return bVar;
                }
                int i = C1171i7.a;
                C1171i7.a aVar = C1171i7.a.a;
                C1171i7 i7Var = (C1171i7) l.b(aVar);
                if (i7Var == null) {
                    b5 = new B5(bVar, l);
                } else {
                    CoroutineContext l2 = l.l(aVar);
                    if (l2 == vaVar) {
                        return new B5(i7Var, bVar);
                    }
                    b5 = new B5(i7Var, new B5(bVar, l2));
                }
                return b5;
            }
        }

        public static CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
            C1177ig.f(coroutineContext2, LogCategory.CONTEXT);
            if (coroutineContext2 == C1440va.a) {
                return coroutineContext;
            }
            return (CoroutineContext) coroutineContext2.C(coroutineContext, C0073a.a);
        }
    }

    /* compiled from: CoroutineContext.kt */
    public interface b extends CoroutineContext {

        /* compiled from: CoroutineContext.kt */
        public static final class a {
            public static <E extends b> E a(b bVar, c<E> cVar) {
                C1177ig.f(cVar, "key");
                if (C1177ig.a(bVar.Z(), cVar)) {
                    return bVar;
                }
                return null;
            }

            public static CoroutineContext b(b bVar, c<?> cVar) {
                C1177ig.f(cVar, "key");
                if (C1177ig.a(bVar.Z(), cVar)) {
                    return C1440va.a;
                }
                return bVar;
            }
        }

        c<?> Z();

        <E extends b> E b(c<E> cVar);
    }

    /* compiled from: CoroutineContext.kt */
    public interface c<E extends b> {
    }

    <R> R C(R r, Function2<? super R, ? super b, ? extends R> function2);

    <E extends b> E b(c<E> cVar);

    CoroutineContext j(CoroutineContext coroutineContext);

    CoroutineContext l(c<?> cVar);
}
