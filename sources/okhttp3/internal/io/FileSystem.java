package okhttp3.internal.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() {
        public Sink appendingSink(File file) throws FileNotFoundException {
            try {
                Logger logger = C1517zn.a;
                if (file != null) {
                    return new C1445vn(new FileOutputStream(file, true), new Timeout());
                }
                throw new IllegalArgumentException("file == null");
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                Logger logger2 = C1517zn.a;
                return new C1445vn(new FileOutputStream(file, true), new Timeout());
            }
        }

        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                throw new IOException("failed to delete " + file);
            }
        }

        public void deleteContents(File file) throws IOException {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                int i = 0;
                while (i < length) {
                    File file2 = listFiles[i];
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (file2.delete()) {
                        i++;
                    } else {
                        throw new IOException("failed to delete " + file2);
                    }
                }
                return;
            }
            throw new IOException("not a readable directory: " + file);
        }

        public boolean exists(File file) {
            return file.exists();
        }

        public void rename(File file, File file2) throws IOException {
            delete(file2);
            if (!file.renameTo(file2)) {
                throw new IOException("failed to rename " + file + " to " + file2);
            }
        }

        public Sink sink(File file) throws FileNotFoundException {
            try {
                Logger logger = C1517zn.a;
                if (file != null) {
                    return new C1445vn(new FileOutputStream(file), new Timeout());
                }
                throw new IllegalArgumentException("file == null");
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                Logger logger2 = C1517zn.a;
                return new C1445vn(new FileOutputStream(file), new Timeout());
            }
        }

        public long size(File file) {
            return file.length();
        }

        public Source source(File file) throws FileNotFoundException {
            Logger logger = C1517zn.a;
            if (file != null) {
                return C1517zn.b(new FileInputStream(file));
            }
            throw new IllegalArgumentException("file == null");
        }
    };

    Sink appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    Sink sink(File file) throws FileNotFoundException;

    long size(File file);

    Source source(File file) throws FileNotFoundException;
}
