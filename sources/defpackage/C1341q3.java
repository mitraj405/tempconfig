package defpackage;

import kotlin.jvm.functions.Function2;

/* renamed from: q3  reason: default package and case insensitive filesystem */
/* compiled from: BufferedChannel.kt */
public final /* synthetic */ class C1341q3 extends C1068de implements Function2<Long, W4<Object>, W4<Object>> {
    public static final C1341q3 a = new C1341q3();

    public C1341q3() {
        super(2, C1361r3.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
    }

    public final Object invoke(Object obj, Object obj2) {
        long longValue = ((Number) obj).longValue();
        W4 w4 = (W4) obj2;
        W4<Object> w42 = C1361r3.f6939a;
        C1296o3<E> o3Var = w4.f3824a;
        C1177ig.c(o3Var);
        return new W4(longValue, w4, o3Var, 0);
    }
}
