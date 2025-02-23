package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function1;

/* renamed from: LA  reason: default package */
/* compiled from: ViewGroup.kt */
public final class LA<T> implements Iterator<T> {
    public final ArrayList a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public Iterator<? extends T> f384a;

    /* renamed from: a  reason: collision with other field name */
    public final Function1<T, Iterator<T>> f385a;

    public LA(C0324sC sCVar, C0313rC rCVar) {
        this.f385a = rCVar;
        this.f384a = sCVar;
    }

    public final boolean hasNext() {
        return this.f384a.hasNext();
    }

    public final T next() {
        T next = this.f384a.next();
        Iterator<? extends T> invoke = this.f385a.invoke(next);
        ArrayList arrayList = this.a;
        if (invoke == null || !invoke.hasNext()) {
            while (!this.f384a.hasNext() && (!arrayList.isEmpty())) {
                if (!arrayList.isEmpty()) {
                    this.f384a = (Iterator) arrayList.get(r1.y(arrayList));
                    if (!arrayList.isEmpty()) {
                        arrayList.remove(r1.y(arrayList));
                    } else {
                        throw new NoSuchElementException("List is empty.");
                    }
                } else {
                    throw new NoSuchElementException("List is empty.");
                }
            }
        } else {
            arrayList.add(this.f384a);
            this.f384a = invoke;
        }
        return next;
    }

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
