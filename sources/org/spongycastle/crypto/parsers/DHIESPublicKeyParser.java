package org.spongycastle.crypto.parsers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.util.io.Streams;

public class DHIESPublicKeyParser implements KeyParser {
    public final DHParameters a;

    public DHIESPublicKeyParser(DHParameters dHParameters) {
        this.a = dHParameters;
    }

    public final AsymmetricKeyParameter a(ByteArrayInputStream byteArrayInputStream) throws IOException {
        DHParameters dHParameters = this.a;
        int bitLength = (dHParameters.b.bitLength() + 7) / 8;
        byte[] bArr = new byte[bitLength];
        Streams.b(byteArrayInputStream, bArr, 0, bitLength);
        return new DHPublicKeyParameters(new BigInteger(1, bArr), dHParameters);
    }
}
