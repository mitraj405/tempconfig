package defpackage;

import androidx.datastore.preferences.protobuf.n;

/* renamed from: je  reason: default package and case insensitive filesystem */
/* compiled from: GeneratedMessageInfoFactory */
public final class C0238je implements il {
    public static final C0238je a = new C0238je();

    /* JADX WARNING: type inference failed for: r4v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final defpackage.hl a(java.lang.Class<?> r4) {
        /*
            r3 = this;
            java.lang.Class<androidx.datastore.preferences.protobuf.n> r0 = androidx.datastore.preferences.protobuf.n.class
            boolean r1 = r0.isAssignableFrom(r4)
            if (r1 == 0) goto L_0x002a
            java.lang.Class r0 = r4.asSubclass(r0)     // Catch:{ Exception -> 0x0019 }
            androidx.datastore.preferences.protobuf.n r0 = androidx.datastore.preferences.protobuf.n.j(r0)     // Catch:{ Exception -> 0x0019 }
            androidx.datastore.preferences.protobuf.n$f r1 = androidx.datastore.preferences.protobuf.n.f.BUILD_MESSAGE_INFO     // Catch:{ Exception -> 0x0019 }
            java.lang.Object r0 = r0.i(r1)     // Catch:{ Exception -> 0x0019 }
            hl r0 = (defpackage.hl) r0     // Catch:{ Exception -> 0x0019 }
            return r0
        L_0x0019:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r4 = r4.getName()
            java.lang.String r2 = "Unable to get message info for "
            java.lang.String r4 = r2.concat(r4)
            r1.<init>(r4, r0)
            throw r1
        L_0x002a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r4 = r4.getName()
            java.lang.String r1 = "Unsupported message type: "
            java.lang.String r4 = r1.concat(r4)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0238je.a(java.lang.Class):hl");
    }

    public final boolean isSupported(Class<?> cls) {
        return n.class.isAssignableFrom(cls);
    }
}
