package cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet;

import android.animation.Animator;
import android.view.View;
import cris.org.in.ima.mobikwiklayout.view.bottomsheet.flipboard_bottomsheet.BottomSheetLayoutCustom;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: BottomSheetLayoutCustom */
public final class b extends BottomSheetLayoutCustom.d {
    public final /* synthetic */ View a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ BottomSheetLayoutCustom f5337a;

    public b(BottomSheetLayoutCustom bottomSheetLayoutCustom, View view) {
        this.f5337a = bottomSheetLayoutCustom;
        this.a = view;
    }

    public final void onAnimationEnd(Animator animator) {
        if (!this.a) {
            BottomSheetLayoutCustom bottomSheetLayoutCustom = this.f5337a;
            bottomSheetLayoutCustom.f5314a = null;
            bottomSheetLayoutCustom.setState(BottomSheetLayoutCustom.g.HIDDEN);
            bottomSheetLayoutCustom.setSheetLayerTypeIfEnabled(0);
            bottomSheetLayoutCustom.removeView(this.a);
            bottomSheetLayoutCustom.f5317a.setVisibility(4);
            CopyOnWriteArraySet<Xn> copyOnWriteArraySet = bottomSheetLayoutCustom.f5321a;
            Iterator<Xn> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            bottomSheetLayoutCustom.f5323b = null;
            copyOnWriteArraySet.clear();
            bottomSheetLayoutCustom.f5326b.clear();
            Runnable runnable = bottomSheetLayoutCustom.f5320a;
            if (runnable != null) {
                runnable.run();
                bottomSheetLayoutCustom.f5320a = null;
            }
        }
    }
}
