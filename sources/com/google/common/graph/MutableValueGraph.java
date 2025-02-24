package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@ElementTypesAreNonnullByDefault
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    @CanIgnoreReturnValue
    boolean addNode(N n);

    @CanIgnoreReturnValue
    V putEdgeValue(EndpointPair<N> endpointPair, V v);

    @CanIgnoreReturnValue
    V putEdgeValue(N n, N n2, V v);

    @CanIgnoreReturnValue
    V removeEdge(EndpointPair<N> endpointPair);

    @CanIgnoreReturnValue
    V removeEdge(N n, N n2);

    @CanIgnoreReturnValue
    boolean removeNode(N n);
}
