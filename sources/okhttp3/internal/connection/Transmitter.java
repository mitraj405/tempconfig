package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;
import okio.Timeout;

public final class Transmitter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Call call;
    private Object callStackTrace;
    private boolean canceled;
    private final OkHttpClient client;
    public RealConnection connection;
    private final RealConnectionPool connectionPool;
    private final EventListener eventListener;
    private Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private boolean exchangeRequestDone;
    private boolean exchangeResponseDone;
    private boolean noMoreExchanges;
    private Request request;
    private final AsyncTimeout timeout;
    private boolean timeoutEarlyExit;

    public static final class TransmitterReference extends WeakReference<Transmitter> {
        final Object callStackTrace;

        public TransmitterReference(Transmitter transmitter, Object obj) {
            super(transmitter);
            this.callStackTrace = obj;
        }
    }

    public Transmitter(OkHttpClient okHttpClient, Call call2) {
        AnonymousClass1 r0 = new AsyncTimeout() {
            public void timedOut() {
                Transmitter.this.cancel();
            }
        };
        this.timeout = r0;
        this.client = okHttpClient;
        this.connectionPool = Internal.instance.realConnectionPool(okHttpClient.connectionPool());
        this.call = call2;
        this.eventListener = okHttpClient.eventListenerFactory().create(call2);
        r0.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    }

    private Address createAddress(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            sSLSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private IOException maybeReleaseConnection(IOException iOException, boolean z) {
        RealConnection realConnection;
        Socket socket;
        boolean z2;
        boolean z3;
        synchronized (this.connectionPool) {
            if (z) {
                if (this.exchange != null) {
                    throw new IllegalStateException("cannot release connection while it is in use");
                }
            }
            realConnection = this.connection;
            if (realConnection == null || this.exchange != null || (!z && !this.noMoreExchanges)) {
                socket = null;
            } else {
                socket = releaseConnectionNoEvents();
            }
            if (this.connection != null) {
                realConnection = null;
            }
            z2 = true;
            if (!this.noMoreExchanges || this.exchange != null) {
                z3 = false;
            } else {
                z3 = true;
            }
        }
        Util.closeQuietly(socket);
        if (realConnection != null) {
            this.eventListener.connectionReleased(this.call, realConnection);
        }
        if (z3) {
            if (iOException == null) {
                z2 = false;
            }
            iOException = timeoutExit(iOException);
            if (z2) {
                this.eventListener.callFailed(this.call, iOException);
            } else {
                this.eventListener.callEnd(this.call);
            }
        }
        return iOException;
    }

    private IOException timeoutExit(IOException iOException) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public void acquireConnectionNoEvents(RealConnection realConnection) {
        if (this.connection == null) {
            this.connection = realConnection;
            realConnection.transmitters.add(new TransmitterReference(this, this.callStackTrace));
            return;
        }
        throw new IllegalStateException();
    }

    public void callStart() {
        this.callStackTrace = Platform.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this.call);
    }

    public boolean canRetry() {
        if (!this.exchangeFinder.hasStreamFailure() || !this.exchangeFinder.hasRouteToTry()) {
            return false;
        }
        return true;
    }

    public void cancel() {
        Exchange exchange2;
        RealConnection realConnection;
        synchronized (this.connectionPool) {
            this.canceled = true;
            exchange2 = this.exchange;
            ExchangeFinder exchangeFinder2 = this.exchangeFinder;
            if (exchangeFinder2 == null || exchangeFinder2.connectingConnection() == null) {
                realConnection = this.connection;
            } else {
                realConnection = this.exchangeFinder.connectingConnection();
            }
        }
        if (exchange2 != null) {
            exchange2.cancel();
        } else if (realConnection != null) {
            realConnection.cancel();
        }
    }

    public void exchangeDoneDueToException() {
        synchronized (this.connectionPool) {
            if (!this.noMoreExchanges) {
                this.exchange = null;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0036, code lost:
        if (r4 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return maybeReleaseConnection(r7, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.IOException exchangeMessageDone(okhttp3.internal.connection.Exchange r4, boolean r5, boolean r6, java.io.IOException r7) {
        /*
            r3 = this;
            okhttp3.internal.connection.RealConnectionPool r0 = r3.connectionPool
            monitor-enter(r0)
            okhttp3.internal.connection.Exchange r1 = r3.exchange     // Catch:{ all -> 0x003d }
            if (r4 == r1) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            return r7
        L_0x0009:
            r4 = 1
            r2 = 0
            if (r5 == 0) goto L_0x0013
            boolean r5 = r3.exchangeRequestDone     // Catch:{ all -> 0x003d }
            r5 = r5 ^ r4
            r3.exchangeRequestDone = r4     // Catch:{ all -> 0x003d }
            goto L_0x0014
        L_0x0013:
            r5 = r2
        L_0x0014:
            if (r6 == 0) goto L_0x001d
            boolean r6 = r3.exchangeResponseDone     // Catch:{ all -> 0x003d }
            if (r6 != 0) goto L_0x001b
            r5 = r4
        L_0x001b:
            r3.exchangeResponseDone = r4     // Catch:{ all -> 0x003d }
        L_0x001d:
            boolean r6 = r3.exchangeRequestDone     // Catch:{ all -> 0x003d }
            if (r6 == 0) goto L_0x0034
            boolean r6 = r3.exchangeResponseDone     // Catch:{ all -> 0x003d }
            if (r6 == 0) goto L_0x0034
            if (r5 == 0) goto L_0x0034
            okhttp3.internal.connection.RealConnection r5 = r1.connection()     // Catch:{ all -> 0x003d }
            int r6 = r5.successCount     // Catch:{ all -> 0x003d }
            int r6 = r6 + r4
            r5.successCount = r6     // Catch:{ all -> 0x003d }
            r5 = 0
            r3.exchange = r5     // Catch:{ all -> 0x003d }
            goto L_0x0035
        L_0x0034:
            r4 = r2
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x003c
            java.io.IOException r7 = r3.maybeReleaseConnection(r7, r2)
        L_0x003c:
            return r7
        L_0x003d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.Transmitter.exchangeMessageDone(okhttp3.internal.connection.Exchange, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public boolean hasExchange() {
        boolean z;
        synchronized (this.connectionPool) {
            if (this.exchange != null) {
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.connectionPool) {
            z = this.canceled;
        }
        return z;
    }

    public Exchange newExchange(Interceptor.Chain chain, boolean z) {
        synchronized (this.connectionPool) {
            if (this.noMoreExchanges) {
                throw new IllegalStateException("released");
            } else if (this.exchange != null) {
                throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
            }
        }
        Exchange exchange2 = new Exchange(this, this.call, this.eventListener, this.exchangeFinder, this.exchangeFinder.find(this.client, chain, z));
        synchronized (this.connectionPool) {
            this.exchange = exchange2;
            this.exchangeRequestDone = false;
            this.exchangeResponseDone = false;
        }
        return exchange2;
    }

    public IOException noMoreExchanges(IOException iOException) {
        synchronized (this.connectionPool) {
            this.noMoreExchanges = true;
        }
        return maybeReleaseConnection(iOException, false);
    }

    public void prepareToConnect(Request request2) {
        Request request3 = this.request;
        if (request3 != null) {
            if (Util.sameConnection(request3.url(), request2.url()) && this.exchangeFinder.hasRouteToTry()) {
                return;
            }
            if (this.exchange != null) {
                throw new IllegalStateException();
            } else if (this.exchangeFinder != null) {
                maybeReleaseConnection((IOException) null, true);
                this.exchangeFinder = null;
            }
        }
        this.request = request2;
        this.exchangeFinder = new ExchangeFinder(this, this.connectionPool, createAddress(request2.url()), this.call, this.eventListener);
    }

    public Socket releaseConnectionNoEvents() {
        int size = this.connection.transmitters.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (this.connection.transmitters.get(i).get() == this) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            RealConnection realConnection = this.connection;
            realConnection.transmitters.remove(i);
            this.connection = null;
            if (realConnection.transmitters.isEmpty()) {
                realConnection.idleAtNanos = System.nanoTime();
                if (this.connectionPool.connectionBecameIdle(realConnection)) {
                    return realConnection.socket();
                }
            }
            return null;
        }
        throw new IllegalStateException();
    }

    public Timeout timeout() {
        return this.timeout;
    }

    public void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            this.timeout.exit();
            return;
        }
        throw new IllegalStateException();
    }

    public void timeoutEnter() {
        this.timeout.enter();
    }
}
