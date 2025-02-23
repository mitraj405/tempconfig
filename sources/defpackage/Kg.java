package defpackage;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.Job;

/* renamed from: Kg  reason: default package */
/* compiled from: Exceptions.kt */
public final class Kg extends CancellationException {
    public final transient Job a;

    public Kg(String str, Throwable th, Job job) {
        super(str);
        this.a = job;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Kg) {
                Kg kg = (Kg) obj;
                if (!C1177ig.a(kg.getMessage(), getMessage()) || !C1177ig.a(kg.a, this.a) || !C1177ig.a(kg.getCause(), getCause())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        int i;
        String message = getMessage();
        C1177ig.c(message);
        int hashCode = (this.a.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i = cause.hashCode();
        } else {
            i = 0;
        }
        return hashCode + i;
    }

    public final String toString() {
        return super.toString() + "; job=" + this.a;
    }
}
