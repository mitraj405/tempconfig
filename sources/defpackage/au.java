package defpackage;

import androidx.work.impl.WorkDatabase_Impl;
import defpackage.Ly;

/* renamed from: au  reason: default package */
/* compiled from: RoomOpenHelper */
public final class au extends Ly.a {
    public final a a;

    /* renamed from: a  reason: collision with other field name */
    public b8 f2708a;

    /* renamed from: au$a */
    /* compiled from: RoomOpenHelper */
    public static abstract class a {
        public final int a = 12;

        public abstract void a(C0408yd ydVar);

        public abstract b b(C0408yd ydVar);
    }

    /* renamed from: au$b */
    /* compiled from: RoomOpenHelper */
    public static class b {
        public final String a;

        /* renamed from: a  reason: collision with other field name */
        public final boolean f2709a;

        public b(String str, boolean z) {
            this.f2709a = z;
            this.a = str;
        }
    }

    public au(b8 b8Var, WorkDatabase_Impl.a aVar) {
        super(aVar.a);
        this.f2708a = b8Var;
        this.a = aVar;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
        r0 = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(defpackage.C0408yd r12, int r13, int r14) {
        /*
            r11 = this;
            b8 r0 = r11.f2708a
            au$a r1 = r11.a
            r2 = 0
            if (r0 == 0) goto L_0x00fa
            Zt$c r0 = r0.f2731a
            r0.getClass()
            r3 = 1
            if (r13 != r14) goto L_0x0015
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x0079
        L_0x0015:
            if (r14 <= r13) goto L_0x0019
            r4 = r3
            goto L_0x001a
        L_0x0019:
            r4 = r2
        L_0x001a:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6 = r13
        L_0x0020:
            if (r4 == 0) goto L_0x0025
            if (r6 >= r14) goto L_0x0078
            goto L_0x0027
        L_0x0025:
            if (r6 <= r14) goto L_0x0078
        L_0x0027:
            java.util.HashMap<java.lang.Integer, java.util.TreeMap<java.lang.Integer, pl>> r7 = r0.a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            java.lang.Object r7 = r7.get(r8)
            java.util.TreeMap r7 = (java.util.TreeMap) r7
            if (r7 != 0) goto L_0x0036
            goto L_0x0076
        L_0x0036:
            if (r4 == 0) goto L_0x003d
            java.util.NavigableSet r8 = r7.descendingKeySet()
            goto L_0x0041
        L_0x003d:
            java.util.Set r8 = r7.keySet()
        L_0x0041:
            java.util.Iterator r8 = r8.iterator()
        L_0x0045:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0073
            java.lang.Object r9 = r8.next()
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            if (r4 == 0) goto L_0x005c
            if (r9 > r14) goto L_0x0062
            if (r9 <= r6) goto L_0x0062
            goto L_0x0060
        L_0x005c:
            if (r9 < r14) goto L_0x0062
            if (r9 >= r6) goto L_0x0062
        L_0x0060:
            r10 = r3
            goto L_0x0063
        L_0x0062:
            r10 = r2
        L_0x0063:
            if (r10 == 0) goto L_0x0045
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            java.lang.Object r6 = r7.get(r6)
            r5.add(r6)
            r7 = r3
            r6 = r9
            goto L_0x0074
        L_0x0073:
            r7 = r2
        L_0x0074:
            if (r7 != 0) goto L_0x0020
        L_0x0076:
            r0 = 0
            goto L_0x0079
        L_0x0078:
            r0 = r5
        L_0x0079:
            if (r0 == 0) goto L_0x00fa
            r4 = r1
            androidx.work.impl.WorkDatabase_Impl$a r4 = (androidx.work.impl.WorkDatabase_Impl.a) r4
            r4.getClass()
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.lang.String r5 = "SELECT name FROM sqlite_master WHERE type = 'trigger'"
            android.database.Cursor r5 = r12.h(r5)
        L_0x008c:
            boolean r6 = r5.moveToNext()     // Catch:{ all -> 0x00f5 }
            if (r6 == 0) goto L_0x009a
            java.lang.String r6 = r5.getString(r2)     // Catch:{ all -> 0x00f5 }
            r4.add(r6)     // Catch:{ all -> 0x00f5 }
            goto L_0x008c
        L_0x009a:
            r5.close()
            java.util.Iterator r4 = r4.iterator()
        L_0x00a1:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00bf
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r6 = "room_fts_content_sync_"
            boolean r6 = r5.startsWith(r6)
            if (r6 == 0) goto L_0x00a1
            java.lang.String r6 = "DROP TRIGGER IF EXISTS "
            java.lang.String r5 = r6.concat(r5)
            r12.c(r5)
            goto L_0x00a1
        L_0x00bf:
            java.util.Iterator r0 = r0.iterator()
        L_0x00c3:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x00d3
            java.lang.Object r4 = r0.next()
            pl r4 = (defpackage.pl) r4
            r4.a(r12)
            goto L_0x00c3
        L_0x00d3:
            au$b r0 = r1.b(r12)
            boolean r4 = r0.f2709a
            if (r4 == 0) goto L_0x00df
            r11.c(r12)
            goto L_0x00fb
        L_0x00df:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r14 = "Migration didn't properly handle: "
            r13.<init>(r14)
            java.lang.String r14 = r0.a
            r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L_0x00f5:
            r12 = move-exception
            r5.close()
            throw r12
        L_0x00fa:
            r3 = r2
        L_0x00fb:
            if (r3 != 0) goto L_0x0171
            b8 r0 = r11.f2708a
            if (r0 == 0) goto L_0x0150
            boolean r0 = r0.a(r13, r14)
            if (r0 != 0) goto L_0x0150
            r13 = r1
            androidx.work.impl.WorkDatabase_Impl$a r13 = (androidx.work.impl.WorkDatabase_Impl.a) r13
            r13.getClass()
            java.lang.String r14 = "DROP TABLE IF EXISTS `Dependency`"
            r12.c(r14)
            java.lang.String r14 = "DROP TABLE IF EXISTS `WorkSpec`"
            r12.c(r14)
            java.lang.String r14 = "DROP TABLE IF EXISTS `WorkTag`"
            r12.c(r14)
            java.lang.String r14 = "DROP TABLE IF EXISTS `SystemIdInfo`"
            r12.c(r14)
            java.lang.String r14 = "DROP TABLE IF EXISTS `WorkName`"
            r12.c(r14)
            java.lang.String r14 = "DROP TABLE IF EXISTS `WorkProgress`"
            r12.c(r14)
            java.lang.String r14 = "DROP TABLE IF EXISTS `Preference`"
            r12.c(r14)
            int r14 = androidx.work.impl.WorkDatabase_Impl.b
            androidx.work.impl.WorkDatabase_Impl r13 = androidx.work.impl.WorkDatabase_Impl.this
            java.util.List<Zt$b> r14 = r13.f770a
            if (r14 == 0) goto L_0x014c
            int r14 = r14.size()
        L_0x013c:
            if (r2 >= r14) goto L_0x014c
            java.util.List<Zt$b> r0 = r13.f770a
            java.lang.Object r0 = r0.get(r2)
            Zt$b r0 = (defpackage.Zt.b) r0
            r0.getClass()
            int r2 = r2 + 1
            goto L_0x013c
        L_0x014c:
            r1.a(r12)
            goto L_0x0171
        L_0x0150:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "A migration from "
            r0.<init>(r1)
            r0.append(r13)
            java.lang.String r13 = " to "
            r0.append(r13)
            r0.append(r14)
            java.lang.String r13 = " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods."
            r0.append(r13)
            java.lang.String r13 = r0.toString()
            r12.<init>(r13)
            throw r12
        L_0x0171:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.au.b(yd, int, int):void");
    }

    public final void c(C0408yd ydVar) {
        ydVar.c("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        ydVar.c("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c103703e120ae8cc73c9248622f3cd1e')");
    }
}
