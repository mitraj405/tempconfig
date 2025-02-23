package defpackage;

import android.view.Choreographer;

/* renamed from: Aq  reason: default package */
/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class Aq implements Choreographer.FrameCallback {
    public final /* synthetic */ Runnable a;

    public /* synthetic */ Aq(Runnable runnable) {
        this.a = runnable;
    }

    public final void doFrame(long j) {
        this.a.run();
    }
}
