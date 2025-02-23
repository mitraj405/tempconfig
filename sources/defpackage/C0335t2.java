package defpackage;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* renamed from: t2  reason: default package and case insensitive filesystem */
/* compiled from: BaseKeyframeAnimation */
public abstract class C0335t2<K, A> {
    public float a = 0.0f;

    /* renamed from: a  reason: collision with other field name */
    public A f3284a = null;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f3285a = new ArrayList(1);

    /* renamed from: a  reason: collision with other field name */
    public final c<K> f3286a;

    /* renamed from: a  reason: collision with other field name */
    public C0344tk f3287a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3288a = false;
    public float b = -1.0f;
    public float c = -1.0f;

    /* renamed from: t2$a */
    /* compiled from: BaseKeyframeAnimation */
    public interface a {
        void f();
    }

    /* renamed from: t2$b */
    /* compiled from: BaseKeyframeAnimation */
    public static final class b<T> implements c<T> {
        public final float a() {
            return 0.0f;
        }

        public final float b() {
            return 1.0f;
        }

        public final boolean c(float f) {
            throw new IllegalStateException("not implemented");
        }

        public final Bh<T> d() {
            throw new IllegalStateException("not implemented");
        }

        public final boolean e(float f) {
            return false;
        }

        public final boolean isEmpty() {
            return true;
        }
    }

    /* renamed from: t2$c */
    /* compiled from: BaseKeyframeAnimation */
    public interface c<T> {
        float a();

        float b();

        boolean c(float f);

        Bh<T> d();

        boolean e(float f);

        boolean isEmpty();
    }

    /* renamed from: t2$d */
    /* compiled from: BaseKeyframeAnimation */
    public static final class d<T> implements c<T> {
        public float a = -1.0f;

        /* renamed from: a  reason: collision with other field name */
        public Bh<T> f3289a;

        /* renamed from: a  reason: collision with other field name */
        public final List<? extends Bh<T>> f3290a;
        public Bh<T> b = null;

        public d(List<? extends Bh<T>> list) {
            this.f3290a = list;
            this.f3289a = f(0.0f);
        }

        public final float a() {
            return ((Bh) this.f3290a.get(0)).b();
        }

        public final float b() {
            List<? extends Bh<T>> list = this.f3290a;
            return ((Bh) list.get(list.size() - 1)).a();
        }

        public final boolean c(float f) {
            Bh<T> bh = this.b;
            Bh<T> bh2 = this.f3289a;
            if (bh == bh2 && this.a == f) {
                return true;
            }
            this.b = bh2;
            this.a = f;
            return false;
        }

        public final Bh<T> d() {
            return this.f3289a;
        }

        public final boolean e(float f) {
            boolean z;
            Bh<T> bh = this.f3289a;
            if (f < bh.b() || f >= bh.a()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return !this.f3289a.c();
            }
            this.f3289a = f(f);
            return true;
        }

        public final Bh<T> f(float f) {
            List<? extends Bh<T>> list = this.f3290a;
            Bh<T> bh = (Bh) list.get(list.size() - 1);
            if (f >= bh.b()) {
                return bh;
            }
            int size = list.size() - 2;
            while (true) {
                boolean z = false;
                if (size < 1) {
                    return (Bh) list.get(0);
                }
                Bh<T> bh2 = (Bh) list.get(size);
                if (this.f3289a != bh2) {
                    if (f >= bh2.b() && f < bh2.a()) {
                        z = true;
                    }
                    if (z) {
                        return bh2;
                    }
                }
                size--;
            }
        }

        public final boolean isEmpty() {
            return false;
        }
    }

    /* renamed from: t2$e */
    /* compiled from: BaseKeyframeAnimation */
    public static final class e<T> implements c<T> {
        public float a = -1.0f;

        /* renamed from: a  reason: collision with other field name */
        public final Bh<T> f3291a;

        public e(List<? extends Bh<T>> list) {
            this.f3291a = (Bh) list.get(0);
        }

        public final float a() {
            return this.f3291a.b();
        }

        public final float b() {
            return this.f3291a.a();
        }

        public final boolean c(float f) {
            if (this.a == f) {
                return true;
            }
            this.a = f;
            return false;
        }

        public final Bh<T> d() {
            return this.f3291a;
        }

        public final boolean e(float f) {
            return !this.f3291a.c();
        }

        public final boolean isEmpty() {
            return false;
        }
    }

    public C0335t2(List<? extends Bh<K>> list) {
        c<K> cVar;
        c<K> cVar2;
        if (list.isEmpty()) {
            cVar = new b<>();
        } else {
            if (list.size() == 1) {
                cVar2 = new e<>(list);
            } else {
                cVar2 = new d<>(list);
            }
            cVar = cVar2;
        }
        this.f3286a = cVar;
    }

    public final void a(a aVar) {
        this.f3285a.add(aVar);
    }

    public final Bh<K> b() {
        Bh<K> d2 = this.f3286a.d();
        C1354qp.G();
        return d2;
    }

    public float c() {
        if (this.c == -1.0f) {
            this.c = this.f3286a.b();
        }
        return this.c;
    }

    public final float d() {
        Bh b2 = b();
        if (b2 == null || b2.c()) {
            return 0.0f;
        }
        return b2.f62a.getInterpolation(e());
    }

    public final float e() {
        if (this.f3288a) {
            return 0.0f;
        }
        Bh b2 = b();
        if (b2.c()) {
            return 0.0f;
        }
        return (this.a - b2.b()) / (b2.a() - b2.b());
    }

    public A f() {
        A a2;
        Interpolator interpolator;
        float e2 = e();
        if (this.f3287a == null && this.f3286a.c(e2)) {
            return this.f3284a;
        }
        Bh b2 = b();
        Interpolator interpolator2 = b2.f68b;
        if (interpolator2 == null || (interpolator = b2.f70c) == null) {
            a2 = g(b2, d());
        } else {
            a2 = h(b2, e2, interpolator2.getInterpolation(e2), interpolator.getInterpolation(e2));
        }
        this.f3284a = a2;
        return a2;
    }

    public abstract A g(Bh<K> bh, float f);

    public A h(Bh<K> bh, float f, float f2, float f3) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void i() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f3285a;
            if (i < arrayList.size()) {
                ((a) arrayList.get(i)).f();
                i++;
            } else {
                return;
            }
        }
    }

    public void j(float f) {
        c<K> cVar = this.f3286a;
        if (!cVar.isEmpty()) {
            if (this.b == -1.0f) {
                this.b = cVar.a();
            }
            float f2 = this.b;
            if (f < f2) {
                if (f2 == -1.0f) {
                    this.b = cVar.a();
                }
                f = this.b;
            } else if (f > c()) {
                f = c();
            }
            if (f != this.a) {
                this.a = f;
                if (cVar.e(f)) {
                    i();
                }
            }
        }
    }

    public final void k(C0344tk tkVar) {
        C0344tk tkVar2 = this.f3287a;
        if (tkVar2 != null) {
            tkVar2.b = null;
        }
        this.f3287a = tkVar;
        if (tkVar != null) {
            tkVar.b = this;
        }
    }
}
