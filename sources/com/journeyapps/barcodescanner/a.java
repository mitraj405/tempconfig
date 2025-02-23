package com.journeyapps.barcodescanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Handler;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.BeepManager;
import com.google.zxing.client.android.InactivityTimer;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.CameraPreview;
import java.util.List;

/* compiled from: CaptureManager */
public final class a {
    public static final /* synthetic */ int b = 0;
    public int a = -1;

    /* renamed from: a  reason: collision with other field name */
    public final Activity f3975a;

    /* renamed from: a  reason: collision with other field name */
    public final Handler f3976a;

    /* renamed from: a  reason: collision with other field name */
    public final BeepManager f3977a;

    /* renamed from: a  reason: collision with other field name */
    public final InactivityTimer f3978a;

    /* renamed from: a  reason: collision with other field name */
    public final DecoratedBarcodeView f3979a;

    /* renamed from: a  reason: collision with other field name */
    public final C0051a f3980a = new C0051a();

    /* renamed from: a  reason: collision with other field name */
    public String f3981a = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f3982a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f3983b = true;
    public boolean c = false;
    public boolean d = false;
    public boolean e;

    public a(Activity activity, DecoratedBarcodeView decoratedBarcodeView) {
        b bVar = new b();
        this.e = false;
        this.f3975a = activity;
        this.f3979a = decoratedBarcodeView;
        decoratedBarcodeView.getBarcodeView().f3954a.add(bVar);
        this.f3976a = new Handler();
        this.f3978a = new InactivityTimer(activity, new C0088Dd(this, 7));
        this.f3977a = new BeepManager(activity);
    }

    public final void a() {
        boolean z;
        DecoratedBarcodeView decoratedBarcodeView = this.f3979a;
        O3 o3 = decoratedBarcodeView.getBarcodeView().f3942a;
        if (o3 == null || o3.f3735b) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.f3975a.finish();
        } else {
            this.d = true;
        }
        decoratedBarcodeView.f3966a.d();
        this.f3978a.cancel();
    }

    public final void b(String str) {
        Activity activity = this.f3975a;
        if (!activity.isFinishing() && !this.c && !this.d) {
            if (str.isEmpty()) {
                str = activity.getString(R.string.zxing_msg_camera_framework_bug);
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle(activity.getString(R.string.zxing_app_name));
            builder.setMessage(str);
            builder.setPositiveButton(R.string.zxing_button_ok, new G4(this));
            builder.setOnCancelListener(new H4(this));
            builder.show();
        }
    }

    /* compiled from: CaptureManager */
    public class b implements CameraPreview.e {
        public b() {
        }

        public final void d() {
            a aVar = a.this;
            if (aVar.d) {
                int i = a.b;
                aVar.f3975a.finish();
            }
        }

        public final void e(Exception exc) {
            a aVar = a.this;
            aVar.b(aVar.f3975a.getString(R.string.zxing_msg_camera_framework_bug));
        }

        public final void a() {
        }

        public final void b() {
        }

        public final void c() {
        }
    }

    /* renamed from: com.journeyapps.barcodescanner.a$a  reason: collision with other inner class name */
    /* compiled from: CaptureManager */
    public class C0051a implements C1251m2 {
        public C0051a() {
        }

        public final void a(C1272n2 n2Var) {
            a aVar = a.this;
            aVar.f3979a.f3966a.d();
            aVar.f3977a.playBeepSoundAndVibrate();
            aVar.f3976a.post(new A1(5, this, n2Var));
        }

        public final void b(List<ResultPoint> list) {
        }
    }
}
