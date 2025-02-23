package org.spongycastle.jcajce.provider.asymmetric.util;

import java.io.IOException;
import java.math.BigInteger;

public interface DSAEncoder {
    byte[] a(BigInteger bigInteger, BigInteger bigInteger2) throws IOException;

    BigInteger[] b(byte[] bArr) throws IOException;
}
