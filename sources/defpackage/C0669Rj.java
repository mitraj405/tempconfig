package defpackage;

import android.view.animation.Animation;
import cris.org.in.ima.mobikwiklayout.view.MKEditText;

/* renamed from: Rj  reason: default package and case insensitive filesystem */
/* compiled from: MKEditText */
public final class C0669Rj implements Animation.AnimationListener {
    public final /* synthetic */ MKEditText a;

    public C0669Rj(MKEditText mKEditText) {
        this.a = mKEditText;
    }

    public final void onAnimationStart(Animation animation) {
        this.a.f5256a.setAlpha(1.0f);
    }

    public final void onAnimationEnd(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
