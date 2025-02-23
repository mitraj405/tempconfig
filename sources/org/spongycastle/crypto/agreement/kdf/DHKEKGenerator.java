package org.spongycastle.crypto.agreement.kdf;

import java.io.IOException;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.util.Pack;

public class DHKEKGenerator implements DerivationFunction {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public ASN1ObjectIdentifier f5808a;

    /* renamed from: a  reason: collision with other field name */
    public final Digest f5809a;

    /* renamed from: a  reason: collision with other field name */
    public byte[] f5810a;
    public byte[] b;

    public DHKEKGenerator(SHA1Digest sHA1Digest) {
        this.f5809a = sHA1Digest;
    }

    public final void a(DerivationParameters derivationParameters) {
        DHKDFParameters dHKDFParameters = (DHKDFParameters) derivationParameters;
        this.f5808a = dHKDFParameters.f5806a;
        this.a = dHKDFParameters.a;
        this.f5810a = dHKDFParameters.f5807a;
        this.b = dHKDFParameters.b;
    }

    public final int b(byte[] bArr, int i) throws DataLengthException, IllegalArgumentException {
        byte[] bArr2 = bArr;
        int i2 = i;
        if (bArr2.length - i2 >= 0) {
            long j = (long) i2;
            Digest digest = this.f5809a;
            int f = digest.f();
            if (j <= 8589934591L) {
                long j2 = (long) f;
                int i3 = (int) (((j + j2) - 1) / j2);
                byte[] bArr3 = new byte[digest.f()];
                int i4 = 1;
                int i5 = 0;
                int i6 = 0;
                while (i5 < i3) {
                    byte[] bArr4 = this.f5810a;
                    digest.update(bArr4, 0, bArr4.length);
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    aSN1EncodableVector2.a(this.f5808a);
                    int i7 = i3;
                    long j3 = j;
                    byte[] bArr5 = new byte[4];
                    Pack.c(i4, bArr5, 0);
                    aSN1EncodableVector2.a(new DEROctetString(bArr5));
                    aSN1EncodableVector.a(new DERSequence(aSN1EncodableVector2));
                    byte[] bArr6 = this.b;
                    if (bArr6 != null) {
                        aSN1EncodableVector.a(new DERTaggedObject(true, 0, new DEROctetString(bArr6)));
                    }
                    byte[] bArr7 = new byte[4];
                    Pack.c(this.a, bArr7, 0);
                    aSN1EncodableVector.a(new DERTaggedObject(true, 2, new DEROctetString(bArr7)));
                    try {
                        byte[] f2 = new DERSequence(aSN1EncodableVector).f("DER");
                        digest.update(f2, 0, f2.length);
                        digest.c(0, bArr3);
                        if (i2 > f) {
                            System.arraycopy(bArr3, 0, bArr2, i6, f);
                            i6 += f;
                            i2 -= f;
                        } else {
                            System.arraycopy(bArr3, 0, bArr2, i6, i2);
                        }
                        i4++;
                        i5++;
                        i3 = i7;
                        j = j3;
                    } catch (IOException e) {
                        throw new IllegalArgumentException(C0709Uj.g(e, new StringBuilder("unable to encode parameter info: ")));
                    }
                }
                digest.reset();
                return (int) j;
            }
            throw new IllegalArgumentException("Output length too large");
        }
        throw new OutputLengthException("output buffer too small");
    }
}
