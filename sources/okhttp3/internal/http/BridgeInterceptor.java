package okhttp3.internal.http;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.Version;

public final class BridgeInterceptor implements Interceptor {
    private final CookieJar cookieJar;

    public BridgeInterceptor(CookieJar cookieJar2) {
        this.cookieJar = cookieJar2;
    }

    private String cookieHeader(List<Cookie> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            Cookie cookie = list.get(i);
            sb.append(cookie.name());
            sb.append('=');
            sb.append(cookie.value());
        }
        return sb.toString();
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder newBuilder = request.newBuilder();
        RequestBody body = request.body();
        if (body != null) {
            MediaType contentType = body.contentType();
            if (contentType != null) {
                newBuilder.header(HttpHeaders.CONTENT_TYPE, contentType.toString());
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                newBuilder.header(HttpHeaders.CONTENT_LENGTH, Long.toString(contentLength));
                newBuilder.removeHeader(HttpHeaders.TRANSFER_ENCODING);
            } else {
                newBuilder.header(HttpHeaders.TRANSFER_ENCODING, "chunked");
                newBuilder.removeHeader(HttpHeaders.CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (request.header(HttpHeaders.HOST) == null) {
            newBuilder.header(HttpHeaders.HOST, Util.hostHeader(request.url(), false));
        }
        if (request.header(HttpHeaders.CONNECTION) == null) {
            newBuilder.header(HttpHeaders.CONNECTION, HttpHeaders.KEEP_ALIVE);
        }
        if (request.header(HttpHeaders.ACCEPT_ENCODING) == null && request.header(HttpHeaders.RANGE) == null) {
            newBuilder.header(HttpHeaders.ACCEPT_ENCODING, "gzip");
            z = true;
        }
        List<Cookie> loadForRequest = this.cookieJar.loadForRequest(request.url());
        if (!loadForRequest.isEmpty()) {
            newBuilder.header(HttpHeaders.COOKIE, cookieHeader(loadForRequest));
        }
        if (request.header(HttpHeaders.USER_AGENT) == null) {
            newBuilder.header(HttpHeaders.USER_AGENT, Version.userAgent());
        }
        Response proceed = chain.proceed(newBuilder.build());
        HttpHeaders.receiveHeaders(this.cookieJar, request.url(), proceed.headers());
        Response.Builder request2 = proceed.newBuilder().request(request);
        if (z && "gzip".equalsIgnoreCase(proceed.header(HttpHeaders.CONTENT_ENCODING)) && HttpHeaders.hasBody(proceed)) {
            C0567Ke ke = new C0567Ke(proceed.body().source());
            request2.headers(proceed.headers().newBuilder().removeAll(HttpHeaders.CONTENT_ENCODING).removeAll(HttpHeaders.CONTENT_LENGTH).build());
            String header = proceed.header(HttpHeaders.CONTENT_TYPE);
            Logger logger = C1517zn.a;
            request2.body(new RealResponseBody(header, -1, new As(ke)));
        }
        return request2.build();
    }
}
