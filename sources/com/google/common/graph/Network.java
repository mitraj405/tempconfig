package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;

@ElementTypesAreNonnullByDefault
@Beta
@DoNotMock("Use NetworkBuilder to create a real instance")
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<E> adjacentEdges(E e);

    Set<N> adjacentNodes(N n);

    boolean allowsParallelEdges();

    boolean allowsSelfLoops();

    Graph<N> asGraph();

    int degree(N n);

    E edgeConnectingOrNull(EndpointPair<N> endpointPair);

    E edgeConnectingOrNull(N n, N n2);

    ElementOrder<E> edgeOrder();

    Set<E> edges();

    Set<E> edgesConnecting(EndpointPair<N> endpointPair);

    Set<E> edgesConnecting(N n, N n2);

    boolean equals(Object obj);

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n, N n2);

    int hashCode();

    int inDegree(N n);

    Set<E> inEdges(N n);

    Set<E> incidentEdges(N n);

    EndpointPair<N> incidentNodes(E e);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n);

    Set<E> outEdges(N n);

    Set<N> predecessors(N n);

    Set<N> successors(N n);
}
