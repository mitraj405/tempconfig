package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.Wrapper;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.crypto.params.ParametersWithSBox;
import org.spongycastle.crypto.params.ParametersWithUKM;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;
import org.spongycastle.jcajce.spec.GOST28147WrapParameterSpec;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Arrays;

public abstract class BaseWrapCipher extends CipherSpi implements PBE {
    public AlgorithmParameters a = null;

    /* renamed from: a  reason: collision with other field name */
    public final Wrapper f6558a = null;

    /* renamed from: a  reason: collision with other field name */
    public final BCJcaJceHelper f6559a = new BCJcaJceHelper();

    /* renamed from: a  reason: collision with other field name */
    public byte[] f6560a;

    /* renamed from: a  reason: collision with other field name */
    public final Class[] f6561a = {GOST28147WrapParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
    public final int c;

    public BaseWrapCipher() {
    }

    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, BadPaddingException, ShortBufferException {
        return 0;
    }

    public int engineGetBlockSize() {
        return 0;
    }

    public byte[] engineGetIV() {
        return Arrays.c(this.f6560a);
    }

    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    public int engineGetOutputSize(int i) {
        return -1;
    }

    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithIV parametersWithIV;
        int i2;
        boolean z = key instanceof BCPBEKey;
        Wrapper wrapper = this.f6558a;
        if (z) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                parametersWithIV = PBE.Util.e(bCPBEKey, algorithmParameterSpec, wrapper.b());
            } else {
                parametersWithIV = bCPBEKey.f6539a;
                if (parametersWithIV == null) {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
            }
        } else {
            parametersWithIV = new KeyParameter(key.getEncoded());
        }
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            parametersWithIV = new ParametersWithIV(parametersWithIV, ((IvParameterSpec) algorithmParameterSpec).getIV());
        }
        if (algorithmParameterSpec instanceof GOST28147WrapParameterSpec) {
            ((GOST28147WrapParameterSpec) algorithmParameterSpec).getClass();
            byte[] c2 = Arrays.c((byte[]) null);
            if (c2 != null) {
                parametersWithIV = new ParametersWithSBox(parametersWithIV, c2);
            }
            parametersWithIV = new ParametersWithUKM(parametersWithIV, Arrays.c((byte[]) null));
        }
        if ((parametersWithIV instanceof KeyParameter) && (i2 = this.c) != 0) {
            byte[] bArr = new byte[i2];
            this.f6560a = bArr;
            secureRandom.nextBytes(bArr);
            parametersWithIV = new ParametersWithIV(parametersWithIV, this.f6560a);
        }
        if (secureRandom != null) {
            parametersWithIV = new ParametersWithRandom(parametersWithIV, secureRandom);
        }
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException("engine only valid for wrapping");
        } else if (i == 3) {
            wrapper.a(true, parametersWithIV);
        } else if (i != 4) {
            System.out.println("eeek!");
        } else {
            wrapper.a(false, parametersWithIV);
        }
    }

    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException(C0709Uj.i("can't support mode ", str));
    }

    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException(lf.j("Padding ", str, " unknown."));
    }

    public final Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException, NoSuchAlgorithmException {
        byte[] bArr2;
        try {
            Wrapper wrapper = this.f6558a;
            if (wrapper == null) {
                bArr2 = engineDoFinal(bArr, 0, bArr.length);
            } else {
                bArr2 = wrapper.c(bArr, bArr.length);
            }
            if (i == 3) {
                return new SecretKeySpec(bArr2, str);
            }
            if (!str.equals("") || i != 2) {
                try {
                    KeyFactory c2 = this.f6559a.c(str);
                    if (i == 1) {
                        return c2.generatePublic(new X509EncodedKeySpec(bArr2));
                    }
                    if (i == 2) {
                        return c2.generatePrivate(new PKCS8EncodedKeySpec(bArr2));
                    }
                    throw new InvalidKeyException(lf.h("Unknown key type ", i));
                } catch (NoSuchProviderException e) {
                    throw new InvalidKeyException("Unknown key type " + e.getMessage());
                } catch (InvalidKeySpecException e2) {
                    throw new InvalidKeyException("Unknown key type " + e2.getMessage());
                }
            } else {
                try {
                    PrivateKeyInfo g = PrivateKeyInfo.g(bArr2);
                    PrivateKey f = BouncyCastleProvider.f(g);
                    if (f != null) {
                        return f;
                    }
                    throw new InvalidKeyException("algorithm " + g.f5702a.Z0 + " not supported");
                } catch (Exception unused) {
                    throw new InvalidKeyException("Invalid key encoding.");
                }
            }
        } catch (InvalidCipherTextException e3) {
            throw new InvalidKeyException(e3.getMessage());
        } catch (BadPaddingException e4) {
            throw new InvalidKeyException(e4.getMessage());
        } catch (IllegalBlockSizeException e5) {
            throw new InvalidKeyException(e5.getMessage());
        }
    }

    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        throw new RuntimeException("not supported for wrapping");
    }

    public final byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded != null) {
            try {
                Wrapper wrapper = this.f6558a;
                if (wrapper == null) {
                    return engineDoFinal(encoded, 0, encoded.length);
                }
                return wrapper.d(encoded, encoded.length);
            } catch (BadPaddingException e) {
                throw new IllegalBlockSizeException(e.getMessage());
            }
        } else {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
    }

    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException, BadPaddingException {
        return null;
    }

    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        throw new RuntimeException("not supported for wrapping");
    }

    public BaseWrapCipher(Wrapper wrapper, int i) {
        this.f6558a = wrapper;
        this.c = i;
    }

    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i2 = 0;
            while (true) {
                Class[] clsArr = this.f6561a;
                if (i2 == clsArr.length) {
                    break;
                }
                try {
                    algorithmParameterSpec = algorithmParameters.getParameterSpec(clsArr[i2]);
                    break;
                } catch (Exception unused) {
                    i2++;
                }
            }
            if (algorithmParameterSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        }
        this.a = algorithmParameters;
        engineInit(i, key, algorithmParameterSpec, secureRandom);
    }

    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
