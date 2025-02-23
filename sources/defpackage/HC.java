package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: HC  reason: default package */
/* compiled from: ViewPropertyAnimatorCompatSet */
public final class HC {
    public long a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final a f252a = new a();

    /* renamed from: a  reason: collision with other field name */
    public IC f253a;

    /* renamed from: a  reason: collision with other field name */
    public Interpolator f254a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<GC> f255a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public boolean f256a;

    /* renamed from: HC$a */
    /* compiled from: ViewPropertyAnimatorCompatSet */
    public class a extends C1488xu {
        public int a = 0;
        public boolean b = false;

        public a() {
        }

        public final void a() {
            if (!this.b) {
                this.b = true;
                IC ic = HC.this.f253a;
                if (ic != null) {
                    ic.a();
                }
            }
        }

        public final void onAnimationEnd() {
            int i = this.a + 1;
            this.a = i;
            HC hc = HC.this;
            if (i == hc.f255a.size()) {
                IC ic = hc.f253a;
                if (ic != null) {
                    ic.onAnimationEnd();
                }
                this.a = 0;
                this.b = false;
                hc.f256a = false;
            }
        }
    }

    public final void a() {
        if (this.f256a) {
            Iterator<GC> it = this.f255a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f256a = false;
        }
    }

    public final void b() {
        View view;
        if (!this.f256a) {
            Iterator<GC> it = this.f255a.iterator();
            while (it.hasNext()) {
                GC next = it.next();
                long j = this.a;
                if (j >= 0) {
                    next.c(j);
                }
                Interpolator interpolator = this.f254a;
                if (!(interpolator == null || (view = next.a.get()) == null)) {
                    view.animate().setInterpolator(interpolator);
                }
                if (this.f253a != null) {
                    next.d(this.f252a);
                }
                View view2 = next.a.get();
                if (view2 != null) {
                    view2.animate().start();
                }
            }
            this.f256a = true;
        }
    }
}
