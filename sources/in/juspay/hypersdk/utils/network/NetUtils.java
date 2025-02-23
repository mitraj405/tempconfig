package in.juspay.hypersdk.utils.network;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import in.juspay.hypersdk.R;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

public class NetUtils {
    private static String USER_AGENT;
    private int connectionTimeout;
    private int readTimeout;
    private final boolean sslPinningRequired;
    private SSLSocketFactory sslSocketFactory;

    static {
        String property = System.getProperty("http.agent");
        USER_AGENT = property;
        if (property == null || property.length() == 0) {
            USER_AGENT = "Juspay Express Checkout Android SDK";
        }
    }

    public NetUtils(int i, int i2) {
        this(i, i2, false);
    }

    private HttpsURLConnection doGetOrHead(String str, Map<String, String> map, Map<String, String> map2, String str2, JSONObject jSONObject) {
        String generateQueryString = generateQueryString(map2);
        StringBuilder sb = new StringBuilder(str);
        if (generateQueryString.length() > 0) {
            str = C0709Uj.j(sb, "?", generateQueryString);
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
        httpsURLConnection.setRequestMethod(str2);
        setDefaultSDKHeaders(httpsURLConnection);
        setTimeouts(httpsURLConnection, jSONObject);
        if (getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(getSslSocketFactory());
        }
        if (map != null) {
            for (String next : map.keySet()) {
                httpsURLConnection.setRequestProperty(next, map.get(next));
            }
        }
        httpsURLConnection.connect();
        return httpsURLConnection;
    }

    private HttpsURLConnection initAndGetConnection(URL url) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        setDefaultSDKHeaders(httpsURLConnection);
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setReadTimeout(this.readTimeout);
        httpsURLConnection.setConnectTimeout(this.connectionTimeout);
        if (getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(getSslSocketFactory());
        }
        return httpsURLConnection;
    }

    private void setDefaultSDKHeaders(HttpsURLConnection httpsURLConnection) {
        for (Map.Entry next : getDefaultSDKHeaders().entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) next.getValue();
            if (!(str == null || str2 == null)) {
                httpsURLConnection.setRequestProperty(str, str2);
            }
        }
    }

    private void setTimeouts(HttpsURLConnection httpsURLConnection, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("connectionTimeout", -1);
        int optInt2 = jSONObject.optInt("readTimeout", -1);
        if (optInt != -1) {
            httpsURLConnection.setConnectTimeout(optInt);
        }
        if (optInt2 != -1) {
            httpsURLConnection.setReadTimeout(optInt2);
        }
    }

    public HttpsURLConnection deleteUrl(URL url, Map<String, String> map, String str, JSONObject jSONObject) {
        return doDelete(url, str.getBytes(), "application/x-www-form-urlencoded", map, jSONObject);
    }

    public HttpsURLConnection doDelete(URL url, byte[] bArr, String str, Map<String, String> map, JSONObject jSONObject) {
        HttpsURLConnection initAndGetConnection = initAndGetConnection(url);
        initAndGetConnection.setRequestMethod(FirebasePerformance.HttpMethod.DELETE);
        initAndGetConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, str);
        setTimeouts(initAndGetConnection, jSONObject);
        if (getSslSocketFactory() != null) {
            initAndGetConnection.setSSLSocketFactory(getSslSocketFactory());
        }
        if (map != null) {
            for (String next : map.keySet()) {
                initAndGetConnection.setRequestProperty(next, map.get(next));
            }
        }
        if (bArr != null) {
            OutputStream outputStream = initAndGetConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        initAndGetConnection.connect();
        return initAndGetConnection;
        throw th;
    }

    public HttpsURLConnection doGet(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject) {
        return doGetOrHead(str, map, map2, FirebasePerformance.HttpMethod.GET, jSONObject);
    }

    public HttpsURLConnection doHead(String str, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject) {
        return doGetOrHead(str, map, map2, FirebasePerformance.HttpMethod.HEAD, jSONObject);
    }

    public HttpsURLConnection doPost(URL url, byte[] bArr, String str, Map<String, String> map, JSONObject jSONObject) {
        HttpsURLConnection initAndGetConnection = initAndGetConnection(url);
        setTimeouts(initAndGetConnection, jSONObject);
        initAndGetConnection.setRequestMethod(FirebasePerformance.HttpMethod.POST);
        initAndGetConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, str);
        if (getSslSocketFactory() != null) {
            initAndGetConnection.setSSLSocketFactory(getSslSocketFactory());
        }
        if (map != null) {
            for (String next : map.keySet()) {
                initAndGetConnection.setRequestProperty(next, map.get(next));
            }
        }
        if (bArr != null) {
            OutputStream outputStream = initAndGetConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        initAndGetConnection.connect();
        return initAndGetConnection;
        throw th;
    }

    public HttpsURLConnection doPut(Context context, URL url, byte[] bArr, Map<String, String> map, NetUtils netUtils, JSONObject jSONObject) {
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        setDefaultSDKHeaders(httpsURLConnection);
        setTimeouts(httpsURLConnection, jSONObject);
        httpsURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.PUT);
        httpsURLConnection.setRequestProperty("X-App-Name", context.getString(R.string.godel_app_name));
        if (netUtils.getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(netUtils.getSslSocketFactory());
        }
        if (map != null) {
            for (String next : map.keySet()) {
                httpsURLConnection.setRequestProperty(next, map.get(next));
            }
        }
        if (bArr != null) {
            OutputStream outputStream = httpsURLConnection.getOutputStream();
            try {
                outputStream.write(bArr);
                outputStream.flush();
                outputStream.close();
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        httpsURLConnection.connect();
        return httpsURLConnection;
        throw th;
    }

    public byte[] fetchIfModified(String str, Map<String, String> map) {
        HttpsURLConnection doGet = doGet(str, map, (Map<String, String>) null, new JSONObject());
        if (doGet.getResponseCode() == 200) {
            return new JuspayHttpsResponse(doGet).responsePayload;
        }
        return null;
    }

    @Keep
    public String generateQueryString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
            }
        }
        return sb.toString();
    }

    public Map<String, String> getDefaultSDKHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.USER_AGENT, USER_AGENT);
        hashMap.put(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0.5");
        hashMap.put(HttpHeaders.X_POWERED_BY, "Juspay EC SDK for Android");
        return hashMap;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public HttpsURLConnection postForm(URL url, Map<String, String> map, JSONObject jSONObject) {
        return doPost(url, generateQueryString(map).getBytes(), "application/x-www-form-urlencoded", (Map<String, String>) null, jSONObject);
    }

    public <T> HttpsURLConnection postJson(URL url, T t, JSONObject jSONObject) {
        return doPost(url, t.toString().getBytes(), "application/json", (Map<String, String>) null, jSONObject);
    }

    public HttpsURLConnection postUrl(URL url, Map<String, String> map, String str, JSONObject jSONObject) {
        return doPost(url, str.getBytes(), "application/x-www-form-urlencoded", map, jSONObject);
    }

    public void setConnectionTimeout(int i) {
        this.connectionTimeout = i;
    }

    public void setReadTimeout(int i) {
        this.readTimeout = i;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public NetUtils(int i, int i2, boolean z) {
        this.connectionTimeout = i;
        this.readTimeout = i2;
        this.sslPinningRequired = z;
        this.sslSocketFactory = new JuspaySSLSocketFactory();
    }

    public HttpsURLConnection deleteUrl(URL url, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject) {
        return doDelete(url, generateQueryString(map2).getBytes(), "application/json", map, jSONObject);
    }

    public HttpsURLConnection postUrl(URL url, Map<String, String> map, Map<String, String> map2, JSONObject jSONObject) {
        return doPost(url, generateQueryString(map2).getBytes(), "application/json", map, jSONObject);
    }

    public HttpsURLConnection deleteUrl(URL url, Map<String, String> map, JSONObject jSONObject) {
        return doDelete(url, generateQueryString(map).getBytes(), "application/x-www-form-urlencoded", (Map<String, String>) null, jSONObject);
    }

    public HttpsURLConnection postUrl(URL url, Map<String, String> map, JSONObject jSONObject) {
        return doPost(url, generateQueryString(map).getBytes(), "application/x-www-form-urlencoded", (Map<String, String>) null, jSONObject);
    }

    public HttpsURLConnection deleteUrl(URL url, JSONObject jSONObject) {
        return doDelete(url, (byte[]) null, "application/x-www-form-urlencoded", (Map<String, String>) null, jSONObject);
    }

    public HttpsURLConnection postUrl(URL url, JSONObject jSONObject) {
        return doPost(url, (byte[]) null, "application/x-www-form-urlencoded", (Map<String, String>) null, jSONObject);
    }
}
