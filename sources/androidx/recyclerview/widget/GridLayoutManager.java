package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.common.primitives.Ints;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    public int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final Rect f2288a = new Rect();

    /* renamed from: a  reason: collision with other field name */
    public final SparseIntArray f2289a = new SparseIntArray();

    /* renamed from: a  reason: collision with other field name */
    public final a f2290a = new a();

    /* renamed from: a  reason: collision with other field name */
    public boolean f2291a = false;

    /* renamed from: a  reason: collision with other field name */
    public int[] f2292a;

    /* renamed from: a  reason: collision with other field name */
    public View[] f2293a;
    public final SparseIntArray b = new SparseIntArray();

    public static final class a extends b {
    }

    public static abstract class b {
        public final SparseIntArray a = new SparseIntArray();
        public final SparseIntArray b = new SparseIntArray();

        public static int a(int i, int i2) {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i3++;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = 1;
                }
            }
            if (i3 + 1 > i2) {
                return i4 + 1;
            }
            return i4;
        }

        public final void b() {
            this.a.clear();
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        g(RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2).b);
    }

    public final void a(int i) {
        int i2;
        int[] iArr = this.f2292a;
        int i3 = this.a;
        if (!(iArr != null && iArr.length == i3 + 1 && iArr[iArr.length - 1] == i)) {
            iArr = new int[(i3 + 1)];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i / i3;
        int i6 = i % i3;
        int i7 = 0;
        for (int i8 = 1; i8 <= i3; i8++) {
            i4 += i6;
            if (i4 <= 0 || i3 - i4 >= i6) {
                i2 = i5;
            } else {
                i2 = i5 + 1;
                i4 -= i3;
            }
            i7 += i2;
            iArr[i8] = i7;
        }
        this.f2292a = iArr;
    }

    public final int b(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.f2292a;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.f2292a;
        int i3 = this.a;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public final int c(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.f2324b;
        a aVar = this.f2290a;
        if (!z) {
            int i2 = this.a;
            aVar.getClass();
            return b.a(i, i2);
        }
        int b2 = recycler.b(i);
        if (b2 == -1) {
            return 0;
        }
        int i3 = this.a;
        aVar.getClass();
        return b.a(b2, i3);
    }

    public final boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final void collectPrefetchPositionsForLayoutState(RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, RecyclerView.LayoutManager.LayoutPrefetchRegistry layoutPrefetchRegistry) {
        boolean z;
        int i = this.a;
        int i2 = 0;
        while (i2 < this.a) {
            int i3 = layoutState.c;
            if (i3 < 0 || i3 >= state.b()) {
                z = false;
            } else {
                z = true;
            }
            if (z && i > 0) {
                layoutPrefetchRegistry.a(layoutState.c, Math.max(0, layoutState.f));
                this.f2290a.getClass();
                i--;
                layoutState.c += layoutState.d;
                i2++;
            } else {
                return;
            }
        }
    }

    public final int computeHorizontalScrollOffset(RecyclerView.State state) {
        return super.computeHorizontalScrollOffset(state);
    }

    public final int computeHorizontalScrollRange(RecyclerView.State state) {
        return super.computeHorizontalScrollRange(state);
    }

    public final int computeVerticalScrollOffset(RecyclerView.State state) {
        return super.computeVerticalScrollOffset(state);
    }

    public final int computeVerticalScrollRange(RecyclerView.State state) {
        return super.computeVerticalScrollRange(state);
    }

    public final int d(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.f2324b;
        a aVar = this.f2290a;
        if (!z) {
            int i2 = this.a;
            aVar.getClass();
            return i % i2;
        }
        int i3 = this.b.get(i, -1);
        if (i3 != -1) {
            return i3;
        }
        int b2 = recycler.b(i);
        if (b2 == -1) {
            return 0;
        }
        int i4 = this.a;
        aVar.getClass();
        return b2 % i4;
    }

    public final int e(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.f2324b;
        a aVar = this.f2290a;
        if (!z) {
            aVar.getClass();
            return 1;
        }
        int i2 = this.f2289a.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        if (recycler.b(i) == -1) {
            return 1;
        }
        aVar.getClass();
        return 1;
    }

    public final void f(View view, int i, boolean z) {
        int i2;
        int i3;
        boolean z2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.a;
        int i4 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i5 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int b2 = b(layoutParams.a, layoutParams.b);
        if (this.mOrientation == 1) {
            i2 = RecyclerView.LayoutManager.getChildMeasureSpec(b2, i, i5, layoutParams.width, false);
            i3 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.l(), getHeightMode(), i4, layoutParams.height, true);
        } else {
            int childMeasureSpec = RecyclerView.LayoutManager.getChildMeasureSpec(b2, i, i4, layoutParams.height, false);
            int childMeasureSpec2 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.l(), getWidthMode(), i5, layoutParams.width, true);
            i3 = childMeasureSpec;
            i2 = childMeasureSpec2;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            z2 = shouldReMeasureChild(view, i2, i3, layoutParams2);
        } else {
            z2 = shouldMeasureChild(view, i2, i3, layoutParams2);
        }
        if (z2) {
            view.measure(i2, i3);
        }
    }

    public final View findReferenceChild(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z, boolean z2) {
        int i;
        int i2;
        int childCount = getChildCount();
        int i3 = 1;
        if (z2) {
            i2 = getChildCount() - 1;
            i = -1;
            i3 = -1;
        } else {
            i = childCount;
            i2 = 0;
        }
        int b2 = state.b();
        ensureLayoutState();
        int k = this.mOrientationHelper.k();
        int g = this.mOrientationHelper.g();
        View view = null;
        View view2 = null;
        while (i2 != i) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < b2 && d(position, recycler, state) == 0) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.mOrientationHelper.e(childAt) < g && this.mOrientationHelper.b(childAt) >= k) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i3;
        }
        if (view != null) {
            return view;
        }
        return view2;
    }

    public final void g(int i) {
        if (i != this.a) {
            this.f2291a = true;
            if (i >= 1) {
                this.a = i;
                this.f2290a.b();
                requestLayout();
                return;
            }
            throw new IllegalArgumentException(lf.h("Span count should be at least 1. Provided ", i));
        }
    }

    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    public final RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public final int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 1) {
            return this.a;
        }
        if (state.b() < 1) {
            return 0;
        }
        return c(state.b() - 1, recycler, state) + 1;
    }

    public final int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mOrientation == 0) {
            return this.a;
        }
        if (state.b() < 1) {
            return 0;
        }
        return c(state.b() - 1, recycler, state) + 1;
    }

    public final void h() {
        int i;
        int i2;
        if (getOrientation() == 1) {
            i2 = getWidth() - getPaddingRight();
            i = getPaddingLeft();
        } else {
            i2 = getHeight() - getPaddingBottom();
            i = getPaddingTop();
        }
        a(i2 - i);
    }

    public final void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.LayoutState layoutState, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        boolean z3;
        boolean z4;
        View b2;
        RecyclerView.Recycler recycler2 = recycler;
        RecyclerView.State state2 = state;
        LinearLayoutManager.LayoutState layoutState2 = layoutState;
        LinearLayoutManager.LayoutChunkResult layoutChunkResult2 = layoutChunkResult;
        int j = this.mOrientationHelper.j();
        if (j != 1073741824) {
            z = true;
        } else {
            z = false;
        }
        if (getChildCount() > 0) {
            i = this.f2292a[this.a];
        } else {
            i = 0;
        }
        if (z) {
            h();
        }
        if (layoutState2.d == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        int i20 = this.a;
        if (!z2) {
            i20 = d(layoutState2.c, recycler2, state2) + e(layoutState2.c, recycler2, state2);
        }
        int i21 = 0;
        while (i21 < this.a) {
            int i22 = layoutState2.c;
            if (i22 < 0 || i22 >= state.b()) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (!z4 || i20 <= 0) {
                break;
            }
            int i23 = layoutState2.c;
            int e = e(i23, recycler2, state2);
            if (e <= this.a) {
                i20 -= e;
                if (i20 < 0 || (b2 = layoutState2.b(recycler2)) == null) {
                    break;
                }
                this.f2293a[i21] = b2;
                i21++;
            } else {
                throw new IllegalArgumentException(lf.k(C1058d.C("Item at position ", i23, " requires ", e, " spans but GridLayoutManager has only "), this.a, " spans."));
            }
        }
        if (i21 == 0) {
            layoutChunkResult2.f2297a = true;
            return;
        }
        if (z2) {
            i2 = 1;
            i3 = i21;
            i4 = 0;
        } else {
            i4 = i21 - 1;
            i3 = -1;
            i2 = -1;
        }
        int i24 = 0;
        while (i4 != i3) {
            View view = this.f2293a[i4];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int e2 = e(getPosition(view), recycler2, state2);
            layoutParams.b = e2;
            layoutParams.a = i24;
            i24 += e2;
            i4 += i2;
        }
        float f = 0.0f;
        int i25 = 0;
        for (int i26 = 0; i26 < i21; i26++) {
            View view2 = this.f2293a[i26];
            if (layoutState2.f2298a != null) {
                z3 = false;
                if (z2) {
                    addDisappearingView(view2);
                } else {
                    addDisappearingView(view2, 0);
                }
            } else if (z2) {
                addView(view2);
                z3 = false;
            } else {
                z3 = false;
                addView(view2, 0);
            }
            calculateItemDecorationsForChild(view2, this.f2288a);
            f(view2, j, z3);
            int c = this.mOrientationHelper.c(view2);
            if (c > i25) {
                i25 = c;
            }
            float d = (((float) this.mOrientationHelper.d(view2)) * 1.0f) / ((float) ((LayoutParams) view2.getLayoutParams()).b);
            if (d > f) {
                f = d;
            }
        }
        if (z) {
            a(Math.max(Math.round(f * ((float) this.a)), i));
            i25 = 0;
            for (int i27 = 0; i27 < i21; i27++) {
                View view3 = this.f2293a[i27];
                f(view3, Ints.MAX_POWER_OF_TWO, true);
                int c2 = this.mOrientationHelper.c(view3);
                if (c2 > i25) {
                    i25 = c2;
                }
            }
        }
        for (int i28 = 0; i28 < i21; i28++) {
            View view4 = this.f2293a[i28];
            if (this.mOrientationHelper.c(view4) != i25) {
                LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
                Rect rect = layoutParams2.a;
                int i29 = rect.top + rect.bottom + layoutParams2.topMargin + layoutParams2.bottomMargin;
                int i30 = rect.left + rect.right + layoutParams2.leftMargin + layoutParams2.rightMargin;
                int b3 = b(layoutParams2.a, layoutParams2.b);
                if (this.mOrientation == 1) {
                    i19 = RecyclerView.LayoutManager.getChildMeasureSpec(b3, Ints.MAX_POWER_OF_TWO, i30, layoutParams2.width, false);
                    i18 = View.MeasureSpec.makeMeasureSpec(i25 - i29, Ints.MAX_POWER_OF_TWO);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i25 - i30, Ints.MAX_POWER_OF_TWO);
                    i18 = RecyclerView.LayoutManager.getChildMeasureSpec(b3, Ints.MAX_POWER_OF_TWO, i29, layoutParams2.height, false);
                    i19 = makeMeasureSpec;
                }
                if (shouldReMeasureChild(view4, i19, i18, (RecyclerView.LayoutParams) view4.getLayoutParams())) {
                    view4.measure(i19, i18);
                }
            }
        }
        int i31 = 0;
        layoutChunkResult2.a = i25;
        if (this.mOrientation == 1) {
            if (layoutState2.e == -1) {
                i17 = layoutState2.a;
                i16 = i17 - i25;
            } else {
                int i32 = layoutState2.a;
                i16 = i32;
                i17 = i25 + i32;
            }
            i7 = 0;
            i6 = i16;
            i5 = i17;
            i8 = 0;
        } else {
            if (layoutState2.e == -1) {
                i8 = layoutState2.a;
                i15 = i8 - i25;
            } else {
                int i33 = layoutState2.a;
                i15 = i33;
                i8 = i25 + i33;
            }
            i6 = 0;
            i7 = i15;
            i5 = 0;
        }
        while (i31 < i21) {
            View view5 = this.f2293a[i31];
            LayoutParams layoutParams3 = (LayoutParams) view5.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    i14 = getPaddingLeft() + this.f2292a[this.a - layoutParams3.a];
                    i13 = i14 - this.mOrientationHelper.d(view5);
                } else {
                    i13 = this.f2292a[layoutParams3.a] + getPaddingLeft();
                    i14 = this.mOrientationHelper.d(view5) + i13;
                }
                i11 = i13;
                i10 = i6;
                i9 = i5;
                i12 = i14;
            } else {
                int paddingTop = getPaddingTop() + this.f2292a[layoutParams3.a];
                i12 = i8;
                i11 = i7;
                i10 = paddingTop;
                i9 = this.mOrientationHelper.d(view5) + paddingTop;
            }
            layoutDecoratedWithMargins(view5, i11, i10, i12, i9);
            if (layoutParams3.c() || layoutParams3.b()) {
                layoutChunkResult2.b = true;
            }
            layoutChunkResult2.c |= view5.hasFocusable();
            i31++;
            i8 = i12;
            i7 = i11;
            i6 = i10;
            i5 = i9;
        }
        Arrays.fill(this.f2293a, (Object) null);
    }

    public final void onAnchorReady(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.AnchorInfo anchorInfo, int i) {
        boolean z;
        super.onAnchorReady(recycler, state, anchorInfo, i);
        h();
        if (state.b() > 0 && !state.f2324b) {
            if (i == 1) {
                z = true;
            } else {
                z = false;
            }
            int d = d(anchorInfo.a, recycler, state);
            if (z) {
                while (d > 0) {
                    int i2 = anchorInfo.a;
                    if (i2 <= 0) {
                        break;
                    }
                    int i3 = i2 - 1;
                    anchorInfo.a = i3;
                    d = d(i3, recycler, state);
                }
            } else {
                int b2 = state.b() - 1;
                int i4 = anchorInfo.a;
                while (i4 < b2) {
                    int i5 = i4 + 1;
                    int d2 = d(i5, recycler, state);
                    if (d2 <= d) {
                        break;
                    }
                    i4 = i5;
                    d = d2;
                }
                anchorInfo.a = i4;
            }
        }
        View[] viewArr = this.f2293a;
        if (viewArr == null || viewArr.length != this.a) {
            this.f2293a = new View[this.a];
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d6, code lost:
        if (r13 == r7) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f6, code lost:
        if (r13 == r11) goto L_0x00b8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0107  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View onFocusSearchFailed(android.view.View r24, int r25, androidx.recyclerview.widget.RecyclerView.Recycler r26, androidx.recyclerview.widget.RecyclerView.State r27) {
        /*
            r23 = this;
            r0 = r23
            r1 = r26
            r2 = r27
            android.view.View r3 = r23.findContainingItemView(r24)
            r4 = 0
            if (r3 != 0) goto L_0x000e
            return r4
        L_0x000e:
            android.view.ViewGroup$LayoutParams r5 = r3.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r5 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r5
            int r6 = r5.a
            int r5 = r5.b
            int r5 = r5 + r6
            android.view.View r7 = super.onFocusSearchFailed(r24, r25, r26, r27)
            if (r7 != 0) goto L_0x0020
            return r4
        L_0x0020:
            r7 = r25
            int r7 = r0.convertFocusDirectionToLayoutDirection(r7)
            r9 = 1
            if (r7 != r9) goto L_0x002b
            r7 = r9
            goto L_0x002c
        L_0x002b:
            r7 = 0
        L_0x002c:
            boolean r10 = r0.mShouldReverseLayout
            if (r7 == r10) goto L_0x0032
            r7 = r9
            goto L_0x0033
        L_0x0032:
            r7 = 0
        L_0x0033:
            r10 = -1
            if (r7 == 0) goto L_0x003e
            int r7 = r23.getChildCount()
            int r7 = r7 - r9
            r11 = r10
            r12 = r11
            goto L_0x0045
        L_0x003e:
            int r7 = r23.getChildCount()
            r11 = r7
            r12 = r9
            r7 = 0
        L_0x0045:
            int r13 = r0.mOrientation
            if (r13 != r9) goto L_0x0051
            boolean r13 = r23.isLayoutRTL()
            if (r13 == 0) goto L_0x0051
            r13 = r9
            goto L_0x0052
        L_0x0051:
            r13 = 0
        L_0x0052:
            int r14 = r0.c(r7, r1, r2)
            r15 = r10
            r16 = r15
            r8 = 0
            r17 = 0
            r10 = r7
            r7 = r4
        L_0x005e:
            if (r10 == r11) goto L_0x0149
            int r9 = r0.c(r10, r1, r2)
            android.view.View r1 = r0.getChildAt(r10)
            if (r1 != r3) goto L_0x006c
            goto L_0x0149
        L_0x006c:
            boolean r18 = r1.hasFocusable()
            if (r18 == 0) goto L_0x0086
            if (r9 == r14) goto L_0x0086
            if (r4 == 0) goto L_0x0078
            goto L_0x0149
        L_0x0078:
            r18 = r3
            r21 = r7
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
            goto L_0x0135
        L_0x0086:
            android.view.ViewGroup$LayoutParams r9 = r1.getLayoutParams()
            androidx.recyclerview.widget.GridLayoutManager$LayoutParams r9 = (androidx.recyclerview.widget.GridLayoutManager.LayoutParams) r9
            int r2 = r9.a
            r18 = r3
            int r3 = r9.b
            int r3 = r3 + r2
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x009e
            if (r2 != r6) goto L_0x009e
            if (r3 != r5) goto L_0x009e
            return r1
        L_0x009e:
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00a6
            if (r4 == 0) goto L_0x00ae
        L_0x00a6:
            boolean r19 = r1.hasFocusable()
            if (r19 != 0) goto L_0x00ba
            if (r7 != 0) goto L_0x00ba
        L_0x00ae:
            r21 = r7
        L_0x00b0:
            r19 = r8
            r20 = r11
            r7 = r16
            r8 = r17
        L_0x00b8:
            r11 = 1
            goto L_0x0105
        L_0x00ba:
            int r19 = java.lang.Math.max(r2, r6)
            int r20 = java.lang.Math.min(r3, r5)
            r21 = r7
            int r7 = r20 - r19
            boolean r19 = r1.hasFocusable()
            if (r19 == 0) goto L_0x00d9
            if (r7 <= r8) goto L_0x00cf
        L_0x00ce:
            goto L_0x00b0
        L_0x00cf:
            if (r7 != r8) goto L_0x00fc
            if (r2 <= r15) goto L_0x00d5
            r7 = 1
            goto L_0x00d6
        L_0x00d5:
            r7 = 0
        L_0x00d6:
            if (r13 != r7) goto L_0x00fc
            goto L_0x00ce
        L_0x00d9:
            if (r4 != 0) goto L_0x00fc
            r19 = r8
            r20 = r11
            r8 = 0
            r11 = 1
            boolean r22 = r0.isViewPartiallyVisible(r1, r8, r11)
            if (r22 == 0) goto L_0x0100
            r8 = r17
            if (r7 <= r8) goto L_0x00ee
            r7 = r16
            goto L_0x0105
        L_0x00ee:
            if (r7 != r8) goto L_0x00f9
            r7 = r16
            if (r2 <= r7) goto L_0x00f5
            goto L_0x00f6
        L_0x00f5:
            r11 = 0
        L_0x00f6:
            if (r13 != r11) goto L_0x0104
            goto L_0x00b8
        L_0x00f9:
            r7 = r16
            goto L_0x0104
        L_0x00fc:
            r19 = r8
            r20 = r11
        L_0x0100:
            r7 = r16
            r8 = r17
        L_0x0104:
            r11 = 0
        L_0x0105:
            if (r11 == 0) goto L_0x0135
            boolean r11 = r1.hasFocusable()
            if (r11 == 0) goto L_0x0123
            int r4 = r9.a
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r2 = r3 - r2
            r15 = r4
            r16 = r7
            r17 = r8
            r7 = r21
            r4 = r1
            r8 = r2
            goto L_0x013d
        L_0x0123:
            int r7 = r9.a
            int r3 = java.lang.Math.min(r3, r5)
            int r2 = java.lang.Math.max(r2, r6)
            int r17 = r3 - r2
            r16 = r7
            r8 = r19
            r7 = r1
            goto L_0x013d
        L_0x0135:
            r16 = r7
            r17 = r8
            r8 = r19
            r7 = r21
        L_0x013d:
            int r10 = r10 + r12
            r1 = r26
            r2 = r27
            r3 = r18
            r11 = r20
            r9 = 1
            goto L_0x005e
        L_0x0149:
            r21 = r7
            if (r4 == 0) goto L_0x014e
            goto L_0x0150
        L_0x014e:
            r4 = r21
        L_0x0150:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.onFocusSearchFailed(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public final void onInitializeAccessibilityNodeInfo(RecyclerView.Recycler recycler, RecyclerView.State state, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.j(GridView.class.getName());
    }

    public final void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int c = c(layoutParams2.a(), recycler, state);
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.l(AccessibilityNodeInfoCompat.e.a(layoutParams2.a, layoutParams2.b, c, 1, false, false));
            return;
        }
        accessibilityNodeInfoCompat.l(AccessibilityNodeInfoCompat.e.a(c, 1, layoutParams2.a, layoutParams2.b, false, false));
    }

    public final void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        a aVar = this.f2290a;
        aVar.b();
        aVar.b.clear();
    }

    public final void onItemsChanged(RecyclerView recyclerView) {
        a aVar = this.f2290a;
        aVar.b();
        aVar.b.clear();
    }

    public final void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        a aVar = this.f2290a;
        aVar.b();
        aVar.b.clear();
    }

    public final void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        a aVar = this.f2290a;
        aVar.b();
        aVar.b.clear();
    }

    public final void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        a aVar = this.f2290a;
        aVar.b();
        aVar.b.clear();
    }

    public final void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z = state.f2324b;
        SparseIntArray sparseIntArray = this.b;
        SparseIntArray sparseIntArray2 = this.f2289a;
        if (z) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
                int a2 = layoutParams.a();
                sparseIntArray2.put(a2, layoutParams.b);
                sparseIntArray.put(a2, layoutParams.a);
            }
        }
        super.onLayoutChildren(recycler, state);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    public final void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f2291a = false;
    }

    public final int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        h();
        View[] viewArr = this.f2293a;
        if (viewArr == null || viewArr.length != this.a) {
            this.f2293a = new View[this.a];
        }
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    public final int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        h();
        View[] viewArr = this.f2293a;
        if (viewArr == null || viewArr.length != this.a) {
            this.f2293a = new View[this.a];
        }
        return super.scrollVerticallyBy(i, recycler, state);
    }

    public final void setMeasuredDimension(Rect rect, int i, int i2) {
        int i3;
        int i4;
        if (this.f2292a == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            i4 = RecyclerView.LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.f2292a;
            i3 = RecyclerView.LayoutManager.chooseSize(i, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            i3 = RecyclerView.LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.f2292a;
            i4 = RecyclerView.LayoutManager.chooseSize(i2, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(i3, i4);
    }

    public final void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public final boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState != null || this.f2291a) {
            return false;
        }
        return true;
    }

    public final RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public int a = -1;
        public int b = 0;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public GridLayoutManager(Context context) {
        super(context);
        g(5);
    }

    public GridLayoutManager(ContextThemeWrapper contextThemeWrapper, int i) {
        super(contextThemeWrapper, 1, false);
        g(i);
    }
}
