package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.DerivationFunction;
import org.spongycastle.crypto.agreement.kdf.DHKEKGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseAgreementSpi;
import org.spongycastle.jcajce.spec.UserKeyingMaterialSpec;
import org.spongycastle.util.Arrays;

public class KeyAgreementSpi extends BaseAgreementSpi {
    public static final BigInteger e = BigInteger.valueOf(1);
    public static final BigInteger f = BigInteger.valueOf(2);
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;
    public BigInteger d;

    public static class DHwithRFC2631KDF extends KeyAgreementSpi {
        public DHwithRFC2631KDF() {
            super(new DHKEKGenerator(new SHA1Digest()));
        }
    }

    public KeyAgreementSpi() {
        super("Diffie-Hellman", (DerivationFunction) null);
    }

    public final byte[] a() {
        return b(this.d);
    }

    public final byte[] b(BigInteger bigInteger) {
        int bitLength = (this.b.bitLength() + 7) / 8;
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == bitLength) {
            return byteArray;
        }
        if (byteArray[0] == 0 && byteArray.length == bitLength + 1) {
            int length = byteArray.length - 1;
            byte[] bArr = new byte[length];
            System.arraycopy(byteArray, 1, bArr, 0, length);
            return bArr;
        }
        byte[] bArr2 = new byte[bitLength];
        System.arraycopy(byteArray, 0, bArr2, bitLength - byteArray.length, byteArray.length);
        return bArr2;
    }

    public final Key engineDoPhase(Key key, boolean z) throws InvalidKeyException, IllegalStateException {
        if (this.a == null) {
            throw new IllegalStateException("Diffie-Hellman not initialised.");
        } else if (key instanceof DHPublicKey) {
            DHPublicKey dHPublicKey = (DHPublicKey) key;
            if (!dHPublicKey.getParams().getG().equals(this.c) || !dHPublicKey.getParams().getP().equals(this.b)) {
                throw new InvalidKeyException("DHPublicKey not for this KeyAgreement!");
            }
            BigInteger y = dHPublicKey.getY();
            if (y != null && y.compareTo(f) >= 0) {
                BigInteger bigInteger = this.b;
                BigInteger bigInteger2 = e;
                if (y.compareTo(bigInteger.subtract(bigInteger2)) < 0) {
                    BigInteger modPow = y.modPow(this.a, this.b);
                    this.d = modPow;
                    if (modPow.compareTo(bigInteger2) == 0) {
                        throw new InvalidKeyException("Shared key can't be 1");
                    } else if (z) {
                        return null;
                    } else {
                        return new BCDHPublicKey(this.d, dHPublicKey.getParams());
                    }
                }
            }
            throw new InvalidKeyException("Invalid DH PublicKey");
        } else {
            throw new InvalidKeyException("DHKeyAgreement doPhase requires DHPublicKey");
        }
    }

    public final byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.a != null) {
            return super.engineGenerateSecret();
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    public final void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            if (algorithmParameterSpec == null) {
                this.b = dHPrivateKey.getParams().getP();
                this.c = dHPrivateKey.getParams().getG();
            } else if (algorithmParameterSpec instanceof DHParameterSpec) {
                DHParameterSpec dHParameterSpec = (DHParameterSpec) algorithmParameterSpec;
                this.b = dHParameterSpec.getP();
                this.c = dHParameterSpec.getG();
            } else if (algorithmParameterSpec instanceof UserKeyingMaterialSpec) {
                this.b = dHPrivateKey.getParams().getP();
                this.c = dHPrivateKey.getParams().getG();
                UserKeyingMaterialSpec userKeyingMaterialSpec = (UserKeyingMaterialSpec) algorithmParameterSpec;
                this.f6479a = Arrays.c((byte[]) null);
            } else {
                throw new InvalidAlgorithmParameterException("DHKeyAgreement only accepts DHParameterSpec");
            }
            BigInteger x = dHPrivateKey.getX();
            this.d = x;
            this.a = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey for initialisation");
    }

    public KeyAgreementSpi(DHKEKGenerator dHKEKGenerator) {
        super("DHwithRFC2631KDF", dHKEKGenerator);
    }

    public final int engineGenerateSecret(byte[] bArr, int i) throws IllegalStateException, ShortBufferException {
        if (this.a != null) {
            return super.engineGenerateSecret(bArr, i);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    public final SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        if (this.a != null) {
            byte[] b2 = b(this.d);
            if (!str.equals("TlsPremasterSecret")) {
                return super.engineGenerateSecret(str);
            }
            if (b2[0] == 0) {
                int i = 0;
                while (i < b2.length && b2[i] == 0) {
                    i++;
                }
                int length = b2.length - i;
                byte[] bArr = new byte[length];
                System.arraycopy(b2, i, bArr, 0, length);
                b2 = bArr;
            }
            return new SecretKeySpec(b2, str);
        }
        throw new IllegalStateException("Diffie-Hellman not initialised.");
    }

    public final void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        if (key instanceof DHPrivateKey) {
            DHPrivateKey dHPrivateKey = (DHPrivateKey) key;
            this.b = dHPrivateKey.getParams().getP();
            this.c = dHPrivateKey.getParams().getG();
            BigInteger x = dHPrivateKey.getX();
            this.d = x;
            this.a = x;
            return;
        }
        throw new InvalidKeyException("DHKeyAgreement requires DHPrivateKey");
    }
}
