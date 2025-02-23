package androidx.datastore.preferences.protobuf;

/* compiled from: LazyFieldLite */
public class s {
    public volatile A a;

    /* renamed from: a  reason: collision with other field name */
    public volatile x3 f1936a;

    static {
        C0132i.a();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|9|10|11) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.datastore.preferences.protobuf.A a(androidx.datastore.preferences.protobuf.A r2) {
        /*
            r1 = this;
            androidx.datastore.preferences.protobuf.A r0 = r1.a
            if (r0 == 0) goto L_0x0005
            goto L_0x001a
        L_0x0005:
            monitor-enter(r1)
            androidx.datastore.preferences.protobuf.A r0 = r1.a     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            goto L_0x001a
        L_0x000c:
            r1.a = r2     // Catch:{ q -> 0x0013 }
            x3$e r0 = defpackage.x3.f3407a     // Catch:{ q -> 0x0013 }
            r1.f1936a = r0     // Catch:{ q -> 0x0013 }
            goto L_0x0019
        L_0x0013:
            r1.a = r2     // Catch:{ all -> 0x001d }
            x3$e r2 = defpackage.x3.f3407a     // Catch:{ all -> 0x001d }
            r1.f1936a = r2     // Catch:{ all -> 0x001d }
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
        L_0x001a:
            androidx.datastore.preferences.protobuf.A r2 = r1.a
            return r2
        L_0x001d:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.s.a(androidx.datastore.preferences.protobuf.A):androidx.datastore.preferences.protobuf.A");
    }

    public final x3 b() {
        if (this.f1936a != null) {
            return this.f1936a;
        }
        synchronized (this) {
            if (this.f1936a != null) {
                x3 x3Var = this.f1936a;
                return x3Var;
            }
            if (this.a == null) {
                this.f1936a = x3.f3407a;
            } else {
                this.f1936a = this.a.a();
            }
            x3 x3Var2 = this.f1936a;
            return x3Var2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        A a2 = this.a;
        A a3 = sVar.a;
        if (a2 == null && a3 == null) {
            return b().equals(sVar.b());
        }
        if (a2 != null && a3 != null) {
            return a2.equals(a3);
        }
        if (a2 != null) {
            return a2.equals(sVar.a(a2.d()));
        }
        return a(a3.d()).equals(a3);
    }

    public int hashCode() {
        return 1;
    }
}
