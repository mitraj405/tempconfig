package defpackage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* renamed from: i2  reason: default package and case insensitive filesystem */
/* compiled from: BankDBOperations */
public final class C1168i2 {
    public static SQLiteDatabase a;

    /* renamed from: a  reason: collision with other field name */
    public static C1168i2 f5481a;

    /* renamed from: a  reason: collision with other field name */
    public final R7 f5482a;

    /* renamed from: i2$a */
    /* compiled from: BankDBOperations */
    public class a {
        public long a = 0;

        /* renamed from: a  reason: collision with other field name */
        public String f5483a = "";
    }

    public C1168i2(Context context) {
        this.f5482a = new R7(context);
    }

    public static void a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bank_json", str);
        contentValues.put("saving_time", System.currentTimeMillis() + "");
        contentValues.put("bank_type", str2);
        a.insert("banks", (String) null, contentValues);
    }

    public static a b(String str) {
        String j = lf.j("bank_type = '", str, "'");
        a aVar = null;
        a.delete("banks", j, (String[]) null);
        Cursor query = a.query("banks", (String[]) null, j, (String[]) null, (String) null, (String) null, (String) null);
        try {
            if (query.getCount() <= 0 || !query.moveToFirst()) {
                return null;
            }
            a aVar2 = new a();
            try {
                aVar2.f5483a = query.getString(1);
                aVar2.a = Long.parseLong(query.getString(2));
                return aVar2;
            } catch (Exception e) {
                e = e;
                aVar = aVar2;
                e.printStackTrace();
                return aVar;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return aVar;
        }
    }
}
