package org.spongycastle.pqc.crypto.mceliece;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricCipherKeyPair;
import org.spongycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.spongycastle.crypto.KeyGenerationParameters;
import org.spongycastle.pqc.math.linearalgebra.GF2Matrix;
import org.spongycastle.pqc.math.linearalgebra.GF2mField;
import org.spongycastle.pqc.math.linearalgebra.GoppaCode;
import org.spongycastle.pqc.math.linearalgebra.Permutation;
import org.spongycastle.pqc.math.linearalgebra.PolynomialGF2mSmallM;

public class McElieceCCA2KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6673a;

    /* renamed from: a  reason: collision with other field name */
    public McElieceCCA2KeyGenerationParameters f6674a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f6675a = false;
    public int b;
    public int c;
    public int d;

    public final AsymmetricCipherKeyPair a() {
        if (!this.f6675a) {
            b(new McElieceCCA2KeyGenerationParameters(new SecureRandom(), new McElieceCCA2Parameters()));
        }
        GF2mField gF2mField = new GF2mField(this.a, this.d);
        PolynomialGF2mSmallM polynomialGF2mSmallM = new PolynomialGF2mSmallM(gF2mField, this.c, this.f6673a);
        GoppaCode.MaMaPe a2 = GoppaCode.a(GoppaCode.b(gF2mField, polynomialGF2mSmallM), this.f6673a);
        Permutation permutation = a2.f6850a;
        GF2Matrix c2 = a2.a.c();
        return new AsymmetricCipherKeyPair(new McElieceCCA2PublicKeyParameters(this.b, this.c, c2, this.f6674a.a.c), new McElieceCCA2PrivateKeyParameters(this.b, c2.a, gF2mField, polynomialGF2mSmallM, permutation, this.f6674a.a.c));
    }

    public final void b(KeyGenerationParameters keyGenerationParameters) {
        this.f6674a = (McElieceCCA2KeyGenerationParameters) keyGenerationParameters;
        this.f6673a = new SecureRandom();
        McElieceCCA2Parameters mcElieceCCA2Parameters = this.f6674a.a;
        this.a = mcElieceCCA2Parameters.c;
        this.b = mcElieceCCA2Parameters.e;
        this.c = mcElieceCCA2Parameters.d;
        this.d = mcElieceCCA2Parameters.f;
        this.f6675a = true;
    }
}
