package defpackage;

import java.io.ObjectStreamException;
import java.io.Serializable;

/* renamed from: rm  reason: default package and case insensitive filesystem */
/* compiled from: NamedLoggerBase */
public abstract class C1370rm implements Bi, Serializable {
    private static final long serialVersionUID = 7535258609338176893L;

    public String getName() {
        return null;
    }

    public Object readResolve() throws ObjectStreamException {
        return C0473Ci.e(getName());
    }
}
