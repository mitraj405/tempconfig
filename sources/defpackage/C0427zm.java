package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* renamed from: zm  reason: default package and case insensitive filesystem */
/* compiled from: NetworkFetcher */
public final class C0427zm {
    public final C1354qp a;

    /* renamed from: a  reason: collision with other field name */
    public final C0397xm f3487a;

    public C0427zm(C0397xm xmVar, C1354qp qpVar) {
        this.f3487a = xmVar;
        this.a = qpVar;
    }

    public final Lj<C0181ej> a(String str, InputStream inputStream, String str2, String str3) throws IOException {
        C0203gc gcVar;
        Lj<C0181ej> lj;
        if (str2 == null) {
            str2 = "application/json";
        }
        boolean contains = str2.contains("application/zip");
        C0397xm xmVar = this.f3487a;
        if (contains || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            Ai.a();
            gcVar = C0203gc.ZIP;
            if (str3 == null) {
                lj = C0281nj.f(new ZipInputStream(inputStream), (String) null);
            } else {
                lj = C0281nj.f(new ZipInputStream(new FileInputStream(xmVar.c(str, inputStream, gcVar))), str);
            }
        } else {
            Ai.a();
            gcVar = C0203gc.JSON;
            if (str3 == null) {
                lj = C0281nj.c(inputStream, (String) null);
            } else {
                lj = C0281nj.c(new FileInputStream(xmVar.c(str, inputStream, gcVar).getAbsolutePath()), str);
            }
        }
        if (!(str3 == null || lj.a == null)) {
            xmVar.getClass();
            File file = new File(xmVar.b(), C0397xm.a(str, gcVar, true));
            File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
            boolean renameTo = file.renameTo(file2);
            file2.toString();
            Ai.a();
            if (!renameTo) {
                Ai.b("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
            }
        }
        return lj;
    }
}
