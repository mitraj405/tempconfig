package defpackage;

import defpackage.x3;

/* renamed from: w3  reason: default package */
/* compiled from: ByteString */
public final class w3 extends x3.a {
    public final /* synthetic */ x3 a;
    public int c = 0;
    public final int d;

    public w3(x3 x3Var) {
        this.a = x3Var;
        this.d = x3Var.size();
    }

    public final boolean hasNext() {
        if (this.c < this.d) {
            return true;
        }
        return false;
    }
}
