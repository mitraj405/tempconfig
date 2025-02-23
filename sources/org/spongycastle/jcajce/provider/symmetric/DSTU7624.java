package org.spongycastle.jcajce.provider.symmetric;

import com.google.android.gms.ads.AdRequest;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ua.UAObjectIdentifiers;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.CipherKeyGenerator;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.engines.DSTU7624Engine;
import org.spongycastle.crypto.engines.DSTU7624WrapEngine;
import org.spongycastle.crypto.macs.KGMac;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.crypto.modes.CBCBlockCipher;
import org.spongycastle.crypto.modes.CFBBlockCipher;
import org.spongycastle.crypto.modes.KCCMBlockCipher;
import org.spongycastle.crypto.modes.KCTRBlockCipher;
import org.spongycastle.crypto.modes.KGCMBlockCipher;
import org.spongycastle.crypto.modes.OFBBlockCipher;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.symmetric.util.BaseAlgorithmParameterGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseBlockCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BaseKeyGenerator;
import org.spongycastle.jcajce.provider.symmetric.util.BaseMac;
import org.spongycastle.jcajce.provider.symmetric.util.BaseWrapCipher;
import org.spongycastle.jcajce.provider.symmetric.util.BlockCipherProvider;
import org.spongycastle.jcajce.provider.symmetric.util.IvAlgorithmParameters;

public class DSTU7624 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        public final int a;

        public AlgParamGen(int i) {
            this.a = i / 8;
        }

        public final AlgorithmParameters engineGenerateParameters() {
            byte[] bArr = new byte[this.a];
            if (this.a == null) {
                this.a = new SecureRandom();
            }
            this.a.nextBytes(bArr);
            try {
                AlgorithmParameters a2 = a("DSTU7624");
                a2.init(new IvParameterSpec(bArr));
                return a2;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        public final void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSTU7624 parameter generation.");
        }
    }

    public static class AlgParamGen128 extends AlgParamGen {
        public AlgParamGen128() {
            super(128);
        }
    }

    public static class AlgParamGen256 extends AlgParamGen {
        public AlgParamGen256() {
            super(256);
        }
    }

    public static class AlgParamGen512 extends AlgParamGen {
        public AlgParamGen512() {
            super(AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        public final String engineToString() {
            return "DSTU7624 IV";
        }
    }

    public static class CBC128 extends BaseBlockCipher {
        public CBC128() {
            super(new CBCBlockCipher(new DSTU7624Engine(128)), 128);
        }
    }

    public static class CBC256 extends BaseBlockCipher {
        public CBC256() {
            super(new CBCBlockCipher(new DSTU7624Engine(256)), 256);
        }
    }

    public static class CBC512 extends BaseBlockCipher {
        public CBC512() {
            super(new CBCBlockCipher(new DSTU7624Engine(AdRequest.MAX_CONTENT_URL_LENGTH)), (int) AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class CCM128 extends BaseBlockCipher {
        public CCM128() {
            super((AEADBlockCipher) new KCCMBlockCipher(new DSTU7624Engine(128)));
        }
    }

    public static class CCM256 extends BaseBlockCipher {
        public CCM256() {
            super((AEADBlockCipher) new KCCMBlockCipher(new DSTU7624Engine(256)));
        }
    }

    public static class CCM512 extends BaseBlockCipher {
        public CCM512() {
            super((AEADBlockCipher) new KCCMBlockCipher(new DSTU7624Engine(AdRequest.MAX_CONTENT_URL_LENGTH)));
        }
    }

    public static class CFB128 extends BaseBlockCipher {
        public CFB128() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new DSTU7624Engine(128), 128)), 128);
        }
    }

    public static class CFB256 extends BaseBlockCipher {
        public CFB256() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new DSTU7624Engine(256), 256)), 256);
        }
    }

    public static class CFB512 extends BaseBlockCipher {
        public CFB512() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new DSTU7624Engine(AdRequest.MAX_CONTENT_URL_LENGTH), AdRequest.MAX_CONTENT_URL_LENGTH)), (int) AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class CTR128 extends BaseBlockCipher {
        public CTR128() {
            super(new BufferedBlockCipher(new KCTRBlockCipher(new DSTU7624Engine(128))), 128);
        }
    }

    public static class CTR256 extends BaseBlockCipher {
        public CTR256() {
            super(new BufferedBlockCipher(new KCTRBlockCipher(new DSTU7624Engine(256))), 256);
        }
    }

    public static class CTR512 extends BaseBlockCipher {
        public CTR512() {
            super(new BufferedBlockCipher(new KCTRBlockCipher(new DSTU7624Engine(AdRequest.MAX_CONTENT_URL_LENGTH))), (int) AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class ECB extends BaseBlockCipher {
        public ECB() {
            super((BlockCipherProvider) new BlockCipherProvider() {
                public final BlockCipher a() {
                    return new DSTU7624Engine(128);
                }
            });
        }
    }

    public static class ECB128 extends BaseBlockCipher {
        public ECB128() {
            super((BlockCipher) new DSTU7624Engine(128));
        }
    }

    public static class ECB256 extends BaseBlockCipher {
        public ECB256() {
            super((BlockCipher) new DSTU7624Engine(256));
        }
    }

    public static class ECB512 extends BaseBlockCipher {
        public ECB512() {
            super((BlockCipher) new DSTU7624Engine(AdRequest.MAX_CONTENT_URL_LENGTH));
        }
    }

    public static class ECB_128 extends BaseBlockCipher {
        public ECB_128() {
            super((BlockCipher) new DSTU7624Engine(128));
        }
    }

    public static class ECB_256 extends BaseBlockCipher {
        public ECB_256() {
            super((BlockCipher) new DSTU7624Engine(256));
        }
    }

    public static class ECB_512 extends BaseBlockCipher {
        public ECB_512() {
            super((BlockCipher) new DSTU7624Engine(AdRequest.MAX_CONTENT_URL_LENGTH));
        }
    }

    public static class GCM128 extends BaseBlockCipher {
        public GCM128() {
            super((AEADBlockCipher) new KGCMBlockCipher(new DSTU7624Engine(128)));
        }
    }

    public static class GCM256 extends BaseBlockCipher {
        public GCM256() {
            super((AEADBlockCipher) new KGCMBlockCipher(new DSTU7624Engine(256)));
        }
    }

    public static class GCM512 extends BaseBlockCipher {
        public GCM512() {
            super((AEADBlockCipher) new KGCMBlockCipher(new DSTU7624Engine(AdRequest.MAX_CONTENT_URL_LENGTH)));
        }
    }

    public static class GMAC extends BaseMac {
        public GMAC() {
            super((Mac) new KGMac(new KGCMBlockCipher(new DSTU7624Engine(128)), 128));
        }
    }

    public static class GMAC128 extends BaseMac {
        public GMAC128() {
            super((Mac) new KGMac(new KGCMBlockCipher(new DSTU7624Engine(128)), 128));
        }
    }

    public static class GMAC256 extends BaseMac {
        public GMAC256() {
            super((Mac) new KGMac(new KGCMBlockCipher(new DSTU7624Engine(256)), 256));
        }
    }

    public static class GMAC512 extends BaseMac {
        public GMAC512() {
            super((Mac) new KGMac(new KGCMBlockCipher(new DSTU7624Engine(AdRequest.MAX_CONTENT_URL_LENGTH)), AdRequest.MAX_CONTENT_URL_LENGTH));
        }
    }

    public static class KeyGen extends BaseKeyGenerator {
        public KeyGen() {
            this(256);
        }

        public KeyGen(int i) {
            super("DSTU7624", i, new CipherKeyGenerator());
        }
    }

    public static class KeyGen128 extends KeyGen {
        public KeyGen128() {
            super(128);
        }
    }

    public static class KeyGen256 extends KeyGen {
        public KeyGen256() {
            super(256);
        }
    }

    public static class KeyGen512 extends KeyGen {
        public KeyGen512() {
            super(AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {
        public static final String a = DSTU7624.class.getName();

        public final void a(ConfigurableProvider configurableProvider) {
            ConfigurableProvider configurableProvider2 = configurableProvider;
            String str = a;
            configurableProvider2.b("AlgorithmParameters.DSTU7624", str.concat("$AlgParams128"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier = UAObjectIdentifiers.r;
            configurableProvider2.c("AlgorithmParameters", aSN1ObjectIdentifier, str.concat("$AlgParams"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = UAObjectIdentifiers.s;
            configurableProvider2.c("AlgorithmParameters", aSN1ObjectIdentifier2, str.concat("$AlgParams"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = UAObjectIdentifiers.t;
            configurableProvider2.c("AlgorithmParameters", aSN1ObjectIdentifier3, str.concat("$AlgParams"));
            configurableProvider2.c("AlgorithmParameterGenerator", aSN1ObjectIdentifier, xx.E(str, "$AlgParamGen128", configurableProvider2, "AlgorithmParameterGenerator.DSTU7624", "$AlgParamGen128"));
            configurableProvider2.c("AlgorithmParameterGenerator", aSN1ObjectIdentifier2, str.concat("$AlgParamGen256"));
            configurableProvider2.c("AlgorithmParameterGenerator", aSN1ObjectIdentifier3, str.concat("$AlgParamGen512"));
            configurableProvider2.b("Cipher.DSTU7624-128", xx.E(str, "$ECB_128", configurableProvider2, "Cipher.DSTU7624", "$ECB_128"));
            configurableProvider2.b("Cipher.DSTU7624-512", xx.E(str, "$ECB_256", configurableProvider2, "Cipher.DSTU7624-256", "$ECB_512"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = UAObjectIdentifiers.i;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier4, str.concat("$ECB128"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = UAObjectIdentifiers.j;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier5, str.concat("$ECB256"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = UAObjectIdentifiers.k;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier6, str.concat("$ECB512"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier, str.concat("$CBC128"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier2, str.concat("$CBC256"));
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier3, str.concat("$CBC512"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = UAObjectIdentifiers.u;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier7, str.concat("$OFB128"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = UAObjectIdentifiers.v;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier8, str.concat("$OFB256"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = UAObjectIdentifiers.w;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier9, str.concat("$OFB512"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = UAObjectIdentifiers.o;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier10, str.concat("$CFB128"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = UAObjectIdentifiers.p;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier11, str.concat("$CFB256"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = UAObjectIdentifiers.q;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier12, str.concat("$CFB512"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = UAObjectIdentifiers.l;
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = aSN1ObjectIdentifier12;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier13, str.concat("$CTR128"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = UAObjectIdentifiers.m;
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier13;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier15, str.concat("$CTR256"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = UAObjectIdentifiers.n;
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = aSN1ObjectIdentifier15;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier17, str.concat("$CTR512"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = UAObjectIdentifiers.A;
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = aSN1ObjectIdentifier17;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier19, str.concat("$CCM128"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = UAObjectIdentifiers.B;
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = aSN1ObjectIdentifier19;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier21, str.concat("$CCM256"));
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = UAObjectIdentifiers.C;
            ASN1ObjectIdentifier aSN1ObjectIdentifier24 = aSN1ObjectIdentifier21;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier23, str.concat("$CCM512"));
            configurableProvider2.b("Cipher.DSTU7624KW", str.concat("$Wrap"));
            configurableProvider2.b("Alg.Alias.Cipher.DSTU7624WRAP", "DSTU7624KW");
            ASN1ObjectIdentifier aSN1ObjectIdentifier25 = aSN1ObjectIdentifier23;
            StringBuilder o = lf.o(str, "$Wrap128", configurableProvider2, "Cipher.DSTU7624-128KW", "Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = UAObjectIdentifiers.D;
            ASN1ObjectIdentifier aSN1ObjectIdentifier27 = aSN1ObjectIdentifier11;
            o.append(aSN1ObjectIdentifier26.c);
            configurableProvider2.b(o.toString(), "DSTU7624-128KW");
            configurableProvider2.b("Alg.Alias.Cipher.DSTU7624-128WRAP", "DSTU7624-128KW");
            StringBuilder o2 = lf.o(str, "$Wrap256", configurableProvider2, "Cipher.DSTU7624-256KW", "Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier28 = UAObjectIdentifiers.E;
            ASN1ObjectIdentifier aSN1ObjectIdentifier29 = aSN1ObjectIdentifier10;
            o2.append(aSN1ObjectIdentifier28.c);
            configurableProvider2.b(o2.toString(), "DSTU7624-256KW");
            configurableProvider2.b("Alg.Alias.Cipher.DSTU7624-256WRAP", "DSTU7624-256KW");
            StringBuilder o3 = lf.o(str, "$Wrap512", configurableProvider2, "Cipher.DSTU7624-512KW", "Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier30 = UAObjectIdentifiers.F;
            o3.append(aSN1ObjectIdentifier30.c);
            configurableProvider2.b(o3.toString(), "DSTU7624-512KW");
            configurableProvider2.b("Alg.Alias.Cipher.DSTU7624-512WRAP", "DSTU7624-512KW");
            ASN1ObjectIdentifier aSN1ObjectIdentifier31 = aSN1ObjectIdentifier9;
            configurableProvider2.b("Mac.DSTU7624-128GMAC", xx.E(str, "$GMAC", configurableProvider2, "Mac.DSTU7624GMAC", "$GMAC128"));
            StringBuilder sb = new StringBuilder("Alg.Alias.Mac.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier32 = UAObjectIdentifiers.x;
            ASN1ObjectIdentifier aSN1ObjectIdentifier33 = aSN1ObjectIdentifier8;
            sb.append(aSN1ObjectIdentifier32.c);
            configurableProvider2.b(sb.toString(), "DSTU7624-128GMAC");
            StringBuilder o4 = lf.o(str, "$GMAC256", configurableProvider2, "Mac.DSTU7624-256GMAC", "Alg.Alias.Mac.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier34 = UAObjectIdentifiers.y;
            o4.append(aSN1ObjectIdentifier34.c);
            configurableProvider2.b(o4.toString(), "DSTU7624-256GMAC");
            StringBuilder o5 = lf.o(str, "$GMAC512", configurableProvider2, "Mac.DSTU7624-512GMAC", "Alg.Alias.Mac.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier35 = UAObjectIdentifiers.z;
            o5.append(aSN1ObjectIdentifier35.c);
            configurableProvider2.b(o5.toString(), "DSTU7624-512GMAC");
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier26, xx.E(str, "$KeyGen", configurableProvider2, "KeyGenerator.DSTU7624", "$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier28, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier30, str.concat("$KeyGen512"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier4, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier5, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier6, str.concat("$KeyGen512"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier2, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier3, str.concat("$KeyGen512"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier7, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier33, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier31, str.concat("$KeyGen512"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier29, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier27, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier14, str.concat("$KeyGen512"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier16, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier18, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier20, str.concat("$KeyGen512"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier22, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier24, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier25, str.concat("$KeyGen512"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier32, str.concat("$KeyGen128"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier34, str.concat("$KeyGen256"));
            configurableProvider2.c("KeyGenerator", aSN1ObjectIdentifier35, str.concat("$KeyGen512"));
        }
    }

    public static class OFB128 extends BaseBlockCipher {
        public OFB128() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new DSTU7624Engine(128), 128)), 128);
        }
    }

    public static class OFB256 extends BaseBlockCipher {
        public OFB256() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new DSTU7624Engine(256), 256)), 256);
        }
    }

    public static class OFB512 extends BaseBlockCipher {
        public OFB512() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new DSTU7624Engine(AdRequest.MAX_CONTENT_URL_LENGTH), AdRequest.MAX_CONTENT_URL_LENGTH)), (int) AdRequest.MAX_CONTENT_URL_LENGTH);
        }
    }

    public static class Wrap extends BaseWrapCipher {
        public Wrap() {
            super(new DSTU7624WrapEngine(128), 0);
        }
    }

    public static class Wrap128 extends BaseWrapCipher {
        public Wrap128() {
            super(new DSTU7624WrapEngine(128), 0);
        }
    }

    public static class Wrap256 extends BaseWrapCipher {
        public Wrap256() {
            super(new DSTU7624WrapEngine(256), 0);
        }
    }

    public static class Wrap512 extends BaseWrapCipher {
        public Wrap512() {
            super(new DSTU7624WrapEngine(AdRequest.MAX_CONTENT_URL_LENGTH), 0);
        }
    }

    private DSTU7624() {
    }
}
