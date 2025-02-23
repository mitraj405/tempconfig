package org.spongycastle.jce.interfaces;

import java.security.Key;

public interface IESKey extends Key {
    void N();

    void q();
}
