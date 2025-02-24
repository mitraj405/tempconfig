package butterknife;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife {
    static final Map<Class<?>, Constructor<? extends Unbinder>> BINDINGS = new LinkedHashMap();
    private static final String TAG = "ButterKnife";
    private static boolean debug = false;

    private ButterKnife() {
        throw new AssertionError("No instances.");
    }

    public static Unbinder bind(Activity activity) {
        return bind((Object) activity, activity.getWindow().getDecorView());
    }

    private static Constructor<? extends Unbinder> findBindingConstructorForClass(Class<?> cls) {
        Constructor<? extends Unbinder> constructor;
        Map<Class<?>, Constructor<? extends Unbinder>> map = BINDINGS;
        Constructor<? extends Unbinder> constructor2 = map.get(cls);
        if (constructor2 != null || map.containsKey(cls)) {
            return constructor2;
        }
        String name = cls.getName();
        if (name.startsWith("android.") || name.startsWith("java.") || name.startsWith("androidx.")) {
            return null;
        }
        try {
            constructor = cls.getClassLoader().loadClass(name.concat("_ViewBinding")).getConstructor(new Class[]{cls, View.class});
            boolean z = debug;
        } catch (ClassNotFoundException unused) {
            if (debug) {
                cls.getSuperclass().getName();
            }
            constructor = findBindingConstructorForClass(cls.getSuperclass());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Unable to find binding constructor for ".concat(name), e);
        }
        BINDINGS.put(cls, constructor);
        return constructor;
    }

    public static void setDebug(boolean z) {
        debug = z;
    }

    public static Unbinder bind(View view) {
        return bind((Object) view, view);
    }

    public static Unbinder bind(Dialog dialog) {
        return bind((Object) dialog, dialog.getWindow().getDecorView());
    }

    public static Unbinder bind(Object obj, Activity activity) {
        return bind(obj, activity.getWindow().getDecorView());
    }

    public static Unbinder bind(Object obj, Dialog dialog) {
        return bind(obj, dialog.getWindow().getDecorView());
    }

    public static Unbinder bind(Object obj, View view) {
        Constructor<? extends Unbinder> findBindingConstructorForClass = findBindingConstructorForClass(obj.getClass());
        if (findBindingConstructorForClass == null) {
            return Unbinder.EMPTY;
        }
        try {
            return (Unbinder) findBindingConstructorForClass.newInstance(new Object[]{obj, view});
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to invoke " + findBindingConstructorForClass, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("Unable to invoke " + findBindingConstructorForClass, e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unable to create binding instance.", cause);
            }
        }
    }
}
