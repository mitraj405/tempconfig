package com.paytm.easypay;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.webkit.URLUtil;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class EasypayLoaderService extends IntentService {
    public SharedPreferences.Editor a;

    /* renamed from: a  reason: collision with other field name */
    public SharedPreferences f4093a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f4094a;
    public SharedPreferences.Editor b;

    /* renamed from: b  reason: collision with other field name */
    public SharedPreferences f4095b;

    public EasypayLoaderService() {
        super("EasypayLoaderService");
    }

    public final boolean a(String str) {
        try {
            URL url = new URL(str);
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            if (URLUtil.isHttpsUrl(url.toString())) {
                synchronized (C1354qp.class) {
                }
                synchronized (C1354qp.class) {
                }
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new C1313oz());
                synchronized (C1354qp.class) {
                }
            }
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.setConnectTimeout(20000);
            httpURLConnection.setRequestMethod(FirebasePerformance.HttpMethod.GET);
            String string = this.f4095b.getString("ETAGValue", "0");
            long j = this.f4095b.getLong("LastRequestTimestamp", 0);
            long currentTimeMillis = System.currentTimeMillis();
            httpURLConnection.setRequestProperty(HttpHeaders.IF_NONE_MATCH, string);
            httpURLConnection.connect();
            this.a.putString("ETAGValue", httpURLConnection.getHeaderField(HttpHeaders.ETAG));
            this.a.commit();
            int responseCode = httpURLConnection.getResponseCode();
            if (currentTimeMillis >= j + 86400000) {
                if (responseCode != 304) {
                    this.a.putLong("LastRequestTimestamp", currentTimeMillis);
                    this.a.commit();
                    BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream(), 5120);
                    File file = new File(getApplicationContext().getFilesDir() + "/easypay_configuration.json");
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[5120];
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream.write(bArr, 0, read);
                        } else {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            bufferedInputStream.close();
                            Intent intent = new Intent();
                            intent.setAction("com.drc.paytm_example.EASYPAY_CONFIG_DOWNLOADED");
                            sendBroadcast(intent);
                            return true;
                        }
                    }
                }
            }
            Intent intent2 = new Intent();
            intent2.setAction("com.drc.paytm_example.EASYPAY_CONFIG_DOWNLOADED");
            sendBroadcast(intent2);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final void onHandleIntent(Intent intent) {
        this.f4093a = getSharedPreferences("com.paytm.easypay.PREFERENCE_FILE_KEY", 0);
        SharedPreferences sharedPreferences = getSharedPreferences("ETAGPreference", 0);
        this.f4095b = sharedPreferences;
        this.a = sharedPreferences.edit();
        this.b = this.f4093a.edit();
        boolean booleanExtra = intent.getBooleanExtra("enableEasyPay", false);
        this.f4094a = booleanExtra;
        this.b.putBoolean("enableEasyPay", booleanExtra);
        this.b.commit();
        if (this.f4094a) {
            if (System.currentTimeMillis() - Long.valueOf(this.f4093a.getLong("easypay_configuration_load_timestamp", 0)).longValue() > Long.valueOf(this.f4093a.getLong("easypay_configuration_ttl", 0)).longValue()) {
                try {
                    if (Boolean.valueOf(a("http://easypay.paytm.in/easyPayWeb/paytmAssist.json" + ("?" + ("JsonData={\"MID\":\"" + this.f4093a.getString("merchant_mid", "") + "\"}")))).booleanValue()) {
                        SharedPreferences.Editor edit = getSharedPreferences("com.paytm.easypay.PREFERENCE_FILE_KEY", 0).edit();
                        edit.putLong("easypay_configuration_load_timestamp", System.currentTimeMillis());
                        edit.commit();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }
}
