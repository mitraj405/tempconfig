package cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet;

import android.animation.Animator;
import android.view.View;
import cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayout;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BottomSheetLayout */
public final class a extends BottomSheetLayout.e {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ BottomSheetLayout f5336a;
    public final /* synthetic */ boolean b = false;

    public a(BottomSheetLayout bottomSheetLayout, View view) {
        this.f5336a = bottomSheetLayout;
        this.a = view;
    }

    public final void onAnimationEnd(Animator animator) {
        if (!this.a) {
            BottomSheetLayout bottomSheetLayout = this.f5336a;
            bottomSheetLayout.f5291a = null;
            bottomSheetLayout.setState(BottomSheetLayout.h.HIDDEN);
            bottomSheetLayout.setSheetLayerTypeIfEnabled(0);
            bottomSheetLayout.removeView(this.a);
            CopyOnWriteArraySet<Xn> copyOnWriteArraySet = bottomSheetLayout.f5298a;
            Iterator<Xn> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            bottomSheetLayout.f5300b = null;
            copyOnWriteArraySet.clear();
            if (!this.b) {
                bottomSheetLayout.f5294a.setVisibility(4);
            }
            bottomSheetLayout.f5302b.clear();
            Runnable runnable = bottomSheetLayout.f5297a;
            if (runnable != null) {
                runnable.run();
                bottomSheetLayout.f5297a = null;
            }
        }
    }
}
