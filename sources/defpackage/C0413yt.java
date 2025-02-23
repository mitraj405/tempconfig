package defpackage;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

/* renamed from: yt  reason: default package and case insensitive filesystem */
/* compiled from: RequestExecutor */
public final class C0413yt implements ThreadFactory {
    public final int c = 10;

    /* renamed from: c  reason: collision with other field name */
    public final String f3440c = "fonts-androidx";

    /* renamed from: yt$a */
    /* compiled from: RequestExecutor */
    public static class a extends Thread {
        public final int c;

        public a(Runnable runnable, String str, int i) {
            super(runnable, str);
            this.c = i;
        }

        public final void run() {
            Process.setThreadPriority(this.c);
            super.run();
        }
    }

    public final Thread newThread(Runnable runnable) {
        return new a(runnable, this.f3440c, this.c);
    }
}
