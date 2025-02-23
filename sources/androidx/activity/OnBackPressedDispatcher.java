package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.f;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: OnBackPressedDispatcher.kt */
public final class OnBackPressedDispatcher {
    public Bn a;

    /* renamed from: a  reason: collision with other field name */
    public final C0534I1<Bn> f810a;

    /* renamed from: a  reason: collision with other field name */
    public final U6<Boolean> f811a;

    /* renamed from: a  reason: collision with other field name */
    public final OnBackInvokedCallback f812a;

    /* renamed from: a  reason: collision with other field name */
    public OnBackInvokedDispatcher f813a;

    /* renamed from: a  reason: collision with other field name */
    public final Runnable f814a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f815a;
    public boolean b;

    /* compiled from: OnBackPressedDispatcher.kt */
    public final class LifecycleOnBackPressedCancellable implements f, u4 {
        public final Bn a;

        /* renamed from: a  reason: collision with other field name */
        public c f816a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ OnBackPressedDispatcher f817a;

        /* renamed from: a  reason: collision with other field name */
        public final Lifecycle f818a;

        public LifecycleOnBackPressedCancellable(OnBackPressedDispatcher onBackPressedDispatcher, Lifecycle lifecycle, FragmentManager.c cVar) {
            C1177ig.f(cVar, "onBackPressedCallback");
            this.f817a = onBackPressedDispatcher;
            this.f818a = lifecycle;
            this.a = cVar;
            lifecycle.a(this);
        }

        public final void b(LifecycleOwner lifecycleOwner, Lifecycle.a aVar) {
            if (aVar == Lifecycle.a.ON_START) {
                this.f816a = this.f817a.b(this.a);
            } else if (aVar == Lifecycle.a.ON_STOP) {
                c cVar = this.f816a;
                if (cVar != null) {
                    cVar.cancel();
                }
            } else if (aVar == Lifecycle.a.ON_DESTROY) {
                cancel();
            }
        }

        public final void cancel() {
            this.f818a.c(this);
            this.a.removeCancellable(this);
            c cVar = this.f816a;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f816a = null;
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    public static final class a {
        public static final a a = new a();

        public final OnBackInvokedCallback a(Function0<Unit> function0) {
            C1177ig.f(function0, "onBackInvoked");
            return new Hn(function0, 0);
        }

        public final void b(Object obj, int i, Object obj2) {
            C1177ig.f(obj, "dispatcher");
            C1177ig.f(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
        }

        public final void c(Object obj, Object obj2) {
            C1177ig.f(obj, "dispatcher");
            C1177ig.f(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    public static final class b {
        public static final b a = new b();

        /* compiled from: OnBackPressedDispatcher.kt */
        public static final class a implements OnBackAnimationCallback {
            public final /* synthetic */ Function0<Unit> a;

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ Function1<BackEventCompat, Unit> f819a;
            public final /* synthetic */ Function0<Unit> b;

            /* renamed from: b  reason: collision with other field name */
            public final /* synthetic */ Function1<BackEventCompat, Unit> f820b;

            public a(Function1<? super BackEventCompat, Unit> function1, Function1<? super BackEventCompat, Unit> function12, Function0<Unit> function0, Function0<Unit> function02) {
                this.f819a = function1;
                this.f820b = function12;
                this.a = function0;
                this.b = function02;
            }

            public final void onBackCancelled() {
                this.b.invoke();
            }

            public final void onBackInvoked() {
                this.a.invoke();
            }

            public final void onBackProgressed(BackEvent backEvent) {
                C1177ig.f(backEvent, "backEvent");
                this.f820b.invoke(new BackEventCompat(backEvent));
            }

            public final void onBackStarted(BackEvent backEvent) {
                C1177ig.f(backEvent, "backEvent");
                this.f819a.invoke(new BackEventCompat(backEvent));
            }
        }

        public final OnBackInvokedCallback a(Function1<? super BackEventCompat, Unit> function1, Function1<? super BackEventCompat, Unit> function12, Function0<Unit> function0, Function0<Unit> function02) {
            C1177ig.f(function1, "onBackStarted");
            C1177ig.f(function12, "onBackProgressed");
            C1177ig.f(function0, "onBackInvoked");
            C1177ig.f(function02, "onBackCancelled");
            return new a(function1, function12, function0, function02);
        }
    }

    /* compiled from: OnBackPressedDispatcher.kt */
    public final class c implements u4 {
        public final Bn a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ OnBackPressedDispatcher f821a;

        public c(OnBackPressedDispatcher onBackPressedDispatcher, Bn bn) {
            C1177ig.f(bn, "onBackPressedCallback");
            this.f821a = onBackPressedDispatcher;
            this.a = bn;
        }

        public final void cancel() {
            OnBackPressedDispatcher onBackPressedDispatcher = this.f821a;
            C0534I1<Bn> i1 = onBackPressedDispatcher.f810a;
            Bn bn = this.a;
            i1.remove(bn);
            if (C1177ig.a(onBackPressedDispatcher.a, bn)) {
                bn.handleOnBackCancelled();
                onBackPressedDispatcher.a = null;
            }
            bn.removeCancellable(this);
            Function0<Unit> enabledChangedCallback$activity_release = bn.getEnabledChangedCallback$activity_release();
            if (enabledChangedCallback$activity_release != null) {
                enabledChangedCallback$activity_release.invoke();
            }
            bn.setEnabledChangedCallback$activity_release((Function0<Unit>) null);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        OnBackInvokedCallback onBackInvokedCallback;
        this.f814a = runnable;
        this.f811a = null;
        this.f810a = new C0534I1<>();
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            if (i >= 34) {
                onBackInvokedCallback = b.a.a(new Cn(this), new Dn(this), new En(this), new Fn(this));
            } else {
                onBackInvokedCallback = a.a.a(new Gn(this));
            }
            this.f812a = onBackInvokedCallback;
        }
    }

    public final void a(LifecycleOwner lifecycleOwner, FragmentManager.c cVar) {
        C1177ig.f(cVar, "onBackPressedCallback");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.b() != Lifecycle.State.DESTROYED) {
            cVar.addCancellable(new LifecycleOnBackPressedCancellable(this, lifecycle, cVar));
            e();
            cVar.setEnabledChangedCallback$activity_release(new In(this));
        }
    }

    public final c b(Bn bn) {
        C1177ig.f(bn, "onBackPressedCallback");
        this.f810a.addLast(bn);
        c cVar = new c(this, bn);
        bn.addCancellable(cVar);
        e();
        bn.setEnabledChangedCallback$activity_release(new Jn(this));
        return cVar;
    }

    public final void c() {
        Bn bn;
        C0534I1<Bn> i1 = this.f810a;
        ListIterator<Bn> listIterator = i1.listIterator(i1.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                bn = null;
                break;
            }
            bn = listIterator.previous();
            if (bn.isEnabled()) {
                break;
            }
        }
        Bn bn2 = bn;
        this.a = null;
        if (bn2 != null) {
            bn2.handleOnBackPressed();
            return;
        }
        Runnable runnable = this.f814a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void d(boolean z) {
        OnBackInvokedCallback onBackInvokedCallback;
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f813a;
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.f812a) != null) {
            a aVar = a.a;
            if (z && !this.f815a) {
                aVar.b(onBackInvokedDispatcher, 0, onBackInvokedCallback);
                this.f815a = true;
            } else if (!z && this.f815a) {
                aVar.c(onBackInvokedDispatcher, onBackInvokedCallback);
                this.f815a = false;
            }
        }
    }

    public final void e() {
        boolean z = this.b;
        C0534I1<Bn> i1 = this.f810a;
        boolean z2 = false;
        if (!(i1 instanceof Collection) || !i1.isEmpty()) {
            Iterator<T> it = i1.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((Bn) it.next()).isEnabled()) {
                        z2 = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.b = z2;
        if (z2 != z) {
            U6<Boolean> u6 = this.f811a;
            if (u6 != null) {
                u6.accept(Boolean.valueOf(z2));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                d(z2);
            }
        }
    }

    public OnBackPressedDispatcher() {
        this((Runnable) null);
    }
}
