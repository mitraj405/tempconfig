package androidx.constraintlayout.core.widgets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class ConstraintAnchor {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public final Type f1338a;

    /* renamed from: a  reason: collision with other field name */
    public ConstraintAnchor f1339a;

    /* renamed from: a  reason: collision with other field name */
    public final ConstraintWidget f1340a;

    /* renamed from: a  reason: collision with other field name */
    public HashSet<ConstraintAnchor> f1341a = null;

    /* renamed from: a  reason: collision with other field name */
    public C0415yx f1342a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1343a;
    public int b = 0;
    public int c = Integer.MIN_VALUE;

    public enum Type {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f1340a = constraintWidget;
        this.f1338a = type;
    }

    public final void a(ConstraintAnchor constraintAnchor, int i) {
        b(constraintAnchor, i, Integer.MIN_VALUE, false);
    }

    public final boolean b(ConstraintAnchor constraintAnchor, int i, int i2, boolean z) {
        if (constraintAnchor == null) {
            j();
            return true;
        } else if (!z && !i(constraintAnchor)) {
            return false;
        } else {
            this.f1339a = constraintAnchor;
            if (constraintAnchor.f1341a == null) {
                constraintAnchor.f1341a = new HashSet<>();
            }
            HashSet<ConstraintAnchor> hashSet = this.f1339a.f1341a;
            if (hashSet != null) {
                hashSet.add(this);
            }
            this.b = i;
            this.c = i2;
            return true;
        }
    }

    public final void c(int i, BD bd, ArrayList arrayList) {
        HashSet<ConstraintAnchor> hashSet = this.f1341a;
        if (hashSet != null) {
            Iterator<ConstraintAnchor> it = hashSet.iterator();
            while (it.hasNext()) {
                C0096He.a(it.next().f1340a, i, arrayList, bd);
            }
        }
    }

    public final int d() {
        if (!this.f1343a) {
            return 0;
        }
        return this.a;
    }

    public final int e() {
        ConstraintAnchor constraintAnchor;
        if (this.f1340a.w == 8) {
            return 0;
        }
        int i = this.c;
        if (i == Integer.MIN_VALUE || (constraintAnchor = this.f1339a) == null || constraintAnchor.f1340a.w != 8) {
            return this.b;
        }
        return i;
    }

    public final ConstraintAnchor f() {
        Type type = this.f1338a;
        int ordinal = type.ordinal();
        ConstraintWidget constraintWidget = this.f1340a;
        switch (ordinal) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return constraintWidget.f1371c;
            case 2:
                return constraintWidget.f1376d;
            case 3:
                return constraintWidget.f1348a;
            case 4:
                return constraintWidget.f1363b;
            default:
                throw new AssertionError(type.name());
        }
    }

    public final boolean g() {
        HashSet<ConstraintAnchor> hashSet = this.f1341a;
        if (hashSet == null) {
            return false;
        }
        Iterator<ConstraintAnchor> it = hashSet.iterator();
        while (it.hasNext()) {
            if (it.next().f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        if (this.f1339a != null) {
            return true;
        }
        return false;
    }

    public final boolean i(ConstraintAnchor constraintAnchor) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (constraintAnchor == null) {
            return false;
        }
        Type type = Type.BASELINE;
        Type type2 = this.f1338a;
        ConstraintWidget constraintWidget = constraintAnchor.f1340a;
        Type type3 = constraintAnchor.f1338a;
        if (type3 != type2) {
            int ordinal = type2.ordinal();
            Type type4 = Type.CENTER_Y;
            Type type5 = Type.RIGHT;
            Type type6 = Type.CENTER_X;
            Type type7 = Type.LEFT;
            switch (ordinal) {
                case 0:
                case 7:
                case 8:
                    return false;
                case 1:
                case 3:
                    if (type3 == type7 || type3 == type5) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!(constraintWidget instanceof e)) {
                        return z;
                    }
                    if (z || type3 == type6) {
                        z3 = true;
                    }
                    return z3;
                case 2:
                case 4:
                    if (type3 == Type.TOP || type3 == Type.BOTTOM) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!(constraintWidget instanceof e)) {
                        return z2;
                    }
                    if (z2 || type3 == type4) {
                        z3 = true;
                    }
                    return z3;
                case 5:
                    if (type3 == type7 || type3 == type5) {
                        return false;
                    }
                    return true;
                case 6:
                    if (type3 == type || type3 == type6 || type3 == type4) {
                        return false;
                    }
                    return true;
                default:
                    throw new AssertionError(type2.name());
            }
        } else if (type2 != type || (constraintWidget.f1388h && this.f1340a.f1388h)) {
            return true;
        } else {
            return false;
        }
    }

    public final void j() {
        HashSet<ConstraintAnchor> hashSet;
        ConstraintAnchor constraintAnchor = this.f1339a;
        if (!(constraintAnchor == null || (hashSet = constraintAnchor.f1341a) == null)) {
            hashSet.remove(this);
            if (this.f1339a.f1341a.size() == 0) {
                this.f1339a.f1341a = null;
            }
        }
        this.f1341a = null;
        this.f1339a = null;
        this.b = 0;
        this.c = Integer.MIN_VALUE;
        this.f1343a = false;
        this.a = 0;
    }

    public final void k() {
        C0415yx yxVar = this.f1342a;
        if (yxVar == null) {
            this.f1342a = new C0415yx(1);
        } else {
            yxVar.h();
        }
    }

    public final void l(int i) {
        this.a = i;
        this.f1343a = true;
    }

    public final String toString() {
        return this.f1340a.f1365b + ":" + this.f1338a.toString();
    }
}
