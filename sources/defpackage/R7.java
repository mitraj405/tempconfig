package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: R7  reason: default package */
/* compiled from: DBHelper */
public final class R7 extends SQLiteOpenHelper {
    public R7(Context context) {
        super(context, "Bank.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table banks(_id integer primary key autoincrement, bank_json text not null , saving_time  text not null ,bank_type text not null);");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS banks");
        sQLiteDatabase.execSQL("create table banks(_id integer primary key autoincrement, bank_json text not null , saving_time  text not null ,bank_type text not null);");
    }
}
