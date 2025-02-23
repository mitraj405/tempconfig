package defpackage;

import kotlin.jvm.internal.a;
import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* renamed from: Kq  reason: default package and case insensitive filesystem */
/* compiled from: PropertyReference */
public abstract class C0570Kq extends a implements KProperty {
    private final boolean syntheticJavaProperty;

    public C0570Kq() {
        this.syntheticJavaProperty = false;
    }

    public KCallable compute() {
        if (this.syntheticJavaProperty) {
            return this;
        }
        return super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0570Kq) {
            C0570Kq kq = (C0570Kq) obj;
            if (!getOwner().equals(kq.getOwner()) || !getName().equals(kq.getName()) || !getSignature().equals(kq.getSignature()) || !C1177ig.a(getBoundReceiver(), kq.getBoundReceiver())) {
                return false;
            }
            return true;
        } else if (obj instanceof KProperty) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        int hashCode = getName().hashCode();
        return getSignature().hashCode() + ((hashCode + (getOwner().hashCode() * 31)) * 31);
    }

    public boolean isConst() {
        return getReflected().isConst();
    }

    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        KCallable compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    public KProperty getReflected() {
        if (!this.syntheticJavaProperty) {
            return (KProperty) super.getReflected();
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties");
    }

    public C0570Kq(Object obj) {
        super(obj);
        this.syntheticJavaProperty = false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0570Kq(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        boolean z = false;
        this.syntheticJavaProperty = (i & 2) == 2 ? true : z;
    }
}
