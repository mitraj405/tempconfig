package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.media.session.PlaybackStateCompat;
import defpackage.CE;
import in.juspay.hypersdk.core.PaymentConstants;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* renamed from: cm  reason: default package and case insensitive filesystem */
/* compiled from: MultiDexExtractor */
public final class C0160cm implements Closeable {
    public final long a;

    /* renamed from: a  reason: collision with other field name */
    public final File f2757a;

    /* renamed from: a  reason: collision with other field name */
    public final RandomAccessFile f2758a;

    /* renamed from: a  reason: collision with other field name */
    public final FileChannel f2759a;

    /* renamed from: a  reason: collision with other field name */
    public final FileLock f2760a;
    public final File b;

    /* renamed from: cm$a */
    /* compiled from: MultiDexExtractor */
    public static class a extends File {
        public long a = -1;

        public a(File file, String str) {
            super(file, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0041, code lost:
        r3 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0040 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041 A[ExcHandler: Error | RuntimeException (e java.lang.Throwable), Splitter:B:1:0x0023] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0160cm(java.io.File r3, java.io.File r4) throws java.io.IOException {
        /*
            r2 = this;
            r2.<init>()
            r3.getPath()
            r4.getPath()
            r2.f2757a = r3
            r2.b = r4
            long r0 = b(r3)
            r2.a = r0
            java.io.File r3 = new java.io.File
            java.lang.String r0 = "MultiDex.lock"
            r3.<init>(r4, r0)
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile
            java.lang.String r0 = "rw"
            r4.<init>(r3, r0)
            r2.f2758a = r4
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch:{ IOException -> 0x0045, RuntimeException -> 0x0043, Error -> 0x0041 }
            r2.f2759a = r4     // Catch:{ IOException -> 0x0045, RuntimeException -> 0x0043, Error -> 0x0041 }
            r3.getPath()     // Catch:{ IOException -> 0x003a, RuntimeException -> 0x0038, Error -> 0x0036 }
            java.nio.channels.FileLock r4 = r4.lock()     // Catch:{ IOException -> 0x003a, RuntimeException -> 0x0038, Error -> 0x0036 }
            r2.f2760a = r4     // Catch:{ IOException -> 0x003a, RuntimeException -> 0x0038, Error -> 0x0036 }
            r3.getPath()     // Catch:{ IOException -> 0x0045, RuntimeException -> 0x0043, Error -> 0x0041 }
            return
        L_0x0036:
            r3 = move-exception
            goto L_0x003b
        L_0x0038:
            r3 = move-exception
            goto L_0x003b
        L_0x003a:
            r3 = move-exception
        L_0x003b:
            java.nio.channels.FileChannel r4 = r2.f2759a     // Catch:{ IOException -> 0x0045, RuntimeException -> 0x0043, Error -> 0x0041 }
            r4.close()     // Catch:{ IOException -> 0x0040, RuntimeException -> 0x0043, Error -> 0x0041 }
        L_0x0040:
            throw r3     // Catch:{ IOException -> 0x0045, RuntimeException -> 0x0043, Error -> 0x0041 }
        L_0x0041:
            r3 = move-exception
            goto L_0x0046
        L_0x0043:
            r3 = move-exception
            goto L_0x0046
        L_0x0045:
            r3 = move-exception
        L_0x0046:
            java.io.RandomAccessFile r4 = r2.f2758a
            r4.close()     // Catch:{ IOException -> 0x004b }
        L_0x004b:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0160cm.<init>(java.io.File, java.io.File):void");
    }

    public static void a(ZipFile zipFile, ZipEntry zipEntry, a aVar, String str) throws IOException, FileNotFoundException {
        ZipOutputStream zipOutputStream;
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(C0709Uj.i("tmp-", str), ".zip", aVar.getParentFile());
        createTempFile.getPath();
        try {
            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            ZipEntry zipEntry2 = new ZipEntry("classes.dex");
            zipEntry2.setTime(zipEntry.getTime());
            zipOutputStream.putNextEntry(zipEntry2);
            byte[] bArr = new byte[16384];
            for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                zipOutputStream.write(bArr, 0, read);
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            if (createTempFile.setReadOnly()) {
                aVar.getPath();
                if (createTempFile.renameTo(aVar)) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                    createTempFile.delete();
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + aVar.getAbsolutePath() + "\"");
            }
            throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + aVar.getAbsolutePath() + "\")");
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            createTempFile.delete();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public static long b(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            CE.a a2 = CE.a(randomAccessFile);
            CRC32 crc32 = new CRC32();
            long j = a2.b;
            randomAccessFile.seek(a2.a);
            byte[] bArr = new byte[16384];
            int read = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
            while (true) {
                if (read == -1) {
                    break;
                }
                crc32.update(bArr, 0, read);
                j -= (long) read;
                if (j == 0) {
                    break;
                }
                read = randomAccessFile.read(bArr, 0, (int) Math.min(PlaybackStateCompat.ACTION_PREPARE, j));
            }
            long value = crc32.getValue();
            randomAccessFile.close();
            if (value == -1) {
                return value - 1;
            }
            return value;
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public static void j(Context context, long j, long j2, ArrayList arrayList) {
        SharedPreferences.Editor edit = context.getSharedPreferences("multidex.version", 4).edit();
        edit.putLong(PaymentConstants.TIMESTAMP, j);
        edit.putLong("crc", j2);
        edit.putInt("dex.number", arrayList.size() + 1);
        Iterator it = arrayList.iterator();
        int i = 2;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            edit.putLong(lf.h("dex.crc.", i), aVar.a);
            edit.putLong("dex.time." + i, aVar.lastModified());
            i++;
        }
        edit.commit();
    }

    public final ArrayList c(Context context, boolean z) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        boolean z2;
        File file = this.f2757a;
        file.getPath();
        if (this.f2760a.isValid()) {
            if (!z) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("multidex.version", 4);
                long j = sharedPreferences.getLong(PaymentConstants.TIMESTAMP, -1);
                long lastModified = file.lastModified();
                if (lastModified == -1) {
                    lastModified--;
                }
                if (j == lastModified && sharedPreferences.getLong("crc", -1) == this.a) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (!z2) {
                    try {
                        arrayList = e(context);
                    } catch (IOException unused) {
                        arrayList2 = h();
                        long lastModified2 = file.lastModified();
                        if (lastModified2 == -1) {
                            lastModified2--;
                        }
                        j(context, lastModified2, this.a, arrayList2);
                    }
                    arrayList.size();
                    return arrayList;
                }
            }
            arrayList2 = h();
            long lastModified3 = file.lastModified();
            if (lastModified3 == -1) {
                lastModified3--;
            }
            j(context, lastModified3, this.a, arrayList2);
            arrayList = arrayList2;
            arrayList.size();
            return arrayList;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public final void close() throws IOException {
        this.f2760a.release();
        this.f2759a.close();
        this.f2758a.close();
    }

    public final ArrayList e(Context context) throws IOException {
        String str = this.f2757a.getName() + ".classes";
        SharedPreferences sharedPreferences = context.getSharedPreferences("multidex.version", 4);
        int i = sharedPreferences.getInt("dex.number", 1);
        ArrayList arrayList = new ArrayList(i - 1);
        int i2 = 2;
        while (i2 <= i) {
            a aVar = new a(this.b, str + i2 + ".zip");
            if (aVar.isFile()) {
                aVar.a = b(aVar);
                long j = sharedPreferences.getLong("dex.crc." + i2, -1);
                long j2 = sharedPreferences.getLong("dex.time." + i2, -1);
                long lastModified = aVar.lastModified();
                if (j2 == lastModified && j == aVar.a) {
                    arrayList.add(aVar);
                    i2++;
                } else {
                    throw new IOException("Invalid extracted dex: " + aVar + " (key \"\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + aVar.a);
                }
            } else {
                throw new IOException("Missing extracted secondary dex file '" + aVar.getPath() + "'");
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:22|23) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r10.getAbsolutePath();
        r11 = false;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x009f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.ArrayList h() throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = ".dex"
            java.lang.String r1 = "classes"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = r13.f2757a
            java.lang.String r4 = r3.getName()
            r2.append(r4)
            java.lang.String r4 = ".classes"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            bm r4 = new bm
            r4.<init>()
            java.io.File r5 = r13.b
            java.io.File[] r4 = r5.listFiles(r4)
            r6 = 0
            if (r4 != 0) goto L_0x002d
            r5.getPath()
            goto L_0x0049
        L_0x002d:
            int r7 = r4.length
            r8 = r6
        L_0x002f:
            if (r8 >= r7) goto L_0x0049
            r9 = r4[r8]
            r9.getPath()
            r9.length()
            boolean r10 = r9.delete()
            if (r10 != 0) goto L_0x0043
            r9.getPath()
            goto L_0x0046
        L_0x0043:
            r9.getPath()
        L_0x0046:
            int r8 = r8 + 1
            goto L_0x002f
        L_0x0049:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.zip.ZipFile r7 = new java.util.zip.ZipFile
            r7.<init>(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r3.<init>()     // Catch:{ all -> 0x00b8 }
            r3.append(r1)     // Catch:{ all -> 0x00b8 }
            r8 = 2
            r3.append(r8)     // Catch:{ all -> 0x00b8 }
            r3.append(r0)     // Catch:{ all -> 0x00b8 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b8 }
            java.util.zip.ZipEntry r3 = r7.getEntry(r3)     // Catch:{ all -> 0x00b8 }
        L_0x006a:
            if (r3 == 0) goto L_0x00fd
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r9.<init>()     // Catch:{ all -> 0x00b8 }
            r9.append(r2)     // Catch:{ all -> 0x00b8 }
            r9.append(r8)     // Catch:{ all -> 0x00b8 }
            java.lang.String r10 = ".zip"
            r9.append(r10)     // Catch:{ all -> 0x00b8 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00b8 }
            cm$a r10 = new cm$a     // Catch:{ all -> 0x00b8 }
            r10.<init>(r5, r9)     // Catch:{ all -> 0x00b8 }
            r4.add(r10)     // Catch:{ all -> 0x00b8 }
            r10.toString()     // Catch:{ all -> 0x00b8 }
            r9 = r6
            r11 = r9
        L_0x008d:
            r12 = 3
            if (r9 >= r12) goto L_0x00ba
            if (r11 != 0) goto L_0x00ba
            int r9 = r9 + 1
            a(r7, r3, r10, r2)     // Catch:{ all -> 0x00b8 }
            long r11 = b(r10)     // Catch:{ IOException -> 0x009f }
            r10.a = r11     // Catch:{ IOException -> 0x009f }
            r11 = 1
            goto L_0x00a3
        L_0x009f:
            r10.getAbsolutePath()     // Catch:{ all -> 0x00b8 }
            r11 = r6
        L_0x00a3:
            r10.getAbsolutePath()     // Catch:{ all -> 0x00b8 }
            r10.length()     // Catch:{ all -> 0x00b8 }
            if (r11 != 0) goto L_0x008d
            r10.delete()     // Catch:{ all -> 0x00b8 }
            boolean r12 = r10.exists()     // Catch:{ all -> 0x00b8 }
            if (r12 == 0) goto L_0x008d
            r10.getPath()     // Catch:{ all -> 0x00b8 }
            goto L_0x008d
        L_0x00b8:
            r0 = move-exception
            goto L_0x0101
        L_0x00ba:
            if (r11 == 0) goto L_0x00d5
            int r8 = r8 + 1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r3.<init>()     // Catch:{ all -> 0x00b8 }
            r3.append(r1)     // Catch:{ all -> 0x00b8 }
            r3.append(r8)     // Catch:{ all -> 0x00b8 }
            r3.append(r0)     // Catch:{ all -> 0x00b8 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00b8 }
            java.util.zip.ZipEntry r3 = r7.getEntry(r3)     // Catch:{ all -> 0x00b8 }
            goto L_0x006a
        L_0x00d5:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00b8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r1.<init>()     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = "Could not create zip file "
            r1.append(r2)     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = r10.getAbsolutePath()     // Catch:{ all -> 0x00b8 }
            r1.append(r2)     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = " for secondary dex ("
            r1.append(r2)     // Catch:{ all -> 0x00b8 }
            r1.append(r8)     // Catch:{ all -> 0x00b8 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x00b8 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00b8 }
            r0.<init>(r1)     // Catch:{ all -> 0x00b8 }
            throw r0     // Catch:{ all -> 0x00b8 }
        L_0x00fd:
            r7.close()     // Catch:{ IOException -> 0x0100 }
        L_0x0100:
            return r4
        L_0x0101:
            r7.close()     // Catch:{ IOException -> 0x0104 }
        L_0x0104:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0160cm.h():java.util.ArrayList");
    }
}
