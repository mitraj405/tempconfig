package defpackage;

import android.os.CancellationSignal;

/* renamed from: B4  reason: default package */
/* compiled from: CancellationSignalProvider */
public final class B4 {
    public A4 a;

    /* renamed from: a  reason: collision with other field name */
    public final a f40a = new a();

    /* renamed from: a  reason: collision with other field name */
    public CancellationSignal f41a;

    /* renamed from: B4$a */
    /* compiled from: CancellationSignalProvider */
    public class a {
    }

    /* renamed from: B4$b */
    /* compiled from: CancellationSignalProvider */
    public static class b {
        public static void a(CancellationSignal cancellationSignal) {
            cancellationSignal.cancel();
        }

        public static CancellationSignal b() {
            return new CancellationSignal();
        }
    }
}
