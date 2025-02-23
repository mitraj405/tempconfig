package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.k;

/* renamed from: Mg  reason: default package */
/* compiled from: JobSupport.kt */
public class Mg extends k {
    public final boolean a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Mg(Job job) {
        super(true);
        C0796b5 b5Var;
        C0796b5 b5Var2;
        boolean z = true;
        V(job);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = k.b;
        C0778a5 a5Var = (C0778a5) atomicReferenceFieldUpdater.get(this);
        if (a5Var instanceof C0796b5) {
            b5Var = (C0796b5) a5Var;
        } else {
            b5Var = null;
        }
        if (b5Var != null) {
            k m = b5Var.m();
            while (true) {
                if (!m.N()) {
                    C0778a5 a5Var2 = (C0778a5) atomicReferenceFieldUpdater.get(m);
                    if (a5Var2 instanceof C0796b5) {
                        b5Var2 = (C0796b5) a5Var2;
                    } else {
                        b5Var2 = null;
                    }
                    if (b5Var2 == null) {
                        break;
                    }
                    m = b5Var2.m();
                } else {
                    break;
                }
            }
        }
        z = false;
        this.a = z;
    }

    public final boolean N() {
        return this.a;
    }

    public final boolean P() {
        return true;
    }
}
