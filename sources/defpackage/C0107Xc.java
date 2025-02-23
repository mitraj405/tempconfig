package defpackage;

/* renamed from: Xc  reason: default package and case insensitive filesystem */
/* compiled from: FontProvider */
public final class C0107Xc {
    public static final C0105Wc a = new C0105Wc(0);

    /* JADX WARNING: type inference failed for: r10v0, types: [gd[]] */
    /* JADX WARNING: type inference failed for: r10v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v2, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r10v4 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.C0195fd a(android.content.Context r21, defpackage.C0109Yc r22) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r0 = r22
            r6 = 0
            android.content.pm.PackageManager r1 = r21.getPackageManager()
            android.content.res.Resources r2 = r21.getResources()
            java.lang.String r3 = r0.a
            r7 = 0
            android.content.pm.ProviderInfo r4 = r1.resolveContentProvider(r3, r7)
            if (r4 == 0) goto L_0x01bd
            java.lang.String r5 = r4.packageName
            java.lang.String r8 = r0.b
            boolean r5 = r5.equals(r8)
            if (r5 == 0) goto L_0x01a1
            java.lang.String r3 = r4.packageName
            r5 = 64
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r5)
            android.content.pm.Signature[] r1 = r1.signatures
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            int r5 = r1.length
            r8 = r7
        L_0x002f:
            if (r8 >= r5) goto L_0x003d
            r9 = r1[r8]
            byte[] r9 = r9.toByteArray()
            r3.add(r9)
            int r8 = r8 + 1
            goto L_0x002f
        L_0x003d:
            Wc r1 = a
            java.util.Collections.sort(r3, r1)
            java.util.List<java.util.List<byte[]>> r5 = r0.f712a
            if (r5 == 0) goto L_0x0047
            goto L_0x004b
        L_0x0047:
            java.util.List r5 = defpackage.C0180ed.b(r2, r7)
        L_0x004b:
            r2 = r7
        L_0x004c:
            int r8 = r5.size()
            r9 = 1
            r10 = 0
            if (r2 >= r8) goto L_0x0092
            java.util.ArrayList r8 = new java.util.ArrayList
            java.lang.Object r11 = r5.get(r2)
            java.util.Collection r11 = (java.util.Collection) r11
            r8.<init>(r11)
            java.util.Collections.sort(r8, r1)
            int r11 = r3.size()
            int r12 = r8.size()
            if (r11 == r12) goto L_0x006d
            goto L_0x0086
        L_0x006d:
            r11 = r7
        L_0x006e:
            int r12 = r3.size()
            if (r11 >= r12) goto L_0x008b
            java.lang.Object r12 = r3.get(r11)
            byte[] r12 = (byte[]) r12
            java.lang.Object r13 = r8.get(r11)
            byte[] r13 = (byte[]) r13
            boolean r12 = java.util.Arrays.equals(r12, r13)
            if (r12 != 0) goto L_0x0088
        L_0x0086:
            r8 = r7
            goto L_0x008c
        L_0x0088:
            int r11 = r11 + 1
            goto L_0x006e
        L_0x008b:
            r8 = r9
        L_0x008c:
            if (r8 == 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            int r2 = r2 + 1
            goto L_0x004c
        L_0x0092:
            r4 = r10
        L_0x0093:
            if (r4 != 0) goto L_0x009b
            fd r0 = new fd
            r0.<init>(r9, r10)
            return r0
        L_0x009b:
            java.lang.String r1 = r4.authority
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            java.lang.String r3 = "content"
            android.net.Uri$Builder r2 = r2.scheme(r3)
            android.net.Uri$Builder r2 = r2.authority(r1)
            android.net.Uri r11 = r2.build()
            android.net.Uri$Builder r2 = new android.net.Uri$Builder
            r2.<init>()
            android.net.Uri$Builder r2 = r2.scheme(r3)
            android.net.Uri$Builder r1 = r2.authority(r1)
            java.lang.String r2 = "file"
            android.net.Uri$Builder r1 = r1.appendPath(r2)
            android.net.Uri r12 = r1.build()
            android.content.ContentResolver r1 = r21.getContentResolver()
            android.content.ContentProviderClient r13 = r1.acquireUnstableContentProviderClient(r11)
            java.lang.String r14 = "_id"
            java.lang.String r15 = "file_id"
            java.lang.String r16 = "font_ttc_index"
            java.lang.String r17 = "font_variation_settings"
            java.lang.String r18 = "font_weight"
            java.lang.String r19 = "font_italic"
            java.lang.String r20 = "result_code"
            java.lang.String[] r2 = new java.lang.String[]{r14, r15, r16, r17, r18, r19, r20}     // Catch:{ all -> 0x0195 }
            java.lang.String r3 = "query = ?"
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch:{ all -> 0x0195 }
            java.lang.String r0 = r0.c     // Catch:{ all -> 0x0195 }
            r4[r7] = r0     // Catch:{ all -> 0x0195 }
            r5 = 0
            if (r13 != 0) goto L_0x00f2
            goto L_0x00f8
        L_0x00f2:
            r0 = r13
            r1 = r11
            android.database.Cursor r10 = r0.query(r1, r2, r3, r4, r5, r6)     // Catch:{ RemoteException -> 0x00f8 }
        L_0x00f8:
            if (r10 == 0) goto L_0x017d
            int r0 = r10.getCount()     // Catch:{ all -> 0x0195 }
            if (r0 <= 0) goto L_0x017d
            java.lang.String r0 = "result_code"
            int r0 = r10.getColumnIndex(r0)     // Catch:{ all -> 0x0195 }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x0195 }
            r8.<init>()     // Catch:{ all -> 0x0195 }
            java.lang.String r1 = "_id"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ all -> 0x0195 }
            java.lang.String r2 = "file_id"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x0195 }
            java.lang.String r3 = "font_ttc_index"
            int r3 = r10.getColumnIndex(r3)     // Catch:{ all -> 0x0195 }
            java.lang.String r4 = "font_weight"
            int r4 = r10.getColumnIndex(r4)     // Catch:{ all -> 0x0195 }
            java.lang.String r5 = "font_italic"
            int r5 = r10.getColumnIndex(r5)     // Catch:{ all -> 0x0195 }
        L_0x0129:
            boolean r6 = r10.moveToNext()     // Catch:{ all -> 0x0195 }
            if (r6 == 0) goto L_0x017d
            r6 = -1
            if (r0 == r6) goto L_0x0139
            int r14 = r10.getInt(r0)     // Catch:{ all -> 0x0195 }
            r20 = r14
            goto L_0x013b
        L_0x0139:
            r20 = r7
        L_0x013b:
            if (r3 == r6) goto L_0x0144
            int r14 = r10.getInt(r3)     // Catch:{ all -> 0x0195 }
            r17 = r14
            goto L_0x0146
        L_0x0144:
            r17 = r7
        L_0x0146:
            if (r2 != r6) goto L_0x0151
            long r14 = r10.getLong(r1)     // Catch:{ all -> 0x0195 }
            android.net.Uri r14 = android.content.ContentUris.withAppendedId(r11, r14)     // Catch:{ all -> 0x0195 }
            goto L_0x0159
        L_0x0151:
            long r14 = r10.getLong(r2)     // Catch:{ all -> 0x0195 }
            android.net.Uri r14 = android.content.ContentUris.withAppendedId(r12, r14)     // Catch:{ all -> 0x0195 }
        L_0x0159:
            r16 = r14
            if (r4 == r6) goto L_0x0162
            int r14 = r10.getInt(r4)     // Catch:{ all -> 0x0195 }
            goto L_0x0164
        L_0x0162:
            r14 = 400(0x190, float:5.6E-43)
        L_0x0164:
            r18 = r14
            if (r5 == r6) goto L_0x0171
            int r6 = r10.getInt(r5)     // Catch:{ all -> 0x0195 }
            if (r6 != r9) goto L_0x0171
            r19 = r9
            goto L_0x0173
        L_0x0171:
            r19 = r7
        L_0x0173:
            gd r6 = new gd     // Catch:{ all -> 0x0195 }
            r15 = r6
            r15.<init>(r16, r17, r18, r19, r20)     // Catch:{ all -> 0x0195 }
            r8.add(r6)     // Catch:{ all -> 0x0195 }
            goto L_0x0129
        L_0x017d:
            if (r10 == 0) goto L_0x0182
            r10.close()
        L_0x0182:
            if (r13 == 0) goto L_0x0187
            r13.close()
        L_0x0187:
            gd[] r0 = new defpackage.C0204gd[r7]
            java.lang.Object[] r0 = r8.toArray(r0)
            gd[] r0 = (defpackage.C0204gd[]) r0
            fd r1 = new fd
            r1.<init>(r7, r0)
            return r1
        L_0x0195:
            r0 = move-exception
            if (r10 == 0) goto L_0x019b
            r10.close()
        L_0x019b:
            if (r13 == 0) goto L_0x01a0
            r13.close()
        L_0x01a0:
            throw r0
        L_0x01a1:
            android.content.pm.PackageManager$NameNotFoundException r0 = new android.content.pm.PackageManager$NameNotFoundException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Found content provider "
            r1.<init>(r2)
            r1.append(r3)
            java.lang.String r2 = ", but package was not "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x01bd:
            android.content.pm.PackageManager$NameNotFoundException r0 = new android.content.pm.PackageManager$NameNotFoundException
            java.lang.String r1 = "No package found for authority: "
            java.lang.String r1 = defpackage.C0709Uj.i(r1, r3)
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0107Xc.a(android.content.Context, Yc):fd");
    }
}
