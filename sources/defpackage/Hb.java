package defpackage;

/* renamed from: Hb  reason: default package */
/* compiled from: ExtensionRegistryFactory */
public final class Hb {
    public static final Class<?> a;

    static {
        Class<?> cls;
        try {
            cls = Class.forName("androidx.datastore.preferences.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        a = cls;
    }
}
