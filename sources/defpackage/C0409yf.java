package defpackage;

import com.google.common.base.Function;
import com.google.common.graph.ImmutableValueGraph;
import com.google.common.graph.ValueGraph;

/* renamed from: yf  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0409yf implements Function {
    public final /* synthetic */ ValueGraph a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Object f3438a;

    public /* synthetic */ C0409yf(ValueGraph valueGraph, Object obj) {
        this.a = valueGraph;
        this.f3438a = obj;
    }

    public final Object apply(Object obj) {
        return ImmutableValueGraph.lambda$connectionsOf$0(this.a, this.f3438a, obj);
    }
}
