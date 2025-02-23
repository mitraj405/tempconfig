package defpackage;

import androidx.datastore.preferences.protobuf.E;

/* renamed from: Km  reason: default package */
/* compiled from: NewInstanceSchemas */
public final class Km {
    public static final Jm a;

    /* renamed from: a  reason: collision with other field name */
    public static final E f367a = new E();

    static {
        Jm jm;
        try {
            jm = (Jm) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            jm = null;
        }
        a = jm;
    }
}
