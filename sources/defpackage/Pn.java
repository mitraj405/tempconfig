package defpackage;

/* renamed from: Pn  reason: default package */
/* compiled from: OnErrorFailedException */
public final class Pn extends RuntimeException {
    private static final long serialVersionUID = -419289748403337611L;

    public Pn(String str, Throwable th) {
        super(str, th);
    }

    public Pn(Throwable th) {
        super(th.getMessage(), th);
    }
}
