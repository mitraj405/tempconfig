package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.io.Closeable;
import java.io.File;

/* renamed from: Ly  reason: default package */
/* compiled from: SupportSQLiteOpenHelper */
public interface Ly extends Closeable {

    /* renamed from: Ly$a */
    /* compiled from: SupportSQLiteOpenHelper */
    public static abstract class a {
        public final int a;

        public a(int i) {
            this.a = i;
        }

        public static void a(String str) {
            if (!str.equalsIgnoreCase(":memory:") && str.trim().length() != 0) {
                try {
                    SQLiteDatabase.deleteDatabase(new File(str));
                } catch (Exception unused) {
                }
            }
        }

        public abstract void b(C0408yd ydVar, int i, int i2);
    }

    /* renamed from: Ly$b */
    /* compiled from: SupportSQLiteOpenHelper */
    public static class b {
        public final a a;

        /* renamed from: a  reason: collision with other field name */
        public final Context f391a;

        /* renamed from: a  reason: collision with other field name */
        public final String f392a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f393a;

        public b(Context context, String str, a aVar, boolean z) {
            this.f391a = context;
            this.f392a = str;
            this.a = aVar;
            this.f393a = z;
        }
    }

    /* renamed from: Ly$c */
    /* compiled from: SupportSQLiteOpenHelper */
    public interface c {
        Ly a(b bVar);
    }

    void close();

    Ky f();

    String getDatabaseName();

    void setWriteAheadLoggingEnabled(boolean z);
}
