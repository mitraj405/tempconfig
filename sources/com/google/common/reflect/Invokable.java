package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

@ElementTypesAreNonnullByDefault
@Beta
public abstract class Invokable<T, R> implements AnnotatedElement, Member {
    private final AccessibleObject accessibleObject;
    private final Member member;

    public static class ConstructorInvokable<T> extends Invokable<T, T> {
        final Constructor<?> constructor;

        public ConstructorInvokable(Constructor<?> constructor2) {
            super(constructor2);
            this.constructor = constructor2;
        }

        private boolean mayNeedHiddenThis() {
            Class<?> declaringClass = this.constructor.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            Method enclosingMethod = declaringClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                return !Modifier.isStatic(enclosingMethod.getModifiers());
            }
            if (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) {
                return false;
            }
            return true;
        }

        public Type[] getGenericExceptionTypes() {
            return this.constructor.getGenericExceptionTypes();
        }

        public Type[] getGenericParameterTypes() {
            Type[] genericParameterTypes = this.constructor.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !mayNeedHiddenThis()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            if (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) {
                return (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length);
            }
            return genericParameterTypes;
        }

        public Type getGenericReturnType() {
            Class declaringClass = getDeclaringClass();
            TypeVariable[] typeParameters = declaringClass.getTypeParameters();
            if (typeParameters.length > 0) {
                return Types.newParameterizedType(declaringClass, typeParameters);
            }
            return declaringClass;
        }

        public final Annotation[][] getParameterAnnotations() {
            return this.constructor.getParameterAnnotations();
        }

        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable[] typeParameters2 = this.constructor.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[(typeParameters.length + typeParameters2.length)];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        public final Object invokeInternal(Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            try {
                return this.constructor.newInstance(objArr);
            } catch (InstantiationException e) {
                String valueOf = String.valueOf(this.constructor);
                throw new RuntimeException(C1058d.v(valueOf.length() + 8, valueOf, " failed."), e);
            }
        }

        public final boolean isOverridable() {
            return false;
        }

        public final boolean isVarArgs() {
            return this.constructor.isVarArgs();
        }
    }

    public static class MethodInvokable<T> extends Invokable<T, Object> {
        final Method method;

        public MethodInvokable(Method method2) {
            super(method2);
            this.method = method2;
        }

        public Type[] getGenericExceptionTypes() {
            return this.method.getGenericExceptionTypes();
        }

        public Type[] getGenericParameterTypes() {
            return this.method.getGenericParameterTypes();
        }

        public Type getGenericReturnType() {
            return this.method.getGenericReturnType();
        }

        public final Annotation[][] getParameterAnnotations() {
            return this.method.getParameterAnnotations();
        }

        public final TypeVariable<?>[] getTypeParameters() {
            return this.method.getTypeParameters();
        }

        public final Object invokeInternal(Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            return this.method.invoke(obj, objArr);
        }

        public final boolean isOverridable() {
            if (isFinal() || isPrivate() || isStatic() || Modifier.isFinal(getDeclaringClass().getModifiers())) {
                return false;
            }
            return true;
        }

        public final boolean isVarArgs() {
            return this.method.isVarArgs();
        }
    }

    public <M extends AccessibleObject & Member> Invokable(M m) {
        Preconditions.checkNotNull(m);
        this.accessibleObject = m;
        this.member = (Member) m;
    }

    public static Invokable<?, Object> from(Method method) {
        return new MethodInvokable(method);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Invokable)) {
            return false;
        }
        Invokable invokable = (Invokable) obj;
        if (!getOwnerType().equals(invokable.getOwnerType()) || !this.member.equals(invokable.member)) {
            return false;
        }
        return true;
    }

    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this.accessibleObject.getAnnotation(cls);
    }

    public final Annotation[] getAnnotations() {
        return this.accessibleObject.getAnnotations();
    }

    public final Annotation[] getDeclaredAnnotations() {
        return this.accessibleObject.getDeclaredAnnotations();
    }

    public final Class<? super T> getDeclaringClass() {
        return this.member.getDeclaringClass();
    }

    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type of : getGenericExceptionTypes()) {
            builder.add((Object) TypeToken.of(of));
        }
        return builder.build();
    }

    public abstract Type[] getGenericExceptionTypes();

    public abstract Type[] getGenericParameterTypes();

    public abstract Type getGenericReturnType();

    public final int getModifiers() {
        return this.member.getModifiers();
    }

    public final String getName() {
        return this.member.getName();
    }

    public TypeToken<T> getOwnerType() {
        return TypeToken.of(getDeclaringClass());
    }

    public abstract Annotation[][] getParameterAnnotations();

    public final ImmutableList<Parameter> getParameters() {
        Type[] genericParameterTypes = getGenericParameterTypes();
        Annotation[][] parameterAnnotations = getParameterAnnotations();
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < genericParameterTypes.length; i++) {
            builder.add((Object) new Parameter(this, i, TypeToken.of(genericParameterTypes[i]), parameterAnnotations[i]));
        }
        return builder.build();
    }

    public final TypeToken<? extends R> getReturnType() {
        return TypeToken.of(getGenericReturnType());
    }

    public abstract TypeVariable<?>[] getTypeParameters();

    public int hashCode() {
        return this.member.hashCode();
    }

    @CanIgnoreReturnValue
    public final R invoke(T t, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        return invokeInternal(t, (Object[]) Preconditions.checkNotNull(objArr));
    }

    public abstract Object invokeInternal(Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException;

    public final boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    public final boolean isAccessible() {
        return this.accessibleObject.isAccessible();
    }

    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.accessibleObject.isAnnotationPresent(cls);
    }

    public final boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    public final boolean isNative() {
        return Modifier.isNative(getModifiers());
    }

    public abstract boolean isOverridable();

    public final boolean isPackagePrivate() {
        if (isPrivate() || isPublic() || isProtected()) {
            return false;
        }
        return true;
    }

    public final boolean isPrivate() {
        return Modifier.isPrivate(getModifiers());
    }

    public final boolean isProtected() {
        return Modifier.isProtected(getModifiers());
    }

    public final boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    public final boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    public final boolean isSynchronized() {
        return Modifier.isSynchronized(getModifiers());
    }

    public final boolean isSynthetic() {
        return this.member.isSynthetic();
    }

    public final boolean isTransient() {
        return Modifier.isTransient(getModifiers());
    }

    public abstract boolean isVarArgs();

    public final boolean isVolatile() {
        return Modifier.isVolatile(getModifiers());
    }

    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> cls) {
        return returning(TypeToken.of(cls));
    }

    public final void setAccessible(boolean z) {
        this.accessibleObject.setAccessible(z);
    }

    public String toString() {
        return this.member.toString();
    }

    public final boolean trySetAccessible() {
        try {
            this.accessibleObject.setAccessible(true);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public static <T> Invokable<T, T> from(Constructor<T> constructor) {
        return new ConstructorInvokable(constructor);
    }

    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> typeToken) {
        if (typeToken.isSupertypeOf((TypeToken<?>) getReturnType())) {
            return this;
        }
        String valueOf = String.valueOf(getReturnType());
        String valueOf2 = String.valueOf(typeToken);
        throw new IllegalArgumentException(xx.A(valueOf2.length() + valueOf.length() + 35, "Invokable is known to return ", valueOf, ", not ", valueOf2));
    }
}
