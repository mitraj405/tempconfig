package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

@SuppressLint({"ViewConstructor"})
/* renamed from: re  reason: default package and case insensitive filesystem */
/* compiled from: GhostViewPort */
public final class C0319re extends ViewGroup implements C0290oe {
    public static final /* synthetic */ int d = 0;
    public Matrix a;

    /* renamed from: a  reason: collision with other field name */
    public View f3223a;

    /* renamed from: a  reason: collision with other field name */
    public ViewGroup f3224a;

    /* renamed from: a  reason: collision with other field name */
    public final a f3225a = new a();
    public final View b;
    public int c;

    /* renamed from: re$a */
    /* compiled from: GhostViewPort */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        public final boolean onPreDraw() {
            View view;
            C0319re reVar = C0319re.this;
            reVar.postInvalidateOnAnimation();
            ViewGroup viewGroup = reVar.f3224a;
            if (viewGroup == null || (view = reVar.f3223a) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            reVar.f3224a.postInvalidateOnAnimation();
            reVar.f3224a = null;
            reVar.f3223a = null;
            return true;
        }
    }

    public C0319re(View view) {
        super(view.getContext());
        this.b = view;
        setWillNotDraw(false);
        setClipChildren(false);
        setLayerType(2, (Paint) null);
    }

    public static void b(View view, ViewGroup viewGroup) {
        TC.a(viewGroup, viewGroup.getLeft(), viewGroup.getTop(), view.getWidth() + viewGroup.getLeft(), view.getHeight() + viewGroup.getTop());
    }

    public final void a(ViewGroup viewGroup, View view) {
        this.f3224a = viewGroup;
        this.f3223a = view;
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        int i = Br.ghost_view;
        View view = this.b;
        view.setTag(i, this);
        view.getViewTreeObserver().addOnPreDrawListener(this.f3225a);
        TC.c(view, 4);
        if (view.getParent() != null) {
            ((View) view.getParent()).invalidate();
        }
    }

    public final void onDetachedFromWindow() {
        View view = this.b;
        view.getViewTreeObserver().removeOnPreDrawListener(this.f3225a);
        TC.c(view, 0);
        view.setTag(Br.ghost_view, (Object) null);
        if (view.getParent() != null) {
            ((View) view.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    public final void onDraw(Canvas canvas) {
        D4.a(canvas, true);
        canvas.setMatrix(this.a);
        View view = this.b;
        TC.c(view, 0);
        view.invalidate();
        TC.c(view, 4);
        drawChild(canvas, view, getDrawingTime());
        D4.a(canvas, false);
    }

    public final void setVisibility(int i) {
        int i2;
        super.setVisibility(i);
        int i3 = Br.ghost_view;
        View view = this.b;
        if (((C0319re) view.getTag(i3)) == this) {
            if (i == 0) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            TC.c(view, i2);
        }
    }

    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }
}
