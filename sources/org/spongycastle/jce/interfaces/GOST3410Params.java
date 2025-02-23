package org.spongycastle.jce.interfaces;

import org.spongycastle.jce.spec.GOST3410PublicKeyParameterSetSpec;

public interface GOST3410Params {
    GOST3410PublicKeyParameterSetSpec a();

    String b();

    String c();

    String d();
}
