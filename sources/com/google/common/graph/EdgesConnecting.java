package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;

@ElementTypesAreNonnullByDefault
final class EdgesConnecting<E> extends AbstractSet<E> {
    private final Map<?, E> nodeToOutEdge;
    private final Object targetNode;

    public EdgesConnecting(Map<?, E> map, Object obj) {
        this.nodeToOutEdge = (Map) Preconditions.checkNotNull(map);
        this.targetNode = Preconditions.checkNotNull(obj);
    }

    private E getConnectingEdge() {
        return this.nodeToOutEdge.get(this.targetNode);
    }

    public boolean contains(Object obj) {
        Object connectingEdge = getConnectingEdge();
        if (connectingEdge == null || !connectingEdge.equals(obj)) {
            return false;
        }
        return true;
    }

    public int size() {
        if (getConnectingEdge() == null) {
            return 0;
        }
        return 1;
    }

    public UnmodifiableIterator<E> iterator() {
        Object connectingEdge = getConnectingEdge();
        if (connectingEdge == null) {
            return ImmutableSet.of().iterator();
        }
        return Iterators.singletonIterator(connectingEdge);
    }
}
