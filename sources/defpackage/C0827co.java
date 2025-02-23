package defpackage;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: co  reason: default package and case insensitive filesystem */
/* compiled from: OnSwipeTouchListener */
public class C0827co implements View.OnTouchListener {
    public final GestureDetector a;

    /* renamed from: co$a */
    /* compiled from: OnSwipeTouchListener */
    public final class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        public final boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            float x = motionEvent2.getX() - motionEvent.getX();
            float y = motionEvent2.getY() - motionEvent.getY();
            int i = (Math.abs(x) > Math.abs(y) ? 1 : (Math.abs(x) == Math.abs(y) ? 0 : -1));
            C0827co coVar = C0827co.this;
            if (i <= 0 || Math.abs(x) <= 100.0f || Math.abs(f) <= 100.0f) {
                if (Math.abs(y) <= 100.0f || Math.abs(f2) <= 100.0f) {
                    return false;
                }
                if (y > 0.0f) {
                    coVar.b();
                    return false;
                }
                coVar.c();
                return false;
            } else if (x > 0.0f) {
                coVar.getClass();
                return true;
            } else {
                coVar.getClass();
                return true;
            }
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            C0827co.this.a();
            return true;
        }
    }

    public C0827co(Activity activity) {
        this.a = new GestureDetector(activity, new a());
    }

    public void b() {
        throw null;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.onTouchEvent(motionEvent);
    }

    public void a() {
    }

    public void c() {
    }
}
