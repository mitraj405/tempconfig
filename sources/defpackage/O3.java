package defpackage;

import android.content.Context;
import android.hardware.Camera;
import android.os.Handler;
import android.view.SurfaceHolder;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.camera.CameraManager;
import com.journeyapps.barcodescanner.camera.CameraSettings;

/* renamed from: O3  reason: default package */
/* compiled from: CameraInstance */
public final class O3 {
    public static final /* synthetic */ int a = 0;

    /* renamed from: a  reason: collision with other field name */
    public final a f3724a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final b f3725a = new b();

    /* renamed from: a  reason: collision with other field name */
    public final c f3726a = new c();

    /* renamed from: a  reason: collision with other field name */
    public final d f3727a = new d();

    /* renamed from: a  reason: collision with other field name */
    public Q3 f3728a;

    /* renamed from: a  reason: collision with other field name */
    public final R3 f3729a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f3730a;

    /* renamed from: a  reason: collision with other field name */
    public final CameraManager f3731a;

    /* renamed from: a  reason: collision with other field name */
    public CameraSettings f3732a = new CameraSettings();

    /* renamed from: a  reason: collision with other field name */
    public C1237l9 f3733a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3734a = false;
    public final Handler b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f3735b = true;

    /* renamed from: O3$a */
    /* compiled from: CameraInstance */
    public class a implements Runnable {
        public a() {
        }

        public final void run() {
            O3 o3 = O3.this;
            try {
                int i = O3.a;
                o3.f3731a.b();
            } catch (Exception e) {
                Handler handler = o3.f3730a;
                if (handler != null) {
                    handler.obtainMessage(R.id.zxing_camera_error, e).sendToTarget();
                }
            }
        }
    }

    /* renamed from: O3$b */
    /* compiled from: CameraInstance */
    public class b implements Runnable {
        public b() {
        }

        public final void run() {
            boolean z;
            O3 o3 = O3.this;
            try {
                int i = O3.a;
                o3.f3731a.a();
                Handler handler = o3.f3730a;
                if (handler != null) {
                    int i2 = R.id.zxing_prewiew_size_ready;
                    CameraManager cameraManager = o3.f3731a;
                    C1205jx jxVar = cameraManager.b;
                    if (jxVar == null) {
                        jxVar = null;
                    } else {
                        int i3 = cameraManager.a;
                        if (i3 != -1) {
                            if (i3 % 180 != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (z) {
                                jxVar = new C1205jx(jxVar.d, jxVar.c);
                            }
                        } else {
                            throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
                        }
                    }
                    handler.obtainMessage(i2, jxVar).sendToTarget();
                }
            } catch (Exception e) {
                Handler handler2 = o3.f3730a;
                if (handler2 != null) {
                    handler2.obtainMessage(R.id.zxing_camera_error, e).sendToTarget();
                }
            }
        }
    }

    /* renamed from: O3$c */
    /* compiled from: CameraInstance */
    public class c implements Runnable {
        public c() {
        }

        public final void run() {
            O3 o3 = O3.this;
            try {
                int i = O3.a;
                CameraManager cameraManager = o3.f3731a;
                Q3 q3 = o3.f3728a;
                Camera camera = cameraManager.f3987a;
                SurfaceHolder surfaceHolder = q3.f3759a;
                if (surfaceHolder != null) {
                    camera.setPreviewDisplay(surfaceHolder);
                } else {
                    camera.setPreviewTexture(q3.a);
                }
                o3.f3731a.e();
            } catch (Exception e) {
                Handler handler = o3.f3730a;
                if (handler != null) {
                    handler.obtainMessage(R.id.zxing_camera_error, e).sendToTarget();
                }
            }
        }
    }

    /* renamed from: O3$d */
    /* compiled from: CameraInstance */
    public class d implements Runnable {
        public d() {
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:4|(2:6|7)|8|9) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r6 = this;
                r0 = 1
                r1 = 0
                int r2 = defpackage.O3.a     // Catch:{ Exception -> 0x0049 }
                O3 r2 = defpackage.O3.this     // Catch:{ Exception -> 0x0049 }
                com.journeyapps.barcodescanner.camera.CameraManager r2 = r2.f3731a     // Catch:{ Exception -> 0x0049 }
                a2 r3 = r2.f3984a     // Catch:{ Exception -> 0x0049 }
                r4 = 0
                if (r3 == 0) goto L_0x0021
                r3.f3896a = r0     // Catch:{ Exception -> 0x0049 }
                r3.b = r4     // Catch:{ Exception -> 0x0049 }
                android.os.Handler r5 = r3.f3895a     // Catch:{ Exception -> 0x0049 }
                r5.removeMessages(r0)     // Catch:{ Exception -> 0x0049 }
                boolean r5 = r3.c     // Catch:{ Exception -> 0x0049 }
                if (r5 == 0) goto L_0x001f
                android.hardware.Camera r3 = r3.f3894a     // Catch:{ RuntimeException -> 0x001f }
                r3.cancelAutoFocus()     // Catch:{ RuntimeException -> 0x001f }
            L_0x001f:
                r2.f3984a = r1     // Catch:{ Exception -> 0x0049 }
            L_0x0021:
                com.google.zxing.client.android.AmbientLightManager r3 = r2.f3988a     // Catch:{ Exception -> 0x0049 }
                if (r3 == 0) goto L_0x002a
                r3.stop()     // Catch:{ Exception -> 0x0049 }
                r2.f3988a = r1     // Catch:{ Exception -> 0x0049 }
            L_0x002a:
                android.hardware.Camera r3 = r2.f3987a     // Catch:{ Exception -> 0x0049 }
                if (r3 == 0) goto L_0x003b
                boolean r5 = r2.f3994a     // Catch:{ Exception -> 0x0049 }
                if (r5 == 0) goto L_0x003b
                r3.stopPreview()     // Catch:{ Exception -> 0x0049 }
                com.journeyapps.barcodescanner.camera.CameraManager$a r3 = r2.f3989a     // Catch:{ Exception -> 0x0049 }
                r3.f3996a = r1     // Catch:{ Exception -> 0x0049 }
                r2.f3994a = r4     // Catch:{ Exception -> 0x0049 }
            L_0x003b:
                O3 r2 = defpackage.O3.this     // Catch:{ Exception -> 0x0049 }
                com.journeyapps.barcodescanner.camera.CameraManager r2 = r2.f3731a     // Catch:{ Exception -> 0x0049 }
                android.hardware.Camera r3 = r2.f3987a     // Catch:{ Exception -> 0x0049 }
                if (r3 == 0) goto L_0x004b
                r3.release()     // Catch:{ Exception -> 0x0049 }
                r2.f3987a = r1     // Catch:{ Exception -> 0x0049 }
                goto L_0x004b
            L_0x0049:
                int r2 = defpackage.O3.a
            L_0x004b:
                O3 r2 = defpackage.O3.this
                r2.f3735b = r0
                android.os.Handler r0 = r2.f3730a
                int r2 = com.google.zxing.client.android.R.id.zxing_camera_closed
                r0.sendEmptyMessage(r2)
                O3 r0 = defpackage.O3.this
                R3 r0 = r0.f3729a
                java.lang.Object r2 = r0.f3783a
                monitor-enter(r2)
                int r3 = r0.f3780a     // Catch:{ all -> 0x0078 }
                int r3 = r3 + -1
                r0.f3780a = r3     // Catch:{ all -> 0x0078 }
                if (r3 != 0) goto L_0x0076
                java.lang.Object r3 = r0.f3783a     // Catch:{ all -> 0x0078 }
                monitor-enter(r3)     // Catch:{ all -> 0x0078 }
                android.os.HandlerThread r4 = r0.f3782a     // Catch:{ all -> 0x0073 }
                r4.quit()     // Catch:{ all -> 0x0073 }
                r0.f3782a = r1     // Catch:{ all -> 0x0073 }
                r0.f3781a = r1     // Catch:{ all -> 0x0073 }
                monitor-exit(r3)     // Catch:{ all -> 0x0073 }
                goto L_0x0076
            L_0x0073:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0073 }
                throw r0     // Catch:{ all -> 0x0078 }
            L_0x0076:
                monitor-exit(r2)     // Catch:{ all -> 0x0078 }
                return
            L_0x0078:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0078 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.O3.d.run():void");
        }
    }

    public O3(Context context) {
        r1.U();
        if (R3.a == null) {
            R3.a = new R3();
        }
        this.f3729a = R3.a;
        CameraManager cameraManager = new CameraManager(context);
        this.f3731a = cameraManager;
        cameraManager.f3990a = this.f3732a;
        this.b = new Handler();
    }
}
