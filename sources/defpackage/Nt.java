package defpackage;

import com.google.common.net.HttpHeaders;
import cris.org.in.ima.IrctcImaApplication;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: Nt  reason: default package */
/* compiled from: RestServiceFactory */
public final class Nt implements Interceptor {
    public final Response intercept(Interceptor.Chain chain) throws IOException {
        String str;
        Request request = chain.request();
        if (C0535I5.f3625a) {
            str = "IRCTC Rail Connect - for RAIL SAARTHI/";
        } else {
            str = "IRCTC Rail Connect/";
        }
        Request.Builder header = request.newBuilder().header("greq", IrctcImaApplication.c).header("mup", IrctcImaApplication.d).header("bmirak", "androidbm").header("bmiyek", Bw.e(IrctcImaApplication.a).f3534a.getString("sdflkjl", "")).header(HttpHeaders.USER_AGENT, str.concat("4.2.28Android"));
        Request.Builder method = header.header(HttpHeaders.ACCEPT_LANGUAGE, "en-US,en;q=0." + C0535I5.e).method(request.method(), request.body());
        boolean J = C0535I5.J(request.url().url().toString());
        return chain.proceed(method.build());
    }
}
