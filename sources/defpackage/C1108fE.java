package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: fE  reason: default package and case insensitive filesystem */
/* compiled from: WorkQueue.kt */
public final class C1108fE {
    public static final AtomicIntegerFieldUpdater a;

    /* renamed from: a  reason: collision with other field name */
    public static final AtomicReferenceFieldUpdater f5461a;
    public static final AtomicIntegerFieldUpdater b;
    public static final AtomicIntegerFieldUpdater c;

    /* renamed from: a  reason: collision with other field name */
    public final AtomicReferenceArray<C1433uz> f5462a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    static {
        Class<C1108fE> cls = C1108fE.class;
        f5461a = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        a = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        b = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        c = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public final C1433uz a(C1433uz uzVar) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = a;
        if (atomicIntegerFieldUpdater.get(this) - b.get(this) == 127) {
            return uzVar;
        }
        boolean z = true;
        if (uzVar.f6993a.b() != 1) {
            z = false;
        }
        if (z) {
            c.incrementAndGet(this);
        }
        int i = atomicIntegerFieldUpdater.get(this) & 127;
        while (true) {
            AtomicReferenceArray<C1433uz> atomicReferenceArray = this.f5462a;
            if (atomicReferenceArray.get(i) != null) {
                Thread.yield();
            } else {
                atomicReferenceArray.lazySet(i, uzVar);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
        }
    }

    public final C1433uz b() {
        C1433uz andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = b;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - a.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (andSet = this.f5462a.getAndSet(i2, (Object) null)) != null) {
                boolean z = true;
                if (andSet.f6993a.b() != 1) {
                    z = false;
                }
                if (z) {
                    c.decrementAndGet(this);
                }
                return andSet;
            }
        }
    }

    public final C1433uz c(int i, boolean z) {
        boolean z2;
        int i2 = i & 127;
        AtomicReferenceArray<C1433uz> atomicReferenceArray = this.f5462a;
        C1433uz uzVar = atomicReferenceArray.get(i2);
        if (uzVar != null) {
            boolean z3 = false;
            if (uzVar.f6993a.b() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 == z) {
                while (true) {
                    if (!atomicReferenceArray.compareAndSet(i2, uzVar, (Object) null)) {
                        if (atomicReferenceArray.get(i2) != uzVar) {
                            break;
                        }
                    } else {
                        z3 = true;
                        break;
                    }
                }
                if (z3) {
                    if (z) {
                        c.decrementAndGet(this);
                    }
                    return uzVar;
                }
            }
        }
        return null;
    }
}
