package defpackage;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CancellableContinuation;

/* renamed from: Sv  reason: default package */
/* compiled from: Select.kt */
public final class Sv<R> extends C0688T3 implements Tv, C1256mD {
    public static final AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(Sv.class, Object.class, RemoteConfigConstants.ResponseFieldKey.STATE);
    private volatile Object state;

    /* renamed from: Sv$a */
    /* compiled from: Select.kt */
    public final class a {
    }

    public final boolean a(Object obj, Object obj2) {
        if (e(obj) == 0) {
            return true;
        }
        return false;
    }

    public final void d(Throwable th) {
        boolean z;
        do {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != r1.j) {
                C0422zD zDVar = r1.k;
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(this, obj, zDVar)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            z = false;
                            continue;
                            break;
                        }
                    } else {
                        z = true;
                        continue;
                        break;
                    }
                }
            } else {
                return;
            }
        } while (!z);
    }

    public final int e(Object obj) {
        boolean z;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (!(obj2 instanceof CancellableContinuation)) {
                if (C1177ig.a(obj2, r1.j)) {
                    z = true;
                } else {
                    z = obj2 instanceof a;
                }
                if (z) {
                    return 3;
                }
                if (C1177ig.a(obj2, r1.k)) {
                    return 2;
                }
                boolean z2 = false;
                if (C1177ig.a(obj2, r1.i)) {
                    List E = r1.E(obj);
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, E)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                break;
                            }
                        } else {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        return 1;
                    }
                } else if (obj2 instanceof List) {
                    Collection collection = (Collection) obj2;
                    C1177ig.f(collection, "<this>");
                    ArrayList arrayList = new ArrayList(collection.size() + 1);
                    arrayList.addAll(collection);
                    arrayList.add(obj);
                    while (true) {
                        if (!atomicReferenceFieldUpdater.compareAndSet(this, obj2, arrayList)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj2) {
                                break;
                            }
                        } else {
                            z2 = true;
                            break;
                        }
                    }
                    if (z2) {
                        return 1;
                    }
                } else {
                    throw new IllegalStateException(("Unexpected state: " + obj2).toString());
                }
            }
        }
    }

    public final CoroutineContext getContext() {
        return null;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        d((Throwable) obj);
        return Unit.a;
    }

    public final void b(Pv<?> pv, int i) {
    }
}
