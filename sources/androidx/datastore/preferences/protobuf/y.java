package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.w;

/* compiled from: MapFieldSchema */
public interface y {
    x a(Object obj);

    x b(Object obj);

    x c();

    x d(Object obj, Object obj2);

    w.a<?, ?> e(Object obj);

    int getSerializedSize(int i, Object obj, Object obj2);

    boolean isImmutable(Object obj);

    Object toImmutable(Object obj);
}
