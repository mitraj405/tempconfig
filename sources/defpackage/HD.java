package defpackage;

import java.io.Serializable;

/* renamed from: HD  reason: default package */
/* compiled from: WireFormat */
public enum HD {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(x3.f3407a),
    ENUM((String) null),
    MESSAGE((String) null);
    

    /* renamed from: a  reason: collision with other field name */
    public final Object f259a;

    /* access modifiers changed from: public */
    HD(Serializable serializable) {
        this.f259a = serializable;
    }
}
