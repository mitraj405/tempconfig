package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.AbstractBaseGraph;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class a implements Function {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ a(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final Object apply(Object obj) {
        int i = this.c;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                return ((AbstractBaseGraph.AnonymousClass2) obj2).lambda$iterator$0(obj);
            default:
                return EndpointPair.ordered(obj2, obj);
        }
    }
}
