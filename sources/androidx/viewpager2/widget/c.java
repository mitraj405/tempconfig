package androidx.viewpager2.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* compiled from: ScrollEventAdapter */
public final class c extends RecyclerView.OnScrollListener {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final LinearLayoutManager f2624a;

    /* renamed from: a  reason: collision with other field name */
    public final RecyclerView f2625a;

    /* renamed from: a  reason: collision with other field name */
    public ViewPager2.g f2626a;

    /* renamed from: a  reason: collision with other field name */
    public final ViewPager2 f2627a;

    /* renamed from: a  reason: collision with other field name */
    public final a f2628a = new a();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2629a;
    public int b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f2630b;
    public int c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f2631c;
    public int d;

    /* renamed from: d  reason: collision with other field name */
    public boolean f2632d;

    /* compiled from: ScrollEventAdapter */
    public static final class a {
        public float a;

        /* renamed from: a  reason: collision with other field name */
        public int f2633a;
        public int b;
    }

    public c(ViewPager2 viewPager2) {
        this.f2627a = viewPager2;
        ViewPager2.k kVar = viewPager2.f2613a;
        this.f2625a = kVar;
        this.f2624a = (LinearLayoutManager) kVar.getLayoutManager();
        b();
    }

    public final void a(int i) {
        if ((this.a != 3 || this.b != 0) && this.b != i) {
            this.b = i;
            ViewPager2.g gVar = this.f2626a;
            if (gVar != null) {
                gVar.onPageScrollStateChanged(i);
            }
        }
    }

    public final void b() {
        this.a = 0;
        this.b = 0;
        a aVar = this.f2628a;
        aVar.f2633a = -1;
        aVar.a = 0.0f;
        aVar.b = 0;
        this.c = -1;
        this.d = -1;
        this.f2629a = false;
        this.f2630b = false;
        this.f2632d = false;
        this.f2631c = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0122, code lost:
        if (r5[r1 - 1][1] >= r6) goto L_0x0125;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0146 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c() {
        /*
            r13 = this;
            androidx.recyclerview.widget.LinearLayoutManager r0 = r13.f2624a
            int r1 = r0.findFirstVisibleItemPosition()
            androidx.viewpager2.widget.c$a r2 = r13.f2628a
            r2.f2633a = r1
            r3 = 0
            r4 = 0
            r5 = -1
            if (r1 != r5) goto L_0x0016
            r2.f2633a = r5
            r2.a = r3
            r2.b = r4
            return
        L_0x0016:
            android.view.View r1 = r0.findViewByPosition(r1)
            if (r1 != 0) goto L_0x0023
            r2.f2633a = r5
            r2.a = r3
            r2.b = r4
            return
        L_0x0023:
            int r5 = r0.getLeftDecorationWidth(r1)
            int r6 = r0.getRightDecorationWidth(r1)
            int r7 = r0.getTopDecorationHeight(r1)
            int r8 = r0.getBottomDecorationHeight(r1)
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            boolean r10 = r9 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r10 == 0) goto L_0x0049
            android.view.ViewGroup$MarginLayoutParams r9 = (android.view.ViewGroup.MarginLayoutParams) r9
            int r10 = r9.leftMargin
            int r5 = r5 + r10
            int r10 = r9.rightMargin
            int r6 = r6 + r10
            int r10 = r9.topMargin
            int r7 = r7 + r10
            int r9 = r9.bottomMargin
            int r8 = r8 + r9
        L_0x0049:
            int r9 = r1.getHeight()
            int r9 = r9 + r7
            int r9 = r9 + r8
            int r8 = r1.getWidth()
            int r8 = r8 + r5
            int r8 = r8 + r6
            int r6 = r0.getOrientation()
            r10 = 1
            if (r6 != 0) goto L_0x005e
            r6 = r10
            goto L_0x005f
        L_0x005e:
            r6 = r4
        L_0x005f:
            androidx.recyclerview.widget.RecyclerView r11 = r13.f2625a
            if (r6 == 0) goto L_0x007f
            int r1 = r1.getLeft()
            int r1 = r1 - r5
            int r5 = r11.getPaddingLeft()
            int r1 = r1 - r5
            androidx.viewpager2.widget.ViewPager2 r5 = r13.f2627a
            androidx.viewpager2.widget.ViewPager2$f r5 = r5.f2610a
            int r5 = r5.getLayoutDirection()
            if (r5 != r10) goto L_0x0079
            r5 = r10
            goto L_0x007a
        L_0x0079:
            r5 = r4
        L_0x007a:
            if (r5 == 0) goto L_0x007d
            int r1 = -r1
        L_0x007d:
            r9 = r8
            goto L_0x0089
        L_0x007f:
            int r1 = r1.getTop()
            int r1 = r1 - r7
            int r5 = r11.getPaddingTop()
            int r1 = r1 - r5
        L_0x0089:
            int r1 = -r1
            r2.b = r1
            if (r1 >= 0) goto L_0x016e
            T0 r1 = new T0
            int r1 = r0.getChildCount()
            if (r1 != 0) goto L_0x0098
            goto L_0x0125
        L_0x0098:
            int r3 = r0.getOrientation()
            if (r3 != 0) goto L_0x00a0
            r3 = r10
            goto L_0x00a1
        L_0x00a0:
            r3 = r4
        L_0x00a1:
            r5 = 2
            int[] r6 = new int[r5]
            r6[r10] = r5
            r6[r4] = r1
            java.lang.Class r5 = java.lang.Integer.TYPE
            java.lang.Object r5 = java.lang.reflect.Array.newInstance(r5, r6)
            int[][] r5 = (int[][]) r5
            r6 = r4
        L_0x00b1:
            if (r6 >= r1) goto L_0x00f9
            android.view.View r7 = r0.getChildAt(r6)
            if (r7 == 0) goto L_0x00f1
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            boolean r9 = r8 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r9 == 0) goto L_0x00c4
            android.view.ViewGroup$MarginLayoutParams r8 = (android.view.ViewGroup.MarginLayoutParams) r8
            goto L_0x00c6
        L_0x00c4:
            android.view.ViewGroup$MarginLayoutParams r8 = defpackage.T0.a
        L_0x00c6:
            r9 = r5[r6]
            if (r3 == 0) goto L_0x00d1
            int r11 = r7.getLeft()
            int r12 = r8.leftMargin
            goto L_0x00d7
        L_0x00d1:
            int r11 = r7.getTop()
            int r12 = r8.topMargin
        L_0x00d7:
            int r11 = r11 - r12
            r9[r4] = r11
            r9 = r5[r6]
            if (r3 == 0) goto L_0x00e5
            int r7 = r7.getRight()
            int r8 = r8.rightMargin
            goto L_0x00eb
        L_0x00e5:
            int r7 = r7.getBottom()
            int r8 = r8.bottomMargin
        L_0x00eb:
            int r7 = r7 + r8
            r9[r10] = r7
            int r6 = r6 + 1
            goto L_0x00b1
        L_0x00f1:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "null view contained in the view hierarchy"
            r0.<init>(r1)
            throw r0
        L_0x00f9:
            S0 r3 = new S0
            r3.<init>()
            java.util.Arrays.sort(r5, r3)
            r3 = r10
        L_0x0102:
            if (r3 >= r1) goto L_0x0114
            int r6 = r3 + -1
            r6 = r5[r6]
            r6 = r6[r10]
            r7 = r5[r3]
            r7 = r7[r4]
            if (r6 == r7) goto L_0x0111
            goto L_0x0127
        L_0x0111:
            int r3 = r3 + 1
            goto L_0x0102
        L_0x0114:
            r3 = r5[r4]
            r6 = r3[r10]
            r3 = r3[r4]
            int r6 = r6 - r3
            if (r3 > 0) goto L_0x0127
            int r1 = r1 - r10
            r1 = r5[r1]
            r1 = r1[r10]
            if (r1 >= r6) goto L_0x0125
            goto L_0x0127
        L_0x0125:
            r1 = r10
            goto L_0x0128
        L_0x0127:
            r1 = r4
        L_0x0128:
            if (r1 == 0) goto L_0x0130
            int r1 = r0.getChildCount()
            if (r1 > r10) goto L_0x014b
        L_0x0130:
            int r1 = r0.getChildCount()
            r3 = r4
        L_0x0135:
            if (r3 >= r1) goto L_0x0146
            android.view.View r5 = r0.getChildAt(r3)
            boolean r5 = defpackage.T0.a(r5)
            if (r5 == 0) goto L_0x0143
            r0 = r10
            goto L_0x0147
        L_0x0143:
            int r3 = r3 + 1
            goto L_0x0135
        L_0x0146:
            r0 = r4
        L_0x0147:
            if (r0 == 0) goto L_0x014b
            r0 = r10
            goto L_0x014c
        L_0x014b:
            r0 = r4
        L_0x014c:
            if (r0 == 0) goto L_0x0156
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started."
            r0.<init>(r1)
            throw r0
        L_0x0156:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.util.Locale r1 = java.util.Locale.US
            java.lang.Object[] r3 = new java.lang.Object[r10]
            int r2 = r2.b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3[r4] = r2
            java.lang.String r2 = "Page can only be offset by a positive amount, not by %d"
            java.lang.String r1 = java.lang.String.format(r1, r2, r3)
            r0.<init>(r1)
            throw r0
        L_0x016e:
            if (r9 != 0) goto L_0x0171
            goto L_0x0175
        L_0x0171:
            float r0 = (float) r1
            float r1 = (float) r9
            float r3 = r0 / r1
        L_0x0175:
            r2.a = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.c.c():void");
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z;
        boolean z2;
        ViewPager2.g gVar;
        ViewPager2.g gVar2;
        int i2 = this.a;
        boolean z3 = true;
        if (!(i2 == 1 && this.b == 1) && i == 1) {
            this.f2632d = false;
            this.a = 1;
            int i3 = this.d;
            if (i3 != -1) {
                this.c = i3;
                this.d = -1;
            } else if (this.c == -1) {
                this.c = this.f2624a.findFirstVisibleItemPosition();
            }
            a(1);
            return;
        }
        if (i2 == 1 || i2 == 4) {
            z = true;
        } else {
            z = false;
        }
        if (!z || i != 2) {
            if (i2 == 1 || i2 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            a aVar = this.f2628a;
            if (z2 && i == 0) {
                c();
                if (!this.f2630b) {
                    int i4 = aVar.f2633a;
                    if (!(i4 == -1 || (gVar2 = this.f2626a) == null)) {
                        gVar2.onPageScrolled(i4, 0.0f, 0);
                    }
                } else if (aVar.b == 0) {
                    int i5 = this.c;
                    int i6 = aVar.f2633a;
                    if (!(i5 == i6 || (gVar = this.f2626a) == null)) {
                        gVar.onPageSelected(i6);
                    }
                } else {
                    z3 = false;
                }
                if (z3) {
                    a(0);
                    b();
                }
            }
            if (this.a == 2 && i == 0 && this.f2631c) {
                c();
                if (aVar.b == 0) {
                    int i7 = this.d;
                    int i8 = aVar.f2633a;
                    if (i7 != i8) {
                        if (i8 == -1) {
                            i8 = 0;
                        }
                        ViewPager2.g gVar3 = this.f2626a;
                        if (gVar3 != null) {
                            gVar3.onPageSelected(i8);
                        }
                    }
                    a(0);
                    b();
                }
            }
        } else if (this.f2630b) {
            a(2);
            this.f2629a = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0026, code lost:
        if (r7 == r8) goto L_0x002b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onScrolled(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
        /*
            r5 = this;
            r6 = 1
            r5.f2630b = r6
            r5.c()
            boolean r0 = r5.f2629a
            r1 = -1
            androidx.viewpager2.widget.c$a r2 = r5.f2628a
            r3 = 0
            if (r0 == 0) goto L_0x0046
            r5.f2629a = r3
            if (r8 > 0) goto L_0x002b
            if (r8 != 0) goto L_0x0029
            if (r7 >= 0) goto L_0x0018
            r7 = r6
            goto L_0x0019
        L_0x0018:
            r7 = r3
        L_0x0019:
            androidx.viewpager2.widget.ViewPager2 r8 = r5.f2627a
            androidx.viewpager2.widget.ViewPager2$f r8 = r8.f2610a
            int r8 = r8.getLayoutDirection()
            if (r8 != r6) goto L_0x0025
            r8 = r6
            goto L_0x0026
        L_0x0025:
            r8 = r3
        L_0x0026:
            if (r7 != r8) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r7 = r3
            goto L_0x002c
        L_0x002b:
            r7 = r6
        L_0x002c:
            if (r7 == 0) goto L_0x0036
            int r7 = r2.b
            if (r7 == 0) goto L_0x0036
            int r7 = r2.f2633a
            int r7 = r7 + r6
            goto L_0x0038
        L_0x0036:
            int r7 = r2.f2633a
        L_0x0038:
            r5.d = r7
            int r8 = r5.c
            if (r8 == r7) goto L_0x0056
            androidx.viewpager2.widget.ViewPager2$g r8 = r5.f2626a
            if (r8 == 0) goto L_0x0056
            r8.onPageSelected(r7)
            goto L_0x0056
        L_0x0046:
            int r7 = r5.a
            if (r7 != 0) goto L_0x0056
            int r7 = r2.f2633a
            if (r7 != r1) goto L_0x004f
            r7 = r3
        L_0x004f:
            androidx.viewpager2.widget.ViewPager2$g r8 = r5.f2626a
            if (r8 == 0) goto L_0x0056
            r8.onPageSelected(r7)
        L_0x0056:
            int r7 = r2.f2633a
            if (r7 != r1) goto L_0x005b
            r7 = r3
        L_0x005b:
            float r8 = r2.a
            int r0 = r2.b
            androidx.viewpager2.widget.ViewPager2$g r4 = r5.f2626a
            if (r4 == 0) goto L_0x0066
            r4.onPageScrolled(r7, r8, r0)
        L_0x0066:
            int r7 = r2.f2633a
            int r8 = r5.d
            if (r7 == r8) goto L_0x006e
            if (r8 != r1) goto L_0x007c
        L_0x006e:
            int r7 = r2.b
            if (r7 != 0) goto L_0x007c
            int r7 = r5.b
            if (r7 == r6) goto L_0x007c
            r5.a(r3)
            r5.b()
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.widget.c.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
