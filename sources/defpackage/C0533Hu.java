package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: Hu  reason: default package and case insensitive filesystem */
/* compiled from: RxThreadFactory */
public final class C0533Hu extends AtomicLong implements ThreadFactory {
    public static final a a = new a();
    private static final long serialVersionUID = -8841098858898482335L;
    public final String c;

    /* renamed from: Hu$a */
    /* compiled from: RxThreadFactory */
    public static class a implements ThreadFactory {
        public final Thread newThread(Runnable runnable) {
            throw new AssertionError("No threads allowed.");
        }
    }

    public C0533Hu(String str) {
        this.c = str;
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable, this.c + incrementAndGet());
        thread.setDaemon(true);
        return thread;
    }
}
