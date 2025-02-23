package okhttp3;

import com.google.firebase.perf.FirebasePerformance;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.CacheStrategy;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Sink;
import okio.Source;

public final class Cache implements Closeable, Flushable {
    private static final int ENTRY_BODY = 1;
    private static final int ENTRY_COUNT = 2;
    private static final int ENTRY_METADATA = 0;
    private static final int VERSION = 201105;
    final DiskLruCache cache;
    private int hitCount;
    final InternalCache internalCache;
    private int networkCount;
    private int requestCount;
    int writeAbortCount;
    int writeSuccessCount;

    public final class CacheRequestImpl implements CacheRequest {
        private Sink body;
        private Sink cacheOut;
        boolean done;
        private final DiskLruCache.Editor editor;

        public CacheRequestImpl(final DiskLruCache.Editor editor2) {
            this.editor = editor2;
            Sink newSink = editor2.newSink(1);
            this.cacheOut = newSink;
            this.body = new C1258md(newSink, Cache.this) {
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        CacheRequestImpl cacheRequestImpl = CacheRequestImpl.this;
                        if (!cacheRequestImpl.done) {
                            cacheRequestImpl.done = true;
                            Cache.this.writeSuccessCount++;
                            super.close();
                            editor2.commit();
                        }
                    }
                }
            };
        }

        public void abort() {
            synchronized (Cache.this) {
                if (!this.done) {
                    this.done = true;
                    Cache.this.writeAbortCount++;
                    Util.closeQuietly((Closeable) this.cacheOut);
                    try {
                        this.editor.abort();
                    } catch (IOException unused) {
                    }
                }
            }
        }

        public Sink body() {
            return this.body;
        }
    }

    public static class CacheResponseBody extends ResponseBody {
        private final BufferedSource bodySource;
        private final String contentLength;
        private final String contentType;
        final DiskLruCache.Snapshot snapshot;

        public CacheResponseBody(final DiskLruCache.Snapshot snapshot2, String str, String str2) {
            this.snapshot = snapshot2;
            this.contentType = str;
            this.contentLength = str2;
            AnonymousClass1 r3 = new C1280nd(snapshot2.getSource(1)) {
                public void close() throws IOException {
                    snapshot2.close();
                    super.close();
                }
            };
            Logger logger = C1517zn.a;
            this.bodySource = new As(r3);
        }

        public long contentLength() {
            try {
                String str = this.contentLength;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public MediaType contentType() {
            String str = this.contentType;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        public BufferedSource source() {
            return this.bodySource;
        }
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.SYSTEM);
    }

    private void abortQuietly(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException unused) {
            }
        }
    }

    public static String key(HttpUrl httpUrl) {
        return ByteString.m(httpUrl.toString()).l("MD5").o();
    }

    public static int readInt(BufferedSource bufferedSource) throws IOException {
        try {
            long U = bufferedSource.U();
            String D = bufferedSource.D();
            if (U >= 0 && U <= 2147483647L && D.isEmpty()) {
                return (int) U;
            }
            throw new IOException("expected an int but was \"" + U + D + "\"");
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    public void close() throws IOException {
        this.cache.close();
    }

    public void delete() throws IOException {
        this.cache.delete();
    }

    public File directory() {
        return this.cache.getDirectory();
    }

    public void evictAll() throws IOException {
        this.cache.evictAll();
    }

    public void flush() throws IOException {
        this.cache.flush();
    }

    public Response get(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.cache.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                Util.closeQuietly((Closeable) response.body());
                return null;
            } catch (IOException unused) {
                Util.closeQuietly((Closeable) snapshot);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public synchronized int hitCount() {
        return this.hitCount;
    }

    public void initialize() throws IOException {
        this.cache.initialize();
    }

    public boolean isClosed() {
        return this.cache.isClosed();
    }

    public long maxSize() {
        return this.cache.getMaxSize();
    }

    public synchronized int networkCount() {
        return this.networkCount;
    }

    public CacheRequest put(Response response) {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                remove(response.request());
            } catch (IOException unused) {
            }
            return null;
        } else if (!method.equals(FirebasePerformance.HttpMethod.GET) || HttpHeaders.hasVaryAll(response)) {
            return null;
        } else {
            Entry entry = new Entry(response);
            try {
                editor = this.cache.edit(key(response.request().url()));
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new CacheRequestImpl(editor);
                } catch (IOException unused2) {
                    abortQuietly(editor);
                    return null;
                }
            } catch (IOException unused3) {
                editor = null;
                abortQuietly(editor);
                return null;
            }
        }
    }

    public void remove(Request request) throws IOException {
        this.cache.remove(key(request.url()));
    }

    public synchronized int requestCount() {
        return this.requestCount;
    }

    public long size() throws IOException {
        return this.cache.size();
    }

    public synchronized void trackConditionalCacheHit() {
        this.hitCount++;
    }

    public synchronized void trackResponse(CacheStrategy cacheStrategy) {
        this.requestCount++;
        if (cacheStrategy.networkRequest != null) {
            this.networkCount++;
        } else if (cacheStrategy.cacheResponse != null) {
            this.hitCount++;
        }
    }

    public void update(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = ((CacheResponseBody) response.body()).snapshot.edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            editor = null;
            abortQuietly(editor);
        }
    }

    public Iterator<String> urls() throws IOException {
        return new Iterator<String>() {
            boolean canRemove;
            final Iterator<DiskLruCache.Snapshot> delegate;
            String nextUrl;

            {
                this.delegate = Cache.this.cache.snapshots();
            }

            /* JADX WARNING: Code restructure failed: missing block: B:17:0x0030, code lost:
                r4 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0031, code lost:
                if (r2 != null) goto L_0x0033;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
                r2.close();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x003b, code lost:
                throw r4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
                continue;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean hasNext() {
                /*
                    r5 = this;
                    java.lang.String r0 = r5.nextUrl
                    r1 = 1
                    if (r0 == 0) goto L_0x0006
                    return r1
                L_0x0006:
                    r0 = 0
                    r5.canRemove = r0
                L_0x0009:
                    java.util.Iterator<okhttp3.internal.cache.DiskLruCache$Snapshot> r2 = r5.delegate
                    boolean r2 = r2.hasNext()
                    if (r2 == 0) goto L_0x003c
                    java.util.Iterator<okhttp3.internal.cache.DiskLruCache$Snapshot> r2 = r5.delegate     // Catch:{ IOException -> 0x0009 }
                    java.lang.Object r2 = r2.next()     // Catch:{ IOException -> 0x0009 }
                    okhttp3.internal.cache.DiskLruCache$Snapshot r2 = (okhttp3.internal.cache.DiskLruCache.Snapshot) r2     // Catch:{ IOException -> 0x0009 }
                    okio.Source r3 = r2.getSource(r0)     // Catch:{ all -> 0x002e }
                    java.util.logging.Logger r4 = defpackage.C1517zn.a     // Catch:{ all -> 0x002e }
                    As r4 = new As     // Catch:{ all -> 0x002e }
                    r4.<init>(r3)     // Catch:{ all -> 0x002e }
                    java.lang.String r3 = r4.D()     // Catch:{ all -> 0x002e }
                    r5.nextUrl = r3     // Catch:{ all -> 0x002e }
                    r2.close()     // Catch:{ IOException -> 0x0009 }
                    return r1
                L_0x002e:
                    r3 = move-exception
                    throw r3     // Catch:{ all -> 0x0030 }
                L_0x0030:
                    r4 = move-exception
                    if (r2 == 0) goto L_0x003b
                    r2.close()     // Catch:{ all -> 0x0037 }
                    goto L_0x003b
                L_0x0037:
                    r2 = move-exception
                    r3.addSuppressed(r2)     // Catch:{ IOException -> 0x0009 }
                L_0x003b:
                    throw r4     // Catch:{ IOException -> 0x0009 }
                L_0x003c:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cache.AnonymousClass2.hasNext():boolean");
            }

            public void remove() {
                if (this.canRemove) {
                    this.delegate.remove();
                    return;
                }
                throw new IllegalStateException("remove() before next()");
            }

            public String next() {
                if (hasNext()) {
                    String str = this.nextUrl;
                    this.nextUrl = null;
                    this.canRemove = true;
                    return str;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public synchronized int writeAbortCount() {
        return this.writeAbortCount;
    }

    public synchronized int writeSuccessCount() {
        return this.writeSuccessCount;
    }

    public Cache(File file, long j, FileSystem fileSystem) {
        this.internalCache = new InternalCache() {
            public Response get(Request request) throws IOException {
                return Cache.this.get(request);
            }

            public CacheRequest put(Response response) throws IOException {
                return Cache.this.put(response);
            }

            public void remove(Request request) throws IOException {
                Cache.this.remove(request);
            }

            public void trackConditionalCacheHit() {
                Cache.this.trackConditionalCacheHit();
            }

            public void trackResponse(CacheStrategy cacheStrategy) {
                Cache.this.trackResponse(cacheStrategy);
            }

            public void update(Response response, Response response2) {
                Cache.this.update(response, response2);
            }
        };
        this.cache = DiskLruCache.create(fileSystem, file, VERSION, 2, j);
    }

    public static final class Entry {
        private static final String RECEIVED_MILLIS = (Platform.get().getPrefix() + "-Received-Millis");
        private static final String SENT_MILLIS = (Platform.get().getPrefix() + "-Sent-Millis");
        private final int code;
        private final Handshake handshake;
        private final String message;
        private final Protocol protocol;
        private final long receivedResponseMillis;
        private final String requestMethod;
        private final Headers responseHeaders;
        private final long sentRequestMillis;
        private final String url;
        private final Headers varyHeaders;

        public Entry(Source source) throws IOException {
            TlsVersion tlsVersion;
            try {
                Logger logger = C1517zn.a;
                As as = new As(source);
                this.url = as.D();
                this.requestMethod = as.D();
                Headers.Builder builder = new Headers.Builder();
                int readInt = Cache.readInt(as);
                for (int i = 0; i < readInt; i++) {
                    builder.addLenient(as.D());
                }
                this.varyHeaders = builder.build();
                StatusLine parse = StatusLine.parse(as.D());
                this.protocol = parse.protocol;
                this.code = parse.code;
                this.message = parse.message;
                Headers.Builder builder2 = new Headers.Builder();
                int readInt2 = Cache.readInt(as);
                for (int i2 = 0; i2 < readInt2; i2++) {
                    builder2.addLenient(as.D());
                }
                String str = SENT_MILLIS;
                String str2 = builder2.get(str);
                String str3 = RECEIVED_MILLIS;
                String str4 = builder2.get(str3);
                builder2.removeAll(str);
                builder2.removeAll(str3);
                long j = 0;
                this.sentRequestMillis = str2 != null ? Long.parseLong(str2) : 0;
                this.receivedResponseMillis = str4 != null ? Long.parseLong(str4) : j;
                this.responseHeaders = builder2.build();
                if (isHttps()) {
                    String D = as.D();
                    if (D.length() <= 0) {
                        CipherSuite forJavaName = CipherSuite.forJavaName(as.D());
                        List<Certificate> readCertificateList = readCertificateList(as);
                        List<Certificate> readCertificateList2 = readCertificateList(as);
                        if (!as.h0()) {
                            tlsVersion = TlsVersion.forJavaName(as.D());
                        } else {
                            tlsVersion = TlsVersion.SSL_3_0;
                        }
                        this.handshake = Handshake.get(tlsVersion, forJavaName, readCertificateList, readCertificateList2);
                    } else {
                        throw new IOException("expected \"\" but was \"" + D + "\"");
                    }
                } else {
                    this.handshake = null;
                }
            } finally {
                source.close();
            }
        }

        private boolean isHttps() {
            return this.url.startsWith("https://");
        }

        private List<Certificate> readCertificateList(BufferedSource bufferedSource) throws IOException {
            int readInt = Cache.readInt(bufferedSource);
            if (readInt == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    String D = bufferedSource.D();
                    Buffer buffer = new Buffer();
                    buffer.z(ByteString.f(D));
                    arrayList.add(instance.generateCertificate(new Buffer.a()));
                }
                return arrayList;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void writeCertList(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.g0((long) list.size()).o(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.e0(ByteString.t(list.get(i).getEncoded()).a()).o(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean matches(Request request, Response response) {
            if (!this.url.equals(request.url().toString()) || !this.requestMethod.equals(request.method()) || !HttpHeaders.varyMatches(response, this.varyHeaders, request)) {
                return false;
            }
            return true;
        }

        public Response response(DiskLruCache.Snapshot snapshot) {
            String str = this.responseHeaders.get(com.google.common.net.HttpHeaders.CONTENT_TYPE);
            String str2 = this.responseHeaders.get(com.google.common.net.HttpHeaders.CONTENT_LENGTH);
            return new Response.Builder().request(new Request.Builder().url(this.url).method(this.requestMethod, (RequestBody) null).headers(this.varyHeaders).build()).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
        }

        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            Sink newSink = editor.newSink(0);
            Logger logger = C1517zn.a;
            C1519zs zsVar = new C1519zs(newSink);
            zsVar.e0(this.url);
            zsVar.o(10);
            zsVar.e0(this.requestMethod);
            zsVar.o(10);
            zsVar.g0((long) this.varyHeaders.size());
            zsVar.o(10);
            int size = this.varyHeaders.size();
            for (int i = 0; i < size; i++) {
                zsVar.e0(this.varyHeaders.name(i));
                zsVar.e0(": ");
                zsVar.e0(this.varyHeaders.value(i));
                zsVar.o(10);
            }
            zsVar.e0(new StatusLine(this.protocol, this.code, this.message).toString());
            zsVar.o(10);
            zsVar.g0((long) (this.responseHeaders.size() + 2));
            zsVar.o(10);
            int size2 = this.responseHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                zsVar.e0(this.responseHeaders.name(i2));
                zsVar.e0(": ");
                zsVar.e0(this.responseHeaders.value(i2));
                zsVar.o(10);
            }
            zsVar.e0(SENT_MILLIS);
            zsVar.e0(": ");
            zsVar.g0(this.sentRequestMillis);
            zsVar.o(10);
            zsVar.e0(RECEIVED_MILLIS);
            zsVar.e0(": ");
            zsVar.g0(this.receivedResponseMillis);
            zsVar.o(10);
            if (isHttps()) {
                zsVar.o(10);
                zsVar.e0(this.handshake.cipherSuite().javaName());
                zsVar.o(10);
                writeCertList(zsVar, this.handshake.peerCertificates());
                writeCertList(zsVar, this.handshake.localCertificates());
                zsVar.e0(this.handshake.tlsVersion().javaName());
                zsVar.o(10);
            }
            zsVar.close();
        }

        public Entry(Response response) {
            this.url = response.request().url().toString();
            this.varyHeaders = HttpHeaders.varyHeaders(response);
            this.requestMethod = response.request().method();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.responseHeaders = response.headers();
            this.handshake = response.handshake();
            this.sentRequestMillis = response.sentRequestAtMillis();
            this.receivedResponseMillis = response.receivedResponseAtMillis();
        }
    }
}
