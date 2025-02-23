package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* renamed from: yC  reason: default package and case insensitive filesystem */
/* compiled from: ViewModel */
public abstract class C0404yC {
    public final HashMap a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    public final LinkedHashSet f3428a = new LinkedHashSet();

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f3429a = false;

    public static void a(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void b() {
    }
}
