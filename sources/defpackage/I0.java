package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: I0  reason: default package */
/* compiled from: AnimatableGradientColorValue */
public final class I0 extends C0293p2 {
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ I0(ArrayList arrayList, int i) {
        super(arrayList);
        this.a = i;
    }

    public final C0335t2 b() {
        int i = this.a;
        List<Bh<V>> list = this.a;
        switch (i) {
            case 0:
                return new we(list, 0);
            default:
                return new we(list, 1);
        }
    }
}
