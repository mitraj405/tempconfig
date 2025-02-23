package defpackage;

/* renamed from: V7  reason: default package */
/* compiled from: SingleProcessDataStore.kt */
public final class V7<T> extends Rx<T> {
    public final int a;

    /* renamed from: a  reason: collision with other field name */
    public final T f587a;

    public V7(T t, int i) {
        this.f587a = t;
        this.a = i;
    }

    public final void a() {
        int i;
        boolean z = false;
        T t = this.f587a;
        if (t != null) {
            i = t.hashCode();
        } else {
            i = 0;
        }
        if (i == this.a) {
            z = true;
        }
        if (!z) {
            throw new IllegalStateException("Data in DataStore was mutated but DataStore is only compatible with Immutable types.".toString());
        }
    }
}
