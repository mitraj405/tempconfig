package org.spongycastle.crypto.prng.drbg;

import java.math.BigInteger;
import java.util.Hashtable;
import org.spongycastle.asn1.nist.NISTNamedCurves;
import org.spongycastle.math.ec.ECCurve;
import org.spongycastle.util.Arrays;

public class DualECSP800DRBG implements SP80090DRBG {
    static {
        BigInteger bigInteger = new BigInteger("6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", 16);
        BigInteger bigInteger2 = new BigInteger("4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5", 16);
        BigInteger bigInteger3 = new BigInteger("c97445f45cdef9f0d3e05e1e585fc297235b82b5be8ff3efca67c59852018192", 16);
        BigInteger bigInteger4 = new BigInteger("b28ef557ba31dfcbdd21ac46e2a91e3c304f44cb87058ada2cb815151e610046", 16);
        BigInteger bigInteger5 = new BigInteger("aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", 16);
        BigInteger bigInteger6 = new BigInteger("3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f", 16);
        BigInteger bigInteger7 = new BigInteger("8e722de3125bddb05580164bfe20b8b432216a62926c57502ceede31c47816edd1e89769124179d0b695106428815065", 16);
        BigInteger bigInteger8 = new BigInteger("023b1660dd701d0839fd45eec36f9ee7b32e13b315dc02610aa1b636e346df671f790f84c5e09b05674dbb7e45c803dd", 16);
        BigInteger bigInteger9 = new BigInteger("c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", 16);
        BigInteger bigInteger10 = new BigInteger("11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650", 16);
        BigInteger bigInteger11 = new BigInteger("1b9fa3e518d683c6b65763694ac8efbaec6fab44f2276171a42726507dd08add4c3b3f4c1ebc5b1222ddba077f722943b24c3edfa0f85fe24d0c8c01591f0be6f63", 16);
        BigInteger bigInteger12 = new BigInteger("1f3bdba585295d9a1110d1df1f9430ef8442c5018976ff3437ef91b81dc0b8132c8d5c39c32d0e004a3092b7d327c0e7a4d26d2c7b69b58f9066652911e457779de", 16);
        ECCurve.Fp fp = (ECCurve.Fp) NISTNamedCurves.b("P-256").f5787a;
        new DualECPoints(fp.d(bigInteger, bigInteger2, false), fp.d(bigInteger3, bigInteger4, false));
        ECCurve.Fp fp2 = (ECCurve.Fp) NISTNamedCurves.b("P-384").f5787a;
        new DualECPoints(fp2.d(bigInteger5, bigInteger6, false), fp2.d(bigInteger7, bigInteger8, false));
        ECCurve.Fp fp3 = (ECCurve.Fp) NISTNamedCurves.b("P-521").f5787a;
        new DualECPoints(fp3.d(bigInteger9, bigInteger10, false), fp3.d(bigInteger11, bigInteger12, false));
    }

    public final void a() {
        Hashtable hashtable = Utils.a;
        throw null;
    }

    public final int b(byte[] bArr, boolean z) {
        int length = bArr.length;
        int length2 = bArr.length / 0;
        Hashtable hashtable = Utils.a;
        if (0 + ((long) length2) > 2147483648L) {
            return -1;
        }
        if (!z) {
            new BigInteger(1, (byte[]) null);
            Arrays.p(bArr, (byte) 0);
            if (length2 > 0) {
                throw null;
            } else if (bArr.length > 0) {
                throw null;
            } else {
                throw null;
            }
        } else {
            throw null;
        }
    }
}
