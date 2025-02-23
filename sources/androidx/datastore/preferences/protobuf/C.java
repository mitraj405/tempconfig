package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.p;
import androidx.datastore.preferences.protobuf.w;
import defpackage.s5;
import defpackage.x3;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* compiled from: MessageSchema */
public final class C<T> implements kv<T> {
    public static final Unsafe a = C0285oB.o();
    public static final int[] c = new int[0];

    /* renamed from: a  reason: collision with other field name */
    public final int f1893a;

    /* renamed from: a  reason: collision with other field name */
    public final Jm f1894a;

    /* renamed from: a  reason: collision with other field name */
    public final A f1895a;

    /* renamed from: a  reason: collision with other field name */
    public final K<?, ?> f1896a;

    /* renamed from: a  reason: collision with other field name */
    public final C0133j<?> f1897a;

    /* renamed from: a  reason: collision with other field name */
    public final u f1898a;

    /* renamed from: a  reason: collision with other field name */
    public final y f1899a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f1900a;

    /* renamed from: a  reason: collision with other field name */
    public final int[] f1901a;

    /* renamed from: a  reason: collision with other field name */
    public final Object[] f1902a;
    public final int b;

    /* renamed from: b  reason: collision with other field name */
    public final boolean f1903b;

    /* renamed from: b  reason: collision with other field name */
    public final int[] f1904b;

    /* renamed from: c  reason: collision with other field name */
    public final int f1905c;

    /* renamed from: c  reason: collision with other field name */
    public final boolean f1906c;
    public final int d;

    /* renamed from: d  reason: collision with other field name */
    public final boolean f1907d;

    public C(int[] iArr, Object[] objArr, int i, int i2, A a2, boolean z, int[] iArr2, int i3, int i4, Jm jm, u uVar, K k, C0133j jVar, y yVar) {
        this.f1901a = iArr;
        this.f1902a = objArr;
        this.f1893a = i;
        this.b = i2;
        this.f1903b = a2 instanceof n;
        this.f1906c = z;
        this.f1900a = jVar != null && jVar.e(a2);
        this.f1907d = false;
        this.f1904b = iArr2;
        this.f1905c = i3;
        this.d = i4;
        this.f1894a = jm;
        this.f1898a = uVar;
        this.f1896a = k;
        this.f1897a = jVar;
        this.f1895a = a2;
        this.f1899a = yVar;
    }

    public static void F(int i, Object obj, C0130g gVar) throws IOException {
        if (obj instanceof String) {
            gVar.a.Q(i, (String) obj);
            return;
        }
        gVar.b(i, (x3) obj);
    }

    public static List<?> l(Object obj, long j) {
        return (List) C0285oB.n(obj, j);
    }

    public static C p(hl hlVar, Jm jm, u uVar, K k, C0133j jVar, y yVar) {
        if (hlVar instanceof vs) {
            return q((vs) hlVar, jm, uVar, k, jVar, yVar);
        }
        C0373vy vyVar = (C0373vy) hlVar;
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:163:0x036b  */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x03b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> androidx.datastore.preferences.protobuf.C<T> q(defpackage.vs r36, defpackage.Jm r37, androidx.datastore.preferences.protobuf.u r38, androidx.datastore.preferences.protobuf.K<?, ?> r39, androidx.datastore.preferences.protobuf.C0133j<?> r40, androidx.datastore.preferences.protobuf.y r41) {
        /*
            int r0 = r36.b()
            r2 = 2
            r3 = 0
            if (r0 != r2) goto L_0x000a
            r10 = 1
            goto L_0x000b
        L_0x000a:
            r10 = r3
        L_0x000b:
            java.lang.String r0 = r36.d()
            int r4 = r0.length()
            char r5 = r0.charAt(r3)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0034
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r8 = 1
            r9 = 13
        L_0x0021:
            int r11 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x0031
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r9
            r5 = r5 | r8
            int r9 = r9 + 13
            r8 = r11
            goto L_0x0021
        L_0x0031:
            int r8 = r8 << r9
            r5 = r5 | r8
            goto L_0x0035
        L_0x0034:
            r11 = 1
        L_0x0035:
            int r8 = r11 + 1
            char r9 = r0.charAt(r11)
            if (r9 < r6) goto L_0x0054
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x0041:
            int r12 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x0051
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r11
            r9 = r9 | r8
            int r11 = r11 + 13
            r8 = r12
            goto L_0x0041
        L_0x0051:
            int r8 = r8 << r11
            r9 = r9 | r8
            r8 = r12
        L_0x0054:
            if (r9 != 0) goto L_0x0061
            int[] r9 = c
            r7 = r3
            r12 = r7
            r13 = r12
            r14 = r13
            r15 = r14
            r11 = r9
            r9 = r15
            goto L_0x0180
        L_0x0061:
            int r9 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r6) goto L_0x0080
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r11 = 13
        L_0x006d:
            int r12 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x007d
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r11
            r8 = r8 | r9
            int r11 = r11 + 13
            r9 = r12
            goto L_0x006d
        L_0x007d:
            int r9 = r9 << r11
            r8 = r8 | r9
            r9 = r12
        L_0x0080:
            int r11 = r9 + 1
            char r9 = r0.charAt(r9)
            if (r9 < r6) goto L_0x009f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x008c:
            int r13 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x009c
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r12
            r9 = r9 | r11
            int r12 = r12 + 13
            r11 = r13
            goto L_0x008c
        L_0x009c:
            int r11 = r11 << r12
            r9 = r9 | r11
            r11 = r13
        L_0x009f:
            int r12 = r11 + 1
            char r11 = r0.charAt(r11)
            if (r11 < r6) goto L_0x00be
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00ab:
            int r14 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00bb
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r13
            r11 = r11 | r12
            int r13 = r13 + 13
            r12 = r14
            goto L_0x00ab
        L_0x00bb:
            int r12 = r12 << r13
            r11 = r11 | r12
            r12 = r14
        L_0x00be:
            int r13 = r12 + 1
            char r12 = r0.charAt(r12)
            if (r12 < r6) goto L_0x00dd
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00ca:
            int r15 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x00da
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r13 = r13 << r14
            r12 = r12 | r13
            int r14 = r14 + 13
            r13 = r15
            goto L_0x00ca
        L_0x00da:
            int r13 = r13 << r14
            r12 = r12 | r13
            r13 = r15
        L_0x00dd:
            int r14 = r13 + 1
            char r13 = r0.charAt(r13)
            if (r13 < r6) goto L_0x00fe
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x00e9:
            int r16 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x00fa
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            int r14 = r14 << r15
            r13 = r13 | r14
            int r15 = r15 + 13
            r14 = r16
            goto L_0x00e9
        L_0x00fa:
            int r14 = r14 << r15
            r13 = r13 | r14
            r14 = r16
        L_0x00fe:
            int r15 = r14 + 1
            char r14 = r0.charAt(r14)
            if (r14 < r6) goto L_0x0121
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x010a:
            int r17 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x011c
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r14 = r14 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x010a
        L_0x011c:
            int r15 = r15 << r16
            r14 = r14 | r15
            r15 = r17
        L_0x0121:
            int r16 = r15 + 1
            char r15 = r0.charAt(r15)
            if (r15 < r6) goto L_0x0147
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r3 = r16
            r16 = 13
        L_0x012f:
            int r18 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r6) goto L_0x0141
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r16
            r15 = r15 | r3
            int r16 = r16 + 13
            r3 = r18
            goto L_0x012f
        L_0x0141:
            int r3 = r3 << r16
            r15 = r15 | r3
            r3 = r18
            goto L_0x0149
        L_0x0147:
            r3 = r16
        L_0x0149:
            int r16 = r3 + 1
            char r3 = r0.charAt(r3)
            if (r3 < r6) goto L_0x016e
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r7 = r16
            r16 = 13
        L_0x0157:
            int r19 = r7 + 1
            char r7 = r0.charAt(r7)
            if (r7 < r6) goto L_0x0169
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r16
            r3 = r3 | r7
            int r16 = r16 + 13
            r7 = r19
            goto L_0x0157
        L_0x0169:
            int r7 = r7 << r16
            r3 = r3 | r7
            r16 = r19
        L_0x016e:
            int r7 = r3 + r14
            int r7 = r7 + r15
            int[] r7 = new int[r7]
            int r15 = r8 * 2
            int r15 = r15 + r9
            r9 = r13
            r13 = r3
            r3 = r8
            r8 = r16
            r35 = r11
            r11 = r7
            r7 = r35
        L_0x0180:
            java.lang.Object[] r16 = r36.c()
            androidx.datastore.preferences.protobuf.A r19 = r36.a()
            java.lang.Class r1 = r19.getClass()
            int r6 = r9 * 3
            int[] r6 = new int[r6]
            int r9 = r9 * r2
            java.lang.Object[] r9 = new java.lang.Object[r9]
            int r14 = r14 + r13
            r23 = r13
            r24 = r14
            r21 = 0
            r22 = 0
        L_0x019c:
            if (r8 >= r4) goto L_0x0405
            int r25 = r8 + 1
            char r8 = r0.charAt(r8)
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r8 < r2) goto L_0x01ce
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r2 = r25
            r25 = 13
        L_0x01af:
            int r27 = r2 + 1
            char r2 = r0.charAt(r2)
            r28 = r4
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r4) goto L_0x01c8
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r25
            r8 = r8 | r2
            int r25 = r25 + 13
            r2 = r27
            r4 = r28
            goto L_0x01af
        L_0x01c8:
            int r2 = r2 << r25
            r8 = r8 | r2
            r2 = r27
            goto L_0x01d2
        L_0x01ce:
            r28 = r4
            r2 = r25
        L_0x01d2:
            int r4 = r2 + 1
            char r2 = r0.charAt(r2)
            r25 = r4
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r4) goto L_0x0204
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r4 = r25
            r25 = 13
        L_0x01e5:
            int r27 = r4 + 1
            char r4 = r0.charAt(r4)
            r29 = r14
            r14 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r14) goto L_0x01fe
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r25
            r2 = r2 | r4
            int r25 = r25 + 13
            r4 = r27
            r14 = r29
            goto L_0x01e5
        L_0x01fe:
            int r4 = r4 << r25
            r2 = r2 | r4
            r4 = r27
            goto L_0x0208
        L_0x0204:
            r29 = r14
            r4 = r25
        L_0x0208:
            r14 = r2 & 255(0xff, float:3.57E-43)
            r25 = r13
            r13 = r2 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0216
            int r13 = r22 + 1
            r11[r22] = r21
            r22 = r13
        L_0x0216:
            r13 = 51
            r31 = r10
            sun.misc.Unsafe r10 = a
            if (r14 < r13) goto L_0x02ca
            int r13 = r4 + 1
            char r4 = r0.charAt(r4)
            r32 = r13
            r13 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r13) goto L_0x0250
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r13 = r32
            r32 = 13
        L_0x0231:
            int r33 = r13 + 1
            char r13 = r0.charAt(r13)
            r34 = r12
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r13 < r12) goto L_0x024a
            r12 = r13 & 8191(0x1fff, float:1.1478E-41)
            int r12 = r12 << r32
            r4 = r4 | r12
            int r32 = r32 + 13
            r13 = r33
            r12 = r34
            goto L_0x0231
        L_0x024a:
            int r12 = r13 << r32
            r4 = r4 | r12
            r13 = r33
            goto L_0x0254
        L_0x0250:
            r34 = r12
            r13 = r32
        L_0x0254:
            int r12 = r14 + -51
            r32 = r13
            r13 = 9
            if (r12 == r13) goto L_0x027a
            r13 = 17
            if (r12 != r13) goto L_0x0261
            goto L_0x027a
        L_0x0261:
            r13 = 12
            if (r12 != r13) goto L_0x0278
            r12 = r5 & 1
            r13 = 1
            if (r12 != r13) goto L_0x0278
            int r12 = r21 / 3
            r20 = 2
            int r12 = r12 * 2
            int r12 = r12 + r13
            int r13 = r15 + 1
            r15 = r16[r15]
            r9[r12] = r15
            r15 = r13
        L_0x0278:
            r13 = 2
            goto L_0x028a
        L_0x027a:
            int r12 = r21 / 3
            r13 = 2
            int r12 = r12 * r13
            r20 = 1
            int r12 = r12 + 1
            int r26 = r15 + 1
            r15 = r16[r15]
            r9[r12] = r15
            r15 = r26
        L_0x028a:
            int r4 = r4 * r13
            r12 = r16[r4]
            boolean r13 = r12 instanceof java.lang.reflect.Field
            if (r13 == 0) goto L_0x0294
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x029c
        L_0x0294:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = z(r1, r12)
            r16[r4] = r12
        L_0x029c:
            long r12 = r10.objectFieldOffset(r12)
            int r12 = (int) r12
            int r4 = r4 + 1
            r13 = r16[r4]
            r27 = r12
            boolean r12 = r13 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x02ae
            java.lang.reflect.Field r13 = (java.lang.reflect.Field) r13
            goto L_0x02b6
        L_0x02ae:
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = z(r1, r13)
            r16[r4] = r13
        L_0x02b6:
            long r12 = r10.objectFieldOffset(r13)
            int r4 = (int) r12
            r13 = r0
            r26 = r1
            r0 = r4
            r1 = r15
            r12 = r27
            r4 = 0
            r27 = r7
            r15 = r8
            r8 = r32
            goto L_0x03ce
        L_0x02ca:
            r34 = r12
            int r12 = r15 + 1
            r13 = r16[r15]
            java.lang.String r13 = (java.lang.String) r13
            java.lang.reflect.Field r13 = z(r1, r13)
            r15 = 9
            if (r14 == r15) goto L_0x034c
            r15 = 17
            if (r14 != r15) goto L_0x02e0
            goto L_0x034c
        L_0x02e0:
            r15 = 27
            if (r14 == r15) goto L_0x0338
            r15 = 49
            if (r14 != r15) goto L_0x02e9
            goto L_0x0338
        L_0x02e9:
            r15 = 12
            if (r14 == r15) goto L_0x0323
            r15 = 30
            if (r14 == r15) goto L_0x0323
            r15 = 44
            if (r14 != r15) goto L_0x02f6
            goto L_0x0323
        L_0x02f6:
            r15 = 50
            if (r14 != r15) goto L_0x031f
            int r15 = r23 + 1
            r11[r23] = r21
            int r23 = r21 / 3
            r26 = 2
            int r23 = r23 * 2
            int r27 = r12 + 1
            r12 = r16[r12]
            r9[r23] = r12
            r12 = r2 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x031b
            int r23 = r23 + 1
            int r12 = r27 + 1
            r27 = r16[r27]
            r9[r23] = r27
            r27 = r7
            r23 = r15
            goto L_0x0321
        L_0x031b:
            r23 = r15
            r12 = r27
        L_0x031f:
            r27 = r7
        L_0x0321:
            r7 = 1
            goto L_0x035c
        L_0x0323:
            r15 = r5 & 1
            r27 = r7
            r7 = 1
            if (r15 != r7) goto L_0x035c
            int r15 = r21 / 3
            r20 = 2
            int r15 = r15 * 2
            int r15 = r15 + r7
            int r26 = r12 + 1
            r12 = r16[r12]
            r9[r15] = r12
            goto L_0x0348
        L_0x0338:
            r27 = r7
            r7 = 1
            r20 = 2
            int r15 = r21 / 3
            int r15 = r15 * 2
            int r15 = r15 + r7
            int r26 = r12 + 1
            r12 = r16[r12]
            r9[r15] = r12
        L_0x0348:
            r15 = r8
            r12 = r26
            goto L_0x035d
        L_0x034c:
            r27 = r7
            r7 = 1
            r20 = 2
            int r15 = r21 / 3
            int r15 = r15 * 2
            int r15 = r15 + r7
            java.lang.Class r20 = r13.getType()
            r9[r15] = r20
        L_0x035c:
            r15 = r8
        L_0x035d:
            long r7 = r10.objectFieldOffset(r13)
            int r7 = (int) r7
            r8 = r5 & 1
            r13 = 1
            if (r8 != r13) goto L_0x03b5
            r8 = 17
            if (r14 > r8) goto L_0x03b5
            int r8 = r4 + 1
            char r4 = r0.charAt(r4)
            r13 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r13) goto L_0x0390
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r19 = 13
        L_0x037a:
            int r30 = r8 + 1
            char r8 = r0.charAt(r8)
            if (r8 < r13) goto L_0x038c
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r19
            r4 = r4 | r8
            int r19 = r19 + 13
            r8 = r30
            goto L_0x037a
        L_0x038c:
            int r8 = r8 << r19
            r4 = r4 | r8
            goto L_0x0392
        L_0x0390:
            r30 = r8
        L_0x0392:
            r8 = 2
            int r19 = r3 * 2
            int r26 = r4 / 32
            int r26 = r26 + r19
            r8 = r16[r26]
            boolean r13 = r8 instanceof java.lang.reflect.Field
            if (r13 == 0) goto L_0x03a2
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x03aa
        L_0x03a2:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = z(r1, r8)
            r16[r26] = r8
        L_0x03aa:
            r13 = r0
            r26 = r1
            long r0 = r10.objectFieldOffset(r8)
            int r0 = (int) r0
            int r4 = r4 % 32
            goto L_0x03bc
        L_0x03b5:
            r13 = r0
            r26 = r1
            r30 = r4
            r0 = 0
            r4 = 0
        L_0x03bc:
            r1 = 18
            if (r14 < r1) goto L_0x03ca
            r1 = 49
            if (r14 > r1) goto L_0x03ca
            int r1 = r24 + 1
            r11[r24] = r7
            r24 = r1
        L_0x03ca:
            r1 = r12
            r8 = r30
            r12 = r7
        L_0x03ce:
            int r7 = r21 + 1
            r6[r21] = r15
            int r10 = r7 + 1
            r15 = r2 & 512(0x200, float:7.175E-43)
            if (r15 == 0) goto L_0x03db
            r15 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03dc
        L_0x03db:
            r15 = 0
        L_0x03dc:
            r2 = r2 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x03e3
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03e4
        L_0x03e3:
            r2 = 0
        L_0x03e4:
            r2 = r2 | r15
            int r14 = r14 << 20
            r2 = r2 | r14
            r2 = r2 | r12
            r6[r7] = r2
            int r21 = r10 + 1
            int r2 = r4 << 20
            r0 = r0 | r2
            r6[r10] = r0
            r15 = r1
            r0 = r13
            r13 = r25
            r1 = r26
            r7 = r27
            r4 = r28
            r14 = r29
            r10 = r31
            r12 = r34
            r2 = 2
            goto L_0x019c
        L_0x0405:
            r27 = r7
            r31 = r10
            r34 = r12
            r25 = r13
            r29 = r14
            androidx.datastore.preferences.protobuf.C r0 = new androidx.datastore.preferences.protobuf.C
            androidx.datastore.preferences.protobuf.A r1 = r36.a()
            r4 = r0
            r5 = r6
            r6 = r9
            r8 = r34
            r9 = r1
            r12 = r25
            r13 = r29
            r14 = r37
            r15 = r38
            r16 = r39
            r17 = r40
            r18 = r41
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C.q(vs, Jm, androidx.datastore.preferences.protobuf.u, androidx.datastore.preferences.protobuf.K, androidx.datastore.preferences.protobuf.j, androidx.datastore.preferences.protobuf.y):androidx.datastore.preferences.protobuf.C");
    }

    public static long r(int i) {
        return (long) (i & 1048575);
    }

    public static <T> int s(T t, long j) {
        return ((Integer) C0285oB.n(t, j)).intValue();
    }

    public static <T> long t(T t, long j) {
        return ((Long) C0285oB.n(t, j)).longValue();
    }

    public static Field z(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder K = xx.K("Field ", str, " for ");
            K.append(cls.getName());
            K.append(" not found. Known fields are ");
            K.append(Arrays.toString(declaredFields));
            throw new RuntimeException(K.toString());
        }
    }

    public final void A(T t, int i) {
        if (!this.f1906c) {
            int i2 = this.f1901a[i + 2];
            long j = (long) (i2 & 1048575);
            C0285oB.s(t, j, C0285oB.l(t, j) | (1 << (i2 >>> 20)));
        }
    }

    public final void B(T t, int i, int i2) {
        C0285oB.s(t, (long) (this.f1901a[i2 + 2] & 1048575), i);
    }

    public final int C(int i) {
        return this.f1901a[i + 1];
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x02c3  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02d1  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0318  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0326  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0334  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0342  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0350  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x036c  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x03a5  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x03bf  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x03cc  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x03d9  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x03e8  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x03f9  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0405  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0412  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x041e  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x042a  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0436  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0442  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x045b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01d5  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x021b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0245  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0261  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x027d  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0299  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(java.lang.Object r21, androidx.datastore.preferences.protobuf.C0130g r22) throws java.io.IOException {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            boolean r4 = r0.f1900a
            androidx.datastore.preferences.protobuf.j<?> r5 = r0.f1897a
            if (r4 == 0) goto L_0x0021
            androidx.datastore.preferences.protobuf.l r4 = r5.c(r1)
            boolean r6 = r4.h()
            if (r6 != 0) goto L_0x0021
            java.util.Iterator r4 = r4.k()
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            goto L_0x0023
        L_0x0021:
            r4 = 0
            r6 = 0
        L_0x0023:
            int[] r7 = r0.f1901a
            int r8 = r7.length
            r10 = -1
            r11 = 0
            r12 = 0
        L_0x0029:
            if (r11 >= r8) goto L_0x046f
            int r13 = r0.C(r11)
            r14 = r7[r11]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r13
            int r15 = r15 >>> 20
            boolean r9 = r0.f1906c
            r16 = 1048575(0xfffff, float:1.469367E-39)
            sun.misc.Unsafe r3 = a
            if (r9 != 0) goto L_0x0060
            r9 = 17
            if (r15 > r9) goto L_0x0060
            int r9 = r11 + 2
            r9 = r7[r9]
            r17 = r6
            r6 = r9 & r16
            r18 = r7
            r19 = r8
            if (r6 == r10) goto L_0x0057
            long r7 = (long) r6
            int r12 = r3.getInt(r1, r7)
            r10 = r6
        L_0x0057:
            int r6 = r9 >>> 20
            r7 = 1
            int r6 = r7 << r6
            r7 = r6
            r6 = r17
            goto L_0x0069
        L_0x0060:
            r17 = r6
            r18 = r7
            r19 = r8
            r6 = r17
            r7 = 0
        L_0x0069:
            if (r6 == 0) goto L_0x0082
            r5.a(r6)
            if (r14 < 0) goto L_0x0082
            r5.j(r6)
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0080
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            goto L_0x0069
        L_0x0080:
            r6 = 0
            goto L_0x0069
        L_0x0082:
            r8 = r13 & r16
            long r8 = (long) r8
            switch(r15) {
                case 0: goto L_0x045b;
                case 1: goto L_0x044e;
                case 2: goto L_0x0442;
                case 3: goto L_0x0436;
                case 4: goto L_0x042a;
                case 5: goto L_0x041e;
                case 6: goto L_0x0412;
                case 7: goto L_0x0405;
                case 8: goto L_0x03f9;
                case 9: goto L_0x03e8;
                case 10: goto L_0x03d9;
                case 11: goto L_0x03cc;
                case 12: goto L_0x03bf;
                case 13: goto L_0x03b2;
                case 14: goto L_0x03a5;
                case 15: goto L_0x0398;
                case 16: goto L_0x038b;
                case 17: goto L_0x037a;
                case 18: goto L_0x036c;
                case 19: goto L_0x035e;
                case 20: goto L_0x0350;
                case 21: goto L_0x0342;
                case 22: goto L_0x0334;
                case 23: goto L_0x0326;
                case 24: goto L_0x0318;
                case 25: goto L_0x030a;
                case 26: goto L_0x02fd;
                case 27: goto L_0x02ec;
                case 28: goto L_0x02df;
                case 29: goto L_0x02d1;
                case 30: goto L_0x02c3;
                case 31: goto L_0x02b5;
                case 32: goto L_0x02a7;
                case 33: goto L_0x0299;
                case 34: goto L_0x028b;
                case 35: goto L_0x027d;
                case 36: goto L_0x026f;
                case 37: goto L_0x0261;
                case 38: goto L_0x0253;
                case 39: goto L_0x0245;
                case 40: goto L_0x0237;
                case 41: goto L_0x0229;
                case 42: goto L_0x021b;
                case 43: goto L_0x020d;
                case 44: goto L_0x01ff;
                case 45: goto L_0x01f1;
                case 46: goto L_0x01e3;
                case 47: goto L_0x01d5;
                case 48: goto L_0x01c7;
                case 49: goto L_0x01b6;
                case 50: goto L_0x01ad;
                case 51: goto L_0x0198;
                case 52: goto L_0x0183;
                case 53: goto L_0x0174;
                case 54: goto L_0x0165;
                case 55: goto L_0x0156;
                case 56: goto L_0x0147;
                case 57: goto L_0x0138;
                case 58: goto L_0x0123;
                case 59: goto L_0x0114;
                case 60: goto L_0x0101;
                case 61: goto L_0x00f1;
                case 62: goto L_0x00e3;
                case 63: goto L_0x00d5;
                case 64: goto L_0x00c7;
                case 65: goto L_0x00b9;
                case 66: goto L_0x00ab;
                case 67: goto L_0x009d;
                case 68: goto L_0x008b;
                default: goto L_0x0088;
            }
        L_0x0088:
            r13 = 0
            goto L_0x0467
        L_0x008b:
            boolean r7 = r0.k(r1, r14, r11)
            if (r7 == 0) goto L_0x0088
            java.lang.Object r3 = r3.getObject(r1, r8)
            kv r7 = r0.g(r11)
            r2.h(r14, r7, r3)
            goto L_0x0088
        L_0x009d:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            long r7 = t(r1, r8)
            r2.p(r14, r7)
            goto L_0x0088
        L_0x00ab:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            int r3 = s(r1, r8)
            r2.o(r14, r3)
            goto L_0x0088
        L_0x00b9:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            long r7 = t(r1, r8)
            r2.n(r14, r7)
            goto L_0x0088
        L_0x00c7:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            int r3 = s(r1, r8)
            r2.m(r14, r3)
            goto L_0x0088
        L_0x00d5:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            int r3 = s(r1, r8)
            r2.d(r14, r3)
            goto L_0x0088
        L_0x00e3:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            int r3 = s(r1, r8)
            r2.q(r14, r3)
            goto L_0x0088
        L_0x00f1:
            boolean r7 = r0.k(r1, r14, r11)
            if (r7 == 0) goto L_0x0088
            java.lang.Object r3 = r3.getObject(r1, r8)
            x3 r3 = (defpackage.x3) r3
            r2.b(r14, r3)
            goto L_0x0088
        L_0x0101:
            boolean r7 = r0.k(r1, r14, r11)
            if (r7 == 0) goto L_0x0088
            java.lang.Object r3 = r3.getObject(r1, r8)
            kv r7 = r0.g(r11)
            r2.k(r14, r7, r3)
            goto L_0x0088
        L_0x0114:
            boolean r7 = r0.k(r1, r14, r11)
            if (r7 == 0) goto L_0x0088
            java.lang.Object r3 = r3.getObject(r1, r8)
            F(r14, r3, r2)
            goto L_0x0088
        L_0x0123:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            java.lang.Object r3 = defpackage.C0285oB.n(r1, r8)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r2.a(r14, r3)
            goto L_0x0088
        L_0x0138:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            int r3 = s(r1, r8)
            r2.e(r14, r3)
            goto L_0x0088
        L_0x0147:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            long r7 = t(r1, r8)
            r2.f(r14, r7)
            goto L_0x0088
        L_0x0156:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            int r3 = s(r1, r8)
            r2.i(r14, r3)
            goto L_0x0088
        L_0x0165:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            long r7 = t(r1, r8)
            r2.r(r14, r7)
            goto L_0x0088
        L_0x0174:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            long r7 = t(r1, r8)
            r2.j(r14, r7)
            goto L_0x0088
        L_0x0183:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            java.lang.Object r3 = defpackage.C0285oB.n(r1, r8)
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r2.g(r14, r3)
            goto L_0x0088
        L_0x0198:
            boolean r3 = r0.k(r1, r14, r11)
            if (r3 == 0) goto L_0x0088
            java.lang.Object r3 = defpackage.C0285oB.n(r1, r8)
            java.lang.Double r3 = (java.lang.Double) r3
            double r7 = r3.doubleValue()
            r2.c(r14, r7)
            goto L_0x0088
        L_0x01ad:
            java.lang.Object r3 = r3.getObject(r1, r8)
            r0.E(r2, r14, r3, r11)
            goto L_0x0088
        L_0x01b6:
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            kv r8 = r0.g(r11)
            androidx.datastore.preferences.protobuf.H.L(r7, r3, r2, r8)
            goto L_0x0088
        L_0x01c7:
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            r13 = 1
            androidx.datastore.preferences.protobuf.H.S(r7, r3, r2, r13)
            goto L_0x0088
        L_0x01d5:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.R(r7, r3, r2, r13)
            goto L_0x0088
        L_0x01e3:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.Q(r7, r3, r2, r13)
            goto L_0x0088
        L_0x01f1:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.P(r7, r3, r2, r13)
            goto L_0x0088
        L_0x01ff:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.H(r7, r3, r2, r13)
            goto L_0x0088
        L_0x020d:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.U(r7, r3, r2, r13)
            goto L_0x0088
        L_0x021b:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.E(r7, r3, r2, r13)
            goto L_0x0088
        L_0x0229:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.I(r7, r3, r2, r13)
            goto L_0x0088
        L_0x0237:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.J(r7, r3, r2, r13)
            goto L_0x0088
        L_0x0245:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.M(r7, r3, r2, r13)
            goto L_0x0088
        L_0x0253:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.V(r7, r3, r2, r13)
            goto L_0x0088
        L_0x0261:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.N(r7, r3, r2, r13)
            goto L_0x0088
        L_0x026f:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.K(r7, r3, r2, r13)
            goto L_0x0088
        L_0x027d:
            r13 = 1
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.G(r7, r3, r2, r13)
            goto L_0x0088
        L_0x028b:
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            r13 = 0
            androidx.datastore.preferences.protobuf.H.S(r7, r3, r2, r13)
            goto L_0x0467
        L_0x0299:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.R(r7, r3, r2, r13)
            goto L_0x0467
        L_0x02a7:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.Q(r7, r3, r2, r13)
            goto L_0x0467
        L_0x02b5:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.P(r7, r3, r2, r13)
            goto L_0x0467
        L_0x02c3:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.H(r7, r3, r2, r13)
            goto L_0x0467
        L_0x02d1:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.U(r7, r3, r2, r13)
            goto L_0x0467
        L_0x02df:
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.F(r7, r3, r2)
            goto L_0x0088
        L_0x02ec:
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            kv r8 = r0.g(r11)
            androidx.datastore.preferences.protobuf.H.O(r7, r3, r2, r8)
            goto L_0x0088
        L_0x02fd:
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.T(r7, r3, r2)
            goto L_0x0088
        L_0x030a:
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            r13 = 0
            androidx.datastore.preferences.protobuf.H.E(r7, r3, r2, r13)
            goto L_0x0467
        L_0x0318:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.I(r7, r3, r2, r13)
            goto L_0x0467
        L_0x0326:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.J(r7, r3, r2, r13)
            goto L_0x0467
        L_0x0334:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.M(r7, r3, r2, r13)
            goto L_0x0467
        L_0x0342:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.V(r7, r3, r2, r13)
            goto L_0x0467
        L_0x0350:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.N(r7, r3, r2, r13)
            goto L_0x0467
        L_0x035e:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.K(r7, r3, r2, r13)
            goto L_0x0467
        L_0x036c:
            r13 = 0
            r7 = r18[r11]
            java.lang.Object r3 = r3.getObject(r1, r8)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.G(r7, r3, r2, r13)
            goto L_0x0467
        L_0x037a:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            java.lang.Object r3 = r3.getObject(r1, r8)
            kv r7 = r0.g(r11)
            r2.h(r14, r7, r3)
            goto L_0x0467
        L_0x038b:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            long r7 = r3.getLong(r1, r8)
            r2.p(r14, r7)
            goto L_0x0467
        L_0x0398:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            int r3 = r3.getInt(r1, r8)
            r2.o(r14, r3)
            goto L_0x0467
        L_0x03a5:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            long r7 = r3.getLong(r1, r8)
            r2.n(r14, r7)
            goto L_0x0467
        L_0x03b2:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            int r3 = r3.getInt(r1, r8)
            r2.m(r14, r3)
            goto L_0x0467
        L_0x03bf:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            int r3 = r3.getInt(r1, r8)
            r2.d(r14, r3)
            goto L_0x0467
        L_0x03cc:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            int r3 = r3.getInt(r1, r8)
            r2.q(r14, r3)
            goto L_0x0467
        L_0x03d9:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            java.lang.Object r3 = r3.getObject(r1, r8)
            x3 r3 = (defpackage.x3) r3
            r2.b(r14, r3)
            goto L_0x0467
        L_0x03e8:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            java.lang.Object r3 = r3.getObject(r1, r8)
            kv r7 = r0.g(r11)
            r2.k(r14, r7, r3)
            goto L_0x0467
        L_0x03f9:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            java.lang.Object r3 = r3.getObject(r1, r8)
            F(r14, r3, r2)
            goto L_0x0467
        L_0x0405:
            r13 = 0
            r3 = r7 & r12
            if (r3 == 0) goto L_0x0467
            boolean r3 = defpackage.C0285oB.f(r1, r8)
            r2.a(r14, r3)
            goto L_0x0467
        L_0x0412:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            int r3 = r3.getInt(r1, r8)
            r2.e(r14, r3)
            goto L_0x0467
        L_0x041e:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            long r7 = r3.getLong(r1, r8)
            r2.f(r14, r7)
            goto L_0x0467
        L_0x042a:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            int r3 = r3.getInt(r1, r8)
            r2.i(r14, r3)
            goto L_0x0467
        L_0x0436:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            long r7 = r3.getLong(r1, r8)
            r2.r(r14, r7)
            goto L_0x0467
        L_0x0442:
            r13 = 0
            r7 = r7 & r12
            if (r7 == 0) goto L_0x0467
            long r7 = r3.getLong(r1, r8)
            r2.j(r14, r7)
            goto L_0x0467
        L_0x044e:
            r13 = 0
            r3 = r7 & r12
            if (r3 == 0) goto L_0x0467
            float r3 = defpackage.C0285oB.k(r1, r8)
            r2.g(r14, r3)
            goto L_0x0467
        L_0x045b:
            r13 = 0
            r3 = r7 & r12
            if (r3 == 0) goto L_0x0467
            double r7 = defpackage.C0285oB.j(r1, r8)
            r2.c(r14, r7)
        L_0x0467:
            int r11 = r11 + 3
            r7 = r18
            r8 = r19
            goto L_0x0029
        L_0x046f:
            r17 = r6
        L_0x0471:
            if (r6 == 0) goto L_0x0486
            r5.j(r6)
            boolean r3 = r4.hasNext()
            if (r3 == 0) goto L_0x0484
            java.lang.Object r3 = r4.next()
            r6 = r3
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            goto L_0x0471
        L_0x0484:
            r6 = 0
            goto L_0x0471
        L_0x0486:
            androidx.datastore.preferences.protobuf.K<?, ?> r3 = r0.f1896a
            androidx.datastore.preferences.protobuf.L r1 = r3.g(r1)
            r3.s(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C.D(java.lang.Object, androidx.datastore.preferences.protobuf.g):void");
    }

    public final void E(C0130g gVar, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            Object f = f(i2);
            y yVar = this.f1899a;
            w.a<?, ?> e = yVar.e(f);
            x b2 = yVar.b(obj);
            s5 s5Var = gVar.a;
            s5Var.getClass();
            for (Map.Entry entry : b2.entrySet()) {
                s5Var.S(i, 2);
                s5Var.U(w.a(e, entry.getKey(), entry.getValue()));
                w.b(s5Var, e, entry.getKey(), entry.getValue());
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x05b8, code lost:
        r7 = r11.f(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x05c3, code lost:
        if (r14 < r13) goto L_0x05c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x05c5, code lost:
        r7 = d(r9, r12[r14], r7, r11);
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x05ce, code lost:
        if (r7 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0135, code lost:
        r15 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x023f, code lost:
        r15 = r17;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:159:0x05b3 */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x05b8 A[Catch:{ all -> 0x05d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x05df A[LOOP:5: B:174:0x05dd->B:175:0x05df, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x05ea  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x05c3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x05d4 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r20, androidx.datastore.preferences.protobuf.G r21, androidx.datastore.preferences.protobuf.C0132i r22) throws java.io.IOException {
        /*
            r19 = this;
            r8 = r19
            r9 = r20
            r0 = r21
            r10 = r22
            r22.getClass()
            androidx.datastore.preferences.protobuf.K<?, ?> r11 = r8.f1896a
            int[] r12 = r8.f1904b
            int r13 = r8.d
            int r14 = r8.f1905c
            r7 = 0
            r16 = 0
        L_0x0016:
            int r1 = r21.getFieldNumber()     // Catch:{ all -> 0x05da }
            int r5 = r8.u(r1)     // Catch:{ all -> 0x05da }
            if (r5 >= 0) goto L_0x0073
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0034
        L_0x0025:
            if (r14 >= r13) goto L_0x0030
            r0 = r12[r14]
            java.lang.Object r7 = r8.d(r9, r0, r7, r11)
            int r14 = r14 + 1
            goto L_0x0025
        L_0x0030:
            if (r7 == 0) goto L_0x05d3
            goto L_0x05d0
        L_0x0034:
            boolean r2 = r8.f1900a     // Catch:{ all -> 0x05da }
            androidx.datastore.preferences.protobuf.j<?> r3 = r8.f1897a
            if (r2 != 0) goto L_0x003c
            r1 = 0
            goto L_0x0042
        L_0x003c:
            androidx.datastore.preferences.protobuf.A r2 = r8.f1895a     // Catch:{ all -> 0x05da }
            androidx.datastore.preferences.protobuf.n$e r1 = r3.b(r10, r2, r1)     // Catch:{ all -> 0x05da }
        L_0x0042:
            if (r1 == 0) goto L_0x0052
            if (r16 != 0) goto L_0x004c
            androidx.datastore.preferences.protobuf.l r2 = r3.d(r9)     // Catch:{ all -> 0x05d8 }
            r16 = r2
        L_0x004c:
            java.lang.Object r7 = r3.g(r1)     // Catch:{ all -> 0x05da }
            goto L_0x05d4
        L_0x0052:
            r11.p()     // Catch:{ all -> 0x05da }
            if (r7 != 0) goto L_0x005c
            androidx.datastore.preferences.protobuf.L r1 = r11.f(r9)     // Catch:{ all -> 0x05da }
            r7 = r1
        L_0x005c:
            boolean r1 = r11.l(r7, r0)     // Catch:{ all -> 0x05d8 }
            if (r1 == 0) goto L_0x0064
            goto L_0x05d4
        L_0x0064:
            if (r14 >= r13) goto L_0x006f
            r0 = r12[r14]
            java.lang.Object r7 = r8.d(r9, r0, r7, r11)
            int r14 = r14 + 1
            goto L_0x0064
        L_0x006f:
            if (r7 == 0) goto L_0x05d3
            goto L_0x05d0
        L_0x0073:
            int r3 = r8.C(r5)     // Catch:{ all -> 0x05da }
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r2 = r2 & r3
            int r2 = r2 >>> 20
            r4 = 1048575(0xfffff, float:1.469367E-39)
            androidx.datastore.preferences.protobuf.u r6 = r8.f1898a
            switch(r2) {
                case 0: goto L_0x0584;
                case 1: goto L_0x0573;
                case 2: goto L_0x0564;
                case 3: goto L_0x0555;
                case 4: goto L_0x0546;
                case 5: goto L_0x0537;
                case 6: goto L_0x0528;
                case 7: goto L_0x0513;
                case 8: goto L_0x050a;
                case 9: goto L_0x04d2;
                case 10: goto L_0x04c2;
                case 11: goto L_0x04b2;
                case 12: goto L_0x048e;
                case 13: goto L_0x047e;
                case 14: goto L_0x046e;
                case 15: goto L_0x045e;
                case 16: goto L_0x044e;
                case 17: goto L_0x0416;
                case 18: goto L_0x0409;
                case 19: goto L_0x03fc;
                case 20: goto L_0x03ef;
                case 21: goto L_0x03e2;
                case 22: goto L_0x03d5;
                case 23: goto L_0x03c8;
                case 24: goto L_0x03bb;
                case 25: goto L_0x03ae;
                case 26: goto L_0x03a8;
                case 27: goto L_0x0396;
                case 28: goto L_0x0389;
                case 29: goto L_0x037c;
                case 30: goto L_0x0367;
                case 31: goto L_0x035a;
                case 32: goto L_0x034d;
                case 33: goto L_0x033f;
                case 34: goto L_0x0331;
                case 35: goto L_0x0323;
                case 36: goto L_0x0315;
                case 37: goto L_0x0307;
                case 38: goto L_0x02f9;
                case 39: goto L_0x02eb;
                case 40: goto L_0x02dd;
                case 41: goto L_0x02cf;
                case 42: goto L_0x02c1;
                case 43: goto L_0x02b3;
                case 44: goto L_0x029d;
                case 45: goto L_0x028f;
                case 46: goto L_0x0281;
                case 47: goto L_0x0273;
                case 48: goto L_0x0265;
                case 49: goto L_0x0243;
                case 50: goto L_0x022d;
                case 51: goto L_0x0218;
                case 52: goto L_0x0203;
                case 53: goto L_0x01ee;
                case 54: goto L_0x01d9;
                case 55: goto L_0x01c4;
                case 56: goto L_0x01ae;
                case 57: goto L_0x0198;
                case 58: goto L_0x0182;
                case 59: goto L_0x0178;
                case 60: goto L_0x0138;
                case 61: goto L_0x0127;
                case 62: goto L_0x0114;
                case 63: goto L_0x00ee;
                case 64: goto L_0x00db;
                case 65: goto L_0x00c8;
                case 66: goto L_0x00b5;
                case 67: goto L_0x00a1;
                case 68: goto L_0x008d;
                default: goto L_0x0084;
            }
        L_0x0084:
            r15 = r7
            if (r15 != 0) goto L_0x059e
            androidx.datastore.preferences.protobuf.L r1 = r11.m()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x059a
        L_0x008d:
            long r2 = r(r3)     // Catch:{ a -> 0x0175 }
            kv r4 = r8.g(r5)     // Catch:{ a -> 0x0175 }
            java.lang.Object r4 = r0.c(r4, r10)     // Catch:{ a -> 0x0175 }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0175 }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0175 }
            goto L_0x0135
        L_0x00a1:
            long r2 = r(r3)     // Catch:{ a -> 0x0175 }
            long r17 = r21.readSInt64()     // Catch:{ a -> 0x0175 }
            java.lang.Long r4 = java.lang.Long.valueOf(r17)     // Catch:{ a -> 0x0175 }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0175 }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0175 }
            goto L_0x0135
        L_0x00b5:
            long r2 = r(r3)     // Catch:{ a -> 0x0175 }
            int r4 = r21.readSInt32()     // Catch:{ a -> 0x0175 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ a -> 0x0175 }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0175 }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0175 }
            goto L_0x0135
        L_0x00c8:
            long r2 = r(r3)     // Catch:{ a -> 0x0175 }
            long r17 = r21.readSFixed64()     // Catch:{ a -> 0x0175 }
            java.lang.Long r4 = java.lang.Long.valueOf(r17)     // Catch:{ a -> 0x0175 }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0175 }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0175 }
            goto L_0x0135
        L_0x00db:
            long r2 = r(r3)     // Catch:{ a -> 0x0175 }
            int r4 = r21.readSFixed32()     // Catch:{ a -> 0x0175 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ a -> 0x0175 }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0175 }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0175 }
            goto L_0x0135
        L_0x00ee:
            int r2 = r21.readEnum()     // Catch:{ a -> 0x0175 }
            androidx.datastore.preferences.protobuf.p$b r4 = r8.e(r5)     // Catch:{ a -> 0x0175 }
            if (r4 == 0) goto L_0x0105
            boolean r4 = r4.a()     // Catch:{ a -> 0x0175 }
            if (r4 == 0) goto L_0x00ff
            goto L_0x0105
        L_0x00ff:
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.H.D(r1, r2, r7, r11)     // Catch:{ a -> 0x0175 }
            goto L_0x05d4
        L_0x0105:
            long r3 = r(r3)     // Catch:{ a -> 0x0175 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ a -> 0x0175 }
            defpackage.C0285oB.u(r9, r3, r2)     // Catch:{ a -> 0x0175 }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0175 }
            goto L_0x0135
        L_0x0114:
            long r2 = r(r3)     // Catch:{ a -> 0x0175 }
            int r4 = r21.readUInt32()     // Catch:{ a -> 0x0175 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ a -> 0x0175 }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0175 }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0175 }
            goto L_0x0135
        L_0x0127:
            long r2 = r(r3)     // Catch:{ a -> 0x0175 }
            x3 r4 = r21.b()     // Catch:{ a -> 0x0175 }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0175 }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0175 }
        L_0x0135:
            r15 = r7
            goto L_0x0598
        L_0x0138:
            boolean r2 = r8.k(r9, r1, r5)     // Catch:{ a -> 0x0175 }
            if (r2 == 0) goto L_0x015c
            r17 = r7
            long r6 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            java.lang.Object r2 = defpackage.C0285oB.n(r9, r6)     // Catch:{ a -> 0x0261, all -> 0x025c }
            kv r4 = r8.g(r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            java.lang.Object r4 = r0.e(r4, r10)     // Catch:{ a -> 0x0261, all -> 0x025c }
            androidx.datastore.preferences.protobuf.n r2 = androidx.datastore.preferences.protobuf.p.b(r2, r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            long r3 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            defpackage.C0285oB.u(r9, r3, r2)     // Catch:{ a -> 0x0261, all -> 0x025c }
            goto L_0x0170
        L_0x015c:
            r17 = r7
            long r2 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            kv r4 = r8.g(r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            java.lang.Object r4 = r0.e(r4, r10)     // Catch:{ a -> 0x0261, all -> 0x025c }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r8.A(r9, r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
        L_0x0170:
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            goto L_0x023f
        L_0x0175:
            r15 = r7
            goto L_0x059c
        L_0x0178:
            r17 = r7
            r8.x(r9, r3, r0)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            goto L_0x023f
        L_0x0182:
            r17 = r7
            long r2 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            boolean r4 = r21.readBool()     // Catch:{ a -> 0x0261, all -> 0x025c }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            goto L_0x023f
        L_0x0198:
            r17 = r7
            long r2 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            int r4 = r21.readFixed32()     // Catch:{ a -> 0x0261, all -> 0x025c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            goto L_0x023f
        L_0x01ae:
            r17 = r7
            long r2 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            long r6 = r21.readFixed64()     // Catch:{ a -> 0x0261, all -> 0x025c }
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0261, all -> 0x025c }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            goto L_0x023f
        L_0x01c4:
            r17 = r7
            long r2 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            int r4 = r21.readInt32()     // Catch:{ a -> 0x0261, all -> 0x025c }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            goto L_0x023f
        L_0x01d9:
            r17 = r7
            long r2 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            long r6 = r21.readUInt64()     // Catch:{ a -> 0x0261, all -> 0x025c }
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0261, all -> 0x025c }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            goto L_0x023f
        L_0x01ee:
            r17 = r7
            long r2 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            long r6 = r21.readInt64()     // Catch:{ a -> 0x0261, all -> 0x025c }
            java.lang.Long r4 = java.lang.Long.valueOf(r6)     // Catch:{ a -> 0x0261, all -> 0x025c }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            goto L_0x023f
        L_0x0203:
            r17 = r7
            long r2 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            float r4 = r21.readFloat()     // Catch:{ a -> 0x0261, all -> 0x025c }
            java.lang.Float r4 = java.lang.Float.valueOf(r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            goto L_0x023f
        L_0x0218:
            r17 = r7
            long r2 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            double r6 = r21.readDouble()     // Catch:{ a -> 0x0261, all -> 0x025c }
            java.lang.Double r4 = java.lang.Double.valueOf(r6)     // Catch:{ a -> 0x0261, all -> 0x025c }
            defpackage.C0285oB.u(r9, r2, r4)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r8.B(r9, r1, r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            goto L_0x023f
        L_0x022d:
            r17 = r7
            java.lang.Object r4 = r8.f(r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r1 = r19
            r2 = r20
            r3 = r5
            r5 = r22
            r6 = r21
            r1.m(r2, r3, r4, r5, r6)     // Catch:{ a -> 0x0261, all -> 0x025c }
        L_0x023f:
            r15 = r17
            goto L_0x0598
        L_0x0243:
            r17 = r7
            long r3 = r(r3)     // Catch:{ a -> 0x0261, all -> 0x025c }
            kv r6 = r8.g(r5)     // Catch:{ a -> 0x0261, all -> 0x025c }
            r1 = r19
            r2 = r20
            r5 = r21
            r15 = r17
            r7 = r22
            r1.v(r2, r3, r5, r6, r7)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x025c:
            r0 = move-exception
            r15 = r17
            goto L_0x05dc
        L_0x0261:
            r15 = r17
            goto L_0x059c
        L_0x0265:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readSInt64List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0273:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readSInt32List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0281:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readSFixed64List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x028f:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readSFixed32List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x029d:
            r15 = r7
            long r2 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r2 = r6.c(r9, r2)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readEnumList(r2)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            androidx.datastore.preferences.protobuf.p$b r3 = r8.e(r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.H.z(r1, r2, r3, r15, r11)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x05d4
        L_0x02b3:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readUInt32List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x02c1:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readBoolList(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x02cf:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readFixed32List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x02dd:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readFixed64List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x02eb:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readInt32List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x02f9:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readUInt64List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0307:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readInt64List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0315:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readFloatList(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0323:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readDoubleList(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0331:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readSInt64List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x033f:
            r15 = r7
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readSInt32List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x034d:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readSFixed64List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x035a:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readSFixed32List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0367:
            r15 = r7
            r2 = r3 & r4
            long r2 = (long) r2     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r2 = r6.c(r9, r2)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readEnumList(r2)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            androidx.datastore.preferences.protobuf.p$b r3 = r8.e(r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.H.z(r1, r2, r3, r15, r11)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x05d4
        L_0x037c:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readUInt32List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0389:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readBytesList(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0396:
            r15 = r7
            kv r5 = r8.g(r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r1 = r19
            r2 = r20
            r4 = r21
            r6 = r22
            r1.w(r2, r3, r4, r5, r6)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x03a8:
            r15 = r7
            r8.y(r9, r3, r0)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x03ae:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readBoolList(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x03bb:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readFixed32List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x03c8:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readFixed64List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x03d5:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readInt32List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x03e2:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readUInt64List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x03ef:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readInt64List(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x03fc:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readFloatList(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0409:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.util.List r1 = r6.c(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r0.readDoubleList(r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0416:
            r15 = r7
            boolean r1 = r8.j(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            if (r1 == 0) goto L_0x043a
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.lang.Object r1 = defpackage.C0285oB.n(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            kv r2 = r8.g(r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.lang.Object r2 = r0.c(r2, r10)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            androidx.datastore.preferences.protobuf.n r1 = androidx.datastore.preferences.protobuf.p.b(r1, r2)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            long r2 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.u(r9, r2, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x043a:
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            kv r3 = r8.g(r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.lang.Object r3 = r0.c(r3, r10)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.u(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x044e:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            long r3 = r21.readSInt64()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.t(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x045e:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            int r3 = r21.readSInt32()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.s(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x046e:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            long r3 = r21.readSFixed64()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.t(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x047e:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            int r3 = r21.readSFixed32()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.s(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x048e:
            r15 = r7
            int r2 = r21.readEnum()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            androidx.datastore.preferences.protobuf.p$b r4 = r8.e(r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            if (r4 == 0) goto L_0x04a6
            boolean r4 = r4.a()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            if (r4 == 0) goto L_0x04a0
            goto L_0x04a6
        L_0x04a0:
            java.lang.Object r7 = androidx.datastore.preferences.protobuf.H.D(r1, r2, r15, r11)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x05d4
        L_0x04a6:
            long r3 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.s(r9, r3, r2)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x04b2:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            int r3 = r21.readUInt32()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.s(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x04c2:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            x3 r3 = r21.b()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.u(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x04d2:
            r15 = r7
            boolean r1 = r8.j(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            if (r1 == 0) goto L_0x04f6
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.lang.Object r1 = defpackage.C0285oB.n(r9, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            kv r2 = r8.g(r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.lang.Object r2 = r0.e(r2, r10)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            androidx.datastore.preferences.protobuf.n r1 = androidx.datastore.preferences.protobuf.p.b(r1, r2)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            long r2 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.u(r9, r2, r1)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x04f6:
            long r1 = r(r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            kv r3 = r8.g(r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            java.lang.Object r3 = r0.e(r3, r10)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.u(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x050a:
            r15 = r7
            r8.x(r9, r3, r0)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0513:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            boolean r3 = r21.readBool()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            oB$e r4 = defpackage.C0285oB.f3140a     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r4.k(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0525:
            r0 = move-exception
            goto L_0x05dc
        L_0x0528:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            int r3 = r21.readFixed32()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.s(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0537:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            long r3 = r21.readFixed64()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.t(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0546:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            int r3 = r21.readInt32()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.s(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0555:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            long r3 = r21.readUInt64()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.t(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0564:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            long r3 = r21.readInt64()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            defpackage.C0285oB.t(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0573:
            r15 = r7
            r1 = r3 & r4
            long r1 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            float r3 = r21.readFloat()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            oB$e r4 = defpackage.C0285oB.f3140a     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r4.n(r9, r1, r3)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            goto L_0x0598
        L_0x0584:
            r15 = r7
            r1 = r3 & r4
            long r3 = (long) r1     // Catch:{ a -> 0x059c, all -> 0x0525 }
            double r6 = r21.readDouble()     // Catch:{ a -> 0x059c, all -> 0x0525 }
            oB$e r1 = defpackage.C0285oB.f3140a     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r2 = r20
            r10 = r5
            r5 = r6
            r1.m(r2, r3, r5)     // Catch:{ a -> 0x059c, all -> 0x0525 }
            r8.A(r9, r10)     // Catch:{ a -> 0x059c, all -> 0x0525 }
        L_0x0598:
            r7 = r15
            goto L_0x05d4
        L_0x059a:
            r7 = r1
            goto L_0x059f
        L_0x059c:
            r7 = r15
            goto L_0x05b3
        L_0x059e:
            r7 = r15
        L_0x059f:
            boolean r1 = r11.l(r7, r0)     // Catch:{ a -> 0x05b3 }
            if (r1 != 0) goto L_0x05d4
        L_0x05a5:
            if (r14 >= r13) goto L_0x05b0
            r0 = r12[r14]
            java.lang.Object r7 = r8.d(r9, r0, r7, r11)
            int r14 = r14 + 1
            goto L_0x05a5
        L_0x05b0:
            if (r7 == 0) goto L_0x05d3
            goto L_0x05d0
        L_0x05b3:
            r11.p()     // Catch:{ all -> 0x05d8 }
            if (r7 != 0) goto L_0x05bd
            androidx.datastore.preferences.protobuf.L r1 = r11.f(r9)     // Catch:{ all -> 0x05d8 }
            r7 = r1
        L_0x05bd:
            boolean r1 = r11.l(r7, r0)     // Catch:{ all -> 0x05d8 }
            if (r1 != 0) goto L_0x05d4
        L_0x05c3:
            if (r14 >= r13) goto L_0x05ce
            r0 = r12[r14]
            java.lang.Object r7 = r8.d(r9, r0, r7, r11)
            int r14 = r14 + 1
            goto L_0x05c3
        L_0x05ce:
            if (r7 == 0) goto L_0x05d3
        L_0x05d0:
            r11.n(r9, r7)
        L_0x05d3:
            return
        L_0x05d4:
            r10 = r22
            goto L_0x0016
        L_0x05d8:
            r0 = move-exception
            goto L_0x05dd
        L_0x05da:
            r0 = move-exception
            r15 = r7
        L_0x05dc:
            r7 = r15
        L_0x05dd:
            if (r14 >= r13) goto L_0x05e8
            r1 = r12[r14]
            java.lang.Object r7 = r8.d(r9, r1, r7, r11)
            int r14 = r14 + 1
            goto L_0x05dd
        L_0x05e8:
            if (r7 == 0) goto L_0x05ed
            r11.n(r9, r7)
        L_0x05ed:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C.a(java.lang.Object, androidx.datastore.preferences.protobuf.G, androidx.datastore.preferences.protobuf.i):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x0366  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x038a  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x039c  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x03ae  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x03d2  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x03e4  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x03f6  */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x040e  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0422  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0436  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x044a  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x045e  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0472  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x0486  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x049c  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x04b4  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x04c8  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x04f0  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0503  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0516  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0529  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x053c  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x054f  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x056b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01fa  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x020c  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x021e  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0242  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x029c  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02d2  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02e4  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02f6  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x031a  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0354  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.Object r18, androidx.datastore.preferences.protobuf.C0130g r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r19.getClass()
            boolean r3 = r0.f1906c
            if (r3 == 0) goto L_0x0588
            boolean r4 = r0.f1900a
            androidx.datastore.preferences.protobuf.j<?> r5 = r0.f1897a
            if (r4 == 0) goto L_0x0028
            androidx.datastore.preferences.protobuf.l r4 = r5.c(r1)
            boolean r6 = r4.h()
            if (r6 != 0) goto L_0x0028
            java.util.Iterator r4 = r4.k()
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            goto L_0x002a
        L_0x0028:
            r4 = 0
            r6 = 0
        L_0x002a:
            int[] r7 = r0.f1901a
            int r8 = r7.length
            r9 = 0
            r10 = r9
        L_0x002f:
            if (r10 >= r8) goto L_0x0567
            int r11 = r0.C(r10)
            r12 = r7[r10]
        L_0x0037:
            if (r6 == 0) goto L_0x0050
            r5.a(r6)
            if (r12 < 0) goto L_0x0050
            r5.j(r6)
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x004e
            java.lang.Object r6 = r4.next()
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            goto L_0x0037
        L_0x004e:
            r6 = 0
            goto L_0x0037
        L_0x0050:
            r13 = 267386880(0xff00000, float:2.3665827E-29)
            r13 = r13 & r11
            int r13 = r13 >>> 20
            r14 = 1
            r15 = 1048575(0xfffff, float:1.469367E-39)
            switch(r13) {
                case 0: goto L_0x054f;
                case 1: goto L_0x053c;
                case 2: goto L_0x0529;
                case 3: goto L_0x0516;
                case 4: goto L_0x0503;
                case 5: goto L_0x04f0;
                case 6: goto L_0x04dc;
                case 7: goto L_0x04c8;
                case 8: goto L_0x04b4;
                case 9: goto L_0x049c;
                case 10: goto L_0x0486;
                case 11: goto L_0x0472;
                case 12: goto L_0x045e;
                case 13: goto L_0x044a;
                case 14: goto L_0x0436;
                case 15: goto L_0x0422;
                case 16: goto L_0x040e;
                case 17: goto L_0x03f6;
                case 18: goto L_0x03e4;
                case 19: goto L_0x03d2;
                case 20: goto L_0x03c0;
                case 21: goto L_0x03ae;
                case 22: goto L_0x039c;
                case 23: goto L_0x038a;
                case 24: goto L_0x0378;
                case 25: goto L_0x0366;
                case 26: goto L_0x0354;
                case 27: goto L_0x033e;
                case 28: goto L_0x032c;
                case 29: goto L_0x031a;
                case 30: goto L_0x0308;
                case 31: goto L_0x02f6;
                case 32: goto L_0x02e4;
                case 33: goto L_0x02d2;
                case 34: goto L_0x02c0;
                case 35: goto L_0x02ae;
                case 36: goto L_0x029c;
                case 37: goto L_0x028a;
                case 38: goto L_0x0278;
                case 39: goto L_0x0266;
                case 40: goto L_0x0254;
                case 41: goto L_0x0242;
                case 42: goto L_0x0230;
                case 43: goto L_0x021e;
                case 44: goto L_0x020c;
                case 45: goto L_0x01fa;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d6;
                case 48: goto L_0x01c5;
                case 49: goto L_0x01b2;
                case 50: goto L_0x01a7;
                case 51: goto L_0x0190;
                case 52: goto L_0x0179;
                case 53: goto L_0x0168;
                case 54: goto L_0x0157;
                case 55: goto L_0x0146;
                case 56: goto L_0x0135;
                case 57: goto L_0x0124;
                case 58: goto L_0x010d;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e7;
                case 61: goto L_0x00d4;
                case 62: goto L_0x00c4;
                case 63: goto L_0x00b4;
                case 64: goto L_0x00a4;
                case 65: goto L_0x0094;
                case 66: goto L_0x0084;
                case 67: goto L_0x0074;
                case 68: goto L_0x0060;
                default: goto L_0x005c;
            }
        L_0x005c:
            r16 = r4
            goto L_0x0561
        L_0x0060:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            java.lang.Object r11 = defpackage.C0285oB.n(r1, r13)
            kv r13 = r0.g(r10)
            r2.h(r12, r13, r11)
            goto L_0x005c
        L_0x0074:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            long r13 = t(r1, r13)
            r2.p(r12, r13)
            goto L_0x005c
        L_0x0084:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            int r11 = s(r1, r13)
            r2.o(r12, r11)
            goto L_0x005c
        L_0x0094:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            long r13 = t(r1, r13)
            r2.n(r12, r13)
            goto L_0x005c
        L_0x00a4:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            int r11 = s(r1, r13)
            r2.m(r12, r11)
            goto L_0x005c
        L_0x00b4:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            int r11 = s(r1, r13)
            r2.d(r12, r11)
            goto L_0x005c
        L_0x00c4:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            int r11 = s(r1, r13)
            r2.q(r12, r11)
            goto L_0x005c
        L_0x00d4:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            java.lang.Object r11 = defpackage.C0285oB.n(r1, r13)
            x3 r11 = (defpackage.x3) r11
            r2.b(r12, r11)
            goto L_0x005c
        L_0x00e7:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            java.lang.Object r11 = defpackage.C0285oB.n(r1, r13)
            kv r13 = r0.g(r10)
            r2.k(r12, r13, r11)
            goto L_0x005c
        L_0x00fc:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            java.lang.Object r11 = defpackage.C0285oB.n(r1, r13)
            F(r12, r11, r2)
            goto L_0x005c
        L_0x010d:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            java.lang.Object r11 = defpackage.C0285oB.n(r1, r13)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            r2.a(r12, r11)
            goto L_0x005c
        L_0x0124:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            int r11 = s(r1, r13)
            r2.e(r12, r11)
            goto L_0x005c
        L_0x0135:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            long r13 = t(r1, r13)
            r2.f(r12, r13)
            goto L_0x005c
        L_0x0146:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            int r11 = s(r1, r13)
            r2.i(r12, r11)
            goto L_0x005c
        L_0x0157:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            long r13 = t(r1, r13)
            r2.r(r12, r13)
            goto L_0x005c
        L_0x0168:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            long r13 = t(r1, r13)
            r2.j(r12, r13)
            goto L_0x005c
        L_0x0179:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            java.lang.Object r11 = defpackage.C0285oB.n(r1, r13)
            java.lang.Float r11 = (java.lang.Float) r11
            float r11 = r11.floatValue()
            r2.g(r12, r11)
            goto L_0x005c
        L_0x0190:
            boolean r13 = r0.k(r1, r12, r10)
            if (r13 == 0) goto L_0x005c
            r11 = r11 & r15
            long r13 = (long) r11
            java.lang.Object r11 = defpackage.C0285oB.n(r1, r13)
            java.lang.Double r11 = (java.lang.Double) r11
            double r13 = r11.doubleValue()
            r2.c(r12, r13)
            goto L_0x005c
        L_0x01a7:
            r11 = r11 & r15
            long r13 = (long) r11
            java.lang.Object r11 = defpackage.C0285oB.n(r1, r13)
            r0.E(r2, r12, r11, r10)
            goto L_0x005c
        L_0x01b2:
            r12 = r7[r10]
            r11 = r11 & r15
            long r13 = (long) r11
            java.lang.Object r11 = defpackage.C0285oB.n(r1, r13)
            java.util.List r11 = (java.util.List) r11
            kv r13 = r0.g(r10)
            androidx.datastore.preferences.protobuf.H.L(r12, r11, r2, r13)
            goto L_0x005c
        L_0x01c5:
            r12 = r7[r10]
            r11 = r11 & r15
            r16 = r4
            long r3 = (long) r11
            java.lang.Object r3 = defpackage.C0285oB.n(r1, r3)
            java.util.List r3 = (java.util.List) r3
            androidx.datastore.preferences.protobuf.H.S(r12, r3, r2, r14)
            goto L_0x0561
        L_0x01d6:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.R(r3, r4, r2, r14)
            goto L_0x0561
        L_0x01e8:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.Q(r3, r4, r2, r14)
            goto L_0x0561
        L_0x01fa:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.P(r3, r4, r2, r14)
            goto L_0x0561
        L_0x020c:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.H(r3, r4, r2, r14)
            goto L_0x0561
        L_0x021e:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.U(r3, r4, r2, r14)
            goto L_0x0561
        L_0x0230:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.E(r3, r4, r2, r14)
            goto L_0x0561
        L_0x0242:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.I(r3, r4, r2, r14)
            goto L_0x0561
        L_0x0254:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.J(r3, r4, r2, r14)
            goto L_0x0561
        L_0x0266:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.M(r3, r4, r2, r14)
            goto L_0x0561
        L_0x0278:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.V(r3, r4, r2, r14)
            goto L_0x0561
        L_0x028a:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.N(r3, r4, r2, r14)
            goto L_0x0561
        L_0x029c:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.K(r3, r4, r2, r14)
            goto L_0x0561
        L_0x02ae:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.G(r3, r4, r2, r14)
            goto L_0x0561
        L_0x02c0:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.S(r3, r4, r2, r9)
            goto L_0x0561
        L_0x02d2:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.R(r3, r4, r2, r9)
            goto L_0x0561
        L_0x02e4:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.Q(r3, r4, r2, r9)
            goto L_0x0561
        L_0x02f6:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.P(r3, r4, r2, r9)
            goto L_0x0561
        L_0x0308:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.H(r3, r4, r2, r9)
            goto L_0x0561
        L_0x031a:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.U(r3, r4, r2, r9)
            goto L_0x0561
        L_0x032c:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.F(r3, r4, r2)
            goto L_0x0561
        L_0x033e:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            kv r11 = r0.g(r10)
            androidx.datastore.preferences.protobuf.H.O(r3, r4, r2, r11)
            goto L_0x0561
        L_0x0354:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.T(r3, r4, r2)
            goto L_0x0561
        L_0x0366:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.E(r3, r4, r2, r9)
            goto L_0x0561
        L_0x0378:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.I(r3, r4, r2, r9)
            goto L_0x0561
        L_0x038a:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.J(r3, r4, r2, r9)
            goto L_0x0561
        L_0x039c:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.M(r3, r4, r2, r9)
            goto L_0x0561
        L_0x03ae:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.V(r3, r4, r2, r9)
            goto L_0x0561
        L_0x03c0:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.N(r3, r4, r2, r9)
            goto L_0x0561
        L_0x03d2:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.K(r3, r4, r2, r9)
            goto L_0x0561
        L_0x03e4:
            r16 = r4
            r3 = r7[r10]
            r4 = r11 & r15
            long r11 = (long) r4
            java.lang.Object r4 = defpackage.C0285oB.n(r1, r11)
            java.util.List r4 = (java.util.List) r4
            androidx.datastore.preferences.protobuf.H.G(r3, r4, r2, r9)
            goto L_0x0561
        L_0x03f6:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            java.lang.Object r3 = defpackage.C0285oB.n(r1, r3)
            kv r4 = r0.g(r10)
            r2.h(r12, r4, r3)
            goto L_0x0561
        L_0x040e:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            long r3 = defpackage.C0285oB.m(r1, r3)
            r2.p(r12, r3)
            goto L_0x0561
        L_0x0422:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            int r3 = defpackage.C0285oB.l(r1, r3)
            r2.o(r12, r3)
            goto L_0x0561
        L_0x0436:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            long r3 = defpackage.C0285oB.m(r1, r3)
            r2.n(r12, r3)
            goto L_0x0561
        L_0x044a:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            int r3 = defpackage.C0285oB.l(r1, r3)
            r2.m(r12, r3)
            goto L_0x0561
        L_0x045e:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            int r3 = defpackage.C0285oB.l(r1, r3)
            r2.d(r12, r3)
            goto L_0x0561
        L_0x0472:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            int r3 = defpackage.C0285oB.l(r1, r3)
            r2.q(r12, r3)
            goto L_0x0561
        L_0x0486:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            java.lang.Object r3 = defpackage.C0285oB.n(r1, r3)
            x3 r3 = (defpackage.x3) r3
            r2.b(r12, r3)
            goto L_0x0561
        L_0x049c:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            java.lang.Object r3 = defpackage.C0285oB.n(r1, r3)
            kv r4 = r0.g(r10)
            r2.k(r12, r4, r3)
            goto L_0x0561
        L_0x04b4:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            java.lang.Object r3 = defpackage.C0285oB.n(r1, r3)
            F(r12, r3, r2)
            goto L_0x0561
        L_0x04c8:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            boolean r3 = defpackage.C0285oB.f(r1, r3)
            r2.a(r12, r3)
            goto L_0x0561
        L_0x04dc:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            int r3 = defpackage.C0285oB.l(r1, r3)
            r2.e(r12, r3)
            goto L_0x0561
        L_0x04f0:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            long r3 = defpackage.C0285oB.m(r1, r3)
            r2.f(r12, r3)
            goto L_0x0561
        L_0x0503:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            int r3 = defpackage.C0285oB.l(r1, r3)
            r2.i(r12, r3)
            goto L_0x0561
        L_0x0516:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            long r3 = defpackage.C0285oB.m(r1, r3)
            r2.r(r12, r3)
            goto L_0x0561
        L_0x0529:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            long r3 = defpackage.C0285oB.m(r1, r3)
            r2.j(r12, r3)
            goto L_0x0561
        L_0x053c:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            float r3 = defpackage.C0285oB.k(r1, r3)
            r2.g(r12, r3)
            goto L_0x0561
        L_0x054f:
            r16 = r4
            boolean r3 = r0.j(r1, r10)
            if (r3 == 0) goto L_0x0561
            r3 = r11 & r15
            long r3 = (long) r3
            double r3 = defpackage.C0285oB.j(r1, r3)
            r2.c(r12, r3)
        L_0x0561:
            int r10 = r10 + 3
            r4 = r16
            goto L_0x002f
        L_0x0567:
            r16 = r4
        L_0x0569:
            if (r6 == 0) goto L_0x057e
            r5.j(r6)
            boolean r3 = r16.hasNext()
            if (r3 == 0) goto L_0x057c
            java.lang.Object r3 = r16.next()
            r6 = r3
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            goto L_0x0569
        L_0x057c:
            r6 = 0
            goto L_0x0569
        L_0x057e:
            androidx.datastore.preferences.protobuf.K<?, ?> r3 = r0.f1896a
            androidx.datastore.preferences.protobuf.L r1 = r3.g(r1)
            r3.s(r1, r2)
            goto L_0x058b
        L_0x0588:
            r17.D(r18, r19)
        L_0x058b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C.b(java.lang.Object, androidx.datastore.preferences.protobuf.g):void");
    }

    public final boolean c(T t, T t2, int i) {
        if (j(t, i) == j(t2, i)) {
            return true;
        }
        return false;
    }

    public final <UT, UB> UB d(Object obj, int i, UB ub, K<UT, UB> k) {
        p.b e;
        int i2 = this.f1901a[i];
        Object n = C0285oB.n(obj, (long) (C(i) & 1048575));
        if (n == null || (e = e(i)) == null) {
            return ub;
        }
        y yVar = this.f1899a;
        x a2 = yVar.a(n);
        w.a<?, ?> e2 = yVar.e(f(i));
        Iterator it = a2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            ((Integer) entry.getValue()).intValue();
            if (!e.a()) {
                if (ub == null) {
                    ub = k.m();
                }
                int a3 = w.a(e2, entry.getKey(), entry.getValue());
                byte[] bArr = new byte[a3];
                Logger logger = s5.a;
                s5.b bVar = new s5.b(bArr, a3);
                try {
                    w.b(bVar, e2, entry.getKey(), entry.getValue());
                    if (bVar.a - bVar.b == 0) {
                        k.d(ub, i2, new x3.e(bArr));
                        it.remove();
                    } else {
                        throw new IllegalStateException("Did not write as much data as expected.");
                    }
                } catch (IOException e3) {
                    throw new RuntimeException(e3);
                }
            }
        }
        return ub;
    }

    public final p.b e(int i) {
        return (p.b) this.f1902a[((i / 3) * 2) + 1];
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003d, code lost:
        if (androidx.datastore.preferences.protobuf.H.C(defpackage.C0285oB.n(r11, r7), defpackage.C0285oB.n(r12, r7)) != false) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006f, code lost:
        if (androidx.datastore.preferences.protobuf.H.C(defpackage.C0285oB.n(r11, r7), defpackage.C0285oB.n(r12, r7)) != false) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0083, code lost:
        if (defpackage.C0285oB.m(r11, r7) == defpackage.C0285oB.m(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0095, code lost:
        if (defpackage.C0285oB.l(r11, r7) == defpackage.C0285oB.l(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a9, code lost:
        if (defpackage.C0285oB.m(r11, r7) == defpackage.C0285oB.m(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bb, code lost:
        if (defpackage.C0285oB.l(r11, r7) == defpackage.C0285oB.l(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cd, code lost:
        if (defpackage.C0285oB.l(r11, r7) == defpackage.C0285oB.l(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00df, code lost:
        if (defpackage.C0285oB.l(r11, r7) == defpackage.C0285oB.l(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f5, code lost:
        if (androidx.datastore.preferences.protobuf.H.C(defpackage.C0285oB.n(r11, r7), defpackage.C0285oB.n(r12, r7)) != false) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010b, code lost:
        if (androidx.datastore.preferences.protobuf.H.C(defpackage.C0285oB.n(r11, r7), defpackage.C0285oB.n(r12, r7)) != false) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0121, code lost:
        if (androidx.datastore.preferences.protobuf.H.C(defpackage.C0285oB.n(r11, r7), defpackage.C0285oB.n(r12, r7)) != false) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0133, code lost:
        if (defpackage.C0285oB.f(r11, r7) == defpackage.C0285oB.f(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        if (defpackage.C0285oB.l(r11, r7) == defpackage.C0285oB.l(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0159, code lost:
        if (defpackage.C0285oB.m(r11, r7) == defpackage.C0285oB.m(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016b, code lost:
        if (defpackage.C0285oB.l(r11, r7) == defpackage.C0285oB.l(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017e, code lost:
        if (defpackage.C0285oB.m(r11, r7) == defpackage.C0285oB.m(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0191, code lost:
        if (defpackage.C0285oB.m(r11, r7) == defpackage.C0285oB.m(r12, r7)) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01aa, code lost:
        if (java.lang.Float.floatToIntBits(defpackage.C0285oB.k(r11, r7)) == java.lang.Float.floatToIntBits(defpackage.C0285oB.k(r12, r7))) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01c5, code lost:
        if (java.lang.Double.doubleToLongBits(defpackage.C0285oB.j(r11, r7)) == java.lang.Double.doubleToLongBits(defpackage.C0285oB.j(r12, r7))) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c8, code lost:
        r4 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r11, T r12) {
        /*
            r10 = this;
            int[] r0 = r10.f1901a
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L_0x0005:
            r4 = 1
            if (r3 >= r1) goto L_0x01d0
            int r5 = r10.C(r3)
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r5 & r6
            long r7 = (long) r7
            r9 = 267386880(0xff00000, float:2.3665827E-29)
            r5 = r5 & r9
            int r5 = r5 >>> 20
            switch(r5) {
                case 0: goto L_0x01ad;
                case 1: goto L_0x0194;
                case 2: goto L_0x0181;
                case 3: goto L_0x016e;
                case 4: goto L_0x015d;
                case 5: goto L_0x0149;
                case 6: goto L_0x0137;
                case 7: goto L_0x0125;
                case 8: goto L_0x010f;
                case 9: goto L_0x00f9;
                case 10: goto L_0x00e3;
                case 11: goto L_0x00d1;
                case 12: goto L_0x00bf;
                case 13: goto L_0x00ad;
                case 14: goto L_0x0099;
                case 15: goto L_0x0087;
                case 16: goto L_0x0073;
                case 17: goto L_0x005d;
                case 18: goto L_0x004f;
                case 19: goto L_0x004f;
                case 20: goto L_0x004f;
                case 21: goto L_0x004f;
                case 22: goto L_0x004f;
                case 23: goto L_0x004f;
                case 24: goto L_0x004f;
                case 25: goto L_0x004f;
                case 26: goto L_0x004f;
                case 27: goto L_0x004f;
                case 28: goto L_0x004f;
                case 29: goto L_0x004f;
                case 30: goto L_0x004f;
                case 31: goto L_0x004f;
                case 32: goto L_0x004f;
                case 33: goto L_0x004f;
                case 34: goto L_0x004f;
                case 35: goto L_0x004f;
                case 36: goto L_0x004f;
                case 37: goto L_0x004f;
                case 38: goto L_0x004f;
                case 39: goto L_0x004f;
                case 40: goto L_0x004f;
                case 41: goto L_0x004f;
                case 42: goto L_0x004f;
                case 43: goto L_0x004f;
                case 44: goto L_0x004f;
                case 45: goto L_0x004f;
                case 46: goto L_0x004f;
                case 47: goto L_0x004f;
                case 48: goto L_0x004f;
                case 49: goto L_0x004f;
                case 50: goto L_0x0041;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c9
        L_0x001c:
            int r5 = r3 + 2
            r5 = r0[r5]
            r5 = r5 & r6
            long r5 = (long) r5
            int r9 = defpackage.C0285oB.l(r11, r5)
            int r5 = defpackage.C0285oB.l(r12, r5)
            if (r9 != r5) goto L_0x002e
            r5 = r4
            goto L_0x002f
        L_0x002e:
            r5 = r2
        L_0x002f:
            if (r5 == 0) goto L_0x01c8
            java.lang.Object r5 = defpackage.C0285oB.n(r11, r7)
            java.lang.Object r6 = defpackage.C0285oB.n(r12, r7)
            boolean r5 = androidx.datastore.preferences.protobuf.H.C(r5, r6)
            if (r5 == 0) goto L_0x01c8
            goto L_0x01c9
        L_0x0041:
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r7)
            java.lang.Object r5 = defpackage.C0285oB.n(r12, r7)
            boolean r4 = androidx.datastore.preferences.protobuf.H.C(r4, r5)
            goto L_0x01c9
        L_0x004f:
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r7)
            java.lang.Object r5 = defpackage.C0285oB.n(r12, r7)
            boolean r4 = androidx.datastore.preferences.protobuf.H.C(r4, r5)
            goto L_0x01c9
        L_0x005d:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            java.lang.Object r5 = defpackage.C0285oB.n(r11, r7)
            java.lang.Object r6 = defpackage.C0285oB.n(r12, r7)
            boolean r5 = androidx.datastore.preferences.protobuf.H.C(r5, r6)
            if (r5 == 0) goto L_0x01c8
            goto L_0x01c9
        L_0x0073:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            long r5 = defpackage.C0285oB.m(r11, r7)
            long r7 = defpackage.C0285oB.m(r12, r7)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x01c8
            goto L_0x01c9
        L_0x0087:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            int r5 = defpackage.C0285oB.l(r11, r7)
            int r6 = defpackage.C0285oB.l(r12, r7)
            if (r5 != r6) goto L_0x01c8
            goto L_0x01c9
        L_0x0099:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            long r5 = defpackage.C0285oB.m(r11, r7)
            long r7 = defpackage.C0285oB.m(r12, r7)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x01c8
            goto L_0x01c9
        L_0x00ad:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            int r5 = defpackage.C0285oB.l(r11, r7)
            int r6 = defpackage.C0285oB.l(r12, r7)
            if (r5 != r6) goto L_0x01c8
            goto L_0x01c9
        L_0x00bf:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            int r5 = defpackage.C0285oB.l(r11, r7)
            int r6 = defpackage.C0285oB.l(r12, r7)
            if (r5 != r6) goto L_0x01c8
            goto L_0x01c9
        L_0x00d1:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            int r5 = defpackage.C0285oB.l(r11, r7)
            int r6 = defpackage.C0285oB.l(r12, r7)
            if (r5 != r6) goto L_0x01c8
            goto L_0x01c9
        L_0x00e3:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            java.lang.Object r5 = defpackage.C0285oB.n(r11, r7)
            java.lang.Object r6 = defpackage.C0285oB.n(r12, r7)
            boolean r5 = androidx.datastore.preferences.protobuf.H.C(r5, r6)
            if (r5 == 0) goto L_0x01c8
            goto L_0x01c9
        L_0x00f9:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            java.lang.Object r5 = defpackage.C0285oB.n(r11, r7)
            java.lang.Object r6 = defpackage.C0285oB.n(r12, r7)
            boolean r5 = androidx.datastore.preferences.protobuf.H.C(r5, r6)
            if (r5 == 0) goto L_0x01c8
            goto L_0x01c9
        L_0x010f:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            java.lang.Object r5 = defpackage.C0285oB.n(r11, r7)
            java.lang.Object r6 = defpackage.C0285oB.n(r12, r7)
            boolean r5 = androidx.datastore.preferences.protobuf.H.C(r5, r6)
            if (r5 == 0) goto L_0x01c8
            goto L_0x01c9
        L_0x0125:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            boolean r5 = defpackage.C0285oB.f(r11, r7)
            boolean r6 = defpackage.C0285oB.f(r12, r7)
            if (r5 != r6) goto L_0x01c8
            goto L_0x01c9
        L_0x0137:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            int r5 = defpackage.C0285oB.l(r11, r7)
            int r6 = defpackage.C0285oB.l(r12, r7)
            if (r5 != r6) goto L_0x01c8
            goto L_0x01c9
        L_0x0149:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            long r5 = defpackage.C0285oB.m(r11, r7)
            long r7 = defpackage.C0285oB.m(r12, r7)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x01c8
            goto L_0x01c9
        L_0x015d:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            int r5 = defpackage.C0285oB.l(r11, r7)
            int r6 = defpackage.C0285oB.l(r12, r7)
            if (r5 != r6) goto L_0x01c8
            goto L_0x01c9
        L_0x016e:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            long r5 = defpackage.C0285oB.m(r11, r7)
            long r7 = defpackage.C0285oB.m(r12, r7)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x01c8
            goto L_0x01c9
        L_0x0181:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            long r5 = defpackage.C0285oB.m(r11, r7)
            long r7 = defpackage.C0285oB.m(r12, r7)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x01c8
            goto L_0x01c9
        L_0x0194:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            float r5 = defpackage.C0285oB.k(r11, r7)
            int r5 = java.lang.Float.floatToIntBits(r5)
            float r6 = defpackage.C0285oB.k(r12, r7)
            int r6 = java.lang.Float.floatToIntBits(r6)
            if (r5 != r6) goto L_0x01c8
            goto L_0x01c9
        L_0x01ad:
            boolean r5 = r10.c(r11, r12, r3)
            if (r5 == 0) goto L_0x01c8
            double r5 = defpackage.C0285oB.j(r11, r7)
            long r5 = java.lang.Double.doubleToLongBits(r5)
            double r7 = defpackage.C0285oB.j(r12, r7)
            long r7 = java.lang.Double.doubleToLongBits(r7)
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x01c8
            goto L_0x01c9
        L_0x01c8:
            r4 = r2
        L_0x01c9:
            if (r4 != 0) goto L_0x01cc
            return r2
        L_0x01cc:
            int r3 = r3 + 3
            goto L_0x0005
        L_0x01d0:
            androidx.datastore.preferences.protobuf.K<?, ?> r0 = r10.f1896a
            androidx.datastore.preferences.protobuf.L r1 = r0.g(r11)
            androidx.datastore.preferences.protobuf.L r0 = r0.g(r12)
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x01e1
            return r2
        L_0x01e1:
            boolean r0 = r10.f1900a
            if (r0 == 0) goto L_0x01f4
            androidx.datastore.preferences.protobuf.j<?> r0 = r10.f1897a
            androidx.datastore.preferences.protobuf.l r11 = r0.c(r11)
            androidx.datastore.preferences.protobuf.l r12 = r0.c(r12)
            boolean r11 = r11.equals(r12)
            return r11
        L_0x01f4:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C.equals(java.lang.Object, java.lang.Object):boolean");
    }

    public final Object f(int i) {
        return this.f1902a[(i / 3) * 2];
    }

    public final kv g(int i) {
        int i2 = (i / 3) * 2;
        Object[] objArr = this.f1902a;
        kv kvVar = (kv) objArr[i2];
        if (kvVar != null) {
            return kvVar;
        }
        kv a2 = Mq.a.a((Class) objArr[i2 + 1]);
        objArr[i2] = a2;
        return a2;
    }

    public final int getSerializedSize(T t) {
        if (this.f1906c) {
            return i(t);
        }
        return h(t);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0328, code lost:
        r4 = defpackage.C1058d.q(r8, r6, r7, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0499, code lost:
        r4 = r6 + r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int h(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0008:
            int[] r6 = r0.f1901a
            int r7 = r6.length
            if (r3 >= r7) goto L_0x04f4
            int r7 = r0.C(r3)
            r8 = r6[r3]
            r9 = 267386880(0xff00000, float:2.3665827E-29)
            r9 = r9 & r7
            int r9 = r9 >>> 20
            r10 = 17
            r11 = 1048575(0xfffff, float:1.469367E-39)
            boolean r12 = r0.f1907d
            sun.misc.Unsafe r13 = a
            if (r9 > r10) goto L_0x003f
            int r10 = r3 + 2
            r6 = r6[r10]
            r10 = r6 & r11
            int r14 = r6 >>> 20
            r15 = 1
            int r14 = r15 << r14
            r16 = r12
            if (r10 == r2) goto L_0x003d
            long r11 = (long) r10
            int r2 = r13.getInt(r1, r11)
            r5 = r2
            r2 = r10
            r10 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0061
        L_0x003d:
            r10 = r11
            goto L_0x0061
        L_0x003f:
            r16 = r12
            if (r16 == 0) goto L_0x005c
            fc r10 = defpackage.C0194fc.DOUBLE_LIST_PACKED
            int r10 = r10.a()
            if (r9 < r10) goto L_0x005c
            fc r10 = defpackage.C0194fc.SINT64_LIST_PACKED
            int r10 = r10.a()
            if (r9 > r10) goto L_0x005c
            int r10 = r3 + 2
            r6 = r6[r10]
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r6 & r10
            goto L_0x0060
        L_0x005c:
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r6 = 0
        L_0x0060:
            r14 = 0
        L_0x0061:
            r7 = r7 & r10
            long r10 = (long) r7
            switch(r9) {
                case 0: goto L_0x04e7;
                case 1: goto L_0x04de;
                case 2: goto L_0x04d1;
                case 3: goto L_0x04c4;
                case 4: goto L_0x04b7;
                case 5: goto L_0x04ae;
                case 6: goto L_0x04a5;
                case 7: goto L_0x049c;
                case 8: goto L_0x0480;
                case 9: goto L_0x046e;
                case 10: goto L_0x045e;
                case 11: goto L_0x0450;
                case 12: goto L_0x0442;
                case 13: goto L_0x0438;
                case 14: goto L_0x042e;
                case 15: goto L_0x0420;
                case 16: goto L_0x0412;
                case 17: goto L_0x03fe;
                case 18: goto L_0x03f2;
                case 19: goto L_0x03e6;
                case 20: goto L_0x03da;
                case 21: goto L_0x03ce;
                case 22: goto L_0x03c2;
                case 23: goto L_0x03b6;
                case 24: goto L_0x03aa;
                case 25: goto L_0x039e;
                case 26: goto L_0x0392;
                case 27: goto L_0x0382;
                case 28: goto L_0x0376;
                case 29: goto L_0x036a;
                case 30: goto L_0x035e;
                case 31: goto L_0x0352;
                case 32: goto L_0x0346;
                case 33: goto L_0x033a;
                case 34: goto L_0x032e;
                case 35: goto L_0x030e;
                case 36: goto L_0x02f3;
                case 37: goto L_0x02d8;
                case 38: goto L_0x02bd;
                case 39: goto L_0x02a2;
                case 40: goto L_0x0286;
                case 41: goto L_0x026a;
                case 42: goto L_0x024e;
                case 43: goto L_0x0232;
                case 44: goto L_0x0216;
                case 45: goto L_0x01fa;
                case 46: goto L_0x01de;
                case 47: goto L_0x01c2;
                case 48: goto L_0x01a6;
                case 49: goto L_0x0196;
                case 50: goto L_0x0186;
                case 51: goto L_0x017a;
                case 52: goto L_0x016e;
                case 53: goto L_0x015e;
                case 54: goto L_0x014e;
                case 55: goto L_0x013e;
                case 56: goto L_0x0132;
                case 57: goto L_0x0126;
                case 58: goto L_0x011a;
                case 59: goto L_0x00fc;
                case 60: goto L_0x00e8;
                case 61: goto L_0x00d6;
                case 62: goto L_0x00c6;
                case 63: goto L_0x00b6;
                case 64: goto L_0x00aa;
                case 65: goto L_0x009e;
                case 66: goto L_0x008e;
                case 67: goto L_0x007e;
                case 68: goto L_0x0068;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x04f0
        L_0x0068:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            java.lang.Object r6 = r13.getObject(r1, r10)
            androidx.datastore.preferences.protobuf.A r6 = (androidx.datastore.preferences.protobuf.A) r6
            kv r7 = r0.g(r3)
            int r6 = defpackage.s5.k(r8, r6, r7)
            goto L_0x04ef
        L_0x007e:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            long r6 = t(r1, r10)
            int r6 = defpackage.s5.s(r8, r6)
            goto L_0x04ef
        L_0x008e:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            int r6 = s(r1, r10)
            int r6 = defpackage.s5.r(r8, r6)
            goto L_0x04ef
        L_0x009e:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.q(r8)
            goto L_0x04ef
        L_0x00aa:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.p(r8)
            goto L_0x04ef
        L_0x00b6:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            int r6 = s(r1, r10)
            int r6 = defpackage.s5.g(r8, r6)
            goto L_0x04ef
        L_0x00c6:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            int r6 = s(r1, r10)
            int r6 = defpackage.s5.w(r8, r6)
            goto L_0x04ef
        L_0x00d6:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            java.lang.Object r6 = r13.getObject(r1, r10)
            x3 r6 = (defpackage.x3) r6
            int r6 = defpackage.s5.e(r8, r6)
            goto L_0x04ef
        L_0x00e8:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            java.lang.Object r6 = r13.getObject(r1, r10)
            kv r7 = r0.g(r3)
            int r6 = androidx.datastore.preferences.protobuf.H.o(r8, r7, r6)
            goto L_0x04ef
        L_0x00fc:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            java.lang.Object r6 = r13.getObject(r1, r10)
            boolean r7 = r6 instanceof defpackage.x3
            if (r7 == 0) goto L_0x0112
            x3 r6 = (defpackage.x3) r6
            int r6 = defpackage.s5.e(r8, r6)
            goto L_0x0499
        L_0x0112:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = defpackage.s5.t(r8, r6)
            goto L_0x0499
        L_0x011a:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.d(r8)
            goto L_0x04ef
        L_0x0126:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.h(r8)
            goto L_0x04ef
        L_0x0132:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.i(r8)
            goto L_0x04ef
        L_0x013e:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            int r6 = s(r1, r10)
            int r6 = defpackage.s5.l(r8, r6)
            goto L_0x04ef
        L_0x014e:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            long r6 = t(r1, r10)
            int r6 = defpackage.s5.y(r8, r6)
            goto L_0x04ef
        L_0x015e:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            long r6 = t(r1, r10)
            int r6 = defpackage.s5.n(r8, r6)
            goto L_0x04ef
        L_0x016e:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.j(r8)
            goto L_0x04ef
        L_0x017a:
            boolean r6 = r0.k(r1, r8, r3)
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.f(r8)
            goto L_0x04ef
        L_0x0186:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.lang.Object r7 = r0.f(r3)
            androidx.datastore.preferences.protobuf.y r9 = r0.f1899a
            int r6 = r9.getSerializedSize(r8, r6, r7)
            goto L_0x04ef
        L_0x0196:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            kv r7 = r0.g(r3)
            int r6 = androidx.datastore.preferences.protobuf.H.j(r8, r6, r7)
            goto L_0x04ef
        L_0x01a6:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.t(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x01b8
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x01b8:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x01c2:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.r(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x01d4
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x01d4:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x01de:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.i(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x01f0
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x01f0:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x01fa:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.g(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x020c
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x020c:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x0216:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.e(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x0228
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x0228:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x0232:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.w(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x0244
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x0244:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x024e:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.b(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x0260
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x0260:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x026a:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.g(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x027c
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x027c:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x0286:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.i(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x0298
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x0298:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x02a2:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.l(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x02b4
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x02b4:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x02bd:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.y(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x02cf
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x02cf:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x02d8:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.n(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x02ea
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x02ea:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x02f3:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.g(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x0305
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x0305:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
            goto L_0x0328
        L_0x030e:
            java.lang.Object r7 = r13.getObject(r1, r10)
            java.util.List r7 = (java.util.List) r7
            int r7 = androidx.datastore.preferences.protobuf.H.i(r7)
            if (r7 <= 0) goto L_0x04f0
            if (r16 == 0) goto L_0x0320
            long r9 = (long) r6
            r13.putInt(r1, r9, r7)
        L_0x0320:
            int r6 = defpackage.s5.v(r8)
            int r8 = defpackage.s5.x(r7)
        L_0x0328:
            int r4 = defpackage.C1058d.q(r8, r6, r7, r4)
            goto L_0x04f0
        L_0x032e:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.s(r8, r6)
            goto L_0x04ef
        L_0x033a:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.q(r8, r6)
            goto L_0x04ef
        L_0x0346:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.h(r8, r6)
            goto L_0x04ef
        L_0x0352:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.f(r8, r6)
            goto L_0x04ef
        L_0x035e:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.d(r8, r6)
            goto L_0x04ef
        L_0x036a:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.v(r8, r6)
            goto L_0x04ef
        L_0x0376:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.c(r8, r6)
            goto L_0x04ef
        L_0x0382:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            kv r7 = r0.g(r3)
            int r6 = androidx.datastore.preferences.protobuf.H.p(r8, r6, r7)
            goto L_0x04ef
        L_0x0392:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.u(r8, r6)
            goto L_0x04ef
        L_0x039e:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.a(r8, r6)
            goto L_0x04ef
        L_0x03aa:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.f(r8, r6)
            goto L_0x04ef
        L_0x03b6:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.h(r8, r6)
            goto L_0x04ef
        L_0x03c2:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.k(r8, r6)
            goto L_0x04ef
        L_0x03ce:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.x(r8, r6)
            goto L_0x04ef
        L_0x03da:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.m(r8, r6)
            goto L_0x04ef
        L_0x03e6:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.f(r8, r6)
            goto L_0x04ef
        L_0x03f2:
            java.lang.Object r6 = r13.getObject(r1, r10)
            java.util.List r6 = (java.util.List) r6
            int r6 = androidx.datastore.preferences.protobuf.H.h(r8, r6)
            goto L_0x04ef
        L_0x03fe:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            java.lang.Object r6 = r13.getObject(r1, r10)
            androidx.datastore.preferences.protobuf.A r6 = (androidx.datastore.preferences.protobuf.A) r6
            kv r7 = r0.g(r3)
            int r6 = defpackage.s5.k(r8, r6, r7)
            goto L_0x04ef
        L_0x0412:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            long r6 = r13.getLong(r1, r10)
            int r6 = defpackage.s5.s(r8, r6)
            goto L_0x04ef
        L_0x0420:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            int r6 = r13.getInt(r1, r10)
            int r6 = defpackage.s5.r(r8, r6)
            goto L_0x04ef
        L_0x042e:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.q(r8)
            goto L_0x04ef
        L_0x0438:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.p(r8)
            goto L_0x04ef
        L_0x0442:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            int r6 = r13.getInt(r1, r10)
            int r6 = defpackage.s5.g(r8, r6)
            goto L_0x04ef
        L_0x0450:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            int r6 = r13.getInt(r1, r10)
            int r6 = defpackage.s5.w(r8, r6)
            goto L_0x04ef
        L_0x045e:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            java.lang.Object r6 = r13.getObject(r1, r10)
            x3 r6 = (defpackage.x3) r6
            int r6 = defpackage.s5.e(r8, r6)
            goto L_0x04ef
        L_0x046e:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            java.lang.Object r6 = r13.getObject(r1, r10)
            kv r7 = r0.g(r3)
            int r6 = androidx.datastore.preferences.protobuf.H.o(r8, r7, r6)
            goto L_0x04ef
        L_0x0480:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            java.lang.Object r6 = r13.getObject(r1, r10)
            boolean r7 = r6 instanceof defpackage.x3
            if (r7 == 0) goto L_0x0493
            x3 r6 = (defpackage.x3) r6
            int r6 = defpackage.s5.e(r8, r6)
            goto L_0x0499
        L_0x0493:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = defpackage.s5.t(r8, r6)
        L_0x0499:
            int r6 = r6 + r4
            r4 = r6
            goto L_0x04f0
        L_0x049c:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.d(r8)
            goto L_0x04ef
        L_0x04a5:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.h(r8)
            goto L_0x04ef
        L_0x04ae:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.i(r8)
            goto L_0x04ef
        L_0x04b7:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            int r6 = r13.getInt(r1, r10)
            int r6 = defpackage.s5.l(r8, r6)
            goto L_0x04ef
        L_0x04c4:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            long r6 = r13.getLong(r1, r10)
            int r6 = defpackage.s5.y(r8, r6)
            goto L_0x04ef
        L_0x04d1:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            long r6 = r13.getLong(r1, r10)
            int r6 = defpackage.s5.n(r8, r6)
            goto L_0x04ef
        L_0x04de:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.j(r8)
            goto L_0x04ef
        L_0x04e7:
            r6 = r5 & r14
            if (r6 == 0) goto L_0x04f0
            int r6 = defpackage.s5.f(r8)
        L_0x04ef:
            int r4 = r4 + r6
        L_0x04f0:
            int r3 = r3 + 3
            goto L_0x0008
        L_0x04f4:
            androidx.datastore.preferences.protobuf.K<?, ?> r2 = r0.f1896a
            androidx.datastore.preferences.protobuf.L r3 = r2.g(r1)
            int r2 = r2.h(r3)
            int r2 = r2 + r4
            boolean r3 = r0.f1900a
            if (r3 == 0) goto L_0x050e
            androidx.datastore.preferences.protobuf.j<?> r3 = r0.f1897a
            androidx.datastore.preferences.protobuf.l r1 = r3.c(r1)
            int r1 = r1.g()
            int r2 = r2 + r1
        L_0x050e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C.h(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00da, code lost:
        if (r4 != false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01d6, code lost:
        r4 = 37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01d8, code lost:
        r3 = (r3 * 53) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01f2, code lost:
        if (r4 != false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01f5, code lost:
        r8 = 1237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01f6, code lost:
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0240, code lost:
        r3 = r4 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0242, code lost:
        r2 = r2 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r11) {
        /*
            r10 = this;
            int[] r0 = r10.f1901a
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L_0x0005:
            if (r2 >= r1) goto L_0x0246
            int r4 = r10.C(r2)
            r5 = r0[r2]
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r6 & r4
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            r8 = 1231(0x4cf, float:1.725E-42)
            r9 = 1237(0x4d5, float:1.733E-42)
            switch(r4) {
                case 0: goto L_0x0232;
                case 1: goto L_0x0227;
                case 2: goto L_0x021c;
                case 3: goto L_0x0211;
                case 4: goto L_0x020a;
                case 5: goto L_0x01ff;
                case 6: goto L_0x01f8;
                case 7: goto L_0x01ea;
                case 8: goto L_0x01dd;
                case 9: goto L_0x01cb;
                case 10: goto L_0x01bf;
                case 11: goto L_0x01b7;
                case 12: goto L_0x01af;
                case 13: goto L_0x01a7;
                case 14: goto L_0x019b;
                case 15: goto L_0x0193;
                case 16: goto L_0x0187;
                case 17: goto L_0x017c;
                case 18: goto L_0x0170;
                case 19: goto L_0x0170;
                case 20: goto L_0x0170;
                case 21: goto L_0x0170;
                case 22: goto L_0x0170;
                case 23: goto L_0x0170;
                case 24: goto L_0x0170;
                case 25: goto L_0x0170;
                case 26: goto L_0x0170;
                case 27: goto L_0x0170;
                case 28: goto L_0x0170;
                case 29: goto L_0x0170;
                case 30: goto L_0x0170;
                case 31: goto L_0x0170;
                case 32: goto L_0x0170;
                case 33: goto L_0x0170;
                case 34: goto L_0x0170;
                case 35: goto L_0x0170;
                case 36: goto L_0x0170;
                case 37: goto L_0x0170;
                case 38: goto L_0x0170;
                case 39: goto L_0x0170;
                case 40: goto L_0x0170;
                case 41: goto L_0x0170;
                case 42: goto L_0x0170;
                case 43: goto L_0x0170;
                case 44: goto L_0x0170;
                case 45: goto L_0x0170;
                case 46: goto L_0x0170;
                case 47: goto L_0x0170;
                case 48: goto L_0x0170;
                case 49: goto L_0x0170;
                case 50: goto L_0x0164;
                case 51: goto L_0x0148;
                case 52: goto L_0x0130;
                case 53: goto L_0x011e;
                case 54: goto L_0x010c;
                case 55: goto L_0x00fe;
                case 56: goto L_0x00ec;
                case 57: goto L_0x00de;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0242
        L_0x0020:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            int r3 = r3 * 53
            int r4 = r4.hashCode()
            goto L_0x0240
        L_0x0032:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            long r4 = t(r11, r6)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
            goto L_0x0240
        L_0x0044:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            int r4 = s(r11, r6)
            goto L_0x0240
        L_0x0052:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            long r4 = t(r11, r6)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
            goto L_0x0240
        L_0x0064:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            int r4 = s(r11, r6)
            goto L_0x0240
        L_0x0072:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            int r4 = s(r11, r6)
            goto L_0x0240
        L_0x0080:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            int r4 = s(r11, r6)
            goto L_0x0240
        L_0x008e:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            int r4 = r4.hashCode()
            goto L_0x0240
        L_0x00a0:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            int r3 = r3 * 53
            int r4 = r4.hashCode()
            goto L_0x0240
        L_0x00b2:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r4.hashCode()
            goto L_0x0240
        L_0x00c6:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            java.nio.charset.Charset r5 = androidx.datastore.preferences.protobuf.p.a
            if (r4 == 0) goto L_0x01f5
            goto L_0x01f6
        L_0x00de:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            int r4 = s(r11, r6)
            goto L_0x0240
        L_0x00ec:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            long r4 = t(r11, r6)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
            goto L_0x0240
        L_0x00fe:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            int r4 = s(r11, r6)
            goto L_0x0240
        L_0x010c:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            long r4 = t(r11, r6)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
            goto L_0x0240
        L_0x011e:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            long r4 = t(r11, r6)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
            goto L_0x0240
        L_0x0130:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            int r4 = java.lang.Float.floatToIntBits(r4)
            goto L_0x0240
        L_0x0148:
            boolean r4 = r10.k(r11, r5, r2)
            if (r4 == 0) goto L_0x0242
            int r3 = r3 * 53
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            java.lang.Double r4 = (java.lang.Double) r4
            double r4 = r4.doubleValue()
            long r4 = java.lang.Double.doubleToLongBits(r4)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
            goto L_0x0240
        L_0x0164:
            int r3 = r3 * 53
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            int r4 = r4.hashCode()
            goto L_0x0240
        L_0x0170:
            int r3 = r3 * 53
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            int r4 = r4.hashCode()
            goto L_0x0240
        L_0x017c:
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            if (r4 == 0) goto L_0x01d6
            int r4 = r4.hashCode()
            goto L_0x01d8
        L_0x0187:
            int r3 = r3 * 53
            long r4 = defpackage.C0285oB.m(r11, r6)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
            goto L_0x0240
        L_0x0193:
            int r3 = r3 * 53
            int r4 = defpackage.C0285oB.l(r11, r6)
            goto L_0x0240
        L_0x019b:
            int r3 = r3 * 53
            long r4 = defpackage.C0285oB.m(r11, r6)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
            goto L_0x0240
        L_0x01a7:
            int r3 = r3 * 53
            int r4 = defpackage.C0285oB.l(r11, r6)
            goto L_0x0240
        L_0x01af:
            int r3 = r3 * 53
            int r4 = defpackage.C0285oB.l(r11, r6)
            goto L_0x0240
        L_0x01b7:
            int r3 = r3 * 53
            int r4 = defpackage.C0285oB.l(r11, r6)
            goto L_0x0240
        L_0x01bf:
            int r3 = r3 * 53
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            int r4 = r4.hashCode()
            goto L_0x0240
        L_0x01cb:
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            if (r4 == 0) goto L_0x01d6
            int r4 = r4.hashCode()
            goto L_0x01d8
        L_0x01d6:
            r4 = 37
        L_0x01d8:
            int r3 = r3 * 53
            int r3 = r3 + r4
            goto L_0x0242
        L_0x01dd:
            int r3 = r3 * 53
            java.lang.Object r4 = defpackage.C0285oB.n(r11, r6)
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r4.hashCode()
            goto L_0x0240
        L_0x01ea:
            int r3 = r3 * 53
            boolean r4 = defpackage.C0285oB.f(r11, r6)
            java.nio.charset.Charset r5 = androidx.datastore.preferences.protobuf.p.a
            if (r4 == 0) goto L_0x01f5
            goto L_0x01f6
        L_0x01f5:
            r8 = r9
        L_0x01f6:
            r4 = r8
            goto L_0x0240
        L_0x01f8:
            int r3 = r3 * 53
            int r4 = defpackage.C0285oB.l(r11, r6)
            goto L_0x0240
        L_0x01ff:
            int r3 = r3 * 53
            long r4 = defpackage.C0285oB.m(r11, r6)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
            goto L_0x0240
        L_0x020a:
            int r3 = r3 * 53
            int r4 = defpackage.C0285oB.l(r11, r6)
            goto L_0x0240
        L_0x0211:
            int r3 = r3 * 53
            long r4 = defpackage.C0285oB.m(r11, r6)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
            goto L_0x0240
        L_0x021c:
            int r3 = r3 * 53
            long r4 = defpackage.C0285oB.m(r11, r6)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
            goto L_0x0240
        L_0x0227:
            int r3 = r3 * 53
            float r4 = defpackage.C0285oB.k(r11, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            goto L_0x0240
        L_0x0232:
            int r3 = r3 * 53
            double r4 = defpackage.C0285oB.j(r11, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            int r4 = androidx.datastore.preferences.protobuf.p.a(r4)
        L_0x0240:
            int r4 = r4 + r3
            r3 = r4
        L_0x0242:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x0246:
            int r3 = r3 * 53
            androidx.datastore.preferences.protobuf.K<?, ?> r0 = r10.f1896a
            androidx.datastore.preferences.protobuf.L r0 = r0.g(r11)
            int r0 = r0.hashCode()
            int r0 = r0 + r3
            boolean r1 = r10.f1900a
            if (r1 == 0) goto L_0x0264
            int r0 = r0 * 53
            androidx.datastore.preferences.protobuf.j<?> r1 = r10.f1897a
            androidx.datastore.preferences.protobuf.l r11 = r1.c(r11)
            int r11 = r11.hashCode()
            int r0 = r0 + r11
        L_0x0264:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C.hashCode(java.lang.Object):int");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x02f6, code lost:
        r2 = defpackage.C1058d.q(r4, r3, r5, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int i(T r11) {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
            r2 = r1
        L_0x0003:
            int[] r3 = r10.f1901a
            int r4 = r3.length
            if (r1 >= r4) goto L_0x04c3
            int r4 = r10.C(r1)
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r5 = r5 & r4
            int r5 = r5 >>> 20
            r6 = r3[r1]
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            long r8 = (long) r4
            fc r4 = defpackage.C0194fc.DOUBLE_LIST_PACKED
            int r4 = r4.a()
            if (r5 < r4) goto L_0x002e
            fc r4 = defpackage.C0194fc.SINT64_LIST_PACKED
            int r4 = r4.a()
            if (r5 > r4) goto L_0x002e
            int r4 = r1 + 2
            r3 = r3[r4]
            r3 = r3 & r7
            goto L_0x002f
        L_0x002e:
            r3 = r0
        L_0x002f:
            boolean r4 = r10.f1907d
            sun.misc.Unsafe r7 = a
            switch(r5) {
                case 0: goto L_0x04b4;
                case 1: goto L_0x04a9;
                case 2: goto L_0x049a;
                case 3: goto L_0x048b;
                case 4: goto L_0x047c;
                case 5: goto L_0x0471;
                case 6: goto L_0x0466;
                case 7: goto L_0x045b;
                case 8: goto L_0x043e;
                case 9: goto L_0x042a;
                case 10: goto L_0x0418;
                case 11: goto L_0x0408;
                case 12: goto L_0x03f8;
                case 13: goto L_0x03ec;
                case 14: goto L_0x03e0;
                case 15: goto L_0x03d0;
                case 16: goto L_0x03c0;
                case 17: goto L_0x03aa;
                case 18: goto L_0x03a0;
                case 19: goto L_0x0396;
                case 20: goto L_0x038c;
                case 21: goto L_0x0382;
                case 22: goto L_0x0378;
                case 23: goto L_0x036e;
                case 24: goto L_0x0364;
                case 25: goto L_0x035a;
                case 26: goto L_0x0350;
                case 27: goto L_0x0342;
                case 28: goto L_0x0338;
                case 29: goto L_0x032e;
                case 30: goto L_0x0324;
                case 31: goto L_0x031a;
                case 32: goto L_0x0310;
                case 33: goto L_0x0306;
                case 34: goto L_0x02fc;
                case 35: goto L_0x02dc;
                case 36: goto L_0x02c1;
                case 37: goto L_0x02a6;
                case 38: goto L_0x028b;
                case 39: goto L_0x0270;
                case 40: goto L_0x0254;
                case 41: goto L_0x0238;
                case 42: goto L_0x021c;
                case 43: goto L_0x0200;
                case 44: goto L_0x01e4;
                case 45: goto L_0x01c8;
                case 46: goto L_0x01ac;
                case 47: goto L_0x0190;
                case 48: goto L_0x0174;
                case 49: goto L_0x0166;
                case 50: goto L_0x0156;
                case 51: goto L_0x014a;
                case 52: goto L_0x013e;
                case 53: goto L_0x012e;
                case 54: goto L_0x011e;
                case 55: goto L_0x010e;
                case 56: goto L_0x0102;
                case 57: goto L_0x00f6;
                case 58: goto L_0x00ea;
                case 59: goto L_0x00cc;
                case 60: goto L_0x00b8;
                case 61: goto L_0x00a6;
                case 62: goto L_0x0096;
                case 63: goto L_0x0086;
                case 64: goto L_0x007a;
                case 65: goto L_0x006e;
                case 66: goto L_0x005e;
                case 67: goto L_0x004e;
                case 68: goto L_0x0038;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x04bf
        L_0x0038:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            java.lang.Object r3 = defpackage.C0285oB.n(r11, r8)
            androidx.datastore.preferences.protobuf.A r3 = (androidx.datastore.preferences.protobuf.A) r3
            kv r4 = r10.g(r1)
            int r3 = defpackage.s5.k(r6, r3, r4)
            goto L_0x04be
        L_0x004e:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            long r3 = t(r11, r8)
            int r3 = defpackage.s5.s(r6, r3)
            goto L_0x04be
        L_0x005e:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = s(r11, r8)
            int r3 = defpackage.s5.r(r6, r3)
            goto L_0x04be
        L_0x006e:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.q(r6)
            goto L_0x04be
        L_0x007a:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.p(r6)
            goto L_0x04be
        L_0x0086:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = s(r11, r8)
            int r3 = defpackage.s5.g(r6, r3)
            goto L_0x04be
        L_0x0096:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = s(r11, r8)
            int r3 = defpackage.s5.w(r6, r3)
            goto L_0x04be
        L_0x00a6:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            java.lang.Object r3 = defpackage.C0285oB.n(r11, r8)
            x3 r3 = (defpackage.x3) r3
            int r3 = defpackage.s5.e(r6, r3)
            goto L_0x04be
        L_0x00b8:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            java.lang.Object r3 = defpackage.C0285oB.n(r11, r8)
            kv r4 = r10.g(r1)
            int r3 = androidx.datastore.preferences.protobuf.H.o(r6, r4, r3)
            goto L_0x04be
        L_0x00cc:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            java.lang.Object r3 = defpackage.C0285oB.n(r11, r8)
            boolean r4 = r3 instanceof defpackage.x3
            if (r4 == 0) goto L_0x00e2
            x3 r3 = (defpackage.x3) r3
            int r3 = defpackage.s5.e(r6, r3)
            goto L_0x04be
        L_0x00e2:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = defpackage.s5.t(r6, r3)
            goto L_0x04be
        L_0x00ea:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.d(r6)
            goto L_0x04be
        L_0x00f6:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.h(r6)
            goto L_0x04be
        L_0x0102:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.i(r6)
            goto L_0x04be
        L_0x010e:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = s(r11, r8)
            int r3 = defpackage.s5.l(r6, r3)
            goto L_0x04be
        L_0x011e:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            long r3 = t(r11, r8)
            int r3 = defpackage.s5.y(r6, r3)
            goto L_0x04be
        L_0x012e:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            long r3 = t(r11, r8)
            int r3 = defpackage.s5.n(r6, r3)
            goto L_0x04be
        L_0x013e:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.j(r6)
            goto L_0x04be
        L_0x014a:
            boolean r3 = r10.k(r11, r6, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.f(r6)
            goto L_0x04be
        L_0x0156:
            java.lang.Object r3 = defpackage.C0285oB.n(r11, r8)
            java.lang.Object r4 = r10.f(r1)
            androidx.datastore.preferences.protobuf.y r5 = r10.f1899a
            int r3 = r5.getSerializedSize(r6, r3, r4)
            goto L_0x04be
        L_0x0166:
            java.util.List r3 = l(r11, r8)
            kv r4 = r10.g(r1)
            int r3 = androidx.datastore.preferences.protobuf.H.j(r6, r3, r4)
            goto L_0x04be
        L_0x0174:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.t(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x0186
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x0186:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x0190:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.r(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x01a2
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x01a2:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x01ac:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.i(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x01be
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x01be:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x01c8:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.g(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x01da
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x01da:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x01e4:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.e(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x01f6
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x01f6:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x0200:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.w(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x0212
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x0212:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x021c:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.b(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x022e
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x022e:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x0238:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.g(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x024a
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x024a:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x0254:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.i(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x0266
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x0266:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x0270:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.l(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x0282
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x0282:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x028b:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.y(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x029d
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x029d:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x02a6:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.n(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x02b8
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x02b8:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x02c1:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.g(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x02d3
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x02d3:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
            goto L_0x02f6
        L_0x02dc:
            java.lang.Object r5 = r7.getObject(r11, r8)
            java.util.List r5 = (java.util.List) r5
            int r5 = androidx.datastore.preferences.protobuf.H.i(r5)
            if (r5 <= 0) goto L_0x04bf
            if (r4 == 0) goto L_0x02ee
            long r3 = (long) r3
            r7.putInt(r11, r3, r5)
        L_0x02ee:
            int r3 = defpackage.s5.v(r6)
            int r4 = defpackage.s5.x(r5)
        L_0x02f6:
            int r2 = defpackage.C1058d.q(r4, r3, r5, r2)
            goto L_0x04bf
        L_0x02fc:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.s(r6, r3)
            goto L_0x04be
        L_0x0306:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.q(r6, r3)
            goto L_0x04be
        L_0x0310:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.h(r6, r3)
            goto L_0x04be
        L_0x031a:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.f(r6, r3)
            goto L_0x04be
        L_0x0324:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.d(r6, r3)
            goto L_0x04be
        L_0x032e:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.v(r6, r3)
            goto L_0x04be
        L_0x0338:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.c(r6, r3)
            goto L_0x04be
        L_0x0342:
            java.util.List r3 = l(r11, r8)
            kv r4 = r10.g(r1)
            int r3 = androidx.datastore.preferences.protobuf.H.p(r6, r3, r4)
            goto L_0x04be
        L_0x0350:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.u(r6, r3)
            goto L_0x04be
        L_0x035a:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.a(r6, r3)
            goto L_0x04be
        L_0x0364:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.f(r6, r3)
            goto L_0x04be
        L_0x036e:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.h(r6, r3)
            goto L_0x04be
        L_0x0378:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.k(r6, r3)
            goto L_0x04be
        L_0x0382:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.x(r6, r3)
            goto L_0x04be
        L_0x038c:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.m(r6, r3)
            goto L_0x04be
        L_0x0396:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.f(r6, r3)
            goto L_0x04be
        L_0x03a0:
            java.util.List r3 = l(r11, r8)
            int r3 = androidx.datastore.preferences.protobuf.H.h(r6, r3)
            goto L_0x04be
        L_0x03aa:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            java.lang.Object r3 = defpackage.C0285oB.n(r11, r8)
            androidx.datastore.preferences.protobuf.A r3 = (androidx.datastore.preferences.protobuf.A) r3
            kv r4 = r10.g(r1)
            int r3 = defpackage.s5.k(r6, r3, r4)
            goto L_0x04be
        L_0x03c0:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            long r3 = defpackage.C0285oB.m(r11, r8)
            int r3 = defpackage.s5.s(r6, r3)
            goto L_0x04be
        L_0x03d0:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.C0285oB.l(r11, r8)
            int r3 = defpackage.s5.r(r6, r3)
            goto L_0x04be
        L_0x03e0:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.q(r6)
            goto L_0x04be
        L_0x03ec:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.p(r6)
            goto L_0x04be
        L_0x03f8:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.C0285oB.l(r11, r8)
            int r3 = defpackage.s5.g(r6, r3)
            goto L_0x04be
        L_0x0408:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.C0285oB.l(r11, r8)
            int r3 = defpackage.s5.w(r6, r3)
            goto L_0x04be
        L_0x0418:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            java.lang.Object r3 = defpackage.C0285oB.n(r11, r8)
            x3 r3 = (defpackage.x3) r3
            int r3 = defpackage.s5.e(r6, r3)
            goto L_0x04be
        L_0x042a:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            java.lang.Object r3 = defpackage.C0285oB.n(r11, r8)
            kv r4 = r10.g(r1)
            int r3 = androidx.datastore.preferences.protobuf.H.o(r6, r4, r3)
            goto L_0x04be
        L_0x043e:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            java.lang.Object r3 = defpackage.C0285oB.n(r11, r8)
            boolean r4 = r3 instanceof defpackage.x3
            if (r4 == 0) goto L_0x0454
            x3 r3 = (defpackage.x3) r3
            int r3 = defpackage.s5.e(r6, r3)
            goto L_0x04be
        L_0x0454:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = defpackage.s5.t(r6, r3)
            goto L_0x04be
        L_0x045b:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.d(r6)
            goto L_0x04be
        L_0x0466:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.h(r6)
            goto L_0x04be
        L_0x0471:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.i(r6)
            goto L_0x04be
        L_0x047c:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.C0285oB.l(r11, r8)
            int r3 = defpackage.s5.l(r6, r3)
            goto L_0x04be
        L_0x048b:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            long r3 = defpackage.C0285oB.m(r11, r8)
            int r3 = defpackage.s5.y(r6, r3)
            goto L_0x04be
        L_0x049a:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            long r3 = defpackage.C0285oB.m(r11, r8)
            int r3 = defpackage.s5.n(r6, r3)
            goto L_0x04be
        L_0x04a9:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.j(r6)
            goto L_0x04be
        L_0x04b4:
            boolean r3 = r10.j(r11, r1)
            if (r3 == 0) goto L_0x04bf
            int r3 = defpackage.s5.f(r6)
        L_0x04be:
            int r2 = r2 + r3
        L_0x04bf:
            int r1 = r1 + 3
            goto L_0x0003
        L_0x04c3:
            androidx.datastore.preferences.protobuf.K<?, ?> r0 = r10.f1896a
            androidx.datastore.preferences.protobuf.L r11 = r0.g(r11)
            int r11 = r0.h(r11)
            int r11 = r11 + r2
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C.i(java.lang.Object):int");
    }

    public final boolean isInitialized(T t) {
        int i;
        boolean z;
        boolean z2;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            boolean z3 = true;
            if (i3 < this.f1905c) {
                int i5 = this.f1904b[i3];
                int[] iArr = this.f1901a;
                int i6 = iArr[i5];
                int C = C(i5);
                boolean z4 = this.f1906c;
                if (!z4) {
                    int i7 = iArr[i5 + 2];
                    int i8 = i7 & 1048575;
                    i = 1 << (i7 >>> 20);
                    if (i8 != i2) {
                        i4 = a.getInt(t, (long) i8);
                        i2 = i8;
                    }
                } else {
                    i = 0;
                }
                if ((268435456 & C) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (z4) {
                        z2 = j(t, i5);
                    } else if ((i4 & i) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        return false;
                    }
                }
                int i9 = (267386880 & C) >>> 20;
                if (i9 == 9 || i9 == 17) {
                    if (z4) {
                        z3 = j(t, i5);
                    } else if ((i & i4) == 0) {
                        z3 = false;
                    }
                    if (z3 && !g(i5).isInitialized(C0285oB.n(t, (long) (C & 1048575)))) {
                        return false;
                    }
                } else {
                    if (i9 != 27) {
                        if (i9 == 60 || i9 == 68) {
                            if (k(t, i6, i5) && !g(i5).isInitialized(C0285oB.n(t, (long) (C & 1048575)))) {
                                return false;
                            }
                        } else if (i9 != 49) {
                            if (i9 != 50) {
                                continue;
                            } else {
                                Object n = C0285oB.n(t, (long) (C & 1048575));
                                y yVar = this.f1899a;
                                x b2 = yVar.b(n);
                                if (!b2.isEmpty() && yVar.e(f(i5)).b.f232a == HD.MESSAGE) {
                                    Iterator it = b2.values().iterator();
                                    kv<?> kvVar = null;
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (kvVar == null) {
                                            kvVar = Mq.a.a(next.getClass());
                                        }
                                        if (!kvVar.isInitialized(next)) {
                                            z3 = false;
                                            break;
                                        }
                                    }
                                }
                                if (!z3) {
                                    return false;
                                }
                            }
                        }
                    }
                    List list = (List) C0285oB.n(t, (long) (C & 1048575));
                    if (!list.isEmpty()) {
                        kv g = g(i5);
                        int i10 = 0;
                        while (true) {
                            if (i10 >= list.size()) {
                                break;
                            } else if (!g.isInitialized(list.get(i10))) {
                                z3 = false;
                                break;
                            } else {
                                i10++;
                            }
                        }
                    }
                    if (!z3) {
                        return false;
                    }
                }
                i3++;
            } else if (!this.f1900a || this.f1897a.c(t).i()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public final boolean j(T t, int i) {
        boolean equals;
        if (this.f1906c) {
            int C = C(i);
            long j = (long) (C & 1048575);
            switch ((C & 267386880) >>> 20) {
                case 0:
                    if (C0285oB.j(t, j) != 0.0d) {
                        return true;
                    }
                    return false;
                case 1:
                    if (C0285oB.k(t, j) != 0.0f) {
                        return true;
                    }
                    return false;
                case 2:
                    if (C0285oB.m(t, j) != 0) {
                        return true;
                    }
                    return false;
                case 3:
                    if (C0285oB.m(t, j) != 0) {
                        return true;
                    }
                    return false;
                case 4:
                    if (C0285oB.l(t, j) != 0) {
                        return true;
                    }
                    return false;
                case 5:
                    if (C0285oB.m(t, j) != 0) {
                        return true;
                    }
                    return false;
                case 6:
                    if (C0285oB.l(t, j) != 0) {
                        return true;
                    }
                    return false;
                case 7:
                    return C0285oB.f(t, j);
                case 8:
                    Object n = C0285oB.n(t, j);
                    if (n instanceof String) {
                        equals = ((String) n).isEmpty();
                        break;
                    } else if (n instanceof x3) {
                        equals = x3.f3407a.equals(n);
                        break;
                    } else {
                        throw new IllegalArgumentException();
                    }
                case 9:
                    if (C0285oB.n(t, j) != null) {
                        return true;
                    }
                    return false;
                case 10:
                    equals = x3.f3407a.equals(C0285oB.n(t, j));
                    break;
                case 11:
                    if (C0285oB.l(t, j) != 0) {
                        return true;
                    }
                    return false;
                case 12:
                    if (C0285oB.l(t, j) != 0) {
                        return true;
                    }
                    return false;
                case 13:
                    if (C0285oB.l(t, j) != 0) {
                        return true;
                    }
                    return false;
                case 14:
                    if (C0285oB.m(t, j) != 0) {
                        return true;
                    }
                    return false;
                case 15:
                    if (C0285oB.l(t, j) != 0) {
                        return true;
                    }
                    return false;
                case 16:
                    if (C0285oB.m(t, j) != 0) {
                        return true;
                    }
                    return false;
                case 17:
                    if (C0285oB.n(t, j) != null) {
                        return true;
                    }
                    return false;
                default:
                    throw new IllegalArgumentException();
            }
            return !equals;
        }
        int i2 = this.f1901a[i + 2];
        if ((C0285oB.l(t, (long) (i2 & 1048575)) & (1 << (i2 >>> 20))) != 0) {
            return true;
        }
        return false;
    }

    public final boolean k(T t, int i, int i2) {
        if (C0285oB.l(t, (long) (this.f1901a[i2 + 2] & 1048575)) == i) {
            return true;
        }
        return false;
    }

    public final <K, V> void m(Object obj, int i, Object obj2, C0132i iVar, G g) throws IOException {
        long C = (long) (C(i) & 1048575);
        Object n = C0285oB.n(obj, C);
        y yVar = this.f1899a;
        if (n == null) {
            n = yVar.c();
            C0285oB.u(obj, C, n);
        } else if (yVar.isImmutable(n)) {
            x c2 = yVar.c();
            yVar.d(c2, n);
            C0285oB.u(obj, C, c2);
            n = c2;
        }
        g.a(yVar.a(n), yVar.e(obj2), iVar);
    }

    public final void makeImmutable(T t) {
        int[] iArr;
        int i;
        int i2 = this.f1905c;
        while (true) {
            iArr = this.f1904b;
            i = this.d;
            if (i2 >= i) {
                break;
            }
            long C = (long) (C(iArr[i2]) & 1048575);
            Object n = C0285oB.n(t, C);
            if (n != null) {
                C0285oB.u(t, C, this.f1899a.toImmutable(n));
            }
            i2++;
        }
        int length = iArr.length;
        while (i < length) {
            this.f1898a.a(t, (long) iArr[i]);
            i++;
        }
        this.f1896a.j(t);
        if (this.f1900a) {
            this.f1897a.f(t);
        }
    }

    public final void mergeFrom(T t, T t2) {
        t2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.f1901a;
            if (i < iArr.length) {
                int C = C(i);
                long j = (long) (1048575 & C);
                int i2 = iArr[i];
                switch ((C & 267386880) >>> 20) {
                    case 0:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.f3140a.m(t, j, C0285oB.j(t2, j));
                            A(t, i);
                            break;
                        }
                    case 1:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.f3140a.n(t, j, C0285oB.k(t2, j));
                            A(t, i);
                            break;
                        }
                    case 2:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.t(t, j, C0285oB.m(t2, j));
                            A(t, i);
                            break;
                        }
                    case 3:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.t(t, j, C0285oB.m(t2, j));
                            A(t, i);
                            break;
                        }
                    case 4:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.s(t, j, C0285oB.l(t2, j));
                            A(t, i);
                            break;
                        }
                    case 5:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.t(t, j, C0285oB.m(t2, j));
                            A(t, i);
                            break;
                        }
                    case 6:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.s(t, j, C0285oB.l(t2, j));
                            A(t, i);
                            break;
                        }
                    case 7:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.f3140a.k(t, j, C0285oB.f(t2, j));
                            A(t, i);
                            break;
                        }
                    case 8:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.u(t, j, C0285oB.n(t2, j));
                            A(t, i);
                            break;
                        }
                    case 9:
                        n(t, t2, i);
                        break;
                    case 10:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.u(t, j, C0285oB.n(t2, j));
                            A(t, i);
                            break;
                        }
                    case 11:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.s(t, j, C0285oB.l(t2, j));
                            A(t, i);
                            break;
                        }
                    case 12:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.s(t, j, C0285oB.l(t2, j));
                            A(t, i);
                            break;
                        }
                    case 13:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.s(t, j, C0285oB.l(t2, j));
                            A(t, i);
                            break;
                        }
                    case 14:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.t(t, j, C0285oB.m(t2, j));
                            A(t, i);
                            break;
                        }
                    case 15:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.s(t, j, C0285oB.l(t2, j));
                            A(t, i);
                            break;
                        }
                    case 16:
                        if (!j(t2, i)) {
                            break;
                        } else {
                            C0285oB.t(t, j, C0285oB.m(t2, j));
                            A(t, i);
                            break;
                        }
                    case 17:
                        n(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.f1898a.b(t, t2, j);
                        break;
                    case 50:
                        Class<?> cls = H.f1913a;
                        C0285oB.u(t, j, this.f1899a.d(C0285oB.n(t, j), C0285oB.n(t2, j)));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!k(t2, i2, i)) {
                            break;
                        } else {
                            C0285oB.u(t, j, C0285oB.n(t2, j));
                            B(t, i2, i);
                            break;
                        }
                    case 60:
                        o(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!k(t2, i2, i)) {
                            break;
                        } else {
                            C0285oB.u(t, j, C0285oB.n(t2, j));
                            B(t, i2, i);
                            break;
                        }
                    case 68:
                        o(t, t2, i);
                        break;
                }
                i += 3;
            } else if (!this.f1906c) {
                Class<?> cls2 = H.f1913a;
                K<?, ?> k = this.f1896a;
                k.o(t, k.k(k.g(t), k.g(t2)));
                if (this.f1900a) {
                    H.B(this.f1897a, t, t2);
                    return;
                }
                return;
            } else {
                return;
            }
        }
    }

    public final void n(T t, T t2, int i) {
        long C = (long) (C(i) & 1048575);
        if (j(t2, i)) {
            Object n = C0285oB.n(t, C);
            Object n2 = C0285oB.n(t2, C);
            if (n != null && n2 != null) {
                C0285oB.u(t, C, p.b(n, n2));
                A(t, i);
            } else if (n2 != null) {
                C0285oB.u(t, C, n2);
                A(t, i);
            }
        }
    }

    public final T newInstance() {
        return this.f1894a.a(this.f1895a);
    }

    public final void o(T t, T t2, int i) {
        int C = C(i);
        int i2 = this.f1901a[i];
        long j = (long) (C & 1048575);
        if (k(t2, i2, i)) {
            Object n = C0285oB.n(t, j);
            Object n2 = C0285oB.n(t2, j);
            if (n != null && n2 != null) {
                C0285oB.u(t, j, p.b(n, n2));
                B(t, i2, i);
            } else if (n2 != null) {
                C0285oB.u(t, j, n2);
                B(t, i2, i);
            }
        }
    }

    public final int u(int i) {
        if (i < this.f1893a || i > this.b) {
            return -1;
        }
        int[] iArr = this.f1901a;
        int length = (iArr.length / 3) - 1;
        int i2 = 0;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    public final <E> void v(Object obj, long j, G g, kv<E> kvVar, C0132i iVar) throws IOException {
        g.f(this.f1898a.c(obj, j), kvVar, iVar);
    }

    public final <E> void w(Object obj, int i, G g, kv<E> kvVar, C0132i iVar) throws IOException {
        g.d(this.f1898a.c(obj, (long) (i & 1048575)), kvVar, iVar);
    }

    public final void x(Object obj, int i, G g) throws IOException {
        boolean z;
        if ((536870912 & i) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            C0285oB.u(obj, (long) (i & 1048575), g.readStringRequireUtf8());
        } else if (this.f1903b) {
            C0285oB.u(obj, (long) (i & 1048575), g.readString());
        } else {
            C0285oB.u(obj, (long) (i & 1048575), g.b());
        }
    }

    public final void y(Object obj, int i, G g) throws IOException {
        boolean z;
        if ((536870912 & i) != 0) {
            z = true;
        } else {
            z = false;
        }
        u uVar = this.f1898a;
        if (z) {
            g.readStringListRequireUtf8(uVar.c(obj, (long) (i & 1048575)));
        } else {
            g.readStringList(uVar.c(obj, (long) (i & 1048575)));
        }
    }
}
