package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineDispatcher;

/* renamed from: bi  reason: default package and case insensitive filesystem */
/* compiled from: LimitedDispatcher.kt */
public final class C0804bi extends CoroutineDispatcher implements C0481D8 {
    public static final AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(C0804bi.class, "runningWorkers");

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ C0481D8 f3920a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f3921a;

    /* renamed from: a  reason: collision with other field name */
    public final CoroutineDispatcher f3922a;

    /* renamed from: a  reason: collision with other field name */
    public final C1327pi<Runnable> f3923a;
    public final int c;
    private volatile int runningWorkers;

    /* renamed from: bi$a */
    /* compiled from: LimitedDispatcher.kt */
    public final class a implements Runnable {

        /* renamed from: a  reason: collision with other field name */
        public Runnable f3924a;

        public a(Runnable runnable) {
            this.f3924a = runnable;
        }

        public final void run() {
            int i = 0;
            while (true) {
                try {
                    this.f3924a.run();
                } catch (Throwable th) {
                    C1399t7.a(C1440va.a, th);
                }
                C0804bi biVar = C0804bi.this;
                Runnable r = biVar.r();
                if (r != null) {
                    this.f3924a = r;
                    i++;
                    if (i >= 16) {
                        CoroutineDispatcher coroutineDispatcher = biVar.f3922a;
                        if (coroutineDispatcher.q()) {
                            coroutineDispatcher.h(biVar, this);
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public C0804bi(C1193jB jBVar, int i) {
        C0481D8 d8;
        this.f3922a = jBVar;
        this.c = i;
        if (jBVar instanceof C0481D8) {
            d8 = (C0481D8) jBVar;
        } else {
            d8 = null;
        }
        this.f3920a = d8 == null ? C1321p8.a : d8;
        this.f3923a = new C1327pi<>();
        this.f3921a = new Object();
    }

    public final void h(CoroutineContext coroutineContext, Runnable runnable) {
        boolean z;
        Runnable r;
        this.f3923a.a(runnable);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a;
        if (atomicIntegerFieldUpdater.get(this) < this.c) {
            synchronized (this.f3921a) {
                if (atomicIntegerFieldUpdater.get(this) >= this.c) {
                    z = false;
                } else {
                    atomicIntegerFieldUpdater.incrementAndGet(this);
                    z = true;
                }
            }
            if (z && (r = r()) != null) {
                this.f3922a.h(this, new a(r));
            }
        }
    }

    public final Runnable r() {
        while (true) {
            Runnable d = this.f3923a.d();
            if (d != null) {
                return d;
            }
            synchronized (this.f3921a) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f3923a.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }
}
