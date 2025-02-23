package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;

public abstract class RequestBody {
    public static RequestBody create(MediaType mediaType, String str) {
        Charset charset = StandardCharsets.UTF_8;
        if (mediaType != null && (charset = mediaType.charset()) == null) {
            charset = StandardCharsets.UTF_8;
            mediaType = MediaType.parse(mediaType + "; charset=utf-8");
        }
        return create(mediaType, str.getBytes(charset));
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public static RequestBody create(final MediaType mediaType, final ByteString byteString) {
        return new RequestBody() {
            public long contentLength() throws IOException {
                return (long) byteString.A();
            }

            public MediaType contentType() {
                return MediaType.this;
            }

            public void writeTo(BufferedSink bufferedSink) throws IOException {
                bufferedSink.R(byteString);
            }
        };
    }

    public static RequestBody create(MediaType mediaType, byte[] bArr) {
        return create(mediaType, bArr, 0, bArr.length);
    }

    public static RequestBody create(final MediaType mediaType, final byte[] bArr, final int i, final int i2) {
        if (bArr != null) {
            Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
            return new RequestBody() {
                public long contentLength() {
                    return (long) i2;
                }

                public MediaType contentType() {
                    return MediaType.this;
                }

                public void writeTo(BufferedSink bufferedSink) throws IOException {
                    bufferedSink.P(i, bArr, i2);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(final MediaType mediaType, final File file) {
        if (file != null) {
            return new RequestBody() {
                public long contentLength() {
                    return file.length();
                }

                public MediaType contentType() {
                    return MediaType.this;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
                    r1 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
                    r0.close();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
                    r0 = move-exception;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
                    r3.addSuppressed(r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
                    throw r1;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void writeTo(okio.BufferedSink r3) throws java.io.IOException {
                    /*
                        r2 = this;
                        java.io.File r0 = r2
                        java.util.logging.Logger r1 = defpackage.C1517zn.a
                        if (r0 == 0) goto L_0x0022
                        java.io.FileInputStream r1 = new java.io.FileInputStream
                        r1.<init>(r0)
                        wn r0 = defpackage.C1517zn.b(r1)
                        r3.T(r0)     // Catch:{ all -> 0x0016 }
                        r0.close()
                        return
                    L_0x0016:
                        r3 = move-exception
                        throw r3     // Catch:{ all -> 0x0018 }
                    L_0x0018:
                        r1 = move-exception
                        r0.close()     // Catch:{ all -> 0x001d }
                        goto L_0x0021
                    L_0x001d:
                        r0 = move-exception
                        r3.addSuppressed(r0)
                    L_0x0021:
                        throw r1
                    L_0x0022:
                        java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
                        java.lang.String r0 = "file == null"
                        r3.<init>(r0)
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: okhttp3.RequestBody.AnonymousClass3.writeTo(okio.BufferedSink):void");
                }
            };
        }
        throw new NullPointerException("file == null");
    }
}
