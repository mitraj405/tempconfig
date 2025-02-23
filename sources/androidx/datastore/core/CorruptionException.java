package androidx.datastore.core;

import androidx.datastore.preferences.protobuf.q;
import java.io.IOException;

/* compiled from: Serializer.kt */
public final class CorruptionException extends IOException {
    public CorruptionException(q qVar) {
        super("Unable to parse preferences proto.", qVar);
    }

    public CorruptionException(String str) {
        super(str, (Throwable) null);
    }
}
