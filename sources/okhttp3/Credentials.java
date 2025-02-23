package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okio.ByteString;

public final class Credentials {
    private Credentials() {
    }

    public static String basic(String str, String str2, Charset charset) {
        String D = xx.D(str, ":", str2);
        char[] cArr = ByteString.f5629a;
        if (D == null) {
            throw new IllegalArgumentException("s == null");
        } else if (charset != null) {
            return C0709Uj.i("Basic ", new ByteString(D.getBytes(charset)).a());
        } else {
            throw new IllegalArgumentException("charset == null");
        }
    }

    public static String basic(String str, String str2) {
        return basic(str, str2, StandardCharsets.ISO_8859_1);
    }
}
