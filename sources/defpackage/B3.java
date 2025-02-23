package defpackage;

import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Callable;

/* renamed from: B3  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class B3 implements Callable {
    public final /* synthetic */ Object a;

    public /* synthetic */ B3(Object obj) {
        this.a = obj;
    }

    public final Object call() {
        return Callables.lambda$returning$0(this.a);
    }
}
