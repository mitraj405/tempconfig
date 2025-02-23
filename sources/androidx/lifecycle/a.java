package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
/* compiled from: ClassesInfoCache */
public final class a {
    public static final a a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final HashMap f2200a = new HashMap();
    public final HashMap b = new HashMap();

    @Deprecated
    /* renamed from: androidx.lifecycle.a$a  reason: collision with other inner class name */
    /* compiled from: ClassesInfoCache */
    public static class C0021a {
        public final HashMap a = new HashMap();

        /* renamed from: a  reason: collision with other field name */
        public final Map<b, Lifecycle.a> f2201a;

        public C0021a(HashMap hashMap) {
            this.f2201a = hashMap;
            for (Map.Entry entry : hashMap.entrySet()) {
                Lifecycle.a aVar = (Lifecycle.a) entry.getValue();
                List list = (List) this.a.get(aVar);
                if (list == null) {
                    list = new ArrayList();
                    this.a.put(aVar, list);
                }
                list.add((b) entry.getKey());
            }
        }

        public static void a(List<b> list, LifecycleOwner lifecycleOwner, Lifecycle.a aVar, Object obj) {
            if (list != null) {
                int size = list.size() - 1;
                while (size >= 0) {
                    b bVar = list.get(size);
                    bVar.getClass();
                    try {
                        int i = bVar.a;
                        Method method = bVar.f2202a;
                        if (i == 0) {
                            method.invoke(obj, new Object[0]);
                        } else if (i == 1) {
                            method.invoke(obj, new Object[]{lifecycleOwner});
                        } else if (i == 2) {
                            method.invoke(obj, new Object[]{lifecycleOwner, aVar});
                        }
                        size--;
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException("Failed to call observer method", e.getCause());
                    } catch (IllegalAccessException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        }
    }

    @Deprecated
    /* compiled from: ClassesInfoCache */
    public static final class b {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final Method f2202a;

        public b(Method method, int i) {
            this.a = i;
            this.f2202a = method;
            method.setAccessible(true);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.a != bVar.a || !this.f2202a.getName().equals(bVar.f2202a.getName())) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.f2202a.getName().hashCode() + (this.a * 31);
        }
    }

    public static void c(HashMap hashMap, b bVar, Lifecycle.a aVar, Class cls) {
        Lifecycle.a aVar2 = (Lifecycle.a) hashMap.get(bVar);
        if (aVar2 != null && aVar != aVar2) {
            Method method = bVar.f2202a;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
        } else if (aVar2 == null) {
            hashMap.put(bVar, aVar);
        }
    }

    public final C0021a a(Class<?> cls, Method[] methodArr) {
        int i;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            hashMap.putAll(b(superclass).f2201a);
        }
        for (Class b2 : cls.getInterfaces()) {
            for (Map.Entry next : b(b2).f2201a.entrySet()) {
                c(hashMap, (b) next.getKey(), (Lifecycle.a) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            try {
                methodArr = cls.getDeclaredMethods();
            } catch (NoClassDefFoundError e) {
                throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
            }
        }
        boolean z = false;
        for (Method method : methodArr) {
            g gVar = (g) method.getAnnotation(g.class);
            if (gVar != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else if (LifecycleOwner.class.isAssignableFrom(parameterTypes[0])) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.a value = gVar.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.a.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == Lifecycle.a.ON_ANY) {
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    c(hashMap, new b(method, i), value, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        C0021a aVar = new C0021a(hashMap);
        this.f2200a.put(cls, aVar);
        this.b.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    public final C0021a b(Class<?> cls) {
        C0021a aVar = (C0021a) this.f2200a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, (Method[]) null);
    }
}
