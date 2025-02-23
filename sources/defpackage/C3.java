package defpackage;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Callable;

/* renamed from: C3  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C3 implements Callable {
    public final /* synthetic */ Supplier a;

    /* renamed from: a  reason: collision with other field name */
    public final /* synthetic */ Callable f73a;

    public /* synthetic */ C3(Supplier supplier, Callable callable) {
        this.a = supplier;
        this.f73a = callable;
    }

    public final Object call() {
        return Callables.lambda$threadRenaming$2(this.a, this.f73a);
    }
}
