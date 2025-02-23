package defpackage;

import androidx.datastore.preferences.protobuf.C0130g;
import androidx.datastore.preferences.protobuf.C0132i;
import androidx.datastore.preferences.protobuf.G;
import java.io.IOException;

/* renamed from: kv  reason: default package */
/* compiled from: Schema */
public interface kv<T> {
    void a(T t, G g, C0132i iVar) throws IOException;

    void b(Object obj, C0130g gVar) throws IOException;

    boolean equals(T t, T t2);

    int getSerializedSize(T t);

    int hashCode(T t);

    boolean isInitialized(T t);

    void makeImmutable(T t);

    void mergeFrom(T t, T t2);

    T newInstance();
}
