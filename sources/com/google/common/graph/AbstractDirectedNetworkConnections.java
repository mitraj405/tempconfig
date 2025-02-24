package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@ElementTypesAreNonnullByDefault
abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    final Map<E, N> inEdgeMap;
    final Map<E, N> outEdgeMap;
    /* access modifiers changed from: private */
    public int selfLoopCount;

    public AbstractDirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i) {
        boolean z;
        this.inEdgeMap = (Map) Preconditions.checkNotNull(map);
        this.outEdgeMap = (Map) Preconditions.checkNotNull(map2);
        this.selfLoopCount = Graphs.checkNonNegative(i);
        if (i > map.size() || i > map2.size()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkState(z);
    }

    public void addInEdge(E e, N n, boolean z) {
        Preconditions.checkNotNull(e);
        Preconditions.checkNotNull(n);
        boolean z2 = true;
        if (z) {
            int i = this.selfLoopCount + 1;
            this.selfLoopCount = i;
            Graphs.checkPositive(i);
        }
        if (this.inEdgeMap.put(e, n) != null) {
            z2 = false;
        }
        Preconditions.checkState(z2);
    }

    public void addOutEdge(E e, N n) {
        boolean z;
        Preconditions.checkNotNull(e);
        Preconditions.checkNotNull(n);
        if (this.outEdgeMap.put(e, n) == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
    }

    public N adjacentNode(E e) {
        N n = this.outEdgeMap.get(e);
        Objects.requireNonNull(n);
        return n;
    }

    public Set<N> adjacentNodes() {
        return Sets.union(predecessors(), successors());
    }

    public Set<E> inEdges() {
        return Collections.unmodifiableSet(this.inEdgeMap.keySet());
    }

    public Set<E> incidentEdges() {
        return new AbstractSet<E>() {
            public boolean contains(Object obj) {
                if (AbstractDirectedNetworkConnections.this.inEdgeMap.containsKey(obj) || AbstractDirectedNetworkConnections.this.outEdgeMap.containsKey(obj)) {
                    return true;
                }
                return false;
            }

            public int size() {
                return IntMath.saturatedAdd(AbstractDirectedNetworkConnections.this.inEdgeMap.size(), AbstractDirectedNetworkConnections.this.outEdgeMap.size() - AbstractDirectedNetworkConnections.this.selfLoopCount);
            }

            public UnmodifiableIterator<E> iterator() {
                Iterable<T> iterable;
                if (AbstractDirectedNetworkConnections.this.selfLoopCount == 0) {
                    iterable = Iterables.concat(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                } else {
                    iterable = Sets.union(AbstractDirectedNetworkConnections.this.inEdgeMap.keySet(), AbstractDirectedNetworkConnections.this.outEdgeMap.keySet());
                }
                return Iterators.unmodifiableIterator(iterable.iterator());
            }
        };
    }

    public Set<E> outEdges() {
        return Collections.unmodifiableSet(this.outEdgeMap.keySet());
    }

    public N removeInEdge(E e, boolean z) {
        if (z) {
            int i = this.selfLoopCount - 1;
            this.selfLoopCount = i;
            Graphs.checkNonNegative(i);
        }
        N remove = this.inEdgeMap.remove(e);
        Objects.requireNonNull(remove);
        return remove;
    }

    public N removeOutEdge(E e) {
        N remove = this.outEdgeMap.remove(e);
        Objects.requireNonNull(remove);
        return remove;
    }
}
