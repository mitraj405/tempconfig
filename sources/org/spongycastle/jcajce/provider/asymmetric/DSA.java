package org.spongycastle.jcajce.provider.asymmetric;

import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.jcajce.provider.asymmetric.dsa.DSAUtil;
import org.spongycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;

public class DSA {

    public static class Mappings extends AsymmetricAlgorithmProvider {
        public final void a(ConfigurableProvider configurableProvider) {
            configurableProvider.b("AlgorithmParameters.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.AlgorithmParametersSpi");
            configurableProvider.b("AlgorithmParameterGenerator.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.AlgorithmParameterGeneratorSpi");
            configurableProvider.b("KeyPairGenerator.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.KeyPairGeneratorSpi");
            configurableProvider.b("KeyFactory.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.KeyFactorySpi");
            configurableProvider.b("Signature.DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$stdDSA");
            configurableProvider.b("Signature.NONEWITHDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$noneDSA");
            configurableProvider.b("Alg.Alias.Signature.RAWDSA", "NONEWITHDSA");
            configurableProvider.b("Signature.DETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            configurableProvider.b("Signature.SHA1WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            configurableProvider.b("Signature.SHA224WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
            configurableProvider.b("Signature.SHA256WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
            configurableProvider.b("Signature.SHA384WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
            configurableProvider.b("Signature.SHA512WITHDETDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
            configurableProvider.b("Signature.DDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            configurableProvider.b("Signature.SHA1WITHDDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA");
            configurableProvider.b("Signature.SHA224WITHDDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA224");
            configurableProvider.b("Signature.SHA256WITHDDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA256");
            configurableProvider.b("Signature.SHA384WITHDDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA384");
            configurableProvider.b("Signature.SHA512WITHDDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSA512");
            configurableProvider.b("Signature.SHA3-224WITHDDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_224");
            configurableProvider.b("Signature.SHA3-256WITHDDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_256");
            configurableProvider.b("Signature.SHA3-384WITHDDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_384");
            configurableProvider.b("Signature.SHA3-512WITHDDSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$detDSASha3_512");
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA224", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa224", NISTObjectIdentifiers.P);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA256", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa256", NISTObjectIdentifiers.Q);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA384", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa384", NISTObjectIdentifiers.R);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA512", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsa512", NISTObjectIdentifiers.S);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA3-224", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_224", NISTObjectIdentifiers.T);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA3-256", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_256", NISTObjectIdentifiers.U);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA3-384", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_384", NISTObjectIdentifiers.V);
            AsymmetricAlgorithmProvider.b(configurableProvider, "SHA3-512", "DSA", "org.spongycastle.jcajce.provider.asymmetric.dsa.DSASigner$dsaSha3_512", NISTObjectIdentifiers.W);
            configurableProvider.b("Alg.Alias.Signature.SHA/DSA", "DSA");
            configurableProvider.b("Alg.Alias.Signature.SHA1withDSA", "DSA");
            configurableProvider.b("Alg.Alias.Signature.SHA1WITHDSA", "DSA");
            configurableProvider.b("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.1", "DSA");
            configurableProvider.b("Alg.Alias.Signature.1.3.14.3.2.26with1.2.840.10040.4.3", "DSA");
            configurableProvider.b("Alg.Alias.Signature.DSAwithSHA1", "DSA");
            configurableProvider.b("Alg.Alias.Signature.DSAWITHSHA1", "DSA");
            configurableProvider.b("Alg.Alias.Signature.SHA1WithDSA", "DSA");
            configurableProvider.b("Alg.Alias.Signature.DSAWithSHA1", "DSA");
            configurableProvider.b("Alg.Alias.Signature.1.2.840.10040.4.3", "DSA");
            KeyFactorySpi keyFactorySpi = new KeyFactorySpi();
            int i = 0;
            while (true) {
                ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = DSAUtil.a;
                if (i != aSN1ObjectIdentifierArr.length) {
                    C1058d.I(new StringBuilder("Alg.Alias.Signature."), aSN1ObjectIdentifierArr[i], configurableProvider, "DSA");
                    AsymmetricAlgorithmProvider.c(configurableProvider, aSN1ObjectIdentifierArr[i], "DSA", keyFactorySpi);
                    AsymmetricAlgorithmProvider.d("DSA", aSN1ObjectIdentifierArr[i], configurableProvider);
                    i++;
                } else {
                    return;
                }
            }
        }
    }
}
