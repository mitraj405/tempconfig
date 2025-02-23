package okhttp3.internal.huc;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.logging.Logger;
import okhttp3.internal.http.UnrepeatableRequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.Pipe;

final class StreamedRequestBody extends OutputStreamRequestBody implements UnrepeatableRequestBody {
    private final Pipe pipe;

    public StreamedRequestBody(long j) {
        Pipe pipe2 = new Pipe();
        this.pipe = pipe2;
        Logger logger = C1517zn.a;
        initOutputStream(new C1519zs(pipe2.f5634a), j);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Buffer buffer = new Buffer();
        while (this.pipe.f5635a.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
            bufferedSink.write(buffer, buffer.f5623a);
        }
    }
}
