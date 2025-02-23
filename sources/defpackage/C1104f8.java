package defpackage;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.FileWriter;

/* renamed from: f8  reason: default package and case insensitive filesystem */
/* compiled from: DebugFileManager */
public final class C1104f8 {
    public static void a(Context context, File file, String str, String str2) {
        if (file != null) {
            File file2 = new File(file, "pid.debug");
            C1139gq c = C1139gq.c(context);
            try {
                FileWriter fileWriter = new FileWriter(file2, true);
                fileWriter.append(str2).append("\n");
                fileWriter.append(str).append("\n");
                fileWriter.flush();
                fileWriter.close();
                if (str2.equalsIgnoreCase("RegisterToken")) {
                    c.f("iz_fileExits", true);
                }
            } catch (Exception e) {
                c.f("iz_fileExits", false);
                e.toString();
            }
        }
    }

    public static void b(Context context, String str, String str2) {
        File file;
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                file = Environment.getExternalStoragePublicDirectory("DATB.907135001.debug");
                if (file.exists() && file.isDirectory()) {
                    a(context, file, str, str2);
                }
            }
            file = null;
            a(context, file, str, str2);
        } catch (Exception e) {
            e.toString();
        }
    }
}
