package defpackage;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

/* renamed from: Q3  reason: default package */
/* compiled from: CameraSurface */
public final class Q3 {
    public final SurfaceTexture a;

    /* renamed from: a  reason: collision with other field name */
    public final SurfaceHolder f3759a;

    public Q3(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            this.f3759a = surfaceHolder;
            return;
        }
        throw new IllegalArgumentException("surfaceHolder may not be null");
    }

    public Q3(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            this.a = surfaceTexture;
            return;
        }
        throw new IllegalArgumentException("surfaceTexture may not be null");
    }
}
