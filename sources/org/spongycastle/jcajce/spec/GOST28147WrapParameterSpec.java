package org.spongycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;

public class GOST28147WrapParameterSpec implements AlgorithmParameterSpec {
    static {
        HashMap hashMap = new HashMap();
        hashMap.put(CryptoProObjectIdentifiers.g, "E-A");
        hashMap.put(CryptoProObjectIdentifiers.h, "E-B");
        hashMap.put(CryptoProObjectIdentifiers.i, "E-C");
        hashMap.put(CryptoProObjectIdentifiers.j, "E-D");
    }
}
