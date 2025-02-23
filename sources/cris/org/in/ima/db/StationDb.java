package cris.org.in.ima.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import cris.org.in.ima.model.StationModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public final class StationDb extends SQLiteOpenHelper {
    public static final SimpleDateFormat a = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    public static final int c = 1;

    /* renamed from: c  reason: collision with other field name */
    public static final String f4378c = "dbapp.db";

    /* renamed from: a  reason: collision with other field name */
    public final Context f4379a;

    public class a {
        public final String a;

        /* renamed from: a  reason: collision with other field name */
        public Date f4380a;

        public a(String str, Date date) {
            this.a = str;
            this.f4380a = date;
        }

        public final String toString() {
            return "StnListHash{hashcode='" + this.a + "', timeStamp=" + this.f4380a + '}';
        }
    }

    static {
        C1354qp.R(StationDb.class);
    }

    public StationDb(Context context) {
        super(context, f4378c, (SQLiteDatabase.CursorFactory) null, c);
        this.f4379a = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0065, code lost:
        if (r1 != null) goto L_0x0067;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a() {
        /*
            r6 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r6.getReadableDatabase()     // Catch:{ SQLiteException -> 0x005e, all -> 0x004f }
            java.lang.String r2 = "select fromStn,toStn from last_Search_Pair where id=1"
            android.database.Cursor r2 = r1.rawQuery(r2, r0)     // Catch:{ SQLiteException -> 0x004d, all -> 0x0048 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            if (r3 == 0) goto L_0x0042
        L_0x0011:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            r4 = 0
            java.lang.String r4 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            java.lang.String r4 = ":"
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            r4 = 1
            java.lang.String r4 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            r3.append(r4)     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            if (r4 != 0) goto L_0x0011
            r2.close()     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            r1.close()     // Catch:{ SQLiteException -> 0x0060, all -> 0x0046 }
            r2.close()
            r1.close()
            return r3
        L_0x0042:
            r2.close()
            goto L_0x0067
        L_0x0046:
            r0 = move-exception
            goto L_0x0053
        L_0x0048:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L_0x0053
        L_0x004d:
            r2 = r0
            goto L_0x0060
        L_0x004f:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L_0x0053:
            if (r2 == 0) goto L_0x0058
            r2.close()
        L_0x0058:
            if (r1 == 0) goto L_0x005d
            r1.close()
        L_0x005d:
            throw r0
        L_0x005e:
            r1 = r0
            r2 = r1
        L_0x0060:
            if (r2 == 0) goto L_0x0065
            r2.close()
        L_0x0065:
            if (r1 == 0) goto L_0x006a
        L_0x0067:
            r1.close()
        L_0x006a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.db.StationDb.a():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x003b, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003e, code lost:
        if (r3 != null) goto L_0x0040;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0029 A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v3 android.database.Cursor) = (r2v0 android.database.Cursor), (r2v4 android.database.Cursor) binds: [B:3:0x0008, B:7:0x0017] A[DONT_GENERATE, DONT_INLINE], Splitter:B:3:0x0008] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "select count(*) from "
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r4.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0038, all -> 0x002b }
            java.lang.String r5 = r0.concat(r5)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0029 }
            android.database.Cursor r2 = r3.rawQuery(r5, r2)     // Catch:{ SQLiteException -> 0x0039, all -> 0x0029 }
            boolean r5 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0039, all -> 0x0029 }
            if (r5 == 0) goto L_0x0025
            r5 = r1
        L_0x0017:
            int r5 = r2.getInt(r1)     // Catch:{ SQLiteException -> 0x0023, all -> 0x0029 }
            boolean r0 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0023, all -> 0x0029 }
            if (r0 != 0) goto L_0x0017
            r1 = r5
            goto L_0x0025
        L_0x0023:
            r1 = r5
            goto L_0x0039
        L_0x0025:
            r2.close()
            goto L_0x0040
        L_0x0029:
            r5 = move-exception
            goto L_0x002d
        L_0x002b:
            r5 = move-exception
            r3 = r2
        L_0x002d:
            if (r2 == 0) goto L_0x0032
            r2.close()
        L_0x0032:
            if (r3 == 0) goto L_0x0037
            r3.close()
        L_0x0037:
            throw r5
        L_0x0038:
            r3 = r2
        L_0x0039:
            if (r2 == 0) goto L_0x003e
            r2.close()
        L_0x003e:
            if (r3 == 0) goto L_0x0043
        L_0x0040:
            r3.close()
        L_0x0043:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.db.StationDb.b(java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0075, code lost:
        if (r2 != null) goto L_0x005b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList<cris.org.in.ima.model.StationModel> c() {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r7.getReadableDatabase()     // Catch:{ Exception -> 0x0067, all -> 0x0064 }
            java.lang.String r3 = "select snameEn,snameHi,scode,scityEn,scityHi,sStateEn,sStateHi from stns"
            android.database.Cursor r3 = r2.rawQuery(r3, r1)     // Catch:{ Exception -> 0x0061, all -> 0x005f }
            boolean r4 = r3.moveToFirst()     // Catch:{ Exception -> 0x0056 }
            if (r4 == 0) goto L_0x0058
        L_0x0016:
            cris.org.in.ima.model.StationModel r4 = new cris.org.in.ima.model.StationModel     // Catch:{ Exception -> 0x0056 }
            r4.<init>()     // Catch:{ Exception -> 0x0056 }
            r5 = 0
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x0056 }
            r6 = 1
            java.lang.String r6 = r3.getString(r6)     // Catch:{ Exception -> 0x0056 }
            r4.d = r6     // Catch:{ Exception -> 0x0056 }
            r4.b = r5     // Catch:{ Exception -> 0x0056 }
            r5 = 2
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x0056 }
            r4.f5341a = r5     // Catch:{ Exception -> 0x0056 }
            r5 = 3
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x0056 }
            r6 = 4
            java.lang.String r6 = r3.getString(r6)     // Catch:{ Exception -> 0x0056 }
            r4.c = r5     // Catch:{ Exception -> 0x0056 }
            r4.e = r6     // Catch:{ Exception -> 0x0056 }
            r5 = 5
            java.lang.String r5 = r3.getString(r5)     // Catch:{ Exception -> 0x0056 }
            r6 = 6
            java.lang.String r6 = r3.getString(r6)     // Catch:{ Exception -> 0x0056 }
            r4.g = r6     // Catch:{ Exception -> 0x0056 }
            r4.f = r5     // Catch:{ Exception -> 0x0056 }
            r0.add(r4)     // Catch:{ Exception -> 0x0056 }
            boolean r4 = r3.moveToNext()     // Catch:{ Exception -> 0x0056 }
            if (r4 != 0) goto L_0x0016
            goto L_0x0058
        L_0x0056:
            r4 = move-exception
            goto L_0x006a
        L_0x0058:
            r3.close()
        L_0x005b:
            r2.close()
            goto L_0x0078
        L_0x005f:
            r0 = move-exception
            goto L_0x0082
        L_0x0061:
            r4 = move-exception
            r3 = r1
            goto L_0x006a
        L_0x0064:
            r0 = move-exception
            r2 = r1
            goto L_0x0082
        L_0x0067:
            r4 = move-exception
            r2 = r1
            r3 = r2
        L_0x006a:
            r4.getMessage()     // Catch:{ all -> 0x0080 }
            cris.org.in.ima.services.StationListFetch.a()     // Catch:{ all -> 0x0080 }
            if (r3 == 0) goto L_0x0075
            r3.close()
        L_0x0075:
            if (r2 == 0) goto L_0x0078
            goto L_0x005b
        L_0x0078:
            boolean r2 = r0.isEmpty()
            if (r2 == 0) goto L_0x007f
            r0 = r1
        L_0x007f:
            return r0
        L_0x0080:
            r0 = move-exception
            r1 = r3
        L_0x0082:
            if (r1 == 0) goto L_0x0087
            r1.close()
        L_0x0087:
            if (r2 == 0) goto L_0x008c
            r2.close()
        L_0x008c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.db.StationDb.c():java.util.ArrayList");
    }

    public final ArrayList<StationModel> e() {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (readableDatabase != null) {
            Cursor rawQuery = readableDatabase.rawQuery("select stnName,stnCode from recent_Search_Stn ORDER BY timeStamp DESC", (String[]) null);
            if (rawQuery != null) {
                if (rawQuery.moveToFirst()) {
                    ArrayList<StationModel> arrayList = new ArrayList<>();
                    do {
                        StationModel stationModel = new StationModel();
                        String string = rawQuery.getString(0);
                        stationModel.d = "";
                        stationModel.b = string;
                        stationModel.f5341a = rawQuery.getString(1);
                        arrayList.add(stationModel);
                    } while (rawQuery.moveToNext());
                    rawQuery.close();
                    readableDatabase.close();
                    return arrayList;
                }
                rawQuery.close();
            }
            readableDatabase.close();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006c, code lost:
        if (r1 != null) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String h(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r8.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0065, all -> 0x0056 }
            java.lang.String r2 = "SELECT scityEn, scityHi FROM stns WHERE scode MATCH ?"
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0054, all -> 0x004f }
            r5 = 0
            r4[r5] = r9     // Catch:{ SQLiteException -> 0x0054, all -> 0x004f }
            android.database.Cursor r9 = r1.rawQuery(r2, r4)     // Catch:{ SQLiteException -> 0x0054, all -> 0x004f }
            boolean r2 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            if (r2 == 0) goto L_0x0049
        L_0x0017:
            java.lang.String r2 = r9.getString(r5)     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            java.lang.String r4 = r9.getString(r3)     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            boolean r6 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            if (r6 != 0) goto L_0x0017
            r9.close()     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            r1.close()     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            java.lang.String r3 = cris.org.in.ima.IrctcImaApplication.e     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            java.lang.String r5 = "hi"
            boolean r3 = r3.equalsIgnoreCase(r5)     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            if (r3 == 0) goto L_0x0042
            java.lang.String r0 = ""
            if (r4 == r0) goto L_0x0042
            if (r4 == 0) goto L_0x0042
            r9.close()
            r1.close()
            return r4
        L_0x0042:
            r9.close()
            r1.close()
            return r2
        L_0x0049:
            r9.close()
            goto L_0x006e
        L_0x004d:
            r0 = move-exception
            goto L_0x005a
        L_0x004f:
            r9 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x005a
        L_0x0054:
            r9 = r0
            goto L_0x0067
        L_0x0056:
            r9 = move-exception
            r1 = r0
            r0 = r9
            r9 = r1
        L_0x005a:
            if (r9 == 0) goto L_0x005f
            r9.close()
        L_0x005f:
            if (r1 == 0) goto L_0x0064
            r1.close()
        L_0x0064:
            throw r0
        L_0x0065:
            r9 = r0
            r1 = r9
        L_0x0067:
            if (r9 == 0) goto L_0x006c
            r9.close()
        L_0x006c:
            if (r1 == 0) goto L_0x0071
        L_0x006e:
            r1.close()
        L_0x0071:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.db.StationDb.h(java.lang.String):java.lang.String");
    }

    public final ArrayList<StationModel> j(String str) {
        SQLiteDatabase readableDatabase = getReadableDatabase();
        if (str == null || str.equals("")) {
            return new ArrayList<>();
        }
        String upperCase = str.toUpperCase();
        upperCase.getClass();
        String str2 = "%" + upperCase + "%";
        Cursor rawQuery = readableDatabase.rawQuery("SELECT snameEn, snameHi, scode, scityEn, scityHi, sStateEn, sStateHi, sTags FROM stns WHERE snameEn LIKE ? OR scode LIKE ? OR scityEn LIKE ? OR sTags LIKE ?", new String[]{str2, str2, str2, str2});
        if (rawQuery.moveToFirst()) {
            ArrayList<StationModel> arrayList = new ArrayList<>();
            do {
                StationModel stationModel = new StationModel();
                String string = rawQuery.getString(0);
                stationModel.d = rawQuery.getString(1);
                stationModel.b = string;
                stationModel.f5341a = rawQuery.getString(2);
                String string2 = rawQuery.getString(3);
                String string3 = rawQuery.getString(4);
                stationModel.c = string2;
                stationModel.e = string3;
                String string4 = rawQuery.getString(5);
                stationModel.g = rawQuery.getString(6);
                stationModel.f = string4;
                stationModel.h = rawQuery.getString(7);
                arrayList.add(stationModel);
            } while (rawQuery.moveToNext());
            rawQuery.close();
            readableDatabase.close();
            return arrayList;
        }
        rawQuery.close();
        readableDatabase.close();
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: cris.org.in.ima.db.StationDb$a} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v3, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: type inference failed for: r0v6 */
    /* JADX WARNING: type inference failed for: r0v7 */
    /* JADX WARNING: type inference failed for: r0v8 */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        r7 = r2;
        r2 = r0;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0051, code lost:
        if (r1 != null) goto L_0x0053;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0033 A[ExcHandler: all (r0v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:7:0x000d] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final cris.org.in.ima.db.StationDb.a l() throws defpackage.Pm {
        /*
            r8 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r8.getReadableDatabase()     // Catch:{ SQLiteException -> 0x004a, all -> 0x003c }
            java.lang.String r2 = "select hashcode, time_stamp from config_hash where field_name=\"station_list_hash\""
            android.database.Cursor r2 = r1.rawQuery(r2, r0)     // Catch:{ SQLiteException -> 0x003a, all -> 0x0038 }
            if (r2 == 0) goto L_0x002d
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x004c, all -> 0x0033 }
            if (r3 == 0) goto L_0x002d
            r3 = 0
            java.lang.String r3 = r2.getString(r3)     // Catch:{ Exception -> 0x0029, all -> 0x0033 }
            r4 = 1
            java.lang.String r4 = r2.getString(r4)     // Catch:{ Exception -> 0x0029, all -> 0x0033 }
            cris.org.in.ima.db.StationDb$a r5 = new cris.org.in.ima.db.StationDb$a     // Catch:{ Exception -> 0x0029, all -> 0x0033 }
            java.text.SimpleDateFormat r6 = a     // Catch:{ Exception -> 0x0029, all -> 0x0033 }
            java.util.Date r4 = r6.parse(r4)     // Catch:{ Exception -> 0x0029, all -> 0x0033 }
            r5.<init>(r3, r4)     // Catch:{ Exception -> 0x0029, all -> 0x0033 }
            r0 = r5
        L_0x0029:
            r2.close()
            goto L_0x0053
        L_0x002d:
            Pm r3 = new Pm     // Catch:{ SQLiteException -> 0x004c, all -> 0x0033 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x004c, all -> 0x0033 }
            throw r3     // Catch:{ SQLiteException -> 0x004c, all -> 0x0033 }
        L_0x0033:
            r0 = move-exception
            r7 = r2
            r2 = r0
            r0 = r7
            goto L_0x003f
        L_0x0038:
            r2 = move-exception
            goto L_0x003f
        L_0x003a:
            r2 = r0
            goto L_0x004c
        L_0x003c:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            if (r1 == 0) goto L_0x0049
            r1.close()
        L_0x0049:
            throw r2
        L_0x004a:
            r1 = r0
            r2 = r1
        L_0x004c:
            if (r2 == 0) goto L_0x0051
            r2.close()
        L_0x0051:
            if (r1 == 0) goto L_0x0056
        L_0x0053:
            r1.close()
        L_0x0056:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.db.StationDb.l():cris.org.in.ima.db.StationDb$a");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x006c, code lost:
        if (r1 != null) goto L_0x006e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0069  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String m(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r8.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0065, all -> 0x0056 }
            java.lang.String r2 = "SELECT snameEn, snameHi FROM stns WHERE scode MATCH ?"
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0054, all -> 0x004f }
            r5 = 0
            r4[r5] = r9     // Catch:{ SQLiteException -> 0x0054, all -> 0x004f }
            android.database.Cursor r9 = r1.rawQuery(r2, r4)     // Catch:{ SQLiteException -> 0x0054, all -> 0x004f }
            boolean r2 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            if (r2 == 0) goto L_0x0049
        L_0x0017:
            java.lang.String r2 = r9.getString(r5)     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            java.lang.String r4 = r9.getString(r3)     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            boolean r6 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            if (r6 != 0) goto L_0x0017
            r9.close()     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            r1.close()     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            java.lang.String r3 = cris.org.in.ima.IrctcImaApplication.e     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            java.lang.String r5 = "hi"
            boolean r3 = r3.equalsIgnoreCase(r5)     // Catch:{ SQLiteException -> 0x0067, all -> 0x004d }
            if (r3 == 0) goto L_0x0042
            java.lang.String r0 = ""
            if (r4 != r0) goto L_0x003b
            if (r4 == 0) goto L_0x0042
        L_0x003b:
            r9.close()
            r1.close()
            return r4
        L_0x0042:
            r9.close()
            r1.close()
            return r2
        L_0x0049:
            r9.close()
            goto L_0x006e
        L_0x004d:
            r0 = move-exception
            goto L_0x005a
        L_0x004f:
            r9 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x005a
        L_0x0054:
            r9 = r0
            goto L_0x0067
        L_0x0056:
            r9 = move-exception
            r1 = r0
            r0 = r9
            r9 = r1
        L_0x005a:
            if (r9 == 0) goto L_0x005f
            r9.close()
        L_0x005f:
            if (r1 == 0) goto L_0x0064
            r1.close()
        L_0x0064:
            throw r0
        L_0x0065:
            r9 = r0
            r1 = r9
        L_0x0067:
            if (r9 == 0) goto L_0x006c
            r9.close()
        L_0x006c:
            if (r1 == 0) goto L_0x0071
        L_0x006e:
            r1.close()
        L_0x0071:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.db.StationDb.m(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0070, code lost:
        if (r1 != null) goto L_0x0072;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String n(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r9 = r9.trim()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r8.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0069, all -> 0x005a }
            r2 = 1
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0058, all -> 0x0053 }
            r4 = 0
            r3[r4] = r9     // Catch:{ SQLiteException -> 0x0058, all -> 0x0053 }
            java.lang.String r9 = "select snameEn,snameHi from stns where scode = ?"
            android.database.Cursor r9 = r1.rawQuery(r9, r3)     // Catch:{ SQLiteException -> 0x0058, all -> 0x0053 }
            boolean r3 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x006b, all -> 0x0051 }
            if (r3 == 0) goto L_0x004d
        L_0x001b:
            java.lang.String r3 = r9.getString(r4)     // Catch:{ SQLiteException -> 0x006b, all -> 0x0051 }
            java.lang.String r5 = r9.getString(r2)     // Catch:{ SQLiteException -> 0x006b, all -> 0x0051 }
            boolean r6 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x006b, all -> 0x0051 }
            if (r6 != 0) goto L_0x001b
            r9.close()     // Catch:{ SQLiteException -> 0x006b, all -> 0x0051 }
            r1.close()     // Catch:{ SQLiteException -> 0x006b, all -> 0x0051 }
            java.lang.String r2 = cris.org.in.ima.IrctcImaApplication.e     // Catch:{ SQLiteException -> 0x006b, all -> 0x0051 }
            java.lang.String r4 = "hi"
            boolean r2 = r2.equalsIgnoreCase(r4)     // Catch:{ SQLiteException -> 0x006b, all -> 0x0051 }
            if (r2 == 0) goto L_0x0046
            java.lang.String r0 = ""
            if (r5 != r0) goto L_0x003f
            if (r5 == 0) goto L_0x0046
        L_0x003f:
            r9.close()
            r1.close()
            return r5
        L_0x0046:
            r9.close()
            r1.close()
            return r3
        L_0x004d:
            r9.close()
            goto L_0x0072
        L_0x0051:
            r0 = move-exception
            goto L_0x005e
        L_0x0053:
            r9 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L_0x005e
        L_0x0058:
            r9 = r0
            goto L_0x006b
        L_0x005a:
            r9 = move-exception
            r1 = r0
            r0 = r9
            r9 = r1
        L_0x005e:
            if (r9 == 0) goto L_0x0063
            r9.close()
        L_0x0063:
            if (r1 == 0) goto L_0x0068
            r1.close()
        L_0x0068:
            throw r0
        L_0x0069:
            r9 = r0
            r1 = r9
        L_0x006b:
            if (r9 == 0) goto L_0x0070
            r9.close()
        L_0x0070:
            if (r1 == 0) goto L_0x0075
        L_0x0072:
            r1.close()
        L_0x0075:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.db.StationDb.n(java.lang.String):java.lang.String");
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `config_hash` (`field_name`TEXT NOT NULL,`hashcode`TEXT NOT NULL,`time_stamp`TEXT NOT NULL,PRIMARY KEY(field_name))");
        } catch (SQLiteException unused) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS stns using fts3(snameEn text,snameHi text,scode text,scityEn TEXT,scityHi TEXT,sStateEn TEXT,sStateHi TEXT,sTags TEXT)");
        } catch (SQLiteException unused2) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS last_Search_Pair(id INT PRIMARY KEY NOT NULL,fromStn CHAR(50) NOT NULL,toStn CHAR(50) NOT NULL)");
        } catch (SQLiteException unused3) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS recent_Search_Stn(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,stnName CHAR(50) NOT NULL,stnCode CHAR(50) NOT NULL,timeStamp DATETIME NOT NULL)");
        } catch (SQLiteException unused4) {
        }
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS login_detail(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,userLogin CHAR(50) NOT NULL,loginTimeStamp CHAR(20) NOT NULL)");
        } catch (SQLiteException unused5) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: android.database.sqlite.SQLiteDatabase} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: android.database.Cursor} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.String[], java.lang.String, android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0041, code lost:
        if (r3 != null) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00c9, code lost:
        if (r3 == null) goto L_0x00ce;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d5 A[SYNTHETIC, Splitter:B:73:0x00d5] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void q(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r10.getReadableDatabase()     // Catch:{ SQLiteException -> 0x003a, all -> 0x002d }
            java.lang.String r4 = "select timeStamp from recent_Search_Stn where stnName=?"
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x002b, all -> 0x0029 }
            r5[r2] = r11     // Catch:{ SQLiteException -> 0x002b, all -> 0x0029 }
            android.database.Cursor r4 = r3.rawQuery(r4, r5)     // Catch:{ SQLiteException -> 0x002b, all -> 0x0029 }
            boolean r5 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0026 }
            if (r5 == 0) goto L_0x0022
            r4.close()     // Catch:{ SQLiteException -> 0x003c, all -> 0x0026 }
            r4.close()
            r3.close()
            r3 = r0
            goto L_0x0047
        L_0x0022:
            r4.close()
            goto L_0x0043
        L_0x0026:
            r11 = move-exception
            r1 = r4
            goto L_0x002f
        L_0x0029:
            r11 = move-exception
            goto L_0x002f
        L_0x002b:
            r4 = r1
            goto L_0x003c
        L_0x002d:
            r11 = move-exception
            r3 = r1
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.close()
        L_0x0034:
            if (r3 == 0) goto L_0x0039
            r3.close()
        L_0x0039:
            throw r11
        L_0x003a:
            r3 = r1
            r4 = r3
        L_0x003c:
            if (r4 == 0) goto L_0x0041
            r4.close()
        L_0x0041:
            if (r3 == 0) goto L_0x0046
        L_0x0043:
            r3.close()
        L_0x0046:
            r3 = r2
        L_0x0047:
            java.lang.String r4 = "timeStamp"
            java.lang.String r5 = "yyyy-MM-dd HH:mm:ss"
            java.lang.String r6 = "recent_Search_Stn"
            if (r3 != 0) goto L_0x010e
            int r3 = r10.b(r6)
            r7 = 8
            java.lang.String r8 = "stnCode"
            java.lang.String r9 = "stnName"
            if (r3 >= r7) goto L_0x008e
            android.database.sqlite.SQLiteDatabase r0 = r10.getWritableDatabase()
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0081 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x0081 }
            java.util.Date r3 = new java.util.Date     // Catch:{ Exception -> 0x0081 }
            r3.<init>()     // Catch:{ Exception -> 0x0081 }
            java.lang.String r2 = r2.format(r3)     // Catch:{ Exception -> 0x0081 }
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x0081 }
            r3.<init>()     // Catch:{ Exception -> 0x0081 }
            r3.put(r9, r11)     // Catch:{ Exception -> 0x0081 }
            r3.put(r8, r12)     // Catch:{ Exception -> 0x0081 }
            r3.put(r4, r2)     // Catch:{ Exception -> 0x0081 }
            r0.insert(r6, r1, r3)     // Catch:{ Exception -> 0x0081 }
            goto L_0x0085
        L_0x007f:
            r11 = move-exception
            goto L_0x008a
        L_0x0081:
            r11 = move-exception
            r11.getMessage()     // Catch:{ all -> 0x007f }
        L_0x0085:
            r0.close()
            goto L_0x013e
        L_0x008a:
            r0.close()
            throw r11
        L_0x008e:
            android.database.sqlite.SQLiteDatabase r3 = r10.getReadableDatabase()     // Catch:{ SQLiteException -> 0x00c3, all -> 0x00b6 }
            java.lang.String r7 = "SELECT id FROM recent_Search_Stn ORDER BY timeStamp ASC LIMIT 1;"
            android.database.Cursor r1 = r3.rawQuery(r7, r1)     // Catch:{ SQLiteException -> 0x00c4, all -> 0x00b4 }
            boolean r7 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00c4, all -> 0x00b4 }
            if (r7 == 0) goto L_0x00b0
            java.lang.String r7 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x00c4, all -> 0x00b4 }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ SQLiteException -> 0x00c4, all -> 0x00b4 }
            r1.close()     // Catch:{ SQLiteException -> 0x00c4, all -> 0x00b4 }
            r1.close()
            r3.close()
            goto L_0x00cf
        L_0x00b0:
            r1.close()
            goto L_0x00cb
        L_0x00b4:
            r11 = move-exception
            goto L_0x00b8
        L_0x00b6:
            r11 = move-exception
            r3 = r1
        L_0x00b8:
            if (r1 == 0) goto L_0x00bd
            r1.close()
        L_0x00bd:
            if (r3 == 0) goto L_0x00c2
            r3.close()
        L_0x00c2:
            throw r11
        L_0x00c3:
            r3 = r1
        L_0x00c4:
            if (r1 == 0) goto L_0x00c9
            r1.close()
        L_0x00c9:
            if (r3 == 0) goto L_0x00ce
        L_0x00cb:
            r3.close()
        L_0x00ce:
            r7 = r2
        L_0x00cf:
            android.database.sqlite.SQLiteDatabase r1 = r10.getWritableDatabase()
            if (r7 == 0) goto L_0x010a
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0101 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0101 }
            java.util.Date r5 = new java.util.Date     // Catch:{ Exception -> 0x0101 }
            r5.<init>()     // Catch:{ Exception -> 0x0101 }
            java.lang.String r3 = r3.format(r5)     // Catch:{ Exception -> 0x0101 }
            android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ Exception -> 0x0101 }
            r5.<init>()     // Catch:{ Exception -> 0x0101 }
            r5.put(r9, r11)     // Catch:{ Exception -> 0x0101 }
            r5.put(r8, r12)     // Catch:{ Exception -> 0x0101 }
            r5.put(r4, r3)     // Catch:{ Exception -> 0x0101 }
            java.lang.String r11 = "id=?"
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0101 }
            java.lang.String r0 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x0101 }
            r12[r2] = r0     // Catch:{ Exception -> 0x0101 }
            r1.update(r6, r5, r11, r12)     // Catch:{ Exception -> 0x0101 }
            goto L_0x010a
        L_0x00ff:
            r11 = move-exception
            goto L_0x0106
        L_0x0101:
            r11 = move-exception
            r11.getMessage()     // Catch:{ all -> 0x00ff }
            goto L_0x010a
        L_0x0106:
            r1.close()
            throw r11
        L_0x010a:
            r1.close()
            goto L_0x013e
        L_0x010e:
            android.database.sqlite.SQLiteDatabase r1 = r10.getWritableDatabase()
            android.content.ContentValues r3 = new android.content.ContentValues     // Catch:{ Exception -> 0x0137 }
            r3.<init>()     // Catch:{ Exception -> 0x0137 }
            java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x0137 }
            r7.<init>(r5)     // Catch:{ Exception -> 0x0137 }
            java.util.Date r5 = new java.util.Date     // Catch:{ Exception -> 0x0137 }
            r5.<init>()     // Catch:{ Exception -> 0x0137 }
            java.lang.String r5 = r7.format(r5)     // Catch:{ Exception -> 0x0137 }
            r3.put(r4, r5)     // Catch:{ Exception -> 0x0137 }
            java.lang.String r4 = "stnName=? and stnCode=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ Exception -> 0x0137 }
            r5[r2] = r11     // Catch:{ Exception -> 0x0137 }
            r5[r0] = r12     // Catch:{ Exception -> 0x0137 }
            r1.update(r6, r3, r4, r5)     // Catch:{ Exception -> 0x0137 }
            goto L_0x013b
        L_0x0135:
            r11 = move-exception
            goto L_0x013f
        L_0x0137:
            r11 = move-exception
            r11.getMessage()     // Catch:{ all -> 0x0135 }
        L_0x013b:
            r1.close()
        L_0x013e:
            return
        L_0x013f:
            r1.close()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.db.StationDb.q(java.lang.String, java.lang.String):void");
    }

    public final void r(String str, String str2) {
        if (b("last_Search_Pair") == 0) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put(FacebookMediationAdapter.KEY_ID, 1);
                contentValues.put("fromStn", str);
                contentValues.put("toStn", str2);
                writableDatabase.insert("last_Search_Pair", (String) null, contentValues);
            } catch (Exception e) {
                e.getMessage();
            } catch (Throwable th) {
                writableDatabase.close();
                throw th;
            }
            writableDatabase.close();
            return;
        }
        SQLiteDatabase writableDatabase2 = getWritableDatabase();
        try {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("fromStn", str);
            contentValues2.put("toStn", str2);
            writableDatabase2.update("last_Search_Pair", contentValues2, "id=1", (String[]) null);
        } catch (Exception e2) {
            e2.getMessage();
        } catch (Throwable th2) {
            writableDatabase2.close();
            throw th2;
        }
        writableDatabase2.close();
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }
}
