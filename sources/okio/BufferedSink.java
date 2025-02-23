package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;

public interface BufferedSink extends Sink, WritableByteChannel {
    BufferedSink H(byte[] bArr) throws IOException;

    BufferedSink P(int i, byte[] bArr, int i2) throws IOException;

    BufferedSink R(ByteString byteString) throws IOException;

    long T(Source source) throws IOException;

    BufferedSink V(int i) throws IOException;

    BufferedSink c0() throws IOException;

    Buffer d();

    BufferedSink e0(String str) throws IOException;

    void flush() throws IOException;

    BufferedSink g(long j) throws IOException;

    BufferedSink g0(long j) throws IOException;

    BufferedSink k(int i) throws IOException;

    BufferedSink k0() throws IOException;

    BufferedSink o(int i) throws IOException;
}
