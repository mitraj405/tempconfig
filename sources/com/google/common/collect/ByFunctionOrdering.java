package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final Function<F, ? extends T> function;
    final Ordering<T> ordering;

    public ByFunctionOrdering(Function<F, ? extends T> function2, Ordering<T> ordering2) {
        this.function = (Function) Preconditions.checkNotNull(function2);
        this.ordering = (Ordering) Preconditions.checkNotNull(ordering2);
    }

    public int compare(@ParametricNullness F f, @ParametricNullness F f2) {
        return this.ordering.compare(this.function.apply(f), this.function.apply(f2));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        if (!this.function.equals(byFunctionOrdering.function) || !this.ordering.equals(byFunctionOrdering.ordering)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.function, this.ordering);
    }

    public String toString() {
        String valueOf = String.valueOf(this.ordering);
        String valueOf2 = String.valueOf(this.function);
        return xx.A(valueOf2.length() + valueOf.length() + 13, valueOf, ".onResultOf(", valueOf2, ")");
    }
}
