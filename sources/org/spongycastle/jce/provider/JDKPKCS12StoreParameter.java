package org.spongycastle.jce.provider;

import java.security.KeyStore;

public class JDKPKCS12StoreParameter implements KeyStore.LoadStoreParameter {
    public final KeyStore.ProtectionParameter getProtectionParameter() {
        return null;
    }
}
