package defpackage;

import kotlin.jvm.internal.a;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* renamed from: ce  reason: default package and case insensitive filesystem */
/* compiled from: FunctionReference */
public class C0821ce extends a implements C0801be, KFunction {
    private final int arity;
    private final int flags;

    public C0821ce(int i) {
        this(i, a.NO_RECEIVER, (Class) null, (String) null, (String) null, 0);
    }

    public KCallable computeReflected() {
        C0584Ls.a.getClass();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0821ce) {
            C0821ce ceVar = (C0821ce) obj;
            if (!getName().equals(ceVar.getName()) || !getSignature().equals(ceVar.getSignature()) || this.flags != ceVar.flags || this.arity != ceVar.arity || !C1177ig.a(getBoundReceiver(), ceVar.getBoundReceiver()) || !C1177ig.a(getOwner(), ceVar.getOwner())) {
                return false;
            }
            return true;
        } else if (obj instanceof KFunction) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        int i;
        if (getOwner() == null) {
            i = 0;
        } else {
            i = getOwner().hashCode() * 31;
        }
        return getSignature().hashCode() + ((getName().hashCode() + i) * 31);
    }

    public boolean isExternal() {
        return getReflected().isExternal();
    }

    public boolean isInfix() {
        return getReflected().isInfix();
    }

    public boolean isInline() {
        return getReflected().isInline();
    }

    public boolean isOperator() {
        return getReflected().isOperator();
    }

    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        KCallable compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public C0821ce(int i, Object obj) {
        this(i, obj, (Class) null, (String) null, (String) null, 0);
    }

    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C0821ce(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }
}
