package okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.m("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.m("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final Buffer buffer = new Buffer();
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    final Buffer upstreamBuffer = new Buffer();
    long upstreamPos;
    Thread upstreamReader;

    public class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                synchronized (Relay.this) {
                    Relay relay = Relay.this;
                    int i = relay.sourceCount - 1;
                    relay.sourceCount = i;
                    if (i == 0) {
                        RandomAccessFile randomAccessFile2 = relay.file;
                        relay.file = null;
                        randomAccessFile = randomAccessFile2;
                    }
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
            r13 = r7 - r0.buffer.f5623a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            if (r5 >= r13) goto L_0x00e9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
            r0 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
            r2 = java.lang.Math.min(r2, r7 - r5);
            r1.this$0.buffer.e(r1.sourcePos - r13, r22, r2);
            r1.sourcePos += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x0103, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(okio.Buffer r22, long r23) throws java.io.IOException {
            /*
                r21 = this;
                r1 = r21
                r2 = r23
                okhttp3.internal.cache2.FileOperator r0 = r1.fileOperator
                if (r0 == 0) goto L_0x0107
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r4)
            L_0x000b:
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0104 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0104 }
                long r7 = r0.upstreamPos     // Catch:{ all -> 0x0104 }
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                r10 = 2
                r11 = -1
                if (r9 != 0) goto L_0x0031
                boolean r5 = r0.complete     // Catch:{ all -> 0x0104 }
                if (r5 == 0) goto L_0x001e
                monitor-exit(r4)     // Catch:{ all -> 0x0104 }
                return r11
            L_0x001e:
                java.lang.Thread r5 = r0.upstreamReader     // Catch:{ all -> 0x0104 }
                if (r5 == 0) goto L_0x0028
                okio.Timeout r5 = r1.timeout     // Catch:{ all -> 0x0104 }
                r5.waitUntilNotified(r0)     // Catch:{ all -> 0x0104 }
                goto L_0x000b
            L_0x0028:
                java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0104 }
                r0.upstreamReader = r5     // Catch:{ all -> 0x0104 }
                monitor-exit(r4)     // Catch:{ all -> 0x0104 }
                r0 = 1
                goto L_0x003d
            L_0x0031:
                okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x0104 }
                long r13 = r0.f5623a     // Catch:{ all -> 0x0104 }
                long r13 = r7 - r13
                int r0 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
                if (r0 >= 0) goto L_0x00e9
                monitor-exit(r4)     // Catch:{ all -> 0x0104 }
                r0 = r10
            L_0x003d:
                r4 = 32
                if (r0 != r10) goto L_0x005a
                long r9 = r1.sourcePos
                long r7 = r7 - r9
                long r2 = java.lang.Math.min(r2, r7)
                okhttp3.internal.cache2.FileOperator r9 = r1.fileOperator
                long r6 = r1.sourcePos
                long r10 = r6 + r4
                r12 = r22
                r13 = r2
                r9.read(r10, r12, r13)
                long r4 = r1.sourcePos
                long r4 = r4 + r2
                r1.sourcePos = r4
                return r2
            L_0x005a:
                r6 = 0
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d9 }
                okio.Source r9 = r0.upstream     // Catch:{ all -> 0x00d9 }
                okio.Buffer r10 = r0.upstreamBuffer     // Catch:{ all -> 0x00d9 }
                long r13 = r0.bufferMaxSize     // Catch:{ all -> 0x00d9 }
                long r9 = r9.read(r10, r13)     // Catch:{ all -> 0x00d9 }
                int r0 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                if (r0 != 0) goto L_0x007f
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d9 }
                r0.commit(r7)     // Catch:{ all -> 0x00d9 }
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x007c }
                r0.upstreamReader = r6     // Catch:{ all -> 0x007c }
                r0.notifyAll()     // Catch:{ all -> 0x007c }
                monitor-exit(r2)     // Catch:{ all -> 0x007c }
                return r11
            L_0x007c:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x007c }
                throw r0
            L_0x007f:
                long r2 = java.lang.Math.min(r9, r2)     // Catch:{ all -> 0x00d9 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d9 }
                okio.Buffer r11 = r0.upstreamBuffer     // Catch:{ all -> 0x00d9 }
                r12 = 0
                r14 = r22
                r15 = r2
                r11.e(r12, r14, r15)     // Catch:{ all -> 0x00d9 }
                long r11 = r1.sourcePos     // Catch:{ all -> 0x00d9 }
                long r11 = r11 + r2
                r1.sourcePos = r11     // Catch:{ all -> 0x00d9 }
                okhttp3.internal.cache2.FileOperator r15 = r1.fileOperator     // Catch:{ all -> 0x00d9 }
                long r16 = r7 + r4
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d9 }
                okio.Buffer r0 = r0.upstreamBuffer     // Catch:{ all -> 0x00d9 }
                okio.Buffer r18 = r0.clone()     // Catch:{ all -> 0x00d9 }
                r19 = r9
                r15.write(r16, r18, r19)     // Catch:{ all -> 0x00d9 }
                okhttp3.internal.cache2.Relay r4 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d9 }
                monitor-enter(r4)     // Catch:{ all -> 0x00d9 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d6 }
                okio.Buffer r5 = r0.buffer     // Catch:{ all -> 0x00d6 }
                okio.Buffer r0 = r0.upstreamBuffer     // Catch:{ all -> 0x00d6 }
                r5.write(r0, r9)     // Catch:{ all -> 0x00d6 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d6 }
                okio.Buffer r5 = r0.buffer     // Catch:{ all -> 0x00d6 }
                long r7 = r5.f5623a     // Catch:{ all -> 0x00d6 }
                long r11 = r0.bufferMaxSize     // Catch:{ all -> 0x00d6 }
                int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r0 <= 0) goto L_0x00c1
                long r7 = r7 - r11
                r5.d0(r7)     // Catch:{ all -> 0x00d6 }
            L_0x00c1:
                okhttp3.internal.cache2.Relay r5 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d6 }
                long r7 = r5.upstreamPos     // Catch:{ all -> 0x00d6 }
                long r7 = r7 + r9
                r5.upstreamPos = r7     // Catch:{ all -> 0x00d6 }
                monitor-exit(r4)     // Catch:{ all -> 0x00d6 }
                monitor-enter(r5)
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00d3 }
                r0.upstreamReader = r6     // Catch:{ all -> 0x00d3 }
                r0.notifyAll()     // Catch:{ all -> 0x00d3 }
                monitor-exit(r5)     // Catch:{ all -> 0x00d3 }
                return r2
            L_0x00d3:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x00d3 }
                throw r0
            L_0x00d6:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x00d6 }
                throw r0     // Catch:{ all -> 0x00d9 }
            L_0x00d9:
                r0 = move-exception
                okhttp3.internal.cache2.Relay r2 = okhttp3.internal.cache2.Relay.this
                monitor-enter(r2)
                okhttp3.internal.cache2.Relay r3 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x00e6 }
                r3.upstreamReader = r6     // Catch:{ all -> 0x00e6 }
                r3.notifyAll()     // Catch:{ all -> 0x00e6 }
                monitor-exit(r2)     // Catch:{ all -> 0x00e6 }
                throw r0
            L_0x00e6:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00e6 }
                throw r0
            L_0x00e9:
                long r7 = r7 - r5
                long r2 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x0104 }
                okhttp3.internal.cache2.Relay r0 = okhttp3.internal.cache2.Relay.this     // Catch:{ all -> 0x0104 }
                okio.Buffer r15 = r0.buffer     // Catch:{ all -> 0x0104 }
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0104 }
                long r16 = r5 - r13
                r18 = r22
                r19 = r2
                r15.e(r16, r18, r19)     // Catch:{ all -> 0x0104 }
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0104 }
                long r5 = r5 + r2
                r1.sourcePos = r5     // Catch:{ all -> 0x0104 }
                monitor-exit(r4)     // Catch:{ all -> 0x0104 }
                return r2
            L_0x0104:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0104 }
                throw r0
            L_0x0107:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "closed"
                r0.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache2.Relay.RelaySource.read(okio.Buffer, long):long");
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        boolean z;
        this.file = randomAccessFile;
        this.upstream = source;
        if (source == null) {
            z = true;
        } else {
            z = false;
        }
        this.complete = z;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file2, Source source, ByteString byteString, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0, byteString, j);
        randomAccessFile.setLength(0);
        relay.writeHeader(PREFIX_DIRTY, -1, -1);
        return relay;
    }

    public static Relay read(File file2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer2 = new Buffer();
        fileOperator.read(0, buffer2, 32);
        ByteString byteString = PREFIX_CLEAN;
        if (buffer2.b0((long) byteString.A()).equals(byteString)) {
            long readLong = buffer2.readLong();
            long readLong2 = buffer2.readLong();
            Buffer buffer3 = new Buffer();
            fileOperator.read(readLong + 32, buffer3, readLong2);
            return new Relay(randomAccessFile, (Source) null, readLong, buffer3.n(), 0);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.z(byteString);
        buffer2.J(j);
        buffer2.J(j2);
        if (buffer2.f5623a == 32) {
            new FileOperator(this.file.getChannel()).write(0, buffer2, 32);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long j) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.z(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j, buffer2, (long) this.metadata.A());
    }

    public void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, (long) this.metadata.A());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly((Closeable) this.upstream);
        this.upstream = null;
    }

    public boolean isClosed() {
        if (this.file == null) {
            return true;
        }
        return false;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }
}
