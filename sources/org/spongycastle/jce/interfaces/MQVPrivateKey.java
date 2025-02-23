package org.spongycastle.jce.interfaces;

import java.security.PrivateKey;

public interface MQVPrivateKey extends PrivateKey {
    void h();

    void r();

    void s();
}
