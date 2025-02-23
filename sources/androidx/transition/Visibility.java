package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import java.util.HashMap;

public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};
    private int mMode = 3;

    public static class VisibilityInfo {
        public int a;

        /* renamed from: a  reason: collision with other field name */
        public ViewGroup f2520a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2521a;
        public int b;

        /* renamed from: b  reason: collision with other field name */
        public ViewGroup f2522b;

        /* renamed from: b  reason: collision with other field name */
        public boolean f2523b;
    }

    public static class a extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final View f2524a;

        /* renamed from: a  reason: collision with other field name */
        public final ViewGroup f2525a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f2526a;
        public boolean b;
        public boolean c = false;

        public a(View view, int i) {
            this.f2524a = view;
            this.a = i;
            this.f2525a = (ViewGroup) view.getParent();
            this.f2526a = true;
            a(true);
        }

        public final void a(boolean z) {
            ViewGroup viewGroup;
            if (this.f2526a && this.b != z && (viewGroup = this.f2525a) != null) {
                this.b = z;
                C0338tC.a(viewGroup, z);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            this.c = true;
        }

        public final void onAnimationEnd(Animator animator) {
            if (!this.c) {
                TC.c(this.f2524a, this.a);
                ViewGroup viewGroup = this.f2525a;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public final void onTransitionPause(Transition transition) {
            a(false);
            if (!this.c) {
                TC.c(this.f2524a, this.a);
            }
        }

        public final void onTransitionResume(Transition transition) {
            a(true);
            if (!this.c) {
                TC.c(this.f2524a, 0);
            }
        }

        public final void onAnimationStart(Animator animator, boolean z) {
            if (z) {
                TC.c(this.f2524a, 0);
                ViewGroup viewGroup = this.f2525a;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }

        public final void onAnimationEnd(Animator animator, boolean z) {
            if (!z) {
                if (!this.c) {
                    TC.c(this.f2524a, this.a);
                    ViewGroup viewGroup = this.f2525a;
                    if (viewGroup != null) {
                        viewGroup.invalidate();
                    }
                }
                a(false);
            }
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onTransitionCancel(Transition transition) {
        }

        public final void onTransitionStart(Transition transition) {
        }
    }

    public class b extends AnimatorListenerAdapter implements Transition.TransitionListener {
        public final View a;

        /* renamed from: a  reason: collision with other field name */
        public final ViewGroup f2527a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f2529a = true;
        public final View b;

        public b(ViewGroup viewGroup, View view, View view2) {
            this.f2527a = viewGroup;
            this.a = view;
            this.b = view2;
        }

        public final void a() {
            this.b.setTag(Br.save_overlay_view, (Object) null);
            this.f2527a.getOverlay().remove(this.a);
            this.f2529a = false;
        }

        public final void onAnimationEnd(Animator animator) {
            a();
        }

        public final void onAnimationPause(Animator animator) {
            this.f2527a.getOverlay().remove(this.a);
        }

        public final void onAnimationResume(Animator animator) {
            View view = this.a;
            if (view.getParent() == null) {
                this.f2527a.getOverlay().add(view);
            } else {
                Visibility.this.cancel();
            }
        }

        public final void onAnimationStart(Animator animator, boolean z) {
            if (z) {
                View view = this.b;
                int i = Br.save_overlay_view;
                View view2 = this.a;
                view.setTag(i, view2);
                this.f2527a.getOverlay().add(view2);
                this.f2529a = true;
            }
        }

        public final void onTransitionCancel(Transition transition) {
            if (this.f2529a) {
                a();
            }
        }

        public final void onTransitionEnd(Transition transition) {
            transition.removeListener(this);
        }

        public final void onAnimationEnd(Animator animator, boolean z) {
            if (!z) {
                a();
            }
        }

        public final void onTransitionPause(Transition transition) {
        }

        public final void onTransitionResume(Transition transition) {
        }

        public final void onTransitionStart(Transition transition) {
        }
    }

    public Visibility() {
    }

    private void captureValues(TransitionValues transitionValues) {
        Integer valueOf = Integer.valueOf(transitionValues.a.getVisibility());
        HashMap hashMap = transitionValues.f2517a;
        hashMap.put(PROPNAME_VISIBILITY, valueOf);
        hashMap.put(PROPNAME_PARENT, transitionValues.a.getParent());
        int[] iArr = new int[2];
        transitionValues.a.getLocationOnScreen(iArr);
        hashMap.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.transition.Visibility.VisibilityInfo getVisibilityChangeInfo(androidx.transition.TransitionValues r9, androidx.transition.TransitionValues r10) {
        /*
            r8 = this;
            androidx.transition.Visibility$VisibilityInfo r0 = new androidx.transition.Visibility$VisibilityInfo
            r0.<init>()
            r1 = 0
            r0.f2521a = r1
            r0.f2523b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r9 == 0) goto L_0x002f
            java.util.HashMap r6 = r9.f2517a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L_0x002f
            java.lang.Object r7 = r6.get(r5)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r0.a = r7
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f2520a = r6
            goto L_0x0033
        L_0x002f:
            r0.a = r4
            r0.f2520a = r3
        L_0x0033:
            if (r10 == 0) goto L_0x0052
            java.util.HashMap r6 = r10.f2517a
            boolean r7 = r6.containsKey(r5)
            if (r7 == 0) goto L_0x0052
            java.lang.Object r3 = r6.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.b = r3
            java.lang.Object r2 = r6.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f2522b = r2
            goto L_0x0056
        L_0x0052:
            r0.b = r4
            r0.f2522b = r3
        L_0x0056:
            r2 = 1
            if (r9 == 0) goto L_0x008a
            if (r10 == 0) goto L_0x008a
            int r9 = r0.a
            int r10 = r0.b
            if (r9 != r10) goto L_0x0068
            android.view.ViewGroup r3 = r0.f2520a
            android.view.ViewGroup r4 = r0.f2522b
            if (r3 != r4) goto L_0x0068
            return r0
        L_0x0068:
            if (r9 == r10) goto L_0x0078
            if (r9 != 0) goto L_0x0071
            r0.f2523b = r1
            r0.f2521a = r2
            goto L_0x009f
        L_0x0071:
            if (r10 != 0) goto L_0x009f
            r0.f2523b = r2
            r0.f2521a = r2
            goto L_0x009f
        L_0x0078:
            android.view.ViewGroup r9 = r0.f2522b
            if (r9 != 0) goto L_0x0081
            r0.f2523b = r1
            r0.f2521a = r2
            goto L_0x009f
        L_0x0081:
            android.view.ViewGroup r9 = r0.f2520a
            if (r9 != 0) goto L_0x009f
            r0.f2523b = r2
            r0.f2521a = r2
            goto L_0x009f
        L_0x008a:
            if (r9 != 0) goto L_0x0095
            int r9 = r0.b
            if (r9 != 0) goto L_0x0095
            r0.f2523b = r2
            r0.f2521a = r2
            goto L_0x009f
        L_0x0095:
            if (r10 != 0) goto L_0x009f
            int r9 = r0.a
            if (r9 != 0) goto L_0x009f
            r0.f2523b = r1
            r0.f2521a = r2
        L_0x009f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.getVisibilityChangeInfo(androidx.transition.TransitionValues, androidx.transition.TransitionValues):androidx.transition.Visibility$VisibilityInfo");
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.f2521a) {
            return null;
        }
        if (visibilityChangeInfo.f2520a == null && visibilityChangeInfo.f2522b == null) {
            return null;
        }
        if (visibilityChangeInfo.f2523b) {
            return onAppear(viewGroup, transitionValues, visibilityChangeInfo.a, transitionValues2, visibilityChangeInfo.b);
        }
        return onDisappear(viewGroup, transitionValues, visibilityChangeInfo.a, transitionValues2, visibilityChangeInfo.b);
    }

    public int getMode() {
        return this.mMode;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.f2517a.containsKey(PROPNAME_VISIBILITY) != transitionValues.f2517a.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.f2521a) {
            return false;
        }
        if (visibilityChangeInfo.a == 0 || visibilityChangeInfo.b == 0) {
            return true;
        }
        return false;
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        HashMap hashMap = transitionValues.f2517a;
        int intValue = ((Integer) hashMap.get(PROPNAME_VISIBILITY)).intValue();
        View view = (View) hashMap.get(PROPNAME_PARENT);
        if (intValue != 0 || view == null) {
            return false;
        }
        return true;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public void setMode(int i) {
        if ((i & -4) == 0) {
            this.mMode = i;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.a.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f2521a) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.a, transitionValues, transitionValues2);
    }

    /* JADX WARNING: type inference failed for: r17v4, types: [android.view.ViewParent] */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01b8, code lost:
        if (r0.mCanRemoveViews != false) goto L_0x01ba;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0182  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator onDisappear(android.view.ViewGroup r21, androidx.transition.TransitionValues r22, int r23, androidx.transition.TransitionValues r24, int r25) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r24
            r4 = r25
            int r5 = r0.mMode
            r6 = 2
            r5 = r5 & r6
            r7 = 0
            if (r5 == r6) goto L_0x0012
            return r7
        L_0x0012:
            if (r2 != 0) goto L_0x0015
            return r7
        L_0x0015:
            android.view.View r5 = r2.a
            if (r3 == 0) goto L_0x001c
            android.view.View r8 = r3.a
            goto L_0x001d
        L_0x001c:
            r8 = r7
        L_0x001d:
            int r9 = defpackage.Br.save_overlay_view
            java.lang.Object r10 = r5.getTag(r9)
            android.view.View r10 = (android.view.View) r10
            r11 = 1
            if (r10 == 0) goto L_0x002d
            r8 = r7
            r19 = r9
            goto L_0x01c6
        L_0x002d:
            if (r8 == 0) goto L_0x003f
            android.view.ViewParent r10 = r8.getParent()
            if (r10 != 0) goto L_0x0036
            goto L_0x003f
        L_0x0036:
            r10 = 4
            if (r4 != r10) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            if (r5 != r8) goto L_0x0045
        L_0x003c:
            r10 = r7
            r13 = 0
            goto L_0x0048
        L_0x003f:
            if (r8 == 0) goto L_0x0045
            r10 = r8
            r13 = 0
            r8 = r7
            goto L_0x0048
        L_0x0045:
            r8 = r7
            r10 = r8
            r13 = r11
        L_0x0048:
            if (r13 == 0) goto L_0x01bf
            android.view.ViewParent r13 = r5.getParent()
            if (r13 != 0) goto L_0x0056
            r18 = r8
            r19 = r9
            goto L_0x01ba
        L_0x0056:
            android.view.ViewParent r13 = r5.getParent()
            boolean r13 = r13 instanceof android.view.View
            if (r13 == 0) goto L_0x01bf
            android.view.ViewParent r13 = r5.getParent()
            android.view.View r13 = (android.view.View) r13
            androidx.transition.TransitionValues r14 = r0.getTransitionValues(r13, r11)
            androidx.transition.TransitionValues r15 = r0.getMatchedTransitionValues(r13, r11)
            androidx.transition.Visibility$VisibilityInfo r14 = r0.getVisibilityChangeInfo(r14, r15)
            boolean r14 = r14.f2521a
            if (r14 != 0) goto L_0x019d
            boolean r10 = androidx.transition.f.a
            android.graphics.Matrix r10 = new android.graphics.Matrix
            r10.<init>()
            int r14 = r13.getScrollX()
            int r14 = -r14
            float r14 = (float) r14
            int r13 = r13.getScrollY()
            int r13 = -r13
            float r13 = (float) r13
            r10.setTranslate(r14, r13)
            YC r13 = defpackage.TC.f548a
            r13.e(r5, r10)
            r13.f(r1, r10)
            android.graphics.RectF r13 = new android.graphics.RectF
            int r14 = r5.getWidth()
            float r14 = (float) r14
            int r15 = r5.getHeight()
            float r15 = (float) r15
            r7 = 0
            r13.<init>(r7, r7, r14, r15)
            r10.mapRect(r13)
            float r7 = r13.left
            int r7 = java.lang.Math.round(r7)
            float r14 = r13.top
            int r14 = java.lang.Math.round(r14)
            float r15 = r13.right
            int r15 = java.lang.Math.round(r15)
            float r6 = r13.bottom
            int r6 = java.lang.Math.round(r6)
            android.widget.ImageView r12 = new android.widget.ImageView
            android.content.Context r11 = r5.getContext()
            r12.<init>(r11)
            android.widget.ImageView$ScaleType r11 = android.widget.ImageView.ScaleType.CENTER_CROP
            r12.setScaleType(r11)
            boolean r11 = r5.isAttachedToWindow()
            r16 = 1
            r11 = r11 ^ 1
            if (r1 == 0) goto L_0x00de
            boolean r17 = r21.isAttachedToWindow()
            if (r17 == 0) goto L_0x00de
            r17 = 1
            goto L_0x00e0
        L_0x00de:
            r17 = 0
        L_0x00e0:
            if (r11 == 0) goto L_0x0107
            if (r17 != 0) goto L_0x00eb
            r18 = r8
            r19 = r9
            r0 = 0
            goto L_0x0180
        L_0x00eb:
            android.view.ViewParent r17 = r5.getParent()
            r18 = r8
            r8 = r17
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            int r17 = r8.indexOfChild(r5)
            r19 = r8
            android.view.ViewGroupOverlay r8 = r21.getOverlay()
            r8.add(r5)
            r4 = r17
            r8 = r19
            goto L_0x010b
        L_0x0107:
            r18 = r8
            r4 = 0
            r8 = 0
        L_0x010b:
            float r17 = r13.width()
            r19 = r9
            int r9 = java.lang.Math.round(r17)
            float r17 = r13.height()
            int r3 = java.lang.Math.round(r17)
            if (r9 <= 0) goto L_0x0173
            if (r3 <= 0) goto L_0x0173
            int r2 = r9 * r3
            float r2 = (float) r2
            r17 = 1233125376(0x49800000, float:1048576.0)
            float r2 = r17 / r2
            r0 = 1065353216(0x3f800000, float:1.0)
            float r0 = java.lang.Math.min(r0, r2)
            float r2 = (float) r9
            float r2 = r2 * r0
            int r2 = java.lang.Math.round(r2)
            float r3 = (float) r3
            float r3 = r3 * r0
            int r3 = java.lang.Math.round(r3)
            float r9 = r13.left
            float r9 = -r9
            float r13 = r13.top
            float r13 = -r13
            r10.postTranslate(r9, r13)
            r10.postScale(r0, r0)
            boolean r0 = androidx.transition.f.a
            if (r0 == 0) goto L_0x0161
            android.graphics.Picture r0 = new android.graphics.Picture
            r0.<init>()
            android.graphics.Canvas r2 = r0.beginRecording(r2, r3)
            r2.concat(r10)
            r5.draw(r2)
            r0.endRecording()
            android.graphics.Bitmap r0 = androidx.transition.f.a.a(r0)
            goto L_0x0174
        L_0x0161:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r2, r3, r0)
            android.graphics.Canvas r2 = new android.graphics.Canvas
            r2.<init>(r0)
            r2.concat(r10)
            r5.draw(r2)
            goto L_0x0174
        L_0x0173:
            r0 = 0
        L_0x0174:
            if (r11 == 0) goto L_0x0180
            android.view.ViewGroupOverlay r2 = r21.getOverlay()
            r2.remove(r5)
            r8.addView(r5, r4)
        L_0x0180:
            if (r0 == 0) goto L_0x0185
            r12.setImageBitmap(r0)
        L_0x0185:
            int r0 = r15 - r7
            r2 = 1073741824(0x40000000, float:2.0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r2)
            int r3 = r6 - r14
            int r2 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r2)
            r12.measure(r0, r2)
            r12.layout(r7, r14, r15, r6)
            r0 = r20
            r10 = r12
            goto L_0x01c3
        L_0x019d:
            r18 = r8
            r19 = r9
            int r0 = r13.getId()
            android.view.ViewParent r2 = r13.getParent()
            if (r2 != 0) goto L_0x01bc
            r2 = -1
            if (r0 == r2) goto L_0x01bc
            android.view.View r0 = r1.findViewById(r0)
            if (r0 == 0) goto L_0x01bc
            r0 = r20
            boolean r2 = r0.mCanRemoveViews
            if (r2 == 0) goto L_0x01c3
        L_0x01ba:
            r10 = r5
            goto L_0x01c3
        L_0x01bc:
            r0 = r20
            goto L_0x01c3
        L_0x01bf:
            r18 = r8
            r19 = r9
        L_0x01c3:
            r8 = r18
            r11 = 0
        L_0x01c6:
            if (r10 == 0) goto L_0x0229
            r2 = r22
            if (r11 != 0) goto L_0x01ff
            java.util.HashMap r3 = r2.f2517a
            java.lang.String r4 = "android:visibility:screenLocation"
            java.lang.Object r3 = r3.get(r4)
            int[] r3 = (int[]) r3
            r4 = 0
            r6 = r3[r4]
            r7 = 1
            r3 = r3[r7]
            r8 = 2
            int[] r8 = new int[r8]
            r1.getLocationOnScreen(r8)
            r4 = r8[r4]
            int r6 = r6 - r4
            int r4 = r10.getLeft()
            int r6 = r6 - r4
            r10.offsetLeftAndRight(r6)
            r4 = r8[r7]
            int r3 = r3 - r4
            int r4 = r10.getTop()
            int r3 = r3 - r4
            r10.offsetTopAndBottom(r3)
            android.view.ViewGroupOverlay r3 = r21.getOverlay()
            r3.add(r10)
        L_0x01ff:
            r3 = r24
            android.animation.Animator r2 = r0.onDisappear(r1, r10, r2, r3)
            if (r11 != 0) goto L_0x0228
            if (r2 != 0) goto L_0x0211
            android.view.ViewGroupOverlay r1 = r21.getOverlay()
            r1.remove(r10)
            goto L_0x0228
        L_0x0211:
            r3 = r19
            r5.setTag(r3, r10)
            androidx.transition.Visibility$b r3 = new androidx.transition.Visibility$b
            r3.<init>(r1, r10, r5)
            r2.addListener(r3)
            r2.addPauseListener(r3)
            androidx.transition.Transition r1 = r20.getRootTransition()
            r1.addListener(r3)
        L_0x0228:
            return r2
        L_0x0229:
            r2 = r22
            r3 = r24
            if (r8 == 0) goto L_0x0253
            int r4 = r8.getVisibility()
            r5 = 0
            defpackage.TC.c(r8, r5)
            android.animation.Animator r1 = r0.onDisappear(r1, r8, r2, r3)
            if (r1 == 0) goto L_0x024f
            androidx.transition.Visibility$a r2 = new androidx.transition.Visibility$a
            r3 = r25
            r2.<init>(r8, r3)
            r1.addListener(r2)
            androidx.transition.Transition r3 = r20.getRootTransition()
            r3.addListener(r2)
            goto L_0x0252
        L_0x024f:
            defpackage.TC.c(r8, r4)
        L_0x0252:
            return r1
        L_0x0253:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.onDisappear(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0385wy.c);
        int c = SA.c(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (c != 0) {
            setMode(c);
        }
    }
}
