package in.juspay.hyper.core;

import com.google.common.primitives.UnsignedBytes;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.PrivateKey;

public class EncHelper {
    public static String bytesToHexString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UnsignedBytes.MAX_VALUE);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static KeyStore getAndroidKeyStore() throws Exception {
        KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
        instance.load((KeyStore.LoadStoreParameter) null);
        return instance;
    }

    public static KeyPair getKeyPair(String str) throws Exception {
        KeyStore androidKeyStore = getAndroidKeyStore();
        return new KeyPair(androidKeyStore.getCertificate(str).getPublicKey(), (PrivateKey) androidKeyStore.getKey(str, (char[]) null));
    }
}
