package defpackage;

import android.content.Context;
import java.io.File;
import java.util.HashMap;

/* renamed from: QD  reason: default package */
/* compiled from: WorkDatabasePathHelper */
public final class QD {
    public static final String[] a = {"-journal", "-shm", "-wal"};

    static {
        zi.e("WrkDbPathHelper");
    }

    public static void a(Context context) {
        if (context.getDatabasePath("androidx.work.workdb").exists()) {
            zi.c().a(new Throwable[0]);
            HashMap hashMap = new HashMap();
            File databasePath = context.getDatabasePath("androidx.work.workdb");
            File file = new File(context.getNoBackupFilesDir(), "androidx.work.workdb");
            hashMap.put(databasePath, file);
            for (String str : a) {
                hashMap.put(new File(databasePath.getPath() + str), new File(file.getPath() + str));
            }
            for (File file2 : hashMap.keySet()) {
                File file3 = (File) hashMap.get(file2);
                if (file2.exists() && file3 != null) {
                    if (file3.exists()) {
                        String.format("Over-writing contents of %s", new Object[]{file3});
                        zi.c().f(new Throwable[0]);
                    }
                    if (file2.renameTo(file3)) {
                        String.format("Migrated %s to %s", new Object[]{file2, file3});
                    } else {
                        String.format("Renaming %s to %s failed", new Object[]{file2, file3});
                    }
                    zi.c().a(new Throwable[0]);
                }
            }
        }
    }
}
