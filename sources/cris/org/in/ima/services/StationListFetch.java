package cris.org.in.ima.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import cris.org.in.ima.IrctcImaApplication;
import cris.org.in.ima.db.StationDb;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import rx.Subscriber;

public class StationListFetch extends Service {
    public static final Context a = IrctcImaApplication.a;

    /* renamed from: a  reason: collision with other field name */
    public static final ArrayList<C0742Wx> f5363a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    public static final LinkedHashMap<String, ArrayList<C0742Wx>> f5364a = new LinkedHashMap<>();
    public static final ArrayList<String> b = new ArrayList<>();

    /* renamed from: b  reason: collision with other field name */
    public static final LinkedHashMap<String, ArrayList<C0742Wx>> f5365b = new LinkedHashMap<>();
    public static int c = 0;

    /* renamed from: c  reason: collision with other field name */
    public static String f5366c = null;

    /* renamed from: c  reason: collision with other field name */
    public static final ArrayList<String> f5367c = new ArrayList<>();

    public class a extends Subscriber<C0742Wx[]> {
        public final /* synthetic */ StationDb a;

        public a(StationDb stationDb, long j) {
            this.a = stationDb;
        }

        public final void onCompleted() {
            LinkedHashMap<String, ArrayList<C0742Wx>> linkedHashMap = StationListFetch.f5364a;
        }

        public final void onError(Throwable th) {
            LinkedHashMap<String, ArrayList<C0742Wx>> linkedHashMap = StationListFetch.f5364a;
            th.getClass();
            th.getMessage();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            defpackage.C0535I5.t0(r1, "Error in synchronizing station data");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
            r10 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
            r2 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0046, code lost:
            if (r3 != null) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0079, code lost:
            if (r4 == null) goto L_0x007e;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x01bd A[EDGE_INSN: B:100:0x01bd->B:92:0x01bd ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:11:0x0029] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x011e  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x012f  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0220  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onNext(java.lang.Object r10) {
            /*
                r9 = this;
                Wx[] r10 = (defpackage.C0742Wx[]) r10
                cris.org.in.ima.db.StationDb r0 = r9.a
                java.util.Date r1 = new java.util.Date
                r1.<init>()
                cris.org.in.ima.db.StationDb$a r2 = r0.l()     // Catch:{ Pm -> 0x0010 }
                r2.f4380a = r1     // Catch:{ Pm -> 0x0010 }
                goto L_0x0016
            L_0x0010:
                r1 = move-exception
                java.util.LinkedHashMap<java.lang.String, java.util.ArrayList<Wx>> r2 = cris.org.in.ima.services.StationListFetch.f5364a
                r1.getMessage()
            L_0x0016:
                java.lang.System.currentTimeMillis()
                java.util.LinkedHashMap<java.lang.String, java.util.ArrayList<Wx>> r1 = cris.org.in.ima.services.StationListFetch.f5364a
                if (r10 == 0) goto L_0x0224
                r0.getClass()
                android.content.Context r1 = r0.f4379a
                r2 = 0
                android.database.sqlite.SQLiteDatabase r3 = r0.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0045, all -> 0x003e }
                java.lang.String r4 = "drop table stns"
                r3.execSQL(r4)     // Catch:{ SQLiteException -> 0x0046, all -> 0x003b }
                java.lang.String r4 = "CREATE VIRTUAL TABLE IF NOT EXISTS stns using fts3(snameEn text,snameHi text,scode text,scityEn TEXT,scityHi TEXT,sStateEn TEXT,sStateHi TEXT,sTags TEXT)"
                r3.execSQL(r4)     // Catch:{ SQLiteException -> 0x0032, all -> 0x003b }
                goto L_0x0037
            L_0x0032:
                java.lang.String r4 = "Error in synchronizing station data"
                defpackage.C0535I5.t0(r1, r4)     // Catch:{ SQLiteException -> 0x0046, all -> 0x003b }
            L_0x0037:
                r3.close()     // Catch:{ SQLiteException -> 0x0046, all -> 0x003b }
                goto L_0x0048
            L_0x003b:
                r10 = move-exception
                r2 = r3
                goto L_0x003f
            L_0x003e:
                r10 = move-exception
            L_0x003f:
                if (r2 == 0) goto L_0x0044
                r2.close()
            L_0x0044:
                throw r10
            L_0x0045:
                r3 = r2
            L_0x0046:
                if (r3 == 0) goto L_0x004b
            L_0x0048:
                r3.close()
            L_0x004b:
                java.lang.String r3 = cris.org.in.ima.services.StationListFetch.f5366c
                android.database.sqlite.SQLiteDatabase r4 = r0.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0078, all -> 0x0071 }
                android.content.ContentValues r5 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0079, all -> 0x006e }
                r5.<init>()     // Catch:{ SQLiteException -> 0x0079, all -> 0x006e }
                java.lang.String r6 = "time_stamp"
                java.text.SimpleDateFormat r7 = cris.org.in.ima.db.StationDb.a     // Catch:{ SQLiteException -> 0x0079, all -> 0x006e }
                java.util.Date r8 = new java.util.Date     // Catch:{ SQLiteException -> 0x0079, all -> 0x006e }
                r8.<init>()     // Catch:{ SQLiteException -> 0x0079, all -> 0x006e }
                java.lang.String r7 = r7.format(r8)     // Catch:{ SQLiteException -> 0x0079, all -> 0x006e }
                r5.put(r6, r7)     // Catch:{ SQLiteException -> 0x0079, all -> 0x006e }
                java.lang.String r6 = "config_hash"
                java.lang.String r7 = "field_name=\"station_list_hash\""
                r4.update(r6, r5, r7, r2)     // Catch:{ SQLiteException -> 0x0079, all -> 0x006e }
                goto L_0x007b
            L_0x006e:
                r10 = move-exception
                r2 = r4
                goto L_0x0072
            L_0x0071:
                r10 = move-exception
            L_0x0072:
                if (r2 == 0) goto L_0x0077
                r2.close()
            L_0x0077:
                throw r10
            L_0x0078:
                r4 = r2
            L_0x0079:
                if (r4 == 0) goto L_0x007e
            L_0x007b:
                r4.close()
            L_0x007e:
                r4 = 0
                android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()     // Catch:{ SQLiteException -> 0x0117 }
                r0.beginTransaction()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r5 = r4
            L_0x0087:
                int r6 = r10.length     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                if (r5 >= r6) goto L_0x00ef
                android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r6.<init>()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r7 = "scode"
                r8 = r10[r5]     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r8 = r8.getSc()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r6.put(r7, r8)     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r7 = "snameHi"
                r8 = r10[r5]     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r8 = r8.getHi()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r6.put(r7, r8)     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r7 = "snameEn"
                r8 = r10[r5]     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r8 = r8.getEn()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r6.put(r7, r8)     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r7 = "scityHi"
                r8 = r10[r5]     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r8 = r8.getHc()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r6.put(r7, r8)     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r7 = "scityEn"
                r8 = r10[r5]     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r8 = r8.getEc()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r6.put(r7, r8)     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r7 = "sStateEn"
                r8 = r10[r5]     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r8 = r8.getSe()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r6.put(r7, r8)     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r7 = "sStateHi"
                r8 = r10[r5]     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r8 = r8.getSh()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r6.put(r7, r8)     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r7 = "sTags"
                r8 = r10[r5]     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r8 = r8.getTg()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r6.put(r7, r8)     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r7 = "stns"
                r0.insert(r7, r2, r6)     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                int r5 = r5 + 1
                goto L_0x0087
            L_0x00ef:
                r0.setTransactionSuccessful()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r0.endTransaction()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                android.content.Context r2 = r1.getApplicationContext()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                Bw r2 = defpackage.Bw.e(r2)     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                Nv r2 = r2.f3534a     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                Nv$a r2 = r2.edit()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                java.lang.String r5 = "hash"
                r2.putString(r5, r3)     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r2.commit()     // Catch:{ SQLiteException -> 0x0112, all -> 0x010f }
                r0.close()
                goto L_0x0121
            L_0x010f:
                r10 = move-exception
                goto L_0x021e
            L_0x0112:
                r2 = r0
                goto L_0x0117
            L_0x0114:
                r10 = move-exception
                goto L_0x021d
            L_0x0117:
                java.lang.String r0 = "Error in synchronizing station data."
                defpackage.C0535I5.t0(r1, r0)     // Catch:{ all -> 0x0114 }
                if (r2 == 0) goto L_0x0121
                r2.close()
            L_0x0121:
                r0 = r4
            L_0x0122:
                int r1 = r10.length
                java.util.ArrayList<Wx> r2 = cris.org.in.ima.services.StationListFetch.f5363a
                java.util.ArrayList<java.lang.String> r3 = cris.org.in.ima.services.StationListFetch.f5367c
                java.util.LinkedHashMap<java.lang.String, java.util.ArrayList<Wx>> r5 = cris.org.in.ima.services.StationListFetch.f5365b
                java.util.ArrayList<java.lang.String> r6 = cris.org.in.ima.services.StationListFetch.b
                java.util.LinkedHashMap<java.lang.String, java.util.ArrayList<Wx>> r7 = cris.org.in.ima.services.StationListFetch.f5364a
                if (r0 >= r1) goto L_0x01bd
                r1 = r10[r0]
                r2.add(r1)
                r1 = r10[r0]
                java.lang.String r1 = r1.getEc()
                if (r1 == 0) goto L_0x016a
                boolean r2 = r7.containsKey(r1)
                if (r2 != 0) goto L_0x0159
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                r7.put(r1, r2)
                java.lang.Object r2 = r7.get(r1)
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                r7 = r10[r0]
                r2.add(r7)
                r6.add(r1)
                goto L_0x016a
            L_0x0159:
                boolean r2 = r7.containsKey(r1)
                if (r2 == 0) goto L_0x016a
                java.lang.Object r1 = r7.get(r1)
                java.util.ArrayList r1 = (java.util.ArrayList) r1
                r2 = r10[r0]
                r1.add(r2)
            L_0x016a:
                r1 = r10[r0]
                java.lang.String r1 = r1.getTg()
                if (r1 == 0) goto L_0x01b9
                java.lang.String r2 = ","
                java.lang.String[] r1 = r1.split(r2)
                r2 = r4
            L_0x0179:
                int r6 = r1.length
                if (r2 >= r6) goto L_0x01b9
                r6 = r1[r2]
                boolean r6 = r5.containsKey(r6)
                if (r6 != 0) goto L_0x01a1
                r6 = r1[r2]
                java.util.ArrayList r7 = new java.util.ArrayList
                r7.<init>()
                r5.put(r6, r7)
                r6 = r1[r2]
                java.lang.Object r6 = r5.get(r6)
                java.util.ArrayList r6 = (java.util.ArrayList) r6
                r7 = r10[r0]
                r6.add(r7)
                r6 = r1[r2]
                r3.add(r6)
                goto L_0x01b6
            L_0x01a1:
                r6 = r1[r2]
                boolean r6 = r5.containsKey(r6)
                if (r6 == 0) goto L_0x01b6
                r6 = r1[r2]
                java.lang.Object r6 = r5.get(r6)
                java.util.ArrayList r6 = (java.util.ArrayList) r6
                r7 = r10[r0]
                r6.add(r7)
            L_0x01b6:
                int r2 = r2 + 1
                goto L_0x0179
            L_0x01b9:
                int r0 = r0 + 1
                goto L_0x0122
            L_0x01bd:
                android.content.Context r10 = cris.org.in.ima.services.StationListFetch.a
                Bw r10 = defpackage.Bw.e(r10)
                com.google.gson.Gson r0 = new com.google.gson.Gson
                r0.<init>()
                java.lang.String r1 = r0.toJson((java.lang.Object) r7)
                java.lang.String r4 = r0.toJson((java.lang.Object) r6)
                java.lang.String r5 = r0.toJson((java.lang.Object) r5)
                java.lang.String r3 = r0.toJson((java.lang.Object) r3)
                java.lang.String r0 = r0.toJson((java.lang.Object) r2)
                Nv r2 = r10.f3534a
                Nv$a r2 = r2.edit()
                java.lang.String r6 = "CityWiseStationList"
                r2.putString(r6, r1)
                r2.commit()
                Nv r10 = r10.f3534a
                Nv$a r1 = r10.edit()
                java.lang.String r2 = "CityNameList"
                r1.putString(r2, r4)
                r1.commit()
                Nv$a r1 = r10.edit()
                java.lang.String r2 = "TagList"
                r1.putString(r2, r3)
                r1.commit()
                Nv$a r1 = r10.edit()
                java.lang.String r2 = "TagWiseStationList"
                r1.putString(r2, r5)
                r1.commit()
                Nv$a r10 = r10.edit()
                java.lang.String r1 = "DISTSCORINGSTNLIST"
                r10.putString(r1, r0)
                r10.commit()
                goto L_0x0224
            L_0x021d:
                r0 = r2
            L_0x021e:
                if (r0 == 0) goto L_0x0223
                r0.close()
            L_0x0223:
                throw r10
            L_0x0224:
                java.lang.System.currentTimeMillis()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.services.StationListFetch.a.onNext(java.lang.Object):void");
        }
    }

    static {
        C1354qp.R(StationListFetch.class);
    }

    public static void a() {
        StationDb stationDb = C0793b1.a.f3911a;
        long currentTimeMillis = System.currentTimeMillis();
        String f = C0657Qt.f();
        ((Om) C0657Qt.b()).p(f + "stationData").c(C1181iv.a()).a(E0.a()).b(new a(stationDb, currentTimeMillis));
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], android.database.Cursor] */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003a, code lost:
        if (r6.isOpen() != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        r6.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006f, code lost:
        if (r6.isOpen() != false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int onStartCommand(android.content.Intent r5, int r6, int r7) {
        /*
            r4 = this;
            java.lang.String r6 = "stationHash"
            java.lang.String r5 = r5.getStringExtra(r6)
            f5366c = r5
            b1 r5 = defpackage.C0793b1.a
            cris.org.in.ima.db.StationDb r5 = r5.f3911a
            android.database.sqlite.SQLiteDatabase r6 = r5.getReadableDatabase()
            r7 = 1
            r0 = 0
            java.lang.String r1 = "SELECT COUNT(scityEn) FROM stns"
            android.database.Cursor r0 = r6.rawQuery(r1, r0)     // Catch:{ SQLiteException -> 0x0058 }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0058 }
            if (r1 == 0) goto L_0x0040
            r1 = 0
            int r2 = r0.getInt(r1)     // Catch:{ SQLiteException -> 0x0058 }
            r0.close()     // Catch:{ SQLiteException -> 0x0058 }
            if (r2 <= 0) goto L_0x0029
            r1 = r7
        L_0x0029:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)     // Catch:{ SQLiteException -> 0x0058 }
            boolean r2 = r0.isClosed()
            if (r2 != 0) goto L_0x0036
            r0.close()
        L_0x0036:
            boolean r0 = r6.isOpen()
            if (r0 == 0) goto L_0x0072
        L_0x003c:
            r6.close()
            goto L_0x0072
        L_0x0040:
            boolean r1 = r0.isClosed()
            if (r1 != 0) goto L_0x0049
            r0.close()
        L_0x0049:
            boolean r0 = r6.isOpen()
            if (r0 == 0) goto L_0x0052
            r6.close()
        L_0x0052:
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            goto L_0x0072
        L_0x0055:
            r5 = move-exception
            goto L_0x00e1
        L_0x0058:
            r1 = move-exception
            r1.getMessage()     // Catch:{ all -> 0x0055 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0055 }
            if (r0 == 0) goto L_0x0069
            boolean r2 = r0.isClosed()
            if (r2 != 0) goto L_0x0069
            r0.close()
        L_0x0069:
            if (r6 == 0) goto L_0x0072
            boolean r0 = r6.isOpen()
            if (r0 == 0) goto L_0x0072
            goto L_0x003c
        L_0x0072:
            boolean r6 = r1.booleanValue()
            if (r6 != 0) goto L_0x0081
            int r6 = c
            if (r6 != 0) goto L_0x0081
            a()
            c = r7
        L_0x0081:
            r6 = 2
            cris.org.in.ima.db.StationDb$a r5 = r5.l()     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            java.lang.String r1 = "dd-MM-yyyy"
            r0.<init>(r1)     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            java.util.Date r1 = new java.util.Date     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            r1.<init>()     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            java.lang.String r1 = r0.format(r1)     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            java.util.Date r0 = r0.parse(r1)     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            long r0 = r0.getTime()     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            java.util.Date r2 = r5.f4380a     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            long r2 = r2.getTime()     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            long r0 = r0 - r2
            long r0 = java.lang.Math.abs(r0)     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            r2 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r2
            java.util.Date r5 = r5.f4380a     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            if (r5 == 0) goto L_0x00ba
            r2 = 3600(0xe10, double:1.7786E-320)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L_0x00ba
            java.util.Objects.toString(r5)     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            return r6
        L_0x00ba:
            if (r5 != 0) goto L_0x00e0
            java.util.Objects.toString(r5)     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            int r5 = c     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            if (r5 != 0) goto L_0x00c8
            a()     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
            c = r7     // Catch:{ Pm -> 0x00d7, ParseException -> 0x00c9 }
        L_0x00c8:
            return r6
        L_0x00c9:
            r5 = move-exception
            r5.getMessage()
            int r5 = c
            if (r5 != 0) goto L_0x00e0
            a()
            c = r7
            goto L_0x00e0
        L_0x00d7:
            int r5 = c
            if (r5 != 0) goto L_0x00e0
            a()
            c = r7
        L_0x00e0:
            return r6
        L_0x00e1:
            if (r0 == 0) goto L_0x00ec
            boolean r7 = r0.isClosed()
            if (r7 != 0) goto L_0x00ec
            r0.close()
        L_0x00ec:
            if (r6 == 0) goto L_0x00f7
            boolean r7 = r6.isOpen()
            if (r7 == 0) goto L_0x00f7
            r6.close()
        L_0x00f7:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cris.org.in.ima.services.StationListFetch.onStartCommand(android.content.Intent, int, int):int");
    }
}
