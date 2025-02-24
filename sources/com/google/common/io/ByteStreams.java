package com.google.common.io;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final OutputStream NULL_OUTPUT_STREAM = new OutputStream() {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        public void write(int i) {
        }

        public void write(byte[] bArr) {
            Preconditions.checkNotNull(bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            Preconditions.checkNotNull(bArr);
            Preconditions.checkPositionIndexes(i, i2 + i, bArr.length);
        }
    };
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;
    private static final int ZERO_COPY_CHUNK_SIZE = 524288;

    private ByteStreams() {
    }

    private static byte[] combineBuffers(Queue<byte[]> queue, int i) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i) {
            return remove;
        }
        int length = i - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i - length, min);
            length -= min;
        }
        return copyOf;
    }

    @CanIgnoreReturnValue
    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(outputStream);
        byte[] createBuffer = createBuffer();
        long j = 0;
        while (true) {
            int read = inputStream.read(createBuffer);
            if (read == -1) {
                return j;
            }
            outputStream.write(createBuffer, 0, read);
            j += (long) read;
        }
    }

    public static byte[] createBuffer() {
        return new byte[8192];
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(InputStream inputStream) throws IOException {
        byte[] createBuffer = createBuffer();
        long j = 0;
        while (true) {
            long read = (long) inputStream.read(createBuffer);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @Beta
    public static InputStream limit(InputStream inputStream, long j) {
        return new LimitedInputStream(inputStream, j);
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bArr) {
        return newDataInput(new ByteArrayInputStream(bArr));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput() {
        return newDataOutput(new ByteArrayOutputStream());
    }

    @Beta
    public static OutputStream nullOutputStream() {
        return NULL_OUTPUT_STREAM;
    }

    @CanIgnoreReturnValue
    @Beta
    public static int read(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(bArr);
        int i3 = 0;
        if (i2 >= 0) {
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            while (i3 < i2) {
                int read = inputStream.read(bArr, i + i3, i2 - i3);
                if (read == -1) {
                    break;
                }
                i3 += read;
            }
            return i3;
        }
        throw new IndexOutOfBoundsException(String.format("len (%s) cannot be negative", new Object[]{Integer.valueOf(i2)}));
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    @Beta
    public static <T> T readBytes(InputStream inputStream, ByteProcessor<T> byteProcessor) throws IOException {
        int read;
        Preconditions.checkNotNull(inputStream);
        Preconditions.checkNotNull(byteProcessor);
        byte[] createBuffer = createBuffer();
        do {
            read = inputStream.read(createBuffer);
            if (read == -1 || !byteProcessor.processBytes(createBuffer, 0, read)) {
            }
            read = inputStream.read(createBuffer);
            break;
        } while (!byteProcessor.processBytes(createBuffer, 0, read));
        return byteProcessor.getResult();
    }

    @Beta
    public static void readFully(InputStream inputStream, byte[] bArr) throws IOException {
        readFully(inputStream, bArr, 0, bArr.length);
    }

    @Beta
    public static void skipFully(InputStream inputStream, long j) throws IOException {
        long skipUpTo = skipUpTo(inputStream, j);
        if (skipUpTo < j) {
            StringBuilder sb = new StringBuilder(100);
            sb.append("reached end of stream after skipping ");
            sb.append(skipUpTo);
            sb.append(" bytes; ");
            throw new EOFException(lf.l(sb, j, " bytes expected"));
        }
    }

    private static long skipSafely(InputStream inputStream, long j) throws IOException {
        int available = inputStream.available();
        if (available == 0) {
            return 0;
        }
        return inputStream.skip(Math.min((long) available, j));
    }

    public static long skipUpTo(InputStream inputStream, long j) throws IOException {
        byte[] bArr = null;
        long j2 = 0;
        while (j2 < j) {
            long j3 = j - j2;
            long skipSafely = skipSafely(inputStream, j3);
            if (skipSafely == 0) {
                int min = (int) Math.min(j3, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
                if (bArr == null) {
                    bArr = new byte[min];
                }
                skipSafely = (long) inputStream.read(bArr, 0, min);
                if (skipSafely == -1) {
                    break;
                }
            }
            j2 += skipSafely;
        }
        return j2;
    }

    public static byte[] toByteArray(InputStream inputStream) throws IOException {
        Preconditions.checkNotNull(inputStream);
        return toByteArrayInternal(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] toByteArrayInternal(InputStream inputStream, Queue<byte[]> queue, int i) throws IOException {
        int i2;
        int min = Math.min(8192, Math.max(128, Integer.highestOneBit(i) * 2));
        while (i < MAX_ARRAY_LEN) {
            int min2 = Math.min(min, MAX_ARRAY_LEN - i);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i3 = 0;
            while (i3 < min2) {
                int read = inputStream.read(bArr, i3, min2 - i3);
                if (read == -1) {
                    return combineBuffers(queue, i);
                }
                i3 += read;
                i += read;
            }
            if (min < 4096) {
                i2 = 4;
            } else {
                i2 = 2;
            }
            min = IntMath.saturatedMultiply(min, i2);
        }
        if (inputStream.read() == -1) {
            return combineBuffers(queue, MAX_ARRAY_LEN);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static class ByteArrayDataInputStream implements ByteArrayDataInput {
        final DataInput input;

        public ByteArrayDataInputStream(ByteArrayInputStream byteArrayInputStream) {
            this.input = new DataInputStream(byteArrayInputStream);
        }

        public boolean readBoolean() {
            try {
                return this.input.readBoolean();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public byte readByte() {
            try {
                return this.input.readByte();
            } catch (EOFException e) {
                throw new IllegalStateException(e);
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }

        public char readChar() {
            try {
                return this.input.readChar();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public double readDouble() {
            try {
                return this.input.readDouble();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public float readFloat() {
            try {
                return this.input.readFloat();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public void readFully(byte[] bArr) {
            try {
                this.input.readFully(bArr);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public int readInt() {
            try {
                return this.input.readInt();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String readLine() {
            try {
                return this.input.readLine();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public long readLong() {
            try {
                return this.input.readLong();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public short readShort() {
            try {
                return this.input.readShort();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String readUTF() {
            try {
                return this.input.readUTF();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public int readUnsignedByte() {
            try {
                return this.input.readUnsignedByte();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public int readUnsignedShort() {
            try {
                return this.input.readUnsignedShort();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public int skipBytes(int i) {
            try {
                return this.input.skipBytes(i);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public void readFully(byte[] bArr, int i, int i2) {
            try {
                this.input.readFully(bArr, i, i2);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        final ByteArrayOutputStream byteArrayOutputStream;
        final DataOutput output;

        public ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputStream2) {
            this.byteArrayOutputStream = byteArrayOutputStream2;
            this.output = new DataOutputStream(byteArrayOutputStream2);
        }

        public byte[] toByteArray() {
            return this.byteArrayOutputStream.toByteArray();
        }

        public void write(int i) {
            try {
                this.output.write(i);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void writeBoolean(boolean z) {
            try {
                this.output.writeBoolean(z);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void writeByte(int i) {
            try {
                this.output.writeByte(i);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void writeBytes(String str) {
            try {
                this.output.writeBytes(str);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void writeChar(int i) {
            try {
                this.output.writeChar(i);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void writeChars(String str) {
            try {
                this.output.writeChars(str);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void writeDouble(double d) {
            try {
                this.output.writeDouble(d);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void writeFloat(float f) {
            try {
                this.output.writeFloat(f);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void writeInt(int i) {
            try {
                this.output.writeInt(i);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void writeLong(long j) {
            try {
                this.output.writeLong(j);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void writeShort(int i) {
            try {
                this.output.writeShort(i);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void writeUTF(String str) {
            try {
                this.output.writeUTF(str);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void write(byte[] bArr) {
            try {
                this.output.write(bArr);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }

        public void write(byte[] bArr, int i, int i2) {
            try {
                this.output.write(bArr, i, i2);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
    }

    @Beta
    public static ByteArrayDataInput newDataInput(byte[] bArr, int i) {
        Preconditions.checkPositionIndex(i, bArr.length);
        return newDataInput(new ByteArrayInputStream(bArr, i, bArr.length - i));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(int i) {
        if (i >= 0) {
            return newDataOutput(new ByteArrayOutputStream(i));
        }
        throw new IllegalArgumentException(String.format("Invalid size: %s", new Object[]{Integer.valueOf(i)}));
    }

    @Beta
    public static void readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int read = read(inputStream, bArr, i, i2);
        if (read != i2) {
            StringBuilder sb = new StringBuilder(81);
            sb.append("reached end of stream after reading ");
            sb.append(read);
            sb.append(" bytes; ");
            sb.append(i2);
            sb.append(" bytes expected");
            throw new EOFException(sb.toString());
        }
    }

    public static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark = -1;

        public LimitedInputStream(InputStream inputStream, long j) {
            super(inputStream);
            boolean z;
            Preconditions.checkNotNull(inputStream);
            if (j >= 0) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "limit must be non-negative");
            this.left = j;
        }

        public int available() throws IOException {
            return (int) Math.min((long) this.in.available(), this.left);
        }

        public synchronized void mark(int i) {
            this.in.mark(i);
            this.mark = this.left;
        }

        public int read() throws IOException {
            if (this.left == 0) {
                return -1;
            }
            int read = this.in.read();
            if (read != -1) {
                this.left--;
            }
            return read;
        }

        public synchronized void reset() throws IOException {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            } else if (this.mark != -1) {
                this.in.reset();
                this.left = this.mark;
            } else {
                throw new IOException("Mark not set");
            }
        }

        public long skip(long j) throws IOException {
            long skip = this.in.skip(Math.min(j, this.left));
            this.left -= skip;
            return skip;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            long j = this.left;
            if (j == 0) {
                return -1;
            }
            int read = this.in.read(bArr, i, (int) Math.min((long) i2, j));
            if (read != -1) {
                this.left -= (long) read;
            }
            return read;
        }
    }

    public static byte[] toByteArray(InputStream inputStream, long j) throws IOException {
        Preconditions.checkArgument(j >= 0, "expectedSize (%s) must be non-negative", j);
        if (j <= 2147483639) {
            int i = (int) j;
            byte[] bArr = new byte[i];
            int i2 = i;
            while (i2 > 0) {
                int i3 = i - i2;
                int read = inputStream.read(bArr, i3, i2);
                if (read == -1) {
                    return Arrays.copyOf(bArr, i3);
                }
                i2 -= read;
            }
            int read2 = inputStream.read();
            if (read2 == -1) {
                return bArr;
            }
            ArrayDeque arrayDeque = new ArrayDeque(22);
            arrayDeque.add(bArr);
            arrayDeque.add(new byte[]{(byte) read2});
            return toByteArrayInternal(inputStream, arrayDeque, i + 1);
        }
        StringBuilder sb = new StringBuilder(62);
        sb.append(j);
        sb.append(" bytes is too large to fit in a byte array");
        throw new OutOfMemoryError(sb.toString());
    }

    @Beta
    public static ByteArrayDataInput newDataInput(ByteArrayInputStream byteArrayInputStream) {
        return new ByteArrayDataInputStream((ByteArrayInputStream) Preconditions.checkNotNull(byteArrayInputStream));
    }

    @Beta
    public static ByteArrayDataOutput newDataOutput(ByteArrayOutputStream byteArrayOutputStream) {
        return new ByteArrayDataOutputStream((ByteArrayOutputStream) Preconditions.checkNotNull(byteArrayOutputStream));
    }

    @CanIgnoreReturnValue
    public static long copy(ReadableByteChannel readableByteChannel, WritableByteChannel writableByteChannel) throws IOException {
        Preconditions.checkNotNull(readableByteChannel);
        Preconditions.checkNotNull(writableByteChannel);
        long j = 0;
        if (readableByteChannel instanceof FileChannel) {
            FileChannel fileChannel = (FileChannel) readableByteChannel;
            long position = fileChannel.position();
            long j2 = position;
            while (true) {
                long transferTo = fileChannel.transferTo(j2, PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED, writableByteChannel);
                j2 += transferTo;
                fileChannel.position(j2);
                if (transferTo <= 0 && j2 >= fileChannel.size()) {
                    return j2 - position;
                }
            }
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(createBuffer());
            while (readableByteChannel.read(wrap) != -1) {
                Java8Compatibility.flip(wrap);
                while (wrap.hasRemaining()) {
                    j += (long) writableByteChannel.write(wrap);
                }
                Java8Compatibility.clear(wrap);
            }
            return j;
        }
    }
}
