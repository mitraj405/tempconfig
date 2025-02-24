package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
@DoNotMock("Use Optional.of(value) or Optional.absent()")
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    public static <T> Optional<T> fromNullable(T t) {
        if (t == null) {
            return absent();
        }
        return new Present(t);
    }

    public static <T> Optional<T> of(T t) {
        return new Present(Preconditions.checkNotNull(t));
    }

    @Beta
    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new AbstractIterator<T>() {
                    private final Iterator<? extends Optional<? extends T>> iterator;

                    {
                        this.iterator = (Iterator) Preconditions.checkNotNull(iterable.iterator());
                    }

                    public T computeNext() {
                        while (this.iterator.hasNext()) {
                            Optional optional = (Optional) this.iterator.next();
                            if (optional.isPresent()) {
                                return optional.get();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    public abstract Set<T> asSet();

    public abstract boolean equals(Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    @Beta
    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T t);

    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);
}
