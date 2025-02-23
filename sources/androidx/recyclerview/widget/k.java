package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: OrientationHelper */
public final class k extends OrientationHelper {
    public k(RecyclerView.LayoutManager layoutManager) {
        super(layoutManager);
    }

    public final int b(View view) {
        return this.f2302a.getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    public final int c(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f2302a.getDecoratedMeasuredHeight(view) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final int d(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return this.f2302a.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin + layoutParams.rightMargin;
    }

    public final int e(View view) {
        return this.f2302a.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    public final int f() {
        return this.f2302a.getHeight();
    }

    public final int g() {
        RecyclerView.LayoutManager layoutManager = this.f2302a;
        return layoutManager.getHeight() - layoutManager.getPaddingBottom();
    }

    public final int h() {
        return this.f2302a.getPaddingBottom();
    }

    public final int i() {
        return this.f2302a.getHeightMode();
    }

    public final int j() {
        return this.f2302a.getWidthMode();
    }

    public final int k() {
        return this.f2302a.getPaddingTop();
    }

    public final int l() {
        RecyclerView.LayoutManager layoutManager = this.f2302a;
        return (layoutManager.getHeight() - layoutManager.getPaddingTop()) - layoutManager.getPaddingBottom();
    }

    public final int m(View view) {
        RecyclerView.LayoutManager layoutManager = this.f2302a;
        Rect rect = this.f2301a;
        layoutManager.getTransformedBoundingBox(view, true, rect);
        return rect.bottom;
    }

    public final int n(View view) {
        RecyclerView.LayoutManager layoutManager = this.f2302a;
        Rect rect = this.f2301a;
        layoutManager.getTransformedBoundingBox(view, true, rect);
        return rect.top;
    }

    public final void o(int i) {
        this.f2302a.offsetChildrenVertical(i);
    }
}
