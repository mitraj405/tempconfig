package defpackage;

/* renamed from: wz  reason: default package and case insensitive filesystem */
/* compiled from: Tasks.kt */
public final class C1468wz extends C1433uz {
    public final Runnable a;

    public C1468wz(Runnable runnable, long j, C1448vz vzVar) {
        super(j, vzVar);
        this.a = runnable;
    }

    public final void run() {
        try {
            this.a.run();
        } finally {
            this.f6993a.a();
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Task[");
        Runnable runnable = this.a;
        sb.append(runnable.getClass().getSimpleName());
        sb.append('@');
        sb.append(C1149h8.a(runnable));
        sb.append(", ");
        sb.append(this.a);
        sb.append(", ");
        sb.append(this.f6993a);
        sb.append(']');
        return sb.toString();
    }
}
