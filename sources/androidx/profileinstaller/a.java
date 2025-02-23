package androidx.profileinstaller;

import java.io.File;

/* compiled from: BenchmarkOperation */
public final class a {
    public static boolean a(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return false;
            }
            boolean z = true;
            for (File a : listFiles) {
                if (!a(a) || !z) {
                    z = false;
                } else {
                    z = true;
                }
            }
            return z;
        }
        file.delete();
        return true;
    }
}
