package defpackage;

import java.util.Iterator;

/* renamed from: c9  reason: default package and case insensitive filesystem */
/* compiled from: DimensionDependency */
public class C0154c9 extends N8 {
    public int e;

    public C0154c9(CD cd) {
        super(cd);
        if (cd instanceof af) {
            this.a = 2;
        } else {
            this.a = 3;
        }
    }

    public final void d(int i) {
        if (!this.f436c) {
            this.f436c = true;
            this.c = i;
            Iterator it = this.f431a.iterator();
            while (it.hasNext()) {
                J8 j8 = (J8) it.next();
                j8.a(j8);
            }
        }
    }
}
