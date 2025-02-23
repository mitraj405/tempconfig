package com.google.android.material.color;

final class ColorResourcesLoaderCreator {
    private static final String TAG = "ColorResLoaderCreator";

    private ColorResourcesLoaderCreator() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0059 A[SYNTHETIC, Splitter:B:46:0x0059] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.loader.ResourcesLoader create(android.content.Context r4, java.util.Map<java.lang.Integer, java.lang.Integer> r5) {
        /*
            r0 = 0
            byte[] r4 = com.google.android.material.color.ColorResourcesTableCreator.create(r4, r5)     // Catch:{ Exception -> 0x005d }
            int r5 = r4.length     // Catch:{ Exception -> 0x005d }
            int r5 = r4.length     // Catch:{ Exception -> 0x005d }
            if (r5 != 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.String r5 = "temp.arsc"
            r1 = 0
            java.io.FileDescriptor r5 = android.system.Os.memfd_create(r5, r1)     // Catch:{ all -> 0x0055 }
            if (r5 != 0) goto L_0x0019
            if (r5 == 0) goto L_0x0018
            android.system.Os.close(r5)     // Catch:{ Exception -> 0x005d }
        L_0x0018:
            return r0
        L_0x0019:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ all -> 0x0053 }
            r1.<init>(r5)     // Catch:{ all -> 0x0053 }
            r1.write(r4)     // Catch:{ all -> 0x0049 }
            android.os.ParcelFileDescriptor r4 = android.os.ParcelFileDescriptor.dup(r5)     // Catch:{ all -> 0x0049 }
            android.content.res.loader.ResourcesLoader r2 = new android.content.res.loader.ResourcesLoader     // Catch:{ all -> 0x003d }
            r2.<init>()     // Catch:{ all -> 0x003d }
            android.content.res.loader.ResourcesProvider r3 = android.content.res.loader.ResourcesProvider.loadFromTable(r4, r0)     // Catch:{ all -> 0x003d }
            r2.addProvider(r3)     // Catch:{ all -> 0x003d }
            if (r4 == 0) goto L_0x0036
            r4.close()     // Catch:{ all -> 0x0049 }
        L_0x0036:
            r1.close()     // Catch:{ all -> 0x0053 }
            android.system.Os.close(r5)     // Catch:{ Exception -> 0x005d }
            return r2
        L_0x003d:
            r2 = move-exception
            if (r4 == 0) goto L_0x0048
            r4.close()     // Catch:{ all -> 0x0044 }
            goto L_0x0048
        L_0x0044:
            r4 = move-exception
            r2.addSuppressed(r4)     // Catch:{ all -> 0x0049 }
        L_0x0048:
            throw r2     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r4 = move-exception
            r1.close()     // Catch:{ all -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r1 = move-exception
            r4.addSuppressed(r1)     // Catch:{ all -> 0x0053 }
        L_0x0052:
            throw r4     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r4 = move-exception
            goto L_0x0057
        L_0x0055:
            r4 = move-exception
            r5 = r0
        L_0x0057:
            if (r5 == 0) goto L_0x005c
            android.system.Os.close(r5)     // Catch:{ Exception -> 0x005d }
        L_0x005c:
            throw r4     // Catch:{ Exception -> 0x005d }
        L_0x005d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.color.ColorResourcesLoaderCreator.create(android.content.Context, java.util.Map):android.content.res.loader.ResourcesLoader");
    }
}
