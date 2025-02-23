package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"B"})
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.of());
    private final ImmutableMap<Class<? extends B>, B> delegate;

    public static final class Builder<B> {
        private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder = ImmutableMap.builder();

        private static <B, T extends B> T cast(Class<T> cls, B b) {
            return Primitives.wrap(cls).cast(b);
        }

        public ImmutableClassToInstanceMap<B> build() {
            ImmutableMap<Class<? extends B>, B> buildOrThrow = this.mapBuilder.buildOrThrow();
            if (buildOrThrow.isEmpty()) {
                return ImmutableClassToInstanceMap.of();
            }
            return new ImmutableClassToInstanceMap<>(buildOrThrow);
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> put(Class<T> cls, T t) {
            this.mapBuilder.put(cls, t);
            return this;
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry next : map.entrySet()) {
                Class cls = (Class) next.getKey();
                this.mapBuilder.put(cls, cast(cls, next.getValue()));
            }
            return this;
        }
    }

    public static <B> Builder<B> builder() {
        return new Builder<>();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        if (map instanceof ImmutableClassToInstanceMap) {
            return (ImmutableClassToInstanceMap) map;
        }
        return new Builder().putAll(map).build();
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return EMPTY;
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return this.delegate.get(Preconditions.checkNotNull(cls));
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        if (isEmpty()) {
            return of();
        }
        return this;
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> cls, T t) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.of(cls, t));
    }

    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }
}
