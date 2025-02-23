package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C0128e;
import androidx.datastore.preferences.protobuf.n;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: Internal */
public final class p {
    public static final Charset a = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with other field name */
    public static final byte[] f1935a;

    /* compiled from: Internal */
    public interface a {
        int getNumber();
    }

    /* compiled from: Internal */
    public interface b {
        boolean a();
    }

    /* compiled from: Internal */
    public interface c<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        c<E> l(int i);

        void makeImmutable();
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f1935a = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new C0128e.a(bArr, 0, 0, false).e(0);
        } catch (q e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static n b(Object obj, Object obj2) {
        n.a c2 = ((A) obj).c();
        A a2 = (A) obj2;
        c2.getClass();
        if (c2.a.getClass().isInstance(a2)) {
            c2.h();
            n.a.i(c2.b, (n) ((C0124a) a2));
            return c2.g();
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
