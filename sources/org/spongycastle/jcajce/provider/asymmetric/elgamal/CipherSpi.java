package org.spongycastle.jcajce.provider.asymmetric.elgamal;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.BufferedAsymmetricBlockCipher;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.encodings.ISO9796d1Encoding;
import org.spongycastle.crypto.encodings.OAEPEncoding;
import org.spongycastle.crypto.encodings.PKCS1Encoding;
import org.spongycastle.crypto.engines.ElGamalEngine;
import org.spongycastle.crypto.params.ElGamalParameters;
import org.spongycastle.crypto.params.ElGamalPrivateKeyParameters;
import org.spongycastle.crypto.params.ElGamalPublicKeyParameters;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.jcajce.provider.asymmetric.util.BaseCipherSpi;
import org.spongycastle.jcajce.provider.util.BadBlockException;
import org.spongycastle.jcajce.provider.util.DigestFactory;
import org.spongycastle.jce.interfaces.ElGamalKey;
import org.spongycastle.jce.interfaces.ElGamalPrivateKey;
import org.spongycastle.jce.interfaces.ElGamalPublicKey;
import org.spongycastle.util.Strings;

public class CipherSpi extends BaseCipherSpi {
    public AlgorithmParameters a;

    /* renamed from: a  reason: collision with other field name */
    public OAEPParameterSpec f6439a;

    /* renamed from: a  reason: collision with other field name */
    public BufferedAsymmetricBlockCipher f6440a;

    public static class NoPadding extends CipherSpi {
        public NoPadding() {
            super(new ElGamalEngine());
        }
    }

    public static class PKCS1v1_5Padding extends CipherSpi {
        public PKCS1v1_5Padding() {
            super(new PKCS1Encoding(new ElGamalEngine()));
        }
    }

    public CipherSpi(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f6440a = new BufferedAsymmetricBlockCipher(asymmetricBlockCipher);
    }

    public final byte[] a() throws BadPaddingException {
        try {
            BufferedAsymmetricBlockCipher bufferedAsymmetricBlockCipher = this.f6440a;
            byte[] c = bufferedAsymmetricBlockCipher.f5792a.c(0, bufferedAsymmetricBlockCipher.f5793a, bufferedAsymmetricBlockCipher.a);
            if (bufferedAsymmetricBlockCipher.f5793a != null) {
                int i = 0;
                while (true) {
                    byte[] bArr = bufferedAsymmetricBlockCipher.f5793a;
                    if (i >= bArr.length) {
                        break;
                    }
                    bArr[i] = 0;
                    i++;
                }
            }
            bufferedAsymmetricBlockCipher.a = 0;
            return c;
        } catch (InvalidCipherTextException e) {
            throw new BadPaddingException() {
                public final synchronized Throwable getCause() {
                    return InvalidCipherTextException.this;
                }
            };
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new BadBlockException("unable to decrypt block", e2);
        }
    }

    public final void b(OAEPParameterSpec oAEPParameterSpec) throws NoSuchPaddingException {
        MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) oAEPParameterSpec.getMGFParameters();
        ExtendedDigest a2 = DigestFactory.a(mGF1ParameterSpec.getDigestAlgorithm());
        if (a2 != null) {
            this.f6440a = new BufferedAsymmetricBlockCipher(new OAEPEncoding(new ElGamalEngine(), a2, a2, ((PSource.PSpecified) oAEPParameterSpec.getPSource()).getValue()));
            this.f6439a = oAEPParameterSpec;
            return;
        }
        throw new NoSuchPaddingException("no match on OAEP constructor for digest algorithm: " + mGF1ParameterSpec.getDigestAlgorithm());
    }

    public final byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        this.f6440a.a(i, bArr, i2);
        return a();
    }

    public final int engineGetBlockSize() {
        return this.f6440a.f5792a.d();
    }

    public final int engineGetKeySize(Key key) {
        if (key instanceof ElGamalKey) {
            return ((ElGamalKey) key).a().a.bitLength();
        }
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        throw new IllegalArgumentException("not an ElGamal key!");
    }

    public final int engineGetOutputSize(int i) {
        return this.f6440a.f5792a.b();
    }

    public final AlgorithmParameters engineGetParameters() {
        if (this.a == null && this.f6439a != null) {
            try {
                AlgorithmParameters b = this.a.b("OAEP");
                this.a = b;
                b.init(this.f6439a);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.a;
    }

    public final void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException {
        ParametersWithRandom parametersWithRandom;
        if (algorithmParameterSpec == null) {
            if (key instanceof ElGamalPublicKey) {
                PublicKey publicKey = (PublicKey) key;
                if (publicKey instanceof ElGamalPublicKey) {
                    ElGamalPublicKey elGamalPublicKey = (ElGamalPublicKey) publicKey;
                    parametersWithRandom = new ElGamalPublicKeyParameters(elGamalPublicKey.getY(), new ElGamalParameters(0, elGamalPublicKey.a().a, elGamalPublicKey.a().b));
                } else if (publicKey instanceof DHPublicKey) {
                    DHPublicKey dHPublicKey = (DHPublicKey) publicKey;
                    parametersWithRandom = new ElGamalPublicKeyParameters(dHPublicKey.getY(), new ElGamalParameters(0, dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG()));
                } else {
                    throw new InvalidKeyException("can't identify public key for El Gamal.");
                }
            } else if (key instanceof ElGamalPrivateKey) {
                PrivateKey privateKey = (PrivateKey) key;
                if (privateKey instanceof ElGamalPrivateKey) {
                    ElGamalPrivateKey elGamalPrivateKey = (ElGamalPrivateKey) privateKey;
                    parametersWithRandom = new ElGamalPrivateKeyParameters(elGamalPrivateKey.getX(), new ElGamalParameters(0, elGamalPrivateKey.a().a, elGamalPrivateKey.a().b));
                } else if (privateKey instanceof DHPrivateKey) {
                    DHPrivateKey dHPrivateKey = (DHPrivateKey) privateKey;
                    parametersWithRandom = new ElGamalPrivateKeyParameters(dHPrivateKey.getX(), new ElGamalParameters(0, dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG()));
                } else {
                    throw new InvalidKeyException("can't identify private key for El Gamal.");
                }
            } else {
                throw new InvalidKeyException("unknown key type passed to ElGamal");
            }
            if (secureRandom != null) {
                parametersWithRandom = new ParametersWithRandom(parametersWithRandom, secureRandom);
            }
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new InvalidParameterException(C1058d.y("unknown opmode ", i, " passed to ElGamal"));
                        }
                    }
                }
                BufferedAsymmetricBlockCipher bufferedAsymmetricBlockCipher = this.f6440a;
                if (bufferedAsymmetricBlockCipher.f5793a != null) {
                    int i2 = 0;
                    while (true) {
                        byte[] bArr = bufferedAsymmetricBlockCipher.f5793a;
                        if (i2 >= bArr.length) {
                            break;
                        }
                        bArr[i2] = 0;
                        i2++;
                    }
                }
                bufferedAsymmetricBlockCipher.a = 0;
                AsymmetricBlockCipher asymmetricBlockCipher = bufferedAsymmetricBlockCipher.f5792a;
                asymmetricBlockCipher.a(false, parametersWithRandom);
                bufferedAsymmetricBlockCipher.f5793a = new byte[(asymmetricBlockCipher.d() + 0)];
                bufferedAsymmetricBlockCipher.a = 0;
                return;
            }
            BufferedAsymmetricBlockCipher bufferedAsymmetricBlockCipher2 = this.f6440a;
            if (bufferedAsymmetricBlockCipher2.f5793a != null) {
                int i3 = 0;
                while (true) {
                    byte[] bArr2 = bufferedAsymmetricBlockCipher2.f5793a;
                    if (i3 >= bArr2.length) {
                        break;
                    }
                    bArr2[i3] = 0;
                    i3++;
                }
            }
            bufferedAsymmetricBlockCipher2.a = 0;
            AsymmetricBlockCipher asymmetricBlockCipher2 = bufferedAsymmetricBlockCipher2.f5792a;
            asymmetricBlockCipher2.a(true, parametersWithRandom);
            bufferedAsymmetricBlockCipher2.f5793a = new byte[(asymmetricBlockCipher2.d() + 1)];
            bufferedAsymmetricBlockCipher2.a = 0;
            return;
        }
        throw new IllegalArgumentException("unknown parameter type.");
    }

    public final void engineSetMode(String str) throws NoSuchAlgorithmException {
        String g = Strings.g(str);
        if (!g.equals("NONE") && !g.equals("ECB")) {
            throw new NoSuchAlgorithmException("can't support mode ".concat(str));
        }
    }

    public final void engineSetPadding(String str) throws NoSuchPaddingException {
        String g = Strings.g(str);
        if (g.equals("NOPADDING")) {
            this.f6440a = new BufferedAsymmetricBlockCipher(new ElGamalEngine());
        } else if (g.equals("PKCS1PADDING")) {
            this.f6440a = new BufferedAsymmetricBlockCipher(new PKCS1Encoding(new ElGamalEngine()));
        } else if (g.equals("ISO9796-1PADDING")) {
            this.f6440a = new BufferedAsymmetricBlockCipher(new ISO9796d1Encoding(new ElGamalEngine()));
        } else if (g.equals("OAEPPADDING")) {
            b(OAEPParameterSpec.DEFAULT);
        } else if (g.equals("OAEPWITHMD5ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("MD5", "MGF1", new MGF1ParameterSpec("MD5"), PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPWITHSHA1ANDMGF1PADDING")) {
            b(OAEPParameterSpec.DEFAULT);
        } else if (g.equals("OAEPWITHSHA224ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA-224", "MGF1", new MGF1ParameterSpec("SHA-224"), PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPWITHSHA256ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPWITHSHA384ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA-384", "MGF1", MGF1ParameterSpec.SHA384, PSource.PSpecified.DEFAULT));
        } else if (g.equals("OAEPWITHSHA512ANDMGF1PADDING")) {
            b(new OAEPParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, PSource.PSpecified.DEFAULT));
        } else {
            throw new NoSuchPaddingException(str.concat(" unavailable with ElGamal."));
        }
    }

    public final byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.f6440a.a(i, bArr, i2);
        return null;
    }

    public final int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f6440a.a(i, bArr, i2);
        return 0;
    }

    public final int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        this.f6440a.a(i, bArr, i2);
        byte[] a2 = a();
        for (int i4 = 0; i4 != a2.length; i4++) {
            bArr2[i3 + i4] = a2[i4];
        }
        return a2.length;
    }

    public final void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("can't handle parameters in ElGamal");
    }

    public final void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
    }
}
