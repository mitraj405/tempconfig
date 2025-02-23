package org.spongycastle.jcajce.provider.keystore.pkcs12;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.BEROctetString;
import org.spongycastle.asn1.BEROutputStream;
import org.spongycastle.asn1.DERBMPString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DEROutputStream;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.spongycastle.asn1.cryptopro.GOST28147Parameters;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.ntt.NTTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.AuthenticatedSafe;
import org.spongycastle.asn1.pkcs.CertBag;
import org.spongycastle.asn1.pkcs.ContentInfo;
import org.spongycastle.asn1.pkcs.EncryptedData;
import org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.spongycastle.asn1.pkcs.EncryptionScheme;
import org.spongycastle.asn1.pkcs.MacData;
import org.spongycastle.asn1.pkcs.PBES2Parameters;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCS12PBEParams;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.Pfx;
import org.spongycastle.asn1.pkcs.SafeBag;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DigestInfo;
import org.spongycastle.asn1.x509.SubjectKeyIdentifier;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.jcajce.PKCS12Key;
import org.spongycastle.jcajce.PKCS12StoreParameter;
import org.spongycastle.jcajce.spec.GOST28147ParameterSpec;
import org.spongycastle.jcajce.spec.PBKDF2KeySpec;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jce.interfaces.BCKeyStore;
import org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.jce.provider.JDKPKCS12StoreParameter;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Properties;
import org.spongycastle.util.Strings;

public class PKCS12KeyStoreSpi extends KeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore {
    public static final DefaultSecretKeyProvider a = new DefaultSecretKeyProvider();
    public final ASN1ObjectIdentifier Z0;

    /* renamed from: a  reason: collision with other field name */
    public final SecureRandom f6525a = new SecureRandom();

    /* renamed from: a  reason: collision with other field name */
    public final CertificateFactory f6526a;

    /* renamed from: a  reason: collision with other field name */
    public Hashtable f6527a = new Hashtable();

    /* renamed from: a  reason: collision with other field name */
    public AlgorithmIdentifier f6528a = new AlgorithmIdentifier(OIWObjectIdentifiers.f, DERNull.a);

    /* renamed from: a  reason: collision with other field name */
    public IgnoresCaseHashtable f6529a = new IgnoresCaseHashtable(0);

    /* renamed from: a  reason: collision with other field name */
    public final BCJcaJceHelper f6530a = new BCJcaJceHelper();
    public final ASN1ObjectIdentifier a1;
    public Hashtable b = new Hashtable();

    /* renamed from: b  reason: collision with other field name */
    public IgnoresCaseHashtable f6531b = new IgnoresCaseHashtable(0);
    public int c = UserMetadata.MAX_ATTRIBUTE_SIZE;

    /* renamed from: c  reason: collision with other field name */
    public Hashtable f6532c = new Hashtable();
    public int d = 20;

    public static class BCPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public BCPKCS12KeyStore() {
            super(new BouncyCastleProvider(), PKCSObjectIdentifiers.Y, PKCSObjectIdentifiers.b0);
        }
    }

    public static class BCPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public BCPKCS12KeyStore3DES() {
            /*
                r2 = this;
                org.spongycastle.jce.provider.BouncyCastleProvider r0 = new org.spongycastle.jce.provider.BouncyCastleProvider
                r0.<init>()
                org.spongycastle.asn1.ASN1ObjectIdentifier r1 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.Y
                r2.<init>(r0, r1, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.BCPKCS12KeyStore3DES.<init>():void");
        }
    }

    public static class DefPKCS12KeyStore extends PKCS12KeyStoreSpi {
        public DefPKCS12KeyStore() {
            super((BouncyCastleProvider) null, PKCSObjectIdentifiers.Y, PKCSObjectIdentifiers.b0);
        }
    }

    public static class DefPKCS12KeyStore3DES extends PKCS12KeyStoreSpi {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DefPKCS12KeyStore3DES() {
            /*
                r2 = this;
                org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.Y
                r1 = 0
                r2.<init>(r1, r0, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.DefPKCS12KeyStore3DES.<init>():void");
        }
    }

    public static class DefaultSecretKeyProvider {
        public final Map a;

        public DefaultSecretKeyProvider() {
            HashMap hashMap = new HashMap();
            hashMap.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), 128);
            hashMap.put(PKCSObjectIdentifiers.y, 192);
            hashMap.put(NISTObjectIdentifiers.s, 128);
            hashMap.put(NISTObjectIdentifiers.A, 192);
            hashMap.put(NISTObjectIdentifiers.I, 256);
            hashMap.put(NTTObjectIdentifiers.a, 128);
            hashMap.put(NTTObjectIdentifiers.b, 192);
            hashMap.put(NTTObjectIdentifiers.c, 256);
            hashMap.put(CryptoProObjectIdentifiers.e, 256);
            this.a = Collections.unmodifiableMap(hashMap);
        }
    }

    public PKCS12KeyStoreSpi(BouncyCastleProvider bouncyCastleProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2) {
        this.Z0 = aSN1ObjectIdentifier;
        this.a1 = aSN1ObjectIdentifier2;
        if (bouncyCastleProvider != null) {
            try {
                this.f6526a = CertificateFactory.getInstance("X.509", bouncyCastleProvider);
            } catch (Exception e) {
                throw new IllegalArgumentException(C1058d.x(e, new StringBuilder("can't create cert factory - ")));
            }
        } else {
            this.f6526a = CertificateFactory.getInstance("X.509");
        }
    }

    public static SubjectKeyIdentifier c(PublicKey publicKey) {
        try {
            SubjectPublicKeyInfo g = SubjectPublicKeyInfo.g(publicKey.getEncoded());
            SHA1Digest sHA1Digest = new SHA1Digest();
            byte[] bArr = new byte[20];
            byte[] r = g.a.r();
            sHA1Digest.update(r, 0, r.length);
            sHA1Digest.c(0, bArr);
            return new SubjectKeyIdentifier(bArr);
        } catch (Exception unused) {
            throw new RuntimeException("error creating key");
        }
    }

    public static int g(BigInteger bigInteger) {
        BigInteger bigInteger2;
        int intValue = bigInteger.intValue();
        if (intValue >= 0) {
            String a2 = Properties.a("org.spongycastle.pkcs12.max_it_count");
            if (a2 != null) {
                bigInteger2 = new BigInteger(a2);
            } else {
                bigInteger2 = null;
            }
            if (bigInteger2 == null || bigInteger2.intValue() >= intValue) {
                return intValue;
            }
            StringBuilder m = lf.m("iteration count ", intValue, " greater than ");
            m.append(bigInteger2.intValue());
            throw new IllegalStateException(m.toString());
        }
        throw new IllegalStateException("negative iteration count found");
    }

    public final byte[] a(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, int i, char[] cArr, boolean z, byte[] bArr2) throws Exception {
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        Mac instance = Mac.getInstance(aSN1ObjectIdentifier.c, this.f6530a.a);
        instance.init(new PKCS12Key(cArr, z), pBEParameterSpec);
        instance.update(bArr2);
        return instance.doFinal();
    }

    public final Cipher b(int i, char[] cArr, AlgorithmIdentifier algorithmIdentifier) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchProviderException {
        PBES2Parameters pBES2Parameters;
        boolean z;
        SecretKey secretKey;
        ASN1Encodable aSN1Encodable = algorithmIdentifier.a;
        GOST28147Parameters gOST28147Parameters = null;
        if (aSN1Encodable instanceof PBES2Parameters) {
            pBES2Parameters = (PBES2Parameters) aSN1Encodable;
        } else if (aSN1Encodable != null) {
            pBES2Parameters = new PBES2Parameters(ASN1Sequence.q(aSN1Encodable));
        } else {
            pBES2Parameters = null;
        }
        PBKDF2Params g = PBKDF2Params.g(pBES2Parameters.f5695a.a.a);
        EncryptionScheme encryptionScheme = pBES2Parameters.a;
        AlgorithmIdentifier g2 = AlgorithmIdentifier.g(encryptionScheme);
        SecretKeyFactory instance = SecretKeyFactory.getInstance(pBES2Parameters.f5695a.a.Z0.c, this.f6530a.a);
        AlgorithmIdentifier algorithmIdentifier2 = g.f5697a;
        if (algorithmIdentifier2 == null || algorithmIdentifier2.equals(PBKDF2Params.b)) {
            z = true;
        } else {
            z = false;
        }
        DefaultSecretKeyProvider defaultSecretKeyProvider = a;
        int i2 = -1;
        ASN1Integer aSN1Integer = g.a;
        ASN1OctetString aSN1OctetString = g.f5696a;
        if (z) {
            byte[] s = aSN1OctetString.s();
            int g3 = g(aSN1Integer.t());
            defaultSecretKeyProvider.getClass();
            Integer num = (Integer) defaultSecretKeyProvider.a.get(g2.Z0);
            if (num != null) {
                i2 = num.intValue();
            }
            secretKey = instance.generateSecret(new PBEKeySpec(cArr, s, g3, i2));
        } else {
            byte[] s2 = aSN1OctetString.s();
            int g4 = g(aSN1Integer.t());
            defaultSecretKeyProvider.getClass();
            Integer num2 = (Integer) defaultSecretKeyProvider.a.get(g2.Z0);
            if (num2 != null) {
                i2 = num2.intValue();
            }
            int i3 = i2;
            AlgorithmIdentifier algorithmIdentifier3 = g.f5697a;
            if (algorithmIdentifier3 == null) {
                algorithmIdentifier3 = PBKDF2Params.b;
            }
            secretKey = instance.generateSecret(new PBKDF2KeySpec(cArr, s2, g4, i3, algorithmIdentifier3));
        }
        Cipher instance2 = Cipher.getInstance(encryptionScheme.a.Z0.c);
        ASN1Encodable aSN1Encodable2 = encryptionScheme.a.a;
        if (aSN1Encodable2 instanceof ASN1OctetString) {
            instance2.init(i, secretKey, new IvParameterSpec(ASN1OctetString.q(aSN1Encodable2).s()));
        } else {
            if (aSN1Encodable2 instanceof GOST28147Parameters) {
                gOST28147Parameters = (GOST28147Parameters) aSN1Encodable2;
            } else if (aSN1Encodable2 != null) {
                gOST28147Parameters = new GOST28147Parameters(ASN1Sequence.q(aSN1Encodable2));
            }
            instance2.init(i, secretKey, new GOST28147ParameterSpec(gOST28147Parameters.Z0, Arrays.c(gOST28147Parameters.a.s())));
        }
        return instance2;
    }

    public final byte[] d(boolean z, AlgorithmIdentifier algorithmIdentifier, char[] cArr, boolean z2, byte[] bArr) throws IOException {
        int i;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = algorithmIdentifier.Z0;
        if (z) {
            i = 1;
        } else {
            i = 2;
        }
        if (aSN1ObjectIdentifier.x(PKCSObjectIdentifiers.V)) {
            PKCS12PBEParams g = PKCS12PBEParams.g(algorithmIdentifier.a);
            try {
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(g.f5699a.s(), g.a.t().intValue());
                PKCS12Key pKCS12Key = new PKCS12Key(cArr, z2);
                Cipher instance = Cipher.getInstance(aSN1ObjectIdentifier.c, this.f6530a.a);
                instance.init(i, pKCS12Key, pBEParameterSpec);
                return instance.doFinal(bArr);
            } catch (Exception e) {
                throw new IOException(C1058d.x(e, new StringBuilder("exception decrypting data - ")));
            }
        } else if (aSN1ObjectIdentifier.equals(PKCSObjectIdentifiers.w)) {
            try {
                return b(i, cArr, algorithmIdentifier).doFinal(bArr);
            } catch (Exception e2) {
                throw new IOException(C1058d.x(e2, new StringBuilder("exception decrypting data - ")));
            }
        } else {
            throw new IOException("unknown PBE algorithm: " + aSN1ObjectIdentifier);
        }
    }

    public final void e(OutputStream outputStream, char[] cArr, boolean z) throws IOException {
        SecureRandom secureRandom;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4;
        DEROutputStream dEROutputStream;
        DEROutputStream dEROutputStream2;
        String str;
        Enumeration enumeration;
        boolean z2;
        AlgorithmIdentifier algorithmIdentifier;
        BEROctetString bEROctetString;
        boolean z3;
        boolean z4;
        OutputStream outputStream2 = outputStream;
        char[] cArr2 = cArr;
        if (cArr2 != null) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            Enumeration b2 = this.f6529a.b();
            while (true) {
                boolean hasMoreElements = b2.hasMoreElements();
                secureRandom = this.f6525a;
                aSN1ObjectIdentifier = PKCSObjectIdentifiers.Q;
                aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.P;
                if (!hasMoreElements) {
                    break;
                }
                byte[] bArr = new byte[20];
                secureRandom.nextBytes(bArr);
                String str2 = (String) b2.nextElement();
                PrivateKey privateKey = (PrivateKey) this.f6529a.a(str2);
                PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams(bArr, UserMetadata.MAX_ATTRIBUTE_SIZE);
                ASN1ObjectIdentifier aSN1ObjectIdentifier5 = this.Z0;
                String str3 = aSN1ObjectIdentifier5.c;
                PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr2);
                BCJcaJceHelper bCJcaJceHelper = this.f6530a;
                try {
                    SecretKeyFactory instance = SecretKeyFactory.getInstance(str3, bCJcaJceHelper.a);
                    Enumeration enumeration2 = b2;
                    PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.f5699a.s(), pKCS12PBEParams.a.t().intValue());
                    Cipher instance2 = Cipher.getInstance(str3, bCJcaJceHelper.a);
                    instance2.init(3, instance.generateSecret(pBEKeySpec), pBEParameterSpec);
                    EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier5, pKCS12PBEParams.b()), instance2.wrap(privateKey));
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    if (privateKey instanceof PKCS12BagAttributeCarrier) {
                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier = (PKCS12BagAttributeCarrier) privateKey;
                        DERBMPString dERBMPString = (DERBMPString) pKCS12BagAttributeCarrier.d(aSN1ObjectIdentifier2);
                        if (dERBMPString == null || !dERBMPString.c().equals(str2)) {
                            pKCS12BagAttributeCarrier.f(aSN1ObjectIdentifier2, new DERBMPString(str2));
                        }
                        if (pKCS12BagAttributeCarrier.d(aSN1ObjectIdentifier) == null) {
                            pKCS12BagAttributeCarrier.f(aSN1ObjectIdentifier, c(engineGetCertificate(str2).getPublicKey()));
                        }
                        Enumeration e = pKCS12BagAttributeCarrier.e();
                        z4 = false;
                        while (e.hasMoreElements()) {
                            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = (ASN1ObjectIdentifier) e.nextElement();
                            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
                            aSN1EncodableVector3.a(aSN1ObjectIdentifier6);
                            aSN1EncodableVector3.a(new DERSet(pKCS12BagAttributeCarrier.d(aSN1ObjectIdentifier6)));
                            aSN1EncodableVector2.a(new DERSequence(aSN1EncodableVector3));
                            z4 = true;
                        }
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                        Certificate engineGetCertificate = engineGetCertificate(str2);
                        aSN1EncodableVector4.a(aSN1ObjectIdentifier);
                        aSN1EncodableVector4.a(new DERSet((ASN1Encodable) c(engineGetCertificate.getPublicKey())));
                        aSN1EncodableVector2.a(new DERSequence(aSN1EncodableVector4));
                        ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                        aSN1EncodableVector5.a(aSN1ObjectIdentifier2);
                        aSN1EncodableVector5.a(new DERSet((ASN1Encodable) new DERBMPString(str2)));
                        aSN1EncodableVector2.a(new DERSequence(aSN1EncodableVector5));
                    }
                    aSN1EncodableVector.a(new SafeBag(PKCSObjectIdentifiers.T, (DERSequence) encryptedPrivateKeyInfo.b(), new DERSet(aSN1EncodableVector2)));
                    cArr2 = cArr;
                    b2 = enumeration2;
                } catch (Exception e2) {
                    throw new IOException(C1058d.x(e2, new StringBuilder("exception encrypting data - ")));
                }
            }
            DERSequence dERSequence = new DERSequence(aSN1EncodableVector);
            String str4 = "DER";
            BEROctetString bEROctetString2 = new BEROctetString(dERSequence.f(str4));
            byte[] bArr2 = new byte[20];
            secureRandom.nextBytes(bArr2);
            ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
            AlgorithmIdentifier algorithmIdentifier2 = new AlgorithmIdentifier(this.a1, new PKCS12PBEParams(bArr2, UserMetadata.MAX_ATTRIBUTE_SIZE).b());
            Hashtable hashtable = new Hashtable();
            Enumeration b3 = this.f6529a.b();
            while (true) {
                boolean hasMoreElements2 = b3.hasMoreElements();
                aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.U;
                aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.R;
                if (!hasMoreElements2) {
                    break;
                }
                try {
                    String str5 = (String) b3.nextElement();
                    Certificate engineGetCertificate2 = engineGetCertificate(str5);
                    Enumeration enumeration3 = b3;
                    SecureRandom secureRandom2 = secureRandom;
                    CertBag certBag = new CertBag(aSN1ObjectIdentifier4, new DEROctetString(engineGetCertificate2.getEncoded()));
                    ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
                    if (engineGetCertificate2 instanceof PKCS12BagAttributeCarrier) {
                        PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier2 = (PKCS12BagAttributeCarrier) engineGetCertificate2;
                        DERBMPString dERBMPString2 = (DERBMPString) pKCS12BagAttributeCarrier2.d(aSN1ObjectIdentifier2);
                        if (dERBMPString2 == null || !dERBMPString2.c().equals(str5)) {
                            pKCS12BagAttributeCarrier2.f(aSN1ObjectIdentifier2, new DERBMPString(str5));
                        }
                        if (pKCS12BagAttributeCarrier2.d(aSN1ObjectIdentifier) == null) {
                            pKCS12BagAttributeCarrier2.f(aSN1ObjectIdentifier, c(engineGetCertificate2.getPublicKey()));
                        }
                        Enumeration e3 = pKCS12BagAttributeCarrier2.e();
                        z3 = false;
                        while (e3.hasMoreElements()) {
                            Enumeration enumeration4 = e3;
                            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = (ASN1ObjectIdentifier) e3.nextElement();
                            BEROctetString bEROctetString3 = bEROctetString2;
                            ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                            aSN1EncodableVector8.a(aSN1ObjectIdentifier7);
                            aSN1EncodableVector8.a(new DERSet(pKCS12BagAttributeCarrier2.d(aSN1ObjectIdentifier7)));
                            aSN1EncodableVector7.a(new DERSequence(aSN1EncodableVector8));
                            z3 = true;
                            e3 = enumeration4;
                            bEROctetString2 = bEROctetString3;
                            algorithmIdentifier2 = algorithmIdentifier2;
                        }
                        bEROctetString = bEROctetString2;
                        algorithmIdentifier = algorithmIdentifier2;
                    } else {
                        bEROctetString = bEROctetString2;
                        algorithmIdentifier = algorithmIdentifier2;
                        z3 = false;
                    }
                    if (!z3) {
                        ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                        aSN1EncodableVector9.a(aSN1ObjectIdentifier);
                        aSN1EncodableVector9.a(new DERSet((ASN1Encodable) c(engineGetCertificate2.getPublicKey())));
                        aSN1EncodableVector7.a(new DERSequence(aSN1EncodableVector9));
                        ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                        aSN1EncodableVector10.a(aSN1ObjectIdentifier2);
                        aSN1EncodableVector10.a(new DERSet((ASN1Encodable) new DERBMPString(str5)));
                        aSN1EncodableVector7.a(new DERSequence(aSN1EncodableVector10));
                    }
                    aSN1EncodableVector6.a(new SafeBag(aSN1ObjectIdentifier3, (DERSequence) certBag.b(), new DERSet(aSN1EncodableVector7)));
                    hashtable.put(engineGetCertificate2, engineGetCertificate2);
                    OutputStream outputStream3 = outputStream;
                    b3 = enumeration3;
                    secureRandom = secureRandom2;
                    bEROctetString2 = bEROctetString;
                    algorithmIdentifier2 = algorithmIdentifier;
                } catch (CertificateEncodingException e4) {
                    throw new IOException("Error encoding certificate: " + e4.toString());
                }
            }
            BEROctetString bEROctetString4 = bEROctetString2;
            SecureRandom secureRandom3 = secureRandom;
            AlgorithmIdentifier algorithmIdentifier3 = algorithmIdentifier2;
            Enumeration b4 = this.f6531b.b();
            while (b4.hasMoreElements()) {
                try {
                    String str6 = (String) b4.nextElement();
                    Certificate certificate = (Certificate) this.f6531b.a(str6);
                    if (this.f6529a.a(str6) == null) {
                        CertBag certBag2 = new CertBag(aSN1ObjectIdentifier4, new DEROctetString(certificate.getEncoded()));
                        ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
                        if (certificate instanceof PKCS12BagAttributeCarrier) {
                            PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier3 = (PKCS12BagAttributeCarrier) certificate;
                            DERBMPString dERBMPString3 = (DERBMPString) pKCS12BagAttributeCarrier3.d(aSN1ObjectIdentifier2);
                            if (dERBMPString3 == null || !dERBMPString3.c().equals(str6)) {
                                pKCS12BagAttributeCarrier3.f(aSN1ObjectIdentifier2, new DERBMPString(str6));
                            }
                            Enumeration e5 = pKCS12BagAttributeCarrier3.e();
                            z2 = false;
                            while (e5.hasMoreElements()) {
                                Enumeration enumeration5 = b4;
                                ASN1ObjectIdentifier aSN1ObjectIdentifier8 = (ASN1ObjectIdentifier) e5.nextElement();
                                if (aSN1ObjectIdentifier8.equals(aSN1ObjectIdentifier)) {
                                    b4 = enumeration5;
                                } else {
                                    Enumeration enumeration6 = e5;
                                    ASN1EncodableVector aSN1EncodableVector12 = new ASN1EncodableVector();
                                    aSN1EncodableVector12.a(aSN1ObjectIdentifier8);
                                    aSN1EncodableVector12.a(new DERSet(pKCS12BagAttributeCarrier3.d(aSN1ObjectIdentifier8)));
                                    aSN1EncodableVector11.a(new DERSequence(aSN1EncodableVector12));
                                    z2 = true;
                                    e5 = enumeration6;
                                    b4 = enumeration5;
                                    str4 = str4;
                                }
                            }
                            enumeration = b4;
                            str = str4;
                        } else {
                            enumeration = b4;
                            str = str4;
                            z2 = false;
                        }
                        if (!z2) {
                            ASN1EncodableVector aSN1EncodableVector13 = new ASN1EncodableVector();
                            aSN1EncodableVector13.a(aSN1ObjectIdentifier2);
                            aSN1EncodableVector13.a(new DERSet((ASN1Encodable) new DERBMPString(str6)));
                            aSN1EncodableVector11.a(new DERSequence(aSN1EncodableVector13));
                        }
                        aSN1EncodableVector6.a(new SafeBag(aSN1ObjectIdentifier3, (DERSequence) certBag2.b(), new DERSet(aSN1EncodableVector11)));
                        hashtable.put(certificate, certificate);
                        b4 = enumeration;
                        str4 = str;
                    }
                } catch (CertificateEncodingException e6) {
                    throw new IOException("Error encoding certificate: " + e6.toString());
                }
            }
            String str7 = str4;
            HashSet hashSet = new HashSet();
            Enumeration b5 = this.f6529a.b();
            while (b5.hasMoreElements()) {
                Certificate[] engineGetCertificateChain = engineGetCertificateChain((String) b5.nextElement());
                for (int i = 0; i != engineGetCertificateChain.length; i++) {
                    hashSet.add(engineGetCertificateChain[i]);
                }
            }
            Enumeration b6 = this.f6531b.b();
            while (b6.hasMoreElements()) {
                hashSet.add(engineGetCertificate((String) b6.nextElement()));
            }
            Enumeration keys = this.b.keys();
            while (keys.hasMoreElements()) {
                try {
                    Certificate certificate2 = (Certificate) this.b.get((CertId) keys.nextElement());
                    if (hashSet.contains(certificate2)) {
                        if (hashtable.get(certificate2) == null) {
                            CertBag certBag3 = new CertBag(aSN1ObjectIdentifier4, new DEROctetString(certificate2.getEncoded()));
                            ASN1EncodableVector aSN1EncodableVector14 = new ASN1EncodableVector();
                            if (certificate2 instanceof PKCS12BagAttributeCarrier) {
                                PKCS12BagAttributeCarrier pKCS12BagAttributeCarrier4 = (PKCS12BagAttributeCarrier) certificate2;
                                Enumeration e7 = pKCS12BagAttributeCarrier4.e();
                                while (e7.hasMoreElements()) {
                                    ASN1ObjectIdentifier aSN1ObjectIdentifier9 = (ASN1ObjectIdentifier) e7.nextElement();
                                    if (!aSN1ObjectIdentifier9.equals(aSN1ObjectIdentifier)) {
                                        ASN1EncodableVector aSN1EncodableVector15 = new ASN1EncodableVector();
                                        aSN1EncodableVector15.a(aSN1ObjectIdentifier9);
                                        aSN1EncodableVector15.a(new DERSet(pKCS12BagAttributeCarrier4.d(aSN1ObjectIdentifier9)));
                                        aSN1EncodableVector14.a(new DERSequence(aSN1EncodableVector15));
                                    }
                                }
                            }
                            aSN1EncodableVector6.a(new SafeBag(aSN1ObjectIdentifier3, (DERSequence) certBag3.b(), new DERSet(aSN1EncodableVector14)));
                        }
                    }
                } catch (CertificateEncodingException e8) {
                    throw new IOException("Error encoding certificate: " + e8.toString());
                }
            }
            byte[] f = new DERSequence(aSN1EncodableVector6).f(str7);
            AlgorithmIdentifier algorithmIdentifier4 = algorithmIdentifier3;
            BEROctetString bEROctetString5 = new BEROctetString(d(true, algorithmIdentifier4, cArr, false, f));
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = PKCSObjectIdentifiers.J;
            AuthenticatedSafe authenticatedSafe = new AuthenticatedSafe(new ContentInfo[]{new ContentInfo(aSN1ObjectIdentifier10, bEROctetString4), new ContentInfo(PKCSObjectIdentifiers.L, new EncryptedData(aSN1ObjectIdentifier10, algorithmIdentifier4, bEROctetString5).b())});
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (z) {
                dEROutputStream = new DEROutputStream(byteArrayOutputStream);
            } else {
                dEROutputStream = new BEROutputStream(byteArrayOutputStream);
            }
            dEROutputStream.g(authenticatedSafe);
            ContentInfo contentInfo = new ContentInfo(aSN1ObjectIdentifier10, new BEROctetString(byteArrayOutputStream.toByteArray()));
            byte[] bArr3 = new byte[this.d];
            secureRandom3.nextBytes(bArr3);
            try {
                Pfx pfx = new Pfx(contentInfo, new MacData(new DigestInfo(this.f6528a, a(this.f6528a.Z0, bArr3, this.c, cArr, false, ((ASN1OctetString) contentInfo.a).s())), bArr3, this.c));
                if (z) {
                    dEROutputStream2 = new DEROutputStream(outputStream);
                } else {
                    dEROutputStream2 = new BEROutputStream(outputStream);
                }
                dEROutputStream2.g(pfx);
            } catch (Exception e9) {
                throw new IOException(C1058d.x(e9, new StringBuilder("error constructing MAC: ")));
            }
        } else {
            throw new NullPointerException("No password supplied for PKCS#12 KeyStore.");
        }
    }

    public final Enumeration engineAliases() {
        Hashtable hashtable = new Hashtable();
        Enumeration b2 = this.f6531b.b();
        while (b2.hasMoreElements()) {
            hashtable.put(b2.nextElement(), "cert");
        }
        Enumeration b3 = this.f6529a.b();
        while (b3.hasMoreElements()) {
            String str = (String) b3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.keys();
    }

    public final boolean engineContainsAlias(String str) {
        if (this.f6531b.a(str) == null && this.f6529a.a(str) == null) {
            return false;
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.security.cert.Certificate} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void engineDeleteEntry(java.lang.String r6) throws java.security.KeyStoreException {
        /*
            r5 = this;
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r0 = r5.f6529a
            java.lang.Object r0 = r0.d(r6)
            java.security.Key r0 = (java.security.Key) r0
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r1 = r5.f6531b
            java.lang.Object r1 = r1.d(r6)
            java.security.cert.Certificate r1 = (java.security.cert.Certificate) r1
            if (r1 == 0) goto L_0x0020
            java.util.Hashtable r2 = r5.b
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r3 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId
            java.security.PublicKey r4 = r1.getPublicKey()
            r3.<init>(r5, r4)
            r2.remove(r3)
        L_0x0020:
            if (r0 == 0) goto L_0x0045
            java.util.Hashtable r0 = r5.f6527a
            java.lang.Object r6 = r0.remove(r6)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0035
            java.util.Hashtable r0 = r5.f6532c
            java.lang.Object r6 = r0.remove(r6)
            r1 = r6
            java.security.cert.Certificate r1 = (java.security.cert.Certificate) r1
        L_0x0035:
            if (r1 == 0) goto L_0x0045
            java.util.Hashtable r6 = r5.b
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r0 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId
            java.security.PublicKey r1 = r1.getPublicKey()
            r0.<init>(r5, r1)
            r6.remove(r0)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineDeleteEntry(java.lang.String):void");
    }

    public final Certificate engineGetCertificate(String str) {
        if (str != null) {
            Certificate certificate = (Certificate) this.f6531b.a(str);
            if (certificate != null) {
                return certificate;
            }
            String str2 = (String) this.f6527a.get(str);
            if (str2 != null) {
                return (Certificate) this.f6532c.get(str2);
            }
            return (Certificate) this.f6532c.get(str);
        }
        throw new IllegalArgumentException("null alias passed to getCertificate.");
    }

    public final String engineGetCertificateAlias(Certificate certificate) {
        Enumeration elements = this.f6531b.a.elements();
        Enumeration b2 = this.f6531b.b();
        while (elements.hasMoreElements()) {
            String str = (String) b2.nextElement();
            if (((Certificate) elements.nextElement()).equals(certificate)) {
                return str;
            }
        }
        Enumeration elements2 = this.f6532c.elements();
        Enumeration keys = this.f6532c.keys();
        while (elements2.hasMoreElements()) {
            String str2 = (String) keys.nextElement();
            if (((Certificate) elements2.nextElement()).equals(certificate)) {
                return str2;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.cert.Certificate[] engineGetCertificateChain(java.lang.String r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x00e2
            boolean r0 = r8.engineIsKeyEntry(r9)
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            java.security.cert.Certificate r9 = r8.engineGetCertificate(r9)
            if (r9 == 0) goto L_0x00e1
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
        L_0x0015:
            if (r9 == 0) goto L_0x00cd
            r2 = r9
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.x509.Extension.n1
            java.lang.String r3 = r3.c
            byte[] r3 = r2.getExtensionValue(r3)
            if (r3 == 0) goto L_0x0080
            org.spongycastle.asn1.ASN1InputStream r4 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ IOException -> 0x0075 }
            r4.<init>((byte[]) r3)     // Catch:{ IOException -> 0x0075 }
            org.spongycastle.asn1.ASN1Primitive r3 = r4.j()     // Catch:{ IOException -> 0x0075 }
            org.spongycastle.asn1.ASN1OctetString r3 = (org.spongycastle.asn1.ASN1OctetString) r3     // Catch:{ IOException -> 0x0075 }
            byte[] r3 = r3.s()     // Catch:{ IOException -> 0x0075 }
            org.spongycastle.asn1.ASN1InputStream r4 = new org.spongycastle.asn1.ASN1InputStream     // Catch:{ IOException -> 0x0075 }
            r4.<init>((byte[]) r3)     // Catch:{ IOException -> 0x0075 }
            org.spongycastle.asn1.ASN1Primitive r3 = r4.j()     // Catch:{ IOException -> 0x0075 }
            boolean r4 = r3 instanceof org.spongycastle.asn1.x509.AuthorityKeyIdentifier     // Catch:{ IOException -> 0x0075 }
            if (r4 == 0) goto L_0x0043
            org.spongycastle.asn1.x509.AuthorityKeyIdentifier r3 = (org.spongycastle.asn1.x509.AuthorityKeyIdentifier) r3     // Catch:{ IOException -> 0x0075 }
            goto L_0x0051
        L_0x0043:
            if (r3 == 0) goto L_0x0050
            org.spongycastle.asn1.x509.AuthorityKeyIdentifier r4 = new org.spongycastle.asn1.x509.AuthorityKeyIdentifier     // Catch:{ IOException -> 0x0075 }
            org.spongycastle.asn1.ASN1Sequence r3 = org.spongycastle.asn1.ASN1Sequence.q(r3)     // Catch:{ IOException -> 0x0075 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0075 }
            r3 = r4
            goto L_0x0051
        L_0x0050:
            r3 = r1
        L_0x0051:
            org.spongycastle.asn1.ASN1OctetString r4 = r3.f5726a     // Catch:{ IOException -> 0x0075 }
            if (r4 == 0) goto L_0x005a
            byte[] r4 = r4.s()     // Catch:{ IOException -> 0x0075 }
            goto L_0x005b
        L_0x005a:
            r4 = r1
        L_0x005b:
            if (r4 == 0) goto L_0x0080
            java.util.Hashtable r4 = r8.b     // Catch:{ IOException -> 0x0075 }
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r5 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId     // Catch:{ IOException -> 0x0075 }
            org.spongycastle.asn1.ASN1OctetString r3 = r3.f5726a     // Catch:{ IOException -> 0x0075 }
            if (r3 == 0) goto L_0x006a
            byte[] r3 = r3.s()     // Catch:{ IOException -> 0x0075 }
            goto L_0x006b
        L_0x006a:
            r3 = r1
        L_0x006b:
            r5.<init>(r3)     // Catch:{ IOException -> 0x0075 }
            java.lang.Object r3 = r4.get(r5)     // Catch:{ IOException -> 0x0075 }
            java.security.cert.Certificate r3 = (java.security.cert.Certificate) r3     // Catch:{ IOException -> 0x0075 }
            goto L_0x0081
        L_0x0075:
            r9 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        L_0x0080:
            r3 = r1
        L_0x0081:
            if (r3 != 0) goto L_0x00bb
            java.security.Principal r4 = r2.getIssuerDN()
            java.security.Principal r5 = r2.getSubjectDN()
            boolean r5 = r4.equals(r5)
            if (r5 != 0) goto L_0x00bb
            java.util.Hashtable r5 = r8.b
            java.util.Enumeration r5 = r5.keys()
        L_0x0097:
            boolean r6 = r5.hasMoreElements()
            if (r6 == 0) goto L_0x00bb
            java.util.Hashtable r6 = r8.b
            java.lang.Object r7 = r5.nextElement()
            java.lang.Object r6 = r6.get(r7)
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6
            java.security.Principal r7 = r6.getSubjectDN()
            boolean r7 = r7.equals(r4)
            if (r7 == 0) goto L_0x0097
            java.security.PublicKey r7 = r6.getPublicKey()     // Catch:{ Exception -> 0x0097 }
            r2.verify(r7)     // Catch:{ Exception -> 0x0097 }
            r3 = r6
        L_0x00bb:
            boolean r2 = r0.contains(r9)
            if (r2 == 0) goto L_0x00c2
            goto L_0x00ca
        L_0x00c2:
            r0.addElement(r9)
            if (r3 == r9) goto L_0x00ca
            r9 = r3
            goto L_0x0015
        L_0x00ca:
            r9 = r1
            goto L_0x0015
        L_0x00cd:
            int r9 = r0.size()
            java.security.cert.Certificate[] r1 = new java.security.cert.Certificate[r9]
            r2 = 0
        L_0x00d4:
            if (r2 == r9) goto L_0x00e1
            java.lang.Object r3 = r0.elementAt(r2)
            java.security.cert.Certificate r3 = (java.security.cert.Certificate) r3
            r1[r2] = r3
            int r2 = r2 + 1
            goto L_0x00d4
        L_0x00e1:
            return r1
        L_0x00e2:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "null alias passed to getCertificateChain."
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineGetCertificateChain(java.lang.String):java.security.cert.Certificate[]");
    }

    public final Date engineGetCreationDate(String str) {
        if (str == null) {
            throw new NullPointerException("alias == null");
        } else if (this.f6529a.a(str) == null && this.f6531b.a(str) == null) {
            return null;
        } else {
            return new Date();
        }
    }

    public final Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        if (str != null) {
            return (Key) this.f6529a.a(str);
        }
        throw new IllegalArgumentException("null alias passed to getKey.");
    }

    public final boolean engineIsCertificateEntry(String str) {
        if (this.f6531b.a(str) == null || this.f6529a.a(str) != null) {
            return false;
        }
        return true;
    }

    public final boolean engineIsKeyEntry(String str) {
        if (this.f6529a.a(str) != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: type inference failed for: r5v11, types: [org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Encodable, java.lang.Object] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x04ee  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e3  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void engineLoad(java.io.InputStream r24, char[] r25) throws java.io.IOException {
        /*
            r23 = this;
            r8 = r23
            r0 = r24
            r9 = r25
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            if (r9 == 0) goto L_0x0628
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream
            r1.<init>(r0)
            r0 = 10
            r1.mark(r0)
            int r0 = r1.read()
            r2 = 48
            if (r0 != r2) goto L_0x0620
            r1.reset()
            org.spongycastle.asn1.ASN1InputStream r0 = new org.spongycastle.asn1.ASN1InputStream
            r0.<init>((java.io.InputStream) r1)
            org.spongycastle.asn1.ASN1Primitive r0 = r0.j()
            org.spongycastle.asn1.ASN1Sequence r0 = (org.spongycastle.asn1.ASN1Sequence) r0
            boolean r1 = r0 instanceof org.spongycastle.asn1.pkcs.Pfx
            if (r1 == 0) goto L_0x0032
            org.spongycastle.asn1.pkcs.Pfx r0 = (org.spongycastle.asn1.pkcs.Pfx) r0
            goto L_0x0040
        L_0x0032:
            if (r0 == 0) goto L_0x003f
            org.spongycastle.asn1.pkcs.Pfx r1 = new org.spongycastle.asn1.pkcs.Pfx
            org.spongycastle.asn1.ASN1Sequence r0 = org.spongycastle.asn1.ASN1Sequence.q(r0)
            r1.<init>(r0)
            r0 = r1
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            org.spongycastle.asn1.pkcs.ContentInfo r10 = r0.a
            java.util.Vector r11 = new java.util.Vector
            r11.<init>()
            r12 = 0
            org.spongycastle.asn1.pkcs.MacData r0 = r0.f5700a
            if (r0 == 0) goto L_0x00c2
            org.spongycastle.asn1.x509.DigestInfo r13 = r0.f5692a
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r13.a
            r8.f6528a = r1
            byte[] r1 = r0.f5693a
            byte[] r14 = org.spongycastle.util.Arrays.c(r1)
            java.math.BigInteger r0 = r0.a
            int r0 = g(r0)
            r8.c = r0
            int r0 = r14.length
            r8.d = r0
            org.spongycastle.asn1.ASN1Encodable r0 = r10.a
            org.spongycastle.asn1.ASN1OctetString r0 = (org.spongycastle.asn1.ASN1OctetString) r0
            byte[] r0 = r0.s()
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r8.f6528a     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r1.Z0     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            int r4 = r8.c     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            r6 = 0
            r1 = r23
            r3 = r14
            r5 = r25
            r7 = r0
            byte[] r1 = r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            byte[] r13 = r13.f5737a     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            boolean r1 = org.spongycastle.util.Arrays.l(r1, r13)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            if (r1 != 0) goto L_0x00c2
            int r1 = r9.length     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            java.lang.String r15 = "PKCS12 key store mac invalid - wrong password or corrupted file."
            if (r1 > 0) goto L_0x00a8
            org.spongycastle.asn1.x509.AlgorithmIdentifier r1 = r8.f6528a     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r1.Z0     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            int r4 = r8.c     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            r6 = 1
            r1 = r23
            r3 = r14
            r5 = r25
            r7 = r0
            byte[] r0 = r1.a(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            boolean r0 = org.spongycastle.util.Arrays.l(r0, r13)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            if (r0 == 0) goto L_0x00a2
            r0 = 1
            goto L_0x00c3
        L_0x00a2:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            r0.<init>(r15)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            throw r0     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
        L_0x00a8:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            r0.<init>(r15)     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
            throw r0     // Catch:{ IOException -> 0x00c0, Exception -> 0x00ae }
        L_0x00ae:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "error constructing MAC: "
            r2.<init>(r3)
            java.lang.String r0 = defpackage.C1058d.x(r0, r2)
            r1.<init>(r0)
            throw r1
        L_0x00c0:
            r0 = move-exception
            throw r0
        L_0x00c2:
            r0 = r12
        L_0x00c3:
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r1 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable
            r1.<init>(r12)
            r8.f6529a = r1
            java.util.Hashtable r1 = new java.util.Hashtable
            r1.<init>()
            r8.f6527a = r1
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r10.Z0
            org.spongycastle.asn1.ASN1ObjectIdentifier r7 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.J
            boolean r1 = r1.equals(r7)
            java.lang.String r13 = "unmarked"
            java.lang.String r14 = "attempt to add existing attribute with different value"
            org.spongycastle.asn1.ASN1ObjectIdentifier r15 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.Q
            org.spongycastle.asn1.ASN1ObjectIdentifier r6 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.P
            if (r1 == 0) goto L_0x04cc
            org.spongycastle.asn1.ASN1InputStream r1 = new org.spongycastle.asn1.ASN1InputStream
            org.spongycastle.asn1.ASN1Encodable r2 = r10.a
            org.spongycastle.asn1.ASN1OctetString r2 = (org.spongycastle.asn1.ASN1OctetString) r2
            byte[] r2 = r2.s()
            r1.<init>((byte[]) r2)
            org.spongycastle.asn1.ASN1Primitive r1 = r1.j()
            boolean r2 = r1 instanceof org.spongycastle.asn1.pkcs.AuthenticatedSafe
            if (r2 == 0) goto L_0x00fb
            org.spongycastle.asn1.pkcs.AuthenticatedSafe r1 = (org.spongycastle.asn1.pkcs.AuthenticatedSafe) r1
            goto L_0x0109
        L_0x00fb:
            if (r1 == 0) goto L_0x0108
            org.spongycastle.asn1.pkcs.AuthenticatedSafe r2 = new org.spongycastle.asn1.pkcs.AuthenticatedSafe
            org.spongycastle.asn1.ASN1Sequence r1 = org.spongycastle.asn1.ASN1Sequence.q(r1)
            r2.<init>((org.spongycastle.asn1.ASN1Sequence) r1)
            r1 = r2
            goto L_0x0109
        L_0x0108:
            r1 = 0
        L_0x0109:
            org.spongycastle.asn1.pkcs.ContentInfo[] r10 = r1.f5689a
            r1 = r12
            r16 = r1
        L_0x010e:
            int r2 = r10.length
            if (r12 == r2) goto L_0x04c8
            r2 = r10[r12]
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r2.Z0
            boolean r2 = r2.equals(r7)
            org.spongycastle.asn1.ASN1ObjectIdentifier r5 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.U
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.T
            if (r2 == 0) goto L_0x0260
            org.spongycastle.asn1.ASN1InputStream r2 = new org.spongycastle.asn1.ASN1InputStream
            r3 = r10[r12]
            org.spongycastle.asn1.ASN1Encodable r3 = r3.a
            org.spongycastle.asn1.ASN1OctetString r3 = (org.spongycastle.asn1.ASN1OctetString) r3
            byte[] r3 = r3.s()
            r2.<init>((byte[]) r3)
            org.spongycastle.asn1.ASN1Primitive r2 = r2.j()
            org.spongycastle.asn1.ASN1Sequence r2 = (org.spongycastle.asn1.ASN1Sequence) r2
        L_0x0134:
            int r3 = r2.size()
            if (r1 == r3) goto L_0x0257
            org.spongycastle.asn1.ASN1Encodable r3 = r2.s(r1)
            r24 = r2
            boolean r2 = r3 instanceof org.spongycastle.asn1.pkcs.SafeBag
            if (r2 == 0) goto L_0x0147
            org.spongycastle.asn1.pkcs.SafeBag r3 = (org.spongycastle.asn1.pkcs.SafeBag) r3
            goto L_0x0155
        L_0x0147:
            if (r3 == 0) goto L_0x0154
            org.spongycastle.asn1.pkcs.SafeBag r2 = new org.spongycastle.asn1.pkcs.SafeBag
            org.spongycastle.asn1.ASN1Sequence r3 = org.spongycastle.asn1.ASN1Sequence.q(r3)
            r2.<init>(r3)
            r3 = r2
            goto L_0x0155
        L_0x0154:
            r3 = 0
        L_0x0155:
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r3.Z0
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x021f
            org.spongycastle.asn1.ASN1Encodable r2 = r3.a
            org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo r2 = org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo.g(r2)
            r17 = r4
            org.spongycastle.asn1.x509.AlgorithmIdentifier r4 = r2.f5691a
            org.spongycastle.asn1.ASN1OctetString r2 = r2.a
            byte[] r2 = r2.s()
            java.security.PrivateKey r2 = r8.f(r4, r2, r9, r0)
            r4 = r2
            org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier r4 = (org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier) r4
            org.spongycastle.asn1.ASN1Set r3 = r3.f5709a
            if (r3 == 0) goto L_0x01f1
            java.util.Enumeration r3 = r3.t()
            r18 = 0
            r19 = 0
        L_0x0180:
            boolean r20 = r3.hasMoreElements()
            if (r20 == 0) goto L_0x01ee
            java.lang.Object r20 = r3.nextElement()
            r21 = r3
            r3 = r20
            org.spongycastle.asn1.ASN1Sequence r3 = (org.spongycastle.asn1.ASN1Sequence) r3
            r20 = r7
            r7 = 0
            org.spongycastle.asn1.ASN1Encodable r7 = r3.s(r7)
            org.spongycastle.asn1.ASN1ObjectIdentifier r7 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r7
            r9 = 1
            org.spongycastle.asn1.ASN1Encodable r3 = r3.s(r9)
            org.spongycastle.asn1.ASN1Set r3 = (org.spongycastle.asn1.ASN1Set) r3
            int r9 = r3.size()
            if (r9 <= 0) goto L_0x01c8
            r9 = 0
            org.spongycastle.asn1.ASN1Encodable r3 = r3.s(r9)
            org.spongycastle.asn1.ASN1Primitive r3 = (org.spongycastle.asn1.ASN1Primitive) r3
            org.spongycastle.asn1.ASN1Encodable r9 = r4.d(r7)
            if (r9 == 0) goto L_0x01c4
            org.spongycastle.asn1.ASN1Primitive r9 = r9.b()
            boolean r9 = r9.equals(r3)
            if (r9 == 0) goto L_0x01be
            goto L_0x01c9
        L_0x01be:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r14)
            throw r0
        L_0x01c4:
            r4.f(r7, r3)
            goto L_0x01c9
        L_0x01c8:
            r3 = 0
        L_0x01c9:
            boolean r9 = r7.equals(r6)
            if (r9 == 0) goto L_0x01dd
            org.spongycastle.asn1.DERBMPString r3 = (org.spongycastle.asn1.DERBMPString) r3
            java.lang.String r3 = r3.c()
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r7 = r8.f6529a
            r7.c(r2, r3)
            r18 = r3
            goto L_0x01e7
        L_0x01dd:
            boolean r7 = r7.equals(r15)
            if (r7 == 0) goto L_0x01e7
            org.spongycastle.asn1.ASN1OctetString r3 = (org.spongycastle.asn1.ASN1OctetString) r3
            r19 = r3
        L_0x01e7:
            r9 = r25
            r7 = r20
            r3 = r21
            goto L_0x0180
        L_0x01ee:
            r20 = r7
            goto L_0x01f7
        L_0x01f1:
            r20 = r7
            r18 = 0
            r19 = 0
        L_0x01f7:
            r3 = r18
            if (r19 == 0) goto L_0x0216
            java.lang.String r4 = new java.lang.String
            byte[] r7 = r19.s()
            byte[] r7 = org.spongycastle.util.encoders.Hex.c(r7)
            r4.<init>(r7)
            if (r3 != 0) goto L_0x0210
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r3 = r8.f6529a
            r3.c(r2, r4)
            goto L_0x024b
        L_0x0210:
            java.util.Hashtable r2 = r8.f6527a
            r2.put(r3, r4)
            goto L_0x024b
        L_0x0216:
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r3 = r8.f6529a
            r3.c(r2, r13)
            r2 = 1
            r16 = r2
            goto L_0x024b
        L_0x021f:
            r17 = r4
            r20 = r7
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r3.Z0
            boolean r4 = r2.equals(r5)
            if (r4 == 0) goto L_0x022f
            r11.addElement(r3)
            goto L_0x024b
        L_0x022f:
            java.io.PrintStream r4 = java.lang.System.out
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "extra in data "
            r7.<init>(r9)
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            r4.println(r2)
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.String r3 = org.spongycastle.asn1.util.ASN1Dump.b(r3)
            r2.println(r3)
        L_0x024b:
            int r1 = r1 + 1
            r2 = r24
            r9 = r25
            r4 = r17
            r7 = r20
            goto L_0x0134
        L_0x0257:
            r20 = r7
            r21 = r0
            r24 = r13
            r13 = r6
            goto L_0x04ba
        L_0x0260:
            r17 = r4
            r20 = r7
            r1 = r10[r12]
            org.spongycastle.asn1.ASN1ObjectIdentifier r1 = r1.Z0
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.L
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0483
            r1 = r10[r12]
            org.spongycastle.asn1.ASN1Encodable r1 = r1.a
            boolean r2 = r1 instanceof org.spongycastle.asn1.pkcs.EncryptedData
            if (r2 == 0) goto L_0x027b
            org.spongycastle.asn1.pkcs.EncryptedData r1 = (org.spongycastle.asn1.pkcs.EncryptedData) r1
            goto L_0x0289
        L_0x027b:
            if (r1 == 0) goto L_0x0288
            org.spongycastle.asn1.pkcs.EncryptedData r2 = new org.spongycastle.asn1.pkcs.EncryptedData
            org.spongycastle.asn1.ASN1Sequence r1 = org.spongycastle.asn1.ASN1Sequence.q(r1)
            r2.<init>(r1)
            r1 = r2
            goto L_0x0289
        L_0x0288:
            r1 = 0
        L_0x0289:
            r2 = 0
            org.spongycastle.asn1.ASN1Sequence r3 = r1.a
            r4 = 1
            org.spongycastle.asn1.ASN1Encodable r3 = r3.s(r4)
            org.spongycastle.asn1.x509.AlgorithmIdentifier r3 = org.spongycastle.asn1.x509.AlgorithmIdentifier.g(r3)
            org.spongycastle.asn1.ASN1Sequence r1 = r1.a
            int r4 = r1.size()
            r7 = 3
            if (r4 != r7) goto L_0x02ad
            r4 = 2
            org.spongycastle.asn1.ASN1Encodable r1 = r1.s(r4)
            org.spongycastle.asn1.ASN1TaggedObject r1 = org.spongycastle.asn1.ASN1TaggedObject.q(r1)
            r4 = 0
            org.spongycastle.asn1.ASN1OctetString r1 = org.spongycastle.asn1.ASN1OctetString.r(r1, r4)
            goto L_0x02ae
        L_0x02ad:
            r1 = 0
        L_0x02ae:
            byte[] r7 = r1.s()
            r1 = r23
            r9 = r17
            r4 = r25
            r22 = r5
            r5 = r0
            r24 = r13
            r13 = r6
            r6 = r7
            byte[] r1 = r1.d(r2, r3, r4, r5, r6)
            org.spongycastle.asn1.ASN1Primitive r1 = org.spongycastle.asn1.ASN1Primitive.k(r1)
            org.spongycastle.asn1.ASN1Sequence r1 = (org.spongycastle.asn1.ASN1Sequence) r1
            r2 = 0
        L_0x02ca:
            int r3 = r1.size()
            if (r2 == r3) goto L_0x0480
            org.spongycastle.asn1.ASN1Encodable r3 = r1.s(r2)
            boolean r4 = r3 instanceof org.spongycastle.asn1.pkcs.SafeBag
            if (r4 == 0) goto L_0x02db
            org.spongycastle.asn1.pkcs.SafeBag r3 = (org.spongycastle.asn1.pkcs.SafeBag) r3
            goto L_0x02e9
        L_0x02db:
            if (r3 == 0) goto L_0x02e8
            org.spongycastle.asn1.pkcs.SafeBag r4 = new org.spongycastle.asn1.pkcs.SafeBag
            org.spongycastle.asn1.ASN1Sequence r3 = org.spongycastle.asn1.ASN1Sequence.q(r3)
            r4.<init>(r3)
            r3 = r4
            goto L_0x02e9
        L_0x02e8:
            r3 = 0
        L_0x02e9:
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = r3.Z0
            r5 = r22
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x02fe
            r11.addElement(r3)
            r21 = r0
            r17 = r1
            r22 = r5
            goto L_0x0478
        L_0x02fe:
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = r3.Z0
            boolean r6 = r4.equals(r9)
            org.spongycastle.asn1.ASN1Set r7 = r3.f5709a
            r17 = r1
            org.spongycastle.asn1.ASN1Encodable r1 = r3.a
            if (r6 == 0) goto L_0x03b8
            org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo r1 = org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo.g(r1)
            org.spongycastle.asn1.x509.AlgorithmIdentifier r3 = r1.f5691a
            org.spongycastle.asn1.ASN1OctetString r1 = r1.a
            byte[] r1 = r1.s()
            r6 = r25
            java.security.PrivateKey r1 = r8.f(r3, r1, r6, r0)
            r3 = r1
            org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier r3 = (org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier) r3
            java.util.Enumeration r4 = r7.t()
            r7 = 0
            r18 = 0
        L_0x0328:
            boolean r19 = r4.hasMoreElements()
            if (r19 == 0) goto L_0x0397
            java.lang.Object r19 = r4.nextElement()
            r21 = r0
            r0 = r19
            org.spongycastle.asn1.ASN1Sequence r0 = (org.spongycastle.asn1.ASN1Sequence) r0
            r19 = r4
            r4 = 0
            org.spongycastle.asn1.ASN1Encodable r4 = r0.s(r4)
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r4
            r22 = r5
            r5 = 1
            org.spongycastle.asn1.ASN1Encodable r0 = r0.s(r5)
            org.spongycastle.asn1.ASN1Set r0 = (org.spongycastle.asn1.ASN1Set) r0
            int r5 = r0.size()
            if (r5 <= 0) goto L_0x0372
            r5 = 0
            org.spongycastle.asn1.ASN1Encodable r0 = r0.s(r5)
            org.spongycastle.asn1.ASN1Primitive r0 = (org.spongycastle.asn1.ASN1Primitive) r0
            org.spongycastle.asn1.ASN1Encodable r5 = r3.d(r4)
            if (r5 == 0) goto L_0x036e
            org.spongycastle.asn1.ASN1Primitive r5 = r5.b()
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x0368
            goto L_0x0373
        L_0x0368:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r14)
            throw r0
        L_0x036e:
            r3.f(r4, r0)
            goto L_0x0373
        L_0x0372:
            r0 = 0
        L_0x0373:
            boolean r5 = r4.equals(r13)
            if (r5 == 0) goto L_0x0386
            org.spongycastle.asn1.DERBMPString r0 = (org.spongycastle.asn1.DERBMPString) r0
            java.lang.String r0 = r0.c()
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r4 = r8.f6529a
            r4.c(r1, r0)
            r7 = r0
            goto L_0x0390
        L_0x0386:
            boolean r4 = r4.equals(r15)
            if (r4 == 0) goto L_0x0390
            org.spongycastle.asn1.ASN1OctetString r0 = (org.spongycastle.asn1.ASN1OctetString) r0
            r18 = r0
        L_0x0390:
            r4 = r19
            r0 = r21
            r5 = r22
            goto L_0x0328
        L_0x0397:
            r21 = r0
            r22 = r5
            java.lang.String r0 = new java.lang.String
            byte[] r3 = r18.s()
            byte[] r3 = org.spongycastle.util.encoders.Hex.c(r3)
            r0.<init>(r3)
            if (r7 != 0) goto L_0x03b1
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r3 = r8.f6529a
            r3.c(r1, r0)
            goto L_0x0478
        L_0x03b1:
            java.util.Hashtable r1 = r8.f6527a
            r1.put(r7, r0)
            goto L_0x0478
        L_0x03b8:
            r6 = r25
            r21 = r0
            r22 = r5
            org.spongycastle.asn1.ASN1ObjectIdentifier r0 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.S
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x045c
            org.spongycastle.asn1.pkcs.PrivateKeyInfo r0 = org.spongycastle.asn1.pkcs.PrivateKeyInfo.g(r1)
            java.security.PrivateKey r0 = org.spongycastle.jce.provider.BouncyCastleProvider.f(r0)
            r1 = r0
            org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier r1 = (org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier) r1
            java.util.Enumeration r3 = r7.t()
            r4 = 0
            r5 = 0
        L_0x03d7:
            boolean r7 = r3.hasMoreElements()
            if (r7 == 0) goto L_0x0441
            java.lang.Object r7 = r3.nextElement()
            org.spongycastle.asn1.ASN1Sequence r7 = org.spongycastle.asn1.ASN1Sequence.q(r7)
            r18 = r3
            r3 = 0
            org.spongycastle.asn1.ASN1Encodable r3 = r7.s(r3)
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = org.spongycastle.asn1.ASN1ObjectIdentifier.u(r3)
            r6 = 1
            org.spongycastle.asn1.ASN1Encodable r6 = r7.s(r6)
            org.spongycastle.asn1.ASN1Set r6 = org.spongycastle.asn1.ASN1Set.q(r6)
            int r7 = r6.size()
            if (r7 <= 0) goto L_0x043c
            r7 = 0
            org.spongycastle.asn1.ASN1Encodable r6 = r6.s(r7)
            org.spongycastle.asn1.ASN1Primitive r6 = (org.spongycastle.asn1.ASN1Primitive) r6
            org.spongycastle.asn1.ASN1Encodable r7 = r1.d(r3)
            if (r7 == 0) goto L_0x041d
            org.spongycastle.asn1.ASN1Primitive r7 = r7.b()
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x0417
            goto L_0x0420
        L_0x0417:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r14)
            throw r0
        L_0x041d:
            r1.f(r3, r6)
        L_0x0420:
            boolean r7 = r3.equals(r13)
            if (r7 == 0) goto L_0x0433
            org.spongycastle.asn1.DERBMPString r6 = (org.spongycastle.asn1.DERBMPString) r6
            java.lang.String r3 = r6.c()
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r5 = r8.f6529a
            r5.c(r0, r3)
            r5 = r3
            goto L_0x043c
        L_0x0433:
            boolean r3 = r3.equals(r15)
            if (r3 == 0) goto L_0x043c
            org.spongycastle.asn1.ASN1OctetString r6 = (org.spongycastle.asn1.ASN1OctetString) r6
            r4 = r6
        L_0x043c:
            r6 = r25
            r3 = r18
            goto L_0x03d7
        L_0x0441:
            java.lang.String r1 = new java.lang.String
            byte[] r3 = r4.s()
            byte[] r3 = org.spongycastle.util.encoders.Hex.c(r3)
            r1.<init>(r3)
            if (r5 != 0) goto L_0x0456
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r3 = r8.f6529a
            r3.c(r0, r1)
            goto L_0x0478
        L_0x0456:
            java.util.Hashtable r0 = r8.f6527a
            r0.put(r5, r1)
            goto L_0x0478
        L_0x045c:
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r5 = "extra in encryptedData "
            r1.<init>(r5)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.String r1 = org.spongycastle.asn1.util.ASN1Dump.b(r3)
            r0.println(r1)
        L_0x0478:
            int r2 = r2 + 1
            r1 = r17
            r0 = r21
            goto L_0x02ca
        L_0x0480:
            r21 = r0
            goto L_0x04ba
        L_0x0483:
            r21 = r0
            r24 = r13
            r13 = r6
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "extra "
            r1.<init>(r2)
            r3 = r10[r12]
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r3.Z0
            java.lang.String r3 = r3.c
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r2)
            r2 = r10[r12]
            org.spongycastle.asn1.ASN1Encodable r2 = r2.a
            java.lang.String r2 = org.spongycastle.asn1.util.ASN1Dump.b(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.println(r1)
        L_0x04ba:
            int r12 = r12 + 1
            r1 = 0
            r9 = r25
            r6 = r13
            r7 = r20
            r0 = r21
            r13 = r24
            goto L_0x010e
        L_0x04c8:
            r24 = r13
            r13 = r6
            goto L_0x04d1
        L_0x04cc:
            r24 = r13
            r13 = r6
            r16 = 0
        L_0x04d1:
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r0 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable
            r1 = 0
            r0.<init>(r1)
            r8.f6531b = r0
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            r8.b = r0
            java.util.Hashtable r0 = new java.util.Hashtable
            r0.<init>()
            r8.f6532c = r0
            r0 = 0
        L_0x04e8:
            int r1 = r11.size()
            if (r0 == r1) goto L_0x061f
            java.lang.Object r1 = r11.elementAt(r0)
            org.spongycastle.asn1.pkcs.SafeBag r1 = (org.spongycastle.asn1.pkcs.SafeBag) r1
            org.spongycastle.asn1.ASN1Encodable r2 = r1.a
            boolean r3 = r2 instanceof org.spongycastle.asn1.pkcs.CertBag
            if (r3 == 0) goto L_0x04fd
            org.spongycastle.asn1.pkcs.CertBag r2 = (org.spongycastle.asn1.pkcs.CertBag) r2
            goto L_0x050b
        L_0x04fd:
            if (r2 == 0) goto L_0x050a
            org.spongycastle.asn1.pkcs.CertBag r3 = new org.spongycastle.asn1.pkcs.CertBag
            org.spongycastle.asn1.ASN1Sequence r2 = org.spongycastle.asn1.ASN1Sequence.q(r2)
            r3.<init>(r2)
            r2 = r3
            goto L_0x050b
        L_0x050a:
            r2 = 0
        L_0x050b:
            org.spongycastle.asn1.ASN1ObjectIdentifier r3 = r2.Z0
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.R
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0609
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x05fe }
            org.spongycastle.asn1.ASN1Encodable r2 = r2.a     // Catch:{ Exception -> 0x05fe }
            org.spongycastle.asn1.ASN1OctetString r2 = (org.spongycastle.asn1.ASN1OctetString) r2     // Catch:{ Exception -> 0x05fe }
            byte[] r2 = r2.s()     // Catch:{ Exception -> 0x05fe }
            r3.<init>(r2)     // Catch:{ Exception -> 0x05fe }
            java.security.cert.CertificateFactory r2 = r8.f6526a     // Catch:{ Exception -> 0x05fe }
            java.security.cert.Certificate r2 = r2.generateCertificate(r3)     // Catch:{ Exception -> 0x05fe }
            org.spongycastle.asn1.ASN1Set r1 = r1.f5709a
            if (r1 == 0) goto L_0x0596
            java.util.Enumeration r1 = r1.t()
            r3 = 0
            r4 = 0
        L_0x0532:
            boolean r5 = r1.hasMoreElements()
            if (r5 == 0) goto L_0x0598
            java.lang.Object r5 = r1.nextElement()
            org.spongycastle.asn1.ASN1Sequence r5 = org.spongycastle.asn1.ASN1Sequence.q(r5)
            r6 = 0
            org.spongycastle.asn1.ASN1Encodable r7 = r5.s(r6)
            org.spongycastle.asn1.ASN1ObjectIdentifier r7 = org.spongycastle.asn1.ASN1ObjectIdentifier.u(r7)
            r9 = 1
            org.spongycastle.asn1.ASN1Encodable r5 = r5.s(r9)
            org.spongycastle.asn1.ASN1Set r5 = org.spongycastle.asn1.ASN1Set.q(r5)
            int r9 = r5.size()
            if (r9 <= 0) goto L_0x0532
            org.spongycastle.asn1.ASN1Encodable r5 = r5.s(r6)
            org.spongycastle.asn1.ASN1Primitive r5 = (org.spongycastle.asn1.ASN1Primitive) r5
            boolean r6 = r2 instanceof org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier
            if (r6 == 0) goto L_0x057f
            r6 = r2
            org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier r6 = (org.spongycastle.jce.interfaces.PKCS12BagAttributeCarrier) r6
            org.spongycastle.asn1.ASN1Encodable r9 = r6.d(r7)
            if (r9 == 0) goto L_0x057c
            org.spongycastle.asn1.ASN1Primitive r6 = r9.b()
            boolean r6 = r6.equals(r5)
            if (r6 == 0) goto L_0x0576
            goto L_0x057f
        L_0x0576:
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r14)
            throw r0
        L_0x057c:
            r6.f(r7, r5)
        L_0x057f:
            boolean r6 = r7.equals(r13)
            if (r6 == 0) goto L_0x058c
            org.spongycastle.asn1.DERBMPString r5 = (org.spongycastle.asn1.DERBMPString) r5
            java.lang.String r4 = r5.c()
            goto L_0x0532
        L_0x058c:
            boolean r6 = r7.equals(r15)
            if (r6 == 0) goto L_0x0532
            r3 = r5
            org.spongycastle.asn1.ASN1OctetString r3 = (org.spongycastle.asn1.ASN1OctetString) r3
            goto L_0x0532
        L_0x0596:
            r3 = 0
            r4 = 0
        L_0x0598:
            java.util.Hashtable r1 = r8.b
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId r5 = new org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$CertId
            java.security.PublicKey r6 = r2.getPublicKey()
            r5.<init>(r8, r6)
            r1.put(r5, r2)
            if (r16 == 0) goto L_0x05db
            java.util.Hashtable r1 = r8.f6532c
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x05d8
            java.lang.String r1 = new java.lang.String
            java.security.PublicKey r3 = r2.getPublicKey()
            org.spongycastle.asn1.x509.SubjectKeyIdentifier r3 = c(r3)
            byte[] r3 = r3.a
            byte[] r3 = org.spongycastle.util.Arrays.c(r3)
            byte[] r3 = org.spongycastle.util.encoders.Hex.c(r3)
            r1.<init>(r3)
            java.util.Hashtable r3 = r8.f6532c
            r3.put(r1, r2)
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r2 = r8.f6529a
            r5 = r24
            java.lang.Object r3 = r2.d(r5)
            r2.c(r3, r1)
            goto L_0x05f8
        L_0x05d8:
            r5 = r24
            goto L_0x05f8
        L_0x05db:
            r5 = r24
            if (r3 == 0) goto L_0x05f1
            java.lang.String r1 = new java.lang.String
            byte[] r3 = r3.s()
            byte[] r3 = org.spongycastle.util.encoders.Hex.c(r3)
            r1.<init>(r3)
            java.util.Hashtable r3 = r8.f6532c
            r3.put(r1, r2)
        L_0x05f1:
            if (r4 == 0) goto L_0x05f8
            org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi$IgnoresCaseHashtable r1 = r8.f6531b
            r1.c(r2, r4)
        L_0x05f8:
            int r0 = r0 + 1
            r24 = r5
            goto L_0x04e8
        L_0x05fe:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L_0x0609:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Unsupported certificate type: "
            r1.<init>(r3)
            org.spongycastle.asn1.ASN1ObjectIdentifier r2 = r2.Z0
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x061f:
            return
        L_0x0620:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "stream does not represent a PKCS12 key store"
            r0.<init>(r1)
            throw r0
        L_0x0628:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "No password supplied for PKCS#12 KeyStore."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.pkcs12.PKCS12KeyStoreSpi.engineLoad(java.io.InputStream, char[]):void");
    }

    public final void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        if (this.f6529a.a(str) == null) {
            this.f6531b.c(certificate, str);
            this.b.put(new CertId(this, certificate.getPublicKey()), certificate);
            return;
        }
        throw new KeyStoreException(lf.j("There is a key entry with the name ", str, "."));
    }

    public final void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        throw new RuntimeException("operation not supported");
    }

    public final int engineSize() {
        Hashtable hashtable = new Hashtable();
        Enumeration b2 = this.f6531b.b();
        while (b2.hasMoreElements()) {
            hashtable.put(b2.nextElement(), "cert");
        }
        Enumeration b3 = this.f6529a.b();
        while (b3.hasMoreElements()) {
            String str = (String) b3.nextElement();
            if (hashtable.get(str) == null) {
                hashtable.put(str, "key");
            }
        }
        return hashtable.size();
    }

    public final void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws IOException, NoSuchAlgorithmException, CertificateException {
        PKCS12StoreParameter pKCS12StoreParameter;
        char[] cArr;
        if (loadStoreParameter != null) {
            boolean z = loadStoreParameter instanceof PKCS12StoreParameter;
            if (z || (loadStoreParameter instanceof JDKPKCS12StoreParameter)) {
                if (z) {
                    pKCS12StoreParameter = (PKCS12StoreParameter) loadStoreParameter;
                } else {
                    JDKPKCS12StoreParameter jDKPKCS12StoreParameter = (JDKPKCS12StoreParameter) loadStoreParameter;
                    pKCS12StoreParameter = new PKCS12StoreParameter(loadStoreParameter.getProtectionParameter());
                }
                KeyStore.ProtectionParameter protectionParameter = loadStoreParameter.getProtectionParameter();
                if (protectionParameter == null) {
                    cArr = null;
                } else if (protectionParameter instanceof KeyStore.PasswordProtection) {
                    cArr = ((KeyStore.PasswordProtection) protectionParameter).getPassword();
                } else {
                    throw new IllegalArgumentException("No support for protection parameter of type ".concat(protectionParameter.getClass().getName()));
                }
                e(pKCS12StoreParameter.a, cArr, pKCS12StoreParameter.f6312a);
                return;
            }
            throw new IllegalArgumentException("No support for 'param' of type ".concat(loadStoreParameter.getClass().getName()));
        }
        throw new IllegalArgumentException("'param' arg cannot be null");
    }

    public final PrivateKey f(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, char[] cArr, boolean z) throws IOException {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = algorithmIdentifier.Z0;
        try {
            if (aSN1ObjectIdentifier.x(PKCSObjectIdentifiers.V)) {
                PKCS12PBEParams g = PKCS12PBEParams.g(algorithmIdentifier.a);
                PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(g.f5699a.s(), g(g.a.t()));
                Cipher instance = Cipher.getInstance(aSN1ObjectIdentifier.c, this.f6530a.a);
                instance.init(4, new PKCS12Key(cArr, z), pBEParameterSpec);
                return (PrivateKey) instance.unwrap(bArr, "", 2);
            } else if (aSN1ObjectIdentifier.equals(PKCSObjectIdentifiers.w)) {
                return (PrivateKey) b(4, cArr, algorithmIdentifier).unwrap(bArr, "", 2);
            } else {
                throw new IOException("exception unwrapping private key - cannot recognise: " + aSN1ObjectIdentifier);
            }
        } catch (Exception e) {
            throw new IOException(C1058d.x(e, new StringBuilder("exception unwrapping private key - ")));
        }
    }

    public final void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        boolean z = key instanceof PrivateKey;
        if (!z) {
            throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
        } else if (!z || certificateArr != null) {
            if (this.f6529a.a(str) != null) {
                engineDeleteEntry(str);
            }
            this.f6529a.c(key, str);
            if (certificateArr != null) {
                this.f6531b.c(certificateArr[0], str);
                for (int i = 0; i != certificateArr.length; i++) {
                    this.b.put(new CertId(this, certificateArr[i].getPublicKey()), certificateArr[i]);
                }
            }
        } else {
            throw new KeyStoreException("no certificate chain for private key");
        }
    }

    public static class IgnoresCaseHashtable {
        public final Hashtable a;
        public final Hashtable b;

        private IgnoresCaseHashtable() {
            this.a = new Hashtable();
            this.b = new Hashtable();
        }

        public final Object a(String str) {
            String str2;
            Hashtable hashtable = this.b;
            if (str == null) {
                str2 = null;
            } else {
                str2 = Strings.e(str);
            }
            String str3 = (String) hashtable.get(str2);
            if (str3 == null) {
                return null;
            }
            return this.a.get(str3);
        }

        public final Enumeration b() {
            return this.a.keys();
        }

        public final void c(Object obj, String str) {
            String str2;
            if (str == null) {
                str2 = null;
            } else {
                str2 = Strings.e(str);
            }
            Hashtable hashtable = this.b;
            String str3 = (String) hashtable.get(str2);
            Hashtable hashtable2 = this.a;
            if (str3 != null) {
                hashtable2.remove(str3);
            }
            hashtable.put(str2, str);
            hashtable2.put(str, obj);
        }

        public final Object d(String str) {
            String str2;
            Hashtable hashtable = this.b;
            if (str == null) {
                str2 = null;
            } else {
                str2 = Strings.e(str);
            }
            String str3 = (String) hashtable.remove(str2);
            if (str3 == null) {
                return null;
            }
            return this.a.remove(str3);
        }

        public /* synthetic */ IgnoresCaseHashtable(int i) {
            this();
        }
    }

    public class CertId {
        public final byte[] a;

        public CertId(PKCS12KeyStoreSpi pKCS12KeyStoreSpi, PublicKey publicKey) {
            DefaultSecretKeyProvider defaultSecretKeyProvider = PKCS12KeyStoreSpi.a;
            pKCS12KeyStoreSpi.getClass();
            this.a = Arrays.c(PKCS12KeyStoreSpi.c(publicKey).a);
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CertId)) {
                return false;
            }
            return Arrays.a(this.a, ((CertId) obj).a);
        }

        public final int hashCode() {
            return Arrays.t(this.a);
        }

        public CertId(byte[] bArr) {
            this.a = bArr;
        }
    }

    public final void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
        e(outputStream, cArr, false);
    }
}
