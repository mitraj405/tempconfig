package org.spongycastle.jcajce.provider.symmetric;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST28147Parameters;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.engines.CryptoProWrapEngine;
import org.spongycastle.crypto.engines.GOST28147Engine;
import org.spongycastle.crypto.engines.GOST28147WrapEngine;
import org.spongycastle.crypto.macs.GOST28147Mac;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.GCFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameters;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.util.Arrays;

public final class GOST28147 {
    public static final HashMap a;

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public final byte[] a = new byte[8];
        public byte[] b = GOST28147Engine.i("E-A");

        public final AlgorithmParameters engineGenerateParameters() {
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            SecureRandom secureRandom = this.a;
            byte[] bArr = this.a;
            secureRandom.nextBytes(bArr);
            try {
                AlgorithmParameters a2 = a("GOST28147");
                a2.init(new GOST28147ParameterSpec(this.b, bArr));
                return a2;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                this.b = Arrays.c(((GOST28147ParameterSpec) algorithmParameterSpec).b);
                return;
            }
            throw new InvalidAlgorithmParameterException("parameter spec not supported");
        }
    }

    public static class AlgParams extends BaseAlgParams {
        public ASN1ObjectIdentifier b = CryptoProObjectIdentifiers.g;

        /* renamed from: b  reason: collision with other field name */
        public byte[] f6535b;

        public final AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f6535b);
            }
            if (cls == GOST28147ParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new GOST28147ParameterSpec(this.b, this.f6535b);
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: ".concat(cls.getName()));
        }

        public final byte[] d() throws IOException {
            return new GOST28147Parameters(this.b, this.f6535b).e();
        }

        public final void e(byte[] bArr) throws IOException {
            GOST28147Parameters gOST28147Parameters;
            ASN1Primitive k = ASN1Primitive.k(bArr);
            if (k instanceof ASN1OctetString) {
                this.f6535b = ASN1OctetString.q(k).s();
            } else if (k instanceof ASN1Sequence) {
                if (k instanceof GOST28147Parameters) {
                    gOST28147Parameters = (GOST28147Parameters) k;
                } else if (k != null) {
                    gOST28147Parameters = new GOST28147Parameters(ASN1Sequence.q(k));
                } else {
                    gOST28147Parameters = null;
                }
                this.b = gOST28147Parameters.Z0;
                this.f6535b = Arrays.c(gOST28147Parameters.a.s());
            } else {
                throw new IOException("Unable to recognize parameters");
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f6535b = ((IvParameterSpec) algorithmParameterSpec).getIV();
            } else if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                this.f6535b = ((GOST28147ParameterSpec) algorithmParameterSpec).a();
                try {
                    this.b = BaseAlgParams.c(Arrays.c(((GOST28147ParameterSpec) algorithmParameterSpec).b));
                } catch (IllegalArgumentException e) {
                    throw new InvalidParameterSpecException(e.getMessage());
                }
            } else {
                throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
            }
        }

        public final String engineToString() {
            return "GOST 28147 IV Parameters";
        }
    }

    public static abstract class BaseAlgParams extends BaseAlgorithmParameters {
        public ASN1ObjectIdentifier a = CryptoProObjectIdentifiers.g;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f6536a;

        public static ASN1ObjectIdentifier c(byte[] bArr) {
            Hashtable hashtable = GOST28147Engine.a;
            Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                String str = (String) keys.nextElement();
                if (Arrays.a((byte[]) hashtable.get(str), bArr)) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) GOST28147.a.get(str);
                    if (aSN1ObjectIdentifier != null) {
                        return aSN1ObjectIdentifier;
                    }
                    throw new IllegalArgumentException(C0709Uj.i("Unknown SBOX name: ", str));
                }
            }
            throw new IllegalArgumentException("SBOX provided did not map to a known one");
        }

        public AlgorithmParameterSpec b(Class cls) throws InvalidParameterSpecException {
            if (cls == IvParameterSpec.class) {
                return new IvParameterSpec(this.f6536a);
            }
            if (cls == GOST28147ParameterSpec.class || cls == AlgorithmParameterSpec.class) {
                return new GOST28147ParameterSpec(this.a, this.f6536a);
            }
            throw new InvalidParameterSpecException("AlgorithmParameterSpec not recognized: ".concat(cls.getName()));
        }

        public byte[] d() throws IOException {
            return new GOST28147Parameters(this.a, this.f6536a).e();
        }

        public abstract void e(byte[] bArr) throws IOException;

        public final byte[] engineGetEncoded() throws IOException {
            return engineGetEncoded("ASN.1");
        }

        public final void engineInit(byte[] bArr) throws IOException {
            engineInit(bArr, "ASN.1");
        }

        public final byte[] engineGetEncoded(String str) throws IOException {
            if (BaseAlgorithmParameters.a(str)) {
                return d();
            }
            throw new IOException(C0709Uj.i("Unknown parameter format: ", str));
        }

        public final void engineInit(byte[] bArr, String str) throws IOException {
            if (bArr == null) {
                throw new NullPointerException("Encoded parameters cannot be null");
            } else if (BaseAlgorithmParameters.a(str)) {
                try {
                    e(bArr);
                } catch (IOException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new IOException(C1058d.M(e2, new StringBuilder("Parameter parsing failed: ")));
                }
            } else {
                throw new IOException(C0709Uj.i("Unknown parameter format: ", str));
            }
        }

        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidParameterSpecException {
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                this.f6536a = ((IvParameterSpec) algorithmParameterSpec).getIV();
            } else if (algorithmParameterSpec instanceof GOST28147ParameterSpec) {
                this.f6536a = ((GOST28147ParameterSpec) algorithmParameterSpec).a();
                try {
                    this.a = c(Arrays.c(((GOST28147ParameterSpec) algorithmParameterSpec).b));
                } catch (IllegalArgumentException e) {
                    throw new InvalidParameterSpecException(e.getMessage());
                }
            } else {
                throw new InvalidParameterSpecException("IvParameterSpec required to initialise a IV parameters algorithm parameters object");
            }
        }
    }

    public static class CBC extends BaseBlockCipher {
        public CBC() {
            super(new CBCBlockCipher(new GOST28147Engine()), 64);
        }
    }

    public static class CryptoProWrap extends BaseWrapCipher {
        public CryptoProWrap() {
            super(new CryptoProWrapEngine(), 0);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipher) new GOST28147Engine());
        }
    }

    public static class GCFB extends BaseBlockCipher {
        public GCFB() {
            super(new BufferedBlockCipher(new GCFBBlockCipher(new GOST28147Engine())), 64);
        }
    }

    public static class GostWrap extends BaseWrapCipher {
        public GostWrap() {
            super(new GOST28147WrapEngine(), 0);
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            super("GOST28147", 256, new CipherKeyGenerator());
        }
    }

    public static class Mac extends BaseMac {
        public Mac() {
            super((org.spongycastle.crypto.Mac) new GOST28147Mac());
        }
    }

    public static class Mappings extends AlgorithmProvider {
        public static final String a = GOST28147.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            String str = a;
            configurableProvider.b("Cipher.GOST28147", str.concat("$ECB"));
            configurableProvider.b("Alg.Alias.Cipher.GOST", "GOST28147");
            configurableProvider.b("Alg.Alias.Cipher.GOST-28147", "GOST28147");
            StringBuilder sb = new StringBuilder("Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.e;
            sb.append(aSN1ObjectIdentifier);
            configurableProvider.b("KeyGenerator.GOST28147", xx.E(str, "$GCFB", configurableProvider, sb.toString(), "$KeyGen"));
            configurableProvider.b("Alg.Alias.KeyGenerator.GOST", "GOST28147");
            configurableProvider.b("Alg.Alias.KeyGenerator.GOST-28147", "GOST28147");
            configurableProvider.b("Alg.Alias.KeyGenerator." + aSN1ObjectIdentifier, "GOST28147");
            configurableProvider.b("AlgorithmParameterGenerator.GOST28147", xx.E(str, "$AlgParams", configurableProvider, "AlgorithmParameters.GOST28147", "$AlgParamGen"));
            configurableProvider.b("Alg.Alias.AlgorithmParameters." + aSN1ObjectIdentifier, "GOST28147");
            configurableProvider.b("Alg.Alias.AlgorithmParameterGenerator." + aSN1ObjectIdentifier, "GOST28147");
            StringBuilder o = lf.o(str, "$CryptoProWrap", configurableProvider, "Cipher." + CryptoProObjectIdentifiers.d, "Cipher.");
            o.append(CryptoProObjectIdentifiers.c);
            configurableProvider.b("Mac.GOST28147MAC", xx.E(str, "$GostWrap", configurableProvider, o.toString(), "$Mac"));
            configurableProvider.b("Alg.Alias.Mac.GOST28147", "GOST28147MAC");
        }
    }

    static {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        a = hashMap2;
        hashMap.put(CryptoProObjectIdentifiers.f, "E-TEST");
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CryptoProObjectIdentifiers.g;
        hashMap.put(aSN1ObjectIdentifier, "E-A");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CryptoProObjectIdentifiers.h;
        hashMap.put(aSN1ObjectIdentifier2, "E-B");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = CryptoProObjectIdentifiers.i;
        hashMap.put(aSN1ObjectIdentifier3, "E-C");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = CryptoProObjectIdentifiers.j;
        hashMap.put(aSN1ObjectIdentifier4, "E-D");
        hashMap2.put("E-A", aSN1ObjectIdentifier);
        hashMap2.put("E-B", aSN1ObjectIdentifier2);
        hashMap2.put("E-C", aSN1ObjectIdentifier3);
        hashMap2.put("E-D", aSN1ObjectIdentifier4);
    }

    private GOST28147() {
    }
}
