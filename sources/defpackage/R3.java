package defpackage;

import android.os.Handler;
import android.os.HandlerThread;

/* renamed from: R3  reason: default package */
/* compiled from: CameraThread */
public final class R3 {
    public static R3 a;

    /* renamed from: a  reason: collision with other field name */
    public int f3780a = 0;

    /* renamed from: a  reason: collision with other field name */
    public Handler f3781a;

    /* renamed from: a  reason: collision with other field name */
    public HandlerThread f3782a;

    /* renamed from: a  reason: collision with other field name */
    public final Object f3783a = new Object();

    public final void a() {
        synchronized (this.f3783a) {
            if (this.f3781a == null) {
                if (this.f3780a > 0) {
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.f3782a = handlerThread;
                    handlerThread.start();
                    this.f3781a = new Handler(this.f3782a.getLooper());
                } else {
                    throw new IllegalStateException("CameraThread is not open");
                }
            }
        }
    }

    public final void b(Runnable runnable) {
        synchronized (this.f3783a) {
            a();
            this.f3781a.post(runnable);
        }
    }
}
