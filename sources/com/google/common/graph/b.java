package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.AbstractBaseGraph;
import com.google.common.graph.DirectedGraphConnections;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class b implements Function {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ b(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final Object apply(Object obj) {
        int i = this.c;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                return ((AbstractBaseGraph.AnonymousClass2) obj2).lambda$iterator$1(obj);
            default:
                return DirectedGraphConnections.lambda$incidentEdgeIterator$2(obj2, (DirectedGraphConnections.NodeConnection) obj);
        }
    }
}
