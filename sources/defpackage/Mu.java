package defpackage;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: Mu  reason: default package */
/* compiled from: Builders.kt */
public final class Mu<T> extends C1270n<T> {
    public final Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> a;

    public Mu(ax axVar) {
        this.a = axVar;
    }
}
