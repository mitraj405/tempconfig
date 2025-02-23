package defpackage;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped;

/* renamed from: qy  reason: default package and case insensitive filesystem */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class C0310qy implements Supplier {
    public final /* synthetic */ int c;

    public /* synthetic */ C0310qy(int i) {
        this.c = i;
    }

    public final Object get() {
        return Striped.lambda$semaphore$1(this.c);
    }
}
