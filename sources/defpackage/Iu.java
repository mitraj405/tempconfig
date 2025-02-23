package defpackage;

import java.io.File;
import java.io.IOException;

/* renamed from: Iu  reason: default package */
/* compiled from: SQLiteCopyOpenHelper */
public final class Iu implements Ly {
    public b8 a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f266a;

    public final void a(File file) throws IOException {
        throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
    }

    public final void b() {
        getDatabaseName();
        throw null;
    }

    public final synchronized void close() {
        throw null;
    }

    public final synchronized Ky f() {
        if (!this.f266a) {
            b();
            this.f266a = true;
        }
        throw null;
    }

    public final String getDatabaseName() {
        throw null;
    }

    public final void setWriteAheadLoggingEnabled(boolean z) {
        throw null;
    }
}
