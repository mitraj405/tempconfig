package com.google.protobuf;

import com.google.common.primitives.UnsignedBytes;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

final class NioByteString extends ByteString.LeafByteString {
    /* access modifiers changed from: private */
    public final ByteBuffer buffer;

    public NioByteString(ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    private ByteBuffer slice(int i, int i2) {
        if (i < this.buffer.position() || i2 > this.buffer.limit() || i > i2) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        }
        ByteBuffer slice = this.buffer.slice();
        slice.position(i - this.buffer.position());
        slice.limit(i2 - this.buffer.position());
        return slice;
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.buffer.slice());
    }

    public ByteBuffer asReadOnlyByteBuffer() {
        return this.buffer.asReadOnlyBuffer();
    }

    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    public byte byteAt(int i) {
        try {
            return this.buffer.get(i);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    public void copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.buffer.slice());
    }

    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(i);
        slice.get(bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (size() != byteString.size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof NioByteString) {
            return this.buffer.equals(((NioByteString) obj).buffer);
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        return this.buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    public boolean equalsRange(ByteString byteString, int i, int i2) {
        return substring(0, i2).equals(byteString.substring(i, i2 + i));
    }

    public byte internalByteAt(int i) {
        return byteAt(i);
    }

    public boolean isValidUtf8() {
        return Utf8.isValidUtf8(this.buffer);
    }

    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.buffer, true);
    }

    public InputStream newInput() {
        return new InputStream() {
            private final ByteBuffer buf;

            {
                this.buf = NioByteString.this.buffer.slice();
            }

            public int available() throws IOException {
                return this.buf.remaining();
            }

            public void mark(int i) {
                ByteBuffer byteBuffer = (ByteBuffer) this.buf.mark();
            }

            public boolean markSupported() {
                return true;
            }

            public int read() throws IOException {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                return this.buf.get() & UnsignedBytes.MAX_VALUE;
            }

            public void reset() throws IOException {
                try {
                    ByteBuffer byteBuffer = (ByteBuffer) this.buf.reset();
                } catch (InvalidMarkException e) {
                    throw new IOException(e);
                }
            }

            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!this.buf.hasRemaining()) {
                    return -1;
                }
                int min = Math.min(i2, this.buf.remaining());
                this.buf.get(bArr, i, min);
                return min;
            }
        };
    }

    public int partialHash(int i, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + this.buffer.get(i4);
        }
        return i;
    }

    public int partialIsValidUtf8(int i, int i2, int i3) {
        return Utf8.partialIsValidUtf8(i, this.buffer, i2, i3 + i2);
    }

    public int size() {
        return this.buffer.remaining();
    }

    public ByteString substring(int i, int i2) {
        try {
            return new NioByteString(slice(i, i2));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    public String toStringInternal(Charset charset) {
        int i;
        int i2;
        byte[] bArr;
        if (this.buffer.hasArray()) {
            bArr = this.buffer.array();
            i = this.buffer.position() + this.buffer.arrayOffset();
            i2 = this.buffer.remaining();
        } else {
            bArr = toByteArray();
            i2 = bArr.length;
            i = 0;
        }
        return new String(bArr, i, i2, charset);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    public void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.position() + this.buffer.arrayOffset() + i, i2);
            return;
        }
        ByteBufferWriter.write(slice(i, i2 + i), outputStream);
    }

    public void writeTo(ByteOutput byteOutput) throws IOException {
        byteOutput.writeLazy(this.buffer.slice());
    }
}
