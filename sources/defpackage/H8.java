package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;

/* renamed from: H8  reason: default package */
/* compiled from: Strings.kt */
public final class H8 implements C0810bw<C1112fg> {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final CharSequence f3606a;

    /* renamed from: a  reason: collision with other field name */
    public final Function2<CharSequence, Integer, Pair<Integer, Integer>> f3607a;
    public final int b;

    /* renamed from: H8$a */
    /* compiled from: Strings.kt */
    public static final class a implements Iterator<C1112fg> {
        public final /* synthetic */ H8 a;

        /* renamed from: a  reason: collision with other field name */
        public C1112fg f3608a;
        public int c = -1;
        public int d;
        public int e;
        public int f;

        public a(H8 h8) {
            this.a = h8;
            int i = h8.a;
            int length = h8.f3606a.length();
            if (length >= 0) {
                if (i < 0) {
                    i = 0;
                } else if (i > length) {
                    i = length;
                }
                this.d = i;
                this.e = i;
                return;
            }
            throw new IllegalArgumentException(C1058d.y("Cannot coerce value to an empty range: maximum ", length, " is less than minimum 0."));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001b, code lost:
            if (r7 < r3) goto L_0x001d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a() {
            /*
                r8 = this;
                int r0 = r8.e
                r1 = 0
                if (r0 >= 0) goto L_0x000c
                r8.c = r1
                r0 = 0
                r8.f3608a = r0
                goto L_0x0081
            L_0x000c:
                H8 r2 = r8.a
                int r3 = r2.b
                r4 = -1
                java.lang.CharSequence r5 = r2.f3606a
                r6 = 1
                if (r3 <= 0) goto L_0x001d
                int r7 = r8.f
                int r7 = r7 + r6
                r8.f = r7
                if (r7 >= r3) goto L_0x0023
            L_0x001d:
                int r3 = r5.length()
                if (r0 <= r3) goto L_0x0033
            L_0x0023:
                fg r0 = new fg
                int r1 = r8.d
                int r2 = defpackage.C1337py.U0(r5)
                r0.<init>(r1, r2)
                r8.f3608a = r0
                r8.e = r4
                goto L_0x007f
            L_0x0033:
                int r0 = r8.e
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                kotlin.jvm.functions.Function2<java.lang.CharSequence, java.lang.Integer, kotlin.Pair<java.lang.Integer, java.lang.Integer>> r2 = r2.f3607a
                java.lang.Object r0 = r2.invoke(r5, r0)
                kotlin.Pair r0 = (kotlin.Pair) r0
                if (r0 != 0) goto L_0x0053
                fg r0 = new fg
                int r1 = r8.d
                int r2 = defpackage.C1337py.U0(r5)
                r0.<init>(r1, r2)
                r8.f3608a = r0
                r8.e = r4
                goto L_0x007f
            L_0x0053:
                A r2 = r0.a
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                B r0 = r0.b
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r3 = r8.d
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r2 > r4) goto L_0x006c
                fg r3 = defpackage.C1112fg.a
                goto L_0x0074
            L_0x006c:
                fg r4 = new fg
                int r5 = r2 + -1
                r4.<init>(r3, r5)
                r3 = r4
            L_0x0074:
                r8.f3608a = r3
                int r2 = r2 + r0
                r8.d = r2
                if (r0 != 0) goto L_0x007c
                r1 = r6
            L_0x007c:
                int r2 = r2 + r1
                r8.e = r2
            L_0x007f:
                r8.c = r6
            L_0x0081:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.H8.a.a():void");
        }

        public final boolean hasNext() {
            if (this.c == -1) {
                a();
            }
            if (this.c == 1) {
                return true;
            }
            return false;
        }

        public final Object next() {
            if (this.c == -1) {
                a();
            }
            if (this.c != 0) {
                C1112fg fgVar = this.f3608a;
                C1177ig.d(fgVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f3608a = null;
                this.c = -1;
                return fgVar;
            }
            throw new NoSuchElementException();
        }

        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public H8(String str, int i, int i2, C1292ny nyVar) {
        this.f3606a = str;
        this.a = i;
        this.b = i2;
        this.f3607a = nyVar;
    }

    public final Iterator<C1112fg> iterator() {
        return new a(this);
    }
}
