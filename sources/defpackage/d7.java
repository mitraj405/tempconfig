package defpackage;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.TypedValue;
import defpackage.Et;
import java.io.File;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* renamed from: d7  reason: default package */
/* compiled from: ContextCompat */
public class d7 {
    public static final Object a = new Object();

    /* renamed from: d7$a */
    /* compiled from: ContextCompat */
    public static class a {
        public static File a(Context context) {
            return context.getCodeCacheDir();
        }

        public static Drawable b(Context context, int i) {
            return context.getDrawable(i);
        }

        public static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* renamed from: d7$b */
    /* compiled from: ContextCompat */
    public static class b {
        public static int a(Context context, int i) {
            return context.getColor(i);
        }

        public static <T> T b(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        public static String c(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    /* renamed from: d7$c */
    /* compiled from: ContextCompat */
    public static class c {
        public static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        public static File b(Context context) {
            return context.getDataDir();
        }

        public static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    /* renamed from: d7$d */
    /* compiled from: ContextCompat */
    public static class d {
        public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
            if ((i & 4) == 0 || str != null) {
                return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i & 1);
            }
            Object obj = d7.a;
            String str2 = context.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
            if (r1.k(context, str2) == 0) {
                return context.registerReceiver(broadcastReceiver, intentFilter, str2, handler);
            }
            throw new RuntimeException(lf.j("Permission ", str2, " is required by your application to receive broadcasts, please add it to your manifest"));
        }

        public static ComponentName b(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    /* renamed from: d7$e */
    /* compiled from: ContextCompat */
    public static class e {
        public static Executor a(Context context) {
            return context.getMainExecutor();
        }
    }

    /* renamed from: d7$f */
    /* compiled from: ContextCompat */
    public static class f {
        public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
        }
    }

    public static int a(Context context, String str) {
        if (str == null) {
            throw new NullPointerException("permission must be non-null");
        } else if (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } else {
            if (new C0183en(context).a()) {
                return 0;
            }
            return -1;
        }
    }

    public static int b(Context context, int i) {
        return b.a(context, i);
    }

    public static ColorStateList c(Context context, int i) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        Et.c cVar;
        Resources resources = context.getResources();
        Resources.Theme theme = context.getTheme();
        Et.d dVar = new Et.d(resources, theme);
        synchronized (Et.a) {
            SparseArray sparseArray = Et.f162a.get(dVar);
            colorStateList = null;
            if (!(sparseArray == null || sparseArray.size() <= 0 || (cVar = (Et.c) sparseArray.get(i)) == null)) {
                if (!cVar.f164a.equals(resources.getConfiguration()) || (!(theme == null && cVar.a == 0) && (theme == null || cVar.a != theme.hashCode()))) {
                    sparseArray.remove(i);
                } else {
                    colorStateList2 = cVar.f163a;
                }
            }
            colorStateList2 = null;
        }
        if (colorStateList2 != null) {
            return colorStateList2;
        }
        ThreadLocal<TypedValue> threadLocal = Et.f161a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        boolean z = true;
        resources.getValue(i, typedValue, true);
        int i2 = typedValue.type;
        if (i2 < 28 || i2 > 31) {
            z = false;
        }
        if (!z) {
            try {
                colorStateList = C0416z5.a(resources, resources.getXml(i), theme);
            } catch (Exception unused) {
            }
        }
        if (colorStateList == null) {
            return Et.b.b(resources, i, theme);
        }
        synchronized (Et.a) {
            WeakHashMap<Et.d, SparseArray<Et.c>> weakHashMap = Et.f162a;
            SparseArray sparseArray2 = weakHashMap.get(dVar);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                weakHashMap.put(dVar, sparseArray2);
            }
            sparseArray2.append(i, new Et.c(colorStateList, dVar.f165a.getConfiguration(), theme));
        }
        return colorStateList;
    }

    public static Executor d(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return e.a(context);
        }
        return new sb(new Handler(context.getMainLooper()));
    }
}
