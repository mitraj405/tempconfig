package defpackage;

import android.database.sqlite.SQLiteProgram;
import java.io.Closeable;

/* renamed from: Bd  reason: default package and case insensitive filesystem */
/* compiled from: FrameworkSQLiteProgram */
public class C0084Bd implements Closeable {
    public final SQLiteProgram a;

    public C0084Bd(SQLiteProgram sQLiteProgram) {
        this.a = sQLiteProgram;
    }

    public final void a(int i, byte[] bArr) {
        this.a.bindBlob(i, bArr);
    }

    public final void b(double d, int i) {
        this.a.bindDouble(i, d);
    }

    public final void c(int i, long j) {
        this.a.bindLong(i, j);
    }

    public final void close() {
        this.a.close();
    }

    public final void e(int i) {
        this.a.bindNull(i);
    }

    public final void h(int i, String str) {
        this.a.bindString(i, str);
    }
}
