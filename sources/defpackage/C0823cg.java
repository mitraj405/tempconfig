package defpackage;

import java.util.Iterator;

/* renamed from: cg  reason: default package and case insensitive filesystem */
/* compiled from: PrimitiveIterators.kt */
public abstract class C0823cg implements Iterator<Integer> {
    public final /* bridge */ /* synthetic */ Object next() {
        return Integer.valueOf(nextInt());
    }

    public abstract int nextInt();

    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
