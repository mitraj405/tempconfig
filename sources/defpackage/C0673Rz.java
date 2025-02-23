package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* renamed from: Rz  reason: default package and case insensitive filesystem */
/* compiled from: ThreadContext.kt */
public final class C0673Rz {
    public static final a a = a.a;

    /* renamed from: a  reason: collision with other field name */
    public static final b f3786a = b.a;

    /* renamed from: a  reason: collision with other field name */
    public static final c f3787a = c.a;

    /* renamed from: a  reason: collision with other field name */
    public static final C0422zD f3788a = new C0422zD("NO_THREAD_ELEMENTS", 2);

    /* renamed from: Rz$a */
    /* compiled from: ThreadContext.kt */
    public static final class a extends C0595Mh implements Function2<Object, CoroutineContext.b, Object> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        public final Object invoke(Object obj, Object obj2) {
            Integer num;
            int i;
            CoroutineContext.b bVar = (CoroutineContext.b) obj2;
            if (!(bVar instanceof C0659Qz)) {
                return obj;
            }
            if (obj instanceof Integer) {
                num = (Integer) obj;
            } else {
                num = null;
            }
            if (num != null) {
                i = num.intValue();
            } else {
                i = 1;
            }
            if (i == 0) {
                return bVar;
            }
            return Integer.valueOf(i + 1);
        }
    }

    /* renamed from: Rz$b */
    /* compiled from: ThreadContext.kt */
    public static final class b extends C0595Mh implements Function2<C0659Qz<?>, CoroutineContext.b, C0659Qz<?>> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        public final Object invoke(Object obj, Object obj2) {
            C0659Qz qz = (C0659Qz) obj;
            CoroutineContext.b bVar = (CoroutineContext.b) obj2;
            if (qz != null) {
                return qz;
            }
            if (bVar instanceof C0659Qz) {
                return (C0659Qz) bVar;
            }
            return null;
        }
    }

    /* renamed from: Rz$c */
    /* compiled from: ThreadContext.kt */
    public static final class c extends C0595Mh implements Function2<Vz, CoroutineContext.b, Vz> {
        public static final c a = new c();

        public c() {
            super(2);
        }

        public final Object invoke(Object obj, Object obj2) {
            Vz vz = (Vz) obj;
            CoroutineContext.b bVar = (CoroutineContext.b) obj2;
            if (bVar instanceof C0659Qz) {
                C0659Qz<Object> qz = (C0659Qz) bVar;
                String G = qz.G(vz.f3820a);
                int i = vz.a;
                vz.f3822a[i] = G;
                vz.a = i + 1;
                vz.f3821a[i] = qz;
            }
            return vz;
        }
    }

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj != f3788a) {
            if (obj instanceof Vz) {
                Vz vz = (Vz) obj;
                C0659Qz<Object>[] qzArr = vz.f3821a;
                int length = qzArr.length - 1;
                if (length >= 0) {
                    while (true) {
                        int i = length - 1;
                        C0659Qz<Object> qz = qzArr[length];
                        C1177ig.c(qz);
                        qz.m(vz.f3822a[length]);
                        if (i >= 0) {
                            length = i;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                Object C = coroutineContext.C(null, f3786a);
                C1177ig.d(C, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
                ((C0659Qz) C).m(obj);
            }
        }
    }

    public static final Object b(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = coroutineContext.C(0, a);
            C1177ig.c(obj);
        }
        if (obj == 0) {
            return f3788a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.C(new Vz(coroutineContext, ((Number) obj).intValue()), f3787a);
        }
        return ((C0659Qz) obj).G(coroutineContext);
    }
}
