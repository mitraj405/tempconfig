package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;

/* compiled from: FragmentFactory */
public class l {
    public static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> a = new SimpleArrayMap<>();

    public static Class<?> a(ClassLoader classLoader, String str) throws ClassNotFoundException {
        SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> simpleArrayMap = a;
        SimpleArrayMap orDefault = simpleArrayMap.getOrDefault(classLoader, null);
        if (orDefault == null) {
            orDefault = new SimpleArrayMap();
            simpleArrayMap.put(classLoader, orDefault);
        }
        Class<?> cls = (Class) orDefault.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        orDefault.put(str, cls2);
        return cls2;
    }

    public static Class<? extends Fragment> b(ClassLoader classLoader, String str) {
        try {
            return a(classLoader, str);
        } catch (ClassNotFoundException e) {
            throw new Fragment.i(lf.j("Unable to instantiate fragment ", str, ": make sure class name exists"), e);
        } catch (ClassCastException e2) {
            throw new Fragment.i(lf.j("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e2);
        }
    }
}
