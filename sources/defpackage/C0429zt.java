package defpackage;

import android.os.Handler;
import java.util.concurrent.Callable;

/* renamed from: zt  reason: default package and case insensitive filesystem */
/* compiled from: RequestExecutor */
public final class C0429zt<T> implements Runnable {
    public final U6<T> a;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f3488a;

    /* renamed from: a  reason: collision with other field name */
    public final Callable<T> f3489a;

    /* renamed from: zt$a */
    /* compiled from: RequestExecutor */
    public class a implements Runnable {
        public final /* synthetic */ U6 a;

        /* renamed from: a  reason: collision with other field name */
        public final /* synthetic */ Object f3490a;

        public a(U6 u6, Object obj) {
            this.a = u6;
            this.f3490a = obj;
        }

        public final void run() {
            this.a.accept(this.f3490a);
        }
    }

    public C0429zt(Handler handler, C0147bd bdVar, C0158cd cdVar) {
        this.f3489a = bdVar;
        this.a = cdVar;
        this.f3488a = handler;
    }

    public final void run() {
        T t;
        try {
            t = this.f3489a.call();
        } catch (Exception unused) {
            t = null;
        }
        this.f3488a.post(new a(this.a, t));
    }
}
