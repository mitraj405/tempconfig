package org.spongycastle.asn1.x9;

public abstract class X9ECParametersHolder {
    public X9ECParameters a;

    public abstract X9ECParameters a();

    public final synchronized X9ECParameters b() {
        if (this.a == null) {
            this.a = a();
        }
        return this.a;
    }
}
