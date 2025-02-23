package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

public final class Pipe {
    public final long a = PlaybackStateCompat.ACTION_PLAY_FROM_URI;

    /* renamed from: a  reason: collision with other field name */
    public final Buffer f5633a = new Buffer();

    /* renamed from: a  reason: collision with other field name */
    public final a f5634a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final b f5635a = new b();

    /* renamed from: a  reason: collision with other field name */
    public boolean f5636a;
    public boolean b;

    public final class a implements Sink {
        public final C0711Uq a = new C0711Uq();

        public a() {
        }

        public final void close() throws IOException {
            synchronized (Pipe.this.f5633a) {
                Pipe pipe = Pipe.this;
                if (!pipe.f5636a) {
                    pipe.getClass();
                    Pipe pipe2 = Pipe.this;
                    if (pipe2.b) {
                        if (pipe2.f5633a.f5623a > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                    pipe2.f5636a = true;
                    pipe2.f5633a.notifyAll();
                }
            }
        }

        public final void flush() throws IOException {
            synchronized (Pipe.this.f5633a) {
                Pipe pipe = Pipe.this;
                if (!pipe.f5636a) {
                    pipe.getClass();
                    Pipe pipe2 = Pipe.this;
                    if (pipe2.b) {
                        if (pipe2.f5633a.f5623a > 0) {
                            throw new IOException("source is closed");
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
        }

        public final Timeout timeout() {
            return this.a;
        }

        public final void write(Buffer buffer, long j) throws IOException {
            synchronized (Pipe.this.f5633a) {
                if (!Pipe.this.f5636a) {
                    while (j > 0) {
                        Pipe.this.getClass();
                        Pipe pipe = Pipe.this;
                        if (!pipe.b) {
                            long j2 = pipe.a;
                            Buffer buffer2 = pipe.f5633a;
                            long j3 = j2 - buffer2.f5623a;
                            if (j3 == 0) {
                                this.a.waitUntilNotified(buffer2);
                            } else {
                                long min = Math.min(j3, j);
                                Pipe.this.f5633a.write(buffer, min);
                                j -= min;
                                Pipe.this.f5633a.notifyAll();
                            }
                        } else {
                            throw new IOException("source is closed");
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
        }
    }

    public final class b implements Source {

        /* renamed from: a  reason: collision with other field name */
        public final Timeout f5638a = new Timeout();

        public b() {
        }

        public final void close() throws IOException {
            synchronized (Pipe.this.f5633a) {
                Pipe pipe = Pipe.this;
                pipe.b = true;
                pipe.f5633a.notifyAll();
            }
        }

        public final long read(Buffer buffer, long j) throws IOException {
            synchronized (Pipe.this.f5633a) {
                if (!Pipe.this.b) {
                    while (true) {
                        Pipe pipe = Pipe.this;
                        Buffer buffer2 = pipe.f5633a;
                        if (buffer2.f5623a != 0) {
                            long read = buffer2.read(buffer, j);
                            Pipe.this.f5633a.notifyAll();
                            return read;
                        } else if (pipe.f5636a) {
                            return -1;
                        } else {
                            this.f5638a.waitUntilNotified(buffer2);
                        }
                    }
                } else {
                    throw new IllegalStateException("closed");
                }
            }
        }

        public final Timeout timeout() {
            return this.f5638a;
        }
    }
}
