package in.juspay.hypersdk.security;

import in.juspay.hypersdk.core.PaymentConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

public class JOSEUtils {
    public static RSAPublicKey JWKtoRSAPublicKey(JSONObject jSONObject) {
        return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, Base64Codec.decode(jSONObject.getString("n"))), new BigInteger(1, Base64Codec.decode(jSONObject.getString("e")))));
    }

    public static void assertIfMatches(String str, String str2) {
        if (!str.equals(str2)) {
            throw new Exception("Assert failed, org=" + str + ", expected=" + str2);
        }
    }

    public static void assertIfSupportedEncAlg(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1868738169:
                if (str.equals("RSA1_5")) {
                    c = 0;
                    break;
                }
                break;
            case -890830960:
                if (str.equals("RSA-OAEP-256")) {
                    c = 1;
                    break;
                }
                break;
            case -565207670:
                if (str.equals("RSA-OAEP")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                return;
            default:
                throw new Exception("Not supported signing alg ".concat(str));
        }
    }

    public static void assertIfSupportedSigningAlg(String str) {
        str.getClass();
        if (!str.equals("RS256") && !str.equals("RS512")) {
            throw new Exception("Not supported signing alg ".concat(str));
        }
    }

    public static byte[] concat(byte[]... bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            for (byte[] bArr2 : bArr) {
                if (bArr2 != null) {
                    byteArrayOutputStream.write(bArr2);
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static String constructPayload(HashMap<String, Object> hashMap) {
        if (!hashMap.containsKey("headers") || !hashMap.containsKey("encryptedKey") || !hashMap.containsKey("iv") || !hashMap.containsKey("cipherText") || !hashMap.containsKey("authTag")) {
            return null;
        }
        String str = (String) hashMap.get("headers");
        String str2 = (String) hashMap.get("encryptedKey");
        String str3 = (String) hashMap.get("iv");
        byte[] bArr = (byte[]) hashMap.get("cipherText");
        String str4 = (String) hashMap.get("authTag");
        if (str == null || str2 == null || str3 == null || bArr == null || str4 == null) {
            return null;
        }
        return str + "." + str2 + "." + str3 + "." + Base64Codec.encodeToString(bArr, true) + "." + str4;
    }

    public static String extractKey(String str, String str2) {
        JSONObject jSONObject = new JSONObject(str2);
        if (jSONObject.has(str)) {
            return jSONObject.getString(str);
        }
        throw new Exception(C0709Uj.i("JWS Sign - header missing ", str));
    }

    public static String getJavaAlg(String str) {
        str.getClass();
        char c = 65535;
        switch (str.hashCode()) {
            case -1868738169:
                if (str.equals("RSA1_5")) {
                    c = 0;
                    break;
                }
                break;
            case -890830960:
                if (str.equals("RSA-OAEP-256")) {
                    c = 1;
                    break;
                }
                break;
            case -565207670:
                if (str.equals("RSA-OAEP")) {
                    c = 2;
                    break;
                }
                break;
            case 78251122:
                if (str.equals("RS256")) {
                    c = 3;
                    break;
                }
                break;
            case 78253877:
                if (str.equals("RS512")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "RSA/ECB/PKCS1Padding";
            case 1:
                return "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
            case 2:
                return "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
            case 3:
                return "SHA256withRSA";
            case 4:
                return "SHA512withRSA";
            default:
                throw new Exception("Not supported signing alg ".concat(str));
        }
    }

    public static JSONObject jweDecrypt(String str, PrivateKey privateKey) {
        GCMParameterSpec gCMParameterSpec;
        String[] split = str.split("\\.");
        String str2 = new String(Base64Codec.decode(split[0]));
        String extractKey = extractKey("alg", str2);
        assertIfSupportedEncAlg(extractKey);
        assertIfMatches(extractKey("enc", str2), "A256GCM");
        new SecureRandom().nextBytes(new byte[2048]);
        String str3 = split[1];
        Cipher instance = Cipher.getInstance(getJavaAlg(extractKey));
        instance.init(2, privateKey);
        SecretKeySpec secretKeySpec = new SecretKeySpec(instance.doFinal(Base64Codec.decode(str3)), "AES");
        byte[] bytes = Base64Codec.encodeToString(str2.getBytes(StandardCharsets.UTF_8), true).getBytes(StandardCharsets.US_ASCII);
        SecretKeySpec secretKeySpec2 = new SecretKeySpec(secretKeySpec.getEncoded(), "AES");
        Cipher instance2 = Cipher.getInstance("AES/GCM/NoPadding");
        try {
            gCMParameterSpec = new GCMParameterSpec(128, Base64Codec.decode(split[2]));
        } catch (Exception unused) {
            gCMParameterSpec = new GCMParameterSpec(128, Base64Codec.decode(split[2]));
        }
        instance2.init(2, secretKeySpec2, gCMParameterSpec);
        instance2.updateAAD(bytes);
        byte[] doFinal = instance2.doFinal(concat(Base64Codec.decode(split[3]), Base64Codec.decode(split[4])));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("headers", str2);
        jSONObject.put(PaymentConstants.PAYLOAD, new String(doFinal));
        return jSONObject;
    }

    public static String jweEncrypt(String str, String str2, byte[] bArr) {
        return constructPayload(jweEncrypt(str.getBytes(StandardCharsets.UTF_8), str2, (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr))));
    }

    public static String jwsSign(String str, String str2, PrivateKey privateKey) {
        String str3 = Base64Codec.encodeToString(str2.getBytes(StandardCharsets.UTF_8), true) + "." + Base64Codec.encodeToString(str.getBytes(StandardCharsets.UTF_8), true);
        String extractKey = extractKey("alg", str2);
        assertIfSupportedSigningAlg(extractKey);
        Signature instance = Signature.getInstance(getJavaAlg(extractKey));
        instance.initSign(privateKey);
        instance.update(str3.getBytes(StandardCharsets.UTF_8));
        byte[] sign = instance.sign();
        StringBuilder n = lf.n(str3, ".");
        n.append(Base64Codec.encodeToString(sign, true));
        return n.toString();
    }

    public static boolean jwsVerify(String str, byte[] bArr) {
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        String[] split = str.split("\\.");
        if (split.length == 3) {
            String extractKey = extractKey("alg", new String(Base64Codec.decode(split[0])));
            assertIfSupportedSigningAlg(extractKey);
            Signature instance = Signature.getInstance(getJavaAlg(extractKey));
            instance.initVerify(rSAPublicKey);
            instance.update((split[0] + "." + split[1]).getBytes(StandardCharsets.UTF_8));
            return instance.verify(Base64Codec.decode(split[2]));
        }
        throw new Exception("JWS Verify - mandatory params missing " + split.length);
    }

    public static byte[] subArray(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public static HashMap<String, Object> jweEncrypt(byte[] bArr, String str, RSAPublicKey rSAPublicKey) {
        GCMParameterSpec gCMParameterSpec;
        byte[] bArr2;
        Class cls = GCMParameterSpec.class;
        String extractKey = extractKey("alg", str);
        assertIfSupportedEncAlg(extractKey);
        assertIfMatches(extractKey("enc", str), "A256GCM");
        byte[] bArr3 = new byte[32];
        new SecureRandom().nextBytes(bArr3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, "AES");
        Cipher instance = Cipher.getInstance(getJavaAlg(extractKey));
        instance.init(1, rSAPublicKey);
        String encodeToString = Base64Codec.encodeToString(instance.doFinal(secretKeySpec.getEncoded()), true);
        byte[] bytes = Base64Codec.encodeToString(str.getBytes(StandardCharsets.UTF_8), true).getBytes(StandardCharsets.US_ASCII);
        byte[] bArr4 = new byte[12];
        new SecureRandom().nextBytes(bArr4);
        Cipher instance2 = Cipher.getInstance("AES/GCM/NoPadding");
        try {
            gCMParameterSpec = new GCMParameterSpec(128, bArr4);
        } catch (Exception unused) {
            gCMParameterSpec = new GCMParameterSpec(128, bArr4);
        }
        instance2.init(1, secretKeySpec, gCMParameterSpec);
        instance2.updateAAD(bytes);
        byte[] doFinal = instance2.doFinal(bArr);
        int length = doFinal.length - 16;
        byte[] subArray = subArray(doFinal, 0, length);
        byte[] subArray2 = subArray(doFinal, length, 16);
        try {
            bArr2 = ((GCMParameterSpec) instance2.getParameters().getParameterSpec(cls)).getIV();
        } catch (Exception unused2) {
            bArr2 = ((GCMParameterSpec) instance2.getParameters().getParameterSpec(cls)).getIV();
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("encryptedKey", encodeToString);
        hashMap.put("iv", Base64Codec.encodeToString(bArr2, true));
        hashMap.put("cipherText", subArray);
        hashMap.put("authTag", Base64Codec.encodeToString(subArray2, true));
        hashMap.put("headers", Base64Codec.encodeToString(str.getBytes(StandardCharsets.UTF_8), true));
        return hashMap;
    }
}
