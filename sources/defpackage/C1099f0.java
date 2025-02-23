package defpackage;

import android.os.Build;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: f0  reason: default package and case insensitive filesystem */
/* compiled from: AesCbcWithIntegrity */
public final class C1099f0 {
    public static final AtomicBoolean a = new AtomicBoolean(false);

    /* renamed from: f0$b */
    /* compiled from: AesCbcWithIntegrity */
    public static final class b {
        public static final /* synthetic */ int a = 0;

        static {
            StringBuilder sb = new StringBuilder();
            String str = Build.FINGERPRINT;
            if (str != null) {
                sb.append(str);
            }
            String str2 = null;
            try {
                str2 = (String) Build.class.getField("SERIAL").get((Object) null);
            } catch (Exception unused) {
            }
            if (str2 != null) {
                sb.append(str2);
            }
            try {
                sb.toString().getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused2) {
                throw new RuntimeException("UTF-8 encoding not supported");
            }
        }
    }

    /* renamed from: f0$c */
    /* compiled from: AesCbcWithIntegrity */
    public static class c {
        public SecretKey a;
        public SecretKey b;

        public c(SecretKey secretKey, SecretKeySpec secretKeySpec) {
            this.a = secretKey;
            this.b = secretKeySpec;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.b.equals(cVar.b) && this.a.equals(cVar.a)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return this.b.hashCode() + ((this.a.hashCode() + 31) * 31);
        }

        public final String toString() {
            return Base64.encodeToString(this.a.getEncoded(), 2) + ":" + Base64.encodeToString(this.b.getEncoded(), 2);
        }
    }

    public static String a(a aVar, c cVar) throws UnsupportedEncodingException, GeneralSecurityException {
        byte[] bArr = aVar.b;
        int length = bArr.length;
        byte[] bArr2 = aVar.a;
        byte[] bArr3 = new byte[(length + bArr2.length)];
        boolean z = false;
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        SecretKey secretKey = cVar.b;
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(secretKey);
        byte[] doFinal = instance.doFinal(bArr3);
        int length2 = doFinal.length;
        byte[] bArr4 = aVar.c;
        if (length2 == bArr4.length) {
            byte b2 = 0;
            for (int i = 0; i < doFinal.length; i++) {
                b2 |= doFinal[i] ^ bArr4[i];
            }
            if (b2 == 0) {
                z = true;
            }
        }
        if (z) {
            Cipher instance2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            instance2.init(2, cVar.a, new IvParameterSpec(bArr));
            return new String(instance2.doFinal(bArr2), "UTF-8");
        }
        throw new GeneralSecurityException("MAC stored in civ does not match computed MAC.");
    }

    public static a b(String str, c cVar) throws UnsupportedEncodingException, GeneralSecurityException {
        byte[] bytes = str.getBytes("UTF-8");
        c();
        byte[] bArr = new byte[16];
        new SecureRandom().nextBytes(bArr);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, cVar.a, new IvParameterSpec(bArr));
        byte[] iv = instance.getIV();
        byte[] doFinal = instance.doFinal(bytes);
        byte[] bArr2 = new byte[(iv.length + doFinal.length)];
        System.arraycopy(iv, 0, bArr2, 0, iv.length);
        System.arraycopy(doFinal, 0, bArr2, iv.length, doFinal.length);
        SecretKey secretKey = cVar.b;
        Mac instance2 = Mac.getInstance("HmacSHA256");
        instance2.init(secretKey);
        return new a(doFinal, iv, instance2.doFinal(bArr2));
    }

    public static void c() {
        AtomicBoolean atomicBoolean = a;
        if (!atomicBoolean.get()) {
            synchronized (b.class) {
                if (!atomicBoolean.get()) {
                    int i = b.a;
                    atomicBoolean.set(true);
                }
            }
        }
    }

    public static c d(String str, byte[] bArr) throws GeneralSecurityException {
        c();
        byte[] encoded = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(new PBEKeySpec(str.toCharArray(), bArr, 10000, 384)).getEncoded();
        byte[] bArr2 = new byte[16];
        System.arraycopy(encoded, 0, bArr2, 0, 16);
        byte[] bArr3 = new byte[32];
        System.arraycopy(encoded, 16, bArr3, 0, 32);
        return new c(new SecretKeySpec(bArr2, "AES"), new SecretKeySpec(bArr3, "HmacSHA256"));
    }

    public static c e(String str) throws InvalidKeyException {
        String[] split = str.split(":");
        if (split.length == 2) {
            byte[] decode = Base64.decode(split[0], 2);
            if (decode.length == 16) {
                byte[] decode2 = Base64.decode(split[1], 2);
                if (decode2.length == 32) {
                    return new c(new SecretKeySpec(decode, 0, decode.length, "AES"), new SecretKeySpec(decode2, "HmacSHA256"));
                }
                throw new InvalidKeyException("Base64 decoded key is not 256 bytes");
            }
            throw new InvalidKeyException("Base64 decoded key is not 128 bytes");
        }
        throw new IllegalArgumentException("Cannot parse aesKey:hmacKey");
    }

    /* renamed from: f0$a */
    /* compiled from: AesCbcWithIntegrity */
    public static class a {
        public final byte[] a;
        public final byte[] b;
        public final byte[] c;

        public a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            byte[] bArr4 = new byte[bArr.length];
            this.a = bArr4;
            System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
            byte[] bArr5 = new byte[bArr2.length];
            this.b = bArr5;
            System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
            byte[] bArr6 = new byte[bArr3.length];
            this.c = bArr6;
            System.arraycopy(bArr3, 0, bArr6, 0, bArr3.length);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (Arrays.equals(this.a, aVar.a) && Arrays.equals(this.b, aVar.b) && Arrays.equals(this.c, aVar.c)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int hashCode = Arrays.hashCode(this.b);
            return Arrays.hashCode(this.c) + ((hashCode + ((Arrays.hashCode(this.a) + 31) * 31)) * 31);
        }

        public final String toString() {
            String encodeToString = Base64.encodeToString(this.b, 2);
            String encodeToString2 = Base64.encodeToString(this.a, 2);
            String encodeToString3 = Base64.encodeToString(this.c, 2);
            return String.format(encodeToString + ":" + encodeToString3 + ":" + encodeToString2, new Object[0]);
        }

        public a(String str) {
            String[] split = str.split(":");
            if (split.length == 3) {
                this.b = Base64.decode(split[0], 2);
                this.c = Base64.decode(split[1], 2);
                this.a = Base64.decode(split[2], 2);
                return;
            }
            throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
        }
    }
}
