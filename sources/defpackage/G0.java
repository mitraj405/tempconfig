package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: G0  reason: default package */
/* compiled from: AnimatableColorValue */
public final class G0 extends C0293p2 {
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ G0(ArrayList arrayList, int i) {
        super(arrayList);
        this.a = i;
    }

    public final C0335t2 b() {
        int i = this.a;
        List<Bh<V>> list = this.a;
        switch (i) {
            case 0:
                return new C0400y5(list);
            default:
                return new Hp(list);
        }
    }
}
