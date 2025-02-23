package defpackage;

import android.view.View;
import androidx.appcompat.widget.ScrollingTabContainerView;

/* renamed from: nv  reason: default package */
/* compiled from: ScrollingTabContainerView */
public final class nv implements Runnable {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ ScrollingTabContainerView f3120a;

    public nv(ScrollingTabContainerView scrollingTabContainerView, View view) {
        this.f3120a = scrollingTabContainerView;
        this.a = view;
    }

    public final void run() {
        View view = this.a;
        int left = view.getLeft();
        ScrollingTabContainerView scrollingTabContainerView = this.f3120a;
        scrollingTabContainerView.smoothScrollTo(left - ((scrollingTabContainerView.getWidth() - view.getWidth()) / 2), 0);
        scrollingTabContainerView.f1219a = null;
    }
}
