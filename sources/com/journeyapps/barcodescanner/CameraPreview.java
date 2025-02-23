package com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.camera.CameraSettings;
import defpackage.O3;
import java.util.ArrayList;
import java.util.Iterator;

public class CameraPreview extends ViewGroup {
    public static final /* synthetic */ int d = 0;
    public double a = 0.1d;

    /* renamed from: a  reason: collision with other field name */
    public O3 f3942a;

    /* renamed from: a  reason: collision with other field name */
    public Rect f3943a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f3944a;

    /* renamed from: a  reason: collision with other field name */
    public SurfaceView f3945a;

    /* renamed from: a  reason: collision with other field name */
    public TextureView f3946a;

    /* renamed from: a  reason: collision with other field name */
    public WindowManager f3947a;

    /* renamed from: a  reason: collision with other field name */
    public final a f3948a = new a();

    /* renamed from: a  reason: collision with other field name */
    public final b f3949a = new b();

    /* renamed from: a  reason: collision with other field name */
    public final c f3950a = new c();

    /* renamed from: a  reason: collision with other field name */
    public final d f3951a = new d();

    /* renamed from: a  reason: collision with other field name */
    public CameraSettings f3952a = new CameraSettings();

    /* renamed from: a  reason: collision with other field name */
    public C1095eu f3953a;

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList f3954a = new ArrayList();

    /* renamed from: a  reason: collision with other field name */
    public C1205jx f3955a;

    /* renamed from: a  reason: collision with other field name */
    public C1237l9 f3956a;

    /* renamed from: a  reason: collision with other field name */
    public C1333pq f3957a = null;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3958a = false;
    public Rect b = null;

    /* renamed from: b  reason: collision with other field name */
    public C1205jx f3959b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f3960b = false;
    public int c = -1;

    /* renamed from: c  reason: collision with other field name */
    public Rect f3961c = null;

    /* renamed from: c  reason: collision with other field name */
    public C1205jx f3962c;

    /* renamed from: c  reason: collision with other field name */
    public boolean f3963c = false;

    /* renamed from: d  reason: collision with other field name */
    public C1205jx f3964d = null;

    public class b implements Handler.Callback {
        public b() {
        }

        public final boolean handleMessage(Message message) {
            C1237l9 l9Var;
            int i = message.what;
            int i2 = R.id.zxing_prewiew_size_ready;
            boolean z = true;
            CameraPreview cameraPreview = CameraPreview.this;
            if (i == i2) {
                C1205jx jxVar = (C1205jx) message.obj;
                cameraPreview.f3959b = jxVar;
                C1205jx jxVar2 = cameraPreview.f3955a;
                if (jxVar2 != null) {
                    if (jxVar == null || (l9Var = cameraPreview.f3956a) == null) {
                        cameraPreview.f3961c = null;
                        cameraPreview.b = null;
                        cameraPreview.f3943a = null;
                        throw new IllegalStateException("containerSize or previewSize is not set yet");
                    }
                    Rect b = l9Var.f5584a.b(jxVar, l9Var.f5583a);
                    if (b.width() > 0 && b.height() > 0) {
                        cameraPreview.f3943a = b;
                        Rect rect = new Rect(0, 0, jxVar2.c, jxVar2.d);
                        Rect rect2 = cameraPreview.f3943a;
                        Rect rect3 = new Rect(rect);
                        rect3.intersect(rect2);
                        if (cameraPreview.f3964d != null) {
                            rect3.inset(Math.max(0, (rect3.width() - cameraPreview.f3964d.c) / 2), Math.max(0, (rect3.height() - cameraPreview.f3964d.d) / 2));
                        } else {
                            int min = (int) Math.min(((double) rect3.width()) * cameraPreview.a, ((double) rect3.height()) * cameraPreview.a);
                            rect3.inset(min, min);
                            if (rect3.height() > rect3.width()) {
                                rect3.inset(0, (rect3.height() - rect3.width()) / 2);
                            }
                        }
                        cameraPreview.b = rect3;
                        Rect rect4 = new Rect(cameraPreview.b);
                        Rect rect5 = cameraPreview.f3943a;
                        rect4.offset(-rect5.left, -rect5.top);
                        int i3 = rect4.left;
                        int i4 = jxVar.c;
                        int width = (i3 * i4) / cameraPreview.f3943a.width();
                        int i5 = rect4.top;
                        int i6 = jxVar.d;
                        Rect rect6 = new Rect(width, (i5 * i6) / cameraPreview.f3943a.height(), (rect4.right * i4) / cameraPreview.f3943a.width(), (rect4.bottom * i6) / cameraPreview.f3943a.height());
                        cameraPreview.f3961c = rect6;
                        if (rect6.width() <= 0 || cameraPreview.f3961c.height() <= 0) {
                            cameraPreview.f3961c = null;
                            cameraPreview.b = null;
                        } else {
                            cameraPreview.f3951a.b();
                        }
                    }
                    cameraPreview.requestLayout();
                    cameraPreview.h();
                }
                return true;
            }
            if (i == R.id.zxing_camera_error) {
                Exception exc = (Exception) message.obj;
                if (cameraPreview.f3942a == null) {
                    z = false;
                }
                if (z) {
                    cameraPreview.d();
                    cameraPreview.f3951a.e(exc);
                }
            } else if (i == R.id.zxing_camera_closed) {
                cameraPreview.f3951a.d();
            }
            return false;
        }
    }

    public class c implements C1056cu {
        public c() {
        }
    }

    public class d implements e {
        public d() {
        }

        public final void a() {
            Iterator it = CameraPreview.this.f3954a.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a();
            }
        }

        public final void b() {
            Iterator it = CameraPreview.this.f3954a.iterator();
            while (it.hasNext()) {
                ((e) it.next()).b();
            }
        }

        public final void c() {
            Iterator it = CameraPreview.this.f3954a.iterator();
            while (it.hasNext()) {
                ((e) it.next()).c();
            }
        }

        public final void d() {
            Iterator it = CameraPreview.this.f3954a.iterator();
            while (it.hasNext()) {
                ((e) it.next()).d();
            }
        }

        public final void e(Exception exc) {
            Iterator it = CameraPreview.this.f3954a.iterator();
            while (it.hasNext()) {
                ((e) it.next()).e(exc);
            }
        }
    }

    public interface e {
        void a();

        void b();

        void c();

        void d();

        void e(Exception exc);
    }

    public CameraPreview(Context context) {
        super(context);
        b(context, (AttributeSet) null);
    }

    public static void a(CameraPreview cameraPreview) {
        boolean z;
        if (cameraPreview.f3942a != null) {
            z = true;
        } else {
            z = false;
        }
        if (z && cameraPreview.getDisplayRotation() != cameraPreview.c) {
            cameraPreview.d();
            cameraPreview.f();
        }
    }

    private int getDisplayRotation() {
        return this.f3947a.getDefaultDisplay().getRotation();
    }

    public final void b(Context context, AttributeSet attributeSet) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        c(attributeSet);
        this.f3947a = (WindowManager) context.getSystemService("window");
        this.f3944a = new Handler(this.f3949a);
        this.f3953a = new C1095eu();
    }

    public final void c(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_camera_preview);
        int dimension = (int) obtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.f3964d = new C1205jx(dimension, dimension2);
        }
        this.f3958a = obtainStyledAttributes.getBoolean(R.styleable.zxing_camera_preview_zxing_use_texture_view, true);
        int integer = obtainStyledAttributes.getInteger(R.styleable.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
        if (integer == 1) {
            this.f3957a = new L4();
        } else if (integer == 2) {
            this.f3957a = new C0472Cc();
        } else if (integer == 3) {
            this.f3957a = new C0496Ec();
        }
        obtainStyledAttributes.recycle();
    }

    public void d() {
        TextureView textureView;
        SurfaceView surfaceView;
        r1.U();
        this.c = -1;
        O3 o3 = this.f3942a;
        if (o3 != null) {
            r1.U();
            if (o3.f3734a) {
                o3.f3729a.b(o3.f3727a);
            } else {
                o3.f3735b = true;
            }
            o3.f3734a = false;
            this.f3942a = null;
            this.f3960b = false;
        } else {
            this.f3944a.sendEmptyMessage(R.id.zxing_camera_closed);
        }
        if (this.f3962c == null && (surfaceView = this.f3945a) != null) {
            surfaceView.getHolder().removeCallback(this.f3948a);
        }
        if (this.f3962c == null && (textureView = this.f3946a) != null) {
            textureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
        }
        this.f3955a = null;
        this.f3959b = null;
        this.f3961c = null;
        C1095eu euVar = this.f3953a;
        C1077du duVar = euVar.f5456a;
        if (duVar != null) {
            duVar.disable();
        }
        euVar.f5456a = null;
        euVar.f5454a = null;
        euVar.f5455a = null;
        this.f3951a.a();
    }

    public final void f() {
        r1.U();
        if (this.f3942a == null) {
            O3 o3 = new O3(getContext());
            CameraSettings cameraSettings = this.f3952a;
            if (!o3.f3734a) {
                o3.f3732a = cameraSettings;
                o3.f3731a.f3990a = cameraSettings;
            }
            this.f3942a = o3;
            o3.f3730a = this.f3944a;
            r1.U();
            o3.f3734a = true;
            o3.f3735b = false;
            R3 r3 = o3.f3729a;
            O3.a aVar = o3.f3724a;
            synchronized (r3.f3783a) {
                r3.f3780a++;
                r3.b(aVar);
            }
            this.c = getDisplayRotation();
        }
        if (this.f3962c != null) {
            h();
        } else {
            SurfaceView surfaceView = this.f3945a;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.f3948a);
            } else {
                TextureView textureView = this.f3946a;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        this.f3946a.getSurfaceTexture();
                        this.f3962c = new C1205jx(this.f3946a.getWidth(), this.f3946a.getHeight());
                        h();
                    } else {
                        this.f3946a.setSurfaceTextureListener(new P3(this));
                    }
                }
            }
        }
        requestLayout();
        C1095eu euVar = this.f3953a;
        Context context = getContext();
        c cVar = this.f3950a;
        C1077du duVar = euVar.f5456a;
        if (duVar != null) {
            duVar.disable();
        }
        euVar.f5456a = null;
        euVar.f5454a = null;
        euVar.f5455a = null;
        Context applicationContext = context.getApplicationContext();
        euVar.f5455a = cVar;
        euVar.f5454a = (WindowManager) applicationContext.getSystemService("window");
        C1077du duVar2 = new C1077du(euVar, applicationContext);
        euVar.f5456a = duVar2;
        duVar2.enable();
        euVar.a = euVar.f5454a.getDefaultDisplay().getRotation();
    }

    public final void g(Q3 q3) {
        O3 o3;
        if (!this.f3960b && (o3 = this.f3942a) != null) {
            o3.f3728a = q3;
            r1.U();
            if (o3.f3734a) {
                o3.f3729a.b(o3.f3726a);
                this.f3960b = true;
                e();
                this.f3951a.c();
                return;
            }
            throw new IllegalStateException("CameraInstance is not open");
        }
    }

    public O3 getCameraInstance() {
        return this.f3942a;
    }

    public CameraSettings getCameraSettings() {
        return this.f3952a;
    }

    public Rect getFramingRect() {
        return this.b;
    }

    public C1205jx getFramingRectSize() {
        return this.f3964d;
    }

    public double getMarginFraction() {
        return this.a;
    }

    public Rect getPreviewFramingRect() {
        return this.f3961c;
    }

    public C1333pq getPreviewScalingStrategy() {
        C1333pq pqVar = this.f3957a;
        if (pqVar != null) {
            return pqVar;
        }
        if (this.f3946a != null) {
            return new L4();
        }
        return new C0472Cc();
    }

    public C1205jx getPreviewSize() {
        return this.f3959b;
    }

    public final void h() {
        Rect rect;
        float f;
        C1205jx jxVar = this.f3962c;
        if (jxVar != null && this.f3959b != null && (rect = this.f3943a) != null) {
            if (this.f3945a == null || !jxVar.equals(new C1205jx(rect.width(), this.f3943a.height()))) {
                TextureView textureView = this.f3946a;
                if (textureView != null && textureView.getSurfaceTexture() != null) {
                    if (this.f3959b != null) {
                        int width = this.f3946a.getWidth();
                        int height = this.f3946a.getHeight();
                        C1205jx jxVar2 = this.f3959b;
                        float f2 = (float) height;
                        float f3 = ((float) width) / f2;
                        float f4 = ((float) jxVar2.c) / ((float) jxVar2.d);
                        float f5 = 1.0f;
                        if (f3 < f4) {
                            float f6 = f4 / f3;
                            f = 1.0f;
                            f5 = f6;
                        } else {
                            f = f3 / f4;
                        }
                        Matrix matrix = new Matrix();
                        matrix.setScale(f5, f);
                        float f7 = (float) width;
                        matrix.postTranslate((f7 - (f5 * f7)) / 2.0f, (f2 - (f * f2)) / 2.0f);
                        this.f3946a.setTransform(matrix);
                    }
                    g(new Q3(this.f3946a.getSurfaceTexture()));
                    return;
                }
                return;
            }
            g(new Q3(this.f3945a.getHolder()));
        }
    }

    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3958a) {
            TextureView textureView = new TextureView(getContext());
            this.f3946a = textureView;
            textureView.setSurfaceTextureListener(new P3(this));
            addView(this.f3946a);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.f3945a = surfaceView;
        surfaceView.getHolder().addCallback(this.f3948a);
        addView(this.f3945a);
    }

    @SuppressLint({"DrawAllocation"})
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C1205jx jxVar = new C1205jx(i3 - i, i4 - i2);
        this.f3955a = jxVar;
        O3 o3 = this.f3942a;
        if (o3 != null && o3.f3733a == null) {
            C1237l9 l9Var = new C1237l9(getDisplayRotation(), jxVar);
            this.f3956a = l9Var;
            l9Var.f5584a = getPreviewScalingStrategy();
            O3 o32 = this.f3942a;
            C1237l9 l9Var2 = this.f3956a;
            o32.f3733a = l9Var2;
            o32.f3731a.f3993a = l9Var2;
            r1.U();
            if (o32.f3734a) {
                o32.f3729a.b(o32.f3725a);
                boolean z2 = this.f3963c;
                if (z2) {
                    O3 o33 = this.f3942a;
                    o33.getClass();
                    r1.U();
                    if (o33.f3734a) {
                        o33.f3729a.b(new C0602N3(o33, z2));
                    }
                }
            } else {
                throw new IllegalStateException("CameraInstance is not open");
            }
        }
        SurfaceView surfaceView = this.f3945a;
        if (surfaceView != null) {
            Rect rect = this.f3943a;
            if (rect == null) {
                surfaceView.layout(0, 0, getWidth(), getHeight());
            } else {
                surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
        } else {
            TextureView textureView = this.f3946a;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
            }
        }
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    public final Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putBoolean("torch", this.f3963c);
        return bundle;
    }

    public void setCameraSettings(CameraSettings cameraSettings) {
        this.f3952a = cameraSettings;
    }

    public void setFramingRectSize(C1205jx jxVar) {
        this.f3964d = jxVar;
    }

    public void setMarginFraction(double d2) {
        if (d2 < 0.5d) {
            this.a = d2;
            return;
        }
        throw new IllegalArgumentException("The margin fraction must be less than 0.5");
    }

    public void setPreviewScalingStrategy(C1333pq pqVar) {
        this.f3957a = pqVar;
    }

    public void setTorch(boolean z) {
        this.f3963c = z;
        O3 o3 = this.f3942a;
        if (o3 != null) {
            r1.U();
            if (o3.f3734a) {
                o3.f3729a.b(new C0602N3(o3, z));
            }
        }
    }

    public void setUseTextureView(boolean z) {
        this.f3958a = z;
    }

    public CameraPreview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public void e() {
    }

    public class a implements SurfaceHolder.Callback {
        public a() {
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder == null) {
                int i4 = CameraPreview.d;
                return;
            }
            C1205jx jxVar = new C1205jx(i2, i3);
            CameraPreview cameraPreview = CameraPreview.this;
            cameraPreview.f3962c = jxVar;
            cameraPreview.h();
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            CameraPreview.this.f3962c = null;
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        }
    }

    public CameraPreview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b(context, attributeSet);
    }
}
