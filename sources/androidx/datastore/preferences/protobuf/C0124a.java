package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.C0124a;
import androidx.datastore.preferences.protobuf.C0124a.C0015a;
import defpackage.s5;
import defpackage.x3;
import java.io.IOException;
import java.util.logging.Logger;

/* renamed from: androidx.datastore.preferences.protobuf.a  reason: case insensitive filesystem */
/* compiled from: AbstractMessageLite */
public abstract class C0124a<MessageType extends C0124a<MessageType, BuilderType>, BuilderType extends C0015a<MessageType, BuilderType>> implements A {
    protected int memoizedHashCode = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.a$a  reason: collision with other inner class name */
    /* compiled from: AbstractMessageLite */
    public static abstract class C0015a<MessageType extends C0124a<MessageType, BuilderType>, BuilderType extends C0015a<MessageType, BuilderType>> implements A.a {
    }

    public final x3.e a() {
        try {
            n nVar = (n) this;
            int serializedSize = nVar.getSerializedSize();
            x3.e eVar = x3.f3407a;
            byte[] bArr = new byte[serializedSize];
            Logger logger = s5.a;
            s5.b bVar = new s5.b(bArr, serializedSize);
            nVar.e(bVar);
            if (bVar.a - bVar.b == 0) {
                return new x3.e(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a ByteString threw an IOException (should never happen).", e);
        }
    }

    /* access modifiers changed from: package-private */
    public int f() {
        throw new UnsupportedOperationException();
    }

    public final int g(kv kvVar) {
        int f = f();
        if (f != -1) {
            return f;
        }
        int serializedSize = kvVar.getSerializedSize(this);
        h(serializedSize);
        return serializedSize;
    }

    /* access modifiers changed from: package-private */
    public void h(int i) {
        throw new UnsupportedOperationException();
    }
}
