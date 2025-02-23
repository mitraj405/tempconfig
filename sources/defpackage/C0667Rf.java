package defpackage;

import java.io.Serializable;
import kotlin.Lazy;

/* renamed from: Rf  reason: default package and case insensitive filesystem */
/* compiled from: Lazy.kt */
public final class C0667Rf<T> implements Lazy<T>, Serializable {
    public final T a;

    public C0667Rf(T t) {
        this.a = t;
    }

    public final T getValue() {
        return this.a;
    }

    public final String toString() {
        return String.valueOf(this.a);
    }
}
