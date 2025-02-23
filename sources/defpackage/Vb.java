package defpackage;

import defpackage.Nu;
import java.util.HashMap;

/* renamed from: Vb  reason: default package */
/* compiled from: FastSafeIterableMap */
public final class Vb<K, V> extends Nu<K, V> {
    public final HashMap<K, Nu.c<K, V>> a = new HashMap<>();

    public final Nu.c<K, V> a(K k) {
        return this.a.get(k);
    }

    public final V b(K k, V v) {
        Nu.c a2 = a(k);
        if (a2 != null) {
            return a2.f455b;
        }
        HashMap<K, Nu.c<K, V>> hashMap = this.a;
        Nu.c<K, V> cVar = new Nu.c<>(k, v);
        this.c++;
        Nu.c<K, V> cVar2 = this.b;
        if (cVar2 == null) {
            this.a = cVar;
            this.b = cVar;
        } else {
            cVar2.a = cVar;
            cVar.b = cVar2;
            this.b = cVar;
        }
        hashMap.put(k, cVar);
        return null;
    }

    public final V c(K k) {
        V c = super.c(k);
        this.a.remove(k);
        return c;
    }
}
