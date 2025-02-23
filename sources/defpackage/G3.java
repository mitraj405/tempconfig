package defpackage;

/* renamed from: G3  reason: default package */
/* compiled from: CallbackToFutureAdapter */
public final class G3 extends Throwable {
    public G3(String str) {
        super(str);
    }

    public final synchronized Throwable fillInStackTrace() {
        return this;
    }
}
