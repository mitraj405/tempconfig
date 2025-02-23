package defpackage;

import android.util.Base64;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import in.juspay.hyper.constants.LogLevel;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/* renamed from: Qt  reason: default package and case insensitive filesystem */
/* compiled from: RestServiceFactory */
public final class C0657Qt {
    public static ObjectMapper a;

    /* renamed from: a  reason: collision with other field name */
    public static Boolean f3773a = null;

    /* renamed from: a  reason: collision with other field name */
    public static String f3774a = null;

    /* renamed from: a  reason: collision with other field name */
    public static final CookieManager f3775a = new CookieManager();

    /* renamed from: a  reason: collision with other field name */
    public static final HashMap f3776a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public static C1211k7 f3777a;
    public static String b = null;
    public static String c = null;
    public static String d = null;

    /* renamed from: Qt$a */
    /* compiled from: RestServiceFactory */
    public class a implements HostnameVerifier {
        public final boolean verify(String str, SSLSession sSLSession) {
            if (str.endsWith("irctc.co.in") || str.endsWith("indianrail.gov.in")) {
                return true;
            }
            return false;
        }
    }

    static {
        C1354qp.R(C0657Qt.class);
    }

    public static void a() {
        f3776a.clear();
    }

    public static synchronized Object b() {
        Class cls = Om.class;
        synchronized (C0657Qt.class) {
            String concat = cls.getName().concat(":nontoken");
            C1450w1.f7005a = 2;
            HashMap hashMap = f3776a;
            if (hashMap.containsKey(concat)) {
                Object obj = hashMap.get(concat);
                return obj;
            }
            OkHttpClient.Builder n = n();
            n.addInterceptor(new C0630Ot());
            OkHttpClient build = n.build();
            Retrofit.Builder builder = new Retrofit.Builder();
            if (f3774a == null) {
                f3774a = new String(Base64.decode("aHR0cHM6Ly93d3cuY29udGVudHMuaXJjdGMuY28uaW4v", 2));
            }
            Object create = builder.baseUrl(f3774a).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(JacksonConverterFactory.create(h())).client(build).build().create(cls);
            if (create == null) {
                return null;
            }
            hashMap.put(concat, create);
            return create;
        }
    }

    public static synchronized Object c(C1223kn knVar) {
        Class cls = Om.class;
        synchronized (C0657Qt.class) {
            String concat = cls.getName().concat(":token");
            C1450w1.f7005a = 1;
            HashMap hashMap = f3776a;
            if (hashMap.containsKey(concat)) {
                Object obj = hashMap.get(concat);
                return obj;
            }
            OkHttpClient.Builder n = n();
            if (!(knVar == null || knVar.getAccess_token() == null || knVar.getToken_type() == null)) {
                n.addInterceptor(new C1285nn(knVar));
            }
            OkHttpClient build = n.build();
            Retrofit.Builder builder = new Retrofit.Builder();
            if (f3774a == null) {
                f3774a = new String(Base64.decode("aHR0cHM6Ly93d3cuY29udGVudHMuaXJjdGMuY28uaW4v", 2));
            }
            Object create = builder.baseUrl(f3774a).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(JacksonConverterFactory.create(h())).client(build).build().create(cls);
            if (create == null) {
                return null;
            }
            hashMap.put(concat, create);
            return create;
        }
    }

    public static synchronized Object d(String str, String str2) {
        Class cls = C1243ln.class;
        synchronized (C0657Qt.class) {
            String concat = cls.getName().concat(":pwd");
            HashMap hashMap = f3776a;
            if (hashMap.containsKey(concat)) {
                Object obj = hashMap.get(concat);
                return obj;
            }
            OkHttpClient.Builder n = n();
            if (!(str == null || str2 == null)) {
                n.addInterceptor(new Nt());
            }
            OkHttpClient build = n.build();
            Retrofit.Builder builder = new Retrofit.Builder();
            if (d == null) {
                d = new String(Base64.decode("aHR0cHM6Ly93d3cuY29udGVudHMuaXJjdGMuY28uaW4v", 2));
            }
            Object create = builder.baseUrl(d).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(JacksonConverterFactory.create(h())).client(build).build().create(cls);
            if (create == null) {
                return null;
            }
            hashMap.put(concat, create);
            return create;
        }
    }

    public static synchronized Object e() {
        Class cls = Om.class;
        synchronized (C0657Qt.class) {
            String concat = cls.getName().concat(":nontoken:Vikalp");
            HashMap hashMap = f3776a;
            if (hashMap.containsKey(concat)) {
                Object obj = hashMap.get(concat);
                return obj;
            }
            OkHttpClient.Builder n = n();
            n.addInterceptor(new C0644Pt());
            OkHttpClient build = n.build();
            Retrofit.Builder builder = new Retrofit.Builder();
            if (b == null) {
                b = new String(Base64.decode("aHR0cHM6Ly93d3cub3BlcmF0aW9ucy5pcmN0Yy5jby5pbi8=", 2));
            }
            Object create = builder.baseUrl(b).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(JacksonConverterFactory.create(h())).client(build).build().create(cls);
            if (create == null) {
                return null;
            }
            hashMap.put(concat, create);
            return create;
        }
    }

    public static String f() {
        return new String(Base64.decode("aHR0cHM6Ly93d3cuY29udGVudHMuaXJjdGMuY28uaW4v", 2)).concat("eticketing/protected/mapps1/");
    }

    public static String g() {
        return new String(Base64.decode("aHR0cHM6Ly93d3cuY29udGVudHMuaXJjdGMuY28uaW4v", 2)).concat("eticketing/protected/ewallet/");
    }

    public static synchronized ObjectMapper h() {
        ObjectMapper objectMapper;
        synchronized (C0657Qt.class) {
            if (a == null) {
                ObjectMapper objectMapper2 = new ObjectMapper();
                a = objectMapper2;
                objectMapper2.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
                a.configure(DeserializationFeature.ADJUST_DATES_TO_CONTEXT_TIME_ZONE, true);
                a.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, true);
                a.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                a.configure(MapperFeature.USE_ANNOTATIONS, false);
                SimpleModule simpleModule = new SimpleModule();
                simpleModule.addSerializer(C0624Oe.class.getGenericSuperclass().getClass(), new C0624Oe());
                a.registerModule(simpleModule);
                a.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
            }
            objectMapper = a;
        }
        return objectMapper;
    }

    public static String i() {
        return new String(Base64.decode("aHR0cHM6Ly93d3cuY29udGVudHMuaXJjdGMuY28uaW4v", 2)).concat("eticketing/protected/soft/");
    }

    public static String j() {
        return new String(Base64.decode("aHR0cHM6Ly93d3cuY29udGVudHMuaXJjdGMuY28uaW4v", 2)).concat("eticketing/protected/adon/");
    }

    public static String k() {
        if (c == null) {
            c = new String(Base64.decode("aHR0cHM6Ly93d3cubXBzLmlyY3RjLmNvLmluLw==", 2)).concat("eticketing/protected/mapps1/");
        }
        return c;
    }

    public static String l() {
        return new String(Base64.decode("aHR0cHM6Ly93d3cuY29udGVudHMuaXJjdGMuY28uaW4v", 2)).concat("eticketing/protected/profile/");
    }

    public static String m() {
        return new String(Base64.decode("aHR0cHM6Ly93d3cub3BlcmF0aW9ucy5pcmN0Yy5jby5pbi8=", 2)).concat("ctcan/webservices/systktservices/");
    }

    public static OkHttpClient.Builder n() {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient.Builder writeTimeout = builder.connectTimeout(600, timeUnit).readTimeout(600, timeUnit).writeTimeout(600, timeUnit);
            synchronized (C0657Qt.class) {
                if (f3777a == null) {
                    CookieManager cookieManager = f3775a;
                    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
                    f3777a = new C1211k7(cookieManager);
                }
                writeTimeout.cookieJar(f3777a);
            }
            if (r1.b == null) {
                r1.b = new r1();
            }
            r1.b.getClass();
            writeTimeout.sslSocketFactory(r1.G().getSocketFactory());
            writeTimeout.hostnameVerifier(new a());
            if (f3773a == null) {
                String lowerCase = "release".toLowerCase();
                lowerCase.getClass();
                char c2 = 65535;
                switch (lowerCase.hashCode()) {
                    case -1990759796:
                        if (lowerCase.equals("releaseDebug")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 95458899:
                        if (lowerCase.equals(LogLevel.DEBUG)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 767851224:
                        if (lowerCase.equals("stagingDebug")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                    case 1:
                    case 2:
                        f3773a = Boolean.TRUE;
                        break;
                    default:
                        f3773a = Boolean.FALSE;
                        break;
                }
            }
            if (f3773a.booleanValue()) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                writeTimeout.addNetworkInterceptor(httpLoggingInterceptor);
            }
            return writeTimeout;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } catch (Throwable th) {
            while (true) {
            }
            throw th;
        }
    }
}
