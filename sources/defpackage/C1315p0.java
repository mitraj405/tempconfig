package defpackage;

import java.util.Arrays;
import java.util.HashSet;

/* renamed from: p0  reason: default package and case insensitive filesystem */
/* compiled from: AlgorithmConstraints */
public final class C1315p0 {
    public static final C1315p0 a = new C1315p0(4, new String[0]);
    public static final C1315p0 b = new C1315p0(4, "none");

    /* renamed from: a  reason: collision with other field name */
    public final int f6882a;

    /* renamed from: a  reason: collision with other field name */
    public final HashSet f6883a;

    static {
        new C1315p0(3, "none");
    }

    public C1315p0(int i, String... strArr) {
        if (i != 0) {
            this.f6882a = i;
            this.f6883a = new HashSet(Arrays.asList(strArr));
            return;
        }
        throw new NullPointerException("ConstraintType cannot be null");
    }

    public final void a(String str) throws C1240lg {
        int V = xx.V(this.f6882a);
        HashSet hashSet = this.f6883a;
        if (V != 0) {
            if (V != 1) {
                if (V != 2) {
                    if (V != 3) {
                        return;
                    }
                }
            }
            if (hashSet.contains(str)) {
                throw new C1240lg(lf.j("'", str, "' is a blocked algorithm."));
            }
            return;
        }
        if (!hashSet.contains(str)) {
            throw new C1240lg(lf.j("'", str, "' is not a permitted algorithm."));
        }
    }
}
