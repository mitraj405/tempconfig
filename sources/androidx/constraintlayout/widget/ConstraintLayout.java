package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.e;
import androidx.constraintlayout.core.widgets.f;
import androidx.constraintlayout.core.widgets.h;
import com.google.android.gms.ads.AdRequest;
import com.google.common.primitives.Ints;
import com.google.firebase.sessions.settings.RemoteSettings;
import defpackage.D2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static SharedValues sSharedValues;
    SparseArray<View> mChildrenByIds = new SparseArray<>();
    /* access modifiers changed from: private */
    public ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    protected ConstraintLayoutStates mConstraintLayoutSpec = null;
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    protected boolean mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
    private int mLastMeasureHeight = -1;
    int mLastMeasureHeightMode = 0;
    int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    int mLastMeasureWidthMode = 0;
    int mLastMeasureWidthSize = -1;
    /* access modifiers changed from: protected */
    public ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    Measurer mMeasurer = new Measurer(this);
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOnMeasureHeightMeasureSpec = 0;
    private int mOnMeasureWidthMeasureSpec = 0;
    /* access modifiers changed from: private */
    public int mOptimizationLevel = 257;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget = new SparseArray<>();

    public class Measurer implements D2.b {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public final ConstraintLayout f1648a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;

        public Measurer(ConstraintLayout constraintLayout) {
            this.f1648a = constraintLayout;
        }

        public static boolean a(int i, int i2, int i3) {
            if (i == i2) {
                return ConstraintLayout.USE_CONSTRAINTS_HELPER;
            }
            int mode = View.MeasureSpec.getMode(i);
            View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                return false;
            }
            if ((mode == Integer.MIN_VALUE || mode == 0) && i3 == size) {
                return ConstraintLayout.USE_CONSTRAINTS_HELPER;
            }
            return false;
        }

        @SuppressLint({"WrongCall"})
        public final void b(ConstraintWidget constraintWidget, D2.a aVar) {
            int i;
            int i2;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            int i3;
            int i4;
            int i5;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            int i6;
            int i7;
            int i8;
            boolean z11;
            boolean z12;
            boolean z13;
            boolean z14;
            int i9;
            boolean z15;
            boolean z16;
            boolean z17;
            int i10;
            ConstraintWidget constraintWidget2 = constraintWidget;
            D2.a aVar2 = aVar;
            if (constraintWidget2 != null) {
                if (constraintWidget2.w == 8 && !constraintWidget2.f1389i) {
                    aVar2.c = 0;
                    aVar2.d = 0;
                    aVar2.e = 0;
                } else if (constraintWidget2.f1349a != null) {
                    ConstraintWidget.a aVar3 = aVar2.f107a;
                    ConstraintWidget.a aVar4 = aVar2.f109b;
                    int i11 = aVar2.a;
                    int i12 = aVar2.b;
                    int i13 = this.a + this.b;
                    int i14 = this.c;
                    View view = (View) constraintWidget2.f1351a;
                    int ordinal = aVar3.ordinal();
                    ConstraintAnchor constraintAnchor = constraintWidget2.f1371c;
                    ConstraintAnchor constraintAnchor2 = constraintWidget2.f1348a;
                    if (ordinal == 0) {
                        i = View.MeasureSpec.makeMeasureSpec(i11, Ints.MAX_POWER_OF_TWO);
                    } else if (ordinal == 1) {
                        i = ViewGroup.getChildMeasureSpec(this.e, i14, -2);
                    } else if (ordinal == 2) {
                        i = ViewGroup.getChildMeasureSpec(this.e, i14, -2);
                        if (constraintWidget2.f1381f == 1) {
                            z15 = true;
                        } else {
                            z15 = false;
                        }
                        int i15 = aVar2.f;
                        if (i15 == 1 || i15 == 2) {
                            if (view.getMeasuredHeight() == constraintWidget.o()) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (aVar2.f == 2 || !z15 || ((z15 && z16) || (view instanceof Placeholder) || constraintWidget.E())) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                i = View.MeasureSpec.makeMeasureSpec(constraintWidget.u(), Ints.MAX_POWER_OF_TWO);
                            }
                        }
                    } else if (ordinal != 3) {
                        i = 0;
                    } else {
                        int i16 = this.e;
                        if (constraintAnchor2 != null) {
                            i10 = constraintAnchor2.b + 0;
                        } else {
                            i10 = 0;
                        }
                        if (constraintAnchor != null) {
                            i10 += constraintAnchor.b;
                        }
                        i = ViewGroup.getChildMeasureSpec(i16, i14 + i10, -1);
                    }
                    int ordinal2 = aVar4.ordinal();
                    if (ordinal2 == 0) {
                        i2 = View.MeasureSpec.makeMeasureSpec(i12, Ints.MAX_POWER_OF_TWO);
                    } else if (ordinal2 == 1) {
                        i2 = ViewGroup.getChildMeasureSpec(this.f, i13, -2);
                    } else if (ordinal2 == 2) {
                        i2 = ViewGroup.getChildMeasureSpec(this.f, i13, -2);
                        if (constraintWidget2.f1384g == 1) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        int i17 = aVar2.f;
                        if (i17 == 1 || i17 == 2) {
                            if (view.getMeasuredWidth() == constraintWidget.u()) {
                                z13 = true;
                            } else {
                                z13 = false;
                            }
                            if (aVar2.f == 2 || !z12 || ((z12 && z13) || (view instanceof Placeholder) || constraintWidget.F())) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            if (z14) {
                                i2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.o(), Ints.MAX_POWER_OF_TWO);
                            }
                        }
                    } else if (ordinal2 != 3) {
                        i2 = 0;
                    } else {
                        int i18 = this.f;
                        if (constraintAnchor2 != null) {
                            i9 = constraintWidget2.f1363b.b + 0;
                        } else {
                            i9 = 0;
                        }
                        if (constraintAnchor != null) {
                            i9 += constraintWidget2.f1376d.b;
                        }
                        i2 = ViewGroup.getChildMeasureSpec(i18, i13 + i9, -1);
                    }
                    ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2.f1349a;
                    ConstraintLayout constraintLayout = ConstraintLayout.this;
                    if (constraintWidgetContainer != null && f.b(constraintLayout.mOptimizationLevel, 256) && view.getMeasuredWidth() == constraintWidget.u() && view.getMeasuredWidth() < constraintWidgetContainer.u() && view.getMeasuredHeight() == constraintWidget.o() && view.getMeasuredHeight() < constraintWidgetContainer.o() && view.getBaseline() == constraintWidget2.t && !constraintWidget.D()) {
                        if (!a(constraintWidget2.m, i, constraintWidget.u()) || !a(constraintWidget2.n, i2, constraintWidget.o())) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        if (z11) {
                            aVar2.c = constraintWidget.u();
                            aVar2.d = constraintWidget.o();
                            aVar2.e = constraintWidget2.t;
                            return;
                        }
                    }
                    ConstraintWidget.a aVar5 = ConstraintWidget.a.MATCH_CONSTRAINT;
                    if (aVar3 == aVar5) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (aVar4 == aVar5) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ConstraintWidget.a aVar6 = ConstraintWidget.a.MATCH_PARENT;
                    ConstraintWidget.a aVar7 = ConstraintWidget.a.FIXED;
                    if (aVar4 == aVar6 || aVar4 == aVar7) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (aVar3 == aVar6 || aVar3 == aVar7) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z || constraintWidget2.e <= 0.0f) {
                        z5 = false;
                    } else {
                        z5 = true;
                    }
                    if (!z2 || constraintWidget2.e <= 0.0f) {
                        z6 = false;
                    } else {
                        z6 = true;
                    }
                    if (view != null) {
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        int i19 = aVar2.f;
                        if (i19 == 1 || i19 == 2 || !z || constraintWidget2.f1381f != 0 || !z2 || constraintWidget2.f1384g != 0) {
                            if (!(view instanceof VirtualLayout) || !(constraintWidget2 instanceof h)) {
                                view.measure(i, i2);
                            } else {
                                ((VirtualLayout) view).u((h) constraintWidget2, i, i2);
                            }
                            constraintWidget2.m = i;
                            constraintWidget2.n = i2;
                            constraintWidget2.f1366b = false;
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            int baseline = view.getBaseline();
                            int i20 = constraintWidget2.h;
                            if (i20 > 0) {
                                i4 = Math.max(i20, measuredWidth);
                            } else {
                                i4 = measuredWidth;
                            }
                            int i21 = constraintWidget2.i;
                            if (i21 > 0) {
                                i4 = Math.min(i21, i4);
                            }
                            int i22 = constraintWidget2.j;
                            if (i22 > 0) {
                                i3 = Math.max(i22, measuredHeight);
                                i6 = i2;
                            } else {
                                i6 = i2;
                                i3 = measuredHeight;
                            }
                            int i23 = constraintWidget2.k;
                            if (i23 > 0) {
                                i3 = Math.min(i23, i3);
                            }
                            if (!f.b(constraintLayout.mOptimizationLevel, 1)) {
                                if (z5 && z3) {
                                    i4 = (int) ((((float) i3) * constraintWidget2.e) + 0.5f);
                                } else if (z6 && z4) {
                                    i3 = (int) ((((float) i4) / constraintWidget2.e) + 0.5f);
                                }
                            }
                            if (measuredWidth == i4 && measuredHeight == i3) {
                                i5 = baseline;
                                z7 = false;
                            } else {
                                if (measuredWidth != i4) {
                                    i7 = Ints.MAX_POWER_OF_TWO;
                                    i = View.MeasureSpec.makeMeasureSpec(i4, Ints.MAX_POWER_OF_TWO);
                                } else {
                                    i7 = Ints.MAX_POWER_OF_TWO;
                                }
                                if (measuredHeight != i3) {
                                    i8 = View.MeasureSpec.makeMeasureSpec(i3, i7);
                                } else {
                                    i8 = i6;
                                }
                                view.measure(i, i8);
                                constraintWidget2.m = i;
                                constraintWidget2.n = i8;
                                z7 = false;
                                constraintWidget2.f1366b = false;
                                int measuredWidth2 = view.getMeasuredWidth();
                                int measuredHeight2 = view.getMeasuredHeight();
                                i5 = view.getBaseline();
                                i3 = measuredHeight2;
                                i4 = measuredWidth2;
                            }
                        } else {
                            z7 = false;
                            i5 = 0;
                            i4 = 0;
                            i3 = 0;
                        }
                        if (i5 != -1) {
                            z8 = ConstraintLayout.USE_CONSTRAINTS_HELPER;
                        } else {
                            z8 = z7;
                        }
                        if (i4 == aVar2.a && i3 == aVar2.b) {
                            z9 = z7;
                        } else {
                            z9 = ConstraintLayout.USE_CONSTRAINTS_HELPER;
                        }
                        aVar2.f110b = z9;
                        if (layoutParams.f1640f) {
                            z10 = ConstraintLayout.USE_CONSTRAINTS_HELPER;
                        } else {
                            z10 = z8;
                        }
                        if (!(!z10 || i5 == -1 || constraintWidget2.t == i5)) {
                            aVar2.f110b = ConstraintLayout.USE_CONSTRAINTS_HELPER;
                        }
                        aVar2.c = i4;
                        aVar2.d = i3;
                        aVar2.f108a = z10;
                        aVar2.e = i5;
                    }
                }
            }
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        init((AttributeSet) null, 0, 0);
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        if (max2 > 0) {
            return max2;
        }
        return max;
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new SharedValues();
        }
        return sSharedValues;
    }

    private final ConstraintWidget getTargetWidget(int i) {
        if (i == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i);
        if (view == null && (view = findViewById(i)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f1627a;
    }

    private void init(AttributeSet attributeSet, int i, int i2) {
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        constraintWidgetContainer.f1351a = this;
        Measurer measurer = this.mMeasurer;
        constraintWidgetContainer.f1393a = measurer;
        constraintWidgetContainer.f1395a.f395a = measurer;
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0221hs.ConstraintLayout_Layout, i, i2);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == C0221hs.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == C0221hs.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == C0221hs.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == C0221hs.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == C0221hs.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == C0221hs.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == C0221hs.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.j(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutWidget;
        constraintWidgetContainer2.G = this.mOptimizationLevel;
        ei.c = constraintWidgetContainer2.Z(AdRequest.MAX_CONTENT_URL_LENGTH);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00be, code lost:
        r8 = java.lang.Integer.valueOf(r8);
        r10 = r4.f1622a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setChildrenConstraints() {
        /*
            r12 = this;
            boolean r6 = r12.isInEditMode()
            int r7 = r12.getChildCount()
            r0 = 0
            r1 = r0
        L_0x000a:
            if (r1 >= r7) goto L_0x001d
            android.view.View r2 = r12.getChildAt(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r12.getViewWidget(r2)
            if (r2 != 0) goto L_0x0017
            goto L_0x001a
        L_0x0017:
            r2.G()
        L_0x001a:
            int r1 = r1 + 1
            goto L_0x000a
        L_0x001d:
            r1 = -1
            if (r6 == 0) goto L_0x0059
            r2 = r0
        L_0x0021:
            if (r2 >= r7) goto L_0x0059
            android.view.View r3 = r12.getChildAt(r2)
            android.content.res.Resources r4 = r12.getResources()     // Catch:{ NotFoundException -> 0x0056 }
            int r5 = r3.getId()     // Catch:{ NotFoundException -> 0x0056 }
            java.lang.String r4 = r4.getResourceName(r5)     // Catch:{ NotFoundException -> 0x0056 }
            int r5 = r3.getId()     // Catch:{ NotFoundException -> 0x0056 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ NotFoundException -> 0x0056 }
            r12.setDesignInformation(r0, r4, r5)     // Catch:{ NotFoundException -> 0x0056 }
            r5 = 47
            int r5 = r4.indexOf(r5)     // Catch:{ NotFoundException -> 0x0056 }
            if (r5 == r1) goto L_0x004c
            int r5 = r5 + 1
            java.lang.String r4 = r4.substring(r5)     // Catch:{ NotFoundException -> 0x0056 }
        L_0x004c:
            int r3 = r3.getId()     // Catch:{ NotFoundException -> 0x0056 }
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r12.getTargetWidget(r3)     // Catch:{ NotFoundException -> 0x0056 }
            r3.f1365b = r4     // Catch:{ NotFoundException -> 0x0056 }
        L_0x0056:
            int r2 = r2 + 1
            goto L_0x0021
        L_0x0059:
            int r2 = r12.mConstraintSetId
            if (r2 == r1) goto L_0x007b
            r2 = r0
        L_0x005e:
            if (r2 >= r7) goto L_0x007b
            android.view.View r3 = r12.getChildAt(r2)
            int r4 = r3.getId()
            int r5 = r12.mConstraintSetId
            if (r4 != r5) goto L_0x0078
            boolean r4 = r3 instanceof androidx.constraintlayout.widget.Constraints
            if (r4 == 0) goto L_0x0078
            androidx.constraintlayout.widget.Constraints r3 = (androidx.constraintlayout.widget.Constraints) r3
            androidx.constraintlayout.widget.ConstraintSet r3 = r3.getConstraintSet()
            r12.mConstraintSet = r3
        L_0x0078:
            int r2 = r2 + 1
            goto L_0x005e
        L_0x007b:
            androidx.constraintlayout.widget.ConstraintSet r2 = r12.mConstraintSet
            if (r2 == 0) goto L_0x0082
            r2.c(r12)
        L_0x0082:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = r12.mLayoutWidget
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r2.b
            r2.clear()
            java.util.ArrayList<androidx.constraintlayout.widget.ConstraintHelper> r2 = r12.mConstraintHelpers
            int r2 = r2.size()
            if (r2 <= 0) goto L_0x00f5
            r3 = r0
        L_0x0092:
            if (r3 >= r2) goto L_0x00f5
            java.util.ArrayList<androidx.constraintlayout.widget.ConstraintHelper> r4 = r12.mConstraintHelpers
            java.lang.Object r4 = r4.get(r3)
            androidx.constraintlayout.widget.ConstraintHelper r4 = (androidx.constraintlayout.widget.ConstraintHelper) r4
            boolean r5 = r4.isInEditMode()
            if (r5 == 0) goto L_0x00a7
            java.lang.String r5 = r4.f1625c
            r4.setIds(r5)
        L_0x00a7:
            Te r5 = r4.a
            if (r5 != 0) goto L_0x00ac
            goto L_0x00f2
        L_0x00ac:
            r5.a()
            r5 = r0
        L_0x00b0:
            int r8 = r4.c
            if (r5 >= r8) goto L_0x00ed
            int[] r8 = r4.f1623a
            r8 = r8[r5]
            android.view.View r9 = r12.getViewById(r8)
            if (r9 != 0) goto L_0x00df
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.util.HashMap<java.lang.Integer, java.lang.String> r10 = r4.f1622a
            java.lang.Object r8 = r10.get(r8)
            java.lang.String r8 = (java.lang.String) r8
            int r11 = r4.k(r12, r8)
            if (r11 == 0) goto L_0x00df
            int[] r9 = r4.f1623a
            r9[r5] = r11
            java.lang.Integer r9 = java.lang.Integer.valueOf(r11)
            r10.put(r9, r8)
            android.view.View r9 = r12.getViewById(r11)
        L_0x00df:
            if (r9 == 0) goto L_0x00ea
            Te r8 = r4.a
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r12.getViewWidget(r9)
            r8.c(r9)
        L_0x00ea:
            int r5 = r5 + 1
            goto L_0x00b0
        L_0x00ed:
            Te r4 = r4.a
            r4.b()
        L_0x00f2:
            int r3 = r3 + 1
            goto L_0x0092
        L_0x00f5:
            r2 = r0
        L_0x00f6:
            if (r2 >= r7) goto L_0x012f
            android.view.View r3 = r12.getChildAt(r2)
            boolean r4 = r3 instanceof androidx.constraintlayout.widget.Placeholder
            if (r4 == 0) goto L_0x012c
            androidx.constraintlayout.widget.Placeholder r3 = (androidx.constraintlayout.widget.Placeholder) r3
            int r4 = r3.c
            if (r4 != r1) goto L_0x0111
            boolean r4 = r3.isInEditMode()
            if (r4 != 0) goto L_0x0111
            int r4 = r3.d
            r3.setVisibility(r4)
        L_0x0111:
            int r4 = r3.c
            android.view.View r4 = r12.findViewById(r4)
            r3.a = r4
            if (r4 == 0) goto L_0x012c
            android.view.ViewGroup$LayoutParams r4 = r4.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
            r5 = 1
            r4.f1646i = r5
            android.view.View r4 = r3.a
            r4.setVisibility(r0)
            r3.setVisibility(r0)
        L_0x012c:
            int r2 = r2 + 1
            goto L_0x00f6
        L_0x012f:
            android.util.SparseArray<androidx.constraintlayout.core.widgets.ConstraintWidget> r1 = r12.mTempMapIdToWidget
            r1.clear()
            android.util.SparseArray<androidx.constraintlayout.core.widgets.ConstraintWidget> r1 = r12.mTempMapIdToWidget
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r2 = r12.mLayoutWidget
            r1.put(r0, r2)
            android.util.SparseArray<androidx.constraintlayout.core.widgets.ConstraintWidget> r1 = r12.mTempMapIdToWidget
            int r2 = r12.getId()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r3 = r12.mLayoutWidget
            r1.put(r2, r3)
            r1 = r0
        L_0x0147:
            if (r1 >= r7) goto L_0x015d
            android.view.View r2 = r12.getChildAt(r1)
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r12.getViewWidget(r2)
            android.util.SparseArray<androidx.constraintlayout.core.widgets.ConstraintWidget> r4 = r12.mTempMapIdToWidget
            int r2 = r2.getId()
            r4.put(r2, r3)
            int r1 = r1 + 1
            goto L_0x0147
        L_0x015d:
            r8 = r0
        L_0x015e:
            if (r8 >= r7) goto L_0x0193
            android.view.View r2 = r12.getChildAt(r8)
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = r12.getViewWidget(r2)
            if (r3 != 0) goto L_0x016b
            goto L_0x0190
        L_0x016b:
            android.view.ViewGroup$LayoutParams r0 = r2.getLayoutParams()
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r4 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r4
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = r12.mLayoutWidget
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r1 = r0.b
            r1.add(r3)
            androidx.constraintlayout.core.widgets.ConstraintWidget r1 = r3.f1349a
            if (r1 == 0) goto L_0x0187
            AD r1 = (defpackage.AD) r1
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r1 = r1.b
            r1.remove(r3)
            r3.G()
        L_0x0187:
            r3.f1349a = r0
            android.util.SparseArray<androidx.constraintlayout.core.widgets.ConstraintWidget> r5 = r12.mTempMapIdToWidget
            r0 = r12
            r1 = r6
            r0.applyConstraintsFromLayoutParams(r1, r2, r3, r4, r5)
        L_0x0190:
            int r8 = r8 + 1
            goto L_0x015e
        L_0x0193:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.setChildrenConstraints():void");
    }

    private void setWidgetBaseline(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray, int i, ConstraintAnchor.Type type) {
        View view = this.mChildrenByIds.get(i);
        ConstraintWidget constraintWidget2 = sparseArray.get(i);
        if (constraintWidget2 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
            layoutParams.f1640f = USE_CONSTRAINTS_HELPER;
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
            if (type == type2) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.f1640f = USE_CONSTRAINTS_HELPER;
                layoutParams2.f1627a.f1388h = USE_CONSTRAINTS_HELPER;
            }
            constraintWidget.m(type2).b(constraintWidget2.m(type), layoutParams.A, layoutParams.z, USE_CONSTRAINTS_HELPER);
            constraintWidget.f1388h = USE_CONSTRAINTS_HELPER;
            constraintWidget.m(ConstraintAnchor.Type.TOP).j();
            constraintWidget.m(ConstraintAnchor.Type.BOTTOM).j();
        }
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            } else if (getChildAt(i).isLayoutRequested()) {
                z = USE_CONSTRAINTS_HELPER;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            setChildrenConstraints();
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:155:0x02f3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void applyConstraintsFromLayoutParams(boolean r22, android.view.View r23, androidx.constraintlayout.core.widgets.ConstraintWidget r24, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams r25, android.util.SparseArray<androidx.constraintlayout.core.widgets.ConstraintWidget> r26) {
        /*
            r21 = this;
            r0 = r23
            r6 = r24
            r7 = r25
            r8 = r26
            r25.a()
            int r1 = r23.getVisibility()
            r6.w = r1
            boolean r1 = r7.f1646i
            r9 = 1
            if (r1 == 0) goto L_0x001c
            r6.f1389i = r9
            r1 = 8
            r6.w = r1
        L_0x001c:
            r6.f1351a = r0
            boolean r1 = r0 instanceof androidx.constraintlayout.widget.ConstraintHelper
            if (r1 == 0) goto L_0x002e
            androidx.constraintlayout.widget.ConstraintHelper r0 = (androidx.constraintlayout.widget.ConstraintHelper) r0
            r10 = r21
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r10.mLayoutWidget
            boolean r1 = r1.l
            r0.p(r6, r1)
            goto L_0x0030
        L_0x002e:
            r10 = r21
        L_0x0030:
            boolean r0 = r7.f1642g
            r11 = -1
            if (r0 == 0) goto L_0x0066
            r0 = r6
            androidx.constraintlayout.core.widgets.e r0 = (androidx.constraintlayout.core.widgets.e) r0
            int r1 = r7.T
            int r2 = r7.U
            float r3 = r7.j
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x004e
            if (r5 <= 0) goto L_0x035e
            r0.h = r3
            r0.B = r11
            r0.C = r11
            goto L_0x035e
        L_0x004e:
            if (r1 == r11) goto L_0x005a
            if (r1 <= r11) goto L_0x035e
            r0.h = r4
            r0.B = r1
            r0.C = r11
            goto L_0x035e
        L_0x005a:
            if (r2 == r11) goto L_0x035e
            if (r2 <= r11) goto L_0x035e
            r0.h = r4
            r0.B = r11
            r0.C = r2
            goto L_0x035e
        L_0x0066:
            int r0 = r7.N
            int r1 = r7.O
            int r12 = r7.P
            int r13 = r7.Q
            int r5 = r7.R
            int r14 = r7.S
            float r15 = r7.i
            int r2 = r7.n
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r4 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r3 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.LEFT
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r9 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            r16 = r5
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.TOP
            if (r2 == r11) goto L_0x00ac
            java.lang.Object r0 = r8.get(r2)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00a1
            float r8 = r7.b
            int r12 = r7.o
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r13 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.CENTER
            r14 = 0
            r0 = r24
            r1 = r13
            r15 = r3
            r3 = r13
            r13 = r4
            r4 = r12
            r12 = r5
            r5 = r14
            r0.z(r1, r2, r3, r4, r5)
            r6.d = r8
            goto L_0x00a4
        L_0x00a1:
            r15 = r3
            r13 = r4
            r12 = r5
        L_0x00a4:
            r18 = r12
            r17 = r13
            r19 = r15
            goto L_0x01d1
        L_0x00ac:
            r20 = r4
            r4 = r3
            r3 = r5
            r5 = r20
            if (r0 == r11) goto L_0x00da
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00d3
            int r1 = r7.leftMargin
            r0 = r24
            r17 = r1
            r1 = r4
            r18 = r3
            r3 = r4
            r19 = r4
            r4 = r17
            r17 = r5
            r5 = r16
            r0.z(r1, r2, r3, r4, r5)
            goto L_0x00f8
        L_0x00d3:
            r18 = r3
            r19 = r4
            r17 = r5
            goto L_0x00f8
        L_0x00da:
            r18 = r3
            r19 = r4
            r17 = r5
            if (r1 == r11) goto L_0x00f8
            java.lang.Object r0 = r8.get(r1)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x00f8
            int r4 = r7.leftMargin
            r0 = r24
            r1 = r19
            r3 = r17
            r5 = r16
            r0.z(r1, r2, r3, r4, r5)
        L_0x00f8:
            if (r12 == r11) goto L_0x0110
            java.lang.Object r0 = r8.get(r12)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x0127
            int r4 = r7.rightMargin
            r0 = r24
            r1 = r17
            r3 = r19
            r5 = r14
            r0.z(r1, r2, r3, r4, r5)
            goto L_0x0127
        L_0x0110:
            if (r13 == r11) goto L_0x0127
            java.lang.Object r0 = r8.get(r13)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x0127
            int r4 = r7.rightMargin
            r0 = r24
            r1 = r17
            r3 = r17
            r5 = r14
            r0.z(r1, r2, r3, r4, r5)
        L_0x0127:
            int r0 = r7.f1641g
            if (r0 == r11) goto L_0x0142
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x015b
            int r4 = r7.topMargin
            int r5 = r7.u
            r0 = r24
            r1 = r18
            r3 = r18
            r0.z(r1, r2, r3, r4, r5)
            goto L_0x015b
        L_0x0142:
            int r0 = r7.f1643h
            if (r0 == r11) goto L_0x015b
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x015b
            int r4 = r7.topMargin
            int r5 = r7.u
            r0 = r24
            r1 = r18
            r3 = r9
            r0.z(r1, r2, r3, r4, r5)
        L_0x015b:
            int r0 = r7.f1645i
            if (r0 == r11) goto L_0x0175
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x018d
            int r4 = r7.bottomMargin
            int r5 = r7.w
            r0 = r24
            r1 = r9
            r3 = r18
            r0.z(r1, r2, r3, r4, r5)
            goto L_0x018d
        L_0x0175:
            int r0 = r7.f1647j
            if (r0 == r11) goto L_0x018d
            java.lang.Object r0 = r8.get(r0)
            r2 = r0
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            if (r2 == 0) goto L_0x018d
            int r4 = r7.bottomMargin
            int r5 = r7.w
            r0 = r24
            r1 = r9
            r3 = r9
            r0.z(r1, r2, r3, r4, r5)
        L_0x018d:
            int r4 = r7.k
            if (r4 == r11) goto L_0x01a0
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r5 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BASELINE
            r0 = r21
            r1 = r24
            r2 = r25
            r3 = r26
            r0.setWidgetBaseline(r1, r2, r3, r4, r5)
        L_0x019e:
            r0 = 0
            goto L_0x01c3
        L_0x01a0:
            int r4 = r7.l
            if (r4 == r11) goto L_0x01b2
            r0 = r21
            r1 = r24
            r2 = r25
            r3 = r26
            r5 = r18
            r0.setWidgetBaseline(r1, r2, r3, r4, r5)
            goto L_0x019e
        L_0x01b2:
            int r4 = r7.m
            if (r4 == r11) goto L_0x019e
            r0 = r21
            r1 = r24
            r2 = r25
            r3 = r26
            r5 = r9
            r0.setWidgetBaseline(r1, r2, r3, r4, r5)
            goto L_0x019e
        L_0x01c3:
            int r1 = (r15 > r0 ? 1 : (r15 == r0 ? 0 : -1))
            if (r1 < 0) goto L_0x01c9
            r6.f = r15
        L_0x01c9:
            float r1 = r7.d
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 < 0) goto L_0x01d1
            r6.g = r1
        L_0x01d1:
            if (r22 == 0) goto L_0x01e1
            int r0 = r7.J
            if (r0 != r11) goto L_0x01db
            int r1 = r7.K
            if (r1 == r11) goto L_0x01e1
        L_0x01db:
            int r1 = r7.K
            r6.r = r0
            r6.s = r1
        L_0x01e1:
            boolean r0 = r7.f1636d
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_PARENT
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.WRAP_CONTENT
            r3 = -2
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.FIXED
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            r8 = 0
            if (r0 != 0) goto L_0x021a
            int r0 = r7.width
            if (r0 != r11) goto L_0x0213
            boolean r0 = r7.f1632b
            if (r0 == 0) goto L_0x01fb
            r6.P(r5)
            goto L_0x01fe
        L_0x01fb:
            r6.P(r1)
        L_0x01fe:
            r0 = r19
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.m(r0)
            int r12 = r7.leftMargin
            r0.b = r12
            r0 = r17
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.m(r0)
            int r12 = r7.rightMargin
            r0.b = r12
            goto L_0x0229
        L_0x0213:
            r6.P(r5)
            r6.R(r8)
            goto L_0x0229
        L_0x021a:
            r6.P(r4)
            int r0 = r7.width
            r6.R(r0)
            int r0 = r7.width
            if (r0 != r3) goto L_0x0229
            r6.P(r2)
        L_0x0229:
            boolean r0 = r7.f1638e
            if (r0 != 0) goto L_0x0256
            int r0 = r7.height
            if (r0 != r11) goto L_0x024f
            boolean r0 = r7.f1634c
            if (r0 == 0) goto L_0x0239
            r6.Q(r5)
            goto L_0x023c
        L_0x0239:
            r6.Q(r1)
        L_0x023c:
            r0 = r18
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.m(r0)
            int r1 = r7.topMargin
            r0.b = r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r0 = r6.m(r9)
            int r1 = r7.bottomMargin
            r0.b = r1
            goto L_0x0265
        L_0x024f:
            r6.Q(r5)
            r6.O(r8)
            goto L_0x0265
        L_0x0256:
            r6.Q(r4)
            int r0 = r7.height
            r6.O(r0)
            int r0 = r7.height
            if (r0 != r3) goto L_0x0265
            r6.Q(r2)
        L_0x0265:
            java.lang.String r0 = r7.f1628a
            if (r0 == 0) goto L_0x02f8
            int r1 = r0.length()
            if (r1 != 0) goto L_0x0271
            goto L_0x02f8
        L_0x0271:
            int r1 = r0.length()
            r2 = 44
            int r2 = r0.indexOf(r2)
            if (r2 <= 0) goto L_0x029c
            int r3 = r1 + -1
            if (r2 >= r3) goto L_0x029c
            java.lang.String r3 = r0.substring(r8, r2)
            java.lang.String r4 = "W"
            boolean r4 = r3.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0290
            r11 = r8
        L_0x028e:
            r3 = 1
            goto L_0x029a
        L_0x0290:
            java.lang.String r4 = "H"
            boolean r3 = r3.equalsIgnoreCase(r4)
            if (r3 == 0) goto L_0x028e
            r3 = 1
            r11 = 1
        L_0x029a:
            int r2 = r2 + r3
            goto L_0x029e
        L_0x029c:
            r3 = 1
            r2 = r8
        L_0x029e:
            r4 = 58
            int r4 = r0.indexOf(r4)
            if (r4 < 0) goto L_0x02de
            int r1 = r1 - r3
            if (r4 >= r1) goto L_0x02de
            java.lang.String r1 = r0.substring(r2, r4)
            int r4 = r4 + r3
            java.lang.String r0 = r0.substring(r4)
            int r2 = r1.length()
            if (r2 <= 0) goto L_0x02ed
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x02ed
            float r1 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x02ed }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x02ed }
            r2 = 0
            int r3 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x02ed
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x02ed
            r2 = 1
            if (r11 != r2) goto L_0x02d8
            float r0 = r0 / r1
            float r0 = java.lang.Math.abs(r0)     // Catch:{ NumberFormatException -> 0x02ed }
            goto L_0x02ee
        L_0x02d8:
            float r1 = r1 / r0
            float r0 = java.lang.Math.abs(r1)     // Catch:{ NumberFormatException -> 0x02ed }
            goto L_0x02ee
        L_0x02de:
            java.lang.String r0 = r0.substring(r2)
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x02ed
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ NumberFormatException -> 0x02ed }
            goto L_0x02ee
        L_0x02ed:
            r0 = 0
        L_0x02ee:
            r1 = 0
            int r2 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r2 <= 0) goto L_0x02fb
            r6.e = r0
            r6.q = r11
            goto L_0x02fb
        L_0x02f8:
            r1 = 0
            r6.e = r1
        L_0x02fb:
            float r0 = r7.e
            float[] r1 = r6.f1355a
            r1[r8] = r0
            float r0 = r7.f
            r2 = 1
            r1[r2] = r0
            int r0 = r7.B
            r6.x = r0
            int r0 = r7.C
            r6.y = r0
            int r0 = r7.M
            if (r0 < 0) goto L_0x0317
            r1 = 3
            if (r0 > r1) goto L_0x0317
            r6.f1378e = r0
        L_0x0317:
            int r0 = r7.D
            int r1 = r7.F
            int r2 = r7.H
            float r3 = r7.g
            r6.f1381f = r0
            r6.h = r1
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r1) goto L_0x0329
            r2 = r8
        L_0x0329:
            r6.i = r2
            r6.a = r3
            r2 = 0
            int r4 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            r2 = 2
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r4 <= 0) goto L_0x033d
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x033d
            if (r0 != 0) goto L_0x033d
            r6.f1381f = r2
        L_0x033d:
            int r0 = r7.E
            int r3 = r7.G
            int r4 = r7.I
            float r7 = r7.h
            r6.f1384g = r0
            r6.j = r3
            if (r4 != r1) goto L_0x034c
            goto L_0x034d
        L_0x034c:
            r8 = r4
        L_0x034d:
            r6.k = r8
            r6.b = r7
            r1 = 0
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x035e
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x035e
            if (r0 != 0) goto L_0x035e
            r6.f1384g = r2
        L_0x035e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.applyConstraintsFromLayoutParams(boolean, android.view.View, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams, android.util.SparseArray):void");
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i = 0; i < size; i++) {
                this.mConstraintHelpers.get(i).r(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i3 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i4 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f = (float) i3;
                        float f2 = (float) i4;
                        float f3 = (float) (i3 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f4 = f2;
                        float f5 = f2;
                        float f6 = f3;
                        float f7 = f;
                        Paint paint2 = paint;
                        canvas2.drawLine(f, f4, f6, f5, paint);
                        float parseInt4 = (float) (i4 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f8 = f3;
                        float f9 = parseInt4;
                        canvas2.drawLine(f8, f5, f6, f9, paint);
                        float f10 = parseInt4;
                        float f11 = f7;
                        canvas2.drawLine(f8, f10, f11, f9, paint);
                        float f12 = f7;
                        canvas2.drawLine(f12, f10, f11, f5, paint);
                        paint.setColor(-16711936);
                        float f13 = f3;
                        Paint paint3 = paint;
                        canvas2.drawLine(f12, f5, f13, parseInt4, paint);
                        canvas2.drawLine(f12, parseInt4, f13, f5, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        constraintWidgetContainer.getClass();
        constraintWidgetContainer.f1396a.getClass();
        ei.a = metrics;
    }

    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i, Object obj) {
        if (i != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.G;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.mLayoutWidget.f1352a == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.mLayoutWidget.f1352a = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.mLayoutWidget.f1352a = "parent";
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        if (constraintWidgetContainer.f1365b == null) {
            constraintWidgetContainer.f1365b = constraintWidgetContainer.f1352a;
        }
        Iterator<ConstraintWidget> it = constraintWidgetContainer.b.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            View view = (View) next.f1351a;
            if (view != null) {
                if (next.f1352a == null && (id = view.getId()) != -1) {
                    next.f1352a = getContext().getResources().getResourceEntryName(id);
                }
                if (next.f1365b == null) {
                    next.f1365b = next.f1352a;
                }
            }
        }
        this.mLayoutWidget.r(sb);
        return sb.toString();
    }

    public View getViewById(int i) {
        return this.mChildrenByIds.get(i);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f1627a;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f1627a;
        }
        return null;
    }

    public boolean isRtl() {
        boolean z;
        if ((getContext().getApplicationInfo().flags & 4194304) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z || 1 != getLayoutDirection()) {
            return false;
        }
        return USE_CONSTRAINTS_HELPER;
    }

    public void loadLayoutDescription(int i) {
        if (i != 0) {
            try {
                this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
            } catch (Resources.NotFoundException unused) {
                this.mConstraintLayoutSpec = null;
            }
        } else {
            this.mConstraintLayoutSpec = null;
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.f1627a;
            if ((childAt.getVisibility() != 8 || layoutParams.f1642g || layoutParams.f1644h || isInEditMode) && !layoutParams.f1646i) {
                int v = constraintWidget.v();
                int w = constraintWidget.w();
                int u = constraintWidget.u() + v;
                int o = constraintWidget.o() + w;
                childAt.layout(v, w, u, o);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(v, w, u, o);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).q();
            }
        }
    }

    public void onMeasure(int i, int i2) {
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                } else if (getChildAt(i3).isLayoutRequested()) {
                    this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
                    break;
                } else {
                    i3++;
                }
            }
        }
        this.mOnMeasureWidthMeasureSpec = i;
        this.mOnMeasureHeightMeasureSpec = i2;
        this.mLayoutWidget.l = isRtl();
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
                constraintWidgetContainer.f1394a.c(constraintWidgetContainer);
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i, i2);
        int u = this.mLayoutWidget.u();
        int o = this.mLayoutWidget.o();
        ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutWidget;
        resolveMeasuredDimension(i, i2, u, o, constraintWidgetContainer2.m, constraintWidgetContainer2.n);
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof e)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            e eVar = new e();
            layoutParams.f1627a = eVar;
            layoutParams.f1642g = USE_CONSTRAINTS_HELPER;
            eVar.V(layoutParams.L);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.t();
            ((LayoutParams) view.getLayoutParams()).f1644h = USE_CONSTRAINTS_HELPER;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        ConstraintWidget viewWidget = getViewWidget(view);
        this.mLayoutWidget.b.remove(viewWidget);
        viewWidget.G();
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = USE_CONSTRAINTS_HELPER;
    }

    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i);
    }

    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Measurer measurer = this.mMeasurer;
        int i5 = measurer.d;
        int resolveSizeAndState = View.resolveSizeAndState(i3 + measurer.c, i, 0);
        int min = Math.min(this.mMaxWidth, resolveSizeAndState & 16777215);
        int min2 = Math.min(this.mMaxHeight, View.resolveSizeAndState(i4 + i5, i2, 0) & 16777215);
        if (z) {
            min |= 16777216;
        }
        if (z2) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x038f  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03a2  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:377:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x011a A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void resolveSystem(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r26, int r27, int r28, int r29) {
        /*
            r25 = this;
            r6 = r26
            r7 = r27
            int r8 = android.view.View.MeasureSpec.getMode(r28)
            int r0 = android.view.View.MeasureSpec.getSize(r28)
            int r9 = android.view.View.MeasureSpec.getMode(r29)
            int r1 = android.view.View.MeasureSpec.getSize(r29)
            int r2 = r25.getPaddingTop()
            r10 = 0
            int r11 = java.lang.Math.max(r10, r2)
            int r2 = r25.getPaddingBottom()
            int r2 = java.lang.Math.max(r10, r2)
            int r3 = r11 + r2
            int r4 = r25.getPaddingWidth()
            r12 = r25
            androidx.constraintlayout.widget.ConstraintLayout$Measurer r5 = r12.mMeasurer
            r5.a = r11
            r5.b = r2
            r5.c = r4
            r5.d = r3
            r2 = r28
            r5.e = r2
            r2 = r29
            r5.f = r2
            int r2 = r25.getPaddingStart()
            int r2 = java.lang.Math.max(r10, r2)
            int r5 = r25.getPaddingEnd()
            int r5 = java.lang.Math.max(r10, r5)
            if (r2 > 0) goto L_0x005d
            if (r5 <= 0) goto L_0x0054
            goto L_0x005d
        L_0x0054:
            int r2 = r25.getPaddingLeft()
            int r2 = java.lang.Math.max(r10, r2)
            goto L_0x0065
        L_0x005d:
            boolean r13 = r25.isRtl()
            if (r13 == 0) goto L_0x0065
            r13 = r5
            goto L_0x0066
        L_0x0065:
            r13 = r2
        L_0x0066:
            int r14 = r0 - r4
            int r15 = r1 - r3
            r0 = r25
            r1 = r26
            r2 = r8
            r3 = r14
            r4 = r9
            r5 = r15
            r0.setSelfDimensionBehaviour(r1, r2, r3, r4, r5)
            r6.C = r13
            r6.D = r11
            D2 r0 = r6.f1394a
            r0.getClass()
            D2$b r1 = r6.f1393a
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r2 = r6.b
            int r2 = r2.size()
            int r3 = r26.u()
            int r4 = r26.o()
            r5 = 128(0x80, float:1.794E-43)
            boolean r5 = androidx.constraintlayout.core.widgets.f.b(r7, r5)
            r11 = 64
            if (r5 != 0) goto L_0x00a1
            boolean r7 = androidx.constraintlayout.core.widgets.f.b(r7, r11)
            if (r7 == 0) goto L_0x009f
            goto L_0x00a1
        L_0x009f:
            r7 = r10
            goto L_0x00a2
        L_0x00a1:
            r7 = 1
        L_0x00a2:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r11 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_CONSTRAINT
            r16 = 0
            if (r7 == 0) goto L_0x0104
            r13 = r10
        L_0x00a9:
            if (r13 >= r2) goto L_0x0104
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r10 = r6.b
            java.lang.Object r10 = r10.get(r13)
            androidx.constraintlayout.core.widgets.ConstraintWidget r10 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r10
            r27 = r7
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r7 = r10.f1358a
            r17 = 0
            r12 = r7[r17]
            if (r12 != r11) goto L_0x00bf
            r12 = 1
            goto L_0x00c0
        L_0x00bf:
            r12 = 0
        L_0x00c0:
            r18 = 1
            r7 = r7[r18]
            if (r7 != r11) goto L_0x00c8
            r7 = 1
            goto L_0x00c9
        L_0x00c8:
            r7 = 0
        L_0x00c9:
            if (r12 == 0) goto L_0x00d5
            if (r7 == 0) goto L_0x00d5
            float r7 = r10.e
            int r7 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d5
            r7 = 1
            goto L_0x00d6
        L_0x00d5:
            r7 = 0
        L_0x00d6:
            boolean r12 = r10.B()
            if (r12 == 0) goto L_0x00df
            if (r7 == 0) goto L_0x00df
            goto L_0x0102
        L_0x00df:
            boolean r12 = r10.C()
            if (r12 == 0) goto L_0x00e8
            if (r7 == 0) goto L_0x00e8
            goto L_0x0102
        L_0x00e8:
            boolean r7 = r10 instanceof androidx.constraintlayout.core.widgets.h
            if (r7 == 0) goto L_0x00ed
            goto L_0x0102
        L_0x00ed:
            boolean r7 = r10.B()
            if (r7 != 0) goto L_0x0102
            boolean r7 = r10.C()
            if (r7 == 0) goto L_0x00fa
            goto L_0x0102
        L_0x00fa:
            int r13 = r13 + 1
            r12 = r25
            r7 = r27
            r10 = 0
            goto L_0x00a9
        L_0x0102:
            r7 = 0
            goto L_0x0108
        L_0x0104:
            r27 = r7
            r7 = r27
        L_0x0108:
            if (r7 == 0) goto L_0x0116
            androidx.constraintlayout.core.Metrics r10 = defpackage.ei.a
            if (r10 == 0) goto L_0x0116
            long r12 = r10.a
            r18 = 1
            long r12 = r12 + r18
            r10.a = r12
        L_0x0116:
            r10 = 1073741824(0x40000000, float:2.0)
            if (r8 != r10) goto L_0x011c
            if (r9 == r10) goto L_0x011e
        L_0x011c:
            if (r5 == 0) goto L_0x0120
        L_0x011e:
            r12 = 1
            goto L_0x0121
        L_0x0120:
            r12 = 0
        L_0x0121:
            r7 = r7 & r12
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r12 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.WRAP_CONTENT
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r13 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.FIXED
            if (r7 == 0) goto L_0x038f
            int[] r10 = r6.f1367b
            r17 = 0
            r10 = r10[r17]
            int r10 = java.lang.Math.min(r10, r14)
            int[] r14 = r6.f1367b
            r19 = r7
            r7 = 1
            r14 = r14[r7]
            int r14 = java.lang.Math.min(r14, r15)
            M8 r15 = r6.f1395a
            r7 = 1073741824(0x40000000, float:2.0)
            if (r8 != r7) goto L_0x0150
            int r7 = r26.u()
            if (r7 == r10) goto L_0x0150
            r6.R(r10)
            r7 = 1
            r15.f398a = r7
            goto L_0x0151
        L_0x0150:
            r7 = 1
        L_0x0151:
            r10 = 1073741824(0x40000000, float:2.0)
            if (r9 != r10) goto L_0x0162
            int r10 = r26.o()
            if (r10 == r14) goto L_0x0160
            r6.O(r14)
            r15.f398a = r7
        L_0x0160:
            r10 = 1073741824(0x40000000, float:2.0)
        L_0x0162:
            if (r8 != r10) goto L_0x02f0
            if (r9 != r10) goto L_0x02f0
            r5 = r5 & r7
            boolean r7 = r15.f398a
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r10 = r15.f396a
            if (r7 != 0) goto L_0x0174
            boolean r7 = r15.f400b
            if (r7 == 0) goto L_0x0172
            goto L_0x0174
        L_0x0172:
            r7 = 0
            goto L_0x01ad
        L_0x0174:
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r7 = r10.b
            java.util.Iterator r7 = r7.iterator()
        L_0x017a:
            boolean r14 = r7.hasNext()
            if (r14 == 0) goto L_0x019b
            java.lang.Object r14 = r7.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r14
            r14.l()
            r20 = r7
            r7 = 0
            r14.f1354a = r7
            af r7 = r14.f1347a
            r7.n()
            hC r7 = r14.f1350a
            r7.m()
            r7 = r20
            goto L_0x017a
        L_0x019b:
            r10.l()
            r7 = 0
            r10.f1354a = r7
            af r14 = r10.f1347a
            r14.n()
            hC r14 = r10.f1350a
            r14.m()
            r15.f400b = r7
        L_0x01ad:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r14 = r15.b
            r15.b(r14)
            r10.r = r7
            r10.s = r7
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r14 = r10.n(r7)
            r20 = r1
            r7 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r1 = r10.n(r7)
            boolean r7 = r15.f398a
            if (r7 == 0) goto L_0x01c8
            r15.c()
        L_0x01c8:
            int r7 = r10.v()
            r21 = r3
            int r3 = r10.w()
            r22 = r4
            af r4 = r10.f1347a
            N8 r4 = r4.f79a
            r4.d(r7)
            hC r4 = r10.f1350a
            N8 r4 = r4.f79a
            r4.d(r3)
            r15.g()
            java.util.ArrayList<CD> r4 = r15.f397a
            if (r14 == r12) goto L_0x01f1
            if (r1 != r12) goto L_0x01ec
            goto L_0x01f1
        L_0x01ec:
            r23 = r0
            r24 = r11
            goto L_0x0247
        L_0x01f1:
            if (r5 == 0) goto L_0x020a
            java.util.Iterator r23 = r4.iterator()
        L_0x01f7:
            boolean r24 = r23.hasNext()
            if (r24 == 0) goto L_0x020a
            java.lang.Object r24 = r23.next()
            CD r24 = (defpackage.CD) r24
            boolean r24 = r24.k()
            if (r24 != 0) goto L_0x01f7
            r5 = 0
        L_0x020a:
            if (r5 == 0) goto L_0x0229
            if (r14 != r12) goto L_0x0229
            r10.P(r13)
            r23 = r0
            r24 = r11
            r0 = 0
            int r11 = r15.d(r10, r0)
            r10.R(r11)
            af r0 = r10.f1347a
            c9 r0 = r0.f82a
            int r11 = r10.u()
            r0.d(r11)
            goto L_0x022d
        L_0x0229:
            r23 = r0
            r24 = r11
        L_0x022d:
            if (r5 == 0) goto L_0x0247
            if (r1 != r12) goto L_0x0247
            r10.Q(r13)
            r0 = 1
            int r5 = r15.d(r10, r0)
            r10.O(r5)
            hC r0 = r10.f1350a
            c9 r0 = r0.f82a
            int r5 = r10.o()
            r0.d(r5)
        L_0x0247:
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r10.f1358a
            r5 = 0
            r0 = r0[r5]
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r5 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.MATCH_PARENT
            if (r0 == r13) goto L_0x0255
            if (r0 != r5) goto L_0x0253
            goto L_0x0255
        L_0x0253:
            r0 = 0
            goto L_0x028d
        L_0x0255:
            int r0 = r10.u()
            int r0 = r0 + r7
            af r11 = r10.f1347a
            N8 r11 = r11.f85b
            r11.d(r0)
            af r11 = r10.f1347a
            c9 r11 = r11.f82a
            int r0 = r0 - r7
            r11.d(r0)
            r15.g()
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r0 = r10.f1358a
            r7 = 1
            r0 = r0[r7]
            if (r0 == r13) goto L_0x0275
            if (r0 != r5) goto L_0x0289
        L_0x0275:
            int r0 = r10.o()
            int r0 = r0 + r3
            hC r5 = r10.f1350a
            N8 r5 = r5.f85b
            r5.d(r0)
            hC r5 = r10.f1350a
            c9 r5 = r5.f82a
            int r0 = r0 - r3
            r5.d(r0)
        L_0x0289:
            r15.g()
            r0 = 1
        L_0x028d:
            java.util.Iterator r3 = r4.iterator()
        L_0x0291:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x02aa
            java.lang.Object r5 = r3.next()
            CD r5 = (defpackage.CD) r5
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r5.f81a
            if (r7 != r10) goto L_0x02a6
            boolean r7 = r5.f84a
            if (r7 != 0) goto L_0x02a6
            goto L_0x0291
        L_0x02a6:
            r5.e()
            goto L_0x0291
        L_0x02aa:
            java.util.Iterator r3 = r4.iterator()
        L_0x02ae:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02e3
            java.lang.Object r4 = r3.next()
            CD r4 = (defpackage.CD) r4
            if (r0 != 0) goto L_0x02c1
            androidx.constraintlayout.core.widgets.ConstraintWidget r5 = r4.f81a
            if (r5 != r10) goto L_0x02c1
            goto L_0x02ae
        L_0x02c1:
            N8 r5 = r4.f79a
            boolean r5 = r5.f436c
            if (r5 != 0) goto L_0x02c8
            goto L_0x02e1
        L_0x02c8:
            N8 r5 = r4.f85b
            boolean r5 = r5.f436c
            if (r5 != 0) goto L_0x02d3
            boolean r5 = r4 instanceof defpackage.C0098Je
            if (r5 != 0) goto L_0x02d3
            goto L_0x02e1
        L_0x02d3:
            c9 r5 = r4.f82a
            boolean r5 = r5.f436c
            if (r5 != 0) goto L_0x02ae
            boolean r5 = r4 instanceof defpackage.M4
            if (r5 != 0) goto L_0x02ae
            boolean r4 = r4 instanceof defpackage.C0098Je
            if (r4 != 0) goto L_0x02ae
        L_0x02e1:
            r0 = 0
            goto L_0x02e4
        L_0x02e3:
            r0 = 1
        L_0x02e4:
            r10.P(r14)
            r10.Q(r1)
            r1 = r0
            r0 = 1073741824(0x40000000, float:2.0)
            r4 = 2
            goto L_0x037f
        L_0x02f0:
            r23 = r0
            r20 = r1
            r21 = r3
            r22 = r4
            r24 = r11
            boolean r0 = r15.f398a
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r1 = r15.f396a
            if (r0 == 0) goto L_0x034f
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r0 = r1.b
            java.util.Iterator r0 = r0.iterator()
        L_0x0306:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x032f
            java.lang.Object r3 = r0.next()
            androidx.constraintlayout.core.widgets.ConstraintWidget r3 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r3
            r3.l()
            r4 = 0
            r3.f1354a = r4
            af r7 = r3.f1347a
            c9 r10 = r7.f82a
            r10.f436c = r4
            r7.f84a = r4
            r7.n()
            hC r3 = r3.f1350a
            c9 r7 = r3.f82a
            r7.f436c = r4
            r3.f84a = r4
            r3.m()
            goto L_0x0306
        L_0x032f:
            r4 = 0
            r1.l()
            r1.f1354a = r4
            af r0 = r1.f1347a
            c9 r3 = r0.f82a
            r3.f436c = r4
            r0.f84a = r4
            r0.n()
            hC r0 = r1.f1350a
            c9 r3 = r0.f82a
            r3.f436c = r4
            r0.f84a = r4
            r0.m()
            r15.c()
            goto L_0x0350
        L_0x034f:
            r4 = 0
        L_0x0350:
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r0 = r15.b
            r15.b(r0)
            r1.r = r4
            r1.s = r4
            af r0 = r1.f1347a
            N8 r0 = r0.f79a
            r0.d(r4)
            hC r0 = r1.f1350a
            N8 r0 = r0.f79a
            r0.d(r4)
            r0 = 1073741824(0x40000000, float:2.0)
            if (r8 != r0) goto L_0x0373
            boolean r1 = r6.X(r4, r5)
            r3 = 1
            r1 = r1 & r3
            r4 = r3
            goto L_0x0376
        L_0x0373:
            r3 = 1
            r1 = r3
            r4 = 0
        L_0x0376:
            if (r9 != r0) goto L_0x037f
            boolean r5 = r6.X(r3, r5)
            r1 = r1 & r5
            int r4 = r4 + 1
        L_0x037f:
            if (r1 == 0) goto L_0x039d
            if (r8 != r0) goto L_0x0385
            r3 = 1
            goto L_0x0386
        L_0x0385:
            r3 = 0
        L_0x0386:
            if (r9 != r0) goto L_0x038a
            r0 = 1
            goto L_0x038b
        L_0x038a:
            r0 = 0
        L_0x038b:
            r6.S(r3, r0)
            goto L_0x039d
        L_0x038f:
            r23 = r0
            r20 = r1
            r21 = r3
            r22 = r4
            r19 = r7
            r24 = r11
            r1 = 0
            r4 = 0
        L_0x039d:
            if (r1 == 0) goto L_0x03a2
            r0 = 2
            if (r4 == r0) goto L_0x0699
        L_0x03a2:
            int r0 = r6.G
            r1 = 8
            if (r2 <= 0) goto L_0x04c2
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r3 = r6.b
            int r3 = r3.size()
            r4 = 64
            boolean r4 = r6.Z(r4)
            D2$b r5 = r6.f1393a
            r7 = 0
        L_0x03b7:
            if (r7 >= r3) goto L_0x044e
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r8 = r6.b
            java.lang.Object r8 = r8.get(r7)
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r8
            boolean r9 = r8 instanceof androidx.constraintlayout.core.widgets.e
            if (r9 == 0) goto L_0x03c6
            goto L_0x03e6
        L_0x03c6:
            boolean r9 = r8 instanceof androidx.constraintlayout.core.widgets.a
            if (r9 == 0) goto L_0x03cb
            goto L_0x03e6
        L_0x03cb:
            boolean r9 = r8.f1390j
            if (r9 == 0) goto L_0x03d0
            goto L_0x03e6
        L_0x03d0:
            if (r4 == 0) goto L_0x03eb
            af r9 = r8.f1347a
            if (r9 == 0) goto L_0x03eb
            hC r10 = r8.f1350a
            if (r10 == 0) goto L_0x03eb
            c9 r9 = r9.f82a
            boolean r9 = r9.f436c
            if (r9 == 0) goto L_0x03eb
            c9 r9 = r10.f82a
            boolean r9 = r9.f436c
            if (r9 == 0) goto L_0x03eb
        L_0x03e6:
            r10 = r23
            r14 = r24
            goto L_0x0446
        L_0x03eb:
            r9 = 0
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r10 = r8.n(r9)
            r9 = 1
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r11 = r8.n(r9)
            r14 = r24
            if (r10 != r14) goto L_0x0405
            int r15 = r8.f1381f
            if (r15 == r9) goto L_0x0405
            if (r11 != r14) goto L_0x0405
            int r15 = r8.f1384g
            if (r15 == r9) goto L_0x0405
            r15 = r9
            goto L_0x0406
        L_0x0405:
            r15 = 0
        L_0x0406:
            if (r15 != 0) goto L_0x043b
            boolean r24 = r6.Z(r9)
            if (r24 == 0) goto L_0x043b
            boolean r9 = r8 instanceof androidx.constraintlayout.core.widgets.h
            if (r9 != 0) goto L_0x043b
            if (r10 != r14) goto L_0x0421
            int r9 = r8.f1381f
            if (r9 != 0) goto L_0x0421
            if (r11 == r14) goto L_0x0421
            boolean r9 = r8.B()
            if (r9 != 0) goto L_0x0421
            r15 = 1
        L_0x0421:
            if (r11 != r14) goto L_0x0430
            int r9 = r8.f1384g
            if (r9 != 0) goto L_0x0430
            if (r10 == r14) goto L_0x0430
            boolean r9 = r8.B()
            if (r9 != 0) goto L_0x0430
            r15 = 1
        L_0x0430:
            if (r10 == r14) goto L_0x0434
            if (r11 != r14) goto L_0x043b
        L_0x0434:
            float r9 = r8.e
            int r9 = (r9 > r16 ? 1 : (r9 == r16 ? 0 : -1))
            if (r9 <= 0) goto L_0x043b
            r15 = 1
        L_0x043b:
            if (r15 == 0) goto L_0x0440
            r10 = r23
            goto L_0x0446
        L_0x0440:
            r10 = r23
            r9 = 0
            r10.a(r9, r8, r5)
        L_0x0446:
            int r7 = r7 + 1
            r23 = r10
            r24 = r14
            goto L_0x03b7
        L_0x044e:
            r10 = r23
            androidx.constraintlayout.widget.ConstraintLayout$Measurer r5 = (androidx.constraintlayout.widget.ConstraintLayout.Measurer) r5
            androidx.constraintlayout.widget.ConstraintLayout r3 = r5.f1648a
            int r4 = r3.getChildCount()
            r5 = 0
        L_0x0459:
            if (r5 >= r4) goto L_0x04a5
            android.view.View r7 = r3.getChildAt(r5)
            boolean r8 = r7 instanceof androidx.constraintlayout.widget.Placeholder
            if (r8 == 0) goto L_0x04a2
            androidx.constraintlayout.widget.Placeholder r7 = (androidx.constraintlayout.widget.Placeholder) r7
            android.view.View r8 = r7.a
            if (r8 != 0) goto L_0x046a
            goto L_0x04a2
        L_0x046a:
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r8 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r8
            android.view.View r7 = r7.a
            android.view.ViewGroup$LayoutParams r7 = r7.getLayoutParams()
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r7 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r7
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r7.f1627a
            r11 = 0
            r9.w = r11
            androidx.constraintlayout.core.widgets.ConstraintWidget r14 = r8.f1627a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r15 = r14.f1358a
            r15 = r15[r11]
            if (r15 == r13) goto L_0x048c
            int r9 = r9.u()
            r14.R(r9)
        L_0x048c:
            androidx.constraintlayout.core.widgets.ConstraintWidget r8 = r8.f1627a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r9 = r8.f1358a
            r11 = 1
            r9 = r9[r11]
            if (r9 == r13) goto L_0x049e
            androidx.constraintlayout.core.widgets.ConstraintWidget r9 = r7.f1627a
            int r9 = r9.o()
            r8.O(r9)
        L_0x049e:
            androidx.constraintlayout.core.widgets.ConstraintWidget r7 = r7.f1627a
            r7.w = r1
        L_0x04a2:
            int r5 = r5 + 1
            goto L_0x0459
        L_0x04a5:
            java.util.ArrayList r4 = r3.mConstraintHelpers
            int r4 = r4.size()
            if (r4 <= 0) goto L_0x04c4
            r5 = 0
        L_0x04b0:
            if (r5 >= r4) goto L_0x04c4
            java.util.ArrayList r7 = r3.mConstraintHelpers
            java.lang.Object r7 = r7.get(r5)
            androidx.constraintlayout.widget.ConstraintHelper r7 = (androidx.constraintlayout.widget.ConstraintHelper) r7
            r7.getClass()
            int r5 = r5 + 1
            goto L_0x04b0
        L_0x04c2:
            r10 = r23
        L_0x04c4:
            r10.c(r6)
            java.util.ArrayList<androidx.constraintlayout.core.widgets.ConstraintWidget> r3 = r10.f106a
            int r4 = r3.size()
            if (r2 <= 0) goto L_0x04d8
            r5 = r21
            r7 = r22
            r2 = 0
            r10.b(r6, r2, r5, r7)
            goto L_0x04dd
        L_0x04d8:
            r5 = r21
            r7 = r22
            r2 = 0
        L_0x04dd:
            if (r4 <= 0) goto L_0x068a
            androidx.constraintlayout.core.widgets.ConstraintWidget$a[] r8 = r6.f1358a
            r9 = r8[r2]
            if (r9 != r12) goto L_0x04e9
            r9 = 1
            r17 = 1
            goto L_0x04ec
        L_0x04e9:
            r17 = r2
            r9 = 1
        L_0x04ec:
            r8 = r8[r9]
            if (r8 != r12) goto L_0x04f2
            r8 = 1
            goto L_0x04f3
        L_0x04f2:
            r8 = r2
        L_0x04f3:
            int r9 = r26.u()
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r11 = r10.f105a
            int r12 = r11.u
            int r9 = java.lang.Math.max(r9, r12)
            int r12 = r26.o()
            int r11 = r11.v
            int r11 = java.lang.Math.max(r12, r11)
            r12 = r2
            r13 = r12
        L_0x050b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r14 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.BOTTOM
            androidx.constraintlayout.core.widgets.ConstraintAnchor$Type r15 = androidx.constraintlayout.core.widgets.ConstraintAnchor.Type.RIGHT
            if (r12 >= r4) goto L_0x05a8
            java.lang.Object r16 = r3.get(r12)
            r2 = r16
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r2
            boolean r1 = r2 instanceof androidx.constraintlayout.core.widgets.h
            if (r1 != 0) goto L_0x0525
            r16 = r0
            r22 = r5
            r5 = r20
            goto L_0x0599
        L_0x0525:
            int r1 = r2.u()
            r16 = r0
            int r0 = r2.o()
            r22 = r5
            r5 = r20
            r6 = 1
            boolean r20 = r10.a(r6, r2, r5)
            r6 = r13 | r20
            int r13 = r2.u()
            r28 = r6
            int r6 = r2.o()
            if (r13 == r1) goto L_0x056b
            r2.R(r13)
            if (r17 == 0) goto L_0x0569
            int r1 = r2.v()
            int r13 = r2.o
            int r1 = r1 + r13
            if (r1 <= r9) goto L_0x0569
            int r1 = r2.v()
            int r13 = r2.o
            int r1 = r1 + r13
            androidx.constraintlayout.core.widgets.ConstraintAnchor r13 = r2.m(r15)
            int r13 = r13.e()
            int r13 = r13 + r1
            int r1 = java.lang.Math.max(r9, r13)
            r9 = r1
        L_0x0569:
            r1 = 1
            goto L_0x056d
        L_0x056b:
            r1 = r28
        L_0x056d:
            if (r6 == r0) goto L_0x0593
            r2.O(r6)
            if (r8 == 0) goto L_0x0592
            int r0 = r2.w()
            int r1 = r2.p
            int r0 = r0 + r1
            if (r0 <= r11) goto L_0x0592
            int r0 = r2.w()
            int r1 = r2.p
            int r0 = r0 + r1
            androidx.constraintlayout.core.widgets.ConstraintAnchor r1 = r2.m(r14)
            int r1 = r1.e()
            int r1 = r1 + r0
            int r0 = java.lang.Math.max(r11, r1)
            r11 = r0
        L_0x0592:
            r1 = 1
        L_0x0593:
            androidx.constraintlayout.core.widgets.h r2 = (androidx.constraintlayout.core.widgets.h) r2
            boolean r0 = r2.l
            r0 = r0 | r1
            r13 = r0
        L_0x0599:
            int r12 = r12 + 1
            r6 = r26
            r20 = r5
            r0 = r16
            r5 = r22
            r1 = 8
            r2 = 0
            goto L_0x050b
        L_0x05a8:
            r16 = r0
            r22 = r5
            r5 = r20
            r0 = 0
            r1 = 2
        L_0x05b0:
            if (r0 >= r1) goto L_0x0687
            r18 = r13
            r2 = 0
        L_0x05b5:
            if (r2 >= r4) goto L_0x0670
            java.lang.Object r6 = r3.get(r2)
            androidx.constraintlayout.core.widgets.ConstraintWidget r6 = (androidx.constraintlayout.core.widgets.ConstraintWidget) r6
            boolean r12 = r6 instanceof defpackage.Re
            if (r12 == 0) goto L_0x05c5
            boolean r12 = r6 instanceof androidx.constraintlayout.core.widgets.h
            if (r12 == 0) goto L_0x05c9
        L_0x05c5:
            boolean r12 = r6 instanceof androidx.constraintlayout.core.widgets.e
            if (r12 == 0) goto L_0x05cc
        L_0x05c9:
            r13 = 8
            goto L_0x05ea
        L_0x05cc:
            int r12 = r6.w
            r13 = 8
            if (r12 != r13) goto L_0x05d3
            goto L_0x05ea
        L_0x05d3:
            if (r19 == 0) goto L_0x05e6
            af r12 = r6.f1347a
            c9 r12 = r12.f82a
            boolean r12 = r12.f436c
            if (r12 == 0) goto L_0x05e6
            hC r12 = r6.f1350a
            c9 r12 = r12.f82a
            boolean r12 = r12.f436c
            if (r12 == 0) goto L_0x05e6
            goto L_0x05ea
        L_0x05e6:
            boolean r12 = r6 instanceof androidx.constraintlayout.core.widgets.h
            if (r12 == 0) goto L_0x05f0
        L_0x05ea:
            r23 = r3
            r28 = r4
            goto L_0x0667
        L_0x05f0:
            int r12 = r6.u()
            int r1 = r6.o()
            int r13 = r6.t
            r23 = r3
            r3 = 1
            if (r0 != r3) goto L_0x0600
            r3 = 2
        L_0x0600:
            boolean r3 = r10.a(r3, r6, r5)
            r18 = r18 | r3
            int r3 = r6.u()
            r28 = r4
            int r4 = r6.o()
            if (r3 == r12) goto L_0x0636
            r6.R(r3)
            if (r17 == 0) goto L_0x0634
            int r3 = r6.v()
            int r12 = r6.o
            int r3 = r3 + r12
            if (r3 <= r9) goto L_0x0634
            int r3 = r6.v()
            int r12 = r6.o
            int r3 = r3 + r12
            androidx.constraintlayout.core.widgets.ConstraintAnchor r12 = r6.m(r15)
            int r12 = r12.e()
            int r12 = r12 + r3
            int r9 = java.lang.Math.max(r9, r12)
        L_0x0634:
            r18 = 1
        L_0x0636:
            if (r4 == r1) goto L_0x065d
            r6.O(r4)
            if (r8 == 0) goto L_0x065b
            int r1 = r6.w()
            int r3 = r6.p
            int r1 = r1 + r3
            if (r1 <= r11) goto L_0x065b
            int r1 = r6.w()
            int r3 = r6.p
            int r1 = r1 + r3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r6.m(r14)
            int r3 = r3.e()
            int r3 = r3 + r1
            int r1 = java.lang.Math.max(r11, r3)
            r11 = r1
        L_0x065b:
            r18 = 1
        L_0x065d:
            boolean r1 = r6.f1388h
            if (r1 == 0) goto L_0x0667
            int r1 = r6.t
            if (r13 == r1) goto L_0x0667
            r18 = 1
        L_0x0667:
            int r2 = r2 + 1
            r4 = r28
            r3 = r23
            r1 = 2
            goto L_0x05b5
        L_0x0670:
            r23 = r3
            r28 = r4
            if (r18 == 0) goto L_0x0687
            int r0 = r0 + 1
            r1 = r26
            r2 = r22
            r10.b(r1, r0, r2, r7)
            r4 = r28
            r3 = r23
            r1 = 2
            r13 = 0
            goto L_0x05b0
        L_0x0687:
            r1 = r26
            goto L_0x068d
        L_0x068a:
            r16 = r0
            r1 = r6
        L_0x068d:
            r0 = r16
            r1.G = r0
            r0 = 512(0x200, float:7.175E-43)
            boolean r0 = r1.Z(r0)
            defpackage.ei.c = r0
        L_0x0699:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.resolveSystem(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, int, int, int):void");
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i, Object obj, Object obj2) {
        if (i == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf(RemoteSettings.FORWARD_SLASH_STRING);
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public void setId(int i) {
        this.mChildrenByIds.remove(getId());
        super.setId(i);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i) {
        if (i != this.mMaxHeight) {
            this.mMaxHeight = i;
            requestLayout();
        }
    }

    public void setMaxWidth(int i) {
        if (i != this.mMaxWidth) {
            this.mMaxWidth = i;
            requestLayout();
        }
    }

    public void setMinHeight(int i) {
        if (i != this.mMinHeight) {
            this.mMinHeight = i;
            requestLayout();
        }
    }

    public void setMinWidth(int i) {
        if (i != this.mMinWidth) {
            this.mMinWidth = i;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.getClass();
        }
    }

    public void setOptimizationLevel(int i) {
        this.mOptimizationLevel = i;
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        constraintWidgetContainer.G = i;
        ei.c = constraintWidgetContainer.Z(AdRequest.MAX_CONTENT_URL_LENGTH);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setSelfDimensionBehaviour(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r9, int r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            androidx.constraintlayout.widget.ConstraintLayout$Measurer r0 = r8.mMeasurer
            int r1 = r0.d
            int r0 = r0.c
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.FIXED
            int r3 = r8.getChildCount()
            androidx.constraintlayout.core.widgets.ConstraintWidget$a r4 = androidx.constraintlayout.core.widgets.ConstraintWidget.a.WRAP_CONTENT
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = 0
            if (r10 == r6) goto L_0x0031
            if (r10 == 0) goto L_0x0024
            if (r10 == r5) goto L_0x001b
            r10 = r2
            goto L_0x002e
        L_0x001b:
            int r10 = r8.mMaxWidth
            int r10 = r10 - r0
            int r10 = java.lang.Math.min(r10, r11)
            r11 = r2
            goto L_0x003b
        L_0x0024:
            if (r3 != 0) goto L_0x002d
            int r10 = r8.mMinWidth
            int r11 = java.lang.Math.max(r7, r10)
            goto L_0x0039
        L_0x002d:
            r10 = r4
        L_0x002e:
            r11 = r10
            r10 = r7
            goto L_0x003b
        L_0x0031:
            if (r3 != 0) goto L_0x0039
            int r10 = r8.mMinWidth
            int r11 = java.lang.Math.max(r7, r10)
        L_0x0039:
            r10 = r11
            r11 = r4
        L_0x003b:
            if (r12 == r6) goto L_0x0056
            if (r12 == 0) goto L_0x004a
            if (r12 == r5) goto L_0x0042
            goto L_0x0054
        L_0x0042:
            int r12 = r8.mMaxHeight
            int r12 = r12 - r1
            int r12 = java.lang.Math.min(r12, r13)
            goto L_0x0060
        L_0x004a:
            if (r3 != 0) goto L_0x0053
            int r12 = r8.mMinHeight
            int r13 = java.lang.Math.max(r7, r12)
            goto L_0x005e
        L_0x0053:
            r2 = r4
        L_0x0054:
            r12 = r7
            goto L_0x0060
        L_0x0056:
            if (r3 != 0) goto L_0x005e
            int r12 = r8.mMinHeight
            int r13 = java.lang.Math.max(r7, r12)
        L_0x005e:
            r12 = r13
            r2 = r4
        L_0x0060:
            int r13 = r9.u()
            r3 = 1
            if (r10 != r13) goto L_0x006d
            int r13 = r9.o()
            if (r12 == r13) goto L_0x0071
        L_0x006d:
            M8 r13 = r9.f1395a
            r13.f400b = r3
        L_0x0071:
            r9.r = r7
            r9.s = r7
            int r13 = r8.mMaxWidth
            int r13 = r13 - r0
            int[] r4 = r9.f1367b
            r4[r7] = r13
            int r13 = r8.mMaxHeight
            int r13 = r13 - r1
            r4[r3] = r13
            r9.u = r7
            r9.v = r7
            r9.P(r11)
            r9.R(r10)
            r9.Q(r2)
            r9.O(r12)
            int r10 = r8.mMinWidth
            int r10 = r10 - r0
            if (r10 >= 0) goto L_0x0099
            r9.u = r7
            goto L_0x009b
        L_0x0099:
            r9.u = r10
        L_0x009b:
            int r10 = r8.mMinHeight
            int r10 = r10 - r1
            if (r10 >= 0) goto L_0x00a3
            r9.v = r7
            goto L_0x00a5
        L_0x00a3:
            r9.v = r10
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.setSelfDimensionBehaviour(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, int, int, int, int):void");
    }

    public void setState(int i, int i2, int i3) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.b((float) i2, (float) i3, i);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet, i, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(attributeSet, i, i2);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public final int A = 0;
        public int B = 0;
        public int C = 0;
        public int D = 0;
        public int E = 0;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = -1;
        public int K = -1;
        public int L = -1;
        public int M = 0;
        public int N = -1;
        public int O = -1;
        public int P = -1;
        public int Q = -1;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public int T;
        public int U;
        public float a = -1.0f;

        /* renamed from: a  reason: collision with other field name */
        public int f1626a = -1;

        /* renamed from: a  reason: collision with other field name */
        public ConstraintWidget f1627a = new ConstraintWidget();

        /* renamed from: a  reason: collision with other field name */
        public String f1628a = null;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f1629a = ConstraintLayout.USE_CONSTRAINTS_HELPER;
        public float b = 0.0f;

        /* renamed from: b  reason: collision with other field name */
        public int f1630b = -1;

        /* renamed from: b  reason: collision with other field name */
        public String f1631b = null;

        /* renamed from: b  reason: collision with other field name */
        public boolean f1632b = false;
        public float c = 0.5f;

        /* renamed from: c  reason: collision with other field name */
        public int f1633c = -1;

        /* renamed from: c  reason: collision with other field name */
        public boolean f1634c = false;
        public float d = 0.5f;

        /* renamed from: d  reason: collision with other field name */
        public int f1635d = -1;

        /* renamed from: d  reason: collision with other field name */
        public boolean f1636d = ConstraintLayout.USE_CONSTRAINTS_HELPER;
        public float e = -1.0f;

        /* renamed from: e  reason: collision with other field name */
        public int f1637e = -1;

        /* renamed from: e  reason: collision with other field name */
        public boolean f1638e = ConstraintLayout.USE_CONSTRAINTS_HELPER;
        public float f = -1.0f;

        /* renamed from: f  reason: collision with other field name */
        public int f1639f = -1;

        /* renamed from: f  reason: collision with other field name */
        public boolean f1640f = false;
        public float g = 1.0f;

        /* renamed from: g  reason: collision with other field name */
        public int f1641g = -1;

        /* renamed from: g  reason: collision with other field name */
        public boolean f1642g = false;
        public float h = 1.0f;

        /* renamed from: h  reason: collision with other field name */
        public int f1643h = -1;

        /* renamed from: h  reason: collision with other field name */
        public boolean f1644h = false;
        public float i = 0.5f;

        /* renamed from: i  reason: collision with other field name */
        public int f1645i = -1;

        /* renamed from: i  reason: collision with other field name */
        public boolean f1646i = false;
        public float j;

        /* renamed from: j  reason: collision with other field name */
        public int f1647j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = 0;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public final int t = Integer.MIN_VALUE;
        public int u = Integer.MIN_VALUE;
        public final int v = Integer.MIN_VALUE;
        public int w = Integer.MIN_VALUE;
        public int x = Integer.MIN_VALUE;
        public int y = Integer.MIN_VALUE;
        public final int z = Integer.MIN_VALUE;

        public static class a {
            public static final SparseIntArray a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                a = sparseIntArray;
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(C0221hs.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                int i3 = a.a.get(index);
                switch (i3) {
                    case 1:
                        this.L = obtainStyledAttributes.getInt(index, this.L);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.n);
                        this.n = resourceId;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.n = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.o = obtainStyledAttributes.getDimensionPixelSize(index, this.o);
                        break;
                    case 4:
                        float f2 = obtainStyledAttributes.getFloat(index, this.b) % 360.0f;
                        this.b = f2;
                        if (f2 >= 0.0f) {
                            break;
                        } else {
                            this.b = (360.0f - f2) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f1626a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1626a);
                        break;
                    case 6:
                        this.f1630b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f1630b);
                        break;
                    case 7:
                        this.a = obtainStyledAttributes.getFloat(index, this.a);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f1633c);
                        this.f1633c = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            this.f1633c = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f1635d);
                        this.f1635d = resourceId3;
                        if (resourceId3 != -1) {
                            break;
                        } else {
                            this.f1635d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f1637e);
                        this.f1637e = resourceId4;
                        if (resourceId4 != -1) {
                            break;
                        } else {
                            this.f1637e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f1639f);
                        this.f1639f = resourceId5;
                        if (resourceId5 != -1) {
                            break;
                        } else {
                            this.f1639f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f1641g);
                        this.f1641g = resourceId6;
                        if (resourceId6 != -1) {
                            break;
                        } else {
                            this.f1641g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f1643h);
                        this.f1643h = resourceId7;
                        if (resourceId7 != -1) {
                            break;
                        } else {
                            this.f1643h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f1645i);
                        this.f1645i = resourceId8;
                        if (resourceId8 != -1) {
                            break;
                        } else {
                            this.f1645i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f1647j);
                        this.f1647j = resourceId9;
                        if (resourceId9 != -1) {
                            break;
                        } else {
                            this.f1647j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.k);
                        this.k = resourceId10;
                        if (resourceId10 != -1) {
                            break;
                        } else {
                            this.k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId11;
                        if (resourceId11 != -1) {
                            break;
                        } else {
                            this.p = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.q);
                        this.q = resourceId12;
                        if (resourceId12 != -1) {
                            break;
                        } else {
                            this.q = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.r);
                        this.r = resourceId13;
                        if (resourceId13 != -1) {
                            break;
                        } else {
                            this.r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId14;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.t = obtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.u = obtainStyledAttributes.getDimensionPixelSize(index, this.u);
                        break;
                    case 23:
                        this.v = obtainStyledAttributes.getDimensionPixelSize(index, this.v);
                        break;
                    case 24:
                        this.w = obtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 25:
                        this.x = obtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 26:
                        this.y = obtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 27:
                        this.f1632b = obtainStyledAttributes.getBoolean(index, this.f1632b);
                        break;
                    case 28:
                        this.f1634c = obtainStyledAttributes.getBoolean(index, this.f1634c);
                        break;
                    case 29:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 30:
                        this.d = obtainStyledAttributes.getFloat(index, this.d);
                        break;
                    case 31:
                        this.D = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 32:
                        this.E = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 33:
                        try {
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.F) != -2) {
                                break;
                            } else {
                                this.F = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.H) != -2) {
                                break;
                            } else {
                                this.H = -2;
                                break;
                            }
                        }
                    case 35:
                        this.g = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.g));
                        this.D = 2;
                        break;
                    case 36:
                        try {
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.G) != -2) {
                                break;
                            } else {
                                this.G = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.I) != -2) {
                                break;
                            } else {
                                this.I = -2;
                                break;
                            }
                        }
                    case 38:
                        this.h = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.h));
                        this.E = 2;
                        break;
                    default:
                        switch (i3) {
                            case 44:
                                ConstraintSet.n(this, obtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.e = obtainStyledAttributes.getFloat(index, this.e);
                                break;
                            case 46:
                                this.f = obtainStyledAttributes.getFloat(index, this.f);
                                break;
                            case 47:
                                this.B = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.C = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.J = obtainStyledAttributes.getDimensionPixelOffset(index, this.J);
                                break;
                            case 50:
                                this.K = obtainStyledAttributes.getDimensionPixelOffset(index, this.K);
                                break;
                            case 51:
                                this.f1631b = obtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.l);
                                this.l = resourceId15;
                                if (resourceId15 != -1) {
                                    break;
                                } else {
                                    this.l = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.m);
                                this.m = resourceId16;
                                if (resourceId16 != -1) {
                                    break;
                                } else {
                                    this.m = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 54:
                                this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                                break;
                            case 55:
                                this.z = obtainStyledAttributes.getDimensionPixelSize(index, this.z);
                                break;
                            default:
                                switch (i3) {
                                    case 64:
                                        ConstraintSet.m(this, obtainStyledAttributes, index, 0);
                                        break;
                                    case 65:
                                        ConstraintSet.m(this, obtainStyledAttributes, index, 1);
                                        break;
                                    case 66:
                                        this.M = obtainStyledAttributes.getInt(index, this.M);
                                        break;
                                    case 67:
                                        this.f1629a = obtainStyledAttributes.getBoolean(index, this.f1629a);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            a();
        }

        public final void a() {
            this.f1642g = false;
            this.f1636d = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            this.f1638e = ConstraintLayout.USE_CONSTRAINTS_HELPER;
            int i2 = this.width;
            if (i2 == -2 && this.f1632b) {
                this.f1636d = false;
                if (this.D == 0) {
                    this.D = 1;
                }
            }
            int i3 = this.height;
            if (i3 == -2 && this.f1634c) {
                this.f1638e = false;
                if (this.E == 0) {
                    this.E = 1;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.f1636d = false;
                if (i2 == 0 && this.D == 1) {
                    this.width = -2;
                    this.f1632b = ConstraintLayout.USE_CONSTRAINTS_HELPER;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.f1638e = false;
                if (i3 == 0 && this.E == 1) {
                    this.height = -2;
                    this.f1634c = ConstraintLayout.USE_CONSTRAINTS_HELPER;
                }
            }
            if (this.a != -1.0f || this.f1626a != -1 || this.f1630b != -1) {
                this.f1642g = ConstraintLayout.USE_CONSTRAINTS_HELPER;
                this.f1636d = ConstraintLayout.USE_CONSTRAINTS_HELPER;
                this.f1638e = ConstraintLayout.USE_CONSTRAINTS_HELPER;
                if (!(this.f1627a instanceof e)) {
                    this.f1627a = new e();
                }
                ((e) this.f1627a).V(this.L);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0051  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x005e  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x007a  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0082  */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void resolveLayoutDirection(int r11) {
            /*
                r10 = this;
                int r0 = r10.leftMargin
                int r1 = r10.rightMargin
                super.resolveLayoutDirection(r11)
                int r11 = r10.getLayoutDirection()
                r2 = 0
                r3 = 1
                if (r3 != r11) goto L_0x0011
                r11 = r3
                goto L_0x0012
            L_0x0011:
                r11 = r2
            L_0x0012:
                r4 = -1
                r10.P = r4
                r10.Q = r4
                r10.N = r4
                r10.O = r4
                int r5 = r10.t
                r10.R = r5
                int r5 = r10.v
                r10.S = r5
                float r5 = r10.c
                r10.i = r5
                int r6 = r10.f1626a
                r10.T = r6
                int r7 = r10.f1630b
                r10.U = r7
                float r8 = r10.a
                r10.j = r8
                r9 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r11 == 0) goto L_0x0094
                int r11 = r10.p
                if (r11 == r4) goto L_0x003f
                r10.P = r11
            L_0x003d:
                r2 = r3
                goto L_0x0046
            L_0x003f:
                int r11 = r10.q
                if (r11 == r4) goto L_0x0046
                r10.Q = r11
                goto L_0x003d
            L_0x0046:
                int r11 = r10.r
                if (r11 == r4) goto L_0x004d
                r10.O = r11
                r2 = r3
            L_0x004d:
                int r11 = r10.s
                if (r11 == r4) goto L_0x0054
                r10.N = r11
                r2 = r3
            L_0x0054:
                int r11 = r10.x
                if (r11 == r9) goto L_0x005a
                r10.S = r11
            L_0x005a:
                int r11 = r10.y
                if (r11 == r9) goto L_0x0060
                r10.R = r11
            L_0x0060:
                r11 = 1065353216(0x3f800000, float:1.0)
                if (r2 == 0) goto L_0x0068
                float r2 = r11 - r5
                r10.i = r2
            L_0x0068:
                boolean r2 = r10.f1642g
                if (r2 == 0) goto L_0x00b8
                int r2 = r10.L
                if (r2 != r3) goto L_0x00b8
                boolean r2 = r10.f1629a
                if (r2 == 0) goto L_0x00b8
                r2 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                if (r3 == 0) goto L_0x0082
                float r11 = r11 - r8
                r10.j = r11
                r10.T = r4
                r10.U = r4
                goto L_0x00b8
            L_0x0082:
                if (r6 == r4) goto L_0x008b
                r10.U = r6
                r10.T = r4
                r10.j = r2
                goto L_0x00b8
            L_0x008b:
                if (r7 == r4) goto L_0x00b8
                r10.T = r7
                r10.U = r4
                r10.j = r2
                goto L_0x00b8
            L_0x0094:
                int r11 = r10.p
                if (r11 == r4) goto L_0x009a
                r10.O = r11
            L_0x009a:
                int r11 = r10.q
                if (r11 == r4) goto L_0x00a0
                r10.N = r11
            L_0x00a0:
                int r11 = r10.r
                if (r11 == r4) goto L_0x00a6
                r10.P = r11
            L_0x00a6:
                int r11 = r10.s
                if (r11 == r4) goto L_0x00ac
                r10.Q = r11
            L_0x00ac:
                int r11 = r10.x
                if (r11 == r9) goto L_0x00b2
                r10.R = r11
            L_0x00b2:
                int r11 = r10.y
                if (r11 == r9) goto L_0x00b8
                r10.S = r11
            L_0x00b8:
                int r11 = r10.r
                if (r11 != r4) goto L_0x0102
                int r11 = r10.s
                if (r11 != r4) goto L_0x0102
                int r11 = r10.q
                if (r11 != r4) goto L_0x0102
                int r11 = r10.p
                if (r11 != r4) goto L_0x0102
                int r11 = r10.f1637e
                if (r11 == r4) goto L_0x00d7
                r10.P = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00e5
                if (r1 <= 0) goto L_0x00e5
                r10.rightMargin = r1
                goto L_0x00e5
            L_0x00d7:
                int r11 = r10.f1639f
                if (r11 == r4) goto L_0x00e5
                r10.Q = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00e5
                if (r1 <= 0) goto L_0x00e5
                r10.rightMargin = r1
            L_0x00e5:
                int r11 = r10.f1633c
                if (r11 == r4) goto L_0x00f4
                r10.N = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0102
                if (r0 <= 0) goto L_0x0102
                r10.leftMargin = r0
                goto L_0x0102
            L_0x00f4:
                int r11 = r10.f1635d
                if (r11 == r4) goto L_0x0102
                r10.O = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0102
                if (r0 <= 0) goto L_0x0102
                r10.leftMargin = r0
            L_0x0102:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public LayoutParams() {
            super(-2, -2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
