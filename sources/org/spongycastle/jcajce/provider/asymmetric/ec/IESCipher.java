package org.spongycastle.jcajce.provider.asymmetric.ec;

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
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.KeyEncoder;
import org.spongycastle.crypto.agreement.ECDHBasicAgreement;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.engines.AESEngine;
import org.spongycastle.crypto.engines.DESedeEngine;
import org.spongycastle.crypto.engines.IESEngine;
import org.spongycastle.crypto.generators.ECKeyPairGenerator;
import org.spongycastle.crypto.generators.EphemeralKeyPairGenerator;
import org.spongycastle.crypto.generators.KDF2BytesGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.ECDomainParameters;
import org.spongycastle.crypto.params.ECKeyGenerationParameters;
import org.spongycastle.crypto.params.ECKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.IESWithCipherParameters;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.parsers.ECIESPublicKeyParser;
import org.spongycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.spongycastle.jcajce.provider.asymmetric.util.IESUtil;
import org.spongycastle.jcajce.provider.util.BadBlockException;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jce.interfaces.ECKey;
import org.spongycastle.jce.interfaces.IESKey;
import org.spongycastle.jce.spec.IESParameterSpec;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class IESCipher extends CipherSpi {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final ByteArrayOutputStream f6390a = new ByteArrayOutputStream();

    /* renamed from: a  reason: collision with other field name */
    public AlgorithmParameters f6391a = null;

    /* renamed from: a  reason: collision with other field name */
    public SecureRandom f6392a;

    /* renamed from: a  reason: collision with other field name */
    public final IESEngine f6393a;

    /* renamed from: a  reason: collision with other field name */
    public AsymmetricKeyParameter f6394a;

    /* renamed from: a  reason: collision with other field name */
    public final BCJcaJceHelper f6395a = new BCJcaJceHelper();

    /* renamed from: a  reason: collision with other field name */
    public IESParameterSpec f6396a = null;
    public int b = -1;

    /* renamed from: b  reason: collision with other field name */
    public AsymmetricKeyParameter f6397b = null;

    public static class ECIES extends IESCipher {
        public ECIES() {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest())));
        }
    }

    public static class ECIESwithAESCBC extends ECIESwithCipher {
        public ECIESwithAESCBC() {
            super(new CBCBlockCipher(new AESEngine()), 16);
        }
    }

    public static class ECIESwithCipher extends IESCipher {
        public ECIESwithCipher(CBCBlockCipher cBCBlockCipher, int i) {
            super(new IESEngine(new ECDHBasicAgreement(), new KDF2BytesGenerator(new SHA1Digest()), new HMac(new SHA1Digest()), new PaddedBufferedBlockCipher(cBCBlockCipher)), i);
        }
    }

    public static class ECIESwithDESedeCBC extends ECIESwithCipher {
        public ECIESwithDESedeCBC() {
            super(new CBCBlockCipher(new DESedeEngine()), 8);
        }
    }

    public IESCipher(IESEngine iESEngine) {
        this.f6393a = iESEngine;
        this.a = 0;
    }

    public final byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        ByteArrayOutputStream byteArrayOutputStream = this.f6390a;
        if (i2 != 0) {
            byteArrayOutputStream.write(bArr, i, i2);
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        byte[] c = Arrays.c(this.f6396a.f6607a);
        byte[] c2 = Arrays.c(this.f6396a.f6608b);
        IESParameterSpec iESParameterSpec = this.f6396a;
        CipherParameters iESWithCipherParameters = new IESWithCipherParameters(iESParameterSpec.a, iESParameterSpec.b, c, c2);
        if (iESParameterSpec.a() != null) {
            iESWithCipherParameters = new ParametersWithIV(iESWithCipherParameters, this.f6396a.a());
        }
        AsymmetricKeyParameter asymmetricKeyParameter = this.f6394a;
        ECDomainParameters eCDomainParameters = ((ECKeyParameters) asymmetricKeyParameter).a;
        AsymmetricKeyParameter asymmetricKeyParameter2 = this.f6397b;
        IESEngine iESEngine = this.f6393a;
        if (asymmetricKeyParameter2 != null) {
            try {
                int i3 = this.b;
                if (i3 != 1) {
                    if (i3 != 3) {
                        iESEngine.e(false, asymmetricKeyParameter, asymmetricKeyParameter2, iESWithCipherParameters);
                        return iESEngine.f(byteArray, byteArray.length);
                    }
                }
                iESEngine.e(true, asymmetricKeyParameter2, asymmetricKeyParameter, iESWithCipherParameters);
                return iESEngine.f(byteArray, byteArray.length);
            } catch (Exception e) {
                throw new BadBlockException("unable to process block", e);
            }
        } else {
            int i4 = this.b;
            if (i4 == 1 || i4 == 3) {
                ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
                eCKeyPairGenerator.b(new ECKeyGenerationParameters(this.f6392a, eCDomainParameters));
                final boolean z = this.f6396a.f6606a;
                EphemeralKeyPairGenerator ephemeralKeyPairGenerator = new EphemeralKeyPairGenerator(eCKeyPairGenerator, new KeyEncoder() {
                    public final byte[] a(AsymmetricKeyParameter asymmetricKeyParameter) {
                        return ((ECPublicKeyParameters) asymmetricKeyParameter).a.h(z);
                    }
                });
                try {
                    AsymmetricKeyParameter asymmetricKeyParameter3 = this.f6394a;
                    iESEngine.f5989a = true;
                    iESEngine.b = asymmetricKeyParameter3;
                    iESEngine.f5987a = ephemeralKeyPairGenerator;
                    iESEngine.c(iESWithCipherParameters);
                    return iESEngine.f(byteArray, byteArray.length);
                } catch (Exception e2) {
                    throw new BadBlockException("unable to process block", e2);
                }
            } else if (i4 == 2 || i4 == 4) {
                try {
                    ECIESPublicKeyParser eCIESPublicKeyParser = new ECIESPublicKeyParser(eCDomainParameters);
                    iESEngine.f5989a = false;
                    iESEngine.f5983a = asymmetricKeyParameter;
                    iESEngine.f5985a = eCIESPublicKeyParser;
                    iESEngine.c(iESWithCipherParameters);
                    return iESEngine.f(byteArray, byteArray.length);
                } catch (InvalidCipherTextException e3) {
                    throw new BadBlockException("unable to process block", e3);
                }
            } else {
                throw new IllegalStateException("cipher not initialised");
            }
        }
    }

    public final int engineGetBlockSize() {
        BufferedBlockCipher bufferedBlockCipher = this.f6393a.f5982a;
        if (bufferedBlockCipher != null) {
            return bufferedBlockCipher.b();
        }
        return 0;
    }

    public final byte[] engineGetIV() {
        IESParameterSpec iESParameterSpec = this.f6396a;
        if (iESParameterSpec != null) {
            return iESParameterSpec.a();
        }
        return null;
    }

    public final int engineGetKeySize(Key key) {
        if (key instanceof ECKey) {
            return ((ECKey) key).a().f6602a.k();
        }
        throw new IllegalArgumentException("not an EC key");
    }

    public final int engineGetOutputSize(int i) {
        int i2;
        int size;
        if (this.f6394a != null) {
            IESEngine iESEngine = this.f6393a;
            int e = iESEngine.f5986a.e();
            if (this.f6397b == null) {
                i2 = ((((ECKeyParameters) this.f6394a).a.a.k() + 7) / 8) * 2;
            } else {
                i2 = 0;
            }
            BufferedBlockCipher bufferedBlockCipher = iESEngine.f5982a;
            if (bufferedBlockCipher != null) {
                int i3 = this.b;
                if (i3 == 1 || i3 == 3) {
                    i = bufferedBlockCipher.c(i);
                } else if (i3 == 2 || i3 == 4) {
                    i = bufferedBlockCipher.c((i - e) - i2);
                } else {
                    throw new IllegalStateException("cipher not initialised");
                }
            }
            int i4 = this.b;
            ByteArrayOutputStream byteArrayOutputStream = this.f6390a;
            if (i4 == 1 || i4 == 3) {
                size = byteArrayOutputStream.size() + e + 1 + i2;
            } else if (i4 == 2 || i4 == 4) {
                size = (byteArrayOutputStream.size() - e) - i2;
            } else {
                throw new IllegalStateException("cipher not initialised");
            }
            return size + i;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    public final AlgorithmParameters engineGetParameters() {
        if (this.f6391a == null && this.f6396a != null) {
            try {
                AlgorithmParameters b2 = this.f6395a.b("IES");
                this.f6391a = b2;
                b2.init(this.f6396a);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.f6391a;
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
        this.f6391a = algorithmParameters;
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
        this.f6390a.write(bArr, i, i2);
        return null;
    }

    public final int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f6390a.write(bArr, i, i2);
        return 0;
    }

    public IESCipher(IESEngine iESEngine, int i) {
        this.f6393a = iESEngine;
        this.a = i;
    }

    public final void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException, InvalidKeyException {
        byte[] bArr;
        this.f6397b = null;
        int i2 = this.a;
        if (algorithmParameterSpec == null) {
            if (i2 == 0 || i != 1) {
                bArr = null;
            } else {
                bArr = new byte[i2];
                secureRandom.nextBytes(bArr);
            }
            this.f6396a = IESUtil.a(this.f6393a.f5982a, bArr);
        } else if (algorithmParameterSpec instanceof IESParameterSpec) {
            this.f6396a = (IESParameterSpec) algorithmParameterSpec;
        } else {
            throw new InvalidAlgorithmParameterException("must be passed IES parameters");
        }
        byte[] a2 = this.f6396a.a();
        if (i2 == 0 || (a2 != null && a2.length == i2)) {
            if (i == 1 || i == 3) {
                if (key instanceof PublicKey) {
                    this.f6394a = ECUtils.a((PublicKey) key);
                } else if (key instanceof IESKey) {
                    IESKey iESKey = (IESKey) key;
                    iESKey.q();
                    this.f6394a = ECUtils.a((PublicKey) null);
                    iESKey.N();
                    this.f6397b = ECUtil.b((PrivateKey) null);
                } else {
                    throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
                }
            } else if (i != 2 && i != 4) {
                throw new InvalidKeyException("must be passed EC key");
            } else if (key instanceof PrivateKey) {
                this.f6394a = ECUtil.b((PrivateKey) key);
            } else if (key instanceof IESKey) {
                IESKey iESKey2 = (IESKey) key;
                iESKey2.q();
                this.f6397b = ECUtils.a((PublicKey) null);
                iESKey2.N();
                this.f6394a = ECUtil.b((PrivateKey) null);
            } else {
                throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
            }
            this.f6392a = secureRandom;
            this.b = i;
            this.f6390a.reset();
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
