package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public abstract class OrientationHelper {
    public int a = Integer.MIN_VALUE;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f2301a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    public final RecyclerView.LayoutManager f2302a;

    public OrientationHelper(RecyclerView.LayoutManager layoutManager) {
        this.f2302a = layoutManager;
    }

    public static OrientationHelper a(RecyclerView.LayoutManager layoutManager, int i) {
        if (i == 0) {
            return new j(layoutManager);
        }
        if (i == 1) {
            return new k(layoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m(View view);

    public abstract int n(View view);

    public abstract void o(int i);
}
