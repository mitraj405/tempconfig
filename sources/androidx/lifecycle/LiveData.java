package androidx.lifecycle;

import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import defpackage.Nu;
import java.util.Map;

public abstract class LiveData<T> {
    public static final Object d = new Object();
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final Nu<Observer<? super T>, LiveData<T>.C0811c> f2186a = new Nu<>();

    /* renamed from: a  reason: collision with other field name */
    public final a f2187a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f2188a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2189a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public volatile Object f2190b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2191b;
    public volatile Object c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f2192c;

    public class LifecycleBoundObserver extends LiveData<T>.C0811c implements f {
        public final LifecycleOwner a;

        public LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
            super(observer);
            this.a = lifecycleOwner;
        }

        public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
            LifecycleOwner lifecycleOwner2 = this.a;
            Lifecycle.State b2 = lifecycleOwner2.getLifecycle().b();
            if (b2 == Lifecycle.State.DESTROYED) {
                LiveData.this.h(this.f2193a);
                return;
            }
            Lifecycle.State state = null;
            while (state != b2) {
                c(f());
                state = b2;
                b2 = lifecycleOwner2.getLifecycle().b();
            }
        }

        public final void d() {
            this.a.getLifecycle().c(this);
        }

        public final boolean e(LifecycleOwner lifecycleOwner) {
            if (this.a == lifecycleOwner) {
                return true;
            }
            return false;
        }

        public final boolean f() {
            return this.a.getLifecycle().b().a(Lifecycle.State.STARTED);
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            Object obj;
            synchronized (LiveData.this.f2188a) {
                obj = LiveData.this.c;
                LiveData.this.c = LiveData.d;
            }
            LiveData.this.i(obj);
        }
    }

    public class b extends LiveData<T>.C0811c {
        public b(LiveData liveData, Observer<? super T> observer) {
            super(observer);
        }

        public final boolean f() {
            return true;
        }
    }

    public LiveData() {
        Object obj = d;
        this.c = obj;
        this.f2187a = new a();
        this.f2190b = obj;
        this.b = -1;
    }

    public static void a(String str) {
        boolean z;
        G1.d().f226a.getClass();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            throw new IllegalStateException(lf.j("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(LiveData<T>.C0811c cVar) {
        if (cVar.f2194a) {
            if (!cVar.f()) {
                cVar.c(false);
                return;
            }
            int i = cVar.c;
            int i2 = this.b;
            if (i < i2) {
                cVar.c = i2;
                cVar.f2193a.a(this.f2190b);
            }
        }
    }

    public final void c(LiveData<T>.C0811c cVar) {
        if (this.f2191b) {
            this.f2192c = true;
            return;
        }
        this.f2191b = true;
        do {
            this.f2192c = false;
            if (cVar == null) {
                Nu<Observer<? super T>, LiveData<T>.C0811c> nu = this.f2186a;
                nu.getClass();
                Nu.d dVar = new Nu.d();
                nu.f453a.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((c) ((Map.Entry) dVar.next()).getValue());
                    if (this.f2192c) {
                        break;
                    }
                }
            } else {
                b(cVar);
                cVar = null;
            }
        } while (this.f2192c);
        this.f2191b = false;
    }

    public final void d(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        a("observe");
        if (lifecycleOwner.getLifecycle().b() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
            c b2 = this.f2186a.b(observer, lifecycleBoundObserver);
            if (b2 != null && !b2.e(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (b2 == null) {
                lifecycleOwner.getLifecycle().a(lifecycleBoundObserver);
            }
        }
    }

    public final void e(Observer<? super T> observer) {
        a("observeForever");
        b bVar = new b(this, observer);
        c b2 = this.f2186a.b(observer, bVar);
        if (b2 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (b2 == null) {
            bVar.c(true);
        }
    }

    public void h(Observer<? super T> observer) {
        a("removeObserver");
        c c2 = this.f2186a.c(observer);
        if (c2 != null) {
            c2.d();
            c2.c(false);
        }
    }

    public void i(T t) {
        a("setValue");
        this.b++;
        this.f2190b = t;
        c((LiveData<T>.C0811c) null);
    }

    public abstract class c {

        /* renamed from: a  reason: collision with other field name */
        public final Observer<? super T> f2193a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2194a;
        public int c = -1;

        public c(Observer<? super T> observer) {
            this.f2193a = observer;
        }

        public final void c(boolean z) {
            int i;
            boolean z2;
            boolean z3;
            if (z != this.f2194a) {
                this.f2194a = z;
                if (z) {
                    i = 1;
                } else {
                    i = -1;
                }
                LiveData liveData = LiveData.this;
                int i2 = liveData.a;
                liveData.a = i + i2;
                if (!liveData.f2189a) {
                    liveData.f2189a = true;
                    while (true) {
                        try {
                            int i3 = liveData.a;
                            if (i2 == i3) {
                                break;
                            }
                            if (i2 != 0 || i3 <= 0) {
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                            if (i2 <= 0 || i3 != 0) {
                                z3 = false;
                            } else {
                                z3 = true;
                            }
                            if (z2) {
                                liveData.f();
                            } else if (z3) {
                                liveData.g();
                            }
                            i2 = i3;
                        } finally {
                            liveData.f2189a = false;
                        }
                    }
                }
                if (this.f2194a) {
                    liveData.c(this);
                }
            }
        }

        public boolean e(LifecycleOwner lifecycleOwner) {
            return false;
        }

        public abstract boolean f();

        public void d() {
        }
    }

    public void f() {
    }

    public void g() {
    }
}
