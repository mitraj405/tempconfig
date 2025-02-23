package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;

public class MotionEffect extends MotionHelper {
    public float b = 0.1f;
    public boolean c = true;
    public int d = 49;
    public int e = 50;
    public int f = 0;
    public int g = 0;
    public int h = -1;
    public int i = -1;

    public MotionEffect(Context context) {
        super(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0184, code lost:
        if (r14 == 0.0f) goto L_0x0186;
     */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void u(androidx.constraintlayout.motion.widget.MotionLayout r21, java.util.HashMap<android.view.View, defpackage.Vl> r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r22
            android.view.ViewParent r2 = r20.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r2 = (androidx.constraintlayout.widget.ConstraintLayout) r2
            android.view.View[] r2 = r0.m(r2)
            if (r2 != 0) goto L_0x0014
            defpackage.C0175e8.a()
            return
        L_0x0014:
            mh r3 = new mh
            r3.<init>()
            mh r4 = new mh
            r4.<init>()
            float r5 = r0.b
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            java.lang.String r6 = "alpha"
            r3.h(r5, r6)
            float r5 = r0.b
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r4.h(r5, r6)
            int r5 = r0.d
            r3.a = r5
            int r5 = r0.e
            r4.a = r5
            xh r5 = new xh
            r5.<init>()
            int r6 = r0.d
            r5.a = r6
            r6 = 0
            r5.f3414f = r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r8 = "percentX"
            r5.h(r7, r8)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r9 = "percentY"
            r5.h(r7, r9)
            xh r7 = new xh
            r7.<init>()
            int r10 = r0.e
            r7.a = r10
            r7.f3414f = r6
            r10 = 1
            java.lang.Integer r11 = java.lang.Integer.valueOf(r10)
            r7.h(r11, r8)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)
            r7.h(r8, r9)
            int r8 = r0.f
            r9 = 0
            if (r8 <= 0) goto L_0x009d
            mh r8 = new mh
            r8.<init>()
            mh r11 = new mh
            r11.<init>()
            int r12 = r0.f
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)
            java.lang.String r13 = "translationX"
            r8.h(r12, r13)
            int r12 = r0.e
            r8.a = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r6)
            r11.h(r12, r13)
            int r12 = r0.e
            int r12 = r12 - r10
            r11.a = r12
            goto L_0x009f
        L_0x009d:
            r8 = r9
            r11 = r8
        L_0x009f:
            int r12 = r0.g
            if (r12 <= 0) goto L_0x00ce
            mh r9 = new mh
            r9.<init>()
            mh r12 = new mh
            r12.<init>()
            int r13 = r0.g
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = "translationY"
            r9.h(r13, r14)
            int r13 = r0.e
            r9.a = r13
            java.lang.Integer r13 = java.lang.Integer.valueOf(r6)
            r12.h(r13, r14)
            int r13 = r0.e
            int r13 = r13 - r10
            r12.a = r13
            r19 = r12
            r12 = r9
            r9 = r19
            goto L_0x00cf
        L_0x00ce:
            r12 = r9
        L_0x00cf:
            int r13 = r0.i
            r15 = -1
            r16 = 0
            if (r13 != r15) goto L_0x013f
            r13 = 4
            int[] r15 = new int[r13]
            r13 = r6
        L_0x00da:
            int r14 = r2.length
            if (r13 >= r14) goto L_0x012b
            r14 = r2[r13]
            java.lang.Object r14 = r1.get(r14)
            Vl r14 = (defpackage.Vl) r14
            if (r14 != 0) goto L_0x00ea
            r18 = r9
            goto L_0x0124
        L_0x00ea:
            Xl r6 = r14.f619b
            float r10 = r6.c
            Xl r14 = r14.f604a
            r18 = r9
            float r9 = r14.c
            float r10 = r10 - r9
            float r6 = r6.d
            float r9 = r14.d
            float r6 = r6 - r9
            int r9 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r9 >= 0) goto L_0x0105
            r9 = 1
            r14 = r15[r9]
            int r14 = r14 + r9
            r15[r9] = r14
            goto L_0x0106
        L_0x0105:
            r9 = 1
        L_0x0106:
            int r6 = (r6 > r16 ? 1 : (r6 == r16 ? 0 : -1))
            if (r6 <= 0) goto L_0x0110
            r6 = 0
            r14 = r15[r6]
            int r14 = r14 + r9
            r15[r6] = r14
        L_0x0110:
            int r6 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r6 <= 0) goto L_0x011a
            r6 = 3
            r14 = r15[r6]
            int r14 = r14 + r9
            r15[r6] = r14
        L_0x011a:
            int r6 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1))
            if (r6 >= 0) goto L_0x0124
            r6 = 2
            r10 = r15[r6]
            int r10 = r10 + r9
            r15[r6] = r10
        L_0x0124:
            int r13 = r13 + 1
            r9 = r18
            r6 = 0
            r10 = 1
            goto L_0x00da
        L_0x012b:
            r18 = r9
            r9 = r6
            r6 = r15[r9]
            r13 = r9
            r10 = 1
            r14 = 4
        L_0x0133:
            if (r10 >= r14) goto L_0x0141
            r9 = r15[r10]
            if (r6 >= r9) goto L_0x013b
            r6 = r9
            r13 = r10
        L_0x013b:
            int r10 = r10 + 1
            r9 = 0
            goto L_0x0133
        L_0x013f:
            r18 = r9
        L_0x0141:
            r6 = 0
        L_0x0142:
            int r9 = r2.length
            if (r6 >= r9) goto L_0x0231
            r9 = r2[r6]
            java.lang.Object r9 = r1.get(r9)
            Vl r9 = (defpackage.Vl) r9
            if (r9 != 0) goto L_0x0157
        L_0x014f:
            r10 = r21
            r17 = r2
            r14 = r18
            goto L_0x0224
        L_0x0157:
            Xl r10 = r9.f619b
            float r14 = r10.c
            Xl r15 = r9.f604a
            float r1 = r15.c
            float r14 = r14 - r1
            float r1 = r10.d
            float r10 = r15.d
            float r1 = r1 - r10
            if (r13 != 0) goto L_0x0177
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 <= 0) goto L_0x0175
            boolean r1 = r0.c
            if (r1 == 0) goto L_0x0173
            int r1 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x0175
        L_0x0173:
            r10 = 1
            goto L_0x0186
        L_0x0175:
            r10 = 1
            goto L_0x018a
        L_0x0177:
            r10 = 1
            if (r13 != r10) goto L_0x018d
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 >= 0) goto L_0x018a
            boolean r1 = r0.c
            if (r1 == 0) goto L_0x0186
            int r1 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x018a
        L_0x0186:
            r1 = 0
            r10 = 3
            r15 = 2
            goto L_0x01b3
        L_0x018a:
            r10 = 3
            r15 = 2
            goto L_0x01b2
        L_0x018d:
            r15 = 2
            if (r13 != r15) goto L_0x01a1
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x019f
            boolean r14 = r0.c
            if (r14 == 0) goto L_0x019c
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x019f
        L_0x019c:
            r1 = 0
            r10 = 3
            goto L_0x01b3
        L_0x019f:
            r10 = 3
            goto L_0x01b2
        L_0x01a1:
            r10 = 3
            if (r13 != r10) goto L_0x01b2
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 <= 0) goto L_0x01b2
            boolean r14 = r0.c
            if (r14 == 0) goto L_0x01b0
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 != 0) goto L_0x01b2
        L_0x01b0:
            r1 = 0
            goto L_0x01b3
        L_0x01b2:
            r1 = 1
        L_0x01b3:
            if (r1 == 0) goto L_0x014f
            int r1 = r0.h
            r14 = -1
            if (r1 != r14) goto L_0x01e2
            r9.a(r3)
            r9.a(r4)
            r9.a(r5)
            r9.a(r7)
            int r1 = r0.f
            if (r1 <= 0) goto L_0x01d0
            r9.a(r8)
            r9.a(r11)
        L_0x01d0:
            int r1 = r0.g
            if (r1 <= 0) goto L_0x01df
            r9.a(r12)
            r14 = r18
            r9.a(r14)
        L_0x01dc:
            r10 = r21
            goto L_0x0222
        L_0x01df:
            r14 = r18
            goto L_0x01dc
        L_0x01e2:
            r10 = r21
            r14 = r18
            androidx.constraintlayout.motion.widget.a r15 = r10.f1447a
            if (r15 == 0) goto L_0x0222
            androidx.constraintlayout.motion.widget.d r15 = r15.f1508a
            java.util.ArrayList<androidx.constraintlayout.motion.widget.c> r15 = r15.f1558a
            java.util.Iterator r15 = r15.iterator()
        L_0x01f2:
            boolean r17 = r15.hasNext()
            if (r17 == 0) goto L_0x0222
            java.lang.Object r17 = r15.next()
            r0 = r17
            androidx.constraintlayout.motion.widget.c r0 = (androidx.constraintlayout.motion.widget.c) r0
            r17 = r2
            int r2 = r0.a
            if (r2 != r1) goto L_0x021d
            r2 = -1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            rh r0 = r0.f1545a
            java.util.HashMap<java.lang.Integer, java.util.ArrayList<lh>> r0 = r0.a
            java.lang.Object r0 = r0.get(r1)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 == 0) goto L_0x0225
            java.util.ArrayList<lh> r1 = r9.f621b
            r1.addAll(r0)
            goto L_0x0225
        L_0x021d:
            r0 = r20
            r2 = r17
            goto L_0x01f2
        L_0x0222:
            r17 = r2
        L_0x0224:
            r2 = -1
        L_0x0225:
            int r6 = r6 + 1
            r0 = r20
            r1 = r22
            r18 = r14
            r2 = r17
            goto L_0x0142
        L_0x0231:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.u(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    public final void v(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0221hs.MotionEffect);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == C0221hs.MotionEffect_motionEffect_start) {
                    int i3 = obtainStyledAttributes.getInt(index, this.d);
                    this.d = i3;
                    this.d = Math.max(Math.min(i3, 99), 0);
                } else if (index == C0221hs.MotionEffect_motionEffect_end) {
                    int i4 = obtainStyledAttributes.getInt(index, this.e);
                    this.e = i4;
                    this.e = Math.max(Math.min(i4, 99), 0);
                } else if (index == C0221hs.MotionEffect_motionEffect_translationX) {
                    this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                } else if (index == C0221hs.MotionEffect_motionEffect_translationY) {
                    this.g = obtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == C0221hs.MotionEffect_motionEffect_alpha) {
                    this.b = obtainStyledAttributes.getFloat(index, this.b);
                } else if (index == C0221hs.MotionEffect_motionEffect_move) {
                    this.i = obtainStyledAttributes.getInt(index, this.i);
                } else if (index == C0221hs.MotionEffect_motionEffect_strict) {
                    this.c = obtainStyledAttributes.getBoolean(index, this.c);
                } else if (index == C0221hs.MotionEffect_motionEffect_viewTransition) {
                    this.h = obtainStyledAttributes.getResourceId(index, this.h);
                }
            }
            int i5 = this.d;
            int i6 = this.e;
            if (i5 == i6) {
                if (i5 > 0) {
                    this.d = i5 - 1;
                } else {
                    this.e = i6 + 1;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        v(context, attributeSet);
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        v(context, attributeSet);
    }
}
