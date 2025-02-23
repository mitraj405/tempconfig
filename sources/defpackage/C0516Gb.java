package defpackage;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;

/* renamed from: Gb  reason: default package and case insensitive filesystem */
/* compiled from: ExpandTouchListener */
public final class C0516Gb implements View.OnTouchListener {
    public float a;

    /* renamed from: a  reason: collision with other field name */
    public final GestureDetector f3591a;

    /* renamed from: a  reason: collision with other field name */
    public final View f3592a;

    /* renamed from: a  reason: collision with other field name */
    public final AbsListView f3593a;

    /* renamed from: a  reason: collision with other field name */
    public final FrameLayout.LayoutParams f3594a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3595a;
    public boolean b;
    public final int c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f3596c;
    public final int d;
    public final int e;

    public C0516Gb(Activity activity, AbsListView absListView, ViewGroup viewGroup, int i, int i2, int i3) {
        this.f3593a = absListView;
        this.f3592a = viewGroup;
        this.e = i;
        this.c = i2;
        this.d = i3;
        this.f3594a = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        this.f3591a = new GestureDetector(activity, new C0484Db(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        if (r9 == false) goto L_0x0027;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r9, android.view.MotionEvent r10) {
        /*
            r8 = this;
            android.view.GestureDetector r9 = r8.f3591a
            boolean r9 = r9.onTouchEvent(r10)
            r0 = 0
            if (r9 == 0) goto L_0x000a
            return r0
        L_0x000a:
            boolean r9 = r8.f3596c
            r1 = 1
            if (r9 != 0) goto L_0x0027
            android.widget.AbsListView r9 = r8.f3593a
            int r2 = r9.getChildCount()
            if (r2 == 0) goto L_0x0024
            android.view.View r9 = r9.getChildAt(r0)
            int r9 = r9.getTop()
            if (r9 != 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r9 = r0
            goto L_0x0025
        L_0x0024:
            r9 = r1
        L_0x0025:
            if (r9 != 0) goto L_0x002c
        L_0x0027:
            boolean r9 = r8.f3595a
            if (r9 == 0) goto L_0x002c
            return r0
        L_0x002c:
            int r9 = r10.getAction()
            if (r9 == 0) goto L_0x00da
            int r2 = r8.d
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            android.widget.FrameLayout$LayoutParams r4 = r8.f3594a
            android.view.View r5 = r8.f3592a
            int r6 = r8.c
            if (r9 == r1) goto L_0x0090
            r7 = 2
            if (r9 == r7) goto L_0x0043
            goto L_0x00d9
        L_0x0043:
            int r9 = r4.height
            if (r9 != r6) goto L_0x004e
            int r9 = r9 - r1
            r4.height = r9
            r5.setLayoutParams(r4)
            return r0
        L_0x004e:
            float r9 = r8.a
            int r9 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r9 != 0) goto L_0x005a
            float r9 = r10.getRawY()
            r8.a = r9
        L_0x005a:
            float r9 = r8.a
            float r3 = r10.getRawY()
            float r9 = r9 - r3
            r3 = 0
            int r3 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0068
            r3 = r1
            goto L_0x0069
        L_0x0068:
            r3 = r0
        L_0x0069:
            r8.b = r3
            int r3 = r8.e
            r7 = 48
            if (r3 != r7) goto L_0x0072
            float r9 = -r9
        L_0x0072:
            float r10 = r10.getRawY()
            r8.a = r10
            int r10 = r4.height
            int r9 = (int) r9
            int r10 = r10 + r9
            if (r10 <= r6) goto L_0x007f
            r10 = r6
        L_0x007f:
            if (r10 >= r2) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            r2 = r10
        L_0x0083:
            r4.height = r2
            r5.setLayoutParams(r4)
            int r9 = r4.height
            if (r9 != r6) goto L_0x008d
            r0 = r1
        L_0x008d:
            r8.f3595a = r0
            goto L_0x00d9
        L_0x0090:
            r8.a = r3
            boolean r9 = r8.b
            if (r9 != 0) goto L_0x00a9
            int r10 = r4.height
            if (r10 >= r6) goto L_0x00a9
            int r0 = r6 * 4
            int r0 = r0 / 5
            if (r10 <= r0) goto L_0x00a9
            Eb r9 = new Eb
            r9.<init>(r8)
            defpackage.C0720VB.a(r5, r6, r9)
            goto L_0x00d9
        L_0x00a9:
            if (r9 == 0) goto L_0x00ba
            int r10 = r4.height
            int r0 = r2 + 50
            if (r10 <= r0) goto L_0x00ba
            Fb r9 = new Fb
            r9.<init>(r8)
            defpackage.C0720VB.a(r5, r6, r9)
            goto L_0x00d9
        L_0x00ba:
            if (r9 == 0) goto L_0x00cb
            int r10 = r4.height
            int r0 = r2 + 50
            if (r10 > r0) goto L_0x00cb
            Nw r9 = new Nw
            r9.<init>()
            defpackage.C0720VB.a(r5, r2, r9)
            goto L_0x00d9
        L_0x00cb:
            if (r9 != 0) goto L_0x00d9
            int r9 = r4.height
            if (r9 <= r2) goto L_0x00d9
            Nw r9 = new Nw
            r9.<init>()
            defpackage.C0720VB.a(r5, r2, r9)
        L_0x00d9:
            return r1
        L_0x00da:
            float r9 = r10.getRawY()
            r8.a = r9
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0516Gb.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
