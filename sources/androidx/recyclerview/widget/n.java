package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a;

/* compiled from: SimpleItemAnimator */
public abstract class n extends RecyclerView.ItemAnimator {
    public final boolean a = true;

    public final boolean a(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i;
        int i2;
        if (itemHolderInfo == null || ((i = itemHolderInfo.a) == (i2 = itemHolderInfo2.a) && itemHolderInfo.b == itemHolderInfo2.b)) {
            a aVar = (a) this;
            aVar.r(viewHolder);
            viewHolder.itemView.setAlpha(0.0f);
            aVar.c.add(viewHolder);
            return true;
        }
        return m(viewHolder, i, itemHolderInfo.b, i2, itemHolderInfo2.b);
    }

    public final boolean b(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i;
        int i2;
        int i3 = itemHolderInfo.a;
        int i4 = itemHolderInfo.b;
        if (viewHolder2.shouldIgnore()) {
            int i5 = itemHolderInfo.a;
            i = itemHolderInfo.b;
            i2 = i5;
        } else {
            i2 = itemHolderInfo2.a;
            i = itemHolderInfo2.b;
        }
        a aVar = (a) this;
        if (viewHolder == viewHolder2) {
            return aVar.m(viewHolder, i3, i4, i2, i);
        }
        float translationX = viewHolder.itemView.getTranslationX();
        float translationY = viewHolder.itemView.getTranslationY();
        float alpha = viewHolder.itemView.getAlpha();
        aVar.r(viewHolder);
        viewHolder.itemView.setTranslationX(translationX);
        viewHolder.itemView.setTranslationY(translationY);
        viewHolder.itemView.setAlpha(alpha);
        aVar.r(viewHolder2);
        viewHolder2.itemView.setTranslationX((float) (-((int) (((float) (i2 - i3)) - translationX))));
        viewHolder2.itemView.setTranslationY((float) (-((int) (((float) (i - i4)) - translationY))));
        viewHolder2.itemView.setAlpha(0.0f);
        aVar.e.add(new a.d(viewHolder, viewHolder2, i3, i4, i2, i));
        return true;
    }

    public final boolean c(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i;
        int i2;
        int i3 = itemHolderInfo.a;
        int i4 = itemHolderInfo.b;
        View view = viewHolder.itemView;
        if (itemHolderInfo2 == null) {
            i = view.getLeft();
        } else {
            i = itemHolderInfo2.a;
        }
        int i5 = i;
        if (itemHolderInfo2 == null) {
            i2 = view.getTop();
        } else {
            i2 = itemHolderInfo2.b;
        }
        int i6 = i2;
        if (viewHolder.isRemoved() || (i3 == i5 && i4 == i6)) {
            a aVar = (a) this;
            aVar.r(viewHolder);
            aVar.b.add(viewHolder);
            return true;
        }
        view.layout(i5, i6, view.getWidth() + i5, view.getHeight() + i6);
        return m(viewHolder, i3, i4, i5, i6);
    }

    public final boolean d(RecyclerView.ViewHolder viewHolder, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo, RecyclerView.ItemAnimator.ItemHolderInfo itemHolderInfo2) {
        int i = itemHolderInfo.a;
        int i2 = itemHolderInfo2.a;
        if (i == i2 && itemHolderInfo.b == itemHolderInfo2.b) {
            h(viewHolder);
            return false;
        }
        return m(viewHolder, i, itemHolderInfo.b, i2, itemHolderInfo2.b);
    }

    public final boolean f(RecyclerView.ViewHolder viewHolder) {
        if (!this.a || viewHolder.isInvalid()) {
            return true;
        }
        return false;
    }

    @SuppressLint({"UnknownNullness"})
    public abstract boolean m(RecyclerView.ViewHolder viewHolder, int i, int i2, int i3, int i4);
}
