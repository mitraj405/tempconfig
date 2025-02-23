package okhttp3.internal.huc;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import okhttp3.Request;
import okio.Buffer;
import okio.BufferedSink;

final class BufferedRequestBody extends OutputStreamRequestBody {
    final Buffer buffer;
    long contentLength = -1;

    public BufferedRequestBody(long j) {
        Buffer buffer2 = new Buffer();
        this.buffer = buffer2;
        initOutputStream(buffer2, j);
    }

    public long contentLength() throws IOException {
        return this.contentLength;
    }

    public Request prepareToSendRequest(Request request) throws IOException {
        if (request.header(HttpHeaders.CONTENT_LENGTH) != null) {
            return request;
        }
        outputStream().close();
        this.contentLength = this.buffer.f5623a;
        return request.newBuilder().removeHeader(HttpHeaders.TRANSFER_ENCODING).header(HttpHeaders.CONTENT_LENGTH, Long.toString(this.buffer.f5623a)).build();
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.buffer.e(0, bufferedSink.d(), this.buffer.f5623a);
    }
}
