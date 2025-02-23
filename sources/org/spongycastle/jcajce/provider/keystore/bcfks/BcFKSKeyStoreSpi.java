package org.spongycastle.jcajce.provider.keystore.bcfks;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.bc.EncryptedObjectStoreData;
import org.spongycastle.asn1.bc.EncryptedPrivateKeyData;
import org.spongycastle.asn1.bc.EncryptedSecretKeyData;
import org.spongycastle.asn1.bc.ObjectData;
import org.spongycastle.asn1.bc.ObjectDataSequence;
import org.spongycastle.asn1.bc.ObjectStore;
import org.spongycastle.asn1.bc.ObjectStoreData;
import org.spongycastle.asn1.bc.ObjectStoreIntegrityCheck;
import org.spongycastle.asn1.bc.PbkdMacIntegrityCheck;
import org.spongycastle.asn1.bc.SecretKeyData;
import org.spongycastle.asn1.cms.CCMParameters;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.oiw.OIWObjectIdentifiers;
import org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.spongycastle.asn1.pkcs.EncryptionScheme;
import org.spongycastle.asn1.pkcs.KeyDerivationFunc;
import org.spongycastle.asn1.pkcs.PBES2Parameters;
import org.spongycastle.asn1.pkcs.PBKDF2Params;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.spongycastle.util.Arrays;

class BcFKSKeyStoreSpi extends KeyStoreSpi {
    public static final BigInteger a = BigInteger.valueOf(0);
    public static final BigInteger b = BigInteger.valueOf(1);
    public static final BigInteger c = BigInteger.valueOf(2);

    /* renamed from: c  reason: collision with other field name */
    public static final HashMap f6516c;
    public static final BigInteger d = BigInteger.valueOf(3);

    /* renamed from: d  reason: collision with other field name */
    public static final HashMap f6517d;
    public static final BigInteger e = BigInteger.valueOf(4);

    /* renamed from: a  reason: collision with other field name */
    public Date f6518a;

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f6519a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public KeyDerivationFunc f6520a;

    /* renamed from: a  reason: collision with other field name */
    public AlgorithmIdentifier f6521a;

    /* renamed from: a  reason: collision with other field name */
    public final BouncyCastleProvider f6522a;

    /* renamed from: b  reason: collision with other field name */
    public Date f6523b;

    /* renamed from: b  reason: collision with other field name */
    public final HashMap f6524b = new HashMap();

    public static class Def extends BcFKSKeyStoreSpi {
        public Def() {
            super((BouncyCastleProvider) null);
        }
    }

    public static class ExtKeyStoreException extends KeyStoreException {
        public final Throwable a;

        public ExtKeyStoreException(String str, Exception exc) {
            super(str);
            this.a = exc;
        }

        public final Throwable getCause() {
            return this.a;
        }
    }

    public static class Std extends BcFKSKeyStoreSpi {
        public Std() {
            super(new BouncyCastleProvider());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f6516c = hashMap;
        HashMap hashMap2 = new HashMap();
        f6517d = hashMap2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.e;
        hashMap.put("DESEDE", aSN1ObjectIdentifier);
        hashMap.put("TRIPLEDES", aSN1ObjectIdentifier);
        hashMap.put("TDEA", aSN1ObjectIdentifier);
        hashMap.put("HMACSHA1", PKCSObjectIdentifiers.E);
        hashMap.put("HMACSHA224", PKCSObjectIdentifiers.F);
        hashMap.put("HMACSHA256", PKCSObjectIdentifiers.G);
        hashMap.put("HMACSHA384", PKCSObjectIdentifiers.H);
        hashMap.put("HMACSHA512", PKCSObjectIdentifiers.I);
        hashMap2.put(PKCSObjectIdentifiers.a, "RSA");
        hashMap2.put(X9ObjectIdentifiers.q0, "EC");
        hashMap2.put(OIWObjectIdentifiers.i, "DH");
        hashMap2.put(PKCSObjectIdentifiers.p, "DH");
        hashMap2.put(X9ObjectIdentifiers.T0, "DSA");
    }

    public BcFKSKeyStoreSpi(BouncyCastleProvider bouncyCastleProvider) {
        this.f6522a = bouncyCastleProvider;
    }

    public static byte[] d(KeyDerivationFunc keyDerivationFunc, String str, char[] cArr) throws IOException {
        BigInteger bigInteger;
        byte[] a2 = PBEParametersGenerator.a(cArr);
        byte[] a3 = PBEParametersGenerator.a(str.toCharArray());
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA512Digest());
        if (keyDerivationFunc.a.Z0.equals(PKCSObjectIdentifiers.x)) {
            PBKDF2Params g = PBKDF2Params.g(keyDerivationFunc.a.a);
            AlgorithmIdentifier algorithmIdentifier = g.f5697a;
            if (algorithmIdentifier == null) {
                algorithmIdentifier = PBKDF2Params.b;
            }
            if (algorithmIdentifier.Z0.equals(PKCSObjectIdentifiers.I)) {
                pKCS5S2ParametersGenerator.f(Arrays.i(a2, a3), g.a.t().intValue(), g.f5696a.s());
                ASN1Integer aSN1Integer = g.f5698b;
                if (aSN1Integer != null) {
                    bigInteger = aSN1Integer.t();
                } else {
                    bigInteger = null;
                }
                return pKCS5S2ParametersGenerator.d(bigInteger.intValue() * 8).a;
            }
            throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD PRF.");
        }
        throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD.");
    }

    public static KeyDerivationFunc e(int i) {
        byte[] bArr = new byte[64];
        new SecureRandom().nextBytes(bArr);
        return new KeyDerivationFunc(PKCSObjectIdentifiers.x, new PBKDF2Params(bArr, UserMetadata.MAX_ATTRIBUTE_SIZE, i, new AlgorithmIdentifier(PKCSObjectIdentifiers.I, DERNull.a)));
    }

    public final byte[] a(byte[] bArr, AlgorithmIdentifier algorithmIdentifier, KeyDerivationFunc keyDerivationFunc, char[] cArr) throws NoSuchAlgorithmException, IOException {
        Mac mac;
        String str = algorithmIdentifier.Z0.c;
        BouncyCastleProvider bouncyCastleProvider = this.f6522a;
        if (bouncyCastleProvider != null) {
            mac = Mac.getInstance(str, bouncyCastleProvider);
        } else {
            mac = Mac.getInstance(str);
        }
        try {
            if (cArr == null) {
                cArr = new char[0];
            }
            mac.init(new SecretKeySpec(d(keyDerivationFunc, "INTEGRITY_CHECK", cArr), str));
            return mac.doFinal(bArr);
        } catch (InvalidKeyException e2) {
            throw new IOException("Cannot set up MAC calculation: " + e2.getMessage());
        }
    }

    public final Certificate b(Object obj) {
        BouncyCastleProvider bouncyCastleProvider = this.f6522a;
        if (bouncyCastleProvider != null) {
            try {
                return CertificateFactory.getInstance("X.509", bouncyCastleProvider).generateCertificate(new ByteArrayInputStream(org.spongycastle.asn1.x509.Certificate.g(obj).e()));
            } catch (Exception unused) {
                return null;
            }
        } else {
            try {
                return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(org.spongycastle.asn1.x509.Certificate.g(obj).e()));
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    public final byte[] c(String str, AlgorithmIdentifier algorithmIdentifier, char[] cArr, byte[] bArr) throws IOException {
        PBES2Parameters pBES2Parameters;
        Cipher cipher;
        AlgorithmParameters algorithmParameters;
        if (algorithmIdentifier.Z0.equals(PKCSObjectIdentifiers.w)) {
            ASN1Encodable aSN1Encodable = algorithmIdentifier.a;
            if (aSN1Encodable instanceof PBES2Parameters) {
                pBES2Parameters = (PBES2Parameters) aSN1Encodable;
            } else if (aSN1Encodable != null) {
                pBES2Parameters = new PBES2Parameters(ASN1Sequence.q(aSN1Encodable));
            } else {
                pBES2Parameters = null;
            }
            EncryptionScheme encryptionScheme = pBES2Parameters.a;
            if (encryptionScheme.a.Z0.equals(NISTObjectIdentifiers.N)) {
                try {
                    CCMParameters g = CCMParameters.g(encryptionScheme.a.a);
                    BouncyCastleProvider bouncyCastleProvider = this.f6522a;
                    if (bouncyCastleProvider == null) {
                        cipher = Cipher.getInstance("AES/CCM/NoPadding");
                        algorithmParameters = AlgorithmParameters.getInstance("CCM");
                    } else {
                        cipher = Cipher.getInstance("AES/CCM/NoPadding", bouncyCastleProvider);
                        algorithmParameters = AlgorithmParameters.getInstance("CCM", bouncyCastleProvider);
                    }
                    algorithmParameters.init(g.e());
                    KeyDerivationFunc keyDerivationFunc = pBES2Parameters.f5695a;
                    if (cArr == null) {
                        cArr = new char[0];
                    }
                    cipher.init(2, new SecretKeySpec(d(keyDerivationFunc, str, cArr), "AES"), algorithmParameters);
                    return cipher.doFinal(bArr);
                } catch (Exception e2) {
                    throw new IOException(e2.toString());
                }
            } else {
                throw new IOException("BCFKS KeyStore cannot recognize protection encryption algorithm.");
            }
        } else {
            throw new IOException("BCFKS KeyStore cannot recognize protection algorithm.");
        }
    }

    public final Enumeration<String> engineAliases() {
        final Iterator it = new HashSet(this.f6519a.keySet()).iterator();
        return new Enumeration() {
            public final boolean hasMoreElements() {
                return it.hasNext();
            }

            public final Object nextElement() {
                return it.next();
            }
        };
    }

    public final boolean engineContainsAlias(String str) {
        if (str != null) {
            return this.f6519a.containsKey(str);
        }
        throw new NullPointerException("alias value is null");
    }

    public final void engineDeleteEntry(String str) throws KeyStoreException {
        HashMap hashMap = this.f6519a;
        if (((ObjectData) hashMap.get(str)) != null) {
            this.f6524b.remove(str);
            hashMap.remove(str);
            this.f6523b = new Date();
        }
    }

    public final Certificate engineGetCertificate(String str) {
        ObjectData objectData = (ObjectData) this.f6519a.get(str);
        if (objectData == null) {
            return null;
        }
        BigInteger bigInteger = objectData.a;
        if (bigInteger.equals(b) || bigInteger.equals(d)) {
            org.spongycastle.asn1.x509.Certificate[] certificateArr = EncryptedPrivateKeyData.g(objectData.g()).f5676a;
            org.spongycastle.asn1.x509.Certificate[] certificateArr2 = new org.spongycastle.asn1.x509.Certificate[certificateArr.length];
            System.arraycopy(certificateArr, 0, certificateArr2, 0, certificateArr.length);
            return b(certificateArr2[0]);
        } else if (bigInteger.equals(a)) {
            return b(objectData.g());
        } else {
            return null;
        }
    }

    public final String engineGetCertificateAlias(Certificate certificate) {
        if (certificate == null) {
            return null;
        }
        try {
            byte[] encoded = certificate.getEncoded();
            HashMap hashMap = this.f6519a;
            for (String str : hashMap.keySet()) {
                ObjectData objectData = (ObjectData) hashMap.get(str);
                if (!objectData.a.equals(a)) {
                    BigInteger bigInteger = objectData.a;
                    if (bigInteger.equals(b) || bigInteger.equals(d)) {
                        try {
                            org.spongycastle.asn1.x509.Certificate[] certificateArr = EncryptedPrivateKeyData.g(objectData.g()).f5676a;
                            org.spongycastle.asn1.x509.Certificate[] certificateArr2 = new org.spongycastle.asn1.x509.Certificate[certificateArr.length];
                            System.arraycopy(certificateArr, 0, certificateArr2, 0, certificateArr.length);
                            if (Arrays.a(certificateArr2[0].a.e(), encoded)) {
                                return str;
                            }
                        } catch (IOException unused) {
                            continue;
                        }
                    }
                } else if (Arrays.a(objectData.g(), encoded)) {
                    return str;
                }
            }
        } catch (CertificateEncodingException unused2) {
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.security.cert.X509Certificate[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.cert.Certificate[] engineGetCertificateChain(java.lang.String r5) {
        /*
            r4 = this;
            java.util.HashMap r0 = r4.f6519a
            java.lang.Object r5 = r0.get(r5)
            org.spongycastle.asn1.bc.ObjectData r5 = (org.spongycastle.asn1.bc.ObjectData) r5
            if (r5 == 0) goto L_0x003e
            java.math.BigInteger r0 = r5.a
            java.math.BigInteger r1 = b
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x001c
            java.math.BigInteger r1 = d
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003e
        L_0x001c:
            byte[] r5 = r5.g()
            org.spongycastle.asn1.bc.EncryptedPrivateKeyData r5 = org.spongycastle.asn1.bc.EncryptedPrivateKeyData.g(r5)
            org.spongycastle.asn1.x509.Certificate[] r5 = r5.f5676a
            int r0 = r5.length
            org.spongycastle.asn1.x509.Certificate[] r1 = new org.spongycastle.asn1.x509.Certificate[r0]
            int r2 = r5.length
            r3 = 0
            java.lang.System.arraycopy(r5, r3, r1, r3, r2)
            java.security.cert.X509Certificate[] r5 = new java.security.cert.X509Certificate[r0]
        L_0x0030:
            if (r3 == r0) goto L_0x003d
            r2 = r1[r3]
            java.security.cert.Certificate r2 = r4.b(r2)
            r5[r3] = r2
            int r3 = r3 + 1
            goto L_0x0030
        L_0x003d:
            return r5
        L_0x003e:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.engineGetCertificateChain(java.lang.String):java.security.cert.Certificate[]");
    }

    public final Date engineGetCreationDate(String str) {
        ObjectData objectData = (ObjectData) this.f6519a.get(str);
        if (objectData == null) {
            return null;
        }
        try {
            return objectData.b.q();
        } catch (ParseException unused) {
            return new Date();
        }
    }

    public final Key engineGetKey(String str, char[] cArr) throws NoSuchAlgorithmException, UnrecoverableKeyException {
        KeyFactory keyFactory;
        EncryptedSecretKeyData encryptedSecretKeyData;
        SecretKeyFactory secretKeyFactory;
        ObjectData objectData = (ObjectData) this.f6519a.get(str);
        SecretKeyData secretKeyData = null;
        if (objectData == null) {
            return null;
        }
        BigInteger bigInteger = objectData.a;
        boolean equals = bigInteger.equals(b);
        BouncyCastleProvider bouncyCastleProvider = this.f6522a;
        if (equals || bigInteger.equals(d)) {
            HashMap hashMap = this.f6524b;
            PrivateKey privateKey = (PrivateKey) hashMap.get(str);
            if (privateKey != null) {
                return privateKey;
            }
            EncryptedPrivateKeyInfo g = EncryptedPrivateKeyInfo.g(EncryptedPrivateKeyData.g(objectData.g()).a);
            try {
                PrivateKeyInfo g2 = PrivateKeyInfo.g(c("PRIVATE_KEY_ENCRYPTION", g.f5691a, cArr, g.a.s()));
                if (bouncyCastleProvider != null) {
                    keyFactory = KeyFactory.getInstance(g2.f5702a.Z0.c, bouncyCastleProvider);
                } else {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier = g2.f5702a.Z0;
                    String str2 = (String) f6517d.get(aSN1ObjectIdentifier);
                    if (str2 == null) {
                        str2 = aSN1ObjectIdentifier.c;
                    }
                    keyFactory = KeyFactory.getInstance(str2);
                }
                PrivateKey generatePrivate = keyFactory.generatePrivate(new PKCS8EncodedKeySpec(g2.e()));
                hashMap.put(str, generatePrivate);
                return generatePrivate;
            } catch (Exception e2) {
                throw new UnrecoverableKeyException(C1058d.M(e2, xx.K("BCFKS KeyStore unable to recover private key (", str, "): ")));
            }
        } else if (bigInteger.equals(c) || bigInteger.equals(e)) {
            byte[] g3 = objectData.g();
            if (g3 instanceof EncryptedSecretKeyData) {
                encryptedSecretKeyData = (EncryptedSecretKeyData) g3;
            } else if (g3 != null) {
                encryptedSecretKeyData = new EncryptedSecretKeyData(ASN1Sequence.q(g3));
            } else {
                encryptedSecretKeyData = null;
            }
            try {
                byte[] c2 = c("SECRET_KEY_ENCRYPTION", encryptedSecretKeyData.f5677a, cArr, Arrays.c(encryptedSecretKeyData.a.s()));
                if (c2 instanceof SecretKeyData) {
                    secretKeyData = (SecretKeyData) c2;
                } else if (c2 != null) {
                    secretKeyData = new SecretKeyData(ASN1Sequence.q(c2));
                }
                if (bouncyCastleProvider != null) {
                    secretKeyFactory = SecretKeyFactory.getInstance(secretKeyData.Z0.c, bouncyCastleProvider);
                } else {
                    secretKeyFactory = SecretKeyFactory.getInstance(secretKeyData.Z0.c);
                }
                return secretKeyFactory.generateSecret(new SecretKeySpec(Arrays.c(secretKeyData.a.s()), secretKeyData.Z0.c));
            } catch (Exception e3) {
                throw new UnrecoverableKeyException(C1058d.M(e3, xx.K("BCFKS KeyStore unable to recover secret key (", str, "): ")));
            }
        } else {
            throw new UnrecoverableKeyException(lf.j("BCFKS KeyStore unable to recover secret key (", str, "): type not recognized"));
        }
    }

    public final boolean engineIsCertificateEntry(String str) {
        ObjectData objectData = (ObjectData) this.f6519a.get(str);
        if (objectData == null) {
            return false;
        }
        return objectData.a.equals(a);
    }

    public final boolean engineIsKeyEntry(String str) {
        ObjectData objectData = (ObjectData) this.f6519a.get(str);
        if (objectData != null) {
            BigInteger bigInteger = objectData.a;
            if (bigInteger.equals(b) || bigInteger.equals(c) || bigInteger.equals(d) || bigInteger.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public final void engineLoad(InputStream inputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
        ObjectStore objectStore;
        ObjectStoreData objectStoreData;
        ObjectData objectData;
        HashMap hashMap = this.f6519a;
        hashMap.clear();
        this.f6524b.clear();
        this.f6518a = null;
        this.f6523b = null;
        this.f6521a = null;
        if (inputStream == null) {
            Date date = new Date();
            this.f6518a = date;
            this.f6523b = date;
            this.f6521a = new AlgorithmIdentifier(PKCSObjectIdentifiers.I, DERNull.a);
            this.f6520a = e(64);
            return;
        }
        ASN1Primitive j = new ASN1InputStream(inputStream).j();
        if (j instanceof ObjectStore) {
            objectStore = (ObjectStore) j;
        } else if (j != null) {
            objectStore = new ObjectStore(ASN1Sequence.q(j));
        } else {
            objectStore = null;
        }
        ObjectStoreIntegrityCheck objectStoreIntegrityCheck = objectStore.f5680a;
        objectStoreIntegrityCheck.getClass();
        PbkdMacIntegrityCheck pbkdMacIntegrityCheck = objectStoreIntegrityCheck.a;
        if (!(pbkdMacIntegrityCheck instanceof PbkdMacIntegrityCheck)) {
            if (pbkdMacIntegrityCheck != null) {
                pbkdMacIntegrityCheck = new PbkdMacIntegrityCheck(ASN1Sequence.q(pbkdMacIntegrityCheck));
            } else {
                pbkdMacIntegrityCheck = null;
            }
        }
        this.f6521a = pbkdMacIntegrityCheck.f5685a;
        KeyDerivationFunc keyDerivationFunc = pbkdMacIntegrityCheck.f5684a;
        this.f6520a = keyDerivationFunc;
        ASN1Encodable aSN1Encodable = objectStore.a;
        if (Arrays.l(a(aSN1Encodable.b().e(), pbkdMacIntegrityCheck.f5685a, keyDerivationFunc, cArr), Arrays.c(pbkdMacIntegrityCheck.a.s()))) {
            if (aSN1Encodable instanceof EncryptedObjectStoreData) {
                EncryptedObjectStoreData encryptedObjectStoreData = (EncryptedObjectStoreData) aSN1Encodable;
                objectStoreData = ObjectStoreData.g(c("STORE_ENCRYPTION", encryptedObjectStoreData.f5675a, cArr, encryptedObjectStoreData.a.s()));
            } else {
                objectStoreData = ObjectStoreData.g(aSN1Encodable);
            }
            try {
                this.f6518a = objectStoreData.f5681a.q();
                this.f6523b = objectStoreData.b.q();
                if (objectStoreData.f5683a.equals(this.f6521a)) {
                    Iterator<ASN1Encodable> it = objectStoreData.f5682a.iterator();
                    while (it.hasNext()) {
                        ASN1Encodable next = it.next();
                        if (next instanceof ObjectData) {
                            objectData = (ObjectData) next;
                        } else if (next != null) {
                            objectData = new ObjectData(ASN1Sequence.q(next));
                        } else {
                            objectData = null;
                        }
                        hashMap.put(objectData.c, objectData);
                    }
                    return;
                }
                throw new IOException("BCFKS KeyStore storeData integrity algorithm does not match store integrity algorithm.");
            } catch (ParseException unused) {
                throw new IOException("BCFKS KeyStore unable to parse store data information.");
            }
        } else {
            throw new IOException("BCFKS KeyStore corrupted: MAC calculation failed.");
        }
    }

    public final void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        Date date;
        Date date2;
        HashMap hashMap = this.f6519a;
        ObjectData objectData = (ObjectData) hashMap.get(str);
        Date date3 = new Date();
        if (objectData != null) {
            if (objectData.a.equals(a)) {
                try {
                    date2 = objectData.f5678a.q();
                } catch (ParseException unused) {
                    date2 = date3;
                }
                date = date2;
            } else {
                throw new KeyStoreException(C0709Uj.i("BCFKS KeyStore already has a key entry with alias ", str));
            }
        } else {
            date = date3;
        }
        try {
            hashMap.put(str, new ObjectData(a, str, date, date3, certificate.getEncoded()));
            this.f6523b = date3;
        } catch (CertificateEncodingException e2) {
            throw new ExtKeyStoreException("BCFKS KeyStore unable to handle certificate: " + e2.getMessage(), e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void engineSetKeyEntry(java.lang.String r17, java.security.Key r18, char[] r19, java.security.cert.Certificate[] r20) throws java.security.KeyStoreException {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            r3 = r20
            java.lang.String r4 = "BCFKS KeyStore cannot recognize secret key ("
            java.util.Date r8 = new java.util.Date
            r8.<init>()
            java.util.HashMap r9 = r1.f6519a
            java.lang.Object r5 = r9.get(r0)
            org.spongycastle.asn1.bc.ObjectData r5 = (org.spongycastle.asn1.bc.ObjectData) r5
            if (r5 == 0) goto L_0x0020
            org.spongycastle.asn1.ASN1GeneralizedTime r5 = r5.f5678a     // Catch:{ ParseException -> 0x0020 }
            java.util.Date r5 = r5.q()     // Catch:{ ParseException -> 0x0020 }
            goto L_0x0021
        L_0x0020:
            r5 = r8
        L_0x0021:
            java.util.HashMap r6 = r1.f6524b
            r6.remove(r0)
            boolean r6 = r2 instanceof java.security.PrivateKey
            r7 = 0
            r10 = 1
            org.spongycastle.jce.provider.BouncyCastleProvider r11 = r1.f6522a
            java.lang.String r12 = "BCFKS KeyStore exception storing private key: "
            r13 = 32
            java.lang.String r14 = "AES"
            java.lang.String r15 = "AES/CCM/NoPadding"
            if (r6 == 0) goto L_0x00cf
            if (r3 == 0) goto L_0x00c7
            byte[] r2 = r18.getEncoded()     // Catch:{ Exception -> 0x00b7 }
            org.spongycastle.asn1.pkcs.KeyDerivationFunc r4 = e(r13)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r6 = "PRIVATE_KEY_ENCRYPTION"
            if (r19 == 0) goto L_0x0047
            r13 = r19
            goto L_0x0049
        L_0x0047:
            char[] r13 = new char[r7]     // Catch:{ Exception -> 0x00b7 }
        L_0x0049:
            byte[] r6 = d(r4, r6, r13)     // Catch:{ Exception -> 0x00b7 }
            if (r11 != 0) goto L_0x0054
            javax.crypto.Cipher r11 = javax.crypto.Cipher.getInstance(r15)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x0058
        L_0x0054:
            javax.crypto.Cipher r11 = javax.crypto.Cipher.getInstance(r15, r11)     // Catch:{ Exception -> 0x00b7 }
        L_0x0058:
            javax.crypto.spec.SecretKeySpec r13 = new javax.crypto.spec.SecretKeySpec     // Catch:{ Exception -> 0x00b7 }
            r13.<init>(r6, r14)     // Catch:{ Exception -> 0x00b7 }
            r11.init(r10, r13)     // Catch:{ Exception -> 0x00b7 }
            byte[] r2 = r11.doFinal(r2)     // Catch:{ Exception -> 0x00b7 }
            java.security.AlgorithmParameters r6 = r11.getParameters()     // Catch:{ Exception -> 0x00b7 }
            org.spongycastle.asn1.pkcs.PBES2Parameters r10 = new org.spongycastle.asn1.pkcs.PBES2Parameters     // Catch:{ Exception -> 0x00b7 }
            org.spongycastle.asn1.pkcs.EncryptionScheme r11 = new org.spongycastle.asn1.pkcs.EncryptionScheme     // Catch:{ Exception -> 0x00b7 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r13 = org.spongycastle.asn1.nist.NISTObjectIdentifiers.N     // Catch:{ Exception -> 0x00b7 }
            byte[] r6 = r6.getEncoded()     // Catch:{ Exception -> 0x00b7 }
            org.spongycastle.asn1.cms.CCMParameters r6 = org.spongycastle.asn1.cms.CCMParameters.g(r6)     // Catch:{ Exception -> 0x00b7 }
            r11.<init>(r13, r6)     // Catch:{ Exception -> 0x00b7 }
            r10.<init>(r4, r11)     // Catch:{ Exception -> 0x00b7 }
            org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo r4 = new org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo     // Catch:{ Exception -> 0x00b7 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r6 = new org.spongycastle.asn1.x509.AlgorithmIdentifier     // Catch:{ Exception -> 0x00b7 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r11 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.w     // Catch:{ Exception -> 0x00b7 }
            r6.<init>(r11, r10)     // Catch:{ Exception -> 0x00b7 }
            r4.<init>(r6, r2)     // Catch:{ Exception -> 0x00b7 }
            int r2 = r3.length     // Catch:{ Exception -> 0x00b7 }
            org.spongycastle.asn1.x509.Certificate[] r2 = new org.spongycastle.asn1.x509.Certificate[r2]     // Catch:{ Exception -> 0x00b7 }
        L_0x008b:
            int r6 = r3.length     // Catch:{ Exception -> 0x00b7 }
            if (r7 == r6) goto L_0x009d
            r6 = r3[r7]     // Catch:{ Exception -> 0x00b7 }
            byte[] r6 = r6.getEncoded()     // Catch:{ Exception -> 0x00b7 }
            org.spongycastle.asn1.x509.Certificate r6 = org.spongycastle.asn1.x509.Certificate.g(r6)     // Catch:{ Exception -> 0x00b7 }
            r2[r7] = r6     // Catch:{ Exception -> 0x00b7 }
            int r7 = r7 + 1
            goto L_0x008b
        L_0x009d:
            org.spongycastle.asn1.bc.EncryptedPrivateKeyData r3 = new org.spongycastle.asn1.bc.EncryptedPrivateKeyData     // Catch:{ Exception -> 0x00b7 }
            r3.<init>(r4, r2)     // Catch:{ Exception -> 0x00b7 }
            org.spongycastle.asn1.bc.ObjectData r10 = new org.spongycastle.asn1.bc.ObjectData     // Catch:{ Exception -> 0x00b7 }
            java.math.BigInteger r4 = b     // Catch:{ Exception -> 0x00b7 }
            byte[] r7 = r3.e()     // Catch:{ Exception -> 0x00b7 }
            r2 = r10
            r3 = r4
            r4 = r17
            r6 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x00b7 }
            r9.put(r0, r10)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x016a
        L_0x00b7:
            r0 = move-exception
            org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$ExtKeyStoreException r2 = new org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$ExtKeyStoreException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r12)
            java.lang.String r3 = defpackage.C1058d.x(r0, r3)
            r2.<init>(r3, r0)
            throw r2
        L_0x00c7:
            java.security.KeyStoreException r0 = new java.security.KeyStoreException
            java.lang.String r2 = "BCFKS KeyStore requires a certificate chain for private key storage."
            r0.<init>(r2)
            throw r0
        L_0x00cf:
            boolean r6 = r2 instanceof javax.crypto.SecretKey
            if (r6 == 0) goto L_0x019c
            if (r3 != 0) goto L_0x0194
            byte[] r3 = r18.getEncoded()     // Catch:{ Exception -> 0x0184 }
            org.spongycastle.asn1.pkcs.KeyDerivationFunc r6 = e(r13)     // Catch:{ Exception -> 0x0184 }
            java.lang.String r13 = "SECRET_KEY_ENCRYPTION"
            if (r19 == 0) goto L_0x00e4
            r7 = r19
            goto L_0x00e6
        L_0x00e4:
            char[] r7 = new char[r7]     // Catch:{ Exception -> 0x0184 }
        L_0x00e6:
            byte[] r7 = d(r6, r13, r7)     // Catch:{ Exception -> 0x0184 }
            if (r11 != 0) goto L_0x00f1
            javax.crypto.Cipher r11 = javax.crypto.Cipher.getInstance(r15)     // Catch:{ Exception -> 0x0184 }
            goto L_0x00f5
        L_0x00f1:
            javax.crypto.Cipher r11 = javax.crypto.Cipher.getInstance(r15, r11)     // Catch:{ Exception -> 0x0184 }
        L_0x00f5:
            javax.crypto.spec.SecretKeySpec r13 = new javax.crypto.spec.SecretKeySpec     // Catch:{ Exception -> 0x0184 }
            r13.<init>(r7, r14)     // Catch:{ Exception -> 0x0184 }
            r11.init(r10, r13)     // Catch:{ Exception -> 0x0184 }
            java.lang.String r2 = r18.getAlgorithm()     // Catch:{ Exception -> 0x0184 }
            java.lang.String r2 = org.spongycastle.util.Strings.g(r2)     // Catch:{ Exception -> 0x0184 }
            int r7 = r2.indexOf(r14)     // Catch:{ Exception -> 0x0184 }
            r10 = -1
            if (r7 <= r10) goto L_0x011c
            org.spongycastle.asn1.bc.SecretKeyData r2 = new org.spongycastle.asn1.bc.SecretKeyData     // Catch:{ Exception -> 0x0184 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r4 = org.spongycastle.asn1.nist.NISTObjectIdentifiers.q     // Catch:{ Exception -> 0x0184 }
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x0184 }
            byte[] r2 = r2.e()     // Catch:{ Exception -> 0x0184 }
            byte[] r2 = r11.doFinal(r2)     // Catch:{ Exception -> 0x0184 }
            goto L_0x0133
        L_0x011c:
            java.util.HashMap r7 = f6516c     // Catch:{ Exception -> 0x0184 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x0184 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r7 = (org.spongycastle.asn1.ASN1ObjectIdentifier) r7     // Catch:{ Exception -> 0x0184 }
            if (r7 == 0) goto L_0x016d
            org.spongycastle.asn1.bc.SecretKeyData r2 = new org.spongycastle.asn1.bc.SecretKeyData     // Catch:{ Exception -> 0x0184 }
            r2.<init>(r7, r3)     // Catch:{ Exception -> 0x0184 }
            byte[] r2 = r2.e()     // Catch:{ Exception -> 0x0184 }
            byte[] r2 = r11.doFinal(r2)     // Catch:{ Exception -> 0x0184 }
        L_0x0133:
            java.security.AlgorithmParameters r3 = r11.getParameters()     // Catch:{ Exception -> 0x0184 }
            org.spongycastle.asn1.pkcs.PBES2Parameters r4 = new org.spongycastle.asn1.pkcs.PBES2Parameters     // Catch:{ Exception -> 0x0184 }
            org.spongycastle.asn1.pkcs.EncryptionScheme r7 = new org.spongycastle.asn1.pkcs.EncryptionScheme     // Catch:{ Exception -> 0x0184 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r10 = org.spongycastle.asn1.nist.NISTObjectIdentifiers.N     // Catch:{ Exception -> 0x0184 }
            byte[] r3 = r3.getEncoded()     // Catch:{ Exception -> 0x0184 }
            org.spongycastle.asn1.cms.CCMParameters r3 = org.spongycastle.asn1.cms.CCMParameters.g(r3)     // Catch:{ Exception -> 0x0184 }
            r7.<init>(r10, r3)     // Catch:{ Exception -> 0x0184 }
            r4.<init>(r6, r7)     // Catch:{ Exception -> 0x0184 }
            org.spongycastle.asn1.bc.EncryptedSecretKeyData r3 = new org.spongycastle.asn1.bc.EncryptedSecretKeyData     // Catch:{ Exception -> 0x0184 }
            org.spongycastle.asn1.x509.AlgorithmIdentifier r6 = new org.spongycastle.asn1.x509.AlgorithmIdentifier     // Catch:{ Exception -> 0x0184 }
            org.spongycastle.asn1.ASN1ObjectIdentifier r7 = org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers.w     // Catch:{ Exception -> 0x0184 }
            r6.<init>(r7, r4)     // Catch:{ Exception -> 0x0184 }
            r3.<init>(r6, r2)     // Catch:{ Exception -> 0x0184 }
            org.spongycastle.asn1.bc.ObjectData r10 = new org.spongycastle.asn1.bc.ObjectData     // Catch:{ Exception -> 0x0184 }
            java.math.BigInteger r4 = c     // Catch:{ Exception -> 0x0184 }
            byte[] r7 = r3.e()     // Catch:{ Exception -> 0x0184 }
            r2 = r10
            r3 = r4
            r4 = r17
            r6 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0184 }
            r9.put(r0, r10)     // Catch:{ Exception -> 0x0184 }
        L_0x016a:
            r1.f6523b = r8
            return
        L_0x016d:
            java.security.KeyStoreException r0 = new java.security.KeyStoreException     // Catch:{ Exception -> 0x0184 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0184 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x0184 }
            r3.append(r2)     // Catch:{ Exception -> 0x0184 }
            java.lang.String r2 = ") for storage."
            r3.append(r2)     // Catch:{ Exception -> 0x0184 }
            java.lang.String r2 = r3.toString()     // Catch:{ Exception -> 0x0184 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0184 }
            throw r0     // Catch:{ Exception -> 0x0184 }
        L_0x0184:
            r0 = move-exception
            org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$ExtKeyStoreException r2 = new org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$ExtKeyStoreException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r12)
            java.lang.String r3 = defpackage.C1058d.x(r0, r3)
            r2.<init>(r3, r0)
            throw r2
        L_0x0194:
            java.security.KeyStoreException r0 = new java.security.KeyStoreException
            java.lang.String r2 = "BCFKS KeyStore cannot store certificate chain with secret key."
            r0.<init>(r2)
            throw r0
        L_0x019c:
            java.security.KeyStoreException r0 = new java.security.KeyStoreException
            java.lang.String r2 = "BCFKS KeyStore unable to recognize key."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.engineSetKeyEntry(java.lang.String, java.security.Key, char[], java.security.cert.Certificate[]):void");
    }

    public final int engineSize() {
        return this.f6519a.size();
    }

    public final void engineStore(OutputStream outputStream, char[] cArr) throws IOException, NoSuchAlgorithmException, CertificateException {
        char[] cArr2;
        Cipher cipher;
        BigInteger bigInteger;
        HashMap hashMap = this.f6519a;
        ObjectData[] objectDataArr = (ObjectData[]) hashMap.values().toArray(new ObjectData[hashMap.size()]);
        KeyDerivationFunc e2 = e(32);
        if (cArr != null) {
            cArr2 = cArr;
        } else {
            cArr2 = new char[0];
        }
        byte[] d2 = d(e2, "STORE_ENCRYPTION", cArr2);
        ObjectStoreData objectStoreData = new ObjectStoreData(this.f6521a, this.f6518a, this.f6523b, new ObjectDataSequence(objectDataArr));
        try {
            BouncyCastleProvider bouncyCastleProvider = this.f6522a;
            if (bouncyCastleProvider == null) {
                cipher = Cipher.getInstance("AES/CCM/NoPadding");
            } else {
                cipher = Cipher.getInstance("AES/CCM/NoPadding", bouncyCastleProvider);
            }
            cipher.init(1, new SecretKeySpec(d2, "AES"));
            EncryptedObjectStoreData encryptedObjectStoreData = new EncryptedObjectStoreData(new AlgorithmIdentifier(PKCSObjectIdentifiers.w, new PBES2Parameters(e2, new EncryptionScheme(NISTObjectIdentifiers.N, CCMParameters.g(cipher.getParameters().getEncoded())))), cipher.doFinal(objectStoreData.e()));
            PBKDF2Params g = PBKDF2Params.g(this.f6520a.a.a);
            byte[] bArr = new byte[g.f5696a.s().length];
            new SecureRandom().nextBytes(bArr);
            ASN1ObjectIdentifier aSN1ObjectIdentifier = this.f6520a.a.Z0;
            int intValue = g.a.t().intValue();
            ASN1Integer aSN1Integer = g.f5698b;
            if (aSN1Integer != null) {
                bigInteger = aSN1Integer.t();
            } else {
                bigInteger = null;
            }
            int intValue2 = bigInteger.intValue();
            AlgorithmIdentifier algorithmIdentifier = g.f5697a;
            if (algorithmIdentifier == null) {
                algorithmIdentifier = PBKDF2Params.b;
            }
            this.f6520a = new KeyDerivationFunc(aSN1ObjectIdentifier, new PBKDF2Params(bArr, intValue, intValue2, algorithmIdentifier));
            outputStream.write(new ObjectStore(encryptedObjectStoreData, new ObjectStoreIntegrityCheck(new PbkdMacIntegrityCheck(this.f6521a, this.f6520a, a(encryptedObjectStoreData.e(), this.f6521a, this.f6520a, cArr)))).e());
            outputStream.flush();
        } catch (NoSuchPaddingException e3) {
            throw new NoSuchAlgorithmException(e3.toString());
        } catch (BadPaddingException e4) {
            throw new IOException(e4.toString());
        } catch (IllegalBlockSizeException e5) {
            throw new IOException(e5.toString());
        } catch (InvalidKeyException e6) {
            throw new IOException(e6.toString());
        }
    }

    public final void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        Date date;
        Date date2;
        Date date3 = new Date();
        HashMap hashMap = this.f6519a;
        ObjectData objectData = (ObjectData) hashMap.get(str);
        if (objectData != null) {
            try {
                date2 = objectData.f5678a.q();
            } catch (ParseException unused) {
                date2 = date3;
            }
            date = date2;
        } else {
            date = date3;
        }
        if (certificateArr != null) {
            try {
                EncryptedPrivateKeyInfo g = EncryptedPrivateKeyInfo.g(bArr);
                try {
                    this.f6524b.remove(str);
                    BigInteger bigInteger = d;
                    org.spongycastle.asn1.x509.Certificate[] certificateArr2 = new org.spongycastle.asn1.x509.Certificate[certificateArr.length];
                    for (int i = 0; i != certificateArr.length; i++) {
                        certificateArr2[i] = org.spongycastle.asn1.x509.Certificate.g(certificateArr[i].getEncoded());
                    }
                    hashMap.put(str, new ObjectData(bigInteger, str, date, date3, new EncryptedPrivateKeyData(g, certificateArr2).e()));
                } catch (Exception e2) {
                    throw new ExtKeyStoreException(C1058d.x(e2, new StringBuilder("BCFKS KeyStore exception storing protected private key: ")), e2);
                }
            } catch (Exception e3) {
                throw new ExtKeyStoreException("BCFKS KeyStore private key encoding must be an EncryptedPrivateKeyInfo.", e3);
            }
        } else {
            try {
                hashMap.put(str, new ObjectData(e, str, date, date3, bArr));
            } catch (Exception e4) {
                throw new ExtKeyStoreException(C1058d.x(e4, new StringBuilder("BCFKS KeyStore exception storing protected private key: ")), e4);
            }
        }
        this.f6523b = date3;
    }
}
