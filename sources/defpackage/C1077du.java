package defpackage;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.journeyapps.barcodescanner.CameraPreview;

/* renamed from: du  reason: default package and case insensitive filesystem */
/* compiled from: RotationListener */
public final class C1077du extends OrientationEventListener {
    public final /* synthetic */ C1095eu a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1077du(C1095eu euVar, Context context) {
        super(context, 3);
        this.a = euVar;
    }

    public final void onOrientationChanged(int i) {
        int rotation;
        C1095eu euVar = this.a;
        WindowManager windowManager = euVar.f5454a;
        C1056cu cuVar = euVar.f5455a;
        if (windowManager != null && cuVar != null && (rotation = windowManager.getDefaultDisplay().getRotation()) != euVar.a) {
            euVar.a = rotation;
            CameraPreview.c cVar = (CameraPreview.c) cuVar;
            CameraPreview.this.f3944a.postDelayed(new C0189f6(cVar, 6), 250);
        }
    }
}
