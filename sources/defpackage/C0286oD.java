package defpackage;

import android.content.Context;
import android.os.PowerManager;
import java.util.WeakHashMap;

/* renamed from: oD  reason: default package and case insensitive filesystem */
/* compiled from: WakeLocks */
public final class C0286oD {
    public static final WeakHashMap<PowerManager.WakeLock, String> a = new WeakHashMap<>();

    static {
        zi.e("WakeLocks");
    }

    public static PowerManager.WakeLock a(Context context, String str) {
        String i = C0709Uj.i("WorkManager: ", str);
        PowerManager.WakeLock newWakeLock = ((PowerManager) context.getApplicationContext().getSystemService("power")).newWakeLock(1, i);
        WeakHashMap<PowerManager.WakeLock, String> weakHashMap = a;
        synchronized (weakHashMap) {
            weakHashMap.put(newWakeLock, i);
        }
        return newWakeLock;
    }
}
