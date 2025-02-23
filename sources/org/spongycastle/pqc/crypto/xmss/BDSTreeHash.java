package org.spongycastle.pqc.crypto.xmss;

import java.io.Serializable;

class BDSTreeHash implements Serializable {
    private static final long serialVersionUID = 1;
    public XMSSNode a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6756a = false;
    public boolean b = false;
    public final int c;
    public int d;
    public int e;

    public BDSTreeHash(int i) {
        this.c = i;
    }

    public final int a() {
        if (!this.f6756a || this.b) {
            return Integer.MAX_VALUE;
        }
        return this.d;
    }
}
