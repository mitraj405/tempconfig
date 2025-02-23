package com.google.common.graph;

import com.google.common.base.Function;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class d implements Function {
    public final /* synthetic */ Object a;
    public final /* synthetic */ int c;

    public /* synthetic */ d(Object obj, int i) {
        this.c = i;
        this.a = obj;
    }

    public final Object apply(Object obj) {
        int i = this.c;
        Object obj2 = this.a;
        switch (i) {
            case 0:
                return EndpointPair.ordered(obj, obj2);
            default:
                return ((Network) obj2).incidentNodes(obj).target();
        }
    }
}
