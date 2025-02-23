package defpackage;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: Ku  reason: default package */
/* compiled from: SafeCollector.kt */
public final class Ku {
    public static final C0694Td<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> a;

    /* renamed from: Ku$a */
    /* compiled from: SafeCollector.kt */
    public /* synthetic */ class a extends C1068de implements C0694Td<FlowCollector<? super Object>, Object, Continuation<? super Unit>, Object> {
        public static final a a = new a();

        public a() {
            super(3, FlowCollector.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ((FlowCollector) obj).emit(obj2, (Continuation) obj3);
        }
    }

    static {
        a aVar = a.a;
        C1177ig.d(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        C0648QA.a(3, aVar);
        a = aVar;
    }
}
