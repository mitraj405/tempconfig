package defpackage;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: kB  reason: default package */
/* compiled from: UnmodifiableLazyStringList */
public final class kB extends AbstractList<String> implements Vh, RandomAccess {
    public final Vh a;

    /* renamed from: kB$a */
    /* compiled from: UnmodifiableLazyStringList */
    public class a implements ListIterator<String> {
        public final ListIterator<String> a;

        public a(kB kBVar, int i) {
            this.a = kBVar.a.listIterator(i);
        }

        public final void add(Object obj) {
            String str = (String) obj;
            throw new UnsupportedOperationException();
        }

        public final boolean hasNext() {
            return this.a.hasNext();
        }

        public final boolean hasPrevious() {
            return this.a.hasPrevious();
        }

        public final Object next() {
            return this.a.next();
        }

        public final int nextIndex() {
            return this.a.nextIndex();
        }

        public final Object previous() {
            return this.a.previous();
        }

        public final int previousIndex() {
            return this.a.previousIndex();
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }

        public final void set(Object obj) {
            String str = (String) obj;
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: kB$b */
    /* compiled from: UnmodifiableLazyStringList */
    public class b implements Iterator<String> {
        public final Iterator<String> a;

        public b(kB kBVar) {
            this.a = kBVar.a.iterator();
        }

        public final boolean hasNext() {
            return this.a.hasNext();
        }

        public final Object next() {
            return this.a.next();
        }

        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public kB(Vh vh) {
        this.a = vh;
    }

    public final Object get(int i) {
        return (String) this.a.get(i);
    }

    public final Object getRaw(int i) {
        return this.a.getRaw(i);
    }

    public final List<?> getUnderlyingElements() {
        return this.a.getUnderlyingElements();
    }

    public final Iterator<String> iterator() {
        return new b(this);
    }

    public final void j(x3 x3Var) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new a(this, i);
    }

    public final int size() {
        return this.a.size();
    }

    public final Vh m() {
        return this;
    }
}
