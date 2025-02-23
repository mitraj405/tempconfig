package androidx.profileinstaller;

import android.content.pm.PackageInfo;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: ProfileInstaller */
public final class c {
    public static final a a = new a();

    /* renamed from: androidx.profileinstaller.c$c  reason: collision with other inner class name */
    /* compiled from: ProfileInstaller */
    public interface C0023c {
        void a();

        void b(int i, Object obj);
    }

    static {
        new b();
    }

    public static void a(PackageInfo packageInfo, File file) {
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            dataOutputStream.writeLong(packageInfo.lastUpdateTime);
            dataOutputStream.close();
            return;
        } catch (IOException unused) {
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:190:0x022b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0236, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:?, code lost:
        r5.addSuppressed(r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:185:0x021f, B:195:0x0232] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01aa A[SYNTHETIC, Splitter:B:135:0x01aa] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0269 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00e6 A[SYNTHETIC, Splitter:B:58:0x00e6] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.content.Context r17, defpackage.F1 r18, androidx.profileinstaller.c.C0023c r19, boolean r20) {
        /*
            r1 = r17
            r8 = r19
            android.content.Context r0 = r17.getApplicationContext()
            java.lang.String r2 = r0.getPackageName()
            android.content.pm.ApplicationInfo r3 = r0.getApplicationInfo()
            android.content.res.AssetManager r9 = r0.getAssets()
            java.io.File r0 = new java.io.File
            java.lang.String r3 = r3.sourceDir
            r0.<init>(r3)
            java.lang.String r6 = r0.getName()
            android.content.pm.PackageManager r0 = r17.getPackageManager()
            r11 = 0
            android.content.pm.PackageInfo r12 = r0.getPackageInfo(r2, r11)     // Catch:{ NameNotFoundException -> 0x0284 }
            java.io.File r13 = r17.getFilesDir()
            r14 = 1
            r15 = 0
            if (r20 != 0) goto L_0x0079
            java.io.File r0 = new java.io.File
            java.lang.String r3 = "profileinstaller_profileWrittenFor_lastUpdateTime.dat"
            r0.<init>(r13, r3)
            boolean r3 = r0.exists()
            if (r3 != 0) goto L_0x003f
            r0 = r11
            goto L_0x006d
        L_0x003f:
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch:{ IOException -> 0x006c }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x006c }
            r4.<init>(r0)     // Catch:{ IOException -> 0x006c }
            r3.<init>(r4)     // Catch:{ IOException -> 0x006c }
            long r4 = r3.readLong()     // Catch:{ all -> 0x0060 }
            r3.close()     // Catch:{ IOException -> 0x006c }
            long r10 = r12.lastUpdateTime
            int r0 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x0058
            r0 = r14
            goto L_0x0059
        L_0x0058:
            r0 = 0
        L_0x0059:
            if (r0 == 0) goto L_0x006d
            r3 = 2
            r8.b(r3, r15)
            goto L_0x006d
        L_0x0060:
            r0 = move-exception
            r4 = r0
            r3.close()     // Catch:{ all -> 0x0066 }
            goto L_0x006b
        L_0x0066:
            r0 = move-exception
            r3 = r0
            r4.addSuppressed(r3)     // Catch:{ IOException -> 0x006c }
        L_0x006b:
            throw r4     // Catch:{ IOException -> 0x006c }
        L_0x006c:
            r0 = 0
        L_0x006d:
            if (r0 != 0) goto L_0x0070
            goto L_0x0079
        L_0x0070:
            r17.getPackageName()
            r2 = 0
            androidx.profileinstaller.d.c(r1, r2)
            goto L_0x0271
        L_0x0079:
            r17.getPackageName()
            int r0 = android.os.Build.VERSION.SDK_INT
            java.io.File r10 = new java.io.File
            java.io.File r3 = new java.io.File
            java.lang.String r4 = "/data/misc/profiles/cur/0"
            r3.<init>(r4, r2)
            java.lang.String r2 = "primary.prof"
            r10.<init>(r3, r2)
            androidx.profileinstaller.b r11 = new androidx.profileinstaller.b
            java.lang.String r7 = "dexopt/baseline.prof"
            r2 = r11
            r3 = r9
            r4 = r18
            r5 = r19
            r16 = r7
            r7 = r10
            r2.<init>(r3, r4, r5, r6, r7)
            r2 = 4
            byte[] r3 = r11.f2264a
            if (r3 != 0) goto L_0x00aa
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4 = 3
            r11.b(r4, r0)
            goto L_0x00b3
        L_0x00aa:
            boolean r0 = r10.canWrite()
            if (r0 != 0) goto L_0x00b5
            r11.b(r2, r15)
        L_0x00b3:
            r0 = 0
            goto L_0x00b8
        L_0x00b5:
            r11.f2263a = r14
            r0 = r14
        L_0x00b8:
            if (r0 != 0) goto L_0x00be
            r4 = r14
            r2 = 0
            goto L_0x0267
        L_0x00be:
            boolean r0 = r11.f2263a
            java.lang.String r4 = "This device doesn't support aot. Did you call deviceSupportsAotProfile()?"
            if (r0 == 0) goto L_0x027e
            byte[] r5 = defpackage.Bq.a
            r6 = 8
            r7 = 6
            if (r3 != 0) goto L_0x00cd
            goto L_0x019b
        L_0x00cd:
            r0 = r16
            java.io.FileInputStream r0 = r11.a(r9, r0)     // Catch:{ FileNotFoundException -> 0x00dc, IOException -> 0x00d5 }
            r10 = r0
            goto L_0x00e2
        L_0x00d5:
            r0 = move-exception
            r10 = r0
            r14 = 7
            r8.b(r14, r10)
            goto L_0x00e1
        L_0x00dc:
            r0 = move-exception
            r10 = r0
            r8.b(r7, r10)
        L_0x00e1:
            r10 = r15
        L_0x00e2:
            java.lang.String r14 = "Invalid magic"
            if (r10 == 0) goto L_0x0134
            byte[] r0 = defpackage.C1354qp.l0(r2, r10)     // Catch:{ IOException -> 0x0109, IllegalStateException -> 0x0105 }
            boolean r0 = java.util.Arrays.equals(r5, r0)     // Catch:{ IOException -> 0x0109, IllegalStateException -> 0x0105 }
            if (r0 == 0) goto L_0x010b
            byte[] r0 = defpackage.C1354qp.l0(r2, r10)     // Catch:{ IOException -> 0x0109, IllegalStateException -> 0x0105 }
            java.lang.String r7 = r11.f2261a     // Catch:{ IOException -> 0x0109, IllegalStateException -> 0x0105 }
            S8[] r7 = defpackage.Bq.h(r10, r0, r7)     // Catch:{ IOException -> 0x0109, IllegalStateException -> 0x0105 }
            r10.close()     // Catch:{ IOException -> 0x00fe }
            goto L_0x0126
        L_0x00fe:
            r0 = move-exception
            r10 = r0
            r15 = 7
            r8.b(r15, r10)
            goto L_0x0126
        L_0x0105:
            r0 = move-exception
            goto L_0x0113
        L_0x0107:
            r0 = move-exception
            goto L_0x0111
        L_0x0109:
            r0 = move-exception
            goto L_0x0118
        L_0x010b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ IOException -> 0x0109, IllegalStateException -> 0x0105 }
            r0.<init>(r14)     // Catch:{ IOException -> 0x0109, IllegalStateException -> 0x0105 }
            throw r0     // Catch:{ IOException -> 0x0109, IllegalStateException -> 0x0105 }
        L_0x0111:
            r1 = r0
            goto L_0x0129
        L_0x0113:
            r8.b(r6, r0)     // Catch:{ all -> 0x0107 }
            r7 = 7
            goto L_0x011c
        L_0x0118:
            r7 = 7
            r8.b(r7, r0)     // Catch:{ all -> 0x0107 }
        L_0x011c:
            r10.close()     // Catch:{ IOException -> 0x0120 }
            goto L_0x0125
        L_0x0120:
            r0 = move-exception
            r10 = r0
            r8.b(r7, r10)
        L_0x0125:
            r7 = 0
        L_0x0126:
            r11.f2265a = r7
            goto L_0x0134
        L_0x0129:
            r10.close()     // Catch:{ IOException -> 0x012d }
            goto L_0x0133
        L_0x012d:
            r0 = move-exception
            r2 = r0
            r3 = 7
            r8.b(r3, r2)
        L_0x0133:
            throw r1
        L_0x0134:
            S8[] r0 = r11.f2265a
            if (r0 == 0) goto L_0x019b
            int r7 = android.os.Build.VERSION.SDK_INT
            r10 = 33
            if (r7 <= r10) goto L_0x013f
            goto L_0x0145
        L_0x013f:
            switch(r7) {
                case 31: goto L_0x0143;
                case 32: goto L_0x0143;
                case 33: goto L_0x0143;
                default: goto L_0x0142;
            }
        L_0x0142:
            goto L_0x0145
        L_0x0143:
            r7 = 1
            goto L_0x0146
        L_0x0145:
            r7 = 0
        L_0x0146:
            if (r7 == 0) goto L_0x019b
            java.lang.String r7 = "dexopt/baseline.profm"
            java.io.FileInputStream r7 = r11.a(r9, r7)     // Catch:{ FileNotFoundException -> 0x0191, IOException -> 0x018b, IllegalStateException -> 0x0183 }
            if (r7 == 0) goto L_0x017d
            byte[] r9 = defpackage.Bq.b     // Catch:{ all -> 0x0171 }
            byte[] r10 = defpackage.C1354qp.l0(r2, r7)     // Catch:{ all -> 0x0171 }
            boolean r9 = java.util.Arrays.equals(r9, r10)     // Catch:{ all -> 0x0171 }
            if (r9 == 0) goto L_0x016b
            byte[] r2 = defpackage.C1354qp.l0(r2, r7)     // Catch:{ all -> 0x0171 }
            S8[] r0 = defpackage.Bq.e(r7, r2, r3, r0)     // Catch:{ all -> 0x0171 }
            r11.f2265a = r0     // Catch:{ all -> 0x0171 }
            r7.close()     // Catch:{ FileNotFoundException -> 0x0191, IOException -> 0x018b, IllegalStateException -> 0x0183 }
            r0 = r11
            goto L_0x0198
        L_0x016b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0171 }
            r0.<init>(r14)     // Catch:{ all -> 0x0171 }
            throw r0     // Catch:{ all -> 0x0171 }
        L_0x0171:
            r0 = move-exception
            r2 = r0
            r7.close()     // Catch:{ all -> 0x0177 }
            goto L_0x017c
        L_0x0177:
            r0 = move-exception
            r3 = r0
            r2.addSuppressed(r3)     // Catch:{ FileNotFoundException -> 0x0191, IOException -> 0x018b, IllegalStateException -> 0x0183 }
        L_0x017c:
            throw r2     // Catch:{ FileNotFoundException -> 0x0191, IOException -> 0x018b, IllegalStateException -> 0x0183 }
        L_0x017d:
            if (r7 == 0) goto L_0x0197
            r7.close()     // Catch:{ FileNotFoundException -> 0x0191, IOException -> 0x018b, IllegalStateException -> 0x0183 }
            goto L_0x0197
        L_0x0183:
            r0 = move-exception
            r2 = 0
            r11.f2265a = r2
            r8.b(r6, r0)
            goto L_0x0197
        L_0x018b:
            r0 = move-exception
            r2 = 7
            r8.b(r2, r0)
            goto L_0x0197
        L_0x0191:
            r0 = move-exception
            r2 = 9
            r8.b(r2, r0)
        L_0x0197:
            r0 = 0
        L_0x0198:
            if (r0 == 0) goto L_0x019b
            r11 = r0
        L_0x019b:
            androidx.profileinstaller.c$c r2 = r11.a
            S8[] r0 = r11.f2265a
            if (r0 == 0) goto L_0x01f0
            byte[] r3 = r11.f2264a
            if (r3 != 0) goto L_0x01a6
            goto L_0x01f0
        L_0x01a6:
            boolean r7 = r11.f2263a
            if (r7 == 0) goto L_0x01ea
            java.io.ByteArrayOutputStream r7 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x01e1, IllegalStateException -> 0x01dc }
            r7.<init>()     // Catch:{ IOException -> 0x01e1, IllegalStateException -> 0x01dc }
            r7.write(r5)     // Catch:{ all -> 0x01d0 }
            r7.write(r3)     // Catch:{ all -> 0x01d0 }
            boolean r0 = defpackage.Bq.j(r7, r3, r0)     // Catch:{ all -> 0x01d0 }
            if (r0 != 0) goto L_0x01c6
            r0 = 5
            r3 = 0
            r2.b(r0, r3)     // Catch:{ all -> 0x01d0 }
            r11.f2265a = r3     // Catch:{ all -> 0x01d0 }
            r7.close()     // Catch:{ IOException -> 0x01e1, IllegalStateException -> 0x01dc }
            goto L_0x01f0
        L_0x01c6:
            byte[] r0 = r7.toByteArray()     // Catch:{ all -> 0x01d0 }
            r11.b = r0     // Catch:{ all -> 0x01d0 }
            r7.close()     // Catch:{ IOException -> 0x01e1, IllegalStateException -> 0x01dc }
            goto L_0x01e6
        L_0x01d0:
            r0 = move-exception
            r3 = r0
            r7.close()     // Catch:{ all -> 0x01d6 }
            goto L_0x01db
        L_0x01d6:
            r0 = move-exception
            r5 = r0
            r3.addSuppressed(r5)     // Catch:{ IOException -> 0x01e1, IllegalStateException -> 0x01dc }
        L_0x01db:
            throw r3     // Catch:{ IOException -> 0x01e1, IllegalStateException -> 0x01dc }
        L_0x01dc:
            r0 = move-exception
            r2.b(r6, r0)
            goto L_0x01e6
        L_0x01e1:
            r0 = move-exception
            r3 = 7
            r2.b(r3, r0)
        L_0x01e6:
            r2 = 0
            r11.f2265a = r2
            goto L_0x01f0
        L_0x01ea:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r4)
            throw r0
        L_0x01f0:
            byte[] r0 = r11.b
            if (r0 != 0) goto L_0x01f7
            r4 = 1
            goto L_0x0261
        L_0x01f7:
            boolean r2 = r11.f2263a
            if (r2 == 0) goto L_0x0278
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ FileNotFoundException -> 0x0256, IOException -> 0x024f }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0256, IOException -> 0x024f }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x023c }
            java.io.File r0 = r11.f2260a     // Catch:{ all -> 0x023c }
            r3.<init>(r0)     // Catch:{ all -> 0x023c }
            r0 = 512(0x200, float:7.175E-43)
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x022f }
        L_0x020b:
            int r4 = r2.read(r0)     // Catch:{ all -> 0x022f }
            if (r4 <= 0) goto L_0x021a
            r5 = 0
            r3.write(r0, r5, r4)     // Catch:{ all -> 0x0216 }
            goto L_0x020b
        L_0x0216:
            r0 = move-exception
            r5 = r0
            r4 = 1
            goto L_0x0232
        L_0x021a:
            r4 = 1
            r5 = 0
            r11.b(r4, r5)     // Catch:{ all -> 0x022d }
            r3.close()     // Catch:{ all -> 0x022b }
            r2.close()     // Catch:{ FileNotFoundException -> 0x024b, IOException -> 0x0249 }
            r11.b = r5
            r11.f2265a = r5
            r2 = r4
            goto L_0x0262
        L_0x022b:
            r0 = move-exception
            goto L_0x023e
        L_0x022d:
            r0 = move-exception
            goto L_0x0231
        L_0x022f:
            r0 = move-exception
            r4 = 1
        L_0x0231:
            r5 = r0
        L_0x0232:
            r3.close()     // Catch:{ all -> 0x0236 }
            goto L_0x023b
        L_0x0236:
            r0 = move-exception
            r3 = r0
            r5.addSuppressed(r3)     // Catch:{ all -> 0x022b }
        L_0x023b:
            throw r5     // Catch:{ all -> 0x022b }
        L_0x023c:
            r0 = move-exception
            r4 = 1
        L_0x023e:
            r3 = r0
            r2.close()     // Catch:{ all -> 0x0243 }
            goto L_0x0248
        L_0x0243:
            r0 = move-exception
            r2 = r0
            r3.addSuppressed(r2)     // Catch:{ FileNotFoundException -> 0x024b, IOException -> 0x0249 }
        L_0x0248:
            throw r3     // Catch:{ FileNotFoundException -> 0x024b, IOException -> 0x0249 }
        L_0x0249:
            r0 = move-exception
            goto L_0x0251
        L_0x024b:
            r0 = move-exception
            goto L_0x0258
        L_0x024d:
            r0 = move-exception
            goto L_0x0272
        L_0x024f:
            r0 = move-exception
            r4 = 1
        L_0x0251:
            r2 = 7
            r11.b(r2, r0)     // Catch:{ all -> 0x024d }
            goto L_0x025c
        L_0x0256:
            r0 = move-exception
            r4 = 1
        L_0x0258:
            r2 = 6
            r11.b(r2, r0)     // Catch:{ all -> 0x024d }
        L_0x025c:
            r2 = 0
            r11.b = r2
            r11.f2265a = r2
        L_0x0261:
            r2 = 0
        L_0x0262:
            if (r2 == 0) goto L_0x0267
            a(r12, r13)
        L_0x0267:
            if (r2 == 0) goto L_0x026d
            if (r20 == 0) goto L_0x026d
            r11 = r4
            goto L_0x026e
        L_0x026d:
            r11 = 0
        L_0x026e:
            androidx.profileinstaller.d.c(r1, r11)
        L_0x0271:
            return
        L_0x0272:
            r1 = 0
            r11.b = r1
            r11.f2265a = r1
            throw r0
        L_0x0278:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r4)
            throw r0
        L_0x027e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r4)
            throw r0
        L_0x0284:
            r0 = move-exception
            r2 = r0
            r3 = 7
            r8.b(r3, r2)
            r2 = 0
            androidx.profileinstaller.d.c(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.c.b(android.content.Context, F1, androidx.profileinstaller.c$c, boolean):void");
    }

    /* compiled from: ProfileInstaller */
    public class a implements C0023c {
        public final void a() {
        }

        public final void b(int i, Object obj) {
        }
    }

    /* compiled from: ProfileInstaller */
    public class b implements C0023c {
        public final void b(int i, Object obj) {
            if (i == 6 || i == 7 || i == 8) {
                Throwable th = (Throwable) obj;
            }
        }

        public final void a() {
        }
    }
}
