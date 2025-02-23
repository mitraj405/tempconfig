package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: iv  reason: default package and case insensitive filesystem */
/* compiled from: Schedulers */
public final class C1181iv {
    public static final AtomicReference<C1181iv> a = new AtomicReference<>();

    /* renamed from: a  reason: collision with other field name */
    public final Lm f5516a = new Lm(new C0533Hu("RxNewThreadScheduler-"));

    /* renamed from: a  reason: collision with other field name */
    public final C0780ab f5517a = new C0780ab(new C0533Hu("RxComputationScheduler-"));

    /* renamed from: a  reason: collision with other field name */
    public final C1509z3 f5518a = new C1509z3(new C0533Hu("RxIoScheduler-"));

    public C1181iv() {
        Cu.f3555a.e().getClass();
    }

    public static Lm a() {
        C1181iv ivVar;
        boolean z;
        while (true) {
            AtomicReference<C1181iv> atomicReference = a;
            ivVar = atomicReference.get();
            if (ivVar != null) {
                break;
            }
            ivVar = new C1181iv();
            while (true) {
                if (!atomicReference.compareAndSet((Object) null, ivVar)) {
                    if (atomicReference.get() != null) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (z) {
                break;
            }
            synchronized (ivVar) {
                C0780ab abVar = ivVar.f5517a;
                if (abVar instanceof C1162hv) {
                    abVar.shutdown();
                }
                C1509z3 z3Var = ivVar.f5518a;
                if (z3Var instanceof C1162hv) {
                    z3Var.shutdown();
                }
                Lm lm = ivVar.f5516a;
                if (lm instanceof C1162hv) {
                    ((C1162hv) lm).shutdown();
                }
            }
        }
        return ivVar.f5516a;
    }
}
