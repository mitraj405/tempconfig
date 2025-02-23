package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.C0124a;
import androidx.datastore.preferences.protobuf.C0135l;
import androidx.datastore.preferences.protobuf.n;
import androidx.datastore.preferences.protobuf.n.a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: GeneratedMessageLite */
public abstract class n<MessageType extends n<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends C0124a<MessageType, BuilderType> {
    private static Map<Object, n<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    protected int memoizedSerializedSize = -1;
    protected L unknownFields = L.a;

    /* compiled from: GeneratedMessageLite */
    public static abstract class a<MessageType extends n<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends C0124a.C0015a<MessageType, BuilderType> {
        public final MessageType a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f1933a = false;
        public MessageType b;

        public a(MessageType messagetype) {
            this.a = messagetype;
            this.b = (n) messagetype.i(f.NEW_MUTABLE_INSTANCE);
        }

        public static void i(n nVar, n nVar2) {
            Mq mq = Mq.a;
            mq.getClass();
            mq.a(nVar.getClass()).mergeFrom(nVar, nVar2);
        }

        public final Object clone() throws CloneNotSupportedException {
            a aVar = (a) this.a.i(f.NEW_BUILDER);
            n g = g();
            aVar.h();
            i(aVar.b, g);
            return aVar;
        }

        public final n d() {
            return this.a;
        }

        public final MessageType f() {
            MessageType g = g();
            if (g.isInitialized()) {
                return g;
            }
            throw new C0222iB();
        }

        public final MessageType g() {
            if (this.f1933a) {
                return this.b;
            }
            MessageType messagetype = this.b;
            messagetype.getClass();
            Mq mq = Mq.a;
            mq.getClass();
            mq.a(messagetype.getClass()).makeImmutable(messagetype);
            this.f1933a = true;
            return this.b;
        }

        public final void h() {
            if (this.f1933a) {
                MessageType messagetype = (n) this.b.i(f.NEW_MUTABLE_INSTANCE);
                i(messagetype, this.b);
                this.b = messagetype;
                this.f1933a = false;
            }
        }
    }

    /* compiled from: GeneratedMessageLite */
    public static class b<T extends n<T, ?>> extends C0125b<T> {
        public b(T t) {
        }
    }

    /* compiled from: GeneratedMessageLite */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType> extends n<MessageType, BuilderType> implements jl {
        protected C0135l<d> extensions = C0135l.a;

        public final a b() {
            return (a) i(f.NEW_BUILDER);
        }

        public final a c() {
            a aVar = (a) i(f.NEW_BUILDER);
            aVar.h();
            a.i(aVar.b, this);
            return aVar;
        }

        public final n d() {
            return (n) i(f.GET_DEFAULT_INSTANCE);
        }
    }

    /* compiled from: GeneratedMessageLite */
    public static class e<ContainingType extends A, Type> extends v3 {
    }

    /* compiled from: GeneratedMessageLite */
    public enum f {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE
    }

    public static <T extends n<?, ?>> T j(Class<T> cls) {
        T t = (n) defaultInstanceMap.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (n) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (n) ((n) C0285oB.a(cls)).i(f.GET_DEFAULT_INSTANCE);
            if (t != null) {
                defaultInstanceMap.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    static Object k(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static <T extends n<T, ?>> T l(T t, C0128e eVar, C0132i iVar) throws q {
        T t2 = (n) t.i(f.NEW_MUTABLE_INSTANCE);
        try {
            Mq mq = Mq.a;
            mq.getClass();
            kv<?> a2 = mq.a(t2.getClass());
            C0129f fVar = eVar.f1926a;
            if (fVar == null) {
                fVar = new C0129f(eVar);
            }
            a2.a(t2, fVar, iVar);
            a2.makeImmutable(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof q) {
                throw ((q) e2.getCause());
            }
            throw new q(e2.getMessage());
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof q) {
                throw ((q) e3.getCause());
            }
            throw e3;
        }
    }

    public static <T extends n<?, ?>> void m(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    public a b() {
        return (a) i(f.NEW_BUILDER);
    }

    public a c() {
        a aVar = (a) i(f.NEW_BUILDER);
        aVar.h();
        a.i(aVar.b, this);
        return aVar;
    }

    public n d() {
        return (n) i(f.GET_DEFAULT_INSTANCE);
    }

    public final void e(s5 s5Var) throws IOException {
        Mq mq = Mq.a;
        mq.getClass();
        kv<?> a2 = mq.a(getClass());
        C0130g gVar = s5Var.f3248a;
        if (gVar == null) {
            gVar = new C0130g(s5Var);
        }
        a2.b(this, gVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((n) i(f.GET_DEFAULT_INSTANCE)).getClass().isInstance(obj)) {
            return false;
        }
        Mq mq = Mq.a;
        mq.getClass();
        return mq.a(getClass()).equals(this, (n) obj);
    }

    /* access modifiers changed from: package-private */
    public final int f() {
        return this.memoizedSerializedSize;
    }

    public final int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            Mq mq = Mq.a;
            mq.getClass();
            this.memoizedSerializedSize = mq.a(getClass()).getSerializedSize(this);
        }
        return this.memoizedSerializedSize;
    }

    /* access modifiers changed from: package-private */
    public final void h(int i) {
        this.memoizedSerializedSize = i;
    }

    public final int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        Mq mq = Mq.a;
        mq.getClass();
        int hashCode = mq.a(getClass()).hashCode(this);
        this.memoizedHashCode = hashCode;
        return hashCode;
    }

    public abstract Object i(f fVar);

    public final boolean isInitialized() {
        byte byteValue = ((Byte) i(f.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        Mq mq = Mq.a;
        mq.getClass();
        boolean isInitialized = mq.a(getClass()).isInitialized(this);
        i(f.SET_MEMOIZED_IS_INITIALIZED);
        return isInitialized;
    }

    public final String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        B.c(this, sb, 0);
        return sb.toString();
    }

    /* compiled from: GeneratedMessageLite */
    public static final class d implements C0135l.a<d> {
        public final HD c() {
            throw null;
        }

        public final int compareTo(Object obj) {
            ((d) obj).getClass();
            return 0;
        }

        public final a k(A.a aVar, A a) {
            a aVar2 = (a) aVar;
            aVar2.h();
            a.i(aVar2.b, (n) a);
            return aVar2;
        }

        public final void b() {
        }

        public final void d() {
        }

        public final void e() {
        }

        public final void g() {
        }
    }
}
