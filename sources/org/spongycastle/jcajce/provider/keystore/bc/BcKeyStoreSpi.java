package org.spongycastle.jcajce.provider.keystore.bc;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.security.Key;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.PBEParametersGenerator;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.generators.PKCS12ParametersGenerator;
import org.spongycastle.crypto.io.DigestInputStream;
import org.spongycastle.crypto.io.DigestOutputStream;
import org.spongycastle.crypto.io.MacInputStream;
import org.spongycastle.crypto.io.MacOutputStream;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.jcajce.util.BCJcaJceHelper;
import org.spongycastle.jce.interfaces.BCKeyStore;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;
import org.spongycastle.util.io.TeeOutputStream;

public class BcKeyStoreSpi extends KeyStoreSpi implements BCKeyStore {
    public final SecureRandom a = new SecureRandom();

    /* renamed from: a  reason: collision with other field name */
    public final Hashtable f6509a = new Hashtable();

    /* renamed from: a  reason: collision with other field name */
    public final BCJcaJceHelper f6510a = new BCJcaJceHelper();
    public final int c;

    public static class BouncyCastleStore extends BcKeyStoreSpi {
        public BouncyCastleStore() {
            super(1);
        }

        public final void engineLoad(InputStream inputStream, char[] cArr) throws IOException {
            String str;
            Hashtable hashtable = this.f6509a;
            hashtable.clear();
            if (inputStream != null) {
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                int readInt = dataInputStream.readInt();
                if (readInt == 2 || readInt == 0 || readInt == 1) {
                    int readInt2 = dataInputStream.readInt();
                    byte[] bArr = new byte[readInt2];
                    if (readInt2 == 20) {
                        dataInputStream.readFully(bArr);
                        int readInt3 = dataInputStream.readInt();
                        if (readInt3 < 0 || readInt3 > 65536) {
                            throw new IOException("Key store corrupted.");
                        }
                        if (readInt == 0) {
                            str = "OldPBEWithSHAAndTwofish-CBC";
                        } else {
                            str = "PBEWithSHAAndTwofish-CBC";
                        }
                        CipherInputStream cipherInputStream = new CipherInputStream(dataInputStream, f(str, 2, cArr, bArr, readInt3));
                        SHA1Digest sHA1Digest = new SHA1Digest();
                        e(new DigestInputStream(cipherInputStream, sHA1Digest));
                        byte[] bArr2 = new byte[20];
                        sHA1Digest.c(0, bArr2);
                        byte[] bArr3 = new byte[20];
                        Streams.b(cipherInputStream, bArr3, 0, 20);
                        if (!Arrays.l(bArr2, bArr3)) {
                            hashtable.clear();
                            throw new IOException("KeyStore integrity check failed.");
                        }
                        return;
                    }
                    throw new IOException("Key store corrupted.");
                }
                throw new IOException("Wrong version of key store.");
            }
        }

        public final void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            byte[] bArr = new byte[20];
            SecureRandom secureRandom = this.a;
            int nextInt = (secureRandom.nextInt() & 1023) + UserMetadata.MAX_ATTRIBUTE_SIZE;
            secureRandom.nextBytes(bArr);
            dataOutputStream.writeInt(this.c);
            dataOutputStream.writeInt(20);
            dataOutputStream.write(bArr);
            dataOutputStream.writeInt(nextInt);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(dataOutputStream, f("PBEWithSHAAndTwofish-CBC", 1, cArr, bArr, nextInt));
            DigestOutputStream digestOutputStream = new DigestOutputStream(new SHA1Digest());
            g(new TeeOutputStream(cipherOutputStream, digestOutputStream));
            Digest digest = digestOutputStream.a;
            byte[] bArr2 = new byte[digest.f()];
            digest.c(0, bArr2);
            cipherOutputStream.write(bArr2);
            cipherOutputStream.close();
        }
    }

    public static class Std extends BcKeyStoreSpi {
        public Std() {
            super(2);
        }
    }

    public static class Version1 extends BcKeyStoreSpi {
        public Version1() {
            super(1);
        }
    }

    public BcKeyStoreSpi(int i) {
        this.c = i;
    }

    public static void c(Certificate certificate, DataOutputStream dataOutputStream) throws IOException {
        try {
            byte[] encoded = certificate.getEncoded();
            dataOutputStream.writeUTF(certificate.getType());
            dataOutputStream.writeInt(encoded.length);
            dataOutputStream.write(encoded);
        } catch (CertificateEncodingException e) {
            throw new IOException(e.toString());
        }
    }

    public static void d(Key key, DataOutputStream dataOutputStream) throws IOException {
        byte[] encoded = key.getEncoded();
        if (key instanceof PrivateKey) {
            dataOutputStream.write(0);
        } else if (key instanceof PublicKey) {
            dataOutputStream.write(1);
        } else {
            dataOutputStream.write(2);
        }
        dataOutputStream.writeUTF(key.getFormat());
        dataOutputStream.writeUTF(key.getAlgorithm());
        dataOutputStream.writeInt(encoded.length);
        dataOutputStream.write(encoded);
    }

    public final Certificate a(DataInputStream dataInputStream) throws IOException {
        String readUTF = dataInputStream.readUTF();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        try {
            return CertificateFactory.getInstance(readUTF, this.f6510a.a).generateCertificate(new ByteArrayInputStream(bArr));
        } catch (NoSuchProviderException e) {
            throw new IOException(e.toString());
        } catch (CertificateException e2) {
            throw new IOException(e2.toString());
        }
    }

    public final Key b(DataInputStream dataInputStream) throws IOException {
        KeySpec keySpec;
        int read = dataInputStream.read();
        String readUTF = dataInputStream.readUTF();
        String readUTF2 = dataInputStream.readUTF();
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.readFully(bArr);
        if (readUTF.equals("PKCS#8") || readUTF.equals("PKCS8")) {
            keySpec = new PKCS8EncodedKeySpec(bArr);
        } else if (readUTF.equals("X.509") || readUTF.equals("X509")) {
            keySpec = new X509EncodedKeySpec(bArr);
        } else if (readUTF.equals("RAW")) {
            return new SecretKeySpec(bArr, readUTF2);
        } else {
            throw new IOException(lf.j("Key format ", readUTF, " not recognised!"));
        }
        BCJcaJceHelper bCJcaJceHelper = this.f6510a;
        if (read == 0) {
            return bCJcaJceHelper.c(readUTF2).generatePrivate(keySpec);
        }
        if (read == 1) {
            return bCJcaJceHelper.c(readUTF2).generatePublic(keySpec);
        }
        if (read == 2) {
            try {
                return SecretKeyFactory.getInstance(readUTF2, bCJcaJceHelper.a).generateSecret(keySpec);
            } catch (Exception e) {
                throw new IOException(C1058d.x(e, new StringBuilder("Exception creating key: ")));
            }
        } else {
            throw new IOException("Key type " + read + " not recognised!");
        }
    }

    /* JADX WARNING: type inference failed for: r6v1, types: [byte[], java.io.Serializable] */
    public final void e(FilterInputStream filterInputStream) throws IOException {
        Certificate[] certificateArr;
        DataInputStream dataInputStream = new DataInputStream(filterInputStream);
        for (int read = dataInputStream.read(); read > 0; read = dataInputStream.read()) {
            String readUTF = dataInputStream.readUTF();
            Date date = new Date(dataInputStream.readLong());
            int readInt = dataInputStream.readInt();
            if (readInt != 0) {
                Certificate[] certificateArr2 = new Certificate[readInt];
                for (int i = 0; i != readInt; i++) {
                    certificateArr2[i] = a(dataInputStream);
                }
                certificateArr = certificateArr2;
            } else {
                certificateArr = null;
            }
            Hashtable hashtable = this.f6509a;
            if (read == 1) {
                hashtable.put(readUTF, new StoreEntry(readUTF, date, a(dataInputStream)));
            } else if (read == 2) {
                hashtable.put(readUTF, new StoreEntry(readUTF, date, 2, b(dataInputStream), certificateArr));
            } else if (read == 3 || read == 4) {
                ? r6 = new byte[dataInputStream.readInt()];
                dataInputStream.readFully(r6);
                hashtable.put(readUTF, new StoreEntry(readUTF, date, read, r6, certificateArr));
            } else {
                throw new RuntimeException("Unknown object type in store.");
            }
        }
    }

    public final Enumeration engineAliases() {
        return this.f6509a.keys();
    }

    public final boolean engineContainsAlias(String str) {
        if (this.f6509a.get(str) != null) {
            return true;
        }
        return false;
    }

    public final void engineDeleteEntry(String str) throws KeyStoreException {
        Hashtable hashtable = this.f6509a;
        if (hashtable.get(str) != null) {
            hashtable.remove(str);
        }
    }

    public final Certificate engineGetCertificate(String str) {
        StoreEntry storeEntry = (StoreEntry) this.f6509a.get(str);
        if (storeEntry == null) {
            return null;
        }
        if (storeEntry.a == 1) {
            return (Certificate) storeEntry.f6511a;
        }
        Certificate[] certificateArr = storeEntry.f6515a;
        if (certificateArr != null) {
            return certificateArr[0];
        }
        return null;
    }

    public final String engineGetCertificateAlias(Certificate certificate) {
        Enumeration elements = this.f6509a.elements();
        while (elements.hasMoreElements()) {
            StoreEntry storeEntry = (StoreEntry) elements.nextElement();
            Object obj = storeEntry.f6511a;
            boolean z = obj instanceof Certificate;
            String str = storeEntry.f6512a;
            if (!z) {
                Certificate[] certificateArr = storeEntry.f6515a;
                if (certificateArr != null && certificateArr[0].equals(certificate)) {
                    return str;
                }
            } else if (((Certificate) obj).equals(certificate)) {
                return str;
            }
        }
        return null;
    }

    public final Certificate[] engineGetCertificateChain(String str) {
        StoreEntry storeEntry = (StoreEntry) this.f6509a.get(str);
        if (storeEntry != null) {
            return storeEntry.f6515a;
        }
        return null;
    }

    public final Date engineGetCreationDate(String str) {
        StoreEntry storeEntry = (StoreEntry) this.f6509a.get(str);
        if (storeEntry != null) {
            return storeEntry.f6513a;
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:17|18|19|20|21|(1:25)(3:28|29|30)) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = new java.io.DataInputStream(new java.io.ByteArrayInputStream((byte[]) r12.f6511a));
        r1 = new byte[r3.readInt()];
        r3.readFully(r1);
        r10 = r3.readInt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3 = r2.b(new java.io.DataInputStream(new javax.crypto.CipherInputStream(r3, r12.f6514a.f("BrokenPBEWithSHAAnd3-KeyTripleDES-CBC", 2, r13, r1, r10))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008f, code lost:
        r8 = r1;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r3 = new java.io.DataInputStream(new java.io.ByteArrayInputStream((byte[]) r12.f6511a));
        r1 = new byte[r3.readInt()];
        r3.readFully(r1);
        r10 = r3.readInt();
        r3 = r2.b(new java.io.DataInputStream(new javax.crypto.CipherInputStream(r3, r12.f6514a.f("OldPBEWithSHAAnd3-KeyTripleDES-CBC", 2, r13, r1, r10))));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c8, code lost:
        if (r3 != null) goto L_0x00ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ca, code lost:
        r1 = new java.io.ByteArrayOutputStream();
        r10 = new java.io.DataOutputStream(r1);
        r10.writeInt(r8.length);
        r10.write(r8);
        r10.writeInt(r9);
        r13 = new java.io.DataOutputStream(new javax.crypto.CipherOutputStream(r10, r12.f6514a.f("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, r13, r8, r9)));
        r2.getClass();
        d(r3, r13);
        r13.close();
        r12.f6511a = r1.toByteArray();
        r3 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0109, code lost:
        throw new java.security.UnrecoverableKeyException("no match");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        if (r4 != false) goto L_0x0101;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0092 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.security.Key engineGetKey(java.lang.String r12, char[] r13) throws java.security.NoSuchAlgorithmException, java.security.UnrecoverableKeyException {
        /*
            r11 = this;
            java.util.Hashtable r0 = r11.f6509a
            java.lang.Object r12 = r0.get(r12)
            org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi$StoreEntry r12 = (org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi.StoreEntry) r12
            if (r12 == 0) goto L_0x0118
            r0 = 1
            int r1 = r12.a
            if (r1 != r0) goto L_0x0011
            goto L_0x0118
        L_0x0011:
            java.lang.String r0 = "no match"
            org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi r2 = org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi.this
            if (r13 == 0) goto L_0x001a
            int r3 = r13.length
            if (r3 != 0) goto L_0x0022
        L_0x001a:
            java.lang.Object r3 = r12.f6511a
            boolean r4 = r3 instanceof java.security.Key
            if (r4 == 0) goto L_0x0022
            goto L_0x0101
        L_0x0022:
            r3 = 4
            if (r1 != r3) goto L_0x0110
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            java.lang.Object r3 = r12.f6511a
            byte[] r3 = (byte[]) r3
            r1.<init>(r3)
            java.io.DataInputStream r3 = new java.io.DataInputStream
            r3.<init>(r1)
            int r1 = r3.readInt()     // Catch:{ Exception -> 0x010a }
            byte[] r8 = new byte[r1]     // Catch:{ Exception -> 0x010a }
            r3.readFully(r8)     // Catch:{ Exception -> 0x010a }
            int r9 = r3.readInt()     // Catch:{ Exception -> 0x010a }
            org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi r4 = org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi.this     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = "PBEWithSHAAnd3-KeyTripleDES-CBC"
            r6 = 2
            r7 = r13
            javax.crypto.Cipher r1 = r4.f(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x010a }
            javax.crypto.CipherInputStream r4 = new javax.crypto.CipherInputStream     // Catch:{ Exception -> 0x010a }
            r4.<init>(r3, r1)     // Catch:{ Exception -> 0x010a }
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ Exception -> 0x005a }
            r1.<init>(r4)     // Catch:{ Exception -> 0x005a }
            java.security.Key r3 = r2.b(r1)     // Catch:{ Exception -> 0x005a }
            goto L_0x0101
        L_0x005a:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x010a }
            java.lang.Object r3 = r12.f6511a     // Catch:{ Exception -> 0x010a }
            byte[] r3 = (byte[]) r3     // Catch:{ Exception -> 0x010a }
            r1.<init>(r3)     // Catch:{ Exception -> 0x010a }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ Exception -> 0x010a }
            r3.<init>(r1)     // Catch:{ Exception -> 0x010a }
            int r1 = r3.readInt()     // Catch:{ Exception -> 0x010a }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x010a }
            r3.readFully(r1)     // Catch:{ Exception -> 0x010a }
            int r10 = r3.readInt()     // Catch:{ Exception -> 0x010a }
            org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi r4 = org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi.this     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = "BrokenPBEWithSHAAnd3-KeyTripleDES-CBC"
            r6 = 2
            r7 = r13
            r8 = r1
            r9 = r10
            javax.crypto.Cipher r4 = r4.f(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x010a }
            javax.crypto.CipherInputStream r5 = new javax.crypto.CipherInputStream     // Catch:{ Exception -> 0x010a }
            r5.<init>(r3, r4)     // Catch:{ Exception -> 0x010a }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0092 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0092 }
            java.security.Key r3 = r2.b(r3)     // Catch:{ Exception -> 0x0092 }
        L_0x008f:
            r8 = r1
            r9 = r10
            goto L_0x00c8
        L_0x0092:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x010a }
            java.lang.Object r3 = r12.f6511a     // Catch:{ Exception -> 0x010a }
            byte[] r3 = (byte[]) r3     // Catch:{ Exception -> 0x010a }
            r1.<init>(r3)     // Catch:{ Exception -> 0x010a }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ Exception -> 0x010a }
            r3.<init>(r1)     // Catch:{ Exception -> 0x010a }
            int r1 = r3.readInt()     // Catch:{ Exception -> 0x010a }
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x010a }
            r3.readFully(r1)     // Catch:{ Exception -> 0x010a }
            int r10 = r3.readInt()     // Catch:{ Exception -> 0x010a }
            org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi r4 = org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi.this     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = "OldPBEWithSHAAnd3-KeyTripleDES-CBC"
            r6 = 2
            r7 = r13
            r8 = r1
            r9 = r10
            javax.crypto.Cipher r4 = r4.f(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x010a }
            javax.crypto.CipherInputStream r5 = new javax.crypto.CipherInputStream     // Catch:{ Exception -> 0x010a }
            r5.<init>(r3, r4)     // Catch:{ Exception -> 0x010a }
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ Exception -> 0x010a }
            r3.<init>(r5)     // Catch:{ Exception -> 0x010a }
            java.security.Key r3 = r2.b(r3)     // Catch:{ Exception -> 0x010a }
            goto L_0x008f
        L_0x00c8:
            if (r3 == 0) goto L_0x0104
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x010a }
            r1.<init>()     // Catch:{ Exception -> 0x010a }
            java.io.DataOutputStream r10 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x010a }
            r10.<init>(r1)     // Catch:{ Exception -> 0x010a }
            int r4 = r8.length     // Catch:{ Exception -> 0x010a }
            r10.writeInt(r4)     // Catch:{ Exception -> 0x010a }
            r10.write(r8)     // Catch:{ Exception -> 0x010a }
            r10.writeInt(r9)     // Catch:{ Exception -> 0x010a }
            org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi r4 = org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi.this     // Catch:{ Exception -> 0x010a }
            java.lang.String r5 = "PBEWithSHAAnd3-KeyTripleDES-CBC"
            r6 = 1
            r7 = r13
            javax.crypto.Cipher r13 = r4.f(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x010a }
            javax.crypto.CipherOutputStream r4 = new javax.crypto.CipherOutputStream     // Catch:{ Exception -> 0x010a }
            r4.<init>(r10, r13)     // Catch:{ Exception -> 0x010a }
            java.io.DataOutputStream r13 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x010a }
            r13.<init>(r4)     // Catch:{ Exception -> 0x010a }
            r2.getClass()     // Catch:{ Exception -> 0x010a }
            d(r3, r13)     // Catch:{ Exception -> 0x010a }
            r13.close()     // Catch:{ Exception -> 0x010a }
            byte[] r13 = r1.toByteArray()     // Catch:{ Exception -> 0x010a }
            r12.f6511a = r13     // Catch:{ Exception -> 0x010a }
        L_0x0101:
            java.security.Key r3 = (java.security.Key) r3
            return r3
        L_0x0104:
            java.security.UnrecoverableKeyException r12 = new java.security.UnrecoverableKeyException     // Catch:{ Exception -> 0x010a }
            r12.<init>(r0)     // Catch:{ Exception -> 0x010a }
            throw r12     // Catch:{ Exception -> 0x010a }
        L_0x010a:
            java.security.UnrecoverableKeyException r12 = new java.security.UnrecoverableKeyException
            r12.<init>(r0)
            throw r12
        L_0x0110:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.String r13 = "forget something!"
            r12.<init>(r13)
            throw r12
        L_0x0118:
            r12 = 0
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.jcajce.provider.keystore.bc.BcKeyStoreSpi.engineGetKey(java.lang.String, char[]):java.security.Key");
    }

    public final boolean engineIsCertificateEntry(String str) {
        StoreEntry storeEntry = (StoreEntry) this.f6509a.get(str);
        if (storeEntry == null || storeEntry.a != 1) {
            return false;
        }
        return true;
    }

    public final boolean engineIsKeyEntry(String str) {
        StoreEntry storeEntry = (StoreEntry) this.f6509a.get(str);
        if (storeEntry == null || storeEntry.a == 1) {
            return false;
        }
        return true;
    }

    public void engineLoad(InputStream inputStream, char[] cArr) throws IOException {
        KeyParameter keyParameter;
        Hashtable hashtable = this.f6509a;
        hashtable.clear();
        if (inputStream != null) {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            int readInt = dataInputStream.readInt();
            if (readInt == 2 || readInt == 0 || readInt == 1) {
                int readInt2 = dataInputStream.readInt();
                if (readInt2 > 0) {
                    byte[] bArr = new byte[readInt2];
                    dataInputStream.readFully(bArr);
                    int readInt3 = dataInputStream.readInt();
                    HMac hMac = new HMac(new SHA1Digest());
                    int i = hMac.f6108a;
                    if (cArr == null || cArr.length == 0) {
                        e(dataInputStream);
                        dataInputStream.readFully(new byte[i]);
                        return;
                    }
                    byte[] a2 = PBEParametersGenerator.a(cArr);
                    PKCS12ParametersGenerator pKCS12ParametersGenerator = new PKCS12ParametersGenerator(new SHA1Digest());
                    pKCS12ParametersGenerator.f(a2, readInt3, bArr);
                    if (readInt != 2) {
                        keyParameter = pKCS12ParametersGenerator.c(i);
                    } else {
                        keyParameter = pKCS12ParametersGenerator.c(i * 8);
                    }
                    Arrays.p(a2, (byte) 0);
                    hMac.a(keyParameter);
                    e(new MacInputStream(dataInputStream, hMac));
                    byte[] bArr2 = new byte[i];
                    hMac.c(0, bArr2);
                    byte[] bArr3 = new byte[i];
                    dataInputStream.readFully(bArr3);
                    if (!Arrays.l(bArr2, bArr3)) {
                        hashtable.clear();
                        throw new IOException("KeyStore integrity check failed.");
                    }
                    return;
                }
                throw new IOException("Invalid salt detected");
            }
            throw new IOException("Wrong version of key store.");
        }
    }

    public final void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        Hashtable hashtable = this.f6509a;
        StoreEntry storeEntry = (StoreEntry) hashtable.get(str);
        if (storeEntry == null || storeEntry.a == 1) {
            hashtable.put(str, new StoreEntry(str, certificate));
            return;
        }
        throw new KeyStoreException(C0709Uj.i("key store already has a key entry with alias ", str));
    }

    public final void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
        this.f6509a.put(str, new StoreEntry(str, bArr, certificateArr));
    }

    public final int engineSize() {
        return this.f6509a.size();
    }

    public void engineStore(OutputStream outputStream, char[] cArr) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        byte[] bArr = new byte[20];
        SecureRandom secureRandom = this.a;
        int nextInt = (secureRandom.nextInt() & 1023) + UserMetadata.MAX_ATTRIBUTE_SIZE;
        secureRandom.nextBytes(bArr);
        int i = this.c;
        dataOutputStream.writeInt(i);
        dataOutputStream.writeInt(20);
        dataOutputStream.write(bArr);
        dataOutputStream.writeInt(nextInt);
        HMac hMac = new HMac(new SHA1Digest());
        MacOutputStream macOutputStream = new MacOutputStream(hMac);
        PKCS12ParametersGenerator pKCS12ParametersGenerator = new PKCS12ParametersGenerator(new SHA1Digest());
        byte[] a2 = PBEParametersGenerator.a(cArr);
        pKCS12ParametersGenerator.f(a2, nextInt, bArr);
        int i2 = hMac.f6108a;
        if (i < 2) {
            hMac.a(pKCS12ParametersGenerator.c(i2));
        } else {
            hMac.a(pKCS12ParametersGenerator.c(i2 * 8));
        }
        for (int i3 = 0; i3 != a2.length; i3++) {
            a2[i3] = 0;
        }
        g(new TeeOutputStream(dataOutputStream, macOutputStream));
        byte[] bArr2 = new byte[i2];
        hMac.c(0, bArr2);
        dataOutputStream.write(bArr2);
        dataOutputStream.close();
    }

    public final Cipher f(String str, int i, char[] cArr, byte[] bArr, int i2) throws IOException {
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr);
            BCJcaJceHelper bCJcaJceHelper = this.f6510a;
            SecretKeyFactory instance = SecretKeyFactory.getInstance(str, bCJcaJceHelper.a);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i2);
            Cipher instance2 = Cipher.getInstance(str, bCJcaJceHelper.a);
            instance2.init(i, instance.generateSecret(pBEKeySpec), pBEParameterSpec);
            return instance2;
        } catch (Exception e) {
            throw new IOException("Error initialising store of key store: " + e);
        }
    }

    public final void g(TeeOutputStream teeOutputStream) throws IOException {
        Enumeration elements = this.f6509a.elements();
        DataOutputStream dataOutputStream = new DataOutputStream(teeOutputStream);
        while (true) {
            if (elements.hasMoreElements()) {
                StoreEntry storeEntry = (StoreEntry) elements.nextElement();
                dataOutputStream.write(storeEntry.a);
                dataOutputStream.writeUTF(storeEntry.f6512a);
                dataOutputStream.writeLong(storeEntry.f6513a.getTime());
                Certificate[] certificateArr = storeEntry.f6515a;
                if (certificateArr == null) {
                    dataOutputStream.writeInt(0);
                } else {
                    dataOutputStream.writeInt(certificateArr.length);
                    for (int i = 0; i != certificateArr.length; i++) {
                        c(certificateArr[i], dataOutputStream);
                    }
                }
                int i2 = storeEntry.a;
                if (i2 == 1) {
                    c((Certificate) storeEntry.f6511a, dataOutputStream);
                } else if (i2 == 2) {
                    d((Key) storeEntry.f6511a, dataOutputStream);
                } else if (i2 == 3 || i2 == 4) {
                    byte[] bArr = (byte[]) storeEntry.f6511a;
                    dataOutputStream.writeInt(bArr.length);
                    dataOutputStream.write(bArr);
                } else {
                    throw new RuntimeException("Unknown object type in store.");
                }
            } else {
                dataOutputStream.write(0);
                return;
            }
        }
    }

    public final void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        if (!(key instanceof PrivateKey) || certificateArr != null) {
            try {
                this.f6509a.put(str, new StoreEntry(str, key, cArr, certificateArr));
            } catch (Exception e) {
                throw new KeyStoreException(e.toString());
            }
        } else {
            throw new KeyStoreException("no certificate chain for private key");
        }
    }

    public class StoreEntry {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public Object f6511a;

        /* renamed from: a  reason: collision with other field name */
        public final String f6512a;

        /* renamed from: a  reason: collision with other field name */
        public final Date f6513a;

        /* renamed from: a  reason: collision with other field name */
        public final Certificate[] f6515a;

        public StoreEntry(String str, Certificate certificate) {
            this.f6513a = new Date();
            this.a = 1;
            this.f6512a = str;
            this.f6511a = certificate;
            this.f6515a = null;
        }

        public StoreEntry(String str, byte[] bArr, Certificate[] certificateArr) {
            this.f6513a = new Date();
            this.a = 3;
            this.f6512a = str;
            this.f6511a = bArr;
            this.f6515a = certificateArr;
        }

        public StoreEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws Exception {
            this.f6513a = new Date();
            this.a = 4;
            this.f6512a = str;
            this.f6515a = certificateArr;
            byte[] bArr = new byte[20];
            BcKeyStoreSpi.this.a.setSeed(System.currentTimeMillis());
            SecureRandom secureRandom = BcKeyStoreSpi.this.a;
            secureRandom.nextBytes(bArr);
            int nextInt = (secureRandom.nextInt() & 1023) + UserMetadata.MAX_ATTRIBUTE_SIZE;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(20);
            dataOutputStream.write(bArr);
            dataOutputStream.writeInt(nextInt);
            DataOutputStream dataOutputStream2 = new DataOutputStream(new CipherOutputStream(dataOutputStream, BcKeyStoreSpi.this.f("PBEWithSHAAnd3-KeyTripleDES-CBC", 1, cArr, bArr, nextInt)));
            BcKeyStoreSpi.d(key, dataOutputStream2);
            dataOutputStream2.close();
            this.f6511a = byteArrayOutputStream.toByteArray();
        }

        public StoreEntry(String str, Date date, Certificate certificate) {
            this.f6513a = new Date();
            this.f6512a = str;
            this.f6513a = date;
            this.a = 1;
            this.f6511a = certificate;
        }

        public StoreEntry(String str, Date date, int i, Serializable serializable, Certificate[] certificateArr) {
            this.f6513a = new Date();
            this.f6512a = str;
            this.f6513a = date;
            this.a = i;
            this.f6511a = serializable;
            this.f6515a = certificateArr;
        }
    }
}
