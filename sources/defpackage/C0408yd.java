package defpackage;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import java.io.IOException;

/* renamed from: yd  reason: default package and case insensitive filesystem */
/* compiled from: FrameworkSQLiteDatabase */
public final class C0408yd implements Ky {
    public static final String[] a = new String[0];

    /* renamed from: a  reason: collision with other field name */
    public final SQLiteDatabase f3431a;

    /* renamed from: yd$a */
    /* compiled from: FrameworkSQLiteDatabase */
    public class a implements SQLiteDatabase.CursorFactory {
        public final /* synthetic */ My a;

        public a(My my) {
            this.a = my;
        }

        public final Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
            this.a.a(new C0084Bd(sQLiteQuery));
            return new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        }
    }

    public C0408yd(SQLiteDatabase sQLiteDatabase) {
        this.f3431a = sQLiteDatabase;
    }

    public final void a() {
        this.f3431a.beginTransaction();
    }

    public final void b() {
        this.f3431a.endTransaction();
    }

    public final void c(String str) throws SQLException {
        this.f3431a.execSQL(str);
    }

    public final void close() throws IOException {
        this.f3431a.close();
    }

    public final Cursor e(My my) {
        return this.f3431a.rawQueryWithFactory(new a(my), my.b(), a, (String) null);
    }

    public final Cursor h(String str) {
        return e(new Pw(str));
    }

    public final void j() {
        this.f3431a.setTransactionSuccessful();
    }
}
