package org.spongycastle.jcajce.provider.asymmetric.dh;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.KeyEncoder;
import org.spongycastle.crypto.agreement.DHBasicAgreement;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.generators.DHKeyPairGenerator;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHKeyGenerationParameters;
import org.spongycastle.crypto.params.DHKeyParameters;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.parsers.DHIESPublicKeyParser;
import org.spongycastle.jcajce.provider.asymmetric.util.DHUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.spongycastle.jcajce.provider.util.BadBlockException;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.BigIntegers;
import org.spongycastle.util.Strings;

public class IESCipher extends CipherSpi {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final ByteArrayOutputStream f6346a = new ByteArrayOutputStream();

    /* renamed from: a  reason: collision with other field name */
    public AlgorithmParameters f6347a = null;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6348a;

    /* renamed from: a  reason: collision with other field name */
    public final IESEngine f6349a;

    /* renamed from: a  reason: collision with other field name */
    public DHKeyParameters f6350a;

    /* renamed from: a  reason: collision with other field name */
    public final BCJcaJceHelper f6351a = new BCJcaJceHelper();

    /* renamed from: a  reason: collision with other field name */
    public IESParameterSpec f6352a = null;
    public int b = -1;

    /* renamed from: b  reason: collision with other field name */
    public DHKeyParameters f6353b = null;

    public static class IES extends IESCipher {
        public IES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class IESwithAESCBC extends IESCipher {
        public IESwithAESCBC() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()))), 16);
        }
    }

    public static class IESwithDESedeCBC extends IESCipher {
        public IESwithDESedeCBC() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(new CBCBlockCipher(new DESedeEngine()))), 8);
        }
    }

    public IESCipher(IESEngine iESEngine) {
        this.f6349a = iESEngine;
        this.a = 0;
    }

    public final byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        ByteArrayOutputStream byteArrayOutputStream = this.f6346a;
        if (i2 != 0) {
            byteArrayOutputStream.write(bArr, i, i2);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        byte[] c = Arrays.c(this.f6352a.f6607a);
        byte[] c2 = Arrays.c(this.f6352a.f6608b);
        IESParameterSpec iESParameterSpec = this.f6352a;
        CipherParameters iESWithCipherParameters = new IESWithCipherParameters(iESParameterSpec.a, iESParameterSpec.b, c, c2);
        if (iESParameterSpec.a() != null) {
            iESWithCipherParameters = new ParametersWithIV(iESWithCipherParameters, this.f6352a.a());
        }
        DHKeyParameters dHKeyParameters = this.f6350a;
        DHParameters dHParameters = dHKeyParameters.a;
        DHKeyParameters dHKeyParameters2 = this.f6353b;
        IESEngine iESEngine = this.f6349a;
        if (dHKeyParameters2 != null) {
            try {
                int i3 = this.b;
                if (i3 != 1) {
                    if (i3 != 3) {
                        iESEngine.e(false, dHKeyParameters, dHKeyParameters2, iESWithCipherParameters);
                        return iESEngine.f(byteArray, byteArray.length);
                    }
                }
                iESEngine.e(true, dHKeyParameters2, dHKeyParameters, iESWithCipherParameters);
                return iESEngine.f(byteArray, byteArray.length);
            } catch (Exception e) {
                throw new BadBlockException("unable to process block", e);
            }
        } else {
            int i4 = this.b;
            if (i4 == 1 || i4 == 3) {
                DHKeyPairGenerator dHKeyPairGenerator = new DHKeyPairGenerator();
                dHKeyPairGenerator.a = new DHKeyGenerationParameters(this.f6348a, dHParameters);
                EphemeralKeyPairGenerator ephemeralKeyPairGenerator = new EphemeralKeyPairGenerator(dHKeyPairGenerator, new KeyEncoder() {
                    public final byte[] a(AsymmetricKeyParameter asymmetricKeyParameter) {
                        int bitLength = (((DHKeyParameters) asymmetricKeyParameter).a.b.bitLength() + 7) / 8;
                        byte[] bArr = new byte[bitLength];
                        byte[] b = BigIntegers.b(((DHPublicKeyParameters) asymmetricKeyParameter).a);
                        if (b.length <= bitLength) {
                            System.arraycopy(b, 0, bArr, bitLength - b.length, b.length);
                            return bArr;
                        }
                        throw new IllegalArgumentException("Senders's public key longer than expected.");
                    }
                });
                try {
                    DHKeyParameters dHKeyParameters3 = this.f6350a;
                    iESEngine.f5989a = true;
                    iESEngine.b = dHKeyParameters3;
                    iESEngine.f5987a = ephemeralKeyPairGenerator;
                    iESEngine.c(iESWithCipherParameters);
                    return iESEngine.f(byteArray, byteArray.length);
                } catch (Exception e2) {
                    throw new BadBlockException("unable to process block", e2);
                }
            } else if (i4 == 2 || i4 == 4) {
                try {
                    DHIESPublicKeyParser dHIESPublicKeyParser = new DHIESPublicKeyParser(dHParameters);
                    iESEngine.f5989a = false;
                    iESEngine.f5983a = dHKeyParameters;
                    iESEngine.f5985a = dHIESPublicKeyParser;
                    iESEngine.c(iESWithCipherParameters);
                    return iESEngine.f(byteArray, byteArray.length);
                } catch (InvalidCipherTextException e3) {
                    throw new BadBlockException("unable to process block", e3);
                }
            } else {
                throw new IllegalStateException("IESCipher not initialised");
            }
        }
    }

    public final int engineGetBlockSize() {
        BufferedBlockCipher bufferedBlockCipher = this.f6349a.f5982a;
        if (bufferedBlockCipher != null) {
            return bufferedBlockCipher.b();
        }
        return 0;
    }

    public final byte[] engineGetIV() {
        IESParameterSpec iESParameterSpec = this.f6352a;
        if (iESParameterSpec != null) {
            return iESParameterSpec.a();
        }
        return null;
    }

    public final int engineGetKeySize(Key key) {
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        throw new IllegalArgumentException("not a DH key");
    }

    public final int engineGetOutputSize(int i) {
        int i2;
        int i3;
        if (this.f6350a != null) {
            IESEngine iESEngine = this.f6349a;
            int e = iESEngine.f5986a.e();
            if (this.f6353b == null) {
                i2 = (((this.f6350a.a.b.bitLength() + 7) * 2) / 8) + 1;
            } else {
                i2 = 0;
            }
            BufferedBlockCipher bufferedBlockCipher = iESEngine.f5982a;
            if (bufferedBlockCipher != null) {
                int i4 = this.b;
                if (i4 == 1 || i4 == 3) {
                    i = bufferedBlockCipher.c(i);
                } else if (i4 == 2 || i4 == 4) {
                    i = bufferedBlockCipher.c((i - e) - i2);
                } else {
                    throw new IllegalStateException("cipher not initialised");
                }
            }
            int i5 = this.b;
            ByteArrayOutputStream byteArrayOutputStream = this.f6346a;
            if (i5 == 1 || i5 == 3) {
                i3 = byteArrayOutputStream.size() + e + i2;
            } else if (i5 == 2 || i5 == 4) {
                i3 = (byteArrayOutputStream.size() - e) - i2;
            } else {
                throw new IllegalStateException("IESCipher not initialised");
            }
            return i3 + i;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    public final AlgorithmParameters engineGetParameters() {
        if (this.f6347a == null && this.f6352a != null) {
            try {
                AlgorithmParameters b2 = this.f6351a.b("IES");
                this.f6347a = b2;
                b2.init(this.f6352a);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.f6347a;
    }

    public final void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec;
        if (algorithmParameters != null) {
            try {
                algorithmParameterSpec = algorithmParameters.getParameterSpec(IESParameterSpec.class);
            } catch (Exception e) {
                throw new InvalidAlgorithmParameterException(C1058d.x(e, new StringBuilder("cannot recognise parameters: ")));
            }
        } else {
            algorithmParameterSpec = null;
        }
        this.f6347a = algorithmParameters;
        engineInit(i, key, algorithmParameterSpec, secureRandom);
    }

    public final void engineSetMode(String str) throws NoSuchAlgorithmException {
        String g = Strings.g(str);
        if (!g.equals("NONE") && !g.equals("DHAES")) {
            throw new IllegalArgumentException("can't support mode ".concat(str));
        }
    }

    public final void engineSetPadding(String str) throws NoSuchPaddingException {
        String g = Strings.g(str);
        if (!g.equals("NOPADDING") && !g.equals("PKCS5PADDING") && !g.equals("PKCS7PADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
    }

    public final byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.f6346a.write(bArr, i, i2);
        return null;
    }

    public final int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f6346a.write(bArr, i, i2);
        return 0;
    }

    public IESCipher(IESEngine iESEngine, int i) {
        this.f6349a = iESEngine;
        this.a = i;
    }

    public final void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException, InvalidKeyException {
        byte[] bArr;
        int i2 = this.a;
        if (algorithmParameterSpec == null) {
            if (i2 == 0 || i != 1) {
                bArr = null;
            } else {
                bArr = new byte[i2];
                secureRandom.nextBytes(bArr);
            }
            this.f6352a = IESUtil.a(this.f6349a.f5982a, bArr);
        } else if (algorithmParameterSpec instanceof IESParameterSpec) {
            this.f6352a = (IESParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        byte[] a2 = this.f6352a.a();
        if (i2 == 0 || (a2 != null && a2.length == i2)) {
            if (i == 1 || i == 3) {
                if (key instanceof DHPublicKey) {
                    this.f6350a = DHUtil.b((PublicKey) key);
                } else if (key instanceof IESKey) {
                    IESKey iESKey = (IESKey) key;
                    iESKey.q();
                    this.f6350a = DHUtil.b((PublicKey) null);
                    iESKey.N();
                    this.f6353b = DHUtil.a((PrivateKey) null);
                } else {
                    throw new InvalidKeyException("must be passed recipient's public DH key for encryption");
                }
            } else if (i != 2 && i != 4) {
                throw new InvalidKeyException("must be passed EC key");
            } else if (key instanceof DHPrivateKey) {
                this.f6350a = DHUtil.a((PrivateKey) key);
            } else if (key instanceof IESKey) {
                IESKey iESKey2 = (IESKey) key;
                iESKey2.q();
                this.f6353b = DHUtil.b((PublicKey) null);
                iESKey2.N();
                this.f6350a = DHUtil.a((PrivateKey) null);
            } else {
                throw new InvalidKeyException("must be passed recipient's private DH key for decryption");
            }
            this.f6348a = secureRandom;
            this.b = i;
            this.f6346a.reset();
            return;
        }
        throw new InvalidAlgorithmParameterException(C1058d.y("NONCE in IES Parameters needs to be ", i2, " bytes long"));
    }

    public final int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException, IllegalBlockSizeException, BadPaddingException {
        byte[] engineDoFinal = engineDoFinal(bArr, i, i2);
        System.arraycopy(engineDoFinal, 0, bArr2, i3, engineDoFinal.length);
        return engineDoFinal.length;
    }

    public final void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException("cannot handle supplied parameter spec: " + e.getMessage());
        }
    }
}
