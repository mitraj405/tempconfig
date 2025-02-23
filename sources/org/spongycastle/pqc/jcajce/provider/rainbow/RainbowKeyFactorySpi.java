package org.spongycastle.pqc.jcajce.provider.rainbow;

import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactorySpi;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.spongycastle.pqc.asn1.RainbowPrivateKey;
import org.spongycastle.pqc.asn1.RainbowPublicKey;
import org.spongycastle.pqc.crypto.rainbow.util.RainbowUtil;
import org.spongycastle.pqc.jcajce.spec.RainbowPrivateKeySpec;
import org.spongycastle.pqc.jcajce.spec.RainbowPublicKeySpec;
import org.spongycastle.util.Arrays;

public class RainbowKeyFactorySpi extends KeyFactorySpi implements AsymmetricKeyInfoConverter {
    public final PrivateKey a(PrivateKeyInfo privateKeyInfo) throws IOException {
        RainbowPrivateKey rainbowPrivateKey;
        ASN1Primitive h = privateKeyInfo.h();
        if (h instanceof RainbowPrivateKey) {
            rainbowPrivateKey = (RainbowPrivateKey) h;
        } else if (h != null) {
            rainbowPrivateKey = new RainbowPrivateKey(ASN1Sequence.q(h));
        } else {
            rainbowPrivateKey = null;
        }
        short[][] d = RainbowUtil.d(rainbowPrivateKey.f6649a);
        short[] b = RainbowUtil.b(rainbowPrivateKey.f6647a);
        short[][] d2 = RainbowUtil.d(rainbowPrivateKey.f6650b);
        short[] b2 = RainbowUtil.b(rainbowPrivateKey.b);
        byte[] bArr = rainbowPrivateKey.c;
        int[] iArr = new int[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            iArr[i] = bArr[i] & UnsignedBytes.MAX_VALUE;
        }
        return new BCRainbowPrivateKey(d, b, d2, b2, iArr, rainbowPrivateKey.f6648a);
    }

    public final PublicKey b(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        RainbowPublicKey rainbowPublicKey;
        ASN1Primitive h = subjectPublicKeyInfo.h();
        if (h instanceof RainbowPublicKey) {
            rainbowPublicKey = (RainbowPublicKey) h;
        } else if (h != null) {
            rainbowPublicKey = new RainbowPublicKey(ASN1Sequence.q(h));
        } else {
            rainbowPublicKey = null;
        }
        return new BCRainbowPublicKey(rainbowPublicKey.b.t().intValue(), RainbowUtil.d(rainbowPublicKey.f6652a), RainbowUtil.d(rainbowPublicKey.f6653b), RainbowUtil.b(rainbowPublicKey.f6651a));
    }

    public final PrivateKey engineGeneratePrivate(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof RainbowPrivateKeySpec) {
            RainbowPrivateKeySpec rainbowPrivateKeySpec = (RainbowPrivateKeySpec) keySpec;
            return new BCRainbowPrivateKey(rainbowPrivateKeySpec.f6842a, rainbowPrivateKeySpec.f6841a, rainbowPrivateKeySpec.f6843b, rainbowPrivateKeySpec.b, rainbowPrivateKeySpec.a, rainbowPrivateKeySpec.f6840a);
        } else if (keySpec instanceof PKCS8EncodedKeySpec) {
            try {
                return a(PrivateKeyInfo.g(ASN1Primitive.k(((PKCS8EncodedKeySpec) keySpec).getEncoded())));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unsupported key specification: " + keySpec.getClass() + ".");
        }
    }

    public final PublicKey engineGeneratePublic(KeySpec keySpec) throws InvalidKeySpecException {
        if (keySpec instanceof RainbowPublicKeySpec) {
            RainbowPublicKeySpec rainbowPublicKeySpec = (RainbowPublicKeySpec) keySpec;
            return new BCRainbowPublicKey(rainbowPublicKeySpec.c, rainbowPublicKeySpec.f6844a, rainbowPublicKeySpec.b, rainbowPublicKeySpec.a);
        } else if (keySpec instanceof X509EncodedKeySpec) {
            try {
                return b(SubjectPublicKeyInfo.g(((X509EncodedKeySpec) keySpec).getEncoded()));
            } catch (Exception e) {
                throw new InvalidKeySpecException(e.toString());
            }
        } else {
            throw new InvalidKeySpecException("Unknown key specification: " + keySpec + ".");
        }
    }

    public final KeySpec engineGetKeySpec(Key key, Class cls) throws InvalidKeySpecException {
        if (key instanceof BCRainbowPrivateKey) {
            if (PKCS8EncodedKeySpec.class.isAssignableFrom(cls)) {
                return new PKCS8EncodedKeySpec(key.getEncoded());
            }
            if (RainbowPrivateKeySpec.class.isAssignableFrom(cls)) {
                BCRainbowPrivateKey bCRainbowPrivateKey = (BCRainbowPrivateKey) key;
                return new RainbowPrivateKeySpec(bCRainbowPrivateKey.f6818a, bCRainbowPrivateKey.f6817a, bCRainbowPrivateKey.f6819b, bCRainbowPrivateKey.b, bCRainbowPrivateKey.a, bCRainbowPrivateKey.f6816a);
            }
        } else if (!(key instanceof BCRainbowPublicKey)) {
            throw new InvalidKeySpecException("Unsupported key type: " + key.getClass() + ".");
        } else if (X509EncodedKeySpec.class.isAssignableFrom(cls)) {
            return new X509EncodedKeySpec(key.getEncoded());
        } else {
            if (RainbowPublicKeySpec.class.isAssignableFrom(cls)) {
                BCRainbowPublicKey bCRainbowPublicKey = (BCRainbowPublicKey) key;
                return new RainbowPublicKeySpec(bCRainbowPublicKey.c, bCRainbowPublicKey.f6820a, bCRainbowPublicKey.a(), Arrays.g(bCRainbowPublicKey.a));
            }
        }
        throw new InvalidKeySpecException("Unknown key specification: " + cls + ".");
    }

    public final Key engineTranslateKey(Key key) throws InvalidKeyException {
        if ((key instanceof BCRainbowPrivateKey) || (key instanceof BCRainbowPublicKey)) {
            return key;
        }
        throw new InvalidKeyException("Unsupported key type");
    }
}
