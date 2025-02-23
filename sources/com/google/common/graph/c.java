package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.AbstractBaseGraph;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class c implements Function {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ c(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final Object apply(Object obj) {
        int i = this.c;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                return ((AbstractBaseGraph.AnonymousClass2) obj2).lambda$iterator$2(obj);
            case 1:
                return EndpointPair.unordered(obj2, obj);
            default:
                return ((Network) obj2).incidentNodes(obj).source();
        }
    }
}
