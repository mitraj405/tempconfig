package defpackage;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* renamed from: Db  reason: default package and case insensitive filesystem */
/* compiled from: ExpandTouchListener */
public final class C0484Db extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ C0516Gb a;

    public C0484Db(C0516Gb gb) {
        this.a = gb;
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        boolean z;
        if (f2 > 0.0f) {
            z = true;
        } else {
            z = false;
        }
        this.a.f3596c = z;
        return false;
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }
}
