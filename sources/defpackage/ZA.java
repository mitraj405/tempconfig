package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import com.google.logging.type.LogSeverity;
import defpackage.C0180ed;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ZA  reason: default package */
/* compiled from: TypefaceCompatBaseImpl */
public class ZA {

    /* renamed from: ZA$a */
    /* compiled from: TypefaceCompatBaseImpl */
    public interface a<T> {
        int a(T t);

        boolean b(T t);
    }

    public ZA() {
        new ConcurrentHashMap();
    }

    public static <T> T d(T[] tArr, int i, a<T> aVar) {
        int i2;
        boolean z;
        int i3;
        if ((i & 1) == 0) {
            i2 = LogSeverity.WARNING_VALUE;
        } else {
            i2 = 700;
        }
        if ((i & 2) != 0) {
            z = true;
        } else {
            z = false;
        }
        T t = null;
        int i4 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = Math.abs(aVar.a(t2) - i2) * 2;
            if (aVar.b(t2) == z) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            int i5 = abs + i3;
            if (t == null || i4 > i5) {
                t = t2;
                i4 = i5;
            }
        }
        return t;
    }

    public Typeface a(Context context, C0180ed.c cVar, Resources resources, int i) {
        throw null;
    }

    public Typeface b(Context context, C0204gd[] gdVarArr, int i) {
        throw null;
    }

    public Typeface c(Context context, Resources resources, int i, String str, int i2) {
        File d = C0116aB.d(context);
        if (d == null) {
            return null;
        }
        try {
            if (!C0116aB.b(d, resources, i)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(d.getPath());
            d.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            d.delete();
        }
    }

    public C0204gd e(int i, C0204gd[] gdVarArr) {
        return (C0204gd) d(gdVarArr, i, new YA());
    }
}
