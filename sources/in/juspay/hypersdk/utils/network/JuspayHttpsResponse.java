package in.juspay.hypersdk.utils.network;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

public class JuspayHttpsResponse {
    private static final String LOG_TAG = "JuspayHttpsResponse";
    public final Map<String, List<String>> headers;
    public final int responseCode;
    public final byte[] responsePayload;

    public JuspayHttpsResponse(int i, byte[] bArr, Map<String, List<String>> map) {
        this.responseCode = i;
        this.responsePayload = bArr;
        this.headers = map;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("responseCode", this.responseCode);
            jSONObject.put("responsePayload", this.responsePayload);
            jSONObject.put("headers", this.headers);
        } catch (Exception unused) {
        }
        return jSONObject.toString();
    }

    public JuspayHttpsResponse(HttpsURLConnection httpsURLConnection) {
        GZIPInputStream gZIPInputStream;
        int responseCode2 = httpsURLConnection.getResponseCode();
        this.responseCode = responseCode2;
        this.headers = httpsURLConnection.getHeaderFields();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(((responseCode2 < 200 || responseCode2 >= 300) && responseCode2 != 302) ? httpsURLConnection.getErrorStream() : httpsURLConnection.getInputStream());
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                String contentEncoding = httpsURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equals("gzip")) {
                    byte[] bArr = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, UserMetadata.MAX_ATTRIBUTE_SIZE);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    this.responsePayload = byteArrayOutputStream.toByteArray();
                } else {
                    gZIPInputStream = new GZIPInputStream(bufferedInputStream);
                    byte[] bArr2 = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
                    while (true) {
                        int read2 = gZIPInputStream.read(bArr2);
                        if (read2 < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read2);
                    }
                    this.responsePayload = byteArrayOutputStream.toByteArray();
                    gZIPInputStream.close();
                }
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                bufferedInputStream.close();
                return;
            } catch (Throwable th) {
                byteArrayOutputStream.close();
                throw th;
            }
            throw th;
        } catch (Throwable th2) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }
}
