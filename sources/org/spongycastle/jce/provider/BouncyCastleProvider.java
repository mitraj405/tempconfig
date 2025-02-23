package org.spongycastle.jce.provider;

import java.io.IOException;
import java.security.AccessController;
import java.security.PrivateKey;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.PublicKey;
import java.util.HashMap;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.jcajce.provider.config.ConfigurableProvider;
import org.spongycastle.jcajce.provider.config.ProviderConfiguration;
import org.spongycastle.jcajce.provider.symmetric.util.ClassUtil;
import org.spongycastle.jcajce.provider.util.AlgorithmProvider;
import org.spongycastle.jcajce.provider.util.AsymmetricKeyInfoConverter;
import org.spongycastle.pqc.asn1.PQCObjectIdentifiers;
import org.spongycastle.pqc.jcajce.provider.mceliece.McElieceCCA2KeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.mceliece.McElieceKeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.newhope.NHKeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.rainbow.RainbowKeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.sphincs.Sphincs256KeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.xmss.XMSSKeyFactorySpi;
import org.spongycastle.pqc.jcajce.provider.xmss.XMSSMTKeyFactorySpi;

public final class BouncyCastleProvider extends Provider implements ConfigurableProvider {
    public static final HashMap a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public static final ProviderConfiguration f6565a = new BouncyCastleProviderConfiguration();

    /* renamed from: a  reason: collision with other field name */
    public static final String[] f6566a = {"PBEPBKDF1", "PBEPBKDF2", "PBEPKCS12", "TLSKDF"};
    public static final String[] b = {"SipHash", "Poly1305"};
    public static final String[] c = {"AES", "ARC4", "ARIA", "Blowfish", "Camellia", "CAST5", "CAST6", "ChaCha", "DES", "DESede", "GOST28147", "Grainv1", "Grain128", "HC128", "HC256", "IDEA", "Noekeon", "RC2", "RC5", "RC6", "Rijndael", "Salsa20", "SEED", "Serpent", "Shacal2", "Skipjack", "SM4", "TEA", "Twofish", "Threefish", "VMPC", "VMPCKSA3", "XTEA", "XSalsa20", "OpenSSLPBKDF", "DSTU7624"};
    public static final String[] d = {"X509", "IES"};
    public static final String[] e = {"DSA", "DH", "EC", "RSA", "GOST", "ECGOST", "ElGamal", "DSTU4145", "GM"};
    public static final String[] f = {"GOST3411", "Keccak", "MD2", "MD4", "MD5", "SHA1", "RIPEMD128", "RIPEMD160", "RIPEMD256", "RIPEMD320", "SHA224", "SHA256", "SHA384", "SHA512", "SHA3", "Skein", "SM3", "Tiger", "Whirlpool", "Blake2b", "DSTU7564"};
    public static final String[] g = {"BC", "BCFKS", "PKCS12"};
    public static final String[] h = {"DRBG"};

    public BouncyCastleProvider() {
        super("SC", 1.58d, "BouncyCastle Security Provider v1.58");
        AccessController.doPrivileged(new PrivilegedAction() {
            public final Object run() {
                String[] strArr = BouncyCastleProvider.f;
                BouncyCastleProvider bouncyCastleProvider = BouncyCastleProvider.this;
                bouncyCastleProvider.i("org.spongycastle.jcajce.provider.digest.", strArr);
                bouncyCastleProvider.i("org.spongycastle.jcajce.provider.symmetric.", BouncyCastleProvider.f6566a);
                bouncyCastleProvider.i("org.spongycastle.jcajce.provider.symmetric.", BouncyCastleProvider.b);
                bouncyCastleProvider.i("org.spongycastle.jcajce.provider.symmetric.", BouncyCastleProvider.c);
                bouncyCastleProvider.i("org.spongycastle.jcajce.provider.asymmetric.", BouncyCastleProvider.d);
                bouncyCastleProvider.i("org.spongycastle.jcajce.provider.asymmetric.", BouncyCastleProvider.e);
                bouncyCastleProvider.i("org.spongycastle.jcajce.provider.keystore.", BouncyCastleProvider.g);
                bouncyCastleProvider.i("org.spongycastle.jcajce.provider.drbg.", BouncyCastleProvider.h);
                bouncyCastleProvider.a(PQCObjectIdentifiers.h, new Sphincs256KeyFactorySpi());
                bouncyCastleProvider.a(PQCObjectIdentifiers.k, new NHKeyFactorySpi());
                bouncyCastleProvider.a(PQCObjectIdentifiers.l, new XMSSKeyFactorySpi());
                bouncyCastleProvider.a(PQCObjectIdentifiers.m, new XMSSMTKeyFactorySpi());
                bouncyCastleProvider.a(PQCObjectIdentifiers.f, new McElieceKeyFactorySpi());
                bouncyCastleProvider.a(PQCObjectIdentifiers.g, new McElieceCCA2KeyFactorySpi());
                bouncyCastleProvider.a(PQCObjectIdentifiers.a, new RainbowKeyFactorySpi());
                bouncyCastleProvider.put("X509Store.CERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertCollection");
                bouncyCastleProvider.put("X509Store.ATTRIBUTECERTIFICATE/COLLECTION", "org.spongycastle.jce.provider.X509StoreAttrCertCollection");
                bouncyCastleProvider.put("X509Store.CRL/COLLECTION", "org.spongycastle.jce.provider.X509StoreCRLCollection");
                bouncyCastleProvider.put("X509Store.CERTIFICATEPAIR/COLLECTION", "org.spongycastle.jce.provider.X509StoreCertPairCollection");
                bouncyCastleProvider.put("X509Store.CERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCerts");
                bouncyCastleProvider.put("X509Store.CRL/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCRLs");
                bouncyCastleProvider.put("X509Store.ATTRIBUTECERTIFICATE/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPAttrCerts");
                bouncyCastleProvider.put("X509Store.CERTIFICATEPAIR/LDAP", "org.spongycastle.jce.provider.X509StoreLDAPCertPairs");
                bouncyCastleProvider.put("X509StreamParser.CERTIFICATE", "org.spongycastle.jce.provider.X509CertParser");
                bouncyCastleProvider.put("X509StreamParser.ATTRIBUTECERTIFICATE", "org.spongycastle.jce.provider.X509AttrCertParser");
                bouncyCastleProvider.put("X509StreamParser.CRL", "org.spongycastle.jce.provider.X509CRLParser");
                bouncyCastleProvider.put("X509StreamParser.CERTIFICATEPAIR", "org.spongycastle.jce.provider.X509CertPairParser");
                bouncyCastleProvider.put("Cipher.BROKENPBEWITHMD5ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithMD5AndDES");
                bouncyCastleProvider.put("Cipher.BROKENPBEWITHSHA1ANDDES", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$BrokePBEWithSHA1AndDES");
                bouncyCastleProvider.put("Cipher.OLDPBEWITHSHAANDTWOFISH-CBC", "org.spongycastle.jce.provider.BrokenJCEBlockCipher$OldPBEWithSHAAndTwofish");
                bouncyCastleProvider.put("CertPathValidator.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathValidatorSpi");
                bouncyCastleProvider.put("CertPathBuilder.RFC3281", "org.spongycastle.jce.provider.PKIXAttrCertPathBuilderSpi");
                bouncyCastleProvider.put("CertPathValidator.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
                bouncyCastleProvider.put("CertPathBuilder.RFC3280", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
                bouncyCastleProvider.put("CertPathValidator.PKIX", "org.spongycastle.jce.provider.PKIXCertPathValidatorSpi");
                bouncyCastleProvider.put("CertPathBuilder.PKIX", "org.spongycastle.jce.provider.PKIXCertPathBuilderSpi");
                bouncyCastleProvider.put("CertStore.Collection", "org.spongycastle.jce.provider.CertStoreCollectionSpi");
                bouncyCastleProvider.put("CertStore.LDAP", "org.spongycastle.jce.provider.X509LDAPCertStoreSpi");
                bouncyCastleProvider.put("CertStore.Multi", "org.spongycastle.jce.provider.MultiCertStoreSpi");
                bouncyCastleProvider.put("Alg.Alias.CertStore.X509LDAP", "LDAP");
                return null;
            }
        });
    }

    public static PrivateKey f(PrivateKeyInfo privateKeyInfo) throws IOException {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = privateKeyInfo.f5702a.Z0;
        HashMap hashMap = a;
        synchronized (hashMap) {
            asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) hashMap.get(aSN1ObjectIdentifier);
        }
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.a(privateKeyInfo);
    }

    public static PublicKey g(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        AsymmetricKeyInfoConverter asymmetricKeyInfoConverter;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = subjectPublicKeyInfo.f5753a.Z0;
        HashMap hashMap = a;
        synchronized (hashMap) {
            asymmetricKeyInfoConverter = (AsymmetricKeyInfoConverter) hashMap.get(aSN1ObjectIdentifier);
        }
        if (asymmetricKeyInfoConverter == null) {
            return null;
        }
        return asymmetricKeyInfoConverter.b(subjectPublicKeyInfo);
    }

    public final void a(ASN1ObjectIdentifier aSN1ObjectIdentifier, AsymmetricKeyInfoConverter asymmetricKeyInfoConverter) {
        HashMap hashMap = a;
        synchronized (hashMap) {
            hashMap.put(aSN1ObjectIdentifier, asymmetricKeyInfoConverter);
        }
    }

    public final void b(String str, String str2) {
        if (!containsKey(str)) {
            put(str, str2);
            return;
        }
        throw new IllegalStateException(lf.j("duplicate provider key (", str, ") found"));
    }

    public final void c(String str, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str2) {
        b(str + "." + aSN1ObjectIdentifier, str2);
        b(str + ".OID." + aSN1ObjectIdentifier, str2);
    }

    public final boolean d(String str) {
        if (containsKey("MessageDigest.".concat(str)) || containsKey("Alg.Alias.MessageDigest.".concat(str))) {
            return true;
        }
        return false;
    }

    public final void e(String str, HashMap hashMap) {
        for (String str2 : hashMap.keySet()) {
            String D = xx.D(str, " ", str2);
            if (!containsKey(D)) {
                put(D, hashMap.get(str2));
            } else {
                throw new IllegalStateException(lf.j("duplicate provider attribute key (", D, ") found"));
            }
        }
    }

    public final void i(String str, String[] strArr) {
        for (int i = 0; i != strArr.length; i++) {
            StringBuilder J = xx.J(str);
            J.append(strArr[i]);
            J.append("$Mappings");
            Class a2 = ClassUtil.a(BouncyCastleProvider.class, J.toString());
            if (a2 != null) {
                try {
                    ((AlgorithmProvider) a2.newInstance()).a(this);
                } catch (Exception e2) {
                    throw new InternalError("cannot create instance of " + str + strArr[i] + "$Mappings : " + e2);
                }
            }
        }
    }
}
