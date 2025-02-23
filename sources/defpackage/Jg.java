package defpackage;

import java.io.Serializable;

/* renamed from: Jg  reason: default package */
/* compiled from: JavaType */
public enum Jg {
    VOID(Void.class, (int) null),
    INT(r7, 0),
    LONG(Long.class, 0L),
    FLOAT(Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.class, Boolean.FALSE),
    STRING(String.class, ""),
    BYTE_STRING(x3.class, x3.f3407a),
    ENUM(r7, (int) null),
    MESSAGE(Object.class, (int) null);
    

    /* renamed from: a  reason: collision with other field name */
    public final Object f306a;

    /* access modifiers changed from: public */
    Jg(Class cls, Serializable serializable) {
        this.f306a = serializable;
    }
}
