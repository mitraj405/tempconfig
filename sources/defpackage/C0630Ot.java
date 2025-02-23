package defpackage;

import com.google.common.net.HttpHeaders;
import cris.org.in.ima.IrctcImaApplication;
import java.io.IOException;
import java.util.HashMap;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: Ot  reason: default package and case insensitive filesystem */
/* compiled from: RestServiceFactory */
public final class C0630Ot implements Interceptor {
    public final Response intercept(Interceptor.Chain chain) throws IOException {
        try {
            Request request = chain.request();
            String str = "IRCTC Rail Connect/";
            if (C0535I5.f3625a) {
                str = "IRCTC Rail Connect - for RAIL SAARTHI/";
            }
            Request.Builder header = request.newBuilder().header("greq", IrctcImaApplication.c).header(HttpHeaders.USER_AGENT, str.concat("4.2.28Android")).header("mup", IrctcImaApplication.d).header("bmirak", "androidbm").header("bmiyek", Bw.e(IrctcImaApplication.a).f3534a.getString("sdflkjl", "")).header(HttpHeaders.CONTENT_LANGUAGE, IrctcImaApplication.e);
            Request.Builder header2 = header.header(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0." + C0535I5.e);
            boolean J = C0535I5.J(request.url().url().toString());
            Response proceed = chain.proceed(header2.method(request.method(), request.body()).build());
            C1228kw a = C1228kw.a();
            synchronized (a) {
                String header3 = proceed.header("X-Request-For");
                if (header3 != null) {
                    a.f5571a = header3;
                }
            }
            return proceed;
        } catch (Exception e) {
            HashMap hashMap = C0657Qt.f3776a;
            throw e;
        }
    }
}
