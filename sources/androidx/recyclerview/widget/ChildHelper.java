package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public final class ChildHelper {
    public int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public View f2276a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2277a;

    /* renamed from: a  reason: collision with other field name */
    public final b f2278a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f2279a;

    public static class a {
        public long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public a f2280a;

        public final void a(int i) {
            if (i >= 64) {
                a aVar = this.f2280a;
                if (aVar != null) {
                    aVar.a(i - 64);
                    return;
                }
                return;
            }
            this.a &= ~(1 << i);
        }

        public final int b(int i) {
            a aVar = this.f2280a;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.a);
                }
                return Long.bitCount(this.a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.a & ((1 << i) - 1));
            } else {
                return Long.bitCount(this.a) + aVar.b(i - 64);
            }
        }

        public final void c() {
            if (this.f2280a == null) {
                this.f2280a = new a();
            }
        }

        public final boolean d(int i) {
            if (i >= 64) {
                c();
                return this.f2280a.d(i - 64);
            } else if ((this.a & (1 << i)) != 0) {
                return true;
            } else {
                return false;
            }
        }

        public final void e(int i, boolean z) {
            boolean z2;
            if (i >= 64) {
                c();
                this.f2280a.e(i - 64, z);
                return;
            }
            long j = this.a;
            if ((Long.MIN_VALUE & j) != 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            long j2 = (1 << i) - 1;
            this.a = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (z2 || this.f2280a != null) {
                c();
                this.f2280a.e(0, z2);
            }
        }

        public final boolean f(int i) {
            boolean z;
            if (i >= 64) {
                c();
                return this.f2280a.f(i - 64);
            }
            long j = 1 << i;
            long j2 = this.a;
            if ((j2 & j) != 0) {
                z = true;
            } else {
                z = false;
            }
            long j3 = j2 & (~j);
            this.a = j3;
            long j4 = j - 1;
            this.a = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            a aVar = this.f2280a;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f2280a.f(0);
            }
            return z;
        }

        public final void g() {
            this.a = 0;
            a aVar = this.f2280a;
            if (aVar != null) {
                aVar.g();
            }
        }

        public final void h(int i) {
            if (i >= 64) {
                c();
                this.f2280a.h(i - 64);
                return;
            }
            this.a |= 1 << i;
        }

        public final String toString() {
            if (this.f2280a == null) {
                return Long.toBinaryString(this.a);
            }
            return this.f2280a.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }

    public interface b {
    }

    public ChildHelper(RecyclerView.e eVar) {
        this.f2278a = eVar;
        this.f2277a = new a();
        this.f2279a = new ArrayList();
    }

    public final void a(View view, int i, boolean z) {
        int i2;
        b bVar = this.f2278a;
        if (i < 0) {
            i2 = ((RecyclerView.e) bVar).a();
        } else {
            i2 = f(i);
        }
        this.f2277a.e(i2, z);
        if (z) {
            i(view);
        }
        RecyclerView recyclerView = RecyclerView.this;
        recyclerView.addView(view, i2);
        recyclerView.dispatchChildAttached(view);
    }

    public final void b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        b bVar = this.f2278a;
        if (i < 0) {
            i2 = ((RecyclerView.e) bVar).a();
        } else {
            i2 = f(i);
        }
        this.f2277a.e(i2, z);
        if (z) {
            i(view);
        }
        RecyclerView.e eVar = (RecyclerView.e) bVar;
        eVar.getClass();
        RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        RecyclerView recyclerView = RecyclerView.this;
        if (childViewHolderInt != null) {
            if (childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                if (RecyclerView.sVerboseLoggingEnabled) {
                    childViewHolderInt.toString();
                }
                childViewHolderInt.clearTmpDetachFlag();
            } else {
                StringBuilder sb = new StringBuilder("Called attach on a child which is not detached: ");
                sb.append(childViewHolderInt);
                throw new IllegalArgumentException(C1058d.w(recyclerView, sb));
            }
        } else if (RecyclerView.sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No ViewHolder found for child: ");
            sb2.append(view);
            sb2.append(", index: ");
            sb2.append(i2);
            throw new IllegalArgumentException(C1058d.w(recyclerView, sb2));
        }
        recyclerView.attachViewToParent(view, i2, layoutParams);
    }

    public final void c(int i) {
        int f = f(i);
        this.f2277a.f(f);
        RecyclerView.e eVar = (RecyclerView.e) this.f2278a;
        View childAt = RecyclerView.this.getChildAt(f);
        RecyclerView recyclerView = RecyclerView.this;
        if (childAt != null) {
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
            if (childViewHolderInt != null) {
                if (!childViewHolderInt.isTmpDetached() || childViewHolderInt.shouldIgnore()) {
                    if (RecyclerView.sVerboseLoggingEnabled) {
                        childViewHolderInt.toString();
                    }
                    childViewHolderInt.addFlags(256);
                } else {
                    StringBuilder sb = new StringBuilder("called detach on an already detached child ");
                    sb.append(childViewHolderInt);
                    throw new IllegalArgumentException(C1058d.w(recyclerView, sb));
                }
            }
        } else if (RecyclerView.sDebugAssertionsEnabled) {
            StringBuilder sb2 = new StringBuilder("No view at offset ");
            sb2.append(f);
            throw new IllegalArgumentException(C1058d.w(recyclerView, sb2));
        }
        recyclerView.detachViewFromParent(f);
    }

    public final View d(int i) {
        return RecyclerView.this.getChildAt(f(i));
    }

    public final int e() {
        return ((RecyclerView.e) this.f2278a).a() - this.f2279a.size();
    }

    public final int f(int i) {
        if (i < 0) {
            return -1;
        }
        int a2 = ((RecyclerView.e) this.f2278a).a();
        int i2 = i;
        while (i2 < a2) {
            a aVar = this.f2277a;
            int b2 = i - (i2 - aVar.b(i2));
            if (b2 == 0) {
                while (aVar.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b2;
        }
        return -1;
    }

    public final View g(int i) {
        return RecyclerView.this.getChildAt(i);
    }

    public final int h() {
        return ((RecyclerView.e) this.f2278a).a();
    }

    public final void i(View view) {
        this.f2279a.add(view);
        RecyclerView.e eVar = (RecyclerView.e) this.f2278a;
        eVar.getClass();
        RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt != null) {
            childViewHolderInt.onEnteredHiddenState(RecyclerView.this);
        }
    }

    public final int j(View view) {
        int indexOfChild = RecyclerView.this.indexOfChild(view);
        if (indexOfChild == -1) {
            return -1;
        }
        a aVar = this.f2277a;
        if (aVar.d(indexOfChild)) {
            return -1;
        }
        return indexOfChild - aVar.b(indexOfChild);
    }

    public final boolean k(View view) {
        return this.f2279a.contains(view);
    }

    public final void l(int i) {
        b bVar = this.f2278a;
        int i2 = this.a;
        if (i2 == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        } else if (i2 != 2) {
            try {
                int f = f(i);
                View childAt = RecyclerView.this.getChildAt(f);
                if (childAt != null) {
                    this.a = 1;
                    this.f2276a = childAt;
                    if (this.f2277a.f(f)) {
                        m(childAt);
                    }
                    ((RecyclerView.e) bVar).b(f);
                }
            } finally {
                this.a = 0;
                this.f2276a = null;
            }
        } else {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
    }

    public final void m(View view) {
        if (this.f2279a.remove(view)) {
            RecyclerView.e eVar = (RecyclerView.e) this.f2278a;
            eVar.getClass();
            RecyclerView.ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
            if (childViewHolderInt != null) {
                childViewHolderInt.onLeftHiddenState(RecyclerView.this);
            }
        }
    }

    public final String toString() {
        return this.f2277a.toString() + ", hidden list:" + this.f2279a.size();
    }
}
