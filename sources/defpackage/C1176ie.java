package defpackage;

import android.os.AsyncTask;
import android.webkit.URLUtil;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: ie  reason: default package and case insensitive filesystem */
/* compiled from: GenerateTokenAsyncTask */
public final class C1176ie extends AsyncTask<String, Void, JSONObject> {
    public final Mn a;

    /* renamed from: a  reason: collision with other field name */
    public final String f5488a;

    public C1176ie(Mn mn, String str) {
        this.f5488a = str;
        this.a = mn;
    }

    public final void a(String str, String str2) {
        try {
            URL url = new URL(str);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            if (URLUtil.isHttpsUrl(url.toString())) {
                C1354qp.D();
                C1354qp.D();
                httpsURLConnection.setSSLSocketFactory(new C1313oz());
                C1354qp.D();
            }
            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.POST);
            if (URLUtil.isHttpsUrl(url.toString())) {
                C1354qp.D();
                C1354qp.D();
                httpsURLConnection.setSSLSocketFactory(new C1313oz());
                C1354qp.D();
            }
            httpsURLConnection.setFixedLengthStreamingMode(str2.getBytes().length);
            httpsURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            PrintWriter printWriter = new PrintWriter(httpsURLConnection.getOutputStream());
            printWriter.print(str2);
            printWriter.close();
            Scanner scanner = new Scanner(httpsURLConnection.getInputStream());
            String str3 = "";
            String str4 = str3;
            while (scanner.hasNextLine()) {
                str4 = str4 + scanner.nextLine();
            }
            JSONObject jSONObject = new JSONObject(str4);
            if (jSONObject.has("TOKEN")) {
                str3 = jSONObject.getString("TOKEN");
            }
            this.a.onTokenGenerateCallback(str3);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (JSONException e3) {
            e3.printStackTrace();
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
        } catch (KeyManagementException e5) {
            e5.printStackTrace();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public final Object doInBackground(Object[] objArr) {
        String[] strArr = (String[]) objArr;
        try {
            a(C1488xu.i().concat("/HANDLER_INTERNAL/CARD_TOKEN_GENERATOR"), this.f5488a);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void onPostExecute(Object obj) {
        super.onPostExecute((JSONObject) obj);
    }
}
