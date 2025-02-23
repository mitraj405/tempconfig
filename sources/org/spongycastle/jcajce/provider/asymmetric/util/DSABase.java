package org.spongycastle.jcajce.provider.asymmetric.util;

import java.math.BigInteger;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.spec.AlgorithmParameterSpec;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.DSA;
import org.spongycastle.crypto.Digest;

public abstract class DSABase extends SignatureSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {
    public final DSA a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f6480a;

    /* renamed from: a  reason: collision with other field name */
    public final DSAEncoder f6481a;

    public DSABase(Digest digest, DSA dsa, DSAEncoder dSAEncoder) {
        this.f6480a = digest;
        this.a = dsa;
        this.f6481a = dSAEncoder;
    }

    public final Object engineGetParameter(String str) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final byte[] engineSign() throws SignatureException {
        Digest digest = this.f6480a;
        byte[] bArr = new byte[digest.f()];
        digest.c(0, bArr);
        try {
            BigInteger[] b = this.a.b(bArr);
            return this.f6481a.a(b[0], b[1]);
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    public final void engineUpdate(byte b) throws SignatureException {
        this.f6480a.d(b);
    }

    public final boolean engineVerify(byte[] bArr) throws SignatureException {
        Digest digest = this.f6480a;
        byte[] bArr2 = new byte[digest.f()];
        digest.c(0, bArr2);
        try {
            BigInteger[] b = this.f6481a.b(bArr);
            return this.a.c(b[0], b[1], bArr2);
        } catch (Exception unused) {
            throw new SignatureException("error decoding signature bytes.");
        }
    }

    public final void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) throws SignatureException {
        this.f6480a.update(bArr, i, i2);
    }
}
