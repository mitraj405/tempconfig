package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import defpackage.C0455Ay;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;

/* renamed from: Yi  reason: default package and case insensitive filesystem */
/* compiled from: LooperScheduler */
public final class C0758Yi extends Scheduler {
    public final Handler a;

    /* renamed from: Yi$a */
    /* compiled from: LooperScheduler */
    public static class a extends Scheduler.a {
        public final Handler a;

        /* renamed from: a  reason: collision with other field name */
        public final C1356qu f3865a = C1334pu.a.a();

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f3866a;

        public a(Handler handler) {
            this.a = handler;
        }

        public final Subscription b(C c) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            boolean z = this.f3866a;
            C0455Ay.a aVar = C0455Ay.a;
            if (z) {
                return aVar;
            }
            this.f3865a.getClass();
            Handler handler = this.a;
            b bVar = new b(c, handler);
            Message obtain = Message.obtain(handler, bVar);
            obtain.obj = this;
            this.a.sendMessageDelayed(obtain, timeUnit.toMillis(0));
            if (!this.f3866a) {
                return bVar;
            }
            this.a.removeCallbacks(bVar);
            return aVar;
        }

        public final boolean isUnsubscribed() {
            return this.f3866a;
        }

        public final void unsubscribe() {
            this.f3866a = true;
            this.a.removeCallbacksAndMessages(this);
        }
    }

    /* renamed from: Yi$b */
    /* compiled from: LooperScheduler */
    public static final class b implements Runnable, Subscription {
        public final C a;

        /* renamed from: a  reason: collision with other field name */
        public final Handler f3867a;

        /* renamed from: a  reason: collision with other field name */
        public volatile boolean f3868a;

        public b(C c, Handler handler) {
            this.a = c;
            this.f3867a = handler;
        }

        public final boolean isUnsubscribed() {
            return this.f3868a;
        }

        public final void run() {
            IllegalStateException illegalStateException;
            try {
                this.a.a();
            } catch (Throwable th) {
                if (th instanceof Qn) {
                    illegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th);
                } else {
                    illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                }
                Cu.f3555a.b().getClass();
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }

        public final void unsubscribe() {
            this.f3868a = true;
            this.f3867a.removeCallbacks(this);
        }
    }

    public C0758Yi(Looper looper) {
        this.a = new Handler(looper);
    }

    public final Scheduler.a a() {
        return new a(this.a);
    }
}
