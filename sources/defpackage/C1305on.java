package defpackage;

import java.util.Collections;
import java.util.List;

/* renamed from: on  reason: default package and case insensitive filesystem */
/* compiled from: OPPOHomeBader */
public final class C1305on implements C1124g2 {
    public static int a = -1;

    public static boolean c() {
        if ("getColorOSVERSION".toString().equals("") || "getColorOSVERSION".toString().trim().equals("null")) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        if (r3.getSuperclass() != null) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return d(r3.getSuperclass());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return r3.getMethod("getColorOSVERSION", (java.lang.Class[]) null);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Method d(java.lang.Class r3) {
        /*
            java.lang.String r0 = "getColorOSVERSION"
            r1 = 0
            if (r3 == 0) goto L_0x002a
            boolean r2 = c()
            if (r2 == 0) goto L_0x000c
            goto L_0x002a
        L_0x000c:
            r3.getMethods()     // Catch:{ Exception -> 0x0017 }
            r3.getDeclaredMethods()     // Catch:{ Exception -> 0x0017 }
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r0, r1)     // Catch:{ Exception -> 0x0017 }
            return r3
        L_0x0017:
            java.lang.reflect.Method r3 = r3.getMethod(r0, r1)     // Catch:{ Exception -> 0x001c }
            return r3
        L_0x001c:
            java.lang.Class r0 = r3.getSuperclass()
            if (r0 == 0) goto L_0x002a
            java.lang.Class r3 = r3.getSuperclass()
            java.lang.reflect.Method r1 = d(r3)
        L_0x002a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1305on.d(java.lang.Class):java.lang.reflect.Method");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[SYNTHETIC, Splitter:B:13:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0034 A[SYNTHETIC, Splitter:B:21:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String e() {
        /*
            r0 = 0
            java.lang.Runtime r1 = java.lang.Runtime.getRuntime()     // Catch:{ IOException -> 0x0031, all -> 0x002a }
            java.lang.String r2 = "getprop ro.build.version.opporom"
            java.lang.Process r1 = r1.exec(r2)     // Catch:{ IOException -> 0x0031, all -> 0x002a }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0031, all -> 0x002a }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0031, all -> 0x002a }
            java.io.InputStream r1 = r1.getInputStream()     // Catch:{ IOException -> 0x0031, all -> 0x002a }
            r3.<init>(r1)     // Catch:{ IOException -> 0x0031, all -> 0x002a }
            r1 = 1024(0x400, float:1.435E-42)
            r2.<init>(r3, r1)     // Catch:{ IOException -> 0x0031, all -> 0x002a }
            java.lang.String r1 = r2.readLine()     // Catch:{ IOException -> 0x0032, all -> 0x0026 }
            r2.close()     // Catch:{ IOException -> 0x0032, all -> 0x0026 }
            r2.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            return r1
        L_0x0026:
            r0 = move-exception
            r1 = r0
            r0 = r2
            goto L_0x002b
        L_0x002a:
            r1 = move-exception
        L_0x002b:
            if (r0 == 0) goto L_0x0030
            r0.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            throw r1
        L_0x0031:
            r2 = r0
        L_0x0032:
            if (r2 == 0) goto L_0x0037
            r2.close()     // Catch:{ IOException -> 0x0037 }
        L_0x0037:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1305on.e():java.lang.String");
    }

    public final List<String> a() {
        return Collections.singletonList("com.oppo.launcher");
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0061 A[SYNTHETIC, Splitter:B:31:0x0061] */
    @android.annotation.TargetApi(11)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(android.content.Context r5, android.content.ComponentName r6, int r7) throws defpackage.Ew {
        /*
            r4 = this;
            if (r7 != 0) goto L_0x0003
            r7 = -1
        L_0x0003:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.oppo.unsettledevent"
            r0.<init>(r1)
            java.lang.String r1 = "pakeageName"
            java.lang.String r6 = r6.getPackageName()
            r0.putExtra(r1, r6)
            java.lang.String r6 = "number"
            r0.putExtra(r6, r7)
            java.lang.String r6 = "upgradeNumber"
            r0.putExtra(r6, r7)
            boolean r6 = defpackage.C1252m3.a(r5, r0)
            if (r6 == 0) goto L_0x0028
            r5.sendBroadcast(r0)
            goto L_0x00ba
        L_0x0028:
            int r6 = a
            r1 = 0
            if (r6 < 0) goto L_0x002e
            goto L_0x0085
        L_0x002e:
            java.lang.String r6 = "com.color.os.ColorBuild"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0035 }
            goto L_0x0036
        L_0x0035:
            r6 = r1
        L_0x0036:
            if (r6 == 0) goto L_0x0056
            boolean r2 = c()     // Catch:{ Exception -> 0x005e }
            if (r2 != 0) goto L_0x0056
            java.lang.reflect.Method r6 = d(r6)     // Catch:{ Exception -> 0x005e }
            if (r6 == 0) goto L_0x0056
            r2 = 1
            r6.setAccessible(r2)     // Catch:{ Exception -> 0x005e }
            java.lang.Object r6 = r6.invoke(r1, r1)     // Catch:{ IllegalAccessException -> 0x0052, InvocationTargetException -> 0x004d }
            goto L_0x0057
        L_0x004d:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ Exception -> 0x005e }
            goto L_0x0056
        L_0x0052:
            r6 = move-exception
            r6.printStackTrace()     // Catch:{ Exception -> 0x005e }
        L_0x0056:
            r6 = r1
        L_0x0057:
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ Exception -> 0x005e }
            int r6 = r6.intValue()     // Catch:{ Exception -> 0x005e }
            goto L_0x005f
        L_0x005e:
            r6 = 0
        L_0x005f:
            if (r6 != 0) goto L_0x0083
            java.lang.String r2 = e()     // Catch:{ Exception -> 0x0083 }
            java.lang.String r3 = "V1.4"
            boolean r3 = r2.startsWith(r3)     // Catch:{ Exception -> 0x0083 }
            if (r3 == 0) goto L_0x006f
            r6 = 3
            goto L_0x0085
        L_0x006f:
            java.lang.String r3 = "V2.0"
            boolean r3 = r2.startsWith(r3)     // Catch:{ Exception -> 0x0083 }
            if (r3 == 0) goto L_0x0079
            r6 = 4
            goto L_0x0085
        L_0x0079:
            java.lang.String r3 = "V2.1"
            boolean r2 = r2.startsWith(r3)     // Catch:{ Exception -> 0x0083 }
            if (r2 == 0) goto L_0x0083
            r6 = 5
            goto L_0x0085
        L_0x0083:
            a = r6
        L_0x0085:
            r2 = 6
            if (r6 != r2) goto L_0x00ba
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x00a2 }
            r6.<init>()     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "app_badge_count"
            r6.putInt(r2, r7)     // Catch:{ all -> 0x00a2 }
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ all -> 0x00a2 }
            java.lang.String r7 = "content://com.android.badge/badge"
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ all -> 0x00a2 }
            java.lang.String r2 = "setAppBadgeCount"
            r5.call(r7, r2, r1, r6)     // Catch:{ all -> 0x00a2 }
            goto L_0x00ba
        L_0x00a2:
            Ew r5 = new Ew
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "unable to resolve intent: "
            r6.<init>(r7)
            java.lang.String r7 = r0.toString()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C1305on.b(android.content.Context, android.content.ComponentName, int):void");
    }
}
