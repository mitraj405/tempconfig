package okhttp3.internal.ws;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Random;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Sink;
import okio.Timeout;

final class WebSocketWriter {
    boolean activeWriter;
    final Buffer buffer = new Buffer();
    final FrameSink frameSink = new FrameSink();
    final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    final Random random;
    final BufferedSink sink;
    final Buffer sinkBuffer;
    boolean writerClosed;

    public final class FrameSink implements Sink {
        boolean closed;
        long contentLength;
        int formatOpcode;
        boolean isFirstFrame;

        public FrameSink() {
        }

        public void close() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.f5623a, this.isFirstFrame, true);
                this.closed = true;
                WebSocketWriter.this.activeWriter = false;
                return;
            }
            throw new IOException("closed");
        }

        public void flush() throws IOException {
            if (!this.closed) {
                WebSocketWriter webSocketWriter = WebSocketWriter.this;
                webSocketWriter.writeMessageFrame(this.formatOpcode, webSocketWriter.buffer.f5623a, this.isFirstFrame, false);
                this.isFirstFrame = false;
                return;
            }
            throw new IOException("closed");
        }

        public Timeout timeout() {
            return WebSocketWriter.this.sink.timeout();
        }

        public void write(Buffer buffer, long j) throws IOException {
            boolean z;
            long c;
            if (!this.closed) {
                WebSocketWriter.this.buffer.write(buffer, j);
                if (this.isFirstFrame) {
                    long j2 = this.contentLength;
                    if (j2 != -1 && WebSocketWriter.this.buffer.f5623a > j2 - PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        z = true;
                        c = WebSocketWriter.this.buffer.c();
                        if (c > 0 && !z) {
                            WebSocketWriter.this.writeMessageFrame(this.formatOpcode, c, this.isFirstFrame, false);
                            this.isFirstFrame = false;
                            return;
                        }
                        return;
                    }
                }
                z = false;
                c = WebSocketWriter.this.buffer.c();
                if (c > 0) {
                    return;
                }
                return;
            }
            throw new IOException("closed");
        }
    }

    public WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random2) {
        byte[] bArr;
        if (bufferedSink == null) {
            throw new NullPointerException("sink == null");
        } else if (random2 != null) {
            this.isClient = z;
            this.sink = bufferedSink;
            this.sinkBuffer = bufferedSink.d();
            this.random = random2;
            Buffer.UnsafeCursor unsafeCursor = null;
            if (z) {
                bArr = new byte[4];
            } else {
                bArr = null;
            }
            this.maskKey = bArr;
            this.maskCursor = z ? new Buffer.UnsafeCursor() : unsafeCursor;
        } else {
            throw new NullPointerException("random == null");
        }
    }

    private void writeControlFrame(int i, ByteString byteString) throws IOException {
        if (!this.writerClosed) {
            int A = byteString.A();
            if (((long) A) <= 125) {
                this.sinkBuffer.A(i | 128);
                if (this.isClient) {
                    this.sinkBuffer.A(A | 128);
                    this.random.nextBytes(this.maskKey);
                    this.sinkBuffer.write(this.maskKey);
                    if (A > 0) {
                        Buffer buffer2 = this.sinkBuffer;
                        long j = buffer2.f5623a;
                        buffer2.z(byteString);
                        this.sinkBuffer.m(this.maskCursor);
                        this.maskCursor.a(j);
                        WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                        this.maskCursor.close();
                    }
                } else {
                    this.sinkBuffer.A(A);
                    this.sinkBuffer.z(byteString);
                }
                this.sink.flush();
                return;
            }
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        throw new IOException("closed");
    }

    public Sink newMessageSink(int i, long j) {
        if (!this.activeWriter) {
            this.activeWriter = true;
            FrameSink frameSink2 = this.frameSink;
            frameSink2.formatOpcode = i;
            frameSink2.contentLength = j;
            frameSink2.isFirstFrame = true;
            frameSink2.closed = false;
            return frameSink2;
        }
        throw new IllegalStateException("Another message writer is active. Did you call close()?");
    }

    public void writeClose(int i, ByteString byteString) throws IOException {
        ByteString byteString2 = ByteString.a;
        if (!(i == 0 && byteString == null)) {
            if (i != 0) {
                WebSocketProtocol.validateCloseCode(i);
            }
            Buffer buffer2 = new Buffer();
            buffer2.L(i);
            if (byteString != null) {
                buffer2.z(byteString);
            }
            byteString2 = buffer2.n();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public void writeMessageFrame(int i, long j, boolean z, boolean z2) throws IOException {
        if (!this.writerClosed) {
            int i2 = 0;
            if (!z) {
                i = 0;
            }
            if (z2) {
                i |= 128;
            }
            this.sinkBuffer.A(i);
            if (this.isClient) {
                i2 = 128;
            }
            if (j <= 125) {
                this.sinkBuffer.A(((int) j) | i2);
            } else if (j <= 65535) {
                this.sinkBuffer.A(i2 | 126);
                this.sinkBuffer.L((int) j);
            } else {
                this.sinkBuffer.A(i2 | 127);
                this.sinkBuffer.J(j);
            }
            if (this.isClient) {
                this.random.nextBytes(this.maskKey);
                this.sinkBuffer.write(this.maskKey);
                if (j > 0) {
                    Buffer buffer2 = this.sinkBuffer;
                    long j2 = buffer2.f5623a;
                    buffer2.write(this.buffer, j);
                    this.sinkBuffer.m(this.maskCursor);
                    this.maskCursor.a(j2);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            } else {
                this.sinkBuffer.write(this.buffer, j);
            }
            this.sink.c0();
            return;
        }
        throw new IOException("closed");
    }

    public void writePing(ByteString byteString) throws IOException {
        writeControlFrame(9, byteString);
    }

    public void writePong(ByteString byteString) throws IOException {
        writeControlFrame(10, byteString);
    }
}
