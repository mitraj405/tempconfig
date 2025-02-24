package okhttp3.internal.huc;

import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketPermission;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.Permission;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.JavaNetHeaders;
import okhttp3.internal.URLFilter;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.platform.Platform;
import okio.Buffer;

public final class OkHttpURLConnection extends HttpURLConnection implements Callback {
    private static final Set<String> METHODS = new LinkedHashSet(Arrays.asList(new String[]{FirebasePerformance.HttpMethod.OPTIONS, FirebasePerformance.HttpMethod.GET, FirebasePerformance.HttpMethod.HEAD, FirebasePerformance.HttpMethod.POST, FirebasePerformance.HttpMethod.PUT, FirebasePerformance.HttpMethod.DELETE, FirebasePerformance.HttpMethod.TRACE, FirebasePerformance.HttpMethod.PATCH}));
    public static final String RESPONSE_SOURCE = (Platform.get().getPrefix() + "-Response-Source");
    public static final String SELECTED_PROTOCOL = (Platform.get().getPrefix() + "-Selected-Protocol");
    Call call;
    private Throwable callFailure;
    OkHttpClient client;
    boolean connectPending;
    private boolean executed;
    private long fixedContentLength;
    Handshake handshake;
    /* access modifiers changed from: private */
    public final Object lock;
    private final NetworkInterceptor networkInterceptor;
    Response networkResponse;
    Proxy proxy;
    private Headers.Builder requestHeaders;
    private Response response;
    private Headers responseHeaders;
    URLFilter urlFilter;

    public final class NetworkInterceptor implements Interceptor {
        private boolean proceed;

        public NetworkInterceptor() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:25|26|27) */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0094, code lost:
            throw new java.io.InterruptedIOException();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0088 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public okhttp3.Response intercept(okhttp3.Interceptor.Chain r5) throws java.io.IOException {
            /*
                r4 = this;
                okhttp3.Request r0 = r5.request()
                okhttp3.internal.huc.OkHttpURLConnection r1 = okhttp3.internal.huc.OkHttpURLConnection.this
                okhttp3.internal.URLFilter r1 = r1.urlFilter
                if (r1 == 0) goto L_0x0015
                okhttp3.HttpUrl r2 = r0.url()
                java.net.URL r2 = r2.url()
                r1.checkURLPermitted(r2)
            L_0x0015:
                okhttp3.internal.huc.OkHttpURLConnection r1 = okhttp3.internal.huc.OkHttpURLConnection.this
                java.lang.Object r1 = r1.lock
                monitor-enter(r1)
                okhttp3.internal.huc.OkHttpURLConnection r2 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0095 }
                r3 = 0
                r2.connectPending = r3     // Catch:{ all -> 0x0095 }
                okhttp3.Connection r3 = r5.connection()     // Catch:{ all -> 0x0095 }
                okhttp3.Route r3 = r3.route()     // Catch:{ all -> 0x0095 }
                java.net.Proxy r3 = r3.proxy()     // Catch:{ all -> 0x0095 }
                r2.proxy = r3     // Catch:{ all -> 0x0095 }
                okhttp3.internal.huc.OkHttpURLConnection r2 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0095 }
                okhttp3.Connection r3 = r5.connection()     // Catch:{ all -> 0x0095 }
                okhttp3.Handshake r3 = r3.handshake()     // Catch:{ all -> 0x0095 }
                r2.handshake = r3     // Catch:{ all -> 0x0095 }
                okhttp3.internal.huc.OkHttpURLConnection r2 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0095 }
                java.lang.Object r2 = r2.lock     // Catch:{ all -> 0x0095 }
                r2.notifyAll()     // Catch:{ all -> 0x0095 }
            L_0x0044:
                boolean r2 = r4.proceed     // Catch:{ InterruptedException -> 0x0088 }
                if (r2 != 0) goto L_0x0052
                okhttp3.internal.huc.OkHttpURLConnection r2 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ InterruptedException -> 0x0088 }
                java.lang.Object r2 = r2.lock     // Catch:{ InterruptedException -> 0x0088 }
                r2.wait()     // Catch:{ InterruptedException -> 0x0088 }
                goto L_0x0044
            L_0x0052:
                monitor-exit(r1)     // Catch:{ all -> 0x0095 }
                okhttp3.RequestBody r1 = r0.body()
                boolean r1 = r1 instanceof okhttp3.internal.huc.OutputStreamRequestBody
                if (r1 == 0) goto L_0x0065
                okhttp3.RequestBody r1 = r0.body()
                okhttp3.internal.huc.OutputStreamRequestBody r1 = (okhttp3.internal.huc.OutputStreamRequestBody) r1
                okhttp3.Request r0 = r1.prepareToSendRequest(r0)
            L_0x0065:
                okhttp3.Response r5 = r5.proceed(r0)
                okhttp3.internal.huc.OkHttpURLConnection r0 = okhttp3.internal.huc.OkHttpURLConnection.this
                java.lang.Object r0 = r0.lock
                monitor-enter(r0)
                okhttp3.internal.huc.OkHttpURLConnection r1 = okhttp3.internal.huc.OkHttpURLConnection.this     // Catch:{ all -> 0x0085 }
                r1.networkResponse = r5     // Catch:{ all -> 0x0085 }
                okhttp3.Request r2 = r5.request()     // Catch:{ all -> 0x0085 }
                okhttp3.HttpUrl r2 = r2.url()     // Catch:{ all -> 0x0085 }
                java.net.URL r2 = r2.url()     // Catch:{ all -> 0x0085 }
                java.net.URL unused = r1.url = r2     // Catch:{ all -> 0x0085 }
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                return r5
            L_0x0085:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0085 }
                throw r5
            L_0x0088:
                java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0095 }
                r5.interrupt()     // Catch:{ all -> 0x0095 }
                java.io.InterruptedIOException r5 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0095 }
                r5.<init>()     // Catch:{ all -> 0x0095 }
                throw r5     // Catch:{ all -> 0x0095 }
            L_0x0095:
                r5 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0095 }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.huc.OkHttpURLConnection.NetworkInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
        }

        public void proceed() {
            synchronized (OkHttpURLConnection.this.lock) {
                this.proceed = true;
                OkHttpURLConnection.this.lock.notifyAll();
            }
        }
    }

    public static final class UnexpectedException extends IOException {
        static final Interceptor INTERCEPTOR = new Interceptor() {
            public Response intercept(Interceptor.Chain chain) throws IOException {
                try {
                    return chain.proceed(chain.request());
                } catch (Error | RuntimeException e) {
                    throw new UnexpectedException(e);
                }
            }
        };

        public UnexpectedException(Throwable th) {
            super(th);
        }
    }

    public OkHttpURLConnection(URL url, OkHttpClient okHttpClient) {
        super(url);
        this.networkInterceptor = new NetworkInterceptor();
        this.requestHeaders = new Headers.Builder();
        this.fixedContentLength = -1;
        this.lock = new Object();
        this.connectPending = true;
        this.client = okHttpClient;
    }

    private Call buildCall() throws IOException {
        OutputStreamRequestBody outputStreamRequestBody;
        Call call2 = this.call;
        if (call2 != null) {
            return call2;
        }
        boolean z = true;
        this.connected = true;
        if (this.doOutput) {
            if (this.method.equals(FirebasePerformance.HttpMethod.GET)) {
                this.method = FirebasePerformance.HttpMethod.POST;
            } else if (!HttpMethod.permitsRequestBody(this.method)) {
                throw new ProtocolException(C0709Uj.j(new StringBuilder(), this.method, " does not support writing"));
            }
        }
        if (this.requestHeaders.get(HttpHeaders.USER_AGENT) == null) {
            this.requestHeaders.add(HttpHeaders.USER_AGENT, defaultUserAgent());
        }
        if (HttpMethod.permitsRequestBody(this.method)) {
            if (this.requestHeaders.get(HttpHeaders.CONTENT_TYPE) == null) {
                this.requestHeaders.add(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            }
            long j = -1;
            if (this.fixedContentLength == -1 && this.chunkLength <= 0) {
                z = false;
            }
            String str = this.requestHeaders.get(HttpHeaders.CONTENT_LENGTH);
            long j2 = this.fixedContentLength;
            if (j2 != -1) {
                j = j2;
            } else if (str != null) {
                j = Long.parseLong(str);
            }
            if (z) {
                outputStreamRequestBody = new StreamedRequestBody(j);
            } else {
                outputStreamRequestBody = new BufferedRequestBody(j);
            }
            outputStreamRequestBody.timeout().timeout((long) this.client.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        } else {
            outputStreamRequestBody = null;
        }
        try {
            Request build = new Request.Builder().url(HttpUrl.get(getURL().toString())).headers(this.requestHeaders.build()).method(this.method, outputStreamRequestBody).build();
            URLFilter uRLFilter = this.urlFilter;
            if (uRLFilter != null) {
                uRLFilter.checkURLPermitted(build.url().url());
            }
            OkHttpClient.Builder newBuilder = this.client.newBuilder();
            newBuilder.interceptors().clear();
            newBuilder.interceptors().add(UnexpectedException.INTERCEPTOR);
            newBuilder.networkInterceptors().clear();
            newBuilder.networkInterceptors().add(this.networkInterceptor);
            newBuilder.dispatcher(new Dispatcher(this.client.dispatcher().executorService()));
            if (!getUseCaches()) {
                newBuilder.cache((Cache) null);
            }
            Call newCall = newBuilder.build().newCall(build);
            this.call = newCall;
            return newCall;
        } catch (IllegalArgumentException e) {
            if (Internal.instance.isInvalidHttpUrlHost(e)) {
                UnknownHostException unknownHostException = new UnknownHostException();
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
            MalformedURLException malformedURLException = new MalformedURLException();
            malformedURLException.initCause(e);
            throw malformedURLException;
        }
    }

    private String defaultUserAgent() {
        String property = System.getProperty("http.agent");
        if (property != null) {
            return toHumanReadableAscii(property);
        }
        return Version.userAgent();
    }

    private Headers getHeaders() throws IOException {
        if (this.responseHeaders == null) {
            Response response2 = getResponse(true);
            this.responseHeaders = response2.headers().newBuilder().add(SELECTED_PROTOCOL, response2.protocol().toString()).add(RESPONSE_SOURCE, responseSourceHeader(response2)).build();
        }
        return this.responseHeaders;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001b, code lost:
        r3 = buildCall();
        r2.networkInterceptor.proceed();
        r0 = (okhttp3.internal.huc.OutputStreamRequestBody) r3.request().body();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        if (r0 == null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        r0.outputStream().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        if (r2.executed == false) goto L_0x005f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        r0 = r2.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
        monitor-enter(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0040, code lost:
        if (r2.response != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0044, code lost:
        if (r2.callFailure != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0046, code lost:
        r2.lock.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        monitor-exit(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0050, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x005c, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005e, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x005f, code lost:
        r2.executed = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        onResponse(r3, r3.execute());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x006b, code lost:
        onFailure(r3, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.Response getResponse(boolean r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            okhttp3.Response r1 = r2.response     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            return r1
        L_0x0009:
            java.lang.Throwable r1 = r2.callFailure     // Catch:{ all -> 0x008a }
            if (r1 == 0) goto L_0x001a
            if (r3 == 0) goto L_0x0015
            okhttp3.Response r3 = r2.networkResponse     // Catch:{ all -> 0x008a }
            if (r3 == 0) goto L_0x0015
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            return r3
        L_0x0015:
            java.io.IOException r3 = propagate(r1)     // Catch:{ all -> 0x008a }
            throw r3     // Catch:{ all -> 0x008a }
        L_0x001a:
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            okhttp3.Call r3 = r2.buildCall()
            okhttp3.internal.huc.OkHttpURLConnection$NetworkInterceptor r0 = r2.networkInterceptor
            r0.proceed()
            okhttp3.Request r0 = r3.request()
            okhttp3.RequestBody r0 = r0.body()
            okhttp3.internal.huc.OutputStreamRequestBody r0 = (okhttp3.internal.huc.OutputStreamRequestBody) r0
            if (r0 == 0) goto L_0x0037
            java.io.OutputStream r0 = r0.outputStream()
            r0.close()
        L_0x0037:
            boolean r0 = r2.executed
            if (r0 == 0) goto L_0x005f
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
        L_0x003e:
            okhttp3.Response r3 = r2.response     // Catch:{ InterruptedException -> 0x0050 }
            if (r3 != 0) goto L_0x004c
            java.lang.Throwable r3 = r2.callFailure     // Catch:{ InterruptedException -> 0x0050 }
            if (r3 != 0) goto L_0x004c
            java.lang.Object r3 = r2.lock     // Catch:{ InterruptedException -> 0x0050 }
            r3.wait()     // Catch:{ InterruptedException -> 0x0050 }
            goto L_0x003e
        L_0x004c:
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            goto L_0x006e
        L_0x004e:
            r3 = move-exception
            goto L_0x005d
        L_0x0050:
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x004e }
            r3.interrupt()     // Catch:{ all -> 0x004e }
            java.io.InterruptedIOException r3 = new java.io.InterruptedIOException     // Catch:{ all -> 0x004e }
            r3.<init>()     // Catch:{ all -> 0x004e }
            throw r3     // Catch:{ all -> 0x004e }
        L_0x005d:
            monitor-exit(r0)     // Catch:{ all -> 0x004e }
            throw r3
        L_0x005f:
            r0 = 1
            r2.executed = r0
            okhttp3.Response r0 = r3.execute()     // Catch:{ IOException -> 0x006a }
            r2.onResponse(r3, r0)     // Catch:{ IOException -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r0 = move-exception
            r2.onFailure(r3, r0)
        L_0x006e:
            java.lang.Object r3 = r2.lock
            monitor-enter(r3)
            java.lang.Throwable r0 = r2.callFailure     // Catch:{ all -> 0x0087 }
            if (r0 != 0) goto L_0x0082
            okhttp3.Response r0 = r2.response     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x007b
            monitor-exit(r3)     // Catch:{ all -> 0x0087 }
            return r0
        L_0x007b:
            monitor-exit(r3)     // Catch:{ all -> 0x0087 }
            java.lang.AssertionError r3 = new java.lang.AssertionError
            r3.<init>()
            throw r3
        L_0x0082:
            java.io.IOException r0 = propagate(r0)     // Catch:{ all -> 0x0087 }
            throw r0     // Catch:{ all -> 0x0087 }
        L_0x0087:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0087 }
            throw r0
        L_0x008a:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008a }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.huc.OkHttpURLConnection.getResponse(boolean):okhttp3.Response");
    }

    private static IOException propagate(Throwable th) throws IOException {
        if (th instanceof IOException) {
            throw ((IOException) th);
        } else if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw new AssertionError();
        }
    }

    private static String responseSourceHeader(Response response2) {
        if (response2.networkResponse() == null) {
            if (response2.cacheResponse() == null) {
                return "NONE";
            }
            return "CACHE " + response2.code();
        } else if (response2.cacheResponse() == null) {
            return "NETWORK " + response2.code();
        } else {
            return "CONDITIONAL_CACHE " + response2.networkResponse().code();
        }
    }

    private static String toHumanReadableAscii(String str) {
        int i;
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt <= 31 || codePointAt >= 127) {
                Buffer buffer = new Buffer();
                buffer.O(0, i2, str);
                buffer.Q(63);
                int charCount = Character.charCount(codePointAt) + i2;
                while (charCount < length) {
                    int codePointAt2 = str.codePointAt(charCount);
                    if (codePointAt2 <= 31 || codePointAt2 >= 127) {
                        i = 63;
                    } else {
                        i = codePointAt2;
                    }
                    buffer.Q(i);
                    charCount += Character.charCount(codePointAt2);
                }
                return buffer.r();
            }
            i2 += Character.charCount(codePointAt);
        }
        return str;
    }

    public void addRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot add request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            Platform.get().log(5, lf.j("Ignoring header ", str, " because its value was null."), (Throwable) null);
        } else {
            this.requestHeaders.add(str, str2);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:22|23|24) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003d, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0031 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect() throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r2.executed
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            okhttp3.Call r0 = r2.buildCall()
            r1 = 1
            r2.executed = r1
            r0.enqueue(r2)
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
        L_0x0012:
            boolean r1 = r2.connectPending     // Catch:{ InterruptedException -> 0x0031 }
            if (r1 == 0) goto L_0x0024
            okhttp3.Response r1 = r2.response     // Catch:{ InterruptedException -> 0x0031 }
            if (r1 != 0) goto L_0x0024
            java.lang.Throwable r1 = r2.callFailure     // Catch:{ InterruptedException -> 0x0031 }
            if (r1 != 0) goto L_0x0024
            java.lang.Object r1 = r2.lock     // Catch:{ InterruptedException -> 0x0031 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0031 }
            goto L_0x0012
        L_0x0024:
            java.lang.Throwable r1 = r2.callFailure     // Catch:{ InterruptedException -> 0x0031 }
            if (r1 != 0) goto L_0x002a
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x002a:
            java.io.IOException r1 = propagate(r1)     // Catch:{ InterruptedException -> 0x0031 }
            throw r1     // Catch:{ InterruptedException -> 0x0031 }
        L_0x002f:
            r1 = move-exception
            goto L_0x003e
        L_0x0031:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002f }
            r1.interrupt()     // Catch:{ all -> 0x002f }
            java.io.InterruptedIOException r1 = new java.io.InterruptedIOException     // Catch:{ all -> 0x002f }
            r1.<init>()     // Catch:{ all -> 0x002f }
            throw r1     // Catch:{ all -> 0x002f }
        L_0x003e:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.huc.OkHttpURLConnection.connect():void");
    }

    public void disconnect() {
        if (this.call != null) {
            this.networkInterceptor.proceed();
            this.call.cancel();
        }
    }

    public int getConnectTimeout() {
        return this.client.connectTimeoutMillis();
    }

    public InputStream getErrorStream() {
        try {
            Response response2 = getResponse(true);
            if (okhttp3.internal.http.HttpHeaders.hasBody(response2) && response2.code() >= 400) {
                return response2.body().byteStream();
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public String getHeaderField(int i) {
        try {
            Headers headers = getHeaders();
            if (i >= 0) {
                if (i < headers.size()) {
                    return headers.value(i);
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public String getHeaderFieldKey(int i) {
        try {
            Headers headers = getHeaders();
            if (i >= 0) {
                if (i < headers.size()) {
                    return headers.name(i);
                }
            }
        } catch (IOException unused) {
        }
        return null;
    }

    public Map<String, List<String>> getHeaderFields() {
        try {
            return JavaNetHeaders.toMultimap(getHeaders(), StatusLine.get(getResponse(true)).toString());
        } catch (IOException unused) {
            return Collections.emptyMap();
        }
    }

    public InputStream getInputStream() throws IOException {
        if (this.doInput) {
            Response response2 = getResponse(false);
            if (response2.code() < 400) {
                return response2.body().byteStream();
            }
            throw new FileNotFoundException(this.url.toString());
        }
        throw new ProtocolException("This protocol does not support input");
    }

    public boolean getInstanceFollowRedirects() {
        return this.client.followRedirects();
    }

    public OutputStream getOutputStream() throws IOException {
        OutputStreamRequestBody outputStreamRequestBody = (OutputStreamRequestBody) buildCall().request().body();
        if (outputStreamRequestBody != null) {
            if (outputStreamRequestBody instanceof StreamedRequestBody) {
                connect();
                this.networkInterceptor.proceed();
            }
            if (!outputStreamRequestBody.isClosed()) {
                return outputStreamRequestBody.outputStream();
            }
            throw new ProtocolException("cannot write request body after response has been read");
        }
        throw new ProtocolException("method does not support a request body: " + this.method);
    }

    public Permission getPermission() throws IOException {
        int i;
        URL url = getURL();
        String host = url.getHost();
        if (url.getPort() != -1) {
            i = url.getPort();
        } else {
            i = HttpUrl.defaultPort(url.getProtocol());
        }
        if (usingProxy()) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) this.client.proxy().address();
            host = inetSocketAddress.getHostName();
            i = inetSocketAddress.getPort();
        }
        return new SocketPermission(host + ":" + i, "connect, resolve");
    }

    public int getReadTimeout() {
        return this.client.readTimeoutMillis();
    }

    public Map<String, List<String>> getRequestProperties() {
        if (!this.connected) {
            return JavaNetHeaders.toMultimap(this.requestHeaders.build(), (String) null);
        }
        throw new IllegalStateException("Cannot access request header fields after connection is set");
    }

    public String getRequestProperty(String str) {
        if (str == null) {
            return null;
        }
        return this.requestHeaders.get(str);
    }

    public int getResponseCode() throws IOException {
        return getResponse(true).code();
    }

    public String getResponseMessage() throws IOException {
        return getResponse(true).message();
    }

    public void onFailure(Call call2, IOException iOException) {
        synchronized (this.lock) {
            boolean z = iOException instanceof UnexpectedException;
            Throwable th = iOException;
            if (z) {
                th = iOException.getCause();
            }
            this.callFailure = th;
            this.lock.notifyAll();
        }
    }

    public void onResponse(Call call2, Response response2) {
        synchronized (this.lock) {
            this.response = response2;
            this.handshake = response2.handshake();
            this.url = response2.request().url().url();
            this.lock.notifyAll();
        }
    }

    public void setConnectTimeout(int i) {
        this.client = this.client.newBuilder().connectTimeout((long) i, TimeUnit.MILLISECONDS).build();
    }

    public void setFixedLengthStreamingMode(int i) {
        setFixedLengthStreamingMode((long) i);
    }

    public void setIfModifiedSince(long j) {
        super.setIfModifiedSince(j);
        if (this.ifModifiedSince != 0) {
            this.requestHeaders.set(HttpHeaders.IF_MODIFIED_SINCE, HttpDate.format(new Date(this.ifModifiedSince)));
        } else {
            this.requestHeaders.removeAll(HttpHeaders.IF_MODIFIED_SINCE);
        }
    }

    public void setInstanceFollowRedirects(boolean z) {
        this.client = this.client.newBuilder().followRedirects(z).build();
    }

    public void setReadTimeout(int i) {
        this.client = this.client.newBuilder().readTimeout((long) i, TimeUnit.MILLISECONDS).build();
    }

    public void setRequestMethod(String str) throws ProtocolException {
        Set<String> set = METHODS;
        if (set.contains(str)) {
            this.method = str;
            return;
        }
        throw new ProtocolException("Expected one of " + set + " but was " + str);
    }

    public void setRequestProperty(String str, String str2) {
        if (this.connected) {
            throw new IllegalStateException("Cannot set request property after connection is made");
        } else if (str == null) {
            throw new NullPointerException("field == null");
        } else if (str2 == null) {
            Platform.get().log(5, lf.j("Ignoring header ", str, " because its value was null."), (Throwable) null);
        } else {
            this.requestHeaders.set(str, str2);
        }
    }

    public boolean usingProxy() {
        if (this.proxy != null) {
            return true;
        }
        Proxy proxy2 = this.client.proxy();
        if (proxy2 == null || proxy2.type() == Proxy.Type.DIRECT) {
            return false;
        }
        return true;
    }

    public void setFixedLengthStreamingMode(long j) {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        } else if (this.chunkLength > 0) {
            throw new IllegalStateException("Already in chunked mode");
        } else if (j >= 0) {
            this.fixedContentLength = j;
            this.fixedContentLength = (int) Math.min(j, 2147483647L);
        } else {
            throw new IllegalArgumentException("contentLength < 0");
        }
    }

    public String getHeaderField(String str) {
        if (str != null) {
            return getHeaders().get(str);
        }
        try {
            return StatusLine.get(getResponse(true)).toString();
        } catch (IOException unused) {
            return null;
        }
    }

    public OkHttpURLConnection(URL url, OkHttpClient okHttpClient, URLFilter uRLFilter) {
        this(url, okHttpClient);
        this.urlFilter = uRLFilter;
    }
}
