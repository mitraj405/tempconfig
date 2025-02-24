package okhttp3.internal.http;

import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Transmitter;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    private Request followUpRequest(Response response, Route route) throws IOException {
        String header;
        HttpUrl resolve;
        Proxy proxy;
        if (response != null) {
            int code = response.code();
            String method = response.request().method();
            RequestBody requestBody = null;
            if (code == 307 || code == 308) {
                if (!method.equals(FirebasePerformance.HttpMethod.GET) && !method.equals(FirebasePerformance.HttpMethod.HEAD)) {
                    return null;
                }
            } else if (code == 401) {
                return this.client.authenticator().authenticate(route, response);
            } else {
                if (code != 503) {
                    if (code == 407) {
                        if (route != null) {
                            proxy = route.proxy();
                        } else {
                            proxy = this.client.proxy();
                        }
                        if (proxy.type() == Proxy.Type.HTTP) {
                            return this.client.proxyAuthenticator().authenticate(route, response);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    } else if (code != 408) {
                        switch (code) {
                            case 300:
                            case 301:
                            case 302:
                            case 303:
                                break;
                            default:
                                return null;
                        }
                    } else if (!this.client.retryOnConnectionFailure()) {
                        return null;
                    } else {
                        RequestBody body = response.request().body();
                        if (body != null && body.isOneShot()) {
                            return null;
                        }
                        if ((response.priorResponse() == null || response.priorResponse().code() != 408) && retryAfter(response, 0) <= 0) {
                            return response.request();
                        }
                        return null;
                    }
                } else if ((response.priorResponse() == null || response.priorResponse().code() != 503) && retryAfter(response, Integer.MAX_VALUE) == 0) {
                    return response.request();
                } else {
                    return null;
                }
            }
            if (!this.client.followRedirects() || (header = response.header(HttpHeaders.LOCATION)) == null || (resolve = response.request().url().resolve(header)) == null) {
                return null;
            }
            if (!resolve.scheme().equals(response.request().url().scheme()) && !this.client.followSslRedirects()) {
                return null;
            }
            Request.Builder newBuilder = response.request().newBuilder();
            if (HttpMethod.permitsRequestBody(method)) {
                boolean redirectsWithBody = HttpMethod.redirectsWithBody(method);
                if (HttpMethod.redirectsToGet(method)) {
                    newBuilder.method(FirebasePerformance.HttpMethod.GET, (RequestBody) null);
                } else {
                    if (redirectsWithBody) {
                        requestBody = response.request().body();
                    }
                    newBuilder.method(method, requestBody);
                }
                if (!redirectsWithBody) {
                    newBuilder.removeHeader(HttpHeaders.TRANSFER_ENCODING);
                    newBuilder.removeHeader(HttpHeaders.CONTENT_LENGTH);
                    newBuilder.removeHeader(HttpHeaders.CONTENT_TYPE);
                }
            }
            if (!Util.sameConnection(response.request().url(), resolve)) {
                newBuilder.removeHeader(HttpHeaders.AUTHORIZATION);
            }
            return newBuilder.url(resolve).build();
        }
        throw new IllegalStateException();
    }

    private boolean isRecoverable(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean recover(IOException iOException, Transmitter transmitter, boolean z, Request request) {
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z || !requestIsOneShot(iOException, request)) && isRecoverable(iOException, z) && transmitter.canRetry()) {
            return true;
        }
        return false;
    }

    private boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody body = request.body();
        if ((body == null || !body.isOneShot()) && !(iOException instanceof FileNotFoundException)) {
            return false;
        }
        return true;
    }

    private int retryAfter(Response response, int i) {
        String header = response.header(HttpHeaders.RETRY_AFTER);
        if (header == null) {
            return i;
        }
        if (header.matches("\\d+")) {
            return Integer.valueOf(header).intValue();
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a8, code lost:
        r1.exchangeDoneDueToException();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r9) throws java.io.IOException {
        /*
            r8 = this;
            okhttp3.Request r0 = r9.request()
            okhttp3.internal.http.RealInterceptorChain r9 = (okhttp3.internal.http.RealInterceptorChain) r9
            okhttp3.internal.connection.Transmitter r1 = r9.transmitter()
            r2 = 0
            r3 = 0
            r5 = r2
            r4 = r3
        L_0x000e:
            r1.prepareToConnect(r0)
            boolean r6 = r1.isCanceled()
            if (r6 != 0) goto L_0x00b6
            okhttp3.Response r0 = r9.proceed(r0, r1, r3)     // Catch:{ RouteException -> 0x009d, IOException -> 0x008d }
            if (r4 == 0) goto L_0x0035
            okhttp3.Response$Builder r0 = r0.newBuilder()
            okhttp3.Response$Builder r4 = r4.newBuilder()
            okhttp3.Response$Builder r4 = r4.body(r3)
            okhttp3.Response r4 = r4.build()
            okhttp3.Response$Builder r0 = r0.priorResponse(r4)
            okhttp3.Response r0 = r0.build()
        L_0x0035:
            r4 = r0
            okhttp3.internal.Internal r0 = okhttp3.internal.Internal.instance
            okhttp3.internal.connection.Exchange r0 = r0.exchange(r4)
            if (r0 == 0) goto L_0x0047
            okhttp3.internal.connection.RealConnection r6 = r0.connection()
            okhttp3.Route r6 = r6.route()
            goto L_0x0048
        L_0x0047:
            r6 = r3
        L_0x0048:
            okhttp3.Request r6 = r8.followUpRequest(r4, r6)
            if (r6 != 0) goto L_0x005a
            if (r0 == 0) goto L_0x0059
            boolean r9 = r0.isDuplex()
            if (r9 == 0) goto L_0x0059
            r1.timeoutEarlyExit()
        L_0x0059:
            return r4
        L_0x005a:
            okhttp3.RequestBody r7 = r6.body()
            if (r7 == 0) goto L_0x0067
            boolean r7 = r7.isOneShot()
            if (r7 == 0) goto L_0x0067
            return r4
        L_0x0067:
            okhttp3.ResponseBody r7 = r4.body()
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r7)
            boolean r7 = r1.hasExchange()
            if (r7 == 0) goto L_0x0077
            r0.detachWithViolence()
        L_0x0077:
            int r5 = r5 + 1
            r0 = 20
            if (r5 > r0) goto L_0x007f
            r0 = r6
            goto L_0x000e
        L_0x007f:
            java.net.ProtocolException r9 = new java.net.ProtocolException
            java.lang.String r0 = "Too many follow-up requests: "
            java.lang.String r0 = defpackage.lf.h(r0, r5)
            r9.<init>(r0)
            throw r9
        L_0x008b:
            r9 = move-exception
            goto L_0x00b2
        L_0x008d:
            r6 = move-exception
            boolean r7 = r6 instanceof okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x008b }
            if (r7 != 0) goto L_0x0094
            r7 = 1
            goto L_0x0095
        L_0x0094:
            r7 = r2
        L_0x0095:
            boolean r7 = r8.recover(r6, r1, r7, r0)     // Catch:{ all -> 0x008b }
            if (r7 == 0) goto L_0x009c
            goto L_0x00a8
        L_0x009c:
            throw r6     // Catch:{ all -> 0x008b }
        L_0x009d:
            r6 = move-exception
            java.io.IOException r7 = r6.getLastConnectException()     // Catch:{ all -> 0x008b }
            boolean r7 = r8.recover(r7, r1, r2, r0)     // Catch:{ all -> 0x008b }
            if (r7 == 0) goto L_0x00ad
        L_0x00a8:
            r1.exchangeDoneDueToException()
            goto L_0x000e
        L_0x00ad:
            java.io.IOException r9 = r6.getFirstConnectException()     // Catch:{ all -> 0x008b }
            throw r9     // Catch:{ all -> 0x008b }
        L_0x00b2:
            r1.exchangeDoneDueToException()
            throw r9
        L_0x00b6:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r0 = "Canceled"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
