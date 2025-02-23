package cris.org.in.ima;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.sessions.settings.RemoteSettings;
import cris.org.in.ima.db.StationDb;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.security.Security;
import java.util.UUID;
import org.spongycastle.jce.provider.BouncyCastleProvider;

public class IrctcImaApplication extends Application {
    public static Context a;

    /* renamed from: a  reason: collision with other field name */
    public static FirebaseAnalytics f4146a;
    public static String c = null;
    public static String d = null;
    public static String e = "en";

    static {
        C1354qp.R(IrctcImaApplication.class);
    }

    public static String a() {
        return e;
    }

    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        C0123am.d(this);
    }

    public final void b() {
        String str;
        String str2;
        try {
            String str3 = "" + Settings.Secure.getString(getContentResolver(), "android_id");
            String[] split = new UUID((long) str3.hashCode(), (long) 0).toString().split("-");
            String[] split2 = "4.2.28".split("\\.");
            String str4 = "";
            for (int length = split.length - 1; length >= 0; length--) {
                if (length == 4) {
                    String str5 = split[length];
                    if (split2.length <= 0 || split2[0] == null) {
                        str = str5 + "0";
                    } else {
                        str = str5 + split2[0];
                    }
                } else {
                    str = "";
                }
                if (length == 3) {
                    String str6 = split[length];
                    if (split2.length <= 0 || split2[1] == null) {
                        str = str6 + "0";
                    } else {
                        str = str6 + split2[1];
                    }
                }
                if (length == 2 || length == 1 || length == 0) {
                    String str7 = split[length];
                    if (split2.length <= 0 || (str2 = split2[2]) == null || str2.length() <= length) {
                        str = str7 + "0";
                    } else {
                        str = str7 + split2[2].substring(length, length + 1);
                    }
                }
                if (str4 == "") {
                    str4 = str;
                } else {
                    str4 = str + "-" + str4;
                }
            }
            if (C0535I5.f3625a) {
                c = "ai" + str4;
            } else {
                c = "ar" + str4;
            }
            d = str3;
        } catch (SecurityException e2) {
            e2.getMessage();
            c = null;
            C0535I5.t0(a, "Application need to read phone status for unique identification. Kindly give permission.");
        } catch (Exception e3) {
            e3.getMessage();
            c = null;
            C0535I5.t0(a, "Unable to read phone status. Please try again.");
        }
    }

    public final void onCreate() {
        FileOutputStream fileOutputStream;
        super.onCreate();
        a = getApplicationContext();
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
        Bw.e(getApplicationContext());
        try {
            if (!T7.a(this)) {
                String str = "/data/data/" + getApplicationContext().getPackageName() + "/databases";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdir();
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                String str2 = T7.a;
                sb.append(str2);
                String sb2 = sb.toString();
                InputStream open = getAssets().open(str2);
                try {
                    fileOutputStream = new FileOutputStream(sb2);
                    byte[] bArr = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
                    while (true) {
                        int read = open.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    open.close();
                    fileOutputStream.close();
                    open.close();
                } catch (Throwable th) {
                    if (open != null) {
                        open.close();
                    }
                    throw th;
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        C0793b1 b1Var = C0793b1.a;
        b1Var.f3909a = new C0582Li(this);
        b1Var.f3911a = new StationDb(this);
        b1Var.f3910a = new C0735Wb(this);
        AudienceNetworkAds.initialize(a);
        MobileAds.initialize(a, new a());
        FirebaseApp.initializeApp(this);
        f4146a = FirebaseAnalytics.getInstance(a);
        try {
            b();
            AsyncTask.execute(new C1405tg());
            return;
        } catch (Exception e2) {
            e2.getMessage();
            return;
        }
        throw th;
    }

    public class a implements OnInitializationCompleteListener {
        public final void onInitializationComplete(InitializationStatus initializationStatus) {
        }
    }
}
