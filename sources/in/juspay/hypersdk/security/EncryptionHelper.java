package in.juspay.hypersdk.security;

import androidx.annotation.Keep;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import in.juspay.hyper.constants.Labels;
import in.juspay.hyper.constants.LogCategory;
import in.juspay.hyper.constants.LogSubCategory;
import in.juspay.hyper.core.EncHelper;
import in.juspay.hyper.core.JuspayLogger;
import in.juspay.hypersdk.core.PaymentConstants;
import in.juspay.hypersdk.core.SdkTracker;
import in.juspay.hypersdk.utils.Utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.crypto.spec.SecretKeySpec;

@Keep
public class EncryptionHelper extends EncHelper {
    private static final String LOG_TAG = "EncryptionHelper";
    private static final String algorithm = "AES";
    private static final byte[] logsEntryRequirement = {-52, 51, -68, -121, -44, -114, -59, -20, -79, Ascii.SYN, 34, -77, -48, -75, 45, 93};

    public static byte[] decryptThenGunzip(byte[] bArr, String str) {
        try {
            return gunzipContent(v1Decrypt(bArr));
        } catch (Exception e) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.HELPER, "Exception in decrypting", e);
            throw new RuntimeException(e);
        }
    }

    private static Key generateKey() {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(logsEntryRequirement);
            int available = byteArrayInputStream.available();
            byte[] bArr = new byte[available];
            int i = 0;
            do {
                i += byteArrayInputStream.read(bArr);
            } while (i < available);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, algorithm);
            byteArrayInputStream.close();
            return secretKeySpec;
        } catch (IOException e) {
            SdkTracker.trackAndLogBootException(LOG_TAG, PaymentConstants.Category.SDK, LogSubCategory.Action.SYSTEM, "generate_key", (String) null, e);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @Keep
    public static String getSHA256Hash(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-256");
            instance.update(str.getBytes());
            String bytesToHexString = EncHelper.bytesToHexString(instance.digest());
            String str2 = LOG_TAG;
            JuspayLogger.d(str2, "result is " + bytesToHexString);
            return bytesToHexString;
        } catch (NoSuchAlgorithmException e) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.HELPER, "Exception caught trying to SHA-256 hash", e);
            return null;
        }
    }

    public static byte[] gunzipContent(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        byte[] bArr2 = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream, UserMetadata.MAX_ATTRIBUTE_SIZE);
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            gZIPInputStream.close();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            byteArrayInputStream.close();
                            return byteArray;
                        }
                    }
                } catch (Throwable th) {
                    byteArrayOutputStream.close();
                    throw th;
                }
                throw th;
            } catch (Throwable th2) {
                byteArrayInputStream.close();
                throw th2;
            }
        } catch (IOException e) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.HELPER, "Error while gunzipping", e);
            throw new RuntimeException(e);
        } catch (Throwable th3) {
            th2.addSuppressed(th3);
        }
    }

    public static byte[] gzipThenEncrypt(byte[] bArr, RSAPublicKey rSAPublicKey) {
        try {
            String constructPayload = JOSEUtils.constructPayload(JOSEUtils.jweEncrypt(Utils.gzipContent(bArr), "{\"alg\":\"RSA-OAEP-256\",\"enc\":\"A256GCM\"}", rSAPublicKey));
            if (constructPayload != null) {
                return constructPayload.getBytes(StandardCharsets.UTF_8);
            }
            return null;
        } catch (Exception e) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.HELPER, "Exception while GZipping and encrypting", e);
            return null;
        }
    }

    public static byte[] gzipThenEncryptExp(byte[] bArr, RSAPublicKey rSAPublicKey, Map<String, String> map) {
        try {
            HashMap<String, Object> jweEncrypt = JOSEUtils.jweEncrypt(Utils.gzipContent(bArr), "{\"alg\":\"RSA-OAEP-256\",\"enc\":\"A256GCM\"}", rSAPublicKey);
            if (jweEncrypt.containsKey("headers") && jweEncrypt.containsKey("encryptedKey") && jweEncrypt.containsKey("iv") && jweEncrypt.containsKey("cipherText") && jweEncrypt.containsKey("authTag")) {
                String str = (String) jweEncrypt.get("headers");
                String str2 = (String) jweEncrypt.get("encryptedKey");
                String str3 = (String) jweEncrypt.get("iv");
                byte[] bArr2 = (byte[]) jweEncrypt.get("cipherText");
                String str4 = (String) jweEncrypt.get("authTag");
                if (!(str == null || str2 == null || str3 == null || bArr2 == null || str4 == null)) {
                    map.put("protectedHeaders", str);
                    map.put("encryptedKey", str2);
                    map.put("iv", str3);
                    map.put("authTag", str4);
                    return bArr2;
                }
            }
            return null;
        } catch (Exception e) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.HELPER, "Exception while GZipping and encrypting", e);
            return null;
        }
    }

    public static String md5(InputStream inputStream) {
        DigestInputStream digestInputStream;
        try {
            digestInputStream = new DigestInputStream(inputStream, MessageDigest.getInstance("MD5"));
            while (digestInputStream.read() != -1) {
            }
            byte[] digest = digestInputStream.getMessageDigest().digest();
            digestInputStream.close();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                StringBuilder sb2 = new StringBuilder(Integer.toHexString(b & UnsignedBytes.MAX_VALUE));
                while (sb2.length() < 2) {
                    sb2.insert(0, "0");
                }
                sb.append(sb2);
            }
            return sb.toString();
        } catch (IOException | NoSuchAlgorithmException e) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.HELPER, "Exception trying to get md5sum from input stream", e);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static byte[] v1Decrypt(byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length - 8)];
        int length = bArr.length;
        byte[] bArr3 = {bArr[9], bArr[19], bArr[29], bArr[39], bArr[49], bArr[59], bArr[69], bArr[79]};
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 % 10 != 9 || i >= 8) {
                bArr2[i2] = (byte) (bArr[i3] ^ bArr3[i2 % 8]);
                i2++;
            } else {
                i++;
            }
        }
        return bArr2;
    }

    public static byte[] v1Encrypt(byte[] bArr) {
        byte[] gzipContent = Utils.gzipContent(bArr);
        byte[] bArr2 = new byte[8];
        new SecureRandom().nextBytes(bArr2);
        int length = gzipContent.length;
        int i = length + 8;
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length && i3 < i) {
            if (i3 % 10 != 9 || i4 >= 8) {
                bArr3[i3] = (byte) (gzipContent[i2] ^ bArr2[i2 % 8]);
                i2++;
            } else {
                bArr3[i3] = bArr2[i4];
                i4++;
            }
            i3++;
        }
        return bArr3;
    }

    public static String md5(String str) {
        return md5(str.getBytes());
    }

    public static String md5(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                StringBuilder sb2 = new StringBuilder(Integer.toHexString(b & UnsignedBytes.MAX_VALUE));
                while (sb2.length() < 2) {
                    sb2.insert(0, "0");
                }
                sb.append(sb2);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            SdkTracker.trackAndLogBootException(LOG_TAG, LogCategory.ACTION, LogSubCategory.Action.SYSTEM, Labels.System.HELPER, "Exception trying to calculate md5sum from given string", e);
            return null;
        }
    }
}
