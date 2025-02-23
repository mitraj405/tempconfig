package org.spongycastle.jcajce.provider.asymmetric;

import java.util.HashMap;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class RSA {
    public static final HashMap a;

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public static void f(ConfigurableProvider configurableProvider, String str, String str2, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
            String concat = str.concat("WITHRSA");
            String concat2 = str.concat("withRSA");
            String concat3 = str.concat("WithRSA");
            String concat4 = str.concat("/RSA");
            String concat5 = str.concat("WITHRSAENCRYPTION");
            String concat6 = str.concat("withRSAEncryption");
            String concat7 = str.concat("WithRSAEncryption");
            configurableProvider.b("Signature." + concat, str2);
            configurableProvider.b("Alg.Alias.Signature." + concat2, concat);
            configurableProvider.b("Alg.Alias.Signature." + concat3, concat);
            configurableProvider.b("Alg.Alias.Signature." + concat5, concat);
            configurableProvider.b("Alg.Alias.Signature." + concat6, concat);
            configurableProvider.b("Alg.Alias.Signature." + concat7, concat);
            configurableProvider.b("Alg.Alias.Signature." + concat4, concat);
            if (aSN1ObjectIdentifier != null) {
                configurableProvider.b("Alg.Alias.Signature." + aSN1ObjectIdentifier, concat);
                C1058d.I(new StringBuilder("Alg.Alias.Signature.OID."), aSN1ObjectIdentifier, configurableProvider, concat);
            }
        }

        public static void g(ConfigurableProvider configurableProvider, String str, String str2) {
            StringBuilder o = lf.o(str, "WITHRSA/ISO9796-2", configurableProvider, C0709Uj.j(lf.o(str, "WITHRSA/ISO9796-2", configurableProvider, lf.j("Alg.Alias.Signature.", str, "withRSA/ISO9796-2"), "Alg.Alias.Signature."), str, "WithRSA/ISO9796-2"), "Signature.");
            o.append(str);
            o.append("WITHRSA/ISO9796-2");
            configurableProvider.b(o.toString(), str2);
        }

        public static void h(ConfigurableProvider configurableProvider, String str, String str2) {
            StringBuilder o = lf.o(str, "WITHRSAANDMGF1", configurableProvider, C0709Uj.j(lf.o(str, "WITHRSAANDMGF1", configurableProvider, C0709Uj.j(lf.o(str, "WITHRSAANDMGF1", configurableProvider, C0709Uj.j(lf.o(str, "WITHRSAANDMGF1", configurableProvider, lf.j("Alg.Alias.Signature.", str, "withRSA/PSS"), "Alg.Alias.Signature."), str, "WithRSA/PSS"), "Alg.Alias.Signature."), str, "withRSAandMGF1"), "Alg.Alias.Signature."), str, "WithRSAAndMGF1"), "Signature.");
            o.append(str);
            o.append("WITHRSAANDMGF1");
            configurableProvider.b(o.toString(), str2);
        }

        public static void i(ConfigurableProvider configurableProvider, String str, String str2) {
            StringBuilder o = lf.o(str, "WITHRSA/X9.31", configurableProvider, C0709Uj.j(lf.o(str, "WITHRSA/X9.31", configurableProvider, lf.j("Alg.Alias.Signature.", str, "withRSA/X9.31"), "Alg.Alias.Signature."), str, "WithRSA/X9.31"), "Signature.");
            o.append(str);
            o.append("WITHRSA/X9.31");
            configurableProvider.b(o.toString(), str2);
        }

        public final void a(ConfigurableProvider configurableProvider) {
            ConfigurableProvider configurableProvider2 = configurableProvider;
            configurableProvider2.b("AlgorithmParameters.OAEP", "org.spongycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$OAEP");
            configurableProvider2.b("AlgorithmParameters.PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.AlgorithmParametersSpi$PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.RSAPSS", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.RSASSA-PSS", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA224withRSA/PSS", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA256withRSA/PSS", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA384withRSA/PSS", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA512withRSA/PSS", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA224WITHRSAANDMGF1", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA256WITHRSAANDMGF1", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA384WITHRSAANDMGF1", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA512WITHRSAANDMGF1", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA3-224WITHRSAANDMGF1", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA3-256WITHRSAANDMGF1", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA3-384WITHRSAANDMGF1", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA3-512WITHRSAANDMGF1", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.RAWRSAPSS", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.NONEWITHRSAPSS", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.NONEWITHRSASSA-PSS", "PSS");
            configurableProvider2.b("Alg.Alias.AlgorithmParameters.NONEWITHRSAANDMGF1", "PSS");
            configurableProvider2.e("Cipher.RSA", RSA.a);
            configurableProvider2.b("Cipher.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            configurableProvider2.b("Cipher.RSA/RAW", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$NoPadding");
            configurableProvider2.b("Cipher.RSA/PKCS1", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.a;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier, "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = X509ObjectIdentifiers.k0;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier2, "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding");
            configurableProvider2.b("Cipher.RSA/1", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PrivateOnly");
            configurableProvider2.b("Cipher.RSA/2", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$PKCS1v1_5Padding_PublicOnly");
            configurableProvider2.b("Cipher.RSA/OAEP", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.f;
            configurableProvider2.c("Cipher", aSN1ObjectIdentifier3, "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$OAEPPadding");
            configurableProvider2.b("Cipher.RSA/ISO9796-1", "org.spongycastle.jcajce.provider.asymmetric.rsa.CipherSpi$ISO9796d1Padding");
            configurableProvider2.b("Alg.Alias.Cipher.RSA//RAW", "RSA");
            configurableProvider2.b("Alg.Alias.Cipher.RSA//NOPADDING", "RSA");
            configurableProvider2.b("Alg.Alias.Cipher.RSA//PKCS1PADDING", "RSA/PKCS1");
            configurableProvider2.b("Alg.Alias.Cipher.RSA//OAEPPADDING", "RSA/OAEP");
            configurableProvider2.b("Alg.Alias.Cipher.RSA//ISO9796-1PADDING", "RSA/ISO9796-1");
            configurableProvider2.b("KeyFactory.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.KeyFactorySpi");
            configurableProvider2.b("KeyPairGenerator.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.KeyPairGeneratorSpi");
            KeyFactorySpi keyFactorySpi = new KeyFactorySpi();
            AsymmetricAlgorithmProvider.c(configurableProvider2, aSN1ObjectIdentifier, "RSA", keyFactorySpi);
            AsymmetricAlgorithmProvider.c(configurableProvider2, aSN1ObjectIdentifier2, "RSA", keyFactorySpi);
            AsymmetricAlgorithmProvider.c(configurableProvider2, aSN1ObjectIdentifier3, "RSA", keyFactorySpi);
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.i;
            AsymmetricAlgorithmProvider.c(configurableProvider2, aSN1ObjectIdentifier4, "RSA", keyFactorySpi);
            AsymmetricAlgorithmProvider.e("RSA", aSN1ObjectIdentifier, configurableProvider2);
            AsymmetricAlgorithmProvider.e("RSA", aSN1ObjectIdentifier2, configurableProvider2);
            AsymmetricAlgorithmProvider.e("OAEP", aSN1ObjectIdentifier3, configurableProvider2);
            AsymmetricAlgorithmProvider.e("PSS", aSN1ObjectIdentifier4, configurableProvider2);
            configurableProvider2.b("Signature.RSASSA-PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            configurableProvider2.b("Signature." + aSN1ObjectIdentifier4, "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            configurableProvider2.b("Signature.OID." + aSN1ObjectIdentifier4, "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$PSSwithRSA");
            configurableProvider2.b("Signature.RSA", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$noneRSA");
            configurableProvider2.b("Signature.RAWRSASSA-PSS", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$nonePSS");
            configurableProvider2.b("Alg.Alias.Signature.RAWRSA", "RSA");
            configurableProvider2.b("Alg.Alias.Signature.NONEWITHRSA", "RSA");
            configurableProvider2.b("Alg.Alias.Signature.RAWRSAPSS", "RAWRSASSA-PSS");
            configurableProvider2.b("Alg.Alias.Signature.NONEWITHRSAPSS", "RAWRSASSA-PSS");
            configurableProvider2.b("Alg.Alias.Signature.NONEWITHRSASSA-PSS", "RAWRSASSA-PSS");
            configurableProvider2.b("Alg.Alias.Signature.NONEWITHRSAANDMGF1", "RAWRSASSA-PSS");
            configurableProvider2.b("Alg.Alias.Signature.RSAPSS", "RSASSA-PSS");
            h(configurableProvider2, "SHA224", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA224withRSA");
            h(configurableProvider2, "SHA256", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA256withRSA");
            h(configurableProvider2, "SHA384", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA384withRSA");
            h(configurableProvider2, "SHA512", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512withRSA");
            h(configurableProvider2, "SHA512(224)", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_224withRSA");
            h(configurableProvider2, "SHA512(256)", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA512_256withRSA");
            h(configurableProvider2, "SHA3-224", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_224withRSA");
            h(configurableProvider2, "SHA3-256", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_256withRSA");
            h(configurableProvider2, "SHA3-384", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_384withRSA");
            h(configurableProvider2, "SHA3-512", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA3_512withRSA");
            if (configurableProvider2.d("MD2")) {
                f(configurableProvider2, "MD2", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD2", PKCSObjectIdentifiers.b);
            }
            if (configurableProvider2.d("MD4")) {
                f(configurableProvider2, "MD4", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD4", PKCSObjectIdentifiers.c);
            }
            if (configurableProvider2.d("MD5")) {
                f(configurableProvider2, "MD5", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD5", PKCSObjectIdentifiers.d);
                g(configurableProvider2, "MD5", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$MD5WithRSAEncryption");
            }
            if (configurableProvider2.d("SHA1")) {
                configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA1withRSA/PSS", "PSS");
                configurableProvider2.b("Alg.Alias.AlgorithmParameters.SHA1WITHRSAANDMGF1", "PSS");
                h(configurableProvider2, "SHA1", "org.spongycastle.jcajce.provider.asymmetric.rsa.PSSSignatureSpi$SHA1withRSA");
                f(configurableProvider2, "SHA1", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA1", PKCSObjectIdentifiers.e);
                g(configurableProvider2, "SHA1", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA1WithRSAEncryption");
                StringBuilder sb = new StringBuilder("Alg.Alias.Signature.");
                ASN1ObjectIdentifier aSN1ObjectIdentifier5 = OIWObjectIdentifiers.h;
                C1058d.I(C1058d.D(sb, aSN1ObjectIdentifier5, configurableProvider2, "SHA1WITHRSA", "Alg.Alias.Signature.OID."), aSN1ObjectIdentifier5, configurableProvider2, "SHA1WITHRSA");
                i(configurableProvider2, "SHA1", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA1WithRSAEncryption");
            }
            f(configurableProvider2, "SHA224", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA224", PKCSObjectIdentifiers.m);
            f(configurableProvider2, "SHA256", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA256", PKCSObjectIdentifiers.j);
            f(configurableProvider2, "SHA384", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA384", PKCSObjectIdentifiers.k);
            f(configurableProvider2, "SHA512", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512", PKCSObjectIdentifiers.l);
            f(configurableProvider2, "SHA512(224)", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_224", PKCSObjectIdentifiers.n);
            f(configurableProvider2, "SHA512(256)", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512_256", PKCSObjectIdentifiers.o);
            f(configurableProvider2, "SHA3-224", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_224", NISTObjectIdentifiers.b0);
            f(configurableProvider2, "SHA3-256", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_256", NISTObjectIdentifiers.c0);
            f(configurableProvider2, "SHA3-384", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_384", NISTObjectIdentifiers.d0);
            f(configurableProvider2, "SHA3-512", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA3_512", NISTObjectIdentifiers.e0);
            g(configurableProvider2, "SHA224", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA224WithRSAEncryption");
            g(configurableProvider2, "SHA256", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA256WithRSAEncryption");
            g(configurableProvider2, "SHA384", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA384WithRSAEncryption");
            g(configurableProvider2, "SHA512", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512WithRSAEncryption");
            g(configurableProvider2, "SHA512(224)", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_224WithRSAEncryption");
            g(configurableProvider2, "SHA512(256)", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$SHA512_256WithRSAEncryption");
            i(configurableProvider2, "SHA224", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA224WithRSAEncryption");
            i(configurableProvider2, "SHA256", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA256WithRSAEncryption");
            i(configurableProvider2, "SHA384", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA384WithRSAEncryption");
            i(configurableProvider2, "SHA512", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512WithRSAEncryption");
            i(configurableProvider2, "SHA512(224)", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_224WithRSAEncryption");
            i(configurableProvider2, "SHA512(256)", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$SHA512_256WithRSAEncryption");
            if (configurableProvider2.d("RIPEMD128")) {
                f(configurableProvider2, "RIPEMD128", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", TeleTrusTObjectIdentifiers.e);
                f(configurableProvider2, "RMD128", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD128", (ASN1ObjectIdentifier) null);
                i(configurableProvider2, "RMD128", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
                i(configurableProvider2, "RIPEMD128", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD128WithRSAEncryption");
            }
            if (configurableProvider2.d("RIPEMD160")) {
                f(configurableProvider2, "RIPEMD160", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", TeleTrusTObjectIdentifiers.d);
                f(configurableProvider2, "RMD160", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD160", (ASN1ObjectIdentifier) null);
                configurableProvider2.b("Alg.Alias.Signature.RIPEMD160WithRSA/ISO9796-2", "RIPEMD160withRSA/ISO9796-2");
                configurableProvider2.b("Signature.RIPEMD160withRSA/ISO9796-2", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$RIPEMD160WithRSAEncryption");
                i(configurableProvider2, "RMD160", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
                i(configurableProvider2, "RIPEMD160", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$RIPEMD160WithRSAEncryption");
            }
            if (configurableProvider2.d("RIPEMD256")) {
                f(configurableProvider2, "RIPEMD256", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", TeleTrusTObjectIdentifiers.f);
                f(configurableProvider2, "RMD256", "org.spongycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$RIPEMD256", (ASN1ObjectIdentifier) null);
            }
            if (configurableProvider2.d("WHIRLPOOL")) {
                g(configurableProvider2, "Whirlpool", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
                g(configurableProvider2, "WHIRLPOOL", "org.spongycastle.jcajce.provider.asymmetric.rsa.ISOSignatureSpi$WhirlpoolWithRSAEncryption");
                i(configurableProvider2, "Whirlpool", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
                i(configurableProvider2, "WHIRLPOOL", "org.spongycastle.jcajce.provider.asymmetric.rsa.X931SignatureSpi$WhirlpoolWithRSAEncryption");
            }
        }
    }

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put("SupportedKeyClasses", "javax.crypto.interfaces.RSAPublicKey|javax.crypto.interfaces.RSAPrivateKey");
        hashMap.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
