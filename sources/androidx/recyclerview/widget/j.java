package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper */
public final class j extends OrientationHelper {
    public j(RecyclerView.LayoutManager layoutManager) {
        super(layoutManager);
    }

    public final int b(View view) {
        return this.f2302a.getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
    }

    public final int c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f2302a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
    }

    public final int d(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f2302a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final int e(View view) {
        return this.f2302a.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    public final int f() {
        return this.f2302a.getWidth();
    }

    public final int g() {
        RecyclerView.LayoutManager layoutManager = this.f2302a;
        return layoutManager.getWidth() - layoutManager.getPaddingRight();
    }

    public final int h() {
        return this.f2302a.getPaddingRight();
    }

    public final int i() {
        return this.f2302a.getWidthMode();
    }

    public final int j() {
        return this.f2302a.getHeightMode();
    }

    public final int k() {
        return this.f2302a.getPaddingLeft();
    }

    public final int l() {
        RecyclerView.LayoutManager layoutManager = this.f2302a;
        return (layoutManager.getWidth() - layoutManager.getPaddingLeft()) - layoutManager.getPaddingRight();
    }

    public final int m(View view) {
        RecyclerView.LayoutManager layoutManager = this.f2302a;
        Rect rect = this.f2301a;
        layoutManager.getTransformedBoundingBox(view, true, rect);
        return rect.right;
    }

    public final int n(View view) {
        RecyclerView.LayoutManager layoutManager = this.f2302a;
        Rect rect = this.f2301a;
        layoutManager.getTransformedBoundingBox(view, true, rect);
        return rect.left;
    }

    public final void o(int i) {
        this.f2302a.offsetChildrenHorizontal(i);
    }
}
