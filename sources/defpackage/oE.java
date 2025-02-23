package defpackage;

import android.os.Build;

/* renamed from: oE  reason: default package */
/* compiled from: WorkTypeConverters */
public final class oE {
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a A[SYNTHETIC, Splitter:B:23:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f A[SYNTHETIC, Splitter:B:34:0x005f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.C0141b7 a(byte[] r7) {
        /*
            b7 r0 = new b7
            r0.<init>()
            if (r7 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream
            r1.<init>(r7)
            r7 = 0
            java.io.ObjectInputStream r2 = new java.io.ObjectInputStream     // Catch:{ IOException -> 0x0041, all -> 0x003f }
            r2.<init>(r1)     // Catch:{ IOException -> 0x0041, all -> 0x003f }
            int r7 = r2.readInt()     // Catch:{ IOException -> 0x003d }
        L_0x0017:
            if (r7 <= 0) goto L_0x0032
            java.lang.String r3 = r2.readUTF()     // Catch:{ IOException -> 0x003d }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ IOException -> 0x003d }
            boolean r4 = r2.readBoolean()     // Catch:{ IOException -> 0x003d }
            b7$a r5 = new b7$a     // Catch:{ IOException -> 0x003d }
            r5.<init>(r3, r4)     // Catch:{ IOException -> 0x003d }
            java.util.HashSet r3 = r0.a     // Catch:{ IOException -> 0x003d }
            r3.add(r5)     // Catch:{ IOException -> 0x003d }
            int r7 = r7 + -1
            goto L_0x0017
        L_0x0032:
            r2.close()     // Catch:{ IOException -> 0x0036 }
            goto L_0x0052
        L_0x0036:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0052
        L_0x003b:
            r7 = move-exception
            goto L_0x005b
        L_0x003d:
            r7 = move-exception
            goto L_0x0045
        L_0x003f:
            r0 = move-exception
            goto L_0x005d
        L_0x0041:
            r2 = move-exception
            r6 = r2
            r2 = r7
            r7 = r6
        L_0x0045:
            r7.printStackTrace()     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x0052
            r2.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0052:
            r1.close()     // Catch:{ IOException -> 0x0056 }
            goto L_0x005a
        L_0x0056:
            r7 = move-exception
            r7.printStackTrace()
        L_0x005a:
            return r0
        L_0x005b:
            r0 = r7
            r7 = r2
        L_0x005d:
            if (r7 == 0) goto L_0x0067
            r7.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0067
        L_0x0063:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0067:
            r1.close()     // Catch:{ IOException -> 0x006b }
            goto L_0x006f
        L_0x006b:
            r7 = move-exception
            r7.printStackTrace()
        L_0x006f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oE.a(byte[]):b7");
    }

    public static int b(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        throw new IllegalArgumentException(C1058d.y("Could not convert ", i, " to BackoffPolicy"));
    }

    public static Em c(int i) {
        if (i == 0) {
            return Em.NOT_REQUIRED;
        }
        if (i == 1) {
            return Em.CONNECTED;
        }
        if (i == 2) {
            return Em.UNMETERED;
        }
        if (i == 3) {
            return Em.NOT_ROAMING;
        }
        if (i == 4) {
            return Em.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && i == 5) {
            return Em.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException(C1058d.y("Could not convert ", i, " to NetworkType"));
    }

    public static int d(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        throw new IllegalArgumentException(C1058d.y("Could not convert ", i, " to OutOfQuotaPolicy"));
    }

    public static UD e(int i) {
        if (i == 0) {
            return UD.ENQUEUED;
        }
        if (i == 1) {
            return UD.RUNNING;
        }
        if (i == 2) {
            return UD.SUCCEEDED;
        }
        if (i == 3) {
            return UD.FAILED;
        }
        if (i == 4) {
            return UD.BLOCKED;
        }
        if (i == 5) {
            return UD.CANCELLED;
        }
        throw new IllegalArgumentException(C1058d.y("Could not convert ", i, " to State"));
    }

    public static int f(UD ud) {
        int ordinal = ud.ordinal();
        if (ordinal == 0) {
            return 0;
        }
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                i = 3;
                if (ordinal != 3) {
                    i = 4;
                    if (ordinal != 4) {
                        if (ordinal == 5) {
                            return 5;
                        }
                        throw new IllegalArgumentException("Could not convert " + ud + " to int");
                    }
                }
            }
        }
        return i;
    }
}
