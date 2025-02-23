package defpackage;

/* renamed from: Gw  reason: default package */
/* compiled from: SidePropagation */
public final class Gw extends jD {
    public final float a = 3.0f;

    /* renamed from: a  reason: collision with other field name */
    public int f238a = 80;

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008b, code lost:
        if (r5 != false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        if (r5 != false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009c, code lost:
        r15 = 5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long c(android.view.ViewGroup r18, androidx.transition.Transition r19, androidx.transition.TransitionValues r20, androidx.transition.TransitionValues r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            r2 = 0
            if (r1 != 0) goto L_0x000b
            if (r21 != 0) goto L_0x000b
            return r2
        L_0x000b:
            android.graphics.Rect r4 = r19.getEpicenter()
            r5 = 1
            if (r21 == 0) goto L_0x002f
            r6 = 8
            if (r1 != 0) goto L_0x0017
            goto L_0x0028
        L_0x0017:
            java.util.HashMap r7 = r1.f2517a
            java.lang.String r8 = "android:visibilityPropagation:visibility"
            java.lang.Object r7 = r7.get(r8)
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 != 0) goto L_0x0024
            goto L_0x0028
        L_0x0024:
            int r6 = r7.intValue()
        L_0x0028:
            if (r6 != 0) goto L_0x002b
            goto L_0x002f
        L_0x002b:
            r1 = r21
            r6 = r5
            goto L_0x0030
        L_0x002f:
            r6 = -1
        L_0x0030:
            r7 = 0
            int r8 = defpackage.jD.d(r1, r7)
            int r1 = defpackage.jD.d(r1, r5)
            r9 = 2
            int[] r10 = new int[r9]
            r11 = r18
            r11.getLocationOnScreen(r10)
            r12 = r10[r7]
            float r13 = r18.getTranslationX()
            int r13 = java.lang.Math.round(r13)
            int r13 = r13 + r12
            r10 = r10[r5]
            float r12 = r18.getTranslationY()
            int r12 = java.lang.Math.round(r12)
            int r12 = r12 + r10
            int r10 = r18.getWidth()
            int r10 = r10 + r13
            int r14 = r18.getHeight()
            int r14 = r14 + r12
            if (r4 == 0) goto L_0x006c
            int r9 = r4.centerX()
            int r4 = r4.centerY()
            goto L_0x0078
        L_0x006c:
            int r4 = r13 + r10
            int r4 = r4 / r9
            int r15 = r12 + r14
            int r9 = r15 / 2
            r16 = r9
            r9 = r4
            r4 = r16
        L_0x0078:
            int r15 = r0.f238a
            r2 = 8388613(0x800005, float:1.175495E-38)
            r3 = 3
            r7 = 8388611(0x800003, float:1.1754948E-38)
            if (r15 != r7) goto L_0x008e
            int r15 = r18.getLayoutDirection()
            if (r15 != r5) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r5 = 0
        L_0x008b:
            if (r5 == 0) goto L_0x009a
            goto L_0x009c
        L_0x008e:
            if (r15 != r2) goto L_0x009d
            int r15 = r18.getLayoutDirection()
            if (r15 != r5) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r5 = 0
        L_0x0098:
            if (r5 == 0) goto L_0x009c
        L_0x009a:
            r15 = r3
            goto L_0x009d
        L_0x009c:
            r15 = 5
        L_0x009d:
            if (r15 == r3) goto L_0x00c4
            r5 = 5
            if (r15 == r5) goto L_0x00bc
            r4 = 48
            if (r15 == r4) goto L_0x00b4
            r4 = 80
            if (r15 == r4) goto L_0x00ac
            r1 = 0
            goto L_0x00cb
        L_0x00ac:
            int r1 = r1 - r12
            int r9 = r9 - r8
            int r4 = java.lang.Math.abs(r9)
            int r1 = r1 + r4
            goto L_0x00cb
        L_0x00b4:
            int r14 = r14 - r1
            int r9 = r9 - r8
            int r1 = java.lang.Math.abs(r9)
            int r1 = r1 + r14
            goto L_0x00cb
        L_0x00bc:
            int r8 = r8 - r13
            int r4 = r4 - r1
            int r1 = java.lang.Math.abs(r4)
            int r1 = r1 + r8
            goto L_0x00cb
        L_0x00c4:
            int r10 = r10 - r8
            int r4 = r4 - r1
            int r1 = java.lang.Math.abs(r4)
            int r1 = r1 + r10
        L_0x00cb:
            float r1 = (float) r1
            int r4 = r0.f238a
            if (r4 == r3) goto L_0x00dc
            r3 = 5
            if (r4 == r3) goto L_0x00dc
            if (r4 == r7) goto L_0x00dc
            if (r4 == r2) goto L_0x00dc
            int r2 = r18.getHeight()
            goto L_0x00e0
        L_0x00dc:
            int r2 = r18.getWidth()
        L_0x00e0:
            float r2 = (float) r2
            float r1 = r1 / r2
            long r2 = r19.getDuration()
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x00ee
            r2 = 300(0x12c, double:1.48E-321)
        L_0x00ee:
            long r4 = (long) r6
            long r2 = r2 * r4
            float r2 = (float) r2
            float r3 = r0.a
            float r2 = r2 / r3
            float r2 = r2 * r1
            int r1 = java.lang.Math.round(r2)
            long r1 = (long) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Gw.c(android.view.ViewGroup, androidx.transition.Transition, androidx.transition.TransitionValues, androidx.transition.TransitionValues):long");
    }
}
