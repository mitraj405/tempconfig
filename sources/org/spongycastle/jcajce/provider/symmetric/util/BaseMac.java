package org.spongycastle.jcajce.provider.symmetric.util;

import com.google.android.gms.ads.AdRequest;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.MacSpi;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.AEADParameters;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.params.ParametersWithIV;
import org.spongycastle.crypto.params.RC2Parameters;
import org.spongycastle.crypto.params.SkeinParameters;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.provider.symmetric.util.PBE;
import org.spongycastle.jcajce.spec.AEADParameterSpec;
import org.spongycastle.jcajce.spec.SkeinParameterSpec;
import org.spongycastle.util.Arrays;

public class BaseMac extends MacSpi implements PBE {
    public static final Class a = ClassUtil.a(BaseMac.class, "javax.crypto.spec.GCMParameterSpec");

    /* renamed from: a  reason: collision with other field name */
    public final Mac f6555a;

    public BaseMac(Mac mac) {
        this.f6555a = mac;
    }

    public final byte[] engineDoFinal() {
        byte[] bArr = new byte[engineGetMacLength()];
        this.f6555a.c(0, bArr);
        return bArr;
    }

    public final int engineGetMacLength() {
        return this.f6555a.e();
    }

    public final void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters cipherParameters;
        KeyParameter keyParameter;
        int i;
        if (key != null) {
            boolean z = key instanceof PKCS12Key;
            Mac mac = this.f6555a;
            if (z) {
                try {
                    SecretKey secretKey = (SecretKey) key;
                    try {
                        PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
                        if ((secretKey instanceof PBEKey) && pBEParameterSpec == null) {
                            PBEKey pBEKey = (PBEKey) secretKey;
                            pBEParameterSpec = new PBEParameterSpec(pBEKey.getSalt(), pBEKey.getIterationCount());
                        }
                        int i2 = 256;
                        if (mac.b().startsWith("GOST")) {
                            i = 6;
                        } else {
                            if (!(mac instanceof HMac) || mac.b().startsWith("SHA-1")) {
                                i = 1;
                            } else if (mac.b().startsWith("SHA-224")) {
                                i = 7;
                                i2 = 224;
                            } else if (mac.b().startsWith("SHA-256")) {
                                i = 4;
                            } else if (mac.b().startsWith("SHA-384")) {
                                i = 8;
                                i2 = 384;
                            } else if (mac.b().startsWith("SHA-512")) {
                                i = 9;
                                i2 = AdRequest.MAX_CONTENT_URL_LENGTH;
                            } else if (mac.b().startsWith("RIPEMD160")) {
                                i = 2;
                            } else {
                                throw new InvalidAlgorithmParameterException("no PKCS12 mapping for HMAC: " + mac.b());
                            }
                            i2 = 160;
                        }
                        PBEParametersGenerator b = PBE.Util.b(2, i);
                        byte[] encoded = secretKey.getEncoded();
                        b.f(secretKey.getEncoded(), pBEParameterSpec.getIterationCount(), pBEParameterSpec.getSalt());
                        cipherParameters = b.c(i2);
                        for (int i3 = 0; i3 != encoded.length; i3++) {
                            encoded[i3] = 0;
                        }
                    } catch (Exception unused) {
                        throw new InvalidAlgorithmParameterException("PKCS12 requires a PBEParameterSpec");
                    }
                } catch (Exception unused2) {
                    throw new InvalidKeyException("PKCS12 requires a SecretKey/PBEKey");
                }
            } else if (key instanceof BCPBEKey) {
                BCPBEKey bCPBEKey = (BCPBEKey) key;
                CipherParameters cipherParameters2 = bCPBEKey.f6539a;
                if (cipherParameters2 != null) {
                    cipherParameters = cipherParameters2;
                } else if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                } else if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                    throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
                } else {
                    PBEParameterSpec pBEParameterSpec2 = (PBEParameterSpec) algorithmParameterSpec;
                    PBEParametersGenerator b2 = PBE.Util.b(bCPBEKey.c, bCPBEKey.d);
                    b2.f(bCPBEKey.getEncoded(), pBEParameterSpec2.getIterationCount(), pBEParameterSpec2.getSalt());
                    cipherParameters = b2.c(bCPBEKey.e);
                }
            } else if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                cipherParameters = new KeyParameter(key.getEncoded());
            } else {
                throw new InvalidAlgorithmParameterException("inappropriate parameter type: ".concat(algorithmParameterSpec.getClass().getName()));
            }
            if (cipherParameters instanceof ParametersWithIV) {
                keyParameter = (KeyParameter) cipherParameters.a;
            } else {
                keyParameter = cipherParameters;
            }
            if (algorithmParameterSpec instanceof AEADParameterSpec) {
                AEADParameterSpec aEADParameterSpec = (AEADParameterSpec) algorithmParameterSpec;
                cipherParameters = new AEADParameters(keyParameter, aEADParameterSpec.a, aEADParameterSpec.getIV(), Arrays.c(aEADParameterSpec.f6563a));
            } else if (algorithmParameterSpec instanceof IvParameterSpec) {
                cipherParameters = new ParametersWithIV(keyParameter, ((IvParameterSpec) algorithmParameterSpec).getIV());
            } else if (algorithmParameterSpec instanceof RC2ParameterSpec) {
                RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec;
                cipherParameters = new ParametersWithIV(new RC2Parameters(keyParameter.a, rC2ParameterSpec.getEffectiveKeyBits()), rC2ParameterSpec.getIV());
            } else if (algorithmParameterSpec instanceof SkeinParameterSpec) {
                Map map = ((SkeinParameterSpec) algorithmParameterSpec).a;
                Hashtable hashtable = new Hashtable();
                for (Object next : map.keySet()) {
                    hashtable.put(next, map.get(next));
                }
                SkeinParameters.Builder builder = new SkeinParameters.Builder(hashtable);
                byte[] bArr = keyParameter.a;
                if (bArr != null) {
                    Hashtable hashtable2 = builder.a;
                    hashtable2.put(0, bArr);
                    cipherParameters = new SkeinParameters(hashtable2);
                } else {
                    throw new IllegalArgumentException("Parameter value must not be null.");
                }
            } else if (algorithmParameterSpec == null) {
                cipherParameters = new KeyParameter(key.getEncoded());
            } else {
                Class cls = a;
                if (cls != null && cls.isAssignableFrom(algorithmParameterSpec.getClass())) {
                    try {
                        cipherParameters = new AEADParameters(keyParameter, ((Integer) cls.getDeclaredMethod("getTLen", new Class[0]).invoke(algorithmParameterSpec, new Object[0])).intValue(), (byte[]) cls.getDeclaredMethod("getIV", new Class[0]).invoke(algorithmParameterSpec, new Object[0]), (byte[]) null);
                    } catch (Exception unused3) {
                        throw new InvalidAlgorithmParameterException("Cannot process GCMParameterSpec.");
                    }
                } else if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("unknown parameter type: ".concat(algorithmParameterSpec.getClass().getName()));
                }
            }
            try {
                mac.a(cipherParameters);
            } catch (Exception e) {
                throw new InvalidAlgorithmParameterException(C1058d.M(e, new StringBuilder("cannot initialize MAC: ")));
            }
        } else {
            throw new InvalidKeyException("key is null");
        }
    }

    public final void engineReset() {
        this.f6555a.reset();
    }

    public final void engineUpdate(byte b) {
        this.f6555a.d(b);
    }

    public final void engineUpdate(byte[] bArr, int i, int i2) {
        this.f6555a.update(bArr, i, i2);
    }

    public BaseMac(HMac hMac) {
        this.f6555a = hMac;
    }
}
