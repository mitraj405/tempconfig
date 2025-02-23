package org.spongycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.util.Arrays;

public class GOST28147ParameterSpec implements AlgorithmParameterSpec {
    public static final HashMap a;

    /* renamed from: a  reason: collision with other field name */
    public final byte[] f6564a;
    public final byte[] b;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(CryptoProObjectIdentifiers.g, "E-A");
        hashMap.put(CryptoProObjectIdentifiers.h, "E-B");
        hashMap.put(CryptoProObjectIdentifiers.i, "E-C");
        hashMap.put(CryptoProObjectIdentifiers.j, "E-D");
    }

    public GOST28147ParameterSpec(byte[] bArr, byte[] bArr2) {
        this.f6564a = null;
        this.b = null;
        byte[] bArr3 = new byte[bArr.length];
        this.b = bArr3;
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        byte[] bArr4 = new byte[bArr2.length];
        this.f6564a = bArr4;
        System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
    }

    public final byte[] a() {
        return Arrays.c(this.f6564a);
    }

    public GOST28147ParameterSpec(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        String str = (String) a.get(aSN1ObjectIdentifier);
        if (str != null) {
            this.f6564a = null;
            this.b = null;
            this.b = GOST28147Engine.i(str);
            this.f6564a = Arrays.c(bArr);
            return;
        }
        throw new IllegalArgumentException("unknown OID: " + aSN1ObjectIdentifier);
    }
}
