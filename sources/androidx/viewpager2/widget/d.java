package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;

/* compiled from: ViewPager2 */
public final class d extends ViewPager2.e {
    public final /* synthetic */ ViewPager2.h a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(ViewPager2.h hVar) {
        super(0);
        this.a = hVar;
    }

    public final void onChanged() {
        this.a.b();
    }
}
