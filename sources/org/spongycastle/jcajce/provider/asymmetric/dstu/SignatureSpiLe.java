package org.spongycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.security.SignatureException;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;

public class SignatureSpiLe extends SignatureSpi {
    public final byte[] engineSign() throws SignatureException {
        byte[] s = ASN1OctetString.q(super.engineSign()).s();
        for (int i = 0; i < s.length / 2; i++) {
            byte b = s[i];
            s[i] = s[(s.length - 1) - i];
            s[(s.length - 1) - i] = b;
        }
        try {
            return new DEROctetString(s).e();
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        try {
            byte[] s = ((ASN1OctetString) ASN1Primitive.k(bArr)).s();
            for (int i = 0; i < s.length / 2; i++) {
                byte b = s[i];
                s[i] = s[(s.length - 1) - i];
                s[(s.length - 1) - i] = b;
            }
            try {
                return super.engineVerify(new DEROctetString(s).e());
            } catch (SignatureException e) {
                throw e;
            } catch (Exception e2) {
                throw new SignatureException(e2.toString());
            }
        } catch (IOException unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }
}
