package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;

/* renamed from: Lu  reason: default package */
/* compiled from: SafeCollector.common.kt */
public final class Lu extends C0595Mh implements Function2<Integer, CoroutineContext.b, Integer> {
    public final /* synthetic */ C0559Ju<?> a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Lu(C0559Ju<?> ju) {
        super(2);
        this.a = ju;
    }

    public final Object invoke(Object obj, Object obj2) {
        int i;
        int intValue = ((Number) obj).intValue();
        CoroutineContext.b bVar = (CoroutineContext.b) obj2;
        CoroutineContext.c Z = bVar.Z();
        CoroutineContext.b b = this.a.f3670a.b(Z);
        int i2 = Job.b;
        if (Z != Job.b.a) {
            if (bVar != b) {
                i = Integer.MIN_VALUE;
            } else {
                i = intValue + 1;
            }
            return Integer.valueOf(i);
        }
        Job job = (Job) b;
        Job job2 = (Job) bVar;
        while (true) {
            if (job2 != null) {
                if (job2 == job || !(job2 instanceof C1266mv)) {
                    break;
                }
                job2 = job2.a();
            } else {
                job2 = null;
                break;
            }
        }
        if (job2 == job) {
            if (job != null) {
                intValue++;
            }
            return Integer.valueOf(intValue);
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + job2 + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }
}
