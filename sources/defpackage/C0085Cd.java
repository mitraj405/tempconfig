package defpackage;

import android.database.sqlite.SQLiteStatement;

/* renamed from: Cd  reason: default package and case insensitive filesystem */
/* compiled from: FrameworkSQLiteStatement */
public final class C0085Cd extends C0084Bd {
    public final SQLiteStatement a;

    public C0085Cd(SQLiteStatement sQLiteStatement) {
        super(sQLiteStatement);
        this.a = sQLiteStatement;
    }

    public final int j() {
        return this.a.executeUpdateDelete();
    }
}
