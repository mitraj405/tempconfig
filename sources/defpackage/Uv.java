package defpackage;

import kotlin.jvm.functions.Function2;

/* renamed from: Uv  reason: default package */
/* compiled from: Semaphore.kt */
public final /* synthetic */ class Uv extends C1068de implements Function2<Long, Zv, Zv> {
    public static final Uv a = new Uv();

    public Uv() {
        super(2, Yv.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    public final Object invoke(Object obj, Object obj2) {
        int i = Yv.a;
        return new Zv(((Number) obj).longValue(), (Zv) obj2, 0);
    }
}
