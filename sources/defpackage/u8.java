package defpackage;

import java.io.Closeable;
import java.net.HttpURLConnection;

/* renamed from: u8  reason: default package */
/* compiled from: DefaultLottieFetchResult */
public final class u8 implements Closeable {
    public final HttpURLConnection a;

    public u8(HttpURLConnection httpURLConnection) {
        this.a = httpURLConnection;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|18|19|28) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:20|21|22|23|24) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0059 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0069 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0012 A[SYNTHETIC, Splitter:B:10:0x0012] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0010 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:18:0x0059=Splitter:B:18:0x0059, B:23:0x0069=Splitter:B:23:0x0069} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a() {
        /*
            r4 = this;
            java.net.HttpURLConnection r0 = r4.a
            int r1 = r0.getResponseCode()     // Catch:{ IOException -> 0x000d }
            int r1 = r1 / 100
            r2 = 2
            if (r1 != r2) goto L_0x000d
            r1 = 1
            goto L_0x000e
        L_0x000d:
            r1 = 0
        L_0x000e:
            if (r1 == 0) goto L_0x0012
            r0 = 0
            goto L_0x0064
        L_0x0012:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006a }
            r1.<init>()     // Catch:{ IOException -> 0x006a }
            java.lang.String r2 = "Unable to fetch "
            r1.append(r2)     // Catch:{ IOException -> 0x006a }
            java.net.URL r2 = r0.getURL()     // Catch:{ IOException -> 0x006a }
            r1.append(r2)     // Catch:{ IOException -> 0x006a }
            java.lang.String r2 = ". Failed with "
            r1.append(r2)     // Catch:{ IOException -> 0x006a }
            int r2 = r0.getResponseCode()     // Catch:{ IOException -> 0x006a }
            r1.append(r2)     // Catch:{ IOException -> 0x006a }
            java.lang.String r2 = "\n"
            r1.append(r2)     // Catch:{ IOException -> 0x006a }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x006a }
            java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x006a }
            java.io.InputStream r0 = r0.getErrorStream()     // Catch:{ IOException -> 0x006a }
            r3.<init>(r0)     // Catch:{ IOException -> 0x006a }
            r2.<init>(r3)     // Catch:{ IOException -> 0x006a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006a }
            r0.<init>()     // Catch:{ IOException -> 0x006a }
        L_0x0047:
            java.lang.String r3 = r2.readLine()     // Catch:{ all -> 0x0065 }
            if (r3 == 0) goto L_0x0056
            r0.append(r3)     // Catch:{ all -> 0x0065 }
            r3 = 10
            r0.append(r3)     // Catch:{ all -> 0x0065 }
            goto L_0x0047
        L_0x0056:
            r2.close()     // Catch:{ Exception -> 0x0059 }
        L_0x0059:
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x006a }
            r1.append(r0)     // Catch:{ IOException -> 0x006a }
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x006a }
        L_0x0064:
            return r0
        L_0x0065:
            r0 = move-exception
            r2.close()     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            throw r0     // Catch:{ IOException -> 0x006a }
        L_0x006a:
            r0 = move-exception
            java.lang.String r1 = "get error failed "
            defpackage.Ai.c(r1, r0)
            java.lang.String r0 = r0.getMessage()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u8.a():java.lang.String");
    }

    public final void close() {
        this.a.disconnect();
    }
}
