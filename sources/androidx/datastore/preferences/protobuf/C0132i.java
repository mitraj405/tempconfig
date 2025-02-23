package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.n;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: androidx.datastore.preferences.protobuf.i  reason: case insensitive filesystem */
/* compiled from: ExtensionRegistryLite */
public final class C0132i {
    public static volatile C0132i a;
    public static final C0132i b = new C0132i(0);

    /* renamed from: a  reason: collision with other field name */
    public final Map<a, n.e<?, ?>> f1929a;

    /* renamed from: androidx.datastore.preferences.protobuf.i$a */
    /* compiled from: ExtensionRegistryLite */
    public static final class a {
        public final int a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f1930a;

        public a(Object obj, int i) {
            this.f1930a = obj;
            this.a = i;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
            r4 = (androidx.datastore.preferences.protobuf.C0132i.a) r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof androidx.datastore.preferences.protobuf.C0132i.a
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                androidx.datastore.preferences.protobuf.i$a r4 = (androidx.datastore.preferences.protobuf.C0132i.a) r4
                java.lang.Object r0 = r4.f1930a
                java.lang.Object r2 = r3.f1930a
                if (r2 != r0) goto L_0x0015
                int r0 = r3.a
                int r4 = r4.a
                if (r0 != r4) goto L_0x0015
                r1 = 1
            L_0x0015:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C0132i.a.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f1930a) * 65535) + this.a;
        }
    }

    static {
        try {
            Class.forName("androidx.datastore.preferences.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
        }
    }

    public C0132i() {
        this.f1929a = new HashMap();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|(3:9|10|11)|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.datastore.preferences.protobuf.C0132i a() {
        /*
            androidx.datastore.preferences.protobuf.i r0 = a
            if (r0 != 0) goto L_0x002b
            java.lang.Class<androidx.datastore.preferences.protobuf.i> r1 = androidx.datastore.preferences.protobuf.C0132i.class
            monitor-enter(r1)
            androidx.datastore.preferences.protobuf.i r0 = a     // Catch:{ all -> 0x0028 }
            if (r0 != 0) goto L_0x0026
            java.lang.Class<?> r0 = defpackage.Hb.a     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0022
            java.lang.String r2 = "getEmptyRegistry"
            r3 = 0
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0022 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r4)     // Catch:{ Exception -> 0x0022 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0022 }
            r3 = 0
            java.lang.Object r0 = r0.invoke(r3, r2)     // Catch:{ Exception -> 0x0022 }
            androidx.datastore.preferences.protobuf.i r0 = (androidx.datastore.preferences.protobuf.C0132i) r0     // Catch:{ Exception -> 0x0022 }
            goto L_0x0024
        L_0x0022:
            androidx.datastore.preferences.protobuf.i r0 = b     // Catch:{ all -> 0x0028 }
        L_0x0024:
            a = r0     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            goto L_0x002b
        L_0x0028:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            throw r0
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.C0132i.a():androidx.datastore.preferences.protobuf.i");
    }

    public C0132i(int i) {
        this.f1929a = Collections.emptyMap();
    }
}
