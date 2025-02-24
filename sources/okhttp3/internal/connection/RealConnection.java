package okhttp3.internal.connection;

import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.FirebasePerformance;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.Version;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;

public final class RealConnection extends Http2Connection.Listener implements Connection {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit = 1;
    public final RealConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    long idleAtNanos = Long.MAX_VALUE;
    boolean noNewExchanges;
    private Protocol protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    int routeFailureCount;
    private BufferedSink sink;
    private Socket socket;
    private BufferedSource source;
    int successCount;
    final List<Reference<Transmitter>> transmitters = new ArrayList();

    public RealConnection(RealConnectionPool realConnectionPool, Route route2) {
        this.connectionPool = realConnectionPool;
        this.route = route2;
    }

    private void connectSocket(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket socket2;
        Proxy proxy = this.route.proxy();
        Address address = this.route.address();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) {
            socket2 = address.socketFactory().createSocket();
        } else {
            socket2 = new Socket(proxy);
        }
        this.rawSocket = socket2;
        eventListener.connectStart(call, this.route.socketAddress(), proxy);
        this.rawSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.socketAddress(), i);
            try {
                this.source = new As(C1517zn.c(this.rawSocket));
                this.sink = new C1519zs(C1517zn.a(this.rawSocket));
            } catch (NullPointerException e) {
                if (NPE_THROW_WITH_NULL.equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.socketAddress());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0131 A[Catch:{ all -> 0x0128 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0137 A[Catch:{ all -> 0x0128 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x013a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void connectTls(okhttp3.internal.connection.ConnectionSpecSelector r8) throws java.io.IOException {
        /*
            r7 = this;
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address()
            javax.net.ssl.SSLSocketFactory r1 = r0.sslSocketFactory()
            r2 = 0
            java.net.Socket r3 = r7.rawSocket     // Catch:{ AssertionError -> 0x012a }
            okhttp3.HttpUrl r4 = r0.url()     // Catch:{ AssertionError -> 0x012a }
            java.lang.String r4 = r4.host()     // Catch:{ AssertionError -> 0x012a }
            okhttp3.HttpUrl r5 = r0.url()     // Catch:{ AssertionError -> 0x012a }
            int r5 = r5.port()     // Catch:{ AssertionError -> 0x012a }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x012a }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x012a }
            okhttp3.ConnectionSpec r8 = r8.configureSecureSocket(r1)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            boolean r3 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            if (r3 == 0) goto L_0x0041
            okhttp3.internal.platform.Platform r3 = okhttp3.internal.platform.Platform.get()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            okhttp3.HttpUrl r4 = r0.url()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r4 = r4.host()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.util.List r5 = r0.protocols()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r3.configureTlsExtensions(r1, r4, r5)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
        L_0x0041:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            okhttp3.Handshake r4 = okhttp3.Handshake.get(r3)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            javax.net.ssl.HostnameVerifier r5 = r0.hostnameVerifier()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            okhttp3.HttpUrl r6 = r0.url()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r6 = r6.host()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            if (r3 != 0) goto L_0x00d2
            java.util.List r8 = r4.peerCertificates()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            boolean r2 = r8.isEmpty()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r3 = "Hostname "
            if (r2 != 0) goto L_0x00b3
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r4.<init>(r3)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r0 = okhttp3.CertificatePinner.pin(r8)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r0 = "\n    DN: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.util.List r8 = okhttp3.internal.tls.OkHostnameVerifier.allSubjectAltNames(r8)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r4.append(r8)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r8 = r4.toString()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            throw r2     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
        L_0x00b3:
            javax.net.ssl.SSLPeerUnverifiedException r8 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r2.<init>(r3)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r2.append(r0)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r0 = " not verified (no certificates)"
            r2.append(r0)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r0 = r2.toString()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r8.<init>(r0)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            throw r8     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
        L_0x00d2:
            okhttp3.CertificatePinner r3 = r0.certificatePinner()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.util.List r5 = r4.peerCertificates()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r3.check((java.lang.String) r0, (java.util.List<java.security.cert.Certificate>) r5)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            boolean r8 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            if (r8 == 0) goto L_0x00f3
            okhttp3.internal.platform.Platform r8 = okhttp3.internal.platform.Platform.get()     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.lang.String r2 = r8.getSelectedProtocol(r1)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
        L_0x00f3:
            r7.socket = r1     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            okio.Source r8 = defpackage.C1517zn.c(r1)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            As r0 = new As     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r0.<init>(r8)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r7.source = r0     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            java.net.Socket r8 = r7.socket     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            okio.Sink r8 = defpackage.C1517zn.a(r8)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            zs r0 = new zs     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r0.<init>(r8)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r7.sink = r0     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            r7.handshake = r4     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            if (r2 == 0) goto L_0x0116
            okhttp3.Protocol r8 = okhttp3.Protocol.get(r2)     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            goto L_0x0118
        L_0x0116:
            okhttp3.Protocol r8 = okhttp3.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
        L_0x0118:
            r7.protocol = r8     // Catch:{ AssertionError -> 0x0125, all -> 0x0122 }
            okhttp3.internal.platform.Platform r8 = okhttp3.internal.platform.Platform.get()
            r8.afterHandshake(r1)
            return
        L_0x0122:
            r8 = move-exception
            r2 = r1
            goto L_0x0138
        L_0x0125:
            r8 = move-exception
            r2 = r1
            goto L_0x012b
        L_0x0128:
            r8 = move-exception
            goto L_0x0138
        L_0x012a:
            r8 = move-exception
        L_0x012b:
            boolean r0 = okhttp3.internal.Util.isAndroidGetsocknameError(r8)     // Catch:{ all -> 0x0128 }
            if (r0 == 0) goto L_0x0137
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0128 }
            r0.<init>(r8)     // Catch:{ all -> 0x0128 }
            throw r0     // Catch:{ all -> 0x0128 }
        L_0x0137:
            throw r8     // Catch:{ all -> 0x0128 }
        L_0x0138:
            if (r2 == 0) goto L_0x0141
            okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Platform.get()
            r0.afterHandshake(r2)
        L_0x0141:
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connectTls(okhttp3.internal.connection.ConnectionSpecSelector):void");
    }

    private void connectTunnel(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i4 = 0;
        while (i4 < 21) {
            connectSocket(i, i2, call, eventListener);
            createTunnelRequest = createTunnel(i2, i3, createTunnelRequest, url);
            if (createTunnelRequest != null) {
                Util.closeQuietly(this.rawSocket);
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), (Protocol) null);
                i4++;
            } else {
                return;
            }
        }
    }

    private Request createTunnel(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec((OkHttpClient) null, (RealConnection) null, this.source, this.sink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.source.timeout().timeout((long) i, timeUnit);
            this.sink.timeout().timeout((long) i2, timeUnit);
            http1ExchangeCodec.writeRequest(request.headers(), str);
            http1ExchangeCodec.finishRequest();
            Response build = http1ExchangeCodec.readResponseHeaders(false).request(request).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(build.header(HttpHeaders.CONNECTION))) {
                        return authenticate;
                    } else {
                        request = authenticate;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
            } else if (this.source.x().h0() && this.sink.d().h0()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private Request createTunnelRequest() throws IOException {
        Request build = new Request.Builder().url(this.route.address().url()).method(FirebasePerformance.HttpMethod.CONNECT, (RequestBody) null).header(HttpHeaders.HOST, Util.hostHeader(this.route.address().url(), true)).header("Proxy-Connection", HttpHeaders.KEEP_ALIVE).header(HttpHeaders.USER_AGENT, Version.userAgent()).build();
        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header(HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive").build());
        if (authenticate != null) {
            return authenticate;
        }
        return build;
    }

    private void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() == null) {
            List<Protocol> protocols = this.route.address().protocols();
            Protocol protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (protocols.contains(protocol2)) {
                this.socket = this.rawSocket;
                this.protocol = protocol2;
                startHttp2(i);
                return;
            }
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
            return;
        }
        eventListener.secureConnectStart(call);
        connectTls(connectionSpecSelector);
        eventListener.secureConnectEnd(call, this.handshake);
        if (this.protocol == Protocol.HTTP_2) {
            startHttp2(i);
        }
    }

    private boolean routeMatchesAny(List<Route> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Route route2 = list.get(i);
            if (route2.proxy().type() == Proxy.Type.DIRECT && this.route.proxy().type() == Proxy.Type.DIRECT && this.route.socketAddress().equals(route2.socketAddress())) {
                return true;
            }
        }
        return false;
    }

    private void startHttp2(int i) throws IOException {
        this.socket.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true).socket(this.socket, this.route.address().url().host(), this.source, this.sink).listener(this).pingIntervalMillis(i).build();
        this.http2Connection = build;
        build.start();
    }

    public static RealConnection testConnection(RealConnectionPool realConnectionPool, Route route2, Socket socket2, long j) {
        RealConnection realConnection = new RealConnection(realConnectionPool, route2);
        realConnection.socket = socket2;
        realConnection.idleAtNanos = j;
        return realConnection;
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0082 A[Catch:{ IOException -> 0x00ed }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            okhttp3.Protocol r0 = r7.protocol
            if (r0 != 0) goto L_0x0143
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.connectionSpecs()
            okhttp3.internal.connection.ConnectionSpecSelector r10 = new okhttp3.internal.connection.ConnectionSpecSelector
            r10.<init>(r0)
            okhttp3.Route r1 = r7.route
            okhttp3.Address r1 = r1.address()
            javax.net.ssl.SSLSocketFactory r1 = r1.sslSocketFactory()
            if (r1 != 0) goto L_0x0066
            okhttp3.ConnectionSpec r1 = okhttp3.ConnectionSpec.CLEARTEXT
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0059
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address()
            okhttp3.HttpUrl r0 = r0.url()
            java.lang.String r0 = r0.host()
            okhttp3.internal.platform.Platform r1 = okhttp3.internal.platform.Platform.get()
            boolean r1 = r1.isCleartextTrafficPermitted(r0)
            if (r1 == 0) goto L_0x0046
            goto L_0x0078
        L_0x0046:
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.String r3 = "CLEARTEXT communication to "
            java.lang.String r4 = " not permitted by network security policy"
            java.lang.String r0 = defpackage.lf.j(r3, r0, r4)
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0059:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0066:
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.protocols()
            okhttp3.Protocol r1 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0136
        L_0x0078:
            r11 = 0
            r12 = r11
        L_0x007a:
            okhttp3.Route r0 = r7.route     // Catch:{ IOException -> 0x00ed }
            boolean r0 = r0.requiresTunnel()     // Catch:{ IOException -> 0x00ed }
            if (r0 == 0) goto L_0x009b
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.connectTunnel(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00ed }
            java.net.Socket r0 = r7.rawSocket     // Catch:{ IOException -> 0x00ed }
            if (r0 != 0) goto L_0x0096
            goto L_0x00b8
        L_0x0096:
            r13 = r17
            r14 = r18
            goto L_0x00a2
        L_0x009b:
            r13 = r17
            r14 = r18
            r7.connectSocket(r13, r14, r8, r9)     // Catch:{ IOException -> 0x00e9 }
        L_0x00a2:
            r15 = r20
            r7.establishProtocol(r10, r15, r8, r9)     // Catch:{ IOException -> 0x00e7 }
            okhttp3.Route r0 = r7.route     // Catch:{ IOException -> 0x00e7 }
            java.net.InetSocketAddress r0 = r0.socketAddress()     // Catch:{ IOException -> 0x00e7 }
            okhttp3.Route r1 = r7.route     // Catch:{ IOException -> 0x00e7 }
            java.net.Proxy r1 = r1.proxy()     // Catch:{ IOException -> 0x00e7 }
            okhttp3.Protocol r2 = r7.protocol     // Catch:{ IOException -> 0x00e7 }
            r9.connectEnd(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00e7 }
        L_0x00b8:
            okhttp3.Route r0 = r7.route
            boolean r0 = r0.requiresTunnel()
            if (r0 == 0) goto L_0x00d2
            java.net.Socket r0 = r7.rawSocket
            if (r0 == 0) goto L_0x00c5
            goto L_0x00d2
        L_0x00c5:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            r1.<init>(r0)
            throw r1
        L_0x00d2:
            okhttp3.internal.http2.Http2Connection r0 = r7.http2Connection
            if (r0 == 0) goto L_0x00e6
            okhttp3.internal.connection.RealConnectionPool r1 = r7.connectionPool
            monitor-enter(r1)
            okhttp3.internal.http2.Http2Connection r0 = r7.http2Connection     // Catch:{ all -> 0x00e3 }
            int r0 = r0.maxConcurrentStreams()     // Catch:{ all -> 0x00e3 }
            r7.allocationLimit = r0     // Catch:{ all -> 0x00e3 }
            monitor-exit(r1)     // Catch:{ all -> 0x00e3 }
            goto L_0x00e6
        L_0x00e3:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00e3 }
            throw r0
        L_0x00e6:
            return
        L_0x00e7:
            r0 = move-exception
            goto L_0x00f3
        L_0x00e9:
            r0 = move-exception
        L_0x00ea:
            r15 = r20
            goto L_0x00f3
        L_0x00ed:
            r0 = move-exception
            r13 = r17
            r14 = r18
            goto L_0x00ea
        L_0x00f3:
            java.net.Socket r1 = r7.socket
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r1)
            java.net.Socket r1 = r7.rawSocket
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r1)
            r7.socket = r11
            r7.rawSocket = r11
            r7.source = r11
            r7.sink = r11
            r7.handshake = r11
            r7.protocol = r11
            r7.http2Connection = r11
            okhttp3.Route r1 = r7.route
            java.net.InetSocketAddress r3 = r1.socketAddress()
            okhttp3.Route r1 = r7.route
            java.net.Proxy r4 = r1.proxy()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.connectFailed(r2, r3, r4, r5, r6)
            if (r12 != 0) goto L_0x0128
            okhttp3.internal.connection.RouteException r12 = new okhttp3.internal.connection.RouteException
            r12.<init>(r0)
            goto L_0x012b
        L_0x0128:
            r12.addConnectException(r0)
        L_0x012b:
            if (r21 == 0) goto L_0x0135
            boolean r0 = r10.connectionFailed(r0)
            if (r0 == 0) goto L_0x0135
            goto L_0x007a
        L_0x0135:
            throw r12
        L_0x0136:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0143:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public boolean isEligible(Address address, List<Route> list) {
        if (this.transmitters.size() >= this.allocationLimit || this.noNewExchanges || !Internal.instance.equalsNonHost(this.route.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.http2Connection == null || list == null || !routeMatchesAny(list) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean isHealthy(boolean z) {
        int soTimeout;
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 != null) {
            return http2Connection2.isHealthy(System.nanoTime());
        }
        if (z) {
            try {
                soTimeout = this.socket.getSoTimeout();
                this.socket.setSoTimeout(1);
                if (this.source.h0()) {
                    this.socket.setSoTimeout(soTimeout);
                    return false;
                }
                this.socket.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.socket.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public boolean isMultiplexed() {
        if (this.http2Connection != null) {
            return true;
        }
        return false;
    }

    public ExchangeCodec newCodec(OkHttpClient okHttpClient, Interceptor.Chain chain) throws SocketException {
        if (this.http2Connection != null) {
            return new Http2ExchangeCodec(okHttpClient, this, chain, this.http2Connection);
        }
        this.socket.setSoTimeout(chain.readTimeoutMillis());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.source.timeout().timeout((long) chain.readTimeoutMillis(), timeUnit);
        this.sink.timeout().timeout((long) chain.writeTimeoutMillis(), timeUnit);
        return new Http1ExchangeCodec(okHttpClient, this, this.source, this.sink);
    }

    public RealWebSocket.Streams newWebSocketStreams(Exchange exchange) throws SocketException {
        this.socket.setSoTimeout(0);
        noNewExchanges();
        final Exchange exchange2 = exchange;
        return new RealWebSocket.Streams(true, this.source, this.sink) {
            public void close() throws IOException {
                exchange2.bodyComplete(-1, true, true, (IOException) null);
            }
        };
    }

    public void noNewExchanges() {
        synchronized (this.connectionPool) {
            this.noNewExchanges = true;
        }
    }

    public void onSettings(Http2Connection http2Connection2) {
        synchronized (this.connectionPool) {
            this.allocationLimit = http2Connection2.maxConcurrentStreams();
        }
    }

    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM, (IOException) null);
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public Route route() {
        return this.route;
    }

    public Socket socket() {
        return this.socket;
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        if (httpUrl.port() != this.route.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.route.address().url().host())) {
            return true;
        }
        if (this.handshake == null || !OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) this.handshake.peerCertificates().get(0))) {
            return false;
        }
        return true;
    }

    public String toString() {
        Object obj;
        StringBuilder sb = new StringBuilder("Connection{");
        sb.append(this.route.address().url().host());
        sb.append(":");
        sb.append(this.route.address().url().port());
        sb.append(", proxy=");
        sb.append(this.route.proxy());
        sb.append(" hostAddress=");
        sb.append(this.route.socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        if (handshake2 != null) {
            obj = handshake2.cipherSuite();
        } else {
            obj = "none";
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    public void trackFailure(IOException iOException) {
        synchronized (this.connectionPool) {
            if (iOException instanceof StreamResetException) {
                ErrorCode errorCode = ((StreamResetException) iOException).errorCode;
                if (errorCode == ErrorCode.REFUSED_STREAM) {
                    int i = this.refusedStreamCount + 1;
                    this.refusedStreamCount = i;
                    if (i > 1) {
                        this.noNewExchanges = true;
                        this.routeFailureCount++;
                    }
                } else if (errorCode != ErrorCode.CANCEL) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (!isMultiplexed() || (iOException instanceof ConnectionShutdownException)) {
                this.noNewExchanges = true;
                if (this.successCount == 0) {
                    if (iOException != null) {
                        this.connectionPool.connectFailed(this.route, iOException);
                    }
                    this.routeFailureCount++;
                }
            }
        }
    }
}
