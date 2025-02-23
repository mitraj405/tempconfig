package defpackage;

import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;

/* renamed from: ny  reason: default package and case insensitive filesystem */
/* compiled from: Strings.kt */
public final class C1292ny extends C0595Mh implements Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {
    public final /* synthetic */ List<String> a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ boolean f5607a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1292ny(List<String> list, boolean z) {
        super(2);
        this.a = list;
        this.f5607a = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.Object r11, java.lang.Object r12) {
        /*
            r10 = this;
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            java.lang.String r0 = "$this$$receiver"
            defpackage.C1177ig.f(r11, r0)
            java.util.List<java.lang.String> r0 = r10.a
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r1 = r10.f5607a
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x007e
            int r4 = r0.size()
            r5 = 1
            if (r4 != r5) goto L_0x007e
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.List
            if (r1 == 0) goto L_0x0043
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            if (r1 == 0) goto L_0x003b
            if (r1 != r5) goto L_0x0033
            java.lang.Object r0 = r0.get(r3)
            goto L_0x0058
        L_0x0033:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "List has more than one element."
            r11.<init>(r12)
            throw r11
        L_0x003b:
            java.util.NoSuchElementException r11 = new java.util.NoSuchElementException
            java.lang.String r12 = "List is empty."
            r11.<init>(r12)
            throw r11
        L_0x0043:
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0076
            java.lang.Object r1 = r0.next()
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x006e
            r0 = r1
        L_0x0058:
            java.lang.String r0 = (java.lang.String) r0
            r1 = 4
            int r11 = defpackage.C1337py.Y0(r11, r0, r12, r3, r1)
            if (r11 >= 0) goto L_0x0063
            goto L_0x0109
        L_0x0063:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            kotlin.Pair r12 = new kotlin.Pair
            r12.<init>(r11, r0)
            goto L_0x010a
        L_0x006e:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException
            java.lang.String r12 = "Collection has more than one element."
            r11.<init>(r12)
            throw r11
        L_0x0076:
            java.util.NoSuchElementException r11 = new java.util.NoSuchElementException
            java.lang.String r12 = "Collection is empty."
            r11.<init>(r12)
            throw r11
        L_0x007e:
            fg r4 = new fg
            if (r12 >= 0) goto L_0x0083
            r12 = r3
        L_0x0083:
            int r3 = r11.length()
            r4.<init>(r12, r3)
            boolean r3 = r11 instanceof java.lang.String
            int r5 = r4.e
            int r4 = r4.d
            if (r3 == 0) goto L_0x00cf
            if (r5 <= 0) goto L_0x0096
            if (r12 <= r4) goto L_0x009a
        L_0x0096:
            if (r5 >= 0) goto L_0x0109
            if (r4 > r12) goto L_0x0109
        L_0x009a:
            r3 = r0
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x00a1:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00bc
            java.lang.Object r6 = r3.next()
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            r8 = r11
            java.lang.String r8 = (java.lang.String) r8
            int r9 = r7.length()
            boolean r7 = defpackage.C1268my.S0(r12, r9, r7, r8, r1)
            if (r7 == 0) goto L_0x00a1
            goto L_0x00bd
        L_0x00bc:
            r6 = r2
        L_0x00bd:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x00cb
            java.lang.Integer r11 = java.lang.Integer.valueOf(r12)
            kotlin.Pair r12 = new kotlin.Pair
            r12.<init>(r11, r6)
            goto L_0x010a
        L_0x00cb:
            if (r12 == r4) goto L_0x0109
            int r12 = r12 + r5
            goto L_0x009a
        L_0x00cf:
            if (r5 <= 0) goto L_0x00d3
            if (r12 <= r4) goto L_0x00d7
        L_0x00d3:
            if (r5 >= 0) goto L_0x0109
            if (r4 > r12) goto L_0x0109
        L_0x00d7:
            r3 = r0
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x00de:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L_0x00f6
            java.lang.Object r6 = r3.next()
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            int r8 = r7.length()
            boolean r7 = defpackage.C1337py.Z0(r7, r11, r12, r8, r1)
            if (r7 == 0) goto L_0x00de
            goto L_0x00f7
        L_0x00f6:
            r6 = r2
        L_0x00f7:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0105
            java.lang.Integer r11 = java.lang.Integer.valueOf(r12)
            kotlin.Pair r12 = new kotlin.Pair
            r12.<init>(r11, r6)
            goto L_0x010a
        L_0x0105:
            if (r12 == r4) goto L_0x0109
            int r12 = r12 + r5
            goto L_0x00d7
        L_0x0109:
            r12 = r2
        L_0x010a:
            if (r12 == 0) goto L_0x011f
            B r11 = r12.b
            java.lang.String r11 = (java.lang.String) r11
            int r11 = r11.length()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            kotlin.Pair r2 = new kotlin.Pair
            A r12 = r12.a
            r2.<init>(r12, r11)
        L_0x011f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1292ny.invoke(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
