package defpackage;

import java.util.Iterator;

/* renamed from: Ti  reason: default package */
/* compiled from: PrimitiveIterators.kt */
public abstract class Ti implements Iterator<Long> {
    public final /* bridge */ /* synthetic */ Object next() {
        return Long.valueOf(nextLong());
    }

    public abstract long nextLong();

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
