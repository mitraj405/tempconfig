package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.C0135l;
import java.util.Map;

/* compiled from: SmallSortedMap */
public final class I extends J<Object, Object> {
    public I(int i) {
        super(i);
    }

    public final void g() {
        if (!this.f1916a) {
            for (int i = 0; i < d(); i++) {
                ((C0135l.a) c(i).getKey()).b();
            }
            for (Map.Entry key : e()) {
                ((C0135l.a) key.getKey()).b();
            }
        }
        super.g();
    }

    public final /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((C0135l.a) obj, obj2);
    }
}
