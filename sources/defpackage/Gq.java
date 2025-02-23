package defpackage;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;

/* renamed from: Gq  reason: default package */
/* compiled from: PropertyReference1 */
public abstract class Gq extends C0570Kq implements KProperty1 {
    public Gq() {
    }

    public KCallable computeReflected() {
        C0584Ls.a.getClass();
        return this;
    }

    public Object getDelegate(Object obj) {
        return ((KProperty1) getReflected()).getDelegate(obj);
    }

    public Object invoke(Object obj) {
        return get(obj);
    }

    public Gq(Object obj) {
        super(obj);
    }

    public KProperty1.Getter getGetter() {
        return ((KProperty1) getReflected()).getGetter();
    }

    public Gq(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, i);
    }
}
