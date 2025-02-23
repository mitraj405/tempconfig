package defpackage;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import java.util.ArrayList;

/* renamed from: a2  reason: default package and case insensitive filesystem */
/* compiled from: AutoFocusManager */
public final class C0775a2 {
    public static final ArrayList a;

    /* renamed from: a  reason: collision with other field name */
    public final b f3893a;

    /* renamed from: a  reason: collision with other field name */
    public final Camera f3894a;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f3895a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3896a;
    public boolean b;
    public final boolean c;

    /* renamed from: a2$a */
    /* compiled from: AutoFocusManager */
    public class a implements Handler.Callback {
        public a() {
        }

        public final boolean handleMessage(Message message) {
            int i = message.what;
            C0775a2 a2Var = C0775a2.this;
            a2Var.getClass();
            if (i != 1) {
                return false;
            }
            if (a2Var.c && !a2Var.f3896a && !a2Var.b) {
                try {
                    a2Var.f3894a.autoFocus(a2Var.f3893a);
                    a2Var.b = true;
                } catch (RuntimeException unused) {
                    a2Var.a();
                }
            }
            return true;
        }
    }

    /* renamed from: a2$b */
    /* compiled from: AutoFocusManager */
    public class b implements Camera.AutoFocusCallback {
        public b() {
        }

        public final void onAutoFocus(boolean z, Camera camera) {
            C0775a2.this.f3895a.post(new C0088Dd(this, 8));
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        a = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public C0775a2(Camera camera, CameraSettings cameraSettings) {
        boolean z;
        a aVar = new a();
        b bVar = new b();
        this.f3893a = bVar;
        this.f3895a = new Handler(aVar);
        this.f3894a = camera;
        String focusMode = camera.getParameters().getFocusMode();
        if (!cameraSettings.f3997a || !a.contains(focusMode)) {
            z = false;
        } else {
            z = true;
        }
        this.c = z;
        this.f3896a = false;
        if (z && !this.b) {
            try {
                camera.autoFocus(bVar);
                this.b = true;
            } catch (RuntimeException unused) {
                a();
            }
        }
    }

    public final synchronized void a() {
        if (!this.f3896a && !this.f3895a.hasMessages(1)) {
            Handler handler = this.f3895a;
            handler.sendMessageDelayed(handler.obtainMessage(1), 2000);
        }
    }
}
