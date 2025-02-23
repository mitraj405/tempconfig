package defpackage;

import com.google.common.net.HttpHeaders;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.activities.MoreDrawerActivity;
import java.io.IOException;
import java.net.CookieManager;
import java.net.HttpCookie;
import java.util.Collections;
import java.util.List;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: nn  reason: default package and case insensitive filesystem */
/* compiled from: OAuthRequestInterceptor */
public final class C1285nn implements Interceptor {
    public final String a;

    static {
        C1354qp.R(C1285nn.class);
    }

    public C1285nn(C1223kn knVar) {
        new MoreDrawerActivity();
        this.a = knVar.getToken_type() + " " + knVar.getAccess_token();
    }

    public final Response intercept(Interceptor.Chain chain) throws IOException {
        List<HttpCookie> list;
        Response proceed;
        try {
            Request request = chain.request();
            C1228kw a2 = C1228kw.a();
            String str = "IRCTC Rail Connect/";
            if (C0535I5.f3625a) {
                str = "IRCTC Rail Connect - for RAIL SAARTHI/";
            }
            Request.Builder header = request.newBuilder().header(HttpHeaders.AUTHORIZATION, this.a).header("greq", IrctcImaApplication.c).header(HttpHeaders.USER_AGENT, str.concat("4.2.28Android")).header("mup", IrctcImaApplication.d).header("bmirak", "androidbm").header("bmiyek", Bw.e(IrctcImaApplication.a).f3534a.getString("sdflkjl", ""));
            CookieManager cookieManager = C0657Qt.f3775a;
            if (cookieManager != null) {
                list = cookieManager.getCookieStore().getCookies();
            } else {
                list = Collections.emptyList();
            }
            StringBuilder sb = new StringBuilder();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append("; ");
                }
                HttpCookie httpCookie = list.get(i);
                sb.append(httpCookie.getName());
                sb.append('=');
                sb.append(httpCookie.getValue());
            }
            Request.Builder header2 = header.header(HttpHeaders.COOKIE, sb.toString()).header(HttpHeaders.CONTENT_LANGUAGE, IrctcImaApplication.e);
            Request.Builder header3 = header2.header(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0." + C0535I5.e);
            String str2 = C0535I5.m;
            if (str2 != null && !str2.equals("")) {
                header3.header("lso", str2);
            }
            boolean J = C0535I5.J(request.url().url().toString());
            C1239le leVar = C1239le.a;
            synchronized (a2) {
                if (leVar != null) {
                    if (!(a2.b == null || a2.f5570a == null)) {
                        header3 = header3.header("dss", leVar.a());
                    }
                }
                proceed = chain.proceed(header3.method(request.method(), request.body()).build());
                String header4 = proceed.header("X-Request-For");
                if (header4 != null) {
                    a2.f5571a = header4;
                }
            }
            return proceed;
        } catch (Exception e) {
            throw e;
        }
    }
}
