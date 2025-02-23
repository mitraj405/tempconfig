package org.spongycastle.pqc.crypto.xmss;

import java.io.Serializable;

public final class XMSSNode implements Serializable {
    private static final long serialVersionUID = 1;
    public final byte[] a;
    public final int c;

    public XMSSNode(int i, byte[] bArr) {
        this.c = i;
        this.a = bArr;
    }

    /* renamed from: a */
    public final XMSSNode clone() {
        return new XMSSNode(this.c, b());
    }

    public final byte[] b() {
        return XMSSUtil.b(this.a);
    }
}
