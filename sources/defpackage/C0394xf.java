package defpackage;

import com.google.common.base.Function;
import com.google.common.graph.Network;

/* renamed from: xf  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0394xf implements Function {
    public final /* synthetic */ Network a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3410a;

    public /* synthetic */ C0394xf(Network network, Object obj) {
        this.a = network;
        this.f3410a = obj;
    }

    public final Object apply(Object obj) {
        return this.a.incidentNodes(obj).adjacentNode(this.f3410a);
    }
}
