package defpackage;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: CC  reason: default package */
/* compiled from: ViewPager2 */
public final class CC implements RecyclerView.OnChildAttachStateChangeListener {
    public final void a(View view) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (layoutParams.width != -1 || layoutParams.height != -1) {
            throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
        }
    }

    public final void b() {
    }
}
