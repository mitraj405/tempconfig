package org.spongycastle.jcajce;

import java.io.OutputStream;
import java.security.KeyStore;

public class PKCS12StoreParameter implements KeyStore.LoadStoreParameter {
    public final OutputStream a = null;

    /* renamed from: a  reason: collision with other field name */
    public final KeyStore.ProtectionParameter f6311a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f6312a;

    public PKCS12StoreParameter(KeyStore.ProtectionParameter protectionParameter) {
        this.f6311a = protectionParameter;
        this.f6312a = false;
    }

    public final KeyStore.ProtectionParameter getProtectionParameter() {
        return this.f6311a;
    }
}
