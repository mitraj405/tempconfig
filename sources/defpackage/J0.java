package defpackage;

import java.util.List;

/* renamed from: J0  reason: default package */
/* compiled from: AnimatableIntegerValue */
public final class J0 extends C0293p2 {
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ J0(List list, int i) {
        super(list);
        this.a = i;
    }

    public final C0335t2 b() {
        int i = this.a;
        List<Bh<V>> list = this.a;
        switch (i) {
            case 0:
                return new gg(list);
            default:
                return new sw(list);
        }
    }
}
