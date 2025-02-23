package defpackage;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: xm  reason: default package and case insensitive filesystem */
/* compiled from: NetworkCache */
public final class C0397xm {
    public final Ij a;

    public C0397xm(Kh kh) {
        this.a = kh;
    }

    public static String a(String str, C0203gc gcVar, boolean z) {
        StringBuilder sb = new StringBuilder("lottie_cache_");
        sb.append(str.replaceAll("\\W+", ""));
        String str2 = gcVar.c;
        if (z) {
            str2 = ".temp" + str2;
        }
        sb.append(str2);
        return sb.toString();
    }

    public final File b() {
        Kh kh = (Kh) this.a;
        kh.getClass();
        File file = new File(kh.a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final File c(String str, InputStream inputStream, C0203gc gcVar) throws IOException {
        FileOutputStream fileOutputStream;
        File file = new File(b(), a(str, gcVar, true));
        try {
            fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[UserMetadata.MAX_ATTRIBUTE_SIZE];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    inputStream.close();
                    return file;
                }
            }
        } catch (Throwable th) {
            inputStream.close();
            throw th;
        }
    }
}
