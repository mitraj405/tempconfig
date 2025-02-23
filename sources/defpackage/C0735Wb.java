package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.SimpleDateFormat;

/* renamed from: Wb  reason: default package and case insensitive filesystem */
/* compiled from: FavoritePnrDb */
public final class C0735Wb extends SQLiteOpenHelper {
    public static final SimpleDateFormat a = new SimpleDateFormat("dd-MMM-yyyy");
    public static final int c = 1;

    /* renamed from: c  reason: collision with other field name */
    public static final String f3826c = "app.db";

    /* renamed from: a  reason: collision with other field name */
    public final Context f3827a;

    static {
        C1354qp.R(C0735Wb.class);
    }

    public C0735Wb(Context context) {
        super(context, f3826c, (SQLiteDatabase.CursorFactory) null, c);
        this.f3827a = context;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS pnr_detail(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,userPNR CHAR(10) unique,jDATE CHAR(20) NOT NULL)");
        } catch (SQLiteException unused) {
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
