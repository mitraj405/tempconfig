package defpackage;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped;

/* renamed from: ry  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0321ry implements Supplier {
    public final /* synthetic */ int c;

    public /* synthetic */ C0321ry(int i) {
        this.c = i;
    }

    public final Object get() {
        return Striped.lambda$lazyWeakSemaphore$2(this.c);
    }
}
