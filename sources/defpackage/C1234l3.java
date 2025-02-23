package defpackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* renamed from: l3  reason: default package and case insensitive filesystem */
/* compiled from: BoundaryInterfaceReflectionUtil */
public final class C1234l3 {

    /* renamed from: l3$a */
    /* compiled from: BoundaryInterfaceReflectionUtil */
    public static class a implements InvocationHandler {
        public final Object a;

        public a(C0314rD rDVar) {
            this.a = rDVar;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Object obj2 = this.a;
            try {
                return Class.forName(method.getDeclaringClass().getName(), true, obj2.getClass().getClassLoader()).getDeclaredMethod(method.getName(), method.getParameterTypes()).invoke(obj2, objArr);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            } catch (ReflectiveOperationException e2) {
                throw new RuntimeException("Reflection failed for method " + method, e2);
            }
        }
    }

    public static <T> T a(Class<T> cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(C1234l3.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }
}
