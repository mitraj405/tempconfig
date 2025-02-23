package kotlin.random;

import com.google.firebase.messaging.Constants;
import java.io.Serializable;

/* compiled from: Random.kt */
public abstract class Random {
    public static final a a = new a(0);

    /* renamed from: a  reason: collision with other field name */
    public static final Random f5559a = Bp.a.b();

    /* compiled from: Random.kt */
    public static final class a extends Random implements Serializable {

        /* renamed from: kotlin.random.Random$a$a  reason: collision with other inner class name */
        /* compiled from: Random.kt */
        public static final class C0075a implements Serializable {
            public static final C0075a a = new C0075a();
            private static final long serialVersionUID = 0;

            private final Object readResolve() {
                return Random.a;
            }
        }

        public a(int i) {
        }

        private final Object writeReplace() {
            return C0075a.a;
        }

        public final int a(int i) {
            return Random.f5559a.a(i);
        }

        public final int b() {
            return Random.f5559a.b();
        }

        public final int c(int i) {
            return Random.f5559a.c(i);
        }

        public final int d(int i) {
            return Random.f5559a.d(i);
        }
    }

    public abstract int a(int i);

    public int b() {
        return a(32);
    }

    public int c(int i) {
        return d(i);
    }

    public int d(int i) {
        boolean z;
        int i2;
        int b;
        int i3;
        int b2;
        boolean z2;
        if (i > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            int i4 = i + 0;
            if (i4 > 0 || i4 == Integer.MIN_VALUE) {
                if (((-i4) & i4) == i4) {
                    i2 = a(31 - Integer.numberOfLeadingZeros(i4));
                } else {
                    do {
                        b = b() >>> 1;
                        i3 = b % i4;
                    } while ((i4 - 1) + (b - i3) < 0);
                    i2 = i3;
                }
                return 0 + i2;
            }
            do {
                b2 = b();
                if (b2 < 0 || b2 >= i) {
                    z2 = false;
                    continue;
                } else {
                    z2 = true;
                    continue;
                }
            } while (!z2);
            return b2;
        }
        Integer valueOf = Integer.valueOf(i);
        C1177ig.f(0, Constants.MessagePayloadKeys.FROM);
        C1177ig.f(valueOf, "until");
        throw new IllegalArgumentException(("Random range is empty: [" + 0 + ", " + valueOf + ").").toString());
    }
}
