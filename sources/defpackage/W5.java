package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Shader;

/* renamed from: W5  reason: default package */
/* compiled from: ComplexColorCompat */
public final class W5 {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final ColorStateList f631a;

    /* renamed from: a  reason: collision with other field name */
    public final Shader f632a;

    public W5(Shader shader, ColorStateList colorStateList, int i) {
        this.f632a = shader;
        this.f631a = colorStateList;
        this.a = i;
    }

    /* JADX WARNING: type inference failed for: r4v7, types: [android.graphics.Shader] */
    /* JADX WARNING: type inference failed for: r16v2, types: [android.graphics.RadialGradient] */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r11v10, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0182, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r2.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.W5 a(android.content.res.Resources r28, int r29, android.content.res.Resources.Theme r30) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            r0 = r28
            r1 = r30
            android.content.res.XmlResourceParser r2 = r28.getXml(r29)
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r2)
        L_0x000c:
            int r4 = r2.next()
            r5 = 2
            r6 = 1
            if (r4 == r5) goto L_0x0017
            if (r4 == r6) goto L_0x0017
            goto L_0x000c
        L_0x0017:
            if (r4 != r5) goto L_0x023c
            java.lang.String r4 = r2.getName()
            r4.getClass()
            java.lang.String r7 = "gradient"
            boolean r8 = r4.equals(r7)
            r9 = 0
            if (r8 != 0) goto L_0x005d
            java.lang.String r5 = "selector"
            boolean r5 = r4.equals(r5)
            if (r5 == 0) goto L_0x003f
            android.content.res.ColorStateList r0 = defpackage.C0416z5.b(r0, r2, r3, r1)
            W5 r1 = new W5
            int r2 = r0.getDefaultColor()
            r1.<init>(r9, r0, r2)
            return r1
        L_0x003f:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r2.getPositionDescription()
            r1.append(r2)
            java.lang.String r2 = ": unsupported complex color tag "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x005d:
            java.lang.String r4 = r2.getName()
            boolean r7 = r4.equals(r7)
            if (r7 == 0) goto L_0x021e
            int[] r4 = defpackage.js.GradientColor
            android.content.res.TypedArray r4 = defpackage.SA.f(r0, r1, r3, r4)
            java.lang.String r7 = "startX"
            int r8 = defpackage.js.GradientColor_android_startX
            r10 = 0
            float r12 = defpackage.SA.b(r4, r2, r7, r8, r10)
            java.lang.String r7 = "startY"
            int r8 = defpackage.js.GradientColor_android_startY
            float r13 = defpackage.SA.b(r4, r2, r7, r8, r10)
            java.lang.String r7 = "endX"
            int r8 = defpackage.js.GradientColor_android_endX
            float r14 = defpackage.SA.b(r4, r2, r7, r8, r10)
            java.lang.String r7 = "endY"
            int r8 = defpackage.js.GradientColor_android_endY
            float r15 = defpackage.SA.b(r4, r2, r7, r8, r10)
            java.lang.String r7 = "centerX"
            int r8 = defpackage.js.GradientColor_android_centerX
            float r7 = defpackage.SA.b(r4, r2, r7, r8, r10)
            java.lang.String r8 = "centerY"
            int r11 = defpackage.js.GradientColor_android_centerY
            float r8 = defpackage.SA.b(r4, r2, r8, r11, r10)
            java.lang.String r11 = "type"
            int r9 = defpackage.js.GradientColor_android_type
            r5 = 0
            int r9 = defpackage.SA.c(r4, r2, r11, r9, r5)
            int r11 = defpackage.js.GradientColor_android_startColor
            java.lang.String r6 = "startColor"
            boolean r6 = defpackage.SA.e(r2, r6)
            if (r6 != 0) goto L_0x00b3
            r6 = r5
            goto L_0x00b7
        L_0x00b3:
            int r6 = r4.getColor(r11, r5)
        L_0x00b7:
            java.lang.String r11 = "centerColor"
            boolean r18 = defpackage.SA.e(r2, r11)
            int r10 = defpackage.js.GradientColor_android_centerColor
            boolean r11 = defpackage.SA.e(r2, r11)
            if (r11 != 0) goto L_0x00c7
            r10 = r5
            goto L_0x00cb
        L_0x00c7:
            int r10 = r4.getColor(r10, r5)
        L_0x00cb:
            int r11 = defpackage.js.GradientColor_android_endColor
            java.lang.String r5 = "endColor"
            boolean r5 = defpackage.SA.e(r2, r5)
            if (r5 != 0) goto L_0x00d8
            r5 = 0
            r11 = 0
            goto L_0x00df
        L_0x00d8:
            r5 = 0
            int r23 = r4.getColor(r11, r5)
            r11 = r23
        L_0x00df:
            java.lang.String r0 = "tileMode"
            r20 = r7
            int r7 = defpackage.js.GradientColor_android_tileMode
            int r0 = defpackage.SA.c(r4, r2, r0, r7, r5)
            java.lang.String r5 = "gradientRadius"
            int r7 = defpackage.js.GradientColor_android_gradientRadius
            r21 = r8
            r8 = 0
            float r5 = defpackage.SA.b(r4, r2, r5, r7, r8)
            r4.recycle()
            int r4 = r2.getDepth()
            r7 = 1
            int r4 = r4 + r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r7 = 20
            r8.<init>(r7)
            r22 = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r7)
            r7 = r28
            r24 = r15
        L_0x010f:
            int r15 = r2.next()
            r25 = r14
            r14 = 1
            if (r15 == r14) goto L_0x018a
            int r14 = r2.getDepth()
            r26 = r13
            if (r14 >= r4) goto L_0x0123
            r13 = 3
            if (r15 == r13) goto L_0x018c
        L_0x0123:
            r13 = 2
            if (r15 == r13) goto L_0x0127
            goto L_0x0185
        L_0x0127:
            if (r14 > r4) goto L_0x0183
            java.lang.String r13 = r2.getName()
            java.lang.String r14 = "item"
            boolean r13 = r13.equals(r14)
            if (r13 != 0) goto L_0x0136
            goto L_0x0185
        L_0x0136:
            int[] r13 = defpackage.js.GradientColorItem
            android.content.res.TypedArray r7 = defpackage.SA.f(r7, r1, r3, r13)
            int r13 = defpackage.js.GradientColorItem_android_color
            boolean r14 = r7.hasValue(r13)
            int r15 = defpackage.js.GradientColorItem_android_offset
            boolean r27 = r7.hasValue(r15)
            if (r14 == 0) goto L_0x0168
            if (r27 == 0) goto L_0x0168
            r14 = 0
            int r13 = r7.getColor(r13, r14)
            r14 = 0
            float r15 = r7.getFloat(r15, r14)
            r7.recycle()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r13)
            r5.add(r7)
            java.lang.Float r7 = java.lang.Float.valueOf(r15)
            r8.add(r7)
            goto L_0x0183
        L_0x0168:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r2.getPositionDescription()
            r1.append(r2)
            java.lang.String r2 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0183:
            r7 = r28
        L_0x0185:
            r14 = r25
            r13 = r26
            goto L_0x010f
        L_0x018a:
            r26 = r13
        L_0x018c:
            int r1 = r5.size()
            if (r1 <= 0) goto L_0x0198
            ve r1 = new ve
            r1.<init>((java.util.ArrayList) r5, (java.util.ArrayList) r8)
            goto L_0x0199
        L_0x0198:
            r1 = 0
        L_0x0199:
            if (r1 == 0) goto L_0x019c
            goto L_0x01a9
        L_0x019c:
            if (r18 == 0) goto L_0x01a4
            ve r1 = new ve
            r1.<init>(r6, r10, r11)
            goto L_0x01a9
        L_0x01a4:
            ve r1 = new ve
            r1.<init>((int) r6, (int) r11)
        L_0x01a9:
            r2 = 1
            if (r9 == r2) goto L_0x01e0
            r3 = 2
            if (r9 == r3) goto L_0x01d2
            android.graphics.LinearGradient r4 = new android.graphics.LinearGradient
            int[] r5 = r1.f3372a
            float[] r1 = r1.a
            if (r0 == r2) goto L_0x01bf
            if (r0 == r3) goto L_0x01bc
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.CLAMP
            goto L_0x01c1
        L_0x01bc:
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.MIRROR
            goto L_0x01c1
        L_0x01bf:
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.REPEAT
        L_0x01c1:
            r18 = r0
            r11 = r4
            r13 = r26
            r14 = r25
            r15 = r24
            r16 = r5
            r17 = r1
            r11.<init>(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x020e
        L_0x01d2:
            android.graphics.SweepGradient r4 = new android.graphics.SweepGradient
            int[] r0 = r1.f3372a
            float[] r1 = r1.a
            r2 = r20
            r3 = r21
            r4.<init>(r2, r3, r0, r1)
            goto L_0x020e
        L_0x01e0:
            r2 = r20
            r3 = r21
            r4 = 0
            int r4 = (r22 > r4 ? 1 : (r22 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0216
            android.graphics.RadialGradient r4 = new android.graphics.RadialGradient
            int[] r5 = r1.f3372a
            float[] r1 = r1.a
            r6 = 1
            if (r0 == r6) goto L_0x01fb
            r6 = 2
            if (r0 == r6) goto L_0x01f8
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.CLAMP
            goto L_0x01fd
        L_0x01f8:
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.MIRROR
            goto L_0x01fd
        L_0x01fb:
            android.graphics.Shader$TileMode r0 = android.graphics.Shader.TileMode.REPEAT
        L_0x01fd:
            r16 = r4
            r17 = r2
            r18 = r3
            r19 = r22
            r20 = r5
            r21 = r1
            r22 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22)
        L_0x020e:
            W5 r0 = new W5
            r1 = 0
            r2 = 0
            r0.<init>(r4, r1, r2)
            return r0
        L_0x0216:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r1 = "<gradient> tag requires 'gradientRadius' attribute with radial type"
            r0.<init>(r1)
            throw r0
        L_0x021e:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r2.getPositionDescription()
            r1.append(r2)
            java.lang.String r2 = ": invalid gradient color tag "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x023c:
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r1 = "No start tag found"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.W5.a(android.content.res.Resources, int, android.content.res.Resources$Theme):W5");
    }

    public final boolean b() {
        ColorStateList colorStateList;
        if (this.f632a != null || (colorStateList = this.f631a) == null || !colorStateList.isStateful()) {
            return false;
        }
        return true;
    }
}
