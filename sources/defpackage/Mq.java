package defpackage;

import androidx.datastore.preferences.protobuf.C;
import androidx.datastore.preferences.protobuf.C0133j;
import androidx.datastore.preferences.protobuf.D;
import androidx.datastore.preferences.protobuf.H;
import androidx.datastore.preferences.protobuf.K;
import androidx.datastore.preferences.protobuf.n;
import androidx.datastore.preferences.protobuf.p;
import androidx.datastore.preferences.protobuf.u;
import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: Mq  reason: default package */
/* compiled from: Protobuf */
public final class Mq {
    public static final Mq a = new Mq();

    /* renamed from: a  reason: collision with other field name */
    public final ConcurrentHashMap f410a = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with other field name */
    public final mk f411a = new mk();

    public final <T> kv<T> a(Class<T> cls) {
        kv<T> kvVar;
        D d;
        Class<?> cls2;
        Charset charset = p.a;
        if (cls != null) {
            ConcurrentHashMap concurrentHashMap = this.f410a;
            kv<T> kvVar2 = (kv) concurrentHashMap.get(cls);
            if (kvVar2 != null) {
                return kvVar2;
            }
            mk mkVar = this.f411a;
            mkVar.getClass();
            Class<?> cls3 = H.f1913a;
            Class<n> cls4 = n.class;
            if (cls4.isAssignableFrom(cls) || (cls2 = H.f1913a) == null || cls2.isAssignableFrom(cls)) {
                hl a2 = mkVar.f3106a.a(cls);
                if (a2.isMessageSetWireFormat()) {
                    if (cls4.isAssignableFrom(cls)) {
                        d = new D(H.f1912a, Ib.f265a, a2.a());
                    } else {
                        K<?, ?> k = H.a;
                        C0133j<?> jVar = Ib.a;
                        if (jVar != null) {
                            d = new D(k, jVar, a2.a());
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    }
                    kvVar = d;
                } else {
                    boolean isAssignableFrom = cls4.isAssignableFrom(cls);
                    boolean z = false;
                    if (isAssignableFrom) {
                        if (a2.b() == 1) {
                            z = true;
                        }
                        if (z) {
                            kvVar = C.p(a2, Km.f367a, u.f1937a, H.f1912a, Ib.f265a, C0291ok.f3161a);
                        } else {
                            kvVar = C.p(a2, Km.f367a, u.f1937a, H.f1912a, (C0133j) null, C0291ok.f3161a);
                        }
                    } else {
                        if (a2.b() == 1) {
                            z = true;
                        }
                        if (z) {
                            Jm jm = Km.a;
                            u.a aVar = u.a;
                            K<?, ?> k2 = H.a;
                            C0133j<?> jVar2 = Ib.a;
                            if (jVar2 != null) {
                                kvVar = C.p(a2, jm, aVar, k2, jVar2, C0291ok.a);
                            } else {
                                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                            }
                        } else {
                            kvVar = C.p(a2, Km.a, u.a, H.b, (C0133j) null, C0291ok.a);
                        }
                    }
                }
                kv<T> kvVar3 = (kv) concurrentHashMap.putIfAbsent(cls, kvVar);
                if (kvVar3 != null) {
                    return kvVar3;
                }
                return kvVar;
            }
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        throw new NullPointerException("messageType");
    }
}
