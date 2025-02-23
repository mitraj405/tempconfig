package org.spongycastle.jcajce.provider.symmetric.util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.PKCS12KeyWithParameters;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;

public class BaseStreamCipher extends BaseWrapCipher {
    public PBEParameterSpec a;

    /* renamed from: a  reason: collision with other field name */
    public final StreamCipher f6556a;

    /* renamed from: a  reason: collision with other field name */
    public ParametersWithIV f6557a;
    public final Class[] b;
    public String c;
    public final int d;
    public final int e;
    public final int f;

    public BaseStreamCipher() {
        throw null;
    }

    public BaseStreamCipher(StreamCipher streamCipher, int i, int i2, int i3) {
        this.b = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f = 0;
        this.a = null;
        this.c = null;
        this.f6556a = streamCipher;
        this.f = i;
        this.d = i2;
        this.e = i3;
    }

    public final byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        StreamCipher streamCipher = this.f6556a;
        if (i2 != 0) {
            byte[] engineUpdate = engineUpdate(bArr, i, i2);
            streamCipher.reset();
            return engineUpdate;
        }
        streamCipher.reset();
        return new byte[0];
    }

    public final int engineGetBlockSize() {
        return 0;
    }

    public final byte[] engineGetIV() {
        ParametersWithIV parametersWithIV = this.f6557a;
        if (parametersWithIV != null) {
            return parametersWithIV.f6233a;
        }
        return null;
    }

    public final int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    public final AlgorithmParameters engineGetParameters() {
        AlgorithmParameters algorithmParameters = this.a;
        if (algorithmParameters != null || this.a == null) {
            return algorithmParameters;
        }
        try {
            AlgorithmParameters b2 = this.f6559a.b(this.c);
            b2.init(this.a);
            return b2;
        } catch (Exception unused) {
            return null;
        }
    }

    public final void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        ParametersWithIV parametersWithIV;
        ParametersWithIV parametersWithIV2;
        CipherParameters cipherParameters;
        int i2 = i;
        Key key2 = key;
        AlgorithmParameterSpec algorithmParameterSpec2 = algorithmParameterSpec;
        this.a = null;
        this.c = null;
        this.a = null;
        if (key2 instanceof SecretKey) {
            boolean z = key2 instanceof PKCS12Key;
            int i3 = this.f;
            StreamCipher streamCipher = this.f6556a;
            if (z) {
                PKCS12Key pKCS12Key = (PKCS12Key) key2;
                PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec2;
                this.a = pBEParameterSpec;
                if ((pKCS12Key instanceof PKCS12KeyWithParameters) && pBEParameterSpec == null) {
                    PKCS12KeyWithParameters pKCS12KeyWithParameters = (PKCS12KeyWithParameters) pKCS12Key;
                    this.a = new PBEParameterSpec(pKCS12KeyWithParameters.getSalt(), pKCS12KeyWithParameters.getIterationCount());
                }
                parametersWithIV = PBE.Util.f(pKCS12Key.getEncoded(), 2, this.e, this.d, i3 * 8, this.a, streamCipher.b());
            } else {
                if (key2 instanceof BCPBEKey) {
                    BCPBEKey bCPBEKey = (BCPBEKey) key2;
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = bCPBEKey.Z0;
                    if (aSN1ObjectIdentifier != null) {
                        this.c = aSN1ObjectIdentifier.c;
                    } else {
                        this.c = bCPBEKey.getAlgorithm();
                    }
                    CipherParameters cipherParameters2 = bCPBEKey.f6539a;
                    if (cipherParameters2 != null) {
                        this.a = new PBEParameterSpec(bCPBEKey.getSalt(), bCPBEKey.getIterationCount());
                        cipherParameters = cipherParameters2;
                    } else if (algorithmParameterSpec2 instanceof PBEParameterSpec) {
                        CipherParameters e2 = PBE.Util.e(bCPBEKey, algorithmParameterSpec2, streamCipher.b());
                        this.a = (PBEParameterSpec) algorithmParameterSpec2;
                        cipherParameters = e2;
                    } else {
                        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                    }
                    parametersWithIV2 = cipherParameters;
                    if (bCPBEKey.f != 0) {
                        this.f6557a = (ParametersWithIV) cipherParameters;
                        parametersWithIV2 = cipherParameters;
                    }
                } else if (algorithmParameterSpec2 == null) {
                    if (this.e <= 0) {
                        parametersWithIV = new KeyParameter(key.getEncoded());
                    } else {
                        throw new InvalidKeyException("Algorithm requires a PBE key");
                    }
                } else if (algorithmParameterSpec2 instanceof IvParameterSpec) {
                    ParametersWithIV parametersWithIV3 = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec2).getIV());
                    this.f6557a = parametersWithIV3;
                    parametersWithIV2 = parametersWithIV3;
                } else {
                    throw new InvalidAlgorithmParameterException("unknown parameter type.");
                }
                parametersWithIV = parametersWithIV2;
            }
            if (i3 != 0 && !(parametersWithIV instanceof ParametersWithIV)) {
                SecureRandom secureRandom2 = secureRandom == null ? new SecureRandom() : secureRandom;
                if (i2 == 1 || i2 == 3) {
                    byte[] bArr = new byte[i3];
                    secureRandom2.nextBytes(bArr);
                    ParametersWithIV parametersWithIV4 = new ParametersWithIV(parametersWithIV, bArr, 0, i3);
                    this.f6557a = parametersWithIV4;
                    parametersWithIV = parametersWithIV4;
                } else {
                    throw new InvalidAlgorithmParameterException("no IV set when one expected");
                }
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            try {
                                throw new InvalidParameterException("unknown opmode " + i2 + " passed");
                            } catch (Exception e3) {
                                throw new InvalidKeyException(e3.getMessage());
                            }
                        }
                    }
                }
                streamCipher.a(false, parametersWithIV);
                return;
            }
            streamCipher.a(true, parametersWithIV);
            return;
        }
        throw new InvalidKeyException("Key for algorithm " + key.getAlgorithm() + " not suitable for symmetric enryption.");
    }

    public final void engineSetMode(String str) throws NoSuchAlgorithmException {
        if (!str.equalsIgnoreCase("ECB")) {
            throw new NoSuchAlgorithmException("can't support mode ".concat(str));
        }
    }

    public final void engineSetPadding(String str) throws NoSuchPaddingException {
        if (!str.equalsIgnoreCase("NoPadding")) {
            throw new NoSuchPaddingException(lf.j("Padding ", str, " unknown."));
        }
    }

    public final byte[] engineUpdate(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f6556a.d(bArr, i, i2, bArr2, 0);
        return bArr2;
    }

    public final int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        if (i3 + i2 <= bArr2.length) {
            try {
                this.f6556a.d(bArr, i, i2, bArr2, i3);
                return i2;
            } catch (DataLengthException e2) {
                throw new IllegalStateException(e2.getMessage());
            }
        } else {
            throw new ShortBufferException("output buffer too short for input.");
        }
    }

    public final int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        if (i3 + i2 <= bArr2.length) {
            if (i2 != 0) {
                this.f6556a.d(bArr, i, i2, bArr2, i3);
            }
            this.f6556a.reset();
            return i2;
        }
        throw new ShortBufferException("output buffer too short for input.");
    }

    public final int engineGetOutputSize(int i) {
        return i;
    }

    public final void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpec = null;
        if (algorithmParameters != null) {
            int i2 = 0;
            while (true) {
                Class[] clsArr = this.b;
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
        engineInit(i, key, algorithmParameterSpec, secureRandom);
        this.a = algorithmParameters;
    }

    public final void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new InvalidKeyException(e2.getMessage());
        }
    }
}
