package defpackage;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

/* renamed from: r3  reason: default package and case insensitive filesystem */
/* compiled from: BufferedChannel.kt */
public final class C1361r3 {
    public static final int a = C1354qp.B0("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12);

    /* renamed from: a  reason: collision with other field name */
    public static final W4<Object> f6939a = new W4(-1, (W4) null, (C1296o3) null, 0);

    /* renamed from: a  reason: collision with other field name */
    public static final C0422zD f6940a = new C0422zD("BUFFERED", 2);
    public static final int b = C1354qp.B0("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12);

    /* renamed from: b  reason: collision with other field name */
    public static final C0422zD f6941b = new C0422zD("SHOULD_BUFFER", 2);
    public static final C0422zD c = new C0422zD("S_RESUMING_BY_RCV", 2);
    public static final C0422zD d = new C0422zD("RESUMING_BY_EB", 2);
    public static final C0422zD e = new C0422zD("POISONED", 2);
    public static final C0422zD f = new C0422zD("DONE_RCV", 2);
    public static final C0422zD g = new C0422zD("INTERRUPTED_SEND", 2);
    public static final C0422zD h = new C0422zD("INTERRUPTED_RCV", 2);
    public static final C0422zD i = new C0422zD("CHANNEL_CLOSED", 2);
    public static final C0422zD j = new C0422zD("SUSPEND", 2);
    public static final C0422zD k = new C0422zD("SUSPEND_NO_WAITER", 2);
    public static final C0422zD l = new C0422zD("FAILED", 2);
    public static final C0422zD m = new C0422zD("NO_RECEIVE_RESULT", 2);
    public static final C0422zD n = new C0422zD("CLOSE_HANDLER_CLOSED", 2);
    public static final C0422zD o = new C0422zD("CLOSE_HANDLER_INVOKED", 2);
    public static final C0422zD p = new C0422zD("NO_CLOSE_CAUSE", 2);

    public static final <T> boolean a(CancellableContinuation<? super T> cancellableContinuation, T t, Function1<? super Throwable, Unit> function1) {
        C0422zD g2 = cancellableContinuation.g(t, function1);
        if (g2 == null) {
            return false;
        }
        cancellableContinuation.k(g2);
        return true;
    }
}
