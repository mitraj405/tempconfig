package defpackage;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import com.journeyapps.barcodescanner.CameraPreview;

/* renamed from: P3  reason: default package */
/* compiled from: CameraPreview */
public final class P3 implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ CameraPreview a;

    public P3(CameraPreview cameraPreview) {
        this.a = cameraPreview;
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        C1205jx jxVar = new C1205jx(i, i2);
        CameraPreview cameraPreview = this.a;
        cameraPreview.f3962c = jxVar;
        cameraPreview.h();
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
