package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.work.impl.WorkDatabase_Impl;
import defpackage.Ly;
import defpackage.Zt;
import defpackage.au;
import java.io.File;
import java.util.List;

/* renamed from: zd  reason: default package and case insensitive filesystem */
/* compiled from: FrameworkSQLiteOpenHelper */
public final class C0425zd implements Ly {
    public final Ly.a a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f3459a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f3460a = new Object();

    /* renamed from: a  reason: collision with other field name */
    public a f3461a;

    /* renamed from: a  reason: collision with other field name */
    public final boolean f3462a;
    public boolean b;
    public final String c;

    /* renamed from: zd$a */
    /* compiled from: FrameworkSQLiteOpenHelper */
    public static class a extends SQLiteOpenHelper {
        public final Ly.a a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f3463a;

        /* renamed from: a  reason: collision with other field name */
        public final C0408yd[] f3464a;

        /* renamed from: zd$a$a  reason: collision with other inner class name */
        /* compiled from: FrameworkSQLiteOpenHelper */
        public class C0033a implements DatabaseErrorHandler {
            public final /* synthetic */ Ly.a a;

            /* renamed from: a  reason: collision with other field name */
            public final /* synthetic */ C0408yd[] f3465a;

            public C0033a(Ly.a aVar, C0408yd[] ydVarArr) {
                this.a = aVar;
                this.f3465a = ydVarArr;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
                r4 = move-exception;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
                if (r1 != null) goto L_0x0041;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
                r0 = r1.iterator();
             */
            /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
                if (r0.hasNext() != false) goto L_0x004b;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
                defpackage.Ly.a.a((java.lang.String) r0.next().second);
             */
            /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
                defpackage.Ly.a.a(r0.getPath());
             */
            /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
                throw r4;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
                if (r2 == false) goto L_0x0010;
             */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003b */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0039 A[ExcHandler: all (r4v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
              PHI: (r1v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r1v2 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v3 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:12:0x0034, B:15:0x003b, B:16:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:12:0x0034] */
            /* JADX WARNING: Removed duplicated region for block: B:26:0x0063  */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x007b  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onCorruption(android.database.sqlite.SQLiteDatabase r4) {
                /*
                    r3 = this;
                    yd[] r0 = r3.f3465a
                    r1 = 0
                    r2 = r0[r1]
                    if (r2 == 0) goto L_0x0010
                    android.database.sqlite.SQLiteDatabase r2 = r2.f3431a
                    if (r2 != r4) goto L_0x000d
                    r2 = 1
                    goto L_0x000e
                L_0x000d:
                    r2 = r1
                L_0x000e:
                    if (r2 != 0) goto L_0x0017
                L_0x0010:
                    yd r2 = new yd
                    r2.<init>(r4)
                    r0[r1] = r2
                L_0x0017:
                    r4 = r0[r1]
                    Ly$a r0 = r3.a
                    r0.getClass()
                    android.database.sqlite.SQLiteDatabase r0 = r4.f3431a
                    r0.getPath()
                    android.database.sqlite.SQLiteDatabase r0 = r4.f3431a
                    boolean r1 = r0.isOpen()
                    if (r1 != 0) goto L_0x0033
                    java.lang.String r4 = r0.getPath()
                    defpackage.Ly.a.a(r4)
                    goto L_0x0082
                L_0x0033:
                    r1 = 0
                    java.util.List r1 = r0.getAttachedDbs()     // Catch:{ SQLiteException -> 0x003b, all -> 0x0039 }
                    goto L_0x003b
                L_0x0039:
                    r4 = move-exception
                    goto L_0x003f
                L_0x003b:
                    r4.close()     // Catch:{ IOException -> 0x0061, all -> 0x0039 }
                    goto L_0x0061
                L_0x003f:
                    if (r1 == 0) goto L_0x0059
                    java.util.Iterator r0 = r1.iterator()
                L_0x0045:
                    boolean r1 = r0.hasNext()
                    if (r1 == 0) goto L_0x0060
                    java.lang.Object r1 = r0.next()
                    android.util.Pair r1 = (android.util.Pair) r1
                    java.lang.Object r1 = r1.second
                    java.lang.String r1 = (java.lang.String) r1
                    defpackage.Ly.a.a(r1)
                    goto L_0x0045
                L_0x0059:
                    java.lang.String r0 = r0.getPath()
                    defpackage.Ly.a.a(r0)
                L_0x0060:
                    throw r4
                L_0x0061:
                    if (r1 == 0) goto L_0x007b
                    java.util.Iterator r4 = r1.iterator()
                L_0x0067:
                    boolean r0 = r4.hasNext()
                    if (r0 == 0) goto L_0x0082
                    java.lang.Object r0 = r4.next()
                    android.util.Pair r0 = (android.util.Pair) r0
                    java.lang.Object r0 = r0.second
                    java.lang.String r0 = (java.lang.String) r0
                    defpackage.Ly.a.a(r0)
                    goto L_0x0067
                L_0x007b:
                    java.lang.String r4 = r0.getPath()
                    defpackage.Ly.a.a(r4)
                L_0x0082:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: defpackage.C0425zd.a.C0033a.onCorruption(android.database.sqlite.SQLiteDatabase):void");
            }
        }

        public a(Context context, String str, C0408yd[] ydVarArr, Ly.a aVar) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, aVar.a, new C0033a(aVar, ydVarArr));
            this.a = aVar;
            this.f3464a = ydVarArr;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
            if (r2 == false) goto L_0x0010;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final defpackage.C0408yd a(android.database.sqlite.SQLiteDatabase r4) {
            /*
                r3 = this;
                yd[] r0 = r3.f3464a
                r1 = 0
                r2 = r0[r1]
                if (r2 == 0) goto L_0x0010
                android.database.sqlite.SQLiteDatabase r2 = r2.f3431a
                if (r2 != r4) goto L_0x000d
                r2 = 1
                goto L_0x000e
            L_0x000d:
                r2 = r1
            L_0x000e:
                if (r2 != 0) goto L_0x0017
            L_0x0010:
                yd r2 = new yd
                r2.<init>(r4)
                r0[r1] = r2
            L_0x0017:
                r4 = r0[r1]
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.C0425zd.a.a(android.database.sqlite.SQLiteDatabase):yd");
        }

        public final synchronized Ky b() {
            this.f3463a = false;
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (this.f3463a) {
                close();
                return b();
            }
            return a(writableDatabase);
        }

        public final synchronized void close() {
            super.close();
            this.f3464a[0] = null;
        }

        public final void onConfigure(SQLiteDatabase sQLiteDatabase) {
            a(sQLiteDatabase);
            this.a.getClass();
        }

        /* JADX INFO: finally extract failed */
        public final void onCreate(SQLiteDatabase sQLiteDatabase) {
            boolean z;
            C0408yd a2 = a(sQLiteDatabase);
            au auVar = (au) this.a;
            auVar.getClass();
            Cursor h = a2.h("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                if (!h.moveToFirst() || h.getInt(0) != 0) {
                    z = false;
                } else {
                    z = true;
                }
                h.close();
                au.a aVar = auVar.a;
                aVar.a(a2);
                if (!z) {
                    au.b b = aVar.b(a2);
                    if (!b.f2709a) {
                        throw new IllegalStateException("Pre-packaged database has an invalid schema: " + b.a);
                    }
                }
                auVar.c(a2);
                int i = WorkDatabase_Impl.b;
                WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
                List<Zt.b> list = workDatabase_Impl.f770a;
                if (list != null) {
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        workDatabase_Impl.f770a.get(i2).getClass();
                    }
                }
            } catch (Throwable th) {
                h.close();
                throw th;
            }
        }

        public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f3463a = true;
            ((au) this.a).b(a(sQLiteDatabase), i, i2);
        }

        /* JADX INFO: finally extract failed */
        public final void onOpen(SQLiteDatabase sQLiteDatabase) {
            boolean z;
            String str;
            if (!this.f3463a) {
                Ly.a aVar = this.a;
                C0408yd a2 = a(sQLiteDatabase);
                au auVar = (au) aVar;
                auVar.getClass();
                Cursor h = a2.h("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
                try {
                    if (!h.moveToFirst() || h.getInt(0) == 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    h.close();
                    if (z) {
                        Cursor e = a2.e(new Pw("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
                        try {
                            if (e.moveToFirst()) {
                                str = e.getString(0);
                            } else {
                                str = null;
                            }
                            e.close();
                            if (!"c103703e120ae8cc73c9248622f3cd1e".equals(str) && !"49f946663a8deb7054212b8adda248c6".equals(str)) {
                                throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number.");
                            }
                        } catch (Throwable th) {
                            e.close();
                            throw th;
                        }
                    } else {
                        au.b b = auVar.a.b(a2);
                        if (b.f2709a) {
                            auVar.c(a2);
                        } else {
                            throw new IllegalStateException("Pre-packaged database has an invalid schema: " + b.a);
                        }
                    }
                    WorkDatabase_Impl.a aVar2 = (WorkDatabase_Impl.a) auVar.a;
                    WorkDatabase_Impl workDatabase_Impl = WorkDatabase_Impl.this;
                    int i = WorkDatabase_Impl.b;
                    workDatabase_Impl.a = a2;
                    a2.c("PRAGMA foreign_keys = ON");
                    og ogVar = WorkDatabase_Impl.this.f773a;
                    synchronized (ogVar) {
                        if (!ogVar.f3152a) {
                            a2.c("PRAGMA temp_store = MEMORY;");
                            a2.c("PRAGMA recursive_triggers='ON';");
                            a2.c("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                            ogVar.c(a2);
                            ogVar.a = new C0085Cd(a2.f3431a.compileStatement("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 "));
                            ogVar.f3152a = true;
                        }
                    }
                    List<Zt.b> list = WorkDatabase_Impl.this.f770a;
                    if (list != null) {
                        int size = list.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            WorkDatabase_Impl.this.f770a.get(i2).a(a2);
                        }
                    }
                    auVar.f2708a = null;
                } catch (Throwable th2) {
                    h.close();
                    throw th2;
                }
            }
        }

        public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.f3463a = true;
            this.a.b(a(sQLiteDatabase), i, i2);
        }
    }

    public C0425zd(Context context, String str, Ly.a aVar, boolean z) {
        this.f3459a = context;
        this.c = str;
        this.a = aVar;
        this.f3462a = z;
    }

    public final a a() {
        a aVar;
        synchronized (this.f3460a) {
            if (this.f3461a == null) {
                C0408yd[] ydVarArr = new C0408yd[1];
                if (this.c == null || !this.f3462a) {
                    this.f3461a = new a(this.f3459a, this.c, ydVarArr, this.a);
                } else {
                    this.f3461a = new a(this.f3459a, new File(this.f3459a.getNoBackupFilesDir(), this.c).getAbsolutePath(), ydVarArr, this.a);
                }
                this.f3461a.setWriteAheadLoggingEnabled(this.b);
            }
            aVar = this.f3461a;
        }
        return aVar;
    }

    public final void close() {
        a().close();
    }

    public final Ky f() {
        return a().b();
    }

    public final String getDatabaseName() {
        return this.c;
    }

    public final void setWriteAheadLoggingEnabled(boolean z) {
        synchronized (this.f3460a) {
            a aVar = this.f3461a;
            if (aVar != null) {
                aVar.setWriteAheadLoggingEnabled(z);
            }
            this.b = z;
        }
    }
}
