package com.journeyapps.barcodescanner.camera;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import com.google.zxing.client.android.AmbientLightManager;
import com.google.zxing.client.android.R;
import com.google.zxing.client.android.camera.open.OpenCameraInterface;
import defpackage.C1236l8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public final class CameraManager {
    public int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public C0775a2 f3984a;

    /* renamed from: a  reason: collision with other field name */
    public final Context f3985a;

    /* renamed from: a  reason: collision with other field name */
    public Camera.CameraInfo f3986a;

    /* renamed from: a  reason: collision with other field name */
    public Camera f3987a;

    /* renamed from: a  reason: collision with other field name */
    public AmbientLightManager f3988a;

    /* renamed from: a  reason: collision with other field name */
    public final a f3989a;

    /* renamed from: a  reason: collision with other field name */
    public CameraSettings f3990a = new CameraSettings();

    /* renamed from: a  reason: collision with other field name */
    public String f3991a;

    /* renamed from: a  reason: collision with other field name */
    public C1205jx f3992a;

    /* renamed from: a  reason: collision with other field name */
    public C1237l9 f3993a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3994a;
    public C1205jx b;

    public final class a implements Camera.PreviewCallback {

        /* renamed from: a  reason: collision with other field name */
        public C1205jx f3995a;

        /* renamed from: a  reason: collision with other field name */
        public C1287nq f3996a;

        public a() {
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            C1205jx jxVar = this.f3995a;
            C1287nq nqVar = this.f3996a;
            if (jxVar == null || nqVar == null) {
                if (nqVar != null) {
                    new Exception("No resolution available");
                    C1236l8.b bVar = (C1236l8.b) nqVar;
                    synchronized (C1236l8.this.f5579a) {
                        C1236l8 l8Var = C1236l8.this;
                        if (l8Var.f5582a) {
                            l8Var.f5576a.obtainMessage(R.id.zxing_preview_failed).sendToTarget();
                        }
                    }
                }
            } else if (bArr != null) {
                try {
                    byte[] bArr2 = bArr;
                    C0466Bx bx = new C0466Bx(bArr2, jxVar.c, jxVar.d, camera.getParameters().getPreviewFormat(), CameraManager.this.a);
                    if (CameraManager.this.f3986a.facing == 1) {
                        bx.f3538a = true;
                    }
                    C1236l8.b bVar2 = (C1236l8.b) nqVar;
                    synchronized (C1236l8.this.f5579a) {
                        C1236l8 l8Var2 = C1236l8.this;
                        if (l8Var2.f5582a) {
                            l8Var2.f5576a.obtainMessage(R.id.zxing_decode, bx).sendToTarget();
                        }
                    }
                } catch (RuntimeException unused) {
                    C1236l8.b bVar3 = (C1236l8.b) nqVar;
                    synchronized (C1236l8.this.f5579a) {
                        C1236l8 l8Var3 = C1236l8.this;
                        if (l8Var3.f5582a) {
                            l8Var3.f5576a.obtainMessage(R.id.zxing_preview_failed).sendToTarget();
                        }
                    }
                }
            } else {
                throw new NullPointerException("No preview data received");
            }
        }
    }

    public CameraManager(Context context) {
        this.f3985a = context;
        this.f3989a = new a();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(16:2|3|4|(12:(2:7|(2:9|(1:11)(1:12))(1:13))(1:14)|16|(1:18)(1:19)|20|21|22|23|24|25|(1:28)(1:29)|30|31)|15|16|(0)(0)|20|21|22|23|24|25|(0)(0)|30|31) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x003b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x003f */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0025 A[Catch:{ Exception -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x002f A[Catch:{ Exception -> 0x003b }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r6 = this;
            android.hardware.Camera r0 = r6.f3987a
            if (r0 == 0) goto L_0x0065
            r1 = 0
            r2 = 1
            l9 r3 = r6.f3993a     // Catch:{ Exception -> 0x003b }
            int r3 = r3.a     // Catch:{ Exception -> 0x003b }
            if (r3 == 0) goto L_0x001e
            if (r3 == r2) goto L_0x001b
            r4 = 2
            if (r3 == r4) goto L_0x0018
            r4 = 3
            if (r3 == r4) goto L_0x0015
            goto L_0x001e
        L_0x0015:
            r3 = 270(0x10e, float:3.78E-43)
            goto L_0x001f
        L_0x0018:
            r3 = 180(0xb4, float:2.52E-43)
            goto L_0x001f
        L_0x001b:
            r3 = 90
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            android.hardware.Camera$CameraInfo r4 = r6.f3986a     // Catch:{ Exception -> 0x003b }
            int r5 = r4.facing     // Catch:{ Exception -> 0x003b }
            if (r5 != r2) goto L_0x002f
            int r4 = r4.orientation     // Catch:{ Exception -> 0x003b }
            int r4 = r4 + r3
            int r4 = r4 % 360
            int r3 = 360 - r4
            int r3 = r3 % 360
            goto L_0x0036
        L_0x002f:
            int r4 = r4.orientation     // Catch:{ Exception -> 0x003b }
            int r4 = r4 - r3
            int r4 = r4 + 360
            int r3 = r4 % 360
        L_0x0036:
            r6.a = r3     // Catch:{ Exception -> 0x003b }
            r0.setDisplayOrientation(r3)     // Catch:{ Exception -> 0x003b }
        L_0x003b:
            r6.c(r1)     // Catch:{ Exception -> 0x003f }
            goto L_0x0042
        L_0x003f:
            r6.c(r2)     // Catch:{ Exception -> 0x0042 }
        L_0x0042:
            android.hardware.Camera r0 = r6.f3987a
            android.hardware.Camera$Parameters r0 = r0.getParameters()
            android.hardware.Camera$Size r0 = r0.getPreviewSize()
            if (r0 != 0) goto L_0x0053
            jx r0 = r6.f3992a
            r6.b = r0
            goto L_0x005e
        L_0x0053:
            jx r1 = new jx
            int r2 = r0.width
            int r0 = r0.height
            r1.<init>(r2, r0)
            r6.b = r1
        L_0x005e:
            jx r0 = r6.b
            com.journeyapps.barcodescanner.camera.CameraManager$a r1 = r6.f3989a
            r1.f3995a = r0
            return
        L_0x0065:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Camera not open"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.journeyapps.barcodescanner.camera.CameraManager.a():void");
    }

    public final void b() {
        Camera open = OpenCameraInterface.open(this.f3990a.a);
        this.f3987a = open;
        if (open != null) {
            int cameraId = OpenCameraInterface.getCameraId(this.f3990a.a);
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            this.f3986a = cameraInfo;
            Camera.getCameraInfo(cameraId, cameraInfo);
            return;
        }
        throw new RuntimeException("Failed to open camera");
    }

    public final void c(boolean z) {
        String str;
        boolean z2;
        Camera.Parameters parameters = this.f3987a.getParameters();
        String str2 = this.f3991a;
        if (str2 == null) {
            this.f3991a = parameters.flatten();
        } else {
            parameters.unflatten(str2);
        }
        if (parameters != null) {
            parameters.flatten();
            int i = this.f3990a.b;
            int i2 = M3.a;
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            int[] iArr = null;
            if (z || i == 1) {
                str = M3.a(supportedFocusModes, "auto");
            } else if (i == 2) {
                str = M3.a(supportedFocusModes, "continuous-picture", "continuous-video", "auto");
            } else if (i == 3) {
                str = M3.a(supportedFocusModes, "infinity");
            } else if (i == 4) {
                str = M3.a(supportedFocusModes, "macro");
            } else {
                str = null;
            }
            if (!z && str == null) {
                str = M3.a(supportedFocusModes, "macro", "edof");
            }
            if (str != null && !str.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(str);
            }
            if (!z) {
                M3.b(parameters, false);
                this.f3990a.getClass();
                this.f3990a.getClass();
                this.f3990a.getClass();
            }
            List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            ArrayList arrayList = new ArrayList();
            if (supportedPreviewSizes == null) {
                Camera.Size previewSize = parameters.getPreviewSize();
                if (previewSize != null) {
                    arrayList.add(new C1205jx(previewSize.width, previewSize.height));
                }
            } else {
                for (Camera.Size next : supportedPreviewSizes) {
                    arrayList.add(new C1205jx(next.width, next.height));
                }
            }
            if (arrayList.size() == 0) {
                this.f3992a = null;
            } else {
                C1237l9 l9Var = this.f3993a;
                int i3 = this.a;
                if (i3 != -1) {
                    if (i3 % 180 != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    C1205jx jxVar = l9Var.f5583a;
                    if (jxVar == null) {
                        jxVar = null;
                    } else if (z2) {
                        jxVar = new C1205jx(jxVar.d, jxVar.c);
                    }
                    C1333pq pqVar = l9Var.f5584a;
                    pqVar.getClass();
                    if (jxVar != null) {
                        Collections.sort(arrayList, new C1308oq(pqVar, jxVar));
                    }
                    Objects.toString(jxVar);
                    Objects.toString(arrayList);
                    C1205jx jxVar2 = (C1205jx) arrayList.get(0);
                    this.f3992a = jxVar2;
                    parameters.setPreviewSize(jxVar2.c, jxVar2.d);
                } else {
                    throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
                }
            }
            if (Build.DEVICE.equals("glass-1")) {
                List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
                    Iterator<int[]> it = supportedPreviewFpsRange.iterator();
                    while (it.hasNext()) {
                        Arrays.toString(it.next());
                        it.hasNext();
                    }
                }
                if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
                    Iterator<int[]> it2 = supportedPreviewFpsRange.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        int[] next2 = it2.next();
                        int i4 = next2[0];
                        int i5 = next2[1];
                        if (i4 >= 10000 && i5 <= 20000) {
                            iArr = next2;
                            break;
                        }
                    }
                    if (iArr != null) {
                        int[] iArr2 = new int[2];
                        parameters.getPreviewFpsRange(iArr2);
                        if (Arrays.equals(iArr2, iArr)) {
                            Arrays.toString(iArr);
                        } else {
                            Arrays.toString(iArr);
                            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
                        }
                    }
                }
            }
            parameters.flatten();
            this.f3987a.setParameters(parameters);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:14|(2:16|(2:18|19))|20|21|(2:23|(1:38)(5:27|28|29|30|32))(1:36)) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0068 */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054 A[Catch:{ RuntimeException -> 0x006b }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(boolean r5) {
        /*
            r4 = this;
            android.hardware.Camera r0 = r4.f3987a
            if (r0 == 0) goto L_0x006b
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ RuntimeException -> 0x006b }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0024
            java.lang.String r0 = r0.getFlashMode()     // Catch:{ RuntimeException -> 0x006b }
            if (r0 == 0) goto L_0x0024
            java.lang.String r3 = "on"
            boolean r3 = r3.equals(r0)     // Catch:{ RuntimeException -> 0x006b }
            if (r3 != 0) goto L_0x0022
            java.lang.String r3 = "torch"
            boolean r0 = r3.equals(r0)     // Catch:{ RuntimeException -> 0x006b }
            if (r0 == 0) goto L_0x0024
        L_0x0022:
            r0 = r1
            goto L_0x0025
        L_0x0024:
            r0 = r2
        L_0x0025:
            if (r5 == r0) goto L_0x006b
            a2 r0 = r4.f3984a     // Catch:{ RuntimeException -> 0x006b }
            if (r0 == 0) goto L_0x003d
            r0.f3896a = r1     // Catch:{ RuntimeException -> 0x006b }
            r0.b = r2     // Catch:{ RuntimeException -> 0x006b }
            android.os.Handler r3 = r0.f3895a     // Catch:{ RuntimeException -> 0x006b }
            r3.removeMessages(r1)     // Catch:{ RuntimeException -> 0x006b }
            boolean r3 = r0.c     // Catch:{ RuntimeException -> 0x006b }
            if (r3 == 0) goto L_0x003d
            android.hardware.Camera r0 = r0.f3894a     // Catch:{ RuntimeException -> 0x003d }
            r0.cancelAutoFocus()     // Catch:{ RuntimeException -> 0x003d }
        L_0x003d:
            android.hardware.Camera r0 = r4.f3987a     // Catch:{ RuntimeException -> 0x006b }
            android.hardware.Camera$Parameters r0 = r0.getParameters()     // Catch:{ RuntimeException -> 0x006b }
            defpackage.M3.b(r0, r5)     // Catch:{ RuntimeException -> 0x006b }
            com.journeyapps.barcodescanner.camera.CameraSettings r5 = r4.f3990a     // Catch:{ RuntimeException -> 0x006b }
            r5.getClass()     // Catch:{ RuntimeException -> 0x006b }
            android.hardware.Camera r5 = r4.f3987a     // Catch:{ RuntimeException -> 0x006b }
            r5.setParameters(r0)     // Catch:{ RuntimeException -> 0x006b }
            a2 r5 = r4.f3984a     // Catch:{ RuntimeException -> 0x006b }
            if (r5 == 0) goto L_0x006b
            r5.f3896a = r2     // Catch:{ RuntimeException -> 0x006b }
            boolean r0 = r5.c     // Catch:{ RuntimeException -> 0x006b }
            if (r0 == 0) goto L_0x006b
            boolean r0 = r5.b     // Catch:{ RuntimeException -> 0x006b }
            if (r0 != 0) goto L_0x006b
            android.hardware.Camera r0 = r5.f3894a     // Catch:{ RuntimeException -> 0x0068 }
            a2$b r2 = r5.f3893a     // Catch:{ RuntimeException -> 0x0068 }
            r0.autoFocus(r2)     // Catch:{ RuntimeException -> 0x0068 }
            r5.b = r1     // Catch:{ RuntimeException -> 0x0068 }
            goto L_0x006b
        L_0x0068:
            r5.a()     // Catch:{ RuntimeException -> 0x006b }
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.journeyapps.barcodescanner.camera.CameraManager.d(boolean):void");
    }

    public final void e() {
        Camera camera = this.f3987a;
        if (camera != null && !this.f3994a) {
            camera.startPreview();
            this.f3994a = true;
            this.f3984a = new C0775a2(this.f3987a, this.f3990a);
            AmbientLightManager ambientLightManager = new AmbientLightManager(this.f3985a, this, this.f3990a);
            this.f3988a = ambientLightManager;
            ambientLightManager.start();
        }
    }
}
