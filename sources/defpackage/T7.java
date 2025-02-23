package defpackage;

/* renamed from: T7  reason: default package */
/* compiled from: DBUtils */
public final class T7 {
    public static final String a = "dbapp.db";

    static {
        C1354qp.R(T7.class);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0077, code lost:
        if (r5 != null) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007c, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0090, code lost:
        if (r5 != null) goto L_0x0079;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r5) {
        /*
            java.lang.String r0 = "/data/data/"
            r1 = 0
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            r3.<init>(r0)     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            android.content.Context r5 = r5.getApplicationContext()     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            java.lang.String r5 = r5.getPackageName()     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            r3.append(r5)     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            java.lang.String r5 = "/databases"
            r3.append(r5)     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            java.lang.String r5 = r3.toString()     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            boolean r3 = r0.exists()     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            if (r3 == 0) goto L_0x0074
            boolean r0 = r0.isDirectory()     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            if (r0 == 0) goto L_0x0074
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            r0.<init>()     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            r0.append(r5)     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            java.lang.String r5 = "/"
            r0.append(r5)     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            java.lang.String r5 = a     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            r0.append(r5)     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            if (r0 == 0) goto L_0x0074
            r0 = 1
            android.database.sqlite.SQLiteDatabase r5 = android.database.sqlite.SQLiteDatabase.openDatabase(r5, r1, r0)     // Catch:{ Exception -> 0x008d, all -> 0x0080 }
            java.lang.String r3 = "SELECT count(*) FROM sqlite_master WHERE type = 'table' AND name = 'stns'"
            android.database.Cursor r1 = r5.rawQuery(r3, r1)     // Catch:{ Exception -> 0x0070, all -> 0x006b }
            boolean r3 = r1.moveToFirst()     // Catch:{ Exception -> 0x0070, all -> 0x006b }
            if (r3 == 0) goto L_0x0067
            int r3 = r1.getInt(r2)     // Catch:{ Exception -> 0x0070, all -> 0x006b }
            if (r3 != r0) goto L_0x0067
            r2 = r0
        L_0x0067:
            r4 = r1
            r1 = r5
            r5 = r4
            goto L_0x0075
        L_0x006b:
            r0 = move-exception
            r4 = r1
            r1 = r5
            r5 = r4
            goto L_0x0082
        L_0x0070:
            r4 = r1
            r1 = r5
            r5 = r4
            goto L_0x008e
        L_0x0074:
            r5 = r1
        L_0x0075:
            if (r1 == 0) goto L_0x0093
            if (r5 == 0) goto L_0x007c
        L_0x0079:
            r5.close()
        L_0x007c:
            r1.close()
            goto L_0x0093
        L_0x0080:
            r0 = move-exception
            r5 = r1
        L_0x0082:
            if (r1 == 0) goto L_0x008c
            if (r5 == 0) goto L_0x0089
            r5.close()
        L_0x0089:
            r1.close()
        L_0x008c:
            throw r0
        L_0x008d:
            r5 = r1
        L_0x008e:
            if (r1 == 0) goto L_0x0093
            if (r5 == 0) goto L_0x007c
            goto L_0x0079
        L_0x0093:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.T7.a(android.content.Context):boolean");
    }
}
