package defpackage;

import android.graphics.Rect;
import android.transition.Transition;

/* renamed from: sd  reason: default package and case insensitive filesystem */
/* compiled from: FragmentTransitionCompat21 */
public final class C0329sd extends Transition.EpicenterCallback {
    public final /* synthetic */ Rect a;

    public C0329sd(Rect rect) {
        this.a = rect;
    }

    public final Rect onGetEpicenter(Transition transition) {
        return this.a;
    }
}
