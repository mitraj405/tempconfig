package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public interface BufferedSource extends Source, ReadableByteChannel {
    As B();

    String D() throws IOException;

    byte[] F() throws IOException;

    long I(Buffer buffer) throws IOException;

    void K(long j) throws IOException;

    InputStream M();

    boolean S(long j) throws IOException;

    long U() throws IOException;

    String Y(long j) throws IOException;

    byte[] a0(long j) throws IOException;

    ByteString b0(long j) throws IOException;

    @Deprecated
    Buffer d();

    void d0(long j) throws IOException;

    boolean h0() throws IOException;

    void i(Buffer buffer, long j) throws IOException;

    long j0(ByteString byteString) throws IOException;

    long l0() throws IOException;

    String n0(Charset charset) throws IOException;

    int p(Options options) throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    Buffer x();
}
