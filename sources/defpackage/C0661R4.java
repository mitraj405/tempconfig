package defpackage;

import androidx.datastore.preferences.core.MutablePreferences;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* renamed from: R4  reason: default package and case insensitive filesystem */
/* compiled from: ChannelFlow.kt */
public abstract class C0661R4<T> implements Flow {
    public final CoroutineContext a;
    public final int c;
    public final int d;

    public C0661R4(CoroutineContext coroutineContext, int i, int i2) {
        this.a = coroutineContext;
        this.c = i;
        this.d = i2;
    }

    public abstract Object b(ProducerScope<? super T> producerScope, Continuation<? super Unit> continuation);

    public final Object collect(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        P4 p4 = new P4((Continuation) null, flowCollector, this);
        C1266mv mvVar = new C1266mv(continuation, continuation.getContext());
        Object y0 = C1354qp.y0(mvVar, mvVar, p4);
        if (y0 == C1438v7.COROUTINE_SUSPENDED) {
            return y0;
        }
        return Unit.a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        C1440va vaVar = C1440va.a;
        CoroutineContext coroutineContext = this.a;
        if (coroutineContext != vaVar) {
            arrayList.add("context=" + coroutineContext);
        }
        int i = this.c;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        int i2 = this.d;
        if (i2 != 1) {
            arrayList.add("onBufferOverflow=".concat(C1058d.N(i2)));
        }
        return getClass().getSimpleName() + '[' + C1472x5.Z(arrayList, ", ", (String) null, (String) null, (MutablePreferences.a) null, 62) + ']';
    }
}
