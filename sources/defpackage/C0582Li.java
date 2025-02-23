package defpackage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.SimpleDateFormat;

/* renamed from: Li  reason: default package and case insensitive filesystem */
/* compiled from: LoginDb */
public final class C0582Li extends SQLiteOpenHelper {
    public static final SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public static final int c = 1;

    /* renamed from: c  reason: collision with other field name */
    public static final String f3698c = "dbapp.db";

    /* renamed from: a  reason: collision with other field name */
    public final Context f3699a;

    static {
        C1354qp.R(C0582Li.class);
    }

    public C0582Li(Context context) {
        super(context, f3698c, (SQLiteDatabase.CursorFactory) null, c);
        this.f3699a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0055, code lost:
        if (r1 != null) goto L_0x0057;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r6.getReadableDatabase()     // Catch:{ SQLiteException -> 0x004e, all -> 0x0041 }
            java.lang.String r2 = "select userLogin, loginTimeStamp from login_detail"
            android.database.Cursor r2 = r1.rawQuery(r2, r0)     // Catch:{ SQLiteException -> 0x003f, all -> 0x003d }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0050, all -> 0x003a }
            if (r3 == 0) goto L_0x0036
            r3 = r0
        L_0x0012:
            r4 = 0
            java.lang.String r4 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x0050, all -> 0x003a }
            r5 = 1
            java.lang.String r5 = r2.getString(r5)     // Catch:{ SQLiteException -> 0x0050, all -> 0x003a }
            boolean r4 = r4.equalsIgnoreCase(r7)     // Catch:{ SQLiteException -> 0x0050, all -> 0x003a }
            if (r4 == 0) goto L_0x0023
            r3 = r5
        L_0x0023:
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0050, all -> 0x003a }
            if (r4 != 0) goto L_0x0012
            r2.close()     // Catch:{ SQLiteException -> 0x0050, all -> 0x003a }
            r1.close()     // Catch:{ SQLiteException -> 0x0050, all -> 0x003a }
            r2.close()
            r1.close()
            return r3
        L_0x0036:
            r2.close()
            goto L_0x0057
        L_0x003a:
            r7 = move-exception
            r0 = r2
            goto L_0x0043
        L_0x003d:
            r7 = move-exception
            goto L_0x0043
        L_0x003f:
            r2 = r0
            goto L_0x0050
        L_0x0041:
            r7 = move-exception
            r1 = r0
        L_0x0043:
            if (r0 == 0) goto L_0x0048
            r0.close()
        L_0x0048:
            if (r1 == 0) goto L_0x004d
            r1.close()
        L_0x004d:
            throw r7
        L_0x004e:
            r1 = r0
            r2 = r1
        L_0x0050:
            if (r2 == 0) goto L_0x0055
            r2.close()
        L_0x0055:
            if (r1 == 0) goto L_0x005a
        L_0x0057:
            r1.close()
        L_0x005a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0582Li.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|10|11|12|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        r5 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        r0 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0011 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r5, java.util.Date r6) {
        /*
            r4 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x0038 }
            java.lang.String r2 = "delete from login_detail"
            r1.execSQL(r2)     // Catch:{ SQLiteException -> 0x0011 }
            goto L_0x0011
        L_0x000b:
            r5 = move-exception
            r0 = r1
            goto L_0x0045
        L_0x000e:
            r5 = move-exception
            r0 = r1
            goto L_0x0039
        L_0x0011:
            r1.close()     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            android.database.sqlite.SQLiteDatabase r1 = r4.getWritableDatabase()     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            r2.<init>()     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            java.lang.String r3 = "userLogin"
            r2.put(r3, r5)     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            java.lang.String r5 = "loginTimeStamp"
            java.text.SimpleDateFormat r3 = a     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            java.lang.String r3 = r3.format(r6)     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            r2.put(r5, r3)     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            java.lang.String r5 = "login_detail"
            r1.insert(r5, r0, r2)     // Catch:{ Exception -> 0x000e, all -> 0x000b }
            r1.close()
            goto L_0x0044
        L_0x0036:
            r5 = move-exception
            goto L_0x0045
        L_0x0038:
            r5 = move-exception
        L_0x0039:
            java.util.Objects.toString(r6)     // Catch:{ all -> 0x0036 }
            r5.getMessage()     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            return
        L_0x0045:
            if (r0 == 0) goto L_0x004a
            r0.close()
        L_0x004a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0582Li.b(java.lang.String, java.util.Date):void");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS login_detail(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,userLogin CHAR(50) NOT NULL,loginTimeStamp CHAR(20) NOT NULL)");
        } catch (SQLiteException unused) {
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
