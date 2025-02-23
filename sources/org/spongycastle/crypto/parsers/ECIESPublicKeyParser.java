package org.spongycastle.crypto.parsers;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.spongycastle.crypto.KeyParser;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.util.io.Streams;

public class ECIESPublicKeyParser implements KeyParser {
    public final ECDomainParameters a;

    public ECIESPublicKeyParser(ECDomainParameters eCDomainParameters) {
        this.a = eCDomainParameters;
    }

    public final AsymmetricKeyParameter a(ByteArrayInputStream byteArrayInputStream) throws IOException {
        byte[] bArr;
        int read = byteArrayInputStream.read();
        if (read != 0) {
            ECDomainParameters eCDomainParameters = this.a;
            if (read == 2 || read == 3) {
                bArr = new byte[(((eCDomainParameters.a.k() + 7) / 8) + 1)];
            } else if (read == 4 || read == 6 || read == 7) {
                bArr = new byte[((((eCDomainParameters.a.k() + 7) / 8) * 2) + 1)];
            } else {
                throw new IOException("Sender's public key has invalid point encoding 0x" + Integer.toString(read, 16));
            }
            bArr[0] = (byte) read;
            Streams.b(byteArrayInputStream, bArr, 1, bArr.length - 1);
            return new ECPublicKeyParameters(eCDomainParameters.a.g(bArr), eCDomainParameters);
        }
        throw new IOException("Sender's public key invalid.");
    }
}
