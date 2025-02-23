package okhttp3.logging;

import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;

public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            public void log(String str) {
                Platform.get().log(4, str, (Throwable) null);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    private boolean bodyEncoded(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        if (str == null || str.equalsIgnoreCase("identity")) {
            return false;
        }
        return true;
    }

    public static boolean isPlaintext(Buffer buffer) {
        long j;
        try {
            Buffer buffer2 = new Buffer();
            long j2 = buffer.f5623a;
            if (j2 < 64) {
                j = j2;
            } else {
                j = 64;
            }
            buffer.e(0, buffer2, j);
            for (int i = 0; i < 16; i++) {
                if (buffer2.h0()) {
                    return true;
                }
                int t = buffer2.t();
                if (Character.isISOControl(t) && !Character.isWhitespace(t)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public Level getLevel() {
        return this.level;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        boolean z2;
        Protocol protocol;
        String str;
        String str2;
        String str3;
        String str4;
        Interceptor.Chain chain2 = chain;
        Level level2 = this.level;
        Request request = chain.request();
        if (level2 == Level.NONE) {
            return chain2.proceed(request);
        }
        boolean z3 = true;
        if (level2 == Level.BODY) {
            z = true;
        } else {
            z = false;
        }
        if (z || level2 == Level.HEADERS) {
            z2 = true;
        } else {
            z2 = false;
        }
        RequestBody body = request.body();
        if (body == null) {
            z3 = false;
        }
        Connection connection = chain.connection();
        if (connection != null) {
            protocol = connection.protocol();
        } else {
            protocol = Protocol.HTTP_1_1;
        }
        String str5 = "--> " + request.method() + ' ' + request.url() + ' ' + protocol;
        if (!z2 && z3) {
            StringBuilder n = lf.n(str5, " (");
            n.append(body.contentLength());
            n.append("-byte body)");
            str5 = n.toString();
        }
        this.logger.log(str5);
        String str6 = ": ";
        if (z2) {
            if (z3) {
                if (body.contentType() != null) {
                    this.logger.log("Content-Type: " + body.contentType());
                }
                if (body.contentLength() != -1) {
                    this.logger.log("Content-Length: " + body.contentLength());
                }
            }
            Headers headers = request.headers();
            int size = headers.size();
            int i = 0;
            while (i < size) {
                String name = headers.name(i);
                int i2 = size;
                if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(name) || HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(name)) {
                    str4 = str6;
                } else {
                    Logger logger2 = this.logger;
                    StringBuilder n2 = lf.n(name, str6);
                    str4 = str6;
                    n2.append(headers.value(i));
                    logger2.log(n2.toString());
                }
                i++;
                size = i2;
                str6 = str4;
            }
            str = str6;
            if (!z || !z3) {
                this.logger.log("--> END " + request.method());
            } else if (bodyEncoded(request.headers())) {
                this.logger.log("--> END " + request.method() + " (encoded body omitted)");
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                Charset charset = UTF8;
                MediaType contentType = body.contentType();
                if (contentType != null) {
                    charset = contentType.charset(charset);
                }
                this.logger.log("");
                if (isPlaintext(buffer)) {
                    this.logger.log(buffer.n0(charset));
                    this.logger.log("--> END " + request.method() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.method() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        } else {
            str = str6;
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain2.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.body();
            long contentLength = body2.contentLength();
            if (contentLength != -1) {
                str2 = contentLength + "-byte";
            } else {
                str2 = "unknown-length";
            }
            Logger logger3 = this.logger;
            String str7 = "-byte body)";
            StringBuilder sb = new StringBuilder("<-- ");
            sb.append(proceed.code());
            sb.append(' ');
            long j = contentLength;
            sb.append(proceed.message());
            sb.append(' ');
            sb.append(proceed.request().url());
            sb.append(" (");
            sb.append(millis);
            sb.append("ms");
            if (!z2) {
                str3 = lf.j(", ", str2, " body");
            } else {
                str3 = "";
            }
            sb.append(str3);
            sb.append(')');
            logger3.log(sb.toString());
            if (z2) {
                Headers headers2 = proceed.headers();
                int size2 = headers2.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    this.logger.log(headers2.name(i3) + str + headers2.value(i3));
                }
                if (!z || !okhttp3.internal.http.HttpHeaders.hasBody(proceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyEncoded(proceed.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = body2.source();
                    source.S(Long.MAX_VALUE);
                    Buffer d = source.d();
                    Charset charset2 = UTF8;
                    MediaType contentType2 = body2.contentType();
                    if (contentType2 != null) {
                        try {
                            charset2 = contentType2.charset(charset2);
                        } catch (UnsupportedCharsetException unused) {
                            this.logger.log("");
                            this.logger.log("Couldn't decode the response body; charset is likely malformed.");
                            this.logger.log("<-- END HTTP");
                            return proceed;
                        }
                    }
                    if (!isPlaintext(d)) {
                        this.logger.log("");
                        this.logger.log("<-- END HTTP (binary " + d.f5623a + "-byte body omitted)");
                        return proceed;
                    }
                    if (j != 0) {
                        this.logger.log("");
                        this.logger.log(d.clone().n0(charset2));
                    }
                    this.logger.log("<-- END HTTP (" + d.f5623a + str7);
                }
            }
            return proceed;
        } catch (Exception e) {
            Exception exc = e;
            this.logger.log("<-- HTTP FAILED: " + exc);
            throw exc;
        }
    }

    public HttpLoggingInterceptor setLevel(Level level2) {
        if (level2 != null) {
            this.level = level2;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public HttpLoggingInterceptor(Logger logger2) {
        this.level = Level.NONE;
        this.logger = logger2;
    }
}
