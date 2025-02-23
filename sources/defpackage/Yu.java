package defpackage;

import android.app.Application;
import androidx.lifecycle.k;
import in.juspay.hypersdk.core.PaymentConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: Yu  reason: default package */
/* compiled from: SavedStateViewModelFactory.kt */
public final class Yu {
    public static final List<Class<?>> a;
    public static final List<Class<?>> b;

    static {
        Class<k> cls = k.class;
        a = r1.F(Application.class, cls);
        b = r1.E(cls);
    }

    public static final <T> Constructor<T> a(Class<T> cls, List<? extends Class<?>> list) {
        List list2;
        C1177ig.f(list, PaymentConstants.SIGNATURE);
        Constructor<T>[] constructors = cls.getConstructors();
        C1177ig.e(constructors, "modelClass.constructors");
        int length = constructors.length;
        int i = 0;
        while (i < length) {
            Constructor<T> constructor = constructors[i];
            Class[] parameterTypes = constructor.getParameterTypes();
            C1177ig.e(parameterTypes, "constructor.parameterTypes");
            int length2 = parameterTypes.length;
            if (length2 == 0) {
                list2 = C1477xa.a;
            } else if (length2 != 1) {
                list2 = new ArrayList(new C0525H1(parameterTypes, false));
            } else {
                list2 = r1.E(parameterTypes[0]);
            }
            if (C1177ig.a(list, list2)) {
                return constructor;
            }
            if (list.size() != list2.size() || !list2.containsAll(list)) {
                i++;
            } else {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends C0404yC> T b(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        try {
            return (C0404yC) constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Failed to access " + cls, e);
        } catch (InstantiationException e2) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException("An exception happened in constructor of " + cls, e3.getCause());
        }
    }
}
